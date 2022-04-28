package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import android.media.Image
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.camera.core.ImageProxy
import java.nio.ByteBuffer

/**
 * J400 (jpeg grey) YUV Format. 4:0:0 8bpp
 */
class J400Buffer private constructor(
    buffer: ByteBuffer?,
    val planeYJ: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable? = null,
) : AbstractBuffer(buffer, arrayOf(planeYJ), releaseCallback) {
    override fun asBitmap(): Bitmap {
        return ArgbBuffer.allocate(width, height).use {
            convertTo(it)
            it.asBitmap()
        }
    }

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            return intArrayOf(width, width * height)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): J400Buffer {
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

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): J400Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (strideY, capacity) = getStrideWithCapacity(width, height)
            val bufferY = buffer.sliceRange(0, capacity)
            return J400Buffer(
                buffer = buffer,
                planeYJ = PlanePrimitive(strideY, bufferY),
                width = width,
                height = height,
                releaseCallback = releaseCallback,
            )
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(planeY: Plane, width: Int, height: Int, releaseCallback: Runnable? = null): J400Buffer {
            return J400Buffer(
                buffer = planeY.buffer,
                planeYJ = planeY,
                width = width,
                height = height,
                releaseCallback = releaseCallback,
            )
        }

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        @JvmStatic
        @JvmName("from")
        fun Image.toJ400Buffer(): J400Buffer {
            val plane = planes[0]
            return J400Buffer(
                buffer = plane.buffer,
                planeYJ = PlaneNative(plane),
                width = width,
                height = height,
            )
        }

        @JvmStatic
        @JvmName("from")
        fun ImageProxy.toJ400Buffer(): J400Buffer {
            val plane = planes[0]
            return J400Buffer(
                buffer = plane.buffer,
                planeYJ = PlaneProxy(plane),
                width = width,
                height = height,
            )
        }
    }
}
