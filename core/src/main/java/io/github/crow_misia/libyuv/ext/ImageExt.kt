package io.github.crow_misia.libyuv.ext

import android.media.Image
import android.os.Build
import androidx.annotation.RequiresApi
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
import io.github.crow_misia.libyuv.PlaneNative
import io.github.crow_misia.libyuv.RawBuffer
import io.github.crow_misia.libyuv.Rgb24Buffer
import io.github.crow_misia.libyuv.Rgb565Buffer
import io.github.crow_misia.libyuv.RgbaBuffer
import io.github.crow_misia.libyuv.U420Buffer
import io.github.crow_misia.libyuv.U422Buffer
import io.github.crow_misia.libyuv.U444Buffer
import io.github.crow_misia.libyuv.Yuv24Buffer

@Suppress("unused")
@RequiresApi(Build.VERSION_CODES.KITKAT)
object ImageExt {
    /**
     * Handling Image as ABGR format.
     *
     * @return [AbgrBuffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toAbgrBuffer(): AbgrBuffer {
        val plane = planes[0]
        return AbgrBuffer(
            buffer = plane.buffer,
            plane = PlaneNative(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as ARGB1555 format.
     *
     * @return [Argb1555Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toArgb1555Buffer(): Argb1555Buffer {
        val plane = planes[0]
        return Argb1555Buffer(
            buffer = plane.buffer,
            plane = PlaneNative(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as ARGB4444 format.
     *
     * @return [Argb4444Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toArgb4444Buffer(): Argb4444Buffer {
        val plane = planes[0]
        return Argb4444Buffer(
            buffer = plane.buffer,
            plane = PlaneNative(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as ARGB format.
     *
     * @return [ArgbBuffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toArgbBuffer(): ArgbBuffer {
        val plane = planes[0]
        return ArgbBuffer(
            buffer = plane.buffer,
            plane = PlaneNative(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as BGRA format.
     *
     * @return [BgraBuffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toBgraBuffer(): BgraBuffer {
        val plane = planes[0]
        return BgraBuffer(
            buffer = plane.buffer,
            plane = PlaneNative(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as H420 format.
     *
     * @return [H420Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toH420Buffer(): H420Buffer {
        return H420Buffer(
            buffer = null,
            planeY = PlaneNative(planes[0]),
            planeU = PlaneNative(planes[1]),
            planeV = PlaneNative(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as H422 format.
     *
     * @return [H422Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toH422Buffer(): H422Buffer {
        return H422Buffer(
            buffer = null,
            planeY = PlaneNative(planes[0]),
            planeU = PlaneNative(planes[1]),
            planeV = PlaneNative(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as H444 format.
     *
     * @return [H444Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toH444Buffer(): H444Buffer {
        return H444Buffer(
            buffer = null,
            planeY = PlaneNative(planes[0]),
            planeU = PlaneNative(planes[1]),
            planeV = PlaneNative(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as I400 format.
     *
     * @return [I400Buffer]
     */
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

    /**
     * Handling Image as I420 format.
     *
     * @return [I420Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toI420Buffer(): I420Buffer {
        return I420Buffer(
            buffer = null,
            planeY = PlaneNative(planes[0]),
            planeU = PlaneNative(planes[1]),
            planeV = PlaneNative(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as I422 format.
     *
     * @return [I422Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toI422Buffer(): I422Buffer {
        return I422Buffer(
            buffer = null,
            planeY = PlaneNative(planes[0]),
            planeU = PlaneNative(planes[1]),
            planeV = PlaneNative(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as I444 format.
     *
     * @return [I444Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toI444Buffer(): I444Buffer {
        return I444Buffer(
            buffer = null,
            planeY = PlaneNative(planes[0]),
            planeU = PlaneNative(planes[1]),
            planeV = PlaneNative(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as J400 format.
     *
     * @return [J400Buffer]
     */
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

    /**
     * Handling Image as J420 format.
     *
     * @return [J420Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toJ420Buffer(): J420Buffer {
        return J420Buffer(
            buffer = null,
            planeY = PlaneNative(planes[0]),
            planeU = PlaneNative(planes[1]),
            planeV = PlaneNative(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as J422 format.
     *
     * @return [J422Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toJ422Buffer(): J422Buffer {
        return J422Buffer(
            buffer = null,
            planeY = PlaneNative(planes[0]),
            planeU = PlaneNative(planes[1]),
            planeV = PlaneNative(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as J444 format.
     *
     * @return [J444Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toJ444Buffer(): J444Buffer {
        return J444Buffer(
            buffer = null,
            planeY = PlaneNative(planes[0]),
            planeU = PlaneNative(planes[1]),
            planeV = PlaneNative(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as NV12 format.
     *
     * @return [Nv12Buffer]
     */
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

    /**
     * Handling Image as NV21 format.
     *
     * @return [Nv21Buffer]
     */
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

    /**
     * Handling Image as RAW format.
     *
     * @return [RawBuffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toRawBuffer(): RawBuffer {
        val plane = planes[0]
        return RawBuffer(
            buffer = plane.buffer,
            plane = PlaneNative(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as RGB24 format.
     *
     * @return [Rgb24Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toRgb24Buffer(): Rgb24Buffer {
        val plane = planes[0]
        return Rgb24Buffer(
            buffer = plane.buffer,
            plane = PlaneNative(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as RGB565 format.
     *
     * @return [Rgb565Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toRgb565Buffer(): Rgb565Buffer {
        val plane = planes[0]
        return Rgb565Buffer(
            buffer = plane.buffer,
            plane = PlaneNative(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as RGBA format.
     *
     * @return [RgbaBuffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toRgbaBuffer(): RgbaBuffer {
        val plane = planes[0]
        return RgbaBuffer(
            buffer = plane.buffer,
            plane = PlaneNative(plane),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as U420 format.
     *
     * @return [U420Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toU420Buffer(): U420Buffer {
        return U420Buffer(
            buffer = null,
            planeY = PlaneNative(planes[0]),
            planeU = PlaneNative(planes[1]),
            planeV = PlaneNative(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as U422 format.
     *
     * @return [U422Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toU422Buffer(): U422Buffer {
        return U422Buffer(
            buffer = null,
            planeY = PlaneNative(planes[0]),
            planeU = PlaneNative(planes[1]),
            planeV = PlaneNative(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as U444 format.
     *
     * @return [U444Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toU444Buffer(): U444Buffer {
        return U444Buffer(
            buffer = null,
            planeY = PlaneNative(planes[0]),
            planeU = PlaneNative(planes[1]),
            planeV = PlaneNative(planes[2]),
            width = width,
            height = height,
        )
    }

    /**
     * Handling Image as YUV24 format.
     *
     * @return [Yuv24Buffer]
     */
    @JvmStatic
    @JvmName("from")
    fun Image.toYuv24Buffer(): Yuv24Buffer {
        val plane = planes[0]
        return Yuv24Buffer(
            buffer = plane.buffer,
            plane = PlaneNative(plane),
            width = width,
            height = height,
        )
    }
}
