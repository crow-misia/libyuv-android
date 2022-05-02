package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

/**
 * J400 (jpeg grey) YUV Format. 4:0:0 8bpp
 */
class J400Buffer private constructor(
    buffer: ByteBuffer?,
    val planeYJ: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, arrayOf(planeYJ), releaseCallback) {
    companion object Factory : BufferFactory<J400Buffer> {
        private fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            return intArrayOf(width, width * height)
        }

        override fun allocate(width: Int, height: Int): J400Buffer {
            val (strideY, capacity) = getStrideWithCapacity(width, height)
            val bufferY = createByteBuffer(capacity)
            return J400Buffer(
                buffer = bufferY,
                planeYJ = PlanePrimitive(strideY, bufferY),
                width = width,
                height = height,
            ) {
                Yuv.freeNativeBuffer(bufferY)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): J400Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (strideY, capacity) = getStrideWithCapacity(width, height)
            val bufferY = buffer.sliceRange(0, capacity)
            return J400Buffer(
                buffer = buffer,
                planeYJ = PlanePrimitive(strideY, bufferY),
                width = width,
                height = height,
                releaseCallback = null,
            )
        }

        fun wrap(planeYJ: Plane, width: Int, height: Int): J400Buffer {
            return J400Buffer(
                buffer = planeYJ.buffer,
                planeYJ = planeYJ,
                width = width,
                height = height,
                releaseCallback = null,
            )
        }


    }
}
