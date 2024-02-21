package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.nio.ByteBuffer
import kotlin.math.min

/**
 * AR30 is 2 10 10 10 ARGB stored in little endian order.
 */
class Ar30Buffer private constructor(
    buffer: ByteBuffer,
    override val plane: Plane,
    override val width: Int,
    override val height: Int,
    cropRect: Rect,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, cropRect, arrayOf(plane), releaseCallback), Buffer32<Ar30Buffer> {
    fun convertTo(dst: Ab30Buffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertAR30ToAB30(
            srcAR30 = plane.buffer, srcStrideAR30 = plane.rowStride, srcOffsetAR30 = plane.offset,
            dstAB30 = dst.plane.buffer, dstStrideAB30 = dst.plane.rowStride, dstOffsetAB30 = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertAR30ToABGR(
            srcAR30 = plane.buffer, srcStrideAR30 = plane.rowStride, srcOffsetAR30 = plane.offset,
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride, dstOffsetABGR = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertAR30ToARGB(
            srcAR30 = plane.buffer, srcStrideAR30 = plane.rowStride, srcOffsetAR30 = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    companion object Factory : BufferFactory<Ar30Buffer>, CapacityCalculator<Plane1Capacities> {
        override fun calculate(width: Int, height: Int): Plane1Capacities {
            val stride = width.shl(2)
            return Plane1Capacities(
                planeStride = RowStride(stride),
                planeCapacity = Capacity(stride * height),
            )
        }

        override fun allocate(width: Int, height: Int, cropRect: Rect): Ar30Buffer {
            val (capacity, stride) = calculate(width, height)
            val (buffer) = createByteBuffer(listOf(capacity))
            return Ar30Buffer(
                buffer = buffer,
                plane = PlanePrimitive(stride, buffer),
                width = width,
                height = height,
                cropRect = cropRect,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int, cropRect: Rect): Ar30Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacity, stride) = calculate(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity.value)
            return Ar30Buffer(
                buffer = sliceBuffer,
                plane = PlanePrimitive(stride, sliceBuffer),
                width = width,
                height = height,
                cropRect = cropRect,
                releaseCallback = null,
            )
        }

        fun wrap(plane: Plane, width: Int, height: Int, cropRect: Rect): Ar30Buffer {
            return Ar30Buffer(
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
