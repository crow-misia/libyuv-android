#include <jni.h>
#include <cstddef>
#include "libyuv.h"

using namespace libyuv;

extern "C" {

JNIEXPORT void JNICALL
Java_io_github_zncmn_libyuv_Yuv_abgrToArgb(JNIEnv *env, jobject,
                                           jbyteArray srcArray, jint width, jint height,
                                           jbyteArray destArray) {
    jbyte *src = env->GetByteArrayElements(srcArray, NULL);
    jbyte *dest = env->GetByteArrayElements(destArray, NULL);

    ABGRToARGB((uint8*) src, width << 2, (uint8*) dest, width << 2, width, height);

    env->ReleaseByteArrayElements(destArray, dest, 0);
    env->ReleaseByteArrayElements(srcArray, src, 0);
}

JNIEXPORT void JNICALL
Java_io_github_zncmn_libyuv_Yuv_argbToNv21(JNIEnv *env, jobject,
                                           jbyteArray srcArray, jint width, jint height,
                                           jbyteArray destArray) {
    jbyte *src = env->GetByteArrayElements(srcArray, NULL);
    jbyte *dest = env->GetByteArrayElements(destArray, NULL);

    uint8* dest_uv = (uint8*) dest + width * height;
    ARGBToNV21((uint8*) src, width << 2, (uint8*) dest, width, dest_uv, width, width, height);

    env->ReleaseByteArrayElements(destArray, dest, 0);
    env->ReleaseByteArrayElements(srcArray, src, 0);
}

JNIEXPORT void JNICALL
Java_io_github_zncmn_libyuv_Yuv_nv21ToAbgr(JNIEnv *env, jobject,
                                           jbyteArray srcArray, jint width, jint height,
                                           jbyteArray destArray) {
    jbyte *src = env->GetByteArrayElements(srcArray, NULL);
    jbyte *dest = env->GetByteArrayElements(destArray, NULL);

    const uint8* src_uv = (uint8*) src + width * height;
    NV21ToABGR((uint8*) src, width, src_uv, width, (uint8*) dest, width << 2, width, height);

    env->ReleaseByteArrayElements(destArray, dest, 0);
    env->ReleaseByteArrayElements(srcArray, src, 0);
}

JNIEXPORT void JNICALL
Java_io_github_zncmn_libyuv_Yuv_i420ToNv21(JNIEnv *env, jobject,
                                           jbyteArray srcArray, jint width, jint height,
                                           jbyteArray destArray) {
    jbyte *src = env->GetByteArrayElements(srcArray, NULL);
    jbyte *dest = env->GetByteArrayElements(destArray, NULL);

    const int size = width * height;
    const uint8* src_u = (uint8*) src + size;
    const uint8* src_v = (uint8*) src + (size << 1);
    uint8* dest_uv = (uint8*) dest + size;
    I420ToNV21((uint8*) src, width, src_u, width, src_v, width, (uint8*) dest, width, dest_uv, width, width, height);

    env->ReleaseByteArrayElements(destArray, dest, 0);
    env->ReleaseByteArrayElements(srcArray, src, 0);
}

JNIEXPORT void JNICALL
Java_io_github_zncmn_libyuv_Yuv_nv21ToI420Rotate(JNIEnv *env, jobject,
                                                 jbyteArray srcArray, jint srcStride,
                                                 jbyteArray destArray, jint destStride,
                                                 jint width, jint height, jint degrees) {
    jbyte *src = env->GetByteArrayElements(srcArray, NULL);
    jbyte *dest = env->GetByteArrayElements(destArray, NULL);

    const int size = width * height;
    const uint8* src_uv = (uint8*) src + size;
    uint8* dest_u = (uint8*) dest + (size << 1);
    uint8* dest_v = (uint8*) dest + size;
    NV12ToI420Rotate((uint8*) src, srcStride, src_uv, srcStride, (uint8*) dest, destStride, dest_u, destStride, dest_v, destStride, width, height, (RotationMode) degrees);

    env->ReleaseByteArrayElements(destArray, dest, 0);
    env->ReleaseByteArrayElements(srcArray, src, 0);
}

} // extern "C"
