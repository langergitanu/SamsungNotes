package org.apache.poi.java.awt;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import java.lang.ref.WeakReference;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.NoninvertibleTransformException;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.DirectColorModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.sun.awt.image.IntegerComponentRaster;

/* JADX INFO: loaded from: classes10.dex */
class GradientPaintContext implements PaintContext {
    static WeakReference cached;
    static ColorModel cachedModel;
    boolean cyclic;

    /* JADX INFO: renamed from: dx */
    double f10051dx;

    /* JADX INFO: renamed from: dy */
    double f10052dy;
    int[] interp;
    ColorModel model;
    Raster saved;

    /* JADX INFO: renamed from: x1 */
    double f10053x1;

    /* JADX INFO: renamed from: y1 */
    double f10054y1;
    static ColorModel xrgbmodel = new DirectColorModel(24, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255);
    static ColorModel xbgrmodel = new DirectColorModel(24, 255, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 16711680);

    /* JADX WARN: Removed duplicated region for block: B:31:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GradientPaintContext(ColorModel colorModel, Point2D point2D, Point2D point2D2, AffineTransform affineTransform, Color color, Color color2, boolean z) {
        Point2D point2D3;
        Color color3;
        Color color4;
        int i;
        int i2;
        DirectColorModel directColorModel;
        int alphaMask;
        Point2D.Double r32 = new Point2D.Double(1.0d, 0.0d);
        Point2D.Double r8 = new Point2D.Double(0.0d, 1.0d);
        try {
            AffineTransform affineTransformCreateInverse = affineTransform.createInverse();
            affineTransformCreateInverse.deltaTransform(r32, r32);
            affineTransformCreateInverse.deltaTransform(r8, r8);
        } catch (NoninvertibleTransformException unused) {
            r32.setLocation(0.0d, 0.0d);
            r8.setLocation(0.0d, 0.0d);
        }
        double x = point2D2.getX() - point2D.getX();
        double y2 = point2D2.getY() - point2D.getY();
        double d = (y2 * y2) + (x * x);
        if (d <= Double.MIN_VALUE) {
            this.f10051dx = 0.0d;
            this.f10052dy = 0.0d;
        } else {
            this.f10051dx = ((r32.getY() * y2) + (r32.getX() * x)) / d;
            double y3 = ((r8.getY() * y2) + (r8.getX() * x)) / d;
            this.f10052dy = y3;
            if (!z) {
                double d2 = this.f10051dx;
                if (d2 < 0.0d) {
                    this.f10051dx = -d2;
                    this.f10052dy = -y3;
                    point2D3 = point2D2;
                    color3 = color;
                    color4 = color2;
                }
                Point2D point2DTransform = affineTransform.transform(point2D3, null);
                this.f10053x1 = point2DTransform.getX();
                this.f10054y1 = point2DTransform.getY();
                this.cyclic = z;
                int rgb = color4.getRGB();
                int rgb2 = color3.getRGB();
                i = (rgb >> 24) & 255;
                int i4 = (rgb >> 16) & 255;
                int i5 = (rgb >> 8) & 255;
                int i6 = rgb & 255;
                int i7 = ((rgb2 >> 24) & 255) - i;
                int i8 = ((rgb2 >> 16) & 255) - i4;
                int i9 = ((rgb2 >> 8) & 255) - i5;
                int i10 = (rgb2 & 255) - i6;
                if (i == 255 || i7 != 0) {
                    this.model = ColorModel.getRGBdefault();
                } else {
                    this.model = xrgbmodel;
                    if ((colorModel instanceof DirectColorModel) && (((alphaMask = (directColorModel = (DirectColorModel) colorModel).getAlphaMask()) == 0 || alphaMask == 255) && directColorModel.getRedMask() == 255 && directColorModel.getGreenMask() == 65280 && directColorModel.getBlueMask() == 16711680)) {
                        this.model = xbgrmodel;
                        i4 = i6;
                        i6 = i4;
                        i8 = i10;
                        i10 = i8;
                    }
                }
                this.interp = new int[!z ? InputDeviceCompat.SOURCE_DPAD : 257];
                for (i2 = 0; i2 <= 256; i2++) {
                    float f = i2 / 256.0f;
                    int i11 = ((int) ((i10 * f) + i6)) | (((int) ((i7 * f) + i)) << 24) | (((int) ((i8 * f) + i4)) << 16) | (((int) ((i9 * f) + i5)) << 8);
                    int[] iArr = this.interp;
                    iArr[i2] = i11;
                    if (z) {
                        iArr[512 - i2] = i11;
                    }
                }
            }
            this.f10051dx %= 1.0d;
            this.f10052dy = y3 % 1.0d;
        }
        point2D3 = point2D;
        color4 = color;
        color3 = color2;
        Point2D point2DTransform2 = affineTransform.transform(point2D3, null);
        this.f10053x1 = point2DTransform2.getX();
        this.f10054y1 = point2DTransform2.getY();
        this.cyclic = z;
        int rgb3 = color4.getRGB();
        int rgb22 = color3.getRGB();
        i = (rgb3 >> 24) & 255;
        int i42 = (rgb3 >> 16) & 255;
        int i52 = (rgb3 >> 8) & 255;
        int i62 = rgb3 & 255;
        int i72 = ((rgb22 >> 24) & 255) - i;
        int i82 = ((rgb22 >> 16) & 255) - i42;
        int i92 = ((rgb22 >> 8) & 255) - i52;
        int i102 = (rgb22 & 255) - i62;
        if (i == 255) {
            this.model = ColorModel.getRGBdefault();
        }
        this.interp = new int[!z ? InputDeviceCompat.SOURCE_DPAD : 257];
        while (i2 <= 256) {
        }
    }

    public static synchronized Raster getCachedRaster(ColorModel colorModel, int i, int i2) {
        WeakReference weakReference;
        Raster raster;
        if (colorModel != cachedModel || (weakReference = cached) == null || (raster = (Raster) weakReference.get()) == null || raster.getWidth() < i || raster.getHeight() < i2) {
            return colorModel.createCompatibleWritableRaster(i, i2);
        }
        cached = null;
        return raster;
    }

    public static synchronized void putCachedRaster(ColorModel colorModel, Raster raster) {
        Raster raster2;
        WeakReference weakReference = cached;
        if (weakReference != null && (raster2 = (Raster) weakReference.get()) != null) {
            int width = raster2.getWidth();
            int height = raster2.getHeight();
            int width2 = raster.getWidth();
            int height2 = raster.getHeight();
            if (width >= width2 && height >= height2) {
                return;
            }
            if (width * height >= width2 * height2) {
                return;
            }
        }
        cachedModel = colorModel;
        cached = new WeakReference(raster);
    }

    public void clipFillRaster(int[] iArr, int i, int i2, int i4, int i5, double d, double d2, double d3) {
        int i6;
        double d4;
        int i7;
        int i8 = i5;
        double d5 = d;
        while (true) {
            i8--;
            if (i8 < 0) {
                return;
            }
            if (d5 <= 0.0d) {
                int i9 = this.interp[0];
                i6 = i4;
                d4 = d5;
                while (true) {
                    i7 = i + 1;
                    iArr[i] = i9;
                    d4 += d2;
                    i6--;
                    if (i6 <= 0 || d4 > 0.0d) {
                        break;
                    } else {
                        i = i7;
                    }
                }
                i = i7;
            } else {
                i6 = i4;
                d4 = d5;
            }
            while (d4 < 1.0d && i6 - 1 >= 0) {
                iArr[i] = this.interp[(int) (256.0d * d4)];
                d4 += d2;
                i++;
            }
            if (i6 > 0) {
                int i10 = this.interp[256];
                do {
                    iArr[i] = i10;
                    i6--;
                    i++;
                } while (i6 > 0);
            }
            i += i2;
            d5 += d3;
        }
    }

    public void cycleFillRaster(int[] iArr, int i, int i2, int i4, int i5, double d, double d2, double d3) {
        int i6 = ((int) ((d % 2.0d) * 1.073741824E9d)) << 1;
        int i7 = (int) ((-d2) * (-2.147483648E9d));
        int i8 = (int) ((-d3) * (-2.147483648E9d));
        while (true) {
            i5--;
            if (i5 < 0) {
                return;
            }
            int i9 = i4;
            int i10 = i6;
            while (i9 > 0) {
                iArr[i] = this.interp[i10 >>> 23];
                i10 += i7;
                i9--;
                i++;
            }
            i += i2;
            i6 += i8;
        }
    }

    @Override // org.apache.poi.java.awt.PaintContext
    public void dispose() {
        Raster raster = this.saved;
        if (raster != null) {
            putCachedRaster(this.model, raster);
            this.saved = null;
        }
    }

    @Override // org.apache.poi.java.awt.PaintContext
    public ColorModel getColorModel() {
        return this.model;
    }

    @Override // org.apache.poi.java.awt.PaintContext
    public Raster getRaster(int i, int i2, int i4, int i5) {
        double d = ((((double) i2) - this.f10054y1) * this.f10052dy) + ((((double) i) - this.f10053x1) * this.f10051dx);
        Raster cachedRaster = this.saved;
        if (cachedRaster == null || cachedRaster.getWidth() < i4 || cachedRaster.getHeight() < i5) {
            cachedRaster = getCachedRaster(this.model, i4, i5);
            this.saved = cachedRaster;
        }
        IntegerComponentRaster integerComponentRaster = (IntegerComponentRaster) cachedRaster;
        int dataOffset = integerComponentRaster.getDataOffset(0);
        int scanlineStride = integerComponentRaster.getScanlineStride() - i4;
        int[] dataStorage = integerComponentRaster.getDataStorage();
        boolean z = this.cyclic;
        double d2 = this.f10051dx;
        double d3 = this.f10052dy;
        if (z) {
            cycleFillRaster(dataStorage, dataOffset, scanlineStride, i4, i5, d, d2, d3);
        } else {
            clipFillRaster(dataStorage, dataOffset, scanlineStride, i4, i5, d, d2, d3);
        }
        integerComponentRaster.markDirty();
        return cachedRaster;
    }
}
