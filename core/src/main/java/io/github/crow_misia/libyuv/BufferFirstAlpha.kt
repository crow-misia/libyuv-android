package io.github.crow_misia.libyuv

/**
 * Has first Alpha channel.
 */
interface BufferFirstAlpha : Buffer {
    val plane: Plane

    fun copyAlphaTo(dst: AbgrBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planarARGBCopyAlpha(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = offset(0),
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun copyAlphaTo(dst: ArgbBuffer) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planarARGBCopyAlpha(
            srcARGB = plane.buffer, srcStrideARGB = plane.rowStride, srcOffsetARGB = offset(0),
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }
}
