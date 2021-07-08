@file:Suppress("unused")

package io.github.crow_misia.libyuv

import kotlin.math.min

// convert

@JvmName("convert")
fun I444Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertI444ToI420(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I444Buffer.convertTo(dst: Nv12Buffer) {
    Yuv.convertI444ToNV12(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I444Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertI444ToNV21(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertI422ToI420(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: I444Buffer) {
    Yuv.convertI422ToI444(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertI422ToNV21(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertI420Copy(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I400Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertI400ToI420(buffer, strideY,
            dst.buffer, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I400Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertI400ToNV21(buffer, strideY,
            dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I400Buffer.convertTo(dst: Nv12Buffer) {
    Yuv.convertI400ToNV21(buffer, strideY,
            dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun J400Buffer.convertTo(dst: J420Buffer) {
    Yuv.convertI400ToI420(buffer, strideY,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertNV12ToI420(bufferY, strideY, bufferUV, strideUV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertNV21ToI420(bufferY, strideY, bufferVU, strideVU,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}


@JvmName("convert")
fun ArgbBuffer.convertTo(dst: I420Buffer) {
    Yuv.convertARGBToI420(buffer, strideARGB,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun BgraBuffer.convertTo(dst: I420Buffer) {
    Yuv.convertBGRAToI420(buffer, strideBGRA,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun AbgrBuffer.convertTo(dst: I420Buffer) {
    Yuv.convertABGRToI420(buffer, strideABGR,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun RgbaBuffer.convertTo(dst: I420Buffer) {
    Yuv.convertRGBAToI420(buffer, strideRGBA,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Rgb24Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertRGB24ToI420(buffer, strideRGB24,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Rgb24Buffer.convertTo(dst: J420Buffer) {
    Yuv.convertRGB24ToJ420(buffer, strideRGB24,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun RawBuffer.convertTo(dst: I420Buffer) {
    Yuv.convertRAWToI420(buffer, strideRAW,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Rgb565Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertRGB565ToI420(buffer, strideRGB565,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Argb1555Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertARGB1555ToI420(buffer, strideARGB1555,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Argb4444Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertARGB4444ToI420(buffer, strideARGB4444,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Rgb24Buffer.convertTo(dst: J400Buffer) {
    Yuv.convertRGB24ToJ400(buffer, strideRGB24, dst.buffer, dst.strideY, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun RawBuffer.convertTo(dst: J400Buffer) {
    Yuv.convertRAWToJ400(buffer, strideRAW, dst.buffer, dst.strideY, min(width, dst.width), min(height, dst.height))
}

// convert_argb

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertARGBCopy(buffer, strideARGB, dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun J420Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertJ420ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun J420Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertJ420ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun H420Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertH420ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun H420Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertH420ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun U420Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertU420ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun U420Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertU420ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertI422ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun J422Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertJ422ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun J422Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertJ422ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun H422Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertH422ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun H422Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertH422ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun U422Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertU422ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun U422Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertU422ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I444Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertI444ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I444Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertI444ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun J444Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertJ444ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun J444Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertJ444ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun H444Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertH444ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun H444Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertH444ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun U444Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertU444ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun U444Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertU444ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I400Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertI400ToARGB(buffer, strideY, dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun J400Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertJ400ToARGB(buffer, strideY, dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertNV12ToARGB(bufferY, strideY, bufferUV, strideUV, dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertNV21ToARGB(bufferY, strideY, bufferVU, strideVU, dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertNV12ToABGR(bufferY, strideY, bufferUV, strideUV, dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertNV21ToABGR(bufferY, strideY, bufferVU, strideVU, dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertNV12ToRGB24(bufferY, strideY, bufferUV, strideUV, dst.buffer, dst.strideRGB24, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertNV21ToRGB24(bufferY, strideY, bufferVU, strideVU, dst.buffer, dst.strideRGB24, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: Yuv24Buffer) {
    Yuv.convertNV21ToYUV24(bufferY, strideY, bufferVU, strideVU, dst.buffer, dst.strideYUV24, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: RawBuffer) {
    Yuv.convertNV12ToRAW(bufferY, strideY, bufferUV, strideUV, dst.buffer, dst.strideRAW, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: RawBuffer) {
    Yuv.convertNV21ToRAW(bufferY, strideY, bufferVU, strideVU, dst.buffer, dst.strideRAW, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun BgraBuffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertBGRAToARGB(buffer, strideBGRA, dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun AbgrBuffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertABGRToARGB(buffer, strideABGR, dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun RgbaBuffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertRGBAToARGB(buffer, strideRGBA, dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Rgb24Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertRGB24ToARGB(buffer, strideRGB24, dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun RawBuffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertRAWToARGB(buffer, strideRAW, dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun RawBuffer.convertTo(dst: RgbaBuffer) {
    Yuv.convertRAWToRGBA(buffer, strideRAW, dst.buffer, dst.strideRGBA, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Rgb565Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertRGB565ToARGB(buffer, strideRGB565, dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Argb1555Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertARGB1555ToARGB(buffer, strideARGB1555, dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Argb4444Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertARGB4444ToARGB(buffer, strideARGB4444, dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertNV12ToRGB565(bufferY, strideY, bufferUV, strideUV, dst.buffer, dst.strideRGB565, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: BgraBuffer) {
    Yuv.convertI422ToBGRA(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideBGRA, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertI422ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: RgbaBuffer) {
    Yuv.convertI422ToRGBA(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideRGBA, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertI420ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: BgraBuffer) {
    Yuv.convertI420ToBGRA(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideBGRA, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertI420ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: RgbaBuffer) {
    Yuv.convertI420ToRGBA(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideRGBA, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertI420ToRGB24(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideRGB24, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: RawBuffer) {
    Yuv.convertI420ToRAW(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideRAW, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun H420Buffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertH420ToRGB24(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideRGB24, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun H420Buffer.convertTo(dst: RawBuffer) {
    Yuv.convertH420ToRAW(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideRAW, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun J420Buffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertJ420ToRGB24(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideRGB24, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun J420Buffer.convertTo(dst: RawBuffer) {
    Yuv.convertJ420ToRAW(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideRAW, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertI420ToRGB565(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideRGB565, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun J420Buffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertJ420ToRGB565(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideRGB565, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun H420Buffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertH420ToRGB565(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideRGB565, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertI422ToRGB565(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideRGB565, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: Argb1555Buffer) {
    Yuv.convertI420ToARGB1555(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideARGB1555, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: Argb4444Buffer) {
    Yuv.convertI420ToARGB4444(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideARGB4444, min(width, dst.width), min(height, dst.height))
}

// convert_from

@JvmName("convert")
fun I420Buffer.convertTo(dst: I422Buffer) {
    Yuv.convertI420ToI422(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: I444Buffer) {
    Yuv.convertI420ToI444(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I400Buffer.convertTo(dst: I400Buffer) {
    Yuv.convertI400Copy(buffer, strideY, dst.buffer, dst.strideY, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: I400Buffer) {
    Yuv.convertI400Copy(bufferY, strideY, dst.buffer, dst.strideY, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I444Buffer.convertTo(dst: I400Buffer) {
    Yuv.convertI400Copy(bufferY, strideY, dst.buffer, dst.strideY, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: I400Buffer) {
    Yuv.convertI400Copy(bufferY, strideY, dst.buffer, dst.strideY, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: I400Buffer) {
    Yuv.convertI400Copy(bufferY, strideY, dst.buffer, dst.strideY, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: Nv12Buffer) {
    Yuv.convertI420ToNV12(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertI420ToNV21(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

// convert_from_argb

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: BgraBuffer) {
    Yuv.convertARGBToBGRA(buffer, strideARGB, dst.buffer, dst.strideBGRA, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertARGBToABGR(buffer, strideARGB, dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: RgbaBuffer) {
    Yuv.convertARGBToRGBA(buffer, strideARGB, dst.buffer, dst.strideRGBA, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertARGBToRGB24(buffer, strideARGB, dst.buffer, dst.strideRGB24, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: RawBuffer) {
    Yuv.convertARGBToRAW(buffer, strideARGB, dst.buffer, dst.strideRAW, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertARGBToRGB565(buffer, strideARGB, dst.buffer, dst.strideRGB565, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: Argb1555Buffer) {
    Yuv.convertARGBToARGB1555(buffer, strideARGB, dst.buffer, dst.strideARGB1555, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: Argb4444Buffer) {
    Yuv.convertARGBToARGB4444(buffer, strideARGB, dst.buffer, dst.strideARGB4444, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: I444Buffer) {
    Yuv.convertARGBToI444(buffer, strideARGB,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: I422Buffer) {
    Yuv.convertARGBToI422(buffer, strideARGB,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: J420Buffer) {
    Yuv.convertARGBToJ420(buffer, strideARGB,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: J422Buffer) {
    Yuv.convertARGBToJ422(buffer, strideARGB,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: J400Buffer) {
    Yuv.convertARGBToJ400(buffer, strideARGB, dst.buffer, dst.strideY, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun RgbaBuffer.convertTo(dst: J400Buffer) {
    Yuv.convertRGBAToJ400(buffer, strideRGBA, dst.buffer, dst.strideY, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: I400Buffer) {
    Yuv.convertARGBToI400(buffer, strideARGB, dst.buffer, dst.strideY, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: Nv12Buffer) {
    Yuv.convertARGBToNV12(buffer, strideARGB, dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun ArgbBuffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertARGBToNV21(buffer, strideARGB, dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun AbgrBuffer.convertTo(dst: Nv12Buffer) {
    Yuv.convertABGRToNV12(buffer, strideABGR, dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun AbgrBuffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertABGRToNV21(buffer, strideABGR, dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

// planar_functions

@JvmName("convert")
fun J400Buffer.convertTo(dst: J400Buffer) {
    Yuv.convertI400Copy(buffer, strideY, dst.buffer, dst.strideY, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I422Buffer.convertTo(dst: I422Buffer) {
    Yuv.planerI422Copy(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV,
            min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I444Buffer.convertTo(dst: I444Buffer) {
    Yuv.planerI444Copy(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV,
            min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.planerNV12Copy(bufferY, strideY, bufferVU, strideVU,
            dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: Nv12Buffer) {
    Yuv.planerNV12Copy(bufferY, strideY, bufferUV, strideUV,
            dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv21Buffer.convertTo(dst: Nv12Buffer) {
    Yuv.planerNV21ToNV12(bufferY, strideY, bufferVU, strideVU,
            dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun Nv12Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.planerNV21ToNV12(bufferY, strideY, bufferUV, strideUV,
            dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun I420Buffer.convertTo(dst: I400Buffer) {
    Yuv.planerI420ToI400(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideY, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun J420Buffer.convertTo(dst: J400Buffer) {
    Yuv.planerI420ToI400(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.buffer, dst.strideY, min(width, dst.width), min(height, dst.height))
}

@JvmName("mirror")
fun I420Buffer.mirrorTo(dst: I420Buffer) {
    Yuv.planerI420Mirror(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV,
            min(width, dst.width), min(height, dst.height))
}

@JvmName("mirror")
fun I400Buffer.mirrorTo(dst: I400Buffer) {
    Yuv.planerI400Mirror(buffer, strideY, dst.buffer, dst.strideY, min(width, dst.width), min(height, dst.height))
}

@JvmName("mirror")
fun Nv12Buffer.mirrorTo(dst: Nv12Buffer) {
    Yuv.planerNV12Mirror(bufferY, strideY, bufferUV, strideUV, dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, min(width, dst.width), min(height, dst.height))
}

@JvmName("mirror")
fun Nv21Buffer.mirrorTo(dst: Nv21Buffer) {
    Yuv.planerNV12Mirror(bufferY, strideY, bufferVU, strideVU, dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

@JvmName("mirror")
fun AbgrBuffer.mirrorTo(dst: AbgrBuffer) {
    Yuv.planerARGBMirror(buffer, strideABGR, dst.buffer, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

@JvmName("mirror")
fun ArgbBuffer.mirrorTo(dst: ArgbBuffer) {
    Yuv.planerARGBMirror(buffer, strideARGB, dst.buffer, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

@JvmName("mirror")
fun BgraBuffer.mirrorTo(dst: BgraBuffer) {
    Yuv.planerARGBMirror(buffer, strideBGRA, dst.buffer, dst.strideBGRA, min(width, dst.width), min(height, dst.height))
}

@JvmName("mirror")
fun RgbaBuffer.mirrorTo(dst: RgbaBuffer) {
    Yuv.planerARGBMirror(buffer, strideRGBA, dst.buffer, dst.strideRGBA, min(width, dst.width), min(height, dst.height))
}

@JvmName("mirror")
fun Rgb24Buffer.mirrorTo(dst: Rgb24Buffer) {
    Yuv.planerRGB24Mirror(buffer, strideRGB24, dst.buffer, dst.strideRGB24, min(width, dst.width), min(height, dst.height))
}

@JvmName("mirror")
fun RawBuffer.mirrorTo(dst: RawBuffer) {
    Yuv.planerRGB24Mirror(buffer, strideRAW, dst.buffer, dst.strideRAW, min(width, dst.width), min(height, dst.height))
}

@JvmName("convert")
fun RawBuffer.convertTo(dst: Rgb24Buffer) {
    Yuv.planerRAWToRGB24(buffer, strideRAW, dst.buffer, dst.strideRGB24, min(width, dst.width), min(height, dst.height))
}
