package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

object Yuv {
    init {
        System.loadLibrary("yuv_android")
    }

    // helper.cpp
    external fun allocNativeBuffer(size: Int): ByteBuffer
    external fun freeNativeBuffer(buffer: ByteBuffer)

    // ${convert_code}
    // ${rotate_code}
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

    // ${scale_code}
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

    // ${planar_code}
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
