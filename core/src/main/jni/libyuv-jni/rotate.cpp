#include <libyuv.h>
#include "rotate.h"

using namespace libyuv;
using namespace libyuv::jniutil;

extern "C" {

// Rotate I420 frame
PLANES_3_TO_3_R(I420Rotate, y, u, v, y, u, v);

// Rotate I444 frame
PLANES_3_TO_3_R(I444Rotate, y, u, v, y, u, v);

// Rotate NV12 input and store in I420
PLANES_2_TO_3_R(NV12ToI420Rotate, y, uv, y, u ,v);

// Rotate a plane by 0, 90, 180, or 270
PLANES_1_TO_1_R(RotatePlane, p, p);

PLANES_1_TO_2_V(RotateUV90, p, a, b);

// Rotations for when U and V are interleaved. Deprecated
PLANES_1_TO_2_V(RotateUV180, p, a, b);

PLANES_1_TO_2_V(RotateUV270, p, a, b);

// The 90 and 270 functions are based on transposes. Deprecated
PLANES_1_TO_1_V(TransposePlane, p, p);

PLANES_1_TO_2_V(TransposeUV, p, a, b);

}
