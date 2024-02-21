package io.github.crow_misia.libyuv

/**
 * YUV(4:2:2 16bpp) Buffer.
 */
interface BufferX422<BUFFER : BufferX422<BUFFER>> : Buffer {
    val planeY: Plane
    val planeU: Plane
    val planeV: Plane

    fun convertTo(dst: BUFFER) {
        val (fixedWidth, fixedHeight) = calculateSize(dst)
        Yuv.planerI422Copy(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = offset(1),
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = offset(2),
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.offset(0),
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.offset(1),
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.offset(2),
            width = fixedWidth, height = fixedHeight,
        )
    }

    fun rotate(dst: BUFFER, rotateMode: RotateMode) {
        Yuv.rotateI422Rotate(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = offset(1),
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = offset(2),
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.offset(0),
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.offset(1),
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.offset(2),
            width = rotateMode.calculateWidth(this, dst),
            height = rotateMode.calculateHeight(this, dst),
            rotateMode = rotateMode.degrees,
        )
    }

    fun scale(dst: BUFFER, filterMode: FilterMode) {
        Yuv.scaleI422Scale(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride, srcOffsetY = offset(0),
            srcU = planeU.buffer, srcStrideU = planeU.rowStride, srcOffsetU = offset(1),
            srcV = planeV.buffer, srcStrideV = planeV.rowStride, srcOffsetV = offset(2),
            srcWidth = cropRect.width(), srcHeight = cropRect.height(),
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride, dstOffsetY = dst.offset(0),
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride, dstOffsetU = dst.offset(1),
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride, dstOffsetV = dst.offset(2),
            dstWidth = dst.cropRect.width(), dstHeight = dst.cropRect.height(),
            filterMode = filterMode.mode,
        )
    }
}
