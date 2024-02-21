package io.github.crow_misia.libyuv

import android.media.Image
import android.os.Build
import androidx.annotation.RequiresApi
import java.nio.ByteBuffer

@RequiresApi(Build.VERSION_CODES.KITKAT)
data class PlaneNative(
    private val plane: Image.Plane,
) : Plane() {
    override val buffer: ByteBuffer = plane.buffer
    override val rowStride: RowStride = RowStride(plane.rowStride)
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Image.Plane.asPlane(): Plane {
    return PlaneNative(plane = this)
}
