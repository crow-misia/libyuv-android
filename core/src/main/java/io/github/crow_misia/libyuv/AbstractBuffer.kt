package io.github.crow_misia.libyuv

import java.io.ByteArrayOutputStream
import java.lang.UnsupportedOperationException
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

    override fun asBuffer() = buffer ?: run {
        throw UnsupportedOperationException("Cannot operate it because it is converted from multi plane.")
    }

    override fun asByteArray(): ByteArray {
        val capacity = planes.sumOf { it.buffer.capacity() }
        val buffer = ByteArray(capacity)

        asByteArray(buffer)

        return buffer
    }

    override fun asByteArray(dst: ByteArray) {
        var offset = 0
        planes.forEach { plane ->
            val size = plane.buffer.capacity()
            Yuv.memcopy(dst, offset, plane.buffer, size)
            offset += size
        }
    }

    override fun write(stream: ByteArrayOutputStream) {
        planes.forEach {
            stream.write(it.buffer.asByteArray())
        }
    }

    override fun write(buffer: ByteBuffer) {
        planes.forEach {
            buffer.put(it.buffer)
        }
    }
}
