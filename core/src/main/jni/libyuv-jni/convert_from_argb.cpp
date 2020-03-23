#include <libyuv.h>
#include "convert.h"

using namespace libyuv;
using namespace libyuv::jniutil;
extern "C" {

// Convert ARGB To BGRA
PLANES_1_TO_1(ARGBToBGRA, argb, bgra);

// Convert ARGB To ABGR
PLANES_1_TO_1(ARGBToABGR, argb, abgr);

// Convert ARGB To RGBA
PLANES_1_TO_1(ARGBToRGBA, argb, rgba);

// Convert ARGB To RGB24
PLANES_1_TO_1(ARGBToRGB24, argb, rgb24);

// Convert ARGB To RAW
PLANES_1_TO_1(ARGBToRAW, argb, raw);

// Convert ARGB To RGB565
PLANES_1_TO_1(ARGBToRGB565, argb, rgb565);

// Convert ARGB To ARGB1555
PLANES_1_TO_1(ARGBToARGB1555, argb, argb1555);

// Convert ARGB To ARGB4444
PLANES_1_TO_1(ARGBToARGB4444, argb, argb4444);

// Convert ARGB To I444
PLANES_1_TO_3(ARGBToI444, argb, y, u, v);

// Convert ARGB To I422
PLANES_1_TO_3(ARGBToI422, argb, y, u, v);

// Convert ARGB to J420. (JPeg full range I420)
PLANES_1_TO_3(ARGBToJ420, argb, y, u, v);

// Convert ARGB to J422
PLANES_1_TO_3(ARGBToJ422, argb, y, u, v);

// Convert ARGB to J400. (JPeg full range)
PLANES_1_TO_1(ARGBToJ400, argb, yj);

// Convert RGBA to J400. (JPeg full range)
PLANES_1_TO_1(RGBAToJ400, rgba, yj);

// Convert ARGB to I400
PLANES_1_TO_1(ARGBToI400, argb, y);

// Convert ARGB To NV12
PLANES_1_TO_2(ARGBToNV12, argb, y, uv);

// Convert ARGB To NV21
PLANES_1_TO_2(ARGBToNV21, argb, y, vu);

// Convert ABGR To NV12
PLANES_1_TO_2(ABGRToNV12, abgr, y, uv);

// Convert ABGR To NV21
PLANES_1_TO_2(ABGRToNV21, abgr, y, vu);

}
