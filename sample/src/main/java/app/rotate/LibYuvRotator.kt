package app.rotate

import io.github.zncmn.libyuv.RotationMode
import io.github.zncmn.libyuv.YuvRotate

class LibYuvRotator : Rotator {
    private val libYuv = YuvRotate()

    override fun getName() = "libYuv"

    override fun rotate(src: ByteArray, width: Int, height: Int, dest: ByteArray, mode: RotationMode) {
        libYuv.rorate(src, width, height, dest, mode)
    }
}
