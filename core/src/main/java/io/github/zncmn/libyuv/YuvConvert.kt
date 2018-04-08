package io.github.zncmn.libyuv

class YuvConvert {
    init {
        System.loadLibrary("yuv")
    }

    fun argbToYuv(rgb: ByteArray, width: Int, height: Int, yuv: ByteArray) {
        val bgr = ByteArray(rgb.size)
        abgrToArgb(rgb, width, height, bgr)
        argbToNv21(bgr, width, height, yuv)
    }

    private external fun abgrToArgb(rgb: ByteArray, width: Int, height: Int, bgr: ByteArray)
    private external fun argbToNv21(bgr: ByteArray, width: Int, height: Int, yuv: ByteArray)
}
