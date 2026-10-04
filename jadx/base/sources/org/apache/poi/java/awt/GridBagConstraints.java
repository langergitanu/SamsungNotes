package org.apache.poi.java.awt;

import java.io.Serializable;
import org.apache.poi.java.awt.Component;

/* JADX INFO: loaded from: classes10.dex */
public class GridBagConstraints implements Cloneable, Serializable {
    public static final int ABOVE_BASELINE = 1024;
    public static final int ABOVE_BASELINE_LEADING = 1280;
    public static final int ABOVE_BASELINE_TRAILING = 1536;
    public static final int BASELINE = 256;
    public static final int BASELINE_LEADING = 512;
    public static final int BASELINE_TRAILING = 768;
    public static final int BELOW_BASELINE = 1792;
    public static final int BELOW_BASELINE_LEADING = 2048;
    public static final int BELOW_BASELINE_TRAILING = 2304;
    public static final int BOTH = 1;
    public static final int CENTER = 10;
    public static final int EAST = 13;
    public static final int FIRST_LINE_END = 24;
    public static final int FIRST_LINE_START = 23;
    public static final int HORIZONTAL = 2;
    public static final int LAST_LINE_END = 26;
    public static final int LAST_LINE_START = 25;
    public static final int LINE_END = 22;
    public static final int LINE_START = 21;
    public static final int NONE = 0;
    public static final int NORTH = 11;
    public static final int NORTHEAST = 12;
    public static final int NORTHWEST = 18;
    public static final int PAGE_END = 20;
    public static final int PAGE_START = 19;
    public static final int RELATIVE = -1;
    public static final int REMAINDER = 0;
    public static final int SOUTH = 15;
    public static final int SOUTHEAST = 14;
    public static final int SOUTHWEST = 16;
    public static final int VERTICAL = 3;
    public static final int WEST = 17;
    private static final long serialVersionUID = -1000070633030801713L;
    public int anchor;
    transient int ascent;
    transient Component.BaselineResizeBehavior baselineResizeBehavior;
    transient int centerOffset;
    transient int centerPadding;
    transient int descent;
    public int fill;
    public int gridheight;
    public int gridwidth;
    public int gridx;
    public int gridy;
    public Insets insets;
    public int ipadx;
    public int ipady;
    int minHeight;
    int minWidth;
    int tempHeight;
    int tempWidth;
    int tempX;
    int tempY;
    public double weightx;
    public double weighty;

    public GridBagConstraints() {
        this.gridx = -1;
        this.gridy = -1;
        this.gridwidth = 1;
        this.gridheight = 1;
        this.weightx = 0.0d;
        this.weighty = 0.0d;
        this.anchor = 10;
        this.fill = 0;
        this.insets = new Insets(0, 0, 0, 0);
        this.ipadx = 0;
        this.ipady = 0;
    }

    public Object clone() {
        try {
            GridBagConstraints gridBagConstraints = (GridBagConstraints) super.clone();
            gridBagConstraints.insets = (Insets) this.insets.clone();
            return gridBagConstraints;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean isVerticallyResizable() {
        int i = this.fill;
        return i == 1 || i == 3;
    }

    public GridBagConstraints(int i, int i2, int i4, int i5, double d, double d2, int i6, int i7, Insets insets, int i8, int i9) {
        this.gridx = i;
        this.gridy = i2;
        this.gridwidth = i4;
        this.gridheight = i5;
        this.fill = i7;
        this.ipadx = i8;
        this.ipady = i9;
        this.insets = insets;
        this.anchor = i6;
        this.weightx = d;
        this.weighty = d2;
    }
}
