package org.apache.poi.java.awt.geom;

import java.util.Enumeration;
import java.util.Vector;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.Shape;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.sun.awt.geom.AreaOp;
import org.apache.poi.sun.awt.geom.Crossings;
import org.apache.poi.sun.awt.geom.Curve;

/* JADX INFO: loaded from: classes10.dex */
public class Area implements Shape, Cloneable {
    private static Vector EmptyCurves = new Vector();
    private Rectangle2D cachedBounds;
    private Vector curves;

    public Area() {
        this.curves = EmptyCurves;
    }

    private Rectangle2D getCachedBounds() {
        Rectangle2D rectangle2D = this.cachedBounds;
        if (rectangle2D != null) {
            return rectangle2D;
        }
        Rectangle2D.Double r12 = new Rectangle2D.Double();
        if (this.curves.size() > 0) {
            Curve curve = (Curve) this.curves.get(0);
            r12.setRect(curve.getX0(), curve.getY0(), 0.0d, 0.0d);
            for (int i = 1; i < this.curves.size(); i++) {
                ((Curve) this.curves.get(i)).enlarge(r12);
            }
        }
        this.cachedBounds = r12;
        return r12;
    }

    private void invalidateBounds() {
        this.cachedBounds = null;
    }

    private static Vector pathToCurves(PathIterator pathIterator) {
        double d;
        double d2;
        double d3;
        double d4;
        Vector vector = new Vector();
        int windingRule = pathIterator.getWindingRule();
        double[] dArr = new double[23];
        double d5 = 0.0d;
        double d6 = 0.0d;
        double d7 = 0.0d;
        double d8 = 0.0d;
        while (!pathIterator.isDone()) {
            int iCurrentSegment = pathIterator.currentSegment(dArr);
            if (iCurrentSegment != 0) {
                if (iCurrentSegment != 1) {
                    if (iCurrentSegment == 2) {
                        d = d7;
                        d2 = d8;
                        d3 = dArr[2];
                        d4 = dArr[3];
                        Curve.insertQuad(vector, d5, d6, dArr);
                    } else if (iCurrentSegment == 3) {
                        d = d7;
                        d2 = d8;
                        d3 = dArr[4];
                        d4 = dArr[5];
                        Curve.insertCubic(vector, d5, d6, dArr);
                    } else if (iCurrentSegment != 4) {
                        pathIterator.next();
                    } else {
                        Curve.insertLine(vector, d5, d6, d7, d8);
                        d5 = d7;
                        d7 = d5;
                        d6 = d8;
                    }
                    d5 = d3;
                    d6 = d4;
                } else {
                    d = d7;
                    d2 = d8;
                    double d9 = dArr[0];
                    double d10 = dArr[1];
                    Curve.insertLine(vector, d5, d6, d9, d10);
                    d5 = d9;
                    d6 = d10;
                }
                d7 = d;
                d8 = d2;
                pathIterator.next();
            } else {
                Curve.insertLine(vector, d5, d6, d7, d8);
                d5 = dArr[0];
                d6 = dArr[1];
                Curve.insertMove(vector, d5, d6);
                d7 = d5;
            }
            d8 = d6;
            pathIterator.next();
        }
        Curve.insertLine(vector, d5, d6, d7, d8);
        return (windingRule == 0 ? new AreaOp.EOWindOp() : new AreaOp.NZWindOp()).calculate(vector, EmptyCurves);
    }

    public void add(Area area) {
        this.curves = new AreaOp.AddOp().calculate(this.curves, area.curves);
        invalidateBounds();
    }

    public Object clone() {
        return new Area(this);
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(double d, double d2) {
        if (!getCachedBounds().contains(d, d2)) {
            return false;
        }
        Enumeration enumerationElements = this.curves.elements();
        int iCrossingsFor = 0;
        while (enumerationElements.hasMoreElements()) {
            iCrossingsFor += ((Curve) enumerationElements.nextElement()).crossingsFor(d, d2);
        }
        return (iCrossingsFor & 1) == 1;
    }

    public Area createTransformedArea(AffineTransform affineTransform) {
        Area area = new Area(this);
        area.transform(affineTransform);
        return area;
    }

    public boolean equals(Area area) {
        if (area == this) {
            return true;
        }
        if (area == null) {
            return false;
        }
        return new AreaOp.XorOp().calculate(this.curves, area.curves).isEmpty();
    }

    public void exclusiveOr(Area area) {
        this.curves = new AreaOp.XorOp().calculate(this.curves, area.curves);
        invalidateBounds();
    }

    @Override // org.apache.poi.java.awt.Shape
    public Rectangle getBounds() {
        return getCachedBounds().getBounds();
    }

    @Override // org.apache.poi.java.awt.Shape
    public Rectangle2D getBounds2D() {
        return getCachedBounds().getBounds2D();
    }

    @Override // org.apache.poi.java.awt.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new AreaIterator(this.curves, affineTransform);
    }

    public void intersect(Area area) {
        this.curves = new AreaOp.IntOp().calculate(this.curves, area.curves);
        invalidateBounds();
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean intersects(double d, double d2, double d3, double d4) {
        if (d3 < 0.0d || d4 < 0.0d || !getCachedBounds().intersects(d, d2, d3, d4)) {
            return false;
        }
        Crossings crossingsFindCrossings = Crossings.findCrossings(this.curves, d, d2, d + d3, d2 + d4);
        return crossingsFindCrossings == null || !crossingsFindCrossings.isEmpty();
    }

    public boolean isEmpty() {
        return this.curves.size() == 0;
    }

    public boolean isPolygonal() {
        Enumeration enumerationElements = this.curves.elements();
        while (enumerationElements.hasMoreElements()) {
            if (((Curve) enumerationElements.nextElement()).getOrder() > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isRectangular() {
        int size = this.curves.size();
        if (size == 0) {
            return true;
        }
        if (size > 3) {
            return false;
        }
        Curve curve = (Curve) this.curves.get(1);
        Curve curve2 = (Curve) this.curves.get(2);
        return curve.getOrder() == 1 && curve2.getOrder() == 1 && curve.getXTop() == curve.getXBot() && curve2.getXTop() == curve2.getXBot() && curve.getYTop() == curve2.getYTop() && curve.getYBot() == curve2.getYBot();
    }

    public boolean isSingular() {
        if (this.curves.size() < 3) {
            return true;
        }
        Enumeration enumerationElements = this.curves.elements();
        enumerationElements.nextElement();
        while (enumerationElements.hasMoreElements()) {
            if (((Curve) enumerationElements.nextElement()).getOrder() == 0) {
                return false;
            }
        }
        return true;
    }

    public void reset() {
        this.curves = new Vector();
        invalidateBounds();
    }

    public void subtract(Area area) {
        this.curves = new AreaOp.SubOp().calculate(this.curves, area.curves);
        invalidateBounds();
    }

    public void transform(AffineTransform affineTransform) {
        if (affineTransform == null) {
            throw new NullPointerException("transform must not be null");
        }
        this.curves = pathToCurves(getPathIterator(affineTransform));
        invalidateBounds();
    }

    public Area(Shape shape) {
        this.curves = shape instanceof Area ? ((Area) shape).curves : pathToCurves(shape.getPathIterator(null));
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean contains(double d, double d2, double d3, double d4) {
        double d5;
        Crossings crossingsFindCrossings;
        return d3 >= 0.0d && d4 >= 0.0d && getCachedBounds().contains(d, d2, d3, d4) && (crossingsFindCrossings = Crossings.findCrossings(this.curves, d, d2, d + d3, (d5 = d2 + d4))) != null && crossingsFindCrossings.covers(d2, d5);
    }

    @Override // org.apache.poi.java.awt.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform, double d) {
        return new FlatteningPathIterator(getPathIterator(affineTransform), d);
    }

    @Override // org.apache.poi.java.awt.Shape
    public boolean intersects(Rectangle2D rectangle2D) {
        return intersects(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
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
