package io.github.crow_misia.libyuv

import kotlin.math.min

/**
 * Y Buffer.
 */
interface BufferY<BUFFER : BufferY<BUFFER>> : Buffer {
    val planeY: Plane

    fun convertTo(dst: BUFFER) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI400Copy(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun copyAlpha(dst: BufferFirstAlpha) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planerARGBCopyYToAlpha(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride, dstOffsetARGB = dst.plane.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }
}
