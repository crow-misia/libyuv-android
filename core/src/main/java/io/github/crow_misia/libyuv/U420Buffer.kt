package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.nio.ByteBuffer

/**
 * U420 (BT.2020) YUV Format. 4:2:0 12bpp
 */
class U420Buffer private constructor(
    buffer: ByteBuffer?,
    override val planeY: Plane,
    override val planeU: Plane,
    override val planeV: Plane,
    override val width: Int,
    override val height: Int,
    cropRect: Rect,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, cropRect, arrayOf(planeY, planeU, planeV), releaseCallback), BufferX420<U420Buffer> {
    override fun getPlaneOffset(planeIndex: Int, rowStride: RowStride, left: Int, top: Int): Int {
        return when (planeIndex) {
            0 -> rowStride * top + left
            else -> {
                val halfLeft = (left + 1).shr(1)
                val halfTop = (top + 1).shr(1)
                rowStride * halfTop + halfLeft
            }
        }
    }

    fun convertTo(dst: ArgbBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertU420ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = offset(1),
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = offset(2),
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertU420ToABGR(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = offset(1),
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = offset(2),
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride, dstOffsetABGR = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    companion object Factory : BufferFactory<U420Buffer>, CapacityCalculator<Plane3Capacities> {
        override fun calculate(width: Int, height: Int): Plane3Capacities {
            val halfWidth = (width + 1).shr(1)
            val halfHeight = (height + 1).shr(1)
            val capacity = width * height
            val halfCapacity = halfWidth * halfHeight
            return Plane3Capacities(
                plane1Stride = RowStride(width),
                plane2Stride = RowStride(halfWidth),
                plane3Stride = RowStride(halfWidth),
                plane1Capacity = Capacity(capacity),
                plane2Capacity = Capacity(halfCapacity),
                plane3Capacity = Capacity(halfCapacity),
            )
        }

        override fun allocate(width: Int, height: Int, cropRect: Rect): U420Buffer {
            val (capacityY, capacityU, capacityV, strideY, strideU, strideV) = calculate(width, height)
            val (bufferY, bufferU, bufferV, buffer) = createByteBuffer(listOf(capacityY, capacityU, capacityV))
            return U420Buffer(
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

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int, cropRect: Rect): U420Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacityY, capacityU, capacityV, strideY, strideU, strideV) = calculate(width, height)
            val (bufferY, bufferU, bufferV) = buffer.sliceByLength(listOf(capacityY, capacityU, capacityV))
            return U420Buffer(
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

        fun wrap(planeY: Plane, planeU: Plane, planeV: Plane, width: Int, height: Int, cropRect: Rect): U420Buffer {
            return U420Buffer(
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
