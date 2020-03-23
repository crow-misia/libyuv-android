#ifndef LIBYUV_JNI_JNIUTIL_H_
#define LIBYUV_JNI_JNIUTIL_H_

#include <jni.h>
#include "nativehelper/scoped_local_ref.h"

namespace libyuv {
namespace jniutil {

extern JavaVM *gJavaVM;

extern jclass byteArrayClass;

void init(JavaVM *vm, JNIEnv *env);

inline jclass findClass(JNIEnv* env, const char* name) {
    ScopedLocalRef<jclass> localClass(env, env->FindClass(name));
    return reinterpret_cast<jclass>(env->NewGlobalRef(localClass.get()));
}

inline int throwException(JNIEnv *env, const char* className, const char *message) {
    ScopedLocalRef<jclass> clazz(env, env->FindClass(className));
    if (clazz.get() == nullptr) {
        // Class not found
        return -1;
    }
    if (env->ThrowNew(clazz.get(), message) != JNI_OK) {
        // an exception, most likely OOM
        return -1;
    }
    return 0;
}

inline int throwNullPointerException(JNIEnv *env, const char *message) {
    return throwException(env, "java/lang/NullPointerException", message);
}

inline int throwIllegalArgumentException(JNIEnv *env, const char *message) {
    return throwException(env, "java/lang/IllegalArgumentException", message);
}

inline int throwIllegalStateException(JNIEnv *env, const char *message) {
    return throwException(env, "java/lang/IllegalStateException", message);
}

}
}

#endif // LIBYUV_JNI_JNIUTIL_H_
