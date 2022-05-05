#include <libyuv.h>
#include "convert.h"

using namespace libyuv;
using namespace libyuv::jniutil;
extern "C" {

// Convert I444 to I420.
PLANES_3_TO_3(I444ToI420, y, u, v, y, u, v);

// Convert I444 to NV12.
PLANES_3_TO_2(I444ToNV12, y, u, v, y, uv);

// Convert I444 to NV21.
PLANES_3_TO_2(I444ToNV21, y, u, v, y, vu);

// Convert I422 to I420.
PLANES_3_TO_3(I422ToI420, y, u, v, y, u, v);

// Convert I422 to I444.
PLANES_3_TO_3(I422ToI444, y, u, v, y, u, v);

// Convert I422 to I210.

// Convert MM21 to NV12.

// Convert MM21 to I420.

// Convert I422 to NV21.
PLANES_3_TO_2(I422ToNV21, y, u, v, y, vu);

// Copy I420 to I420.
// #define I420ToI420 I420Copy
PLANES_3_TO_3(I420Copy, y, u, v, y, u, v);

// Convert I420 to I444.
// redefine convert_from
// PLANES_3_TO_3(I420ToI444, y, u, v, y, u, v);

// Copy I010 to I010.
// #define I010ToI010 I010Copy
// #define H010ToH010 I010Copy
// I010Copy

// Convert 10 bit YUV to 8 bit.
// #define H010ToH420 I010ToI420
// I010ToI420

// #define H210ToH422 I210ToI422
// I210ToI422

// #define H410ToH444 I410ToI444
// I410ToI444

// #define H012ToH420 I012ToI420
// I012ToI420

// #define H212ToH422 I212ToI422
// I212ToI422

// #define H412ToH444 I412ToI444
// I412ToI444

// #define I412ToI012 I410ToI010
// #define H410ToH010 I410ToI010
// #define H412ToH012 I410ToI010
// I410ToI010

// #define I212ToI012 I210ToI010
// #define H210ToH010 I210ToI010
// #define H212ToH012 I210ToI010
// I210ToI010

// Convert I010 to I410
// I010ToI410

// Convert I012 to I412
// #define I012ToI412 I010ToI410

// Convert I210 to I410
// I210ToI410

// Convert I212 to I412
// #define I212ToI412 I210ToI410

// Convert I010 to P010
// I010ToP010

// Convert I210 to P210
// I210ToP210

// Convert I012 to P012
// I012ToP012

// Convert I212 to P212
// I212ToP212

// Convert I400 (grey) to I420.
PLANES_1_TO_3(I400ToI420, y, y, u, v);

// Convert I400 (grey) to NV21.
PLANES_1_TO_2(I400ToNV21, y, y, vu);

// #define J400ToJ420 I400ToI420

// Convert NV12 to I420.
PLANES_2_TO_3(NV12ToI420, y, uv, y, u, v);

// Convert NV21 to I420.
PLANES_2_TO_3(NV21ToI420, y, vu, y, u, v);

// Convert NV12 to NV24.
// NV12ToNV24

// Convert NV16 to NV24.
// NV16ToNV24

// Convert P010 to P410.
// P010ToP410

// Convert P012 to P412.
// #define P012ToP412 P010ToP410

// Convert P016 to P416.
// #define P016ToP416 P010ToP410

// Convert P210 to P410.
// P210ToP410

// Convert P212 to P412.
// #define P212ToP412 P210ToP410

// Convert P216 to P416.
// #define P216ToP416 P210ToP410

// Convert YUY2 to I420.
PLANES_1_TO_3(YUY2ToI420, yuy2, y, u, v);

// Convert UYVY to I420.
PLANES_1_TO_3(UYVYToI420, uyvy, y, u, v);

// Convert AYUV to NV12.
PLANES_1_TO_2(AYUVToNV12, ayuv, y, uv);

// Convert AYUV to NV21.
PLANES_1_TO_2(AYUVToNV21, ayuv, y, vu);

// Convert Android420 to I420.
// Android420ToI420

// ARGB little endian (bgra in memory) to I420.
PLANES_1_TO_3(ARGBToI420, argb, y, u, v);

// BGRA little endian (argb in memory) to I420.
PLANES_1_TO_3(BGRAToI420, bgra, y, u, v);

// ABGR little endian (rgba in memory) to I420.
PLANES_1_TO_3(ABGRToI420, abgr, y, u, v);

// RGBA little endian (abgr in memory) to I420.
PLANES_1_TO_3(RGBAToI420, rgba, y, u, v);

// RGB little endian (bgr in memory) to I420.
PLANES_1_TO_3(RGB24ToI420, rgb24, y, u, v);

// RGB little endian (bgr in memory) to J420.
PLANES_1_TO_3(RGB24ToJ420, rgb24, y, u, v);

// RGB big endian (rgb in memory) to I420.
PLANES_1_TO_3(RAWToI420, raw, y, u, v);

// RGB big endian (rgb in memory) to J420.
PLANES_1_TO_3(RAWToJ420, raw, y, u, v);

// RGB16 (RGBP fourcc) little endian to I420.
PLANES_1_TO_3(RGB565ToI420, rgb565, y, u, v);

// RGB15 (RGBO fourcc) little endian to I420.
PLANES_1_TO_3(ARGB1555ToI420, argb1555, y, u, v);

// RGB12 (R444 fourcc) little endian to I420.
PLANES_1_TO_3(ARGB4444ToI420, argb4444, y, u, v);

// RGB little endian (bgr in memory) to J400.
PLANES_1_TO_1(RGB24ToJ400, rgb24, yj);

// RGB big endian (rgb in memory) to J400.
PLANES_1_TO_1(RAWToJ400, raw, yj);

// src_width/height provided by capture.
// dst_width/height for clipping determine final size.
// MJPGToI420

// JPEG to NV21
// MJPGToNV21

// JPEG to NV12
// MJPGToNV12

// Query size of MJPG in pixels.
// MJPGSize

// Convert camera sample to I420 with cropping, rotation and vertical flip.
// ConvertToI420
}
