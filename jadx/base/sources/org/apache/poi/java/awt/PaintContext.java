package org.apache.poi.java.awt;

import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.Raster;

/* JADX INFO: loaded from: classes10.dex */
public interface PaintContext {
    void dispose();

    ColorModel getColorModel();

    Raster getRaster(int i, int i2, int i4, int i5);
}
