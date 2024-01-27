#ifndef LIBYUV_JNI_SCALE_H_
#define LIBYUV_JNI_SCALE_H_

#include "jniutil.h"
#include "macros.h"
#include "nativehelper/scoped_bytes.h"

#define PLANES_1_TO_1(NAME, S1, D1) \
  JNI_DEFINE_METHOD(void, scale##NAME, \
      const jobject j_src_##S1, const jint j_src_stride_##S1, \
      const jint src_width, const jint src_height, \
            jobject j_dst_##D1, const jint j_dst_stride_##D1, \
      const jint dst_width, const jint dst_height, \
      const jint mode) { \
    SRC_PLANE(S1); \
    DST_PLANE(D1); \
    CALL(NAME, \
         src_##S1, src_stride_##S1, \
         src_width, src_height, \
         dst_##D1, dst_stride_##D1, \
         dst_width, dst_height, \
         (FilterMode) mode); \
  }

#define PLANES_1_TO_1_CLIP(NAME, S1, D1) \
  JNI_DEFINE_METHOD(void, scale##NAME, \
      const jobject j_src_##S1, const jint j_src_stride_##S1, \
      const jint src_width, const jint src_height, \
            jobject j_dst_##D1, const jint j_dst_stride_##D1, \
      const jint dst_width, const jint dst_height, \
      const jint clip_x, const jint clip_y, const jint clip_width, const jint clip_height, \
      const jint mode) { \
    SRC_PLANE(S1); \
    DST_PLANE(D1); \
    CALL(NAME, \
         src_##S1, src_stride_##S1, \
         src_width, src_height, \
         dst_##D1, dst_stride_##D1, \
         dst_width, dst_height, \
         clip_x, clip_y, clip_width, clip_height, \
         (FilterMode) mode); \
  }

#define PLANES_1_TO_1_V(NAME, S1, D1) \
  JNI_DEFINE_METHOD(void, scale##NAME, \
      const jobject j_src_##S1, const jint j_src_stride_##S1, const jint src_width, const jint src_height, \
            jobject j_dst_##D1, const jint j_dst_stride_##D1, const jint dst_width, const jint dst_height, \
      const jint mode) { \
    SRC_PLANE(S1); \
    DST_PLANE(D1); \
    CALL(NAME, \
         src_##S1, src_stride_##S1, src_width, src_height, \
         dst_##D1, dst_stride_##D1, dst_width, dst_height, \
         (FilterMode) mode); \
  }

#define PLANES_2_TO_2(NAME, S1, S2, D1, D2) \
  JNI_DEFINE_METHOD(void, scale##NAME, \
      const jobject j_src_##S1, const jint j_src_stride_##S1, \
      const jobject j_src_##S2, const jint j_src_stride_##S2, \
      const jint src_width, const jint src_height, \
            jobject j_dst_##D1, const jint j_dst_stride_##D1, \
            jobject j_dst_##D2, const jint j_dst_stride_##D2, \
      const jint dst_width, const jint dst_height, \
      const jint mode) { \
    SRC_PLANE(S1); \
    SRC_PLANE(S2); \
    DST_PLANE(D1); \
    DST_PLANE(D2); \
    CALL(NAME, \
         src_##S1, src_stride_##S1, \
         src_##S2, src_stride_##S2, \
         src_width, src_height, \
         dst_##D1, dst_stride_##D1, \
         dst_##D2, dst_stride_##D2, \
         dst_width, dst_height, \
         (FilterMode) mode); \
  }

#define PLANES_3_TO_3(NAME, S1, S2, S3, D1, D2, D3) \
  JNI_DEFINE_METHOD(void, scale##NAME, \
      const jobject j_src_##S1, const jint j_src_stride_##S1, \
      const jobject j_src_##S2, const jint j_src_stride_##S2, \
      const jobject j_src_##S3, const jint j_src_stride_##S3, \
      const jint src_width, const jint src_height, \
            jobject j_dst_##D1, const jint j_dst_stride_##D1, \
            jobject j_dst_##D2, const jint j_dst_stride_##D2, \
            jobject j_dst_##D3, const jint j_dst_stride_##D3, \
      const jint dst_width, const jint dst_height, \
      const jint mode) { \
    SRC_PLANE(S1); \
    SRC_PLANE(S2); \
    SRC_PLANE(S3); \
    DST_PLANE(D1); \
    DST_PLANE(D2); \
    DST_PLANE(D3); \
    CALL(NAME, \
         src_##S1, src_stride_##S1, \
         src_##S2, src_stride_##S2, \
         src_##S3, src_stride_##S3, \
         src_width, src_height, \
         dst_##D1, dst_stride_##D1, \
         dst_##D2, dst_stride_##D2, \
         dst_##D3, dst_stride_##D3, \
         dst_width, dst_height, \
         (FilterMode) mode); \
  }

#endif // LIBYUV_JNI_SCALE_H_
