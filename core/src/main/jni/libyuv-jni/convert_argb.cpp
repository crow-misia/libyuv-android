#include <libyuv.h>
#include "convert.h"

using namespace libyuv;
using namespace libyuv::jniutil;
extern "C" {

// Copy ARGB to ARGB
PLANES_1_TO_1(ARGBCopy, argb, argb);

// Convert I420 to ARGB
PLANES_3_TO_1(I420ToARGB, y, u, v, argb);

// Convert I420 to ABGR
PLANES_3_TO_1(I420ToABGR, y, u, v, abgr);

// Convert I422 to ARGB
PLANES_3_TO_1(I422ToARGB, y, u, v, argb);

// Convert I422 to ABGR
PLANES_3_TO_1(I422ToABGR, y, u, v, abgr);

// Convert I444 to ARGB
PLANES_3_TO_1(I444ToARGB, y, u, v, argb);

// Convert I444 to ABGR
PLANES_3_TO_1(I444ToABGR, y, u, v, abgr);

// Convert I400 (grey) to ARGB.  Reverse of ARGBToI400
PLANES_1_TO_1(I400ToARGB, y, argb);

// Convert J400 (jpeg grey) to ARGB
PLANES_1_TO_1(J400ToARGB, y, argb);

// Convert NV12 to ARGB
PLANES_2_TO_1(NV12ToARGB, y, uv, argb);

// Convert NV21 to ARGB
PLANES_2_TO_1(NV21ToARGB, y, vu, argb);

// Convert NV12 to ABGR
PLANES_2_TO_1(NV12ToABGR, y, uv, abgr);

// Convert NV21 to ABGR
PLANES_2_TO_1(NV21ToABGR, y, vu, abgr);

// Convert NV12 to RGB24
PLANES_2_TO_1(NV12ToRGB24, y, uv, rgb24);

// Convert NV21 to RGB24
PLANES_2_TO_1(NV21ToRGB24, y, vu, rgb24);

// Convert NV12 to RAW
PLANES_2_TO_1(NV12ToRAW, y, uv, raw);

// Convert NV21 to RAW
PLANES_2_TO_1(NV21ToRAW, y, vu, raw);

// BGRA little endian (argb in memory) to ARGB
PLANES_1_TO_1(BGRAToARGB, bgra, argb);

// ABGR little endian (rgba in memory) to ARGB
PLANES_1_TO_1(ABGRToARGB, abgr, argb);

// RGBA little endian (abgr in memory) to ARGB
PLANES_1_TO_1(RGBAToARGB, rgba, argb);

// RGB little endian (bgr in memory) to ARGB
PLANES_1_TO_1(RGB24ToARGB, rgb24, argb);

// RGB big endian (rgb in memory) to ARGB
PLANES_1_TO_1(RAWToARGB, raw, argb);

// RGB big endian (rgb in memory) to RGBA
PLANES_1_TO_1(RAWToRGBA, raw, rgba);

// RGB16 (RGBP fourcc) little endian to ARGB
PLANES_1_TO_1(RGB565ToARGB, rgb565, argb);

// RGB15 (RGBO fourcc) little endian to ARGB
PLANES_1_TO_1(ARGB1555ToARGB, argb1555, argb);

// RGB12 (R444 fourcc) little endian to ARGB
PLANES_1_TO_1(ARGB4444ToARGB, argb4444, argb);

}
