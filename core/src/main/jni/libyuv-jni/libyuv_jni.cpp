#include <jni.h>
#include <cstddef>
#include "libyuv.h"

using namespace libyuv;

extern "C" {

JNIEXPORT void JNICALL
Java_io_github_zncmn_libyuv_Yuv_abgrToNv21(JNIEnv *env, jobject,
                                           jbyteArray srcArray, jbyteArray destArray,
                                           jint width, jint height) {
    jbyte *src = env->GetByteArrayElements(srcArray, NULL);
    jbyte *dest = env->GetByteArrayElements(destArray, NULL);

    const int size = width * height;
    uint8* dest_uv = (uint8*) dest + size;

    // create temporary buffer.
    align_buffer_64(buf, size << 2);

    ABGRToARGB((uint8*) src, width << 2, buf, width << 2, width, height);
    ARGBToNV21(buf, width << 2, (uint8*) dest, width, dest_uv, width, width, height);

    free_aligned_buffer_64(buf);

    env->ReleaseByteArrayElements(destArray, dest, 0);
    env->ReleaseByteArrayElements(srcArray, src, 0);
}

JNIEXPORT void JNICALL
Java_io_github_zncmn_libyuv_Yuv_nv21ToAbgr(JNIEnv *env, jobject,
                                           jbyteArray srcArray, jbyteArray destArray,
                                           jint width, jint height) {
    jbyte *src = env->GetByteArrayElements(srcArray, NULL);
    jbyte *dest = env->GetByteArrayElements(destArray, NULL);

    const uint8* src_uv = (uint8*) src + width * height;
    NV21ToABGR((uint8*) src, width, src_uv, width, (uint8*) dest, width << 2, width, height);

    env->ReleaseByteArrayElements(destArray, dest, 0);
    env->ReleaseByteArrayElements(srcArray, src, 0);
}

JNIEXPORT void JNICALL
Java_io_github_zncmn_libyuv_Yuv_nv21Rotate(JNIEnv *env, jobject,
                                           jbyteArray srcArray, jbyteArray destArray,
                                           jint width, jint height, jint degrees) {
    jbyte *src = env->GetByteArrayElements(srcArray, NULL);
    jbyte *dest = env->GetByteArrayElements(destArray, NULL);

    const int half_width = (width + 1) >> 1;
    const int half_height = (height + 1) >> 1;

    const int size = width * height;
    const int uvSize = half_width * half_height;

    // create temporary buffer.
    align_buffer_64(dest_i420_uv, uvSize << 1);

    const uint8* src_uv = (uint8*) src + size;
    uint8* dest_uv = (uint8*) dest + size;
    uint8* dest_i420_u = dest_i420_uv + uvSize;
    uint8* dest_i420_v = dest_i420_uv;

    const int src_stride = (width + 1) & ~1;
    int dest_stride, dest_i420_stride;

    switch (degrees) {
        case 90:
            dest_stride = (height + 1) & ~1;
            dest_i420_stride = (height + 1) >> 1;

            RotateUV90(src_uv, src_stride, dest_i420_u, dest_i420_stride, dest_i420_v, dest_i420_stride, half_width, half_height);
            MergeUVPlane(dest_i420_u, dest_i420_stride, dest_i420_v, dest_i420_stride, dest_uv, dest_stride, half_height, half_width);
            break;
        case 180:
            dest_stride = (width + 1) & ~1;
            dest_i420_stride = (width + 1) >> 1;

            RotateUV180(src_uv, src_stride, dest_i420_u, dest_i420_stride, dest_i420_v, dest_i420_stride, half_width, half_height);
            MergeUVPlane(dest_i420_u, dest_i420_stride, dest_i420_v, dest_i420_stride, dest_uv, dest_stride, half_width, half_height);
            break;
        case 270:
            dest_stride = (height + 1) & ~1;
            dest_i420_stride = (height + 1) >> 1;

            RotateUV270(src_uv, src_stride, dest_i420_u, dest_i420_stride, dest_i420_v, dest_i420_stride, half_width, half_height);
            MergeUVPlane(dest_i420_u, dest_i420_stride, dest_i420_v, dest_i420_stride, dest_uv, dest_stride, half_height, half_width);
            break;
        default:
            dest_stride = (width + 1) & ~1;
            break;
    }

    RotatePlane((uint8*) src, src_stride, (uint8*) dest, dest_stride, width, height, (RotationMode) degrees);

    free_aligned_buffer_64(dest_i420_uv);

    env->ReleaseByteArrayElements(destArray, dest, 0);
    env->ReleaseByteArrayElements(srcArray, src, 0);
}

} // extern "C"
