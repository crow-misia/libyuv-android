#include <libyuv.h>
#include "planer_functions.h"

using namespace libyuv;
using namespace libyuv::jniutil;

extern "C" {

// Convert NV21 to NV12
PLANES_2_TO_2(NV21ToNV12, y, vu, y, uv);

// Mirror I400
PLANES_1_TO_1(I400Mirror, y, y);

// Mirror I420
PLANES_3_TO_3(I420Mirror, y, u, v, y, u, v);

// Mirror NV12
PLANES_2_TO_2(NV12Mirror, y, vu, y, uv);

// Mirror ARGB
PLANES_1_TO_1(ARGBMirror, argb, argb);

// Mirror RGB24
PLANES_1_TO_1(RGB24Mirror, rgb24, rgb24);

}
