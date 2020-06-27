#include <libyuv.h>
#include "planer_functions.h"

using namespace libyuv;
using namespace libyuv::jniutil;

extern "C" {

// Copy a plane of data.

// Set a plane of data to a 32 bit value.

// Split interleaved UV plane into separate U and V planes.

// Merge separate U and V planes into one interleaved UV plane.

// Scale U and V to half width and height and merge into interleaved UV plane.

// Swap U and V channels in interleaved UV plane.

// Split interleaved RGB plane into separate R, G and B planes.

// Merge separate R, G and B planes into one interleaved RGB plane.

// Copy I400.  Supports inverting.
PLANES_1_TO_1(I400ToI400, y, y);

// Copy I422 to I422.
PLANES_3_TO_3(I422ToI422, y, u, v, y, u, v);

// Copy I444 to I444.
PLANES_3_TO_3(I444ToI444, y, u, v, y, u, v);

// Convert YUY2 to I422.

// Convert UYVY to I422.

// Convert NV21 to NV12.
PLANES_2_TO_2(NV21ToNV12, y, vu, y, uv);

// Convert I420 to I400. (calls CopyPlane ignoring u/v).
PLANES_3_TO_1(I420ToI400, y, u, v, y);

// I420 mirror.
PLANES_3_TO_3(I420Mirror, y, u, v, y, u, v);

// I400 mirror.
PLANES_1_TO_1(I400Mirror, y, y);

// NV12 mirror.
PLANES_2_TO_2(NV12Mirror, y, vu, y, uv);

// ARGB mirror.
PLANES_1_TO_1(ARGBMirror, argb, argb);

// RGB24 mirror.
PLANES_1_TO_1(RGB24Mirror, rgb24, rgb24);

// Mirror a plane of data.

// Mirror a plane of UV data.

PLANES_1_TO_1(RAWToRGB24, raw, rgb24);

// Draw a rectangle into I420.

// Draw a rectangle into ARGB.

// Convert ARGB to gray scale ARGB.

// Make a rectangle of ARGB gray scale.

// Make a rectangle of ARGB Sepia tone.

// Apply a matrix rotation to each ARGB pixel.

// Apply a color table each ARGB pixel.

// Apply a color table each ARGB pixel but preserve destination alpha.

// Apply a luma/color table each ARGB pixel but preserve destination alpha.

// Apply a 3 term polynomial to ARGB values.

// Convert plane of 16 bit shorts to half floats.

// Convert a buffer of bytes to floats, scale the values and store as floats.

// Quantize a rectangle of ARGB. Alpha unaffected.

// Copy ARGB to ARGB.
PLANES_1_TO_1(ARGBCopy, argb, argb);

// Copy Alpha channel of ARGB to alpha of ARGB.
PLANES_1_TO_1(ARGBCopyAlpha, argb, argb);

// Extract the alpha channel from ARGB.

// Copy Y channel to Alpha of ARGB.
PLANES_1_TO_1(ARGBCopyYToAlpha, argb, argb);

// Get function to Alpha Blend ARGB pixels and store to destination.

// Alpha Blend ARGB images and store to destination.

// Alpha Blend plane and store to destination.

// Alpha Blend YUV images and store to destination.

// Multiply ARGB image by ARGB image. Shifted down by 8. Saturates to 255.

// Add ARGB image with ARGB image. Saturates to 255.

// Subtract ARGB image (argb1) from ARGB image (argb0). Saturates to 0.

// Convert I422 to YUY2.

// Convert I422 to UYVY.

// Convert unattentuated ARGB to preattenuated ARGB.
PLANES_1_TO_1(ARGBAttenuate, argb, argb);

// Convert preattentuated ARGB to unattenuated ARGB.
PLANES_1_TO_1(ARGBUnattenuate, argb, argb);

}
