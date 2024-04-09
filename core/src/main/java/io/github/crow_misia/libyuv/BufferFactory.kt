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

interface BufferFactory24<BUFFER : Buffer24<BUFFER>> : BufferFactory<BUFFER> {
    fun wrap(plane: Plane, width: Int, height: Int): BUFFER {
        return wrap(plane, width, height, Rect(0, 0, width, height))
    }

    fun wrap(plane: Plane, width: Int, height: Int, cropRect: Rect): BUFFER
}

interface BufferFactory32<BUFFER : Buffer32<BUFFER>> : BufferFactory<BUFFER> {
    fun wrap(plane: Plane, width: Int, height: Int): BUFFER {
        return wrap(plane, width, height, Rect(0, 0, width, height))
    }

    fun wrap(plane: Plane, width: Int, height: Int, cropRect: Rect): BUFFER
}

interface BufferFactoryY<BUFFER : BufferY<BUFFER>> : BufferFactory<BUFFER> {
    fun wrap(planeY: Plane, width: Int, height: Int): BUFFER {
        return wrap(planeY, width, height, Rect(0, 0, width, height))
    }

    fun wrap(planeY: Plane, width: Int, height: Int, cropRect: Rect): BUFFER
}
interface BufferFactoryYUV<BUFFER : BufferYUV> : BufferFactory<BUFFER> {
    fun wrap(planeY: Plane, planeU: Plane, planeV: Plane, width: Int, height: Int): BUFFER {
        return wrap(planeY, planeU, planeV, width, height, Rect(0, 0, width, height))
    }

    fun wrap(planeY: Plane, planeU: Plane, planeV: Plane, width: Int, height: Int, cropRect: Rect): BUFFER
}
