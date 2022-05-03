package io.github.crow_misia.libyuv

import kotlin.math.min

/**
 * Has first Alpha channel.
 */
interface BufferFirstAlpha : Buffer {
    val plane: Plane

    fun copyAlphaTo(dst: AbgrBuffer) {
        Yuv.planerARGBCopyAlpha(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun copyAlphaTo(dst: ArgbBuffer) {
        Yuv.planerARGBCopyAlpha(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }
}
