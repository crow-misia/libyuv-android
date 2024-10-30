package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

data class PlanePrimitive(
    override val rowStride: RowStride,
    override val pixelStride: PixelStride,
    override val buffer: ByteBuffer,
    override val bufferSize: Int,
) : Plane() {
    constructor(
        rowStride: RowStride,
        buffer: ByteBuffer,
    ) : this(
        rowStride = rowStride,
        pixelStride = PixelStride.ONE,
        buffer = buffer,
        bufferSize = buffer.limit(),
    )

    constructor(
        rowStride: RowStride,
        pixelStride: PixelStride,
        buffer: ByteBuffer,
    ) : this(
        rowStride = rowStride,
        pixelStride = pixelStride,
        buffer = buffer,
        bufferSize = buffer.limit(),
    )
}
