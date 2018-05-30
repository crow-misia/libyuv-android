package io.github.zncmn.libyuv;

import org.jetbrains.annotations.NotNull;

public class YuvRotate {
    public int getBufferSize(final int width, final int height) {
        return width * height + ((width + 1) >> 1) * ((height + 1) >> 1);
    }

    @SuppressWarnings("SuspiciousNameCombination")
    public void rorate(@NotNull final byte[] src, final int width, final int height, @NotNull final byte[] dest, @NotNull final RotationMode mode) {
        final int size = getBufferSize(width, height);
        if (mode == RotationMode.ROTATE_0) {
            if (src != dest) {
                System.arraycopy(src, 0, dest, 0, size);
            }
            return;
        }

        switch (mode) {
            case ROTATE_90:
                Yuv.INSTANCE.nv21Rotate(src, dest, width, height, 90);
                break;
            case ROTATE_180:
                Yuv.INSTANCE.nv21Rotate(src, dest, width, height, 180);
                break;
            case ROTATE_270:
                Yuv.INSTANCE.nv21Rotate(src, dest, width, height, 270);
                break;
        }
    }
}
