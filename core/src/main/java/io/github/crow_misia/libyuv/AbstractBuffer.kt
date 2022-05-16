package io.github.crow_misia.libyuv

import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.nio.ByteBuffer
import java.util.concurrent.atomic.AtomicReference

abstract class AbstractBuffer(
    internal var buffer: ByteBuffer?,
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
        throw UnsupportedOperationException("Cannot operate it because it is converted from multi plane.")
    }

    override fun asByteArray(): ByteArray {
        val size = planes.sumOf {
            it.buffer.position(0)
            it.buffer.limit()
        }
        val buffer = ByteArray(size)

        asByteArray(buffer)

        return buffer
    }

    override fun asByteArray(dst: ByteArray): Int {
        var offset = 0
        planes.forEach { plane ->
            val buffer = plane.buffer
            val remain = dst.size - offset
            buffer.position(0)
            val size = minOf(buffer.remaining(), remain)
            buffer.get(dst, offset, size)
            offset += size
        }
        return offset
    }

    override fun write(dst: OutputStream): Int {
        var ret = 0
        planes.forEach {
            val data = it.buffer.asByteArray()
            dst.write(data)
            ret += data.size
        }
        return ret
    }

    override fun write(dst: ByteBuffer) {
        planes.forEach {
            dst.put(it.buffer)
        }
    }
}
