package com.sun.imageio.plugins.common;

import org.apache.poi.java.awt.color.ColorSpace;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BogusColorSpace extends ColorSpace {
    public BogusColorSpace(int i) {
        super(getType(i), i);
    }

    private static int getType(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("numComponents < 1!");
        }
        if (i != 1) {
            return i + 10;
        }
        return 6;
    }

    @Override // org.apache.poi.java.awt.color.ColorSpace
    public float[] fromCIEXYZ(float[] fArr) {
        if (fArr.length < 3) {
            throw new ArrayIndexOutOfBoundsException("xyzvalue.length < 3");
        }
        int numComponents = getNumComponents();
        System.arraycopy(fArr, 0, new float[numComponents], 0, Math.min(3, numComponents));
        return fArr;
    }

    @Override // org.apache.poi.java.awt.color.ColorSpace
    public float[] fromRGB(float[] fArr) {
        if (fArr.length < 3) {
            throw new ArrayIndexOutOfBoundsException("rgbvalue.length < 3");
        }
        int numComponents = getNumComponents();
        System.arraycopy(fArr, 0, new float[numComponents], 0, Math.min(3, numComponents));
        return fArr;
    }

    @Override // org.apache.poi.java.awt.color.ColorSpace
    public float[] toCIEXYZ(float[] fArr) {
        if (fArr.length < getNumComponents()) {
            throw new ArrayIndexOutOfBoundsException("colorvalue.length < getNumComponents()");
        }
        System.arraycopy(fArr, 0, new float[3], 0, Math.min(3, getNumComponents()));
        return fArr;
    }

    @Override // org.apache.poi.java.awt.color.ColorSpace
    public float[] toRGB(float[] fArr) {
        if (fArr.length < getNumComponents()) {
            throw new ArrayIndexOutOfBoundsException("colorvalue.length < getNumComponents()");
        }
        System.arraycopy(fArr, 0, new float[3], 0, Math.min(3, getNumComponents()));
        return fArr;
    }
}
