package io.github.crow_misia.libyuv

import java.nio.ByteBuffer
import kotlin.math.min

/**
 * I400 (grey) YUV Format. 4:0:0 8bpp
 */
class I400Buffer private constructor(
    buffer: ByteBuffer?,
    override val planeY: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable?,
) : AbstractBuffer(buffer, arrayOf(planeY), releaseCallback), BufferX400<I400Buffer, I420Buffer>, BufferY<I400Buffer> {
    fun convertTo(dst: Nv21Buffer) {
        Yuv.convertI400ToNV21(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstVU = dst.planeVU.buffer, dstStrideVU = dst.planeVU.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: Nv12Buffer) {
        Yuv.convertI400ToNV21(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstVU = dst.planeUV.buffer, dstStrideVU = dst.planeUV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        Yuv.convertI400ToARGB(
            srcY = planeY.buffer, srcStrideY = planeY.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun setValue(value: Int) {
        planeY.setValue(width, height, value)
    }

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
