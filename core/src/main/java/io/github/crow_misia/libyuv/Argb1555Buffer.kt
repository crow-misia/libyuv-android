package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import java.nio.ByteBuffer

/**
 * RGB15 (RGBO fourcc) little endian
 */
class Argb1555Buffer private constructor(
    internal val buffer: ByteBuffer,
    internal val strideARGB1555: Int,
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
            val stride = width.shl(1)
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): Argb1555Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return Argb1555Buffer(buffer, stride, width, height) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): Argb1555Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            return Argb1555Buffer(buffer.sliceRange(0, capacity), stride, width, height, releaseCallback)
        }
    }
}