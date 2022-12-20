package io.github.crow_misia.libyuv

import android.media.Image
import android.os.Build
import androidx.annotation.RequiresApi
import java.nio.ByteBuffer

@RequiresApi(Build.VERSION_CODES.KITKAT)
class PlaneNative(
    private val plane: Image.Plane,
) : Plane {
    override val buffer: ByteBuffer
        get() = plane.buffer
    override val rowStride: Int
        get() = plane.rowStride
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Image.Plane.asPlane(): Plane {
    return PlaneNative(this)
}
