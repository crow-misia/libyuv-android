#include <libyuv.h>
#include "scale.h"

using namespace libyuv;
using namespace libyuv::jniutil;

extern "C" {

PLANES_1_TO_1(ARGBScale, argb, argb)

// Clipped scale takes destination rectangle coordinates for clip values.
PLANES_1_TO_1_CLIP(ARGBScaleClip, argb, argb)

// Scale with YUV conversion to ARGB and clipping.
// YUVToARGBScaleClip
}
