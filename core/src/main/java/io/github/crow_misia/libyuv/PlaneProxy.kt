package io.github.crow_misia.libyuv

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.camera.core.ImageProxy
import java.nio.ByteBuffer

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class PlaneProxy(
    private val proxy: ImageProxy.PlaneProxy,
) : Plane {
    override val buffer: ByteBuffer
        get() = proxy.buffer
    override val rowStride: Int
        get() = proxy.rowStride
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun ImageProxy.PlaneProxy.asPlane(): Plane {
    return PlaneProxy(this)
}
