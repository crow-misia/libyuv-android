package io.github.crow_misia.libyuv

import android.graphics.Rect

/**
 * 32 bpp Buffer.
 */
interface Buffer32<BUFFER : Buffer32<BUFFER>> : Buffer {
    val plane: Plane

    fun convertTo(dst: BUFFER) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertARGBCopy(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = offset(0),
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun mirrorTo(dst: BUFFER) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planerARGBMirror(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = offset(0),
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun rotate(dst: BUFFER, rotateMode: RotateMode) {
        Yuv.rotateARGBRotate(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = offset(0),
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.offset(0),
            width = rotateMode.calculateWidth(this, dst),
            height = rotateMode.calculateHeight(this, dst),
            rotateMode = rotateMode.degrees,
        )
    }

    fun scale(dst: BUFFER, filterMode: FilterMode) {
        Yuv.scaleARGBScale(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = offset(0),
            srcWidth = cropRect.width(), srcHeight = cropRect.height(),
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.offset(0),
            dstWidth = dst.cropRect.width(), dstHeight = dst.cropRect.height(),
            filterMode = filterMode.mode,
        )
    }

    fun scaleClip(dst: BUFFER, rect: Rect, filterMode: FilterMode) {
        Yuv.scaleARGBScaleClip(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = offset(0),
            srcWidth = cropRect.width(), srcHeight = cropRect.height(),
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.offset(0),
            dstWidth = dst.cropRect.width(), dstHeight = dst.cropRect.height(),
            clipX = rect.left, clipY = rect.top,
            clipWidth = rect.width(), clipHeight = rect.height(),
            filterMode = filterMode.mode,
        )
    }
}
