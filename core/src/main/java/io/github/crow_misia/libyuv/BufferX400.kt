package io.github.crow_misia.libyuv

import kotlin.math.min

/**
 * YUV(4:0:0 8bpp) Buffer.
 */
interface BufferX400<BUFFER : BufferX400<BUFFER, BUFFERX420>, BUFFERX420 : BufferX420<BUFFERX420>> : BufferY<BUFFER> {
    fun convertTo(dst: BUFFERX420) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.convertI400Copy(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun mirrorTo(dst: BUFFER) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planerI400Mirror(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun rotate(dst: BUFFER, rotateMode: RotateMode) {
        Yuv.rotateRotatePlane(
            src = planeY.buffer, srcStride = planeY.rowStride, srcOffset = planeY.offset,
            dst = dst.planeY.buffer, dstStride = dst.planeY.rowStride, dstOffset = dst.planeY.offset,
            width = rotateMode.calculateWidth(this, dst),
            height = rotateMode.calculateHeight(this, dst),
            rotateMode = rotateMode.degrees,
        )
    }

    fun scale(dst: BUFFER, filterMode: FilterMode) {
        Yuv.scaleScalePlane(
            src = planeY.buffer, srcStride = planeY.rowStride, srcOffset = planeY.offset,
            srcWidth = cropRect.width(), srcHeight = cropRect.height(),
            dst = dst.planeY.buffer, dstStride = dst.planeY.rowStride, dstOffset = dst.planeY.offset,
            dstWidth = dst.cropRect.width(), dstHeight = dst.cropRect.height(),
            filterMode = filterMode.mode,
        )
    }
}
