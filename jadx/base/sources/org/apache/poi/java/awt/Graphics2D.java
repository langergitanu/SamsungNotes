package org.apache.poi.java.awt;

import java.text.AttributedCharacterIterator;
import java.util.Map;
import org.apache.poi.java.awt.RenderingHints;
import org.apache.poi.java.awt.font.FontRenderContext;
import org.apache.poi.java.awt.font.GlyphVector;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.BufferedImageOp;
import org.apache.poi.java.awt.image.ImageObserver;
import org.apache.poi.java.awt.image.RenderedImage;
import org.apache.poi.java.awt.image.renderable.RenderableImage;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Graphics2D extends Graphics {
    public abstract void addRenderingHints(Map<?, ?> map);

    public abstract void clip(Shape shape);

    public abstract void draw(Shape shape);

    @Override // org.apache.poi.java.awt.Graphics
    public void draw3DRect(int i, int i2, int i4, int i5, boolean z) {
        Paint paint = getPaint();
        Color color = getColor();
        Color colorBrighter = color.brighter();
        Color colorDarker = color.darker();
        setColor(z ? colorBrighter : colorDarker);
        fillRect(i, i2, 1, i5 + 1);
        int i6 = i + 1;
        fillRect(i6, i2, i4 - 1, 1);
        if (z) {
            colorBrighter = colorDarker;
        }
        setColor(colorBrighter);
        fillRect(i6, i2 + i5, i4, 1);
        fillRect(i + i4, i2, 1, i5);
        setPaint(paint);
    }

    public abstract void drawGlyphVector(GlyphVector glyphVector, float f, float f4);

    public abstract void drawImage(BufferedImage bufferedImage, BufferedImageOp bufferedImageOp, int i, int i2);

    public abstract boolean drawImage(Image image, AffineTransform affineTransform, ImageObserver imageObserver);

    public abstract void drawRenderableImage(RenderableImage renderableImage, AffineTransform affineTransform);

    public abstract void drawRenderedImage(RenderedImage renderedImage, AffineTransform affineTransform);

    public abstract void drawString(String str, float f, float f4);

    @Override // org.apache.poi.java.awt.Graphics
    public abstract void drawString(String str, int i, int i2);

    public abstract void drawString(AttributedCharacterIterator attributedCharacterIterator, float f, float f4);

    @Override // org.apache.poi.java.awt.Graphics
    public abstract void drawString(AttributedCharacterIterator attributedCharacterIterator, int i, int i2);

    public abstract void fill(Shape shape);

    @Override // org.apache.poi.java.awt.Graphics
    public void fill3DRect(int i, int i2, int i4, int i5, boolean z) {
        Paint paint = getPaint();
        Color color = getColor();
        Color colorBrighter = color.brighter();
        Color colorDarker = color.darker();
        if (!z) {
            setColor(colorDarker);
        } else if (paint != color) {
            setColor(color);
        }
        int i6 = i + 1;
        int i7 = i4 - 2;
        fillRect(i6, i2 + 1, i7, i5 - 2);
        setColor(z ? colorBrighter : colorDarker);
        fillRect(i, i2, 1, i5);
        fillRect(i6, i2, i7, 1);
        if (z) {
            colorBrighter = colorDarker;
        }
        setColor(colorBrighter);
        fillRect(i6, (i2 + i5) - 1, i4 - 1, 1);
        fillRect((i + i4) - 1, i2, 1, i5 - 1);
        setPaint(paint);
    }

    public abstract Color getBackground();

    public abstract Composite getComposite();

    public abstract GraphicsConfiguration getDeviceConfiguration();

    public abstract FontRenderContext getFontRenderContext();

    public abstract Paint getPaint();

    public abstract Object getRenderingHint(RenderingHints.Key key);

    public abstract RenderingHints getRenderingHints();

    public abstract Stroke getStroke();

    public abstract AffineTransform getTransform();

    public abstract boolean hit(Rectangle rectangle, Shape shape, boolean z);

    public abstract void rotate(double d);

    public abstract void rotate(double d, double d2, double d3);

    public abstract void scale(double d, double d2);

    public abstract void setBackground(Color color);

    public abstract void setComposite(Composite composite);

    public abstract void setPaint(Paint paint);

    public abstract void setRenderingHint(RenderingHints.Key key, Object obj);

    public abstract void setRenderingHints(Map<?, ?> map);

    public abstract void setStroke(Stroke stroke);

    public abstract void setTransform(AffineTransform affineTransform);

    public abstract void shear(double d, double d2);

    public abstract void transform(AffineTransform affineTransform);

    public abstract void translate(double d, double d2);

    @Override // org.apache.poi.java.awt.Graphics
    public abstract void translate(int i, int i2);
}
