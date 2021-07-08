package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import java.nio.ByteBuffer

/**
 * H420 (BT.709) YUV Format. 4:2:0 12bpp
 */
class H420Buffer private constructor(
    internal val buffer: ByteBuffer,
    val bufferY: ByteBuffer,
    val bufferU: ByteBuffer,
    val bufferV: ByteBuffer,
    internal val strideY: Int,
    internal val strideU: Int,
    internal val strideV: Int,

    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?,
) : AbstractBuffer(releaseCallback) {
    override fun asBuffer() = buffer
    override fun asByteArray() = buffer.asByteArray()
    override fun asByteArray(dst: ByteArray) = buffer.asByteArray(dst)
    override fun asBitmap(): Bitmap {
        return AbgrBuffer.allocate(width, height).use { buf ->
            convertTo(buf)
            buf.asBitmap()
        }
    }

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val halfWidth = (width + 1).shr(1)
            val capacity = width * height
            val halfCapacity = (halfWidth + 1).shr(1) * height
            return intArrayOf(width, capacity, halfWidth, halfCapacity, halfWidth, halfCapacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): H420Buffer {
            val (strideY, capacityY, strideU, capacityU, strideV, capacityV) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacityY + capacityU + capacityV)
            val (bufferY, bufferU, bufferV) = buffer.slice(capacityY, capacityU, capacityV)
            return H420Buffer(buffer, bufferY, bufferU, bufferV, strideY, strideU, strideV, width, height) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): H420Buffer {
            val (strideY, capacityY, strideU, capacityU, strideV, capacityV) = getStrideWithCapacity(width, height)
            val (bufferY, bufferU, bufferV) = buffer.slice(capacityY, capacityU, capacityV)
            return H420Buffer(buffer.duplicate(), bufferY, bufferU, bufferV, strideY, strideU, strideV, width, height, releaseCallback)
        }
    }
}