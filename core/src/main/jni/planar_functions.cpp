#include <libyuv.h>
#include "planar_functions.h"

using namespace libyuv;
using namespace libyuv::jniutil;

extern "C" {

// Copy a plane of data.
// CopyPlane
// CopyPlane_16
// Convert16To8Plane
// Convert8To16Plane

// Set a plane of data to a 32 bit value.
JNI_DEFINE_METHOD(void, planarSetPlane,
                  jobject j_dst_y, const jint j_dst_stride_y, const jint j_dst_offset_y,
                  const jint width, const jint height,
                  const jint value) {
    DST_PLANE_OFFSET(y);

    SetPlane(dst_y, dst_stride_y, width, height, value);
}

// Convert a plane of tiles of 16 x H to linear.
// DetilePlane

// Convert a UV plane of tiles of 16 x H into linear U and V planes.
// DetileSplitUVPlane

// Split interleaved UV plane into separate U and V planes.
// SplitUVPlane

// Merge separate U and V planes into one interleaved UV plane.
// MergeUVPlane

// Split interleaved msb UV plane into separate lsb U and V planes.
// SplitUVPlane_16

// Merge separate lsb U and V planes into one interleaved msb UV plane.
// MergeUVPlane_16

// Convert lsb plane to msb plane
// ConvertToMSBPlane_16

// Convert msb plane to lsb plane
// ConvertToLSBPlane_16

// Scale U and V to half width and height and merge into interleaved UV plane.
// HalfMergeUVPlane

// Swap U and V channels in interleaved UV plane.
// SwapUVPlane

// Split interleaved RGB plane into separate R, G and B planes.
// SplitRGBPlane

// Merge separate R, G and B planes into one interleaved RGB plane.
// MergeRGBPlane

// Split interleaved ARGB plane into separate R, G, B and A planes.
// SplitARGBPlane

// Merge separate R, G, B and A planes into one interleaved ARGB plane.
// MergeARGBPlane

// Merge separate 'depth' bit R, G and B planes stored in lsb
// into one interleaved XR30 plane.
// MergeXR30Plane

// Merge separate 'depth' bit R, G, B and A planes stored in lsb
// into one interleaved AR64 plane.
// MergeAR64Plane

// Merge separate 'depth' bit R, G, B and A planes stored in lsb
// into one interleaved ARGB plane.
// MergeARGB16To8Plane

// Copy I400.  Supports inverting. duplicate I400Copy
// PLANES_1_TO_1(I400ToI400, y, y);

// #define J400ToJ400 I400ToI400

// Copy I422 to I422.
// #define I422ToI422 I422Copy
PLANES_3_TO_3(I422Copy, y, u, v, y, u, v);

// Copy I444 to I444.
// #define I444ToI444 I444Copy
PLANES_3_TO_3(I444Copy, y, u, v, y, u, v);

// Copy I210 to I210.
// #define I210ToI210 I210Copy
// I210Copy

// Copy NV12. Supports inverting.
PLANES_2_TO_2(NV12Copy, y, vu, y, uv);

// Copy NV21. Supports inverting.
// NV21Copy

// Convert YUY2 to I422.
PLANES_1_TO_3(YUY2ToI422, yuy2, y, u, v);

// Convert UYVY to I422.
PLANES_1_TO_3(UYVYToI422, uyvy, y, u, v);

PLANES_1_TO_2(YUY2ToNV12, yuy2, y, uv);

PLANES_1_TO_2(UYVYToNV12, uyvy, y, uv);

// Convert NV21 to NV12.
PLANES_2_TO_2(NV21ToNV12, y, vu, y, uv);

// YUY2ToY

// Convert I420 to I400. (calls CopyPlane ignoring u/v).
PLANES_3_TO_1(I420ToI400, y, u, v, y);

// #define J420ToJ400 I420ToI400
// #define I420ToI420Mirror I420Mirror

// I420 mirror.
PLANES_3_TO_3(I420Mirror, y, u, v, y, u, v);

// #define I400ToI400Mirror I400Mirror

// I400 mirror.
PLANES_1_TO_1(I400Mirror, y, y);

// #define NV12ToNV12Mirror NV12Mirror

// NV12 mirror.
PLANES_2_TO_2(NV12Mirror, y, vu, y, uv);

// #define ARGBToARGBMirror ARGBMirror

// ARGB mirror.
PLANES_1_TO_1(ARGBMirror, argb, argb);

// #define RGB24ToRGB24Mirror RGB24Mirror

// RGB24 mirror.
PLANES_1_TO_1(RGB24Mirror, rgb24, rgb24);

// Mirror a plane of data.
// MirrorPlane

// Mirror a plane of UV data.
// MirrorUVPlane

// #define RGB24ToRAW RAWToRGB24

PLANES_1_TO_1(RAWToRGB24, raw, rgb24);

// Draw a rectangle into I420.
JNI_DEFINE_METHOD(void, planarI420Rect,
                  jobject j_dst_y, const jint j_dst_stride_y, const jint j_dst_offset_y,
                  jobject j_dst_u, const jint j_dst_stride_u, const jint j_dst_offset_u,
                  jobject j_dst_v, const jint j_dst_stride_v, const jint j_dst_offset_v,
                  const jint x, const jint y,
                  const jint width, const jint height,
                  const jint value_y, const jint value_u, const jint value_v) {
    DST_PLANE_OFFSET(y);
    DST_PLANE_OFFSET(u);
    DST_PLANE_OFFSET(v);

    I420Rect(dst_y, dst_stride_y, dst_u, dst_stride_u, dst_v, dst_stride_v, x, y, width, height, value_y, value_u, value_v);
}

// Draw a rectangle into ARGB.
JNI_DEFINE_METHOD(void, planarARGBRect,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jint x, const jint y,
                  const jint width, const jint height,
                  const jlong value) {
    DST_PLANE_OFFSET(argb);

    ARGBRect(dst_argb, dst_stride_argb, x, y, width, height, value);
}

// Convert ARGB to gray scale ARGB.
PLANES_1_TO_1(ARGBGrayTo, argb, argb);

// Make a rectangle of ARGB gray scale.
JNI_DEFINE_METHOD(void, planarARGBGray,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jint x, const jint y,
                  const jint width, const jint height) {
    DST_PLANE_OFFSET(argb);

    ARGBGray(dst_argb, dst_stride_argb, x, y, width, height);
}

// Make a rectangle of ARGB Sepia tone.
JNI_DEFINE_METHOD(void, planarARGBSepia,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jint x, const jint y,
                  const jint width, const jint height) {
    DST_PLANE_OFFSET(argb);

    ARGBSepia(dst_argb, dst_stride_argb, x, y, width, height);
}

// Apply a matrix rotation to each ARGB pixel.
JNI_DEFINE_METHOD(void, planarARGBColorMatrix,
                  const jobject j_src_argb, const jint j_src_stride_argb, const jint j_src_offset_argb,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jbyteArray j_matrix_argb,
                  const jint width, const jint height) {
    SRC_PLANE_OFFSET(argb);
    DST_PLANE_OFFSET(argb);
    jbyte *matrix_argb = env->GetByteArrayElements(j_matrix_argb, nullptr);

    ARGBColorMatrix(src_argb, src_stride_argb, dst_argb, dst_stride_argb, matrix_argb, width, height);

    env->ReleaseByteArrayElements(j_matrix_argb, matrix_argb, JNI_ABORT);
}

// Apply a color table each ARGB pixel.
JNI_DEFINE_METHOD(void, planarARGBColorTable,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jbyteArray j_table_argb,
                  const jint x, const jint y,
                  const jint width, const jint height) {
    DST_PLANE_OFFSET(argb);
    jbyte *table_argb = env->GetByteArrayElements(j_table_argb, nullptr);

    ARGBColorTable(dst_argb, dst_stride_argb, reinterpret_cast<const uint8_t *>(table_argb), x, y, width, height);

    env->ReleaseByteArrayElements(j_table_argb, table_argb, JNI_ABORT);
}

// Apply a color table each ARGB pixel but preserve destination alpha.
JNI_DEFINE_METHOD(void, planarRGBColorTable,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jbyteArray j_table_argb,
                  const jint x, const jint y,
                  const jint width, const jint height) {
    DST_PLANE_OFFSET(argb);
    jbyte *table_argb = env->GetByteArrayElements(j_table_argb, nullptr);

    RGBColorTable(dst_argb, dst_stride_argb, reinterpret_cast<const uint8_t *>(table_argb), x, y, width, height);

    env->ReleaseByteArrayElements(j_table_argb, table_argb, JNI_ABORT);
}

// Apply a luma/color table each ARGB pixel but preserve destination alpha.
JNI_DEFINE_METHOD(void, planarARGBLumaColorTable,
                  const jobject j_src_argb, const jint j_src_stride_argb, const jint j_src_offset_argb,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jbyteArray j_luma,
                  const jint width, const jint height) {
    SRC_PLANE_OFFSET(argb);
    DST_PLANE_OFFSET(argb);
    jbyte *luma = env->GetByteArrayElements(j_luma, nullptr);

    ARGBLumaColorTable(src_argb, src_stride_argb, dst_argb, dst_stride_argb,
                       reinterpret_cast<const uint8_t *>(luma), width, height);

    env->ReleaseByteArrayElements(j_luma, luma, JNI_ABORT);
}

// Apply a 3 term polynomial to ARGB values.
JNI_DEFINE_METHOD(void, planarARGBPolynomial,
                  const jobject j_src_argb, const jint j_src_stride_argb, const jint j_src_offset_argb,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jfloatArray j_poly,
                  const jint width, const jint height) {
    SRC_PLANE_OFFSET(argb);
    DST_PLANE_OFFSET(argb);
    jfloat *poly = env->GetFloatArrayElements(j_poly, nullptr);

    ARGBPolynomial(src_argb, src_stride_argb,
                   dst_argb, dst_stride_argb,
                   poly,
                   width, height);

    env->ReleaseFloatArrayElements(j_poly, poly, JNI_ABORT);
}

// Convert plane of 16 bit shorts to half floats.
// HalfFloatPlane

// Convert a buffer of bytes to floats, scale the values and store as floats.
// ByteToFloat

// Quantize a rectangle of ARGB. Alpha unaffected.
JNI_DEFINE_METHOD(void, planarARGBQuantize,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jint scale,
                  const jint interval_size, const jint interval_offset,
                  const jint dst_x, const jint dst_y,
                  const jint width, const jint height) {
    DST_PLANE_OFFSET(argb);

    ARGBQuantize(dst_argb, dst_stride_argb,
                 scale,
                 interval_size, interval_offset,
                 dst_x, dst_y,
                 width, height);
}

// Copy ARGB to ARGB. duplicate
// ARGBCopy

// Copy Alpha channel of ARGB to alpha of ARGB.
PLANES_1_TO_1(ARGBCopyAlpha, argb, argb);

// Extract the alpha channel from ARGB.
PLANES_1_TO_1(ARGBExtractAlpha, argb, a);

// Copy Y channel to Alpha of ARGB.
PLANES_1_TO_1(ARGBCopyYToAlpha, y, argb);

// Get function to Alpha Blend ARGB pixels and store to destination.
// GetARGBBlend

// Alpha Blend ARGB images and store to destination.
JNI_DEFINE_METHOD(void, planarARGBBlend,
                  jobject j_src_argb0, const jint j_src_stride_argb0, const jint j_src_offset_argb0,
                  jobject j_src_argb1, const jint j_src_stride_argb1, const jint j_src_offset_argb1,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jint width, const jint height) {
    SRC_PLANE_OFFSET(argb0);
    SRC_PLANE_OFFSET(argb1);
    DST_PLANE_OFFSET(argb);

    ARGBBlend(src_argb0, src_stride_argb0,
              src_argb1, src_stride_argb1,
              dst_argb, dst_stride_argb,
              width, height);
}

// Alpha Blend plane and store to destination.
// BlendPlane

// Alpha Blend YUV images and store to destination.
JNI_DEFINE_METHOD(void, planarI420Blend,
                  jobject j_src_y0, const jint j_src_stride_y0, const jint j_src_offset_y0,
                  jobject j_src_u0, const jint j_src_stride_u0, const jint j_src_offset_u0,
                  jobject j_src_v0, const jint j_src_stride_v0, const jint j_src_offset_v0,
                  jobject j_src_y1, const jint j_src_stride_y1, const jint j_src_offset_y1,
                  jobject j_src_u1, const jint j_src_stride_u1, const jint j_src_offset_u1,
                  jobject j_src_v1, const jint j_src_stride_v1, const jint j_src_offset_v1,
                  jobject j_src_a, const jint j_src_stride_a, const jint j_src_offset_a,
                  jobject j_dst_y, const jint j_dst_stride_y, const jint j_dst_offset_y,
                  jobject j_dst_u, const jint j_dst_stride_u, const jint j_dst_offset_u,
                  jobject j_dst_v, const jint j_dst_stride_v, const jint j_dst_offset_v,
                  const jint width, const jint height) {
    SRC_PLANE_OFFSET(y0);
    SRC_PLANE_OFFSET(u0);
    SRC_PLANE_OFFSET(v0);
    SRC_PLANE_OFFSET(y1);
    SRC_PLANE_OFFSET(u1);
    SRC_PLANE_OFFSET(v1);
    SRC_PLANE_OFFSET(a);
    DST_PLANE_OFFSET(y);
    DST_PLANE_OFFSET(u);
    DST_PLANE_OFFSET(v);

    I420Blend(src_y0, src_stride_y0,
              src_u0, src_stride_u0,
              src_v0, src_stride_v0,
              src_y1, src_stride_y1,
              src_u1, src_stride_u1,
              src_v1, src_stride_v1,
              src_a, src_stride_a,
              dst_y, dst_stride_y,
              dst_u, dst_stride_u,
              dst_v, dst_stride_v,
              width, height);
}

// Multiply ARGB image by ARGB image. Shifted down by 8. Saturates to 255.
JNI_DEFINE_METHOD(void, planarARGBMultiply,
                  jobject j_src_argb0, const jint j_src_stride_argb0, const jint j_src_offset_argb0,
                  jobject j_src_argb1, const jint j_src_stride_argb1,  const jint j_src_offset_argb1,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jint width, const jint height) {
    SRC_PLANE_OFFSET(argb0);
    SRC_PLANE_OFFSET(argb1);
    DST_PLANE_OFFSET(argb);

    ARGBMultiply(src_argb0, src_stride_argb0,
              src_argb1, src_stride_argb1,
              dst_argb, dst_stride_argb,
              width, height);
}

// Add ARGB image with ARGB image. Saturates to 255.
JNI_DEFINE_METHOD(void, planarARGBAdd,
                  jobject j_src_argb0, const jint j_src_stride_argb0, const jint j_src_offset_argb0,
                  jobject j_src_argb1, const jint j_src_stride_argb1, const jint j_src_offset_argb1,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jint width, const jint height) {
    SRC_PLANE_OFFSET(argb0);
    SRC_PLANE_OFFSET(argb1);
    DST_PLANE_OFFSET(argb);

    ARGBAdd(src_argb0, src_stride_argb0,
                 src_argb1, src_stride_argb1,
                 dst_argb, dst_stride_argb,
                 width, height);
}

// Subtract ARGB image (argb1) from ARGB image (argb0). Saturates to 0.
JNI_DEFINE_METHOD(void, planarARGBSubtract,
                  jobject j_src_argb0, const jint j_src_stride_argb0, const jint j_src_offset_argb0,
                  jobject j_src_argb1, const jint j_src_stride_argb1, const jint j_src_offset_argb1,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jint width, const jint height) {
    SRC_PLANE_OFFSET(argb0);
    SRC_PLANE_OFFSET(argb1);
    DST_PLANE_OFFSET(argb);

    ARGBSubtract(src_argb0, src_stride_argb0,
            src_argb1, src_stride_argb1,
            dst_argb, dst_stride_argb,
            width, height);
}

// Convert I422 to YUY2.
PLANES_3_TO_1(I422ToYUY2, y, u, v, yuy2);

// Convert I422 to UYVY.
PLANES_3_TO_1(I422ToUYVY, y, u, v, uyvy);

// Convert unattentuated ARGB to preattenuated ARGB.
PLANES_1_TO_1(ARGBAttenuate, argb, argb);

// Convert preattentuated ARGB to unattenuated ARGB.
PLANES_1_TO_1(ARGBUnattenuate, argb, argb);

// Blur ARGB image.
JNI_DEFINE_METHOD(void, planarARGBBlur,
                  jobject j_src_argb, const jint j_src_stride_argb, const jint j_src_offset_argb,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jint width, const jint height,
                  const jint radius) {
    SRC_PLANE_OFFSET(argb);
    DST_PLANE_OFFSET(argb);

    auto* dst_cumsum = static_cast<int32_t *>(malloc((size_t) width * (height + 1) * 16));

    ARGBBlur(src_argb, src_stride_argb,
             dst_argb, dst_stride_argb,
             dst_cumsum, dst_stride_argb,
             width, height,
             radius);

    free(dst_cumsum);
}

// Gaussian 5x5 blur a float plane.
// GaussPlane_F32

// Multiply ARGB image by ARGB value.
JNI_DEFINE_METHOD(void, planarARGBShade,
                  jobject j_src_argb, const jint j_src_stride_argb, const jint j_src_offset_argb,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jint width, const jint height,
                  const jlong value) {
    SRC_PLANE_OFFSET(argb);
    DST_PLANE_OFFSET(argb);

    ARGBShade(src_argb, src_stride_argb,
             dst_argb, dst_stride_argb,
             width, height,
             value);
}

// Interpolate between two images using specified amount of interpolation
// (0 to 255) and store to destination.
// InterpolatePlane

// Interpolate between two ARGB images using specified amount of interpolation
// Internally calls InterpolatePlane with width * 4 (bpp).
JNI_DEFINE_METHOD(void, planarARGBInterpolate,
                  jobject j_src_argb0, const jint j_src_stride_argb0, const jint j_src_offset_argb0,
                  jobject j_src_argb1, const jint j_src_stride_argb1, const jint j_src_offset_argb1,
                  jobject j_dst_argb, const jint j_dst_stride_argb, const jint j_dst_offset_argb,
                  const jint width, const jint height,
                  const jint interpolation) {
    SRC_PLANE_OFFSET(argb0);
    SRC_PLANE_OFFSET(argb1);
    DST_PLANE_OFFSET(argb);

    ARGBInterpolate(src_argb0, src_stride_argb0,
                    src_argb1, src_stride_argb1,
                    dst_argb, dst_stride_argb,
                    width, height,
                    interpolation);
}

// Interpolate between two YUV images using specified amount of interpolation
// Internally calls InterpolatePlane on each plane where the U and V planes
// are half width and half height.
JNI_DEFINE_METHOD(void, planarI420Interpolate,
                  jobject j_src_y0, const jint j_src_stride_y0, const jint j_src_offset_y0,
                  jobject j_src_u0, const jint j_src_stride_u0, const jint j_src_offset_u0,
                  jobject j_src_v0, const jint j_src_stride_v0, const jint j_src_offset_v0,
                  jobject j_src_y1, const jint j_src_stride_y1, const jint j_src_offset_y1,
                  jobject j_src_u1, const jint j_src_stride_u1, const jint j_src_offset_u1,
                  jobject j_src_v1, const jint j_src_stride_v1, const jint j_src_offset_v1,
                  jobject j_dst_y, const jint j_dst_stride_y, const jint j_dst_offset_y,
                  jobject j_dst_u, const jint j_dst_stride_u, const jint j_dst_offset_u,
                  jobject j_dst_v, const jint j_dst_stride_v, const jint j_dst_offset_v,
                  const jint width, const jint height,
                  const jint interpolation) {
    SRC_PLANE_OFFSET(y0);
    SRC_PLANE_OFFSET(u0);
    SRC_PLANE_OFFSET(v0);
    SRC_PLANE_OFFSET(y1);
    SRC_PLANE_OFFSET(u1);
    SRC_PLANE_OFFSET(v1);
    DST_PLANE_OFFSET(y);
    DST_PLANE_OFFSET(u);
    DST_PLANE_OFFSET(v);

    I420Interpolate(src_y0, src_stride_y0,
                    src_u0, src_stride_u0,
                    src_v0, src_stride_v0,
                    src_y1, src_stride_y1,
                    src_u1, src_stride_u1,
                    src_v1, src_stride_v1,
                    dst_y, dst_stride_y,
                    dst_u, dst_stride_u,
                    dst_v, dst_stride_v,
                    width, height,
                    interpolation);
}

// Shuffle ARGB channel order.  e.g. BGRA to ARGB.
// ARGBShuffle

// Shuffle AR64 channel order.  e.g. AR64 to AB64.
// AR64Shuffle

// Sobel ARGB effect with planar output.
// ARGBSobelToPlane

// Sobel ARGB effect.
// ARGBSobel

// Sobel ARGB effect w/ Sobel X, Sobel, Sobel Y in ARGB.
// ARGBSobelXY
}
