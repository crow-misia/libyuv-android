package io.github.zncmn.libyuv

import java.nio.ByteBuffer

/**
 * RGB16 (RGBP fourcc) little endian
 */
class Rgb565Buffer private constructor(
    val bufferRGB565: ByteBuffer,

    internal val strideRGB565: Int,

    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?
) : Buffer {
    private val refCountDelegate = RefCountDelegate(releaseCallback)
    override fun retain() = refCountDelegate.retain()
    override fun release() = refCountDelegate.release()

    override fun asByteArray() = bufferRGB565.asByteArray()
    override fun asByteArray(dst: ByteArray) = bufferRGB565.asByteArray(dst)

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width.shl(1)
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): Rgb565Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return Rgb565Buffer(buffer, stride, width, height, Runnable {
                Yuv.freeNativeBuffer(buffer)
            })
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): Rgb565Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            return Rgb565Buffer(buffer.sliceRange(0, capacity), stride, width, height, releaseCallback)
        }
    }
}