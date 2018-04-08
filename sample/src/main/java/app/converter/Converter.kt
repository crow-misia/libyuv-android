package app.converter

interface Converter {
    fun getName(): String
    fun argbToYuv(argb: ByteArray, width: Int, height: Int, yuv: ByteArray)
}
