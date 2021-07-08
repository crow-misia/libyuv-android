package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import io.github.crow_misia.libyuv.BitmapConverter.Companion.toBitmap
import java.nio.ByteBuffer

/**
 * ABGR little endian (rgba in memory)
 */
class AbgrBuffer private constructor(
    internal val buffer: ByteBuffer,
    internal val strideABGR: Int,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?,
) : AbstractBuffer(releaseCallback) {
    override fun asBuffer() = buffer
    override fun asByteArray() = buffer.asByteArray()
    override fun asByteArray(dst: ByteArray) = buffer.asByteArray(dst)
    override fun asBitmap(): Bitmap {
        return buffer.toBitmap(width, height, Bitmap.Config.ARGB_8888)
    }

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width.shl(2)
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): AbgrBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return AbgrBuffer(buffer, stride, width, height) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): AbgrBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            return AbgrBuffer(buffer.sliceRange(0, capacity), stride, width, height, releaseCallback)
        }
    }
}