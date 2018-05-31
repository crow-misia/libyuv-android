package app.converter

interface Converter {
    fun getName(): String
    fun argbToYuv(argb: ByteArray, yuv: ByteArray, width: Int, height: Int)
}
