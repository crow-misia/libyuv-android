package io.github.crow_misia.libyuv

import java.nio.ByteBuffer
import kotlin.math.min

/**
 * J400 (jpeg grey) YUV Format. 4:0:0 8bpp
 */
class J400Buffer private constructor(
    buffer: ByteBuffer?,
    crop: Rect,
    override val planeY: Plane,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, crop, arrayOf(planeY), releaseCallback), BufferX400<J400Buffer, J420Buffer>, BufferY<J400Buffer> {
    fun convertTo(dst: ArgbBuffer) {
        Yuv.convertJ400ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    companion object Factory : BufferFactory<J400Buffer>, CapacityCalculator<Plane1Capacities> {
        override fun calculate(width: Int, height: Int): Plane1Capacities {
            return Plane1Capacities(
                planeStride = RowStride(width),
                planeCapacity = Capacity(width * height),
            )
        }

        override fun allocate(width: Int, height: Int): J400Buffer {
            val (capacity, stride) = calculate(width, height)
            val (buffer) = createByteBuffer(listOf(capacity))
            return J400Buffer(
                buffer = buffer,
                crop = Rect(width = width, height = height),
                planeY = PlanePrimitive(stride, buffer),
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): J400Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacity, stride) = calculate(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity.value)
            return J400Buffer(
                buffer = sliceBuffer,
                crop = Rect(width = width, height = height),
                planeY = PlanePrimitive(stride, sliceBuffer),
                releaseCallback = null,
            )
        }

        fun wrap(planeYJ: Plane, width: Int, height: Int): J400Buffer {
            return J400Buffer(
                buffer = planeYJ.buffer,
                crop = Rect(width = width, height = height),
                planeY = planeYJ,
                releaseCallback = null,
            )
        }
    }
}
