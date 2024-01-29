package io.github.crow_misia.libyuv

import java.nio.ByteBuffer
import kotlin.math.min

/**
 * ARGB little endian (bgra in memory)
 */
class ArgbBuffer private constructor(
    buffer: ByteBuffer?,
    crop: Rect,
    override val plane: Plane,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, crop, arrayOf(plane), releaseCallback), Buffer32<ArgbBuffer>, BufferFirstAlpha {
    fun convertTo(dst: I400Buffer) {
        Yuv.convertARGBToI400(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: I420Buffer) {
        Yuv.convertARGBToI420(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: I422Buffer) {
        Yuv.convertARGBToI422(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: I444Buffer) {
        Yuv.convertARGBToI444(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: J400Buffer) {
        Yuv.convertARGBToJ400(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: J420Buffer) {
        Yuv.convertARGBToJ420(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: J422Buffer) {
        Yuv.convertARGBToJ422(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv12Buffer) {
        Yuv.convertARGBToNV12(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride, dstOffsetUV = dst.planeUV.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv21Buffer) {
        Yuv.convertARGBToNV21(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstVU = dst.planeVU.buffer, dstStrideVU = dst.planeVU.rowStride, dstOffsetVU = dst.planeVU.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        Yuv.convertARGBToABGR(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride, dstOffsetABGR = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Argb1555Buffer) {
        Yuv.convertARGBToARGB1555(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB1555 = dst.plane.buffer, dstStrideARGB1555 = dst.plane.rowStride, dstOffsetARGB1555 = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Argb4444Buffer) {
        Yuv.convertARGBToARGB4444(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB4444 = dst.plane.buffer, dstStrideARGB4444 = dst.plane.rowStride, dstOffsetARGB4444 = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: BgraBuffer) {
        Yuv.convertARGBToBGRA(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstBGRA = dst.plane.buffer, dstStrideBGRA = dst.plane.rowStride, dstOffsetBGRA = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: RawBuffer) {
        Yuv.convertARGBToRAW(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstRAW = dst.plane.buffer, dstStrideRAW = dst.plane.rowStride, dstOffsetRAW = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: RgbaBuffer) {
        Yuv.convertARGBToRGBA(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstRGBA = dst.plane.buffer, dstStrideRGBA = dst.plane.rowStride, dstOffsetRGBA = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Rgb24Buffer) {
        Yuv.convertARGBToRGB24(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstRGB24 = dst.plane.buffer, dstStrideRGB24 = dst.plane.rowStride, dstOffsetRGB24 = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Rgb565Buffer) {
        Yuv.convertARGBToRGB565(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstRGB565 = dst.plane.buffer, dstStrideRGB565 = dst.plane.rowStride, dstOffsetRGB565 = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Yuy2Buffer) {
        Yuv.convertARGBToYUY2(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstYUY2 = dst.plane.buffer, dstStrideYUY2 = dst.plane.rowStride, dstOffsetYUY2 = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: UyvyBuffer) {
        Yuv.convertARGBToUYVY(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstUYVY = dst.plane.buffer, dstStrideUYVY = dst.plane.rowStride, dstOffsetUYVY = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun drawRect(x: Int, y: Int, width: Int, height: Int, value: Long) {
        Yuv.planerARGBRect(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            x = x, y = y,
            width = width, height = height,
            value = value,
        )
    }

    fun drawGrayTo(dst: ArgbBuffer) {
        Yuv.planerARGBGrayTo(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun drawGray(x: Int, y: Int, width: Int, height: Int) {
        Yuv.planerARGBGray(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            x = x, y = y,
            width = width, height = height,
        )
    }

    fun drawSepia(x: Int, y: Int, width: Int, height: Int) {
        Yuv.planerARGBSepia(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            x = x, y = y,
            width = width, height = height,
        )
    }

    fun drawColorMatrix(dst: ArgbBuffer, matrixARGB: ByteArray, width: Int, height: Int) {
        Yuv.planerARGBColorMatrix(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            matrixARGB = matrixARGB,
            width = width, height = height,
        )
    }

    fun drawColorTable(tableARGB: ByteArray, x: Int, y: Int, width: Int, height: Int) {
        Yuv.planerARGBColorTable(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            tableARGB = tableARGB,
            x = x, y = y,
            width = width, height = height,
        )
    }

    fun drawRGBColorTable(tableARGB: ByteArray, x: Int, y: Int, width: Int, height: Int) {
        Yuv.planerARGBColorTable(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            tableARGB = tableARGB,
            x = x, y = y,
            width = width, height = height,
        )
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

    fun drawQuantize(scale: Int, intervalSize: Int, intervalOffset: Int, x: Int, y: Int, width: Int, height: Int) {
        Yuv.planerARGBQuantize(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            scale = scale,
            intervalSize = intervalSize, intervalOffset = intervalOffset,
            x = x, y = y,
            width = width, height = height,
        )
    }

    fun drawBlendFrom(src1: ArgbBuffer, src2: ArgbBuffer, width: Int, height: Int) {
        Yuv.planerARGBBlend(
            srcARGB0 = src1.plane.buffer, srcStrideARGB0 = src1.plane.rowStride, srcOffsetARGB0 = src1.plane.offset,
            srcARGB1 = src2.plane.buffer, srcStrideARGB1 = src2.plane.rowStride, srcOffsetARGB1 = src2.plane.offset,
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            width = minOf(width, src1.width, src2.width), height = minOf(height, src1.height, src2.height),
        )
    }

    fun drawMultiplyFrom(src1: ArgbBuffer, src2: ArgbBuffer, width: Int, height: Int) {
        Yuv.planerARGBMultiply(
            srcARGB0 = src1.plane.buffer, srcStrideARGB0 = src1.plane.rowStride, srcOffsetARGB0 = src1.plane.offset,
            srcARGB1 = src2.plane.buffer, srcStrideARGB1 = src2.plane.rowStride, srcOffsetARGB1 = src2.plane.offset,
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            width = minOf(width, src1.width, src2.width), height = minOf(height, src1.height, src2.height),
        )
    }

    fun drawAddFrom(src1: ArgbBuffer, src2: ArgbBuffer, width: Int, height: Int) {
        Yuv.planerARGBAdd(
            srcARGB0 = src1.plane.buffer, srcStrideARGB0 = src1.plane.rowStride, srcOffsetARGB0 = src1.plane.offset,
            srcARGB1 = src2.plane.buffer, srcStrideARGB1 = src2.plane.rowStride, srcOffsetARGB1 = src2.plane.offset,
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            width = minOf(width, src1.width, src2.width), height = minOf(height, src1.height, src2.height),
        )
    }

    fun drawSubtractFrom(src1: ArgbBuffer, src2: ArgbBuffer, width: Int, height: Int) {
        Yuv.planerARGBSubtract(
            srcARGB0 = src1.plane.buffer, srcStrideARGB0 = src1.plane.rowStride, srcOffsetARGB0 = src1.plane.offset,
            srcARGB1 = src2.plane.buffer, srcStrideARGB1 = src2.plane.rowStride, srcOffsetARGB1 = src2.plane.offset,
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            width = minOf(width, src1.width, src2.width), height = minOf(height, src1.height, src2.height),
        )
    }

    fun drawBlur(dst: ArgbBuffer, width: Int, height: Int, radius: Int) {
        Yuv.planerARGBBlur(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
            radius = radius,
        )
    }

    fun drawShade(dst: ArgbBuffer, width: Int, height: Int, value: Long) {
        Yuv.planerARGBShade(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
            value = value,
        )
    }

    fun drawInterpolateFrom(src1: ArgbBuffer, src2: ArgbBuffer, width: Int, height: Int, interpolation: Int) {
        Yuv.planerARGBInterpolate(
            srcARGB0 = src1.plane.buffer, srcStrideARGB0 = src1.plane.rowStride, srcOffsetARGB0 = src1.plane.offset,
            srcARGB1 = src2.plane.buffer, srcStrideARGB1 = src2.plane.rowStride, srcOffsetARGB1 = src2.plane.offset,
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride, dstOffsetARGB = plane.offset,
            width = minOf(width, src1.width, src2.width), height = minOf(height, src1.height, src2.height),
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

        override fun allocate(width: Int, height: Int): ArgbBuffer {
            val (capacity, stride) = calculate(width, height)
            val (buffer) = createByteBuffer(listOf(capacity))
            return ArgbBuffer(
                buffer = buffer,
                crop = Rect(width = width, height = height),
                plane = PlanePrimitive(stride, buffer),
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): ArgbBuffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacity, stride) = calculate(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity.value)
            return ArgbBuffer(
                buffer = buffer,
                crop = Rect(width = width, height = height),
                plane = PlanePrimitive(stride, sliceBuffer),
                releaseCallback = null,
            )
        }

        fun wrap(plane: Plane, width: Int, height: Int): ArgbBuffer {
            return ArgbBuffer(
                buffer = plane.buffer,
                crop = Rect(width = width, height = height),
                plane = plane,
                releaseCallback = null,
            )
        }
    }
}
