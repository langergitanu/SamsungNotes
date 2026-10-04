package org.apache.poi.p226sl.draw;

import java.io.IOException;
import org.apache.poi.java.awt.Dimension;
import org.apache.poi.java.awt.Graphics2D;
import org.apache.poi.java.awt.Insets;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.p226sl.usermodel.PictureData;
import org.apache.poi.p226sl.usermodel.PictureShape;
import org.apache.poi.p226sl.usermodel.RectAlign;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DrawPictureShape extends DrawSimpleShape {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) DrawPictureShape.class);
    private static final String WMF_IMAGE_RENDERER = "org.apache.poi.hwmf.draw.HwmfSLImageRenderer";

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawPictureShape$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C140671 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$RectAlign;

        static {
            int[] iArr = new int[RectAlign.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$RectAlign = iArr;
            try {
                iArr[RectAlign.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.BOTTOM_LEFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.TOP_LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public DrawPictureShape(PictureShape<?, ?> pictureShape) {
        super(pictureShape);
    }

    public static ImageRenderer getImageRenderer(Graphics2D graphics2D, String str) {
        ImageRenderer imageRenderer = (ImageRenderer) graphics2D.getRenderingHint(Drawable.IMAGE_RENDERER);
        if (imageRenderer != null) {
            return imageRenderer;
        }
        if (PictureData.PictureType.WMF.contentType.equals(str)) {
            try {
                return (ImageRenderer) Thread.currentThread().getContextClassLoader().loadClass(WMF_IMAGE_RENDERER).newInstance();
            } catch (Exception e) {
                LOG.log(7, "WMF image renderer is not on the classpath - include poi-scratchpad jar!", e);
            }
        }
        return new BitmapImageRenderer();
    }

    @Override // org.apache.poi.p226sl.draw.DrawShape, org.apache.poi.p226sl.draw.Drawable
    public void drawContent(Graphics2D graphics2D) {
        PictureData pictureData = getShape().getPictureData();
        if (pictureData == null) {
            return;
        }
        Rectangle2D anchor = DrawShape.getAnchor(graphics2D, getShape());
        Insets clipping = getShape().getClipping();
        try {
            ImageRenderer imageRenderer = getImageRenderer(graphics2D, pictureData.getContentType());
            imageRenderer.loadImage(pictureData.getData(), pictureData.getContentType());
            imageRenderer.drawImage(graphics2D, anchor, clipping);
        } catch (IOException e) {
            LOG.log(7, "image can't be loaded/rendered.", e);
        }
    }

    public void resize() {
        PictureShape<?, ?> shape = getShape();
        Dimension imageDimension = shape.getPictureData().getImageDimension();
        Rectangle2D anchor = shape.getAnchor();
        shape.setAnchor(new Rectangle2D.Double(anchor.getX(), anchor.getY(), imageDimension.getWidth(), imageDimension.getHeight()));
    }

    @Override // org.apache.poi.p226sl.draw.DrawSimpleShape, org.apache.poi.p226sl.draw.DrawShape
    public PictureShape<?, ?> getShape() {
        return (PictureShape) this.shape;
    }

    public void resize(Rectangle2D rectangle2D) {
        resize(rectangle2D, RectAlign.CENTER);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void resize(Rectangle2D rectangle2D, RectAlign rectAlign) {
        double height;
        PictureShape<?, ?> shape = getShape();
        Dimension imageDimension = shape.getPictureData().getImageDimension();
        if (imageDimension.width > 0 && imageDimension.height > 0) {
            double width = rectangle2D.getWidth();
            double height2 = rectangle2D.getHeight();
            int i = imageDimension.width;
            double d = width / ((double) i);
            int i2 = imageDimension.height;
            double d2 = height2 / ((double) i2);
            double width2 = 0.0d;
            if (d > d2) {
                width = d2 * ((double) i);
                width2 = rectangle2D.getWidth() - width;
                height = 0.0d;
            } else if (d2 > d) {
                height2 = ((double) i2) * d;
                height = rectangle2D.getHeight() - height2;
            } else {
                shape.setAnchor(rectangle2D);
                return;
            }
            double d3 = width;
            double d4 = height2;
            double x = rectangle2D.getX();
            double y2 = rectangle2D.getY();
            switch (C140671.$SwitchMap$org$apache$poi$sl$usermodel$RectAlign[rectAlign.ordinal()]) {
                case 1:
                    x += width2 / 2.0d;
                    break;
                case 2:
                    x += width2;
                    break;
                case 3:
                    x += width2;
                    y2 += height / 2.0d;
                    break;
                case 4:
                    x += width2;
                    y2 += height;
                    break;
                case 5:
                    x += width2 / 2.0d;
                    y2 += height;
                    break;
                case 6:
                    y2 += height;
                    break;
                case 7:
                    y2 += height / 2.0d;
                    break;
                case 8:
                    break;
                default:
                    x += width2 / 2.0d;
                    y2 += height / 2.0d;
                    break;
            }
            shape.setAnchor(new Rectangle2D.Double(x, y2, d3, d4));
            return;
        }
        shape.setAnchor(rectangle2D);
    }
}
