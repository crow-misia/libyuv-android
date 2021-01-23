package io.github.zncmn.libyuv

import java.nio.ByteBuffer

/**
 * YUV 24bpp
 */
class Yuv24Buffer private constructor(
    val bufferYUV24: ByteBuffer,

    internal val strideYUV24: Int,

    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?
) : Buffer {
    private val refCountDelegate = RefCountDelegate(releaseCallback)
    override fun retain() = refCountDelegate.retain()
    override fun release() = refCountDelegate.release()

    override fun asByteArray() = bufferYUV24.asByteArray()
    override fun asByteArray(dst: ByteArray) = bufferYUV24.asByteArray(dst)

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width * 3
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): Yuv24Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return Yuv24Buffer(buffer, stride, width, height) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): Yuv24Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            return Yuv24Buffer(buffer.sliceRange(0, capacity), stride, width, height, releaseCallback )
        }
    }
}