package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.nio.ByteBuffer
import kotlin.math.min

/**
 * U422 (BT.2020) YUV Format. 4:2:2 16bpp
 */
class U422Buffer private constructor(
    buffer: ByteBuffer?,
    override val planeY: Plane,
    override val planeU: Plane,
    override val planeV: Plane,
    override val width: Int,
    override val height: Int,
    cropRect: Rect,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, cropRect, arrayOf(planeY, planeU, planeV), releaseCallback), BufferX422<U422Buffer> {
    fun convertTo(dst: ArgbBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertU422ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertU422ToABGR(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride, dstOffsetABGR = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    companion object Factory : BufferFactory<U422Buffer>, CapacityCalculator<Plane3Capacities> {
        override fun calculate(width: Int, height: Int): Plane3Capacities {
            val halfWidth = (width + 1).shr(1)
            val capacity = width * height
            val halfCapacity = halfWidth * height
            return Plane3Capacities(
                plane1Stride = RowStride(width),
                plane2Stride = RowStride(halfWidth),
                plane3Stride = RowStride(halfWidth),
                plane1Capacity = Capacity(capacity),
                plane2Capacity = Capacity(halfCapacity),
                plane3Capacity = Capacity(halfCapacity),
            )
        }

        override fun allocate(width: Int, height: Int, cropRect: Rect): U422Buffer {
            val (capacityY, capacityU, capacityV, strideY, strideU, strideV) = calculate(width, height)
            val (bufferY, bufferU, bufferV, buffer) = createByteBuffer(listOf(capacityY, capacityU, capacityV))
            return U422Buffer(
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

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int, cropRect: Rect): U422Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacityY, capacityU, capacityV, strideY, strideU, strideV) = calculate(width, height)
            val (bufferY, bufferU, bufferV) = buffer.sliceByLength(listOf(capacityY, capacityU, capacityV))
            return U422Buffer(
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

        fun wrap(planeY: Plane, planeU: Plane, planeV: Plane, width: Int, height: Int, cropRect: Rect): U422Buffer {
            return U422Buffer(
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
