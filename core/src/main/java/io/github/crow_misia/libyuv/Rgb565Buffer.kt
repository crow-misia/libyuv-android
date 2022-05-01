package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import io.github.crow_misia.libyuv.BitmapConverter.Companion.toBitmap
import java.nio.ByteBuffer

/**
 * RGB16 (RGBP fourcc) little endian
 */
class Rgb565Buffer private constructor(
    buffer: ByteBuffer?,
    val plane: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable? = null,
) : AbstractBuffer(buffer, arrayOf(plane), releaseCallback), BitmapConverter {
    override fun asBitmap(): Bitmap {
        return asBuffer().toBitmap(width, height, Bitmap.Config.RGB_565)
    }

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width.shl(1)
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): Rgb565Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return Rgb565Buffer(
                buffer = buffer,
                plane = PlanePrimitive(stride, buffer),
                width = width,
                height = height,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): Rgb565Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (stride, capacity) = getStrideWithCapacity(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity)
            return Rgb565Buffer(
                buffer = sliceBuffer,
                plane = PlanePrimitive(stride, sliceBuffer),
                width = width,
                height = height,
                releaseCallback = releaseCallback,
            )
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(plane: Plane, width: Int, height: Int, releaseCallback: Runnable? = null): Rgb565Buffer {
            return Rgb565Buffer(
                buffer = plane.buffer,
                plane = plane,
                width = width,
                height = height,
                releaseCallback = releaseCallback,
            )
        }
    }
}
