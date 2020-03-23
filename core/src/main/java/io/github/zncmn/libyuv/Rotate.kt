package io.github.zncmn.libyuv

import kotlin.math.min

fun I420Buffer.rotate(dst: I420Buffer, rotateMode: RotateMode) {
    Yuv.rotateI420Rotate(bufferY, strideY, bufferU, strideU, bufferV, strideV,
        dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height), rotateMode.degrees)
}

fun I444Buffer.rotate(dst: I444Buffer, rotateMode: RotateMode) {
    Yuv.rotateI444Rotate(bufferY, strideY, bufferU, strideU, bufferV, strideV,
        dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height), rotateMode.degrees)
}

fun Nv12Buffer.rotate(dst: I420Buffer, rotateMode: RotateMode) {
    Yuv.rotateNV12ToI420Rotate(bufferY, strideY, bufferUV, strideUV,
        dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height), rotateMode.degrees)
}

fun Nv21Buffer.rotate(dst: I420Buffer, rotateMode: RotateMode) {
    Yuv.rotateNV12ToI420Rotate(bufferY, strideY, bufferVU, strideVU,
        dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height), rotateMode.degrees)
}

fun ArgbBuffer.rotate(dst: ArgbBuffer, rotateMode: RotateMode) {
    Yuv.rotateARGBRotate(bufferARGB, strideARGB, dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height), rotateMode.degrees)
}
