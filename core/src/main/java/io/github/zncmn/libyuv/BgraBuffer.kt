package io.github.zncmn.libyuv

import java.nio.ByteBuffer

/**
 * BGRA little endian (argb in memory)
 */
class BgraBuffer private constructor(
    val bufferBGRA: ByteBuffer,

    internal val strideBGRA: Int,

    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?
) : Buffer {
    private val refCountDelegate = RefCountDelegate(releaseCallback)
    override fun retain() = refCountDelegate.retain()
    override fun release() = refCountDelegate.release()

    override fun asByteArray() = bufferBGRA.asByteArray()
    override fun asByteArray(dst: ByteArray) = bufferBGRA.asByteArray(dst)

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width.shl(2)
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): BgraBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return BgraBuffer(buffer, stride, width, height) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): BgraBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            return BgraBuffer(buffer.sliceRange(0, capacity), stride, width, height, releaseCallback)
        }
    }
}
