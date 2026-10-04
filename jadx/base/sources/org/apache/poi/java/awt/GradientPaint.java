package org.apache.poi.java.awt;

import java.beans.ConstructorProperties;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.java.awt.image.ColorModel;

/* JADX INFO: loaded from: classes10.dex */
public class GradientPaint implements Paint {
    Color color1;
    Color color2;
    boolean cyclic;

    /* JADX INFO: renamed from: p1 */
    Point2D.Float f10049p1;

    /* JADX INFO: renamed from: p2 */
    Point2D.Float f10050p2;

    public GradientPaint(float f, float f4, Color color, float f5, float f6, Color color2) {
        if (color == null || color2 == null) {
            throw new NullPointerException("Colors cannot be null");
        }
        this.f10049p1 = new Point2D.Float(f, f4);
        this.f10050p2 = new Point2D.Float(f5, f6);
        this.color1 = color;
        this.color2 = color2;
    }

    @Override // org.apache.poi.java.awt.Paint
    public PaintContext createContext(ColorModel colorModel, Rectangle rectangle, Rectangle2D rectangle2D, AffineTransform affineTransform, RenderingHints renderingHints) {
        return new GradientPaintContext(colorModel, this.f10049p1, this.f10050p2, affineTransform, this.color1, this.color2, this.cyclic);
    }

    public Color getColor1() {
        return this.color1;
    }

    public Color getColor2() {
        return this.color2;
    }

    public Point2D getPoint1() {
        Point2D.Float r12 = this.f10049p1;
        return new Point2D.Float(r12.f10132x, r12.f10133y);
    }

    public Point2D getPoint2() {
        Point2D.Float r12 = this.f10050p2;
        return new Point2D.Float(r12.f10132x, r12.f10133y);
    }

    @Override // org.apache.poi.java.awt.Transparency
    public int getTransparency() {
        return (this.color1.getAlpha() & this.color2.getAlpha()) == 255 ? 1 : 3;
    }

    public boolean isCyclic() {
        return this.cyclic;
    }

    public GradientPaint(float f, float f4, Color color, float f5, float f6, Color color2, boolean z) {
        this(f, f4, color, f5, f6, color2);
        this.cyclic = z;
    }

    public GradientPaint(Point2D point2D, Color color, Point2D point2D2, Color color2) {
        if (color == null || color2 == null || point2D == null || point2D2 == null) {
            throw new NullPointerException("Colors and points should be non-null");
        }
        this.f10049p1 = new Point2D.Float((float) point2D.getX(), (float) point2D.getY());
        this.f10050p2 = new Point2D.Float((float) point2D2.getX(), (float) point2D2.getY());
        this.color1 = color;
        this.color2 = color2;
    }

    @ConstructorProperties({"point1", "color1", "point2", "color2", "cyclic"})
    public GradientPaint(Point2D point2D, Color color, Point2D point2D2, Color color2, boolean z) {
        this(point2D, color, point2D2, color2);
        this.cyclic = z;
    }
}
