package org.apache.poi.java.awt;

import org.apache.poi.java.awt.MultipleGradientPaint;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.java.awt.image.ColorModel;
import p001A.AbstractC0000a;

/* JADX INFO: loaded from: classes10.dex */
final class LinearGradientPaintContext extends MultipleGradientPaintContext {
    private float dgdX;
    private float dgdY;

    /* JADX INFO: renamed from: gc */
    private float f10055gc;

    public LinearGradientPaintContext(LinearGradientPaint linearGradientPaint, ColorModel colorModel, Rectangle rectangle, Rectangle2D rectangle2D, AffineTransform affineTransform, RenderingHints renderingHints, Point2D point2D, Point2D point2D2, float[] fArr, Color[] colorArr, MultipleGradientPaint.CycleMethod cycleMethod, MultipleGradientPaint.ColorSpaceType colorSpaceType) {
        super(linearGradientPaint, colorModel, rectangle, rectangle2D, affineTransform, renderingHints, fArr, colorArr, cycleMethod, colorSpaceType);
        float x = (float) point2D.getX();
        float y2 = (float) point2D.getY();
        float x2 = ((float) point2D2.getX()) - x;
        float y3 = ((float) point2D2.getY()) - y2;
        float f = (y3 * y3) + (x2 * x2);
        float f4 = x2 / f;
        float f5 = y3 / f;
        this.dgdX = (this.a10 * f5) + (this.a00 * f4);
        this.dgdY = (this.a11 * f5) + (this.a01 * f4);
        this.f10055gc = AbstractC0000a.m29z(this.a12, y2, f5, (this.a02 - x) * f4);
    }

    @Override // org.apache.poi.java.awt.MultipleGradientPaintContext
    public void fillRaster(int[] iArr, int i, int i2, int i4, int i5, int i6, int i7) {
        int i8 = i + i6;
        float f = (this.dgdX * i4) + this.f10055gc;
        for (int i9 = 0; i9 < i7; i9++) {
            float f4 = (this.dgdY * (i5 + i9)) + f;
            while (i < i8) {
                iArr[i] = indexIntoGradientsArrays(f4);
                f4 += this.dgdX;
                i++;
            }
            i += i2;
            i8 = i + i6;
        }
    }
}
