package org.apache.poi.java.awt.geom;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes10.dex */
class LineIterator implements PathIterator {
    AffineTransform affine;
    int index;
    Line2D line;

    public LineIterator(Line2D line2D, AffineTransform affineTransform) {
        this.line = line2D;
        this.affine = affineTransform;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public int currentSegment(double[] dArr) {
        if (isDone()) {
            throw new NoSuchElementException("line iterator out of bounds");
        }
        int i = 1;
        if (this.index == 0) {
            dArr[0] = this.line.getX1();
            dArr[1] = this.line.getY1();
            i = 0;
        } else {
            dArr[0] = this.line.getX2();
            dArr[1] = this.line.getY2();
        }
        AffineTransform affineTransform = this.affine;
        if (affineTransform != null) {
            affineTransform.transform(dArr, 0, dArr, 0, 1);
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
            throw new NoSuchElementException("line iterator out of bounds");
        }
        int i = 1;
        if (this.index == 0) {
            fArr[0] = (float) this.line.getX1();
            fArr[1] = (float) this.line.getY1();
            i = 0;
        } else {
            fArr[0] = (float) this.line.getX2();
            fArr[1] = (float) this.line.getY2();
        }
        AffineTransform affineTransform = this.affine;
        if (affineTransform != null) {
            affineTransform.transform(fArr, 0, fArr, 0, 1);
        }
        return i;
    }
}
