package io.github.crow_misia.libyuv

/**
 * YUV Buffer.
 */
interface BufferYUV : Buffer {
    val planeY: Plane
    val planeU: Plane
    val planeV: Plane
}
