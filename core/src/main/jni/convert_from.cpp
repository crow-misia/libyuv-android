#include <libyuv.h>
#include "convert.h"

using namespace libyuv;
using namespace libyuv::jniutil;
extern "C" {

// Convert 8 bit YUV to 10 bit.

PLANES_3_TO_3(I420ToI422, y, u, v, y, u, v);

PLANES_3_TO_3(I420ToI444, y, u, v, y, u, v);

// Copy to I400. Source can be I420, I422, I444, I400, NV12 or NV21.
PLANES_1_TO_1(I400Copy, y, y);

PLANES_3_TO_2(I420ToNV12, y, u, v, y, uv);

PLANES_3_TO_2(I420ToNV21, y, u, v, y, vu);

// Convert I420 to specified format.

}
