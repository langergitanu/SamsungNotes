package org.apache.poi.java.awt.geom;

import androidx.compose.foundation.layout.AbstractC1038a;
import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Rectangle2D extends RectangularShape {
    public static final int OUT_BOTTOM = 8;
    public static final int OUT_LEFT = 1;
    public static final int OUT_RIGHT = 4;
    public static final int OUT_TOP = 2;

    public static class Double extends Rectangle2D implements Serializable {
        private static final long serialVersionUID = 7771313791441850493L;
        public double height;
        public double width;

        /* JADX INFO: renamed from: x */
        public double f10138x;

        /* JADX INFO: renamed from: y */
        public double f10139y;

        public Double() {
        }

        @Override // org.apache.poi.java.awt.geom.Rectangle2D
        public Rectangle2D createIntersection(Rectangle2D rectangle2D) {
            Double r02 = new Double();
            Rectangle2D.intersect(this, rectangle2D, r02);
            return r02;
        }

        @Override // org.apache.poi.java.awt.geom.Rectangle2D
        public Rectangle2D createUnion(Rectangle2D rectangle2D) {
            Double r02 = new Double();
            Rectangle2D.union(this, rectangle2D, r02);
            return r02;
        }

        @Override // org.apache.poi.java.awt.geom.Rectangle2D, org.apache.poi.java.awt.Shape
        public Rectangle2D getBounds2D() {
            return new Double(this.f10138x, this.f10139y, this.width, this.height);
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public double getHeight() {
            return this.height;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public double getWidth() {
            return this.width;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public double getX() {
            return this.f10138x;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public double getY() {
            return this.f10139y;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public boolean isEmpty() {
            return this.width <= 0.0d || this.height <= 0.0d;
        }

        @Override // org.apache.poi.java.awt.geom.Rectangle2D
        public int outcode(double d, double d2) {
            int i;
            double d3 = this.width;
            if (d3 <= 0.0d) {
                i = 5;
            } else {
                double d4 = this.f10138x;
                i = d < d4 ? 1 : d > d4 + d3 ? 4 : 0;
            }
            double d5 = this.height;
            if (d5 <= 0.0d) {
                return i | 10;
            }
            double d6 = this.f10139y;
            return d2 < d6 ? i | 2 : d2 > d6 + d5 ? i | 8 : i;
        }

        @Override // org.apache.poi.java.awt.geom.Rectangle2D
        public void setRect(double d, double d2, double d3, double d4) {
            this.f10138x = d;
            this.f10139y = d2;
            this.width = d3;
            this.height = d4;
        }

        public String toString() {
            return getClass().getName() + "[x=" + this.f10138x + ",y=" + this.f10139y + ",w=" + this.width + ",h=" + this.height + "]";
        }

        public Double(double d, double d2, double d3, double d4) {
            setRect(d, d2, d3, d4);
        }

        @Override // org.apache.poi.java.awt.geom.Rectangle2D
        public void setRect(Rectangle2D rectangle2D) {
            this.f10138x = rectangle2D.getX();
            this.f10139y = rectangle2D.getY();
            this.width = rectangle2D.getWidth();
            this.height = rectangle2D.getHeight();
        }
    }

    public static class Float extends Rectangle2D implements Serializable {
        private static final long serialVersionUID = 3798716824173675777L;
        public float height;
        public float width;

        /* JADX INFO: renamed from: x */
        public float f10140x;

        /* JADX INFO: renamed from: y */
        public float f10141y;

        public Float() {
        }

        @Override // org.apache.poi.java.awt.geom.Rectangle2D
        public Rectangle2D createIntersection(Rectangle2D rectangle2D) {
            Rectangle2D rectangle2D2 = rectangle2D instanceof Float ? new Float() : new Double();
            Rectangle2D.intersect(this, rectangle2D, rectangle2D2);
            return rectangle2D2;
        }

        @Override // org.apache.poi.java.awt.geom.Rectangle2D
        public Rectangle2D createUnion(Rectangle2D rectangle2D) {
            Rectangle2D rectangle2D2 = rectangle2D instanceof Float ? new Float() : new Double();
            Rectangle2D.union(this, rectangle2D, rectangle2D2);
            return rectangle2D2;
        }

        @Override // org.apache.poi.java.awt.geom.Rectangle2D, org.apache.poi.java.awt.Shape
        public Rectangle2D getBounds2D() {
            return new Float(this.f10140x, this.f10141y, this.width, this.height);
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public double getHeight() {
            return this.height;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public double getWidth() {
            return this.width;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public double getX() {
            return this.f10140x;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public double getY() {
            return this.f10141y;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public boolean isEmpty() {
            return this.width <= 0.0f || this.height <= 0.0f;
        }

        @Override // org.apache.poi.java.awt.geom.Rectangle2D
        public int outcode(double d, double d2) {
            int i;
            float f = this.width;
            if (f <= 0.0f) {
                i = 5;
            } else {
                float f4 = this.f10140x;
                i = d < ((double) f4) ? 1 : d > ((double) f4) + ((double) f) ? 4 : 0;
            }
            float f5 = this.height;
            if (f5 <= 0.0f) {
                return i | 10;
            }
            float f6 = this.f10141y;
            return d2 < ((double) f6) ? i | 2 : d2 > ((double) f6) + ((double) f5) ? i | 8 : i;
        }

        @Override // org.apache.poi.java.awt.geom.Rectangle2D
        public void setRect(double d, double d2, double d3, double d4) {
            this.f10140x = (float) d;
            this.f10141y = (float) d2;
            this.width = (float) d3;
            this.height = (float) d4;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append("[x=");
            sb.append(this.f10140x);
            sb.append(",y=");
            sb.append(this.f10141y);
            sb.append(",w=");
            sb.append(this.width);
            sb.append(",h=");
            return AbstractC1038a.m1217r(sb, "]", this.height);
        }

        public Float(float f, float f4, float f5, float f6) {
            setRect(f, f4, f5, f6);
        }

        public void setRect(float f, float f4, float f5, float f6) {
            this.f10140x = f;
            this.f10141y = f4;
            this.width = f5;
            this.height = f6;
        }

        @Override // org.apache.poi.java.awt.geom.Rectangle2D
        public void setRect(Rectangle2D rectangle2D) {
            this.f10140x = (float) rectangle2D.getX();
            this.f10141y = (float) rectangle2D.getY();
            this.width = (float) rectangle2D.getWidth();
            this.height = (float) rectangle2D.getHeight();
        }
    }

    public static void intersect(Rectangle2D rectangle2D, Rectangle2D rectangle2D2, Rectangle2D rectangle2D3) {
        double dMax = Math.max(rectangle2D.getMinX(), rectangle2D2.getMinX());
        double dMax2 = Math.max(rectangle2D.getMinY(), rectangle2D2.getMinY());
        rectangle2D3.setFrame(dMax, dMax2, Math.min(rectangle2D.getMaxX(), rectangle2D2.getMaxX()) - dMax, Math.min(rectangle2D.getMaxY(), rectangle2D2.getMaxY()) - dMax2);
    }

    public static void union(Rectangle2D rectangle2D, Rectangle2D rectangle2D2, Rectangle2D rectangle2D3) {
        rectangle2D3.setFrameFromDiagonal(Math.min(rectangle2D.getMinX(), rectangle2D2.getMinX()), Math.min(rectangle2D.getMinY(), rectangle2D2.getMinY()), Math.max(rectangle2D.getMaxX(), rectangle2D2.getMaxX()), Math.max(rectangle2D.getMaxY(), rectangle2D2.getMaxY()));
    }

    public void add(double d, double d2) {
        double dMin = Math.min(getMinX(), d);
        double dMax = Math.max(getMaxX(), d);
        double dMin2 = Math.min(getMinY(), d2);
        setRect(dMin, dMin2, dMax - dMin, Math.max(getMaxY(), d2) - dMin2);
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(double d, double d2) {
        double x = getX();
        double y2 = getY();
        return d >= x && d2 >= y2 && d < getWidth() + x && d2 < getHeight() + y2;
    }

    public abstract Rectangle2D createIntersection(Rectangle2D rectangle2D);

    public abstract Rectangle2D createUnion(Rectangle2D rectangle2D);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Rectangle2D) {
            Rectangle2D rectangle2D = (Rectangle2D) obj;
            if (getX() == rectangle2D.getX() && getY() == rectangle2D.getY() && getWidth() == rectangle2D.getWidth() && getHeight() == rectangle2D.getHeight()) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.java.awt.Shape
    public Rectangle2D getBounds2D() {
        return (Rectangle2D) clone();
    }

    @Override // org.apache.poi.java.awt.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new RectIterator(this, affineTransform);
    }

    public int hashCode() {
        long jDoubleToLongBits = (java.lang.Double.doubleToLongBits(getHeight()) * 47) + (java.lang.Double.doubleToLongBits(getWidth()) * 43) + (java.lang.Double.doubleToLongBits(getY()) * 37) + java.lang.Double.doubleToLongBits(getX());
        return ((int) jDoubleToLongBits) ^ ((int) (jDoubleToLongBits >> 32));
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean intersects(double d, double d2, double d3, double d4) {
        if (!isEmpty() && d3 > 0.0d && d4 > 0.0d) {
            double x = getX();
            double y2 = getY();
            if (d3 + d > x && d4 + d2 > y2 && d < getWidth() + x && d2 < getHeight() + y2) {
                return true;
            }
        }
        return false;
    }

    public boolean intersectsLine(double d, double d2, double d3, double d4) {
        int iOutcode = outcode(d3, d4);
        if (iOutcode == 0) {
            return true;
        }
        double d5 = d;
        double d6 = d2;
        while (true) {
            int iOutcode2 = outcode(d5, d6);
            if (iOutcode2 == 0) {
                return true;
            }
            if ((iOutcode2 & iOutcode) != 0) {
                return false;
            }
            if ((iOutcode2 & 5) != 0) {
                double x = getX();
                if ((iOutcode2 & 4) != 0) {
                    x = getWidth() + x;
                }
                d6 = (((d4 - d6) * (x - d5)) / (d3 - d5)) + d6;
                d5 = x;
            } else {
                double y2 = getY();
                if ((iOutcode2 & 8) != 0) {
                    y2 = getHeight() + y2;
                }
                d5 = (((d3 - d5) * (y2 - d6)) / (d4 - d6)) + d5;
                d6 = y2;
            }
        }
    }

    public abstract int outcode(double d, double d2);

    public int outcode(Point2D point2D) {
        return outcode(point2D.getX(), point2D.getY());
    }

    @Override // org.apache.poi.java.awt.geom.RectangularShape
    public void setFrame(double d, double d2, double d3, double d4) {
        setRect(d, d2, d3, d4);
    }

    public abstract void setRect(double d, double d2, double d3, double d4);

    public void setRect(Rectangle2D rectangle2D) {
        setRect(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public void add(Point2D point2D) {
        add(point2D.getX(), point2D.getY());
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(double d, double d2, double d3, double d4) {
        if (!isEmpty() && d3 > 0.0d && d4 > 0.0d) {
            double x = getX();
            double y2 = getY();
            if (d >= x && d2 >= y2 && d + d3 <= getWidth() + x && d2 + d4 <= getHeight() + y2) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.java.awt.geom.RectangularShape, org.apache.poi.java.awt.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform, double d) {
        return new RectIterator(this, affineTransform);
    }

    public boolean intersectsLine(Line2D line2D) {
        return intersectsLine(line2D.getX1(), line2D.getY1(), line2D.getX2(), line2D.getY2());
    }

    public void add(Rectangle2D rectangle2D) {
        double dMin = Math.min(getMinX(), rectangle2D.getMinX());
        double dMax = Math.max(getMaxX(), rectangle2D.getMaxX());
        double dMin2 = Math.min(getMinY(), rectangle2D.getMinY());
        setRect(dMin, dMin2, dMax - dMin, Math.max(getMaxY(), rectangle2D.getMaxY()) - dMin2);
    }
}
