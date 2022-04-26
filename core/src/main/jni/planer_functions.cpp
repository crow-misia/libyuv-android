#include <libyuv.h>
#include "planer_functions.h"

using namespace libyuv;
using namespace libyuv::jniutil;

extern "C" {

// Copy a plane of data.
// CopyPlane
// CopyPlane_16
// Convert16To8Plane
// Convert8To16Plane

// Set a plane of data to a 32 bit value.
// SetPlane

// Convert a plane of tiles of 16 x H to linear.
// DetilePlane

// Convert a UV plane of tiles of 16 x H into linear U and V planes.
// DetileSplitUVPlane

// Split interleaved UV plane into separate U and V planes.
// SplitUVPlane

// Merge separate U and V planes into one interleaved UV plane.
// MergeUVPlane

// Split interleaved msb UV plane into separate lsb U and V planes.
// SplitUVPlane_16

// Merge separate lsb U and V planes into one interleaved msb UV plane.
// MergeUVPlane_16

// Convert lsb plane to msb plane
// ConvertToMSBPlane_16

// Convert msb plane to lsb plane
// ConvertToLSBPlane_16

// Scale U and V to half width and height and merge into interleaved UV plane.
// HalfMergeUVPlane

// Swap U and V channels in interleaved UV plane.
// SwapUVPlane

// Split interleaved RGB plane into separate R, G and B planes.
// SplitRGBPlane

// Merge separate R, G and B planes into one interleaved RGB plane.
// MergeRGBPlane

// Split interleaved ARGB plane into separate R, G, B and A planes.
// SplitARGBPlane

// Merge separate R, G, B and A planes into one interleaved ARGB plane.
// MergeARGBPlane

// Merge separate 'depth' bit R, G and B planes stored in lsb
// into one interleaved XR30 plane.
// MergeXR30Plane

// Merge separate 'depth' bit R, G, B and A planes stored in lsb
// into one interleaved AR64 plane.
// MergeAR64Plane

// Merge separate 'depth' bit R, G, B and A planes stored in lsb
// into one interleaved ARGB plane.
// MergeARGB16To8Plane

// Copy I400.  Supports inverting. duplicate I400Copy
// PLANES_1_TO_1(I400ToI400, y, y);

// #define J400ToJ400 I400ToI400

// Copy I422 to I422.
// #define I422ToI422 I422Copy
PLANES_3_TO_3(I422Copy, y, u, v, y, u, v);

// Copy I444 to I444.
// #define I444ToI444 I444Copy
PLANES_3_TO_3(I444Copy, y, u, v, y, u, v);

// Copy I210 to I210.
// #define I210ToI210 I210Copy
// I210Copy

// Copy NV12. Supports inverting.
PLANES_2_TO_2(NV12Copy, y, vu, y, uv);

// Copy NV21. Supports inverting.
// NV21Copy

// Convert YUY2 to I422.
// YUY2ToI422

// Convert UYVY to I422.
// UYVYToI422

// YUY2ToNV12

// UYVYToNV12

// Convert NV21 to NV12.
PLANES_2_TO_2(NV21ToNV12, y, vu, y, uv);

// YUY2ToY

// Convert I420 to I400. (calls CopyPlane ignoring u/v).
PLANES_3_TO_1(I420ToI400, y, u, v, y);

// #define J420ToJ400 I420ToI400
// #define I420ToI420Mirror I420Mirror

// I420 mirror.
PLANES_3_TO_3(I420Mirror, y, u, v, y, u, v);

// #define I400ToI400Mirror I400Mirror

// I400 mirror.
PLANES_1_TO_1(I400Mirror, y, y);

// #define NV12ToNV12Mirror NV12Mirror

// NV12 mirror.
PLANES_2_TO_2(NV12Mirror, y, vu, y, uv);

// #define ARGBToARGBMirror ARGBMirror

// ARGB mirror.
PLANES_1_TO_1(ARGBMirror, argb, argb);

// #define RGB24ToRGB24Mirror RGB24Mirror

// RGB24 mirror.
PLANES_1_TO_1(RGB24Mirror, rgb24, rgb24);

// Mirror a plane of data.
// MirrorPlane

// Mirror a plane of UV data.
// MirrorUVPlane

// #define RGB24ToRAW RAWToRGB24

PLANES_1_TO_1(RAWToRGB24, raw, rgb24);

// Draw a rectangle into I420.
// I420Rect

// Draw a rectangle into ARGB.
// ARGBRect

// Convert ARGB to gray scale ARGB.
// ARGBGrayTo

// Make a rectangle of ARGB gray scale.
// ARGBGray

// Make a rectangle of ARGB Sepia tone.
// ARGBSepia

// Apply a matrix rotation to each ARGB pixel.
// ARGBColorMatrix

// Apply a color table each ARGB pixel.
// ARGBColorTable

// Apply a color table each ARGB pixel but preserve destination alpha.
// RGBColorTable

// Apply a luma/color table each ARGB pixel but preserve destination alpha.
// ARGBLumaColorTable

// Apply a 3 term polynomial to ARGB values.
// ARGBPolynomial

// Convert plane of 16 bit shorts to half floats.
// HalfFloatPlane

// Convert a buffer of bytes to floats, scale the values and store as floats.
// ByteToFloat

// Quantize a rectangle of ARGB. Alpha unaffected.
// ARGBQuantize

// Copy ARGB to ARGB. duplicate
// ARGBCopy

// Copy Alpha channel of ARGB to alpha of ARGB.
PLANES_1_TO_1(ARGBCopyAlpha, argb, argb);

// Extract the alpha channel from ARGB.
PLANES_1_TO_1(ARGBExtractAlpha, argb, a);

// Copy Y channel to Alpha of ARGB.
PLANES_1_TO_1(ARGBCopyYToAlpha, y, argb);

// Get function to Alpha Blend ARGB pixels and store to destination.
// GetARGBBlend

// Alpha Blend ARGB images and store to destination.
// ARGBBlend

// Alpha Blend plane and store to destination.
// BlendPlane

// Alpha Blend YUV images and store to destination.
// I420Blend

// Multiply ARGB image by ARGB image. Shifted down by 8. Saturates to 255.
// ARGBMultiply

// Add ARGB image with ARGB image. Saturates to 255.
// ARGBAdd

// Subtract ARGB image (argb1) from ARGB image (argb0). Saturates to 0.
// ARGBSubtract

// Convert I422 to YUY2.
// I422ToYUY2

// Convert I422 to UYVY.
// I422ToUYVY

// Convert unattentuated ARGB to preattenuated ARGB.
PLANES_1_TO_1(ARGBAttenuate, argb, argb);

// Convert preattentuated ARGB to unattenuated ARGB.
PLANES_1_TO_1(ARGBUnattenuate, argb, argb);

// Blur ARGB image.
// ARGBBlur

// Gaussian 5x5 blur a float plane.
// GaussPlane_F32

// Multiply ARGB image by ARGB value.
// ARGBShade

// Interpolate between two images using specified amount of interpolation
// (0 to 255) and store to destination.
// InterpolatePlane

// Interpolate between two ARGB images using specified amount of interpolation
// Internally calls InterpolatePlane with width * 4 (bpp).
// ARGBInterpolate

// Interpolate between two YUV images using specified amount of interpolation
// Internally calls InterpolatePlane on each plane where the U and V planes
// are half width and half height.
// I420Interpolate

// Shuffle ARGB channel order.  e.g. BGRA to ARGB.
// ARGBShuffle

// Shuffle AR64 channel order.  e.g. AR64 to AB64.
// AR64Shuffle

// Sobel ARGB effect with planar output.
// ARGBSobelToPlane

// Sobel ARGB effect.
// ARGBSobel

// Sobel ARGB effect w/ Sobel X, Sobel, Sobel Y in ARGB.
// ARGBSobelXY
}
