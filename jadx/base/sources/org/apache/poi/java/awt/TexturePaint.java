package org.apache.poi.java.awt;

import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.ColorModel;

/* JADX INFO: loaded from: classes10.dex */
public class TexturePaint implements Paint {
    BufferedImage bufImg;

    /* JADX INFO: renamed from: sx */
    double f10099sx;

    /* JADX INFO: renamed from: sy */
    double f10100sy;

    /* JADX INFO: renamed from: tx */
    double f10101tx;

    /* JADX INFO: renamed from: ty */
    double f10102ty;

    public TexturePaint(BufferedImage bufferedImage, Rectangle2D rectangle2D) {
        this.bufImg = bufferedImage;
        this.f10101tx = rectangle2D.getX();
        this.f10102ty = rectangle2D.getY();
        this.f10099sx = rectangle2D.getWidth() / ((double) this.bufImg.getWidth());
        this.f10100sy = rectangle2D.getHeight() / ((double) this.bufImg.getHeight());
    }

    @Override // org.apache.poi.java.awt.Paint
    public PaintContext createContext(ColorModel colorModel, Rectangle rectangle, Rectangle2D rectangle2D, AffineTransform affineTransform, RenderingHints renderingHints) {
        AffineTransform affineTransform2 = affineTransform == null ? new AffineTransform() : (AffineTransform) affineTransform.clone();
        affineTransform2.translate(this.f10101tx, this.f10102ty);
        affineTransform2.scale(this.f10099sx, this.f10100sy);
        return TexturePaintContext.getContext(this.bufImg, affineTransform2, renderingHints, rectangle);
    }

    public Rectangle2D getAnchorRect() {
        return new Rectangle2D.Double(this.f10101tx, this.f10102ty, this.f10099sx * ((double) this.bufImg.getWidth()), this.f10100sy * ((double) this.bufImg.getHeight()));
    }

    public BufferedImage getImage() {
        return this.bufImg;
    }

    @Override // org.apache.poi.java.awt.Transparency
    public int getTransparency() {
        return this.bufImg.getColorModel().getTransparency();
    }
}
