package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import java.nio.ByteBuffer

interface BitmapConverter {
    fun asBitmap(): Bitmap

    companion object {
        @Suppress("NOTHING_TO_INLINE")
        internal inline fun ByteBuffer.toBitmap(width: Int, height: Int, config: Bitmap.Config): Bitmap {
            return Bitmap.createBitmap(width, height, config).also {
                clear()
                it.copyPixelsFromBuffer(this)
            }
        }
    }
}