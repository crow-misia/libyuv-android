package io.github.crow_misia.libyuv

/**
 * Filter Mode
 */
enum class FilterMode(val mode: Int) {
    NONE(0),
    LINEAR(1),
    BILINEAR(2),
    BOX(3)
}