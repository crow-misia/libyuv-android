package io.github.zncmn.libyuv

import java.nio.ByteBuffer

/**
 * RGB12 (R444 fourcc) little endian
 */
class Argb4444Buffer private constructor(
    val bufferARGB4444: ByteBuffer,

    internal val strideARGB4444: Int,

    override val width: Int,
    override val height: Int
) : Buffer {
    override fun asByteArray() = bufferARGB4444.asByteArray()
    override fun asByteArray(dst: ByteArray) = bufferARGB4444.asByteArray(dst)

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width.shl(1)
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): Argb4444Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return Argb4444Buffer(buffer, stride, width, height)
        }

        @JvmStatic
        fun wrap(buffer: ByteBuffer, width: Int, height: Int): Argb4444Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            return Argb4444Buffer(buffer.sliceRange(0, capacity), stride, width, height)
        }
    }
}