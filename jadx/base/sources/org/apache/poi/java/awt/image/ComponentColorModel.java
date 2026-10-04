package org.apache.poi.java.awt.image;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import java.util.Arrays;
import kotlin.UShort;
import kotlin.jvm.internal.ShortCompanionObject;
import org.apache.poi.java.awt.color.ColorSpace;
import org.apache.poi.java.awt.color.ICC_ColorSpace;
import p001A.AbstractC0000a;

/* JADX INFO: loaded from: classes10.dex */
public class ComponentColorModel extends ColorModel {
    private float[] compOffset;
    private float[] compScale;
    private float[] diffMinMax;
    private short[] fromLinearGray16ToOtherGray16LUT;
    private byte[] fromLinearGray16ToOtherGray8LUT;
    private short[] fromsRGB8LUT16;
    private byte[] fromsRGB8LUT8;
    private boolean is_ICCGray_stdScale;
    private boolean is_LinearGray_stdScale;
    private boolean is_LinearRGB_stdScale;
    private boolean is_sRGB_stdScale;
    private float[] min;
    private boolean needScaleInit;
    private boolean noUnnorm;
    private boolean nonStdScale;
    private boolean signed;
    private byte[] tosRGB8LUT;

    public ComponentColorModel(ColorSpace colorSpace, boolean z, boolean z2, int i, int i2) {
        this(colorSpace, null, z, z2, i, i2);
    }

    private static int[] bitsArrayHelper(int[] iArr, int i, ColorSpace colorSpace, boolean z) {
        if ((i == 0 || i == 1 || i == 3) && iArr != null) {
            return iArr;
        }
        int dataTypeSize = DataBuffer.getDataTypeSize(i);
        int numComponents = colorSpace.getNumComponents();
        if (z) {
            numComponents++;
        }
        int[] iArr2 = new int[numComponents];
        for (int i2 = 0; i2 < numComponents; i2++) {
            iArr2[i2] = dataTypeSize;
        }
        return iArr2;
    }

    private static int bitsHelper(int i, ColorSpace colorSpace, boolean z) {
        int dataTypeSize = DataBuffer.getDataTypeSize(i);
        int numComponents = colorSpace.getNumComponents();
        if (z) {
            numComponents++;
        }
        return dataTypeSize * numComponents;
    }

    private int extractComponent(Object obj, int i, int i2) {
        int i4;
        short s;
        int i5;
        boolean z = this.supportsAlpha && this.isAlphaPremultiplied;
        int i6 = this.nBits[i];
        int i7 = (1 << i6) - 1;
        int i8 = this.transferType;
        if (i8 != 0) {
            if (i8 == 1) {
                short[] sArr = (short[]) obj;
                i4 = sArr[i] & i7;
                if (z) {
                    s = sArr[this.numColorComponents];
                    i5 = s & i7;
                }
            } else {
                if (i8 == 2) {
                    short[] sArr2 = (short[]) obj;
                    float f = (1 << i2) - 1;
                    if (!z) {
                        return (int) (((sArr2[i] / 32767.0f) * f) + 0.5f);
                    }
                    short s2 = sArr2[this.numColorComponents];
                    if (s2 != 0) {
                        return (int) (((sArr2[i] / s2) * f) + 0.5f);
                    }
                    return 0;
                }
                if (i8 != 3) {
                    if (i8 == 4) {
                        float[] fArr = (float[]) obj;
                        float f4 = (1 << i2) - 1;
                        if (!z) {
                            return (int) ((fArr[i] * f4) + 0.5f);
                        }
                        float f5 = fArr[this.numColorComponents];
                        if (f5 != 0.0f) {
                            return (int) (((fArr[i] / f5) * f4) + 0.5f);
                        }
                        return 0;
                    }
                    if (i8 != 5) {
                        throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
                    }
                    double[] dArr = (double[]) obj;
                    double d = (1 << i2) - 1;
                    if (!z) {
                        return (int) ((dArr[i] * d) + 0.5d);
                    }
                    double d2 = dArr[this.numColorComponents];
                    if (d2 != 0.0d) {
                        return (int) (((dArr[i] / d2) * d) + 0.5d);
                    }
                    return 0;
                }
                int[] iArr = (int[]) obj;
                i4 = iArr[i];
                if (z) {
                    i5 = iArr[this.numColorComponents];
                }
            }
            i5 = 0;
        } else {
            byte[] bArr = (byte[]) obj;
            i4 = bArr[i] & i7;
            i2 = 8;
            if (z) {
                s = bArr[this.numColorComponents];
                i5 = s & i7;
            }
            i5 = 0;
        }
        if (z) {
            if (i5 != 0) {
                return (int) (((((1 << r3[this.numColorComponents]) - 1) / i5) * (i4 / i7) * ((1 << i2) - 1)) + 0.5f);
            }
            return 0;
        }
        if (i6 != i2) {
            return (int) (((i4 / i7) * ((1 << i2) - 1)) + 0.5f);
        }
        return i4;
    }

    private int getRGBComponent(int i, int i2) {
        if (this.numComponents > 1) {
            throw new IllegalArgumentException("More than one component per pixel");
        }
        if (this.signed) {
            throw new IllegalArgumentException("Component value is signed");
        }
        if (this.needScaleInit) {
            initScale();
        }
        int i4 = this.transferType;
        return (int) ((this.colorSpace.toRGB(getNormalizedComponents(i4 != 0 ? i4 != 1 ? i4 != 3 ? null : new int[]{i} : new short[]{(short) i} : new byte[]{(byte) i}, null, 0))[i2] * 255.0f) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x013c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010e A[EDGE_INSN: B:83:0x010e->B:76:0x010e BREAK  A[LOOP:0: B:67:0x00f5->B:74:0x0109], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initScale() {
        int i;
        float[] normalizedComponents;
        float[] normalizedComponents2;
        float[] fArr;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        this.needScaleInit = false;
        if (this.nonStdScale || this.signed) {
            this.noUnnorm = true;
        } else {
            this.noUnnorm = false;
        }
        int i8 = this.transferType;
        float[] fArr2 = null;
        if (i8 == 0) {
            byte[] bArr = new byte[this.numComponents];
            int i9 = 0;
            while (true) {
                i = this.numColorComponents;
                if (i9 >= i) {
                    break;
                }
                bArr[i9] = 0;
                i9++;
            }
            if (this.supportsAlpha) {
                bArr[i] = (byte) ((1 << this.nBits[i]) - 1);
            }
            normalizedComponents = getNormalizedComponents(bArr, null, 0);
            for (int i10 = 0; i10 < this.numColorComponents; i10++) {
                bArr[i10] = (byte) ((1 << this.nBits[i10]) - 1);
            }
            normalizedComponents2 = getNormalizedComponents(bArr, null, 0);
        } else if (i8 == 1) {
            short[] sArr = new short[this.numComponents];
            int i11 = 0;
            while (true) {
                i5 = this.numColorComponents;
                if (i11 >= i5) {
                    break;
                }
                sArr[i11] = 0;
                i11++;
            }
            if (this.supportsAlpha) {
                sArr[i5] = (short) ((1 << this.nBits[i5]) - 1);
            }
            normalizedComponents = getNormalizedComponents(sArr, null, 0);
            for (int i12 = 0; i12 < this.numColorComponents; i12++) {
                sArr[i12] = (short) ((1 << this.nBits[i12]) - 1);
            }
            normalizedComponents2 = getNormalizedComponents(sArr, null, 0);
        } else if (i8 == 2) {
            short[] sArr2 = new short[this.numComponents];
            int i13 = 0;
            while (true) {
                i6 = this.numColorComponents;
                if (i13 >= i6) {
                    break;
                }
                sArr2[i13] = 0;
                i13++;
            }
            if (this.supportsAlpha) {
                sArr2[i6] = ShortCompanionObject.MAX_VALUE;
            }
            normalizedComponents = getNormalizedComponents(sArr2, null, 0);
            for (int i14 = 0; i14 < this.numColorComponents; i14++) {
                sArr2[i14] = ShortCompanionObject.MAX_VALUE;
            }
            normalizedComponents2 = getNormalizedComponents(sArr2, null, 0);
        } else {
            if (i8 != 3) {
                fArr = null;
                this.nonStdScale = false;
                i2 = 0;
                while (true) {
                    i4 = this.numColorComponents;
                    if (i2 >= i4) {
                        break;
                    }
                    if (fArr2[i2] != 0.0f || fArr[i2] != 1.0f) {
                        break;
                    } else {
                        i2++;
                    }
                }
                this.nonStdScale = true;
                if (this.nonStdScale) {
                    return;
                }
                this.noUnnorm = true;
                this.is_sRGB_stdScale = false;
                this.is_LinearRGB_stdScale = false;
                this.is_LinearGray_stdScale = false;
                this.is_ICCGray_stdScale = false;
                this.compOffset = new float[i4];
                this.compScale = new float[i4];
                for (int i15 = 0; i15 < this.numColorComponents; i15++) {
                    this.compOffset[i15] = fArr2[i15];
                    this.compScale[i15] = 1.0f / (fArr[i15] - fArr2[i15]);
                }
                return;
            }
            int[] iArr = new int[this.numComponents];
            int i16 = 0;
            while (true) {
                i7 = this.numColorComponents;
                if (i16 >= i7) {
                    break;
                }
                iArr[i16] = 0;
                i16++;
            }
            if (this.supportsAlpha) {
                iArr[i7] = (1 << this.nBits[i7]) - 1;
            }
            normalizedComponents = getNormalizedComponents(iArr, null, 0);
            for (int i17 = 0; i17 < this.numColorComponents; i17++) {
                iArr[i17] = (1 << this.nBits[i17]) - 1;
            }
            normalizedComponents2 = getNormalizedComponents(iArr, null, 0);
        }
        fArr = normalizedComponents2;
        fArr2 = normalizedComponents;
        this.nonStdScale = false;
        i2 = 0;
        while (true) {
            i4 = this.numColorComponents;
            if (i2 >= i4) {
            }
            i2++;
        }
        this.nonStdScale = true;
        if (this.nonStdScale) {
        }
    }

    private void setupLUTs() {
        if (this.is_sRGB) {
            this.is_sRGB_stdScale = true;
            this.nonStdScale = false;
            return;
        }
        if (ColorModel.isLinearRGBspace(this.colorSpace)) {
            this.is_LinearRGB_stdScale = true;
            this.nonStdScale = false;
            if (this.transferType == 0) {
                this.tosRGB8LUT = ColorModel.getLinearRGB8TosRGB8LUT();
                this.fromsRGB8LUT8 = ColorModel.getsRGB8ToLinearRGB8LUT();
                return;
            } else {
                this.tosRGB8LUT = ColorModel.getLinearRGB16TosRGB8LUT();
                this.fromsRGB8LUT16 = ColorModel.getsRGB8ToLinearRGB16LUT();
                return;
            }
        }
        if (this.colorSpaceType == 6) {
            ColorSpace colorSpace = this.colorSpace;
            if ((colorSpace instanceof ICC_ColorSpace) && colorSpace.getMinValue(0) == 0.0f && this.colorSpace.getMaxValue(0) == 1.0f) {
                ICC_ColorSpace iCC_ColorSpace = (ICC_ColorSpace) this.colorSpace;
                this.is_ICCGray_stdScale = true;
                this.nonStdScale = false;
                this.fromsRGB8LUT16 = ColorModel.getsRGB8ToLinearRGB16LUT();
                if (ColorModel.isLinearGRAYspace(iCC_ColorSpace)) {
                    this.is_LinearGray_stdScale = true;
                    if (this.transferType == 0) {
                        this.tosRGB8LUT = ColorModel.getGray8TosRGB8LUT(iCC_ColorSpace);
                        return;
                    } else {
                        this.tosRGB8LUT = ColorModel.getGray16TosRGB8LUT(iCC_ColorSpace);
                        return;
                    }
                }
                if (this.transferType == 0) {
                    this.tosRGB8LUT = ColorModel.getGray8TosRGB8LUT(iCC_ColorSpace);
                    this.fromLinearGray16ToOtherGray8LUT = ColorModel.getLinearGray16ToOtherGray8LUT(iCC_ColorSpace);
                    return;
                } else {
                    this.tosRGB8LUT = ColorModel.getGray16TosRGB8LUT(iCC_ColorSpace);
                    this.fromLinearGray16ToOtherGray16LUT = ColorModel.getLinearGray16ToOtherGray16LUT(iCC_ColorSpace);
                    return;
                }
            }
        }
        if (this.needScaleInit) {
            this.nonStdScale = false;
            for (int i = 0; i < this.numColorComponents; i++) {
                if (this.colorSpace.getMinValue(i) != 0.0f || this.colorSpace.getMaxValue(i) != 1.0f) {
                    this.nonStdScale = true;
                    break;
                }
            }
            if (this.nonStdScale) {
                int i2 = this.numColorComponents;
                this.min = new float[i2];
                this.diffMinMax = new float[i2];
                for (int i4 = 0; i4 < this.numColorComponents; i4++) {
                    this.min[i4] = this.colorSpace.getMinValue(i4);
                    this.diffMinMax[i4] = this.colorSpace.getMaxValue(i4) - this.min[i4];
                }
            }
        }
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public ColorModel coerceData(WritableRaster writableRaster, boolean z) {
        if (!this.supportsAlpha || this.isAlphaPremultiplied == z) {
            return this;
        }
        int width = writableRaster.getWidth();
        int height = writableRaster.getHeight();
        int numBands = writableRaster.getNumBands() - 1;
        int minX = writableRaster.getMinX();
        int minY = writableRaster.getMinY();
        double d = 0.0d;
        byte[] bArr = null;
        double[] dArr = null;
        float[] fArr = null;
        int[] iArr = null;
        short[] sArr = null;
        short[] sArr2 = null;
        byte[] bArr2 = null;
        double[] dArr2 = null;
        float[] fArr2 = null;
        int[] iArr2 = null;
        short[] sArr3 = null;
        short[] sArr4 = null;
        float f = 0.0f;
        if (z) {
            int i = this.transferType;
            if (i == 0) {
                float f4 = 1.0f / ((1 << this.nBits[numBands]) - 1);
                byte[] bArr3 = null;
                int i2 = 0;
                while (i2 < height) {
                    int i4 = minX;
                    byte[] bArr4 = bArr2;
                    int i5 = 0;
                    while (i5 < width) {
                        bArr4 = (byte[]) writableRaster.getDataElements(i4, minY, bArr4);
                        if ((bArr4[numBands] & 255) * f4 != 0.0f) {
                            for (int i6 = 0; i6 < numBands; i6++) {
                                bArr4[i6] = (byte) (((bArr4[i6] & 255) * r12) + 0.5f);
                            }
                            writableRaster.setDataElements(i4, minY, bArr4);
                        } else {
                            if (bArr3 == null) {
                                bArr3 = new byte[this.numComponents];
                                Arrays.fill(bArr3, (byte) 0);
                            }
                            writableRaster.setDataElements(i4, minY, bArr3);
                        }
                        i5++;
                        i4++;
                    }
                    i2++;
                    minY++;
                    bArr2 = bArr4;
                }
            } else if (i == 1) {
                float f5 = 1.0f / ((1 << this.nBits[numBands]) - 1);
                short[] sArr5 = null;
                int i7 = 0;
                while (i7 < height) {
                    int i8 = minX;
                    short[] sArr6 = sArr2;
                    int i9 = 0;
                    while (i9 < width) {
                        sArr6 = (short[]) writableRaster.getDataElements(i8, minY, sArr6);
                        if ((sArr6[numBands] & UShort.MAX_VALUE) * f5 != 0.0f) {
                            for (int i10 = 0; i10 < numBands; i10++) {
                                sArr6[i10] = (short) (((sArr6[i10] & UShort.MAX_VALUE) * r12) + 0.5f);
                            }
                            writableRaster.setDataElements(i8, minY, sArr6);
                        } else {
                            if (sArr5 == null) {
                                sArr5 = new short[this.numComponents];
                                Arrays.fill(sArr5, (short) 0);
                            }
                            writableRaster.setDataElements(i8, minY, sArr5);
                        }
                        i9++;
                        i8++;
                    }
                    i7++;
                    minY++;
                    sArr2 = sArr6;
                }
            } else if (i == 2) {
                short[] sArr7 = null;
                int i11 = 0;
                while (i11 < height) {
                    int i12 = minX;
                    short[] sArr8 = sArr;
                    int i13 = 0;
                    while (i13 < width) {
                        sArr8 = (short[]) writableRaster.getDataElements(i12, minY, sArr8);
                        if (sArr8[numBands] * 3.051851E-5f != 0.0f) {
                            for (int i14 = 0; i14 < numBands; i14++) {
                                sArr8[i14] = (short) ((sArr8[i14] * r13) + 0.5f);
                            }
                            writableRaster.setDataElements(i12, minY, sArr8);
                        } else {
                            if (sArr7 == null) {
                                sArr7 = new short[this.numComponents];
                                Arrays.fill(sArr7, (short) 0);
                            }
                            writableRaster.setDataElements(i12, minY, sArr7);
                        }
                        i13++;
                        i12++;
                    }
                    i11++;
                    minY++;
                    sArr = sArr8;
                }
            } else if (i == 3) {
                float f6 = 1.0f / ((1 << this.nBits[numBands]) - 1);
                int[] iArr3 = null;
                int i15 = 0;
                while (i15 < height) {
                    int i16 = minX;
                    int[] iArr4 = iArr;
                    int i17 = 0;
                    while (i17 < width) {
                        iArr4 = (int[]) writableRaster.getDataElements(i16, minY, iArr4);
                        float f7 = iArr4[numBands] * f6;
                        if (f7 != 0.0f) {
                            for (int i18 = 0; i18 < numBands; i18++) {
                                iArr4[i18] = (int) ((iArr4[i18] * f7) + 0.5f);
                            }
                            writableRaster.setDataElements(i16, minY, iArr4);
                        } else {
                            if (iArr3 == null) {
                                iArr3 = new int[this.numComponents];
                                Arrays.fill(iArr3, 0);
                            }
                            writableRaster.setDataElements(i16, minY, iArr3);
                        }
                        i17++;
                        i16++;
                    }
                    i15++;
                    minY++;
                    iArr = iArr4;
                }
            } else if (i == 4) {
                float[] fArr3 = null;
                int i19 = 0;
                while (i19 < height) {
                    int i20 = minX;
                    float[] fArr4 = fArr;
                    int i21 = 0;
                    while (i21 < width) {
                        fArr4 = (float[]) writableRaster.getDataElements(i20, minY, fArr4);
                        float f8 = fArr4[numBands];
                        if (f8 != f) {
                            for (int i22 = 0; i22 < numBands; i22++) {
                                fArr4[i22] = fArr4[i22] * f8;
                            }
                            writableRaster.setDataElements(i20, minY, fArr4);
                        } else {
                            if (fArr3 == null) {
                                fArr3 = new float[this.numComponents];
                                Arrays.fill(fArr3, f);
                            }
                            writableRaster.setDataElements(i20, minY, fArr3);
                        }
                        i21++;
                        i20++;
                        f = 0.0f;
                    }
                    i19++;
                    minY++;
                    fArr = fArr4;
                    f = 0.0f;
                }
            } else {
                if (i != 5) {
                    throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
                }
                double[] dArr3 = null;
                int i23 = 0;
                while (i23 < height) {
                    int i24 = minX;
                    double[] dArr4 = dArr;
                    int i25 = 0;
                    while (i25 < width) {
                        dArr4 = (double[]) writableRaster.getDataElements(i24, minY, dArr4);
                        double d2 = dArr4[numBands];
                        if (d2 != d) {
                            for (int i26 = 0; i26 < numBands; i26++) {
                                dArr4[i26] = dArr4[i26] * d2;
                            }
                            writableRaster.setDataElements(i24, minY, dArr4);
                        } else {
                            if (dArr3 == null) {
                                dArr3 = new double[this.numComponents];
                                Arrays.fill(dArr3, 0.0d);
                            }
                            writableRaster.setDataElements(i24, minY, dArr3);
                        }
                        i25++;
                        i24++;
                        d = 0.0d;
                    }
                    i23++;
                    minY++;
                    dArr = dArr4;
                    d = 0.0d;
                }
            }
        } else {
            int i27 = 0;
            int i28 = this.transferType;
            if (i28 == 0) {
                float f9 = 1.0f / ((1 << this.nBits[numBands]) - 1);
                int i29 = 0;
                while (i29 < height) {
                    int i30 = minX;
                    byte[] bArr5 = bArr;
                    int i31 = 0;
                    while (i31 < width) {
                        bArr5 = (byte[]) writableRaster.getDataElements(i30, minY, bArr5);
                        float f10 = (bArr5[numBands] & 255) * f9;
                        if (f10 != 0.0f) {
                            float f11 = 1.0f / f10;
                            for (int i32 = 0; i32 < numBands; i32++) {
                                bArr5[i32] = (byte) (((bArr5[i32] & 255) * f11) + 0.5f);
                            }
                            writableRaster.setDataElements(i30, minY, bArr5);
                        }
                        i31++;
                        i30++;
                    }
                    i29++;
                    minY++;
                    bArr = bArr5;
                }
            } else if (i28 == 1) {
                float f12 = 1.0f / ((1 << this.nBits[numBands]) - 1);
                int i33 = 0;
                while (i33 < height) {
                    int i34 = minX;
                    short[] sArr9 = sArr4;
                    int i35 = 0;
                    while (i35 < width) {
                        sArr9 = (short[]) writableRaster.getDataElements(i34, minY, sArr9);
                        float f13 = (sArr9[numBands] & UShort.MAX_VALUE) * f12;
                        if (f13 != 0.0f) {
                            float f14 = 1.0f / f13;
                            for (int i36 = 0; i36 < numBands; i36++) {
                                sArr9[i36] = (short) (((sArr9[i36] & UShort.MAX_VALUE) * f14) + 0.5f);
                            }
                            writableRaster.setDataElements(i34, minY, sArr9);
                        }
                        i35++;
                        i34++;
                    }
                    i33++;
                    minY++;
                    sArr4 = sArr9;
                }
            } else if (i28 == 2) {
                int i37 = 0;
                while (i37 < height) {
                    int i38 = minX;
                    short[] sArr10 = sArr3;
                    int i39 = 0;
                    while (i39 < width) {
                        sArr10 = (short[]) writableRaster.getDataElements(i38, minY, sArr10);
                        float f15 = sArr10[numBands] * 3.051851E-5f;
                        if (f15 != 0.0f) {
                            float f16 = 1.0f / f15;
                            for (int i40 = 0; i40 < numBands; i40++) {
                                sArr10[i40] = (short) ((sArr10[i40] * f16) + 0.5f);
                            }
                            writableRaster.setDataElements(i38, minY, sArr10);
                        }
                        i39++;
                        i38++;
                    }
                    i37++;
                    minY++;
                    sArr3 = sArr10;
                }
            } else if (i28 == 3) {
                float f17 = 1.0f / ((1 << this.nBits[numBands]) - 1);
                int i41 = 0;
                while (i41 < height) {
                    int i42 = minX;
                    int i43 = i27;
                    int[] iArr5 = iArr2;
                    while (i43 < width) {
                        iArr5 = (int[]) writableRaster.getDataElements(i42, minY, iArr5);
                        float f18 = iArr5[numBands] * f17;
                        if (f18 != 0.0f) {
                            float f19 = 1.0f / f18;
                            for (int i44 = i27; i44 < numBands; i44++) {
                                iArr5[i44] = (int) ((iArr5[i44] * f19) + 0.5f);
                            }
                            writableRaster.setDataElements(i42, minY, iArr5);
                        }
                        i43++;
                        i42++;
                        i27 = 0;
                    }
                    i41++;
                    minY++;
                    iArr2 = iArr5;
                    i27 = 0;
                }
            } else if (i28 == 4) {
                int i45 = 0;
                while (i45 < height) {
                    int i46 = minX;
                    int i47 = 0;
                    float[] fArr5 = fArr2;
                    while (i47 < width) {
                        fArr5 = (float[]) writableRaster.getDataElements(i46, minY, fArr5);
                        float f20 = fArr5[numBands];
                        if (f20 != 0.0f) {
                            float f21 = 1.0f / f20;
                            for (int i48 = 0; i48 < numBands; i48++) {
                                fArr5[i48] = fArr5[i48] * f21;
                            }
                            writableRaster.setDataElements(i46, minY, fArr5);
                        }
                        i47++;
                        i46++;
                    }
                    i45++;
                    minY++;
                    fArr2 = fArr5;
                }
            } else {
                if (i28 != 5) {
                    throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
                }
                int i49 = 0;
                while (i49 < height) {
                    int i50 = minX;
                    int i51 = 0;
                    double[] dArr5 = dArr2;
                    while (i51 < width) {
                        dArr5 = (double[]) writableRaster.getDataElements(i50, minY, dArr5);
                        double d3 = dArr5[numBands];
                        if (d3 != 0.0d) {
                            double d4 = 1.0d / d3;
                            for (int i52 = 0; i52 < numBands; i52++) {
                                dArr5[i52] = dArr5[i52] * d4;
                            }
                            writableRaster.setDataElements(i50, minY, dArr5);
                        }
                        i51++;
                        i50++;
                    }
                    i49++;
                    minY++;
                    dArr2 = dArr5;
                }
            }
        }
        return !this.signed ? new ComponentColorModel(this.colorSpace, this.nBits, this.supportsAlpha, z, this.transparency, this.transferType) : new ComponentColorModel(this.colorSpace, this.supportsAlpha, z, this.transparency, this.transferType);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public SampleModel createCompatibleSampleModel(int i, int i2) {
        int[] iArr = new int[this.numComponents];
        for (int i4 = 0; i4 < this.numComponents; i4++) {
            iArr[i4] = i4;
        }
        int i5 = this.transferType;
        if (i5 == 0 || i5 == 1) {
            int i6 = this.transferType;
            int i7 = this.numComponents;
            return new PixelInterleavedSampleModel(i6, i, i2, i7, i * i7, iArr);
        }
        int i8 = this.transferType;
        int i9 = this.numComponents;
        return new ComponentSampleModel(i8, i, i2, i9, i * i9, iArr);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public WritableRaster createCompatibleWritableRaster(int i, int i2) {
        int i4 = this.numComponents;
        int i5 = this.transferType;
        if (i5 == 0 || i5 == 1) {
            return Raster.createInterleavedRaster(i5, i, i2, i4, null);
        }
        SampleModel sampleModelCreateCompatibleSampleModel = createCompatibleSampleModel(i, i2);
        return Raster.createWritableRaster(sampleModelCreateCompatibleSampleModel, sampleModelCreateCompatibleSampleModel.createDataBuffer(), null);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public boolean equals(Object obj) {
        return super.equals(obj) && obj.getClass() == getClass();
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getAlpha(int i) {
        if (!this.supportsAlpha) {
            return 255;
        }
        if (this.numComponents > 1) {
            throw new IllegalArgumentException("More than one component per pixel");
        }
        if (this.signed) {
            throw new IllegalArgumentException("Component value is signed");
        }
        return (int) (((i / ((1 << this.nBits[0]) - 1)) * 255.0f) + 0.5f);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public WritableRaster getAlphaRaster(WritableRaster writableRaster) {
        if (!hasAlpha()) {
            return null;
        }
        int minX = writableRaster.getMinX();
        int minY = writableRaster.getMinY();
        return writableRaster.createWritableChild(minX, minY, writableRaster.getWidth(), writableRaster.getHeight(), minX, minY, new int[]{writableRaster.getNumBands() - 1});
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getBlue(int i) {
        return getRGBComponent(i, 2);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int[] getComponents(int i, int[] iArr, int i2) {
        if (this.numComponents > 1) {
            throw new IllegalArgumentException("More than one component per pixel");
        }
        if (this.needScaleInit) {
            initScale();
        }
        if (this.noUnnorm) {
            throw new IllegalArgumentException("This ColorModel does not support the unnormalized form");
        }
        if (iArr == null) {
            iArr = new int[i2 + 1];
        }
        iArr[i2] = i & ((1 << this.nBits[0]) - 1);
        return iArr;
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getDataElement(float[] fArr, int i) {
        if (this.numComponents > 1) {
            throw new IllegalArgumentException("More than one component per pixel");
        }
        if (this.signed) {
            throw new IllegalArgumentException("Component value is signed");
        }
        if (this.needScaleInit) {
            initScale();
        }
        Object dataElements = getDataElements(fArr, i, (Object) null);
        int i2 = this.transferType;
        if (i2 == 0) {
            return ((byte[]) dataElements)[0] & 255;
        }
        if (i2 == 1) {
            return ((short[]) dataElements)[0] & UShort.MAX_VALUE;
        }
        if (i2 == 3) {
            return ((int[]) dataElements)[0];
        }
        throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
    }

    /* JADX WARN: Removed duplicated region for block: B:241:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0589  */
    @Override // org.apache.poi.java.awt.image.ColorModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getDataElements(int i, Object obj) {
        float f;
        int i2;
        float f4;
        int[] iArr;
        float f5;
        double d;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        if (this.needScaleInit) {
            initScale();
        }
        if (this.signed) {
            int i7 = this.transferType;
            f = 1.0f;
            if (i7 == 2) {
                short[] sArr = obj == null ? new short[this.numComponents] : (short[]) obj;
                float f6 = 0.49999237f;
                if (this.is_sRGB_stdScale || this.is_LinearRGB_stdScale) {
                    if (this.is_LinearRGB_stdScale) {
                        short[] sArr2 = this.fromsRGB8LUT16;
                        i4 = sArr2[i4] & UShort.MAX_VALUE;
                        i5 = sArr2[i5] & UShort.MAX_VALUE;
                        i6 = sArr2[i6] & UShort.MAX_VALUE;
                    } else {
                        f6 = 128.49803f;
                    }
                    if (this.supportsAlpha) {
                        float f7 = (i >> 24) & 255;
                        sArr[3] = (short) ((128.49803f * f7) + 0.5f);
                        if (this.isAlphaPremultiplied) {
                            f6 = f7 * f6 * 0.003921569f;
                        }
                    }
                    sArr[0] = (short) ((i4 * f6) + 0.5f);
                    sArr[1] = (short) ((i5 * f6) + 0.5f);
                    sArr[2] = (short) ((i6 * f6) + 0.5f);
                    return sArr;
                }
                float f8 = 32767.0f;
                if (this.is_LinearGray_stdScale) {
                    short[] sArr3 = this.fromsRGB8LUT16;
                    float f9 = (((sArr3[i6] & UShort.MAX_VALUE) * 0.0721f) + (((sArr3[i5] & UShort.MAX_VALUE) * 0.7154f) + ((sArr3[i4] & UShort.MAX_VALUE) * 0.2125f))) / 65535.0f;
                    if (this.supportsAlpha) {
                        float f10 = (i >> 24) & 255;
                        sArr[1] = (short) ((128.49803f * f10) + 0.5f);
                        if (this.isAlphaPremultiplied) {
                            f8 = f10 * 32767.0f * 0.003921569f;
                        }
                    }
                    sArr[0] = (short) ((f9 * f8) + 0.5f);
                    return sArr;
                }
                if (this.is_ICCGray_stdScale) {
                    short[] sArr4 = this.fromsRGB8LUT16;
                    int i8 = this.fromLinearGray16ToOtherGray16LUT[(int) (((sArr4[i6] & UShort.MAX_VALUE) * 0.0721f) + ((sArr4[i5] & UShort.MAX_VALUE) * 0.7154f) + ((sArr4[i4] & UShort.MAX_VALUE) * 0.2125f) + 0.5f)] & UShort.MAX_VALUE;
                    if (this.supportsAlpha) {
                        float f11 = (i >> 24) & 255;
                        sArr[1] = (short) ((128.49803f * f11) + 0.5f);
                        if (this.isAlphaPremultiplied) {
                            f6 = f11 * 0.49999237f * 0.003921569f;
                        }
                    }
                    sArr[0] = (short) ((i8 * f6) + 0.5f);
                    return sArr;
                }
                float[] fArrFromRGB = this.colorSpace.fromRGB(new float[]{i4 * 0.003921569f, i5 * 0.003921569f, i6 * 0.003921569f});
                if (this.nonStdScale) {
                    for (int i9 = 0; i9 < this.numColorComponents; i9++) {
                        float f12 = (fArrFromRGB[i9] - this.compOffset[i9]) * this.compScale[i9];
                        fArrFromRGB[i9] = f12;
                        if (f12 < 0.0f) {
                            fArrFromRGB[i9] = 0.0f;
                        }
                        if (fArrFromRGB[i9] > 1.0f) {
                            fArrFromRGB[i9] = 1.0f;
                        }
                    }
                }
                if (this.supportsAlpha) {
                    float f13 = (i >> 24) & 255;
                    sArr[this.numColorComponents] = (short) ((128.49803f * f13) + 0.5f);
                    if (this.isAlphaPremultiplied) {
                        f8 = 32767.0f * f13 * 0.003921569f;
                    }
                }
                for (int i10 = 0; i10 < this.numColorComponents; i10++) {
                    sArr[i10] = (short) ((fArrFromRGB[i10] * f8) + 0.5f);
                }
                return sArr;
            }
            if (i7 == 4) {
                float[] fArr = obj == null ? new float[this.numComponents] : (float[]) obj;
                if (this.is_sRGB_stdScale || this.is_LinearRGB_stdScale) {
                    if (this.is_LinearRGB_stdScale) {
                        short[] sArr5 = this.fromsRGB8LUT16;
                        i4 = sArr5[i4] & UShort.MAX_VALUE;
                        i5 = sArr5[i5] & UShort.MAX_VALUE;
                        i6 = sArr5[i6] & UShort.MAX_VALUE;
                        f5 = 1.5259022E-5f;
                    } else {
                        f5 = 0.003921569f;
                    }
                    if (this.supportsAlpha) {
                        float f14 = ((i >> 24) & 255) * 0.003921569f;
                        fArr[3] = f14;
                        if (this.isAlphaPremultiplied) {
                            f5 *= f14;
                        }
                    }
                    fArr[0] = i4 * f5;
                    fArr[1] = i5 * f5;
                    fArr[2] = i6 * f5;
                    return fArr;
                }
                if (this.is_LinearGray_stdScale) {
                    short[] sArr6 = this.fromsRGB8LUT16;
                    float f15 = (((sArr6[i6] & UShort.MAX_VALUE) * 0.0721f) + (((sArr6[i5] & UShort.MAX_VALUE) * 0.7154f) + ((sArr6[i4] & UShort.MAX_VALUE) * 0.2125f))) / 65535.0f;
                    fArr[0] = f15;
                    if (this.supportsAlpha) {
                        float f16 = ((i >> 24) & 255) * 0.003921569f;
                        fArr[1] = f16;
                        if (this.isAlphaPremultiplied) {
                            fArr[0] = f15 * f16;
                            return fArr;
                        }
                    }
                } else if (this.is_ICCGray_stdScale) {
                    short[] sArr7 = this.fromsRGB8LUT16;
                    float f17 = (this.fromLinearGray16ToOtherGray16LUT[(int) ((((sArr7[i6] & UShort.MAX_VALUE) * 0.0721f) + (((sArr7[i5] & UShort.MAX_VALUE) * 0.7154f) + ((sArr7[i4] & UShort.MAX_VALUE) * 0.2125f))) + 0.5f)] & UShort.MAX_VALUE) / 65535.0f;
                    fArr[0] = f17;
                    if (this.supportsAlpha) {
                        float f18 = ((i >> 24) & 255) * 0.003921569f;
                        fArr[1] = f18;
                        if (this.isAlphaPremultiplied) {
                            fArr[0] = f17 * f18;
                            return fArr;
                        }
                    }
                } else {
                    float[] fArrFromRGB2 = this.colorSpace.fromRGB(new float[]{i4 * 0.003921569f, i5 * 0.003921569f, i6 * 0.003921569f});
                    if (this.supportsAlpha) {
                        float f19 = ((i >> 24) & 255) * 0.003921569f;
                        fArr[this.numColorComponents] = f19;
                        if (this.isAlphaPremultiplied) {
                            for (int i11 = 0; i11 < this.numColorComponents; i11++) {
                                fArrFromRGB2[i11] = fArrFromRGB2[i11] * f19;
                            }
                        }
                    }
                    for (int i12 = 0; i12 < this.numColorComponents; i12++) {
                        fArr[i12] = fArrFromRGB2[i12];
                    }
                }
                return fArr;
            }
            if (i7 == 5) {
                double[] dArr = obj == null ? new double[this.numComponents] : (double[]) obj;
                if (this.is_sRGB_stdScale || this.is_LinearRGB_stdScale) {
                    if (this.is_LinearRGB_stdScale) {
                        short[] sArr8 = this.fromsRGB8LUT16;
                        i4 = sArr8[i4] & UShort.MAX_VALUE;
                        i5 = sArr8[i5] & UShort.MAX_VALUE;
                        i6 = sArr8[i6] & UShort.MAX_VALUE;
                        d = 1.5259021896696422E-5d;
                    } else {
                        d = 0.00392156862745098d;
                    }
                    if (this.supportsAlpha) {
                        double d2 = ((double) ((i >> 24) & 255)) * 0.00392156862745098d;
                        dArr[3] = d2;
                        if (this.isAlphaPremultiplied) {
                            d *= d2;
                        }
                    }
                    dArr[0] = ((double) i4) * d;
                    dArr[1] = ((double) i5) * d;
                    dArr[2] = ((double) i6) * d;
                    return dArr;
                }
                if (this.is_LinearGray_stdScale) {
                    short[] sArr9 = this.fromsRGB8LUT16;
                    double dM1308a = AbstractC1974b.m1308a(sArr9[i6] & UShort.MAX_VALUE, 0.0721d, (((double) (sArr9[i5] & UShort.MAX_VALUE)) * 0.7154d) + (((double) (sArr9[i4] & UShort.MAX_VALUE)) * 0.2125d), 65535.0d);
                    dArr[0] = dM1308a;
                    if (this.supportsAlpha) {
                        double d3 = ((double) ((i >> 24) & 255)) * 0.00392156862745098d;
                        dArr[1] = d3;
                        if (this.isAlphaPremultiplied) {
                            dArr[0] = dM1308a * d3;
                            return dArr;
                        }
                    }
                } else if (this.is_ICCGray_stdScale) {
                    short[] sArr10 = this.fromsRGB8LUT16;
                    double d4 = ((double) (this.fromLinearGray16ToOtherGray16LUT[(int) ((((sArr10[i6] & UShort.MAX_VALUE) * 0.0721f) + (((sArr10[i5] & UShort.MAX_VALUE) * 0.7154f) + ((sArr10[i4] & UShort.MAX_VALUE) * 0.2125f))) + 0.5f)] & UShort.MAX_VALUE)) / 65535.0d;
                    dArr[0] = d4;
                    if (this.supportsAlpha) {
                        double d5 = ((double) ((i >> 24) & 255)) * 0.00392156862745098d;
                        dArr[1] = d5;
                        if (this.isAlphaPremultiplied) {
                            dArr[0] = d4 * d5;
                            return dArr;
                        }
                    }
                } else {
                    float[] fArrFromRGB3 = this.colorSpace.fromRGB(new float[]{i4 * 0.003921569f, i5 * 0.003921569f, i6 * 0.003921569f});
                    if (this.supportsAlpha) {
                        int i13 = (i >> 24) & 255;
                        dArr[this.numColorComponents] = ((double) i13) * 0.00392156862745098d;
                        if (this.isAlphaPremultiplied) {
                            float f20 = i13 * 0.003921569f;
                            for (int i14 = 0; i14 < this.numColorComponents; i14++) {
                                fArrFromRGB3[i14] = fArrFromRGB3[i14] * f20;
                            }
                        }
                    }
                    for (int i15 = 0; i15 < this.numColorComponents; i15++) {
                        dArr[i15] = fArrFromRGB3[i15];
                    }
                }
                return dArr;
            }
        } else {
            f = 1.0f;
        }
        int i16 = this.transferType;
        int[] iArr2 = (i16 != 3 || obj == null) ? new int[this.numComponents] : (int[]) obj;
        if (this.is_sRGB_stdScale || this.is_LinearRGB_stdScale) {
            if (!this.is_LinearRGB_stdScale) {
                i2 = 8;
                f4 = 0.003921569f;
                if (this.supportsAlpha) {
                    int i17 = (i >> 24) & 255;
                    if (this.nBits[3] == 8) {
                        iArr2[3] = i17;
                    } else {
                        iArr2[3] = (int) ((i17 * 0.003921569f * ((1 << r8) - 1)) + 0.5f);
                    }
                    if (this.isAlphaPremultiplied) {
                        f4 *= i17 * 0.003921569f;
                        i2 = -1;
                    }
                }
                iArr = this.nBits;
                if (iArr[0] == i2) {
                    iArr2[0] = i4;
                } else {
                    iArr2[0] = (int) ((i4 * f4 * ((1 << r8) - 1)) + 0.5f);
                }
                if (iArr[1] == i2) {
                    iArr2[1] = i5;
                } else {
                    iArr2[1] = (int) ((i5 * f4 * ((1 << r2) - 1)) + 0.5f);
                }
                if (iArr[2] == i2) {
                    iArr2[2] = i6;
                } else {
                    iArr2[2] = (int) ((i6 * f4 * ((1 << r1) - 1)) + 0.5f);
                }
            } else if (i16 == 0) {
                byte[] bArr = this.fromsRGB8LUT8;
                i4 = bArr[i4] & 255;
                i5 = bArr[i5] & 255;
                i6 = bArr[i6] & 255;
                i2 = 8;
                f4 = 0.003921569f;
                if (this.supportsAlpha) {
                }
                iArr = this.nBits;
                if (iArr[0] == i2) {
                }
                if (iArr[1] == i2) {
                }
                if (iArr[2] == i2) {
                }
            } else {
                short[] sArr11 = this.fromsRGB8LUT16;
                i4 = sArr11[i4] & UShort.MAX_VALUE;
                i5 = sArr11[i5] & UShort.MAX_VALUE;
                i6 = sArr11[i6] & UShort.MAX_VALUE;
                i2 = 16;
                f4 = 1.5259022E-5f;
                if (this.supportsAlpha) {
                }
                iArr = this.nBits;
                if (iArr[0] == i2) {
                }
                if (iArr[1] == i2) {
                }
                if (iArr[2] == i2) {
                }
            }
        } else if (this.is_LinearGray_stdScale) {
            short[] sArr12 = this.fromsRGB8LUT16;
            float f21 = (((sArr12[i6] & UShort.MAX_VALUE) * 0.0721f) + (((sArr12[i5] & UShort.MAX_VALUE) * 0.7154f) + ((sArr12[i4] & UShort.MAX_VALUE) * 0.2125f))) / 65535.0f;
            if (this.supportsAlpha) {
                int i18 = (i >> 24) & 255;
                if (this.nBits[1] == 8) {
                    iArr2[1] = i18;
                } else {
                    iArr2[1] = (int) ((i18 * 0.003921569f * ((1 << r3) - 1)) + 0.5f);
                }
                if (this.isAlphaPremultiplied) {
                    f21 *= i18 * 0.003921569f;
                }
            }
            iArr2[0] = (int) ((f21 * ((1 << this.nBits[0]) - 1)) + 0.5f);
        } else if (this.is_ICCGray_stdScale) {
            short[] sArr13 = this.fromsRGB8LUT16;
            float f22 = (this.fromLinearGray16ToOtherGray16LUT[(int) ((((sArr13[i6] & UShort.MAX_VALUE) * 0.0721f) + (((sArr13[i5] & UShort.MAX_VALUE) * 0.7154f) + ((sArr13[i4] & UShort.MAX_VALUE) * 0.2125f))) + 0.5f)] & UShort.MAX_VALUE) / 65535.0f;
            if (this.supportsAlpha) {
                int i19 = (i >> 24) & 255;
                if (this.nBits[1] == 8) {
                    iArr2[1] = i19;
                } else {
                    iArr2[1] = (int) ((i19 * 0.003921569f * ((1 << r3) - 1)) + 0.5f);
                }
                if (this.isAlphaPremultiplied) {
                    f22 *= i19 * 0.003921569f;
                }
            }
            iArr2[0] = (int) ((f22 * ((1 << this.nBits[0]) - 1)) + 0.5f);
        } else {
            float[] fArrFromRGB4 = this.colorSpace.fromRGB(new float[]{i4 * 0.003921569f, i5 * 0.003921569f, i6 * 0.003921569f});
            if (this.nonStdScale) {
                for (int i20 = 0; i20 < this.numColorComponents; i20++) {
                    float f23 = (fArrFromRGB4[i20] - this.compOffset[i20]) * this.compScale[i20];
                    fArrFromRGB4[i20] = f23;
                    if (f23 < 0.0f) {
                        fArrFromRGB4[i20] = 0.0f;
                    }
                    if (fArrFromRGB4[i20] > f) {
                        fArrFromRGB4[i20] = f;
                    }
                }
            }
            if (this.supportsAlpha) {
                int i21 = (i >> 24) & 255;
                int[] iArr3 = this.nBits;
                int i22 = this.numColorComponents;
                if (iArr3[i22] == 8) {
                    iArr2[i22] = i21;
                } else {
                    iArr2[i22] = (int) ((i21 * 0.003921569f * ((1 << r3) - 1)) + 0.5f);
                }
                if (this.isAlphaPremultiplied) {
                    float f24 = 0.003921569f * i21;
                    for (int i23 = 0; i23 < this.numColorComponents; i23++) {
                        fArrFromRGB4[i23] = fArrFromRGB4[i23] * f24;
                    }
                }
            }
            for (int i24 = 0; i24 < this.numColorComponents; i24++) {
                iArr2[i24] = (int) ((fArrFromRGB4[i24] * ((1 << this.nBits[i24]) - 1)) + 0.5f);
            }
        }
        int i25 = this.transferType;
        if (i25 == 0) {
            byte[] bArr2 = obj == null ? new byte[this.numComponents] : (byte[]) obj;
            for (int i26 = 0; i26 < this.numComponents; i26++) {
                bArr2[i26] = (byte) (iArr2[i26] & 255);
            }
            return bArr2;
        }
        if (i25 == 1) {
            short[] sArr14 = obj == null ? new short[this.numComponents] : (short[]) obj;
            for (int i27 = 0; i27 < this.numComponents; i27++) {
                sArr14[i27] = (short) (iArr2[i27] & 65535);
            }
            return sArr14;
        }
        if (i25 != 3) {
            throw new IllegalArgumentException("This method has not been implemented for transferType " + this.transferType);
        }
        if (this.maxBits > 23) {
            for (int i28 = 0; i28 < this.numComponents; i28++) {
                int i29 = iArr2[i28];
                int i30 = this.nBits[i28];
                if (i29 > (1 << i30) - 1) {
                    iArr2[i28] = (1 << i30) - 1;
                }
            }
        }
        return iArr2;
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getGreen(int i) {
        return getRGBComponent(i, 1);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public float[] getNormalizedComponents(Object obj, float[] fArr, int i) {
        if (fArr == null) {
            fArr = new float[this.numComponents + i];
        }
        int i2 = this.transferType;
        if (i2 == 0) {
            byte[] bArr = (byte[]) obj;
            int i4 = i;
            int i5 = 0;
            while (i5 < this.numComponents) {
                fArr[i4] = (bArr[i5] & 255) / ((1 << this.nBits[i5]) - 1);
                i5++;
                i4++;
            }
        } else if (i2 == 1) {
            short[] sArr = (short[]) obj;
            int i6 = i;
            int i7 = 0;
            while (i7 < this.numComponents) {
                fArr[i6] = (sArr[i7] & UShort.MAX_VALUE) / ((1 << this.nBits[i7]) - 1);
                i7++;
                i6++;
            }
        } else if (i2 == 2) {
            short[] sArr2 = (short[]) obj;
            int i8 = i;
            int i9 = 0;
            while (i9 < this.numComponents) {
                fArr[i8] = sArr2[i9] / 32767.0f;
                i9++;
                i8++;
            }
        } else if (i2 == 3) {
            int[] iArr = (int[]) obj;
            int i10 = i;
            int i11 = 0;
            while (i11 < this.numComponents) {
                fArr[i10] = iArr[i11] / ((1 << this.nBits[i11]) - 1);
                i11++;
                i10++;
            }
        } else if (i2 == 4) {
            float[] fArr2 = (float[]) obj;
            int i12 = i;
            int i13 = 0;
            while (i13 < this.numComponents) {
                fArr[i12] = fArr2[i13];
                i13++;
                i12++;
            }
        } else {
            if (i2 != 5) {
                throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
            }
            double[] dArr = (double[]) obj;
            int i14 = i;
            int i15 = 0;
            while (i15 < this.numComponents) {
                fArr[i14] = (float) dArr[i15];
                i15++;
                i14++;
            }
        }
        if (this.supportsAlpha && this.isAlphaPremultiplied) {
            float f = fArr[this.numColorComponents + i];
            if (f != 0.0f) {
                float f4 = 1.0f / f;
                for (int i16 = i; i16 < this.numColorComponents + i; i16++) {
                    fArr[i16] = fArr[i16] * f4;
                }
            }
        }
        if (this.min != null) {
            for (int i17 = 0; i17 < this.numColorComponents; i17++) {
                int i18 = i17 + i;
                fArr[i18] = (this.diffMinMax[i17] * fArr[i18]) + this.min[i17];
            }
        }
        return fArr;
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getRGB(int i) {
        if (this.numComponents > 1) {
            throw new IllegalArgumentException("More than one component per pixel");
        }
        if (this.signed) {
            throw new IllegalArgumentException("Component value is signed");
        }
        return getBlue(i) | (getAlpha(i) << 24) | (getRed(i) << 16) | (getGreen(i) << 8);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getRed(int i) {
        return getRGBComponent(i, 0);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int[] getUnnormalizedComponents(float[] fArr, int i, int[] iArr, int i2) {
        if (this.needScaleInit) {
            initScale();
        }
        if (this.noUnnorm) {
            throw new IllegalArgumentException("This ColorModel does not support the unnormalized form");
        }
        return super.getUnnormalizedComponents(fArr, i, iArr, i2);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public boolean isCompatibleRaster(Raster raster) {
        SampleModel sampleModel = raster.getSampleModel();
        if (!(sampleModel instanceof ComponentSampleModel) || sampleModel.getNumBands() != getNumComponents()) {
            return false;
        }
        for (int i = 0; i < this.nBits.length; i++) {
            if (sampleModel.getSampleSize(i) < this.nBits[i]) {
                return false;
            }
        }
        return raster.getTransferType() == this.transferType;
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public boolean isCompatibleSampleModel(SampleModel sampleModel) {
        return (sampleModel instanceof ComponentSampleModel) && this.numComponents == sampleModel.getNumBands() && sampleModel.getTransferType() == this.transferType;
    }

    public ComponentColorModel(ColorSpace colorSpace, int[] iArr, boolean z, boolean z2, int i, int i2) {
        super(bitsHelper(i2, colorSpace, z), bitsArrayHelper(iArr, i2, colorSpace, z), colorSpace, z, z2, i, i2);
        if (i2 == 0 || i2 == 1) {
            this.signed = false;
            this.needScaleInit = true;
        } else if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 4 && i2 != 5) {
                    throw new IllegalArgumentException(AbstractC0000a.m11h(i2, "This constructor is not compatible with transferType "));
                }
                this.signed = true;
                this.needScaleInit = false;
                this.noUnnorm = true;
                this.nonStdScale = false;
            }
            this.signed = false;
            this.needScaleInit = true;
        } else {
            this.signed = true;
            this.needScaleInit = true;
        }
        setupLUTs();
    }

    private int getRGBComponent(Object obj, int i) {
        if (this.needScaleInit) {
            initScale();
        }
        if (this.is_sRGB_stdScale) {
            return extractComponent(obj, i, 8);
        }
        if (this.is_LinearRGB_stdScale) {
            return this.tosRGB8LUT[extractComponent(obj, i, 16)] & 255;
        }
        if (this.is_ICCGray_stdScale) {
            return this.tosRGB8LUT[extractComponent(obj, 0, 16)] & 255;
        }
        return (int) ((this.colorSpace.toRGB(getNormalizedComponents(obj, null, 0))[i] * 255.0f) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    @Override // org.apache.poi.java.awt.image.ColorModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getAlpha(Object obj) {
        short s;
        int i;
        if (!this.supportsAlpha) {
            return 255;
        }
        int i2 = this.numColorComponents;
        int i4 = this.nBits[i2];
        int i5 = (1 << i4) - 1;
        int i6 = this.transferType;
        if (i6 == 0) {
            s = ((byte[]) obj)[i2];
        } else {
            if (i6 != 1) {
                if (i6 == 2) {
                    return (int) (((((short[]) obj)[i2] / 32767.0f) * 255.0f) + 0.5f);
                }
                if (i6 == 3) {
                    i = ((int[]) obj)[i2];
                    return i4 != 8 ? i : (int) (((i / ((1 << i4) - 1)) * 255.0f) + 0.5f);
                }
                if (i6 == 4) {
                    return (int) ((((float[]) obj)[i2] * 255.0f) + 0.5f);
                }
                if (i6 == 5) {
                    return (int) ((((double[]) obj)[i2] * 255.0d) + 0.5d);
                }
                throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
            }
            s = ((short[]) obj)[i2];
        }
        i = s & i5;
        if (i4 != 8) {
        }
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getBlue(Object obj) {
        return getRGBComponent(obj, 2);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int[] getComponents(Object obj, int[] iArr, int i) {
        int[] intArray;
        if (this.needScaleInit) {
            initScale();
        }
        if (this.noUnnorm) {
            throw new IllegalArgumentException("This ColorModel does not support the unnormalized form");
        }
        if (obj instanceof int[]) {
            intArray = (int[]) obj;
        } else {
            intArray = DataBuffer.toIntArray(obj);
            if (intArray == null) {
                throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
            }
        }
        int length = intArray.length;
        int i2 = this.numComponents;
        if (length < i2) {
            throw new IllegalArgumentException("Length of pixel array < number of components in model");
        }
        if (iArr == null) {
            iArr = new int[i + i2];
        } else if (iArr.length - i < i2) {
            throw new IllegalArgumentException("Length of components array < number of components in model");
        }
        System.arraycopy(intArray, 0, iArr, i, i2);
        return iArr;
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getDataElement(int[] iArr, int i) {
        if (this.needScaleInit) {
            initScale();
        }
        if (this.numComponents != 1) {
            throw new IllegalArgumentException(AbstractC2821a.m2223n(new StringBuilder("This model returns "), " elements in the pixel array.", this.numComponents));
        }
        if (this.noUnnorm) {
            throw new IllegalArgumentException("This ColorModel does not support the unnormalized form");
        }
        return iArr[i];
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public Object getDataElements(float[] fArr, int i, Object obj) {
        float[] fArr2;
        int i2;
        int i4 = 0;
        boolean z = this.supportsAlpha && this.isAlphaPremultiplied;
        if (this.needScaleInit) {
            initScale();
        }
        if (this.nonStdScale) {
            fArr2 = new float[this.numComponents];
            int i5 = i;
            int i6 = 0;
            while (true) {
                i2 = this.numColorComponents;
                if (i6 >= i2) {
                    break;
                }
                float f = (fArr[i5] - this.compOffset[i6]) * this.compScale[i6];
                fArr2[i6] = f;
                if (f < 0.0f) {
                    fArr2[i6] = 0.0f;
                }
                if (fArr2[i6] > 1.0f) {
                    fArr2[i6] = 1.0f;
                }
                i6++;
                i5++;
            }
            if (this.supportsAlpha) {
                fArr2[i2] = fArr[i + i2];
            }
            i = 0;
        } else {
            fArr2 = fArr;
        }
        int i7 = this.transferType;
        if (i7 == 0) {
            byte[] bArr = obj == null ? new byte[this.numComponents] : (byte[]) obj;
            if (!z) {
                while (i4 < this.numComponents) {
                    bArr[i4] = (byte) ((fArr2[i] * ((1 << this.nBits[i4]) - 1)) + 0.5f);
                    i4++;
                    i++;
                }
                return bArr;
            }
            float f4 = fArr2[this.numColorComponents + i];
            while (true) {
                int i8 = this.numColorComponents;
                if (i4 >= i8) {
                    bArr[i8] = (byte) ((f4 * ((1 << this.nBits[i8]) - 1)) + 0.5f);
                    return bArr;
                }
                bArr[i4] = (byte) ((fArr2[i] * f4 * ((1 << this.nBits[i4]) - 1)) + 0.5f);
                i4++;
                i++;
            }
        } else if (i7 == 1) {
            short[] sArr = obj == null ? new short[this.numComponents] : (short[]) obj;
            if (!z) {
                while (i4 < this.numComponents) {
                    sArr[i4] = (short) ((fArr2[i] * ((1 << this.nBits[i4]) - 1)) + 0.5f);
                    i4++;
                    i++;
                }
                return sArr;
            }
            float f5 = fArr2[this.numColorComponents + i];
            while (true) {
                int i9 = this.numColorComponents;
                if (i4 >= i9) {
                    sArr[i9] = (short) ((f5 * ((1 << this.nBits[i9]) - 1)) + 0.5f);
                    return sArr;
                }
                sArr[i4] = (short) ((fArr2[i] * f5 * ((1 << this.nBits[i4]) - 1)) + 0.5f);
                i4++;
                i++;
            }
        } else if (i7 == 2) {
            short[] sArr2 = obj == null ? new short[this.numComponents] : (short[]) obj;
            if (!z) {
                while (i4 < this.numComponents) {
                    sArr2[i4] = (short) ((fArr2[i] * 32767.0f) + 0.5f);
                    i4++;
                    i++;
                }
                return sArr2;
            }
            float f6 = fArr2[this.numColorComponents + i];
            while (true) {
                int i10 = this.numColorComponents;
                if (i4 >= i10) {
                    sArr2[i10] = (short) ((f6 * 32767.0f) + 0.5f);
                    return sArr2;
                }
                sArr2[i4] = (short) AbstractC0622a.m1154D(fArr2[i], f6, 32767.0f, 0.5f);
                i4++;
                i++;
            }
        } else if (i7 == 3) {
            int[] iArr = obj == null ? new int[this.numComponents] : (int[]) obj;
            if (!z) {
                while (i4 < this.numComponents) {
                    iArr[i4] = (int) ((fArr2[i] * ((1 << this.nBits[i4]) - 1)) + 0.5f);
                    i4++;
                    i++;
                }
                return iArr;
            }
            float f7 = fArr2[this.numColorComponents + i];
            while (true) {
                int i11 = this.numColorComponents;
                if (i4 >= i11) {
                    iArr[i11] = (int) ((f7 * ((1 << this.nBits[i11]) - 1)) + 0.5f);
                    return iArr;
                }
                iArr[i4] = (int) ((fArr2[i] * f7 * ((1 << this.nBits[i4]) - 1)) + 0.5f);
                i4++;
                i++;
            }
        } else if (i7 == 4) {
            float[] fArr3 = obj == null ? new float[this.numComponents] : (float[]) obj;
            if (!z) {
                while (i4 < this.numComponents) {
                    fArr3[i4] = fArr[i];
                    i4++;
                    i++;
                }
                return fArr3;
            }
            float f8 = fArr[this.numColorComponents + i];
            while (true) {
                int i12 = this.numColorComponents;
                if (i4 >= i12) {
                    fArr3[i12] = f8;
                    return fArr3;
                }
                fArr3[i4] = fArr[i] * f8;
                i4++;
                i++;
            }
        } else {
            if (i7 != 5) {
                throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
            }
            double[] dArr = obj == null ? new double[this.numComponents] : (double[]) obj;
            if (!z) {
                while (i4 < this.numComponents) {
                    dArr[i4] = fArr[i];
                    i4++;
                    i++;
                }
                return dArr;
            }
            double d = fArr[this.numColorComponents + i];
            while (true) {
                int i13 = this.numColorComponents;
                if (i4 >= i13) {
                    dArr[i13] = d;
                    return dArr;
                }
                dArr[i4] = ((double) fArr[i]) * d;
                i4++;
                i++;
            }
        }
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getGreen(Object obj) {
        return getRGBComponent(obj, 1);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public float[] getNormalizedComponents(int[] iArr, int i, float[] fArr, int i2) {
        if (this.needScaleInit) {
            initScale();
        }
        if (this.noUnnorm) {
            throw new IllegalArgumentException("This ColorModel does not support the unnormalized form");
        }
        return super.getNormalizedComponents(iArr, i, fArr, i2);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getRGB(Object obj) {
        if (this.needScaleInit) {
            initScale();
        }
        if (this.is_sRGB_stdScale || this.is_LinearRGB_stdScale) {
            return getBlue(obj) | (getAlpha(obj) << 24) | (getRed(obj) << 16) | (getGreen(obj) << 8);
        }
        if (this.colorSpaceType == 6) {
            int red = getRed(obj);
            return (getAlpha(obj) << 24) | (red << 16) | (red << 8) | red;
        }
        float[] rgb = this.colorSpace.toRGB(getNormalizedComponents(obj, null, 0));
        return (getAlpha(obj) << 24) | (((int) ((rgb[0] * 255.0f) + 0.5f)) << 16) | (((int) ((rgb[1] * 255.0f) + 0.5f)) << 8) | ((int) ((rgb[2] * 255.0f) + 0.5f));
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getRed(Object obj) {
        return getRGBComponent(obj, 0);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public Object getDataElements(int[] iArr, int i, Object obj) {
        if (this.needScaleInit) {
            initScale();
        }
        if (this.noUnnorm) {
            throw new IllegalArgumentException("This ColorModel does not support the unnormalized form");
        }
        int length = iArr.length - i;
        int i2 = this.numComponents;
        if (length < i2) {
            throw new IllegalArgumentException("Component array too small (should be " + this.numComponents);
        }
        int i4 = this.transferType;
        int i5 = 0;
        if (i4 == 0) {
            byte[] bArr = obj == null ? new byte[i2] : (byte[]) obj;
            while (i5 < this.numComponents) {
                bArr[i5] = (byte) (iArr[i + i5] & 255);
                i5++;
            }
            return bArr;
        }
        if (i4 == 1) {
            short[] sArr = obj == null ? new short[i2] : (short[]) obj;
            while (i5 < this.numComponents) {
                sArr[i5] = (short) (iArr[i + i5] & 65535);
                i5++;
            }
            return sArr;
        }
        if (i4 == 3) {
            int[] iArr2 = obj == null ? new int[i2] : (int[]) obj;
            System.arraycopy(iArr, i, iArr2, 0, i2);
            return iArr2;
        }
        throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
    }
}
