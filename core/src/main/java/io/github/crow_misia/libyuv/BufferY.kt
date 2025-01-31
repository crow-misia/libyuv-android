package io.github.crow_misia.libyuv

/**
 * Y Buffer.
 */
interface BufferY<BUFFER : BufferY<BUFFER>> : Buffer {
    val planeY: Plane

    fun convertTo(dst: BUFFER) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI400Copy(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun copyAlpha(dst: BufferFirstAlpha) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planarARGBCopyYToAlpha(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.offset(0),
            width = fixedWidth, height = fixedHeight,
        )
    }
}
