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

    /**
     * Get as ByteBuffer.
     */
    fun asBuffer(): ByteBuffer

    /**
     * Get as Byte Array.
     */
    fun asByteArray(): ByteArray

    /**
     * Get as Byte Array.
     *
     * @param dst destination Byte Array
     * @return output data size
     */
    fun asByteArray(dst: ByteArray): Int

    /**
     * Write image data.
     *
     * @param dst destination OutputStream
     * @return output data size
     */
    fun write(dst: OutputStream): Int

    /**
     * Write image data.
     *
     * @param buffer destination ByteBuffer
     */
    fun write(dst: ByteBuffer)
}
