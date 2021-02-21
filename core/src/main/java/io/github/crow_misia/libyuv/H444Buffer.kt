package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

/**
 * H444 (BT.709) YUV Format. 4:4:4 24bpp
 */
class H444Buffer private constructor(
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
            val capacity = width * height
            return intArrayOf(width, capacity, width, capacity, width, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): H444Buffer {
            val (strideY, capacityY, strideU, capacityU, strideV, capacityV) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacityY + capacityU + capacityV)
            val (bufferY, bufferU, bufferV) = buffer.slice(capacityY, capacityU, capacityV)
            return H444Buffer(buffer, bufferY, bufferU, bufferV, strideY, strideU, strideV, width, height) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): H444Buffer {
            val (strideY, capacityY, strideU, capacityU, strideV, capacityV) = getStrideWithCapacity(width, height)
            val (bufferY, bufferU, bufferV) = buffer.slice(capacityY, capacityU, capacityV)
            return H444Buffer(buffer, bufferY, bufferU, bufferV, strideY, strideU, strideV, width, height, releaseCallback)
        }
    }
}
