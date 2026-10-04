package org.apache.poi.java.awt.geom;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes10.dex */
class QuadIterator implements PathIterator {
    AffineTransform affine;
    int index;
    QuadCurve2D quad;

    public QuadIterator(QuadCurve2D quadCurve2D, AffineTransform affineTransform) {
        this.quad = quadCurve2D;
        this.affine = affineTransform;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public int currentSegment(double[] dArr) {
        if (isDone()) {
            throw new NoSuchElementException("quad iterator iterator out of bounds");
        }
        int i = 0;
        if (this.index == 0) {
            dArr[0] = this.quad.getX1();
            dArr[1] = this.quad.getY1();
        } else {
            dArr[0] = this.quad.getCtrlX();
            dArr[1] = this.quad.getCtrlY();
            dArr[2] = this.quad.getX2();
            dArr[3] = this.quad.getY2();
            i = 2;
        }
        AffineTransform affineTransform = this.affine;
        if (affineTransform != null) {
            affineTransform.transform(dArr, 0, dArr, 0, this.index == 0 ? 1 : 2);
        }
        return i;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public int getWindingRule() {
        return 1;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public boolean isDone() {
        return this.index > 1;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public void next() {
        this.index++;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public int currentSegment(float[] fArr) {
        if (isDone()) {
            throw new NoSuchElementException("quad iterator iterator out of bounds");
        }
        int i = 0;
        if (this.index == 0) {
            fArr[0] = (float) this.quad.getX1();
            fArr[1] = (float) this.quad.getY1();
        } else {
            fArr[0] = (float) this.quad.getCtrlX();
            fArr[1] = (float) this.quad.getCtrlY();
            fArr[2] = (float) this.quad.getX2();
            fArr[3] = (float) this.quad.getY2();
            i = 2;
        }
        AffineTransform affineTransform = this.affine;
        if (affineTransform != null) {
            affineTransform.transform(fArr, 0, fArr, 0, this.index == 0 ? 1 : 2);
        }
        return i;
    }
}
