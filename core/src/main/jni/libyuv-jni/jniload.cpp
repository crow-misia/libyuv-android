#include "const.h"
#include "jniutil.h"

extern "C" {

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *) {
    JNIEnv *env;
    if (vm->GetEnv(reinterpret_cast<void **>(&env), LIBYUV_JNI_VERSION) != JNI_OK) {
        return JNI_ERR;
    }
    libyuv::jniutil::init(vm, env);

    return LIBYUV_JNI_VERSION;
}

}
