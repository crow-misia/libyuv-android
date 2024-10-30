package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.io.OutputStream
import java.nio.ByteBuffer
import java.util.concurrent.atomic.AtomicReference

abstract class AbstractBuffer(
    internal var buffer: ByteBuffer?,
    cropRect: Rect,
    planes: Array<Plane>,
    releaseCallback: Runnable?,
) : Buffer {
    override var planes: Array<Plane> = planes
        internal set

    override var cropRect: Rect = cropRect
        set(value) {
            val tmp = Rect(value)
            if (!tmp.intersect(0, 0, width, height)) {
                tmp.setEmpty()
            }
            field = tmp
        }

    private val releaseCallback = AtomicReference(releaseCallback)

    override fun close() {
        buffer = null
        releaseCallback.getAndSet(null)?.run()
        planes = emptyArray()
    }

    override fun asBuffer(): ByteBuffer {
        val result = buffer ?: run {
            val size = planes.sumOf { it.bufferSize }
            val buffer = ByteBuffer.allocateDirect(size).also {
                buffer = it
            }
            return buffer
        }
        result.rewind()
        return result
    }

    override fun asByteArray(): ByteArray {
        val size = planes.sumOf { it.bufferSize }
        val buffer = ByteArray(size)

        asByteArray(buffer)

        return buffer
    }

    override fun asByteArray(dst: ByteArray): Int {
        var dstOffset = 0
        planes.forEach { plane ->
            val remain = dst.size - dstOffset
            val size = minOf(plane.bufferSize, remain)
            Yuv.memcopy(dst, dstOffset, plane.buffer, 0, size)
            dstOffset += size
        }
        return dstOffset
    }

    override fun write(dst: OutputStream): Int {
        val tmpBufferSize = planes.maxOf { it.bufferSize }
        val tmpBuffer = ByteArray(tmpBufferSize)
        var ret = 0
        planes.forEach { plane ->
            val size = plane.bufferSize
            Yuv.memcopy(tmpBuffer, 0, plane.buffer, 0, size)
            dst.write(tmpBuffer, 0, size)
            ret += size
        }
        return ret
    }

    override fun write(dst: ByteBuffer) {
        var dstOffset = 0
        planes.forEach { plane ->
            val remain = dst.capacity() - dstOffset
            val size = minOf(plane.bufferSize, remain)
            Yuv.memcopy(dst, dstOffset, plane.buffer, 0, size)
            dstOffset += plane.bufferSize
        }
    }
}
