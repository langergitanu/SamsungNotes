package org.apache.poi.java.awt.image;

import androidx.collection.AbstractC0622a;
import java.util.Hashtable;
import org.apache.poi.java.awt.Point;

/* JADX INFO: loaded from: classes10.dex */
public class BufferedImageFilter extends ImageFilter implements Cloneable {
    BufferedImageOp bufferedImageOp;
    byte[] bytePixels;
    int height;
    int[] intPixels;
    ColorModel model;
    int width;

    public BufferedImageFilter(BufferedImageOp bufferedImageOp) {
        if (bufferedImageOp == null) {
            throw new NullPointerException("Operation cannot be null");
        }
        this.bufferedImageOp = bufferedImageOp;
    }

    private void convertToRGB() {
        int i = this.width * this.height;
        int[] iArr = new int[i];
        int i2 = 0;
        if (this.bytePixels != null) {
            while (i2 < i) {
                iArr[i2] = this.model.getRGB(this.bytePixels[i2] & 255);
                i2++;
            }
        } else if (this.intPixels != null) {
            while (i2 < i) {
                iArr[i2] = this.model.getRGB(this.intPixels[i2]);
                i2++;
            }
        }
        this.bytePixels = null;
        this.intPixels = iArr;
        this.model = ColorModel.getRGBdefault();
    }

    private final WritableRaster createDCMraster() {
        ColorModel colorModel = this.model;
        DirectColorModel directColorModel = (DirectColorModel) colorModel;
        boolean zHasAlpha = colorModel.hasAlpha();
        int[] iArr = new int[(zHasAlpha ? 1 : 0) + 3];
        iArr[0] = directColorModel.getRedMask();
        iArr[1] = directColorModel.getGreenMask();
        iArr[2] = directColorModel.getBlueMask();
        if (zHasAlpha) {
            iArr[3] = directColorModel.getAlphaMask();
        }
        DataBufferInt dataBufferInt = new DataBufferInt(this.intPixels, this.width * this.height);
        int i = this.width;
        return Raster.createPackedRaster(dataBufferInt, i, this.height, i, iArr, (Point) null);
    }

    public BufferedImageOp getBufferedImageOp() {
        return this.bufferedImageOp;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0021, code lost:
    
        if (r11.intPixels == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0025, code lost:
    
        r0 = createDCMraster();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
    
        if (r11.intPixels == null) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void imageComplete(int i) {
        WritableRaster writableRasterCreateInterleavedRaster;
        if (i == 1) {
            this.model = null;
            this.width = -1;
            this.height = -1;
            this.intPixels = null;
            this.bytePixels = null;
        } else if (i == 2 || i == 3) {
            if (this.width > 0 && this.height > 0) {
                ColorModel colorModel = this.model;
                if (!(colorModel instanceof DirectColorModel)) {
                    if (colorModel instanceof IndexColorModel) {
                        int[] iArr = {0};
                        if (this.bytePixels != null) {
                            DataBufferByte dataBufferByte = new DataBufferByte(this.bytePixels, this.width * this.height);
                            int i2 = this.width;
                            writableRasterCreateInterleavedRaster = Raster.createInterleavedRaster(dataBufferByte, i2, this.height, i2, 1, iArr, (Point) null);
                        }
                    } else {
                        convertToRGB();
                    }
                }
                ColorModel colorModel2 = this.model;
                BufferedImage bufferedImageFilter = this.bufferedImageOp.filter(new BufferedImage(colorModel2, writableRasterCreateInterleavedRaster, colorModel2.isAlphaPremultiplied(), (Hashtable<?, ?>) null), null);
                WritableRaster raster = bufferedImageFilter.getRaster();
                ColorModel colorModel3 = bufferedImageFilter.getColorModel();
                int width = raster.getWidth();
                int height = raster.getHeight();
                this.consumer.setDimensions(width, height);
                this.consumer.setColorModel(colorModel3);
                if (colorModel3 instanceof DirectColorModel) {
                    this.consumer.setPixels(0, 0, width, height, colorModel3, ((DataBufferInt) raster.getDataBuffer()).getData(), 0, width);
                } else {
                    if (!(colorModel3 instanceof IndexColorModel)) {
                        throw new InternalError("Unknown color model " + colorModel3);
                    }
                    this.consumer.setPixels(0, 0, width, height, colorModel3, ((DataBufferByte) raster.getDataBuffer()).getData(), 0, width);
                }
            }
        } else if (i == 4) {
        }
        this.consumer.imageComplete(i);
    }

    public void setColorModel(ColorModel colorModel) {
        this.model = colorModel;
    }

    public void setDimensions(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            imageComplete(3);
        } else {
            this.width = i;
            this.height = i2;
        }
    }

    public void setPixels(int i, int i2, int i4, int i5, ColorModel colorModel, byte[] bArr, int i6, int i7) {
        if (i4 < 0 || i5 < 0) {
            throw new IllegalArgumentException(AbstractC0622a.m1164j(i4, i5, "Width (", ") and height (", ") must be > 0"));
        }
        if (i4 == 0 || i5 == 0) {
            return;
        }
        if (i2 < 0) {
            int i8 = -i2;
            if (i8 >= i5) {
                return;
            }
            i6 += i7 * i8;
            i2 += i8;
            i5 -= i8;
        }
        int i9 = i2 + i5;
        int i10 = this.height;
        if (i9 <= i10 || (i5 = i10 - i2) > 0) {
            if (i < 0) {
                int i11 = -i;
                if (i11 >= i4) {
                    return;
                }
                i6 += i11;
                i += i11;
                i4 -= i11;
            }
            int i12 = i + i4;
            int i13 = this.width;
            if (i12 <= i13 || (i4 = i13 - i) > 0) {
                int i14 = (i2 * i13) + i;
                if (this.intPixels == null) {
                    if (this.bytePixels == null) {
                        this.bytePixels = new byte[i13 * i10];
                        this.model = colorModel;
                    } else if (this.model != colorModel) {
                        convertToRGB();
                    }
                    if (this.bytePixels != null) {
                        for (int i15 = i5; i15 > 0; i15--) {
                            System.arraycopy(bArr, i6, this.bytePixels, i14, i4);
                            i6 += i7;
                            i14 += this.width;
                        }
                    }
                }
                if (this.intPixels != null) {
                    int i16 = this.width - i4;
                    int i17 = i7 - i4;
                    while (i5 > 0) {
                        int i18 = i4;
                        while (i18 > 0) {
                            this.intPixels[i14] = colorModel.getRGB(bArr[i6] & 255);
                            i18--;
                            i14++;
                            i6++;
                        }
                        i6 += i17;
                        i14 += i16;
                        i5--;
                    }
                }
            }
        }
    }

    public void setPixels(int i, int i2, int i4, int i5, ColorModel colorModel, int[] iArr, int i6, int i7) {
        if (i4 < 0 || i5 < 0) {
            throw new IllegalArgumentException(AbstractC0622a.m1164j(i4, i5, "Width (", ") and height (", ") must be > 0"));
        }
        if (i4 == 0 || i5 == 0) {
            return;
        }
        if (i2 < 0) {
            int i8 = -i2;
            if (i8 >= i5) {
                return;
            }
            i6 += i7 * i8;
            i2 += i8;
            i5 -= i8;
        }
        int i9 = i2 + i5;
        int i10 = this.height;
        if (i9 <= i10 || (i5 = i10 - i2) > 0) {
            if (i < 0) {
                int i11 = -i;
                if (i11 >= i4) {
                    return;
                }
                i6 += i11;
                i += i11;
                i4 -= i11;
            }
            int i12 = i + i4;
            int i13 = this.width;
            if (i12 <= i13 || (i4 = i13 - i) > 0) {
                if (this.intPixels == null) {
                    if (this.bytePixels == null) {
                        this.intPixels = new int[i13 * i10];
                        this.model = colorModel;
                    } else {
                        convertToRGB();
                    }
                }
                int i14 = (i2 * this.width) + i;
                ColorModel colorModel2 = this.model;
                if (colorModel2 == colorModel) {
                    while (i5 > 0) {
                        System.arraycopy(iArr, i6, this.intPixels, i14, i4);
                        i6 += i7;
                        i14 += this.width;
                        i5--;
                    }
                    return;
                }
                if (colorModel2 != ColorModel.getRGBdefault()) {
                    convertToRGB();
                }
                int i15 = this.width - i4;
                int i16 = i7 - i4;
                while (i5 > 0) {
                    int i17 = i4;
                    while (i17 > 0) {
                        this.intPixels[i14] = colorModel.getRGB(iArr[i6]);
                        i17--;
                        i14++;
                        i6++;
                    }
                    i6 += i16;
                    i14 += i15;
                    i5--;
                }
            }
        }
    }
}
