package app

import app.converter.Converter
import kotlin.system.measureTimeMillis

class ConverterExecutor {
    fun execute(converter: Converter, rgb: ByteArray, width: Int, height: Int, yuv: ByteArray): String {
        return buildString {
            appendln(converter.getName())

            var millis = 0L
            for (i in 0 until 10) {
                millis += measureTimeMillis {
                    converter.argbToYuv(rgb, yuv, width, height)
                }
            }
            appendln("${millis / 10} ms")
        }
    }
}
