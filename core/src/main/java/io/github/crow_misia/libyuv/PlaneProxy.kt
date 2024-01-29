package io.github.crow_misia.libyuv

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.camera.core.ImageProxy
import java.nio.ByteBuffer

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
data class PlaneProxy(
    private val proxy: ImageProxy.PlaneProxy,
    override val offset: Int,
) : Plane {
    override val buffer: ByteBuffer = proxy.buffer
    override val rowStride: RowStride = RowStride(proxy.rowStride)
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun ImageProxy.PlaneProxy.asPlane(offset: Int = 0): Plane {
    return PlaneProxy(proxy = this, offset = offset)
}
