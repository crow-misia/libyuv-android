package io.github.crow_misia.libyuv

import java.nio.ByteBuffer

interface BufferFactory<BUFFER : Buffer> {
    fun allocate(width: Int, height: Int): BUFFER

    fun wrap(buffer: ByteBuffer, width: Int, height: Int): BUFFER
}
