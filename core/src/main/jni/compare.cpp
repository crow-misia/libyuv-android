#include <libyuv.h>
#include "compare.h"

using namespace libyuv;
using namespace libyuv::jniutil;
extern "C" {

static jbyteArray bignumToArray(JNIEnv *env, const uint64_t value) {
    const size_t numBytes = sizeof(uint64_t);
    jbyteArray javaBytes = env->NewByteArray(static_cast<jsize>(numBytes));
    ScopedBytesRW bytes(env, javaBytes);
    jbyte *cbytes = bytes.get();
    if (cbytes == nullptr) {
        return nullptr;
    }

    uint64_t tmp = value;
    int i;
    for (i = (int) (numBytes - 1); i >= 0; i--) {
        cbytes[i] = (jbyte)(tmp & 0xFF);
        tmp >>= 8;
    }
    return javaBytes;

}

// Compute a hash for specified memory. Seed of 5381 recommended.
JNI_DEFINE_METHOD(jlong, hashDjb2,
                  const jobject j_src, const jlong count, const jlong seed) {
    DECLARE_BUFFER_SRC(j_src, src, 0);

    return HashDjb2(src, count, seed);
}

// Hamming Distance
JNI_DEFINE_METHOD(jbyteArray, computeHammingDistance,
                  const jobject j_src_a, const jobject j_src_b, const jint count) {
    DECLARE_BUFFER_SRC(j_src_a, src_a, nullptr);
    DECLARE_BUFFER_SRC(j_src_b, src_b, nullptr);

    uint64_t value = ComputeHammingDistance(src_a, src_b, count);

    return bignumToArray(env, value);
}

JNI_DEFINE_METHOD(jbyteArray, computeSumSquareErrorPlane,
                  const jobject j_src_a, const jint j_src_stride_a,
                  const jobject j_src_b, const jint j_src_stride_b,
                  const jint width, const jint height) {
    SRC_PLANE_RET(a, nullptr);
    SRC_PLANE_RET(b, nullptr);

    uint64_t value = ComputeSumSquareErrorPlane(src_a, src_stride_a, src_b, src_stride_b, width, height);

    return bignumToArray(env, value);
}

// Calculate Frame PSNR.
JNI_DEFINE_METHOD(jdouble, calcFramePsnr,
                  const jobject j_src_a, const jint j_src_stride_a,
                  const jobject j_src_b, const jint j_src_stride_b,
                  const jint width, const jint height) {

    SRC_PLANE_RET(a, 0.0);
    SRC_PLANE_RET(b, 0.0);

    return CalcFramePsnr(src_a, src_stride_a, src_b, src_stride_b, width, height);
}

// Calculate I420 PSNR.
JNI_DEFINE_METHOD(jdouble, calcI420Psnr,
                  const jobject j_src_y_a, const jint j_src_stride_y_a,
                  const jobject j_src_u_a, const jint j_src_stride_u_a,
                  const jobject j_src_v_a, const jint j_src_stride_v_a,
                  const jobject j_src_y_b, const jint j_src_stride_y_b,
                  const jobject j_src_u_b, const jint j_src_stride_u_b,
                  const jobject j_src_v_b, const jint j_src_stride_v_b,
                  const jint width, const jint height) {
    SRC_PLANE_RET(y_a, 0.0);
    SRC_PLANE_RET(u_a, 0.0);
    SRC_PLANE_RET(v_a, 0.0);
    SRC_PLANE_RET(y_b, 0.0);
    SRC_PLANE_RET(u_b, 0.0);
    SRC_PLANE_RET(v_b, 0.0);

    return I420Psnr(
            src_y_a, src_stride_y_a,
            src_u_a, src_stride_u_a,
            src_v_a, src_stride_v_a,
            src_y_b, src_stride_y_b,
            src_u_b, src_stride_u_b,
            src_v_b, src_stride_v_b,
            width, height);
}

// Calculate Frame SSIM.
JNI_DEFINE_METHOD(jdouble, calcFrameSsim,
                  const jobject j_src_a, const jint j_src_stride_a,
                  const jobject j_src_b, const jint j_src_stride_b,
                  const jint width, const jint height) {
    SRC_PLANE_RET(a, 0.0);
    SRC_PLANE_RET(b, 0.0);

    return CalcFrameSsim(src_a, src_stride_a, src_b, src_stride_b, width, height);
}

// Calculate I420 SSIM.
JNI_DEFINE_METHOD(jdouble, calcI420Ssim,
                  const jobject j_src_y_a, const jint j_src_stride_y_a,
                  const jobject j_src_u_a, const jint j_src_stride_u_a,
                  const jobject j_src_v_a, const jint j_src_stride_v_a,
                  const jobject j_src_y_b, const jint j_src_stride_y_b,
                  const jobject j_src_u_b, const jint j_src_stride_u_b,
                  const jobject j_src_v_b, const jint j_src_stride_v_b,
                  const jint width, const jint height) {
    SRC_PLANE_RET(y_a, 0.0);
    SRC_PLANE_RET(u_a, 0.0);
    SRC_PLANE_RET(v_a, 0.0);
    SRC_PLANE_RET(y_b, 0.0);
    SRC_PLANE_RET(u_b, 0.0);
    SRC_PLANE_RET(v_b, 0.0);

    return I420Ssim(
            src_y_a, src_stride_y_a,
            src_u_a, src_stride_u_a,
            src_v_a, src_stride_v_a,
            src_y_b, src_stride_y_b,
            src_u_b, src_stride_u_b,
            src_v_b, src_stride_v_b,
            width, height);
}

}
