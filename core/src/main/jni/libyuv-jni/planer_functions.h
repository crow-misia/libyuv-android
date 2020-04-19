#ifndef LIBYUV_JNI_PLANER_FUNCTIONS_H_
#define LIBYUV_JNI_PLANER_FUNCTIONS_H_

#include "jniutil.h"
#include "macros.h"
#include "nativehelper/scoped_bytes.h"

#define PLANES_2_TO_2(NAME, S1, S2, D1, D2) \
  JNI_DEFINE_METHOD(void, planer##NAME, \
      const jobject j_src_##S1, const jint j_src_stride_##S1, \
      const jobject j_src_##S2, const jint j_src_stride_##S2, \
            jobject j_dst_##D1, const jint j_dst_stride_##D1, \
            jobject j_dst_##D2, const jint j_dst_stride_##D2, \
      const jint width, const jint height) { \
    SRC_PLANE(S1); \
    SRC_PLANE(S2); \
    DST_PLANE(D1); \
    DST_PLANE(D2); \
    CALL(NAME, \
         src_##S1, src_stride_##S1, \
         src_##S2, src_stride_##S2, \
         dst_##D1, dst_stride_##D1, \
         dst_##D2, dst_stride_##D2, \
         width, height); \
  }

#endif // LIBYUV_JNI_PLANER_FUNCTIONS_H_
