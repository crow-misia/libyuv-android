package app.rotate

import io.github.zncmn.libyuv.RotationMode
import io.github.zncmn.libyuv.YuvFormat
import io.github.zncmn.libyuv.YuvRotate

class LibYuvRotator : Rotator {
    private val libYuv = YuvRotate()

    override fun getName() = "libYuv"

    override fun rotate(src: ByteArray, dest: ByteArray, width: Int, height: Int, mode: RotationMode) {
        libYuv.rorate(src, dest, width, height, mode, YuvFormat.NV21)
    }
}
