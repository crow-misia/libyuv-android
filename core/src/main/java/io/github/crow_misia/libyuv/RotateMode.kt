package io.github.crow_misia.libyuv

import kotlin.math.min

/**
 * Rotate Mode
 */
enum class RotateMode(val degrees: Int) {
    ROTATE_0(0),
    ROTATE_90(90),
    ROTATE_180(180),
    ROTATE_270(270);

    internal fun calculateWidth(src: Buffer, dst: Buffer): Int {
        return when (this) {
            ROTATE_0, ROTATE_180 -> min(src.cropRect.width(), dst.cropRect.width())
            ROTATE_90, ROTATE_270 -> min(src.cropRect.width(), dst.cropRect.height())
        }
    }

    internal fun calculateHeight(src: Buffer, dst: Buffer): Int {
        return when (this) {
            ROTATE_0, ROTATE_180 -> min(src.cropRect.height(), dst.cropRect.height())
            ROTATE_90, ROTATE_270 -> min(src.cropRect.height(), dst.cropRect.width())
        }
    }
}
