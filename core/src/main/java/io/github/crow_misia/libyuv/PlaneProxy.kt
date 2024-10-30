package io.github.crow_misia.libyuv

import androidx.camera.core.ImageProxy
import java.nio.ByteBuffer

data class PlaneProxy @JvmOverloads constructor(
    private val proxy: ImageProxy.PlaneProxy,
    override val buffer: ByteBuffer = proxy.buffer,
    override val bufferSize: Int = buffer.capacity(),
) : Plane() {
    override val rowStride: RowStride = RowStride(proxy.rowStride)
    override val pixelStride: PixelStride = PixelStride(proxy.pixelStride)
}

fun ImageProxy.PlaneProxy.asPlane(bufferSize: Int = buffer.capacity()): Plane {
    return PlaneProxy(
        proxy = this,
        buffer = buffer,
        bufferSize = bufferSize,
    )
}
