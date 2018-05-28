package app.rotate

import io.github.zncmn.libyuv.RotationMode

interface Rotator {
    fun getName(): String
    fun rotate(src: ByteArray, width: Int, height: Int, dest: ByteArray, mode: RotationMode)
}
