package io.github.zncmn.libyuv;

/**
 * Ro
 */
public enum RotationMode {
    ROTATE_0(0),
    ROTATE_90(90),
    ROTATE_180(180),
    ROTATE_270(270);

    public final int degrees;

    RotationMode(final int degrees) {
        this.degrees = degrees;
    }
}
