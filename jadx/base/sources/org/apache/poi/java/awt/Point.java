package org.apache.poi.java.awt;

import androidx.glance.AbstractC2821a;
import java.beans.Transient;
import java.io.Serializable;
import org.apache.poi.java.awt.geom.Point2D;

/* JADX INFO: loaded from: classes10.dex */
public class Point extends Point2D implements Serializable {
    private static final long serialVersionUID = -5276940640259749850L;

    /* JADX INFO: renamed from: x */
    public int f10092x;

    /* JADX INFO: renamed from: y */
    public int f10093y;

    public Point() {
        this(0, 0);
    }

    @Override // org.apache.poi.java.awt.geom.Point2D
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return super.equals(obj);
        }
        Point point = (Point) obj;
        return this.f10092x == point.f10092x && this.f10093y == point.f10093y;
    }

    @Transient
    public Point getLocation() {
        return new Point(this.f10092x, this.f10093y);
    }

    @Override // org.apache.poi.java.awt.geom.Point2D
    public double getX() {
        return this.f10092x;
    }

    @Override // org.apache.poi.java.awt.geom.Point2D
    public double getY() {
        return this.f10093y;
    }

    public void move(int i, int i2) {
        this.f10092x = i;
        this.f10093y = i2;
    }

    @Override // org.apache.poi.java.awt.geom.Point2D
    public void setLocation(double d, double d2) {
        this.f10092x = (int) Math.floor(d + 0.5d);
        this.f10093y = (int) Math.floor(d2 + 0.5d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[x=");
        sb.append(this.f10092x);
        sb.append(",y=");
        return AbstractC2821a.m2223n(sb, "]", this.f10093y);
    }

    public void translate(int i, int i2) {
        this.f10092x += i;
        this.f10093y += i2;
    }

    public Point(int i, int i2) {
        this.f10092x = i;
        this.f10093y = i2;
    }

    public void setLocation(int i, int i2) {
        move(i, i2);
    }

    public Point(Point point) {
        this(point.f10092x, point.f10093y);
    }

    public void setLocation(Point point) {
        setLocation(point.f10092x, point.f10093y);
    }
}
