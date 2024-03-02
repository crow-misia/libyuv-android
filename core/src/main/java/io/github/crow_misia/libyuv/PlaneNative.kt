package io.github.crow_misia.libyuv

import android.media.Image
import java.nio.ByteBuffer

data class PlaneNative(
    private val plane: Image.Plane,
) : Plane() {
    override val buffer: ByteBuffer = plane.buffer
    override val rowStride: RowStride = RowStride(plane.rowStride)
}

fun Image.Plane.asPlane(): Plane {
    return PlaneNative(plane = this)
}
