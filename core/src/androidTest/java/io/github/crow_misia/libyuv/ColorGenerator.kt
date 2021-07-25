package io.github.crow_misia.libyuv

import android.graphics.*

class ColorGenerator(
    val steps: Int,
    initialHue: Float = 0.0f,
) {
    private val hueStep: Float = 360F / steps
    private var currentHue = initialHue

    fun nextColor(): Int {
        val hsv = floatArrayOf(currentHue, 1.0F, 1.0F)
        currentHue = (currentHue + hueStep) % 360F
        return Color.HSVToColor(255, hsv)
    }
}