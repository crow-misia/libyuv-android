#include <libyuv.h>
#include "scale.h"

using namespace libyuv;
using namespace libyuv::jniutil;

extern "C" {

PLANES_1_TO_1(ARGBScale, argb, argb)

PLANES_1_TO_1_CLIP(ARGBScaleClip, argb, argb)

}
