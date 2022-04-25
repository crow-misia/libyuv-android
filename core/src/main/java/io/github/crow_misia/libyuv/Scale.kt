package io.github.crow_misia.libyuv

import android.graphics.Rect

fun I400Buffer.scale(dst: I400Buffer, filterMode: FilterMode) {
    Yuv.scaleScalePlane(
        src = planeY.buffer,
        srcStride = planeY.rowStride,
        srcWidth = width,
        srcHeight = height,
        dst = dst.planeY.buffer,
        dstStride = dst.planeY.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun J400Buffer.scale(dst: J400Buffer, filterMode: FilterMode) {
    Yuv.scaleScalePlane(
        src = planeYJ.buffer,
        srcStride = planeYJ.rowStride,
        srcWidth = width,
        srcHeight = height,
        dst = dst.planeYJ.buffer,
        dstStride = dst.planeYJ.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun I420Buffer.scale(dst: I420Buffer, filterMode: FilterMode) {
    Yuv.scaleI420Scale(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun J420Buffer.scale(dst: J420Buffer, filterMode: FilterMode) {
    Yuv.scaleI420Scale(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun H420Buffer.scale(dst: H420Buffer, filterMode: FilterMode) {
    Yuv.scaleI420Scale(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun U420Buffer.scale(dst: U420Buffer, filterMode: FilterMode) {
    Yuv.scaleI420Scale(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun I444Buffer.scale(dst: I444Buffer, filterMode: FilterMode) {
    Yuv.scaleI444Scale(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun J444Buffer.scale(dst: J444Buffer, filterMode: FilterMode) {
    Yuv.scaleI444Scale(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun H444Buffer.scale(dst: H444Buffer, filterMode: FilterMode) {
    Yuv.scaleI444Scale(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun U444Buffer.scale(dst: U444Buffer, filterMode: FilterMode) {
    Yuv.scaleI444Scale(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun Nv12Buffer.scale(dst: Nv12Buffer, filterMode: FilterMode) {
    Yuv.scaleNV12Scale(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcUV = planeUV.buffer,
        srcStrideUV = planeUV.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstUV = dst.planeUV.buffer,
        dstStrideUV = dst.planeUV.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun Nv21Buffer.scale(dst: Nv21Buffer, filterMode: FilterMode) {
    Yuv.scaleNV12Scale(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcUV = planeVU.buffer,
        srcStrideUV = planeVU.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstUV = dst.planeVU.buffer,
        dstStrideUV = dst.planeVU.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun ArgbBuffer.scale(dst: ArgbBuffer, filterMode: FilterMode) {
    Yuv.scaleARGBScale(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun AbgrBuffer.scale(dst: AbgrBuffer, filterMode: FilterMode) {
    Yuv.scaleARGBScale(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun RgbaBuffer.scale(dst: RgbaBuffer, filterMode: FilterMode) {
    Yuv.scaleARGBScale(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun BgraBuffer.scale(dst: BgraBuffer, filterMode: FilterMode) {
    Yuv.scaleARGBScale(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        filterMode = filterMode.mode,
    )
}

fun ArgbBuffer.scaleClip(dst: ArgbBuffer, rect: Rect, filterMode: FilterMode) {
    Yuv.scaleARGBScaleClip(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        clipX = rect.left,
        clipY = rect.top,
        clipWidth = rect.width(),
        clipHeight = rect.height(),
        filterMode = filterMode.mode,
    )
}

fun AbgrBuffer.scaleClip(dst: AbgrBuffer, rect: Rect, filterMode: FilterMode) {
    Yuv.scaleARGBScaleClip(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        clipX = rect.left,
        clipY = rect.top,
        clipWidth = rect.width(),
        clipHeight = rect.height(),
        filterMode = filterMode.mode,
    )
}

fun RgbaBuffer.scaleClip(dst: RgbaBuffer, rect: Rect, filterMode: FilterMode) {
    Yuv.scaleARGBScaleClip(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        clipX = rect.left,
        clipY = rect.top,
        clipWidth = rect.width(),
        clipHeight = rect.height(),
        filterMode = filterMode.mode,
    )
}

fun BgraBuffer.scaleClip(dst: BgraBuffer, rect: Rect, filterMode: FilterMode) {
    Yuv.scaleARGBScaleClip(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        srcWidth = width,
        srcHeight = height,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        dstWidth = dst.width,
        dstHeight = dst.height,
        clipX = rect.left,
        clipY = rect.top,
        clipWidth = rect.width(),
        clipHeight = rect.height(),
        filterMode = filterMode.mode,
    )
}
