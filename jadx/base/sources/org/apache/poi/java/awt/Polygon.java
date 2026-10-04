package org.apache.poi.java.awt;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.PathIterator;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.sun.awt.geom.Crossings;

/* JADX INFO: loaded from: classes10.dex */
public class Polygon implements Shape, Serializable {
    private static final int MIN_LENGTH = 4;
    private static final long serialVersionUID = -6460061437900069969L;
    protected Rectangle bounds;
    public int npoints;
    public int[] xpoints;
    public int[] ypoints;

    public class PolygonPathIterator implements PathIterator {
        int index;
        Polygon poly;
        AffineTransform transform;

        public PolygonPathIterator(Polygon polygon, AffineTransform affineTransform) {
            this.poly = polygon;
            this.transform = affineTransform;
            if (polygon.npoints == 0) {
                this.index = 1;
            }
        }

        @Override // org.apache.poi.java.awt.geom.PathIterator
        public int currentSegment(double[] dArr) {
            if (this.index >= this.poly.npoints) {
                return 4;
            }
            dArr[0] = r1.xpoints[r0];
            dArr[1] = r1.ypoints[r0];
            AffineTransform affineTransform = this.transform;
            if (affineTransform != null) {
                affineTransform.transform(dArr, 0, dArr, 0, 1);
            }
            return this.index == 0 ? 0 : 1;
        }

        @Override // org.apache.poi.java.awt.geom.PathIterator
        public int getWindingRule() {
            return 0;
        }

        @Override // org.apache.poi.java.awt.geom.PathIterator
        public boolean isDone() {
            return this.index > this.poly.npoints;
        }

        @Override // org.apache.poi.java.awt.geom.PathIterator
        public void next() {
            this.index++;
        }

        @Override // org.apache.poi.java.awt.geom.PathIterator
        public int currentSegment(float[] fArr) {
            if (this.index >= this.poly.npoints) {
                return 4;
            }
            fArr[0] = r1.xpoints[r0];
            fArr[1] = r1.ypoints[r0];
            AffineTransform affineTransform = this.transform;
            if (affineTransform != null) {
                affineTransform.transform(fArr, 0, fArr, 0, 1);
            }
            return this.index == 0 ? 0 : 1;
        }
    }

    public Polygon() {
        this.xpoints = new int[4];
        this.ypoints = new int[4];
    }

    private Crossings getCrossings(double d, double d2, double d3, double d4) {
        Crossings.EvenOdd evenOdd = new Crossings.EvenOdd(d, d2, d3, d4);
        int[] iArr = this.xpoints;
        int i = this.npoints;
        int i2 = iArr[i - 1];
        int i4 = this.ypoints[i - 1];
        int i5 = 0;
        while (i5 < this.npoints) {
            int i6 = this.xpoints[i5];
            int i7 = this.ypoints[i5];
            if (evenOdd.accumulateLine(i2, i4, i6, i7)) {
                return null;
            }
            i5++;
            i2 = i6;
            i4 = i7;
        }
        return evenOdd;
    }

    public void addPoint(int i, int i2) {
        int i4 = this.npoints;
        if (i4 >= this.xpoints.length || i4 >= this.ypoints.length) {
            int iHighestOneBit = i4 * 2;
            if (iHighestOneBit < 4) {
                iHighestOneBit = 4;
            } else if (((iHighestOneBit - 1) & iHighestOneBit) != 0) {
                iHighestOneBit = Integer.highestOneBit(iHighestOneBit);
            }
            this.xpoints = Arrays.copyOf(this.xpoints, iHighestOneBit);
            this.ypoints = Arrays.copyOf(this.ypoints, iHighestOneBit);
        }
        int[] iArr = this.xpoints;
        int i5 = this.npoints;
        iArr[i5] = i;
        this.ypoints[i5] = i2;
        this.npoints = i5 + 1;
        if (this.bounds != null) {
            updateBounds(i, i2);
        }
    }

    public void calculateBounds(int[] iArr, int[] iArr2, int i) {
        int iMin = Integer.MAX_VALUE;
        int iMax = Integer.MIN_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        for (int i2 = 0; i2 < i; i2++) {
            int i4 = iArr[i2];
            iMin = Math.min(iMin, i4);
            iMax2 = Math.max(iMax2, i4);
            int i5 = iArr2[i2];
            iMin2 = Math.min(iMin2, i5);
            iMax = Math.max(iMax, i5);
        }
        this.bounds = new Rectangle(iMin, iMin2, iMax2 - iMin, iMax - iMin2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a6 A[PHI: r15 r17 r18
      0x00a6: PHI (r15v5 boolean) = (r15v1 boolean), (r15v3 boolean), (r15v6 boolean) binds: [B:43:0x00a1, B:27:0x0061, B:12:0x0037] A[DONT_GENERATE, DONT_INLINE]
      0x00a6: PHI (r17v6 int) = (r17v1 int), (r17v3 int), (r17v7 int) binds: [B:43:0x00a1, B:27:0x0061, B:12:0x0037] A[DONT_GENERATE, DONT_INLINE]
      0x00a6: PHI (r18v3 int) = (r18v1 int), (r18v2 int), (r18v4 int) binds: [B:43:0x00a1, B:27:0x0061, B:12:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // org.apache.poi.java.awt.Shape
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean contains(double d, double d2) {
        int i;
        int i2;
        double d3;
        double d4;
        boolean z;
        int i4;
        if (this.npoints <= 2 || !getBoundingBox().contains(d, d2)) {
            return false;
        }
        int[] iArr = this.xpoints;
        int i5 = this.npoints;
        int i6 = iArr[i5 - 1];
        boolean z2 = true;
        int i7 = this.ypoints[i5 - 1];
        int i8 = 0;
        int i9 = 0;
        while (i8 < this.npoints) {
            int i10 = this.xpoints[i8];
            int i11 = this.ypoints[i8];
            if (i11 == i7) {
                i2 = i8;
                z = z2;
                i4 = i9;
            } else if (i10 < i6) {
                if (d < i6) {
                    i = i10;
                    if (i11 >= i7) {
                        double d5 = i11;
                        i2 = i8;
                        if (d2 >= d5 && d2 < i7) {
                            if (d >= i) {
                                d4 = d - ((double) i10);
                                d3 = d2 - d5;
                                z = z2;
                                i4 = i9;
                                i9 = d4 >= (d3 / ((double) (i7 - i11))) * ((double) (i6 - i10)) ? i4 + 1 : i4;
                            }
                            i9++;
                            z = z2;
                        }
                        z = z2;
                        i4 = i9;
                    } else {
                        i2 = i8;
                        double d6 = i7;
                        if (d2 >= d6 && d2 < i11) {
                            if (d >= i) {
                                d3 = d2 - d6;
                                d4 = d - ((double) i6);
                                z = z2;
                                i4 = i9;
                                if (d4 >= (d3 / ((double) (i7 - i11))) * ((double) (i6 - i10))) {
                                }
                            }
                            i9++;
                            z = z2;
                        }
                        z = z2;
                        i4 = i9;
                    }
                }
                i2 = i8;
                z = z2;
                i4 = i9;
            } else {
                if (d < i10) {
                    i = i6;
                    if (i11 >= i7) {
                    }
                }
                i2 = i8;
                z = z2;
                i4 = i9;
            }
            i8 = i2 + 1;
            i6 = i10;
            i7 = i11;
            z2 = z;
        }
        boolean z3 = z2;
        if ((i9 & 1) != 0) {
            return z3;
        }
        return false;
    }

    @Deprecated
    public Rectangle getBoundingBox() {
        int i = this.npoints;
        if (i == 0) {
            return new Rectangle();
        }
        if (this.bounds == null) {
            calculateBounds(this.xpoints, this.ypoints, i);
        }
        return this.bounds.getBounds();
    }

    @Override // org.apache.poi.java.awt.Shape
    public Rectangle getBounds() {
        return getBoundingBox();
    }

    @Override // org.apache.poi.java.awt.Shape
    public Rectangle2D getBounds2D() {
        return getBounds();
    }

    @Override // org.apache.poi.java.awt.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new PolygonPathIterator(this, affineTransform);
    }

    @Deprecated
    public boolean inside(int i, int i2) {
        return contains(i, i2);
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean intersects(double d, double d2, double d3, double d4) {
        if (this.npoints <= 0 || !getBoundingBox().intersects(d, d2, d3, d4)) {
            return false;
        }
        Crossings crossings = getCrossings(d, d2, d + d3, d2 + d4);
        return crossings == null || !crossings.isEmpty();
    }

    public void invalidate() {
        this.bounds = null;
    }

    public void reset() {
        this.npoints = 0;
        this.bounds = null;
    }

    public void translate(int i, int i2) {
        for (int i4 = 0; i4 < this.npoints; i4++) {
            int[] iArr = this.xpoints;
            iArr[i4] = iArr[i4] + i;
            int[] iArr2 = this.ypoints;
            iArr2[i4] = iArr2[i4] + i2;
        }
        Rectangle rectangle = this.bounds;
        if (rectangle != null) {
            rectangle.translate(i, i2);
        }
    }

    public void updateBounds(int i, int i2) {
        Rectangle rectangle = this.bounds;
        int i4 = rectangle.f10094x;
        int i5 = rectangle.width;
        if (i < i4) {
            rectangle.width = (i4 - i) + i5;
            rectangle.f10094x = i;
        } else {
            rectangle.width = Math.max(i5, i - i4);
        }
        Rectangle rectangle2 = this.bounds;
        int i6 = rectangle2.f10095y;
        int i7 = rectangle2.height;
        if (i2 >= i6) {
            rectangle2.height = Math.max(i7, i2 - i6);
        } else {
            rectangle2.height = (i6 - i2) + i7;
            rectangle2.f10095y = i2;
        }
    }

    public Polygon(int[] iArr, int[] iArr2, int i) {
        if (i > iArr.length || i > iArr2.length) {
            throw new IndexOutOfBoundsException("npoints > xpoints.length || npoints > ypoints.length");
        }
        if (i < 0) {
            throw new NegativeArraySizeException("npoints < 0");
        }
        this.npoints = i;
        this.xpoints = Arrays.copyOf(iArr, i);
        this.ypoints = Arrays.copyOf(iArr2, i);
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(double d, double d2, double d3, double d4) {
        double d5;
        Crossings crossings;
        return this.npoints > 0 && getBoundingBox().intersects(d, d2, d3, d4) && (crossings = getCrossings(d, d2, d + d3, (d5 = d2 + d4))) != null && crossings.covers(d2, d5);
    }

    @Override // org.apache.poi.java.awt.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform, double d) {
        return getPathIterator(affineTransform);
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean intersects(Rectangle2D rectangle2D) {
        return intersects(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public boolean contains(int i, int i2) {
        return contains(i, i2);
    }

    public boolean contains(Point point) {
        return contains(point.f10092x, point.f10093y);
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(Point2D point2D) {
        return contains(point2D.getX(), point2D.getY());
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(Rectangle2D rectangle2D) {
        return contains(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }
}
