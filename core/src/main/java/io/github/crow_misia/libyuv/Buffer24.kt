package io.github.crow_misia.libyuv

import kotlin.math.min

/**
 * 24 bpp Buffer.
 */
interface Buffer24<BUFFER : Buffer24<BUFFER>> : Buffer {
    val plane: Plane

    fun mirrorTo(dst: BUFFER) {
        Yuv.planerRGB24Mirror(
            srcRGB24 = plane.buffer, srcStrideRGB24 = plane.rowStride, srcOffsetRGB24 = plane.offset,
            dstRGB24 = dst.plane.buffer, dstStrideRGB24 = dst.plane.rowStride, dstOffsetRGB24 = dst.plane.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }
}
