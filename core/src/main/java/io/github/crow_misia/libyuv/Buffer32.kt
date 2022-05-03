package io.github.crow_misia.libyuv

import android.graphics.Rect
import kotlin.math.min

/**
 * 32 bpp Buffer.
 */
interface Buffer32<BUFFER : Buffer32<BUFFER>> : Buffer {
    val plane: Plane

    fun convertTo(dst: BUFFER) {
        Yuv.convertARGBCopy(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun mirrorTo(dst: BUFFER) {
        Yuv.planerARGBMirror(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun rotate(dst: BUFFER, rotateMode: RotateMode) {
        Yuv.rotateARGBRotate(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = rotateMode.calculateWidth(this, dst),
            height = rotateMode.calculateHeight(this, dst),
            rotateMode = rotateMode.degrees,
        )
    }

    fun scale(dst: BUFFER, filterMode: FilterMode) {
        Yuv.scaleARGBScale(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            srcWidth = width, srcHeight = height,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            dstWidth = dst.width, dstHeight = dst.height,
            filterMode = filterMode.mode,
        )
    }

    fun scaleClip(dst: BUFFER, rect: Rect, filterMode: FilterMode) {
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
}
