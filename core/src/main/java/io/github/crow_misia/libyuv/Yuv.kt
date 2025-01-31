package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

object Yuv {
    init {
        System.loadLibrary("yuv_android")
    }

    // helper.cpp
    external fun allocNativeBuffer(size: Int): ByteBuffer
    external fun freeNativeBuffer(buffer: ByteBuffer)

    // convert.cpp

    /** Convert I444 to I420 */
    @JvmName("convertI444ToI420")
    external fun convertI444ToI420(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert I444 to NV12 */
    @JvmName("convertI444ToNV12")
    external fun convertI444ToNV12(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstUV: ByteBuffer, dstStrideUV: RowStride, dstOffsetUV: Int,
        width: Int, height: Int,
    )

    /** Convert I444 to NV21 */
    @JvmName("convertI444ToNV21")
    external fun convertI444ToNV21(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstVU: ByteBuffer, dstStrideVU: RowStride, dstOffsetVU: Int,
        width: Int, height: Int,
    )

    /** Convert I422 to I420 */
    @JvmName("convertI422ToI420")
    external fun convertI422ToI420(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert I422 to I444 */
    @JvmName("convertI422ToI444")
    external fun convertI422ToI444(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert I422 to NV21 */
    @JvmName("convertI422ToNV21")
    external fun convertI422ToNV21(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstVU: ByteBuffer, dstStrideVU: RowStride, dstOffsetVU: Int,
        width: Int, height: Int,
    )

    /** Copy I420 to I420 */
    @JvmName("convertI420Copy")
    external fun convertI420Copy(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert I400 (grey) to I420 */
    @JvmName("convertI400ToI420")
    external fun convertI400ToI420(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert I400 (grey) to NV21 / NV12 */
    @JvmName("convertI400ToNV21")
    external fun convertI400ToNV21(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstVU: ByteBuffer, dstStrideVU: RowStride, dstOffsetVU: Int,
        width: Int, height: Int,
    )

    /** Convert NV12 to I420 */
    @JvmName("convertNV12ToI420")
    external fun convertNV12ToI420(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcUV: ByteBuffer, srcStrideUV: RowStride, srcOffsetUV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert NV21 to I420 */
    @JvmName("convertNV21ToI420")
    external fun convertNV21ToI420(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcVU: ByteBuffer, srcStrideVU: RowStride, srcOffsetVU: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert YUY2 to I420 */
    @JvmName("convertYUY2ToI420")
    external fun convertYUY2ToI420(
        srcYUY2: ByteBuffer, srcStrideYUY2: RowStride, srcOffsetYUY2: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert UYVY to I420 */
    @JvmName("convertUYVYToI420")
    external fun convertUYVYToI420(
        srcUYVY: ByteBuffer, srcStrideUYVY: RowStride, srcOffsetUYVY: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert AYUV to NV12 */
    @JvmName("convertAYUVToNV12")
    external fun convertAYUVToNV12(
        srcAYUV: ByteBuffer, srcStrideAYUV: RowStride, srcOffsetAYUV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstUV: ByteBuffer, dstStrideUV: RowStride, dstOffsetUV: Int,
        width: Int, height: Int,
    )

    /** Convert AYUV to NV21 */
    @JvmName("convertAYUVToNV21")
    external fun convertAYUVToNV21(
        srcAYUV: ByteBuffer, srcStrideAYUV: RowStride, srcOffsetAYUV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstVU: ByteBuffer, dstStrideVU: RowStride, dstOffsetVU: Int,
        width: Int, height: Int,
    )

    /** ARGB little endian (bgra in memory) to I420 */
    @JvmName("convertARGBToI420")
    external fun convertARGBToI420(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** BGRA little endian (argb in memory) to I420 */
    @JvmName("convertBGRAToI420")
    external fun convertBGRAToI420(
        srcBGRA: ByteBuffer, srcStrideBGRA: RowStride, srcOffsetBGRA: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** ABGR little endian (rgba in memory) to I420 */
    @JvmName("convertABGRToI420")
    external fun convertABGRToI420(
        srcABGR: ByteBuffer, srcStrideABGR: RowStride, srcOffsetABGR: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** RGBA little endian (abgr in memory) to I420 */
    @JvmName("convertRGBAToI420")
    external fun convertRGBAToI420(
        srcRGBA: ByteBuffer, srcStrideRGBA: RowStride, srcOffsetRGBA: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** RGB little endian (bgr in memory) to I420 */
    @JvmName("convertRGB24ToI420")
    external fun convertRGB24ToI420(
        srcRGB24: ByteBuffer, srcStrideRGB24: RowStride, srcOffsetRGB24: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** RGB little endian (bgr in memory) to J420 */
    @JvmName("convertRGB24ToJ420")
    external fun convertRGB24ToJ420(
        srcRGB24: ByteBuffer, srcStrideRGB24: RowStride, srcOffsetRGB24: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** RGB big endian (rgb in memory) to I420 */
    @JvmName("convertRAWToI420")
    external fun convertRAWToI420(
        srcRAW: ByteBuffer, srcStrideRAW: RowStride, srcOffsetRAW: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** RGB big endian (rgb in memory) to J420 */
    @JvmName("convertRAWToJ420")
    external fun convertRAWToJ420(
        srcRAW: ByteBuffer, srcStrideRAW: RowStride, srcOffsetRAW: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** RGB16 (RGBP fourcc) little endian to I420 */
    @JvmName("convertRGB565ToI420")
    external fun convertRGB565ToI420(
        srcRGB565: ByteBuffer, srcStrideRGB565: RowStride, srcOffsetRGB565: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** RGB15 (RGBO fourcc) little endian to I420 */
    @JvmName("convertARGB1555ToI420")
    external fun convertARGB1555ToI420(
        srcARGB1555: ByteBuffer, srcStrideARGB1555: RowStride, srcOffsetARGB1555: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** RGB12 (R444 fourcc) little endian to I420 */
    @JvmName("convertARGB4444ToI420")
    external fun convertARGB4444ToI420(
        srcARGB4444: ByteBuffer, srcStrideARGB4444: RowStride, srcOffsetARGB4444: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** RGB little endian (bgr in memory) to J400 */
    @JvmName("convertRGB24ToJ400")
    external fun convertRGB24ToJ400(
        srcRGB24: ByteBuffer, srcStrideRGB24: RowStride, srcOffsetRGB24: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        width: Int, height: Int,
    )

    /** RGB big endian (rgb in memory) to J400 */
    @JvmName("convertRAWToJ400")
    external fun convertRAWToJ400(
        srcRAW: ByteBuffer, srcStrideRAW: RowStride, srcOffsetRAW: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        width: Int, height: Int,
    )

    /** Copy ARGB to ARGB */
    @JvmName("convertARGBCopy")
    external fun convertARGBCopy(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert J420 to ARGB */
    @JvmName("convertJ420ToARGB")
    external fun convertJ420ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert J420 to ABGR */
    @JvmName("convertJ420ToABGR")
    external fun convertJ420ToABGR(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert H420 to ARGB */
    @JvmName("convertH420ToARGB")
    external fun convertH420ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert H420 to ABGR */
    @JvmName("convertH420ToABGR")
    external fun convertH420ToABGR(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert U420 to ARGB */
    @JvmName("convertU420ToARGB")
    external fun convertU420ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert U420 to ABGR */
    @JvmName("convertU420ToABGR")
    external fun convertU420ToABGR(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert I422 to ARGB */
    @JvmName("convertI422ToARGB")
    external fun convertI422ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert J422 to ARGB */
    @JvmName("convertJ422ToARGB")
    external fun convertJ422ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert J422 to ABGR */
    @JvmName("convertJ422ToABGR")
    external fun convertJ422ToABGR(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert H422 to ARGB */
    @JvmName("convertH422ToARGB")
    external fun convertH422ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert H422 to ABGR */
    @JvmName("convertH422ToABGR")
    external fun convertH422ToABGR(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert U422 to ARGB */
    @JvmName("convertU422ToARGB")
    external fun convertU422ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert U422 to ABGR */
    @JvmName("convertU422ToABGR")
    external fun convertU422ToABGR(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert I444 to ARGB */
    @JvmName("convertI444ToARGB")
    external fun convertI444ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert I444 to ABGR */
    @JvmName("convertI444ToABGR")
    external fun convertI444ToABGR(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert J444 to ARGB */
    @JvmName("convertJ444ToARGB")
    external fun convertJ444ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert J444 to ABGR */
    @JvmName("convertJ444ToABGR")
    external fun convertJ444ToABGR(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert H444 to ARGB */
    @JvmName("convertH444ToARGB")
    external fun convertH444ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert H444 to ABGR */
    @JvmName("convertH444ToABGR")
    external fun convertH444ToABGR(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert U444 to ARGB */
    @JvmName("convertU444ToARGB")
    external fun convertU444ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert U444 to ABGR */
    @JvmName("convertU444ToABGR")
    external fun convertU444ToABGR(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert I444 to RGB24 */
    @JvmName("convertI444ToRGB24")
    external fun convertI444ToRGB24(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRGB24: ByteBuffer, dstStrideRGB24: RowStride, dstOffsetRGB24: Int,
        width: Int, height: Int,
    )

    /** Convert I444 to RAW */
    @JvmName("convertI444ToRAW")
    external fun convertI444ToRAW(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRAW: ByteBuffer, dstStrideRAW: RowStride, dstOffsetRAW: Int,
        width: Int, height: Int,
    )

    /** Convert I400 (grey) to ARGB.  Reverse of ARGBToI400 */
    @JvmName("convertI400ToARGB")
    external fun convertI400ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert J400 (jpeg grey) to ARGB */
    @JvmName("convertJ400ToARGB")
    external fun convertJ400ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert NV12 to ARGB */
    @JvmName("convertNV12ToARGB")
    external fun convertNV12ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcUV: ByteBuffer, srcStrideUV: RowStride, srcOffsetUV: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert NV21 to ARGB */
    @JvmName("convertNV21ToARGB")
    external fun convertNV21ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcVU: ByteBuffer, srcStrideVU: RowStride, srcOffsetVU: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert NV12 to ABGR */
    @JvmName("convertNV12ToABGR")
    external fun convertNV12ToABGR(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcUV: ByteBuffer, srcStrideUV: RowStride, srcOffsetUV: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert NV21 to ABGR */
    @JvmName("convertNV21ToABGR")
    external fun convertNV21ToABGR(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcVU: ByteBuffer, srcStrideVU: RowStride, srcOffsetVU: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert NV12 to RGB24 */
    @JvmName("convertNV12ToRGB24")
    external fun convertNV12ToRGB24(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcUV: ByteBuffer, srcStrideUV: RowStride, srcOffsetUV: Int,
        dstRGB24: ByteBuffer, dstStrideRGB24: RowStride, dstOffsetRGB24: Int,
        width: Int, height: Int,
    )

    /** Convert NV21 to RGB24 */
    @JvmName("convertNV21ToRGB24")
    external fun convertNV21ToRGB24(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcVU: ByteBuffer, srcStrideVU: RowStride, srcOffsetVU: Int,
        dstRGB24: ByteBuffer, dstStrideRGB24: RowStride, dstOffsetRGB24: Int,
        width: Int, height: Int,
    )

    /** Convert NV21 to YUV24 */
    @JvmName("convertNV21ToYUV24")
    external fun convertNV21ToYUV24(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcVU: ByteBuffer, srcStrideVU: RowStride, srcOffsetVU: Int,
        dstYUV24: ByteBuffer, dstStrideYUV24: RowStride, dstOffsetYUV24: Int,
        width: Int, height: Int,
    )

    /** Convert NV12 to RAW */
    @JvmName("convertNV12ToRAW")
    external fun convertNV12ToRAW(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcUV: ByteBuffer, srcStrideUV: RowStride, srcOffsetUV: Int,
        dstRAW: ByteBuffer, dstStrideRAW: RowStride, dstOffsetRAW: Int,
        width: Int, height: Int,
    )

    /** Convert NV21 to RAW */
    @JvmName("convertNV21ToRAW")
    external fun convertNV21ToRAW(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcVU: ByteBuffer, srcStrideVU: RowStride, srcOffsetVU: Int,
        dstRAW: ByteBuffer, dstStrideRAW: RowStride, dstOffsetRAW: Int,
        width: Int, height: Int,
    )

    /** Convert YUY2 to ARGB */
    @JvmName("convertYUY2ToARGB")
    external fun convertYUY2ToARGB(
        srcYUY2: ByteBuffer, srcStrideYUY2: RowStride, srcOffsetYUY2: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert UYVY to ARGB */
    @JvmName("convertUYVYToARGB")
    external fun convertUYVYToARGB(
        srcUYVY: ByteBuffer, srcStrideUYVY: RowStride, srcOffsetUYVY: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** BGRA little endian (argb in memory) to ARGB */
    @JvmName("convertBGRAToARGB")
    external fun convertBGRAToARGB(
        srcBGRA: ByteBuffer, srcStrideBGRA: RowStride, srcOffsetBGRA: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** ABGR little endian (rgba in memory) to ARGB */
    @JvmName("convertABGRToARGB")
    external fun convertABGRToARGB(
        srcABGR: ByteBuffer, srcStrideABGR: RowStride, srcOffsetABGR: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** RGBA little endian (abgr in memory) to ARGB */
    @JvmName("convertRGBAToARGB")
    external fun convertRGBAToARGB(
        srcRGBA: ByteBuffer, srcStrideRGBA: RowStride, srcOffsetRGBA: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** RGB little endian (bgr in memory) to ARGB */
    @JvmName("convertRGB24ToARGB")
    external fun convertRGB24ToARGB(
        srcRGB24: ByteBuffer, srcStrideRGB24: RowStride, srcOffsetRGB24: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** RGB big endian (rgb in memory) to ARGB */
    @JvmName("convertRAWToARGB")
    external fun convertRAWToARGB(
        srcRAW: ByteBuffer, srcStrideRAW: RowStride, srcOffsetRAW: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** RGB big endian (rgb in memory) to RGBA */
    @JvmName("convertRAWToRGBA")
    external fun convertRAWToRGBA(
        srcRAW: ByteBuffer, srcStrideRAW: RowStride, srcOffsetRAW: Int,
        dstRGBA: ByteBuffer, dstStrideRGBA: RowStride, dstOffsetRGBA: Int,
        width: Int, height: Int,
    )

    /** RGB16 (RGBP fourcc) little endian to ARGB */
    @JvmName("convertRGB565ToARGB")
    external fun convertRGB565ToARGB(
        srcRGB565: ByteBuffer, srcStrideRGB565: RowStride, srcOffsetRGB565: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** RGB15 (RGBO fourcc) little endian to ARGB */
    @JvmName("convertARGB1555ToARGB")
    external fun convertARGB1555ToARGB(
        srcARGB1555: ByteBuffer, srcStrideARGB1555: RowStride, srcOffsetARGB1555: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** RGB12 (R444 fourcc) little endian to ARGB */
    @JvmName("convertARGB4444ToARGB")
    external fun convertARGB4444ToARGB(
        srcARGB4444: ByteBuffer, srcStrideARGB4444: RowStride, srcOffsetARGB4444: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert AR30 to ARGB */
    @JvmName("convertAR30ToARGB")
    external fun convertAR30ToARGB(
        srcAR30: ByteBuffer, srcStrideAR30: RowStride, srcOffsetAR30: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert AR30 to ABGR */
    @JvmName("convertAR30ToABGR")
    external fun convertAR30ToABGR(
        srcAR30: ByteBuffer, srcStrideAR30: RowStride, srcOffsetAR30: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert AR30 to AB30 */
    @JvmName("convertAR30ToAB30")
    external fun convertAR30ToAB30(
        srcAR30: ByteBuffer, srcStrideAR30: RowStride, srcOffsetAR30: Int,
        dstAB30: ByteBuffer, dstStrideAB30: RowStride, dstOffsetAB30: Int,
        width: Int, height: Int,
    )

    /** Convert NV12 to RGB565 */
    @JvmName("convertNV12ToRGB565")
    external fun convertNV12ToRGB565(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcUV: ByteBuffer, srcStrideUV: RowStride, srcOffsetUV: Int,
        dstRGB565: ByteBuffer, dstStrideRGB565: RowStride, dstOffsetRGB565: Int,
        width: Int, height: Int,
    )

    /** Convert I422 to BGRA */
    @JvmName("convertI422ToBGRA")
    external fun convertI422ToBGRA(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstBGRA: ByteBuffer, dstStrideBGRA: RowStride, dstOffsetBGRA: Int,
        width: Int, height: Int,
    )

    /** Convert I422 to ABGR */
    @JvmName("convertI422ToABGR")
    external fun convertI422ToABGR(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert I422 to RGBA */
    @JvmName("convertI422ToRGBA")
    external fun convertI422ToRGBA(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRGBA: ByteBuffer, dstStrideRGBA: RowStride, dstOffsetRGBA: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to ARGB */
    @JvmName("convertI420ToARGB")
    external fun convertI420ToARGB(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to BGRA */
    @JvmName("convertI420ToBGRA")
    external fun convertI420ToBGRA(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstBGRA: ByteBuffer, dstStrideBGRA: RowStride, dstOffsetBGRA: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to ABGR */
    @JvmName("convertI420ToABGR")
    external fun convertI420ToABGR(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to RGBA */
    @JvmName("convertI420ToRGBA")
    external fun convertI420ToRGBA(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRGBA: ByteBuffer, dstStrideRGBA: RowStride, dstOffsetRGBA: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to RGB24 */
    @JvmName("convertI420ToRGB24")
    external fun convertI420ToRGB24(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRGB24: ByteBuffer, dstStrideRGB24: RowStride, dstOffsetRGB24: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to RAW */
    @JvmName("convertI420ToRAW")
    external fun convertI420ToRAW(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRAW: ByteBuffer, dstStrideRAW: RowStride, dstOffsetRAW: Int,
        width: Int, height: Int,
    )

    /** Convert H420 to RGB24 */
    @JvmName("convertH420ToRGB24")
    external fun convertH420ToRGB24(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRGB24: ByteBuffer, dstStrideRGB24: RowStride, dstOffsetRGB24: Int,
        width: Int, height: Int,
    )

    /** Convert H420 to RAW */
    @JvmName("convertH420ToRAW")
    external fun convertH420ToRAW(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRAW: ByteBuffer, dstStrideRAW: RowStride, dstOffsetRAW: Int,
        width: Int, height: Int,
    )

    /** Convert J420 to RGB24 */
    @JvmName("convertJ420ToRGB24")
    external fun convertJ420ToRGB24(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRGB24: ByteBuffer, dstStrideRGB24: RowStride, dstOffsetRGB24: Int,
        width: Int, height: Int,
    )

    /** Convert J420 to RAW */
    @JvmName("convertJ420ToRAW")
    external fun convertJ420ToRAW(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRAW: ByteBuffer, dstStrideRAW: RowStride, dstOffsetRAW: Int,
        width: Int, height: Int,
    )

    /** Convert I422 to RGB24 */
    @JvmName("convertI422ToRGB24")
    external fun convertI422ToRGB24(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRGB24: ByteBuffer, dstStrideRGB24: RowStride, dstOffsetRGB24: Int,
        width: Int, height: Int,
    )

    /** Convert I422 to RAW */
    @JvmName("convertI422ToRAW")
    external fun convertI422ToRAW(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRAW: ByteBuffer, dstStrideRAW: RowStride, dstOffsetRAW: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to RGB565 */
    @JvmName("convertI420ToRGB565")
    external fun convertI420ToRGB565(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRGB565: ByteBuffer, dstStrideRGB565: RowStride, dstOffsetRGB565: Int,
        width: Int, height: Int,
    )

    /** Convert J420 to RGB565 */
    @JvmName("convertJ420ToRGB565")
    external fun convertJ420ToRGB565(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRGB565: ByteBuffer, dstStrideRGB565: RowStride, dstOffsetRGB565: Int,
        width: Int, height: Int,
    )

    /** Convert H420 to RGB565 */
    @JvmName("convertH420ToRGB565")
    external fun convertH420ToRGB565(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRGB565: ByteBuffer, dstStrideRGB565: RowStride, dstOffsetRGB565: Int,
        width: Int, height: Int,
    )

    /** Convert I422 to RGB565 */
    @JvmName("convertI422ToRGB565")
    external fun convertI422ToRGB565(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstRGB565: ByteBuffer, dstStrideRGB565: RowStride, dstOffsetRGB565: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to ARGB1555 */
    @JvmName("convertI420ToARGB1555")
    external fun convertI420ToARGB1555(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstARGB1555: ByteBuffer, dstStrideARGB1555: RowStride, dstOffsetARGB1555: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to ARGB4444 */
    @JvmName("convertI420ToARGB4444")
    external fun convertI420ToARGB4444(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstARGB4444: ByteBuffer, dstStrideARGB4444: RowStride, dstOffsetARGB4444: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to AR30 */
    @JvmName("convertI420ToAR30")
    external fun convertI420ToAR30(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstAR30: ByteBuffer, dstStrideAR30: RowStride, dstOffsetAR30: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to AB30 */
    @JvmName("convertI420ToAB30")
    external fun convertI420ToAB30(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstAB30: ByteBuffer, dstStrideAB30: RowStride, dstOffsetAB30: Int,
        width: Int, height: Int,
    )

    /** Convert H420 to AR30 */
    @JvmName("convertH420ToAR30")
    external fun convertH420ToAR30(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstAR30: ByteBuffer, dstStrideAR30: RowStride, dstOffsetAR30: Int,
        width: Int, height: Int,
    )

    /** Convert H420 to AB30 */
    @JvmName("convertH420ToAB30")
    external fun convertH420ToAB30(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstAB30: ByteBuffer, dstStrideAB30: RowStride, dstOffsetAB30: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to I422 */
    @JvmName("convertI420ToI422")
    external fun convertI420ToI422(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to I444 */
    @JvmName("convertI420ToI444")
    external fun convertI420ToI444(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Copy to I400. Source can be I420, I422, I444, I400, NV12 or NV21 */
    @JvmName("convertI400Copy")
    external fun convertI400Copy(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to NV12 */
    @JvmName("convertI420ToNV12")
    external fun convertI420ToNV12(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstUV: ByteBuffer, dstStrideUV: RowStride, dstOffsetUV: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to NV21 */
    @JvmName("convertI420ToNV21")
    external fun convertI420ToNV21(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstVU: ByteBuffer, dstStrideVU: RowStride, dstOffsetVU: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to YUY2 */
    @JvmName("convertI420ToYUY2")
    external fun convertI420ToYUY2(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstYUY2: ByteBuffer, dstStrideYUY2: RowStride, dstOffsetYUY2: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to UYVY */
    @JvmName("convertI420ToUYVY")
    external fun convertI420ToUYVY(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstUYVY: ByteBuffer, dstStrideUYVY: RowStride, dstOffsetUYVY: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to BGRA */
    @JvmName("convertARGBToBGRA")
    external fun convertARGBToBGRA(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstBGRA: ByteBuffer, dstStrideBGRA: RowStride, dstOffsetBGRA: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to ABGR */
    @JvmName("convertARGBToABGR")
    external fun convertARGBToABGR(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstABGR: ByteBuffer, dstStrideABGR: RowStride, dstOffsetABGR: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to RGBA */
    @JvmName("convertARGBToRGBA")
    external fun convertARGBToRGBA(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstRGBA: ByteBuffer, dstStrideRGBA: RowStride, dstOffsetRGBA: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to RGB24 */
    @JvmName("convertARGBToRGB24")
    external fun convertARGBToRGB24(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstRGB24: ByteBuffer, dstStrideRGB24: RowStride, dstOffsetRGB24: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to RAW */
    @JvmName("convertARGBToRAW")
    external fun convertARGBToRAW(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstRAW: ByteBuffer, dstStrideRAW: RowStride, dstOffsetRAW: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to RGB565 */
    @JvmName("convertARGBToRGB565")
    external fun convertARGBToRGB565(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstRGB565: ByteBuffer, dstStrideRGB565: RowStride, dstOffsetRGB565: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to ARGB1555 */
    @JvmName("convertARGBToARGB1555")
    external fun convertARGBToARGB1555(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstARGB1555: ByteBuffer, dstStrideARGB1555: RowStride, dstOffsetARGB1555: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to ARGB4444 */
    @JvmName("convertARGBToARGB4444")
    external fun convertARGBToARGB4444(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstARGB4444: ByteBuffer, dstStrideARGB4444: RowStride, dstOffsetARGB4444: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to I444 */
    @JvmName("convertARGBToI444")
    external fun convertARGBToI444(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to I422 */
    @JvmName("convertARGBToI422")
    external fun convertARGBToI422(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to J420. (JPeg full range I420) */
    @JvmName("convertARGBToJ420")
    external fun convertARGBToJ420(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to J422 */
    @JvmName("convertARGBToJ422")
    external fun convertARGBToJ422(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to J400. (JPeg full range) */
    @JvmName("convertARGBToJ400")
    external fun convertARGBToJ400(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        width: Int, height: Int,
    )

    /** Convert ABGR to J420. (JPeg full range I420) */
    @JvmName("convertABGRToJ420")
    external fun convertABGRToJ420(
        srcABGR: ByteBuffer, srcStrideABGR: RowStride, srcOffsetABGR: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert ABGR to J422 */
    @JvmName("convertABGRToJ422")
    external fun convertABGRToJ422(
        srcABGR: ByteBuffer, srcStrideABGR: RowStride, srcOffsetABGR: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert ABGR to J400. (JPeg full range) */
    @JvmName("convertABGRToJ400")
    external fun convertABGRToJ400(
        srcABGR: ByteBuffer, srcStrideABGR: RowStride, srcOffsetABGR: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        width: Int, height: Int,
    )

    /** Convert RGBA to J400. (JPeg full range) */
    @JvmName("convertRGBAToJ400")
    external fun convertRGBAToJ400(
        srcRGBA: ByteBuffer, srcStrideRGBA: RowStride, srcOffsetRGBA: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to I400 */
    @JvmName("convertARGBToI400")
    external fun convertARGBToI400(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to NV12 */
    @JvmName("convertARGBToNV12")
    external fun convertARGBToNV12(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstUV: ByteBuffer, dstStrideUV: RowStride, dstOffsetUV: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to NV21 */
    @JvmName("convertARGBToNV21")
    external fun convertARGBToNV21(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstVU: ByteBuffer, dstStrideVU: RowStride, dstOffsetVU: Int,
        width: Int, height: Int,
    )

    /** Convert ABGR to NV12 */
    @JvmName("convertABGRToNV12")
    external fun convertABGRToNV12(
        srcABGR: ByteBuffer, srcStrideABGR: RowStride, srcOffsetABGR: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstUV: ByteBuffer, dstStrideUV: RowStride, dstOffsetUV: Int,
        width: Int, height: Int,
    )

    /** Convert ABGR to NV21 */
    @JvmName("convertABGRToNV21")
    external fun convertABGRToNV21(
        srcABGR: ByteBuffer, srcStrideABGR: RowStride, srcOffsetABGR: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstVU: ByteBuffer, dstStrideVU: RowStride, dstOffsetVU: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to YUY2 */
    @JvmName("convertARGBToYUY2")
    external fun convertARGBToYUY2(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstYUY2: ByteBuffer, dstStrideYUY2: RowStride, dstOffsetYUY2: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to UYVY */
    @JvmName("convertARGBToUYVY")
    external fun convertARGBToUYVY(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstUYVY: ByteBuffer, dstStrideUYVY: RowStride, dstOffsetUYVY: Int,
        width: Int, height: Int,
    )

    // rotate.cpp

    /** Rotate I420 Frame */
    @JvmName("rotateI420Rotate")
    external fun rotateI420Rotate(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
        rotateMode: Int,
    )

    /** Rotate I422 Frame */
    @JvmName("rotateI422Rotate")
    external fun rotateI422Rotate(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
        rotateMode: Int,
    )

    /** Rotate I444 Frame */
    @JvmName("rotateI444Rotate")
    external fun rotateI444Rotate(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
        rotateMode: Int,
    )

    /** Rotate NV12 input and store in I420 */
    @JvmName("rotateNV12ToI420Rotate")
    external fun rotateNV12ToI420Rotate(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcUV: ByteBuffer, srcStrideUV: RowStride, srcOffsetUV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
        rotateMode: Int,
    )

    /** Convert Android420 to I420 with rotation. "rotation" can be 0, 90, 180 or 270 */
    @JvmName("rotateAndroid420ToI420Rotate")
    external fun rotateAndroid420ToI420Rotate(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        srcPixelStrideUV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
        rotateMode: Int,
    )

    /** Rotate ARGB Frame */
    @JvmName("rotateARGBRotate")
    external fun rotateARGBRotate(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
        rotateMode: Int,
    )

    /** Rotate NV12 Frame */
    @JvmName("rotateNV12Rotate")
    external fun rotateNV12Rotate(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcUV: ByteBuffer, srcStrideUV: RowStride, srcOffsetUV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstUV: ByteBuffer, dstStrideUV: RowStride, dstOffsetUV: Int,
        width: Int, height: Int,
        rotateMode: Int,
    )

    /** Rotate NV21 Frame */
    @JvmName("rotateNV21Rotate")
    external fun rotateNV21Rotate(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcVU: ByteBuffer, srcStrideVU: RowStride, srcOffsetVU: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstVU: ByteBuffer, dstStrideVU: RowStride, dstOffsetVU: Int,
        width: Int, height: Int,
        rotateMode: Int,
    )

    /** Rotate NV12 to NV21 */
    @JvmName("rotateNV12ToNV21Rotate")
    external fun rotateNV12ToNV21Rotate(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcUV: ByteBuffer, srcStrideUV: RowStride, srcOffsetUV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstVU: ByteBuffer, dstStrideVU: RowStride, dstOffsetVU: Int,
        width: Int, height: Int,
        rotateMode: Int,
    )

    /** Rotate a plane by 0, 90, 180, or 270 */
    @JvmName("rotateRotatePlane")
    external fun rotateRotatePlane(
        src: ByteBuffer, srcStride: RowStride, srcOffset: Int,
        dst: ByteBuffer, dstStride: RowStride, dstOffset: Int,
        width: Int, height: Int,
        rotateMode: Int,
    )

    /** Rotate UV and split into planar. width and height expected to be half size for NV12 */
    @JvmName("rotateSplitRotateUV")
    external fun rotateSplitRotateUV(
        srcUV: ByteBuffer, srcStrideUV: RowStride, srcOffsetUV: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
        rotateMode: Int,
    )

    /** The 90 and 270 functions are based on transposes. Deprecated */
    @JvmName("rotateTransposePlane")
    external fun rotateTransposePlane(
        src: ByteBuffer, srcStride: RowStride, srcOffset: Int,
        dst: ByteBuffer, dstStride: RowStride, dstOffset: Int,
        width: Int, height: Int,
    )

    @JvmName("rotateSplitTransposeUV")
    external fun rotateSplitTransposeUV(
        src: ByteBuffer, srcStride: RowStride, srcOffset: Int,
        dstA: ByteBuffer, dstStrideA: RowStride, dstOffsetA: Int,
        dstB: ByteBuffer, dstStrideB: RowStride, dstOffsetB: Int,
        width: Int, height: Int,
    )

    // scale.cpp

    /** Scale Plane Frame */
    @JvmName("scaleScalePlane")
    external fun scaleScalePlane(
        src: ByteBuffer, srcStride: RowStride, srcOffset: Int,
        srcWidth: Int, srcHeight: Int,
        dst: ByteBuffer, dstStride: RowStride, dstOffset: Int,
        dstWidth: Int, dstHeight: Int,
        filterMode: Int,
    )

    /** Scale I420 Frame */
    @JvmName("scaleI420Scale")
    external fun scaleI420Scale(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        srcWidth: Int, srcHeight: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        dstWidth: Int, dstHeight: Int,
        filterMode: Int,
    )

    /** Scale I422 Frame */
    @JvmName("scaleI422Scale")
    external fun scaleI422Scale(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        srcWidth: Int, srcHeight: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        dstWidth: Int, dstHeight: Int,
        filterMode: Int,
    )

    /** Scale I444 Frame */
    @JvmName("scaleI444Scale")
    external fun scaleI444Scale(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        srcWidth: Int, srcHeight: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        dstWidth: Int, dstHeight: Int,
        filterMode: Int,
    )

    /** Scale NV12 Frame */
    @JvmName("scaleNV12Scale")
    external fun scaleNV12Scale(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcUV: ByteBuffer, srcStrideUV: RowStride, srcOffsetUV: Int,
        srcWidth: Int, srcHeight: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstUV: ByteBuffer, dstStrideUV: RowStride, dstOffsetUV: Int,
        dstWidth: Int, dstHeight: Int,
        filterMode: Int,
    )

    /** Scale ARGB Frame */
    @JvmName("scaleARGBScale")
    external fun scaleARGBScale(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        srcWidth: Int, srcHeight: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        dstWidth: Int, dstHeight: Int,
        filterMode: Int,
    )

    /** Scale UV Frame */
    @JvmName("scaleUVScale")
    external fun scaleUVScale(
        srcUV: ByteBuffer, srcStrideUV: RowStride, srcOffsetUV: Int,
        srcWidth: Int, srcHeight: Int,
        dstUV: ByteBuffer, dstStrideUV: RowStride, dstOffsetUV: Int,
        dstWidth: Int, dstHeight: Int,
        filterMode: Int,
    )

    /** Clipped scale takes destination rectangle coordinates for clip values */
    @JvmName("scaleARGBScaleClip")
    external fun scaleARGBScaleClip(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        srcWidth: Int, srcHeight: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        dstWidth: Int, dstHeight: Int,
        clipX: Int, clipY: Int,
        clipWidth: Int, clipHeight: Int,
        filterMode: Int,
    )

    // Scale with YUV conversion to ARGB and clipping

    // planar_functions.cpp

    /** Copy I422 to I422 */
    @JvmName("planarI422Copy")
    external fun planarI422Copy(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Copy I444 to I444 */
    @JvmName("planarI444Copy")
    external fun planarI444Copy(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Copy NV12 to NV12 */
    @JvmName("planarNV12Copy")
    external fun planarNV12Copy(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcUV: ByteBuffer, srcStrideUV: RowStride, srcOffsetUV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstUV: ByteBuffer, dstStrideUV: RowStride, dstOffsetUV: Int,
        width: Int, height: Int,
    )

    /** Convert YUY2 to I422 */
    @JvmName("planarYUY2ToI422")
    external fun planarYUY2ToI422(
        srcYUY2: ByteBuffer, srcStrideYUY2: RowStride, srcOffsetYUY2: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert UYVY to I422 */
    @JvmName("planarUYVYToI422")
    external fun planarUYVYToI422(
        srcUYVY: ByteBuffer, srcStrideUYVY: RowStride, srcOffsetUYVY: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Convert YUY2 to NV12 */
    @JvmName("planarYUY2ToNV12")
    external fun planarYUY2ToNV12(
        srcYUY2: ByteBuffer, srcStrideYUY2: RowStride, srcOffsetYUY2: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstUV: ByteBuffer, dstStrideUV: RowStride, dstOffsetUV: Int,
        width: Int, height: Int,
    )

    /** Convert UYVY to NV12 */
    @JvmName("planarUYVYToNV12")
    external fun planarUYVYToNV12(
        srcUYVY: ByteBuffer, srcStrideUYVY: RowStride, srcOffsetUYVY: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstUV: ByteBuffer, dstStrideUV: RowStride, dstOffsetUV: Int,
        width: Int, height: Int,
    )

    /** Convert NV21 to NV12 */
    @JvmName("planarNV21ToNV12")
    external fun planarNV21ToNV12(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcVU: ByteBuffer, srcStrideVU: RowStride, srcOffsetVU: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstUV: ByteBuffer, dstStrideUV: RowStride, dstOffsetUV: Int,
        width: Int, height: Int,
    )

    /** Convert I420 to I400 */
    @JvmName("planarI420ToI400")
    external fun planarI420ToI400(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        width: Int, height: Int,
    )

    /** Mirror I420 */
    @JvmName("planarI420Mirror")
    external fun planarI420Mirror(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Mirror I400 */
    @JvmName("planarI400Mirror")
    external fun planarI400Mirror(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        width: Int, height: Int,
    )

    /** Mirror NV12 */
    @JvmName("planarNV12Mirror")
    external fun planarNV12Mirror(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcUV: ByteBuffer, srcStrideUV: RowStride, srcOffsetUV: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstUV: ByteBuffer, dstStrideUV: RowStride, dstOffsetUV: Int,
        width: Int, height: Int,
    )

    /** Mirror ARGB */
    @JvmName("planarARGBMirror")
    external fun planarARGBMirror(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Mirror RGB24 */
    @JvmName("planarRGB24Mirror")
    external fun planarRGB24Mirror(
        srcRGB24: ByteBuffer, srcStrideRGB24: RowStride, srcOffsetRGB24: Int,
        dstRGB24: ByteBuffer, dstStrideRGB24: RowStride, dstOffsetRGB24: Int,
        width: Int, height: Int,
    )

    /** Convert RAW to RGB24 */
    @JvmName("planarRAWToRGB24")
    external fun planarRAWToRGB24(
        srcRAW: ByteBuffer, srcStrideRAW: RowStride, srcOffsetRAW: Int,
        dstRGB24: ByteBuffer, dstStrideRGB24: RowStride, dstOffsetRGB24: Int,
        width: Int, height: Int,
    )

    /** Convert I422 to YUY2 */
    @JvmName("planarI422ToYUY2")
    external fun planarI422ToYUY2(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstYUY2: ByteBuffer, dstStrideYUY2: RowStride, dstOffsetYUY2: Int,
        width: Int, height: Int,
    )

    /** Convert I422 to UYVY */
    @JvmName("planarI422ToUYVY")
    external fun planarI422ToUYVY(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        srcU: ByteBuffer, srcStrideU: RowStride, srcOffsetU: Int,
        srcV: ByteBuffer, srcStrideV: RowStride, srcOffsetV: Int,
        dstUYVY: ByteBuffer, dstStrideUYVY: RowStride, dstOffsetUYVY: Int,
        width: Int, height: Int,
    )

    /** Convert unattentuated ARGB to preattenuated ARGB */
    @JvmName("planarARGBAttenuate")
    external fun planarARGBAttenuate(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert preattentuated ARGB to unattenuated ARGB */
    @JvmName("planarARGBUnattenuate")
    external fun planarARGBUnattenuate(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Convert ARGB to gray scale ARGB */
    @JvmName("planarARGBGrayTo")
    external fun planarARGBGrayTo(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Copy Alpha channel of ARGB to alpha of ARGB */
    @JvmName("planarARGBCopyAlpha")
    external fun planarARGBCopyAlpha(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Extract the alpha channel from ARGB */
    @JvmName("planarARGBExtractAlpha")
    external fun planarARGBExtractAlpha(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstA: ByteBuffer, dstStrideA: RowStride, dstOffsetA: Int,
        width: Int, height: Int,
    )

    /** Copy Y channel to Alpha of ARGB */
    @JvmName("planarARGBCopyYToAlpha")
    external fun planarARGBCopyYToAlpha(
        srcY: ByteBuffer, srcStrideY: RowStride, srcOffsetY: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Set a plane of data to a 32 bit value. */
    @JvmName("planarSetPlane")
    external fun planarSetPlane(
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        width: Int, height: Int,
        value: Int,
    )

    /** Draw a rectangle into I420 */
    @JvmName("planarI420Rect")
    external fun planarI420Rect(
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        x: Int, y: Int,
        width: Int, height: Int,
        valueY: Int, valueU: Int, valueV: Int,
    )

    /** Draw a rectangle into ARGB */
    @JvmName("planarARGBRect")
    external fun planarARGBRect(
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        x: Int, y: Int,
        width: Int, height: Int,
        value: Long,
    )

    /** Make a rectangle of ARGB gray scale */
    @JvmName("planarARGBGray")
    external fun planarARGBGray(
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        x: Int, y: Int,
        width: Int, height: Int,
    )

    /** Make a rectangle of ARGB Sepia tone */
    @JvmName("planarARGBSepia")
    external fun planarARGBSepia(
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        x: Int, y: Int,
        width: Int, height: Int,
    )

    /** Apply a matrix rotation to each ARGB pixel */
    @JvmName("planarARGBColorMatrix")
    external fun planarARGBColorMatrix(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        matrixARGB: ByteArray,
        width: Int, height: Int,
    )

    /** Apply a color table each ARGB pixel */
    @JvmName("planarARGBColorTable")
    external fun planarARGBColorTable(
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        tableARGB: ByteArray,
        x: Int, y: Int,
        width: Int, height: Int,
    )

    /** Apply a color table each ARGB pixel but preserve destination alpha */
    @JvmName("planarRGBColorTable")
    external fun planarRGBColorTable(
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        tableARGB: ByteArray,
        x: Int, y: Int,
        width: Int, height: Int,
    )

    /** Apply a luma/color table each ARGB pixel but preserve destination alpha */
    @JvmName("planarARGBLumaColorTable")
    external fun planarARGBLumaColorTable(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        luma: ByteArray,
        width: Int, height: Int,
    )

    /** Apply a 3 term polynomial to ARGB values */
    @JvmName("planarARGBPolynomial")
    external fun planarARGBPolynomial(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        poly: FloatArray,
        width: Int, height: Int,
    )

    /** Quantize a rectangle of ARGB. Alpha unaffected */
    @JvmName("planarARGBQuantize")
    external fun planarARGBQuantize(
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        scale: Int,
        intervalSize: Int, intervalOffset: Int,
        x: Int, y: Int,
        width: Int, height: Int,
    )

    /** Alpha Blend ARGB images and store to destination */
    @JvmName("planarARGBBlend")
    external fun planarARGBBlend(
        srcARGB0: ByteBuffer, srcStrideARGB0: RowStride, srcOffsetARGB0: Int,
        srcARGB1: ByteBuffer, srcStrideARGB1: RowStride, srcOffsetARGB1: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Alpha Blend YUV images and store to destination */
    @JvmName("planarI420Blend")
    external fun planarI420Blend(
        srcY0: ByteBuffer, srcStrideY0: RowStride, srcOffsetY0: Int,
        srcU0: ByteBuffer, srcStrideU0: RowStride, srcOffsetU0: Int,
        srcV0: ByteBuffer, srcStrideV0: RowStride, srcOffsetV0: Int,
        srcY1: ByteBuffer, srcStrideY1: RowStride, srcOffsetY1: Int,
        srcU1: ByteBuffer, srcStrideU1: RowStride, srcOffsetU1: Int,
        srcV1: ByteBuffer, srcStrideV1: RowStride, srcOffsetV1: Int,
        srcA: ByteBuffer, srcStrideA: RowStride, dstOffsetA: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
    )

    /** Multiply ARGB image by ARGB image. Shifted down by 8. Saturates to 255 */
    @JvmName("planarARGBMultiply")
    external fun planarARGBMultiply(
        srcARGB0: ByteBuffer, srcStrideARGB0: RowStride, srcOffsetARGB0: Int,
        srcARGB1: ByteBuffer, srcStrideARGB1: RowStride, srcOffsetARGB1: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Add ARGB image with ARGB image. Saturates to 255 */
    @JvmName("planarARGBAdd")
    external fun planarARGBAdd(
        srcARGB0: ByteBuffer, srcStrideARGB0: RowStride, srcOffsetARGB0: Int,
        srcARGB1: ByteBuffer, srcStrideARGB1: RowStride, srcOffsetARGB1: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Subtract ARGB image with ARGB image. Saturates to 0 */
    @JvmName("planarARGBSubtract")
    external fun planarARGBSubtract(
        srcARGB0: ByteBuffer, srcStrideARGB0: RowStride, srcOffsetARGB0: Int,
        srcARGB1: ByteBuffer, srcStrideARGB1: RowStride, srcOffsetARGB1: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
    )

    /** Blur ARGB image */
    @JvmName("planarARGBBlur")
    external fun planarARGBBlur(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
        radius: Int,
    )

    /** Multiply ARGB image by ARGB value */
    @JvmName("planarARGBShade")
    external fun planarARGBShade(
        srcARGB: ByteBuffer, srcStrideARGB: RowStride, srcOffsetARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
        value: Long,
    )

    /** Interpolate between two ARGB images using specified amount of interpolation Internally calls InterpolatePlane with width * 4 (bpp). */
    @JvmName("planarARGBInterpolate")
    external fun planarARGBInterpolate(
        srcARGB0: ByteBuffer, srcStrideARGB0: RowStride, srcOffsetARGB0: Int,
        srcARGB1: ByteBuffer, srcStrideARGB1: RowStride, srcOffsetARGB1: Int,
        dstARGB: ByteBuffer, dstStrideARGB: RowStride, dstOffsetARGB: Int,
        width: Int, height: Int,
        interpolation: Int,
    )

    /** Interpolate between two YUV images using specified amount of interpolation Internally calls InterpolatePlane on each plane where the U and V planes are half width and half height */
    @JvmName("planarI420Interpolate")
    external fun planarI420Interpolate(
        srcY0: ByteBuffer, srcStrideY0: RowStride, srcOffsetY0: Int,
        srcU0: ByteBuffer, srcStrideU0: RowStride, srcOffsetU0: Int,
        srcV0: ByteBuffer, srcStrideV0: RowStride, srcOffsetV0: Int,
        srcY1: ByteBuffer, srcStrideY1: RowStride, srcOffsetY1: Int,
        srcU1: ByteBuffer, srcStrideU1: RowStride, srcOffsetU1: Int,
        srcV1: ByteBuffer, srcStrideV1: RowStride, srcOffsetV1: Int,
        dstY: ByteBuffer, dstStrideY: RowStride, dstOffsetY: Int,
        dstU: ByteBuffer, dstStrideU: RowStride, dstOffsetU: Int,
        dstV: ByteBuffer, dstStrideV: RowStride, dstOffsetV: Int,
        width: Int, height: Int,
        interpolation: Int,
    )

    // compare.cpp

    /** Compute a hash for specified memory. Seed of 5381 recommended. */
    @JvmName("hashDjb2")
    external fun hashDjb2(src: ByteBuffer, count: Long, seed: Long): Long

    /** Compute Hamming Distance */
    @JvmName("computeHammingDistance")
    external fun computeHammingDistance(srcA: ByteBuffer, srcB: ByteBuffer, count: Int): ByteArray

    /** Compute Sum Square Error Plane */
    @JvmName("computeSumSquareErrorPlane")
    external fun computeSumSquareErrorPlane(
        srcA: ByteBuffer, srcStrideA: RowStride,
        srcB: ByteBuffer, srcStrideB: RowStride,
        width: Int, height: Int,
    ): ByteArray

    /** Calculate Frame PSNR. */
    @JvmName("calcFramePsnr")
    external fun calcFramePsnr(
        srcA: ByteBuffer, srcStrideA: RowStride,
        srcB: ByteBuffer, srcStrideB: RowStride,
        width: Int, height: Int,
    ): Double

    /** Calculate Frame PSNR. */
    @JvmName("calcI420Psnr")
    external fun calcI420Psnr(
        srcYA: ByteBuffer, srcStrideYA: RowStride,
        srcUA: ByteBuffer, srcStrideUA: RowStride,
        srcVA: ByteBuffer, srcStrideVA: RowStride,
        srcYB: ByteBuffer, srcStrideYB: RowStride,
        srcUB: ByteBuffer, srcStrideUB: RowStride,
        srcVB: ByteBuffer, srcStrideVB: RowStride,
        width: Int, height: Int,
    ): Double

    /** Calculate Frame SSIM. */
    @JvmName("calcFrameSsim")
    external fun calcFrameSsim(
        srcA: ByteBuffer, srcStrideA: RowStride,
        srcB: ByteBuffer, srcStrideB: RowStride,
        width: Int, height: Int,
    ): Double

    /** Calculate Frame SSIM. */
    @JvmName("calcI420Ssim")
    external fun calcI420Ssim(
        srcYA: ByteBuffer, srcStrideYA: RowStride,
        srcUA: ByteBuffer, srcStrideUA: RowStride,
        srcVA: ByteBuffer, srcStrideVA: RowStride,
        srcYB: ByteBuffer, srcStrideYB: RowStride,
        srcUB: ByteBuffer, srcStrideUB: RowStride,
        srcVB: ByteBuffer, srcStrideVB: RowStride,
        width: Int, height: Int,
    ): Double

    // memcopy.cpp

    @JvmName("memcopy")
    external fun memcopy(dst: Any, dstOffset: Int, src: Any, srcOffset: Int, length: Int)
}

