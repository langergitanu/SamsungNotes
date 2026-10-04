package org.apache.poi.java.awt;

import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.java.awt.image.ColorModel;

/* JADX INFO: loaded from: classes10.dex */
public interface Paint extends Transparency {
    PaintContext createContext(ColorModel colorModel, Rectangle rectangle, Rectangle2D rectangle2D, AffineTransform affineTransform, RenderingHints renderingHints);
}
