#ifndef LIBYUV_JNI_MACROS_H_
#define LIBYUV_JNI_MACROS_H_

#include <jni.h>
#include <cstddef>
#include "const.h"

#define DISALLOW_COPY_AND_ASSIGN(ClassName) \
  ClassName(const ClassName&); \
  void operator=(const ClassName&);

#define DECLARE_BUFFER_SRC(jbuf, buf) \
  ScopedBytesRO scoped_##buf(env, jbuf); \
  const uint8_t *buf = reinterpret_cast<const uint8_t *>(scoped_##buf.get()); \
  if (buf == nullptr) { \
    throwIllegalArgumentException(env, "ByteBuffer " #buf " is not available"); \
    return; \
  }

#define DECLARE_BUFFER_DST(jbuf, buf) \
  ScopedBytesRW scoped_##buf(env, jbuf); \
  uint8_t *buf = reinterpret_cast<uint8_t *>(scoped_##buf.get()); \
  if (buf == nullptr) { \
    throwIllegalArgumentException(env, "ByteBuffer " #buf " is not available"); \
    return; \
  }

#define DECLARE_STRIDE(jStride, stride) \
  const int stride = jStride; \
  if (stride < 0) { \
    throwIllegalArgumentException(env, "Stride " #stride " must be positive"); \
    return; \
  }

#define SRC_PLANE(name) \
  DECLARE_BUFFER_SRC(j_src_##name, src_##name); \
  DECLARE_STRIDE(j_src_stride_##name, src_stride_##name);

#define DST_PLANE(name) \
  DECLARE_BUFFER_DST(j_dst_##name, dst_##name); \
  DECLARE_STRIDE(j_dst_stride_##name, dst_stride_##name);

#define CALL(NAME, ...) \
  int result = NAME(__VA_ARGS__); \
  if (result != 0) { \
    throwIllegalStateException(env, #NAME " failed"); \
    return; \
  }

#endif // LIBYUV_JNI_MACROS_H_
