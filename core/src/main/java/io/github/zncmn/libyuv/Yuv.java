package io.github.zncmn.libyuv;

import org.jetbrains.annotations.NotNull;

public final class Yuv {
    public static final Yuv INSTANCE = new Yuv();

    static {
        System.loadLibrary("yuv");
    }

    /* package */ native void abgrToArgb(@NotNull byte[] abgr, @NotNull byte[] argb, int width, int height);
    /* package */ native void argbToNv21(@NotNull byte[] argb, @NotNull byte[] nv21, int width, int height);
    /* package */ native void nv21ToAbgr(@NotNull byte[] nv21, @NotNull byte[] abgr, int width, int height);
    /* package */ native void nv21Rotate(@NotNull byte[] src, @NotNull byte[] dest, int width, int height, int degrees);
}
