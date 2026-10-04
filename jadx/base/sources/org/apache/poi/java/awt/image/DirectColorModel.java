package org.apache.poi.java.awt.image;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import java.util.Arrays;
import kotlin.UShort;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.color.ColorSpace;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DirectColorModel extends PackedColorModel {
    private int alpha_mask;
    private int alpha_offset;
    private int alpha_scale;
    private int blue_mask;
    private int blue_offset;
    private int blue_scale;
    private short[] fromsRGB8LUT16;
    private byte[] fromsRGB8LUT8;
    private int green_mask;
    private int green_offset;
    private int green_scale;
    private boolean is_LinearRGB;
    private int lRGBprecision;
    private int red_mask;
    private int red_offset;
    private int red_scale;
    private byte[] tosRGB8LUT;

    public DirectColorModel(int i, int i2, int i4, int i5) {
        this(i, i2, i4, i5, 0);
    }

    private float[] getDefaultRGBComponents(int i) {
        return this.colorSpace.toRGB(getNormalizedComponents(getComponents(i, (int[]) null, 0), 0, null, 0));
    }

    private int getsRGBComponentFromLinearRGB(int i, int i2) {
        int i4;
        int[] iArr = this.maskArray;
        int i5 = iArr[i2] & i;
        int[] iArr2 = this.maskOffsets;
        int iM1154D = i5 >>> iArr2[i2];
        if (this.isAlphaPremultiplied) {
            float f = (1 << this.lRGBprecision) - 1;
            int i6 = (i & iArr[3]) >>> iArr2[3];
            if (i6 == 0) {
                i4 = 0;
            } else {
                float f4 = iM1154D;
                float[] fArr = this.scaleFactors;
                i4 = (int) ((((f4 * fArr[i2]) * f) / (i6 * fArr[3])) + 0.5f);
            }
            iM1154D = i4;
        } else {
            int i7 = this.nBits[i2];
            int i8 = this.lRGBprecision;
            if (i7 != i8) {
                iM1154D = (int) (i8 == 16 ? AbstractC0622a.m1154D(iM1154D, this.scaleFactors[i2], 257.0f, 0.5f) : (iM1154D * this.scaleFactors[i2]) + 0.5f);
            }
        }
        return this.tosRGB8LUT[iM1154D] & 255;
    }

    private int getsRGBComponentFromsRGB(int i, int i2) {
        int[] iArr = this.maskArray;
        int i4 = iArr[i2] & i;
        int[] iArr2 = this.maskOffsets;
        int i5 = i4 >>> iArr2[i2];
        if (!this.isAlphaPremultiplied) {
            float f = this.scaleFactors[i2];
            return f != 1.0f ? (int) ((i5 * f) + 0.5f) : i5;
        }
        int i6 = (i & iArr[3]) >>> iArr2[3];
        if (i6 == 0) {
            return 0;
        }
        float f4 = i5;
        float[] fArr = this.scaleFactors;
        return (int) ((((f4 * fArr[i2]) * 255.0f) / (i6 * fArr[3])) + 0.5f);
    }

    private void setFields() {
        int[] iArr = this.maskArray;
        this.red_mask = iArr[0];
        int[] iArr2 = this.maskOffsets;
        this.red_offset = iArr2[0];
        this.green_mask = iArr[1];
        this.green_offset = iArr2[1];
        this.blue_mask = iArr[2];
        this.blue_offset = iArr2[2];
        int[] iArr3 = this.nBits;
        int i = iArr3[0];
        if (i < 8) {
            this.red_scale = (1 << i) - 1;
        }
        int i2 = iArr3[1];
        if (i2 < 8) {
            this.green_scale = (1 << i2) - 1;
        }
        int i4 = iArr3[2];
        if (i4 < 8) {
            this.blue_scale = (1 << i4) - 1;
        }
        if (this.supportsAlpha) {
            this.alpha_mask = iArr[3];
            this.alpha_offset = iArr2[3];
            int i5 = iArr3[3];
            if (i5 < 8) {
                this.alpha_scale = (1 << i5) - 1;
            }
        }
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public final ColorModel coerceData(WritableRaster writableRaster, boolean z) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        if (!this.supportsAlpha || isAlphaPremultiplied() == z) {
            return this;
        }
        int width = writableRaster.getWidth();
        int height = writableRaster.getHeight();
        int i = this.numColorComponents;
        float f = 1.0f / ((1 << this.nBits[i]) - 1);
        int minX = writableRaster.getMinX();
        int minY = writableRaster.getMinY();
        if (z) {
            int i2 = this.transferType;
            if (i2 == 0) {
                int i4 = 0;
                int[] pixel = null;
                int[] iArr4 = null;
                while (i4 < height) {
                    int i5 = minX;
                    int i6 = 0;
                    while (i6 < width) {
                        pixel = writableRaster.getPixel(i5, minY, pixel);
                        float f4 = pixel[i] * f;
                        if (f4 != 0.0f) {
                            for (int i7 = 0; i7 < i; i7++) {
                                pixel[i7] = (int) ((pixel[i7] * f4) + 0.5f);
                            }
                            writableRaster.setPixel(i5, minY, pixel);
                        } else {
                            if (iArr4 == null) {
                                iArr = new int[this.numComponents];
                                Arrays.fill(iArr, 0);
                            } else {
                                iArr = iArr4;
                            }
                            writableRaster.setPixel(i5, minY, iArr);
                            iArr4 = iArr;
                        }
                        i6++;
                        i5++;
                    }
                    i4++;
                    minY++;
                }
            } else if (i2 == 1) {
                int i8 = 0;
                int[] pixel2 = null;
                int[] iArr5 = null;
                while (i8 < height) {
                    int i9 = minX;
                    int i10 = 0;
                    while (i10 < width) {
                        pixel2 = writableRaster.getPixel(i9, minY, pixel2);
                        float f5 = pixel2[i] * f;
                        if (f5 != 0.0f) {
                            for (int i11 = 0; i11 < i; i11++) {
                                pixel2[i11] = (int) ((pixel2[i11] * f5) + 0.5f);
                            }
                            writableRaster.setPixel(i9, minY, pixel2);
                        } else {
                            if (iArr5 == null) {
                                iArr2 = new int[this.numComponents];
                                Arrays.fill(iArr2, 0);
                            } else {
                                iArr2 = iArr5;
                            }
                            writableRaster.setPixel(i9, minY, iArr2);
                            iArr5 = iArr2;
                        }
                        i10++;
                        i9++;
                    }
                    i8++;
                    minY++;
                }
            } else {
                if (i2 != 3) {
                    throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
                }
                int i12 = 0;
                int[] pixel3 = null;
                int[] iArr6 = null;
                while (i12 < height) {
                    int i13 = minX;
                    int i14 = 0;
                    while (i14 < width) {
                        pixel3 = writableRaster.getPixel(i13, minY, pixel3);
                        float f6 = pixel3[i] * f;
                        if (f6 != 0.0f) {
                            for (int i15 = 0; i15 < i; i15++) {
                                pixel3[i15] = (int) ((pixel3[i15] * f6) + 0.5f);
                            }
                            writableRaster.setPixel(i13, minY, pixel3);
                        } else {
                            if (iArr6 == null) {
                                iArr3 = new int[this.numComponents];
                                Arrays.fill(iArr3, 0);
                            } else {
                                iArr3 = iArr6;
                            }
                            writableRaster.setPixel(i13, minY, iArr3);
                            iArr6 = iArr3;
                        }
                        i14++;
                        i13++;
                    }
                    i12++;
                    minY++;
                }
            }
        } else {
            int i16 = this.transferType;
            if (i16 == 0) {
                int i17 = 0;
                int[] pixel4 = null;
                while (i17 < height) {
                    int i18 = minX;
                    int i19 = 0;
                    while (i19 < width) {
                        pixel4 = writableRaster.getPixel(i18, minY, pixel4);
                        float f7 = pixel4[i] * f;
                        if (f7 != 0.0f) {
                            float f8 = 1.0f / f7;
                            for (int i20 = 0; i20 < i; i20++) {
                                pixel4[i20] = (int) ((pixel4[i20] * f8) + 0.5f);
                            }
                            writableRaster.setPixel(i18, minY, pixel4);
                        }
                        i19++;
                        i18++;
                    }
                    i17++;
                    minY++;
                }
            } else if (i16 == 1) {
                int i21 = 0;
                int[] pixel5 = null;
                while (i21 < height) {
                    int i22 = minX;
                    int i23 = 0;
                    while (i23 < width) {
                        pixel5 = writableRaster.getPixel(i22, minY, pixel5);
                        float f9 = pixel5[i] * f;
                        if (f9 != 0.0f) {
                            float f10 = 1.0f / f9;
                            for (int i24 = 0; i24 < i; i24++) {
                                pixel5[i24] = (int) ((pixel5[i24] * f10) + 0.5f);
                            }
                            writableRaster.setPixel(i22, minY, pixel5);
                        }
                        i23++;
                        i22++;
                    }
                    i21++;
                    minY++;
                }
            } else {
                if (i16 != 3) {
                    throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
                }
                int i25 = 0;
                int[] pixel6 = null;
                while (i25 < height) {
                    int i26 = minX;
                    int i27 = 0;
                    while (i27 < width) {
                        pixel6 = writableRaster.getPixel(i26, minY, pixel6);
                        float f11 = pixel6[i] * f;
                        if (f11 != 0.0f) {
                            float f12 = 1.0f / f11;
                            for (int i28 = 0; i28 < i; i28++) {
                                pixel6[i28] = (int) ((pixel6[i28] * f12) + 0.5f);
                            }
                            writableRaster.setPixel(i26, minY, pixel6);
                        }
                        i27++;
                        i26++;
                    }
                    i25++;
                    minY++;
                }
            }
        }
        ColorSpace colorSpace = this.colorSpace;
        int i29 = this.pixel_bits;
        int[] iArr7 = this.maskArray;
        return new DirectColorModel(colorSpace, i29, iArr7[0], iArr7[1], iArr7[2], iArr7[3], z, this.transferType);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public final WritableRaster createCompatibleWritableRaster(int i, int i2) {
        int[] iArr;
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException(AbstractC0622a.m1164j(i, i2, "Width (", ") and height (", ") cannot be <= 0"));
        }
        if (this.supportsAlpha) {
            iArr = new int[4];
            iArr[3] = this.alpha_mask;
        } else {
            iArr = new int[3];
        }
        iArr[0] = this.red_mask;
        iArr[1] = this.green_mask;
        iArr[2] = this.blue_mask;
        int i4 = this.pixel_bits;
        return i4 > 16 ? Raster.createPackedRaster(3, i, i2, iArr, (Point) null) : i4 > 8 ? Raster.createPackedRaster(1, i, i2, iArr, (Point) null) : Raster.createPackedRaster(0, i, i2, iArr, (Point) null);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public final int getAlpha(int i) {
        if (!this.supportsAlpha) {
            return 255;
        }
        int i2 = (i & this.maskArray[3]) >>> this.maskOffsets[3];
        float f = this.scaleFactors[3];
        return f != 1.0f ? (int) ((i2 * f) + 0.5f) : i2;
    }

    public final int getAlphaMask() {
        if (this.supportsAlpha) {
            return this.maskArray[3];
        }
        return 0;
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public final int getBlue(int i) {
        return this.is_sRGB ? getsRGBComponentFromsRGB(i, 2) : this.is_LinearRGB ? getsRGBComponentFromLinearRGB(i, 2) : (int) ((getDefaultRGBComponents(i)[2] * 255.0f) + 0.5f);
    }

    public final int getBlueMask() {
        return this.maskArray[2];
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public final int[] getComponents(int i, int[] iArr, int i2) {
        if (iArr == null) {
            iArr = new int[this.numComponents + i2];
        }
        for (int i4 = 0; i4 < this.numComponents; i4++) {
            iArr[i2 + i4] = (this.maskArray[i4] & i) >>> this.maskOffsets[i4];
        }
        return iArr;
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getDataElement(int[] iArr, int i) {
        int i2 = 0;
        for (int i4 = 0; i4 < this.numComponents; i4++) {
            i2 |= (iArr[i + i4] << this.maskOffsets[i4]) & this.maskArray[i4];
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0140  */
    @Override // org.apache.poi.java.awt.image.ColorModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getDataElements(int i, Object obj) {
        int[] iArr;
        char c;
        float f;
        int i2;
        int i4;
        int i5;
        int i6;
        if (this.transferType != 3 || obj == null) {
            iArr = new int[1];
        } else {
            iArr = (int[]) obj;
            iArr[0] = 0;
        }
        ColorModel rGBdefault = ColorModel.getRGBdefault();
        if (this == rGBdefault || equals(rGBdefault)) {
            iArr[0] = i;
            return iArr;
        }
        int i7 = (i >> 16) & 255;
        int i8 = (i >> 8) & 255;
        int i9 = i & 255;
        if (!this.is_sRGB && !this.is_LinearRGB) {
            float[] fArrFromRGB = this.colorSpace.fromRGB(new float[]{i7 * 0.003921569f, i8 * 0.003921569f, i9 * 0.003921569f});
            if (this.supportsAlpha) {
                int i10 = (i >> 24) & 255;
                if (this.isAlphaPremultiplied) {
                    float f4 = i10 * 0.003921569f;
                    for (int i11 = 0; i11 < 3; i11++) {
                        fArrFromRGB[i11] = fArrFromRGB[i11] * f4;
                    }
                }
                int i12 = this.nBits[3];
                if (i12 != 8 && (i10 = (int) ((i10 * 0.003921569f * ((1 << i12) - 1)) + 0.5f)) > (1 << i12) - 1) {
                    i10 = (1 << i12) - 1;
                }
                iArr[0] = i10 << this.maskOffsets[3];
            }
            float f5 = fArrFromRGB[0];
            int[] iArr2 = this.nBits;
            i6 = (int) ((f5 * ((1 << iArr2[0]) - 1)) + 0.5f);
            i4 = (int) ((fArrFromRGB[1] * ((1 << iArr2[1]) - 1)) + 0.5f);
            i5 = (int) ((fArrFromRGB[2] * ((1 << iArr2[2]) - 1)) + 0.5f);
            c = 0;
        } else if (!this.is_LinearRGB) {
            c = 0;
            f = 0.003921569f;
            i2 = 8;
            if (this.supportsAlpha) {
                int i13 = (i >> 24) & 255;
                if (this.isAlphaPremultiplied) {
                    f *= i13 * 0.003921569f;
                    i2 = -1;
                }
                int i14 = this.nBits[3];
                if (i14 != 8 && (i13 = (int) ((i13 * 0.003921569f * ((1 << i14) - 1)) + 0.5f)) > (1 << i14) - 1) {
                    i13 = (1 << i14) - 1;
                }
                iArr[c] = i13 << this.maskOffsets[3];
            }
            int[] iArr3 = this.nBits;
            int i15 = iArr3[c] != i2 ? (int) ((i7 * f * ((1 << r3) - 1)) + 0.5f) : i7;
            int i16 = iArr3[1] != i2 ? (int) ((i8 * f * ((1 << r6) - 1)) + 0.5f) : i8;
            int i17 = iArr3[2] != i2 ? (int) ((i9 * f * ((1 << r1) - 1)) + 0.5f) : i9;
            i4 = i16;
            i5 = i17;
            i6 = i15;
        } else if (this.lRGBprecision == 8) {
            byte[] bArr = this.fromsRGB8LUT8;
            i7 = bArr[i7] & 255;
            i8 = bArr[i8] & 255;
            i9 = bArr[i9] & 255;
            c = 0;
            f = 0.003921569f;
            i2 = 8;
            if (this.supportsAlpha) {
            }
            int[] iArr32 = this.nBits;
            if (iArr32[c] != i2) {
            }
            if (iArr32[1] != i2) {
            }
            if (iArr32[2] != i2) {
            }
            i4 = i16;
            i5 = i17;
            i6 = i15;
        } else {
            short[] sArr = this.fromsRGB8LUT16;
            i7 = sArr[i7] & UShort.MAX_VALUE;
            i8 = sArr[i8] & UShort.MAX_VALUE;
            i9 = sArr[i9] & UShort.MAX_VALUE;
            i2 = 16;
            f = 1.5259022E-5f;
            c = 0;
            if (this.supportsAlpha) {
            }
            int[] iArr322 = this.nBits;
            if (iArr322[c] != i2) {
            }
            if (iArr322[1] != i2) {
            }
            if (iArr322[2] != i2) {
            }
            i4 = i16;
            i5 = i17;
            i6 = i15;
        }
        if (this.maxBits > 23) {
            int[] iArr4 = this.nBits;
            int i18 = iArr4[c];
            if (i6 > (1 << i18) - 1) {
                i6 = (1 << i18) - 1;
            }
            int i19 = iArr4[1];
            if (i4 > (1 << i19) - 1) {
                i4 = (1 << i19) - 1;
            }
            int i20 = iArr4[2];
            if (i5 > (1 << i20) - 1) {
                i5 = (1 << i20) - 1;
            }
        }
        int i21 = iArr[c];
        int[] iArr5 = this.maskOffsets;
        int i22 = (i6 << iArr5[c]) | (i4 << iArr5[1]) | (i5 << iArr5[2]) | i21;
        iArr[c] = i22;
        int i23 = this.transferType;
        if (i23 == 0) {
            byte[] bArr2 = obj == null ? new byte[1] : (byte[]) obj;
            bArr2[c] = (byte) (i22 & 255);
            return bArr2;
        }
        if (i23 == 1) {
            short[] sArr2 = obj == null ? new short[1] : (short[]) obj;
            sArr2[c] = (short) (i22 & 65535);
            return sArr2;
        }
        if (i23 == 3) {
            return iArr;
        }
        throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public final int getGreen(int i) {
        return this.is_sRGB ? getsRGBComponentFromsRGB(i, 1) : this.is_LinearRGB ? getsRGBComponentFromLinearRGB(i, 1) : (int) ((getDefaultRGBComponents(i)[1] * 255.0f) + 0.5f);
    }

    public final int getGreenMask() {
        return this.maskArray[1];
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public final int getRGB(int i) {
        if (this.is_sRGB || this.is_LinearRGB) {
            return getBlue(i) | (getAlpha(i) << 24) | (getRed(i) << 16) | (getGreen(i) << 8);
        }
        float[] defaultRGBComponents = getDefaultRGBComponents(i);
        return (getAlpha(i) << 24) | (((int) ((defaultRGBComponents[0] * 255.0f) + 0.5f)) << 16) | (((int) ((defaultRGBComponents[1] * 255.0f) + 0.5f)) << 8) | ((int) ((defaultRGBComponents[2] * 255.0f) + 0.5f));
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public final int getRed(int i) {
        return this.is_sRGB ? getsRGBComponentFromsRGB(i, 0) : this.is_LinearRGB ? getsRGBComponentFromLinearRGB(i, 0) : (int) ((getDefaultRGBComponents(i)[0] * 255.0f) + 0.5f);
    }

    public final int getRedMask() {
        return this.maskArray[0];
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public boolean isCompatibleRaster(Raster raster) {
        SampleModel sampleModel = raster.getSampleModel();
        if (sampleModel instanceof SinglePixelPackedSampleModel) {
            SinglePixelPackedSampleModel singlePixelPackedSampleModel = (SinglePixelPackedSampleModel) sampleModel;
            if (singlePixelPackedSampleModel.getNumBands() != getNumComponents()) {
                return false;
            }
            int[] bitMasks = singlePixelPackedSampleModel.getBitMasks();
            for (int i = 0; i < this.numComponents; i++) {
                if (bitMasks[i] != this.maskArray[i]) {
                    return false;
                }
            }
            if (raster.getTransferType() == this.transferType) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public String toString() {
        StringBuilder sb = new StringBuilder("DirectColorModel: rmask=");
        sb.append(Integer.toHexString(this.red_mask));
        sb.append(" gmask=");
        sb.append(Integer.toHexString(this.green_mask));
        sb.append(" bmask=");
        sb.append(Integer.toHexString(this.blue_mask));
        sb.append(" amask=");
        return new String(AbstractC1974b.m1316i(this.alpha_mask, sb));
    }

    public DirectColorModel(int i, int i2, int i4, int i5, int i6) {
        super(ColorSpace.getInstance(1000), i, i2, i4, i5, i6, false, i6 == 0 ? 1 : 3, ColorModel.getDefaultTransferType(i));
        setFields();
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getAlpha(Object obj) {
        int i;
        int i2 = this.transferType;
        if (i2 == 0) {
            i = ((byte[]) obj)[0] & 255;
        } else if (i2 == 1) {
            i = ((short[]) obj)[0] & UShort.MAX_VALUE;
        } else if (i2 == 3) {
            i = ((int[]) obj)[0];
        } else {
            throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
        }
        return getAlpha(i);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public final int[] getComponents(Object obj, int[] iArr, int i) {
        int i2;
        int i4 = this.transferType;
        if (i4 == 0) {
            i2 = ((byte[]) obj)[0] & 255;
        } else if (i4 == 1) {
            i2 = ((short[]) obj)[0] & UShort.MAX_VALUE;
        } else if (i4 == 3) {
            i2 = ((int[]) obj)[0];
        } else {
            throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
        }
        return getComponents(i2, iArr, i);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public DirectColorModel(org.apache.poi.java.awt.color.ColorSpace r12, int r13, int r14, int r15, int r16, int r17, boolean r18, int r19) {
        /*
            r11 = this;
            r10 = 1
            if (r17 != 0) goto L12
            r8 = r10
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r9 = r19
            goto L21
        L12:
            r0 = 3
            r8 = r0
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r9 = r19
            r0 = r11
        L21:
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r11.is_LinearRGB = r10
            int r1 = r11.maxBits
            r2 = 8
            if (r1 > r2) goto L3b
            r11.lRGBprecision = r2
            byte[] r1 = org.apache.poi.java.awt.image.ColorModel.getLinearRGB8TosRGB8LUT()
            r11.tosRGB8LUT = r1
            byte[] r1 = org.apache.poi.java.awt.image.ColorModel.getsRGB8ToLinearRGB8LUT()
            r11.fromsRGB8LUT8 = r1
            goto L4b
        L3b:
            r1 = 16
            r11.lRGBprecision = r1
            byte[] r1 = org.apache.poi.java.awt.image.ColorModel.getLinearRGB16TosRGB8LUT()
            r11.tosRGB8LUT = r1
            short[] r1 = org.apache.poi.java.awt.image.ColorModel.getsRGB8ToLinearRGB16LUT()
            r11.fromsRGB8LUT16 = r1
        L4b:
            r11.setFields()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.java.awt.image.DirectColorModel.<init>(org.apache.poi.java.awt.color.ColorSpace, int, int, int, int, int, boolean, int):void");
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getBlue(Object obj) {
        int i;
        int i2 = this.transferType;
        if (i2 == 0) {
            i = ((byte[]) obj)[0] & 255;
        } else if (i2 == 1) {
            i = ((short[]) obj)[0] & UShort.MAX_VALUE;
        } else if (i2 == 3) {
            i = ((int[]) obj)[0];
        } else {
            throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
        }
        return getBlue(i);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getGreen(Object obj) {
        int i;
        int i2 = this.transferType;
        if (i2 == 0) {
            i = ((byte[]) obj)[0] & 255;
        } else if (i2 == 1) {
            i = ((short[]) obj)[0] & UShort.MAX_VALUE;
        } else if (i2 == 3) {
            i = ((int[]) obj)[0];
        } else {
            throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
        }
        return getGreen(i);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getRed(Object obj) {
        int i;
        int i2 = this.transferType;
        if (i2 == 0) {
            i = ((byte[]) obj)[0] & 255;
        } else if (i2 == 1) {
            i = ((short[]) obj)[0] & UShort.MAX_VALUE;
        } else if (i2 == 3) {
            i = ((int[]) obj)[0];
        } else {
            throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
        }
        return getRed(i);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getRGB(Object obj) {
        int i;
        int i2 = this.transferType;
        if (i2 == 0) {
            i = ((byte[]) obj)[0] & 255;
        } else if (i2 == 1) {
            i = ((short[]) obj)[0] & UShort.MAX_VALUE;
        } else if (i2 == 3) {
            i = ((int[]) obj)[0];
        } else {
            throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
        }
        return getRGB(i);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public Object getDataElements(int[] iArr, int i, Object obj) {
        int i2 = 0;
        for (int i4 = 0; i4 < this.numComponents; i4++) {
            i2 |= (iArr[i + i4] << this.maskOffsets[i4]) & this.maskArray[i4];
        }
        int i5 = this.transferType;
        if (i5 == 0) {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                bArr[0] = (byte) (i2 & 255);
                return bArr;
            }
            return new byte[]{(byte) (i2 & 255)};
        }
        if (i5 == 1) {
            if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                sArr[0] = (short) (i2 & 65535);
                return sArr;
            }
            return new short[]{(short) (i2 & 65535)};
        }
        if (i5 == 3) {
            if (obj instanceof int[]) {
                int[] iArr2 = (int[]) obj;
                iArr2[0] = i2;
                return iArr2;
            }
            return new int[]{i2};
        }
        throw new ClassCastException("This method has not been implemented for transferType " + this.transferType);
    }
}
