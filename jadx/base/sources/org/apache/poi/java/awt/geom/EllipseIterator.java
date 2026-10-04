package org.apache.poi.java.awt.geom;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes10.dex */
class EllipseIterator implements PathIterator {
    public static final double CtrlVal = 0.5522847498307933d;
    AffineTransform affine;

    /* JADX INFO: renamed from: h */
    double f10118h;
    int index;

    /* JADX INFO: renamed from: w */
    double f10119w;

    /* JADX INFO: renamed from: x */
    double f10120x;

    /* JADX INFO: renamed from: y */
    double f10121y;
    private static final double pcv = 0.7761423749153966d;
    private static final double ncv = 0.22385762508460333d;
    private static double[][] ctrlpts = {new double[]{1.0d, pcv, pcv, 1.0d, 0.5d, 1.0d}, new double[]{ncv, 1.0d, 0.0d, pcv, 0.0d, 0.5d}, new double[]{0.0d, ncv, ncv, 0.0d, 0.5d, 0.0d}, new double[]{pcv, 0.0d, 1.0d, ncv, 1.0d, 0.5d}};

    public EllipseIterator(Ellipse2D ellipse2D, AffineTransform affineTransform) {
        this.f10120x = ellipse2D.getX();
        this.f10121y = ellipse2D.getY();
        this.f10119w = ellipse2D.getWidth();
        double height = ellipse2D.getHeight();
        this.f10118h = height;
        this.affine = affineTransform;
        if (this.f10119w < 0.0d || height < 0.0d) {
            this.index = 6;
        }
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public int currentSegment(double[] dArr) {
        if (isDone()) {
            throw new NoSuchElementException("ellipse iterator out of bounds");
        }
        int i = this.index;
        if (i == 5) {
            return 4;
        }
        if (i == 0) {
            double[] dArr2 = ctrlpts[3];
            dArr[0] = (dArr2[4] * this.f10119w) + this.f10120x;
            dArr[1] = (dArr2[5] * this.f10118h) + this.f10121y;
            AffineTransform affineTransform = this.affine;
            if (affineTransform != null) {
                affineTransform.transform(dArr, 0, dArr, 0, 1);
            }
            return 0;
        }
        double[] dArr3 = ctrlpts[i - 1];
        double d = this.f10120x;
        double d2 = dArr3[0];
        double d3 = this.f10119w;
        dArr[0] = (d2 * d3) + d;
        double d4 = this.f10121y;
        double d5 = dArr3[1];
        double d6 = this.f10118h;
        dArr[1] = (d5 * d6) + d4;
        dArr[2] = (dArr3[2] * d3) + d;
        dArr[3] = (dArr3[3] * d6) + d4;
        dArr[4] = (dArr3[4] * d3) + d;
        dArr[5] = (dArr3[5] * d6) + d4;
        AffineTransform affineTransform2 = this.affine;
        if (affineTransform2 != null) {
            affineTransform2.transform(dArr, 0, dArr, 0, 3);
        }
        return 3;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public int getWindingRule() {
        return 1;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public boolean isDone() {
        return this.index > 5;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public void next() {
        this.index++;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public int currentSegment(float[] fArr) {
        if (isDone()) {
            throw new NoSuchElementException("ellipse iterator out of bounds");
        }
        int i = this.index;
        if (i == 5) {
            return 4;
        }
        if (i == 0) {
            double[] dArr = ctrlpts[3];
            fArr[0] = (float) ((dArr[4] * this.f10119w) + this.f10120x);
            fArr[1] = (float) ((dArr[5] * this.f10118h) + this.f10121y);
            AffineTransform affineTransform = this.affine;
            if (affineTransform != null) {
                affineTransform.transform(fArr, 0, fArr, 0, 1);
            }
            return 0;
        }
        double[] dArr2 = ctrlpts[i - 1];
        double d = this.f10120x;
        double d2 = dArr2[0];
        double d3 = this.f10119w;
        fArr[0] = (float) ((d2 * d3) + d);
        double d4 = this.f10121y;
        double d5 = dArr2[1];
        double d6 = this.f10118h;
        fArr[1] = (float) ((d5 * d6) + d4);
        fArr[2] = (float) ((dArr2[2] * d3) + d);
        fArr[3] = (float) ((dArr2[3] * d6) + d4);
        fArr[4] = (float) ((dArr2[4] * d3) + d);
        fArr[5] = (float) ((dArr2[5] * d6) + d4);
        AffineTransform affineTransform2 = this.affine;
        if (affineTransform2 != null) {
            affineTransform2.transform(fArr, 0, fArr, 0, 3);
        }
        return 3;
    }
}
