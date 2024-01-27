package io.github.crow_misia.libyuv

import java.nio.ByteBuffer
import kotlin.math.min

/**
 * U422 (BT.2020) YUV Format. 4:2:2 16bpp
 */
class U422Buffer private constructor(
    buffer: ByteBuffer?,
    crop: Rect,
    override val planeY: Plane,
    override val planeU: Plane,
    override val planeV: Plane,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, crop, arrayOf(planeY, planeU, planeV), releaseCallback), BufferX422<U422Buffer> {
    fun convertTo(dst: ArgbBuffer) {
        Yuv.convertU422ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        Yuv.convertU422ToABGR(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    companion object Factory : BufferFactory<U422Buffer> {
        private fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val halfWidth = (width + 1).shr(1)
            val capacity = width * height
            val halfCapacity = halfWidth * height
            return intArrayOf(width, capacity, halfWidth, halfCapacity, halfWidth, halfCapacity)
        }

        override fun allocate(width: Int, height: Int): U422Buffer {
            val (strideY, capacityY, strideU, capacityU, strideV, capacityV) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacityY + capacityU + capacityV)
            val (bufferY, bufferU, bufferV) = buffer.sliceByLength(capacityY, capacityU, capacityV)
            return U422Buffer(
                buffer = buffer,
                crop = Rect(width = width, height = height),
                planeY = PlanePrimitive(strideY, bufferY),
                planeU = PlanePrimitive(strideU, bufferU),
                planeV = PlanePrimitive(strideV, bufferV),
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): U422Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (strideY, capacityY, strideU, capacityU, strideV, capacityV) = getStrideWithCapacity(width, height)
            val (bufferY, bufferU, bufferV) = buffer.sliceByLength(capacityY, capacityU, capacityV)
            return U422Buffer(
                buffer = buffer,
                crop = Rect(width = width, height = height),
                planeY = PlanePrimitive(strideY, bufferY),
                planeU = PlanePrimitive(strideU, bufferU),
                planeV = PlanePrimitive(strideV, bufferV),
                releaseCallback = null,
            )
        }

        fun wrap(planeY: Plane, planeU: Plane, planeV: Plane, width: Int, height: Int): U422Buffer {
            return U422Buffer(
                buffer = null,
                crop = Rect(width = width, height = height),
                planeY = planeY,
                planeU = planeU,
                planeV = planeV,
                releaseCallback = null,
            )
        }
    }
}
