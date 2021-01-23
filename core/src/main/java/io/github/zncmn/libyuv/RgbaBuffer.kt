package io.github.zncmn.libyuv

import java.nio.ByteBuffer

/**
 * RGBA little endian (abgr in memory)
 */
class RgbaBuffer private constructor(
    val bufferRGBA: ByteBuffer,

    internal val strideRGBA: Int,

    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?
) : Buffer {
    private val refCountDelegate = RefCountDelegate(releaseCallback)
    override fun retain() = refCountDelegate.retain()
    override fun release() = refCountDelegate.release()

    override fun asByteArray() = bufferRGBA.asByteArray()
    override fun asByteArray(dst: ByteArray) = bufferRGBA.asByteArray(dst)

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width.shl(2)
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): RgbaBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return RgbaBuffer(buffer, stride, width, height) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): RgbaBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            return RgbaBuffer(buffer.sliceRange(0, capacity), stride, width, height, releaseCallback)
        }
    }
}