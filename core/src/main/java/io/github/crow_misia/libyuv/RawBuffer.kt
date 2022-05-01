package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

/**
 * RGB big endian (rgb in memory)
 */
class RawBuffer private constructor(
    buffer: ByteBuffer?,
    val plane: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable? = null,
) : AbstractBuffer(buffer, arrayOf(plane), releaseCallback) {
    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width * 3
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): RawBuffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return RawBuffer(
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
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): RawBuffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (stride, capacity) = getStrideWithCapacity(width, height)
            return RawBuffer(
                buffer = buffer,
                plane = PlanePrimitive(stride, buffer.sliceRange(0, capacity)),
                width = width,
                height = height,
                releaseCallback = releaseCallback,
            )
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(plane: Plane, width: Int, height: Int, releaseCallback: Runnable? = null): RawBuffer {
            return RawBuffer(
                buffer = plane.buffer,
                plane = plane,
                width = width,
                height = height,
                releaseCallback = releaseCallback,
            )
        }
    }
}
