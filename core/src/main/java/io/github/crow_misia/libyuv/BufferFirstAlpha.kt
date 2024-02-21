package io.github.crow_misia.libyuv

import kotlin.math.min

/**
 * Has first Alpha channel.
 */
interface BufferFirstAlpha : Buffer {
    val plane: Plane

    fun copyAlphaTo(dst: AbgrBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planerARGBCopyAlpha(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun copyAlphaTo(dst: ArgbBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planerARGBCopyAlpha(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = plane.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }
}
