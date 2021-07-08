package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import java.nio.ByteBuffer

/**
 * ARGB little endian (bgra in memory)
 */
class ArgbBuffer private constructor(
    internal val buffer: ByteBuffer,
    internal val strideARGB: Int,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?,
) : AbstractBuffer(releaseCallback) {
    override fun asBuffer() = buffer
    override fun asByteArray() = buffer.asByteArray()
    override fun asByteArray(dst: ByteArray) = buffer.asByteArray(dst)
    override fun asBitmap(): Bitmap {
        return AbgrBuffer.allocate(width, height).use {
            convertTo(it)
            it.asBitmap()
        }
    }

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width.shl(2)
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): ArgbBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return ArgbBuffer(buffer, stride, width, height) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): ArgbBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            return ArgbBuffer(buffer.sliceRange(0, capacity), stride, width, height, releaseCallback)
        }
    }
}