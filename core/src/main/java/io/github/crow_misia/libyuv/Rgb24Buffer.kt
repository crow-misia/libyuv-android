package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

/**
 * RGB little endian (bgr in memory)
 */
class Rgb24Buffer private constructor(
    val bufferRGB24: ByteBuffer,

    internal val strideRGB24: Int,

    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?
) : Buffer {
    private val refCountDelegate = RefCountDelegate(releaseCallback)
    override fun retain() = refCountDelegate.retain()
    override fun release() = refCountDelegate.release()

    override fun asByteArray() = bufferRGB24.asByteArray()
    override fun asByteArray(dst: ByteArray) = bufferRGB24.asByteArray(dst)

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width * 3
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): Rgb24Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return Rgb24Buffer(buffer, stride, width, height) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): Rgb24Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            return Rgb24Buffer(buffer.sliceRange(0, capacity), stride, width, height, releaseCallback )
        }
    }
}