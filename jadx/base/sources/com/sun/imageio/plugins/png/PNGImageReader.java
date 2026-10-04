package com.sun.imageio.plugins.png;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.sun.imageio.plugins.common.ReaderUtil;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.color.ColorSpace;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.DataBuffer;
import org.apache.poi.java.awt.image.DataBufferByte;
import org.apache.poi.java.awt.image.DataBufferUShort;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.WritableRaster;
import org.apache.poi.javax.imageio.IIOException;
import org.apache.poi.javax.imageio.ImageReadParam;
import org.apache.poi.javax.imageio.ImageReader;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.spi.ImageReaderSpi;
import org.apache.poi.javax.imageio.stream.ImageInputStream;
import org.apache.poi.sun.awt.image.ByteInterleavedRaster;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PNGImageReader extends ImageReader {
    static final int IDAT_TYPE = 1229209940;
    static final int IEND_TYPE = 1229278788;
    static final int IHDR_TYPE = 1229472850;
    static final int PLTE_TYPE = 1347179589;
    static final int PNG_COLOR_GRAY = 0;
    static final int PNG_COLOR_GRAY_ALPHA = 4;
    static final int PNG_COLOR_PALETTE = 3;
    static final int PNG_COLOR_RGB = 2;
    static final int PNG_COLOR_RGB_ALPHA = 6;
    static final int PNG_FILTER_AVERAGE = 3;
    static final int PNG_FILTER_NONE = 0;
    static final int PNG_FILTER_PAETH = 4;
    static final int PNG_FILTER_SUB = 1;
    static final int PNG_FILTER_UP = 2;
    static final int bKGD_TYPE = 1649100612;
    static final int cHRM_TYPE = 1665684045;
    private static final boolean debug = true;
    static final int gAMA_TYPE = 1732332865;
    static final int hIST_TYPE = 1749635924;
    static final int iCCP_TYPE = 1766015824;
    static final int iTXt_TYPE = 1767135348;
    static final int pHYs_TYPE = 1883789683;
    static final int sBIT_TYPE = 1933723988;
    static final int sPLT_TYPE = 1934642260;
    static final int sRGB_TYPE = 1934772034;
    static final int tEXt_TYPE = 1950701684;
    static final int tIME_TYPE = 1950960965;
    static final int tRNS_TYPE = 1951551059;
    static final int zTXt_TYPE = 2052348020;
    int[] destinationBands;
    Point destinationOffset;
    boolean gotHeader;
    boolean gotMetadata;
    long imageStartPosition;
    ImageReadParam lastParam;
    PNGMetadata metadata;
    DataInputStream pixelStream;
    int pixelsDone;
    int[] sourceBands;
    int sourceMaxProgressivePass;
    int sourceMinProgressivePass;
    Rectangle sourceRegion;
    int sourceXSubsampling;
    int sourceYSubsampling;
    ImageInputStream stream;
    BufferedImage theImage;
    int totalPixels;
    static final int[] inputBandsForColorType = {1, -1, 3, 1, 2, -1, 4};
    static final int[] adam7XOffset = {0, 4, 0, 2, 0, 1, 0};
    static final int[] adam7YOffset = {0, 0, 4, 0, 2, 0, 1};
    static final int[] adam7XSubsampling = {8, 8, 4, 4, 2, 2, 1, 1};
    static final int[] adam7YSubsampling = {8, 8, 8, 4, 4, 2, 2, 1};
    private static final int[][] bandOffsets = {null, new int[]{0}, new int[]{0, 1}, new int[]{0, 1, 2}, new int[]{0, 1, 2, 3}};

    public PNGImageReader(ImageReaderSpi imageReaderSpi) {
        super(imageReaderSpi);
        this.stream = null;
        this.gotHeader = false;
        this.gotMetadata = false;
        this.lastParam = null;
        this.imageStartPosition = -1L;
        this.sourceRegion = null;
        this.sourceXSubsampling = -1;
        this.sourceYSubsampling = -1;
        this.sourceMinProgressivePass = 0;
        this.sourceMaxProgressivePass = 6;
        this.sourceBands = null;
        this.destinationBands = null;
        this.destinationOffset = new Point(0, 0);
        this.metadata = new PNGMetadata();
        this.pixelStream = null;
        this.theImage = null;
        this.pixelsDone = 0;
    }

    private WritableRaster createRaster(int i, int i2, int i4, int i5, int i6) {
        Point point = new Point(0, 0);
        return (i6 >= 8 || i4 != 1) ? i6 <= 8 ? Raster.createInterleavedRaster(new DataBufferByte(i2 * i5), i, i2, i5, i4, bandOffsets[i4], point) : Raster.createInterleavedRaster(new DataBufferUShort(i2 * i5), i, i2, i5, i4, bandOffsets[i4], point) : Raster.createPackedRaster(new DataBufferByte(i5 * i2), i, i2, i6, point);
    }

    private static void decodeAverageFilter(byte[] bArr, int i, byte[] bArr2, int i2, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = i6 + i;
            bArr[i7] = (byte) (((bArr2[i6 + i2] & 255) / 2) + (bArr[i7] & 255));
        }
        for (int i8 = i5; i8 < i4; i8++) {
            int i9 = i8 + i;
            bArr[i9] = (byte) ((((bArr[i9 - i5] & 255) + (bArr2[i8 + i2] & 255)) / 2) + (bArr[i9] & 255));
        }
    }

    private void decodeImage() throws IOException {
        PNGMetadata pNGMetadata = this.metadata;
        int i = pNGMetadata.IHDR_width;
        int i2 = pNGMetadata.IHDR_height;
        int i4 = 0;
        this.pixelsDone = 0;
        this.totalPixels = i * i2;
        clearAbortRequest();
        if (this.metadata.IHDR_interlaceMethod == 0) {
            decodePass(0, 0, 0, 1, 1, i, i2);
            return;
        }
        while (i4 <= this.sourceMaxProgressivePass) {
            int i5 = adam7XOffset[i4];
            int i6 = adam7YOffset[i4];
            int[] iArr = adam7XSubsampling;
            int i7 = iArr[i4];
            int[] iArr2 = adam7YSubsampling;
            int i8 = iArr2[i4];
            int i9 = i4 + 1;
            int i10 = iArr[i9] - 1;
            int i11 = iArr2[i9] - 1;
            if (i4 >= this.sourceMinProgressivePass) {
                decodePass(i4, i5, i6, i7, i8, (i10 + i) / i7, (i11 + i2) / i8);
            } else {
                skipPass((i + i10) / i7, (i2 + i11) / i8);
            }
            if (abortRequested()) {
                return;
            } else {
                i4 = i9;
            }
        }
    }

    private static void decodePaethFilter(byte[] bArr, int i, byte[] bArr2, int i2, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = i6 + i;
            bArr[i7] = (byte) ((bArr[i7] & 255) + (bArr2[i6 + i2] & 255));
        }
        for (int i8 = i5; i8 < i4; i8++) {
            int i9 = i8 + i;
            int i10 = i8 + i2;
            bArr[i9] = (byte) ((bArr[i9] & 255) + paethPredictor(bArr[i9 - i5] & 255, bArr2[i10] & 255, bArr2[i10 - i5] & 255));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x025b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void decodePass(int i, int i2, int i4, int i5, int i6, int i7, int i8) throws IOException {
        int[][] iArr;
        short[] data;
        byte[] data2;
        int i9;
        WritableRaster writableRasterCreateWritableChild;
        boolean z;
        int[][] iArr2;
        int i10;
        int i11;
        int i12;
        byte[] bArr;
        int i13;
        int i14;
        int i15;
        byte[] bArr2;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        byte[] bArr3;
        byte[] bArr4;
        int i21;
        WritableRaster writableRaster;
        int[] iArr3;
        int i22;
        int i23;
        int i24;
        PNGImageReader pNGImageReader;
        int i25;
        if (i7 == 0 || i8 == 0) {
            return;
        }
        WritableRaster writableTile = this.theImage.getWritableTile(0, 0);
        int minX = writableTile.getMinX();
        int width = (writableTile.getWidth() + minX) - 1;
        int minY = writableTile.getMinY();
        int height = (writableTile.getHeight() + minY) - 1;
        int[] iArrComputeUpdatedPixels = ReaderUtil.computeUpdatedPixels(this.sourceRegion, this.destinationOffset, minX, minY, width, height, this.sourceXSubsampling, this.sourceYSubsampling, i2, i4, i7, i8, i5, i6);
        int i26 = iArrComputeUpdatedPixels[0];
        int i27 = iArrComputeUpdatedPixels[1];
        int i28 = iArrComputeUpdatedPixels[2];
        int i29 = iArrComputeUpdatedPixels[4];
        int i30 = iArrComputeUpdatedPixels[5];
        PNGMetadata pNGMetadata = this.metadata;
        int i31 = pNGMetadata.IHDR_bitDepth;
        int i32 = inputBandsForColorType[pNGMetadata.IHDR_colorType];
        int i33 = (i31 == 16 ? 2 : 1) * i32;
        int i34 = (((i32 * i7) * i31) + 7) / 8;
        int i35 = i31 == 16 ? i34 / 2 : i34;
        if (i28 == 0) {
            for (int i36 = 0; i36 < i8; i36++) {
                updateImageProgress(i7);
                this.pixelStream.skipBytes(i34 + 1);
            }
            return;
        }
        int i37 = i26 - this.destinationOffset.f10092x;
        int i38 = this.sourceXSubsampling;
        int iM3211u = AbstractC4539a.m3211u(i37 * i38, this.sourceRegion.f10094x, i2, i5);
        int i39 = (i38 * i29) / i5;
        byte[] bArr5 = new byte[i34];
        byte[] bArr6 = new byte[i34];
        int i40 = i34;
        WritableRaster writableRasterCreateRaster = createRaster(i7, 1, i32, i35, i31);
        int[] pixel = writableRasterCreateRaster.getPixel(0, 0, (int[]) null);
        DataBuffer dataBuffer = writableRasterCreateRaster.getDataBuffer();
        if (dataBuffer.getDataType() == 0) {
            data2 = ((DataBufferByte) dataBuffer).getData();
            iArr = null;
            data = null;
        } else {
            iArr = null;
            data = ((DataBufferUShort) dataBuffer).getData();
            data2 = null;
        }
        int i41 = minY;
        int i42 = height;
        int[] iArr4 = pixel;
        byte[] bArr7 = data2;
        int i43 = i35;
        processPassStarted(this.theImage, i, this.sourceMinProgressivePass, this.sourceMaxProgressivePass, i26, i27, i29, i30, this.destinationBands);
        PNGImageReader pNGImageReader2 = this;
        int i44 = i26;
        int i45 = i30;
        WritableRaster writableRasterCreateWritableChild2 = pNGImageReader2.sourceBands != null ? writableRasterCreateRaster.createWritableChild(0, 0, writableRasterCreateRaster.getWidth(), 1, 0, 0, pNGImageReader2.sourceBands) : writableRasterCreateRaster;
        if (pNGImageReader2.destinationBands != null) {
            i9 = i29;
            writableRasterCreateWritableChild = writableTile.createWritableChild(0, 0, writableTile.getWidth(), writableTile.getHeight(), 0, 0, pNGImageReader2.destinationBands);
        } else {
            i9 = i29;
            writableRasterCreateWritableChild = writableTile;
        }
        int[] sampleSize = writableRasterCreateWritableChild.getSampleModel().getSampleSize();
        int length = sampleSize.length;
        int i46 = 0;
        while (true) {
            if (i46 >= length) {
                z = false;
                break;
            } else {
                if (sampleSize[i46] != i31) {
                    z = true;
                    break;
                }
                i46++;
            }
        }
        if (z) {
            int i47 = 1 << i31;
            int i48 = i47 - 1;
            int i49 = i48 / 2;
            int[][] iArr5 = new int[length][];
            int i50 = 0;
            while (i50 < length) {
                int i51 = (1 << sampleSize[i50]) - 1;
                int[] iArr6 = sampleSize;
                iArr5[i50] = new int[i47];
                for (int i52 = 0; i52 <= i48; i52++) {
                    iArr5[i50][i52] = ((i52 * i51) + i49) / i48;
                }
                i50++;
                sampleSize = iArr6;
            }
            iArr2 = iArr5;
        } else {
            iArr2 = iArr;
        }
        boolean z2 = i39 == 1 && i9 == 1 && !z && (writableRasterCreateWritableChild instanceof ByteInterleavedRaster);
        if (z2) {
            i10 = iM3211u;
            writableRasterCreateWritableChild2 = writableRasterCreateWritableChild2.createWritableChild(i10, 0, i28, 1, 0, 0, null);
        } else {
            i10 = iM3211u;
        }
        int i53 = i28;
        WritableRaster writableRaster2 = writableRasterCreateWritableChild2;
        byte[] bArr8 = bArr5;
        byte[] bArr9 = bArr6;
        int i54 = 0;
        while (i54 < i8) {
            pNGImageReader2.updateImageProgress(i7);
            int i55 = pNGImageReader2.pixelStream.read();
            int i56 = i53;
            pNGImageReader2.pixelStream.readFully(bArr9, 0, i40);
            if (i55 == 0) {
                i11 = i54;
                i12 = i40;
                bArr = bArr8;
                i13 = i33;
                i14 = 0;
            } else if (i55 == 1) {
                i11 = i54;
                i12 = i40;
                bArr = bArr8;
                i13 = i33;
                i14 = 0;
                decodeSubFilter(bArr9, 0, i12, i13);
            } else if (i55 != 2) {
                if (i55 == 3) {
                    int i57 = i40;
                    decodeAverageFilter(bArr9, 0, bArr8, 0, i57, i33);
                    i11 = i54;
                    bArr = bArr8;
                    i12 = i57;
                    i13 = i33;
                    i15 = i9;
                } else {
                    if (i55 != 4) {
                        throw new IIOException(AbstractC0541b.m767i(i55, "Unknown row filter type (= ", ")!"));
                    }
                    int i58 = i40;
                    decodePaethFilter(bArr9, 0, bArr8, 0, i58, i33);
                    i11 = i54;
                    i15 = i9;
                    bArr = bArr8;
                    i12 = i58;
                    i13 = i33;
                }
                i14 = 0;
                if (i31 >= 16) {
                    bArr2 = bArr7;
                    System.arraycopy(bArr9, i14, bArr2, i14, i12);
                    i16 = i12;
                    i17 = i43;
                } else {
                    bArr2 = bArr7;
                    i16 = i12;
                    i17 = i43;
                    int i59 = 0;
                    for (int i60 = 0; i60 < i17; i60++) {
                        data[i60] = (short) ((bArr9[i59] << 8) | (bArr9[i59 + 1] & 255));
                        i59 += 2;
                    }
                }
                i18 = (i11 * i6) + i4;
                Rectangle rectangle = pNGImageReader2.sourceRegion;
                int i61 = i17;
                i19 = rectangle.f10095y;
                if (i18 >= i19 || i18 >= rectangle.height + i19) {
                    i20 = length;
                    bArr3 = bArr9;
                } else {
                    bArr3 = bArr9;
                    int i62 = pNGImageReader2.sourceYSubsampling;
                    if ((i18 - i19) % i62 == 0) {
                        int iM7d = AbstractC0000a.m7d(i18, i19, i62, pNGImageReader2.destinationOffset.f10093y);
                        int i63 = i41;
                        if (iM7d < i63) {
                            i20 = length;
                            i41 = i63;
                        } else {
                            int i64 = i42;
                            if (iM7d > i64) {
                                break;
                            }
                            if (!z2) {
                                int i65 = i44;
                                i25 = i65;
                                i41 = i63;
                                int i66 = i10;
                                while (true) {
                                    bArr4 = bArr2;
                                    iArr3 = iArr4;
                                    if (i65 >= i25 + i56) {
                                        break;
                                    }
                                    writableRaster2.getPixel(i66, 0, iArr3);
                                    if (z) {
                                        for (int i67 = 0; i67 < length; i67++) {
                                            iArr3[i67] = iArr2[i67][iArr3[i67]];
                                        }
                                    }
                                    writableRasterCreateWritableChild.setPixel(i65, iM7d, iArr3);
                                    i66 += i39;
                                    i65 += i15;
                                    iArr4 = iArr3;
                                    bArr2 = bArr4;
                                }
                            } else {
                                writableRasterCreateWritableChild.setRect(i44, iM7d, writableRaster2);
                                i25 = i44;
                                i41 = i63;
                                bArr4 = bArr2;
                                iArr3 = iArr4;
                            }
                            pNGImageReader = pNGImageReader2;
                            i20 = length;
                            i42 = i64;
                            i33 = i13;
                            i23 = i15;
                            i53 = i56;
                            int i68 = i45;
                            i21 = i11;
                            writableRaster = writableRaster2;
                            i24 = i25;
                            pNGImageReader.processImageUpdate(pNGImageReader2.theImage, i24, iM7d, i53, 1, i23, i68, pNGImageReader2.destinationBands);
                            i22 = i68;
                            if (pNGImageReader.abortRequested()) {
                                return;
                            }
                            i54 = i21 + 1;
                            pNGImageReader2 = pNGImageReader;
                            i44 = i24;
                            i45 = i22;
                            iArr4 = iArr3;
                            length = i20;
                            writableRaster2 = writableRaster;
                            bArr7 = bArr4;
                            i43 = i61;
                            i9 = i23;
                            bArr9 = bArr;
                            bArr8 = bArr3;
                            i40 = i16;
                        }
                    } else {
                        i20 = length;
                    }
                }
                i33 = i13;
                bArr4 = bArr2;
                i23 = i15;
                i53 = i56;
                iArr3 = iArr4;
                i22 = i45;
                i21 = i11;
                writableRaster = writableRaster2;
                i24 = i44;
                pNGImageReader = pNGImageReader2;
                i54 = i21 + 1;
                pNGImageReader2 = pNGImageReader;
                i44 = i24;
                i45 = i22;
                iArr4 = iArr3;
                length = i20;
                writableRaster2 = writableRaster;
                bArr7 = bArr4;
                i43 = i61;
                i9 = i23;
                bArr9 = bArr;
                bArr8 = bArr3;
                i40 = i16;
            } else {
                i11 = i54;
                i12 = i40;
                bArr = bArr8;
                i13 = i33;
                i14 = 0;
                decodeUpFilter(bArr9, 0, bArr, 0, i12);
            }
            i15 = i9;
            if (i31 >= 16) {
            }
            i18 = (i11 * i6) + i4;
            Rectangle rectangle2 = pNGImageReader2.sourceRegion;
            int i612 = i17;
            i19 = rectangle2.f10095y;
            if (i18 >= i19) {
                i20 = length;
                bArr3 = bArr9;
                i33 = i13;
                bArr4 = bArr2;
                i23 = i15;
                i53 = i56;
                iArr3 = iArr4;
                i22 = i45;
                i21 = i11;
                writableRaster = writableRaster2;
                i24 = i44;
                pNGImageReader = pNGImageReader2;
            }
            i54 = i21 + 1;
            pNGImageReader2 = pNGImageReader;
            i44 = i24;
            i45 = i22;
            iArr4 = iArr3;
            length = i20;
            writableRaster2 = writableRaster;
            bArr7 = bArr4;
            i43 = i612;
            i9 = i23;
            bArr9 = bArr;
            bArr8 = bArr3;
            i40 = i16;
        }
        PNGImageReader pNGImageReader3 = pNGImageReader2;
        pNGImageReader3.processPassComplete(pNGImageReader3.theImage);
    }

    private static void decodeSubFilter(byte[] bArr, int i, int i2, int i4) {
        for (int i5 = i4; i5 < i2; i5++) {
            int i6 = i5 + i;
            bArr[i6] = (byte) ((bArr[i6] & 255) + (bArr[i6 - i4] & 255));
        }
    }

    private static void decodeUpFilter(byte[] bArr, int i, byte[] bArr2, int i2, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 + i;
            bArr[i6] = (byte) ((bArr[i6] & 255) + (bArr2[i5 + i2] & 255));
        }
    }

    private static byte[] inflate(byte[] bArr) throws IOException {
        InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int i = inflaterInputStream.read();
                if (i == -1) {
                    inflaterInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(i);
            } catch (Throwable th) {
                inflaterInputStream.close();
                throw th;
            }
        }
    }

    private static int paethPredictor(int i, int i2, int i4) {
        int i5 = (i + i2) - i4;
        int iAbs = Math.abs(i5 - i);
        int iAbs2 = Math.abs(i5 - i2);
        int iAbs3 = Math.abs(i5 - i4);
        return (iAbs > iAbs2 || iAbs > iAbs3) ? iAbs2 <= iAbs3 ? i2 : i4 : i;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003d A[PHI: r3
      0x003d: PHI (r3v3 int) = (r3v1 int), (r3v2 int) binds: [B:20:0x003b, B:23:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parse_PLTE_chunk(int i) {
        PNGMetadata pNGMetadata = this.metadata;
        if (pNGMetadata.PLTE_present) {
            processWarningOccurred("A PNG image may not contain more than one PLTE chunk.\nThe chunk wil be ignored.");
            return;
        }
        int i2 = pNGMetadata.IHDR_colorType;
        if (i2 != 0) {
            int i4 = 4;
            if (i2 != 4) {
                byte[] bArr = new byte[i];
                this.stream.readFully(bArr);
                int iMin = i / 3;
                PNGMetadata pNGMetadata2 = this.metadata;
                if (pNGMetadata2.IHDR_colorType == 3) {
                    int i5 = 1 << pNGMetadata2.IHDR_bitDepth;
                    if (iMin > i5) {
                        processWarningOccurred("PLTE chunk contains too many entries for bit depth, ignoring extras.");
                        iMin = i5;
                    }
                    iMin = Math.min(iMin, i5);
                }
                int i6 = 16;
                if (iMin > 16) {
                    i4 = 256;
                } else if (iMin > 4) {
                    i4 = i6;
                } else {
                    i6 = 2;
                    if (iMin <= 2) {
                    }
                }
                PNGMetadata pNGMetadata3 = this.metadata;
                pNGMetadata3.PLTE_present = true;
                pNGMetadata3.PLTE_red = new byte[i4];
                pNGMetadata3.PLTE_green = new byte[i4];
                pNGMetadata3.PLTE_blue = new byte[i4];
                int i7 = 0;
                for (int i8 = 0; i8 < iMin; i8++) {
                    PNGMetadata pNGMetadata4 = this.metadata;
                    pNGMetadata4.PLTE_red[i8] = bArr[i7];
                    int i9 = i7 + 2;
                    pNGMetadata4.PLTE_green[i8] = bArr[i7 + 1];
                    i7 += 3;
                    pNGMetadata4.PLTE_blue[i8] = bArr[i9];
                }
                return;
            }
        }
        processWarningOccurred("A PNG gray or gray alpha image cannot have a PLTE chunk.\nThe chunk wil be ignored.");
    }

    private void parse_bKGD_chunk() {
        PNGMetadata pNGMetadata = this.metadata;
        int i = pNGMetadata.IHDR_colorType;
        if (i == 3) {
            pNGMetadata.bKGD_colorType = 3;
            pNGMetadata.bKGD_index = this.stream.readUnsignedByte();
        } else if (i == 0 || i == 4) {
            pNGMetadata.bKGD_colorType = 0;
            pNGMetadata.bKGD_gray = this.stream.readUnsignedShort();
        } else {
            pNGMetadata.bKGD_colorType = 2;
            pNGMetadata.bKGD_red = this.stream.readUnsignedShort();
            this.metadata.bKGD_green = this.stream.readUnsignedShort();
            this.metadata.bKGD_blue = this.stream.readUnsignedShort();
        }
        this.metadata.bKGD_present = true;
    }

    private void parse_cHRM_chunk() {
        this.metadata.cHRM_whitePointX = this.stream.readInt();
        this.metadata.cHRM_whitePointY = this.stream.readInt();
        this.metadata.cHRM_redX = this.stream.readInt();
        this.metadata.cHRM_redY = this.stream.readInt();
        this.metadata.cHRM_greenX = this.stream.readInt();
        this.metadata.cHRM_greenY = this.stream.readInt();
        this.metadata.cHRM_blueX = this.stream.readInt();
        this.metadata.cHRM_blueY = this.stream.readInt();
        this.metadata.cHRM_present = true;
    }

    private void parse_gAMA_chunk() {
        int i = this.stream.readInt();
        PNGMetadata pNGMetadata = this.metadata;
        pNGMetadata.gAMA_gamma = i;
        pNGMetadata.gAMA_present = true;
    }

    private void parse_hIST_chunk(int i) throws IIOException {
        PNGMetadata pNGMetadata = this.metadata;
        if (!pNGMetadata.PLTE_present) {
            throw new IIOException("hIST chunk without prior PLTE chunk!");
        }
        char[] cArr = new char[i / 2];
        pNGMetadata.hIST_histogram = cArr;
        this.stream.readFully(cArr, 0, cArr.length);
        this.metadata.hIST_present = true;
    }

    private void parse_iCCP_chunk(int i) throws EOFException {
        String nullTerminatedString = readNullTerminatedString("ISO-8859-1", 80);
        PNGMetadata pNGMetadata = this.metadata;
        pNGMetadata.iCCP_profileName = nullTerminatedString;
        pNGMetadata.iCCP_compressionMethod = this.stream.readUnsignedByte();
        byte[] bArr = new byte[(i - nullTerminatedString.length()) - 2];
        this.stream.readFully(bArr);
        PNGMetadata pNGMetadata2 = this.metadata;
        pNGMetadata2.iCCP_compressedProfile = bArr;
        pNGMetadata2.iCCP_present = true;
    }

    private void parse_iTXt_chunk(int i) {
        long streamPosition = this.stream.getStreamPosition();
        this.metadata.iTXt_keyword.add(readNullTerminatedString("ISO-8859-1", 80));
        int unsignedByte = this.stream.readUnsignedByte();
        this.metadata.iTXt_compressionFlag.add(Boolean.valueOf(unsignedByte == 1));
        this.metadata.iTXt_compressionMethod.add(Integer.valueOf(this.stream.readUnsignedByte()));
        this.metadata.iTXt_languageTag.add(readNullTerminatedString(InternalZipConstants.CHARSET_UTF8, 80));
        long j = streamPosition + ((long) i);
        this.metadata.iTXt_translatedKeyword.add(readNullTerminatedString(InternalZipConstants.CHARSET_UTF8, (int) (j - this.stream.getStreamPosition())));
        byte[] bArr = new byte[(int) (j - this.stream.getStreamPosition())];
        this.stream.readFully(bArr);
        this.metadata.iTXt_text.add(unsignedByte == 1 ? new String(inflate(bArr), InternalZipConstants.CHARSET_UTF8) : new String(bArr, InternalZipConstants.CHARSET_UTF8));
    }

    private void parse_pHYs_chunk() {
        this.metadata.pHYs_pixelsPerUnitXAxis = this.stream.readInt();
        this.metadata.pHYs_pixelsPerUnitYAxis = this.stream.readInt();
        this.metadata.pHYs_unitSpecifier = this.stream.readUnsignedByte();
        this.metadata.pHYs_present = true;
    }

    private void parse_sBIT_chunk() {
        PNGMetadata pNGMetadata = this.metadata;
        int i = pNGMetadata.IHDR_colorType;
        if (i == 0 || i == 4) {
            pNGMetadata.sBIT_grayBits = this.stream.readUnsignedByte();
        } else if (i == 2 || i == 3 || i == 6) {
            pNGMetadata.sBIT_redBits = this.stream.readUnsignedByte();
            this.metadata.sBIT_greenBits = this.stream.readUnsignedByte();
            this.metadata.sBIT_blueBits = this.stream.readUnsignedByte();
        }
        if (i == 4 || i == 6) {
            this.metadata.sBIT_alphaBits = this.stream.readUnsignedByte();
        }
        PNGMetadata pNGMetadata2 = this.metadata;
        pNGMetadata2.sBIT_colorType = i;
        pNGMetadata2.sBIT_present = true;
    }

    private void parse_sPLT_chunk(int i) throws IIOException {
        this.metadata.sPLT_paletteName = readNullTerminatedString("ISO-8859-1", 80);
        int length = i - (this.metadata.sPLT_paletteName.length() + 1);
        int unsignedByte = this.stream.readUnsignedByte();
        PNGMetadata pNGMetadata = this.metadata;
        pNGMetadata.sPLT_sampleDepth = unsignedByte;
        int i2 = length / (((unsignedByte / 8) * 4) + 2);
        pNGMetadata.sPLT_red = new int[i2];
        pNGMetadata.sPLT_green = new int[i2];
        pNGMetadata.sPLT_blue = new int[i2];
        pNGMetadata.sPLT_alpha = new int[i2];
        pNGMetadata.sPLT_frequency = new int[i2];
        int i4 = 0;
        if (unsignedByte == 8) {
            while (i4 < i2) {
                this.metadata.sPLT_red[i4] = this.stream.readUnsignedByte();
                this.metadata.sPLT_green[i4] = this.stream.readUnsignedByte();
                this.metadata.sPLT_blue[i4] = this.stream.readUnsignedByte();
                this.metadata.sPLT_alpha[i4] = this.stream.readUnsignedByte();
                this.metadata.sPLT_frequency[i4] = this.stream.readUnsignedShort();
                i4++;
            }
        } else {
            if (unsignedByte != 16) {
                throw new IIOException("sPLT sample depth not 8 or 16!");
            }
            while (i4 < i2) {
                this.metadata.sPLT_red[i4] = this.stream.readUnsignedShort();
                this.metadata.sPLT_green[i4] = this.stream.readUnsignedShort();
                this.metadata.sPLT_blue[i4] = this.stream.readUnsignedShort();
                this.metadata.sPLT_alpha[i4] = this.stream.readUnsignedShort();
                this.metadata.sPLT_frequency[i4] = this.stream.readUnsignedShort();
                i4++;
            }
        }
        this.metadata.sPLT_present = true;
    }

    private void parse_sRGB_chunk() {
        this.metadata.sRGB_renderingIntent = this.stream.readUnsignedByte();
        this.metadata.sRGB_present = true;
    }

    private void parse_tEXt_chunk(int i) throws EOFException {
        this.metadata.tEXt_keyword.add(readNullTerminatedString("ISO-8859-1", 80));
        byte[] bArr = new byte[(i - r0.length()) - 1];
        this.stream.readFully(bArr);
        this.metadata.tEXt_text.add(new String(bArr, "ISO-8859-1"));
    }

    private void parse_tIME_chunk() {
        this.metadata.tIME_year = this.stream.readUnsignedShort();
        this.metadata.tIME_month = this.stream.readUnsignedByte();
        this.metadata.tIME_day = this.stream.readUnsignedByte();
        this.metadata.tIME_hour = this.stream.readUnsignedByte();
        this.metadata.tIME_minute = this.stream.readUnsignedByte();
        this.metadata.tIME_second = this.stream.readUnsignedByte();
        this.metadata.tIME_present = true;
    }

    private void parse_tRNS_chunk(int i) {
        PNGMetadata pNGMetadata = this.metadata;
        int i2 = pNGMetadata.IHDR_colorType;
        if (i2 == 3) {
            if (!pNGMetadata.PLTE_present) {
                processWarningOccurred("tRNS chunk without prior PLTE chunk, ignoring it.");
                return;
            }
            int length = pNGMetadata.PLTE_red.length;
            if (i > length) {
                processWarningOccurred("tRNS chunk has more entries than prior PLTE chunk, ignoring extras.");
            } else {
                length = i;
            }
            PNGMetadata pNGMetadata2 = this.metadata;
            byte[] bArr = new byte[length];
            pNGMetadata2.tRNS_alpha = bArr;
            pNGMetadata2.tRNS_colorType = 3;
            this.stream.read(bArr, 0, length);
            this.stream.skipBytes(i - length);
        } else if (i2 == 0) {
            if (i != 2) {
                processWarningOccurred("tRNS chunk for gray image must have length 2, ignoring chunk.");
                this.stream.skipBytes(i);
                return;
            } else {
                pNGMetadata.tRNS_gray = this.stream.readUnsignedShort();
                this.metadata.tRNS_colorType = 0;
            }
        } else {
            if (i2 != 2) {
                processWarningOccurred("Gray+Alpha and RGBS images may not have a tRNS chunk, ignoring it.");
                return;
            }
            if (i != 6) {
                processWarningOccurred("tRNS chunk for RGB image must have length 6, ignoring chunk.");
                this.stream.skipBytes(i);
                return;
            }
            pNGMetadata.tRNS_red = this.stream.readUnsignedShort();
            this.metadata.tRNS_green = this.stream.readUnsignedShort();
            this.metadata.tRNS_blue = this.stream.readUnsignedShort();
            this.metadata.tRNS_colorType = 2;
        }
        this.metadata.tRNS_present = true;
    }

    private void parse_zTXt_chunk(int i) throws EOFException {
        this.metadata.zTXt_keyword.add(readNullTerminatedString("ISO-8859-1", 80));
        this.metadata.zTXt_compressionMethod.add(new Integer(this.stream.readUnsignedByte()));
        byte[] bArr = new byte[(i - r0.length()) - 2];
        this.stream.readFully(bArr);
        this.metadata.zTXt_text.add(new String(inflate(bArr), "ISO-8859-1"));
    }

    private void readHeader() throws IIOException {
        if (this.gotHeader) {
            return;
        }
        ImageInputStream imageInputStream = this.stream;
        if (imageInputStream == null) {
            throw new IllegalStateException("Input source not set!");
        }
        try {
            byte[] bArr = new byte[8];
            imageInputStream.readFully(bArr);
            if (bArr[0] != -119 || bArr[1] != 80 || bArr[2] != 78 || bArr[3] != 71 || bArr[4] != 13 || bArr[5] != 10 || bArr[6] != 26 || bArr[7] != 10) {
                throw new IIOException("Bad PNG signature!");
            }
            if (this.stream.readInt() != 13) {
                throw new IIOException("Bad length for IHDR chunk!");
            }
            if (this.stream.readInt() != IHDR_TYPE) {
                throw new IIOException("Bad type for IHDR chunk!");
            }
            this.metadata = new PNGMetadata();
            int i = this.stream.readInt();
            int i2 = this.stream.readInt();
            this.stream.readFully(bArr, 0, 5);
            int i4 = bArr[0] & 255;
            int i5 = bArr[1] & 255;
            int i6 = bArr[2] & 255;
            int i7 = bArr[3] & 255;
            int i8 = bArr[4] & 255;
            this.stream.skipBytes(4);
            ImageInputStream imageInputStream2 = this.stream;
            imageInputStream2.flushBefore(imageInputStream2.getStreamPosition());
            if (i == 0) {
                throw new IIOException("Image width == 0!");
            }
            if (i2 == 0) {
                throw new IIOException("Image height == 0!");
            }
            if (i4 != 1 && i4 != 2 && i4 != 4 && i4 != 8 && i4 != 16) {
                throw new IIOException("Bit depth must be 1, 2, 4, 8, or 16!");
            }
            if (i5 != 0 && i5 != 2 && i5 != 3 && i5 != 4 && i5 != 6) {
                throw new IIOException("Color type must be 0, 2, 3, 4, or 6!");
            }
            if (i5 == 3 && i4 == 16) {
                throw new IIOException("Bad color type/bit depth combination!");
            }
            if ((i5 == 2 || i5 == 6 || i5 == 4) && i4 != 8 && i4 != 16) {
                throw new IIOException("Bad color type/bit depth combination!");
            }
            if (i6 != 0) {
                throw new IIOException("Unknown compression method (not 0)!");
            }
            if (i7 != 0) {
                throw new IIOException("Unknown filter method (not 0)!");
            }
            if (i8 != 0 && i8 != 1) {
                throw new IIOException("Unknown interlace method (not 0 or 1)!");
            }
            PNGMetadata pNGMetadata = this.metadata;
            pNGMetadata.IHDR_present = true;
            pNGMetadata.IHDR_width = i;
            pNGMetadata.IHDR_height = i2;
            pNGMetadata.IHDR_bitDepth = i4;
            pNGMetadata.IHDR_colorType = i5;
            pNGMetadata.IHDR_compressionMethod = i6;
            pNGMetadata.IHDR_filterMethod = i7;
            pNGMetadata.IHDR_interlaceMethod = i8;
            this.gotHeader = true;
        } catch (IOException e) {
            throw new IIOException("I/O error reading PNG header!", e);
        }
    }

    private void readImage(ImageReadParam imageReadParam) throws Throwable {
        Throwable th;
        IOException iOException;
        SequenceInputStream sequenceInputStream;
        Inflater inflater;
        readMetadata();
        PNGMetadata pNGMetadata = this.metadata;
        int i = pNGMetadata.IHDR_width;
        int i2 = pNGMetadata.IHDR_height;
        this.sourceXSubsampling = 1;
        this.sourceYSubsampling = 1;
        this.sourceMinProgressivePass = 0;
        this.sourceMaxProgressivePass = 6;
        Inflater inflater2 = null;
        this.sourceBands = null;
        this.destinationBands = null;
        this.destinationOffset = new Point(0, 0);
        if (imageReadParam != null) {
            this.sourceXSubsampling = imageReadParam.getSourceXSubsampling();
            this.sourceYSubsampling = imageReadParam.getSourceYSubsampling();
            this.sourceMinProgressivePass = Math.max(imageReadParam.getSourceMinProgressivePass(), 0);
            this.sourceMaxProgressivePass = Math.min(imageReadParam.getSourceMaxProgressivePass(), 6);
            this.sourceBands = imageReadParam.getSourceBands();
            this.destinationBands = imageReadParam.getDestinationBands();
            this.destinationOffset = imageReadParam.getDestinationOffset();
        }
        try {
            try {
                this.stream.seek(this.imageStartPosition);
                sequenceInputStream = new SequenceInputStream(new PNGImageDataEnumeration(this.stream));
                inflater = new Inflater();
            } catch (IOException e) {
                iOException = e;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.pixelStream = new DataInputStream(new BufferedInputStream(new InflaterInputStream(sequenceInputStream, inflater)));
            this.theImage = ImageReader.getDestination(imageReadParam, getImageTypes(0), i, i2);
            Rectangle rectangle = new Rectangle(0, 0, 0, 0);
            Rectangle rectangle2 = new Rectangle(0, 0, 0, 0);
            this.sourceRegion = rectangle2;
            ImageReader.computeRegions(imageReadParam, i, i2, this.theImage, rectangle2, rectangle);
            this.destinationOffset.setLocation(rectangle.getLocation());
            ImageReader.checkReadParamBandSettings(imageReadParam, inputBandsForColorType[this.metadata.IHDR_colorType], this.theImage.getSampleModel().getNumBands());
            processImageStarted(0);
            decodeImage();
            if (abortRequested()) {
                processReadAborted();
            } else {
                processImageComplete();
            }
            inflater.end();
        } catch (IOException e2) {
            iOException = e2;
            inflater2 = inflater;
            throw new IIOException("Error reading PNG image data", iOException);
        } catch (Throwable th3) {
            th = th3;
            inflater2 = inflater;
            if (inflater2 == null) {
                throw th;
            }
            inflater2.end();
            throw th;
        }
    }

    private void readMetadata() throws IIOException {
        if (this.gotMetadata) {
            return;
        }
        readHeader();
        int i = this.metadata.IHDR_colorType;
        if (!this.ignoreMetadata || i == 3) {
            while (true) {
                try {
                    int i2 = this.stream.readInt();
                    int i4 = this.stream.readInt();
                    if (i2 < 0) {
                        throw new IIOException("Invalid chunk lenght " + i2);
                    }
                    try {
                        this.stream.mark();
                        ImageInputStream imageInputStream = this.stream;
                        imageInputStream.seek(imageInputStream.getStreamPosition() + ((long) i2));
                        int i5 = this.stream.readInt();
                        this.stream.reset();
                        switch (i4) {
                            case IDAT_TYPE /* 1229209940 */:
                                this.stream.skipBytes(-8);
                                this.imageStartPosition = this.stream.getStreamPosition();
                                this.gotMetadata = true;
                                return;
                            case PLTE_TYPE /* 1347179589 */:
                                parse_PLTE_chunk(i2);
                                break;
                            case bKGD_TYPE /* 1649100612 */:
                                parse_bKGD_chunk();
                                break;
                            case cHRM_TYPE /* 1665684045 */:
                                parse_cHRM_chunk();
                                break;
                            case gAMA_TYPE /* 1732332865 */:
                                parse_gAMA_chunk();
                                break;
                            case hIST_TYPE /* 1749635924 */:
                                parse_hIST_chunk(i2);
                                break;
                            case iCCP_TYPE /* 1766015824 */:
                                parse_iCCP_chunk(i2);
                                break;
                            case iTXt_TYPE /* 1767135348 */:
                                if (!this.ignoreMetadata) {
                                    parse_iTXt_chunk(i2);
                                } else {
                                    this.stream.skipBytes(i2);
                                }
                                break;
                            case pHYs_TYPE /* 1883789683 */:
                                parse_pHYs_chunk();
                                break;
                            case sBIT_TYPE /* 1933723988 */:
                                parse_sBIT_chunk();
                                break;
                            case sPLT_TYPE /* 1934642260 */:
                                parse_sPLT_chunk(i2);
                                break;
                            case sRGB_TYPE /* 1934772034 */:
                                parse_sRGB_chunk();
                                break;
                            case tEXt_TYPE /* 1950701684 */:
                                parse_tEXt_chunk(i2);
                                break;
                            case tIME_TYPE /* 1950960965 */:
                                parse_tIME_chunk();
                                break;
                            case tRNS_TYPE /* 1951551059 */:
                                parse_tRNS_chunk(i2);
                                break;
                            case zTXt_TYPE /* 2052348020 */:
                                if (!this.ignoreMetadata) {
                                    parse_zTXt_chunk(i2);
                                } else {
                                    this.stream.skipBytes(i2);
                                }
                                break;
                            default:
                                byte[] bArr = new byte[i2];
                                this.stream.readFully(bArr);
                                StringBuilder sb = new StringBuilder(4);
                                sb.append((char) (i4 >>> 24));
                                sb.append((char) ((i4 >> 16) & 255));
                                sb.append((char) ((i4 >> 8) & 255));
                                sb.append((char) (i4 & 255));
                                if ((i4 >>> 28) == 0) {
                                    processWarningOccurred("Encountered unknown chunk with critical bit set!");
                                }
                                this.metadata.unknownChunkType.add(sb.toString());
                                this.metadata.unknownChunkData.add(bArr);
                                break;
                        }
                        if (i5 != this.stream.readInt()) {
                            throw new IIOException("Failed to read a chunk of type " + i4);
                        }
                        ImageInputStream imageInputStream2 = this.stream;
                        imageInputStream2.flushBefore(imageInputStream2.getStreamPosition());
                    } catch (IOException unused) {
                        throw new IIOException("Invalid chunk length " + i2);
                    }
                } catch (IOException e) {
                    throw new IIOException("Error reading PNG metadata", e);
                }
            }
        } else {
            while (true) {
                try {
                    int i6 = this.stream.readInt();
                    if (this.stream.readInt() == IDAT_TYPE) {
                        this.stream.skipBytes(-8);
                        this.imageStartPosition = this.stream.getStreamPosition();
                        this.gotMetadata = true;
                        return;
                    }
                    this.stream.skipBytes(i6 + 4);
                } catch (IOException e2) {
                    throw new IIOException("Error skipping PNG metadata", e2);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        return new java.lang.String(r0.toByteArray(), r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String readNullTerminatedString(String str, int i) throws EOFException {
        int i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            if (i <= i4 || (i2 = this.stream.read()) == 0) {
                break;
            }
            if (i2 == -1) {
                throw new EOFException();
            }
            byteArrayOutputStream.write(i2);
            i4 = i5;
        }
    }

    private void resetStreamSettings() {
        this.gotHeader = false;
        this.gotMetadata = false;
        this.metadata = null;
        this.pixelStream = null;
    }

    private void skipPass(int i, int i2) throws IOException {
        if (i == 0 || i2 == 0) {
            return;
        }
        int[] iArr = inputBandsForColorType;
        PNGMetadata pNGMetadata = this.metadata;
        int i4 = (((iArr[pNGMetadata.IHDR_colorType] * i) * pNGMetadata.IHDR_bitDepth) + 7) / 8;
        for (int i5 = 0; i5 < i2; i5++) {
            this.pixelStream.skipBytes(i4 + 1);
            if (abortRequested()) {
                return;
            }
        }
    }

    private void updateImageProgress(int i) {
        int i2 = this.pixelsDone + i;
        this.pixelsDone = i2;
        processImageProgress((i2 * 100.0f) / this.totalPixels);
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public ImageReadParam getDefaultReadParam() {
        return new ImageReadParam();
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getHeight(int i) throws IIOException {
        if (i != 0) {
            throw new IndexOutOfBoundsException("imageIndex != 0!");
        }
        readHeader();
        return this.metadata.IHDR_height;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public IIOMetadata getImageMetadata(int i) throws IIOException {
        if (i != 0) {
            throw new IndexOutOfBoundsException("imageIndex != 0!");
        }
        readMetadata();
        return this.metadata;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public Iterator<ImageTypeSpecifier> getImageTypes(int i) throws IIOException {
        byte[] bArrCopyOf;
        if (i != 0) {
            throw new IndexOutOfBoundsException("imageIndex != 0!");
        }
        readHeader();
        ArrayList arrayList = new ArrayList(1);
        PNGMetadata pNGMetadata = this.metadata;
        int i2 = pNGMetadata.IHDR_bitDepth;
        int i4 = pNGMetadata.IHDR_colorType;
        int i5 = i2 <= 8 ? 0 : 1;
        if (i4 == 0) {
            arrayList.add(ImageTypeSpecifier.createGrayscale(i2, i5, false));
        } else if (i4 == 6) {
            if (i2 == 8) {
                arrayList.add(ImageTypeSpecifier.createFromBufferedImageType(6));
                arrayList.add(ImageTypeSpecifier.createFromBufferedImageType(2));
            }
            arrayList.add(ImageTypeSpecifier.createInterleaved(ColorSpace.getInstance(1000), new int[]{0, 1, 2, 3}, i5, true, false));
        } else if (i4 == 2) {
            if (i2 == 8) {
                arrayList.add(ImageTypeSpecifier.createFromBufferedImageType(5));
                arrayList.add(ImageTypeSpecifier.createFromBufferedImageType(1));
                arrayList.add(ImageTypeSpecifier.createFromBufferedImageType(4));
            }
            arrayList.add(ImageTypeSpecifier.createInterleaved(ColorSpace.getInstance(1000), new int[]{0, 1, 2}, i5, false, false));
        } else if (i4 == 3) {
            readMetadata();
            int i6 = 1 << i2;
            PNGMetadata pNGMetadata2 = this.metadata;
            byte[] bArrCopyOf2 = pNGMetadata2.PLTE_red;
            byte[] bArrCopyOf3 = pNGMetadata2.PLTE_green;
            byte[] bArrCopyOf4 = pNGMetadata2.PLTE_blue;
            if (bArrCopyOf2.length < i6) {
                bArrCopyOf2 = Arrays.copyOf(bArrCopyOf2, i6);
                byte[] bArr = this.metadata.PLTE_red;
                Arrays.fill(bArrCopyOf2, bArr.length, i6, bArr[bArr.length - 1]);
                bArrCopyOf3 = Arrays.copyOf(this.metadata.PLTE_green, i6);
                byte[] bArr2 = this.metadata.PLTE_green;
                Arrays.fill(bArrCopyOf3, bArr2.length, i6, bArr2[bArr2.length - 1]);
                bArrCopyOf4 = Arrays.copyOf(this.metadata.PLTE_blue, i6);
                byte[] bArr3 = this.metadata.PLTE_blue;
                Arrays.fill(bArrCopyOf4, bArr3.length, i6, bArr3[bArr3.length - 1]);
            }
            byte[] bArr4 = bArrCopyOf3;
            byte[] bArr5 = bArrCopyOf4;
            byte[] bArr6 = bArrCopyOf2;
            PNGMetadata pNGMetadata3 = this.metadata;
            if (!pNGMetadata3.tRNS_present || (bArrCopyOf = pNGMetadata3.tRNS_alpha) == null) {
                bArrCopyOf = null;
            } else if (bArrCopyOf.length != bArr6.length) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArr6.length);
                Arrays.fill(bArrCopyOf, this.metadata.tRNS_alpha.length, bArr6.length, (byte) -1);
            }
            arrayList.add(ImageTypeSpecifier.createIndexed(bArr6, bArr4, bArr5, bArrCopyOf, i2, 0));
        } else if (i4 == 4) {
            arrayList.add(ImageTypeSpecifier.createInterleaved(ColorSpace.getInstance(1003), new int[]{0, 1}, i5, true, false));
        }
        return arrayList.iterator();
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getNumImages(boolean z) {
        if (this.stream == null) {
            throw new IllegalStateException("No input source set!");
        }
        if (this.seekForwardOnly && z) {
            throw new IllegalStateException("seekForwardOnly and allowSearch can't both be true!");
        }
        return 1;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public ImageTypeSpecifier getRawImageType(int i) throws IIOException {
        ImageTypeSpecifier next;
        Iterator<ImageTypeSpecifier> imageTypes = getImageTypes(i);
        do {
            next = imageTypes.next();
        } while (imageTypes.hasNext());
        return next;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public IIOMetadata getStreamMetadata() {
        return null;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getWidth(int i) throws IIOException {
        if (i != 0) {
            throw new IndexOutOfBoundsException("imageIndex != 0!");
        }
        readHeader();
        return this.metadata.IHDR_width;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public BufferedImage read(int i, ImageReadParam imageReadParam) throws Throwable {
        if (i != 0) {
            throw new IndexOutOfBoundsException("imageIndex != 0!");
        }
        readImage(imageReadParam);
        return this.theImage;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public void reset() {
        super.reset();
        resetStreamSettings();
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public void setInput(Object obj, boolean z, boolean z2) {
        super.setInput(obj, z, z2);
        this.stream = (ImageInputStream) obj;
        resetStreamSettings();
    }
}
