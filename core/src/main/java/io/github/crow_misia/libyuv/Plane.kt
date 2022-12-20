@file:Suppress("unused")

package io.github.crow_misia.libyuv

import java.math.BigInteger
import java.nio.ByteBuffer
import kotlin.math.min

interface Plane {
    val rowStride: Int
    val buffer: ByteBuffer

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

    fun setValue(width: Int, height: Int, value: Int) {
        Yuv.planerSetPlane(srcY = buffer, srcStrideY = rowStride, width = width, height = height, value = value)
    }
}
