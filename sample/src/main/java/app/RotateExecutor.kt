package app

import app.rotate.Rotator
import io.github.zncmn.libyuv.RotationMode
import kotlin.system.measureTimeMillis

class RotateExecutor {
    fun execute(rotator: Rotator, src: ByteArray, width: Int, height: Int, dest: ByteArray, callback: (width: Int, height: Int) -> Unit): String {
        return buildString {
            // 90
            append(rotator.getName())
            appendln(" - 90")
//            for (i in 0 until 10) {
                append(measureTimeMillis {
                    rotator.rotate(src, width, height, dest, RotationMode.ROTATE_270)
                    callback.invoke(height, width)
                })
                appendln(" ms")
//            }
        }
    }
}
