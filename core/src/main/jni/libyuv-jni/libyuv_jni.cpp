#include <jni.h>
#include <cstddef>
#include "libyuv.h"

using namespace libyuv;

extern "C" {

JNIEXPORT void JNICALL
Java_io_github_zncmn_libyuv_YuvConvert_abgrToArgb(JNIEnv *env, jobject,
                                                       jbyteArray rgbArray, jint width,
                                                       jint height, jbyteArray bgrArray) {
    jbyte *rgb = env->GetByteArrayElements(rgbArray, NULL);
    jbyte *bgr = env->GetByteArrayElements(bgrArray, NULL);

    ABGRToARGB((uint8*) rgb, width << 2, (uint8*) bgr, width << 2, width, height);

    env->ReleaseByteArrayElements(bgrArray, bgr, 0);
    env->ReleaseByteArrayElements(rgbArray, rgb, 0);
}

JNIEXPORT void JNICALL
Java_io_github_zncmn_libyuv_YuvConvert_argbToNv21(JNIEnv *env, jobject,
                                                       jbyteArray bgrArray, jint width,
                                                       jint height, jbyteArray yuvArray) {
    jbyte *bgr = env->GetByteArrayElements(bgrArray, NULL);
    jbyte *yuv = env->GetByteArrayElements(yuvArray, NULL);

    ARGBToNV21((uint8*) bgr, width << 2, (uint8*) yuv, width, (uint8*) &yuv[width * height], width, width, height);

    env->ReleaseByteArrayElements(yuvArray, yuv, 0);
    env->ReleaseByteArrayElements(bgrArray, bgr, 0);
}

} // extern "C"
