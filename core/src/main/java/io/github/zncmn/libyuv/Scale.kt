package io.github.zncmn.libyuv

import android.graphics.Rect

fun I420Buffer.scale(dst: I420Buffer, filterMode: FilterMode) {
    Yuv.scaleI420Scale(bufferY, strideY, bufferU, strideU, bufferV, strideV, width, height,
        dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, dst.width, dst.height, filterMode.mode)
}

fun I444Buffer.scale(dst: I444Buffer, filterMode: FilterMode) {
    Yuv.scaleI444Scale(bufferY, strideY, bufferU, strideU, bufferV, strideV, width, height,
        dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, dst.width, dst.height, filterMode.mode)
}

fun ArgbBuffer.scale(dst: ArgbBuffer, filterMode: FilterMode) {
    Yuv.scaleARGBScale(bufferARGB, strideARGB, width, height, dst.bufferARGB, dst.strideARGB, dst.width, dst.height, filterMode.mode)
}

fun ArgbBuffer.scaleClip(dst: ArgbBuffer, rect: Rect, filterMode: FilterMode) {
    Yuv.scaleARGBScaleClip(bufferARGB, strideARGB, width, height, dst.bufferARGB, dst.strideARGB, dst.width, dst.height,
        rect.left, rect.top, rect.width(), rect.height(), filterMode.mode)
}
