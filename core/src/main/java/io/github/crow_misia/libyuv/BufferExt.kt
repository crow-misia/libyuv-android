package io.github.crow_misia.libyuv

import android.graphics.Bitmap
import java.nio.ByteBuffer

internal fun ByteBuffer.toBitmap(width: Int, height: Int, config: Bitmap.Config): Bitmap {
    return Bitmap.createBitmap(width, height, config).also {
        position(0)
        it.copyPixelsFromBuffer(this)
    }
}

internal fun ByteBuffer.copy(dst: ByteArray, dstOffset: Int = 0, srcOffset: Int = 0, length: Int = limit()) {
    val srcObj: Any = if (isDirect) this else array()
    check(dst.size >= length) { "dst size is less than length" }

    Yuv.memcopy(dst, dstOffset, srcObj, srcOffset, length)
}

internal fun createByteBuffer(capacity: Int): ByteBuffer {
    return Yuv.allocNativeBuffer(capacity)
}

internal fun ByteBuffer.sliceRange(offset: Int, length: Int): ByteBuffer {
    execute { _, _ ->
        position(offset)
        limit(offset + length)

        return slice()
    }
}

internal fun ByteBuffer.slice(vararg sliceLengths: Int): Array<ByteBuffer> {
    execute { _, limit ->
        var offset = 0
        val results = arrayOfNulls<ByteBuffer>(sliceLengths.size)
        sliceLengths.forEachIndexed { i, sliceLength ->
            position(offset)
            offset += sliceLength
            limit(offset)
            results[i] = slice()
        }
        check(offset <= limit) { "buffer limit is bigger than expected" }

        return results.requireNoNulls()
    }
}

internal inline fun <T> ByteBuffer.execute(func: (position: Int, limit: Int) -> T): T {
    // backup
    val previousPosition = position()
    val previousLimit = limit()

    try {
        return func(previousPosition, previousLimit)
    } finally {
        // restore
        position(previousPosition)
        limit(previousLimit)
    }
}

@Suppress("NOTHING_TO_INLINE")
internal inline operator fun IntArray.component6() = this[5]
