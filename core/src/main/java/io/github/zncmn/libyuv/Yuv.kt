package io.github.zncmn.libyuv

import java.nio.ByteBuffer

internal object Yuv {
    init {
        System.loadLibrary("yuv")
    }

    // convert.cpp

    /** Convert I444 to I420 */
    external fun convertI444ToI420(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                   width: Int, height: Int)

    /** Convert I444 to NV21 */
    external fun convertI444ToNV21(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstVU: ByteBuffer, dstStrideVU: Int,
                                   width: Int, height: Int)

    /** Convert I422 to I420 */
    external fun convertI422ToI420(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                   width: Int, height: Int)

    /** Convert I422 to NV21 */
    external fun convertI422ToNV21(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstVU: ByteBuffer, dstStrideVU: Int,
                                   width: Int, height: Int)

    /** Copy I420 to I420 */
    external fun convertI420Copy(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                 dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                 width: Int, height: Int)

    /** Convert I400 to I420 */
    external fun convertI400ToI420(srcY: ByteBuffer, srcStrideY: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                   width: Int, height: Int)

    /** Convert I400 to NV21 */
    external fun convertI400ToNV21(srcY: ByteBuffer, srcStrideY: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstVU: ByteBuffer, dstStrideVU: Int,
                                   width: Int, height: Int)

    /** Convert NV12 to I420 */
    external fun convertNV12ToI420(srcY: ByteBuffer, srcStrideY: Int, srcUV: ByteBuffer, srcStrideVU: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                   width: Int, height: Int)

    /** Convert NV21 to I420 */
    external fun convertNV21ToI420(srcY: ByteBuffer, srcStrideY: Int, srcVU: ByteBuffer, srcStrideVU: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                   width: Int, height: Int)

    /** ARGB little endian (bgra in memory) to I420 */
    external fun convertARGBToI420(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                   width: Int, height: Int)

    /** BGRA little endian (argb in memory) to I420 */
    external fun convertBGRAToI420(srcBGRA: ByteBuffer, srcStrideBGRA: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                   width: Int, height: Int)

    /** ABGR little endian (rgba in memory) to I420 */
    external fun convertABGRToI420(srcABGR: ByteBuffer, srcStrideABGR: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                   width: Int, height: Int)

    /** RGBA little endian (abgr in memory) to I420 */
    external fun convertRGBAToI420(srcRGBA: ByteBuffer, srcStrideRGBA: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                   width: Int, height: Int)

    /** RGB little endian (bgr in memory) to I420 */
    external fun convertRGB24ToI420(srcRGB24: ByteBuffer, srcStrideRGB24: Int,
                                    dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                    width: Int, height: Int)

    /** RGB little endian (bgr in memory) to J420 */
    external fun convertRGB24ToJ420(srcRGB24: ByteBuffer, srcStrideRGB24: Int,
                                    dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                    width: Int, height: Int)

    /** RGB big endian (rgb in memory) to I420 */
    external fun convertRAWToI420(srcRAW: ByteBuffer, srcStrideRAW: Int,
                                  dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                  width: Int, height: Int)

    /** RGB16 (RGBP fourcc) little endian to I420 */
    external fun convertRGB565ToI420(srcRGB565: ByteBuffer, srcStrideRGB565: Int,
                                     dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                     width: Int, height: Int)

    /** RGB15 (RGBO fourcc) little endian to I420 */
    external fun convertARGB1555ToI420(srcARGB1555: ByteBuffer, srcStrideARGB1555: Int,
                                       dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                       width: Int, height: Int)

    /** RGB12 (R444 fourcc) little endian to I420 */
    external fun convertARGB4444ToI420(srcARGB4444: ByteBuffer, srcStrideARGB4444: Int,
                                       dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                       width: Int, height: Int)

    /** RGB little endian (bgr in memory) to J400 */
    external fun convertRGB24ToJ400(srcRGB24: ByteBuffer, srcStrideRGB24: Int,
                                    dstYJ: ByteBuffer, dstStrideYJ: Int,
                                    width: Int, height: Int)

    /** RGB big endian (rgb in memory) to J400 */
    external fun convertRAWToJ400(srcRAW: ByteBuffer, srcStrideRAW: Int,
                                  dstYJ: ByteBuffer, dstStrideYJ: Int,
                                  width: Int, height: Int)

    // convert_argb.cpp

    /** Copy ARGB to ARGB */
    external fun convertARGBCopy(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                 dstARGB: ByteBuffer, dstStrideARGB: Int,
                                 width: Int, height: Int)

    /** Convert I420 to ARGB */
    external fun convertI420ToARGB(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstARGB: ByteBuffer, dstStrideARGB: Int,
                                   width: Int, height: Int)

    /** Convert I420 to ABGR */
    external fun convertI420ToABGR(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstABGR: ByteBuffer, dstStrideABGR: Int,
                                   width: Int, height: Int)

    /** Convert I422 to ARGB */
    external fun convertI422ToARGB(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstARGB: ByteBuffer, dstStrideARGB: Int,
                                   width: Int, height: Int)

    /** Convert I422 to ABGR */
    external fun convertI422ToABGR(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstABGR: ByteBuffer, dstStrideABGR: Int,
                                   width: Int, height: Int)

    /** Convert I444 to ARGB */
    external fun convertI444ToARGB(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstARGB: ByteBuffer, dstStrideARGB: Int,
                                   width: Int, height: Int)

    /** Convert I444 to ABGR */
    external fun convertI444ToABGR(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstABGR: ByteBuffer, dstStrideABGR: Int,
                                   width: Int, height: Int)

    /** Convert I400 (grey) to ARGB.  Reverse of ARGBToI400 */
    external fun convertI400ToARGB(srcY: ByteBuffer, srcStrideY: Int,
                                   dstABGR: ByteBuffer, dstStrideABGR: Int,
                                   width: Int, height: Int)

    /** Convert J400 (jpeg grey) to ARGB */
    external fun convertJ400ToARGB(srcY: ByteBuffer, srcStrideY: Int,
                                   dstABGR: ByteBuffer, dstStrideABGR: Int,
                                   width: Int, height: Int)

    /** Convert NV12 to ARGB */
    external fun convertNV12ToARGB(srcY: ByteBuffer, srcStrideY: Int, srcUV: ByteBuffer, srcStrideUV: Int,
                                   dstARGB: ByteBuffer, dstStrideARGB: Int,
                                   width: Int, height: Int)

    /** Convert NV21 to ARGB */
    external fun convertNV21ToARGB(srcY: ByteBuffer, srcStrideY: Int, srcVU: ByteBuffer, srcStrideVU: Int,
                                   dstARGB: ByteBuffer, dstStrideARGB: Int,
                                   width: Int, height: Int)

    /** Convert NV12 to ABGR */
    external fun convertNV12ToABGR(srcY: ByteBuffer, srcStrideY: Int, srcUV: ByteBuffer, srcStrideUV: Int,
                                   dstABGR: ByteBuffer, dstStrideABGR: Int,
                                   width: Int, height: Int)

    /** Convert NV21 to ABGR */
    external fun convertNV21ToABGR(srcY: ByteBuffer, srcStrideY: Int, srcVU: ByteBuffer, srcStrideVU: Int,
                                   dstABGR: ByteBuffer, dstStrideABGR: Int,
                                   width: Int, height: Int)

    /** Convert NV12 to RGB24 */
    external fun convertNV12ToRGB24(srcY: ByteBuffer, srcStrideY: Int, srcUV: ByteBuffer, srcStrideUV: Int,
                                    dstRGB24: ByteBuffer, dstStrideRGB24: Int,
                                    width: Int, height: Int)

    /** Convert NV21 to RGB24 */
    external fun convertNV21ToRGB24(srcY: ByteBuffer, srcStrideY: Int, srcVU: ByteBuffer, srcStrideVU: Int,
                                    dstRGB24: ByteBuffer, dstStrideRGB24: Int,
                                    width: Int, height: Int)

    /** Convert NV12 to RAW */
    external fun convertNV12ToRAW(srcY: ByteBuffer, srcStrideY: Int, srcUV: ByteBuffer, srcStrideUV: Int,
                                  dstRAW: ByteBuffer, dstStrideRAW: Int,
                                  width: Int, height: Int)

    /** Convert NV21 to RAW */
    external fun convertNV21ToRAW(srcY: ByteBuffer, srcStrideY: Int, srcVU: ByteBuffer, srcStrideVU: Int,
                                  dstRAW: ByteBuffer, dstStrideRAW: Int,
                                  width: Int, height: Int)

    /** BGRA little endian (argb in memory) to ARGB */
    external fun convertBGRAToARGB(srcBGRA: ByteBuffer, srcStrideBGRA: Int,
                                   dstARGB: ByteBuffer, dstStrideARGB: Int,
                                   width: Int, height: Int)

    /** ABGR little endian (rgba in memory) to ARGB */
    external fun convertABGRToARGB(srcABGR: ByteBuffer, srcStrideABGR: Int,
                                   dstARGB: ByteBuffer, dstStrideARGB: Int,
                                   width: Int, height: Int)

    /** RGBA little endian (abgr in memory) to ARGB */
    external fun convertRGBAToARGB(srcRGBA: ByteBuffer, srcStrideRGBA: Int,
                                   dstARGB: ByteBuffer, dstStrideARGB: Int,
                                   width: Int, height: Int)

    /** RGB little endian (bgr in memory) to ARGB */
    external fun convertRGB24ToARGB(srcRGB24: ByteBuffer, srcStrideRGB24: Int,
                                    dstARGB: ByteBuffer, dstStrideARGB: Int,
                                    width: Int, height: Int)

    /** RGB big endian (rgb in memory) to ARGB */
    external fun convertRAWToARGB(srcRAW: ByteBuffer, srcStrideRAW: Int,
                                  dstARGB: ByteBuffer, dstStrideARGB: Int,
                                  width: Int, height: Int)

    /** RGB big endian (rgb in memory) to RGBA */
    external fun convertRAWToRGBA(srcRAW: ByteBuffer, srcStrideRAW: Int,
                                  dstRGBA: ByteBuffer, dstStrideRGBA: Int,
                                  width: Int, height: Int)

    /** RGB16 (RGBP fourcc) little endian to ARGB */
    external fun convertRGB565ToARGB(srcRGB565: ByteBuffer, srcStrideRGB565: Int,
                                     dstARGB: ByteBuffer, dstStrideARGB: Int,
                                     width: Int, height: Int)

    /** RGB15 (RGBO fourcc) little endian to ARGB */
    external fun convertARGB1555ToARGB(srcARGB1555: ByteBuffer, srcStrideARGB1555: Int,
                                       dstARGB: ByteBuffer, dstStrideARGB: Int,
                                       width: Int, height: Int)

    /** RGB12 (R444 fourcc) little endian to ARGB */
    external fun convertARGB4444ToARGB(srcARGB4444: ByteBuffer, srcStrideARGB4444: Int,
                                       dstARGB: ByteBuffer, dstStrideARGB: Int,
                                       width: Int, height: Int)

    // convert_from.cpp

    external fun convertI420ToI422(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                   width: Int, height: Int)

    external fun convertI420ToI444(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                   width: Int, height: Int)

    /** Copy to I400. Source can be I420, I422, I444, I400, NV12 or NV21 */
    external fun convertI400Copy(srcY: ByteBuffer, srcStrideY: Int,
                                 dstY: ByteBuffer, dstStrideY: Int,
                                 width: Int, height: Int)

    external fun convertI420ToNV12(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstUV: ByteBuffer, dstStrideUV: Int,
                                   width: Int, height: Int)

    external fun convertI420ToNV21(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstVU: ByteBuffer, dstStrideVU: Int,
                                   width: Int, height: Int)

    external fun convertI420ToBGRA(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstBGRA: ByteBuffer, dstStrideBGRA: Int,
                                   width: Int, height: Int)

    external fun convertI420ToRGBA(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                   dstRGBA: ByteBuffer, dstStrideRGBA: Int,
                                   width: Int, height: Int)

    external fun convertI420ToRGB24(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                    dstRGB24: ByteBuffer, dstStrideRGB24: Int,
                                    width: Int, height: Int)

    external fun convertI420ToRAW(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                  dstRAW: ByteBuffer, dstStrideRAW: Int,
                                  width: Int, height: Int)

    external fun convertH420ToRGB24(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                    dstRGB24: ByteBuffer, dstStrideRGB24: Int,
                                    width: Int, height: Int)

    external fun convertH420ToRAW(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                  dstRAW: ByteBuffer, dstStrideRAW: Int,
                                  width: Int, height: Int)

    external fun convertJ420ToRGB24(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                    dstRGB24: ByteBuffer, dstStrideRGB24: Int,
                                    width: Int, height: Int)

    external fun convertJ420ToRAW(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                  dstRAW: ByteBuffer, dstStrideRAW: Int,
                                  width: Int, height: Int)

    external fun convertI420ToRGB565(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                     dstRGB565: ByteBuffer, dstStrideRGB565: Int,
                                     width: Int, height: Int)

    external fun convertJ420ToRGB565(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                     dstRGB565: ByteBuffer, dstStrideRGB565: Int,
                                     width: Int, height: Int)

    external fun convertH420ToRGB565(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                     dstRGB565: ByteBuffer, dstStrideRGB565: Int,
                                     width: Int, height: Int)

    external fun convertI422ToRGB565(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                     dstRGB565: ByteBuffer, dstStrideRGB565: Int,
                                     width: Int, height: Int)

    external fun convertI420ToARGB1555(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                       dstARGB1555: ByteBuffer, dstStrideARGB1555: Int,
                                       width: Int, height: Int)

    external fun convertI420ToARGB4444(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                       dstARGB4444: ByteBuffer, dstStrideARGB4444: Int,
                                       width: Int, height: Int)

    // convert_from_argb.cpp

    // Convert ARGB To BGRA
    external fun convertARGBToBGRA(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                   dstBGRA: ByteBuffer, dstStrideBGRA: Int,
                                   width: Int, height: Int)

    // Convert ARGB To ABGR
    external fun convertARGBToABGR(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                   dstABGR: ByteBuffer, dstStrideABGR: Int,
                                   width: Int, height: Int)

    // Convert ARGB To RGBA
    external fun convertARGBToRGBA(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                   dstRGBA: ByteBuffer, dstStrideRGBA: Int,
                                   width: Int, height: Int)

    // Convert ARGB To RGB24
    external fun convertARGBToRGB24(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                    dstRGB24: ByteBuffer, dstStrideRGB24: Int,
                                    width: Int, height: Int)

    // Convert ARGB To RAW
    external fun convertARGBToRAW(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                  dstRAW: ByteBuffer, dstStrideRAW: Int,
                                  width: Int, height: Int)

    // Convert ARGB To RGB565
    external fun convertARGBToRGB565(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                     dstRGB565: ByteBuffer, dstStrideRGB565: Int,
                                     width: Int, height: Int)

    // Convert ARGB To ARGB1555
    external fun convertARGBToARGB1555(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                       dstARGB1555: ByteBuffer, dstStrideARGB1555: Int,
                                       width: Int, height: Int)

    // Convert ARGB To ARGB4444
    external fun convertARGBToARGB4444(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                       dstARGB4444: ByteBuffer, dstStrideARGB4444: Int,
                                       width: Int, height: Int)

    // Convert ARGB To I444
    external fun convertARGBToI444(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                   width: Int, height: Int)

    // Convert ARGB To I422
    external fun convertARGBToI422(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                   width: Int, height: Int)

    // Convert ARGB to J420. (JPeg full range I420)
    external fun convertARGBToJ420(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                   width: Int, height: Int)

    // Convert ARGB to J422
    external fun convertARGBToJ422(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                   width: Int, height: Int)

    // Convert ARGB to J400. (JPeg full range)
    external fun convertARGBToJ400(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                   dstYJ: ByteBuffer, dstStrideYJ: Int,
                                   width: Int, height: Int)

    // Convert RGBA to J400. (JPeg full range)
    external fun convertRGBAToJ400(srcRGBA: ByteBuffer, srcStrideRGBA: Int,
                                   dstYJ: ByteBuffer, dstStrideYJ: Int,
                                   width: Int, height: Int)

    // Convert ARGB to I400
    external fun convertARGBToI400(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                   dstY: ByteBuffer, dstStrideY: Int,
                                   width: Int, height: Int)

    // Convert ARGB To NV12
    external fun convertARGBToNV12(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstUV: ByteBuffer, dstStrideUV: Int,
                                   width: Int, height: Int)

    // Convert ARGB To NV21
    external fun convertARGBToNV21(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstVU: ByteBuffer, dstStrideVU: Int,
                                   width: Int, height: Int)

    // Convert ABGR To NV12
    external fun convertABGRToNV12(srcABGR: ByteBuffer, srcStrideABGR: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstUV: ByteBuffer, dstStrideUV: Int,
                                   width: Int, height: Int)

    // Convert ABGR To NV21
    external fun convertABGRToNV21(srcABGR: ByteBuffer, srcStrideABGR: Int,
                                   dstY: ByteBuffer, dstStrideY: Int, dstVU: ByteBuffer, dstStrideVU: Int,
                                   width: Int, height: Int)

    // rotate.cpp

    // Rotate I420 frame
    external fun rotateI420Rotate(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                  dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                  width: Int, height: Int, rotateMode: Int)

    // Rotate I444 frame
    external fun rotateI444Rotate(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int,
                                  dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                  width: Int, height: Int, rotateMode: Int)

    // Rotate NV12 input and store in I420
    external fun rotateNV12ToI420Rotate(srcY: ByteBuffer, srcStrideY: Int, srcUV: ByteBuffer, srcStrideUV: Int,
                                        dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int,
                                        width: Int, height: Int, rotateMode: Int)

    // Rotate a plane by 0, 90, 180, or 270
    external fun rotateRotatePlane(src: ByteBuffer, srcStride: Int,
                                   dst: ByteBuffer, dstStride: Int,
                                   width: Int, height: Int, rotateMode: Int)

    external fun rotateRotateUV90(src: ByteBuffer, srcStride: Int,
                                  dstA: ByteBuffer, dstStrideA: Int, dstB: ByteBuffer, dstStrideB: Int,
                                  width: Int, height: Int)

    // Rotations for when U and V are interleaved. Deprecated
    external fun rotateRotateUV180(src: ByteBuffer, srcStride: Int,
                                   dstA: ByteBuffer, dstStrideA: Int, dstB: ByteBuffer, dstStrideB: Int,
                                   width: Int, height: Int)

    external fun rotateRotateUV270(src: ByteBuffer, srcStride: Int,
                                   dstA: ByteBuffer, dstStrideA: Int, dstB: ByteBuffer, dstStrideB: Int,
                                   width: Int, height: Int)

    // The 90 and 270 functions are based on transposes. Deprecated
    external fun rotateTransposePlane(src: ByteBuffer, srcStride: Int,
                                      dst: ByteBuffer, dstStride: Int,
                                      width: Int, height: Int)

    external fun rotateTransposeUV(src: ByteBuffer, srcStride: Int,
                                   dstA: ByteBuffer, dstStrideA: Int, dstB: ByteBuffer, dstStrideB: Int,
                                   width: Int, height: Int)

    // rotate_argb.cpp

    // Rotate ARGB frame
    external fun rotateARGBRotate(srcARGB: ByteBuffer, srcStrideARGB: Int,
                                  dstARGB: ByteBuffer, dstStrideARGB: Int,
                                  width: Int, height: Int, rotateMode: Int)

    // scale.cpp

    external fun scaleScalePlane(src: ByteBuffer, srcStride: Int, srcWidth: Int, srcHeight: Int,
                                 dst: ByteBuffer, dstStride: Int, dstWidth: Int, dstHeight: Int,
                                 filterMode: Int)

    external fun scaleI420Scale(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int, srcWidth: Int, srcHeight: Int,
                                dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int, dstWidth: Int, dstHeight: Int,
                                filterMode: Int)

    external fun scaleI444Scale(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int, srcWidth: Int, srcHeight: Int,
                                dstY: ByteBuffer, dstStrideY: Int, dstU: ByteBuffer, dstStrideU: Int, dstV: ByteBuffer, dstStrideV: Int, dstWidth: Int, dstHeight: Int,
                                filterMode: Int)

    // scale_argb.cpp

    external fun scaleARGBScale(srcARGB: ByteBuffer, srcStrideARGB: Int, srcWidth: Int, srcHeight: Int,
                                dstARGB: ByteBuffer, dstStrideARGB: Int, dstWidth: Int, dstHeight: Int,
                                filterMode: Int)

    // Clipped scale takes destination rectangle coordinates for clip values
    external fun scaleARGBScaleClip(srcARGB: ByteBuffer, srcStrideARGB: Int, srcWidth: Int, srcHeight: Int,
                                    dstARGB: ByteBuffer, dstStrideARGB: Int, dstWidth: Int, dstHeight: Int,
                                    clipX: Int, clipY: Int, clipWidth: Int, clipHeight: Int,
                                    filterMode: Int)

    // Scale with YUV conversion to ARGB and clipping
    external fun scaleYUVToARGBScaleClip(srcY: ByteBuffer, srcStrideY: Int, srcU: ByteBuffer, srcStrideU: Int, srcV: ByteBuffer, srcStrideV: Int, srcFourcc: Int, srcWidth: Int, srcHeight: Int,
                                         dstARGB: ByteBuffer, dstStrideARGB: Int, dstFourcc: Int, dstWidth: Int, dstHeight: Int,
                                         clipX: Int, clipY: Int, clipWidth: Int, clipHeight: Int,
                                         filterMode: Int)

    // memcopy.cpp

    external fun memcopy(dst: Any,
                         src1: Any, src1Length: Int)

}
