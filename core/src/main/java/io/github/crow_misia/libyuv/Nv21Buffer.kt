package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.nio.ByteBuffer

/**
 * NV21 YUV Format. 4:2:0 12bpp
 */
class Nv21Buffer private constructor(
    buffer: ByteBuffer?,
    override val planeY: Plane,
    val planeVU: Plane,
    override val width: Int,
    override val height: Int,
    cropRect: Rect,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, cropRect, arrayOf(planeY, planeVU), releaseCallback), BufferY<I400Buffer> {
    override fun getPlaneOffset(planeIndex: Int, rowStride: RowStride, left: Int, top: Int): Int {
        return when (planeIndex) {
            0 -> rowStride * top + left
            else -> {
                val halfLeft = (left + 1).shr(1)
                rowStride * top + halfLeft
            }
        }
    }

    fun convertTo(dst: I420Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertNV21ToI420(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride, srcOffsetVU = offset(1),
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.offset(0),
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.offset(1),
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.offset(1),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Nv12Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planarNV21ToNV12(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride, srcOffsetVU = offset(1),
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.offset(0),
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride, dstOffsetUV = dst.offset(1),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Nv21Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planarNV12Copy(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcUV = planeVU.buffer, srcStrideUV = planeVU.rowStride, srcOffsetUV = offset(1),
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.offset(0),
            dstUV = dst.planeVU.buffer, dstStrideUV = dst.planeVU.rowStride, dstOffsetUV = dst.offset(1),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertNV21ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride, srcOffsetVU = offset(1),
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertNV21ToABGR(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride, srcOffsetVU = offset(1),
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride, dstOffsetABGR = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Rgb24Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertNV21ToRGB24(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride, srcOffsetVU = offset(1),
            dstRGB24 = dst.plane.buffer, dstStrideRGB24 = dst.plane.rowStride, dstOffsetRGB24 = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Yuv24Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertNV21ToYUV24(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride, srcOffsetVU = offset(1),
            dstYUV24 = dst.plane.buffer, dstStrideYUV24 = dst.plane.rowStride, dstOffsetYUV24 = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: RawBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertNV21ToRAW(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride, srcOffsetVU = offset(1),
            dstRAW = dst.plane.buffer, dstStrideRAW = dst.plane.rowStride, dstOffsetRAW = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun mirrorTo(dst: Nv21Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planarNV12Mirror(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcUV = planeVU.buffer, srcStrideUV = planeVU.rowStride, srcOffsetUV = offset(1),
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.offset(0),
            dstUV = dst.planeVU.buffer, dstStrideUV = dst.planeVU.rowStride, dstOffsetUV = dst.offset(1),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun rotate(dst: I420Buffer, rotateMode: RotateMode) {
        Yuv.rotateNV12ToI420Rotate(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcUV = planeVU.buffer, srcStrideUV = planeVU.rowStride, srcOffsetUV = offset(1),
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.offset(0),
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.offset(1),
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.offset(1),
            width = rotateMode.calculateWidth(this, dst),
            height = rotateMode.calculateHeight(this, dst),
            rotateMode = rotateMode.degrees,
        )
    }

    fun rotate(dst: Nv12Buffer, rotateMode: RotateMode) {
        Yuv.rotateNV12ToNV21Rotate(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcUV = planeVU.buffer, srcStrideUV = planeVU.rowStride, srcOffsetUV = offset(1),
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.offset(0),
            dstVU = dst.planeUV.buffer, dstStrideVU = dst.planeUV.rowStride, dstOffsetVU = dst.offset(1),
            width = rotateMode.calculateWidth(this, dst),
            height = rotateMode.calculateHeight(this, dst),
            rotateMode = rotateMode.degrees,
        )
    }

    fun rotate(dst: Nv21Buffer, rotateMode: RotateMode) {
        Yuv.rotateNV21Rotate(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcVU = planeVU.buffer, srcStrideVU = planeVU.rowStride, srcOffsetVU = offset(1),
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.offset(0),
            dstVU = dst.planeVU.buffer, dstStrideVU = dst.planeVU.rowStride, dstOffsetVU = dst.offset(1),
            width = rotateMode.calculateWidth(this, dst),
            height = rotateMode.calculateHeight(this, dst),
            rotateMode = rotateMode.degrees,
        )
    }

    fun scale(dst: Nv21Buffer, filterMode: FilterMode) {
        Yuv.scaleNV12Scale(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcUV = planeVU.buffer, srcStrideUV = planeVU.rowStride, srcOffsetUV = offset(1),
            srcWidth = cropRect.width(), srcHeight = cropRect.height(),
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.offset(0),
            dstUV = dst.planeVU.buffer, dstStrideUV = dst.planeVU.rowStride, dstOffsetUV = dst.offset(1),
            dstWidth = dst.cropRect.width(), dstHeight = dst.cropRect.height(),
            filterMode = filterMode.mode,
        )
    }

    companion object Factory : BufferFactory<Nv21Buffer>, CapacityCalculator<Plane2Capacities> {
        override fun calculate(width: Int, height: Int): Plane2Capacities {
            val halfWidth = (width + 1).shr(1)
            val capacityY = width * height
            val capacityVU = halfWidth * height
            return Plane2Capacities(
                plane1Stride = RowStride(width),
                plane2Stride = RowStride(width),
                plane1Capacity = Capacity(capacityY),
                plane2Capacity = Capacity(capacityVU),
            )
        }

        override fun allocate(width: Int, height: Int, cropRect: Rect): Nv21Buffer {
            val (capacityY, capacityVU, strideY, strideVU) = calculate(width, height)
            val (bufferY, bufferVU, buffer) = createByteBuffer(listOf(capacityY, capacityVU))
            return Nv21Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeVU = PlanePrimitive(strideVU, bufferVU),
                width = width,
                height = height,
                cropRect = cropRect,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int, cropRect: Rect): Nv21Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacityY, capacityVU, strideY, strideVU) = calculate(width, height)
            val (bufferY, bufferVU) = buffer.sliceByLength(listOf(capacityY, capacityVU))
            return Nv21Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeVU = PlanePrimitive(strideVU, bufferVU),
                width = width,
                height = height,
                cropRect = cropRect,
                releaseCallback = null,
            )
        }

        fun wrap(planeY: Plane, planeUV: Plane, width: Int, height: Int): Nv21Buffer {
            return wrap(planeY, planeUV, width, height, Rect(0, 0, width, height))
        }

        fun wrap(planeY: Plane, planeVU: Plane, width: Int, height: Int, cropRect: Rect): Nv21Buffer {
            return Nv21Buffer(
                buffer = null,
                planeY = planeY,
                planeVU = planeVU,
                width = width,
                height = height,
                cropRect = cropRect,
                releaseCallback = null,
            )
        }
    }
}
