package io.github.crow_misia.libyuv

import android.graphics.Rect
import java.nio.ByteBuffer

interface BufferFactory<BUFFER : Buffer> {
    fun allocate(width: Int, height: Int): BUFFER {
        return allocate(width, height, Rect(0, 0, width, height))
    }

    fun allocate(width: Int, height: Int, cropRect: Rect): BUFFER

    fun wrap(buffer: ByteBuffer, width: Int, height: Int): BUFFER {
        return wrap(buffer, width, height, Rect(0, 0, width, height))
    }

    fun wrap(buffer: ByteBuffer, width: Int, height: Int, cropRect: Rect): BUFFER
}
