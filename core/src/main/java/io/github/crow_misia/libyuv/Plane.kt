@file:Suppress("unused")

package io.github.crow_misia.libyuv

import android.media.Image
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.camera.core.ImageProxy
import java.nio.ByteBuffer

sealed interface Plane {
    val rowStride: Int
    val buffer: ByteBuffer

    companion object {
        @RequiresApi(Build.VERSION_CODES.KITKAT)
        @JvmStatic
        @JvmName("from")
        fun Image.Plane.asPlane(): Plane {
            return PlaneNative(this)
        }

        @JvmStatic
        @JvmName("from")
        fun ImageProxy.PlaneProxy.asPlane(): Plane {
            return PlaneProxy(this)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
internal class PlaneNative(
    private val plane: Image.Plane,
) : Plane {
    override val buffer: ByteBuffer
        get() = plane.buffer
    override val rowStride: Int
        get() = plane.rowStride
}

internal class PlaneProxy(
    private val proxy: ImageProxy.PlaneProxy,
) : Plane {
    override val buffer: ByteBuffer
        get() = proxy.buffer
    override val rowStride: Int
        get() = proxy.rowStride
}

internal class PlanePrimitive(
    override val rowStride: Int,
    override val buffer: ByteBuffer,
) : Plane
