package io.github.crow_misia.libyuv.ext

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
import io.github.crow_misia.libyuv.PlaneProxy
import io.github.crow_misia.libyuv.RawBuffer
import io.github.crow_misia.libyuv.Rgb24Buffer
import io.github.crow_misia.libyuv.Rgb565Buffer
import io.github.crow_misia.libyuv.RgbaBuffer
import io.github.crow_misia.libyuv.U420Buffer
import io.github.crow_misia.libyuv.U422Buffer
import io.github.crow_misia.libyuv.U444Buffer
import io.github.crow_misia.libyuv.Yuv24Buffer

@Suppress("unused")
object ImageProxyExt {
    /**
     * Handling ImageProxy as ABGR format.
     *
     * @return [Argb1555Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toAbgrBuffer(): AbgrBuffer {
        val plane = planes[0]
        return AbgrBuffer(
            buffer = plane.buffer,
            plane = PlaneProxy(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as ARGB1555 format.
     *
     * @return [Argb1555Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toArgb1555Buffer(): Argb1555Buffer {
        val plane = planes[0]
        return Argb1555Buffer(
            buffer = plane.buffer,
            plane = PlaneProxy(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as ARGB4444 format.
     *
     * @return [Argb4444Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toArgb4444Buffer(): Argb4444Buffer {
        val plane = planes[0]
        return Argb4444Buffer(
            buffer = plane.buffer,
            plane = PlaneProxy(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as ARGB format.
     *
     * @return [ArgbBuffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toArgbBuffer(): ArgbBuffer {
        val plane = planes[0]
        return ArgbBuffer(
            buffer = plane.buffer,
            plane = PlaneProxy(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as BGRA format.
     *
     * @return [BgraBuffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toBgraBuffer(): BgraBuffer {
        val plane = planes[0]
        return BgraBuffer(
            buffer = plane.buffer,
            plane = PlaneProxy(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as H420 format.
     *
     * @return [H420Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toH420Buffer(): H420Buffer {
        return H420Buffer(
            buffer = null,
            planeY = PlaneProxy(planes[0]),
            planeU = PlaneProxy(planes[1]),
            planeV = PlaneProxy(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as H422 format.
     *
     * @return [H420Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toH422Buffer(): H422Buffer {
        return H422Buffer(
            buffer = null,
            planeY = PlaneProxy(planes[0]),
            planeU = PlaneProxy(planes[1]),
            planeV = PlaneProxy(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as H444 format.
     *
     * @return [H444Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toH444Buffer(): H444Buffer {
        return H444Buffer(
            buffer = null,
            planeY = PlaneProxy(planes[0]),
            planeU = PlaneProxy(planes[1]),
            planeV = PlaneProxy(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as I400 format.
     *
     * @return [I400Buffer]
     */
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

    /**
     * Handling ImageProxy as I420 format.
     *
     * @return [I420Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toI420Buffer(): I420Buffer {
        return I420Buffer(
            buffer = null,
            planeY = PlaneProxy(planes[0]),
            planeU = PlaneProxy(planes[1]),
            planeV = PlaneProxy(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as I422 format.
     *
     * @return [I422Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toI422Buffer(): I422Buffer {
        return I422Buffer(
            buffer = null,
            planeY = PlaneProxy(planes[0]),
            planeU = PlaneProxy(planes[1]),
            planeV = PlaneProxy(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as I444 format.
     *
     * @return [I444Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toI444Buffer(): I444Buffer {
        return I444Buffer(
            buffer = null,
            planeY = PlaneProxy(planes[0]),
            planeU = PlaneProxy(planes[1]),
            planeV = PlaneProxy(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as J400 format.
     *
     * @return [J400Buffer]
     */
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

    /**
     * Handling ImageProxy as J420 format.
     *
     * @return [J420Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toJ420Buffer(): J420Buffer {
        return J420Buffer(
            buffer = null,
            planeY = PlaneProxy(planes[0]),
            planeU = PlaneProxy(planes[1]),
            planeV = PlaneProxy(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as J422 format.
     *
     * @return [J422Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toJ422Buffer(): J422Buffer {
        return J422Buffer(
            buffer = null,
            planeY = PlaneProxy(planes[0]),
            planeU = PlaneProxy(planes[1]),
            planeV = PlaneProxy(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as J444 format.
     *
     * @return [J444Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toJ444Buffer(): J444Buffer {
        return J444Buffer(
            buffer = null,
            planeY = PlaneProxy(planes[0]),
            planeU = PlaneProxy(planes[1]),
            planeV = PlaneProxy(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as NV12 format.
     *
     * @return [Nv12Buffer]
     */
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

    /**
     * Handling ImageProxy as NV21 format.
     *
     * @return [Nv21Buffer]
     */
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

    /**
     * Handling ImageProxy as RAW format.
     *
     * @return [RawBuffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toRawBuffer(): RawBuffer {
        val plane = planes[0]
        return RawBuffer(
            buffer = plane.buffer,
            plane = PlaneProxy(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as RGB24 format.
     *
     * @return [Rgb24Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toRgb24Buffer(): Rgb24Buffer {
        val plane = planes[0]
        return Rgb24Buffer(
            buffer = plane.buffer,
            plane = PlaneProxy(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as RGB565 format.
     *
     * @return [Rgb565Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toRgb565Buffer(): Rgb565Buffer {
        val plane = planes[0]
        return Rgb565Buffer(
            buffer = plane.buffer,
            plane = PlaneProxy(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as RGBA format.
     *
     * @return [RgbaBuffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toRgbaBuffer(): RgbaBuffer {
        val plane = planes[0]
        return RgbaBuffer(
            buffer = plane.buffer,
            plane = PlaneProxy(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as U420 format.
     *
     * @return [U420Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toU420Buffer(): U420Buffer {
        return U420Buffer(
            buffer = null,
            planeY = PlaneProxy(planes[0]),
            planeU = PlaneProxy(planes[1]),
            planeV = PlaneProxy(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as U422 format.
     *
     * @return [U422Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toU422Buffer(): U422Buffer {
        return U422Buffer(
            buffer = null,
            planeY = PlaneProxy(planes[0]),
            planeU = PlaneProxy(planes[1]),
            planeV = PlaneProxy(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as U444 format.
     *
     * @return [U444Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toU444Buffer(): U444Buffer {
        return U444Buffer(
            buffer = null,
            planeY = PlaneProxy(planes[0]),
            planeU = PlaneProxy(planes[1]),
            planeV = PlaneProxy(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling ImageProxy as YUV24 format.
     *
     * @return [Yuv24Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun ImageProxy.toYuv24Buffer(): Yuv24Buffer {
        val plane = planes[0]
        return Yuv24Buffer(
            buffer = plane.buffer,
            plane = PlaneProxy(plane),
            width = width,
            height = height,
        )
    }
}
