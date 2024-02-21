package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.nio.ByteBuffer
import kotlin.math.min

/**
 * I420 (BT.601) YUV Format. 4:2:0 12bpp
 */
class I420Buffer private constructor(
    buffer: ByteBuffer?,
    override val planeY: Plane,
    override val planeU: Plane,
    override val planeV: Plane,
    override val width: Int,
    override val height: Int,
    cropRect: Rect,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, cropRect, arrayOf(planeY, planeU, planeV), releaseCallback), BufferX420<I420Buffer>, BufferY<I400Buffer> {
    fun convertTo(dst: I422Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToI422(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: I444Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToI444(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Nv12Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToNV12(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride, dstOffsetUV = dst.planeUV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Nv21Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToNV21(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstVU = dst.planeVU.buffer, dstStrideVU = dst.planeVU.rowStride, dstOffsetVU = dst.planeVU.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: BgraBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToBGRA(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstBGRA = dst.plane.buffer, dstStrideBGRA = dst.plane.rowStride, dstOffsetBGRA = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToABGR(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride, dstOffsetABGR = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: RgbaBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToRGBA(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstRGBA = dst.plane.buffer, dstStrideRGBA = dst.plane.rowStride, dstOffsetRGBA = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Rgb24Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToRGB24(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstRGB24 = dst.plane.buffer, dstStrideRGB24 = dst.plane.rowStride, dstOffsetRGB24 = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: RawBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToRAW(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstRAW = dst.plane.buffer, dstStrideRAW = dst.plane.rowStride, dstOffsetRAW = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Rgb565Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToRGB565(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstRGB565 = dst.plane.buffer, dstStrideRGB565 = dst.plane.rowStride, dstOffsetRGB565 = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Argb1555Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToARGB1555(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstARGB1555 = dst.plane.buffer, dstStrideARGB1555 = dst.plane.rowStride, dstOffsetARGB1555 = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Argb4444Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToARGB4444(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstARGB4444 = dst.plane.buffer, dstStrideARGB4444 = dst.plane.rowStride, dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Ar30Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToAR30(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstAR30 = dst.plane.buffer, dstStrideAR30 = dst.plane.rowStride, dstOffsetAR30 = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Ab30Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToAB30(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstAB30 = dst.plane.buffer, dstStrideAB30 = dst.plane.rowStride, dstOffsetAB30 = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Yuy2Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToYUY2(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstYUY2 = dst.plane.buffer, dstStrideYUY2 = dst.plane.rowStride, dstOffsetYUY2 = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: UyvyBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI420ToUYVY(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeU.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeV.offset,
            dstUYVY = dst.plane.buffer, dstStrideUYVY = dst.plane.rowStride, dstOffsetUYVY = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }


    fun drawRect(left: Int, top: Int, width: Int, height: Int, valueY: Int, valueU: Int, valueV: Int) {
        Yuv.planerI420Rect(
            dstY = planeY.buffer, dstStrideY = planeY.rowStride, dstOffsetY = planeY.offset,
            dstU = planeU.buffer, dstStrideU = planeU.rowStride, dstOffsetU = planeU.offset,
            dstV = planeV.buffer, dstStrideV = planeV.rowStride, dstOffsetV = planeV.offset,
            x = left, y = top,
            width = width, height = height,
            valueY = valueY, valueU = valueU, valueV = valueV,
        )
    }

    fun drawRect(rect: Rect, valueY: Int, valueU: Int, valueV: Int) {
        drawRect(rect.left, rect.top, rect.width(), rect.height(), valueY, valueU, valueV)
    }

    fun drawBlendFrom(src1: I420Buffer, srcAPlane: Plane, src2: I420Buffer, width: Int, height: Int) {
        Yuv.planerI420Blend(
            srcY0 = src1.planeY.buffer, srcStrideY0 = src1.planeY.rowStride, srcOffsetY0 = src1.planeY.offset,
            srcU0 = src1.planeU.buffer, srcStrideU0 = src1.planeU.rowStride, srcOffsetU0 = src1.planeU.offset,
            srcV0 = src1.planeV.buffer, srcStrideV0 = src1.planeV.rowStride, srcOffsetV0 = src1.planeV.offset,
            srcY1 = src2.planeY.buffer, srcStrideY1 = src2.planeY.rowStride, srcOffsetY1 = src2.planeY.offset,
            srcU1 = src2.planeU.buffer, srcStrideU1 = src2.planeU.rowStride, srcOffsetU1 = src2.planeU.offset,
            srcV1 = src2.planeV.buffer, srcStrideV1 = src2.planeV.rowStride, srcOffsetV1 = src2.planeV.offset,
            srcA = srcAPlane.buffer, srcStrideA = srcAPlane.rowStride, dstOffsetA = 0,
            dstY = planeY.buffer, dstStrideY = planeY.rowStride, dstOffsetY = planeY.offset,
            dstU = planeU.buffer, dstStrideU = planeU.rowStride, dstOffsetU = planeU.offset,
            dstV = planeV.buffer, dstStrideV = planeV.rowStride, dstOffsetV = planeV.offset,
            width = minWidth(cropRect, src1.cropRect, src2.cropRect),
            height = minHeight(cropRect, src1.cropRect, src2.cropRect),
        )
    }

    fun drawInterpolateFrom(src1: I420Buffer, src2: I420Buffer, width: Int, height: Int, interpolation: Int) {
        Yuv.planerI420Interpolate(
            srcY0 = src1.planeY.buffer, srcStrideY0 = src1.planeY.rowStride, srcOffsetY0 = src1.planeY.offset,
            srcU0 = src1.planeU.buffer, srcStrideU0 = src1.planeU.rowStride, srcOffsetU0 = src1.planeU.offset,
            srcV0 = src1.planeV.buffer, srcStrideV0 = src1.planeV.rowStride, srcOffsetV0 = src1.planeV.offset,
            srcY1 = src2.planeY.buffer, srcStrideY1 = src2.planeY.rowStride, srcOffsetY1 = src2.planeY.offset,
            srcU1 = src2.planeU.buffer, srcStrideU1 = src2.planeU.rowStride, srcOffsetU1 = src2.planeU.offset,
            srcV1 = src2.planeV.buffer, srcStrideV1 = src2.planeV.rowStride, srcOffsetV1 = src2.planeV.offset,
            dstY = planeY.buffer, dstStrideY = planeY.rowStride, dstOffsetY = planeY.offset,
            dstU = planeU.buffer, dstStrideU = planeU.rowStride, dstOffsetU = planeU.offset,
            dstV = planeV.buffer, dstStrideV = planeV.rowStride, dstOffsetV = planeV.offset,
            width = minWidth(cropRect, src1.cropRect, src2.cropRect),
            height = minHeight(cropRect, src1.cropRect, src2.cropRect),
            interpolation = interpolation,
        )
    }

    companion object Factory : BufferFactory<I420Buffer>, CapacityCalculator<Plane3Capacities> {
        override fun calculate(width: Int, height: Int): Plane3Capacities {
            val halfWidth = (width + 1).shr(1)
            val halfHeight = (height + 1).shr(1)
            val capacity = Capacity(width * height)
            val halfCapacity = Capacity(halfWidth * halfHeight)
            return Plane3Capacities(
                plane1Stride = RowStride(width),
                plane2Stride = RowStride(halfWidth),
                plane3Stride = RowStride(halfWidth),
                plane1Capacity = capacity,
                plane2Capacity = halfCapacity,
                plane3Capacity = halfCapacity,
            )
        }

        override fun allocate(width: Int, height: Int, cropRect: Rect): I420Buffer {
            val (capacityY, capacityU, capacityV, strideY, strideU, strideV) = calculate(width, height)
            val (bufferY, bufferU, bufferV, buffer) = createByteBuffer(listOf(capacityY, capacityU, capacityV))
            return I420Buffer(
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

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int, cropRect: Rect): I420Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacityY, capacityU, capacityV, strideY, strideU, strideV) = calculate(width, height)
            val (bufferY, bufferU, bufferV) = buffer.sliceByLength(listOf(capacityY, capacityU, capacityV))
            return I420Buffer(
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

        fun wrap(planeY: Plane, planeU: Plane, planeV: Plane, width: Int, height: Int, cropRect: Rect): I420Buffer {
            return I420Buffer(
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
