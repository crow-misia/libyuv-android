package io.github.zncmn.libyuv

import java.nio.ByteBuffer

/**
 * I422 YUV Format. 4:2:2 16bpp
 */
class I422Buffer private constructor(
    private val buffer: ByteBuffer,

    val bufferY: ByteBuffer,
    val bufferU: ByteBuffer,
    val bufferV: ByteBuffer,

    internal val strideY: Int,
    internal val strideU: Int,
    internal val strideV: Int,

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
            val halfWidth = (width + 1).shr(1)
            val capacity = width * height
            val halfCapacity = halfWidth * height
            return intArrayOf(width, capacity, halfWidth, halfCapacity, halfWidth, halfCapacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): I422Buffer {
            val (strideY, capacityY, strideU, capacityU, strideV, capacityV) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacityY + capacityU + capacityV)
            val (bufferY, bufferU, bufferV) = buffer.slice(capacityY, capacityU, capacityV)
            return I422Buffer(buffer, bufferY, bufferU, bufferV, strideY, strideU, strideV, width, height, Runnable {
                Yuv.freeNativeBuffer(buffer)
            })
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): I422Buffer {
            val (strideY, capacityY, strideU, capacityU, strideV, capacityV) = getStrideWithCapacity(width, height)
            val (bufferY, bufferU, bufferV) = buffer.slice(capacityY, capacityU, capacityV)
            return I422Buffer(buffer.duplicate(), bufferY, bufferU, bufferV, strideY, strideU, strideV, width, height, releaseCallback)
        }
    }
}
