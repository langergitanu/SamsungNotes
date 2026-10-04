package org.apache.poi.java.awt;

import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.PathIterator;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.geom.Rectangle2D;

/* JADX INFO: loaded from: classes10.dex */
public interface Shape {
    boolean contains(double d, double d2);

    boolean contains(double d, double d2, double d3, double d4);

    boolean contains(Point2D point2D);

    boolean contains(Rectangle2D rectangle2D);

    Rectangle getBounds();

    Rectangle2D getBounds2D();

    PathIterator getPathIterator(AffineTransform affineTransform);

    PathIterator getPathIterator(AffineTransform affineTransform, double d);

    boolean intersects(double d, double d2, double d3, double d4);

    boolean intersects(Rectangle2D rectangle2D);
}
