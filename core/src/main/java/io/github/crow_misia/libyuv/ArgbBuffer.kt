package io.github.crow_misia.libyuv

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
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, arrayOf(plane), releaseCallback), Buffer32<ArgbBuffer>, BufferFirstAlpha {
    fun convertTo(dst: I400Buffer) {
        Yuv.convertARGBToI400(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: I420Buffer) {
        Yuv.convertARGBToI420(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: I422Buffer) {
        Yuv.convertARGBToI422(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: I444Buffer) {
        Yuv.convertARGBToI444(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: J400Buffer) {
        Yuv.convertARGBToJ400(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstYJ = dst.planeY.buffer, dstStrideYJ = dst.planeY.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: J420Buffer) {
        Yuv.convertARGBToJ420(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstYJ = dst.planeY.buffer, dstStrideYJ = dst.planeY.rowStride,
            dstUJ = dst.planeU.buffer, dstStrideUJ = dst.planeU.rowStride,
            dstVJ = dst.planeV.buffer, dstStrideVJ = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: J422Buffer) {
        Yuv.convertARGBToJ422(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstYJ = dst.planeY.buffer, dstStrideYJ = dst.planeY.rowStride,
            dstUJ = dst.planeU.buffer, dstStrideUJ = dst.planeU.rowStride,
            dstVJ = dst.planeV.buffer, dstStrideVJ = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv12Buffer) {
        Yuv.convertARGBToNV12(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv21Buffer) {
        Yuv.convertARGBToNV21(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstVU = dst.planeVU.buffer, dstStrideVU = dst.planeVU.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        Yuv.convertARGBToABGR(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Argb1555Buffer) {
        Yuv.convertARGBToARGB1555(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB1555 = dst.plane.buffer, dstStrideARGB1555 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Argb4444Buffer) {
        Yuv.convertARGBToARGB4444(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB4444 = dst.plane.buffer, dstStrideARGB4444 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: BgraBuffer) {
        Yuv.convertARGBToBGRA(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstBGRA = dst.plane.buffer, dstStrideBGRA = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: RawBuffer) {
        Yuv.convertARGBToRAW(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstRAW = dst.plane.buffer, dstStrideRAW = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: RgbaBuffer) {
        Yuv.convertARGBToRGBA(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstRGBA = dst.plane.buffer, dstStrideRGBA = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Rgb24Buffer) {
        Yuv.convertARGBToRGB24(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstRGB24 = dst.plane.buffer, dstStrideRGB24 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Rgb565Buffer) {
        Yuv.convertARGBToRGB565(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstRGB565 = dst.plane.buffer, dstStrideRGB565 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Yuy2Buffer) {
        Yuv.convertARGBToYUY2(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstYUY2 = dst.plane.buffer, dstStrideYUY2 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: UyvyBuffer) {
        Yuv.convertARGBToUYVY(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstUYVY = dst.plane.buffer, dstStrideUYVY = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun drawRect(x: Int, y: Int, width: Int, height: Int, value: Long) {
        Yuv.planerARGBRect(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride,
            x = x, y = y,
            width = width, height = height,
            value = value,
        )
    }

    fun drawGrayTo(dst: ArgbBuffer) {
        Yuv.planerARGBGrayTo(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun drawGray(x: Int, y: Int, width: Int, height: Int) {
        Yuv.planerARGBGray(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride,
            x = x, y = y,
            width = width, height = height,
        )
    }

    fun drawSepia(x: Int, y: Int, width: Int, height: Int) {
        Yuv.planerARGBSepia(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride,
            x = x, y = y,
            width = width, height = height,
        )
    }

    fun drawColorMatrix(dst: ArgbBuffer, matrixARGB: ByteArray, width: Int, height: Int) {
        Yuv.planerARGBColorMatrix(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            matrixARGB = matrixARGB,
            width = width, height = height,
        )
    }

    fun drawColorTable(tableARGB: ByteArray, x: Int, y: Int, width: Int, height: Int) {
        Yuv.planerARGBColorTable(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride,
            tableARGB = tableARGB,
            x = x, y = y,
            width = width, height = height,
        )
    }

    fun drawRGBColorTable(tableARGB: ByteArray, x: Int, y: Int, width: Int, height: Int) {
        Yuv.planerARGBColorTable(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride,
            tableARGB = tableARGB,
            x = x, y = y,
            width = width, height = height,
        )
    }

    fun drawLumaColorTable(dst: ArgbBuffer, luma: ByteArray, width: Int, height: Int) {
        Yuv.planerARGBLumaColorTable(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            luma = luma,
            width = width, height = height,
        )
    }

    fun drawPolynomial(dst: ArgbBuffer, poly: FloatArray, width: Int, height: Int) {
        Yuv.planerARGBPolynomial(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            poly = poly,
            width = width, height = height,
        )
    }

    fun drawQuantize(scale: Int, intervalSize: Int, intervalOffset: Int, x: Int, y: Int, width: Int, height: Int) {
        Yuv.planerARGBQuantize(
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride,
            scale = scale,
            intervalSize = intervalSize, intervalOffset = intervalOffset,
            x = x, y = y,
            width = width, height = height,
        )
    }

    fun drawBlendFrom(src1: ArgbBuffer, src2: ArgbBuffer, width: Int, height: Int) {
        Yuv.planerARGBBlend(
            srcARGB0 = src1.plane.buffer, srcStrideARGB0 = src1.plane.rowStride,
            srcARGB1 = src2.plane.buffer, srcStrideARGB1 = src2.plane.rowStride,
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride,
            width = minOf(width, src1.width, src2.width), height = minOf(height, src1.height, src2.height),
        )
    }

    fun drawMultiplyFrom(src1: ArgbBuffer, src2: ArgbBuffer, width: Int, height: Int) {
        Yuv.planerARGBMultiply(
            srcARGB0 = src1.plane.buffer, srcStrideARGB0 = src1.plane.rowStride,
            srcARGB1 = src2.plane.buffer, srcStrideARGB1 = src2.plane.rowStride,
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride,
            width = minOf(width, src1.width, src2.width), height = minOf(height, src1.height, src2.height),
        )
    }

    fun drawAddFrom(src1: ArgbBuffer, src2: ArgbBuffer, width: Int, height: Int) {
        Yuv.planerARGBAdd(
            srcARGB0 = src1.plane.buffer, srcStrideARGB0 = src1.plane.rowStride,
            srcARGB1 = src2.plane.buffer, srcStrideARGB1 = src2.plane.rowStride,
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride,
            width = minOf(width, src1.width, src2.width), height = minOf(height, src1.height, src2.height),
        )
    }

    fun drawSubtractFrom(src1: ArgbBuffer, src2: ArgbBuffer, width: Int, height: Int) {
        Yuv.planerARGBSubtract(
            srcARGB0 = src1.plane.buffer, srcStrideARGB0 = src1.plane.rowStride,
            srcARGB1 = src2.plane.buffer, srcStrideARGB1 = src2.plane.rowStride,
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride,
            width = minOf(width, src1.width, src2.width), height = minOf(height, src1.height, src2.height),
        )
    }

    fun drawBlue(dst: ArgbBuffer, width: Int, height: Int, radius: Int) {
        Yuv.planerARGBBlue(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
            radius = radius,
        )
    }

    fun drawShade(dst: ArgbBuffer, width: Int, height: Int, value: Long) {
        Yuv.planerARGBShade(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
            value = value,
        )
    }

    fun drawInterpolateFrom(src1: ArgbBuffer, src2: ArgbBuffer, width: Int, height: Int, interpolation: Int) {
        Yuv.planerARGBInterpolate(
            srcARGB0 = src1.plane.buffer, srcStrideARGB0 = src1.plane.rowStride,
            srcARGB1 = src2.plane.buffer, srcStrideARGB1 = src2.plane.rowStride,
            dstARGB = plane.buffer, dstStrideARGB = plane.rowStride,
            width = minOf(width, src1.width, src2.width), height = minOf(height, src1.height, src2.height),
            interpolation = interpolation,
        )
    }

    companion object Factory : BufferFactory<ArgbBuffer> {
        internal fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width.shl(2)
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        override fun allocate(width: Int, height: Int): ArgbBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return ArgbBuffer(
                buffer = buffer,
                plane = PlanePrimitive(stride, buffer),
                width = width,
                height = height,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): ArgbBuffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (stride, capacity) = getStrideWithCapacity(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity)
            return ArgbBuffer(
                buffer = buffer,
                plane = PlanePrimitive(stride, sliceBuffer),
                width = width,
                height = height,
                releaseCallback = null,
            )
        }

        fun wrap(plane: Plane, width: Int, height: Int): ArgbBuffer {
            return ArgbBuffer(
                buffer = plane.buffer,
                plane = plane,
                width = width,
                height = height,
                releaseCallback = null,
            )
        }
    }
}
