@file:Suppress("unused")

package io.github.crow_misia.libyuv

import android.media.Image
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RestrictTo
import java.math.BigInteger
import java.nio.ByteBuffer
import kotlin.math.min

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
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

    companion object {
        @RequiresApi(Build.VERSION_CODES.KITKAT)
        @JvmStatic
        @JvmName("from")
        fun Image.Plane.asPlane(): Plane {
            return PlaneNative(this)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
internal class PlaneNative(
    private val plane: Image.Plane,
) : Plane {
    override val buffer: ByteBuffer
        get() = plane.buffer
    override val rowStride: Int
        get() = plane.rowStride
}

internal class PlanePrimitive(
    override val rowStride: Int,
    override val buffer: ByteBuffer,
) : Plane
