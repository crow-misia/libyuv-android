#include <libyuv.h>
#include "planer_functions.h"

using namespace libyuv;
using namespace libyuv::jniutil;

extern "C" {

// Convert NV21 to NV12
PLANES_2_TO_2(NV21ToNV12, y, vu, y, uv);

}
