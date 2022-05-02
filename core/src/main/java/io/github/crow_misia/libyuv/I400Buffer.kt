package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

/**
 * I400 (grey) YUV Format. 4:0:0 8bpp
 */
class I400Buffer private constructor(
    buffer: ByteBuffer?,
    val planeY: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, arrayOf(planeY), releaseCallback) {
    companion object Factory : BufferFactory<I400Buffer> {
        private fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            return intArrayOf(width, width * height)
        }

        override fun allocate(width: Int, height: Int): I400Buffer {
            val (strideY, capacity) = getStrideWithCapacity(width, height)
            val bufferY = createByteBuffer(capacity)
            return I400Buffer(
                buffer = bufferY,
                planeY = PlanePrimitive(strideY, bufferY),
                width = width,
                height = height,
            ) {
                Yuv.freeNativeBuffer(bufferY)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): I400Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (strideY, capacity) = getStrideWithCapacity(width, height)
            val bufferY = buffer.sliceRange(0, capacity)
            return I400Buffer(
                buffer = bufferY,
                planeY = PlanePrimitive(strideY, bufferY),
                width = width,
                height = height,
                releaseCallback = null,
            )
        }

        fun wrap(planeY: Plane, width: Int, height: Int): I400Buffer {
            return I400Buffer(
                buffer = planeY.buffer,
                planeY = planeY,
                width = width,
                height = height,
                releaseCallback = null,
            )
        }
    }
}
