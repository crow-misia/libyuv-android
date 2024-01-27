package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import java.nio.ByteBuffer
import kotlin.math.min

/**
 * ABGR little endian (rgba in memory).
 */
class AbgrBuffer private constructor(
    buffer: ByteBuffer?,
    crop: Rect,
    override val plane: Plane,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, crop, arrayOf(plane), releaseCallback), BitmapConverter, Buffer32<AbgrBuffer>, BufferFirstAlpha {
    override fun asBitmap(): Bitmap {
        return asBuffer().toBitmap(width, height, Bitmap.Config.ARGB_8888)
    }

    fun convertTo(dst: I420Buffer) {
        Yuv.convertABGRToI420(
            srcABGR = plane.buffer, srcStrideABGR = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: J400Buffer) {
        Yuv.convertABGRToJ400(
            srcABGR = plane.buffer, srcStrideABGR = plane.rowStride,
            dstYJ = dst.planeY.buffer, dstStrideYJ = dst.planeY.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: J420Buffer) {
        Yuv.convertABGRToJ420(
            srcABGR = plane.buffer, srcStrideABGR = plane.rowStride,
            dstYJ = dst.planeY.buffer, dstStrideYJ = dst.planeY.rowStride,
            dstUJ = dst.planeU.buffer, dstStrideUJ = dst.planeU.rowStride,
            dstVJ = dst.planeV.buffer, dstStrideVJ = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: J422Buffer) {
        Yuv.convertABGRToJ422(
            srcABGR = plane.buffer, srcStrideABGR = plane.rowStride,
            dstYJ = dst.planeY.buffer, dstStrideYJ = dst.planeY.rowStride,
            dstUJ = dst.planeU.buffer, dstStrideUJ = dst.planeU.rowStride,
            dstVJ = dst.planeV.buffer, dstStrideVJ = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv12Buffer) {
        Yuv.convertABGRToNV12(
            srcABGR = plane.buffer, srcStrideABGR = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstUV = dst.planeUV.buffer, dstStrideUV = dst.planeUV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv21Buffer) {
        Yuv.convertABGRToNV21(
            srcABGR = plane.buffer, srcStrideABGR = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstVU = dst.planeVU.buffer, dstStrideVU = dst.planeVU.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        Yuv.convertABGRToARGB(
            srcABGR = plane.buffer, srcStrideABGR = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Rgb24Buffer) {
        Yuv.convertARGBToRAW(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstRAW = dst.plane.buffer, dstStrideRAW = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: RawBuffer) {
        Yuv.convertARGBToRGB24(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstRGB24 = dst.plane.buffer, dstStrideRGB24 = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    companion object Factory : BufferFactory<AbgrBuffer> {
        internal fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width.shl(2)
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        override fun allocate(width: Int, height: Int): AbgrBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return AbgrBuffer(
                buffer = buffer,
                crop = Rect(width = width, height = height),
                plane = PlanePrimitive(stride, buffer),
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): AbgrBuffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (stride, capacity) = getStrideWithCapacity(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity)
            return AbgrBuffer(
                buffer = sliceBuffer,
                crop = Rect(width = width, height = height),
                plane = PlanePrimitive(stride, sliceBuffer),
                releaseCallback = null,
            )
        }

        fun wrap(plane: Plane, width: Int, height: Int): AbgrBuffer {
            return AbgrBuffer(
                buffer = plane.buffer,
                crop = Rect(width = width, height = height),
                plane = plane,
                releaseCallback = null,
            )
        }
    }
}
