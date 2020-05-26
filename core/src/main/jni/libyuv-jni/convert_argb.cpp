#include <libyuv.h>
#include "convert.h"

using namespace libyuv;
using namespace libyuv::jniutil;
extern "C" {

// Copy ARGB to ARGB.
PLANES_1_TO_1(ARGBCopy, argb, argb);

// Convert I420 to ARGB. duplicate

// Convert I420 to ABGR. duplicate

// Convert J420 to ARGB.
PLANES_3_TO_1(J420ToARGB, y, u, v, argb);

// Convert J420 to ABGR.
PLANES_3_TO_1(J420ToABGR, y, u, v, abgr);

// Convert H420 to ARGB.
PLANES_3_TO_1(H420ToARGB, y, u, v, argb);

// Convert H420 to ABGR.
PLANES_3_TO_1(H420ToABGR, y, u, v, abgr);

// Convert U420 to ARGB.
PLANES_3_TO_1(U420ToARGB, y, u, v, argb);

// Convert U420 to ABGR.
PLANES_3_TO_1(U420ToABGR, y, u, v, abgr);

// Convert I422 to ARGB.
PLANES_3_TO_1(I422ToARGB, y, u, v, argb);

// Convert I422 to ABGR. duplicate

// Convert J422 to ARGB.
PLANES_3_TO_1(J422ToARGB, y, u, v, argb);

// Convert J422 to ABGR.
PLANES_3_TO_1(J422ToABGR, y, u, v, abgr);

// Convert H422 to ARGB.
PLANES_3_TO_1(H422ToARGB, y, u, v, argb);

// Convert H422 to ABGR.
PLANES_3_TO_1(H422ToABGR, y, u, v, abgr);

// Convert U422 to ARGB.
PLANES_3_TO_1(U422ToARGB, y, u, v, argb);

// Convert U422 to ABGR.
PLANES_3_TO_1(U422ToABGR, y, u, v, abgr);

// Convert I444 to ARGB.
PLANES_3_TO_1(I444ToARGB, y, u, v, argb);

// Convert I444 to ABGR.
PLANES_3_TO_1(I444ToABGR, y, u, v, abgr);

// Convert J444 to ARGB.
PLANES_3_TO_1(J444ToARGB, y, u, v, argb);

// Convert J444 to ABGR.
PLANES_3_TO_1(J444ToABGR, y, u, v, abgr);

// Convert H444 to ARGB.
PLANES_3_TO_1(H444ToARGB, y, u, v, argb);

// Convert H444 to ABGR.
PLANES_3_TO_1(H444ToABGR, y, u, v, abgr);

// Convert U444 to ARGB.
PLANES_3_TO_1(U444ToARGB, y, u, v, argb);

// Convert U444 to ABGR.
PLANES_3_TO_1(U444ToABGR, y, u, v, abgr);

// Convert I010 to ARGB.

// Convert I010 to ABGR.

// Convert H010 to ARGB.

// Convert H010 to ABGR.

// Convert U010 to ARGB.

// Convert U010 to ABGR.

// Convert I210 to ARGB.

// Convert I210 to ABGR.

// Convert H210 to ARGB.

// Convert H210 to ABGR.

// Convert U210 to ARGB.

// Convert U210 to ABGR.

// Convert I420 with Alpha to preattenuated ARGB.

// Convert I420 with Alpha to preattenuated ABGR.

// Convert I400 (grey) to ARGB.  Reverse of ARGBToI400.
PLANES_1_TO_1(I400ToARGB, y, argb);

// Convert J400 (jpeg grey) to ARGB.
PLANES_1_TO_1(J400ToARGB, y, argb);

// Convert NV12 to ARGB.
PLANES_2_TO_1(NV12ToARGB, y, uv, argb);

// Convert NV21 to ARGB.
PLANES_2_TO_1(NV21ToARGB, y, vu, argb);

// Convert NV12 to ABGR.
PLANES_2_TO_1(NV12ToABGR, y, uv, abgr);

// Convert NV21 to ABGR.
PLANES_2_TO_1(NV21ToABGR, y, vu, abgr);

// Convert NV12 to RGB24.
PLANES_2_TO_1(NV12ToRGB24, y, uv, rgb24);

// Convert NV21 to RGB24.
PLANES_2_TO_1(NV21ToRGB24, y, vu, rgb24);

// Convert NV21 to YUV24.
PLANES_2_TO_1(NV21ToYUV24, y, vu, yuv24);

// Convert NV12 to RAW
PLANES_2_TO_1(NV12ToRAW, y, uv, raw);

// Convert NV21 to RAW
PLANES_2_TO_1(NV21ToRAW, y, vu, raw);

// Convert YUY2 to ARGB.

// Convert UYVY to ARGB.

// Convert I010 to AR30.

// Convert I010 to AB30.

// Convert H010 to AR30.

// Convert H010 to AB30.

// Convert U010 to AR30.

// Convert U010 to AB30.

// Convert I210 to AR30.

// Convert I210 to AB30.

// Convert H210 to AR30.

// Convert H210 to AB30.

// Convert U210 to AR30.

// Convert U210 to AB30.

// BGRA little endian (argb in memory) to ARGB.
PLANES_1_TO_1(BGRAToARGB, bgra, argb);

// ABGR little endian (rgba in memory) to ARGB
PLANES_1_TO_1(ABGRToARGB, abgr, argb);

// RGBA little endian (abgr in memory) to ARGB
PLANES_1_TO_1(RGBAToARGB, rgba, argb);

// RGB little endian (bgr in memory) to ARGB
PLANES_1_TO_1(RGB24ToARGB, rgb24, argb);

// RGB big endian (rgb in memory) to ARGB
PLANES_1_TO_1(RAWToARGB, raw, argb);

// RGB big endian (rgb in memory) to RGBA
PLANES_1_TO_1(RAWToRGBA, raw, rgba);

// RGB16 (RGBP fourcc) little endian to ARGB
PLANES_1_TO_1(RGB565ToARGB, rgb565, argb);

// RGB15 (RGBO fourcc) little endian to ARGB
PLANES_1_TO_1(ARGB1555ToARGB, argb1555, argb);

// RGB12 (R444 fourcc) little endian to ARGB
PLANES_1_TO_1(ARGB4444ToARGB, argb4444, argb);

// Convert AR30 To ARGB.

// Convert AR30 To ABGR.

// Convert AR30 To AB30.

// Convert Android420 to ARGB.

// Convert Android420 to ABGR.

// Convert NV12 to RGB565.
PLANES_2_TO_1(NV12ToRGB565, y, uv, rgb565);

// Convert I422 to BGRA.
PLANES_3_TO_1(I422ToBGRA, y, u, v, bgra);

// Convert I422 to ABGR.
PLANES_3_TO_1(I422ToABGR, y, u, v, abgr);

// Convert I422 to RGBA.
PLANES_3_TO_1(I422ToRGBA, y, u, v, rgba);

// Convert I420 to ARGB.
PLANES_3_TO_1(I420ToARGB, y, u, v, argb);

// Convert I420 to BGRA.
PLANES_3_TO_1(I420ToBGRA, y, u, v, bgra);

// Convert I420 to ABGR.
PLANES_3_TO_1(I420ToABGR, y, u, v, abgr);

// Convert I420 to RGBA.
PLANES_3_TO_1(I420ToRGBA, y, u, v, rgba);

// Convert I420 to RGB24.
PLANES_3_TO_1(I420ToRGB24, y, u, v, rgb24);

// Convert I420 to RAW.
PLANES_3_TO_1(I420ToRAW, y, u, v, raw);

// Convert H420 to RGB24.
PLANES_3_TO_1(H420ToRGB24, y, u, v, rgb24);

// Convert H420 to RAW.
PLANES_3_TO_1(H420ToRAW, y, u, v, raw);

// Convert J420 to RGB24.
PLANES_3_TO_1(J420ToRGB24, y, u, v, rgb24);

// Convert J420 to RAW.
PLANES_3_TO_1(J420ToRAW, y, u, v, raw);

// Convert I420 to RGB565
PLANES_3_TO_1(I420ToRGB565, y, u, v, rgb565);

// Convert J420 to RGB565
PLANES_3_TO_1(J420ToRGB565, y, u, v, rgb565);

// Convert H420 to RGB565
PLANES_3_TO_1(H420ToRGB565, y, u, v, rgb565);

// Convert I422 to RGB565
PLANES_3_TO_1(I422ToRGB565, y, u, v, rgb565);

// Convert I420 To RGB565 with 4x4 dither matrix (16 bytes).

// Convert I420 to ARGB1555
PLANES_3_TO_1(I420ToARGB1555, y, u, v, argb1555);

// Convert I420 to ARGB4444
PLANES_3_TO_1(I420ToARGB4444, y, u, v, argb4444);

// Convert I420 to AR30

// Convert H420 to AR30

// Convert I420 to ARGB with matrix.

// Convert I422 to ARGB with matrix.

// Convert I422 to ARGB with matrix.

// multiply 10 bit yuv into high bits to allow any number of bits.

// multiply 10 bit yuv into high bits to allow any number of bits.

// Convert 10 bit YUV to ARGB with matrix.

// Convert 10 bit 422 YUV to ARGB with matrix.

// Convert I420 with Alpha to preattenuated ARGB with matrix.

// Convert NV12 to ARGB with matrix.

// Convert NV21 to ARGB with matrix.

// Convert NV12 to RGB565 with matrix.

// Convert NV12 to RGB24 with matrix.

// Convert NV21 to RGB24 with matrix.

// Convert Android420 to ARGB with matrix.

// Convert I422 to RGBA with matrix.

// Convert I422 to RGBA with matrix.

// Convert I420 to RGB24 with matrix.

// Convert I420 to RGB565 with specified color matrix.

// Convert I420 to AR30 with matrix.

// Convert I400 (grey) to ARGB.  Reverse of ARGBToI400.

// Convert camera sample to ARGB with cropping, rotation and vertical flip.

}