package io.github.zncmn.libyuv

import java.nio.ByteBuffer

internal fun ByteBuffer.asByteArray(): ByteArray {
    val capacity = capacity()
    val results = ByteArray(capacity)
    val srcObj: Any = if (isDirect) this else array()

    Yuv.memcopy(results, srcObj, capacity)
    return results
}

internal fun ByteBuffer.asByteArray(dst: ByteArray) {
    val capacity = capacity()
    val srcObj: Any = if (isDirect) this else array()
    assert(dst.size >= capacity) { "dst size is less than capacity" }

    Yuv.memcopy(dst, srcObj, capacity)
}

internal fun createByteBuffer(capacity: Int): ByteBuffer {
    return ByteBuffer.allocateDirect(capacity)
}

internal fun ByteBuffer.sliceRange(offset: Int, length: Int): ByteBuffer {
    limit(offset + length)
    position(offset)

    val result = slice()
    clear()

    return result
}

internal fun ByteBuffer.slice(vararg sliceLengths: Int): Array<ByteBuffer> {
    clear()
    limit(0)
    val results = arrayOfNulls<ByteBuffer>(sliceLengths.size)
    for (i in sliceLengths.indices) {
        val sliceLength = sliceLengths[i]
        position(limit())
        limit(limit() + sliceLength)
        results[i] = slice()
    }
    assert(capacity() == limit()) { "buffer capacity is bigger than expected" }
    clear()
    return results.requireNoNulls()
}

@Suppress("NOTHING_TO_INLINE")
internal inline operator fun IntArray.component6() = this[5]
