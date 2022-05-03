package io.github.crow_misia.libyuv

import java.nio.ByteBuffer
import kotlin.math.min

/**
 * ARGB little endian (bgra in memory)
 */
class ArgbBuffer private constructor(
    buffer: ByteBuffer?,
    override val plane: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, arrayOf(plane), releaseCallback), Buffer32<ArgbBuffer>, BufferFirstAlpha {
    fun convertTo(dst: I400Buffer) {
        Yuv.convertARGBToI400(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: I420Buffer) {
        Yuv.convertARGBToI420(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: I422Buffer) {
        Yuv.convertARGBToI422(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: I444Buffer) {
        Yuv.convertARGBToI444(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: J400Buffer) {
        Yuv.convertARGBToJ400(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstYJ = dst.planeY.buffer, dstStrideYJ = dst.planeY.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: J420Buffer) {
        Yuv.convertARGBToJ420(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: J422Buffer) {
        Yuv.convertARGBToJ422(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv12Buffer) {
        Yuv.convertARGBToNV12(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv21Buffer) {
        Yuv.convertARGBToNV21(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstVU = dst.planeVU.buffer, dstStrideVU = dst.planeVU.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: AbgrBuffer) {
        Yuv.convertARGBToABGR(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstABGR = dst.plane.buffer, dstStrideABGR = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Argb1555Buffer) {
        Yuv.convertARGBToARGB1555(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB1555 = dst.plane.buffer, dstStrideARGB1555 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Argb4444Buffer) {
        Yuv.convertARGBToARGB4444(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB4444 = dst.plane.buffer, dstStrideARGB4444 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: BgraBuffer) {
        Yuv.convertARGBToBGRA(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstBGRA = dst.plane.buffer, dstStrideBGRA = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: RawBuffer) {
        Yuv.convertARGBToRAW(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstRAW = dst.plane.buffer, dstStrideRAW = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: RgbaBuffer) {
        Yuv.convertARGBToRGBA(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstRGBA = dst.plane.buffer, dstStrideRGBA = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Rgb24Buffer) {
        Yuv.convertARGBToRGB24(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstRGB24 = dst.plane.buffer, dstStrideRGB24 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Rgb565Buffer) {
        Yuv.convertARGBToRGB565(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstRGB565 = dst.plane.buffer, dstStrideRGB565 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }


    companion object Factory : BufferFactory<ArgbBuffer> {
        internal fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width.shl(2)
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        override fun allocate(width: Int, height: Int): ArgbBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return ArgbBuffer(
                buffer = buffer,
                plane = PlanePrimitive(stride, buffer),
                width = width,
                height = height,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): ArgbBuffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (stride, capacity) = getStrideWithCapacity(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity)
            return ArgbBuffer(
                buffer = buffer,
                plane = PlanePrimitive(stride, sliceBuffer),
                width = width,
                height = height,
                releaseCallback = null,
            )
        }

        fun wrap(plane: Plane, width: Int, height: Int): ArgbBuffer {
            return ArgbBuffer(
                buffer = plane.buffer,
                plane = plane,
                width = width,
                height = height,
                releaseCallback = null,
            )
        }
    }
}
