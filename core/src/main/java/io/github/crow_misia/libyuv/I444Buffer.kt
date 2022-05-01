package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

/**
 * I444 (BT.601) YUV Format. 4:4:4 24bpp
 */
class I444Buffer private constructor(
    buffer: ByteBuffer?,
    val planeY: Plane,
    val planeU: Plane,
    val planeV: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable? = null,
) : AbstractBuffer(buffer, arrayOf(planeY, planeU, planeV), releaseCallback) {
    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val capacity = width * height
            return intArrayOf(width, capacity, width, capacity, width, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): I444Buffer {
            val (strideY, capacityY, strideU, capacityU, strideV, capacityV) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacityY + capacityU + capacityV)
            val (bufferY, bufferU, bufferV) = buffer.slice(capacityY, capacityU, capacityV)
            return I444Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeU = PlanePrimitive(strideU, bufferU),
                planeV = PlanePrimitive(strideV, bufferV),
                width = width,
                height = height,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): I444Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (strideY, capacityY, strideU, capacityU, strideV, capacityV) = getStrideWithCapacity(width, height)
            val (bufferY, bufferU, bufferV) = buffer.slice(capacityY, capacityU, capacityV)
            return I444Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeU = PlanePrimitive(strideU, bufferU),
                planeV = PlanePrimitive(strideV, bufferV),
                width = width,
                height = height,
                releaseCallback = releaseCallback,
            )
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(planeY: Plane, planeU: Plane, planeV: Plane, width: Int, height: Int, releaseCallback: Runnable? = null): I444Buffer {
            return I444Buffer(
                buffer = null,
                planeY = planeY,
                planeU = planeU,
                planeV = planeV,
                width = width,
                height = height,
                releaseCallback = releaseCallback,
            )
        }
    }
}
