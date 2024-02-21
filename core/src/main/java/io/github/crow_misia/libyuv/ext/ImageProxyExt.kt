package io.github.crow_misia.libyuv.ext

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.camera.core.ImageProxy
import io.github.crow_misia.libyuv.AbgrBuffer
import io.github.crow_misia.libyuv.Argb1555Buffer
import io.github.crow_misia.libyuv.Argb4444Buffer
import io.github.crow_misia.libyuv.ArgbBuffer
import io.github.crow_misia.libyuv.BgraBuffer
import io.github.crow_misia.libyuv.H420Buffer
import io.github.crow_misia.libyuv.H422Buffer
import io.github.crow_misia.libyuv.H444Buffer
import io.github.crow_misia.libyuv.I400Buffer
import io.github.crow_misia.libyuv.I420Buffer
import io.github.crow_misia.libyuv.I422Buffer
import io.github.crow_misia.libyuv.I444Buffer
import io.github.crow_misia.libyuv.J400Buffer
import io.github.crow_misia.libyuv.J420Buffer
import io.github.crow_misia.libyuv.J422Buffer
import io.github.crow_misia.libyuv.J444Buffer
import io.github.crow_misia.libyuv.Nv12Buffer
import io.github.crow_misia.libyuv.Nv21Buffer
import io.github.crow_misia.libyuv.RawBuffer
import io.github.crow_misia.libyuv.Rgb24Buffer
import io.github.crow_misia.libyuv.Rgb565Buffer
import io.github.crow_misia.libyuv.RgbaBuffer
import io.github.crow_misia.libyuv.U420Buffer
import io.github.crow_misia.libyuv.U422Buffer
import io.github.crow_misia.libyuv.U444Buffer
import io.github.crow_misia.libyuv.UyvyBuffer
import io.github.crow_misia.libyuv.Yuv24Buffer
import io.github.crow_misia.libyuv.asPlane

@Suppress("unused")
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
object ImageProxyExt {
    /**
     * Handling ImageProxy as ABGR format.
     *
     * @return [Argb1555Buffer]
     */
    @JvmStatic
    fun ImageProxy.toAbgrBuffer(): AbgrBuffer {
        val plane = planes[0]
        return AbgrBuffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as ARGB1555 format.
     *
     * @return [Argb1555Buffer]
     */
    @JvmStatic
    fun ImageProxy.toArgb1555Buffer(): Argb1555Buffer {
        val plane = planes[0]
        return Argb1555Buffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as ARGB4444 format.
     *
     * @return [Argb4444Buffer]
     */
    @JvmStatic
    fun ImageProxy.toArgb4444Buffer(): Argb4444Buffer {
        val plane = planes[0]
        return Argb4444Buffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as ARGB format.
     *
     * @return [ArgbBuffer]
     */
    @JvmStatic
    fun ImageProxy.toArgbBuffer(): ArgbBuffer {
        val plane = planes[0]
        return ArgbBuffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as BGRA format.
     *
     * @return [BgraBuffer]
     */
    @JvmStatic
    fun ImageProxy.toBgraBuffer(): BgraBuffer {
        val plane = planes[0]
        return BgraBuffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as H420 format.
     *
     * @return [H420Buffer]
     */
    @JvmStatic
    fun ImageProxy.toH420Buffer(): H420Buffer {
        return H420Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeU = planes[1].asPlane(),
            planeV = planes[2].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as H422 format.
     *
     * @return [H420Buffer]
     */
    @JvmStatic
    fun ImageProxy.toH422Buffer(): H422Buffer {
        return H422Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeU = planes[1].asPlane(),
            planeV = planes[2].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as H444 format.
     *
     * @return [H444Buffer]
     */
    @JvmStatic
    fun ImageProxy.toH444Buffer(): H444Buffer {
        return H444Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeU = planes[1].asPlane(),
            planeV = planes[2].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as I400 format.
     *
     * @return [I400Buffer]
     */
    @JvmStatic
    fun ImageProxy.toI400Buffer(): I400Buffer {
        val plane = planes[0]
        return I400Buffer.wrap(
            planeY = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as I420 format.
     *
     * @return [I420Buffer]
     */
    @JvmStatic
    fun ImageProxy.toI420Buffer(): I420Buffer {
        return I420Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeU = planes[1].asPlane(),
            planeV = planes[2].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as I422 format.
     *
     * @return [I422Buffer]
     */
    @JvmStatic
    fun ImageProxy.toI422Buffer(): I422Buffer {
        return I422Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeU = planes[1].asPlane(),
            planeV = planes[2].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as I444 format.
     *
     * @return [I444Buffer]
     */
    @JvmStatic
    fun ImageProxy.toI444Buffer(): I444Buffer {
        return I444Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeU = planes[1].asPlane(),
            planeV = planes[2].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as J400 format.
     *
     * @return [J400Buffer]
     */
    @JvmStatic
    fun ImageProxy.toJ400Buffer(): J400Buffer {
        val plane = planes[0]
        return J400Buffer.wrap(
            planeYJ = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as J420 format.
     *
     * @return [J420Buffer]
     */
    @JvmStatic
    fun ImageProxy.toJ420Buffer(): J420Buffer {
        return J420Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeU = planes[1].asPlane(),
            planeV = planes[2].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as J422 format.
     *
     * @return [J422Buffer]
     */
    @JvmStatic
    fun ImageProxy.toJ422Buffer(): J422Buffer {
        return J422Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeU = planes[1].asPlane(),
            planeV = planes[2].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as J444 format.
     *
     * @return [J444Buffer]
     */
    @JvmStatic
    fun ImageProxy.toJ444Buffer(): J444Buffer {
        return J444Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeU = planes[1].asPlane(),
            planeV = planes[2].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as NV12 format.
     *
     * @return [Nv12Buffer]
     */
    @JvmStatic
    fun ImageProxy.toNv12Buffer(): Nv12Buffer {
        return Nv12Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeUV = planes[1].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as NV21 format.
     *
     * @return [Nv21Buffer]
     */
    @JvmStatic
    fun ImageProxy.toNv21Buffer(): Nv21Buffer {
        return Nv21Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeVU = planes[1].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as RAW format.
     *
     * @return [RawBuffer]
     */
    @JvmStatic
    fun ImageProxy.toRawBuffer(): RawBuffer {
        val plane = planes[0]
        return RawBuffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as RGB24 format.
     *
     * @return [Rgb24Buffer]
     */
    @JvmStatic
    fun ImageProxy.toRgb24Buffer(): Rgb24Buffer {
        val plane = planes[0]
        return Rgb24Buffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as RGB565 format.
     *
     * @return [Rgb565Buffer]
     */
    @JvmStatic
    fun ImageProxy.toRgb565Buffer(): Rgb565Buffer {
        val plane = planes[0]
        return Rgb565Buffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as RGBA format.
     *
     * @return [RgbaBuffer]
     */
    @JvmStatic
    fun ImageProxy.toRgbaBuffer(): RgbaBuffer {
        val plane = planes[0]
        return RgbaBuffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as U420 format.
     *
     * @return [U420Buffer]
     */
    @JvmStatic
    fun ImageProxy.toU420Buffer(): U420Buffer {
        return U420Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeU = planes[1].asPlane(),
            planeV = planes[2].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as U422 format.
     *
     * @return [U422Buffer]
     */
    @JvmStatic
    fun ImageProxy.toU422Buffer(): U422Buffer {
        return U422Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeU = planes[1].asPlane(),
            planeV = planes[2].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as U444 format.
     *
     * @return [U444Buffer]
     */
    @JvmStatic
    fun ImageProxy.toU444Buffer(): U444Buffer {
        return U444Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeU = planes[1].asPlane(),
            planeV = planes[2].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as U444 format.
     *
     * @return [U444Buffer]
     */
    @JvmStatic
    fun ImageProxy.toUyvyBuffer(): UyvyBuffer {
        return UyvyBuffer.wrap(
            plane = planes[0].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling ImageProxy as YUV24 format.
     *
     * @return [Yuv24Buffer]
     */
    @JvmStatic
    fun ImageProxy.toYuv24Buffer(): Yuv24Buffer {
        val plane = planes[0]
        return Yuv24Buffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }
}
