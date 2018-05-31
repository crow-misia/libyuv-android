package app

import app.rotate.Rotator
import io.github.zncmn.libyuv.RotationMode
import kotlin.system.measureTimeMillis

class RotateExecutor {
    fun execute(rotator: Rotator, src: ByteArray, width: Int, height: Int, dest: ByteArray, callback: (width: Int, height: Int) -> Unit): String {
        return buildString {
            append(rotator.getName())

            var millis = 0L
            for (i in 0 until 10) {
                millis += measureTimeMillis {1
                    rotator.rotate(src, dest, width, height, RotationMode.ROTATE_90)
                    callback.invoke(height, width)
                }
            }
            appendln("${millis / 10} ms")
        }
    }
}
