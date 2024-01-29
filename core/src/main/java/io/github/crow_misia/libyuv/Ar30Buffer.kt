package io.github.crow_misia.libyuv

import java.nio.ByteBuffer
import kotlin.math.min

/**
 * AR30 is 2 10 10 10 ARGB stored in little endian order.
 */
class Ar30Buffer private constructor(
    buffer: ByteBuffer,
    crop: Rect,
    val plane: Plane,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, crop, arrayOf(plane), releaseCallback) {
    fun convertTo(dst: Ab30Buffer) {
        Yuv.convertAR30ToAB30(
            srcAR30 = plane.buffer, srcStrideAR30 = plane.rowStride, srcOffsetAR30 = plane.offset,
            dstAB30 = dst.plane.buffer, dstStrideAB30 = dst.plane.rowStride, dstOffsetAB30 = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        Yuv.convertAR30ToABGR(
            srcAR30 = plane.buffer, srcStrideAR30 = plane.rowStride, srcOffsetAR30 = plane.offset,
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride, dstOffsetABGR = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        Yuv.convertAR30ToARGB(
            srcAR30 = plane.buffer, srcStrideAR30 = plane.rowStride, srcOffsetAR30 = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
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

        override fun allocate(width: Int, height: Int): Ar30Buffer {
            val (capacity, stride) = calculate(width, height)
            val (buffer) = createByteBuffer(listOf(capacity))
            return Ar30Buffer(
                buffer = buffer,
                crop = Rect(width = width, height = height),
                plane = PlanePrimitive(stride, buffer),
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): Ar30Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacity, stride) = calculate(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity.value)
            return Ar30Buffer(
                buffer = sliceBuffer,
                crop = Rect(width = width, height = height),
                plane = PlanePrimitive(stride, sliceBuffer),
                releaseCallback = null,
            )
        }

        fun wrap(plane: Plane, width: Int, height: Int): Ar30Buffer {
            return Ar30Buffer(
                buffer = plane.buffer,
                crop = Rect(width = width, height = height),
                plane = plane,
                releaseCallback = null,
            )
        }
    }
}
