package io.github.crow_misia.libyuv

import android.graphics.Rect

fun I400Buffer.scale(dst: I400Buffer, filterMode: FilterMode) {
    Yuv.scaleScalePlane(buffer, strideY, width, height, dst.buffer, dst.strideY, dst.width, dst.height, filterMode.mode)
}

fun J400Buffer.scale(dst: J400Buffer, filterMode: FilterMode) {
    Yuv.scaleScalePlane(buffer, strideY, width, height, dst.buffer, dst.strideY, dst.width, dst.height, filterMode.mode)
}

fun I420Buffer.scale(dst: I420Buffer, filterMode: FilterMode) {
    Yuv.scaleI420Scale(bufferY, strideY, bufferU, strideU, bufferV, strideV, width, height,
        dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, dst.width, dst.height, filterMode.mode)
}

fun J420Buffer.scale(dst: J420Buffer, filterMode: FilterMode) {
    Yuv.scaleI420Scale(bufferY, strideY, bufferU, strideU, bufferV, strideV, width, height,
        dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, dst.width, dst.height, filterMode.mode)
}

fun H420Buffer.scale(dst: H420Buffer, filterMode: FilterMode) {
    Yuv.scaleI420Scale(bufferY, strideY, bufferU, strideU, bufferV, strideV, width, height,
        dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, dst.width, dst.height, filterMode.mode)
}

fun U420Buffer.scale(dst: U420Buffer, filterMode: FilterMode) {
    Yuv.scaleI420Scale(bufferY, strideY, bufferU, strideU, bufferV, strideV, width, height,
        dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, dst.width, dst.height, filterMode.mode)
}

fun I444Buffer.scale(dst: I444Buffer, filterMode: FilterMode) {
    Yuv.scaleI444Scale(bufferY, strideY, bufferU, strideU, bufferV, strideV, width, height,
        dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, dst.width, dst.height, filterMode.mode)
}

fun J444Buffer.scale(dst: J444Buffer, filterMode: FilterMode) {
    Yuv.scaleI444Scale(bufferY, strideY, bufferU, strideU, bufferV, strideV, width, height,
        dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, dst.width, dst.height, filterMode.mode)
}

fun H444Buffer.scale(dst: H444Buffer, filterMode: FilterMode) {
    Yuv.scaleI444Scale(bufferY, strideY, bufferU, strideU, bufferV, strideV, width, height,
        dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, dst.width, dst.height, filterMode.mode)
}

fun U444Buffer.scale(dst: U444Buffer, filterMode: FilterMode) {
    Yuv.scaleI444Scale(bufferY, strideY, bufferU, strideU, bufferV, strideV, width, height,
        dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, dst.width, dst.height, filterMode.mode)
}

fun Nv12Buffer.scale(dst: Nv12Buffer, filterMode: FilterMode) {
    Yuv.scaleNV12Scale(bufferY, strideY, bufferUV, strideUV, width, height,
            dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, dst.width, dst.height, filterMode.mode)
}

fun Nv21Buffer.scale(dst: Nv21Buffer, filterMode: FilterMode) {
    Yuv.scaleNV12Scale(bufferY, strideY, bufferVU, strideVU, width, height,
            dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, dst.width, dst.height, filterMode.mode)
}

fun ArgbBuffer.scale(dst: ArgbBuffer, filterMode: FilterMode) {
    Yuv.scaleARGBScale(buffer, strideARGB, width, height, dst.buffer, dst.strideARGB, dst.width, dst.height, filterMode.mode)
}

fun AbgrBuffer.scale(dst: AbgrBuffer, filterMode: FilterMode) {
    Yuv.scaleARGBScale(buffer, strideABGR, width, height, dst.buffer, dst.strideABGR, dst.width, dst.height, filterMode.mode)
}

fun RgbaBuffer.scale(dst: RgbaBuffer, filterMode: FilterMode) {
    Yuv.scaleARGBScale(buffer, strideRGBA, width, height, dst.buffer, dst.strideRGBA, dst.width, dst.height, filterMode.mode)
}

fun BgraBuffer.scale(dst: BgraBuffer, filterMode: FilterMode) {
    Yuv.scaleARGBScale(buffer, strideBGRA, width, height, dst.buffer, dst.strideBGRA, dst.width, dst.height, filterMode.mode)
}

fun ArgbBuffer.scaleClip(dst: ArgbBuffer, rect: Rect, filterMode: FilterMode) {
    Yuv.scaleARGBScaleClip(buffer, strideARGB, width, height, dst.buffer, dst.strideARGB, dst.width, dst.height,
        rect.left, rect.top, rect.width(), rect.height(), filterMode.mode)
}

fun AbgrBuffer.scaleClip(dst: AbgrBuffer, rect: Rect, filterMode: FilterMode) {
    Yuv.scaleARGBScaleClip(buffer, strideABGR, width, height, dst.buffer, dst.strideABGR, dst.width, dst.height,
        rect.left, rect.top, rect.width(), rect.height(), filterMode.mode)
}

fun RgbaBuffer.scaleClip(dst: RgbaBuffer, rect: Rect, filterMode: FilterMode) {
    Yuv.scaleARGBScaleClip(buffer, strideRGBA, width, height, dst.buffer, dst.strideRGBA, dst.width, dst.height,
        rect.left, rect.top, rect.width(), rect.height(), filterMode.mode)
}

fun BgraBuffer.scaleClip(dst: BgraBuffer, rect: Rect, filterMode: FilterMode) {
    Yuv.scaleARGBScaleClip(buffer, strideBGRA, width, height, dst.buffer, dst.strideBGRA, dst.width, dst.height,
        rect.left, rect.top, rect.width(), rect.height(), filterMode.mode)
}
