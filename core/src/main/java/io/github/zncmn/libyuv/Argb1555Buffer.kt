package io.github.zncmn.libyuv

import java.nio.ByteBuffer

/**
 * RGB15 (RGBO fourcc) little endian
 */
class Argb1555Buffer private constructor(
    val bufferARGB1555: ByteBuffer,

    internal val strideARGB1555: Int,

    override val width: Int,
    override val height: Int
) : Buffer {
    override fun asByteArray() = bufferARGB1555.asByteArray()
    override fun asByteArray(dst: ByteArray) = bufferARGB1555.asByteArray(dst)

    companion object {
        @JvmStatic
        fun getStrideWithCapacity(width: Int, height: Int): IntArray {
            val stride = width.shl(1)
            val capacity = stride * height
            return intArrayOf(stride, capacity)
        }

        @JvmStatic
        fun allocate(width: Int, height: Int): Argb1555Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            val buffer = createByteBuffer(capacity)
            return Argb1555Buffer(buffer, stride, width, height)
        }

        @JvmStatic
        fun wrap(buffer: ByteBuffer, width: Int, height: Int): Argb1555Buffer {
            val (stride, capacity) = getStrideWithCapacity(width, height)
            return Argb1555Buffer(buffer.sliceRange(0, capacity), stride, width, height)
        }
    }
}