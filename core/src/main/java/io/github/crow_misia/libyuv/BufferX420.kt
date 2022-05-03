package io.github.crow_misia.libyuv

import kotlin.math.min

/**
 * YUV(4:2:0 12bpp) Buffer.
 */
interface BufferX420<BUFFER : BufferX420<BUFFER>> : Buffer {
    val planeY: Plane
    val planeU: Plane
    val planeV: Plane

    fun convertTo(dst: BUFFER) {
        Yuv.convertI420Copy(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun mirrorTo(dst: BUFFER) {
        Yuv.planerI420Mirror(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun rotate(dst: BUFFER, rotateMode: RotateMode) {
        Yuv.rotateI420Rotate(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = rotateMode.calculateWidth(this, dst),
            height = rotateMode.calculateHeight(this, dst),
            rotateMode = rotateMode.degrees,
        )
    }

    fun scale(dst: BUFFER, filterMode: FilterMode) {
        Yuv.scaleI420Scale(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            srcU = planeU.buffer, srcStrideU = planeU.rowStride,
            srcV = planeV.buffer, srcStrideV = planeV.rowStride,
            srcWidth = width, srcHeight = height,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            dstWidth = dst.width, dstHeight = dst.height,
            filterMode = filterMode.mode,
        )
    }
}
