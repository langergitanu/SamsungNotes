package org.apache.poi.java.awt;

import androidx.core.view.MotionEventCompat;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import org.apache.poi.java.awt.MultipleGradientPaint;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.NoninvertibleTransformException;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.DataBufferInt;
import org.apache.poi.java.awt.image.DirectColorModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.SinglePixelPackedSampleModel;

/* JADX INFO: loaded from: classes10.dex */
abstract class MultipleGradientPaintContext implements PaintContext {
    protected static final int GRADIENT_SIZE = 256;
    protected static final int GRADIENT_SIZE_INDEX = 255;
    private static final int MAX_GRADIENT_ARRAY_SIZE = 5000;
    protected static WeakReference<Raster> cached;
    protected static ColorModel cachedModel;
    protected float a00;
    protected float a01;
    protected float a02;
    protected float a10;
    protected float a11;
    protected float a12;
    protected MultipleGradientPaint.ColorSpaceType colorSpace;
    protected MultipleGradientPaint.CycleMethod cycleMethod;
    protected int fastGradientArraySize;
    private float[] fractions;
    protected int[] gradient;
    private int[][] gradients;
    protected boolean isSimpleLookup;
    protected ColorModel model;
    private float[] normalizedIntervals;
    protected Raster saved;
    private int transparencyTest;
    private static ColorModel xrgbmodel = new DirectColorModel(24, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255);
    private static final int[] SRGBtoLinearRGB = new int[256];
    private static final int[] LinearRGBtoSRGB = new int[256];

    static {
        for (int i = 0; i < 256; i++) {
            SRGBtoLinearRGB[i] = convertSRGBtoLinearRGB(i);
            LinearRGBtoSRGB[i] = convertLinearRGBtoSRGB(i);
        }
    }

    public MultipleGradientPaintContext(MultipleGradientPaint multipleGradientPaint, ColorModel colorModel, Rectangle rectangle, Rectangle2D rectangle2D, AffineTransform affineTransform, RenderingHints renderingHints, float[] fArr, Color[] colorArr, MultipleGradientPaint.CycleMethod cycleMethod, MultipleGradientPaint.ColorSpaceType colorSpaceType) {
        if (rectangle == null) {
            throw new NullPointerException("Device bounds cannot be null");
        }
        if (rectangle2D == null) {
            throw new NullPointerException("User bounds cannot be null");
        }
        if (affineTransform == null) {
            throw new NullPointerException("Transform cannot be null");
        }
        if (renderingHints == null) {
            throw new NullPointerException("RenderingHints cannot be null");
        }
        try {
            affineTransform.invert();
        } catch (NoninvertibleTransformException unused) {
            affineTransform = new AffineTransform();
        }
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        this.a00 = (float) dArr[0];
        this.a10 = (float) dArr[1];
        this.a01 = (float) dArr[2];
        this.a11 = (float) dArr[3];
        this.a02 = (float) dArr[4];
        this.a12 = (float) dArr[5];
        this.cycleMethod = cycleMethod;
        this.colorSpace = colorSpaceType;
        this.fractions = fArr;
        SoftReference<int[]> softReference = multipleGradientPaint.gradient;
        int[] iArr = softReference != null ? softReference.get() : null;
        SoftReference<int[][]> softReference2 = multipleGradientPaint.gradients;
        int[][] iArr2 = softReference2 != null ? softReference2.get() : null;
        if (iArr != null || iArr2 != null) {
            this.model = multipleGradientPaint.model;
            this.normalizedIntervals = multipleGradientPaint.normalizedIntervals;
            this.isSimpleLookup = multipleGradientPaint.isSimpleLookup;
            this.gradient = iArr;
            this.fastGradientArraySize = multipleGradientPaint.fastGradientArraySize;
            this.gradients = iArr2;
            return;
        }
        calculateLookupData(colorArr);
        multipleGradientPaint.model = this.model;
        multipleGradientPaint.normalizedIntervals = this.normalizedIntervals;
        boolean z = this.isSimpleLookup;
        multipleGradientPaint.isSimpleLookup = z;
        if (!z) {
            multipleGradientPaint.gradients = new SoftReference<>(this.gradients);
        } else {
            multipleGradientPaint.fastGradientArraySize = this.fastGradientArraySize;
            multipleGradientPaint.gradient = new SoftReference<>(this.gradient);
        }
    }

    private void calculateLookupData(Color[] colorArr) {
        float[] fArr;
        int i = 0;
        if (this.colorSpace == MultipleGradientPaint.ColorSpaceType.LINEAR_RGB) {
            Color[] colorArr2 = new Color[colorArr.length];
            for (int i2 = 0; i2 < colorArr.length; i2++) {
                int rgb = colorArr[i2].getRGB();
                int[] iArr = SRGBtoLinearRGB;
                colorArr2[i2] = new Color(iArr[(rgb >> 16) & 255], iArr[(rgb >> 8) & 255], iArr[rgb & 255], rgb >>> 24);
            }
            colorArr = colorArr2;
        }
        this.normalizedIntervals = new float[this.fractions.length - 1];
        int i4 = 0;
        while (true) {
            fArr = this.normalizedIntervals;
            if (i4 >= fArr.length) {
                break;
            }
            float[] fArr2 = this.fractions;
            int i5 = i4 + 1;
            fArr[i4] = fArr2[i5] - fArr2[i4];
            i4 = i5;
        }
        this.transparencyTest = -16777216;
        this.gradients = new int[fArr.length][];
        float f = 1.0f;
        int i6 = 0;
        while (true) {
            float[] fArr3 = this.normalizedIntervals;
            if (i6 >= fArr3.length) {
                break;
            }
            float f4 = fArr3[i6];
            if (f > f4) {
                f = f4;
            }
            i6++;
        }
        int i7 = 0;
        while (true) {
            float[] fArr4 = this.normalizedIntervals;
            if (i >= fArr4.length) {
                break;
            }
            i7 = (int) (((fArr4[i] / f) * 256.0f) + i7);
            i++;
        }
        if (i7 > 5000) {
            calculateMultipleArrayGradient(colorArr);
        } else {
            calculateSingleArrayGradient(colorArr, f);
        }
        this.model = (this.transparencyTest >>> 24) == 255 ? xrgbmodel : ColorModel.getRGBdefault();
    }

    private void calculateMultipleArrayGradient(Color[] colorArr) {
        this.isSimpleLookup = false;
        int i = 0;
        while (true) {
            int[][] iArr = this.gradients;
            if (i >= iArr.length) {
                break;
            }
            iArr[i] = new int[256];
            int rgb = colorArr[i].getRGB();
            int i2 = i + 1;
            int rgb2 = colorArr[i2].getRGB();
            interpolate(rgb, rgb2, this.gradients[i]);
            this.transparencyTest = this.transparencyTest & rgb & rgb2;
            i = i2;
        }
        if (this.colorSpace == MultipleGradientPaint.ColorSpaceType.LINEAR_RGB) {
            for (int i4 = 0; i4 < this.gradients.length; i4++) {
                int i5 = 0;
                while (true) {
                    int[] iArr2 = this.gradients[i4];
                    if (i5 < iArr2.length) {
                        iArr2[i5] = convertEntireColorLinearRGBtoSRGB(iArr2[i5]);
                        i5++;
                    }
                }
            }
        }
    }

    private void calculateSingleArrayGradient(Color[] colorArr, float f) {
        this.isSimpleLookup = true;
        int i = 0;
        int i2 = 1;
        int i4 = 0;
        while (true) {
            int[][] iArr = this.gradients;
            if (i4 >= iArr.length) {
                break;
            }
            int i5 = (int) ((this.normalizedIntervals[i4] / f) * 255.0f);
            i2 += i5;
            iArr[i4] = new int[i5];
            int rgb = colorArr[i4].getRGB();
            int i6 = i4 + 1;
            int rgb2 = colorArr[i6].getRGB();
            interpolate(rgb, rgb2, this.gradients[i4]);
            this.transparencyTest = this.transparencyTest & rgb & rgb2;
            i4 = i6;
        }
        this.gradient = new int[i2];
        int i7 = 0;
        int length = 0;
        while (true) {
            int[][] iArr2 = this.gradients;
            if (i7 >= iArr2.length) {
                break;
            }
            int[] iArr3 = iArr2[i7];
            System.arraycopy(iArr3, 0, this.gradient, length, iArr3.length);
            length += this.gradients[i7].length;
            i7++;
        }
        int[] iArr4 = this.gradient;
        iArr4[iArr4.length - 1] = colorArr[colorArr.length - 1].getRGB();
        if (this.colorSpace == MultipleGradientPaint.ColorSpaceType.LINEAR_RGB) {
            while (true) {
                int[] iArr5 = this.gradient;
                if (i >= iArr5.length) {
                    break;
                }
                iArr5[i] = convertEntireColorLinearRGBtoSRGB(iArr5[i]);
                i++;
            }
        }
        this.fastGradientArraySize = this.gradient.length - 1;
    }

    private int convertEntireColorLinearRGBtoSRGB(int i) {
        int i2 = (i >> 24) & 255;
        int[] iArr = LinearRGBtoSRGB;
        return iArr[i & 255] | (i2 << 24) | (iArr[(i >> 16) & 255] << 16) | (iArr[(i >> 8) & 255] << 8);
    }

    private static int convertLinearRGBtoSRGB(int i) {
        float f = i / 255.0f;
        double d = f;
        return Math.round((d <= 0.0031308d ? f * 12.92f : (((float) Math.pow(d, 0.4166666666666667d)) * 1.055f) - 0.055f) * 255.0f);
    }

    private static int convertSRGBtoLinearRGB(int i) {
        float f = i / 255.0f;
        return Math.round((f <= 0.04045f ? f / 12.92f : (float) Math.pow((((double) f) + 0.055d) / 1.055d, 2.4d)) * 255.0f);
    }

    private static synchronized Raster getCachedRaster(ColorModel colorModel, int i, int i2) {
        WeakReference<Raster> weakReference;
        Raster raster;
        if (colorModel != cachedModel || (weakReference = cached) == null || (raster = weakReference.get()) == null || raster.getWidth() < i || raster.getHeight() < i2) {
            return colorModel.createCompatibleWritableRaster(i, i2);
        }
        cached = null;
        return raster;
    }

    private void interpolate(int i, int i2, int[] iArr) {
        float length = 1.0f / iArr.length;
        int i4 = (i >> 24) & 255;
        int i5 = (i >> 16) & 255;
        int i6 = (i >> 8) & 255;
        int i7 = i & 255;
        int i8 = ((i2 >> 24) & 255) - i4;
        int i9 = ((i2 >> 16) & 255) - i5;
        int i10 = ((i2 >> 8) & 255) - i6;
        int i11 = (i2 & 255) - i7;
        for (int i12 = 0; i12 < iArr.length; i12++) {
            iArr[i12] = (((int) (((double) (((i12 * i8) * length) + i4)) + 0.5d)) << 24) | (((int) (((double) (((i12 * i9) * length) + i5)) + 0.5d)) << 16) | (((int) (((double) (((i12 * i10) * length) + i6)) + 0.5d)) << 8) | ((int) (((double) ((i12 * i11 * length) + i7)) + 0.5d));
        }
    }

    private static synchronized void putCachedRaster(ColorModel colorModel, Raster raster) {
        Raster raster2;
        WeakReference<Raster> weakReference = cached;
        if (weakReference != null && (raster2 = weakReference.get()) != null) {
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
        cached = new WeakReference<>(raster);
    }

    @Override // org.apache.poi.java.awt.PaintContext
    public final void dispose() {
        Raster raster = this.saved;
        if (raster != null) {
            putCachedRaster(this.model, raster);
            this.saved = null;
        }
    }

    public abstract void fillRaster(int[] iArr, int i, int i2, int i4, int i5, int i6, int i7);

    @Override // org.apache.poi.java.awt.PaintContext
    public final ColorModel getColorModel() {
        return this.model;
    }

    @Override // org.apache.poi.java.awt.PaintContext
    public final Raster getRaster(int i, int i2, int i4, int i5) {
        Raster cachedRaster = this.saved;
        if (cachedRaster == null || cachedRaster.getWidth() < i4 || cachedRaster.getHeight() < i5) {
            cachedRaster = getCachedRaster(this.model, i4, i5);
            this.saved = cachedRaster;
        }
        DataBufferInt dataBufferInt = (DataBufferInt) cachedRaster.getDataBuffer();
        fillRaster(dataBufferInt.getData(0), dataBufferInt.getOffset(), ((SinglePixelPackedSampleModel) cachedRaster.getSampleModel()).getScanlineStride() - i4, i, i2, i4, i5);
        return cachedRaster;
    }

    public final int indexIntoGradientsArrays(float f) {
        MultipleGradientPaint.CycleMethod cycleMethod = this.cycleMethod;
        if (cycleMethod == MultipleGradientPaint.CycleMethod.NO_CYCLE) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
        } else if (cycleMethod == MultipleGradientPaint.CycleMethod.REPEAT) {
            f -= (int) f;
            if (f < 0.0f) {
                f += 1.0f;
            }
        } else {
            if (f < 0.0f) {
                f = -f;
            }
            int i = (int) f;
            f -= i;
            if ((i & 1) == 1) {
                f = 1.0f - f;
            }
        }
        if (this.isSimpleLookup) {
            return this.gradient[(int) (f * this.fastGradientArraySize)];
        }
        int i2 = 0;
        while (true) {
            int[][] iArr = this.gradients;
            if (i2 >= iArr.length) {
                return iArr[iArr.length - 1][255];
            }
            float[] fArr = this.fractions;
            int i4 = i2 + 1;
            if (f < fArr[i4]) {
                return iArr[i2][(int) (((f - fArr[i2]) / this.normalizedIntervals[i2]) * 255.0f)];
            }
            i2 = i4;
        }
    }
}
