package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import android.media.Image
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.camera.core.ImageProxy
import java.nio.ByteBuffer

/**
 * NV21 YUV Format. 4:2:0 12bpp
 */
class Nv21Buffer private constructor(
    buffer: ByteBuffer?,
    val planeY: Plane,
    val planeVU: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable? = null,
) : AbstractBuffer(buffer, arrayOf(planeY, planeVU), releaseCallback) {
    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val capacityY = width * height
            val capacityVU = (width + 1).shr(1) * height
            return intArrayOf(width, capacityY, width, capacityVU)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): Nv21Buffer {
            val (strideY, capacityY, strideVU, capacityVU) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacityY + capacityVU)
            val (bufferY, bufferVU) = buffer.slice(capacityY, capacityVU)
            return Nv21Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeVU = PlanePrimitive(strideVU, bufferVU),
                width = width,
                height = height,
            ) {
                Yuv.freeNativeBuffer(buffer)
            }
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): Nv21Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (strideY, capacityY, strideVU, capacityVU) = getStrideWithCapacity(width, height)
            val (bufferY, bufferVU) = buffer.slice(capacityY, capacityVU)
            return Nv21Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeVU = PlanePrimitive(strideVU, bufferVU),
                width = width,
                height = height,
                releaseCallback = releaseCallback,
            )
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(planeY: Plane, planeVU: Plane, width: Int, height: Int, releaseCallback: Runnable? = null): Nv21Buffer {
            return Nv21Buffer(
                buffer = null,
                planeY = planeY,
                planeVU = planeVU,
                width = width,
                height = height,
                releaseCallback = releaseCallback,
            )
        }

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        @JvmStatic
        @JvmName("from")
        fun Image.toNv21Buffer(): Nv21Buffer {
            return Nv21Buffer(
                buffer = null,
                planeY = PlaneNative(planes[0]),
                planeVU = PlaneNative(planes[1]),
                width = width,
                height = height,
            )
        }

        @JvmStatic
        @JvmName("from")
        fun ImageProxy.toNv21Buffer(): Nv21Buffer {
            return Nv21Buffer(
                buffer = null,
                planeY = PlaneProxy(planes[0]),
                planeVU = PlaneProxy(planes[1]),
                width = width,
                height = height,
            )
        }
    }
}
