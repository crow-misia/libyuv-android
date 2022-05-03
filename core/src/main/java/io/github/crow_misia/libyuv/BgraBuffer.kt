package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.nio.ByteBuffer
import kotlin.math.min

/**
 * BGRA little endian (argb in memory)
 */
class BgraBuffer private constructor(
    buffer: ByteBuffer?,
    val plane: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, arrayOf(plane), releaseCallback) {
    fun convertTo(dst: I420Buffer) {
        Yuv.convertBGRAToI420(
            srcBGRA = plane.buffer, srcStrideBGRA = plane.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: BgraBuffer) {
        Yuv.convertARGBCopy(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        Yuv.convertBGRAToARGB(
            srcBGRA = plane.buffer, srcStrideBGRA = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun mirrorTo(dst: BgraBuffer) {
        Yuv.planerARGBMirror(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun rotate(dst: BgraBuffer, rotateMode: RotateMode) {
        Yuv.rotateARGBRotate(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = calculateWidth(this, dst, rotateMode),
            height = calculateHeight(this, dst, rotateMode),
            rotateMode = rotateMode.degrees,
        )
    }

    fun scale(dst: BgraBuffer, filterMode: FilterMode) {
        Yuv.scaleARGBScale(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            srcWidth = width, srcHeight = height,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            dstWidth = dst.width, dstHeight = dst.height,
            filterMode = filterMode.mode,
        )
    }

    fun scaleClip(dst: BgraBuffer, rect: Rect, filterMode: FilterMode) {
        Yuv.scaleARGBScaleClip(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            srcWidth = width, srcHeight = height,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            dstWidth = dst.width, dstHeight = dst.height,
            clipX = rect.left, clipY = rect.top,
            clipWidth = rect.width(), clipHeight = rect.height(),
            filterMode = filterMode.mode,
        )
    }

    companion object Factory : BufferFactory<BgraBuffer> {
        internal fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width.shl(2)
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        override fun allocate(width: Int, height: Int): BgraBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return BgraBuffer(
                buffer = buffer,
                plane = PlanePrimitive(stride, buffer),
                width = width,
                height = height,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): BgraBuffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (stride, capacity) = getStrideWithCapacity(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity)
            return BgraBuffer(
                buffer = sliceBuffer,
                plane = PlanePrimitive(stride, sliceBuffer),
                width = width,
                height = height,
                releaseCallback = null,
            )
        }

        fun wrap(plane: Plane, width: Int, height: Int): BgraBuffer {
            return BgraBuffer(
                buffer = plane.buffer,
                plane = plane,
                width = width,
                height = height,
                releaseCallback = null,
            )
        }
    }
}
