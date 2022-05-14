package io.github.crow_misia.libyuv

import java.io.ByteArrayOutputStream
import java.io.Closeable
import java.io.OutputStream
import java.nio.ByteBuffer

interface Buffer : Closeable {
    /**
     * Planes.
     */
    val planes: Array<Plane>

    /**
     * Image width.
     */
    val width: Int

    /**
     * Image height.
     */
    val height: Int

    fun asBuffer(): ByteBuffer
    fun asByteArray(): ByteArray
    fun asByteArray(dst: ByteArray)
    fun write(stream: OutputStream)
    fun write(buffer: ByteBuffer)
}
