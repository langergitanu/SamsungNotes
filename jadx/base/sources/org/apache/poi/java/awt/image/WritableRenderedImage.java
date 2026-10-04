package org.apache.poi.java.awt.image;

import org.apache.poi.java.awt.Point;

/* JADX INFO: loaded from: classes10.dex */
public interface WritableRenderedImage extends RenderedImage {
    void addTileObserver(TileObserver tileObserver);

    WritableRaster getWritableTile(int i, int i2);

    Point[] getWritableTileIndices();

    boolean hasTileWriters();

    boolean isTileWritable(int i, int i2);

    void releaseWritableTile(int i, int i2);

    void removeTileObserver(TileObserver tileObserver);

    void setData(Raster raster);
}
