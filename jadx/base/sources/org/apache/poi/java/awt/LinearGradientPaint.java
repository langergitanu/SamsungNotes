package org.apache.poi.java.awt;

import java.beans.ConstructorProperties;
import org.apache.poi.java.awt.MultipleGradientPaint;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.java.awt.image.ColorModel;

/* JADX INFO: loaded from: classes10.dex */
public final class LinearGradientPaint extends MultipleGradientPaint {
    private final Point2D end;
    private final Point2D start;

    public LinearGradientPaint(float f, float f4, float f5, float f6, float[] fArr, Color[] colorArr) {
        this(new Point2D.Float(f, f4), new Point2D.Float(f5, f6), fArr, colorArr, MultipleGradientPaint.CycleMethod.NO_CYCLE);
    }

    @Override // org.apache.poi.java.awt.Paint
    public PaintContext createContext(ColorModel colorModel, Rectangle rectangle, Rectangle2D rectangle2D, AffineTransform affineTransform, RenderingHints renderingHints) {
        MultipleGradientPaint.CycleMethod cycleMethod;
        AffineTransform affineTransform2 = new AffineTransform(affineTransform);
        affineTransform2.concatenate(this.gradientTransform);
        if (this.fractions.length != 2 || (cycleMethod = this.cycleMethod) == MultipleGradientPaint.CycleMethod.REPEAT || this.colorSpace != MultipleGradientPaint.ColorSpaceType.SRGB) {
            return new LinearGradientPaintContext(this, colorModel, rectangle, rectangle2D, affineTransform2, renderingHints, this.start, this.end, this.fractions, this.colors, this.cycleMethod, this.colorSpace);
        }
        boolean z = cycleMethod != MultipleGradientPaint.CycleMethod.NO_CYCLE;
        Point2D point2D = this.start;
        Point2D point2D2 = this.end;
        Color[] colorArr = this.colors;
        return new GradientPaintContext(colorModel, point2D, point2D2, affineTransform2, colorArr[0], colorArr[1], z);
    }

    public Point2D getEndPoint() {
        return new Point2D.Double(this.end.getX(), this.end.getY());
    }

    public Point2D getStartPoint() {
        return new Point2D.Double(this.start.getX(), this.start.getY());
    }

    public LinearGradientPaint(float f, float f4, float f5, float f6, float[] fArr, Color[] colorArr, MultipleGradientPaint.CycleMethod cycleMethod) {
        this(new Point2D.Float(f, f4), new Point2D.Float(f5, f6), fArr, colorArr, cycleMethod);
    }

    public LinearGradientPaint(Point2D point2D, Point2D point2D2, float[] fArr, Color[] colorArr) {
        this(point2D, point2D2, fArr, colorArr, MultipleGradientPaint.CycleMethod.NO_CYCLE);
    }

    public LinearGradientPaint(Point2D point2D, Point2D point2D2, float[] fArr, Color[] colorArr, MultipleGradientPaint.CycleMethod cycleMethod) {
        this(point2D, point2D2, fArr, colorArr, cycleMethod, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform());
    }

    @ConstructorProperties({"startPoint", "endPoint", "fractions", "colors", "cycleMethod", "colorSpace", "transform"})
    public LinearGradientPaint(Point2D point2D, Point2D point2D2, float[] fArr, Color[] colorArr, MultipleGradientPaint.CycleMethod cycleMethod, MultipleGradientPaint.ColorSpaceType colorSpaceType, AffineTransform affineTransform) {
        super(fArr, colorArr, cycleMethod, colorSpaceType, affineTransform);
        if (point2D == null || point2D2 == null) {
            throw new NullPointerException("Start and end points must benon-null");
        }
        if (point2D.equals(point2D2)) {
            throw new IllegalArgumentException("Start point cannot equalendpoint");
        }
        this.start = new Point2D.Double(point2D.getX(), point2D.getY());
        this.end = new Point2D.Double(point2D2.getX(), point2D2.getY());
    }
}
