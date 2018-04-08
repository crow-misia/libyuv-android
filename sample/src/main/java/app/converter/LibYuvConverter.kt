package app.converter

import io.github.zncmn.libyuv.YuvConvert

class LibYuvConverter : Converter {
    private val libYuv = YuvConvert()

    override fun getName() = "libYuv"

    override fun argbToYuv(argb: ByteArray, width: Int, height: Int, yuv: ByteArray) {
        libYuv.argbToYuv(argb, width, height, yuv)
    }
}

