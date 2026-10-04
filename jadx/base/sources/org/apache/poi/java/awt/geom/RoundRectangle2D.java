package org.apache.poi.java.awt.geom;

import java.io.Serializable;
import org.apache.poi.java.awt.geom.Rectangle2D;

/* JADX INFO: loaded from: classes10.dex */
public abstract class RoundRectangle2D extends RectangularShape {

    public static class Double extends RoundRectangle2D implements Serializable {
        private static final long serialVersionUID = 1048939333485206117L;
        public double archeight;
        public double arcwidth;
        public double height;
        public double width;

        /* JADX INFO: renamed from: x */
        public double f10152x;

        /* JADX INFO: renamed from: y */
        public double f10153y;

        public Double() {
        }

        @Override // org.apache.poi.java.awt.geom.RoundRectangle2D
        public double getArcHeight() {
            return this.archeight;
        }

        @Override // org.apache.poi.java.awt.geom.RoundRectangle2D
        public double getArcWidth() {
            return this.arcwidth;
        }

        @Override // org.apache.poi.java.awt.Shape
        public Rectangle2D getBounds2D() {
            return new Rectangle2D.Double(this.f10152x, this.f10153y, this.width, this.height);
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
            return this.f10152x;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public double getY() {
            return this.f10153y;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public boolean isEmpty() {
            return this.width <= 0.0d || this.height <= 0.0d;
        }

        @Override // org.apache.poi.java.awt.geom.RoundRectangle2D
        public void setRoundRect(double d, double d2, double d3, double d4, double d5, double d6) {
            this.f10152x = d;
            this.f10153y = d2;
            this.width = d3;
            this.height = d4;
            this.arcwidth = d5;
            this.archeight = d6;
        }

        public Double(double d, double d2, double d3, double d4, double d5, double d6) {
            setRoundRect(d, d2, d3, d4, d5, d6);
        }

        @Override // org.apache.poi.java.awt.geom.RoundRectangle2D
        public void setRoundRect(RoundRectangle2D roundRectangle2D) {
            this.f10152x = roundRectangle2D.getX();
            this.f10153y = roundRectangle2D.getY();
            this.width = roundRectangle2D.getWidth();
            this.height = roundRectangle2D.getHeight();
            this.arcwidth = roundRectangle2D.getArcWidth();
            this.archeight = roundRectangle2D.getArcHeight();
        }
    }

    public static class Float extends RoundRectangle2D implements Serializable {
        private static final long serialVersionUID = -3423150618393866922L;
        public float archeight;
        public float arcwidth;
        public float height;
        public float width;

        /* JADX INFO: renamed from: x */
        public float f10154x;

        /* JADX INFO: renamed from: y */
        public float f10155y;

        public Float() {
        }

        @Override // org.apache.poi.java.awt.geom.RoundRectangle2D
        public double getArcHeight() {
            return this.archeight;
        }

        @Override // org.apache.poi.java.awt.geom.RoundRectangle2D
        public double getArcWidth() {
            return this.arcwidth;
        }

        @Override // org.apache.poi.java.awt.Shape
        public Rectangle2D getBounds2D() {
            return new Rectangle2D.Float(this.f10154x, this.f10155y, this.width, this.height);
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
            return this.f10154x;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public double getY() {
            return this.f10155y;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public boolean isEmpty() {
            return this.width <= 0.0f || this.height <= 0.0f;
        }

        @Override // org.apache.poi.java.awt.geom.RoundRectangle2D
        public void setRoundRect(double d, double d2, double d3, double d4, double d5, double d6) {
            this.f10154x = (float) d;
            this.f10155y = (float) d2;
            this.width = (float) d3;
            this.height = (float) d4;
            this.arcwidth = (float) d5;
            this.archeight = (float) d6;
        }

        public Float(float f, float f4, float f5, float f6, float f7, float f8) {
            setRoundRect(f, f4, f5, f6, f7, f8);
        }

        public void setRoundRect(float f, float f4, float f5, float f6, float f7, float f8) {
            this.f10154x = f;
            this.f10155y = f4;
            this.width = f5;
            this.height = f6;
            this.arcwidth = f7;
            this.archeight = f8;
        }

        @Override // org.apache.poi.java.awt.geom.RoundRectangle2D
        public void setRoundRect(RoundRectangle2D roundRectangle2D) {
            this.f10154x = (float) roundRectangle2D.getX();
            this.f10155y = (float) roundRectangle2D.getY();
            this.width = (float) roundRectangle2D.getWidth();
            this.height = (float) roundRectangle2D.getHeight();
            this.arcwidth = (float) roundRectangle2D.getArcWidth();
            this.archeight = (float) roundRectangle2D.getArcHeight();
        }
    }

    private int classify(double d, double d2, double d3, double d4) {
        if (d < d2) {
            return 0;
        }
        if (d < d2 + d4) {
            return 1;
        }
        if (d < d3 - d4) {
            return 2;
        }
        return d < d3 ? 3 : 4;
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(double d, double d2) {
        if (isEmpty()) {
            return false;
        }
        double x = getX();
        double y2 = getY();
        double width = getWidth() + x;
        double height = getHeight() + y2;
        if (d < x || d2 < y2 || d >= width || d2 >= height) {
            return false;
        }
        double dMin = Math.min(getWidth(), Math.abs(getArcWidth())) / 2.0d;
        double dMin2 = Math.min(getHeight(), Math.abs(getArcHeight())) / 2.0d;
        double d3 = x + dMin;
        if (d >= d3) {
            d3 = width - dMin;
            if (d < d3) {
                return true;
            }
        }
        double d4 = y2 + dMin2;
        if (d2 >= d4) {
            d4 = height - dMin2;
            if (d2 < d4) {
                return true;
            }
        }
        double d5 = (d - d3) / dMin;
        double d6 = (d2 - d4) / dMin2;
        return (d6 * d6) + (d5 * d5) <= 1.0d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RoundRectangle2D) {
            RoundRectangle2D roundRectangle2D = (RoundRectangle2D) obj;
            if (getX() == roundRectangle2D.getX() && getY() == roundRectangle2D.getY() && getWidth() == roundRectangle2D.getWidth() && getHeight() == roundRectangle2D.getHeight() && getArcWidth() == roundRectangle2D.getArcWidth() && getArcHeight() == roundRectangle2D.getArcHeight()) {
                return true;
            }
        }
        return false;
    }

    public abstract double getArcHeight();

    public abstract double getArcWidth();

    @Override // org.apache.poi.java.awt.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new RoundRectIterator(this, affineTransform);
    }

    public int hashCode() {
        long jDoubleToLongBits = (java.lang.Double.doubleToLongBits(getArcHeight()) * 59) + (java.lang.Double.doubleToLongBits(getArcWidth()) * 53) + (java.lang.Double.doubleToLongBits(getHeight()) * 47) + (java.lang.Double.doubleToLongBits(getWidth()) * 43) + (java.lang.Double.doubleToLongBits(getY()) * 37) + java.lang.Double.doubleToLongBits(getX());
        return ((int) jDoubleToLongBits) ^ ((int) (jDoubleToLongBits >> 32));
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean intersects(double d, double d2, double d3, double d4) {
        if (isEmpty() || d3 <= 0.0d || d4 <= 0.0d) {
            return false;
        }
        double x = getX();
        double y2 = getY();
        double width = getWidth() + x;
        double height = getHeight() + y2;
        double d5 = d + d3;
        if (d5 > x && d < width) {
            double d6 = d2 + d4;
            if (d6 > y2 && d2 < height) {
                double dMin = Math.min(getWidth(), Math.abs(getArcWidth())) / 2.0d;
                double dMin2 = Math.min(getHeight(), Math.abs(getArcHeight())) / 2.0d;
                int iClassify = classify(d, x, width, dMin);
                int iClassify2 = classify(d5, x, width, dMin);
                int iClassify3 = classify(d2, y2, height, dMin2);
                int iClassify4 = classify(d6, y2, height, dMin2);
                if (iClassify == 2 || iClassify2 == 2 || iClassify3 == 2 || iClassify4 == 2) {
                    return true;
                }
                if ((iClassify < 2 && iClassify2 > 2) || (iClassify3 < 2 && iClassify4 > 2)) {
                    return true;
                }
                double d7 = (iClassify2 == 1 ? d5 - (x + dMin) : d - (width - dMin)) / dMin;
                double d8 = (iClassify4 == 1 ? d6 - (y2 + dMin2) : d2 - (height - dMin2)) / dMin2;
                return (d8 * d8) + (d7 * d7) <= 1.0d;
            }
        }
        return false;
    }

    @Override // org.apache.poi.java.awt.geom.RectangularShape
    public void setFrame(double d, double d2, double d3, double d4) {
        setRoundRect(d, d2, d3, d4, getArcWidth(), getArcHeight());
    }

    public abstract void setRoundRect(double d, double d2, double d3, double d4, double d5, double d6);

    public void setRoundRect(RoundRectangle2D roundRectangle2D) {
        setRoundRect(roundRectangle2D.getX(), roundRectangle2D.getY(), roundRectangle2D.getWidth(), roundRectangle2D.getHeight(), roundRectangle2D.getArcWidth(), roundRectangle2D.getArcHeight());
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(double d, double d2, double d3, double d4) {
        if (!isEmpty() && d3 > 0.0d && d4 > 0.0d && contains(d, d2)) {
            double d5 = d3 + d;
            if (contains(d5, d2)) {
                double d6 = d2 + d4;
                if (contains(d, d6) && contains(d5, d6)) {
                    return true;
                }
            }
        }
        return false;
    }
}
