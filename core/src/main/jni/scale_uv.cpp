#include <libyuv.h>
#include "scale.h"

using namespace libyuv;
using namespace libyuv::jniutil;

extern "C" {

PLANES_1_TO_1(UVScale, uv, uv)

// Scale a 16 bit UV image.
// UVScale_16

}
