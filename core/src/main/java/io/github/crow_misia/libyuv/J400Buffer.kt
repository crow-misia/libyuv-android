package io.github.crow_misia.libyuv

import java.nio.ByteBuffer
import kotlin.math.min

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
    fun convertTo(dst: J400Buffer) {
        Yuv.convertI400Copy(
            srcY = planeYJ.buffer, srcStrideY = planeYJ.rowStride,
            dstY = dst.planeYJ.buffer, dstStrideY = dst.planeYJ.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: J420Buffer) {
        Yuv.convertI400ToI420(
            srcY = planeYJ.buffer, srcStrideY = planeYJ.rowStride,
            dstY = dst.planeY.buffer, dstStrideY = dst.planeY.rowStride,
            dstU = dst.planeU.buffer, dstStrideU = dst.planeU.rowStride,
            dstV = dst.planeV.buffer, dstStrideV = dst.planeV.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun convertTo(dst: ArgbBuffer) {
        Yuv.convertJ400ToARGB(
            srcY = planeYJ.buffer, srcStrideY = planeYJ.rowStride,
            dstARGB = dst.plane.buffer, dstStrideARGB = dst.plane.rowStride,
            width = min(width, dst.width), height = min(height, dst.height),
        )
    }

    fun rotate(dst: J400Buffer, rotateMode: RotateMode) {
        Yuv.rotateRotatePlane(
            src = planeYJ.buffer, srcStride = planeYJ.rowStride,
            dst = dst.planeYJ.buffer, dstStride = dst.planeYJ.rowStride,
            width = calculateWidth(this, dst, rotateMode),
            height = calculateHeight(this, dst, rotateMode),
            rotateMode = rotateMode.degrees,
        )
    }

    fun scale(dst: J400Buffer, filterMode: FilterMode) {
        Yuv.scaleScalePlane(
            src = planeYJ.buffer, srcStride = planeYJ.rowStride,
            srcWidth = width, srcHeight = height,
            dst = dst.planeYJ.buffer, dstStride = dst.planeYJ.rowStride,
            dstWidth = dst.width, dstHeight = dst.height,
            filterMode = filterMode.mode,
        )
    }

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
