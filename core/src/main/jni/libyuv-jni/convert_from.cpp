#include <libyuv.h>
#include "convert.h"

using namespace libyuv;
using namespace libyuv::jniutil;
extern "C" {

PLANES_3_TO_3(I420ToI422, y, u, v, y, u, v);

PLANES_3_TO_3(I420ToI444, y, u, v, y, u, v);

// Copy to I400. Source can be I420, I422, I444, I400, NV12 or NV21.
PLANES_1_TO_1(I400Copy, y, y);

PLANES_3_TO_2(I420ToNV12, y, u, v, y, uv);

PLANES_3_TO_2(I420ToNV21, y, u, v, y, vu);

PLANES_3_TO_1(I420ToBGRA, y, u, v, bgra);

PLANES_3_TO_1(I420ToRGBA, y, u, v, rgba);

PLANES_3_TO_1(I420ToRGB24, y, u, v, rgb24);

PLANES_3_TO_1(I420ToRAW, y, u, v, raw);

PLANES_3_TO_1(H420ToRGB24, y, u, v, rgb24);

PLANES_3_TO_1(H420ToRAW, y, u, v, raw);

PLANES_3_TO_1(J420ToRGB24, y, u, v, rgb24);

PLANES_3_TO_1(J420ToRAW, y, u, v, raw);

PLANES_3_TO_1(I420ToRGB565, y, u, v, rgb565);

PLANES_3_TO_1(J420ToRGB565, y, u, v, rgb565);

PLANES_3_TO_1(H420ToRGB565, y, u, v, rgb565);

PLANES_3_TO_1(I422ToRGB565, y, u, v, rgb565);

PLANES_3_TO_1(I420ToARGB1555, y, u, v, argb1555);

PLANES_3_TO_1(I420ToARGB4444, y, u, v, argb4444);

}
