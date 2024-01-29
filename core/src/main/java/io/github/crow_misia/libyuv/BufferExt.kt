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

internal fun createByteBuffer(capacities: List<Capacity>): Array<ByteBuffer> {
    check(capacities.isNotEmpty())

    val whole = Yuv.allocNativeBuffer(capacities.sumOf { it.value })
    return whole.sliceByLength(capacities)
}

internal fun ByteBuffer.sliceRange(offset: Int, length: Int): ByteBuffer {
    execute { _, _ ->
        position(offset)
        limit(offset + length)

        return slice()
    }
}

internal fun ByteBuffer.sliceByLength(capacities: List<Capacity>): Array<ByteBuffer> {
    check(capacities.isNotEmpty())

    execute { _, limit ->
        var offset = 0
        var index = 0
        val num = capacities.size
        val results = arrayOfNulls<ByteBuffer>(num + 1)
        capacities.forEach { sliceLength ->
            position(offset)
            offset += sliceLength.value
            limit(offset)
            results[index++] = slice()
        }
        check(offset <= limit) { "buffer limit is bigger than expected" }

        results[index] = this
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
