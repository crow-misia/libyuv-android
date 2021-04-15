#include <libyuv.h>
#include "scale.h"

using namespace libyuv;
using namespace libyuv::jniutil;

extern "C" {

// Scale a YUV plane.
PLANES_1_TO_1_V(ScalePlane, p, p)

// ScalePlane_16

// Sample is expected to be in the low 12 bits.
// ScalePlane_12

// Scales a YUV 4:2:0 image from the src width and height to the
// dst width and height.
PLANES_3_TO_3(I420Scale, y, u, v, y, u, v)

// I420Scale_16

// I420Scale_12

// Scales a YUV 4:4:4 image from the src width and height to the
// dst width and height.
PLANES_3_TO_3(I444Scale, y, u, v, y, u, v)

// I444Scale_16

// I444Scale_12

// Scales an NV12 image from the src width and height to the
// dst width and height.
PLANES_2_TO_2(NV12Scale, y, uv, y, uv)

}
