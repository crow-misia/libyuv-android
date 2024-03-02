package io.github.crow_misia.libyuv

import androidx.camera.core.ImageProxy
import java.nio.ByteBuffer

data class PlaneProxy(
    private val proxy: ImageProxy.PlaneProxy,
) : Plane() {
    override val buffer: ByteBuffer = proxy.buffer
    override val rowStride: RowStride = RowStride(proxy.rowStride)
}

fun ImageProxy.PlaneProxy.asPlane(): Plane {
    return PlaneProxy(proxy = this)
}
