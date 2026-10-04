package org.apache.poi.java.awt.geom;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Point2D implements Cloneable {

    public static class Double extends Point2D implements Serializable {
        private static final long serialVersionUID = 6150783262733311327L;

        /* JADX INFO: renamed from: x */
        public double f10130x;

        /* JADX INFO: renamed from: y */
        public double f10131y;

        public Double() {
        }

        @Override // org.apache.poi.java.awt.geom.Point2D
        public double getX() {
            return this.f10130x;
        }

        @Override // org.apache.poi.java.awt.geom.Point2D
        public double getY() {
            return this.f10131y;
        }

        @Override // org.apache.poi.java.awt.geom.Point2D
        public void setLocation(double d, double d2) {
            this.f10130x = d;
            this.f10131y = d2;
        }

        public String toString() {
            return "Point2D.Double[" + this.f10130x + SQLKeyword.COMMA + this.f10131y + "]";
        }

        public Double(double d, double d2) {
            this.f10130x = d;
            this.f10131y = d2;
        }
    }

    public static class Float extends Point2D implements Serializable {
        private static final long serialVersionUID = -2870572449815403710L;

        /* JADX INFO: renamed from: x */
        public float f10132x;

        /* JADX INFO: renamed from: y */
        public float f10133y;

        public Float() {
        }

        @Override // org.apache.poi.java.awt.geom.Point2D
        public double getX() {
            return this.f10132x;
        }

        @Override // org.apache.poi.java.awt.geom.Point2D
        public double getY() {
            return this.f10133y;
        }

        @Override // org.apache.poi.java.awt.geom.Point2D
        public void setLocation(double d, double d2) {
            this.f10132x = (float) d;
            this.f10133y = (float) d2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Point2D.Float[");
            sb.append(this.f10132x);
            sb.append(SQLKeyword.COMMA);
            return AbstractC1038a.m1217r(sb, "]", this.f10133y);
        }

        public Float(float f, float f4) {
            this.f10132x = f;
            this.f10133y = f4;
        }

        public void setLocation(float f, float f4) {
            this.f10132x = f;
            this.f10133y = f4;
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public double distance(double d, double d2) {
        double x = d - getX();
        double y2 = d2 - getY();
        return Math.sqrt((y2 * y2) + (x * x));
    }

    public double distanceSq(double d, double d2) {
        double x = d - getX();
        double y2 = d2 - getY();
        return (y2 * y2) + (x * x);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Point2D)) {
            return super.equals(obj);
        }
        Point2D point2D = (Point2D) obj;
        return getX() == point2D.getX() && getY() == point2D.getY();
    }

    public abstract double getX();

    public abstract double getY();

    public int hashCode() {
        long jDoubleToLongBits = java.lang.Double.doubleToLongBits(getX()) ^ (java.lang.Double.doubleToLongBits(getY()) * 31);
        return ((int) (jDoubleToLongBits >> 32)) ^ ((int) jDoubleToLongBits);
    }

    public abstract void setLocation(double d, double d2);

    public void setLocation(Point2D point2D) {
        setLocation(point2D.getX(), point2D.getY());
    }

    public static double distance(double d, double d2, double d3, double d4) {
        double d5 = d - d3;
        double d6 = d2 - d4;
        return Math.sqrt((d6 * d6) + (d5 * d5));
    }

    public static double distanceSq(double d, double d2, double d3, double d4) {
        double d5 = d - d3;
        double d6 = d2 - d4;
        return (d6 * d6) + (d5 * d5);
    }

    public double distance(Point2D point2D) {
        double x = point2D.getX() - getX();
        double y2 = point2D.getY() - getY();
        return Math.sqrt((y2 * y2) + (x * x));
    }

    public double distanceSq(Point2D point2D) {
        double x = point2D.getX() - getX();
        double y2 = point2D.getY() - getY();
        return (y2 * y2) + (x * x);
    }
}
