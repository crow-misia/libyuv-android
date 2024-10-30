package io.github.crow_misia.libyuv

import android.media.Image
import java.nio.ByteBuffer

data class PlaneNative @JvmOverloads constructor(
    private val plane: Image.Plane,
    override val buffer: ByteBuffer = plane.buffer,
    override val bufferSize: Int = buffer.capacity(),
) : Plane() {
    override val rowStride: RowStride = RowStride(plane.rowStride)
    override val pixelStride: PixelStride = PixelStride(plane.pixelStride)
}

fun Image.Plane.asPlane(bufferSize: Int = buffer.capacity()): Plane {
    return PlaneNative(
        plane = this,
        buffer = buffer,
        bufferSize = bufferSize,
    )
}
