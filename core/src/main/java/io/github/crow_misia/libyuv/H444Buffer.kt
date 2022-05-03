package io.github.crow_misia.libyuv

import java.nio.ByteBuffer
import kotlin.math.min

/**
 * H444 (BT.709) YUV Format. 4:4:4 24bpp
 */
class H444Buffer private constructor(
    buffer: ByteBuffer?,
    val planeY: Plane,
    val planeU: Plane,
    val planeV: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, arrayOf(planeY, planeU, planeV), releaseCallback) {
    fun convertTo(dst: ArgbBuffer) {
        Yuv.convertH444ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        Yuv.convertH444ToABGR(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun rotate(dst: H444Buffer, rotateMode: RotateMode) {
        Yuv.rotateI444Rotate(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = calculateWidth(this, dst, rotateMode),
            height = calculateHeight(this, dst, rotateMode),
            rotateMode = rotateMode.degrees,
        )
    }

    fun scale(dst: H444Buffer, filterMode: FilterMode) {
        Yuv.scaleI444Scale(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            srcWidth = width, srcHeight = height,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            dstWidth = dst.width, dstHeight = dst.height,
            filterMode = filterMode.mode,
        )
    }

    companion object Factory : BufferFactory<H444Buffer> {
        private fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val capacity = width * height
            return intArrayOf(width, capacity, width, capacity, width, capacity)
        }

        override fun allocate(width: Int, height: Int): H444Buffer {
            val (strideY, capacityY, strideU, capacityU, strideV, capacityV) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacityY + capacityU + capacityV)
            val (bufferY, bufferU, bufferV) = buffer.slice(capacityY, capacityU, capacityV)
            return H444Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeU = PlanePrimitive(strideU, bufferU),
                planeV = PlanePrimitive(strideV, bufferV),
                width = width,
                height = height,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): H444Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (strideY, capacityY, strideU, capacityU, strideV, capacityV) = getStrideWithCapacity(width, height)
            val (bufferY, bufferU, bufferV) = buffer.slice(capacityY, capacityU, capacityV)
            return H444Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeU = PlanePrimitive(strideU, bufferU),
                planeV = PlanePrimitive(strideV, bufferV),
                width = width,
                height = height,
                releaseCallback = null,
            )
        }

        fun wrap(planeY: Plane, planeU: Plane, planeV: Plane, width: Int, height: Int): H444Buffer {
            return H444Buffer(
                buffer = null,
                planeY = planeY,
                planeU = planeU,
                planeV = planeV,
                width = width,
                height = height,
                releaseCallback = null,
            )
        }
    }
}
