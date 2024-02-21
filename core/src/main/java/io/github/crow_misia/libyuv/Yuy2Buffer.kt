package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.nio.ByteBuffer

/**
 * YUY2 is a packed YUV format with half width, full height.
 *
 * YUY2 is YUYV in memory
 */
class Yuy2Buffer private constructor(
    buffer: ByteBuffer,
    val plane: Plane,
    override val width: Int,
    override val height: Int,
    cropRect: Rect,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, cropRect, arrayOf(plane), releaseCallback) {
    override fun getPlaneOffset(planeIndex: Int, rowStride: RowStride, left: Int, top: Int): Int {
        return rowStride * top + left.shl(1)
    }

    fun convertTo(dst: I420Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertYUY2ToI420(
            srcYUY2 = plane.buffer, srcStrideYUY2 = plane.rowStride, srcOffsetYUY2 = offset(0),
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.offset(0),
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.offset(1),
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.offset(2),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: I422Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planerYUY2ToI422(
            srcYUY2 = plane.buffer, srcStrideYUY2 = plane.rowStride, srcOffsetYUY2 = offset(0),
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.offset(0),
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.offset(1),
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.offset(2),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertYUY2ToARGB(
            srcYUY2 = plane.buffer, srcStrideYUY2 = plane.rowStride, srcOffsetYUY2 = offset(0),
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: Nv12Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planerYUY2ToNV12(
            srcYUY2 = plane.buffer, srcStrideYUY2 = plane.rowStride, srcOffsetYUY2 = offset(0),
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.offset(0),
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride, dstOffsetUV = dst.offset(1),
            width = fixedWidth, height = fixedHeight,
        )
    }

    companion object Factory : BufferFactory<Yuy2Buffer>, CapacityCalculator<Plane1Capacities> {
        override fun calculate(width: Int, height: Int): Plane1Capacities {
            val stride = width.shl(1)
            val capacity = stride * height
            return Plane1Capacities(
                planeStride = RowStride(stride),
                planeCapacity = Capacity(capacity),
            )
        }

        override fun allocate(width: Int, height: Int, cropRect: Rect): Yuy2Buffer {
            val (capacity, stride) = calculate(width, height)
            val (buffer) = createByteBuffer(listOf(capacity))
            return Yuy2Buffer(
                buffer = buffer,
                plane = PlanePrimitive(stride, buffer),
                width = width,
                height = height,
                cropRect = cropRect,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int, cropRect: Rect): Yuy2Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacity, stride) = calculate(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity.value)
            return Yuy2Buffer(
                buffer = sliceBuffer,
                plane = PlanePrimitive(stride, sliceBuffer),
                width = width,
                height = height,
                cropRect = cropRect,
                releaseCallback = null,
            )
        }

        fun wrap(plane: Plane, width: Int, height: Int, cropRect: Rect): Yuy2Buffer {
            return Yuy2Buffer(
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
