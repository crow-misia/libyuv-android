#ifndef LIBYUV_JNI_CONST_H_
#define LIBYUV_JNI_CONST_H_

#include <jni.h>

#define LIBYUV_JNI_VERSION JNI_VERSION_1_6

#define JNI_METHOD_NAME(name) \
  Java_io_github_crow_1misia_libyuv_Yuv_##name

#define JNI_DEFINE_METHOD(type, name, args...) \
  JNIEXPORT type JNICALL JNI_METHOD_NAME(name)(JNIEnv *env, jobject, ##args)

#endif // LIBYUV_JNI_CONST_H_
