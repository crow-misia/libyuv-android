package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import io.github.crow_misia.libyuv.BitmapConverter.Companion.toBitmap
import java.nio.ByteBuffer

/**
 * ABGR little endian (rgba in memory).
 */
class AbgrBuffer private constructor(
    buffer: ByteBuffer?,
    val plane: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable? = null,
) : AbstractBuffer(buffer, arrayOf(plane), releaseCallback), BitmapConverter {
    override fun asBitmap(): Bitmap {
        return asBuffer().toBitmap(width, height, Bitmap.Config.ARGB_8888)
    }

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width.shl(2)
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): AbgrBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return AbgrBuffer(
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
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): AbgrBuffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (stride, capacity) = getStrideWithCapacity(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity)
            return AbgrBuffer(
                buffer = sliceBuffer,
                plane = PlanePrimitive(stride, sliceBuffer),
                width = width,
                height = height,
                releaseCallback = releaseCallback
            )
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(plane: Plane, width: Int, height: Int, releaseCallback: Runnable? = null): AbgrBuffer {
            return AbgrBuffer(
                buffer = plane.buffer,
                plane = plane,
                width = width,
                height = height,
                releaseCallback = releaseCallback,
            )
        }
    }
}
