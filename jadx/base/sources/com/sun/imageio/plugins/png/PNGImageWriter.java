package com.sun.imageio.plugins.png;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.zip.DeflaterOutputStream;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.image.IndexColorModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RenderedImage;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.java.awt.image.WritableRaster;
import org.apache.poi.javax.imageio.IIOException;
import org.apache.poi.javax.imageio.IIOImage;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.ImageWriteParam;
import org.apache.poi.javax.imageio.ImageWriter;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.spi.ImageWriterSpi;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PNGImageWriter extends ImageWriter {
    private static int[] allowedProgressivePasses = {1, 7};
    int bpp;
    byte[] currRow;
    byte[][] filteredRows;
    PNGMetadata metadata;
    int numBands;
    int periodX;
    int periodY;
    int pixelsDone;
    byte[] prevRow;
    RowFilter rowFilter;
    int[] sampleSize;
    byte[][] scale;
    byte[] scale0;
    byte[][] scaleh;
    byte[][] scalel;
    int scalingBitDepth;
    int[] sourceBands;
    int sourceHeight;
    int sourceWidth;
    int sourceXOffset;
    int sourceYOffset;
    ImageOutputStream stream;
    int totalPixels;

    public PNGImageWriter(ImageWriterSpi imageWriterSpi) {
        super(imageWriterSpi);
        this.stream = null;
        this.metadata = null;
        this.sourceXOffset = 0;
        this.sourceYOffset = 0;
        this.sourceWidth = 0;
        this.sourceHeight = 0;
        this.sourceBands = null;
        this.periodX = 1;
        this.periodY = 1;
        this.rowFilter = new RowFilter();
        this.prevRow = null;
        this.currRow = null;
        this.filteredRows = null;
        this.sampleSize = null;
        this.scalingBitDepth = -1;
        this.scale = null;
        this.scale0 = null;
        this.scaleh = null;
        this.scalel = null;
    }

    private static int chunkType(String str) {
        return str.charAt(3) | (str.charAt(0) << 24) | (str.charAt(1) << 16) | (str.charAt(2) << '\b');
    }

    private byte[] deflate(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        deflaterOutputStream.write(bArr);
        deflaterOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x026b A[LOOP:0: B:19:0x0098->B:87:0x026b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x027f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void encodePass(ImageOutputStream imageOutputStream, RenderedImage renderedImage, int i, int i2, int i4, int i5) {
        IndexColorModel indexColorModel;
        int i6;
        IndexColorModel indexColorModel2;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        IndexColorModel indexColorModel3;
        int i12 = this.sourceXOffset;
        int i13 = this.sourceYOffset;
        int i14 = this.sourceWidth;
        int i15 = this.sourceHeight;
        int i16 = this.periodX;
        int i17 = i * i16;
        int i18 = i16 * i4;
        int i19 = this.periodY;
        int i20 = i2 * i19;
        int i21 = i5 * i19;
        int i22 = (((i14 - i17) + i18) - 1) / i18;
        int i23 = (((i15 - i20) + i21) - 1) / i21;
        if (i22 == 0 || i23 == 0) {
            return;
        }
        int i24 = this.numBands;
        int i25 = i17 * i24;
        int i26 = i18 * i24;
        PNGMetadata pNGMetadata = this.metadata;
        int i27 = pNGMetadata.IHDR_bitDepth;
        int i28 = 8 / i27;
        int i29 = i14 * i24;
        int[] iArr = new int[i29];
        int i30 = i29;
        int iM3211u = i22 * i24;
        if (i27 < 8) {
            iM3211u = AbstractC4539a.m3211u(iM3211u, i28, 1, i28);
        } else if (i27 == 16) {
            iM3211u *= 2;
        }
        if (pNGMetadata.IHDR_colorType == 4 && (renderedImage.getColorModel() instanceof IndexColorModel)) {
            iM3211u *= 2;
            indexColorModel = (IndexColorModel) renderedImage.getColorModel();
        } else {
            indexColorModel = null;
        }
        int i31 = iM3211u;
        int i32 = this.bpp;
        this.currRow = new byte[i31 + i32];
        this.prevRow = new byte[i31 + i32];
        this.filteredRows = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 5, i31 + i32);
        int i33 = this.metadata.IHDR_bitDepth;
        int i34 = i13 + i20;
        while (i34 < i13 + i15) {
            Raster data = renderedImage.getData(new Rectangle(i12, i34, i14, 1));
            int i35 = i28;
            int[] iArr2 = this.sourceBands;
            if (iArr2 != null) {
                int i36 = i33;
                i8 = i34;
                i6 = i30;
                i9 = i35;
                i7 = i36;
                indexColorModel2 = indexColorModel;
                z = false;
                data = data.createChild(i12, i8, i14, 1, i12, i8, iArr2);
            } else {
                i6 = i30;
                indexColorModel2 = indexColorModel;
                i7 = i33;
                i8 = i34;
                i9 = i35;
                z = false;
            }
            Raster raster = data;
            int[] iArr3 = iArr;
            raster.getPixels(i12, i8, i14, 1, iArr3);
            if (renderedImage.getColorModel().isAlphaPremultiplied()) {
                WritableRaster writableRasterCreateCompatibleWritableRaster = raster.createCompatibleWritableRaster();
                writableRasterCreateCompatibleWritableRaster.setPixels(writableRasterCreateCompatibleWritableRaster.getMinX(), writableRasterCreateCompatibleWritableRaster.getMinY(), writableRasterCreateCompatibleWritableRaster.getWidth(), writableRasterCreateCompatibleWritableRaster.getHeight(), iArr3);
                renderedImage.getColorModel().coerceData(writableRasterCreateCompatibleWritableRaster, z);
                writableRasterCreateCompatibleWritableRaster.getPixels(writableRasterCreateCompatibleWritableRaster.getMinX(), writableRasterCreateCompatibleWritableRaster.getMinY(), writableRasterCreateCompatibleWritableRaster.getWidth(), writableRasterCreateCompatibleWritableRaster.getHeight(), iArr3);
            }
            int[] iArr4 = this.metadata.PLTE_order;
            if (iArr4 != null) {
                i10 = i6;
                for (int i37 = z; i37 < i10; i37++) {
                    iArr3[i37] = iArr4[iArr3[i37]];
                }
            } else {
                i10 = i6;
            }
            int i38 = this.bpp;
            int i39 = i7;
            if (i39 == 1 || i39 == 2 || i39 == 4) {
                i11 = i12;
                indexColorModel3 = indexColorModel2;
                int i40 = 8;
                int i41 = i9 - 1;
                int i42 = 0;
                int i43 = 0;
                for (int i44 = i25; i44 < i10; i44 += i26) {
                    int i45 = i38;
                    int i46 = this.scale0[iArr3[i44]] | (i43 << i39);
                    int i47 = i42 + 1;
                    if ((i42 & i41) == i41) {
                        this.currRow[i45] = (byte) i46;
                        i38 = i45 + 1;
                        i42 = 0;
                        i43 = 0;
                    } else {
                        i42 = i47;
                        i43 = i46;
                        i38 = i45;
                    }
                }
                int i48 = i38;
                if ((i42 & i41) != 0) {
                    this.currRow[i48] = (byte) (i43 << (((i40 / i39) - i42) * i39));
                }
                int iFilterRow = this.rowFilter.filterRow(this.metadata.IHDR_colorType, this.currRow, this.prevRow, this.filteredRows, i31, this.bpp);
                int i49 = i31;
                imageOutputStream.write(iFilterRow);
                imageOutputStream.write(this.filteredRows[iFilterRow], this.bpp, i49);
                byte[] bArr = this.currRow;
                this.currRow = this.prevRow;
                this.prevRow = bArr;
                int i50 = this.pixelsDone + i22;
                this.pixelsDone = i50;
                processImageProgress((i50 * 100.0f) / this.totalPixels);
                if (!abortRequested()) {
                    return;
                }
                int i51 = i8 + i21;
                i33 = i39;
                i30 = i10;
                i31 = i49;
                iArr = iArr3;
                i28 = i9;
                i34 = i51;
                indexColorModel = indexColorModel3;
                i12 = i11;
            } else {
                char c = '\b';
                if (i39 != 8) {
                    if (i39 != 16) {
                        i11 = i12;
                        indexColorModel3 = indexColorModel2;
                        int iFilterRow2 = this.rowFilter.filterRow(this.metadata.IHDR_colorType, this.currRow, this.prevRow, this.filteredRows, i31, this.bpp);
                        int i492 = i31;
                        imageOutputStream.write(iFilterRow2);
                        imageOutputStream.write(this.filteredRows[iFilterRow2], this.bpp, i492);
                        byte[] bArr2 = this.currRow;
                        this.currRow = this.prevRow;
                        this.prevRow = bArr2;
                        int i502 = this.pixelsDone + i22;
                        this.pixelsDone = i502;
                        processImageProgress((i502 * 100.0f) / this.totalPixels);
                        if (!abortRequested()) {
                        }
                    } else {
                        int i52 = i25;
                        while (i52 < i10) {
                            int i53 = z;
                            while (i53 < this.numBands) {
                                byte[] bArr3 = this.currRow;
                                int i54 = i38 + 1;
                                char c2 = c;
                                byte[] bArr4 = this.scaleh[i53];
                                int i55 = iArr3[i52 + i53];
                                bArr3[i38] = bArr4[i55];
                                i38 += 2;
                                bArr3[i54] = this.scalel[i53][i55];
                                i53++;
                                c = c2;
                            }
                            i52 += i26;
                            z = false;
                        }
                    }
                } else if (this.numBands == 1) {
                    int i56 = i25;
                    while (i56 < i10) {
                        byte[] bArr5 = this.currRow;
                        int i57 = i38 + 1;
                        byte[] bArr6 = this.scale0;
                        int i58 = i38;
                        int i59 = iArr3[i56];
                        bArr5[i58] = bArr6[i59];
                        int i60 = i12;
                        IndexColorModel indexColorModel4 = indexColorModel2;
                        if (indexColorModel4 != null) {
                            bArr5[i57] = bArr6[indexColorModel4.getAlpha(i59 & 255)];
                            i38 = i58 + 2;
                        } else {
                            i38 = i57;
                        }
                        i56 += i26;
                        indexColorModel2 = indexColorModel4;
                        i12 = i60;
                    }
                } else {
                    i11 = i12;
                    indexColorModel3 = indexColorModel2;
                    for (int i61 = i25; i61 < i10; i61 += i26) {
                        int i62 = 0;
                        while (i62 < this.numBands) {
                            this.currRow[i38] = this.scale[i62][iArr3[i61 + i62]];
                            i62++;
                            i38++;
                        }
                    }
                    int iFilterRow22 = this.rowFilter.filterRow(this.metadata.IHDR_colorType, this.currRow, this.prevRow, this.filteredRows, i31, this.bpp);
                    int i4922 = i31;
                    imageOutputStream.write(iFilterRow22);
                    imageOutputStream.write(this.filteredRows[iFilterRow22], this.bpp, i4922);
                    byte[] bArr22 = this.currRow;
                    this.currRow = this.prevRow;
                    this.prevRow = bArr22;
                    int i5022 = this.pixelsDone + i22;
                    this.pixelsDone = i5022;
                    processImageProgress((i5022 * 100.0f) / this.totalPixels);
                    if (!abortRequested()) {
                    }
                }
                i11 = i12;
                indexColorModel3 = indexColorModel2;
                int iFilterRow222 = this.rowFilter.filterRow(this.metadata.IHDR_colorType, this.currRow, this.prevRow, this.filteredRows, i31, this.bpp);
                int i49222 = i31;
                imageOutputStream.write(iFilterRow222);
                imageOutputStream.write(this.filteredRows[iFilterRow222], this.bpp, i49222);
                byte[] bArr222 = this.currRow;
                this.currRow = this.prevRow;
                this.prevRow = bArr222;
                int i50222 = this.pixelsDone + i22;
                this.pixelsDone = i50222;
                processImageProgress((i50222 * 100.0f) / this.totalPixels);
                if (!abortRequested()) {
                }
            }
        }
    }

    private boolean equals(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr2 == null || iArr.length != iArr2.length) {
            return false;
        }
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private void initializeScaleTables(int[] iArr) {
        int i = this.metadata.IHDR_bitDepth;
        if (i == this.scalingBitDepth && equals(iArr, this.sampleSize)) {
            return;
        }
        this.sampleSize = iArr;
        this.scalingBitDepth = i;
        int i2 = (1 << i) - 1;
        if (i <= 8) {
            this.scale = new byte[this.numBands][];
            for (int i4 = 0; i4 < this.numBands; i4++) {
                int i5 = 1 << iArr[i4];
                int i6 = i5 - 1;
                int i7 = i6 / 2;
                this.scale[i4] = new byte[i5];
                for (int i8 = 0; i8 <= i6; i8++) {
                    this.scale[i4][i8] = (byte) (((i8 * i2) + i7) / i6);
                }
            }
            this.scale0 = this.scale[0];
            this.scalel = null;
            this.scaleh = null;
            return;
        }
        int i9 = this.numBands;
        this.scaleh = new byte[i9][];
        this.scalel = new byte[i9][];
        for (int i10 = 0; i10 < this.numBands; i10++) {
            int i11 = 1 << iArr[i10];
            int i12 = i11 - 1;
            int i13 = i12 / 2;
            this.scaleh[i10] = new byte[i11];
            this.scalel[i10] = new byte[i11];
            for (int i14 = 0; i14 <= i12; i14++) {
                int i15 = ((i14 * i2) + i13) / i12;
                this.scaleh[i10][i14] = (byte) (i15 >> 8);
                this.scalel[i10][i14] = (byte) (i15 & 255);
            }
        }
        this.scale = null;
        this.scale0 = null;
    }

    private void writeIEND() {
        new ChunkStream(1229278788, this.stream).finish();
    }

    private void writeUnknownChunks() {
        Iterator<String> it = this.metadata.unknownChunkType.iterator();
        Iterator<byte[]> it2 = this.metadata.unknownChunkData.iterator();
        while (it.hasNext() && it2.hasNext()) {
            ChunkStream chunkStream = new ChunkStream(chunkType(it.next()), this.stream);
            chunkStream.write(it2.next());
            chunkStream.finish();
        }
    }

    private void write_IDAT(RenderedImage renderedImage) {
        IDATOutputStream iDATOutputStream = new IDATOutputStream(this.stream, 32768);
        try {
            if (this.metadata.IHDR_interlaceMethod == 1) {
                int i = 0;
                while (i < 7) {
                    RenderedImage renderedImage2 = renderedImage;
                    encodePass(iDATOutputStream, renderedImage2, PNGImageReader.adam7XOffset[i], PNGImageReader.adam7YOffset[i], PNGImageReader.adam7XSubsampling[i], PNGImageReader.adam7YSubsampling[i]);
                    if (!abortRequested()) {
                        i++;
                        renderedImage = renderedImage2;
                    }
                }
            } else {
                encodePass(iDATOutputStream, renderedImage, 0, 0, 1, 1);
            }
        } finally {
            iDATOutputStream.finish();
        }
    }

    private void write_IHDR() throws IIOException {
        ChunkStream chunkStream = new ChunkStream(1229472850, this.stream);
        chunkStream.writeInt(this.metadata.IHDR_width);
        chunkStream.writeInt(this.metadata.IHDR_height);
        chunkStream.writeByte(this.metadata.IHDR_bitDepth);
        chunkStream.writeByte(this.metadata.IHDR_colorType);
        int i = this.metadata.IHDR_compressionMethod;
        if (i != 0) {
            throw new IIOException("Only compression method 0 is defined in PNG 1.1");
        }
        chunkStream.writeByte(i);
        int i2 = this.metadata.IHDR_filterMethod;
        if (i2 != 0) {
            throw new IIOException("Only filter method 0 is defined in PNG 1.1");
        }
        chunkStream.writeByte(i2);
        int i4 = this.metadata.IHDR_interlaceMethod;
        if (i4 < 0 || i4 > 1) {
            throw new IIOException("Only interlace methods 0 (node) and 1 (adam7) are defined in PNG 1.1");
        }
        chunkStream.writeByte(i4);
        chunkStream.finish();
    }

    private void write_PLTE() {
        PNGMetadata pNGMetadata = this.metadata;
        if (pNGMetadata.PLTE_present) {
            int i = pNGMetadata.IHDR_colorType;
            if (i == 0 || i == 4) {
                processWarningOccurred(0, "A PLTE chunk may not appear in a gray or gray alpha image.\nThe chunk will not be written");
                return;
            }
            ChunkStream chunkStream = new ChunkStream(1347179589, this.stream);
            int length = this.metadata.PLTE_red.length;
            byte[] bArr = new byte[length * 3];
            int i2 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                PNGMetadata pNGMetadata2 = this.metadata;
                bArr[i2] = pNGMetadata2.PLTE_red[i4];
                int i5 = i2 + 2;
                bArr[i2 + 1] = pNGMetadata2.PLTE_green[i4];
                i2 += 3;
                bArr[i5] = pNGMetadata2.PLTE_blue[i4];
            }
            chunkStream.write(bArr);
            chunkStream.finish();
        }
    }

    private void write_bKGD() {
        if (this.metadata.bKGD_present) {
            ChunkStream chunkStream = new ChunkStream(1649100612, this.stream);
            PNGMetadata pNGMetadata = this.metadata;
            int i = pNGMetadata.IHDR_colorType & 3;
            int i2 = pNGMetadata.bKGD_colorType;
            int i4 = pNGMetadata.bKGD_red;
            if (i == 2 && i2 == 0) {
                i4 = pNGMetadata.bKGD_gray;
                i2 = i;
            }
            int i5 = i4;
            if (i2 != i) {
                processWarningOccurred(0, "bKGD metadata has incompatible color type.\nThe chunk will not be written.");
                return;
            }
            if (i == 3) {
                chunkStream.writeByte(pNGMetadata.bKGD_index);
            } else if (i == 0 || i == 4) {
                chunkStream.writeShort(pNGMetadata.bKGD_gray);
            } else {
                chunkStream.writeShort(i4);
                chunkStream.writeShort(i5);
                chunkStream.writeShort(i5);
            }
            chunkStream.finish();
        }
    }

    private void write_cHRM() {
        if (this.metadata.cHRM_present) {
            ChunkStream chunkStream = new ChunkStream(1665684045, this.stream);
            chunkStream.writeInt(this.metadata.cHRM_whitePointX);
            chunkStream.writeInt(this.metadata.cHRM_whitePointY);
            chunkStream.writeInt(this.metadata.cHRM_redX);
            chunkStream.writeInt(this.metadata.cHRM_redY);
            chunkStream.writeInt(this.metadata.cHRM_greenX);
            chunkStream.writeInt(this.metadata.cHRM_greenY);
            chunkStream.writeInt(this.metadata.cHRM_blueX);
            chunkStream.writeInt(this.metadata.cHRM_blueY);
            chunkStream.finish();
        }
    }

    private void write_gAMA() {
        if (this.metadata.gAMA_present) {
            ChunkStream chunkStream = new ChunkStream(1732332865, this.stream);
            chunkStream.writeInt(this.metadata.gAMA_gamma);
            chunkStream.finish();
        }
    }

    private void write_hIST() throws IIOException {
        if (this.metadata.hIST_present) {
            ChunkStream chunkStream = new ChunkStream(1749635924, this.stream);
            PNGMetadata pNGMetadata = this.metadata;
            if (!pNGMetadata.PLTE_present) {
                throw new IIOException("hIST chunk without PLTE chunk!");
            }
            char[] cArr = pNGMetadata.hIST_histogram;
            chunkStream.writeChars(cArr, 0, cArr.length);
            chunkStream.finish();
        }
    }

    private void write_iCCP() {
        if (this.metadata.iCCP_present) {
            ChunkStream chunkStream = new ChunkStream(1766015824, this.stream);
            chunkStream.writeBytes(this.metadata.iCCP_profileName);
            chunkStream.writeByte(0);
            chunkStream.writeByte(this.metadata.iCCP_compressionMethod);
            chunkStream.write(this.metadata.iCCP_compressedProfile);
            chunkStream.finish();
        }
    }

    private void write_iTXt() {
        Iterator<String> it = this.metadata.iTXt_keyword.iterator();
        Iterator<Boolean> it2 = this.metadata.iTXt_compressionFlag.iterator();
        Iterator<Integer> it3 = this.metadata.iTXt_compressionMethod.iterator();
        Iterator<String> it4 = this.metadata.iTXt_languageTag.iterator();
        Iterator<String> it5 = this.metadata.iTXt_translatedKeyword.iterator();
        Iterator<String> it6 = this.metadata.iTXt_text.iterator();
        while (it.hasNext()) {
            ChunkStream chunkStream = new ChunkStream(1767135348, this.stream);
            chunkStream.writeBytes(it.next());
            chunkStream.writeByte(0);
            Boolean next = it2.next();
            chunkStream.writeByte(next.booleanValue() ? 1 : 0);
            chunkStream.writeByte(it3.next().intValue());
            chunkStream.writeBytes(it4.next());
            chunkStream.writeByte(0);
            chunkStream.write(it5.next().getBytes(InternalZipConstants.CHARSET_UTF8));
            chunkStream.writeByte(0);
            String next2 = it6.next();
            if (next.booleanValue()) {
                chunkStream.write(deflate(next2.getBytes(InternalZipConstants.CHARSET_UTF8)));
            } else {
                chunkStream.write(next2.getBytes(InternalZipConstants.CHARSET_UTF8));
            }
            chunkStream.finish();
        }
    }

    private void write_magic() {
        this.stream.write(new byte[]{-119, 80, 78, 71, 13, 10, 26, 10});
    }

    private void write_pHYs() {
        if (this.metadata.pHYs_present) {
            ChunkStream chunkStream = new ChunkStream(1883789683, this.stream);
            chunkStream.writeInt(this.metadata.pHYs_pixelsPerUnitXAxis);
            chunkStream.writeInt(this.metadata.pHYs_pixelsPerUnitYAxis);
            chunkStream.writeByte(this.metadata.pHYs_unitSpecifier);
            chunkStream.finish();
        }
    }

    private void write_sBIT() {
        if (this.metadata.sBIT_present) {
            ChunkStream chunkStream = new ChunkStream(1933723988, this.stream);
            PNGMetadata pNGMetadata = this.metadata;
            int i = pNGMetadata.IHDR_colorType;
            if (pNGMetadata.sBIT_colorType != i) {
                processWarningOccurred(0, "sBIT metadata has wrong color type.\nThe chunk will not be written.");
                return;
            }
            if (i == 0 || i == 4) {
                chunkStream.writeByte(pNGMetadata.sBIT_grayBits);
            } else if (i == 2 || i == 3 || i == 6) {
                chunkStream.writeByte(pNGMetadata.sBIT_redBits);
                chunkStream.writeByte(this.metadata.sBIT_greenBits);
                chunkStream.writeByte(this.metadata.sBIT_blueBits);
            }
            if (i == 4 || i == 6) {
                chunkStream.writeByte(this.metadata.sBIT_alphaBits);
            }
            chunkStream.finish();
        }
    }

    private void write_sPLT() {
        if (this.metadata.sPLT_present) {
            ChunkStream chunkStream = new ChunkStream(1934642260, this.stream);
            chunkStream.writeBytes(this.metadata.sPLT_paletteName);
            int i = 0;
            chunkStream.writeByte(0);
            chunkStream.writeByte(this.metadata.sPLT_sampleDepth);
            PNGMetadata pNGMetadata = this.metadata;
            int length = pNGMetadata.sPLT_red.length;
            if (pNGMetadata.sPLT_sampleDepth == 8) {
                while (i < length) {
                    chunkStream.writeByte(this.metadata.sPLT_red[i]);
                    chunkStream.writeByte(this.metadata.sPLT_green[i]);
                    chunkStream.writeByte(this.metadata.sPLT_blue[i]);
                    chunkStream.writeByte(this.metadata.sPLT_alpha[i]);
                    chunkStream.writeShort(this.metadata.sPLT_frequency[i]);
                    i++;
                }
            } else {
                while (i < length) {
                    chunkStream.writeShort(this.metadata.sPLT_red[i]);
                    chunkStream.writeShort(this.metadata.sPLT_green[i]);
                    chunkStream.writeShort(this.metadata.sPLT_blue[i]);
                    chunkStream.writeShort(this.metadata.sPLT_alpha[i]);
                    chunkStream.writeShort(this.metadata.sPLT_frequency[i]);
                    i++;
                }
            }
            chunkStream.finish();
        }
    }

    private void write_sRGB() {
        if (this.metadata.sRGB_present) {
            ChunkStream chunkStream = new ChunkStream(1934772034, this.stream);
            chunkStream.writeByte(this.metadata.sRGB_renderingIntent);
            chunkStream.finish();
        }
    }

    private void write_tEXt() {
        Iterator<String> it = this.metadata.tEXt_keyword.iterator();
        Iterator<String> it2 = this.metadata.tEXt_text.iterator();
        while (it.hasNext()) {
            ChunkStream chunkStream = new ChunkStream(1950701684, this.stream);
            chunkStream.writeBytes(it.next());
            chunkStream.writeByte(0);
            chunkStream.writeBytes(it2.next());
            chunkStream.finish();
        }
    }

    private void write_tIME() {
        if (this.metadata.tIME_present) {
            ChunkStream chunkStream = new ChunkStream(1950960965, this.stream);
            chunkStream.writeShort(this.metadata.tIME_year);
            chunkStream.writeByte(this.metadata.tIME_month);
            chunkStream.writeByte(this.metadata.tIME_day);
            chunkStream.writeByte(this.metadata.tIME_hour);
            chunkStream.writeByte(this.metadata.tIME_minute);
            chunkStream.writeByte(this.metadata.tIME_second);
            chunkStream.finish();
        }
    }

    private void write_tRNS() throws IIOException {
        if (this.metadata.tRNS_present) {
            ChunkStream chunkStream = new ChunkStream(1951551059, this.stream);
            PNGMetadata pNGMetadata = this.metadata;
            int i = pNGMetadata.IHDR_colorType;
            int i2 = pNGMetadata.tRNS_colorType;
            int i4 = pNGMetadata.tRNS_red;
            int i5 = pNGMetadata.tRNS_green;
            int i6 = pNGMetadata.tRNS_blue;
            if (i == 2 && i2 == 0) {
                i4 = pNGMetadata.tRNS_gray;
                i2 = i;
                i5 = i4;
                i6 = i5;
            }
            if (i2 != i) {
                processWarningOccurred(0, "tRNS metadata has incompatible color type.\nThe chunk will not be written.");
                return;
            }
            if (i == 3) {
                if (!pNGMetadata.PLTE_present) {
                    throw new IIOException("tRNS chunk without PLTE chunk!");
                }
                chunkStream.write(pNGMetadata.tRNS_alpha);
            } else if (i == 0) {
                chunkStream.writeShort(pNGMetadata.tRNS_gray);
            } else {
                if (i != 2) {
                    throw new IIOException("tRNS chunk for color type 4 or 6!");
                }
                chunkStream.writeShort(i4);
                chunkStream.writeShort(i5);
                chunkStream.writeShort(i6);
            }
            chunkStream.finish();
        }
    }

    private void write_zTXt() {
        Iterator<String> it = this.metadata.zTXt_keyword.iterator();
        Iterator<Integer> it2 = this.metadata.zTXt_compressionMethod.iterator();
        Iterator<String> it3 = this.metadata.zTXt_text.iterator();
        while (it.hasNext()) {
            ChunkStream chunkStream = new ChunkStream(2052348020, this.stream);
            chunkStream.writeBytes(it.next());
            chunkStream.writeByte(0);
            chunkStream.writeByte(it2.next().intValue());
            chunkStream.write(deflate(it3.next().getBytes("ISO-8859-1")));
            chunkStream.finish();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter, org.apache.poi.javax.imageio.ImageTranscoder
    public IIOMetadata convertImageMetadata(IIOMetadata iIOMetadata, ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam) {
        return iIOMetadata instanceof PNGMetadata ? (PNGMetadata) ((PNGMetadata) iIOMetadata).clone() : new PNGMetadata(iIOMetadata);
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter, org.apache.poi.javax.imageio.ImageTranscoder
    public IIOMetadata convertStreamMetadata(IIOMetadata iIOMetadata, ImageWriteParam imageWriteParam) {
        return null;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public IIOMetadata getDefaultImageMetadata(ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam) {
        PNGMetadata pNGMetadata = new PNGMetadata();
        pNGMetadata.initialize(imageTypeSpecifier, imageTypeSpecifier.getSampleModel().getNumBands());
        return pNGMetadata;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public IIOMetadata getDefaultStreamMetadata(ImageWriteParam imageWriteParam) {
        return null;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public ImageWriteParam getDefaultWriteParam() {
        return new PNGImageWriteParam(getLocale());
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void setOutput(Object obj) {
        super.setOutput(obj);
        if (obj == null) {
            this.stream = null;
        } else {
            if (!(obj instanceof ImageOutputStream)) {
                throw new IllegalArgumentException("output not an ImageOutputStream!");
            }
            this.stream = (ImageOutputStream) obj;
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void write(IIOMetadata iIOMetadata, IIOImage iIOImage, ImageWriteParam imageWriteParam) throws IIOException {
        if (this.stream == null) {
            throw new IllegalStateException("output == null!");
        }
        if (iIOImage == null) {
            throw new IllegalArgumentException("image == null!");
        }
        if (iIOImage.hasRaster()) {
            throw new UnsupportedOperationException("image has a Raster!");
        }
        RenderedImage renderedImage = iIOImage.getRenderedImage();
        SampleModel sampleModel = renderedImage.getSampleModel();
        this.numBands = sampleModel.getNumBands();
        this.sourceXOffset = renderedImage.getMinX();
        this.sourceYOffset = renderedImage.getMinY();
        this.sourceWidth = renderedImage.getWidth();
        this.sourceHeight = renderedImage.getHeight();
        this.sourceBands = null;
        this.periodX = 1;
        this.periodY = 1;
        if (imageWriteParam != null) {
            Rectangle sourceRegion = imageWriteParam.getSourceRegion();
            if (sourceRegion != null) {
                Rectangle rectangleIntersection = sourceRegion.intersection(new Rectangle(renderedImage.getMinX(), renderedImage.getMinY(), renderedImage.getWidth(), renderedImage.getHeight()));
                this.sourceXOffset = rectangleIntersection.f10094x;
                this.sourceYOffset = rectangleIntersection.f10095y;
                this.sourceWidth = rectangleIntersection.width;
                this.sourceHeight = rectangleIntersection.height;
            }
            int subsamplingXOffset = imageWriteParam.getSubsamplingXOffset();
            int subsamplingYOffset = imageWriteParam.getSubsamplingYOffset();
            this.sourceXOffset += subsamplingXOffset;
            this.sourceYOffset += subsamplingYOffset;
            this.sourceWidth -= subsamplingXOffset;
            this.sourceHeight -= subsamplingYOffset;
            this.periodX = imageWriteParam.getSourceXSubsampling();
            this.periodY = imageWriteParam.getSourceYSubsampling();
            int[] sourceBands = imageWriteParam.getSourceBands();
            if (sourceBands != null) {
                this.sourceBands = sourceBands;
                this.numBands = sourceBands.length;
            }
        }
        int i = this.sourceWidth;
        int i2 = this.periodX;
        int iM3211u = AbstractC4539a.m3211u(i, i2, 1, i2);
        int i4 = this.sourceHeight;
        int i5 = this.periodY;
        int iM3211u2 = AbstractC4539a.m3211u(i4, i5, 1, i5);
        if (iM3211u <= 0 || iM3211u2 <= 0) {
            throw new IllegalArgumentException("Empty source region!");
        }
        this.totalPixels = iM3211u * iM3211u2;
        this.pixelsDone = 0;
        IIOMetadata metadata = iIOImage.getMetadata();
        if (metadata != null) {
            this.metadata = (PNGMetadata) convertImageMetadata(metadata, ImageTypeSpecifier.createFromRenderedImage(renderedImage), null);
        } else {
            this.metadata = new PNGMetadata();
        }
        if (imageWriteParam != null) {
            int progressiveMode = imageWriteParam.getProgressiveMode();
            if (progressiveMode == 0) {
                this.metadata.IHDR_interlaceMethod = 0;
            } else if (progressiveMode == 1) {
                this.metadata.IHDR_interlaceMethod = 1;
            }
        }
        this.metadata.initialize(new ImageTypeSpecifier(renderedImage), this.numBands);
        PNGMetadata pNGMetadata = this.metadata;
        pNGMetadata.IHDR_width = iM3211u;
        pNGMetadata.IHDR_height = iM3211u2;
        this.bpp = this.numBands * (pNGMetadata.IHDR_bitDepth == 16 ? 2 : 1);
        initializeScaleTables(sampleModel.getSampleSize());
        clearAbortRequest();
        processImageStarted(0);
        try {
            write_magic();
            write_IHDR();
            write_cHRM();
            write_gAMA();
            write_iCCP();
            write_sBIT();
            write_sRGB();
            write_PLTE();
            write_hIST();
            write_tRNS();
            write_bKGD();
            write_pHYs();
            write_sPLT();
            write_tIME();
            write_tEXt();
            write_iTXt();
            write_zTXt();
            writeUnknownChunks();
            write_IDAT(renderedImage);
            if (abortRequested()) {
                processWriteAborted();
            } else {
                writeIEND();
                processImageComplete();
            }
        } catch (IOException e) {
            throw new IIOException("I/O error writing PNG file!", e);
        }
    }
}
