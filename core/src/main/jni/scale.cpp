#include <libyuv.h>
#include "scale.h"

using namespace libyuv;
using namespace libyuv::jniutil;

extern "C" {

PLANES_1_TO_1_V(ScalePlane, p, p)

PLANES_3_TO_3(I420Scale, y, u, v, y, u, v)

PLANES_3_TO_3(I444Scale, y, u, v, y, u, v)

PLANES_2_TO_2(NV12Scale, y, uv, y, uv)

}
