#include <libyuv.h>
#include "rotate.h"

using namespace libyuv;
using namespace libyuv::jniutil;

extern "C" {

// Rotate I420 frame.
PLANES_3_TO_3_R(I420Rotate, y, u, v, y, u, v);

// Rotate I422 frame.
PLANES_3_TO_3_R(I422Rotate, y, u, v, y, u, v);

// Rotate I444 frame.
PLANES_3_TO_3_R(I444Rotate, y, u, v, y, u, v);

// Rotate NV12 input and store in I420.
PLANES_2_TO_3_R(NV12ToI420Rotate, y, uv, y, u ,v);

// Convert Android420 to I420 with rotation. "rotation" can be 0, 90, 180 or 270.
PLANES_4_TO_3_R(Android420ToI420Rotate, y, u, v, uv, y, u, v);

// Rotate a plane by 0, 90, 180, or 270.
PLANES_1_TO_1_R(RotatePlane, p, p);

// Rotate UV and split into planar.
// width and height expected to be half size for NV12
PLANES_1_TO_2_R(SplitRotateUV, uv, u, v);

// The 90 and 270 functions are based on transposes. Deprecated
PLANES_1_TO_1_V(TransposePlane, p, p);

PLANES_1_TO_2_V(SplitTransposeUV, p, a, b);

static int rotateNV12RotateInternal(
        const uint8_t *src_y, int src_stride_y,
        const uint8_t *src_uv, int src_stride_uv,
        uint8_t *dst_y, const int dst_stride_y,
        uint8_t *dst_uv, const int dst_stride_uv,
        uint8_t *split_u, uint8_t *split_v,
        uint8_t *merge_u, uint8_t *merge_v,
        const int width, const int height, const int half_width, const int half_height, const int mode) {

    switch (mode) {
        case kRotate90:
            RotatePlane90(src_y, src_stride_y, dst_y, dst_stride_y, width, height);
            SplitRotateUV90(src_uv, src_stride_uv, split_u, half_height, split_v, half_height, half_width, half_height);
            MergeUVPlane(merge_u, half_height, merge_v, half_height, dst_uv, dst_stride_uv, half_height, half_width);
            break;
        case kRotate270:
            RotatePlane270(src_y, src_stride_y, dst_y, dst_stride_y, width, height);
            SplitRotateUV270(src_uv, src_stride_uv, split_u, half_height, split_v, half_height, half_width, half_height);
            MergeUVPlane(merge_u, half_height, merge_v, half_height, dst_uv, dst_stride_uv, half_height, half_width);
            break;
        case kRotate180:
            RotatePlane180(src_y, src_stride_y, dst_y, dst_stride_y, width, height);
            SplitRotateUV180(src_uv, src_stride_uv, split_u, half_width, split_v, half_width, half_width, half_height);
            MergeUVPlane(merge_u, half_width, merge_v, half_width, dst_uv, dst_stride_uv, half_width, half_height);
            break;
        default:
            break;
    }

    return 0;
}

JNI_DEFINE_METHOD(void, rotateNV12Rotate,
      const jobject j_src_y, const jint j_src_stride_y, const jint j_src_offset_y,
            jobject j_src_uv, const jint j_src_stride_uv, const jint j_src_offset_uv,
            jobject j_dst_y, const jint j_dst_stride_y, const jint j_dst_offset_y,
            jobject j_dst_uv, const jint j_dst_stride_uv, const jint j_dst_offset_uv,
      const jint width, jint height, const jint mode) {
    SRC_PLANE_OFFSET(y);
    SRC_PLANE_OFFSET(uv);
    DST_PLANE_OFFSET(y);
    DST_PLANE_OFFSET(uv);

    if (width <= 0 || height == 0) {
        return;
    }

    if (mode == kRotate0) {
        // copy frame
        CopyPlane(src_y, src_stride_y, dst_y, dst_stride_y, width, height);
        CopyPlane(src_uv, src_stride_uv, dst_uv, dst_stride_uv, width, height);
        return;
    }

    int halfwidth = (width + 1) >> 1;
    int halfheight = (height + 1) >> 1;

    // Negative height means invert the image.
    if (height < 0) {
        height = -height;
        halfheight = (height + 1) >> 1;
        src_y = src_y + (height - 1) * src_stride_y;
        src_uv = src_uv + (halfheight - 1) * src_stride_uv;
        src_stride_y = -src_stride_y;
        src_stride_uv = -src_stride_uv;
    }

    // Allocate u and v buffers
    align_buffer_64(plane_u, halfwidth * halfheight * 2);
    uint8_t* plane_v = plane_u + halfwidth * halfheight;
    rotateNV12RotateInternal(src_y, src_stride_y, src_uv, src_stride_uv,
                             dst_y, dst_stride_y, dst_uv, dst_stride_uv,
                             plane_u, plane_v,
                             plane_u, plane_v,
                             width, height, halfwidth, halfheight, mode);
    free_aligned_buffer_64(plane_u);
}

JNI_DEFINE_METHOD(void, rotateNV21Rotate,
                  const jobject j_src_y, const jint j_src_stride_y, const jint j_src_offset_y,
                  const jobject j_src_vu, const jint j_src_stride_vu, const jint j_src_offset_vu,
                  jobject j_dst_y, const jint j_dst_stride_y, const jint j_dst_offset_y,
                  jobject j_dst_vu, const jint j_dst_stride_vu, const jint j_dst_offset_vu,
                  const jint width, jint height, const jint mode) {
    SRC_PLANE_OFFSET(y);
    SRC_PLANE_OFFSET(vu);
    DST_PLANE_OFFSET(y);
    DST_PLANE_OFFSET(vu);

    if (width <= 0 || height == 0) {
        return;
    }

    if (mode == kRotate0) {
        // copy frame
        CopyPlane(src_y, src_stride_y, dst_y, dst_stride_y, width, height);
        CopyPlane(src_vu, src_stride_vu, dst_vu, dst_stride_vu, width, height);
        return;
    }

    int halfwidth = (width + 1) >> 1;
    int halfheight = (height + 1) >> 1;

    // Negative height means invert the image.
    if (height < 0) {
        height = -height;
        halfheight = (height + 1) >> 1;
        src_y = src_y + (height - 1) * src_stride_y;
        src_vu = src_vu + (halfheight - 1) * src_stride_vu;
        src_stride_y = -src_stride_y;
        src_stride_vu = -src_stride_vu;
    }

    // Allocate v and u buffers
    align_buffer_64(plane_v, halfwidth * halfheight * 2);
    uint8_t* plane_u = plane_v + halfwidth * halfheight;
    rotateNV12RotateInternal(src_y, src_stride_y, src_vu, src_stride_vu,
                             dst_y, dst_stride_y, dst_vu, dst_stride_vu,
                             plane_u, plane_v,
                             plane_u, plane_v,
                             width, height, halfwidth, halfheight, mode);
    free_aligned_buffer_64(plane_v);
}

JNI_DEFINE_METHOD(void, rotateNV12ToNV21Rotate,
                  const jobject j_src_y, const jint j_src_stride_y, const jint j_src_offset_y,
                  const jobject j_src_uv, const jint j_src_stride_uv, const jint j_src_offset_uv,
                  jobject j_dst_y, const jint j_dst_stride_y, const jint j_dst_offset_y,
                  jobject j_dst_vu, const jint j_dst_stride_vu, const jint j_dst_offset_vu,
                  const jint width, jint height, const jint mode) {
    SRC_PLANE_OFFSET(y);
    SRC_PLANE_OFFSET(uv);
    DST_PLANE_OFFSET(y);
    DST_PLANE_OFFSET(vu);

    if (width <= 0 || height == 0) {
        return;
    }

    if (mode == kRotate0) {
        // copy frame
        CopyPlane(src_y, src_stride_y, dst_y, dst_stride_y, width, height);
        SwapUVPlane(src_uv, src_stride_uv, dst_vu, dst_stride_vu, width, height);
        return;
    }

    int halfwidth = (width + 1) >> 1;
    int halfheight = (height + 1) >> 1;

    // Negative height means invert the image.
    if (height < 0) {
        height = -height;
        halfheight = (height + 1) >> 1;
        src_y = src_y + (height - 1) * src_stride_y;
        src_uv = src_uv + (halfheight - 1) * src_stride_uv;
        src_stride_y = -src_stride_y;
        src_stride_uv = -src_stride_uv;
    }

    // Allocate v and u buffers
    align_buffer_64(plane_v, halfwidth * halfheight * 2);
    uint8_t* plane_u = plane_v + halfwidth * halfheight;
    rotateNV12RotateInternal(src_y, src_stride_y, src_uv, src_stride_uv,
                             dst_y, dst_stride_y, dst_vu, dst_stride_vu,
                             plane_v, plane_u,
                             plane_u, plane_v,
                             width, height, halfwidth, halfheight, mode);
    free_aligned_buffer_64(plane_v);
}

}
