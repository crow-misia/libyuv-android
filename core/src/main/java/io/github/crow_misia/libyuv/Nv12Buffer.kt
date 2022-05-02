package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

/**
 * NV12 YUV Format. 4:2:0 12bpp
 */
class Nv12Buffer private constructor(
    buffer: ByteBuffer?,
    val planeY: Plane,
    val planeUV: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, arrayOf(planeY, planeUV), releaseCallback) {
    companion object Factory : BufferFactory<Nv12Buffer> {
        private fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val capacityY = width * height
            val capacityUV = (width + 1).shr(1) * height
            return intArrayOf(width, capacityY, width, capacityUV)
        }

        override fun allocate(width: Int, height: Int): Nv12Buffer {
            val (strideY, capacityY, strideUV, capacityUV) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacityY + capacityUV)
            val (bufferY, bufferUV) = buffer.slice(capacityY, capacityUV)
            return Nv12Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeUV = PlanePrimitive(strideUV, bufferUV),
                width = width,
                height = height,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        override fun wrap(buffer: ByteBuffer, width: Int, height: Int): Nv12Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (strideY, capacityY, strideUV, capacityUV) = getStrideWithCapacity(width, height)
            val (bufferY, bufferUV) = buffer.slice(capacityY, capacityUV)
            return Nv12Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeUV = PlanePrimitive(strideUV, bufferUV),
                width = width,
                height = height,
                releaseCallback = null,
            )
        }

        fun wrap(planeY: Plane, planeUV: Plane, width: Int, height: Int): Nv12Buffer {
            return Nv12Buffer(
                buffer = null,
                planeY = planeY,
                planeUV = planeUV,
                width = width,
                height = height,
                releaseCallback = null,
            )
        }

    }
}
