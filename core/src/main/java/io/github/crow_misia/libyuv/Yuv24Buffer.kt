package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.nio.ByteBuffer

/**
 * YUV 24bpp
 */
class Yuv24Buffer private constructor(
    buffer: ByteBuffer?,
    override val plane: Plane,
    override val width: Int,
    override val height: Int,
    cropRect: Rect,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, cropRect, arrayOf(plane), releaseCallback), Buffer24<Yuv24Buffer> {
    override fun getPlaneOffset(planeIndex: Int, rowStride: RowStride, left: Int, top: Int): Int {
        return rowStride * top + left * 3
    }

    companion object Factory : BufferFactory<Yuv24Buffer>, CapacityCalculator<Plane1Capacities> {
        override fun calculate(width: Int, height: Int): Plane1Capacities {
            val stride = width * 3
            val capacity = stride * height
            return Plane1Capacities(
                planeStride = RowStride(stride),
                planeCapacity = Capacity(capacity),
            )
        }

        override fun allocate(width: Int, height: Int, cropRect: Rect): Yuv24Buffer {
            val (capacity, stride) = calculate(width, height)
            val (buffer) = createByteBuffer(listOf(capacity))
            return Yuv24Buffer(
                buffer = buffer,
                plane = PlanePrimitive(stride, buffer),
                width = width,
                height = height,
                cropRect = cropRect,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int, cropRect: Rect): Yuv24Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacity, stride) = calculate(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity.value)
            return Yuv24Buffer(
                buffer = sliceBuffer,
                plane = PlanePrimitive(stride, sliceBuffer),
                width = width,
                height = height,
                cropRect = cropRect,
                releaseCallback = null,
            )
        }

        fun wrap(plane: Plane, width: Int, height: Int, cropRect: Rect): Yuv24Buffer {
            return Yuv24Buffer(
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
