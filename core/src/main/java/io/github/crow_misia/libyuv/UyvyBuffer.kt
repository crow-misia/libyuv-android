package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.nio.ByteBuffer
import kotlin.math.min

/**
 * UYVY is a packed YUV format with half width, full height.
 *
 * UYVY is UYVY in memory
 */
class UyvyBuffer private constructor(
    buffer: ByteBuffer,
    val plane: Plane,
    override val width: Int,
    override val height: Int,
    cropRect: Rect,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, cropRect, arrayOf(plane), releaseCallback) {
    fun convertTo(dst: I420Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertUYVYToI420(
            srcUYVY = plane.buffer, srcStrideUYVY = plane.rowStride, srcOffsetUYVY = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: I422Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planerUYVYToI422(
            srcUYVY = plane.buffer, srcStrideUYVY = plane.rowStride, srcOffsetUYVY = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertUYVYToARGB(
            srcUYVY = plane.buffer, srcStrideUYVY = plane.rowStride, srcOffsetUYVY = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Nv12Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planerUYVYToNV12(
            srcUYVY = plane.buffer, srcStrideUYVY = plane.rowStride, srcOffsetUYVY = plane.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride, dstOffsetUV = dst.planeUV.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    companion object Factory : BufferFactory<UyvyBuffer>, CapacityCalculator<Plane1Capacities> {
        override fun calculate(width: Int, height: Int): Plane1Capacities {
            val stride = width.shl(1)
            val capacity = stride * height
            return Plane1Capacities(
                planeStride = RowStride(stride),
                planeCapacity = Capacity(capacity),
            )
        }

        override fun allocate(width: Int, height: Int, cropRect: Rect): UyvyBuffer {
            val (capacity, stride) = calculate(width, height)
            val (buffer) = createByteBuffer(listOf(capacity))
            return UyvyBuffer(
                buffer = buffer,
                plane = PlanePrimitive(stride, buffer),
                width = width,
                height = height,
                cropRect = cropRect,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int, cropRect: Rect): UyvyBuffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacity, stride) = calculate(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity.value)
            return UyvyBuffer(
                buffer = sliceBuffer,
                plane = PlanePrimitive(stride, sliceBuffer),
                width = width,
                height = height,
                cropRect = cropRect,
                releaseCallback = null,
            )
        }

        fun wrap(plane: Plane, width: Int, height: Int, cropRect: Rect): UyvyBuffer {
            return UyvyBuffer(
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
