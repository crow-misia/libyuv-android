package app

import app.converter.Converter
import kotlin.system.measureTimeMillis

class ConverterExecutor {
    fun execute(converter: Converter, rgb: ByteArray, width: Int, height: Int, yuv: ByteArray): String {

        return buildString {
            appendln(converter.getName())

            for (i in 0 until 10) {
                append(measureTimeMillis {
                    converter.argbToYuv(rgb, width, height, yuv)
                })
                appendln(" ms")
            }
        }
    }
}
