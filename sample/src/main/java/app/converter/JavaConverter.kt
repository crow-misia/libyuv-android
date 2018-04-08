package app.converter

class JavaConverter : Converter {
    override fun getName() = "java"

    override fun argbToYuv(argb: ByteArray, width: Int, height: Int, yuv: ByteArray) {
        var rgbIndex = 0
        var yIndex = 0
        var uvIndex = width * height
        for (j in 0 until height) {
            for (i in 0 until width) {
                val r = (argb[rgbIndex].toInt() and 0xFF).toDouble()
                val g = (argb[rgbIndex + 1].toInt() and 0xFF).toDouble()
                val b = (argb[rgbIndex + 2].toInt() and 0xFF).toDouble()

                val y = (0.257 * r + 0.504 * g + 0.098 * b + 16.0).toInt()
                val u = (-0.148 * r - 0.291 * g + 0.439 * b + 128.0).toInt()
                val v = (0.439 * r - 0.368 * g - 0.071 * b + 128).toInt()

                yuv[yIndex++] = Math.max(0, Math.min(255, y)).toByte()
                if (i and 0x01 == 0 && j and 0x01 == 0) {
                    yuv[uvIndex++] = Math.max(0, Math.min(255, v)).toByte()
                    yuv[uvIndex++] = Math.max(0, Math.min(255, u)).toByte()
                }

                rgbIndex += 4
            }
        }
    }
}