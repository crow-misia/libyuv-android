package io.github.zncmn.libyuv

import java.nio.ByteBuffer

/**
 * NV12 YUV Format. 4:2:0 12bpp
 */
class Nv12Buffer private constructor(
    private val buffer: ByteBuffer,

    val bufferY: ByteBuffer,
    val bufferUV: ByteBuffer,

    internal val strideY: Int,
    internal val strideUV: Int,

    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?
) : Buffer {
    private val refCountDelegate = RefCountDelegate(releaseCallback)
    override fun retain() = refCountDelegate.retain()
    override fun release() = refCountDelegate.release()

    override fun asByteArray() = buffer.asByteArray()
    override fun asByteArray(dst: ByteArray) = buffer.asByteArray(dst)

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val capacityY = width * height
            val capacityUV = (width + 1).shr(1) * height
            return intArrayOf(width, capacityY, width, capacityUV)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): Nv12Buffer {
            val (strideY, capacityY, strideUV, capacityUV) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacityY + capacityUV)
            val (bufferY, bufferUV) = buffer.slice(capacityY, capacityUV)
            return Nv12Buffer(buffer, bufferY, bufferUV, strideY, strideUV, width, height) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): Nv12Buffer {
            val (strideY, capacityY, strideUV, capacityUV) = getStrideWithCapacity(width, height)
            val (bufferY, bufferUV) = buffer.slice(capacityY, capacityUV)
            return Nv12Buffer(buffer.duplicate(), bufferY, bufferUV, strideY, strideUV, width, height, releaseCallback)
        }
    }
}
