#include <libyuv.h>
#include "rotate.h"

using namespace libyuv;
using namespace libyuv::jniutil;

extern "C" {

// Rotate ARGB frame
PLANES_1_TO_1_R(ARGBRotate, argb, argb);

}
