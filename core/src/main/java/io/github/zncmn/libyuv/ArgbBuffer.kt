package io.github.zncmn.libyuv

import java.nio.ByteBuffer

/**
 * ARGB little endian (bgra in memory)
 */
class ArgbBuffer private constructor(
    val bufferARGB: ByteBuffer,

    internal val strideARGB: Int,

    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?
) : Buffer {
    private val refCountDelegate = RefCountDelegate(releaseCallback)
    override fun retain() = refCountDelegate.retain()
    override fun release() = refCountDelegate.release()

    override fun asByteArray() = bufferARGB.asByteArray()
    override fun asByteArray(dst: ByteArray) = bufferARGB.asByteArray(dst)

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
            return ArgbBuffer(buffer, stride, width, height, Runnable {
                Yuv.freeNativeBuffer(buffer)
            })
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): ArgbBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            return ArgbBuffer(buffer.sliceRange(0, capacity), stride, width, height, releaseCallback)
        }
    }
}