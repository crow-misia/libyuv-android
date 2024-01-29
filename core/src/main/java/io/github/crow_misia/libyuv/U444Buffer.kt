package io.github.crow_misia.libyuv

import java.nio.ByteBuffer
import kotlin.math.min

/**
 * U444 (BT.2020) YUV Format. 4:4:4 24bpp
 */
class U444Buffer private constructor(
    buffer: ByteBuffer?,
    crop: Rect,
    override val planeY: Plane,
    override val planeU: Plane,
    override val planeV: Plane,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, crop, arrayOf(planeY, planeU, planeV), releaseCallback), BufferX444<U444Buffer> {
    fun convertTo(dst: ArgbBuffer) {
        Yuv.convertU444ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        Yuv.convertU444ToABGR(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride, dstOffsetABGR = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
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

        override fun allocate(width: Int, height: Int): U444Buffer {
            val (capacityY, capacityU, capacityV, strideY, strideU, strideV) = calculate(width, height)
            val (bufferY, bufferU, bufferV, buffer) = createByteBuffer(listOf(capacityY, capacityU, capacityV))
            return U444Buffer(
                buffer = buffer,
                crop = Rect(width = width, height = height),
                planeY = PlanePrimitive(strideY, bufferY),
                planeU = PlanePrimitive(strideU, bufferU),
                planeV = PlanePrimitive(strideV, bufferV),
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): U444Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacityY, capacityU, capacityV, strideY, strideU, strideV) = calculate(width, height)
            val (bufferY, bufferU, bufferV) = buffer.sliceByLength(listOf(capacityY, capacityU, capacityV))
            return U444Buffer(
                buffer = buffer,
                crop = Rect(width = width, height = height),
                planeY = PlanePrimitive(strideY, bufferY),
                planeU = PlanePrimitive(strideU, bufferU),
                planeV = PlanePrimitive(strideV, bufferV),
                releaseCallback = null,
            )
        }

        fun wrap(planeY: Plane, planeU: Plane, planeV: Plane, width: Int, height: Int): U444Buffer {
            return U444Buffer(
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
