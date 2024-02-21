package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.nio.ByteBuffer

/**
 * U444 (BT.2020) YUV Format. 4:4:4 24bpp
 */
class U444Buffer private constructor(
    buffer: ByteBuffer?,
    override val planeY: Plane,
    override val planeU: Plane,
    override val planeV: Plane,
    override val width: Int,
    override val height: Int,
    cropRect: Rect,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, cropRect, arrayOf(planeY, planeU, planeV), releaseCallback), BufferX444<U444Buffer> {
    override fun getPlaneOffset(planeIndex: Int, rowStride: RowStride, left: Int, top: Int): Int {
        return rowStride * top + left
    }

    fun convertTo(dst: ArgbBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertU444ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = offset(1),
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = offset(2),
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertU444ToABGR(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = offset(1),
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = offset(2),
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride, dstOffsetABGR = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    companion object Factory : BufferFactory<U444Buffer>, CapacityCalculator<Plane3Capacities> {
        override fun calculate(width: Int, height: Int): Plane3Capacities {
            val capacity = width * height
            return Plane3Capacities(
                plane1Stride = RowStride(width),
                plane2Stride = RowStride(width),
                plane3Stride = RowStride(width),
                plane1Capacity = Capacity(capacity),
                plane2Capacity = Capacity(capacity),
                plane3Capacity = Capacity(capacity),
            )
        }

        override fun allocate(width: Int, height: Int, cropRect: Rect): U444Buffer {
            val (capacityY, capacityU, capacityV, strideY, strideU, strideV) = calculate(width, height)
            val (bufferY, bufferU, bufferV, buffer) = createByteBuffer(listOf(capacityY, capacityU, capacityV))
            return U444Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeU = PlanePrimitive(strideU, bufferU),
                planeV = PlanePrimitive(strideV, bufferV),
                width = width,
                height = height,
                cropRect = cropRect,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int, cropRect: Rect): U444Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacityY, capacityU, capacityV, strideY, strideU, strideV) = calculate(width, height)
            val (bufferY, bufferU, bufferV) = buffer.sliceByLength(listOf(capacityY, capacityU, capacityV))
            return U444Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeU = PlanePrimitive(strideU, bufferU),
                planeV = PlanePrimitive(strideV, bufferV),
                width = width,
                height = height,
                cropRect = cropRect,
                releaseCallback = null,
            )
        }

        fun wrap(planeY: Plane, planeU: Plane, planeV: Plane, width: Int, height: Int, cropRect: Rect): U444Buffer {
            return U444Buffer(
                buffer = null,
                planeY = planeY,
                planeU = planeU,
                planeV = planeV,
                width = width,
                height = height,
                cropRect = cropRect,
                releaseCallback = null,
            )
        }
    }
}
