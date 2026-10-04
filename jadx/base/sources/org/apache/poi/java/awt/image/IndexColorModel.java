package org.apache.poi.java.awt.image;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.view.MotionEventCompat;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Hashtable;
import kotlin.UShort;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.color.ColorSpace;
import org.apache.poi.sun.awt.image.BufImgSurfaceData;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IndexColorModel extends ColorModel {
    private static final int CACHESIZE = 40;
    private boolean allgrayopaque;
    private BufImgSurfaceData.ICMColorData colorData;
    private int[] lookupcache;
    private int map_size;
    private int pixel_mask;
    private int[] rgb;
    private int transparent_index;
    private BigInteger validBits;
    private static int[] opaqueBits = {8, 8, 8};
    private static int[] alphaBits = {8, 8, 8, 8};

    static {
        ColorModel.loadLibraries();
    }

    public IndexColorModel(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(i, opaqueBits, ColorSpace.getInstance(1000), false, false, 1, ColorModel.getDefaultTransferType(i));
        this.transparent_index = -1;
        this.colorData = null;
        this.lookupcache = new int[40];
        if (i < 1 || i > 16) {
            throw new IllegalArgumentException("Number of bits must be between 1 and 16.");
        }
        setRGBs(i2, bArr, bArr2, bArr3, null);
        calculatePixelMask();
    }

    private int calcRealMapSize(int i, int i2) {
        return Math.max(Math.max(1 << i, i2), 256);
    }

    private final void calculatePixelMask() {
        int i = this.pixel_bits;
        if (i == 3) {
            i = 4;
        } else if (i > 4 && i < 8) {
            i = 8;
        }
        this.pixel_mask = (1 << i) - 1;
    }

    private BigInteger getAllValid() {
        int i = (this.map_size + 7) / 8;
        byte[] bArr = new byte[i];
        Arrays.fill(bArr, (byte) -1);
        bArr[0] = (byte) (255 >>> ((i * 8) - this.map_size));
        return new BigInteger(1, bArr);
    }

    private Object installpixel(Object obj, int i) {
        Object obj2;
        byte[] bArr;
        Object obj3;
        short[] sArr;
        Object obj4;
        int[] iArr;
        int i2 = this.transferType;
        if (i2 == 0) {
            if (obj == null) {
                bArr = new byte[1];
                obj2 = bArr;
            } else {
                obj2 = obj;
                bArr = (byte[]) obj;
            }
            bArr[0] = (byte) i;
            return obj2;
        }
        if (i2 == 1) {
            if (obj == null) {
                sArr = new short[1];
                obj3 = sArr;
            } else {
                obj3 = obj;
                sArr = (short[]) obj;
            }
            sArr[0] = (short) i;
            return obj3;
        }
        if (i2 != 3) {
            throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
        }
        if (obj == null) {
            iArr = new int[1];
            obj4 = iArr;
        } else {
            obj4 = obj;
            iArr = (int[]) obj;
        }
        iArr[0] = i;
        return obj4;
    }

    private void setRGBs(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        if (i < 1) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "Map size (", ") must be >= 1"));
        }
        this.map_size = i;
        this.rgb = new int[calcRealMapSize(this.pixel_bits, i)];
        boolean z = true;
        int i2 = 1;
        int i4 = 255;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = bArr[i5] & 255;
            int i7 = bArr2[i5] & 255;
            int i8 = bArr3[i5] & 255;
            z = z && i6 == i7 && i7 == i8;
            if (bArr4 != null && (i4 = bArr4[i5] & 255) != 255) {
                if (i4 == 0) {
                    if (i2 == 1) {
                        i2 = 2;
                    }
                    if (this.transparent_index < 0) {
                        this.transparent_index = i5;
                    }
                } else {
                    i2 = 3;
                }
                z = false;
            }
            this.rgb[i5] = (i6 << 16) | (i4 << 24) | (i7 << 8) | i8;
        }
        this.allgrayopaque = z;
        setTransparency(i2);
    }

    private void setTransparency(int i) {
        if (this.transparency != i) {
            this.transparency = i;
            if (i == 1) {
                this.supportsAlpha = false;
                this.numComponents = 3;
                this.nBits = opaqueBits;
            } else {
                this.supportsAlpha = true;
                this.numComponents = 4;
                this.nBits = alphaBits;
            }
        }
    }

    private void setTransparentPixel(int i) {
        if (i < 0 || i >= this.map_size) {
            return;
        }
        int[] iArr = this.rgb;
        iArr[i] = iArr[i] & 16777215;
        this.transparent_index = i;
        this.allgrayopaque = false;
        if (this.transparency == 1) {
            setTransparency(2);
        }
    }

    public BufferedImage convertToIntDiscrete(Raster raster, boolean z) {
        int i;
        if (!isCompatibleRaster(raster)) {
            throw new IllegalArgumentException("This raster is not compatiblewith this IndexColorModel.");
        }
        ColorModel rGBdefault = (z || (i = this.transparency) == 3) ? ColorModel.getRGBdefault() : i == 2 ? new DirectColorModel(25, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255, 16777216) : new DirectColorModel(24, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255);
        int width = raster.getWidth();
        int height = raster.getHeight();
        WritableRaster writableRasterCreateCompatibleWritableRaster = rGBdefault.createCompatibleWritableRaster(width, height);
        int minX = raster.getMinX();
        int minY = raster.getMinY();
        Object obj = null;
        int i2 = 0;
        while (i2 < height) {
            Object dataElements = raster.getDataElements(minX, minY, width, 1, obj);
            int i4 = minX;
            int i5 = minY;
            int[] intArray = dataElements instanceof int[] ? (int[]) dataElements : DataBuffer.toIntArray(dataElements);
            for (int i6 = 0; i6 < width; i6++) {
                intArray[i6] = this.rgb[intArray[i6] & this.pixel_mask];
            }
            int i7 = i2;
            writableRasterCreateCompatibleWritableRaster.setDataElements(0, i7, width, 1, intArray);
            i2 = i7 + 1;
            minY = i5 + 1;
            obj = dataElements;
            minX = i4;
        }
        return new BufferedImage(rGBdefault, writableRasterCreateCompatibleWritableRaster, false, (Hashtable<?, ?>) null);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public SampleModel createCompatibleSampleModel(int i, int i2) {
        int[] iArr = {0};
        int i4 = this.pixel_bits;
        return (i4 == 1 || i4 == 2 || i4 == 4) ? new MultiPixelPackedSampleModel(this.transferType, i, i2, this.pixel_bits) : new ComponentSampleModel(this.transferType, i, i2, 1, i, iArr);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public WritableRaster createCompatibleWritableRaster(int i, int i2) {
        int i4 = this.pixel_bits;
        if (i4 == 1 || i4 == 2 || i4 == 4) {
            return Raster.createPackedRaster(0, i, i2, 1, i4, (Point) null);
        }
        if (i4 <= 8) {
            return Raster.createInterleavedRaster(0, i, i2, 1, null);
        }
        if (i4 <= 16) {
            return Raster.createInterleavedRaster(1, i, i2, 1, null);
        }
        throw new UnsupportedOperationException("This method is not supported  for pixel bits > 16.");
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public final int getAlpha(int i) {
        return (this.rgb[i & this.pixel_mask] >> 24) & 255;
    }

    public final void getAlphas(byte[] bArr) {
        for (int i = 0; i < this.map_size; i++) {
            bArr[i] = (byte) (this.rgb[i] >> 24);
        }
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public final int getBlue(int i) {
        return this.rgb[i & this.pixel_mask] & 255;
    }

    public final void getBlues(byte[] bArr) {
        for (int i = 0; i < this.map_size; i++) {
            bArr[i] = (byte) this.rgb[i];
        }
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int[] getComponentSize() {
        if (this.nBits == null) {
            if (this.supportsAlpha) {
                int[] iArr = new int[4];
                this.nBits = iArr;
                iArr[3] = 8;
            } else {
                this.nBits = new int[3];
            }
            int[] iArr2 = this.nBits;
            iArr2[2] = 8;
            iArr2[1] = 8;
            iArr2[0] = 8;
        }
        return (int[]) this.nBits.clone();
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int[] getComponents(int i, int[] iArr, int i2) {
        if (iArr == null) {
            iArr = new int[this.numComponents + i2];
        }
        iArr[i2] = getRed(i);
        iArr[i2 + 1] = getGreen(i);
        iArr[i2 + 2] = getBlue(i);
        if (this.supportsAlpha && iArr.length - i2 > 3) {
            iArr[i2 + 3] = getAlpha(i);
        }
        return iArr;
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int getDataElement(int[] iArr, int i) {
        Object dataElements = getDataElements((this.supportsAlpha ? iArr[i + 3] << 24 : -16777216) | (iArr[i] << 16) | (iArr[i + 1] << 8) | iArr[i + 2], null);
        int i2 = this.transferType;
        if (i2 == 0) {
            return ((byte[]) dataElements)[0] & 255;
        }
        if (i2 == 1) {
            return ((short[]) dataElements)[0];
        }
        if (i2 == 3) {
            return ((int[]) dataElements)[0];
        }
        throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r13.allgrayopaque == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        r2 = ((r2 * 29) + ((r1 * 150) + (r0 * 77))) + 128;
        r0 = 256;
        r2 = r2 / 256;
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        if (r1 >= r13.map_size) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
    
        r3 = r13.rgb[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
    
        if (r3 != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        r3 = (r3 & 255) - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
    
        if (r3 >= 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
    
        r3 = -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
    
        if (r3 >= r0) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
    
        if (r3 != 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        r7 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
    
        r7 = r1;
        r0 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
    
        r8 = Integer.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        if (r13.transparency != 1) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
    
        r3 = r13.rgb;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006c, code lost:
    
        if (r6 >= r13.map_size) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006e, code lost:
    
        r9 = r3[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0070, code lost:
    
        if (r9 != r14) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
    
        if (r9 == 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0074, code lost:
    
        r8 = 0;
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007a, code lost:
    
        if (r8 == 0) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007c, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007f, code lost:
    
        if (r6 >= r13.map_size) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
    
        r9 = r3[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0083, code lost:
    
        if (r9 != 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0086, code lost:
    
        r10 = ((r9 >> 16) & 255) - r0;
        r10 = r10 * r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008c, code lost:
    
        if (r10 >= r8) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008e, code lost:
    
        r11 = ((r9 >> 8) & 255) - r1;
        r11 = (r11 * r11) + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0095, code lost:
    
        if (r11 >= r8) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0097, code lost:
    
        r9 = (r9 & 255) - r2;
        r9 = (r9 * r9) + r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x009c, code lost:
    
        if (r9 >= r8) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009e, code lost:
    
        r7 = r6;
        r8 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a0, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a3, code lost:
    
        if (r3 != 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a5, code lost:
    
        r6 = r13.transparent_index;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a7, code lost:
    
        if (r6 < 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a9, code lost:
    
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ab, code lost:
    
        r6 = r13.rgb;
        r9 = Integer.MAX_VALUE;
        r8 = r7;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b2, code lost:
    
        if (r7 >= r13.map_size) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b4, code lost:
    
        r10 = r6[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b6, code lost:
    
        if (r10 != r14) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b8, code lost:
    
        r10 = r13.validBits;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ba, code lost:
    
        if (r10 == null) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c0, code lost:
    
        if (r10.testBit(r7) != false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c3, code lost:
    
        r11 = ((r10 >> 16) & 255) - r0;
        r11 = r11 * r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c9, code lost:
    
        if (r11 >= r9) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00cb, code lost:
    
        r12 = ((r10 >> 8) & 255) - r1;
        r12 = (r12 * r12) + r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00d2, code lost:
    
        if (r12 >= r9) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00d4, code lost:
    
        r11 = (r10 & 255) - r2;
        r11 = (r11 * r11) + r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00d9, code lost:
    
        if (r11 >= r9) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00db, code lost:
    
        r10 = (r10 >>> 24) - r3;
        r10 = (r10 * r10) + r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00e0, code lost:
    
        if (r10 >= r9) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00e2, code lost:
    
        r11 = r13.validBits;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00e4, code lost:
    
        if (r11 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00ea, code lost:
    
        if (r11.testBit(r7) == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00ec, code lost:
    
        r8 = r7;
        r9 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00ee, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00f1, code lost:
    
        r7 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00f2, code lost:
    
        r0 = r13.lookupcache;
        java.lang.System.arraycopy(r0, 2, r0, 0, 38);
        r0 = r13.lookupcache;
        r0[39] = r14;
        r0[38] = ~r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0106, code lost:
    
        return installpixel(r15, r7);
     */
    @Override // org.apache.poi.java.awt.image.ColorModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Object getDataElements(int i, Object obj) {
        int i2 = (i >> 16) & 255;
        int i4 = (i >> 8) & 255;
        int i5 = i & 255;
        int i6 = i >>> 24;
        int i7 = 0;
        int i8 = 38;
        while (true) {
            if (i8 < 0) {
                break;
            }
            int[] iArr = this.lookupcache;
            int i9 = iArr[i8];
            if (i9 == 0) {
                i7 = i9;
                break;
            }
            if (i == iArr[i8 + 1]) {
                return installpixel(obj, ~i9);
            }
            i8 -= 2;
            i7 = i9;
        }
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public final int getGreen(int i) {
        return (this.rgb[i & this.pixel_mask] >> 8) & 255;
    }

    public final void getGreens(byte[] bArr) {
        for (int i = 0; i < this.map_size; i++) {
            bArr[i] = (byte) (this.rgb[i] >> 8);
        }
    }

    public final int getMapSize() {
        return this.map_size;
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public final int getRGB(int i) {
        return this.rgb[i & this.pixel_mask];
    }

    public final void getRGBs(int[] iArr) {
        System.arraycopy(this.rgb, 0, iArr, 0, this.map_size);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public final int getRed(int i) {
        return (this.rgb[i & this.pixel_mask] >> 16) & 255;
    }

    public final void getReds(byte[] bArr) {
        for (int i = 0; i < this.map_size; i++) {
            bArr[i] = (byte) (this.rgb[i] >> 16);
        }
    }

    @Override // org.apache.poi.java.awt.image.ColorModel, org.apache.poi.java.awt.Transparency
    public int getTransparency() {
        return this.transparency;
    }

    public final int getTransparentPixel() {
        return this.transparent_index;
    }

    public BigInteger getValidPixels() {
        BigInteger bigInteger = this.validBits;
        return bigInteger == null ? getAllValid() : bigInteger;
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public boolean isCompatibleRaster(Raster raster) {
        return raster.getTransferType() == this.transferType && raster.getNumBands() == 1 && (1 << raster.getSampleModel().getSampleSize(0)) >= this.map_size;
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public boolean isCompatibleSampleModel(SampleModel sampleModel) {
        return ((sampleModel instanceof ComponentSampleModel) || (sampleModel instanceof MultiPixelPackedSampleModel)) && sampleModel.getTransferType() == this.transferType && sampleModel.getNumBands() == 1;
    }

    public boolean isValid(int i) {
        if (i < 0 || i >= this.map_size) {
            return false;
        }
        BigInteger bigInteger = this.validBits;
        return bigInteger == null || bigInteger.testBit(i);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public String toString() {
        return new String("IndexColorModel: #pixelBits = " + this.pixel_bits + " numComponents = " + this.numComponents + " color space = " + this.colorSpace + " transparency = " + this.transparency + " transIndex   = " + this.transparent_index + " has alpha = " + this.supportsAlpha + " isAlphaPre = " + this.isAlphaPremultiplied);
    }

    public boolean isValid() {
        return this.validBits == null;
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public int[] getComponents(Object obj, int[] iArr, int i) {
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

    public IndexColorModel(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i4) {
        super(i, opaqueBits, ColorSpace.getInstance(1000), false, false, 1, ColorModel.getDefaultTransferType(i));
        this.transparent_index = -1;
        this.colorData = null;
        this.lookupcache = new int[40];
        if (i >= 1 && i <= 16) {
            setRGBs(i2, bArr, bArr2, bArr3, null);
            setTransparentPixel(i4);
            calculatePixelMask();
            return;
        }
        throw new IllegalArgumentException("Number of bits must be between 1 and 16.");
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public void finalize() {
    }

    private void setRGBs(int i, int[] iArr, int i2, boolean z) {
        this.map_size = i;
        this.rgb = new int[calcRealMapSize(this.pixel_bits, i)];
        BigInteger bigInteger = this.validBits;
        boolean z2 = true;
        int i4 = 1;
        int i5 = 0;
        while (i5 < i) {
            if (bigInteger == null || bigInteger.testBit(i5)) {
                int i6 = iArr[i2];
                int i7 = (i6 >> 8) & 255;
                z2 = z2 && ((i6 >> 16) & 255) == i7 && i7 == (i6 & 255);
                if (z) {
                    int i8 = i6 >>> 24;
                    if (i8 != 255) {
                        if (i8 == 0) {
                            if (i4 == 1) {
                                i4 = 2;
                            }
                            if (this.transparent_index < 0) {
                                this.transparent_index = i5;
                            }
                        } else {
                            i4 = 3;
                        }
                        z2 = false;
                    }
                } else {
                    i6 |= -16777216;
                }
                this.rgb[i5] = i6;
            }
            i5++;
            i2++;
        }
        this.allgrayopaque = z2;
        setTransparency(i4);
    }

    public IndexColorModel(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        super(i, alphaBits, ColorSpace.getInstance(1000), true, false, 3, ColorModel.getDefaultTransferType(i));
        this.transparent_index = -1;
        this.colorData = null;
        this.lookupcache = new int[40];
        if (i >= 1 && i <= 16) {
            setRGBs(i2, bArr, bArr2, bArr3, bArr4);
            calculatePixelMask();
            return;
        }
        throw new IllegalArgumentException("Number of bits must be between 1 and 16.");
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public Object getDataElements(int[] iArr, int i, Object obj) {
        int i2 = (iArr[i] << 16) | (iArr[i + 1] << 8) | iArr[i + 2];
        return getDataElements(this.supportsAlpha ? (iArr[i + 3] << 24) | i2 : (-16777216) & i2, obj);
    }

    public IndexColorModel(int i, int i2, byte[] bArr, int i4, boolean z) {
        this(i, i2, bArr, i4, z, -1);
        if (i < 1 || i > 16) {
            throw new IllegalArgumentException("Number of bits must be between 1 and 16.");
        }
    }

    public IndexColorModel(int i, int i2, byte[] bArr, int i4, boolean z, int i5) {
        super(i, opaqueBits, ColorSpace.getInstance(1000), false, false, 1, ColorModel.getDefaultTransferType(i));
        this.transparent_index = -1;
        this.colorData = null;
        this.lookupcache = new int[40];
        if (i < 1 || i > 16) {
            throw new IllegalArgumentException("Number of bits must be between 1 and 16.");
        }
        if (i2 >= 1) {
            this.map_size = i2;
            this.rgb = new int[calcRealMapSize(i, i2)];
            int i6 = i4;
            boolean z2 = true;
            int i7 = 1;
            int i8 = 255;
            for (int i9 = 0; i9 < i2; i9++) {
                int i10 = bArr[i6] & 255;
                int i11 = bArr[i6 + 1] & 255;
                int i12 = i6 + 3;
                int i13 = bArr[i6 + 2] & 255;
                z2 = z2 && i10 == i11 && i11 == i13;
                if (z) {
                    i6 += 4;
                    i8 = bArr[i12] & 255;
                    if (i8 != 255) {
                        if (i8 == 0) {
                            i7 = i7 == 1 ? 2 : i7;
                            if (this.transparent_index < 0) {
                                this.transparent_index = i9;
                            }
                        } else {
                            i7 = 3;
                        }
                        z2 = false;
                    }
                } else {
                    i6 = i12;
                }
                this.rgb[i9] = (i11 << 8) | (i10 << 16) | (i8 << 24) | i13;
            }
            this.allgrayopaque = z2;
            setTransparency(i7);
            setTransparentPixel(i5);
            calculatePixelMask();
            return;
        }
        throw new IllegalArgumentException(AbstractC0541b.m767i(i2, "Map size (", ") must be >= 1"));
    }

    public IndexColorModel(int i, int i2, int[] iArr, int i4, boolean z, int i5, int i6) {
        super(i, opaqueBits, ColorSpace.getInstance(1000), false, false, 1, i6);
        this.transparent_index = -1;
        this.colorData = null;
        this.lookupcache = new int[40];
        if (i < 1 || i > 16) {
            throw new IllegalArgumentException("Number of bits must be between 1 and 16.");
        }
        if (i2 < 1) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i2, "Map size (", ") must be >= 1"));
        }
        if (i6 != 0 && i6 != 1) {
            throw new IllegalArgumentException("transferType must be eitherDataBuffer.TYPE_BYTE or DataBuffer.TYPE_USHORT");
        }
        setRGBs(i2, iArr, i4, z);
        setTransparentPixel(i5);
        calculatePixelMask();
    }

    public IndexColorModel(int i, int i2, int[] iArr, int i4, int i5, BigInteger bigInteger) {
        super(i, alphaBits, ColorSpace.getInstance(1000), true, false, 3, i5);
        this.transparent_index = -1;
        this.colorData = null;
        this.lookupcache = new int[40];
        if (i < 1 || i > 16) {
            throw new IllegalArgumentException("Number of bits must be between 1 and 16.");
        }
        if (i2 < 1) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i2, "Map size (", ") must be >= 1"));
        }
        if (i5 != 0 && i5 != 1) {
            throw new IllegalArgumentException("transferType must be eitherDataBuffer.TYPE_BYTE or DataBuffer.TYPE_USHORT");
        }
        if (bigInteger != null) {
            int i6 = 0;
            while (true) {
                if (i6 >= i2) {
                    break;
                }
                if (!bigInteger.testBit(i6)) {
                    this.validBits = bigInteger;
                    break;
                }
                i6++;
            }
        }
        setRGBs(i2, iArr, i4, true);
        calculatePixelMask();
    }
}
