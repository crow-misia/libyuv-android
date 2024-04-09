package io.github.crow_misia.libyuv.ext

import android.media.Image
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
import io.github.crow_misia.libyuv.Yuv24Buffer
import io.github.crow_misia.libyuv.asPlane

@Suppress("unused")
object ImageExt {
    /**
     * Handling Image as ABGR format.
     *
     * @return [AbgrBuffer]
     */
    @JvmStatic
    fun Image.toAbgrBuffer(): AbgrBuffer {
        val plane = planes[0]
        return AbgrBuffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling Image as ARGB1555 format.
     *
     * @return [Argb1555Buffer]
     */
    @JvmStatic
    fun Image.toArgb1555Buffer(): Argb1555Buffer {
        val plane = planes[0]
        return Argb1555Buffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling Image as ARGB4444 format.
     *
     * @return [Argb4444Buffer]
     */
    @JvmStatic
    fun Image.toArgb4444Buffer(): Argb4444Buffer {
        val plane = planes[0]
        return Argb4444Buffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling Image as ARGB format.
     *
     * @return [ArgbBuffer]
     */
    @JvmStatic
    fun Image.toArgbBuffer(): ArgbBuffer {
        val plane = planes[0]
        return ArgbBuffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling Image as BGRA format.
     *
     * @return [BgraBuffer]
     */
    @JvmStatic
    fun Image.toBgraBuffer(): BgraBuffer {
        val plane = planes[0]
        return BgraBuffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling Image as H420 format.
     *
     * @return [H420Buffer]
     */
    @JvmStatic
    fun Image.toH420Buffer(): H420Buffer {
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
     * Handling Image as H422 format.
     *
     * @return [H422Buffer]
     */
    @JvmStatic
    fun Image.toH422Buffer(): H422Buffer {
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
     * Handling Image as H444 format.
     *
     * @return [H444Buffer]
     */
    @JvmStatic
    fun Image.toH444Buffer(): H444Buffer {
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
     * Handling Image as I400 format.
     *
     * @return [I400Buffer]
     */
    @JvmStatic
    fun Image.toI400Buffer(): I400Buffer {
        val plane = planes[0]
        return I400Buffer.wrap(
            planeY = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling Image as I420 format.
     *
     * @return [I420Buffer]
     */
    @JvmStatic
    fun Image.toI420Buffer(): I420Buffer {
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
     * Handling Image as I422 format.
     *
     * @return [I422Buffer]
     */
    @JvmStatic
    fun Image.toI422Buffer(): I422Buffer {
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
     * Handling Image as I444 format.
     *
     * @return [I444Buffer]
     */
    @JvmStatic
    fun Image.toI444Buffer(): I444Buffer {
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
     * Handling Image as J400 format.
     *
     * @return [J400Buffer]
     */
    @JvmStatic
    fun Image.toJ400Buffer(): J400Buffer {
        val plane = planes[0]
        return J400Buffer.wrap(
            planeY = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling Image as J420 format.
     *
     * @return [J420Buffer]
     */
    @JvmStatic
    fun Image.toJ420Buffer(): J420Buffer {
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
     * Handling Image as J422 format.
     *
     * @return [J422Buffer]
     */
    @JvmStatic
    fun Image.toJ422Buffer(): J422Buffer {
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
     * Handling Image as J444 format.
     *
     * @return [J444Buffer]
     */
    @JvmStatic
    fun Image.toJ444Buffer(): J444Buffer {
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
     * Handling Image as NV12 format.
     *
     * @return [Nv12Buffer]
     */
    @JvmStatic
    fun Image.toNv12Buffer(): Nv12Buffer {
        return Nv12Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeUV = planes[1].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling Image as NV21 format.
     *
     * @return [Nv21Buffer]
     */
    @JvmStatic
    fun Image.toNv21Buffer(): Nv21Buffer {
        return Nv21Buffer.wrap(
            planeY = planes[0].asPlane(),
            planeVU = planes[1].asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling Image as RAW format.
     *
     * @return [RawBuffer]
     */
    @JvmStatic
    fun Image.toRawBuffer(): RawBuffer {
        val plane = planes[0]
        return RawBuffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling Image as RGB24 format.
     *
     * @return [Rgb24Buffer]
     */
    @JvmStatic
    fun Image.toRgb24Buffer(): Rgb24Buffer {
        val plane = planes[0]
        return Rgb24Buffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling Image as RGB565 format.
     *
     * @return [Rgb565Buffer]
     */
    @JvmStatic
    fun Image.toRgb565Buffer(): Rgb565Buffer {
        val plane = planes[0]
        return Rgb565Buffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling Image as RGBA format.
     *
     * @return [RgbaBuffer]
     */
    @JvmStatic
    fun Image.toRgbaBuffer(): RgbaBuffer {
        val plane = planes[0]
        return RgbaBuffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }

    /**
     * Handling Image as U420 format.
     *
     * @return [U420Buffer]
     */
    @JvmStatic
    fun Image.toU420Buffer(): U420Buffer {
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
     * Handling Image as U422 format.
     *
     * @return [U422Buffer]
     */
    @JvmStatic
    fun Image.toU422Buffer(): U422Buffer {
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
     * Handling Image as U444 format.
     *
     * @return [U444Buffer]
     */
    @JvmStatic
    fun Image.toU444Buffer(): U444Buffer {
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
     * Handling Image as YUV24 format.
     *
     * @return [Yuv24Buffer]
     */
    @JvmStatic
    fun Image.toYuv24Buffer(): Yuv24Buffer {
        val plane = planes[0]
        return Yuv24Buffer.wrap(
            plane = plane.asPlane(),
            width = width,
            height = height,
            cropRect = cropRect,
        )
    }
}
