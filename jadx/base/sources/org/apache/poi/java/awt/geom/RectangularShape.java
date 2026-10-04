package org.apache.poi.java.awt.geom;

import java.beans.Transient;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.Shape;
import org.apache.poi.java.awt.geom.Rectangle2D;

/* JADX INFO: loaded from: classes10.dex */
public abstract class RectangularShape implements Shape, Cloneable {
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(Point2D point2D) {
        return contains(point2D.getX(), point2D.getY());
    }

    @Override // org.apache.poi.java.awt.Shape
    public Rectangle getBounds() {
        double width = getWidth();
        double height = getHeight();
        if (width < 0.0d || height < 0.0d) {
            return new Rectangle();
        }
        double x = getX();
        double y2 = getY();
        double dFloor = Math.floor(x);
        double dFloor2 = Math.floor(y2);
        return new Rectangle((int) dFloor, (int) dFloor2, (int) (Math.ceil(x + width) - dFloor), (int) (Math.ceil(y2 + height) - dFloor2));
    }

    public double getCenterX() {
        return (getWidth() / 2.0d) + getX();
    }

    public double getCenterY() {
        return (getHeight() / 2.0d) + getY();
    }

    @Transient
    public Rectangle2D getFrame() {
        return new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
    }

    public abstract double getHeight();

    public double getMaxX() {
        return getWidth() + getX();
    }

    public double getMaxY() {
        return getHeight() + getY();
    }

    public double getMinX() {
        return getX();
    }

    public double getMinY() {
        return getY();
    }

    @Override // org.apache.poi.java.awt.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform, double d) {
        return new FlatteningPathIterator(getPathIterator(affineTransform), d);
    }

    public abstract double getWidth();

    public abstract double getX();

    public abstract double getY();

    @Override // org.apache.poi.java.awt.Shape
    public boolean intersects(Rectangle2D rectangle2D) {
        return intersects(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public abstract boolean isEmpty();

    public abstract void setFrame(double d, double d2, double d3, double d4);

    public void setFrame(Point2D point2D, Dimension2D dimension2D) {
        setFrame(point2D.getX(), point2D.getY(), dimension2D.getWidth(), dimension2D.getHeight());
    }

    public void setFrameFromCenter(double d, double d2, double d3, double d4) {
        double dAbs = Math.abs(d3 - d);
        double dAbs2 = Math.abs(d4 - d2);
        setFrame(d - dAbs, d2 - dAbs2, dAbs * 2.0d, dAbs2 * 2.0d);
    }

    public void setFrameFromDiagonal(double d, double d2, double d3, double d4) {
        double d5;
        double d6;
        if (d3 < d) {
            d5 = d3;
        } else {
            d5 = d;
            d = d3;
        }
        if (d4 < d2) {
            d6 = d4;
        } else {
            d6 = d2;
            d2 = d4;
        }
        setFrame(d5, d6, d - d5, d2 - d6);
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(Rectangle2D rectangle2D) {
        return contains(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public void setFrame(Rectangle2D rectangle2D) {
        setFrame(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public void setFrameFromCenter(Point2D point2D, Point2D point2D2) {
        setFrameFromCenter(point2D.getX(), point2D.getY(), point2D2.getX(), point2D2.getY());
    }

    public void setFrameFromDiagonal(Point2D point2D, Point2D point2D2) {
        setFrameFromDiagonal(point2D.getX(), point2D.getY(), point2D2.getX(), point2D2.getY());
    }
}
