package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

class PlanePrimitive(
    override val rowStride: Int,
    override val buffer: ByteBuffer,
) : Plane

