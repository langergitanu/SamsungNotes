package org.apache.poi.java.awt.image;

import org.apache.poi.java.awt.RenderingHints;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.geom.Rectangle2D;

/* JADX INFO: loaded from: classes10.dex */
public interface RasterOp {
    WritableRaster createCompatibleDestRaster(Raster raster);

    WritableRaster filter(Raster raster, WritableRaster writableRaster);

    Rectangle2D getBounds2D(Raster raster);

    Point2D getPoint2D(Point2D point2D, Point2D point2D2);

    RenderingHints getRenderingHints();
}
