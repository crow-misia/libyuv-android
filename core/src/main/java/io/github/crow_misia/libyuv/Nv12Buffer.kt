package io.github.crow_misia.libyuv

import java.nio.ByteBuffer
import kotlin.math.min

/**
 * NV12 YUV Format. 4:2:0 12bpp
 */
class Nv12Buffer private constructor(
    buffer: ByteBuffer?,
    val planeY: Plane,
    val planeUV: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, arrayOf(planeY, planeUV), releaseCallback) {
    fun convertTo(dst: I400Buffer) {
        Yuv.convertI400Copy(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: I420Buffer) {
        Yuv.convertNV12ToI420(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcUV = planeUV.buffer, srcStrideUV = planeUV.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv12Buffer) {
        Yuv.planerNV12Copy(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcVU = planeUV.buffer, srcStrideVU = planeUV.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv21Buffer) {
        Yuv.planerNV21ToNV12(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcVU = planeUV.buffer, srcStrideVU = planeUV.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstUV = dst.planeVU.buffer, dstStrideUV = dst.planeVU.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        Yuv.convertNV12ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcUV = planeUV.buffer, srcStrideUV = planeUV.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        Yuv.convertNV12ToABGR(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcUV = planeUV.buffer, srcStrideUV = planeUV.rowStride,
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Rgb24Buffer) {
        Yuv.convertNV12ToRGB24(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcUV = planeUV.buffer, srcStrideUV = planeUV.rowStride,
            dstRGB24 = dst.plane.buffer, dstStrideRGB24 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: RawBuffer) {
        Yuv.convertNV12ToRAW(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcUV = planeUV.buffer, srcStrideUV = planeUV.rowStride,
            dstRAW = dst.plane.buffer, dstStrideRAW = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Rgb565Buffer) {
        Yuv.convertNV12ToRGB565(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcUV = planeUV.buffer, srcStrideUV = planeUV.rowStride,
            dstRGB565 = dst.plane.buffer, dstStrideRGB565 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun mirrorTo(dst: Nv12Buffer) {
        Yuv.planerNV12Mirror(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcUV = planeUV.buffer, srcStrideUV = planeUV.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun rotate(dst: I420Buffer, rotateMode: RotateMode) {
        Yuv.rotateNV12ToI420Rotate(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcUV = planeUV.buffer, srcStrideUV = planeUV.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = rotateMode.calculateWidth(this, dst),
            height = rotateMode.calculateHeight(this, dst),
            rotateMode = rotateMode.degrees,
        )
    }

    fun rotate(dst: Nv12Buffer, rotateMode: RotateMode) {
        Yuv.rotateNV12Rotate(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcUV = planeUV.buffer, srcStrideUV = planeUV.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride,
            width = rotateMode.calculateWidth(this, dst),
            height = rotateMode.calculateHeight(this, dst),
            rotateMode = rotateMode.degrees,
        )
    }

    fun rotate(dst: Nv21Buffer, rotateMode: RotateMode) {
        Yuv.rotateNV12ToNV21Rotate(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcUV = planeUV.buffer, srcStrideUV = planeUV.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstVU = dst.planeVU.buffer, dstStrideVU = dst.planeVU.rowStride,
            width = rotateMode.calculateWidth(this, dst),
            height = rotateMode.calculateHeight(this, dst),
            rotateMode = rotateMode.degrees,
        )
    }

    fun scale(dst: Nv12Buffer, filterMode: FilterMode) {
        Yuv.scaleNV12Scale(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcUV = planeUV.buffer, srcStrideUV = planeUV.rowStride,
            srcWidth = width, srcHeight = height,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride,
            dstWidth = dst.width, dstHeight = dst.height,
            filterMode = filterMode.mode,
        )
    }

    companion object Factory : BufferFactory<Nv12Buffer> {
        private fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val capacityY = width * height
            val capacityUV = (width + 1).shr(1) * height
            return intArrayOf(width, capacityY, width, capacityUV)
        }

        override fun allocate(width: Int, height: Int): Nv12Buffer {
            val (strideY, capacityY, strideUV, capacityUV) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacityY + capacityUV)
            val (bufferY, bufferUV) = buffer.slice(capacityY, capacityUV)
            return Nv12Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeUV = PlanePrimitive(strideUV, bufferUV),
                width = width,
                height = height,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): Nv12Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (strideY, capacityY, strideUV, capacityUV) = getStrideWithCapacity(width, height)
            val (bufferY, bufferUV) = buffer.slice(capacityY, capacityUV)
            return Nv12Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeUV = PlanePrimitive(strideUV, bufferUV),
                width = width,
                height = height,
                releaseCallback = null,
            )
        }

        fun wrap(planeY: Plane, planeUV: Plane, width: Int, height: Int): Nv12Buffer {
            return Nv12Buffer(
                buffer = null,
                planeY = planeY,
                planeUV = planeUV,
                width = width,
                height = height,
                releaseCallback = null,
            )
        }

    }
}
