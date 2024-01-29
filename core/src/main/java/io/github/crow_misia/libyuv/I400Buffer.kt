package io.github.crow_misia.libyuv

import java.nio.ByteBuffer
import kotlin.math.min

/**
 * I400 (grey) YUV Format. 4:0:0 8bpp
 */
class I400Buffer private constructor(
    buffer: ByteBuffer?,
    crop: Rect,
    override val planeY: Plane,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, crop, arrayOf(planeY), releaseCallback), BufferX400<I400Buffer, I420Buffer>, BufferY<I400Buffer> {
    fun convertTo(dst: Nv21Buffer) {
        Yuv.convertI400ToNV21(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstVU = dst.planeVU.buffer, dstStrideVU = dst.planeVU.rowStride, dstOffsetVU = dst.planeVU.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv12Buffer) {
        Yuv.convertI400ToNV21(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstVU = dst.planeUV.buffer, dstStrideVU = dst.planeUV.rowStride, dstOffsetVU = dst.planeUV.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        Yuv.convertI400ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun setValue(value: Int) {
        planeY.setValue(width, height, value)
    }

    companion object Factory : BufferFactory<I400Buffer>, CapacityCalculator<Plane1Capacities> {
        override fun calculate(width: Int, height: Int): Plane1Capacities {
            return Plane1Capacities(
                planeStride = RowStride(width),
                planeCapacity = Capacity(width * height),
            )
        }

        override fun allocate(width: Int, height: Int): I400Buffer {
            val (capacity, stride) = calculate(width, height)
            val (buffer) = createByteBuffer(listOf(capacity))
            return I400Buffer(
                buffer = buffer,
                crop = Rect(width = width, height = height),
                planeY = PlanePrimitive(stride, buffer),
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): I400Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (capacity, stride) = calculate(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity.value)
            return I400Buffer(
                buffer = sliceBuffer,
                crop = Rect(width = width, height = height),
                planeY = PlanePrimitive(stride, sliceBuffer),
                releaseCallback = null,
            )
        }

        fun wrap(planeY: Plane, width: Int, height: Int): I400Buffer {
            return I400Buffer(
                buffer = planeY.buffer,
                crop = Rect(width = width, height = height),
                planeY = planeY,
                releaseCallback = null,
            )
        }
    }
}
