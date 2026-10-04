package org.apache.poi.java.awt.geom;

import java.io.Serializable;
import org.apache.poi.java.awt.geom.Rectangle2D;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Ellipse2D extends RectangularShape {

    public static class Double extends Ellipse2D implements Serializable {
        private static final long serialVersionUID = 5555464816372320683L;
        public double height;
        public double width;

        /* JADX INFO: renamed from: x */
        public double f10114x;

        /* JADX INFO: renamed from: y */
        public double f10115y;

        public Double() {
        }

        @Override // org.apache.poi.java.awt.Shape
        public Rectangle2D getBounds2D() {
            return new Rectangle2D.Double(this.f10114x, this.f10115y, this.width, this.height);
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
            return this.f10114x;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public double getY() {
            return this.f10115y;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public boolean isEmpty() {
            return this.width <= 0.0d || this.height <= 0.0d;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public void setFrame(double d, double d2, double d3, double d4) {
            this.f10114x = d;
            this.f10115y = d2;
            this.width = d3;
            this.height = d4;
        }

        public Double(double d, double d2, double d3, double d4) {
            setFrame(d, d2, d3, d4);
        }
    }

    public static class Float extends Ellipse2D implements Serializable {
        private static final long serialVersionUID = -6633761252372475977L;
        public float height;
        public float width;

        /* JADX INFO: renamed from: x */
        public float f10116x;

        /* JADX INFO: renamed from: y */
        public float f10117y;

        public Float() {
        }

        @Override // org.apache.poi.java.awt.Shape
        public Rectangle2D getBounds2D() {
            return new Rectangle2D.Float(this.f10116x, this.f10117y, this.width, this.height);
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
            return this.f10116x;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public double getY() {
            return this.f10117y;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public boolean isEmpty() {
            return ((double) this.width) <= 0.0d || ((double) this.height) <= 0.0d;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public void setFrame(double d, double d2, double d3, double d4) {
            this.f10116x = (float) d;
            this.f10117y = (float) d2;
            this.width = (float) d3;
            this.height = (float) d4;
        }

        public Float(float f, float f4, float f5, float f6) {
            setFrame(f, f4, f5, f6);
        }

        public void setFrame(float f, float f4, float f5, float f6) {
            this.f10116x = f;
            this.f10117y = f4;
            this.width = f5;
            this.height = f6;
        }
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(double d, double d2) {
        double width = getWidth();
        if (width <= 0.0d) {
            return false;
        }
        double x = ((d - getX()) / width) - 0.5d;
        double height = getHeight();
        if (height <= 0.0d) {
            return false;
        }
        double y2 = ((d2 - getY()) / height) - 0.5d;
        return (y2 * y2) + (x * x) < 0.25d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Ellipse2D) {
            Ellipse2D ellipse2D = (Ellipse2D) obj;
            if (getX() == ellipse2D.getX() && getY() == ellipse2D.getY() && getWidth() == ellipse2D.getWidth() && getHeight() == ellipse2D.getHeight()) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.java.awt.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new EllipseIterator(this, affineTransform);
    }

    public int hashCode() {
        long jDoubleToLongBits = (java.lang.Double.doubleToLongBits(getHeight()) * 47) + (java.lang.Double.doubleToLongBits(getWidth()) * 43) + (java.lang.Double.doubleToLongBits(getY()) * 37) + java.lang.Double.doubleToLongBits(getX());
        return ((int) jDoubleToLongBits) ^ ((int) (jDoubleToLongBits >> 32));
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean intersects(double d, double d2, double d3, double d4) {
        double d5 = 0.0d;
        if (d3 > 0.0d && d4 > 0.0d) {
            double width = getWidth();
            if (width <= 0.0d) {
                return false;
            }
            double x = ((d - getX()) / width) - 0.5d;
            double d6 = (d3 / width) + x;
            double height = getHeight();
            if (height <= 0.0d) {
                return false;
            }
            double y2 = ((d2 - getY()) / height) - 0.5d;
            double d7 = (d4 / height) + y2;
            if (x <= 0.0d) {
                x = d6 < 0.0d ? d6 : 0.0d;
            }
            if (y2 > 0.0d) {
                d5 = y2;
            } else if (d7 < 0.0d) {
                d5 = d7;
            }
            if ((d5 * d5) + (x * x) < 0.25d) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(double d, double d2, double d3, double d4) {
        if (!contains(d, d2)) {
            return false;
        }
        double d5 = d3 + d;
        if (!contains(d5, d2)) {
            return false;
        }
        double d6 = d2 + d4;
        return contains(d, d6) && contains(d5, d6);
    }
}
