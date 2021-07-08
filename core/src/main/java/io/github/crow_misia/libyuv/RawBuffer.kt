package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import java.nio.ByteBuffer

/**
 * RGB big endian (rgb in memory)
 */
class RawBuffer private constructor(
    internal val buffer: ByteBuffer,
    internal val strideRAW: Int,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?,
) : AbstractBuffer(releaseCallback) {
    override fun asBuffer() = buffer
    override fun asByteArray() = buffer.asByteArray()
    override fun asByteArray(dst: ByteArray) = buffer.asByteArray(dst)
    override fun asBitmap(): Bitmap {
        return ArgbBuffer.allocate(width, height).use {
            convertTo(it)
            it.asBitmap()
        }
    }

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width * 3
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): RawBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return RawBuffer(buffer, stride, width, height) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): RawBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            return RawBuffer(buffer.sliceRange(0, capacity), stride, width, height, releaseCallback)
        }
    }
}