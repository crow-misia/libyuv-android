package io.github.zncmn.libyuv;

import org.jetbrains.annotations.NotNull;

public class YuvRotate {
    public void rorate(@NotNull final byte[] src, @NotNull final byte[] dest, final int width, final int height, @NotNull final RotationMode mode, @NotNull final YuvFormat format) {
        if (mode == RotationMode.ROTATE_0) {
            if (src != dest) {
                System.arraycopy(src, 0, dest, 0, format.getDataSize(width, height));
            }
            return;
        }

        if (format == YuvFormat.NV21) {
            Yuv.INSTANCE.nv21Rotate(src, dest, width, height, mode.degrees);
        } else {
            throw new UnsupportedOperationException("not supported format. " + format);
        }
   }
}
