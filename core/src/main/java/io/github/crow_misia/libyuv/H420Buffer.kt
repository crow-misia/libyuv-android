package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.nio.ByteBuffer

/**
 * H420 (BT.709) YUV Format. 4:2:0 12bpp
 */
class H420Buffer private constructor(
    buffer: ByteBuffer?,
    override val planeY: Plane,
    override val planeU: Plane,
    override val planeV: Plane,
    override val width: Int,
    override val height: Int,
    cropRect: Rect,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, cropRect, arrayOf(planeY, planeU, planeV), releaseCallback), BufferX420<H420Buffer> {
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
        Yuv.convertH420ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = offset(1),
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = offset(2),
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertH420ToABGR(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = offset(1),
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = offset(2),
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride, dstOffsetABGR = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Rgb24Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertH420ToRGB24(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = offset(1),
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = offset(2),
            dstRGB24 = dst.plane.buffer, dstStrideRGB24 = dst.plane.rowStride, dstOffsetRGB24 = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: RawBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertH420ToRAW(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = offset(1),
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = offset(2),
            dstRAW = dst.plane.buffer, dstStrideRAW = dst.plane.rowStride, dstOffsetRAW = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Rgb565Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertH420ToRGB565(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = offset(1),
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = offset(2),
            dstRGB565 = dst.plane.buffer, dstStrideRGB565 = dst.plane.rowStride, dstOffsetRGB565 = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Ar30Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertH420ToAR30(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = offset(1),
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = offset(2),
            dstAR30 = dst.plane.buffer, dstStrideAR30 = dst.plane.rowStride, dstOffsetAR30 = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Ab30Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertH420ToAB30(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = offset(1),
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = offset(2),
            dstAB30 = dst.plane.buffer, dstStrideAB30 = dst.plane.rowStride, dstOffsetAB30 = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    companion object Factory : BufferFactoryYUV<H420Buffer>, CapacityCalculator<Plane3Capacities> {
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

        override fun allocate(width: Int, height: Int, cropRect: Rect): H420Buffer {
            val (capacityY, capacityU, capacityV, strideY, strideU, strideV) = calculate(width, height)
            val (bufferY, bufferU, bufferV, buffer) = createByteBuffer(listOf(capacityY, capacityU, capacityV))
            return H420Buffer(
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

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int, cropRect: Rect): H420Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacityY, capacityU, capacityV, strideY, strideU, strideV) = calculate(width, height)
            val (bufferY, bufferU, bufferV) = buffer.sliceByLength(listOf(capacityY, capacityU, capacityV))
            return H420Buffer(
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

        override fun wrap(planeY: Plane, planeU: Plane, planeV: Plane, width: Int, height: Int, cropRect: Rect): H420Buffer {
            return H420Buffer(
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
