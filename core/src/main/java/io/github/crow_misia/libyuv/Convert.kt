@file:Suppress("unused")

package io.github.crow_misia.libyuv

import kotlin.math.min

// convert

@JvmName("convert")
fun I444Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertI444ToI420(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV= planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I444Buffer.convertTo(dst: Nv12Buffer) {
    Yuv.convertI444ToNV12(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV= planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstUV = dst.planeUV.buffer,
        dstStrideUV = dst.planeUV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I444Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertI444ToNV21(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstVU = dst.planeVU.buffer,
        dstStrideVU = dst.planeVU.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertI422ToI420(
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
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: I444Buffer) {
    Yuv.convertI422ToI444(
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
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertI422ToNV21(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstVU = dst.planeVU.buffer,
        dstStrideVU = dst.planeVU.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertI420Copy(
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
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I400Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertI400ToI420(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I400Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertI400ToNV21(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstVU = dst.planeVU.buffer,
        dstStrideVU = dst.planeVU.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I400Buffer.convertTo(dst: Nv12Buffer) {
    Yuv.convertI400ToNV21(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstVU = dst.planeUV.buffer,
        dstStrideVU = dst.planeUV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun J400Buffer.convertTo(dst: J420Buffer) {
    Yuv.convertI400ToI420(
        srcY = planeYJ.buffer,
        srcStrideY = planeYJ.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertNV12ToI420(
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
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertNV21ToI420(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcVU = planeVU.buffer,
        srcStrideVU = planeVU.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}


@JvmName("convert")
fun ArgbBuffer.convertTo(dst: I420Buffer) {
    Yuv.convertARGBToI420(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun BgraBuffer.convertTo(dst: I420Buffer) {
    Yuv.convertBGRAToI420(
        srcBGRA = plane.buffer,
        srcStrideBGRA = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun AbgrBuffer.convertTo(dst: I420Buffer) {
    Yuv.convertABGRToI420(
        srcABGR = plane.buffer,
        srcStrideABGR = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun RgbaBuffer.convertTo(dst: I420Buffer) {
    Yuv.convertRGBAToI420(
        srcRGBA = plane.buffer,
        srcStrideRGBA = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Rgb24Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertRGB24ToI420(
        srcRGB24 = plane.buffer,
        srcStrideRGB24 = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Rgb24Buffer.convertTo(dst: J420Buffer) {
    Yuv.convertRGB24ToJ420(
        srcRGB24 = plane.buffer,
        srcStrideRGB24 = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun RawBuffer.convertTo(dst: I420Buffer) {
    Yuv.convertRAWToI420(
        srcRAW = plane.buffer,
        srcStrideRAW = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun RawBuffer.convertTo(dst: J420Buffer) {
    Yuv.convertRAWToJ420(
        srcRAW = plane.buffer,
        srcStrideRAW = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Rgb565Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertRGB565ToI420(
        srcRGB565 = plane.buffer,
        srcStrideRGB565 = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Argb1555Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertARGB1555ToI420(
        srcARGB1555 = plane.buffer,
        srcStrideARGB1555 = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Argb4444Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertARGB4444ToI420(
        srcARGB4444 = plane.buffer,
        srcStrideARGB4444 = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Rgb24Buffer.convertTo(dst: J400Buffer) {
    Yuv.convertRGB24ToJ400(
        srcRGB24 = plane.buffer,
        srcStrideRGB24 = plane.rowStride,
        dstYJ = dst.planeYJ.buffer,
        dstStrideYJ = dst.planeYJ.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun RawBuffer.convertTo(dst: J400Buffer) {
    Yuv.convertRAWToJ400(
        srcRAW = plane.buffer,
        srcStrideRAW = plane.rowStride,
        dstYJ = dst.planeYJ.buffer,
        dstStrideYJ = dst.planeYJ.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

// convert_argb

@JvmName("convert")
fun AbgrBuffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertARGBCopy(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertARGBCopy(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun BgraBuffer.convertTo(dst: BgraBuffer) {
    Yuv.convertARGBCopy(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun RgbaBuffer.convertTo(dst: RgbaBuffer) {
    Yuv.convertARGBCopy(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun J420Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertJ420ToARGB(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun J420Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertJ420ToABGR(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstABGR = dst.plane.buffer,
        dstStrideABGR = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun H420Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertH420ToARGB(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun H420Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertH420ToABGR(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstABGR = dst.plane.buffer,
        dstStrideABGR = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun U420Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertU420ToARGB(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun U420Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertU420ToABGR(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstABGR = dst.plane.buffer,
        dstStrideABGR = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertI422ToARGB(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun J422Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertJ422ToARGB(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun J422Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertJ422ToABGR(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstABGR = dst.plane.buffer,
        dstStrideABGR = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun H422Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertH422ToARGB(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun H422Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertH422ToABGR(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstABGR = dst.plane.buffer,
        dstStrideABGR = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun U422Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertU422ToARGB(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun U422Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertU422ToABGR(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstABGR = dst.plane.buffer,
        dstStrideABGR = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I444Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertI444ToARGB(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I444Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertI444ToABGR(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstABGR = dst.plane.buffer,
        dstStrideABGR = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun J444Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertJ444ToARGB(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun J444Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertJ444ToABGR(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstABGR = dst.plane.buffer,
        dstStrideABGR = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun H444Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertH444ToARGB(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun H444Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertH444ToABGR(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstABGR = dst.plane.buffer,
        dstStrideABGR = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun U444Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertU444ToARGB(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun U444Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertU444ToABGR(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstABGR = dst.plane.buffer,
        dstStrideABGR = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I400Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertI400ToARGB(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun J400Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertJ400ToARGB(
        srcY = planeYJ.buffer,
        srcStrideY = planeYJ.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertNV12ToARGB(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcUV = planeUV.buffer,
        srcStrideUV = planeUV.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertNV21ToARGB(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcVU = planeVU.buffer,
        srcStrideVU = planeVU.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertNV12ToABGR(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcUV = planeUV.buffer,
        srcStrideUV = planeUV.rowStride,
        dstABGR = dst.plane.buffer,
        dstStrideABGR = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertNV21ToABGR(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcVU = planeVU.buffer,
        srcStrideVU = planeVU.rowStride,
        dstABGR = dst.plane.buffer,
        dstStrideABGR = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertNV12ToRGB24(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcUV = planeUV.buffer,
        srcStrideUV = planeUV.rowStride,
        dstRGB24 = dst.plane.buffer,
        dstStrideRGB24 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertNV21ToRGB24(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcVU = planeVU.buffer,
        srcStrideVU = planeVU.rowStride,
        dstRGB24 = dst.plane.buffer,
        dstStrideRGB24 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: Yuv24Buffer) {
    Yuv.convertNV21ToYUV24(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcVU = planeVU.buffer,
        srcStrideVU = planeVU.rowStride,
        dstYUV24 = dst.plane.buffer,
        dstStrideYUV24 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: RawBuffer) {
    Yuv.convertNV12ToRAW(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcUV = planeUV.buffer,
        srcStrideUV = planeUV.rowStride,
        dstRAW = dst.plane.buffer,
        dstStrideRAW = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: RawBuffer) {
    Yuv.convertNV21ToRAW(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcVU = planeVU.buffer,
        srcStrideVU = planeVU.rowStride,
        dstRAW = dst.plane.buffer,
        dstStrideRAW = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun BgraBuffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertBGRAToARGB(
        srcBGRA = plane.buffer,
        srcStrideBGRA = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun AbgrBuffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertABGRToARGB(
        srcABGR = plane.buffer,
        srcStrideABGR = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun RgbaBuffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertRGBAToARGB(
        srcRGBA = plane.buffer,
        srcStrideRGBA = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Rgb24Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertRGB24ToARGB(
        srcRGB24 = plane.buffer,
        srcStrideRGB24 = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun RawBuffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertRAWToARGB(
        srcRAW = plane.buffer,
        srcStrideRAW = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun RawBuffer.convertTo(dst: RgbaBuffer) {
    Yuv.convertRAWToRGBA(
        srcRAW = plane.buffer,
        srcStrideRAW = plane.rowStride,
        dstRGBA = dst.plane.buffer,
        dstStrideRGBA = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Rgb565Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertRGB565ToARGB(
        srcRGB565 = plane.buffer,
        srcStrideRGB565 = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Argb1555Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertARGB1555ToARGB(
        srcARGB1555 = plane.buffer,
        srcStrideARGB1555 = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Argb4444Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertARGB4444ToARGB(
        srcARGB4444 = plane.buffer,
        srcStrideARGB4444 = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertNV12ToRGB565(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcUV = planeUV.buffer,
        srcStrideUV = planeUV.rowStride,
        dstRGB565 = dst.plane.buffer,
        dstStrideRGB565 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: BgraBuffer) {
    Yuv.convertI422ToBGRA(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstBGRA = dst.plane.buffer,
        dstStrideBGRA = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertI422ToABGR(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstABGR = dst.plane.buffer,
        dstStrideABGR = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: RgbaBuffer) {
    Yuv.convertI422ToRGBA(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstRGBA = dst.plane.buffer,
        dstStrideRGBA = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertI420ToARGB(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: BgraBuffer) {
    Yuv.convertI420ToBGRA(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstBGRA = dst.plane.buffer,
        dstStrideBGRA = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertI420ToABGR(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstABGR = dst.plane.buffer,
        dstStrideABGR = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: RgbaBuffer) {
    Yuv.convertI420ToRGBA(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstRGBA = dst.plane.buffer,
        dstStrideRGBA = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertI420ToRGB24(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstRGB24 = dst.plane.buffer,
        dstStrideRGB24 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: RawBuffer) {
    Yuv.convertI420ToRAW(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstRAW = dst.plane.buffer,
        dstStrideRAW = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun H420Buffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertH420ToRGB24(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstRGB24 = dst.plane.buffer,
        dstStrideRGB24 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun H420Buffer.convertTo(dst: RawBuffer) {
    Yuv.convertH420ToRAW(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstRAW = dst.plane.buffer,
        dstStrideRAW = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun J420Buffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertJ420ToRGB24(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstRGB24 = dst.plane.buffer,
        dstStrideRGB24 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun J420Buffer.convertTo(dst: RawBuffer) {
    Yuv.convertJ420ToRAW(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstRAW = dst.plane.buffer,
        dstStrideRAW = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertI420ToRGB565(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstRGB565 = dst.plane.buffer,
        dstStrideRGB565 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun J420Buffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertJ420ToRGB565(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstRGB565 = dst.plane.buffer,
        dstStrideRGB565 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun H420Buffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertH420ToRGB565(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstRGB565 = dst.plane.buffer,
        dstStrideRGB565 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertI422ToRGB565(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstRGB565 = dst.plane.buffer,
        dstStrideRGB565 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: Argb1555Buffer) {
    Yuv.convertI420ToARGB1555(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstARGB1555 = dst.plane.buffer,
        dstStrideARGB1555 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: Argb4444Buffer) {
    Yuv.convertI420ToARGB4444(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstARGB4444 = dst.plane.buffer,
        dstStrideARGB4444 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

// convert_from

@JvmName("convert")
fun I420Buffer.convertTo(dst: I422Buffer) {
    Yuv.convertI420ToI422(
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
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: I444Buffer) {
    Yuv.convertI420ToI444(
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
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I400Buffer.convertTo(dst: I400Buffer) {
    Yuv.convertI400Copy(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: I400Buffer) {
    Yuv.convertI400Copy(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I444Buffer.convertTo(dst: I400Buffer) {
    Yuv.convertI400Copy(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: I400Buffer) {
    Yuv.convertI400Copy(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: I400Buffer) {
    Yuv.convertI400Copy(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: Nv12Buffer) {
    Yuv.convertI420ToNV12(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstUV = dst.planeUV.buffer,
        dstStrideUV = dst.planeUV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertI420ToNV21(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstVU = dst.planeVU.buffer,
        dstStrideVU = dst.planeVU.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

// convert_from_argb

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: BgraBuffer) {
    Yuv.convertARGBToBGRA(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstBGRA = dst.plane.buffer,
        dstStrideBGRA = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertARGBToABGR(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstABGR = dst.plane.buffer,
        dstStrideABGR = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: RgbaBuffer) {
    Yuv.convertARGBToRGBA(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstRGBA = dst.plane.buffer,
        dstStrideRGBA = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun AbgrBuffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertARGBToRAW(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstRAW = dst.plane.buffer,
        dstStrideRAW = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun AbgrBuffer.convertTo(dst: RawBuffer) {
    Yuv.convertARGBToRGB24(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstRGB24 = dst.plane.buffer,
        dstStrideRGB24 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertARGBToRGB24(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstRGB24 = dst.plane.buffer,
        dstStrideRGB24 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: RawBuffer) {
    Yuv.convertARGBToRAW(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstRAW = dst.plane.buffer,
        dstStrideRAW = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertARGBToRGB565(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstRGB565 = dst.plane.buffer,
        dstStrideRGB565 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: Argb1555Buffer) {
    Yuv.convertARGBToARGB1555(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstARGB1555 = dst.plane.buffer,
        dstStrideARGB1555 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: Argb4444Buffer) {
    Yuv.convertARGBToARGB4444(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstARGB4444 = dst.plane.buffer,
        dstStrideARGB4444 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: I444Buffer) {
    Yuv.convertARGBToI444(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: I422Buffer) {
    Yuv.convertARGBToI422(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: J420Buffer) {
    Yuv.convertARGBToJ420(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: J422Buffer) {
    Yuv.convertARGBToJ422(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstU = dst.planeU.buffer,
        dstStrideU = dst.planeU.rowStride,
        dstV = dst.planeV.buffer,
        dstStrideV = dst.planeV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: J400Buffer) {
    Yuv.convertARGBToJ400(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstYJ = dst.planeYJ.buffer,
        dstStrideYJ = dst.planeYJ.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun RgbaBuffer.convertTo(dst: J400Buffer) {
    Yuv.convertRGBAToJ400(
        srcRGBA = plane.buffer,
        srcStrideRGBA = plane.rowStride,
        dstYJ = dst.planeYJ.buffer,
        dstStrideYJ = dst.planeYJ.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: I400Buffer) {
    Yuv.convertARGBToI400(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: Nv12Buffer) {
    Yuv.convertARGBToNV12(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstUV = dst.planeUV.buffer,
        dstStrideUV = dst.planeUV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertARGBToNV21(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstVU = dst.planeVU.buffer,
        dstStrideVU = dst.planeVU.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun AbgrBuffer.convertTo(dst: Nv12Buffer) {
    Yuv.convertABGRToNV12(
        srcABGR = plane.buffer,
        srcStrideABGR = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstUV = dst.planeUV.buffer,
        dstStrideUV = dst.planeUV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun AbgrBuffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertABGRToNV21(
        srcABGR = plane.buffer,
        srcStrideABGR = plane.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstVU = dst.planeVU.buffer,
        dstStrideVU = dst.planeVU.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

// planar_functions

@JvmName("convert")
fun J400Buffer.convertTo(dst: J400Buffer) {
    Yuv.convertI400Copy(
        srcY = planeYJ.buffer,
        srcStrideY = planeYJ.rowStride,
        dstY = dst.planeYJ.buffer,
        dstStrideY = dst.planeYJ.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: I422Buffer) {
    Yuv.planerI422Copy(
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
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I444Buffer.convertTo(dst: I444Buffer) {
    Yuv.planerI444Copy(
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
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.planerNV12Copy(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcVU = planeVU.buffer,
        srcStrideVU = planeVU.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstUV = dst.planeVU.buffer,
        dstStrideUV = dst.planeVU.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: Nv12Buffer) {
    Yuv.planerNV12Copy(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcVU = planeUV.buffer,
        srcStrideVU = planeUV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstUV = dst.planeUV.buffer,
        dstStrideUV = dst.planeUV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: Nv12Buffer) {
    Yuv.planerNV21ToNV12(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcVU = planeVU.buffer,
        srcStrideVU = planeVU.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstUV = dst.planeUV.buffer,
        dstStrideUV = dst.planeUV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.planerNV21ToNV12(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcVU = planeUV.buffer,
        srcStrideVU = planeUV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstUV = dst.planeVU.buffer,
        dstStrideUV = dst.planeVU.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: I400Buffer) {
    Yuv.planerI420ToI400(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun J420Buffer.convertTo(dst: J400Buffer) {
    Yuv.planerI420ToI400(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcU = planeU.buffer,
        srcStrideU = planeU.rowStride,
        srcV = planeV.buffer,
        srcStrideV = planeV.rowStride,
        dstY = dst.planeYJ.buffer,
        dstStrideY = dst.planeYJ.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("mirror")
fun I420Buffer.mirrorTo(dst: I420Buffer) {
    Yuv.planerI420Mirror(
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
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("mirror")
fun I400Buffer.mirrorTo(dst: I400Buffer) {
    Yuv.planerI400Mirror(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("mirror")
fun Nv12Buffer.mirrorTo(dst: Nv12Buffer) {
    Yuv.planerNV12Mirror(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcUV = planeUV.buffer,
        srcStrideUV = planeUV.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstUV = dst.planeUV.buffer,
        dstStrideUV = dst.planeUV.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("mirror")
fun Nv21Buffer.mirrorTo(dst: Nv21Buffer) {
    Yuv.planerNV12Mirror(
        srcY = planeY.buffer,
        srcStrideY = planeY.rowStride,
        srcUV = planeVU.buffer,
        srcStrideUV = planeVU.rowStride,
        dstY = dst.planeY.buffer,
        dstStrideY = dst.planeY.rowStride,
        dstUV = dst.planeVU.buffer,
        dstStrideUV = dst.planeVU.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("mirror")
fun AbgrBuffer.mirrorTo(dst: AbgrBuffer) {
    Yuv.planerARGBMirror(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("mirror")
fun ArgbBuffer.mirrorTo(dst: ArgbBuffer) {
    Yuv.planerARGBMirror(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("mirror")
fun BgraBuffer.mirrorTo(dst: BgraBuffer) {
    Yuv.planerARGBMirror(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("mirror")
fun RgbaBuffer.mirrorTo(dst: RgbaBuffer) {
    Yuv.planerARGBMirror(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("mirror")
fun Rgb24Buffer.mirrorTo(dst: Rgb24Buffer) {
    Yuv.planerRGB24Mirror(
        srcRGB24 = plane.buffer,
        srcStrideRGB24 = plane.rowStride,
        dstRGB24 = dst.plane.buffer,
        dstStrideRGB24 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("mirror")
fun RawBuffer.mirrorTo(dst: RawBuffer) {
    Yuv.planerRGB24Mirror(
        srcRGB24 = plane.buffer,
        srcStrideRGB24 = plane.rowStride,
        dstRGB24 = dst.plane.buffer,
        dstStrideRGB24 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("convert")
fun RawBuffer.convertTo(dst: Rgb24Buffer) {
    Yuv.planerRAWToRGB24(
        srcRAW = plane.buffer,
        srcStrideRAW = plane.rowStride,
        dstRGB24 = dst.plane.buffer,
        dstStrideRGB24 = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}

@JvmName("copyAlpha")
fun ArgbBuffer.copyAlphaTo(dst: ArgbBuffer) {
    Yuv.planerARGBCopyAlpha(
        srcARGB = plane.buffer,
        srcStrideARGB = plane.rowStride,
        dstARGB = dst.plane.buffer,
        dstStrideARGB = dst.plane.rowStride,
        width = min(width, dst.width),
        height = min(height, dst.height),
    )
}
