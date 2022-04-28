package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import android.media.Image
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.camera.core.ImageProxy
import java.nio.ByteBuffer

/**
 * I400 (grey) YUV Format. 4:0:0 8bpp
 */
class I400Buffer private constructor(
    buffer: ByteBuffer?,
    val planeY: Plane,
    override val width: Int,
    override val height: Int,
    releaseCallback: Runnable? = null,
) : AbstractBuffer(buffer, arrayOf(planeY), releaseCallback) {
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
        fun allocate(width: Int, height: Int): I400Buffer {
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

        @JvmStatic
        @JvmOverloads
        fun wrap(buffer: ByteBuffer, width: Int, height: Int, releaseCallback: Runnable? = null): I400Buffer {
            check(buffer.isDirect) { "Unsupported non-direct ByteBuffer." }

            val (strideY, capacity) = getStrideWithCapacity(width, height)
            val bufferY = buffer.sliceRange(0, capacity)
            return I400Buffer(
                buffer = bufferY,
                planeY = PlanePrimitive(strideY, bufferY),
                width = width,
                height = height,
                releaseCallback = releaseCallback,
            )
        }

        @JvmStatic
        @JvmOverloads
        fun wrap(planeY: Plane, width: Int, height: Int, releaseCallback: Runnable? = null): I400Buffer {
            return I400Buffer(
                buffer = planeY.buffer,
                planeY = planeY,
                width = width,
                height = height,
                releaseCallback = releaseCallback,
            )
        }

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        @JvmStatic
        @JvmName("from")
        fun Image.toI400Buffer(): I400Buffer {
            val plane = planes[0]
            return I400Buffer(
                buffer = plane.buffer,
                planeY = PlaneNative(plane),
                width = width,
                height = height,
            )
        }

        @JvmStatic
        @JvmName("from")
        fun ImageProxy.toI400Buffer(): I400Buffer {
            val plane = planes[0]
            return I400Buffer(
                buffer = plane.buffer,
                planeY = PlaneProxy(plane),
                width = width,
                height = height,
            )
        }
    }
}
