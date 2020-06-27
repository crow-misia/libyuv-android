#include <malloc.h>
#include "macros.h"

extern "C" {

JNI_DEFINE_METHOD(jobject, allocNativeBuffer, jint size) {
    void* buffer = malloc((size_t) size);
    return env->NewDirectByteBuffer(buffer, size);
}

JNI_DEFINE_METHOD(void, freeNativeBuffer, jobject directRef) {
    void *buffer = env->GetDirectBufferAddress(directRef);
    if (buffer != nullptr) {
        free(buffer);
    }
}

}
