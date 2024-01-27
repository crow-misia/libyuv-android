package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

object Yuv {
    init {
        System.loadLibrary("yuv")
    }

    // helper.cpp
    external fun allocNativeBuffer(size: Int): ByteBuffer
    external fun freeNativeBuffer(buffer: ByteBuffer)

    // ${convert_code}
    // ${rotate_code}
    /** The 90 and 270 functions are based on transposes. Deprecated */
    external fun rotateTransposePlane(
        src: ByteBuffer, srcStride: Int,
        dst: ByteBuffer, dstStride: Int,
        width: Int, height: Int,
    )

    external fun rotateSplitTransposeUV(
        src: ByteBuffer, srcStride: Int,
        dstA: ByteBuffer, dstStrideA: Int,
        dstB: ByteBuffer, dstStrideB: Int,
        width: Int, height: Int,
    )

    // ${scale_code}
    /** Clipped scale takes destination rectangle coordinates for clip values */
    external fun scaleARGBScaleClip(
        srcARGB: ByteBuffer, srcStrideARGB: Int,
        srcWidth: Int, srcHeight: Int,
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        dstWidth: Int, dstHeight: Int,
        clipX: Int, clipY: Int,
        clipWidth: Int, clipHeight: Int,
        filterMode: Int,
    )

    // Scale with YUV conversion to ARGB and clipping

    // ${planar_code}
    /** Set a plane of data to a 32 bit value. */
    external fun planerSetPlane(
        srcY: ByteBuffer, srcStrideY: Int,
        width: Int, height: Int,
        value: Int,
    )

    /** Draw a rectangle into I420 */
    external fun planerI420Rect(
        dstY: ByteBuffer, dstStrideY: Int,
        dstU: ByteBuffer, dstStrideU: Int,
        dstV: ByteBuffer, dstStrideV: Int,
        x: Int, y: Int,
        width: Int, height: Int,
        valueY: Int, valueU: Int, valueV: Int,
    )

    /** Draw a rectangle into ARGB */
    external fun planerARGBRect(
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        x: Int, y: Int,
        width: Int, height: Int,
        value: Long,
    )

    /** Make a rectangle of ARGB gray scale */
    external fun planerARGBGray(
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        x: Int, y: Int,
        width: Int, height: Int,
    )

    /** Make a rectangle of ARGB Sepia tone */
    external fun planerARGBSepia(
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        x: Int, y: Int,
        width: Int, height: Int,
    )

    /** Apply a matrix rotation to each ARGB pixel */
    external fun planerARGBColorMatrix(
        srcARGB: ByteBuffer, srcStrideARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        matrixARGB: ByteArray,
        width: Int, height: Int,
    )

    /** Apply a color table each ARGB pixel */
    external fun planerARGBColorTable(
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        tableARGB: ByteArray,
        x: Int, y: Int,
        width: Int, height: Int,
    )

    /** Apply a color table each ARGB pixel but preserve destination alpha */
    external fun planerRGBColorTable(
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        tableARGB: ByteArray,
        x: Int, y: Int,
        width: Int, height: Int,
    )

    /** Apply a luma/color table each ARGB pixel but preserve destination alpha */
    external fun planerARGBLumaColorTable(
        srcARGB: ByteBuffer, srcStrideARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        luma: ByteArray,
        width: Int, height: Int,
    )

    /** Apply a 3 term polynomial to ARGB values */
    external fun planerARGBPolynomial(
        srcARGB: ByteBuffer, srcStrideARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        poly: FloatArray,
        width: Int, height: Int,
    )

    /** Quantize a rectangle of ARGB. Alpha unaffected */
    external fun planerARGBQuantize(
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        scale: Int,
        intervalSize: Int, intervalOffset: Int,
        x: Int, y: Int,
        width: Int, height: Int,
    )

    /** Alpha Blend ARGB images and store to destination */
    external fun planerARGBBlend(
        srcARGB0: ByteBuffer, srcStrideARGB0: Int,
        srcARGB1: ByteBuffer, srcStrideARGB1: Int,
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        width: Int, height: Int,
    )

    /** Alpha Blend YUV images and store to destination */
    external fun planerI420Blend(
        srcY0: ByteBuffer, srcStrideY0: Int,
        srcU0: ByteBuffer, srcStrideU0: Int,
        srcV0: ByteBuffer, srcStrideV0: Int,
        srcY1: ByteBuffer, srcStrideY1: Int,
        srcU1: ByteBuffer, srcStrideU1: Int,
        srcV1: ByteBuffer, srcStrideV1: Int,
        srcA: ByteBuffer, srcStrideA: Int,
        dstY: ByteBuffer, dstStrideY: Int,
        dstU: ByteBuffer, dstStrideU: Int,
        dstV: ByteBuffer, dstStrideV: Int,
        width: Int, height: Int,
    )

    /** Multiply ARGB image by ARGB image. Shifted down by 8. Saturates to 255 */
    external fun planerARGBMultiply(
        srcARGB0: ByteBuffer, srcStrideARGB0: Int,
        srcARGB1: ByteBuffer, srcStrideARGB1: Int,
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        width: Int, height: Int,
    )

    /** Add ARGB image with ARGB image. Saturates to 255 */
    external fun planerARGBAdd(
        srcARGB0: ByteBuffer, srcStrideARGB0: Int,
        srcARGB1: ByteBuffer, srcStrideARGB1: Int,
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        width: Int, height: Int,
    )

    /** Subtract ARGB image with ARGB image. Saturates to 0 */
    external fun planerARGBSubtract(
        srcARGB0: ByteBuffer, srcStrideARGB0: Int,
        srcARGB1: ByteBuffer, srcStrideARGB1: Int,
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        width: Int, height: Int,
    )

    /** Blur ARGB image */
    external fun planerARGBBlur(
        srcARGB: ByteBuffer, srcStrideARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        width: Int, height: Int,
        radius: Int,
    )

    /** Multiply ARGB image by ARGB value */
    external fun planerARGBShade(
        srcARGB: ByteBuffer, srcStrideARGB: Int,
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        width: Int, height: Int,
        value: Long,
    )

    /** Interpolate between two ARGB images using specified amount of interpolation Internally calls InterpolatePlane with width * 4 (bpp). */
    external fun planerARGBInterpolate(
        srcARGB0: ByteBuffer, srcStrideARGB0: Int,
        srcARGB1: ByteBuffer, srcStrideARGB1: Int,
        dstARGB: ByteBuffer, dstStrideARGB: Int,
        width: Int, height: Int,
        interpolation: Int,
    )

    /** Interpolate between two YUV images using specified amount of interpolation Internally calls InterpolatePlane on each plane where the U and V planes are half width and half height */
    external fun planerI420Interpolate(
        srcY0: ByteBuffer, srcStrideY0: Int,
        srcU0: ByteBuffer, srcStrideU0: Int,
        srcV0: ByteBuffer, srcStrideV0: Int,
        srcY1: ByteBuffer, srcStrideY1: Int,
        srcU1: ByteBuffer, srcStrideU1: Int,
        srcV1: ByteBuffer, srcStrideV1: Int,
        dstY: ByteBuffer, dstStrideY: Int,
        dstU: ByteBuffer, dstStrideU: Int,
        dstV: ByteBuffer, dstStrideV: Int,
        width: Int, height: Int,
        interpolation: Int,
    )

    // compare.cpp

    /** Compute a hash for specified memory. Seed of 5381 recommended. */
    external fun hashDjb2(src: ByteBuffer, count: Long, seed: Long): Long

    /** Compute Hamming Distance */
    external fun computeHammingDistance(srcA: ByteBuffer, srcB: ByteBuffer, count: Int): ByteArray

    /** Compute Sum Square Error Plane */
    external fun computeSumSquareErrorPlane(
        srcA: ByteBuffer, srcStrideA: Int,
        srcB: ByteBuffer, srcStrideB: Int,
        width: Int, height: Int,
    ): ByteArray

    /** Calculate Frame PSNR. */
    external fun calcFramePsnr(
        srcA: ByteBuffer, srcStrideA: Int,
        srcB: ByteBuffer, srcStrideB: Int,
        width: Int, height: Int,
    ): Double

    /** Calculate Frame PSNR. */
    external fun calcI420Psnr(
        srcYA: ByteBuffer, srcStrideYA: Int,
        srcUA: ByteBuffer, srcStrideUA: Int,
        srcVA: ByteBuffer, srcStrideVA: Int,
        srcYB: ByteBuffer, srcStrideYB: Int,
        srcUB: ByteBuffer, srcStrideUB: Int,
        srcVB: ByteBuffer, srcStrideVB: Int,
        width: Int, height: Int,
    ): Double

    /** Calculate Frame SSIM. */
    external fun calcFrameSsim(
        srcA: ByteBuffer, srcStrideA: Int,
        srcB: ByteBuffer, srcStrideB: Int,
        width: Int, height: Int,
    ): Double

    /** Calculate Frame SSIM. */
    external fun calcI420Ssim(
        srcYA: ByteBuffer, srcStrideYA: Int,
        srcUA: ByteBuffer, srcStrideUA: Int,
        srcVA: ByteBuffer, srcStrideVA: Int,
        srcYB: ByteBuffer, srcStrideYB: Int,
        srcUB: ByteBuffer, srcStrideUB: Int,
        srcVB: ByteBuffer, srcStrideVB: Int,
        width: Int, height: Int,
    ): Double

    // memcopy.cpp

    external fun memcopy(dst: Any, dstOffset: Int, src: Any, srcOffset: Int, length: Int)
}
