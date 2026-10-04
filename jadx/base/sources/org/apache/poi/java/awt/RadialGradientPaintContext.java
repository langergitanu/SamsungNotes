package org.apache.poi.java.awt;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import org.apache.poi.java.awt.MultipleGradientPaint;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.java.awt.image.ColorModel;
import p001A.AbstractC0000a;

/* JADX INFO: loaded from: classes10.dex */
final class RadialGradientPaintContext extends MultipleGradientPaintContext {
    private static final float SCALEBACK = 0.99f;
    private static final int SQRT_LUT_SIZE = 2048;
    private static float[] sqrtLut = new float[2049];
    private float centerX;
    private float centerY;
    private float constA;
    private float constB;
    private float focusX;
    private float focusY;
    private float gDeltaDelta;
    private boolean isNonCyclic;
    private boolean isSimpleFocus;
    private float radius;
    private float radiusSq;
    private float trivial;

    static {
        int i = 0;
        while (true) {
            float[] fArr = sqrtLut;
            if (i >= fArr.length) {
                return;
            }
            fArr[i] = (float) Math.sqrt(i / 2048.0f);
            i++;
        }
    }

    public RadialGradientPaintContext(RadialGradientPaint radialGradientPaint, ColorModel colorModel, Rectangle rectangle, Rectangle2D rectangle2D, AffineTransform affineTransform, RenderingHints renderingHints, float f, float f4, float f5, float f6, float f7, float[] fArr, Color[] colorArr, MultipleGradientPaint.CycleMethod cycleMethod, MultipleGradientPaint.ColorSpaceType colorSpaceType) {
        super(radialGradientPaint, colorModel, rectangle, rectangle2D, affineTransform, renderingHints, fArr, colorArr, cycleMethod, colorSpaceType);
        this.isSimpleFocus = false;
        this.isNonCyclic = false;
        this.centerX = f;
        this.centerY = f4;
        this.focusX = f6;
        this.focusY = f7;
        this.radius = f5;
        this.isSimpleFocus = f6 == f && f7 == f4;
        this.isNonCyclic = cycleMethod == MultipleGradientPaint.CycleMethod.NO_CYCLE;
        float f8 = f5 * f5;
        this.radiusSq = f8;
        float f9 = f6 - f;
        float f10 = f7 - f4;
        double d = (f10 * f10) + (f9 * f9);
        if (d > f8 * SCALEBACK) {
            float fSqrt = (float) Math.sqrt(((double) (f8 * SCALEBACK)) / d);
            f9 *= fSqrt;
            this.focusX = this.centerX + f9;
            this.focusY = this.centerY + (f10 * fSqrt);
        }
        this.trivial = (float) Math.sqrt(this.radiusSq - (f9 * f9));
        this.constA = this.a02 - this.centerX;
        this.constB = this.a12 - this.centerY;
        float f11 = this.a00;
        float f12 = this.a10;
        this.gDeltaDelta = AbstractC0622a.m1152B(f12, f12, f11 * f11, 2.0f) / this.radiusSq;
    }

    private void cyclicCircularGradientFillRaster(int[] iArr, int i, int i2, int i4, int i5, int i6, int i7) {
        float f;
        int i8;
        float f4;
        int i9;
        float f5;
        double d;
        double d2;
        double d3;
        double d4;
        float f6 = -this.radiusSq;
        float f7 = this.centerX;
        float f8 = (f7 * f7) + f6;
        float f9 = this.centerY;
        double d5 = (f9 * f9) + f8;
        float f10 = i4;
        float f11 = i5;
        float f12 = this.a02 + (this.a01 * f11) + (this.a00 * f10);
        float f13 = (this.a11 * f11) + (this.a10 * f10) + this.a12;
        float f14 = f9 * 2.0f;
        float f15 = f7 * (-2.0f);
        int i10 = i6 + i2;
        int i11 = i;
        int i12 = 0;
        while (i12 < i7) {
            float f16 = i12;
            float f17 = (this.a01 * f16) + f12;
            float f18 = (this.a11 * f16) + f13;
            int i13 = 0;
            while (i13 < i6) {
                float f19 = this.focusX;
                float f20 = f12;
                float f21 = f13;
                if (f17 == f19) {
                    double d6 = f19;
                    double d7 = this.centerY;
                    if (f18 > this.focusY) {
                        d3 = d7;
                        d4 = this.trivial;
                    } else {
                        d3 = d7;
                        d4 = -this.trivial;
                    }
                    i9 = i12;
                    d2 = d3 + d4;
                    f = f15;
                    f4 = f17;
                    f5 = f18;
                    i8 = i13;
                    d = d6;
                } else {
                    double d8 = (f18 - this.focusY) / (f17 - f19);
                    double d9 = ((double) f18) - (((double) f17) * d8);
                    double d10 = (d8 * d8) + 1.0d;
                    f = f15;
                    double dM1306C = AbstractC1974b.m1306C(this.centerY, d9, d8 * (-2.0d), f15);
                    i8 = i13;
                    f4 = f17;
                    i9 = i12;
                    f5 = f18;
                    float fSqrt = (float) Math.sqrt((dM1306C * dM1306C) - ((4.0d * d10) * AbstractC1974b.m1306C(d9, f14, d9, d5)));
                    double d11 = -dM1306C;
                    if (f4 < this.focusX) {
                        fSqrt = -fSqrt;
                    }
                    d = (d11 + ((double) fSqrt)) / (2.0d * d10);
                    d2 = d9 + (d8 * d);
                }
                float f22 = this.focusX;
                float f23 = f4 - f22;
                float f24 = this.focusY;
                float f25 = f5 - f24;
                float f26 = ((float) d) - f22;
                float f27 = ((float) d2) - f24;
                iArr[i11 + i8] = indexIntoGradientsArrays((float) Math.sqrt(((f25 * f25) + (f23 * f23)) / ((f27 * f27) + (f26 * f26))));
                f17 = f4 + this.a00;
                f18 = f5 + this.a10;
                i13 = i8 + 1;
                f12 = f20;
                i12 = i9;
                f15 = f;
                f13 = f21;
            }
            i11 += i10;
            i12++;
            f13 = f13;
        }
    }

    private void simpleNonCyclicFillRaster(int[] iArr, int i, int i2, int i4, int i5, int i6, int i7) {
        float f;
        float f4;
        int iM29z;
        float f5 = i4;
        float f6 = i5;
        float f7 = (this.a01 * f6) + (this.a00 * f5) + this.constA;
        float f8 = (this.a11 * f6) + (this.a10 * f5) + this.constB;
        float f9 = this.gDeltaDelta;
        int i8 = i2 + i6;
        int i9 = this.gradient[this.fastGradientArraySize];
        float f10 = f7;
        int i10 = 0;
        float f11 = f8;
        int i11 = i;
        while (i10 < i7) {
            float f12 = this.radiusSq;
            float f13 = ((f11 * f11) + (f10 * f10)) / f12;
            float f14 = (f9 / 2.0f) + ((((this.a10 * f11) + (this.a00 * f10)) * 2.0f) / f12);
            int i12 = 0;
            while (true) {
                if (i12 >= i6 || f13 < 1.0f) {
                    break;
                }
                iArr[i11 + i12] = i9;
                f13 += f14;
                f14 += f9;
                i12++;
            }
            for (f = 1.0f; i12 < i6 && f13 < f; f = 1.0f) {
                if (f13 <= 0.0f) {
                    f4 = f9;
                    iM29z = 0;
                } else {
                    float f15 = 2048.0f * f13;
                    int i13 = (int) f15;
                    float[] fArr = sqrtLut;
                    float f16 = fArr[i13];
                    f4 = f9;
                    iM29z = (int) (AbstractC0000a.m29z(f15, i13, fArr[i13 + 1] - f16, f16) * this.fastGradientArraySize);
                }
                iArr[i11 + i12] = this.gradient[iM29z];
                f13 += f14;
                f14 += f4;
                i12++;
                f9 = f4;
            }
            float f17 = f9;
            while (i12 < i6) {
                iArr[i11 + i12] = i9;
                i12++;
            }
            i11 += i8;
            f10 += this.a01;
            f11 += this.a11;
            i10++;
            f9 = f17;
        }
    }

    @Override // org.apache.poi.java.awt.MultipleGradientPaintContext
    public void fillRaster(int[] iArr, int i, int i2, int i4, int i5, int i6, int i7) {
        if (this.isSimpleFocus && this.isNonCyclic && this.isSimpleLookup) {
            simpleNonCyclicFillRaster(iArr, i, i2, i4, i5, i6, i7);
        } else {
            cyclicCircularGradientFillRaster(iArr, i, i2, i4, i5, i6, i7);
        }
    }
}
