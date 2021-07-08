package io.github.crow_misia.libyuv

abstract class AbstractBuffer(
    releaseCallback: Runnable?,
) : Buffer {
    companion object {
        private val noneCallback = Runnable { }
    }

    private val refCountDelegate = RefCountDelegate(releaseCallback ?: noneCallback)
    override fun retain() = refCountDelegate.retain()
    override fun close() = refCountDelegate.release()
}