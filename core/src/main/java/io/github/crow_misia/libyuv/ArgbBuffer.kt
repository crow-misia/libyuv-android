package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.nio.ByteBuffer
import kotlin.math.min

/**
 * ARGB little endian (bgra in memory)
 */
class ArgbBuffer private constructor(
    buffer: ByteBuffer?,
    override val plane: Plane,
    override val width: Int,
    override val height: Int,
    cropRect: Rect,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, cropRect, arrayOf(plane), releaseCallback), Buffer32<ArgbBuffer>, BufferFirstAlpha {
    fun convertTo(dst: I400Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToI400(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: I420Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToI420(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: I422Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToI422(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: I444Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToI444(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: J400Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToJ400(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: J420Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToJ420(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: J422Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToJ422(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Nv12Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToNV12(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride, dstOffsetUV = dst.planeUV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Nv21Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToNV21(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstVU = dst.planeVU.buffer, dstStrideVU = dst.planeVU.rowStride, dstOffsetVU = dst.planeVU.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToABGR(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride, dstOffsetABGR = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Argb1555Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToARGB1555(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB1555 = dst.plane.buffer, dstStrideARGB1555 = dst.plane.rowStride, dstOffsetARGB1555 = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Argb4444Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToARGB4444(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB4444 = dst.plane.buffer, dstStrideARGB4444 = dst.plane.rowStride, dstOffsetARGB4444 = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: BgraBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToBGRA(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstBGRA = dst.plane.buffer, dstStrideBGRA = dst.plane.rowStride, dstOffsetBGRA = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: RawBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToRAW(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstRAW = dst.plane.buffer, dstStrideRAW = dst.plane.rowStride, dstOffsetRAW = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: RgbaBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToRGBA(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstRGBA = dst.plane.buffer, dstStrideRGBA = dst.plane.rowStride, dstOffsetRGBA = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Rgb24Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToRGB24(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstRGB24 = dst.plane.buffer, dstStrideRGB24 = dst.plane.rowStride, dstOffsetRGB24 = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Rgb565Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToRGB565(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstRGB565 = dst.plane.buffer, dstStrideRGB565 = dst.plane.rowStride, dstOffsetRGB565 = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Yuy2Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToYUY2(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstYUY2 = dst.plane.buffer, dstStrideYUY2 = dst.plane.rowStride, dstOffsetYUY2 = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: UyvyBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToUYVY(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstUYVY = dst.plane.buffer, dstStrideUYVY = dst.plane.rowStride, dstOffsetUYVY = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun drawRect(left: Int, top: Int, width: Int, height: Int, value: Long) {
        drawRect(Rect(left, top, left + width, top + height), value)
    }

    fun drawRect(rect: Rect, value: Long) {
        Yuv.planerARGBRect(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            x = rect.left, y = rect.top,
            width = rect.width(), height = rect.height(),
            value = value,
        )
    }

    fun drawGrayTo(dst: ArgbBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planerARGBGrayTo(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun drawGray(left: Int, top: Int, width: Int, height: Int) {
        Yuv.planerARGBGray(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            x = left, y = top,
            width = width, height = height,
        )
    }

    fun drawGray(rect: Rect) {
        drawGray(rect.left, rect.top, rect.width(), rect.height())
    }

    fun drawSepia(left: Int, top: Int, width: Int, height: Int) {
        Yuv.planerARGBSepia(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            x = left, y = top,
            width = width, height = height,
        )
    }

    fun drawSepia(rect: Rect) {
        drawSepia(rect.left, rect.top, rect.width(), rect.height())
    }

    fun drawColorMatrix(dst: ArgbBuffer, matrixARGB: ByteArray, width: Int, height: Int) {
        Yuv.planerARGBColorMatrix(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            matrixARGB = matrixARGB,
            width = width, height = height,
        )
    }

    fun drawColorTable(tableARGB: ByteArray, left: Int, top: Int, width: Int, height: Int) {
        Yuv.planerARGBColorTable(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            tableARGB = tableARGB,
            x = left, y = top,
            width = width, height = height,
        )
    }

    fun drawColorTable(tableARGB: ByteArray, rect: Rect) {
        drawColorTable(tableARGB, rect.left, rect.top, rect.width(), rect.height())
    }

    fun drawRGBColorTable(tableARGB: ByteArray, left: Int, top: Int, width: Int, height: Int) {
        Yuv.planerARGBColorTable(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            tableARGB = tableARGB,
            x = left, y = top,
            width = width, height = height,
        )
    }

    fun drawRGBColorTable(tableARGB: ByteArray, rect: Rect) {
        drawRGBColorTable(tableARGB, rect.left, rect.top, rect.width(), rect.height())
    }

    fun drawLumaColorTable(dst: ArgbBuffer, luma: ByteArray, width: Int, height: Int) {
        Yuv.planerARGBLumaColorTable(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            luma = luma,
            width = width, height = height,
        )
    }

    fun drawPolynomial(dst: ArgbBuffer, poly: FloatArray, width: Int, height: Int) {
        Yuv.planerARGBPolynomial(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            poly = poly,
            width = width, height = height,
        )
    }

    fun drawQuantize(scale: Int, intervalSize: Int, intervalOffset: Int, left: Int, top: Int, width: Int, height: Int) {
        Yuv.planerARGBQuantize(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            scale = scale,
            intervalSize = intervalSize, intervalOffset = intervalOffset,
            x = left, y = top,
            width = width, height = height,
        )
    }

    fun drawQuantize(scale: Int, intervalSize: Int, intervalOffset: Int, rect: Rect) {
        drawQuantize(scale, intervalSize, intervalOffset, rect.left, rect.top, rect.width(), rect.height())
    }

    fun drawBlendFrom(src1: ArgbBuffer, src2: ArgbBuffer, width: Int, height: Int) {
        Yuv.planerARGBBlend(
            srcARGB0 = src1.plane.buffer, srcStrideARGB0 = src1.plane.rowStride, srcOffsetARGB0 = src1.plane.offset,
            srcARGB1 = src2.plane.buffer, srcStrideARGB1 = src2.plane.rowStride, srcOffsetARGB1 = src2.plane.offset,
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            width = minWidth(width, src1.cropRect, src2.cropRect),
            height = minHeight(height, src1.cropRect, src2.cropRect),
        )
    }

    fun drawMultiplyFrom(src1: ArgbBuffer, src2: ArgbBuffer, width: Int, height: Int) {
        Yuv.planerARGBMultiply(
            srcARGB0 = src1.plane.buffer, srcStrideARGB0 = src1.plane.rowStride, srcOffsetARGB0 = src1.plane.offset,
            srcARGB1 = src2.plane.buffer, srcStrideARGB1 = src2.plane.rowStride, srcOffsetARGB1 = src2.plane.offset,
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            width = minWidth(width, src1.cropRect, src2.cropRect),
            height = minHeight(height, src1.cropRect, src2.cropRect),
        )
    }

    fun drawAddFrom(src1: ArgbBuffer, src2: ArgbBuffer, rect: Rect) {
        Yuv.planerARGBAdd(
            srcARGB0 = src1.plane.buffer, srcStrideARGB0 = src1.plane.rowStride, srcOffsetARGB0 = src1.plane.offset,
            srcARGB1 = src2.plane.buffer, srcStrideARGB1 = src2.plane.rowStride, srcOffsetARGB1 = src2.plane.offset,
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            width = minWidth(rect, src1.cropRect, src2.cropRect),
            height = minHeight(rect, src1.cropRect, src2.cropRect),
        )
    }

    fun drawSubtractFrom(src1: ArgbBuffer, src2: ArgbBuffer, rect: Rect) {
        Yuv.planerARGBSubtract(
            srcARGB0 = src1.plane.buffer, srcStrideARGB0 = src1.plane.rowStride, srcOffsetARGB0 = src1.plane.offset,
            srcARGB1 = src2.plane.buffer, srcStrideARGB1 = src2.plane.rowStride, srcOffsetARGB1 = src2.plane.offset,
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            width = minWidth(rect, src1.cropRect, src2.cropRect),
            height = minHeight(rect, src1.cropRect, src2.cropRect),
        )
    }

    fun drawBlur(dst: ArgbBuffer, left: Int = 0, top: Int = 0, width: Int, height: Int, radius: Int) {
        drawBlur(dst, Rect(left, top, left + width, top + height), radius)
    }

    fun drawBlur(dst: ArgbBuffer, rect: Rect = cropRect, radius: Int) {
        Yuv.planerARGBBlur(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = minWidth(rect, dst.cropRect),
            height = minHeight(rect, dst.cropRect),
            radius = radius,
        )
    }

    fun drawShade(dst: ArgbBuffer, left: Int = 0, top: Int = 0, width: Int, height: Int, value: Long) {
        drawShade(dst, Rect(left, top, left + width, top + height), value)
    }

    fun drawShade(dst: ArgbBuffer, rect: Rect = cropRect, value: Long) {
        Yuv.planerARGBShade(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = minWidth(rect, dst.cropRect),
            height = minHeight(rect, dst.cropRect),
            value = value,
        )
    }

    fun drawInterpolateFrom(src1: ArgbBuffer, src2: ArgbBuffer, rect: Rect, interpolation: Int) {
        Yuv.planerARGBInterpolate(
            srcARGB0 = src1.plane.buffer, srcStrideARGB0 = src1.plane.rowStride, srcOffsetARGB0 = src1.plane.offset,
            srcARGB1 = src2.plane.buffer, srcStrideARGB1 = src2.plane.rowStride, srcOffsetARGB1 = src2.plane.offset,
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            width = minWidth(rect, src1.cropRect, src2.cropRect),
            height = minHeight(rect, src1.cropRect, src2.cropRect),
            interpolation = interpolation,
        )
    }

    companion object Factory : BufferFactory<ArgbBuffer>, CapacityCalculator<Plane1Capacities> {
        override fun calculate(width: Int, height: Int): Plane1Capacities {
            val stride = width.shl(2)
            val capacity = stride * height
            return Plane1Capacities(
                planeStride = RowStride(stride),
                planeCapacity = Capacity(capacity),
            )
        }

        override fun allocate(width: Int, height: Int, cropRect: Rect): ArgbBuffer {
            val (capacity, stride) = calculate(width, height)
            val (buffer) = createByteBuffer(listOf(capacity))
            return ArgbBuffer(
                buffer = buffer,
                width = width,
                height = height,
                cropRect = cropRect,
                plane = PlanePrimitive(stride, buffer),
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int, cropRect: Rect): ArgbBuffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacity, stride) = calculate(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity.value)
            return ArgbBuffer(
                buffer = buffer,
                plane = PlanePrimitive(stride, sliceBuffer),
                width = width,
                height = height,
                cropRect = cropRect,
                releaseCallback = null,
            )
        }

        fun wrap(plane: Plane, width: Int, height: Int, cropRect: Rect): ArgbBuffer {
            return ArgbBuffer(
                buffer = plane.buffer,
                plane = plane,
                width = width,
                height = height,
                cropRect = cropRect,
                releaseCallback = null,
            )
        }
    }
}
