package io.github.crow_misia.libyuv

import java.nio.ByteBuffer
import kotlin.math.min

/**
 * RGB big endian (rgb in memory)
 */
class RawBuffer private constructor(
    buffer: ByteBuffer?,
    crop: Rect,
    override val plane: Plane,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, crop, arrayOf(plane), releaseCallback), Buffer24<RawBuffer> {
    fun convertTo(dst: I420Buffer) {
        Yuv.convertRAWToI420(
            srcRAW = plane.buffer, srcStrideRAW = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: J400Buffer) {
        Yuv.convertRAWToJ400(
            srcRAW = plane.buffer, srcStrideRAW = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: J420Buffer) {
        Yuv.convertRAWToJ420(
            srcRAW = plane.buffer, srcStrideRAW = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        Yuv.convertRAWToARGB(
            srcRAW = plane.buffer, srcStrideRAW = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: RgbaBuffer) {
        Yuv.convertRAWToRGBA(
            srcRAW = plane.buffer, srcStrideRAW = plane.rowStride,
            dstRGBA = dst.plane.buffer, dstStrideRGBA = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Rgb24Buffer) {
        Yuv.planerRAWToRGB24(
            srcRAW = plane.buffer, srcStrideRAW = plane.rowStride,
            dstRGB24 = dst.plane.buffer, dstStrideRGB24 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    companion object Factory : BufferFactory<RawBuffer> {
        private fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width * 3
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        override fun allocate(width: Int, height: Int): RawBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return RawBuffer(
                buffer = buffer,
                crop = Rect(width = width, height = height),
                plane = PlanePrimitive(stride, buffer),
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): RawBuffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (stride, capacity) = getStrideWithCapacity(width, height)
            return RawBuffer(
                buffer = buffer,
                crop = Rect(width = width, height = height),
                plane = PlanePrimitive(stride, buffer.sliceRange(0, capacity)),
                releaseCallback = null,
            )
        }

        fun wrap(plane: Plane, width: Int, height: Int): RawBuffer {
            return RawBuffer(
                buffer = plane.buffer,
                crop = Rect(width = width, height = height),
                plane = plane,
                releaseCallback = null,
            )
        }
    }
}
