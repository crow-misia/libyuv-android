package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

data class PlanePrimitive(
    override val rowStride: RowStride,
    override val buffer: ByteBuffer,
    override val pixelStride: PixelStride = PixelStride.ONE,
    override val bufferSize: Int = buffer.capacity(),
) : Plane() {
    companion object {
        @JvmStatic
        @JvmOverloads
        fun create(
            rowStride: Int,
            buffer: ByteBuffer,
            pixelStride: Int = PixelStride.ONE.value,
            bufferSize: Int = buffer.capacity(),
        ) = PlanePrimitive(
            rowStride = RowStride(rowStride),
            pixelStride = PixelStride(pixelStride),
            buffer = buffer,
            bufferSize = bufferSize,
        )
    }
}
