package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

/**
 * I400 (grey) YUV Format. 4:0:0 8bpp
 */
class I400Buffer private constructor(
    val bufferY: ByteBuffer,

    internal val strideY: Int,

    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?
) : Buffer {
    private val refCountDelegate = RefCountDelegate(releaseCallback)
    override fun retain() = refCountDelegate.retain()
    override fun release() = refCountDelegate.release()

    override fun asByteArray() = bufferY.asByteArray()
    override fun asByteArray(dst: ByteArray) = bufferY.asByteArray(dst)

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            return intArrayOf(width, width * height)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): I400Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return I400Buffer(buffer, stride, width, height) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): I400Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            return I400Buffer(buffer.sliceRange(0, capacity), stride, width, height, releaseCallback)
        }
    }
}
