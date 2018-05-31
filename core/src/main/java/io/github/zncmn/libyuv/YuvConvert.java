package io.github.zncmn.libyuv;

import org.jetbrains.annotations.NotNull;

public class YuvConvert {
    public void fromARGB(@NotNull final byte[] argb, @NotNull final byte[] yuv, final int width, final int height, @NotNull final YuvFormat format) {
        switch (format) {
            case NV21:
                Yuv.INSTANCE.abgrToNv21(argb, yuv, width, height);
                break;
            default:
                throw new UnsupportedOperationException("not supported format. " + format);
        }
    }

    public void toARGB(@NotNull final byte[] yuv, @NotNull final byte[] argb, final int width, final int height, @NotNull final YuvFormat format) {
        switch (format) {
            case NV21:
                Yuv.INSTANCE.nv21ToAbgr(yuv, argb, width, height);
                break;
            default:
                throw new UnsupportedOperationException("not supported format. " + format);
        }
    }
}
