@file:JvmMultifileClass

package io.github.crow_misia.libyuv

import kotlin.math.min

/**
 * Rotate Mode
 */
enum class RotateMode(val degrees: Int) {
    ROTATE_0(0),
    ROTATE_90(90),
    ROTATE_180(180),
    ROTATE_270(270),
}

internal fun calculateWidth(src: Buffer, dst: Buffer, rotateMode: RotateMode): Int {
    return when (rotateMode) {
        RotateMode.ROTATE_0, RotateMode.ROTATE_180 -> min(src.width, dst.width)
        RotateMode.ROTATE_90, RotateMode.ROTATE_270 -> min(src.width, dst.height)
    }
}

internal fun calculateHeight(src: Buffer, dst: Buffer, rotateMode: RotateMode): Int {
    return when (rotateMode) {
        RotateMode.ROTATE_0, RotateMode.ROTATE_180 -> min(src.height, dst.height)
        RotateMode.ROTATE_90, RotateMode.ROTATE_270 -> min(src.height, dst.width)
    }
}
