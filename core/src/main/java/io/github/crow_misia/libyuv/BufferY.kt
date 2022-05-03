package io.github.crow_misia.libyuv

import kotlin.math.min

/**
 * Y Buffer.
 */
interface BufferY<BUFFER : BufferY<BUFFER>> : Buffer {
    val planeY: Plane

    fun convertTo(dst: BUFFER) {
        Yuv.convertI400Copy(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }
}
