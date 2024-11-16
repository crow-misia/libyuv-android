package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

data class PlanePrimitive(
    override val rowStride: RowStride,
    override val buffer: ByteBuffer,
    override val bufferSize: Int = buffer.capacity(),
) : Plane() {
    companion object {
        @JvmStatic
        @JvmOverloads
        fun create(
            rowStride: Int,
            buffer: ByteBuffer,
            bufferSize: Int = buffer.capacity(),
        ) = PlanePrimitive(
            rowStride = RowStride(rowStride),
            buffer = buffer,
            bufferSize = bufferSize,
        )
    }
}
