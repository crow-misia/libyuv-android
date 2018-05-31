package app.rotate

import io.github.zncmn.libyuv.RotationMode

interface Rotator {
    fun getName(): String
    fun rotate(src: ByteArray, dest: ByteArray, width: Int, height: Int, mode: RotationMode)
}
