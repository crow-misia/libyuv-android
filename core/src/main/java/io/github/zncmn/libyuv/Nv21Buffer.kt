package io.github.zncmn.libyuv

import java.nio.ByteBuffer

/**
 * NV21 YUV Format. 4:2:0 12bpp
 */
class Nv21Buffer private constructor(
    private val buffer: ByteBuffer,
    val bufferY: ByteBuffer,
    val bufferVU: ByteBuffer,

    internal val strideY: Int,
    internal val strideVU: Int,

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
            val capacityVU = (width + 1).shr(1) * height
            return intArrayOf(width, capacityY, width, capacityVU)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): Nv21Buffer {
            val (strideY, capacityY, strideVU, capacityVU) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacityY + capacityVU)
            val (bufferY, bufferVU) = buffer.slice(capacityY, capacityVU)
            return Nv21Buffer(buffer, bufferY, bufferVU, strideY, strideVU, width, height) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): Nv21Buffer {
            val (strideY, capacityY, strideVU, capacityVU) = getStrideWithCapacity(width, height)
            val (bufferY, bufferVU) = buffer.slice(capacityY, capacityVU)
            return Nv21Buffer(buffer.duplicate(), bufferY, bufferVU, strideY, strideVU, width, height, releaseCallback)
        }
    }
}
