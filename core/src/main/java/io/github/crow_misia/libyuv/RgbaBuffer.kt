package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.nio.ByteBuffer
import kotlin.math.min

/**
 * RGBA little endian (abgr in memory)
 */
class RgbaBuffer private constructor(
    buffer: ByteBuffer,
    override val plane: Plane,
    override val width: Int,
    override val height: Int,
    cropRect: Rect,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, cropRect, arrayOf(plane), releaseCallback), Buffer32<RgbaBuffer> {
    fun convertTo(dst: I420Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertRGBAToI420(
            srcRGBA = plane.buffer, srcStrideRGBA = plane.rowStride, srcOffsetRGBA = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: J400Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertRGBAToJ400(
            srcRGBA = plane.buffer, srcStrideRGBA = plane.rowStride, srcOffsetRGBA = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertRGBAToARGB(
            srcRGBA = plane.buffer, srcStrideRGBA = plane.rowStride, srcOffsetRGBA = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    companion object Factory : BufferFactory<RgbaBuffer>, CapacityCalculator<Plane1Capacities> {
        override fun calculate(width: Int, height: Int): Plane1Capacities {
            val stride = width.shl(2)
            return Plane1Capacities(
                planeStride = RowStride(stride),
                planeCapacity = Capacity(stride * height),
            )
        }

        override fun allocate(width: Int, height: Int, cropRect: Rect): RgbaBuffer {
            val (capacity, stride) = calculate(width, height)
            val (buffer) = createByteBuffer(listOf(capacity))
            return RgbaBuffer(
                buffer = buffer,
                plane = PlanePrimitive(stride, buffer),
                width = width,
                height = height,
                cropRect = cropRect,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int, cropRect: Rect): RgbaBuffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacity, stride) = calculate(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity.value)
            return RgbaBuffer(
                buffer = sliceBuffer,
                plane = PlanePrimitive(stride, sliceBuffer),
                width = width,
                height = height,
                cropRect = cropRect,
                releaseCallback = null,
            )
        }

        fun wrap(plane: Plane, width: Int, height: Int, cropRect: Rect): RgbaBuffer {
            return RgbaBuffer(
                buffer = plane.buffer,
                width = width,
                height = height,
                cropRect = cropRect,
                plane = plane,
                releaseCallback = null,
            )
        }
    }
}
