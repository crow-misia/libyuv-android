package io.github.crow_misia.libyuv

import java.io.OutputStream
import java.nio.ByteBuffer
import java.util.concurrent.atomic.AtomicReference

abstract class AbstractBuffer(
    internal var buffer: ByteBuffer?,
    override val crop: Rect,
    planes: Array<Plane>,
    releaseCallback: Runnable?,
) : Buffer {
    override var planes: Array<Plane> = planes
        internal set

    private val releaseCallback = AtomicReference(releaseCallback)

    override fun close() {
        buffer = null
        releaseCallback.getAndSet(null)?.run()
        planes = emptyArray()
    }

    override fun asBuffer() = buffer?.also { it.position(0) } ?: run {
        val size = planes.sumOf { it.buffer.limit() }
        val buffer = ByteBuffer.allocateDirect(size).also {
            buffer = it
        }
        write(buffer)
        return buffer
    }

    override fun asByteArray(): ByteArray {
        val size = planes.sumOf { it.buffer.limit() }
        val buffer = ByteArray(size)

        asByteArray(buffer)

        return buffer
    }

    override fun asByteArray(dst: ByteArray): Int {
        var offset = 0
        planes.forEach { plane ->
            val buffer = plane.buffer
            val remain = dst.size - offset
            val size = minOf(buffer.limit(), remain)
            buffer.copy(dst, offset, 0, size)
            offset += size
        }
        return offset
    }

    override fun write(dst: OutputStream): Int {
        val tmpBufferSize = planes.maxOf { it.buffer.limit() }
        val tmpBuffer = ByteArray(tmpBufferSize)
        var ret = 0
        planes.forEach {
            val size = it.buffer.limit()
            it.buffer.copy(tmpBuffer, 0, 0, size)
            dst.write(tmpBuffer, 0, size)
            ret += size
        }
        return ret
    }

    override fun write(dst: ByteBuffer) {
        planes.forEach { plane ->
            plane.buffer.also {
                it.position(0)
                dst.put(it)
            }
        }
    }
}
