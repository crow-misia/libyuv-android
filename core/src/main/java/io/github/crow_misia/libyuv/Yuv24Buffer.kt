package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

/**
 * YUV 24bpp
 */
class Yuv24Buffer private constructor(
    buffer: ByteBuffer?,
    crop: Rect,
    override val plane: Plane,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, crop, arrayOf(plane), releaseCallback), Buffer24<Yuv24Buffer> {
    companion object Factory : BufferFactory<Yuv24Buffer> {
        private fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width * 3
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        override fun allocate(width: Int, height: Int): Yuv24Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return Yuv24Buffer(
                buffer = buffer,
                crop = Rect(width = width, height = height),
                plane = PlanePrimitive(stride, buffer),
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): Yuv24Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (stride, capacity) = getStrideWithCapacity(width, height)
            val sliceBuffer = buffer.sliceRange(0, capacity)
            return Yuv24Buffer(
                buffer = sliceBuffer,
                crop = Rect(width = width, height = height),
                plane = PlanePrimitive(stride, sliceBuffer),
                releaseCallback = null,
            )
        }

        fun wrap(plane: Plane, width: Int, height: Int): Yuv24Buffer {
            return Yuv24Buffer(
                buffer = plane.buffer,
                crop = Rect(width = width, height = height),
                plane = plane,
                releaseCallback = null,
            )
        }
    }
}
