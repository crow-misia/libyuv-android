package io.github.crow_misia.libyuv

import java.nio.ByteBuffer
import kotlin.math.min

/**
 * NV21 YUV Format. 4:2:0 12bpp
 */
class Nv21Buffer private constructor(
    buffer: ByteBuffer?,
    val planeY: Plane,
    val planeVU: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, arrayOf(planeY, planeVU), releaseCallback) {
    fun convertTo(dst: I400Buffer) {
        Yuv.convertI400Copy(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: I420Buffer) {
        Yuv.convertNV21ToI420(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv12Buffer) {
        Yuv.planerNV21ToNV12(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv21Buffer) {
        Yuv.planerNV12Copy(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstUV = dst.planeVU.buffer, dstStrideUV = dst.planeVU.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        Yuv.convertNV21ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        Yuv.convertNV21ToABGR(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride,
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Rgb24Buffer) {
        Yuv.convertNV21ToRGB24(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride,
            dstRGB24 = dst.plane.buffer, dstStrideRGB24 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Yuv24Buffer) {
        Yuv.convertNV21ToYUV24(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride,
            dstYUV24 = dst.plane.buffer, dstStrideYUV24 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: RawBuffer) {
        Yuv.convertNV21ToRAW(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride,
            dstRAW = dst.plane.buffer, dstStrideRAW = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun mirrorTo(dst: Nv21Buffer) {
        Yuv.planerNV12Mirror(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcUV = planeVU.buffer, srcStrideUV = planeVU.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstUV = dst.planeVU.buffer, dstStrideUV = dst.planeVU.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun rotate(dst: I420Buffer, rotateMode: RotateMode) {
        Yuv.rotateNV12ToI420Rotate(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcUV = planeVU.buffer, srcStrideUV = planeVU.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeV.buffer, dstStrideU = dst.planeV.rowStride,
            dstV = dst.planeU.buffer, dstStrideV = dst.planeU.rowStride,
            width = rotateMode.calculateWidth(this, dst),
            height = rotateMode.calculateHeight(this, dst),
            rotateMode = rotateMode.degrees,
        )
    }

    fun rotate(dst: Nv12Buffer, rotateMode: RotateMode) {
        Yuv.rotateNV12ToNV21Rotate(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcUV = planeVU.buffer, srcStrideUV = planeVU.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstVU = dst.planeUV.buffer, dstStrideVU = dst.planeUV.rowStride,
            width = rotateMode.calculateWidth(this, dst),
            height = rotateMode.calculateHeight(this, dst),
            rotateMode = rotateMode.degrees,
        )
    }

    fun rotate(dst: Nv21Buffer, rotateMode: RotateMode) {
        Yuv.rotateNV21Rotate(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstVU = dst.planeVU.buffer, dstStrideVU = dst.planeVU.rowStride,
            width = rotateMode.calculateWidth(this, dst),
            height = rotateMode.calculateHeight(this, dst),
            rotateMode = rotateMode.degrees,
        )
    }

    fun scale(dst: Nv21Buffer, filterMode: FilterMode) {
        Yuv.scaleNV12Scale(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcUV = planeVU.buffer, srcStrideUV = planeVU.rowStride,
            srcWidth = width, srcHeight = height,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstUV = dst.planeVU.buffer, dstStrideUV = dst.planeVU.rowStride,
            dstWidth = dst.width, dstHeight = dst.height,
            filterMode = filterMode.mode,
        )
    }

    companion object Factory : BufferFactory<Nv21Buffer> {
        private fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val capacityY = width * height
            val capacityVU = (width + 1).shr(1) * height
            return intArrayOf(width, capacityY, width, capacityVU)
        }

        override fun allocate(width: Int, height: Int): Nv21Buffer {
            val (strideY, capacityY, strideVU, capacityVU) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacityY + capacityVU)
            val (bufferY, bufferVU) = buffer.slice(capacityY, capacityVU)
            return Nv21Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeVU = PlanePrimitive(strideVU, bufferVU),
                width = width,
                height = height,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): Nv21Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (strideY, capacityY, strideVU, capacityVU) = getStrideWithCapacity(width, height)
            val (bufferY, bufferVU) = buffer.slice(capacityY, capacityVU)
            return Nv21Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeVU = PlanePrimitive(strideVU, bufferVU),
                width = width,
                height = height,
                releaseCallback = null,
            )
        }

        fun wrap(planeY: Plane, planeVU: Plane, width: Int, height: Int): Nv21Buffer {
            return Nv21Buffer(
                buffer = null,
                planeY = planeY,
                planeVU = planeVU,
                width = width,
                height = height,
                releaseCallback = null,
            )
        }
    }
}
