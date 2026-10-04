package org.apache.poi.java.awt.geom;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes10.dex */
class RectIterator implements PathIterator {
    AffineTransform affine;

    /* JADX INFO: renamed from: h */
    double f10134h;
    int index;

    /* JADX INFO: renamed from: w */
    double f10135w;

    /* JADX INFO: renamed from: x */
    double f10136x;

    /* JADX INFO: renamed from: y */
    double f10137y;

    public RectIterator(Rectangle2D rectangle2D, AffineTransform affineTransform) {
        this.f10136x = rectangle2D.getX();
        this.f10137y = rectangle2D.getY();
        this.f10135w = rectangle2D.getWidth();
        double height = rectangle2D.getHeight();
        this.f10134h = height;
        this.affine = affineTransform;
        if (this.f10135w < 0.0d || height < 0.0d) {
            this.index = 6;
        }
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public int currentSegment(double[] dArr) {
        if (isDone()) {
            throw new NoSuchElementException("rect iterator out of bounds");
        }
        int i = this.index;
        if (i == 5) {
            return 4;
        }
        double d = this.f10136x;
        dArr[0] = d;
        double d2 = this.f10137y;
        dArr[1] = d2;
        if (i == 1 || i == 2) {
            dArr[0] = d + this.f10135w;
        }
        if (i == 2 || i == 3) {
            dArr[1] = d2 + this.f10134h;
        }
        AffineTransform affineTransform = this.affine;
        if (affineTransform != null) {
            affineTransform.transform(dArr, 0, dArr, 0, 1);
        }
        return this.index == 0 ? 0 : 1;
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
            throw new NoSuchElementException("rect iterator out of bounds");
        }
        int i = this.index;
        if (i == 5) {
            return 4;
        }
        float f = (float) this.f10136x;
        fArr[0] = f;
        float f4 = (float) this.f10137y;
        fArr[1] = f4;
        if (i == 1 || i == 2) {
            fArr[0] = f + ((float) this.f10135w);
        }
        if (i == 2 || i == 3) {
            fArr[1] = f4 + ((float) this.f10134h);
        }
        AffineTransform affineTransform = this.affine;
        if (affineTransform != null) {
            affineTransform.transform(fArr, 0, fArr, 0, 1);
        }
        return this.index == 0 ? 0 : 1;
    }
}
