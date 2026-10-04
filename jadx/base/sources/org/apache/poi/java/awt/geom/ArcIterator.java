package org.apache.poi.java.awt.geom;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes10.dex */
class ArcIterator implements PathIterator {
    AffineTransform affine;
    double angStRad;
    int arcSegs;

    /* JADX INFO: renamed from: cv */
    double f10109cv;

    /* JADX INFO: renamed from: h */
    double f10110h;
    double increment;
    int index;
    int lineSegs;

    /* JADX INFO: renamed from: w */
    double f10111w;

    /* JADX INFO: renamed from: x */
    double f10112x;

    /* JADX INFO: renamed from: y */
    double f10113y;

    /* JADX WARN: Removed duplicated region for block: B:20:0x009b A[PHI: r11
      0x009b: PHI (r11v5 int) = (r11v4 int), (r11v6 int) binds: [B:16:0x0095, B:18:0x0098] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArcIterator(Arc2D arc2D, AffineTransform affineTransform) {
        this.f10111w = arc2D.getWidth() / 2.0d;
        this.f10110h = arc2D.getHeight() / 2.0d;
        this.f10112x = arc2D.getX() + this.f10111w;
        this.f10113y = arc2D.getY() + this.f10110h;
        this.angStRad = -Math.toRadians(arc2D.getAngleStart());
        this.affine = affineTransform;
        double d = -arc2D.getAngleExtent();
        if (d >= 360.0d || d <= -360.0d) {
            this.arcSegs = 4;
            this.increment = 1.5707963267948966d;
            this.f10109cv = 0.5522847498307933d;
            if (d < 0.0d) {
                this.increment = -1.5707963267948966d;
                this.f10109cv = -0.5522847498307933d;
            }
        } else {
            int iCeil = (int) Math.ceil(Math.abs(d) / 90.0d);
            this.arcSegs = iCeil;
            double radians = Math.toRadians(d / ((double) iCeil));
            this.increment = radians;
            double dBtan = btan(radians);
            this.f10109cv = dBtan;
            if (dBtan == 0.0d) {
                this.arcSegs = 0;
            }
        }
        int arcType = arc2D.getArcType();
        if (arcType != 0) {
            int i = 1;
            if (arcType != 1) {
                i = 2;
                if (arcType == 2) {
                    this.lineSegs = i;
                }
            }
        } else {
            this.lineSegs = 0;
        }
        if (this.f10111w < 0.0d || this.f10110h < 0.0d) {
            this.lineSegs = -1;
            this.arcSegs = -1;
        }
    }

    private static double btan(double d) {
        double d2 = d / 2.0d;
        return (Math.sin(d2) * 1.3333333333333333d) / (Math.cos(d2) + 1.0d);
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public int currentSegment(double[] dArr) {
        if (isDone()) {
            throw new NoSuchElementException("arc iterator out of bounds");
        }
        double d = this.angStRad;
        int i = this.index;
        if (i == 0) {
            dArr[0] = (Math.cos(d) * this.f10111w) + this.f10112x;
            dArr[1] = (Math.sin(d) * this.f10110h) + this.f10113y;
            AffineTransform affineTransform = this.affine;
            if (affineTransform != null) {
                affineTransform.transform(dArr, 0, dArr, 0, 1);
            }
            return 0;
        }
        int i2 = this.arcSegs;
        if (i > i2) {
            if (i == i2 + this.lineSegs) {
                return 4;
            }
            dArr[0] = this.f10112x;
            dArr[1] = this.f10113y;
            AffineTransform affineTransform2 = this.affine;
            if (affineTransform2 != null) {
                affineTransform2.transform(dArr, 0, dArr, 0, 1);
            }
            return 1;
        }
        double d2 = (this.increment * ((double) (i - 1))) + d;
        double dCos = Math.cos(d2);
        double dSin = Math.sin(d2);
        double d3 = this.f10112x;
        double d4 = this.f10109cv;
        dArr[0] = ((dCos - (d4 * dSin)) * this.f10111w) + d3;
        dArr[1] = (((d4 * dCos) + dSin) * this.f10110h) + this.f10113y;
        double d5 = d2 + this.increment;
        double dCos2 = Math.cos(d5);
        double dSin2 = Math.sin(d5);
        double d6 = this.f10112x;
        double d7 = this.f10109cv;
        double d8 = this.f10111w;
        dArr[2] = (((d7 * dSin2) + dCos2) * d8) + d6;
        double d9 = this.f10113y;
        double d10 = this.f10110h;
        dArr[3] = ((dSin2 - (d7 * dCos2)) * d10) + d9;
        dArr[4] = (dCos2 * d8) + d6;
        dArr[5] = (dSin2 * d10) + d9;
        AffineTransform affineTransform3 = this.affine;
        if (affineTransform3 != null) {
            affineTransform3.transform(dArr, 0, dArr, 0, 3);
        }
        return 3;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public int getWindingRule() {
        return 1;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public boolean isDone() {
        return this.index > this.arcSegs + this.lineSegs;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public void next() {
        this.index++;
    }

    @Override // org.apache.poi.java.awt.geom.PathIterator
    public int currentSegment(float[] fArr) {
        if (isDone()) {
            throw new NoSuchElementException("arc iterator out of bounds");
        }
        double d = this.angStRad;
        int i = this.index;
        if (i == 0) {
            fArr[0] = (float) ((Math.cos(d) * this.f10111w) + this.f10112x);
            fArr[1] = (float) ((Math.sin(d) * this.f10110h) + this.f10113y);
            AffineTransform affineTransform = this.affine;
            if (affineTransform != null) {
                affineTransform.transform(fArr, 0, fArr, 0, 1);
            }
            return 0;
        }
        int i2 = this.arcSegs;
        if (i > i2) {
            if (i == i2 + this.lineSegs) {
                return 4;
            }
            fArr[0] = (float) this.f10112x;
            fArr[1] = (float) this.f10113y;
            AffineTransform affineTransform2 = this.affine;
            if (affineTransform2 != null) {
                affineTransform2.transform(fArr, 0, fArr, 0, 1);
            }
            return 1;
        }
        double d2 = (this.increment * ((double) (i - 1))) + d;
        double dCos = Math.cos(d2);
        double dSin = Math.sin(d2);
        double d3 = this.f10112x;
        double d4 = this.f10109cv;
        fArr[0] = (float) (((dCos - (d4 * dSin)) * this.f10111w) + d3);
        fArr[1] = (float) ((((d4 * dCos) + dSin) * this.f10110h) + this.f10113y);
        double d5 = d2 + this.increment;
        double dCos2 = Math.cos(d5);
        double dSin2 = Math.sin(d5);
        double d6 = this.f10112x;
        double d7 = this.f10109cv;
        double d8 = this.f10111w;
        fArr[2] = (float) ((((d7 * dSin2) + dCos2) * d8) + d6);
        double d9 = this.f10113y;
        double d10 = this.f10110h;
        fArr[3] = (float) (((dSin2 - (d7 * dCos2)) * d10) + d9);
        fArr[4] = (float) ((dCos2 * d8) + d6);
        fArr[5] = (float) ((dSin2 * d10) + d9);
        AffineTransform affineTransform3 = this.affine;
        if (affineTransform3 != null) {
            affineTransform3.transform(fArr, 0, fArr, 0, 3);
        }
        return 3;
    }
}
