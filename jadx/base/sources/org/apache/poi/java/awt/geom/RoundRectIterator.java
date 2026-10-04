package org.apache.poi.java.awt.geom;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes10.dex */
class RoundRectIterator implements PathIterator {

    /* JADX INFO: renamed from: a */
    private static final double f10142a;
    private static final double acv;
    private static final double angle = 0.7853981633974483d;

    /* JADX INFO: renamed from: b */
    private static final double f10143b;

    /* JADX INFO: renamed from: c */
    private static final double f10144c;
    private static double[][] ctrlpts;

    /* JADX INFO: renamed from: cv */
    private static final double f10145cv;
    private static int[] types;
    AffineTransform affine;

    /* JADX INFO: renamed from: ah */
    double f10146ah;

    /* JADX INFO: renamed from: aw */
    double f10147aw;

    /* JADX INFO: renamed from: h */
    double f10148h;
    int index;

    /* JADX INFO: renamed from: w */
    double f10149w;

    /* JADX INFO: renamed from: x */
    double f10150x;

    /* JADX INFO: renamed from: y */
    double f10151y;

    static {
        double dCos = 1.0d - Math.cos(angle);
        f10142a = dCos;
        double dTan = Math.tan(angle);
        f10143b = dTan;
        double dSqrt = (Math.sqrt((dTan * dTan) + 1.0d) - 1.0d) + dCos;
        f10144c = dSqrt;
        double d = ((dCos * 1.3333333333333333d) * dTan) / dSqrt;
        f10145cv = d;
        double d2 = (1.0d - d) / 2.0d;
        acv = d2;
        ctrlpts = new double[][]{new double[]{0.0d, 0.0d, 0.0d, 0.5d}, new double[]{0.0d, 0.0d, 1.0d, -0.5d}, new double[]{0.0d, 0.0d, 1.0d, -d2, 0.0d, d2, 1.0d, 0.0d, 0.0d, 0.5d, 1.0d, 0.0d}, new double[]{1.0d, -0.5d, 1.0d, 0.0d}, new double[]{1.0d, -d2, 1.0d, 0.0d, 1.0d, 0.0d, 1.0d, -d2, 1.0d, 0.0d, 1.0d, -0.5d}, new double[]{1.0d, 0.0d, 0.0d, 0.5d}, new double[]{1.0d, 0.0d, 0.0d, d2, 1.0d, -d2, 0.0d, 0.0d, 1.0d, -0.5d, 0.0d, 0.0d}, new double[]{0.0d, 0.5d, 0.0d, 0.0d}, new double[]{0.0d, d2, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, d2, 0.0d, 0.0d, 0.0d, 0.5d}, new double[0]};
        types = new int[]{0, 1, 3, 1, 3, 1, 3, 1, 3, 4};
    }

    public RoundRectIterator(RoundRectangle2D roundRectangle2D, AffineTransform affineTransform) {
        this.f10150x = roundRectangle2D.getX();
        this.f10151y = roundRectangle2D.getY();
        this.f10149w = roundRectangle2D.getWidth();
        this.f10148h = roundRectangle2D.getHeight();
        this.f10147aw = Math.min(this.f10149w, Math.abs(roundRectangle2D.getArcWidth()));
        double dMin = Math.min(this.f10148h, Math.abs(roundRectangle2D.getArcHeight()));
        this.f10146ah = dMin;
        this.affine = affineTransform;
        if (this.f10147aw < 0.0d || dMin < 0.0d) {
            this.index = ctrlpts.length;
        }
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public int currentSegment(double[] dArr) {
        if (isDone()) {
            throw new NoSuchElementException("roundrect iterator out of bounds");
        }
        double[] dArr2 = ctrlpts[this.index];
        int i = 0;
        for (int i2 = 0; i2 < dArr2.length; i2 += 4) {
            int i4 = i + 1;
            dArr[i] = (dArr2[i2 + 1] * this.f10147aw) + (dArr2[i2] * this.f10149w) + this.f10150x;
            i += 2;
            dArr[i4] = (dArr2[i2 + 3] * this.f10146ah) + (dArr2[i2 + 2] * this.f10148h) + this.f10151y;
        }
        AffineTransform affineTransform = this.affine;
        if (affineTransform != null) {
            affineTransform.transform(dArr, 0, dArr, 0, i / 2);
        }
        return types[this.index];
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public int getWindingRule() {
        return 1;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public boolean isDone() {
        return this.index >= ctrlpts.length;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public void next() {
        this.index++;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public int currentSegment(float[] fArr) {
        if (isDone()) {
            throw new NoSuchElementException("roundrect iterator out of bounds");
        }
        double[] dArr = ctrlpts[this.index];
        int i = 0;
        for (int i2 = 0; i2 < dArr.length; i2 += 4) {
            int i4 = i + 1;
            fArr[i] = (float) ((dArr[i2 + 1] * this.f10147aw) + (dArr[i2] * this.f10149w) + this.f10150x);
            i += 2;
            fArr[i4] = (float) ((dArr[i2 + 3] * this.f10146ah) + (dArr[i2 + 2] * this.f10148h) + this.f10151y);
        }
        AffineTransform affineTransform = this.affine;
        if (affineTransform != null) {
            affineTransform.transform(fArr, 0, fArr, 0, i / 2);
        }
        return types[this.index];
    }
}
