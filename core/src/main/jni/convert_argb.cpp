#include <libyuv.h>
#include "convert.h"

using namespace libyuv;
using namespace libyuv::jniutil;
extern "C" {

// #define ARGBToARGB ARGBCopy

// Copy ARGB to ARGB.
PLANES_1_TO_1(ARGBCopy, argb, argb);

// Convert I420 to ARGB. duplicate
// I420ToARGB

// Convert I420 to ABGR. duplicate
// I420ToABGR

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
// I422ToABGR

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
// I010ToARGB

// Convert I010 to ABGR.
// I010ToABGR

// Convert H010 to ARGB.
// H010ToARGB

// Convert H010 to ABGR.
// H010ToABGR

// Convert U010 to ARGB.
// U010ToARGB

// Convert U010 to ABGR.
// U010ToABGR

// Convert I210 to ARGB.
// I210ToARGB

// Convert I210 to ABGR.
// I210ToABGR

// Convert H210 to ARGB.
// H210ToARGB

// Convert H210 to ABGR.
// H210ToABGR

// Convert U210 to ARGB.
// U210ToARGB

// Convert U210 to ABGR.
// U210ToABGR

// Convert I420 with Alpha to preattenuated ARGB.
// I420AlphaToARGB

// Convert I420 with Alpha to preattenuated ABGR.
// I420AlphaToABGR

// Convert I422 with Alpha to preattenuated ARGB.
// I422AlphaToARGB

// Convert I422 with Alpha to preattenuated ABGR.
// I422AlphaToABGR

// Convert I444 with Alpha to preattenuated ARGB.
// I444AlphaToARGB

// Convert I444 with Alpha to preattenuated ABGR.
// I444AlphaToABGR

// Convert I400 (grey) to ARGB.  Reverse of ARGBToI400.
PLANES_1_TO_1(I400ToARGB, y, argb);

// Convert J400 (jpeg grey) to ARGB.
PLANES_1_TO_1(J400ToARGB, y, argb);

// #define YToARGB I400ToARGB

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

// Convert NV12 to RAW.
PLANES_2_TO_1(NV12ToRAW, y, uv, raw);

// Convert NV21 to RAW.
PLANES_2_TO_1(NV21ToRAW, y, vu, raw);

// Convert YUY2 to ARGB.
PLANES_1_TO_1(YUY2ToARGB, yuy2, argb);

// Convert UYVY to ARGB.
PLANES_1_TO_1(UYVYToARGB, uyvy, argb);

// Convert I010 to AR30.
// I010ToAR30

// Convert I010 to AB30.
// I010ToAB30

// Convert H010 to AR30.
// H010ToAR30

// Convert H010 to AB30.
// H010ToAB30

// Convert U010 to AR30.
// U010ToAR30

// Convert U010 to AB30.
// U010ToAB30

// Convert I210 to AR30.
// I210ToAR30

// Convert I210 to AB30.
// I210ToAB30

// Convert H210 to AR30.
// H210ToAR30

// Convert H210 to AB30.
// H210ToAB30

// Convert U210 to AR30.
// U210ToAR30

// Convert U210 to AB30.
// U210ToAB30

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

// #define AB30ToARGB AR30ToABGR
// #define AB30ToABGR AR30ToARGB
// #define AB30ToAR30 AR30ToAB30

// Convert AR30 To ARGB.
PLANES_1_TO_1(AR30ToARGB, ar30, argb);

// Convert AR30 To ABGR.
PLANES_1_TO_1(AR30ToABGR, ar30, abgr);

// Convert AR30 To AB30.
PLANES_1_TO_1(AR30ToAB30, ar30, ab30);

// Convert AR64 to ARGB.
// AR64ToARGB

// Convert AB64 to ABGR.
// #define AB64ToABGR AR64ToARGB

// Convert AB64 to ARGB.
// AB64ToARGB

// Convert AR64 to ABGR.
// #define AR64ToABGR AB64ToARGB

// Convert AR64 To AB64.
// AR64ToAB64

// Convert AB64 To AR64.
// #define AB64ToAR64 AR64ToAB64

// MJPGToARGB

// Convert Android420 to ARGB.
// Android420ToARGB

// Convert Android420 to ABGR.
// Android420ToABGR

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
// I420ToRGB565Dither

// Convert I420 to ARGB1555
PLANES_3_TO_1(I420ToARGB1555, y, u, v, argb1555);

// Convert I420 to ARGB4444
PLANES_3_TO_1(I420ToARGB4444, y, u, v, argb4444);

// Convert I420 to AR30
PLANES_3_TO_1(I420ToAR30, y, u, v, ar30);

// Convert I420 to AB30.
PLANES_3_TO_1(I420ToAB30, y, u, v, ab30);

// Convert H420 to AR30
PLANES_3_TO_1(H420ToAR30, y, u, v, ar30);

// Convert H420 to AB30.
PLANES_3_TO_1(H420ToAB30, y, u, v, ab30);

// Convert I420 to ARGB with matrix.
// I420ToARGBMatrix

// Convert I422 to ARGB with matrix.
// I422ToARGBMatrix

// Convert I444 to ARGB with matrix.
// I444ToARGBMatrix

// Convert 10 bit 420 YUV to ARGB with matrix.
// I010ToAR30Matrix

// Convert 10 bit 420 YUV to ARGB with matrix.
// I210ToAR30Matrix

// Convert 10 bit 444 YUV to ARGB with matrix.
// I410ToAR30Matrix

// Convert 10 bit YUV to ARGB with matrix.
// I010ToARGBMatrix

// multiply 10 bit yuv into high bits to allow any number of bits.
// I012ToAR30Matrix

// Convert 12 bit YUV to ARGB with matrix.
// I012ToARGBMatrix

// Convert 10 bit 422 YUV to ARGB with matrix.
// I210ToARGBMatrix

// Convert 10 bit 444 YUV to ARGB with matrix.
// I410ToARGBMatrix

// Convert P010 to ARGB with matrix.
// P010ToARGBMatrix

// Convert P210 to ARGB with matrix.
// P210ToARGBMatrix

// Convert P010 to AR30 with matrix.
// P010ToAR30Matrix

// Convert P210 to AR30 with matrix.
// P210ToAR30Matrix

// P012 and P010 use most significant bits so the conversion is the same.
// Convert P012 to ARGB with matrix.
// #define P012ToARGBMatrix P010ToARGBMatrix
// Convert P012 to AR30 with matrix.
// #define P012ToAR30Matrix P010ToAR30Matrix
// Convert P212 to ARGB with matrix.
// #define P212ToARGBMatrix P210ToARGBMatrix
// Convert P212 to AR30 with matrix.
// #define P212ToAR30Matrix P210ToAR30Matrix

// Convert P016 to ARGB with matrix.
// #define P016ToARGBMatrix P010ToARGBMatrix
// Convert P016 to AR30 with matrix.
// #define P016ToAR30Matrix P010ToAR30Matrix
// Convert P216 to ARGB with matrix.
// #define P216ToARGBMatrix P210ToARGBMatrix
// Convert P216 to AR30 with matrix.
// #define P216ToAR30Matrix P210ToAR30Matrix

// Convert I420 with Alpha to preattenuated ARGB with matrix.
// I420AlphaToARGBMatrix

// Convert I422 with Alpha to preattenuated ARGB with matrix.
// I422AlphaToARGBMatrix

// Convert I444 with Alpha to preattenuated ARGB with matrix.
// I444AlphaToARGBMatrix

// Convert I010 with Alpha to preattenuated ARGB with matrix.
// I010AlphaToARGBMatrix

// Convert I210 with Alpha to preattenuated ARGB with matrix.
// I210AlphaToARGBMatrix

// Convert I410 with Alpha to preattenuated ARGB with matrix.
// I410AlphaToARGBMatrix

// Convert NV12 to ARGB with matrix.
// NV12ToARGBMatrix

// Convert NV21 to ARGB with matrix.
// NV21ToARGBMatrix

// Convert NV12 to RGB565 with matrix.
// NV12ToRGB565Matrix

// Convert NV12 to RGB24 with matrix.
// NV12ToRGB24Matrix

// Convert NV21 to RGB24 with matrix.
// NV21ToRGB24Matrix

// Convert Android420 to ARGB with matrix.
// Android420ToARGBMatrix

// Convert I422 to RGBA with matrix.
// I422ToRGBAMatrix

// Convert I422 to RGBA with matrix.
// I420ToRGBAMatrix

// Convert I420 to RGB24 with matrix.
// I420ToRGB24Matrix

// Convert I420 to RGB565 with specified color matrix.
// I420ToRGB565Matrix

// Convert I420 to AR30 with matrix.
// I420ToAR30Matrix

// Convert I400 (grey) to ARGB.  Reverse of ARGBToI400.
// I400ToARGBMatrix

// Convert I420 to ARGB with matrix and UV filter mode.
// I420ToARGBMatrixFilter

// Convert I422 to ARGB with matrix and UV filter mode.
// I422ToARGBMatrixFilter

// Convert I010 to AR30 with matrix and UV filter mode.
// I010ToAR30MatrixFilter

// Convert I210 to AR30 with matrix and UV filter mode.
// I210ToAR30MatrixFilter

// Convert I010 to ARGB with matrix and UV filter mode.
// I010ToARGBMatrixFilter

// Convert I210 to ARGB with matrix and UV filter mode.
// I210ToARGBMatrixFilter

// Convert I420 with Alpha to attenuated ARGB with matrix and UV filter mode.
// I420AlphaToARGBMatrixFilter

// Convert I422 with Alpha to attenuated ARGB with matrix and UV filter mode.
// I422AlphaToARGBMatrixFilter

// Convert I010 with Alpha to attenuated ARGB with matrix and UV filter mode.
// I010AlphaToARGBMatrixFilter

// Convert I210 with Alpha to attenuated ARGB with matrix and UV filter mode.
// I210AlphaToARGBMatrixFilter

// Convert P010 to ARGB with matrix and UV filter mode.
// P010ToARGBMatrixFilter

// Convert P210 to ARGB with matrix and UV filter mode.
// P210ToARGBMatrixFilter

// Convert P010 to AR30 with matrix and UV filter mode.
// P010ToAR30MatrixFilter

// Convert P210 to AR30 with matrix and UV filter mode.
// P210ToAR30MatrixFilter

// Convert camera sample to ARGB with cropping, rotation and vertical flip.
// ConvertToARGB

}
