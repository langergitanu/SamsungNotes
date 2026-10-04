package org.apache.poi.java.awt;

import androidx.compose.runtime.AbstractC1974b;
import androidx.core.view.MotionEventCompat;
import java.lang.ref.WeakReference;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.NoninvertibleTransformException;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.DirectColorModel;
import org.apache.poi.java.awt.image.IndexColorModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.WritableRaster;
import org.apache.poi.sun.awt.image.ByteInterleavedRaster;
import org.apache.poi.sun.awt.image.IntegerInterleavedRaster;
import org.apache.poi.sun.awt.image.SunWritableRaster;

/* JADX INFO: loaded from: classes10.dex */
abstract class TexturePaintContext implements PaintContext {
    private static WeakReference argbRasRef;
    private static WeakReference byteRasRef;
    private static WeakReference xrgbRasRef;
    int bHeight;
    int bWidth;
    int colincx;
    int colincxerr;
    int colincy;
    int colincyerr;
    ColorModel colorModel;
    double incXAcross;
    double incXDown;
    double incYAcross;
    double incYDown;
    int maxWidth;
    WritableRaster outRas;
    int rowincx;
    int rowincxerr;
    int rowincy;
    int rowincyerr;
    double xOrg;
    double yOrg;
    public static ColorModel xrgbmodel = new DirectColorModel(24, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255);
    public static ColorModel argbmodel = ColorModel.getRGBdefault();

    public static class Any extends TexturePaintContext {
        boolean filter;
        WritableRaster srcRas;

        public Any(WritableRaster writableRaster, ColorModel colorModel, AffineTransform affineTransform, int i, boolean z) {
            super(colorModel, affineTransform, writableRaster.getWidth(), writableRaster.getHeight(), i);
            this.srcRas = writableRaster;
            this.filter = z;
        }

        @Override // org.apache.poi.java.awt.TexturePaintContext
        public WritableRaster makeRaster(int i, int i2) {
            return TexturePaintContext.makeRaster(this.colorModel, this.srcRas, i, i2);
        }

        @Override // org.apache.poi.java.awt.TexturePaintContext
        public void setRaster(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            int i18;
            int i19;
            int i20;
            int i21;
            WritableRaster writableRaster = this.srcRas;
            WritableRaster writableRaster2 = this.outRas;
            int[] iArr = this.filter ? new int[4] : null;
            int i22 = i2;
            int i23 = i4;
            int i24 = i5;
            Object dataElements = null;
            int i25 = i;
            for (int i26 = 0; i26 < i7; i26++) {
                int i27 = i25;
                int i28 = i27;
                int i29 = i22;
                int i30 = i29;
                int i31 = i23;
                int i32 = i24;
                int i33 = 0;
                while (true) {
                    i18 = i23;
                    if (i33 >= i6) {
                        break;
                    }
                    dataElements = writableRaster.getDataElements(i28, i30, dataElements);
                    if (this.filter) {
                        int i34 = i28 + 1;
                        if (i34 >= i8) {
                            i34 = 0;
                        }
                        i21 = i24;
                        int i35 = i30 + 1;
                        if (i35 >= i9) {
                            i35 = 0;
                        }
                        iArr[0] = this.colorModel.getRGB(dataElements);
                        Object dataElements2 = writableRaster.getDataElements(i34, i30, dataElements);
                        iArr[1] = this.colorModel.getRGB(dataElements2);
                        Object dataElements3 = writableRaster.getDataElements(i28, i35, dataElements2);
                        iArr[2] = this.colorModel.getRGB(dataElements3);
                        Object dataElements4 = writableRaster.getDataElements(i34, i35, dataElements3);
                        iArr[3] = this.colorModel.getRGB(dataElements4);
                        dataElements = this.colorModel.getDataElements(TexturePaintContext.blend(iArr, i31, i32), dataElements4);
                    } else {
                        i21 = i24;
                    }
                    writableRaster2.setDataElements(i33, i26, dataElements);
                    i31 += i11;
                    if (i31 < 0) {
                        i31 &= Integer.MAX_VALUE;
                        i28++;
                    }
                    i28 += i10;
                    if (i28 >= i8) {
                        i28 -= i8;
                    }
                    i32 += i13;
                    if (i32 < 0) {
                        i32 &= Integer.MAX_VALUE;
                        i30++;
                    }
                    i30 += i12;
                    if (i30 >= i9) {
                        i30 -= i9;
                    }
                    i33++;
                    i23 = i18;
                    i24 = i21;
                }
                int i36 = i24;
                i23 = i18 + i15;
                if (i23 < 0) {
                    i23 &= Integer.MAX_VALUE;
                    i19 = i27 + 1;
                } else {
                    i19 = i27;
                }
                i25 = i19 + i14;
                if (i25 >= i8) {
                    i25 -= i8;
                }
                i24 = i36 + i17;
                if (i24 < 0) {
                    i20 = i29 + 1;
                    i24 &= Integer.MAX_VALUE;
                } else {
                    i20 = i29;
                }
                i22 = i20 + i16;
                if (i22 >= i9) {
                    i22 -= i9;
                }
            }
        }
    }

    public static class Byte extends TexturePaintContext {
        byte[] inData;
        int inOff;
        int inSpan;
        byte[] outData;
        int outOff;
        int outSpan;
        ByteInterleavedRaster srcRas;

        public Byte(ByteInterleavedRaster byteInterleavedRaster, ColorModel colorModel, AffineTransform affineTransform, int i) {
            super(colorModel, affineTransform, byteInterleavedRaster.getWidth(), byteInterleavedRaster.getHeight(), i);
            this.srcRas = byteInterleavedRaster;
            this.inData = byteInterleavedRaster.getDataStorage();
            this.inSpan = byteInterleavedRaster.getScanlineStride();
            this.inOff = byteInterleavedRaster.getDataOffset(0);
        }

        @Override // org.apache.poi.java.awt.TexturePaintContext, org.apache.poi.java.awt.PaintContext
        public void dispose() {
            TexturePaintContext.dropByteRaster(this.outRas);
        }

        @Override // org.apache.poi.java.awt.TexturePaintContext
        public WritableRaster makeRaster(int i, int i2) {
            WritableRaster writableRasterMakeByteRaster = TexturePaintContext.makeByteRaster(this.srcRas, i, i2);
            ByteInterleavedRaster byteInterleavedRaster = (ByteInterleavedRaster) writableRasterMakeByteRaster;
            this.outData = byteInterleavedRaster.getDataStorage();
            this.outSpan = byteInterleavedRaster.getScanlineStride();
            this.outOff = byteInterleavedRaster.getDataOffset(0);
            return writableRasterMakeByteRaster;
        }

        @Override // org.apache.poi.java.awt.TexturePaintContext
        public void setRaster(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            int i18;
            int i19;
            int i20;
            byte[] bArr = this.inData;
            byte[] bArr2 = this.outData;
            int i21 = this.outOff;
            int i22 = this.inSpan;
            int i23 = this.inOff;
            int i24 = this.outSpan;
            boolean z = i10 == 1 && i11 == 0 && i12 == 0 && i13 == 0;
            if (z) {
                i24 -= i6;
            }
            int i25 = i2;
            int i26 = i4;
            int i27 = i5;
            int i28 = i21;
            int i29 = 0;
            int i30 = i;
            while (i29 < i7) {
                if (z) {
                    int iM1310c = AbstractC1974b.m1310c(i25, i22, i23, i8);
                    int i31 = i8 - i30;
                    i28 += i6;
                    i18 = i29;
                    if (i8 >= 32) {
                        int i32 = i6;
                        int i33 = i31;
                        while (i32 > 0) {
                            int i34 = i33;
                            int i35 = i32;
                            if (i32 < i33) {
                                i33 = i35;
                            }
                            int i36 = i30;
                            System.arraycopy(bArr, iM1310c - i34, bArr2, i28 - i35, i33);
                            i32 = i35 - i33;
                            i33 = i34 - i33;
                            if (i33 == 0) {
                                i33 = i8;
                            }
                            i30 = i36;
                        }
                        i19 = i30;
                    } else {
                        i19 = i30;
                        for (int i37 = i6; i37 > 0; i37--) {
                            bArr2[i28 - i37] = bArr[iM1310c - i31];
                            i31--;
                            if (i31 == 0) {
                                i31 = i8;
                            }
                        }
                    }
                } else {
                    i18 = i29;
                    i19 = i30;
                    int i38 = i25;
                    int i39 = i26;
                    int i40 = i27;
                    for (int i41 = 0; i41 < i6; i41++) {
                        bArr2[i28 + i41] = bArr[AbstractC1974b.m1310c(i38, i22, i23, i30)];
                        i39 += i11;
                        if (i39 < 0) {
                            i39 &= Integer.MAX_VALUE;
                            i30++;
                        }
                        i30 += i10;
                        if (i30 >= i8) {
                            i30 -= i8;
                        }
                        i40 += i13;
                        if (i40 < 0) {
                            i40 &= Integer.MAX_VALUE;
                            i38++;
                        }
                        i38 += i12;
                        if (i38 >= i9) {
                            i38 -= i9;
                        }
                    }
                }
                i26 += i15;
                if (i26 < 0) {
                    i20 = i19 + 1;
                    i26 &= Integer.MAX_VALUE;
                } else {
                    i20 = i19;
                }
                i30 = i20 + i14;
                if (i30 >= i8) {
                    i30 -= i8;
                }
                i27 += i17;
                if (i27 < 0) {
                    i25++;
                    i27 &= Integer.MAX_VALUE;
                }
                i25 += i16;
                if (i25 >= i9) {
                    i25 -= i9;
                }
                i28 += i24;
                i29 = i18 + 1;
            }
        }
    }

    public static class ByteFilter extends TexturePaintContext {
        byte[] inData;
        int inOff;
        int[] inPalette;
        int inSpan;
        int[] outData;
        int outOff;
        int outSpan;
        ByteInterleavedRaster srcRas;

        public ByteFilter(ByteInterleavedRaster byteInterleavedRaster, ColorModel colorModel, AffineTransform affineTransform, int i) {
            super(colorModel.getTransparency() == 1 ? TexturePaintContext.xrgbmodel : TexturePaintContext.argbmodel, affineTransform, byteInterleavedRaster.getWidth(), byteInterleavedRaster.getHeight(), i);
            int[] iArr = new int[256];
            this.inPalette = iArr;
            ((IndexColorModel) colorModel).getRGBs(iArr);
            this.srcRas = byteInterleavedRaster;
            this.inData = byteInterleavedRaster.getDataStorage();
            this.inSpan = byteInterleavedRaster.getScanlineStride();
            this.inOff = byteInterleavedRaster.getDataOffset(0);
        }

        @Override // org.apache.poi.java.awt.TexturePaintContext
        public WritableRaster makeRaster(int i, int i2) {
            WritableRaster writableRasterMakeRaster = TexturePaintContext.makeRaster(this.colorModel, null, i, i2);
            IntegerInterleavedRaster integerInterleavedRaster = (IntegerInterleavedRaster) writableRasterMakeRaster;
            this.outData = integerInterleavedRaster.getDataStorage();
            this.outSpan = integerInterleavedRaster.getScanlineStride();
            this.outOff = integerInterleavedRaster.getDataOffset(0);
            return writableRasterMakeRaster;
        }

        @Override // org.apache.poi.java.awt.TexturePaintContext
        public void setRaster(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            int i18;
            int i19;
            ByteFilter byteFilter = this;
            byte[] bArr = byteFilter.inData;
            int[] iArr = byteFilter.outData;
            int i20 = byteFilter.outOff;
            int i21 = byteFilter.inSpan;
            int i22 = byteFilter.inOff;
            int i23 = byteFilter.outSpan;
            int i24 = i2;
            int i25 = i4;
            int i26 = i5;
            int i27 = i20;
            int i28 = 0;
            int i29 = i;
            while (i28 < i7) {
                byte[] bArr2 = bArr;
                int[] iArr2 = iArr;
                int i30 = i29;
                int i31 = i24;
                int i32 = i25;
                int i33 = i26;
                int i34 = 0;
                while (true) {
                    i18 = i29;
                    if (i34 >= i6) {
                        break;
                    }
                    int i35 = i30 + 1;
                    int i36 = i35 >= i8 ? 0 : i35;
                    int i37 = i31 + 1;
                    int i38 = i37 >= i9 ? 0 : i37;
                    int[] iArr3 = byteFilter.inPalette;
                    int i39 = i22 + i30;
                    int i40 = i21 * i31;
                    int i41 = iArr3[bArr2[i39 + i40] & 255];
                    int i42 = i22 + i36;
                    int i43 = iArr3[bArr2[i42 + i40] & 255];
                    int i44 = i38 * i21;
                    int i45 = i21;
                    int i46 = iArr3[bArr2[i39 + i44] & 255];
                    int i47 = i42 + i44;
                    int i48 = i22;
                    iArr2[i27 + i34] = TexturePaintContext.blend(new int[]{i41, i43, i46, iArr3[bArr2[i47] & 255]}, i32, i33);
                    i32 += i11;
                    if (i32 < 0) {
                        i30 = i35;
                        i32 &= Integer.MAX_VALUE;
                    }
                    int i49 = i30 + i10;
                    if (i49 >= i8) {
                        i49 -= i8;
                    }
                    i30 = i49;
                    i33 += i13;
                    if (i33 < 0) {
                        i31 = i37;
                        i33 &= Integer.MAX_VALUE;
                    }
                    int i50 = i31 + i12;
                    if (i50 >= i9) {
                        i50 -= i9;
                    }
                    i31 = i50;
                    i34++;
                    byteFilter = this;
                    i29 = i18;
                    i22 = i48;
                    i21 = i45;
                }
                int i51 = i21;
                int i52 = i22;
                i25 += i15;
                if (i25 < 0) {
                    i19 = i18 + 1;
                    i25 &= Integer.MAX_VALUE;
                } else {
                    i19 = i18;
                }
                i29 = i19 + i14;
                if (i29 >= i8) {
                    i29 -= i8;
                }
                i26 += i17;
                if (i26 < 0) {
                    i24++;
                    i26 &= Integer.MAX_VALUE;
                }
                i24 += i16;
                if (i24 >= i9) {
                    i24 -= i9;
                }
                i27 += i23;
                i28++;
                byteFilter = this;
                bArr = bArr2;
                iArr = iArr2;
                i22 = i52;
                i21 = i51;
            }
        }
    }

    public static class Int extends TexturePaintContext {
        boolean filter;
        int[] inData;
        int inOff;
        int inSpan;
        int[] outData;
        int outOff;
        int outSpan;
        IntegerInterleavedRaster srcRas;

        public Int(IntegerInterleavedRaster integerInterleavedRaster, ColorModel colorModel, AffineTransform affineTransform, int i, boolean z) {
            super(colorModel, affineTransform, integerInterleavedRaster.getWidth(), integerInterleavedRaster.getHeight(), i);
            this.srcRas = integerInterleavedRaster;
            this.inData = integerInterleavedRaster.getDataStorage();
            this.inSpan = integerInterleavedRaster.getScanlineStride();
            this.inOff = integerInterleavedRaster.getDataOffset(0);
            this.filter = z;
        }

        @Override // org.apache.poi.java.awt.TexturePaintContext
        public WritableRaster makeRaster(int i, int i2) {
            WritableRaster writableRasterMakeRaster = TexturePaintContext.makeRaster(this.colorModel, this.srcRas, i, i2);
            IntegerInterleavedRaster integerInterleavedRaster = (IntegerInterleavedRaster) writableRasterMakeRaster;
            this.outData = integerInterleavedRaster.getDataStorage();
            this.outSpan = integerInterleavedRaster.getScanlineStride();
            this.outOff = integerInterleavedRaster.getDataOffset(0);
            return writableRasterMakeRaster;
        }

        @Override // org.apache.poi.java.awt.TexturePaintContext
        public void setRaster(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            int i18;
            int i19;
            int[] iArr;
            int[] iArr2;
            int i20;
            int i21;
            int[] iArr3 = this.inData;
            int[] iArr4 = this.outData;
            int i22 = this.outOff;
            int i23 = this.inSpan;
            int i24 = this.inOff;
            int i25 = this.outSpan;
            boolean z = this.filter;
            boolean z2 = i10 == 1 && i11 == 0 && i12 == 0 && i13 == 0 && !z;
            if (z2) {
                i25 -= i6;
            }
            int[] iArr5 = z ? new int[4] : null;
            int i26 = i2;
            int i27 = i4;
            int i28 = i5;
            int i29 = i22;
            int i30 = 0;
            int i31 = i;
            while (i30 < i7) {
                if (z2) {
                    int iM1310c = AbstractC1974b.m1310c(i26, i23, i24, i8);
                    int i32 = i8 - i31;
                    i29 += i6;
                    i18 = i30;
                    if (i8 >= 32) {
                        int i33 = i6;
                        int i34 = i32;
                        while (i33 > 0) {
                            int i35 = i34;
                            int i36 = i33;
                            if (i33 < i34) {
                                i34 = i36;
                            }
                            int i37 = i31;
                            System.arraycopy(iArr3, iM1310c - i35, iArr4, i29 - i36, i34);
                            i33 = i36 - i34;
                            i34 = i35 - i34;
                            if (i34 == 0) {
                                i34 = i8;
                            }
                            i31 = i37;
                        }
                        i19 = i31;
                    } else {
                        i19 = i31;
                        for (int i38 = i6; i38 > 0; i38--) {
                            iArr4[i29 - i38] = iArr3[iM1310c - i32];
                            i32--;
                            if (i32 == 0) {
                                i32 = i8;
                            }
                        }
                    }
                    iArr = iArr3;
                    iArr2 = iArr4;
                } else {
                    i18 = i30;
                    i19 = i31;
                    iArr = iArr3;
                    iArr2 = iArr4;
                    int i39 = i26;
                    int i40 = 0;
                    int i41 = i27;
                    int i42 = i28;
                    while (i40 < i6) {
                        if (z) {
                            i20 = i40;
                            int i43 = i31 + 1;
                            if (i43 >= i8) {
                                i43 = 0;
                            }
                            int i44 = i43;
                            int i45 = i39 + 1;
                            if (i45 >= i9) {
                                i45 = 0;
                            }
                            int i46 = (i39 * i23) + i24;
                            iArr5[0] = iArr[i46 + i31];
                            iArr5[1] = iArr[i46 + i44];
                            int i47 = (i45 * i23) + i24;
                            iArr5[2] = iArr[i47 + i31];
                            iArr5[3] = iArr[i47 + i44];
                            iArr2[i29 + i20] = TexturePaintContext.blend(iArr5, i41, i42);
                        } else {
                            i20 = i40;
                            iArr2[i29 + i20] = iArr[AbstractC1974b.m1310c(i39, i23, i24, i31)];
                        }
                        i41 += i11;
                        if (i41 < 0) {
                            i31++;
                            i41 &= Integer.MAX_VALUE;
                        }
                        i31 += i10;
                        if (i31 >= i8) {
                            i31 -= i8;
                        }
                        i42 += i13;
                        if (i42 < 0) {
                            i39++;
                            i42 &= Integer.MAX_VALUE;
                        }
                        i39 += i12;
                        if (i39 >= i9) {
                            i39 -= i9;
                        }
                        i40 = i20 + 1;
                    }
                }
                i27 += i15;
                if (i27 < 0) {
                    i21 = i19 + 1;
                    i27 &= Integer.MAX_VALUE;
                } else {
                    i21 = i19;
                }
                i31 = i21 + i14;
                if (i31 >= i8) {
                    i31 -= i8;
                }
                i28 += i17;
                if (i28 < 0) {
                    i26++;
                    i28 &= Integer.MAX_VALUE;
                }
                i26 += i16;
                if (i26 >= i9) {
                    i26 -= i9;
                }
                i29 += i25;
                i30 = i18 + 1;
                iArr3 = iArr;
                iArr4 = iArr2;
            }
        }
    }

    public TexturePaintContext(ColorModel colorModel, AffineTransform affineTransform, int i, int i2, int i4) {
        this.colorModel = getInternedColorModel(colorModel);
        this.bWidth = i;
        this.bHeight = i2;
        this.maxWidth = i4;
        try {
            affineTransform = affineTransform.createInverse();
        } catch (NoninvertibleTransformException unused) {
            affineTransform.setToScale(0.0d, 0.0d);
        }
        double d = i;
        this.incXAcross = mod(affineTransform.getScaleX(), d);
        double d2 = i2;
        this.incYAcross = mod(affineTransform.getShearY(), d2);
        this.incXDown = mod(affineTransform.getShearX(), d);
        this.incYDown = mod(affineTransform.getScaleY(), d2);
        this.xOrg = affineTransform.getTranslateX();
        this.yOrg = affineTransform.getTranslateY();
        double d3 = this.incXAcross;
        this.colincx = (int) d3;
        this.colincy = (int) this.incYAcross;
        this.colincxerr = fractAsInt(d3);
        this.colincyerr = fractAsInt(this.incYAcross);
        double d4 = this.incXDown;
        this.rowincx = (int) d4;
        this.rowincy = (int) this.incYDown;
        this.rowincxerr = fractAsInt(d4);
        this.rowincyerr = fractAsInt(this.incYDown);
    }

    public static int blend(int[] iArr, int i, int i2) {
        int i4 = i >>> 19;
        int i5 = i2 >>> 19;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = iArr[i10];
            i4 = 4096 - i4;
            if ((i10 & 1) == 0) {
                i5 = 4096 - i5;
            }
            int i12 = i4 * i5;
            if (i12 != 0) {
                int i13 = ((i11 >>> 24) * i12) + i6;
                i9 = ((i11 & 255) * i12) + i9;
                i8 = (((i11 >>> 8) & 255) * i12) + i8;
                i7 = (((i11 >>> 16) & 255) * i12) + i7;
                i6 = i13;
            }
        }
        return ((i9 + 8388608) >>> 24) | (((i6 + 8388608) >>> 24) << 24) | (((i7 + 8388608) >>> 24) << 16) | (((i8 + 8388608) >>> 24) << 8);
    }

    public static synchronized void dropByteRaster(Raster raster) {
        if (raster == null) {
            return;
        }
        byteRasRef = new WeakReference(raster);
    }

    public static synchronized void dropRaster(ColorModel colorModel, Raster raster) {
        if (raster == null) {
            return;
        }
        try {
            if (xrgbmodel == colorModel) {
                xrgbRasRef = new WeakReference(raster);
            } else if (argbmodel == colorModel) {
                argbRasRef = new WeakReference(raster);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static int fractAsInt(double d) {
        return (int) ((d % 1.0d) * 2.147483647E9d);
    }

    public static PaintContext getContext(BufferedImage bufferedImage, AffineTransform affineTransform, RenderingHints renderingHints, Rectangle rectangle) {
        AffineTransform affineTransform2;
        int i;
        ColorModel colorModel;
        WritableRaster raster = bufferedImage.getRaster();
        ColorModel colorModel2 = bufferedImage.getColorModel();
        int i2 = rectangle.width;
        Object obj = renderingHints.get(RenderingHints.KEY_INTERPOLATION);
        boolean z = obj != null ? obj != RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR : renderingHints.get(RenderingHints.KEY_RENDERING) == RenderingHints.VALUE_RENDER_QUALITY;
        if (!(raster instanceof IntegerInterleavedRaster) || (z && !isFilterableDCM(colorModel2))) {
            affineTransform2 = affineTransform;
            i = i2;
            colorModel = colorModel2;
            if (raster instanceof ByteInterleavedRaster) {
                ByteInterleavedRaster byteInterleavedRaster = (ByteInterleavedRaster) raster;
                if (byteInterleavedRaster.getNumDataElements() == 1 && byteInterleavedRaster.getPixelStride() == 1) {
                    if (!z) {
                        return new Byte(byteInterleavedRaster, colorModel, affineTransform2, i);
                    }
                    if (isFilterableICM(colorModel)) {
                        return new ByteFilter(byteInterleavedRaster, colorModel, affineTransform2, i);
                    }
                }
            }
        } else {
            IntegerInterleavedRaster integerInterleavedRaster = (IntegerInterleavedRaster) raster;
            if (integerInterleavedRaster.getNumDataElements() == 1 && integerInterleavedRaster.getPixelStride() == 1) {
                return new Int(integerInterleavedRaster, colorModel2, affineTransform, i2, z);
            }
            affineTransform2 = affineTransform;
            i = i2;
            colorModel = colorModel2;
        }
        return new Any(raster, colorModel, affineTransform2, i, z);
    }

    public static ColorModel getInternedColorModel(ColorModel colorModel) {
        ColorModel colorModel2 = xrgbmodel;
        if (colorModel2 == colorModel || colorModel2.equals(colorModel)) {
            return xrgbmodel;
        }
        ColorModel colorModel3 = argbmodel;
        return (colorModel3 == colorModel || colorModel3.equals(colorModel)) ? argbmodel : colorModel;
    }

    public static boolean isFilterableDCM(ColorModel colorModel) {
        if (colorModel instanceof DirectColorModel) {
            DirectColorModel directColorModel = (DirectColorModel) colorModel;
            if (isMaskOK(directColorModel.getAlphaMask(), true) && isMaskOK(directColorModel.getRedMask(), false) && isMaskOK(directColorModel.getGreenMask(), false) && isMaskOK(directColorModel.getBlueMask(), false)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFilterableICM(ColorModel colorModel) {
        return (colorModel instanceof IndexColorModel) && ((IndexColorModel) colorModel).getMapSize() <= 256;
    }

    public static boolean isMaskOK(int i, boolean z) {
        return (z && i == 0) || i == 255 || i == 65280 || i == 16711680 || i == -16777216;
    }

    public static synchronized WritableRaster makeByteRaster(Raster raster, int i, int i2) {
        WritableRaster writableRaster;
        WeakReference weakReference = byteRasRef;
        if (weakReference != null && (writableRaster = (WritableRaster) weakReference.get()) != null && writableRaster.getWidth() >= i && writableRaster.getHeight() >= i2) {
            byteRasRef = null;
            return writableRaster;
        }
        if (i <= 32 && i2 <= 32) {
            i = 32;
            i2 = 32;
        }
        return raster.createCompatibleWritableRaster(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized WritableRaster makeRaster(ColorModel colorModel, Raster raster, int i, int i2) {
        WritableRaster writableRaster;
        WritableRaster writableRaster2;
        if (xrgbmodel == colorModel) {
            WeakReference weakReference = xrgbRasRef;
            if (weakReference != null && (writableRaster2 = (WritableRaster) weakReference.get()) != null && writableRaster2.getWidth() >= i && writableRaster2.getHeight() >= i2) {
                xrgbRasRef = null;
                return writableRaster2;
            }
            if (i <= 32 && i2 <= 32) {
                i = 32;
                i2 = 32;
            }
        } else if (argbmodel == colorModel) {
            WeakReference weakReference2 = argbRasRef;
            if (weakReference2 != null && (writableRaster = (WritableRaster) weakReference2.get()) != null && writableRaster.getWidth() >= i && writableRaster.getHeight() >= i2) {
                argbRasRef = null;
                return writableRaster;
            }
            if (i <= 32 && i2 <= 32) {
            }
        }
        return raster != null ? raster.createCompatibleWritableRaster(i, i2) : colorModel.createCompatibleWritableRaster(i, i2);
    }

    public static double mod(double d, double d2) {
        double d3 = d % d2;
        if (d3 < 0.0d) {
            d3 += d2;
            if (d3 >= d2) {
                return 0.0d;
            }
        }
        return d3;
    }

    @Override // org.apache.poi.java.awt.PaintContext
    public void dispose() {
        dropRaster(this.colorModel, this.outRas);
    }

    @Override // org.apache.poi.java.awt.PaintContext
    public ColorModel getColorModel() {
        return this.colorModel;
    }

    @Override // org.apache.poi.java.awt.PaintContext
    public Raster getRaster(int i, int i2, int i4, int i5) {
        WritableRaster writableRaster = this.outRas;
        if (writableRaster == null || writableRaster.getWidth() < i4 || this.outRas.getHeight() < i5) {
            this.outRas = makeRaster(i5 == 1 ? Math.max(i4, this.maxWidth) : i4, i5);
        }
        double d = i;
        double d2 = i2;
        double dMod = mod((this.incXDown * d2) + (this.incXAcross * d) + this.xOrg, this.bWidth);
        double dMod2 = mod((d2 * this.incYDown) + (d * this.incYAcross) + this.yOrg, this.bHeight);
        setRaster((int) dMod, (int) dMod2, fractAsInt(dMod), fractAsInt(dMod2), i4, i5, this.bWidth, this.bHeight, this.colincx, this.colincxerr, this.colincy, this.colincyerr, this.rowincx, this.rowincxerr, this.rowincy, this.rowincyerr);
        SunWritableRaster.markDirty(this.outRas);
        return this.outRas;
    }

    public abstract WritableRaster makeRaster(int i, int i2);

    public abstract void setRaster(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17);
}
