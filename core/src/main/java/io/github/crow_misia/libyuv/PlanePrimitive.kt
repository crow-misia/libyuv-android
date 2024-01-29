package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

data class PlanePrimitive(
    override val rowStride: RowStride,
    override val buffer: ByteBuffer,
    override val offset: Int = 0,
) : Plane

