package org.apache.poi.java.awt;

import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.WritableRaster;

/* JADX INFO: loaded from: classes10.dex */
public interface CompositeContext {
    void compose(Raster raster, Raster raster2, WritableRaster writableRaster);

    void dispose();
}
