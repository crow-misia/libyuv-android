package io.github.crow_misia.libyuv

import android.annotation.TargetApi
import android.graphics.Bitmap
import android.os.Build
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.Type
import kotlin.math.min

// convert

fun I444Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertI444ToI420(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun I444Buffer.convertTo(dst: Nv12Buffer) {
    Yuv.convertI444ToNV12(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, min(width, dst.width), min(height, dst.height))
}

fun I444Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertI444ToNV21(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

fun I422Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertI422ToI420(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun I422Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertI422ToNV21(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

fun I420Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertI420Copy(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun I400Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertI400ToI420(bufferY, strideY,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun I400Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertI400ToNV21(bufferY, strideY,
            dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

fun I400Buffer.convertTo(dst: Nv12Buffer) {
    Yuv.convertI400ToNV21(bufferY, strideY,
            dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, min(width, dst.width), min(height, dst.height))
}

fun Nv12Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertNV12ToI420(bufferY, strideY, bufferUV, strideUV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun Nv21Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertNV21ToI420(bufferY, strideY, bufferVU, strideVU,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: I420Buffer) {
    Yuv.convertARGBToI420(bufferARGB, strideARGB,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun BgraBuffer.convertTo(dst: I420Buffer) {
    Yuv.convertBGRAToI420(bufferBGRA, strideBGRA,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun AbgrBuffer.convertTo(dst: I420Buffer) {
    Yuv.convertABGRToI420(bufferABGR, strideABGR,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun RgbaBuffer.convertTo(dst: I420Buffer) {
    Yuv.convertRGBAToI420(bufferRGBA, strideRGBA,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun Rgb24Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertRGB24ToI420(bufferRGB24, strideRGB24,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun Rgb24Buffer.convertTo(dst: J420Buffer) {
    Yuv.convertRGB24ToJ420(bufferRGB24, strideRGB24,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun RawBuffer.convertTo(dst: I420Buffer) {
    Yuv.convertRAWToI420(bufferRAW, strideRAW,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun Rgb565Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertRGB565ToI420(bufferRGB565, strideRGB565,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun Argb1555Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertARGB1555ToI420(bufferARGB1555, strideARGB1555,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun Argb4444Buffer.convertTo(dst: I420Buffer) {
    Yuv.convertARGB4444ToI420(bufferARGB4444, strideARGB4444,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun Rgb24Buffer.convertTo(dst: J400Buffer) {
    Yuv.convertRGB24ToJ400(bufferRGB24, strideRGB24, dst.bufferY, dst.strideY, min(width, dst.width), min(height, dst.height))
}

fun RawBuffer.convertTo(dst: J400Buffer) {
    Yuv.convertRAWToJ400(bufferRAW, strideRAW, dst.bufferY, dst.strideY, min(width, dst.width), min(height, dst.height))
}

// convert_argb

fun ArgbBuffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertARGBCopy(bufferARGB, strideARGB, dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun J420Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertJ420ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun J420Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertJ420ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun H420Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertH420ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun H420Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertH420ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun U420Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertU420ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun U420Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertU420ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun I422Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertI422ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun J422Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertJ422ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun J422Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertJ422ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun H422Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertH422ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun H422Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertH422ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun U422Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertU422ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun U422Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertU422ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun I444Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertI444ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun I444Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertI444ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun J444Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertJ444ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun J444Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertJ444ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun H444Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertH444ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun H444Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertH444ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun U444Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertU444ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun U444Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertU444ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun I400Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertI400ToARGB(bufferY, strideY, dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun J400Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertJ400ToARGB(bufferY, strideY, dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun Nv12Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertNV12ToARGB(bufferY, strideY, bufferUV, strideUV, dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun Nv21Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertNV21ToARGB(bufferY, strideY, bufferVU, strideVU, dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun Nv12Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertNV12ToABGR(bufferY, strideY, bufferUV, strideUV, dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun Nv21Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertNV21ToABGR(bufferY, strideY, bufferVU, strideVU, dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun Nv12Buffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertNV12ToRGB24(bufferY, strideY, bufferUV, strideUV, dst.bufferRGB24, dst.strideRGB24, min(width, dst.width), min(height, dst.height))
}

fun Nv21Buffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertNV21ToRGB24(bufferY, strideY, bufferVU, strideVU, dst.bufferRGB24, dst.strideRGB24, min(width, dst.width), min(height, dst.height))
}

fun Nv21Buffer.convertTo(dst: Yuv24Buffer) {
    Yuv.convertNV21ToYUV24(bufferY, strideY, bufferVU, strideVU, dst.bufferYUV24, dst.strideYUV24, min(width, dst.width), min(height, dst.height))
}

fun Nv12Buffer.convertTo(dst: RawBuffer) {
    Yuv.convertNV12ToRAW(bufferY, strideY, bufferUV, strideUV, dst.bufferRAW, dst.strideRAW, min(width, dst.width), min(height, dst.height))
}

fun Nv21Buffer.convertTo(dst: RawBuffer) {
    Yuv.convertNV21ToRAW(bufferY, strideY, bufferVU, strideVU, dst.bufferRAW, dst.strideRAW, min(width, dst.width), min(height, dst.height))
}

fun BgraBuffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertBGRAToARGB(bufferBGRA, strideBGRA, dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun AbgrBuffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertABGRToARGB(bufferABGR, strideABGR, dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun RgbaBuffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertRGBAToARGB(bufferRGBA, strideRGBA, dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun Rgb24Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertRGB24ToARGB(bufferRGB24, strideRGB24, dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun RawBuffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertRAWToARGB(bufferRAW, strideRAW, dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun RawBuffer.convertTo(dst: RgbaBuffer) {
    Yuv.convertRAWToRGBA(bufferRAW, strideRAW, dst.bufferRGBA, dst.strideRGBA, min(width, dst.width), min(height, dst.height))
}

fun Rgb565Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertRGB565ToARGB(bufferRGB565, strideRGB565, dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun Argb1555Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertARGB1555ToARGB(bufferARGB1555, strideARGB1555, dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun Argb4444Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertARGB4444ToARGB(bufferARGB4444, strideARGB4444, dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun Nv12Buffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertNV12ToRGB565(bufferY, strideY, bufferUV, strideUV, dst.bufferRGB565, dst.strideRGB565, min(width, dst.width), min(height, dst.height))
}

fun I422Buffer.convertTo(dst: BgraBuffer) {
    Yuv.convertI422ToBGRA(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferBGRA, dst.strideBGRA, min(width, dst.width), min(height, dst.height))
}

fun I422Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertI422ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun I422Buffer.convertTo(dst: RgbaBuffer) {
    Yuv.convertI422ToRGBA(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferRGBA, dst.strideRGBA, min(width, dst.width), min(height, dst.height))
}

fun I420Buffer.convertTo(dst: ArgbBuffer) {
    Yuv.convertI420ToARGB(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun I420Buffer.convertTo(dst: BgraBuffer) {
    Yuv.convertI420ToBGRA(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferBGRA, dst.strideBGRA, min(width, dst.width), min(height, dst.height))
}

fun I420Buffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertI420ToABGR(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun I420Buffer.convertTo(dst: RgbaBuffer) {
    Yuv.convertI420ToRGBA(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferRGBA, dst.strideRGBA, min(width, dst.width), min(height, dst.height))
}

fun I420Buffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertI420ToRGB24(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferRGB24, dst.strideRGB24, min(width, dst.width), min(height, dst.height))
}

fun I420Buffer.convertTo(dst: RawBuffer) {
    Yuv.convertI420ToRAW(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferRAW, dst.strideRAW, min(width, dst.width), min(height, dst.height))
}

fun H420Buffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertH420ToRGB24(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferRGB24, dst.strideRGB24, min(width, dst.width), min(height, dst.height))
}

fun H420Buffer.convertTo(dst: RawBuffer) {
    Yuv.convertH420ToRAW(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferRAW, dst.strideRAW, min(width, dst.width), min(height, dst.height))
}

fun J420Buffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertJ420ToRGB24(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferRGB24, dst.strideRGB24, min(width, dst.width), min(height, dst.height))
}

fun J420Buffer.convertTo(dst: RawBuffer) {
    Yuv.convertJ420ToRAW(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferRAW, dst.strideRAW, min(width, dst.width), min(height, dst.height))
}

fun I420Buffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertI420ToRGB565(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferRGB565, dst.strideRGB565, min(width, dst.width), min(height, dst.height))
}

fun J420Buffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertJ420ToRGB565(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferRGB565, dst.strideRGB565, min(width, dst.width), min(height, dst.height))
}

fun H420Buffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertH420ToRGB565(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferRGB565, dst.strideRGB565, min(width, dst.width), min(height, dst.height))
}

fun I422Buffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertI422ToRGB565(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferRGB565, dst.strideRGB565, min(width, dst.width), min(height, dst.height))
}

fun I420Buffer.convertTo(dst: Argb1555Buffer) {
    Yuv.convertI420ToARGB1555(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferARGB1555, dst.strideARGB1555, min(width, dst.width), min(height, dst.height))
}

fun I420Buffer.convertTo(dst: Argb4444Buffer) {
    Yuv.convertI420ToARGB4444(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferARGB4444, dst.strideARGB4444, min(width, dst.width), min(height, dst.height))
}

// convert_from

fun I420Buffer.convertTo(dst: I422Buffer) {
    Yuv.convertI420ToI422(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun I420Buffer.convertTo(dst: I444Buffer) {
    Yuv.convertI420ToI444(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun I400Buffer.convertTo(dst: I400Buffer) {
    Yuv.convertI400Copy(bufferY, strideY, dst.bufferY, dst.strideY, min(width, dst.width), min(height, dst.height))
}

fun I420Buffer.convertTo(dst: Nv12Buffer) {
    Yuv.convertI420ToNV12(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, min(width, dst.width), min(height, dst.height))
}

fun I420Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertI420ToNV21(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

// convert_from_argb

fun ArgbBuffer.convertTo(dst: BgraBuffer) {
    Yuv.convertARGBToBGRA(bufferARGB, strideARGB, dst.bufferBGRA, dst.strideBGRA, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: AbgrBuffer) {
    Yuv.convertARGBToABGR(bufferARGB, strideARGB, dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: RgbaBuffer) {
    Yuv.convertARGBToRGBA(bufferARGB, strideARGB, dst.bufferRGBA, dst.strideRGBA, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: Rgb24Buffer) {
    Yuv.convertARGBToRGB24(bufferARGB, strideARGB, dst.bufferRGB24, dst.strideRGB24, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: RawBuffer) {
    Yuv.convertARGBToRAW(bufferARGB, strideARGB, dst.bufferRAW, dst.strideRAW, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: Rgb565Buffer) {
    Yuv.convertARGBToRGB565(bufferARGB, strideARGB, dst.bufferRGB565, dst.strideRGB565, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: Argb1555Buffer) {
    Yuv.convertARGBToARGB1555(bufferARGB, strideARGB, dst.bufferARGB1555, dst.strideARGB1555, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: Argb4444Buffer) {
    Yuv.convertARGBToARGB4444(bufferARGB, strideARGB, dst.bufferARGB4444, dst.strideARGB4444, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: I444Buffer) {
    Yuv.convertARGBToI444(bufferARGB, strideARGB,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: I422Buffer) {
    Yuv.convertARGBToI422(bufferARGB, strideARGB,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: J420Buffer) {
    Yuv.convertARGBToJ420(bufferARGB, strideARGB,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: J422Buffer) {
    Yuv.convertARGBToJ422(bufferARGB, strideARGB,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: J400Buffer) {
    Yuv.convertARGBToJ400(bufferARGB, strideARGB, dst.bufferY, dst.strideY, min(width, dst.width), min(height, dst.height))
}

fun RgbaBuffer.convertTo(dst: J400Buffer) {
    Yuv.convertRGBAToJ400(bufferRGBA, strideRGBA, dst.bufferY, dst.strideY, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: I400Buffer) {
    Yuv.convertARGBToI400(bufferARGB, strideARGB, dst.bufferY, dst.strideY, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: Nv12Buffer) {
    Yuv.convertARGBToNV12(bufferARGB, strideARGB, dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertARGBToNV21(bufferARGB, strideARGB, dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

fun AbgrBuffer.convertTo(dst: Nv12Buffer) {
    Yuv.convertABGRToNV12(bufferABGR, strideABGR, dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, min(width, dst.width), min(height, dst.height))
}

fun AbgrBuffer.convertTo(dst: Nv21Buffer) {
    Yuv.convertABGRToNV21(bufferABGR, strideABGR, dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

// planar_functions

fun Nv21Buffer.convertTo(dst: Nv12Buffer) {
    Yuv.planerNV21ToNV12(bufferY, strideY, bufferVU, strideVU,
            dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, min(width, dst.width), min(height, dst.height))
}

fun Nv12Buffer.convertTo(dst: Nv21Buffer) {
    Yuv.planerNV21ToNV12(bufferY, strideY, bufferUV, strideUV,
            dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

fun I400Buffer.mirrorTo(dst: I400Buffer) {
    Yuv.planerI400Mirror(bufferY, strideY, dst.bufferY, dst.strideY, min(width, dst.width), min(height, dst.height))
}

fun I420Buffer.mirrorTo(dst: I420Buffer) {
    Yuv.planerI420Mirror(bufferY, strideY, bufferU, strideU, bufferV, strideV,
            dst.bufferY, dst.strideY, dst.bufferU, dst.strideU, dst.bufferV, dst.strideV,
            min(width, dst.width), min(height, dst.height))
}

fun Nv12Buffer.mirrorTo(dst: Nv12Buffer) {
    Yuv.planerNV12Mirror(bufferY, strideY, bufferUV, strideUV, dst.bufferY, dst.strideY, dst.bufferUV, dst.strideUV, min(width, dst.width), min(height, dst.height))
}

fun Nv21Buffer.mirrorTo(dst: Nv21Buffer) {
    Yuv.planerNV12Mirror(bufferY, strideY, bufferVU, strideVU, dst.bufferY, dst.strideY, dst.bufferVU, dst.strideVU, min(width, dst.width), min(height, dst.height))
}

fun AbgrBuffer.mirrorTo(dst: AbgrBuffer) {
    Yuv.planerARGBMirror(bufferABGR, strideABGR, dst.bufferABGR, dst.strideABGR, min(width, dst.width), min(height, dst.height))
}

fun ArgbBuffer.mirrorTo(dst: ArgbBuffer) {
    Yuv.planerARGBMirror(bufferARGB, strideARGB, dst.bufferARGB, dst.strideARGB, min(width, dst.width), min(height, dst.height))
}

fun BgraBuffer.mirrorTo(dst: BgraBuffer) {
    Yuv.planerARGBMirror(bufferBGRA, strideBGRA, dst.bufferBGRA, dst.strideBGRA, min(width, dst.width), min(height, dst.height))
}

fun RgbaBuffer.mirrorTo(dst: RgbaBuffer) {
    Yuv.planerARGBMirror(bufferRGBA, strideRGBA, dst.bufferRGBA, dst.strideRGBA, min(width, dst.width), min(height, dst.height))
}

fun Rgb24Buffer.mirrorTo(dst: Rgb24Buffer) {
    Yuv.planerRGB24Mirror(bufferRGB24, strideRGB24, dst.bufferRGB24, dst.strideRGB24, min(width, dst.width), min(height, dst.height))
}

fun RawBuffer.mirrorTo(dst: RawBuffer) {
    Yuv.planerRGB24Mirror(bufferRAW, strideRAW, dst.bufferRAW, dst.strideRAW, min(width, dst.width), min(height, dst.height))
}

// to Bitmap

@Suppress("NOTHING_TO_INLINE")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
private inline fun toBitmap(rs: RenderScript, element: Element, data: ByteArray, width: Int, height: Int, config: Bitmap.Config): Bitmap {
    val type = Type.Builder(rs, element).also {
        it.setX(width)
        it.setY(height)
    }.create()

    val allocation = Allocation.createTyped(rs, type)
    allocation.copyFromUnchecked(data)

    val bitmap = Bitmap.createBitmap(width, height, config)
    allocation.copyTo(bitmap)

    allocation.destroy()

    return bitmap
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun AbgrBuffer.toBitmap(rs: RenderScript): Bitmap {
    return toBitmap(rs, Element.RGBA_8888(rs), asByteArray(), width, height, Bitmap.Config.ARGB_8888)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun Rgb565Buffer.toBitmap(rs: RenderScript): Bitmap {
    return toBitmap(rs, Element.RGB_565(rs), asByteArray(), width, height, Bitmap.Config.RGB_565)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun Argb1555Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = ArgbBuffer.allocate(width, height)
    convertTo(tempBuffer)
    val temp2Buffer = AbgrBuffer.allocate(width, height)
    tempBuffer.convertTo(temp2Buffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun Argb4444Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = ArgbBuffer.allocate(width, height)
    convertTo(tempBuffer)
    val temp2Buffer = AbgrBuffer.allocate(width, height)
    tempBuffer.convertTo(temp2Buffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun ArgbBuffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = AbgrBuffer.allocate(width, height)
    convertTo(tempBuffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun BgraBuffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = ArgbBuffer.allocate(width, height)
    convertTo(tempBuffer)
    val temp2Buffer = AbgrBuffer.allocate(width, height)
    tempBuffer.convertTo(temp2Buffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun H420Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = AbgrBuffer.allocate(width, height)
    convertTo(tempBuffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun H422Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = AbgrBuffer.allocate(width, height)
    convertTo(tempBuffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun H444Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = AbgrBuffer.allocate(width, height)
    convertTo(tempBuffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun I400Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = ArgbBuffer.allocate(width, height)
    convertTo(tempBuffer)
    val temp2Buffer = AbgrBuffer.allocate(width, height)
    tempBuffer.convertTo(temp2Buffer)

    return temp2Buffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun I420Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = AbgrBuffer.allocate(width, height)
    convertTo(tempBuffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun I422Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = AbgrBuffer.allocate(width, height)
    convertTo(tempBuffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun I444Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = AbgrBuffer.allocate(width, height)
    convertTo(tempBuffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun J400Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = ArgbBuffer.allocate(width, height)
    convertTo(tempBuffer)
    val temp2Buffer = AbgrBuffer.allocate(width, height)
    tempBuffer.convertTo(temp2Buffer)

    return temp2Buffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun J420Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = AbgrBuffer.allocate(width, height)
    convertTo(tempBuffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun J422Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = AbgrBuffer.allocate(width, height)
    convertTo(tempBuffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun J444Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = AbgrBuffer.allocate(width, height)
    convertTo(tempBuffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun Nv12Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = AbgrBuffer.allocate(width, height)
    convertTo(tempBuffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun Nv21Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = AbgrBuffer.allocate(width, height)
    convertTo(tempBuffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun RawBuffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = ArgbBuffer.allocate(width, height)
    convertTo(tempBuffer)
    val temp2Buffer = AbgrBuffer.allocate(width, height)
    tempBuffer.convertTo(temp2Buffer)

    return temp2Buffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun Rgb24Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = ArgbBuffer.allocate(width, height)
    convertTo(tempBuffer)
    val temp2Buffer = AbgrBuffer.allocate(width, height)
    tempBuffer.convertTo(temp2Buffer)

    return temp2Buffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun U420Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = AbgrBuffer.allocate(width, height)
    convertTo(tempBuffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun U422Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = AbgrBuffer.allocate(width, height)
    convertTo(tempBuffer)

    return tempBuffer.toBitmap(rs)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun U444Buffer.toBitmap(rs: RenderScript): Bitmap {
    val tempBuffer = AbgrBuffer.allocate(width, height)
    convertTo(tempBuffer)

    return tempBuffer.toBitmap(rs)
}
