package org.apache.poi.java.awt;

import java.text.AttributedCharacterIterator;
import org.apache.poi.java.awt.image.ImageObserver;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Graphics {
    public abstract void clearRect(int i, int i2, int i4, int i5);

    public abstract void clipRect(int i, int i2, int i4, int i5);

    public abstract void copyArea(int i, int i2, int i4, int i5, int i6, int i7);

    public abstract Graphics create();

    public Graphics create(int i, int i2, int i4, int i5) {
        Graphics graphicsCreate = create();
        if (graphicsCreate == null) {
            return null;
        }
        graphicsCreate.translate(i, i2);
        graphicsCreate.clipRect(0, 0, i4, i5);
        return graphicsCreate;
    }

    public abstract void dispose();

    public void draw3DRect(int i, int i2, int i4, int i5, boolean z) {
        Color color = getColor();
        Color colorBrighter = color.brighter();
        Color colorDarker = color.darker();
        setColor(z ? colorBrighter : colorDarker);
        int i6 = i5 + i2;
        drawLine(i, i2, i, i6);
        int i7 = i + 1;
        int i8 = i + i4;
        drawLine(i7, i2, i8 - 1, i2);
        if (z) {
            colorBrighter = colorDarker;
        }
        setColor(colorBrighter);
        drawLine(i7, i6, i8, i6);
        drawLine(i8, i2, i8, i6 - 1);
        setColor(color);
    }

    public abstract void drawArc(int i, int i2, int i4, int i5, int i6, int i7);

    public void drawBytes(byte[] bArr, int i, int i2, int i4, int i5) {
        drawString(new String(bArr, 0, i, i2), i4, i5);
    }

    public void drawChars(char[] cArr, int i, int i2, int i4, int i5) {
        drawString(new String(cArr, i, i2), i4, i5);
    }

    public abstract boolean drawImage(Image image, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, Color color, ImageObserver imageObserver);

    public abstract boolean drawImage(Image image, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, ImageObserver imageObserver);

    public abstract boolean drawImage(Image image, int i, int i2, int i4, int i5, Color color, ImageObserver imageObserver);

    public abstract boolean drawImage(Image image, int i, int i2, int i4, int i5, ImageObserver imageObserver);

    public abstract boolean drawImage(Image image, int i, int i2, Color color, ImageObserver imageObserver);

    public abstract boolean drawImage(Image image, int i, int i2, ImageObserver imageObserver);

    public abstract void drawLine(int i, int i2, int i4, int i5);

    public abstract void drawOval(int i, int i2, int i4, int i5);

    public void drawPolygon(Polygon polygon) {
        drawPolygon(polygon.xpoints, polygon.ypoints, polygon.npoints);
    }

    public abstract void drawPolygon(int[] iArr, int[] iArr2, int i);

    public abstract void drawPolyline(int[] iArr, int[] iArr2, int i);

    public void drawRect(int i, int i2, int i4, int i5) {
        if (i4 < 0 || i5 < 0) {
            return;
        }
        if (i5 == 0 || i4 == 0) {
            drawLine(i, i2, i4 + i, i5 + i2);
            return;
        }
        int i6 = i4 + i;
        drawLine(i, i2, i6 - 1, i2);
        int i7 = i5 + i2;
        drawLine(i6, i2, i6, i7 - 1);
        drawLine(i6, i7, i + 1, i7);
        drawLine(i, i7, i, i2 + 1);
    }

    public abstract void drawRoundRect(int i, int i2, int i4, int i5, int i6, int i7);

    public abstract void drawString(String str, int i, int i2);

    public abstract void drawString(AttributedCharacterIterator attributedCharacterIterator, int i, int i2);

    public void fill3DRect(int i, int i2, int i4, int i5, boolean z) {
        Color color = getColor();
        Color colorBrighter = color.brighter();
        Color colorDarker = color.darker();
        if (!z) {
            setColor(colorDarker);
        }
        int i6 = i + 1;
        fillRect(i6, i2 + 1, i4 - 2, i5 - 2);
        setColor(z ? colorBrighter : colorDarker);
        int i7 = i5 + i2;
        int i8 = i7 - 1;
        drawLine(i, i2, i, i8);
        int i9 = i + i4;
        drawLine(i6, i2, i9 - 2, i2);
        if (z) {
            colorBrighter = colorDarker;
        }
        setColor(colorBrighter);
        int i10 = i9 - 1;
        drawLine(i6, i8, i10, i8);
        drawLine(i10, i2, i10, i7 - 2);
        setColor(color);
    }

    public abstract void fillArc(int i, int i2, int i4, int i5, int i6, int i7);

    public abstract void fillOval(int i, int i2, int i4, int i5);

    public void fillPolygon(Polygon polygon) {
        fillPolygon(polygon.xpoints, polygon.ypoints, polygon.npoints);
    }

    public abstract void fillPolygon(int[] iArr, int[] iArr2, int i);

    public abstract void fillRect(int i, int i2, int i4, int i5);

    public abstract void fillRoundRect(int i, int i2, int i4, int i5, int i6, int i7);

    public void finalize() {
        dispose();
    }

    public abstract Shape getClip();

    public abstract Rectangle getClipBounds();

    public Rectangle getClipBounds(Rectangle rectangle) {
        Rectangle clipBounds = getClipBounds();
        if (clipBounds == null) {
            if (rectangle != null) {
                return rectangle;
            }
            throw new NullPointerException("null rectangle parameter");
        }
        rectangle.f10094x = clipBounds.f10094x;
        rectangle.f10095y = clipBounds.f10095y;
        rectangle.width = clipBounds.width;
        rectangle.height = clipBounds.height;
        return rectangle;
    }

    @Deprecated
    public Rectangle getClipRect() {
        return getClipBounds();
    }

    public abstract Color getColor();

    public abstract Font getFont();

    public FontMetrics getFontMetrics() {
        return getFontMetrics(getFont());
    }

    public abstract FontMetrics getFontMetrics(Font font);

    public boolean hitClip(int i, int i2, int i4, int i5) {
        Rectangle clipBounds = getClipBounds();
        if (clipBounds == null) {
            return true;
        }
        return clipBounds.intersects(i, i2, i4, i5);
    }

    public abstract void setClip(int i, int i2, int i4, int i5);

    public abstract void setClip(Shape shape);

    public abstract void setColor(Color color);

    public abstract void setFont(Font font);

    public abstract void setPaintMode();

    public abstract void setXORMode(Color color);

    public String toString() {
        return getClass().getName() + "[font=" + getFont() + ",color=" + getColor() + "]";
    }

    public abstract void translate(int i, int i2);
}
