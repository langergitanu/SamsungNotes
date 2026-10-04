package org.apache.poi.java.awt;

import java.io.Serializable;
import org.apache.poi.java.awt.Component;

/* JADX INFO: loaded from: classes10.dex */
public class GridBagLayoutInfo implements Serializable {
    private static final long serialVersionUID = -4899416460737170217L;
    short[] baselineType;
    boolean hasBaseline;
    int height;
    int[] maxAscent;
    int[] maxDescent;
    int[] minHeight;
    int[] minWidth;
    int startx;
    int starty;
    double[] weightX;
    double[] weightY;
    int width;

    public GridBagLayoutInfo(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public boolean hasBaseline(int i) {
        return this.hasBaseline && this.baselineType[i] != 0;
    }

    public boolean hasConstantDescent(int i) {
        return (this.baselineType[i] & (1 << Component.BaselineResizeBehavior.CONSTANT_DESCENT.ordinal())) != 0;
    }
}
