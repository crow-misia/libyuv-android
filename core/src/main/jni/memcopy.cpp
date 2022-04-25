#include <string.h>
#include "const.h"
#include "jniutil.h"
#include "nativehelper/scoped_bytes.h"

extern "C" {

JNI_DEFINE_METHOD(void, memcopy,
                  jobject j_dst, jint offset,
                  jobject j_src, jint length) {
    ScopedBytesRW dst(env, j_dst);
    if (dst.get() == nullptr) {
        return;
    }
    ScopedBytesRO src(env, j_src);
    if (src.get() == nullptr) {
        return;
    }
    memmove(dst.get() + offset, src.get(), static_cast<size_t>(length));
}

}
