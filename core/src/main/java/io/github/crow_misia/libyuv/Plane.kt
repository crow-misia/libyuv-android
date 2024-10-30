@file:Suppress("unused")

package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.math.BigInteger
import java.nio.ByteBuffer
import kotlin.math.min

abstract class Plane {
    abstract val rowStride: RowStride
    abstract val pixelStride: PixelStride
    abstract val buffer: ByteBuffer
    abstract val bufferSize: Int

    fun hashDjb2(): Long = hashDjb2(5381)

    fun hashDjb2(seed: Long): Long {
        return Yuv.hashDjb2(
            src = buffer,
            count = buffer.capacity().toLong(),
            seed = seed,
        )
    }

    fun hammingDistance(other: Plane): BigInteger {
        return BigInteger(Yuv.computeHammingDistance(
            srcA = buffer,
            srcB = other.buffer,
            count = min(buffer.capacity(), other.buffer.capacity()),
        ))
    }

    fun computeSumSquareError(other: Plane, width: Int, height: Int): BigInteger {
        return BigInteger(Yuv.computeSumSquareErrorPlane(
            srcA = buffer, srcStrideA = rowStride,
            srcB = other.buffer, srcStrideB = other.rowStride,
            width = width, height = height,
        ))
    }

    fun calculateFramePsnr(other: Plane, width: Int, height: Int): Double {
        return Yuv.calcFramePsnr(
            srcA = buffer, srcStrideA = rowStride,
            srcB = other.buffer, srcStrideB = other.rowStride,
            width = width, height = height,
        )
    }

    fun calculateFrameSsim(other: Plane, width: Int, height: Int): Double {
        return Yuv.calcFrameSsim(
            srcA = buffer, srcStrideA = rowStride,
            srcB = other.buffer, srcStrideB = other.rowStride,
            width = width, height = height,
        )
    }

    fun setValue(top: Int = 0, left: Int = 0, width: Int, height: Int, value: Int) {
        setValue(Rect(top, left, top + width, top + height), value)
    }

    fun setValue(rect: Rect, value: Int) {
        Yuv.planerSetPlane(
            dstY = buffer, dstStrideY = rowStride, dstOffsetY = rect.top * rowStride.value + rect.left,
            width = rect.width(), height = rect.height(),
            value = value,
        )
    }

    internal fun offset(buffer: Buffer, planeIndex: Int): Int {
        val cropRect = buffer.cropRect
        return buffer.getPlaneOffset(planeIndex, rowStride, cropRect.left, cropRect.top)
    }
}
