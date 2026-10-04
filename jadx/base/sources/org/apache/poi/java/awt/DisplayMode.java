package org.apache.poi.java.awt;

/* JADX INFO: loaded from: classes10.dex */
public final class DisplayMode {
    public static final int BIT_DEPTH_MULTI = -1;
    public static final int REFRESH_RATE_UNKNOWN = 0;
    private int bitDepth;
    private int refreshRate;
    private Dimension size;

    public DisplayMode(int i, int i2, int i4, int i5) {
        this.size = new Dimension(i, i2);
        this.bitDepth = i4;
        this.refreshRate = i5;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DisplayMode) {
            return equals((DisplayMode) obj);
        }
        return false;
    }

    public int getBitDepth() {
        return this.bitDepth;
    }

    public int getHeight() {
        return this.size.height;
    }

    public int getRefreshRate() {
        return this.refreshRate;
    }

    public int getWidth() {
        return this.size.width;
    }

    public int hashCode() {
        return (getRefreshRate() * 13) + (getBitDepth() * 7) + getHeight() + getWidth();
    }

    public boolean equals(DisplayMode displayMode) {
        return displayMode != null && getHeight() == displayMode.getHeight() && getWidth() == displayMode.getWidth() && getBitDepth() == displayMode.getBitDepth() && getRefreshRate() == displayMode.getRefreshRate();
    }
}
