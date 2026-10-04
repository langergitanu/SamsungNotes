package org.apache.poi.java.awt.geom;

import androidx.glance.AbstractC2821a;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.geom.Rectangle2D;
import p001A.AbstractC0000a;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Arc2D extends RectangularShape {
    public static final int CHORD = 1;
    public static final int OPEN = 0;
    public static final int PIE = 2;
    private int type;

    public static class Double extends Arc2D implements Serializable {
        private static final long serialVersionUID = 728264085846882001L;
        public double extent;
        public double height;
        public double start;
        public double width;

        /* JADX INFO: renamed from: x */
        public double f10105x;

        /* JADX INFO: renamed from: y */
        public double f10106y;

        public Double() {
            super(0);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            try {
                setArcType(objectInputStream.readByte());
            } catch (IllegalArgumentException e) {
                throw new InvalidObjectException(e.getMessage());
            }
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeByte(getArcType());
        }

        @Override // org.apache.poi.java.awt.geom.Arc2D
        public double getAngleExtent() {
            return this.extent;
        }

        @Override // org.apache.poi.java.awt.geom.Arc2D
        public double getAngleStart() {
            return this.start;
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
            return this.f10105x;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public double getY() {
            return this.f10106y;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public boolean isEmpty() {
            return this.width <= 0.0d || this.height <= 0.0d;
        }

        @Override // org.apache.poi.java.awt.geom.Arc2D
        public Rectangle2D makeBounds(double d, double d2, double d3, double d4) {
            return new Rectangle2D.Double(d, d2, d3, d4);
        }

        @Override // org.apache.poi.java.awt.geom.Arc2D
        public void setAngleExtent(double d) {
            this.extent = d;
        }

        @Override // org.apache.poi.java.awt.geom.Arc2D
        public void setAngleStart(double d) {
            this.start = d;
        }

        @Override // org.apache.poi.java.awt.geom.Arc2D
        public void setArc(double d, double d2, double d3, double d4, double d5, double d6, int i) {
            setArcType(i);
            this.f10105x = d;
            this.f10106y = d2;
            this.width = d3;
            this.height = d4;
            this.start = d5;
            this.extent = d6;
        }

        public Double(double d, double d2, double d3, double d4, double d5, double d6, int i) {
            super(i);
            this.f10105x = d;
            this.f10106y = d2;
            this.width = d3;
            this.height = d4;
            this.start = d5;
            this.extent = d6;
        }

        public Double(int i) {
            super(i);
        }

        public Double(Rectangle2D rectangle2D, double d, double d2, int i) {
            super(i);
            this.f10105x = rectangle2D.getX();
            this.f10106y = rectangle2D.getY();
            this.width = rectangle2D.getWidth();
            this.height = rectangle2D.getHeight();
            this.start = d;
            this.extent = d2;
        }
    }

    public static class Float extends Arc2D implements Serializable {
        private static final long serialVersionUID = 9130893014586380278L;
        public float extent;
        public float height;
        public float start;
        public float width;

        /* JADX INFO: renamed from: x */
        public float f10107x;

        /* JADX INFO: renamed from: y */
        public float f10108y;

        public Float() {
            super(0);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            try {
                setArcType(objectInputStream.readByte());
            } catch (IllegalArgumentException e) {
                throw new InvalidObjectException(e.getMessage());
            }
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeByte(getArcType());
        }

        @Override // org.apache.poi.java.awt.geom.Arc2D
        public double getAngleExtent() {
            return this.extent;
        }

        @Override // org.apache.poi.java.awt.geom.Arc2D
        public double getAngleStart() {
            return this.start;
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
            return this.f10107x;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public double getY() {
            return this.f10108y;
        }

        @Override // org.apache.poi.java.awt.geom.RectangularShape
        public boolean isEmpty() {
            return ((double) this.width) <= 0.0d || ((double) this.height) <= 0.0d;
        }

        @Override // org.apache.poi.java.awt.geom.Arc2D
        public Rectangle2D makeBounds(double d, double d2, double d3, double d4) {
            return new Rectangle2D.Float((float) d, (float) d2, (float) d3, (float) d4);
        }

        @Override // org.apache.poi.java.awt.geom.Arc2D
        public void setAngleExtent(double d) {
            this.extent = (float) d;
        }

        @Override // org.apache.poi.java.awt.geom.Arc2D
        public void setAngleStart(double d) {
            this.start = (float) d;
        }

        @Override // org.apache.poi.java.awt.geom.Arc2D
        public void setArc(double d, double d2, double d3, double d4, double d5, double d6, int i) {
            setArcType(i);
            this.f10107x = (float) d;
            this.f10108y = (float) d2;
            this.width = (float) d3;
            this.height = (float) d4;
            this.start = (float) d5;
            this.extent = (float) d6;
        }

        public Float(float f, float f4, float f5, float f6, float f7, float f8, int i) {
            super(i);
            this.f10107x = f;
            this.f10108y = f4;
            this.width = f5;
            this.height = f6;
            this.start = f7;
            this.extent = f8;
        }

        public Float(int i) {
            super(i);
        }

        public Float(Rectangle2D rectangle2D, float f, float f4, int i) {
            super(i);
            this.f10107x = (float) rectangle2D.getX();
            this.f10108y = (float) rectangle2D.getY();
            this.width = (float) rectangle2D.getWidth();
            this.height = (float) rectangle2D.getHeight();
            this.start = f;
            this.extent = f4;
        }
    }

    public Arc2D() {
        this(0);
    }

    public static double normalizeDegrees(double d) {
        if (d > 180.0d) {
            if (d <= 540.0d) {
                return d - 360.0d;
            }
            double dIEEEremainder = Math.IEEEremainder(d, 360.0d);
            if (dIEEEremainder == -180.0d) {
                return 180.0d;
            }
            return dIEEEremainder;
        }
        if (d <= -180.0d) {
            if (d > -540.0d) {
                return d + 360.0d;
            }
            d = Math.IEEEremainder(d, 360.0d);
            if (d == -180.0d) {
                return 180.0d;
            }
        }
        return d;
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
        if ((y2 * y2) + (x * x) >= 0.25d) {
            return false;
        }
        double dAbs = Math.abs(getAngleExtent());
        if (dAbs >= 360.0d) {
            return true;
        }
        boolean zContainsAngle = containsAngle(-Math.toDegrees(Math.atan2(y2, x)));
        if (this.type == 2) {
            return zContainsAngle;
        }
        if (zContainsAngle) {
            if (dAbs >= 180.0d) {
                return true;
            }
        } else if (dAbs <= 180.0d) {
            return false;
        }
        double radians = Math.toRadians(-getAngleStart());
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double radians2 = Math.toRadians(-getAngleExtent()) + radians;
        double dCos2 = Math.cos(radians2);
        double dSin2 = Math.sin(radians2);
        boolean z = Line2D.relativeCCW(dCos, dSin, dCos2, dSin2, x * 2.0d, y2 * 2.0d) * Line2D.relativeCCW(dCos, dSin, dCos2, dSin2, 0.0d, 0.0d) >= 0;
        return zContainsAngle ? !z : z;
    }

    public boolean containsAngle(double d) {
        double angleExtent = getAngleExtent();
        boolean z = angleExtent < 0.0d;
        if (z) {
            angleExtent = -angleExtent;
        }
        if (angleExtent >= 360.0d) {
            return true;
        }
        double dNormalizeDegrees = normalizeDegrees(d) - normalizeDegrees(getAngleStart());
        if (z) {
            dNormalizeDegrees = -dNormalizeDegrees;
        }
        if (dNormalizeDegrees < 0.0d) {
            dNormalizeDegrees += 360.0d;
        }
        return dNormalizeDegrees >= 0.0d && dNormalizeDegrees < angleExtent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Arc2D) {
            Arc2D arc2D = (Arc2D) obj;
            if (getX() == arc2D.getX() && getY() == arc2D.getY() && getWidth() == arc2D.getWidth() && getHeight() == arc2D.getHeight() && getAngleStart() == arc2D.getAngleStart() && getAngleExtent() == arc2D.getAngleExtent() && getArcType() == arc2D.getArcType()) {
                return true;
            }
        }
        return false;
    }

    public abstract double getAngleExtent();

    public abstract double getAngleStart();

    public int getArcType() {
        return this.type;
    }

    @Override // org.apache.poi.java.awt.Shape
    public Rectangle2D getBounds2D() {
        double dMin;
        double d;
        double width;
        double height;
        double y2;
        double x;
        Arc2D arc2D;
        if (isEmpty()) {
            x = getX();
            y2 = getY();
            width = getWidth();
            height = getHeight();
            arc2D = this;
        } else {
            if (getArcType() == 2) {
                dMin = 0.0d;
                d = 0.0d;
            } else {
                dMin = 1.0d;
                d = -1.0d;
            }
            double dMax = d;
            int i = 0;
            double angleStart = 0.0d;
            double d2 = dMax;
            double dMin2 = dMin;
            while (i < 6) {
                if (i < 4) {
                    angleStart += 90.0d;
                    if (!containsAngle(angleStart)) {
                    }
                    i++;
                } else {
                    angleStart = i == 4 ? getAngleStart() : angleStart + getAngleExtent();
                }
                double radians = Math.toRadians(-angleStart);
                double d3 = angleStart;
                double dCos = Math.cos(radians);
                double dSin = Math.sin(radians);
                dMin = Math.min(dMin, dCos);
                dMin2 = Math.min(dMin2, dSin);
                double dMax2 = Math.max(d2, dCos);
                dMax = Math.max(dMax, dSin);
                d2 = dMax2;
                angleStart = d3;
                i++;
            }
            double width2 = getWidth();
            double height2 = getHeight();
            width = (d2 - dMin) * 0.5d * width2;
            height = (dMax - dMin2) * 0.5d * height2;
            double x2 = (((dMin * 0.5d) + 0.5d) * width2) + getX();
            y2 = getY() + (((dMin2 * 0.5d) + 0.5d) * height2);
            x = x2;
            arc2D = this;
        }
        return arc2D.makeBounds(x, y2, width, height);
    }

    public Point2D getEndPoint() {
        double radians = Math.toRadians((-getAngleStart()) - getAngleExtent());
        return new Point2D.Double((getWidth() * AbstractC2821a.m2210a(radians, 0.5d, 0.5d)) + getX(), (getHeight() * AbstractC0000a.m5b(radians, 0.5d, 0.5d)) + getY());
    }

    @Override // org.apache.poi.java.awt.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new ArcIterator(this, affineTransform);
    }

    public Point2D getStartPoint() {
        double radians = Math.toRadians(-getAngleStart());
        return new Point2D.Double((getWidth() * AbstractC2821a.m2210a(radians, 0.5d, 0.5d)) + getX(), (getHeight() * AbstractC0000a.m5b(radians, 0.5d, 0.5d)) + getY());
    }

    public int hashCode() {
        long jDoubleToLongBits = (java.lang.Double.doubleToLongBits(getAngleExtent()) * 59) + (java.lang.Double.doubleToLongBits(getAngleStart()) * 53) + (java.lang.Double.doubleToLongBits(getHeight()) * 47) + (java.lang.Double.doubleToLongBits(getWidth()) * 43) + (java.lang.Double.doubleToLongBits(getY()) * 37) + java.lang.Double.doubleToLongBits(getX()) + ((long) (getArcType() * 61));
        return ((int) jDoubleToLongBits) ^ ((int) (jDoubleToLongBits >> 32));
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean intersects(double d, double d2, double d3, double d4) {
        double width = getWidth();
        double height = getHeight();
        if (d3 <= 0.0d || d4 <= 0.0d || width <= 0.0d || height <= 0.0d) {
            return false;
        }
        double angleExtent = getAngleExtent();
        if (angleExtent == 0.0d) {
            return false;
        }
        double x = getX();
        double y2 = getY();
        double d5 = width + x;
        double d6 = height + y2;
        double d7 = d + d3;
        double d8 = d2 + d4;
        if (d >= d5 || d2 >= d6 || d7 <= x || d8 <= y2) {
            return false;
        }
        double centerX = getCenterX();
        double centerY = getCenterY();
        Point2D startPoint = getStartPoint();
        Point2D endPoint = getEndPoint();
        double x2 = startPoint.getX();
        double y3 = startPoint.getY();
        double x5 = endPoint.getX();
        double y4 = endPoint.getY();
        if (centerY >= d2 && centerY <= d8 && ((x2 < d7 && x5 < d7 && centerX < d7 && d5 > d && containsAngle(0.0d)) || (x2 > d && x5 > d && centerX > d && x < d7 && containsAngle(180.0d)))) {
            return true;
        }
        if (centerX >= d && centerX <= d7 && ((y3 > d2 && y4 > d2 && centerY > d2 && y2 < d8 && containsAngle(90.0d)) || (y3 < d8 && y4 < d8 && centerY < d8 && d6 > d2 && containsAngle(270.0d)))) {
            return true;
        }
        Rectangle2D.Double r20 = new Rectangle2D.Double(d, d2, d3, d4);
        if (this.type == 2 || Math.abs(angleExtent) > 180.0d) {
            if (!r20.intersectsLine(centerX, centerY, x2, y3) && !r20.intersectsLine(centerX, centerY, x5, y4)) {
            }
        }
        if (r20.intersectsLine(x2, y3, x5, y4)) {
            return true;
        }
        return contains(d, d2) || contains(d7, d2) || contains(d, d8) || contains(d7, d8);
    }

    public abstract Rectangle2D makeBounds(double d, double d2, double d3, double d4);

    public abstract void setAngleExtent(double d);

    public abstract void setAngleStart(double d);

    public void setAngleStart(Point2D point2D) {
        setAngleStart(-Math.toDegrees(Math.atan2((point2D.getY() - getCenterY()) * getWidth(), (point2D.getX() - getCenterX()) * getHeight())));
    }

    public void setAngles(double d, double d2, double d3, double d4) {
        double centerX = getCenterX();
        double centerY = getCenterY();
        double width = getWidth();
        double height = getHeight();
        double dAtan2 = Math.atan2((centerY - d2) * width, (d - centerX) * height);
        double dAtan22 = Math.atan2((centerY - d4) * width, (d3 - centerX) * height) - dAtan2;
        if (dAtan22 <= 0.0d) {
            dAtan22 += 6.283185307179586d;
        }
        setAngleStart(Math.toDegrees(dAtan2));
        setAngleExtent(Math.toDegrees(dAtan22));
    }

    public abstract void setArc(double d, double d2, double d3, double d4, double d5, double d6, int i);

    public void setArc(Arc2D arc2D) {
        setArc(arc2D.getX(), arc2D.getY(), arc2D.getWidth(), arc2D.getHeight(), arc2D.getAngleStart(), arc2D.getAngleExtent(), arc2D.type);
    }

    public void setArcByCenter(double d, double d2, double d3, double d4, double d5, int i) {
        double d6 = 2.0d * d3;
        setArc(d - d3, d2 - d3, d6, d6, d4, d5, i);
    }

    public void setArcByTangent(Point2D point2D, Point2D point2D2, Point2D point2D3, double d) {
        double d2;
        double d3;
        double dAtan2 = Math.atan2(point2D.getY() - point2D2.getY(), point2D.getX() - point2D2.getX());
        double dAtan22 = Math.atan2(point2D3.getY() - point2D2.getY(), point2D3.getX() - point2D2.getX());
        double d4 = dAtan22 - dAtan2;
        if (d4 > 3.141592653589793d) {
            dAtan22 -= 6.283185307179586d;
        } else if (d4 < -3.141592653589793d) {
            dAtan22 += 6.283185307179586d;
        }
        double d5 = (dAtan2 + dAtan22) / 2.0d;
        double dSin = d / Math.sin(Math.abs(dAtan22 - d5));
        double dM2210a = AbstractC2821a.m2210a(d5, dSin, point2D2.getX());
        double dM5b = AbstractC0000a.m5b(d5, dSin, point2D2.getY());
        if (dAtan2 < dAtan22) {
            d2 = dAtan2 - 1.5707963267948966d;
            d3 = dAtan22 + 1.5707963267948966d;
        } else {
            d2 = dAtan2 + 1.5707963267948966d;
            d3 = dAtan22 - 1.5707963267948966d;
        }
        double degrees = Math.toDegrees(-d2);
        double degrees2 = Math.toDegrees(-d3) - degrees;
        setArcByCenter(dM2210a, dM5b, d, degrees, degrees2 < 0.0d ? degrees2 + 360.0d : degrees2 - 360.0d, this.type);
    }

    public void setArcType(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "invalid type for Arc: "));
        }
        this.type = i;
    }

    @Override // org.apache.poi.java.awt.geom.RectangularShape
    public void setFrame(double d, double d2, double d3, double d4) {
        setArc(d, d2, d3, d4, getAngleStart(), getAngleExtent(), this.type);
    }

    public Arc2D(int i) {
        setArcType(i);
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(double d, double d2, double d3, double d4) {
        return contains(d, d2, d3, d4, null);
    }

    public void setAngles(Point2D point2D, Point2D point2D2) {
        setAngles(point2D.getX(), point2D.getY(), point2D2.getX(), point2D2.getY());
    }

    public void setArc(Point2D point2D, Dimension2D dimension2D, double d, double d2, int i) {
        setArc(point2D.getX(), point2D.getY(), dimension2D.getWidth(), dimension2D.getHeight(), d, d2, i);
    }

    private boolean contains(double d, double d2, double d3, double d4, Rectangle2D rectangle2D) {
        if (contains(d, d2)) {
            double d5 = d + d3;
            if (contains(d5, d2)) {
                double d6 = d2 + d4;
                if (contains(d, d6) && contains(d5, d6)) {
                    if (this.type != 2 || Math.abs(getAngleExtent()) <= 180.0d) {
                        return true;
                    }
                    Rectangle2D rectangle2D2 = rectangle2D == null ? new Rectangle2D.Double(d, d2, d3, d4) : rectangle2D;
                    double width = getWidth() / 2.0d;
                    double height = getHeight() / 2.0d;
                    double x = getX() + width;
                    double y2 = getY() + height;
                    double radians = Math.toRadians(-getAngleStart());
                    if (rectangle2D2.intersectsLine(x, y2, AbstractC2821a.m2210a(radians, width, x), AbstractC0000a.m5b(radians, height, y2))) {
                        return false;
                    }
                    double radians2 = Math.toRadians(-getAngleExtent()) + radians;
                    return !r21.intersectsLine(x, y2, AbstractC2821a.m2210a(radians2, width, x), AbstractC0000a.m5b(radians2, height, y2));
                }
            }
        }
        return false;
    }

    public void setArc(Rectangle2D rectangle2D, double d, double d2, int i) {
        setArc(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight(), d, d2, i);
    }

    @Override // org.apache.poi.java.awt.geom.RectangularShape, org.apache.poi.java.awt.Shape
    public boolean contains(Rectangle2D rectangle2D) {
        return contains(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight(), rectangle2D);
    }
}
