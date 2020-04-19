#include <libyuv.h>
#include "convert.h"

using namespace libyuv;
using namespace libyuv::jniutil;
extern "C" {

// Convert I444 to I420
PLANES_3_TO_3(I444ToI420, y, u, v, y, u, v);

// Convert I444 to NV12
PLANES_3_TO_2(I444ToNV12, y, u, v, y, uv);

// Convert I444 to NV21
PLANES_3_TO_2(I444ToNV21, y, u, v, y, vu);

// Convert I422 to I420
PLANES_3_TO_3(I422ToI420, y, u, v, y, u, v);

// Convert I422 to NV21
PLANES_3_TO_2(I422ToNV21, y, u, v, y, vu);

// Copy I420 to I420
PLANES_3_TO_3(I420Copy, y, u, v, y, u, v);

// Convert I400 to I420
PLANES_1_TO_3(I400ToI420, y, y, u, v);

// Convert I400 to NV21
PLANES_1_TO_2(I400ToNV21, y, y, vu);

// Convert NV12 to I420
PLANES_2_TO_3(NV12ToI420, y, uv, y, u, v);

// Convert NV21 to I420
PLANES_2_TO_3(NV21ToI420, y, vu, y, u, v);

// ARGB little endian (bgra in memory) to I420
PLANES_1_TO_3(ARGBToI420, argb, y, u, v);

// BGRA little endian (argb in memory) to I420
PLANES_1_TO_3(BGRAToI420, bgra, y, u, v);

// ABGR little endian (rgba in memory) to I420
PLANES_1_TO_3(ABGRToI420, abgr, y, u, v);

// RGBA little endian (abgr in memory) to I420
PLANES_1_TO_3(RGBAToI420, rgba, y, u, v);

// RGB little endian (bgr in memory) to I420
PLANES_1_TO_3(RGB24ToI420, rgb24, y, u, v);

// RGB little endian (bgr in memory) to J420
PLANES_1_TO_3(RGB24ToJ420, rgb24, y, u, v);

// RGB big endian (rgb in memory) to I420
PLANES_1_TO_3(RAWToI420, raw, y, u, v);

// RGB16 (RGBP fourcc) little endian to I420
PLANES_1_TO_3(RGB565ToI420, rgb565, y, u, v);

// RGB15 (RGBO fourcc) little endian to I420
PLANES_1_TO_3(ARGB1555ToI420, argb1555, y, u, v);

// RGB12 (R444 fourcc) little endian to I420
PLANES_1_TO_3(ARGB4444ToI420, argb4444, y, u, v);

// RGB little endian (bgr in memory) to J400
PLANES_1_TO_1(RGB24ToJ400, rgb24, yj);

// RGB big endian (rgb in memory) to J400
PLANES_1_TO_1(RAWToJ400, raw, yj);

}
