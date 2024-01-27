package io.github.crow_misia.libyuv

import java.nio.ByteBuffer
import kotlin.math.min

/**
 * J400 (jpeg grey) YUV Format. 4:0:0 8bpp
 */
class J400Buffer private constructor(
    buffer: ByteBuffer?,
    crop: Rect,
    override val planeY: Plane,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, crop, arrayOf(planeY), releaseCallback), BufferX400<J400Buffer, J420Buffer>, BufferY<J400Buffer> {
    fun convertTo(dst: ArgbBuffer) {
        Yuv.convertJ400ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    companion object Factory : BufferFactory<J400Buffer> {
        private fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            return intArrayOf(width, width * height)
        }

        override fun allocate(width: Int, height: Int): J400Buffer {
            val (strideY, capacity) = getStrideWithCapacity(width, height)
            val bufferY = createByteBuffer(capacity)
            return J400Buffer(
                buffer = bufferY,
                crop = Rect(width = width, height = height),
                planeY = PlanePrimitive(strideY, bufferY),
            ) {
                Yuv.freeNativeBuffer(bufferY)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): J400Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (strideY, capacity) = getStrideWithCapacity(width, height)
            val bufferY = buffer.sliceRange(0, capacity)
            return J400Buffer(
                buffer = buffer,
                crop = Rect(width = width, height = height),
                planeY = PlanePrimitive(strideY, bufferY),
                releaseCallback = null,
            )
        }

        fun wrap(planeYJ: Plane, width: Int, height: Int): J400Buffer {
            return J400Buffer(
                buffer = planeYJ.buffer,
                crop = Rect(width = width, height = height),
                planeY = planeYJ,
                releaseCallback = null,
            )
        }
    }
}
