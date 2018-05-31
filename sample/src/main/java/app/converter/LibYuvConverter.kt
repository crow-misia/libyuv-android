package app.converter

import io.github.zncmn.libyuv.YuvConvert
import io.github.zncmn.libyuv.YuvFormat

class LibYuvConverter : Converter {
    private val libYuv = YuvConvert()

    override fun getName() = "libYuv"

    override fun argbToYuv(argb: ByteArray, yuv: ByteArray, width: Int, height: Int) {
        libYuv.fromARGB(argb, yuv, width, height, YuvFormat.NV21)
    }
}

