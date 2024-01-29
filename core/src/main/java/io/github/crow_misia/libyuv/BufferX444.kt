package io.github.crow_misia.libyuv

import kotlin.math.min

/**
 * YUV(4:4:4 24bpp) Buffer.
 */
interface BufferX444<BUFFER : BufferX444<BUFFER>> : Buffer {
    val planeY: Plane
    val planeU: Plane
    val planeV: Plane

    fun convertTo(dst: BUFFER) {
        Yuv.planerI444Copy(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeY.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeY.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun rotate(dst: BUFFER, rotateMode: RotateMode) {
        Yuv.rotateI444Rotate(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeY.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeY.offset,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            width = rotateMode.calculateWidth(this, dst),
            height = rotateMode.calculateHeight(this, dst),
            rotateMode = rotateMode.degrees,
        )
    }

    fun scale(dst: BUFFER, filterMode: FilterMode) {
        Yuv.scaleI444Scale(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = planeY.offset,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = planeY.offset,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = planeY.offset,
            srcWidth = width, srcHeight = height,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.planeY.offset,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.planeU.offset,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.planeV.offset,
            dstWidth = dst.width, dstHeight = dst.height,
            filterMode = filterMode.mode,
        )
    }
}
