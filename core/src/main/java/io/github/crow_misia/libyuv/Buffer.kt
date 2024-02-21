package io.github.crow_misia.libyuv

import android.graphics.Rect
import androidx.annotation.RestrictTo
import java.io.Closeable
import java.io.OutputStream
import java.nio.ByteBuffer

interface Buffer : Closeable {
    /**
     * Planes.
     */
    val planes: Array<Plane>

    /**
     * Image width.
     */
    val width: Int

    /**
     * Image height.
     */
    val height: Int

    /**
     * Image crop rectangle.
     */
    val cropRect: Rect

    /**
     * Get as ByteBuffer.
     */
    fun asBuffer(): ByteBuffer

    /**
     * Get as Byte Array.
     */
    fun asByteArray(): ByteArray

    /**
     * Get as Byte Array.
     *
     * @param dst destination Byte Array
     * @return output data size
     */
    fun asByteArray(dst: ByteArray): Int

    /**
     * Write image data.
     *
     * @param dst destination OutputStream
     * @return output data size
     */
    fun write(dst: OutputStream): Int

    /**
     * Write image data.
     *
     * @param dst destination ByteBuffer
     */
    fun write(dst: ByteBuffer)

    @RestrictTo(RestrictTo.Scope.LIBRARY)
    fun getPlaneOffset(planeIndex: Int, rowStride: RowStride, left: Int, top: Int): Int
}

internal fun minWidth(width: Int, vararg other: Rect): Int {
    var min = width
    for (e in other) {
        min = minOf(min, e.width())
    }
    return min
}

internal fun minHeight(height: Int, vararg other: Rect): Int {
    var min = height
    for (e in other) min = minOf(min, e.height())
    return min
}

internal fun Buffer.calculateSize(dst: Buffer): Pair<Int, Int> {
    return Pair(
        minWidth(cropRect, dst.cropRect),
        minHeight(cropRect, dst.cropRect),
    )
}

internal fun Buffer.minWidth(vararg other: Rect): Int {
    return minWidth(cropRect.width(), *other)
}

internal fun Buffer.minHeight(vararg other: Rect): Int {
    return minHeight(cropRect.height(), *other)
}

internal fun Buffer.offset(planeIndex: Int): Int {
    return planes[planeIndex].offset(this, planeIndex)
}
