package io.github.crow_misia.libyuv

fun interface OffsetCalculator {
    fun calculate(left: Int, top: Int, rowStride: RowStride): Int
}
