package io.github.zncmn.libyuv;

import org.jetbrains.annotations.NotNull;

public class YuvConvert {
    public void argbToYuv(@NotNull final byte[] argb, final int width, final int height, @NotNull final byte[] yuv) {
        final byte[] bgr = new byte[argb.length];
        Yuv.INSTANCE.abgrToArgb(argb, width, height, bgr);
        Yuv.INSTANCE.argbToNv21(bgr, width, height, yuv);
    }

    public void yuvToArgb(@NotNull final byte[] yuv, final int width, final int height, @NotNull final byte[] argb) {
        Yuv.INSTANCE.nv21ToAbgr(yuv, width, height, argb);
    }
}
