package io.github.crow_misia.libyuv

/**
 * 24 bpp Buffer.
 */
interface Buffer24<BUFFER : Buffer24<BUFFER>> : Buffer {
    val plane: Plane

    fun mirrorTo(dst: BUFFER) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planarRGB24Mirror(
            srcRGB24 = plane.buffer, srcStrideRGB24 = plane.rowStride, srcOffsetRGB24 = offset(0),
            dstRGB24 = dst.plane.buffer, dstStrideRGB24 = dst.plane.rowStride, dstOffsetRGB24 = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }
}
