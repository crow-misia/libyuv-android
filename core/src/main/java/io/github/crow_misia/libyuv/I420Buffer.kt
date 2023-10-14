package io.github.crow_misia.libyuv

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
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, arrayOf(planeY, planeU, planeV), releaseCallback), BufferX420<I420Buffer>, BufferY<I400Buffer> {
    fun convertTo(dst: I422Buffer) {
        Yuv.convertI420ToI422(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: I444Buffer) {
        Yuv.convertI420ToI444(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv12Buffer) {
        Yuv.convertI420ToNV12(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv21Buffer) {
        Yuv.convertI420ToNV21(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstVU = dst.planeVU.buffer, dstStrideVU = dst.planeVU.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        Yuv.convertI420ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: BgraBuffer) {
        Yuv.convertI420ToBGRA(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstBGRA = dst.plane.buffer, dstStrideBGRA = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        Yuv.convertI420ToABGR(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: RgbaBuffer) {
        Yuv.convertI420ToRGBA(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstRGBA = dst.plane.buffer, dstStrideRGBA = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Rgb24Buffer) {
        Yuv.convertI420ToRGB24(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstRGB24 = dst.plane.buffer, dstStrideRGB24 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: RawBuffer) {
        Yuv.convertI420ToRAW(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstRAW = dst.plane.buffer, dstStrideRAW = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Rgb565Buffer) {
        Yuv.convertI420ToRGB565(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstRGB565 = dst.plane.buffer, dstStrideRGB565 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Argb1555Buffer) {
        Yuv.convertI420ToARGB1555(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstARGB1555 = dst.plane.buffer, dstStrideARGB1555 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Argb4444Buffer) {
        Yuv.convertI420ToARGB4444(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstARGB4444 = dst.plane.buffer, dstStrideARGB4444 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Ar30Buffer) {
        Yuv.convertI420ToAR30(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstAR30 = dst.plane.buffer, dstStrideAR30 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Ab30Buffer) {
        Yuv.convertI420ToAB30(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstAB30 = dst.plane.buffer, dstStrideAB30 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Yuy2Buffer) {
        Yuv.convertI420ToYUY2(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstYUY2 = dst.plane.buffer, dstStrideYUY2 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: UyvyBuffer) {
        Yuv.convertI420ToUYVY(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstUYVY = dst.plane.buffer, dstStrideUYVY = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun drawRect(x: Int, y: Int, width: Int, height: Int, valueY: Int, valueU: Int, valueV: Int) {
        Yuv.planerI420Rect(
            dstY = planeY.buffer, dstStrideY = planeY.rowStride,
            dstU = planeU.buffer, dstStrideU = planeU.rowStride,
            dstV = planeV.buffer, dstStrideV = planeV.rowStride,
            x = x, y = y,
            width = width, height = height,
            valueY = valueY, valueU = valueU, valueV = valueV,
        )
    }

    fun drawBlendFrom(src1: I420Buffer, srcAPlane: Plane, src2: I420Buffer, width: Int, height: Int) {
        Yuv.planerI420Blend(
            srcY0 = src1.planeY.buffer, srcStrideY0 = src1.planeY.rowStride,
            srcU0 = src1.planeU.buffer, srcStrideU0 = src1.planeU.rowStride,
            srcV0 = src1.planeV.buffer, srcStrideV0 = src1.planeV.rowStride,
            srcY1 = src2.planeY.buffer, srcStrideY1 = src2.planeY.rowStride,
            srcU1 = src2.planeU.buffer, srcStrideU1 = src2.planeU.rowStride,
            srcV1 = src2.planeV.buffer, srcStrideV1 = src2.planeV.rowStride,
            srcA = srcAPlane.buffer, srcStrideA = srcAPlane.rowStride,
            dstY = planeY.buffer, dstStrideY = planeY.rowStride,
            dstU = planeU.buffer, dstStrideU = planeU.rowStride,
            dstV = planeV.buffer, dstStrideV = planeV.rowStride,
            width = minOf(width, src1.width, src2.width), height = minOf(height, src1.height, src2.height),
        )
    }

    fun drawInterpolateFrom(src1: I420Buffer, src2: I420Buffer, width: Int, height: Int, interpolation: Int) {
        Yuv.planerI420Interpolate(
            srcY0 = src1.planeY.buffer, srcStrideY0 = src1.planeY.rowStride,
            srcU0 = src1.planeU.buffer, srcStrideU0 = src1.planeU.rowStride,
            srcV0 = src1.planeV.buffer, srcStrideV0 = src1.planeV.rowStride,
            srcY1 = src2.planeY.buffer, srcStrideY1 = src2.planeY.rowStride,
            srcU1 = src2.planeU.buffer, srcStrideU1 = src2.planeU.rowStride,
            srcV1 = src2.planeV.buffer, srcStrideV1 = src2.planeV.rowStride,
            dstY = planeY.buffer, dstStrideY = planeY.rowStride,
            dstU = planeU.buffer, dstStrideU = planeU.rowStride,
            dstV = planeV.buffer, dstStrideV = planeV.rowStride,
            width = minOf(width, src1.width, src2.width), height = minOf(height, src1.height, src2.height),
            interpolation = interpolation,
        )
    }

    companion object Factory : BufferFactory<I420Buffer> {
        private fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val halfWidth = (width + 1).shr(1)
            val halfHeight = (height + 1).shr(1)
            val capacity = width * height
            val halfCapacity = halfWidth * halfHeight
            return intArrayOf(width, capacity, halfWidth, halfCapacity, halfWidth, halfCapacity)
        }

        override fun allocate(width: Int, height: Int): I420Buffer {
            val (strideY, capacityY, strideU, capacityU, strideV, capacityV) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacityY + capacityU + capacityV)
            val (bufferY, bufferU, bufferV) = buffer.sliceByLength(capacityY, capacityU, capacityV)
            return I420Buffer(
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

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): I420Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (strideY, capacityY, strideU, capacityU, strideV, capacityV) = getStrideWithCapacity(width, height)
            val (bufferY, bufferU, bufferV) = buffer.sliceByLength(capacityY, capacityU, capacityV)
            return I420Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeU = PlanePrimitive(strideU, bufferU),
                planeV = PlanePrimitive(strideV, bufferV),
                width = width,
                height = height,
                releaseCallback = null,
            )
        }

        fun wrap(planeY: Plane, planeU: Plane, planeV: Plane, width: Int, height: Int): I420Buffer {
            return I420Buffer(
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
