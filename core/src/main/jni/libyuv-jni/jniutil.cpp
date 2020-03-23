#include <jni.h>
#include <cstddef>
#include "jniutil.h"

namespace libyuv {
namespace jniutil {

JavaVM *gJavaVM;

jclass byteArrayClass;

void init(JavaVM* vm, JNIEnv* env) {
    gJavaVM = vm;

    byteArrayClass = findClass(env, "[B");
}

}
}

