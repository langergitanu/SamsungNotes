package org.apache.poi.java.awt.geom;

import java.io.Serializable;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.Shape;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.geom.Rectangle2D;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Line2D implements Shape, Cloneable {

    public static class Double extends Line2D implements Serializable {
        private static final long serialVersionUID = 7979627399746467499L;

        /* JADX INFO: renamed from: x1 */
        public double f10122x1;

        /* JADX INFO: renamed from: x2 */
        public double f10123x2;

        /* JADX INFO: renamed from: y1 */
        public double f10124y1;

        /* JADX INFO: renamed from: y2 */
        public double f10125y2;

        public Double() {
        }

        @Override // org.apache.poi.java.awt.Shape
        public Rectangle2D getBounds2D() {
            double d;
            double d2;
            double d3;
            double d4;
            double d5 = this.f10122x1;
            double d6 = this.f10123x2;
            if (d5 < d6) {
                d2 = d5;
                d = d6 - d5;
            } else {
                d = d5 - d6;
                d2 = d6;
            }
            double d7 = this.f10124y1;
            double d8 = this.f10125y2;
            if (d7 < d8) {
                d4 = d7;
                d3 = d8 - d7;
            } else {
                d3 = d7 - d8;
                d4 = d8;
            }
            return new Rectangle2D.Double(d2, d4, d, d3);
        }

        @Override // org.apache.poi.java.awt.geom.Line2D
        public Point2D getP1() {
            return new Point2D.Double(this.f10122x1, this.f10124y1);
        }

        @Override // org.apache.poi.java.awt.geom.Line2D
        public Point2D getP2() {
            return new Point2D.Double(this.f10123x2, this.f10125y2);
        }

        @Override // org.apache.poi.java.awt.geom.Line2D
        public double getX1() {
            return this.f10122x1;
        }

        @Override // org.apache.poi.java.awt.geom.Line2D
        public double getX2() {
            return this.f10123x2;
        }

        @Override // org.apache.poi.java.awt.geom.Line2D
        public double getY1() {
            return this.f10124y1;
        }

        @Override // org.apache.poi.java.awt.geom.Line2D
        public double getY2() {
            return this.f10125y2;
        }

        @Override // org.apache.poi.java.awt.geom.Line2D
        public void setLine(double d, double d2, double d3, double d4) {
            this.f10122x1 = d;
            this.f10124y1 = d2;
            this.f10123x2 = d3;
            this.f10125y2 = d4;
        }

        public Double(double d, double d2, double d3, double d4) {
            setLine(d, d2, d3, d4);
        }

        public Double(Point2D point2D, Point2D point2D2) {
            setLine(point2D, point2D2);
        }
    }

    public static class Float extends Line2D implements Serializable {
        private static final long serialVersionUID = 6161772511649436349L;

        /* JADX INFO: renamed from: x1 */
        public float f10126x1;

        /* JADX INFO: renamed from: x2 */
        public float f10127x2;

        /* JADX INFO: renamed from: y1 */
        public float f10128y1;

        /* JADX INFO: renamed from: y2 */
        public float f10129y2;

        public Float() {
        }

        @Override // org.apache.poi.java.awt.Shape
        public Rectangle2D getBounds2D() {
            float f;
            float f4;
            float f5 = this.f10126x1;
            float f6 = this.f10127x2;
            if (f5 < f6) {
                f = f6 - f5;
            } else {
                f = f5 - f6;
                f5 = f6;
            }
            float f7 = this.f10128y1;
            float f8 = this.f10129y2;
            if (f7 < f8) {
                f4 = f8 - f7;
            } else {
                f4 = f7 - f8;
                f7 = f8;
            }
            return new Rectangle2D.Float(f5, f7, f, f4);
        }

        @Override // org.apache.poi.java.awt.geom.Line2D
        public Point2D getP1() {
            return new Point2D.Float(this.f10126x1, this.f10128y1);
        }

        @Override // org.apache.poi.java.awt.geom.Line2D
        public Point2D getP2() {
            return new Point2D.Float(this.f10127x2, this.f10129y2);
        }

        @Override // org.apache.poi.java.awt.geom.Line2D
        public double getX1() {
            return this.f10126x1;
        }

        @Override // org.apache.poi.java.awt.geom.Line2D
        public double getX2() {
            return this.f10127x2;
        }

        @Override // org.apache.poi.java.awt.geom.Line2D
        public double getY1() {
            return this.f10128y1;
        }

        @Override // org.apache.poi.java.awt.geom.Line2D
        public double getY2() {
            return this.f10129y2;
        }

        @Override // org.apache.poi.java.awt.geom.Line2D
        public void setLine(double d, double d2, double d3, double d4) {
            this.f10126x1 = (float) d;
            this.f10128y1 = (float) d2;
            this.f10127x2 = (float) d3;
            this.f10129y2 = (float) d4;
        }

        public Float(float f, float f4, float f5, float f6) {
            setLine(f, f4, f5, f6);
        }

        public void setLine(float f, float f4, float f5, float f6) {
            this.f10126x1 = f;
            this.f10128y1 = f4;
            this.f10127x2 = f5;
            this.f10129y2 = f6;
        }

        public Float(Point2D point2D, Point2D point2D2) {
            setLine(point2D, point2D2);
        }
    }

    public static boolean linesIntersect(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return relativeCCW(d, d2, d3, d4, d5, d6) * relativeCCW(d, d2, d3, d4, d7, d8) <= 0 && relativeCCW(d5, d6, d7, d8, d, d2) * relativeCCW(d5, d6, d7, d8, d3, d4) <= 0;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(double d, double d2) {
        return false;
    }

    @Override // org.apache.poi.java.awt.Shape
    public Rectangle getBounds() {
        return getBounds2D().getBounds();
    }

    public abstract Point2D getP1();

    public abstract Point2D getP2();

    @Override // org.apache.poi.java.awt.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new LineIterator(this, affineTransform);
    }

    public abstract double getX1();

    public abstract double getX2();

    public abstract double getY1();

    public abstract double getY2();

    @Override // org.apache.poi.java.awt.Shape
    public boolean intersects(double d, double d2, double d3, double d4) {
        return intersects(new Rectangle2D.Double(d, d2, d3, d4));
    }

    public boolean intersectsLine(double d, double d2, double d3, double d4) {
        return linesIntersect(d, d2, d3, d4, getX1(), getY1(), getX2(), getY2());
    }

    public double ptLineDist(double d, double d2) {
        return ptLineDist(getX1(), getY1(), getX2(), getY2(), d, d2);
    }

    public double ptLineDistSq(double d, double d2) {
        return ptLineDistSq(getX1(), getY1(), getX2(), getY2(), d, d2);
    }

    public double ptSegDist(double d, double d2) {
        return ptSegDist(getX1(), getY1(), getX2(), getY2(), d, d2);
    }

    public double ptSegDistSq(double d, double d2) {
        return ptSegDistSq(getX1(), getY1(), getX2(), getY2(), d, d2);
    }

    public int relativeCCW(double d, double d2) {
        return relativeCCW(getX1(), getY1(), getX2(), getY2(), d, d2);
    }

    public abstract void setLine(double d, double d2, double d3, double d4);

    public void setLine(Line2D line2D) {
        setLine(line2D.getX1(), line2D.getY1(), line2D.getX2(), line2D.getY2());
    }

    public static double ptLineDist(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.sqrt(ptLineDistSq(d, d2, d3, d4, d5, d6));
    }

    public static double ptLineDistSq(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d3 - d;
        double d8 = d4 - d2;
        double d9 = d5 - d;
        double d10 = d6 - d2;
        double d11 = (d10 * d8) + (d9 * d7);
        double d12 = (d10 * d10) + (d9 * d9);
        double d13 = d12 - ((d11 * d11) / ((d8 * d8) + (d7 * d7)));
        if (d13 < 0.0d) {
            return 0.0d;
        }
        return d13;
    }

    public static double ptSegDist(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.sqrt(ptSegDistSq(d, d2, d3, d4, d5, d6));
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000f A[PHI: r10 r12
      0x000f: PHI (r10v5 double) = (r10v1 double), (r10v2 double) binds: [B:3:0x000d, B:6:0x001c] A[DONT_GENERATE, DONT_INLINE]
      0x000f: PHI (r12v7 double) = (r12v1 double), (r12v2 double) binds: [B:3:0x000d, B:6:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static double ptSegDistSq(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7;
        double d8 = d3 - d;
        double d9 = d4 - d2;
        double d10 = d5 - d;
        double d11 = d6 - d2;
        if ((d11 * d9) + (d10 * d8) <= 0.0d) {
            d7 = 0.0d;
        } else {
            d10 = d8 - d10;
            d11 = d9 - d11;
            double d12 = (d11 * d9) + (d10 * d8);
            if (d12 > 0.0d) {
                d7 = (d12 * d12) / ((d9 * d9) + (d8 * d8));
            }
        }
        double d13 = ((d11 * d11) + (d10 * d10)) - d7;
        if (d13 < 0.0d) {
            return 0.0d;
        }
        return d13;
    }

    public static int relativeCCW(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d3 - d;
        double d8 = d4 - d2;
        double d9 = d5 - d;
        double d10 = d6 - d2;
        double d11 = (d9 * d8) - (d10 * d7);
        if (d11 == 0.0d) {
            d11 = (d9 * d7) + (d10 * d8);
            if (d11 > 0.0d) {
                d11 = ((d10 - d8) * d8) + ((d9 - d7) * d7);
                if (d11 < 0.0d) {
                    d11 = 0.0d;
                }
            }
        }
        if (d11 < 0.0d) {
            return -1;
        }
        return d11 > 0.0d ? 1 : 0;
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(double d, double d2, double d3, double d4) {
        return false;
    }

    @Override // org.apache.poi.java.awt.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform, double d) {
        return new LineIterator(this, affineTransform);
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean intersects(Rectangle2D rectangle2D) {
        return rectangle2D.intersectsLine(getX1(), getY1(), getX2(), getY2());
    }

    public boolean intersectsLine(Line2D line2D) {
        return linesIntersect(line2D.getX1(), line2D.getY1(), line2D.getX2(), line2D.getY2(), getX1(), getY1(), getX2(), getY2());
    }

    public void setLine(Point2D point2D, Point2D point2D2) {
        setLine(point2D.getX(), point2D.getY(), point2D2.getX(), point2D2.getY());
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(Point2D point2D) {
        return false;
    }

    public double ptLineDist(Point2D point2D) {
        return ptLineDist(getX1(), getY1(), getX2(), getY2(), point2D.getX(), point2D.getY());
    }

    public double ptLineDistSq(Point2D point2D) {
        return ptLineDistSq(getX1(), getY1(), getX2(), getY2(), point2D.getX(), point2D.getY());
    }

    public double ptSegDist(Point2D point2D) {
        return ptSegDist(getX1(), getY1(), getX2(), getY2(), point2D.getX(), point2D.getY());
    }

    public double ptSegDistSq(Point2D point2D) {
        return ptSegDistSq(getX1(), getY1(), getX2(), getY2(), point2D.getX(), point2D.getY());
    }

    public int relativeCCW(Point2D point2D) {
        return relativeCCW(getX1(), getY1(), getX2(), getY2(), point2D.getX(), point2D.getY());
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(Rectangle2D rectangle2D) {
        return false;
    }
}
