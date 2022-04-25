package io.github.crow_misia.libyuv

import kotlin.math.min

fun I420Buffer.rotate(dst: I420Buffer, rotateMode: RotateMode) {
    Yuv.rotateI420Rotate(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun J420Buffer.rotate(dst: J420Buffer, rotateMode: RotateMode) {
    Yuv.rotateI420Rotate(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun H420Buffer.rotate(dst: H420Buffer, rotateMode: RotateMode) {
    Yuv.rotateI420Rotate(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun U420Buffer.rotate(dst: U420Buffer, rotateMode: RotateMode) {
    Yuv.rotateI420Rotate(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun I400Buffer.rotate(dst: I400Buffer, rotateMode: RotateMode) {
    Yuv.rotateRotatePlane(
        src = planeY.buffer,
        srcStride = planeY.rowStride,
        dst = dst.planeY.buffer,
        dstStride = dst.planeY.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun J400Buffer.rotate(dst: J400Buffer, rotateMode: RotateMode) {
    Yuv.rotateRotatePlane(
        src = planeYJ.buffer,
        srcStride = planeYJ.rowStride,
        dst = dst.planeYJ.buffer,
        dstStride = dst.planeYJ.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun I444Buffer.rotate(dst: I444Buffer, rotateMode: RotateMode) {
    Yuv.rotateI444Rotate(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun J444Buffer.rotate(dst: J444Buffer, rotateMode: RotateMode) {
    Yuv.rotateI444Rotate(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun H444Buffer.rotate(dst: H444Buffer, rotateMode: RotateMode) {
    Yuv.rotateI444Rotate(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun U444Buffer.rotate(dst: U444Buffer, rotateMode: RotateMode) {
    Yuv.rotateI444Rotate(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun Nv12Buffer.rotate(dst: I420Buffer, rotateMode: RotateMode) {
    Yuv.rotateNV12ToI420Rotate(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcUV = planeUV.buffer,
        srcStrideUV = planeUV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun Nv12Buffer.rotate(dst: Nv12Buffer, rotateMode: RotateMode) {
    Yuv.rotateNV12Rotate(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcUV = planeUV.buffer,
        srcStrideUV = planeUV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstUV = dst.planeUV.buffer,
        dstStrideUV = dst.planeUV.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun Nv21Buffer.rotate(dst: I420Buffer, rotateMode: RotateMode) {
    Yuv.rotateNV12ToI420Rotate(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcUV = planeVU.buffer,
        srcStrideUV = planeVU.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeV.buffer,
        dstStrideU = dst.planeV.rowStride,
        dstV = dst.planeU.buffer,
        dstStrideV = dst.planeU.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun Nv21Buffer.rotate(dst: Nv21Buffer, rotateMode: RotateMode) {
    Yuv.rotateNV21Rotate(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcVU = planeVU.buffer,
        srcStrideVU = planeVU.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstVU = dst.planeVU.buffer,
        dstStrideVU = dst.planeVU.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun AbgrBuffer.rotate(dst: AbgrBuffer, rotateMode: RotateMode) {
    Yuv.rotateARGBRotate(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun ArgbBuffer.rotate(dst: ArgbBuffer, rotateMode: RotateMode) {
    Yuv.rotateARGBRotate(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun BgraBuffer.rotate(dst: BgraBuffer, rotateMode: RotateMode) {
    Yuv.rotateARGBRotate(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

fun RgbaBuffer.rotate(dst: RgbaBuffer, rotateMode: RotateMode) {
    Yuv.rotateARGBRotate(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = calculateWidth(this, dst, rotateMode),
        height = calculateHeight(this, dst, rotateMode),
        rotateMode = rotateMode.degrees,
    )
}

private fun calculateWidth(src: Buffer, dst: Buffer, rotateMode: RotateMode): Int {
    return when (rotateMode) {
        RotateMode.ROTATE_0, RotateMode.ROTATE_180 -> min(src.width, dst.width)
        RotateMode.ROTATE_90, RotateMode.ROTATE_270 -> min(src.width, dst.height)
    }
}

private fun calculateHeight(src: Buffer, dst: Buffer, rotateMode: RotateMode): Int {
    return when (rotateMode) {
        RotateMode.ROTATE_0, RotateMode.ROTATE_180 -> min(src.height, dst.height)
        RotateMode.ROTATE_90, RotateMode.ROTATE_270 -> min(src.height, dst.width)
    }
}
