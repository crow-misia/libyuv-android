package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import android.graphics.Rect
import java.nio.ByteBuffer
import kotlin.math.min

/**
 * ABGR little endian (rgba in memory).
 */
class AbgrBuffer private constructor(
    buffer: ByteBuffer?,
    override val plane: Plane,
    override val width: Int,
    override val height: Int,
    cropRect: Rect,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, cropRect, arrayOf(plane), releaseCallback), BitmapConverter, Buffer32<AbgrBuffer>, BufferFirstAlpha {
    override fun asBitmap(): Bitmap {
        return asBuffer().toBitmap(width, height, Bitmap.Config.ARGB_8888)
    }

    fun convertTo(dst: I420Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertABGRToI420(
            srcABGR = plane.buffer, srcStrideABGR = plane.rowStride, srcOffsetABGR = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: J400Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertABGRToJ400(
            srcABGR = plane.buffer, srcStrideABGR = plane.rowStride, srcOffsetABGR = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: J420Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertABGRToJ420(
            srcABGR = plane.buffer, srcStrideABGR = plane.rowStride, srcOffsetABGR = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: J422Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertABGRToJ422(
            srcABGR = plane.buffer, srcStrideABGR = plane.rowStride, srcOffsetABGR = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Nv12Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertABGRToNV12(
            srcABGR = plane.buffer, srcStrideABGR = plane.rowStride, srcOffsetABGR = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride, dstOffsetUV = dst.planeUV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Nv21Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertABGRToNV21(
            srcABGR = plane.buffer, srcStrideABGR = plane.rowStride, srcOffsetABGR = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstVU = dst.planeVU.buffer, dstStrideVU = dst.planeVU.rowStride, dstOffsetVU = dst.planeVU.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertABGRToARGB(
            srcABGR = plane.buffer, srcStrideABGR = plane.rowStride, srcOffsetABGR = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Rgb24Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToRAW(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstRAW = dst.plane.buffer, dstStrideRAW = dst.plane.rowStride, dstOffsetRAW = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: RawBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBToRGB24(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstRGB24 = dst.plane.buffer, dstStrideRGB24 = dst.plane.rowStride, dstOffsetRGB24 = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    companion object Factory : BufferFactory<AbgrBuffer>, CapacityCalculator<Plane1Capacities> {
        override fun calculate(width: Int, height: Int): Plane1Capacities {
            val stride = width.shl(2)
            return Plane1Capacities(
                planeStride = RowStride(stride),
                planeCapacity = Capacity(stride * height),
            )
        }

        override fun allocate(width: Int, height: Int, cropRect: Rect): AbgrBuffer {
            val (capacity, stride) = calculate(width, height)
            val (buffer) = createByteBuffer(listOf(capacity))
            return AbgrBuffer(
                buffer = buffer,
                plane = PlanePrimitive(stride, buffer),
                width = width,
                height = height,
                cropRect = cropRect,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int, cropRect: Rect): AbgrBuffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacity, stride) = calculate(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity.value)
            return AbgrBuffer(
                buffer = sliceBuffer,
                plane = PlanePrimitive(stride, sliceBuffer),
                width = width,
                height = height,
                cropRect = cropRect,
                releaseCallback = null,
            )
        }

        fun wrap(plane: Plane, width: Int, height: Int, cropRect: Rect): AbgrBuffer {
            return AbgrBuffer(
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
