package org.apache.poi.java.awt.image;

import java.util.Vector;
import org.apache.poi.java.awt.Rectangle;

/* JADX INFO: loaded from: classes10.dex */
public interface RenderedImage {
    WritableRaster copyData(WritableRaster writableRaster);

    ColorModel getColorModel();

    Raster getData();

    Raster getData(Rectangle rectangle);

    int getHeight();

    int getMinTileX();

    int getMinTileY();

    int getMinX();

    int getMinY();

    int getNumXTiles();

    int getNumYTiles();

    Object getProperty(String str);

    String[] getPropertyNames();

    SampleModel getSampleModel();

    Vector<RenderedImage> getSources();

    Raster getTile(int i, int i2);

    int getTileGridXOffset();

    int getTileGridYOffset();

    int getTileHeight();

    int getTileWidth();

    int getWidth();
}
