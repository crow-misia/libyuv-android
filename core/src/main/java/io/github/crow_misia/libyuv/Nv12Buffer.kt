package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import android.media.Image
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.camera.core.ImageProxy
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
    releaseCallback: Runnable? = null,
) : AbstractBuffer(buffer, arrayOf(planeY, planeUV), releaseCallback) {
    override fun asBitmap(): Bitmap {
        return AbgrBuffer.allocate(width, height).use {
            convertTo(it)
            it.asBitmap()
        }
    }

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val capacityY = width * height
            val capacityUV = (width + 1).shr(1) * height
            return intArrayOf(width, capacityY, width, capacityUV)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): Nv12Buffer {
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

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): Nv12Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (strideY, capacityY, strideUV, capacityUV) = getStrideWithCapacity(width, height)
            val (bufferY, bufferUV) = buffer.slice(capacityY, capacityUV)
            return Nv12Buffer(
                buffer = buffer,
                planeY = PlanePrimitive(strideY, bufferY),
                planeUV = PlanePrimitive(strideUV, bufferUV),
                width = width,
                height = height,
                releaseCallback = releaseCallback,
            )
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(planeY: Plane, planeUV: Plane, width: Int, height: Int, releaseCallback: Runnable? = null): Nv12Buffer {
            return Nv12Buffer(
                buffer = null,
                planeY = planeY,
                planeUV = planeUV,
                width = width,
                height = height,
                releaseCallback = releaseCallback,
            )
        }

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        @JvmStatic
        @JvmName("from")
        fun Image.toNv12Buffer(): Nv12Buffer {
            return Nv12Buffer(
                buffer = null,
                planeY = PlaneNative(planes[0]),
                planeUV = PlaneNative(planes[1]),
                width = width,
                height = height,
            )
        }

        @JvmStatic
        @JvmName("from")
        fun ImageProxy.toNv12Buffer(): Nv12Buffer {
            return Nv12Buffer(
                buffer = null,
                planeY = PlaneProxy(planes[0]),
                planeUV = PlaneProxy(planes[1]),
                width = width,
                height = height,
            )
        }
    }
}
