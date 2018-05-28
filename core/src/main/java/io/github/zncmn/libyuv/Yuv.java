package io.github.zncmn.libyuv;

import org.jetbrains.annotations.NotNull;

public final class Yuv {
    public static final Yuv INSTANCE = new Yuv();

    static {
        System.loadLibrary("yuv");
    }

    /* package */ native void abgrToArgb(@NotNull byte[] abgr, int width, int height, @NotNull byte[] argb);
    /* package */ native void argbToNv21(@NotNull byte[] argb, int width, int height, @NotNull byte[] nv21);
    /* package */ native void nv21ToAbgr(@NotNull byte[] nv21, int width, int height, @NotNull byte[] abgr);
    /* package */ native void i420ToNv21(@NotNull byte[] i420, int width, int height, @NotNull byte[] nv21);
    /* package */ native void nv21ToI420Rotate(@NotNull byte[] src, int srcStride, @NotNull byte[] dest, int destStride, int width, int height, int degrees);
}
