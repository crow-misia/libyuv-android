package io.github.crow_misia.libyuv

interface Buffer {
    val width: Int

    val height: Int

    fun asByteArray(): ByteArray

    fun asByteArray(dst: ByteArray)

    fun retain()

    fun release()
}