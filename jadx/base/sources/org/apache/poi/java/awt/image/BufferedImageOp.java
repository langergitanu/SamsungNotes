package org.apache.poi.java.awt.image;

import org.apache.poi.java.awt.RenderingHints;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.geom.Rectangle2D;

/* JADX INFO: loaded from: classes10.dex */
public interface BufferedImageOp {
    BufferedImage createCompatibleDestImage(BufferedImage bufferedImage, ColorModel colorModel);

    BufferedImage filter(BufferedImage bufferedImage, BufferedImage bufferedImage2);

    Rectangle2D getBounds2D(BufferedImage bufferedImage);

    Point2D getPoint2D(Point2D point2D, Point2D point2D2);

    RenderingHints getRenderingHints();
}
