package io.github.crow_misia.libyuv

import java.io.Closeable
import java.nio.Buffer

interface Buffer : Closeable, BitmapConverter {
    val width: Int

    val height: Int

    fun asBuffer(): Buffer

    fun asByteArray(): ByteArray

    fun asByteArray(dst: ByteArray)

    @Deprecated("delete")
    fun retain()

    @Deprecated(message = "replace close method", replaceWith = ReplaceWith("close()"))
    fun release() = close()
}