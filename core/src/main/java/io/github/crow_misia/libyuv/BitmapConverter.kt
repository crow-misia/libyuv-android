package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import java.nio.ByteBuffer

interface BitmapConverter {
    fun asBitmap(): Bitmap
}
