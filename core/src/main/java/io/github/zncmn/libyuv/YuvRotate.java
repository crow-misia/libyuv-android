package io.github.zncmn.libyuv;

import org.jetbrains.annotations.NotNull;

public class YuvRotate {
    @SuppressWarnings("SuspiciousNameCombination")
    public void rorate(@NotNull final byte[] src, final int width, final int height, @NotNull final byte[] dest, @NotNull final RotationMode mode) {
        if (mode == RotationMode.ROTATE_0 && src != dest) {
            System.arraycopy(src, 0, dest, 0, width * height * 3);
            return;
        }

        final byte[] i420 = new byte[src.length];
        switch (mode) {
            case ROTATE_90:
                Yuv.INSTANCE.nv21ToI420Rotate(src, width, i420, height, width, height, 90);
                Yuv.INSTANCE.i420ToNv21(i420, height, width, dest);
                break;
            case ROTATE_180:
                Yuv.INSTANCE.nv21ToI420Rotate(src, width, i420, width, width, height, 180);
                Yuv.INSTANCE.i420ToNv21(i420, width, height, dest);
                break;
            case ROTATE_270:
                Yuv.INSTANCE.nv21ToI420Rotate(src, width, i420, height, width, height, 270);
                Yuv.INSTANCE.i420ToNv21(i420, height, width, dest);
                break;
        }
    }
}
