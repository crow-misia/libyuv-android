package io.github.zncmn.libyuv;

public enum YuvFormat {
    NV21 {
        @Override
        public int getDataSize(final int width, final int height) {
            return width * height + ((width + 1) / 2 * (height + 1) / 2) * 2;
        }
    };

    /**
     * calculate Data Size.
     * @param width Width
     * @param height Height
     * @return Data Size
     */
    public abstract int getDataSize(int width, int height);
}
