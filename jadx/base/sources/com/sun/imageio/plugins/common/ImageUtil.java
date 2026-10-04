package com.sun.imageio.plugins.common;

import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import kotlin.UShort;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.color.ColorSpace;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.ComponentColorModel;
import org.apache.poi.java.awt.image.ComponentSampleModel;
import org.apache.poi.java.awt.image.DataBuffer;
import org.apache.poi.java.awt.image.DataBufferByte;
import org.apache.poi.java.awt.image.DataBufferInt;
import org.apache.poi.java.awt.image.DataBufferShort;
import org.apache.poi.java.awt.image.DataBufferUShort;
import org.apache.poi.java.awt.image.DirectColorModel;
import org.apache.poi.java.awt.image.IndexColorModel;
import org.apache.poi.java.awt.image.MultiPixelPackedSampleModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RenderedImage;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.java.awt.image.SinglePixelPackedSampleModel;
import org.apache.poi.java.awt.image.WritableRaster;
import org.apache.poi.javax.imageio.IIOException;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.ImageWriter;
import org.apache.poi.javax.imageio.spi.ImageWriterSpi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ImageUtil {
    public static final void canEncodeImage(ImageWriter imageWriter, ImageTypeSpecifier imageTypeSpecifier) throws IIOException {
        ImageWriterSpi originatingProvider = imageWriter.getOriginatingProvider();
        if (imageTypeSpecifier == null || originatingProvider == null || originatingProvider.canEncodeImage(imageTypeSpecifier)) {
            return;
        }
        throw new IIOException(I18N.getString("ImageUtil2") + " " + imageWriter.getClass().getName());
    }

    public static String convertObjectToString(Object obj) {
        String strM2223n = "";
        if (obj == null) {
            return "";
        }
        int i = 0;
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            while (i < bArr.length) {
                strM2223n = AbstractC2821a.m2223n(AbstractC1974b.m1324q(strM2223n), " ", bArr[i]);
                i++;
            }
            return strM2223n;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            while (i < iArr.length) {
                strM2223n = AbstractC2821a.m2223n(AbstractC1974b.m1324q(strM2223n), " ", iArr[i]);
                i++;
            }
            return strM2223n;
        }
        if (!(obj instanceof short[])) {
            return obj.toString();
        }
        short[] sArr = (short[]) obj;
        while (i < sArr.length) {
            strM2223n = AbstractC2821a.m2223n(AbstractC1974b.m1324q(strM2223n), " ", sArr[i]);
            i++;
        }
        return strM2223n;
    }

    public static final ColorModel createColorModel(SampleModel sampleModel) {
        int i;
        int i2;
        int i4;
        int i5;
        if (sampleModel == null) {
            throw new IllegalArgumentException("sampleModel == null!");
        }
        int dataType = sampleModel.getDataType();
        if (dataType != 0 && dataType != 1 && dataType != 2 && dataType != 3 && dataType != 4 && dataType != 5) {
            return null;
        }
        int[] sampleSize = sampleModel.getSampleSize();
        int i6 = 0;
        if (sampleModel instanceof ComponentSampleModel) {
            int numBands = sampleModel.getNumBands();
            ColorSpace colorSpace = numBands <= 2 ? ColorSpace.getInstance(1003) : numBands <= 4 ? ColorSpace.getInstance(1000) : new BogusColorSpace(numBands);
            boolean z = numBands == 2 || numBands == 4;
            return new ComponentColorModel(colorSpace, sampleSize, z, false, z ? 3 : 1, dataType);
        }
        if (sampleModel.getNumBands() > 4 || !(sampleModel instanceof SinglePixelPackedSampleModel)) {
            if (!(sampleModel instanceof MultiPixelPackedSampleModel)) {
                return null;
            }
            int i7 = sampleSize[0];
            int i8 = 1 << i7;
            byte[] bArr = new byte[i8];
            while (i6 < i8) {
                bArr[i6] = (byte) ((i6 * 255) / (i8 - 1));
                i6++;
            }
            return new IndexColorModel(i7, i8, bArr, bArr, bArr);
        }
        int[] bitMasks = ((SinglePixelPackedSampleModel) sampleModel).getBitMasks();
        int length = bitMasks.length;
        if (length <= 2) {
            int i9 = bitMasks[0];
            if (length == 2) {
                i5 = bitMasks[1];
                i4 = i9;
                i2 = i4;
                i = i2;
            } else {
                i4 = i9;
                i2 = i4;
                i = i2;
                i5 = 0;
            }
        } else {
            int i10 = bitMasks[0];
            int i11 = bitMasks[1];
            int i12 = bitMasks[2];
            if (length == 4) {
                i5 = bitMasks[3];
                i = i12;
                i2 = i11;
                i4 = i10;
            } else {
                i = i12;
                i2 = i11;
                i4 = i10;
                i5 = 0;
            }
        }
        int i13 = 0;
        while (i6 < sampleSize.length) {
            i13 += sampleSize[i6];
            i6++;
        }
        return new DirectColorModel(i13, i4, i2, i, i5);
    }

    public static long getBandSize(SampleModel sampleModel) {
        int dataTypeSize = DataBuffer.getDataTypeSize(sampleModel.getDataType());
        if (!(sampleModel instanceof ComponentSampleModel)) {
            return getTileSize(sampleModel);
        }
        ComponentSampleModel componentSampleModel = (ComponentSampleModel) sampleModel;
        int pixelStride = componentSampleModel.getPixelStride();
        int scanlineStride = componentSampleModel.getScanlineStride();
        long jMin = Math.min(pixelStride, scanlineStride);
        if (pixelStride > 0) {
            jMin += (long) ((sampleModel.getWidth() - 1) * pixelStride);
        }
        if (scanlineStride > 0) {
            jMin += (long) ((sampleModel.getHeight() - 1) * scanlineStride);
        }
        return jMin * ((long) ((dataTypeSize + 7) / 8));
    }

    public static int getElementSize(SampleModel sampleModel) {
        int numBands;
        int dataTypeSize = DataBuffer.getDataTypeSize(sampleModel.getDataType());
        if (sampleModel instanceof MultiPixelPackedSampleModel) {
            MultiPixelPackedSampleModel multiPixelPackedSampleModel = (MultiPixelPackedSampleModel) sampleModel;
            dataTypeSize = multiPixelPackedSampleModel.getSampleSize(0);
            numBands = multiPixelPackedSampleModel.getNumBands();
        } else {
            if (!(sampleModel instanceof ComponentSampleModel) && (sampleModel instanceof SinglePixelPackedSampleModel)) {
                return dataTypeSize;
            }
            numBands = sampleModel.getNumBands();
        }
        return numBands * dataTypeSize;
    }

    public static byte[] getPackedBinaryData(Raster raster, Rectangle rectangle) {
        int i;
        SampleModel sampleModel = raster.getSampleModel();
        if (!isBinary(sampleModel)) {
            throw new IllegalArgumentException(I18N.getString("ImageUtil0"));
        }
        int i2 = rectangle.f10094x;
        int i4 = rectangle.f10095y;
        int i5 = rectangle.width;
        int i6 = rectangle.height;
        DataBuffer dataBuffer = raster.getDataBuffer();
        int sampleModelTranslateX = i2 - raster.getSampleModelTranslateX();
        int sampleModelTranslateY = i4 - raster.getSampleModelTranslateY();
        MultiPixelPackedSampleModel multiPixelPackedSampleModel = (MultiPixelPackedSampleModel) sampleModel;
        int scanlineStride = multiPixelPackedSampleModel.getScanlineStride();
        int offset = multiPixelPackedSampleModel.getOffset(sampleModelTranslateX, sampleModelTranslateY) + dataBuffer.getOffset();
        int bitOffset = multiPixelPackedSampleModel.getBitOffset(sampleModelTranslateX);
        int i7 = (i5 + 7) / 8;
        boolean z = dataBuffer instanceof DataBufferByte;
        if (z && offset == 0 && bitOffset == 0 && i7 == scanlineStride) {
            DataBufferByte dataBufferByte = (DataBufferByte) dataBuffer;
            if (dataBufferByte.getData().length == i7 * i6) {
                return dataBufferByte.getData();
            }
        }
        byte[] bArr = new byte[i7 * i6];
        int i8 = 0;
        if (bitOffset == 0) {
            if (z) {
                byte[] data = ((DataBufferByte) dataBuffer).getData();
                int i9 = 0;
                while (i8 < i6) {
                    System.arraycopy(data, offset, bArr, i9, i7);
                    i9 += i7;
                    offset += scanlineStride;
                    i8++;
                }
            } else {
                boolean z2 = dataBuffer instanceof DataBufferShort;
                if (z2 || (dataBuffer instanceof DataBufferUShort)) {
                    short[] data2 = z2 ? ((DataBufferShort) dataBuffer).getData() : ((DataBufferUShort) dataBuffer).getData();
                    int i10 = 0;
                    while (i8 < i6) {
                        int i11 = offset;
                        int i12 = i5;
                        while (i12 > 8) {
                            int i13 = i11 + 1;
                            short s = data2[i11];
                            int i14 = i10 + 1;
                            bArr[i10] = (byte) ((s >>> 8) & 255);
                            i10 += 2;
                            bArr[i14] = (byte) (s & 255);
                            i12 -= 16;
                            i11 = i13;
                        }
                        if (i12 > 0) {
                            bArr[i10] = (byte) ((data2[i11] >>> 8) & 255);
                            i10++;
                        }
                        offset += scanlineStride;
                        i8++;
                    }
                } else if (dataBuffer instanceof DataBufferInt) {
                    int[] data3 = ((DataBufferInt) dataBuffer).getData();
                    int i15 = 0;
                    while (i8 < i6) {
                        int i16 = offset;
                        int i17 = i5;
                        while (i17 > 24) {
                            int i18 = i16 + 1;
                            int i19 = data3[i16];
                            bArr[i15] = (byte) ((i19 >>> 24) & 255);
                            bArr[i15 + 1] = (byte) ((i19 >>> 16) & 255);
                            int i20 = i15 + 3;
                            bArr[i15 + 2] = (byte) ((i19 >>> 8) & 255);
                            i15 += 4;
                            bArr[i20] = (byte) (i19 & 255);
                            i17 -= 32;
                            i16 = i18;
                        }
                        int i21 = 24;
                        while (i17 > 0) {
                            bArr[i15] = (byte) ((data3[i16] >>> i21) & 255);
                            i21 -= 8;
                            i17 -= 8;
                            i15++;
                        }
                        offset += scanlineStride;
                        i8++;
                    }
                }
            }
        } else if (z) {
            byte[] data4 = ((DataBufferByte) dataBuffer).getData();
            int i22 = bitOffset & 7;
            if (i22 == 0) {
                int i23 = 0;
                while (i8 < i6) {
                    System.arraycopy(data4, offset, bArr, i23, i7);
                    i23 += i7;
                    offset += scanlineStride;
                    i8++;
                }
            } else {
                int i24 = 8 - i22;
                int i25 = 0;
                while (i8 < i6) {
                    int i26 = offset;
                    for (int i27 = i5; i27 > 0; i27 -= 8) {
                        if (i27 > i24) {
                            i = i25 + 1;
                            int i28 = i26 + 1;
                            bArr[i25] = (byte) (((data4[i26] & 255) << i22) | ((data4[i28] & 255) >>> i24));
                            i26 = i28;
                        } else {
                            i = i25 + 1;
                            bArr[i25] = (byte) ((data4[i26] & 255) << i22);
                        }
                        i25 = i;
                    }
                    offset += scanlineStride;
                    i8++;
                }
            }
        } else {
            boolean z3 = dataBuffer instanceof DataBufferShort;
            if (z3 || (dataBuffer instanceof DataBufferUShort)) {
                short[] data5 = z3 ? ((DataBufferShort) dataBuffer).getData() : ((DataBufferUShort) dataBuffer).getData();
                int i29 = 0;
                for (int i30 = 0; i30 < i6; i30++) {
                    int i31 = bitOffset;
                    int i32 = 0;
                    while (i32 < i5) {
                        int i33 = (i31 / 16) + offset;
                        int i34 = i31 % 16;
                        int i35 = data5[i33] & UShort.MAX_VALUE;
                        if (i34 <= 8) {
                            bArr[i29] = (byte) (i35 >>> (8 - i34));
                            i29++;
                        } else {
                            int i36 = i34 - 8;
                            bArr[i29] = (byte) (((data5[i33 + 1] & UShort.MAX_VALUE) >>> (16 - i36)) | (i35 << i36));
                            i29++;
                        }
                        i32 += 8;
                        i31 += 8;
                    }
                    offset += scanlineStride;
                }
            } else if (dataBuffer instanceof DataBufferInt) {
                int[] data6 = ((DataBufferInt) dataBuffer).getData();
                int i37 = 0;
                for (int i38 = 0; i38 < i6; i38++) {
                    int i39 = bitOffset;
                    int i40 = 0;
                    while (i40 < i5) {
                        int i41 = (i39 / 32) + offset;
                        int i42 = i39 % 32;
                        int i43 = data6[i41];
                        if (i42 <= 24) {
                            bArr[i37] = (byte) (i43 >>> (24 - i42));
                            i37++;
                        } else {
                            int i44 = i42 - 24;
                            bArr[i37] = (byte) ((data6[i41 + 1] >>> (32 - i44)) | (i43 << i44));
                            i37++;
                        }
                        i40 += 8;
                        i39 += 8;
                    }
                    offset += scanlineStride;
                }
            }
        }
        return bArr;
    }

    public static long getTileSize(SampleModel sampleModel) {
        int dataTypeSize = DataBuffer.getDataTypeSize(sampleModel.getDataType());
        if (sampleModel instanceof MultiPixelPackedSampleModel) {
            MultiPixelPackedSampleModel multiPixelPackedSampleModel = (MultiPixelPackedSampleModel) sampleModel;
            return ((dataTypeSize + 7) / 8) * ((((multiPixelPackedSampleModel.getDataBitOffset() + dataTypeSize) - 1) / dataTypeSize) + (multiPixelPackedSampleModel.getHeight() * multiPixelPackedSampleModel.getScanlineStride()));
        }
        if (!(sampleModel instanceof ComponentSampleModel)) {
            if (!(sampleModel instanceof SinglePixelPackedSampleModel)) {
                return 0L;
            }
            SinglePixelPackedSampleModel singlePixelPackedSampleModel = (SinglePixelPackedSampleModel) sampleModel;
            return ((long) (singlePixelPackedSampleModel.getWidth() + ((singlePixelPackedSampleModel.getHeight() - 1) * singlePixelPackedSampleModel.getScanlineStride()))) * ((long) ((dataTypeSize + 7) / 8));
        }
        ComponentSampleModel componentSampleModel = (ComponentSampleModel) sampleModel;
        int[] bandOffsets = componentSampleModel.getBandOffsets();
        int iMax = bandOffsets[0];
        for (int i = 1; i < bandOffsets.length; i++) {
            iMax = Math.max(iMax, bandOffsets[i]);
        }
        int pixelStride = componentSampleModel.getPixelStride();
        int scanlineStride = componentSampleModel.getScanlineStride();
        long height = iMax >= 0 ? iMax + 1 : 0L;
        if (pixelStride > 0) {
            height += (long) ((sampleModel.getWidth() - 1) * pixelStride);
        }
        if (scanlineStride > 0) {
            height += (long) ((sampleModel.getHeight() - 1) * scanlineStride);
        }
        int[] bankIndices = componentSampleModel.getBankIndices();
        int iMax2 = bankIndices[0];
        for (int i2 = 1; i2 < bankIndices.length; i2++) {
            iMax2 = Math.max(iMax2, bankIndices[i2]);
        }
        return height * ((long) (iMax2 + 1)) * ((long) ((dataTypeSize + 7) / 8));
    }

    public static byte[] getUnpackedBinaryData(Raster raster, Rectangle rectangle) {
        SampleModel sampleModel = raster.getSampleModel();
        if (!isBinary(sampleModel)) {
            throw new IllegalArgumentException(I18N.getString("ImageUtil0"));
        }
        int i = rectangle.f10094x;
        int i2 = rectangle.f10095y;
        int i4 = rectangle.width;
        int i5 = rectangle.height;
        DataBuffer dataBuffer = raster.getDataBuffer();
        int sampleModelTranslateX = i - raster.getSampleModelTranslateX();
        int sampleModelTranslateY = i2 - raster.getSampleModelTranslateY();
        MultiPixelPackedSampleModel multiPixelPackedSampleModel = (MultiPixelPackedSampleModel) sampleModel;
        int scanlineStride = multiPixelPackedSampleModel.getScanlineStride();
        int offset = multiPixelPackedSampleModel.getOffset(sampleModelTranslateX, sampleModelTranslateY) + dataBuffer.getOffset();
        int bitOffset = multiPixelPackedSampleModel.getBitOffset(sampleModelTranslateX);
        byte[] bArr = new byte[i4 * i5];
        int i6 = i5 + i2;
        int i7 = i4 + i;
        int i8 = 0;
        if (dataBuffer instanceof DataBufferByte) {
            byte[] data = ((DataBufferByte) dataBuffer).getData();
            while (i2 < i6) {
                int i9 = (offset * 8) + bitOffset;
                int i10 = i;
                while (i10 < i7) {
                    bArr[i8] = (byte) ((data[i9 / 8] >>> ((7 - i9) & 7)) & 1);
                    i9++;
                    i10++;
                    i8++;
                }
                offset += scanlineStride;
                i2++;
            }
        } else {
            boolean z = dataBuffer instanceof DataBufferShort;
            if (z || (dataBuffer instanceof DataBufferUShort)) {
                short[] data2 = z ? ((DataBufferShort) dataBuffer).getData() : ((DataBufferUShort) dataBuffer).getData();
                while (i2 < i6) {
                    int i11 = (offset * 16) + bitOffset;
                    int i12 = i;
                    while (i12 < i7) {
                        bArr[i8] = (byte) ((data2[i11 / 16] >>> (15 - (i11 % 16))) & 1);
                        i11++;
                        i12++;
                        i8++;
                    }
                    offset += scanlineStride;
                    i2++;
                }
            } else if (dataBuffer instanceof DataBufferInt) {
                int[] data3 = ((DataBufferInt) dataBuffer).getData();
                while (i2 < i6) {
                    int i13 = (offset * 32) + bitOffset;
                    int i14 = i;
                    while (i14 < i7) {
                        bArr[i8] = (byte) ((data3[i13 / 32] >>> (31 - (i13 % 32))) & 1);
                        i13++;
                        i14++;
                        i8++;
                    }
                    offset += scanlineStride;
                    i2++;
                }
            }
        }
        return bArr;
    }

    public static final boolean imageIsContiguous(RenderedImage renderedImage) {
        SampleModel sampleModel = renderedImage instanceof BufferedImage ? ((BufferedImage) renderedImage).getRaster().getSampleModel() : renderedImage.getSampleModel();
        if (!(sampleModel instanceof ComponentSampleModel)) {
            return isBinary(sampleModel);
        }
        ComponentSampleModel componentSampleModel = (ComponentSampleModel) sampleModel;
        if (componentSampleModel.getPixelStride() != componentSampleModel.getNumBands()) {
            return false;
        }
        int[] bandOffsets = componentSampleModel.getBandOffsets();
        for (int i = 0; i < bandOffsets.length; i++) {
            if (bandOffsets[i] != i) {
                return false;
            }
        }
        int[] bankIndices = componentSampleModel.getBankIndices();
        for (int i2 = 0; i2 < bandOffsets.length; i2++) {
            if (bankIndices[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBinary(SampleModel sampleModel) {
        return (sampleModel instanceof MultiPixelPackedSampleModel) && ((MultiPixelPackedSampleModel) sampleModel).getPixelBitStride() == 1 && sampleModel.getNumBands() == 1;
    }

    public static boolean isIndicesForGrayscale(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int length;
        if (bArr.length != bArr2.length || bArr.length != bArr3.length || (length = bArr.length) != 256) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            byte b = (byte) i;
            if (bArr[i] != b || bArr2[i] != b || bArr3[i] != b) {
                return false;
            }
        }
        return true;
    }

    public static void setPackedBinaryData(byte[] bArr, WritableRaster writableRaster, Rectangle rectangle) {
        int i;
        SampleModel sampleModel = writableRaster.getSampleModel();
        if (!isBinary(sampleModel)) {
            throw new IllegalArgumentException(I18N.getString("ImageUtil0"));
        }
        int i2 = rectangle.f10094x;
        int i4 = rectangle.f10095y;
        int i5 = rectangle.width;
        int i6 = rectangle.height;
        DataBuffer dataBuffer = writableRaster.getDataBuffer();
        int sampleModelTranslateX = i2 - writableRaster.getSampleModelTranslateX();
        int sampleModelTranslateY = i4 - writableRaster.getSampleModelTranslateY();
        MultiPixelPackedSampleModel multiPixelPackedSampleModel = (MultiPixelPackedSampleModel) sampleModel;
        int scanlineStride = multiPixelPackedSampleModel.getScanlineStride();
        int offset = multiPixelPackedSampleModel.getOffset(sampleModelTranslateX, sampleModelTranslateY) + dataBuffer.getOffset();
        int bitOffset = multiPixelPackedSampleModel.getBitOffset(sampleModelTranslateX);
        int i7 = 24;
        int i8 = 255;
        if (bitOffset == 0) {
            if (dataBuffer instanceof DataBufferByte) {
                byte[] data = ((DataBufferByte) dataBuffer).getData();
                if (data == bArr) {
                    return;
                }
                int i9 = (i5 + 7) / 8;
                int i10 = 0;
                for (int i11 = 0; i11 < i6; i11++) {
                    System.arraycopy(bArr, i10, data, offset, i9);
                    i10 += i9;
                    offset += scanlineStride;
                }
                return;
            }
            boolean z = dataBuffer instanceof DataBufferShort;
            if (z || (dataBuffer instanceof DataBufferUShort)) {
                short[] data2 = z ? ((DataBufferShort) dataBuffer).getData() : ((DataBufferUShort) dataBuffer).getData();
                int i12 = 0;
                for (int i13 = 0; i13 < i6; i13++) {
                    int i14 = offset;
                    int i15 = i5;
                    while (i15 > 8) {
                        int i16 = i12 + 1;
                        int i17 = (bArr[i12] & 255) << 8;
                        i12 += 2;
                        data2[i14] = (short) ((bArr[i16] & 255) | i17);
                        i15 -= 16;
                        i14++;
                    }
                    if (i15 > 0) {
                        data2[i14] = (short) ((bArr[i12] & 255) << 8);
                        i12++;
                    }
                    offset += scanlineStride;
                }
                return;
            }
            if (dataBuffer instanceof DataBufferInt) {
                int[] data3 = ((DataBufferInt) dataBuffer).getData();
                int i18 = 0;
                int i19 = 0;
                while (i19 < i6) {
                    int i20 = offset;
                    int i21 = i5;
                    while (i21 > i7) {
                        int i22 = i18 + 3;
                        int i23 = ((bArr[i18 + 2] & 255) << 8) | ((bArr[i18 + 1] & 255) << 16) | ((bArr[i18] & 255) << i7);
                        i18 += 4;
                        data3[i20] = i23 | (bArr[i22] & 255);
                        i21 -= 32;
                        i20++;
                        i7 = 24;
                    }
                    int i24 = 24;
                    while (i21 > 0) {
                        data3[i20] = ((bArr[i18] & 255) << i24) | data3[i20];
                        i24 -= 8;
                        i21 -= 8;
                        i18++;
                    }
                    offset += scanlineStride;
                    i19++;
                    i7 = 24;
                }
                return;
            }
            return;
        }
        int i25 = (i5 + 7) / 8;
        if (dataBuffer instanceof DataBufferByte) {
            byte[] data4 = ((DataBufferByte) dataBuffer).getData();
            int i26 = bitOffset & 7;
            if (i26 == 0) {
                int i27 = 0;
                for (int i28 = 0; i28 < i6; i28++) {
                    System.arraycopy(bArr, i27, data4, offset, i25);
                    i27 += i25;
                    offset += scanlineStride;
                }
                return;
            }
            int i29 = 8 - i26;
            int i30 = 16 - i26;
            byte b = (byte) (255 << i29);
            byte b5 = (byte) (~b);
            int i31 = 0;
            for (int i32 = 0; i32 < i6; i32++) {
                int i33 = offset;
                int i34 = i5;
                while (i34 > 0) {
                    int i35 = i31 + 1;
                    int i36 = bArr[i31];
                    if (i34 > i30) {
                        int i37 = i36 & 255;
                        data4[i33] = (byte) ((data4[i33] & b) | (i37 >>> i26));
                        i33++;
                        data4[i33] = (byte) (i37 << i29);
                    } else if (i34 > i29) {
                        int i38 = i36 & 255;
                        data4[i33] = (byte) ((data4[i33] & b) | (i38 >>> i26));
                        i33++;
                        data4[i33] = (byte) ((data4[i33] & b5) | (i38 << i29));
                    } else {
                        int i39 = (1 << (i29 - i34)) - 1;
                        data4[i33] = (byte) ((data4[i33] & (b | i39)) | ((~i39) & ((i36 & 255) >>> i26)));
                    }
                    i34 -= 8;
                    i31 = i35;
                }
                offset += scanlineStride;
            }
            return;
        }
        boolean z2 = dataBuffer instanceof DataBufferShort;
        if (!z2 && !(dataBuffer instanceof DataBufferUShort)) {
            if (dataBuffer instanceof DataBufferInt) {
                int[] data5 = ((DataBufferInt) dataBuffer).getData();
                int i40 = bitOffset & 7;
                int i41 = 8 - i40;
                int i42 = 40 - i40;
                int i43 = (-1) << i41;
                int i44 = ~i43;
                int i45 = 0;
                for (int i46 = 0; i46 < i6; i46++) {
                    int i47 = bitOffset;
                    int i48 = i5;
                    int i49 = 0;
                    while (i49 < i5) {
                        int i50 = offset + (i47 >> 5);
                        int i51 = i47 & 31;
                        int i52 = i45 + 1;
                        int i53 = bArr[i45] & i8;
                        int i54 = i8;
                        if (i51 <= 24) {
                            int i55 = 24 - i51;
                            i = i48;
                            data5[i50] = (data5[i50] & (~(i54 << i55))) | ((i < 8 ? i53 & (i54 << (8 - i)) : i53) << i55);
                        } else {
                            i = i48;
                            if (i > i42) {
                                data5[i50] = (data5[i50] & i43) | (i53 >>> i40);
                                data5[i50 + 1] = i53 << i41;
                            } else if (i > i41) {
                                data5[i50] = (data5[i50] & i43) | (i53 >>> i40);
                                int i56 = i50 + 1;
                                data5[i56] = (data5[i56] & i44) | (i53 << i41);
                            } else {
                                int i57 = (1 << (i41 - i)) - 1;
                                data5[i50] = ((i53 >>> i40) & (~i57)) | (data5[i50] & (i43 | i57));
                            }
                        }
                        i49 += 8;
                        i47 += 8;
                        i48 = i - 8;
                        i45 = i52;
                        i8 = i54;
                    }
                    offset += scanlineStride;
                }
                return;
            }
            return;
        }
        short[] data6 = z2 ? ((DataBufferShort) dataBuffer).getData() : ((DataBufferUShort) dataBuffer).getData();
        int i58 = bitOffset & 7;
        int i59 = 8 - i58;
        int i60 = 24 - i58;
        short s = (short) (~(255 << i59));
        int i61 = 65535;
        short s2 = (short) (65535 << i59);
        short s3 = (short) (~s2);
        int i62 = 0;
        int i63 = 0;
        while (i62 < i6) {
            int i64 = bitOffset;
            int i65 = i61;
            int i66 = 0;
            int i67 = i5;
            while (i66 < i5) {
                int i68 = offset + (i64 >> 4);
                short[] sArr = data6;
                int i69 = i64 & 15;
                int i70 = i63 + 1;
                int i71 = i6;
                int i72 = bArr[i63] & 255;
                if (i69 <= 8) {
                    if (i67 < 8) {
                        i72 &= 255 << (8 - i67);
                    }
                    sArr[i68] = (short) ((sArr[i68] & s) | (i72 << i59));
                } else if (i67 > i60) {
                    sArr[i68] = (short) ((sArr[i68] & s2) | ((i72 >>> i58) & i65));
                    sArr[i68 + 1] = (short) ((i72 << i59) & i65);
                } else if (i67 > i59) {
                    sArr[i68] = (short) ((sArr[i68] & s2) | ((i72 >>> i58) & i65));
                    int i73 = i68 + 1;
                    sArr[i73] = (short) ((sArr[i73] & s3) | ((i72 << i59) & i65));
                } else {
                    int i74 = (1 << (i59 - i67)) - 1;
                    sArr[i68] = (short) ((sArr[i68] & (s2 | i74)) | ((~i74) & (i72 >>> i58) & i65));
                }
                i66 += 8;
                i64 += 8;
                i67 -= 8;
                data6 = sArr;
                i63 = i70;
                i6 = i71;
            }
            offset += scanlineStride;
            i62++;
            i61 = i65;
            i6 = i6;
        }
    }

    public static void setUnpackedBinaryData(byte[] bArr, WritableRaster writableRaster, Rectangle rectangle) {
        SampleModel sampleModel = writableRaster.getSampleModel();
        if (!isBinary(sampleModel)) {
            throw new IllegalArgumentException(I18N.getString("ImageUtil0"));
        }
        int i = rectangle.f10094x;
        int i2 = rectangle.f10095y;
        int i4 = rectangle.width;
        int i5 = rectangle.height;
        DataBuffer dataBuffer = writableRaster.getDataBuffer();
        int sampleModelTranslateX = i - writableRaster.getSampleModelTranslateX();
        int sampleModelTranslateY = i2 - writableRaster.getSampleModelTranslateY();
        MultiPixelPackedSampleModel multiPixelPackedSampleModel = (MultiPixelPackedSampleModel) sampleModel;
        int scanlineStride = multiPixelPackedSampleModel.getScanlineStride();
        int offset = multiPixelPackedSampleModel.getOffset(sampleModelTranslateX, sampleModelTranslateY) + dataBuffer.getOffset();
        int bitOffset = multiPixelPackedSampleModel.getBitOffset(sampleModelTranslateX);
        if (dataBuffer instanceof DataBufferByte) {
            byte[] data = ((DataBufferByte) dataBuffer).getData();
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                int i8 = (offset * 8) + bitOffset;
                int i9 = 0;
                while (i9 < i4) {
                    int i10 = i6 + 1;
                    if (bArr[i6] != 0) {
                        int i11 = i8 / 8;
                        data[i11] = (byte) (data[i11] | ((byte) (1 << ((7 - i8) & 7))));
                    }
                    i8++;
                    i9++;
                    i6 = i10;
                }
                offset += scanlineStride;
            }
            return;
        }
        boolean z = dataBuffer instanceof DataBufferShort;
        if (z || (dataBuffer instanceof DataBufferUShort)) {
            short[] data2 = z ? ((DataBufferShort) dataBuffer).getData() : ((DataBufferUShort) dataBuffer).getData();
            int i12 = 0;
            for (int i13 = 0; i13 < i5; i13++) {
                int i14 = (offset * 16) + bitOffset;
                int i15 = 0;
                while (i15 < i4) {
                    int i16 = i12 + 1;
                    if (bArr[i12] != 0) {
                        int i17 = i14 / 16;
                        data2[i17] = (short) (data2[i17] | ((short) (1 << (15 - (i14 % 16)))));
                    }
                    i14++;
                    i15++;
                    i12 = i16;
                }
                offset += scanlineStride;
            }
            return;
        }
        if (dataBuffer instanceof DataBufferInt) {
            int[] data3 = ((DataBufferInt) dataBuffer).getData();
            int i18 = 0;
            for (int i19 = 0; i19 < i5; i19++) {
                int i20 = (offset * 32) + bitOffset;
                int i21 = 0;
                while (i21 < i4) {
                    int i22 = i18 + 1;
                    if (bArr[i18] != 0) {
                        int i23 = i20 / 32;
                        data3[i23] = data3[i23] | (1 << (31 - (i20 % 32)));
                    }
                    i20++;
                    i21++;
                    i18 = i22;
                }
                offset += scanlineStride;
            }
        }
    }

    public static final void canEncodeImage(ImageWriter imageWriter, ColorModel colorModel, SampleModel sampleModel) throws IIOException {
        canEncodeImage(imageWriter, (colorModel == null || sampleModel == null) ? null : new ImageTypeSpecifier(colorModel, sampleModel));
    }

    public static ColorModel createColorModel(ColorSpace colorSpace, SampleModel sampleModel) {
        int i;
        int i2;
        int i4;
        int i5;
        int i6;
        ColorSpace colorSpace2;
        ColorSpace colorSpace3;
        if (sampleModel != null) {
            int numBands = sampleModel.getNumBands();
            if (numBands < 1 || numBands > 4) {
                return null;
            }
            int dataType = sampleModel.getDataType();
            int i7 = 0;
            if (sampleModel instanceof ComponentSampleModel) {
                if (dataType < 0 || dataType > 5) {
                    return null;
                }
                if (colorSpace == null) {
                    if (numBands <= 2) {
                        colorSpace3 = ColorSpace.getInstance(1003);
                    } else {
                        colorSpace3 = ColorSpace.getInstance(1000);
                    }
                    i6 = 3;
                    colorSpace2 = colorSpace3;
                } else {
                    i6 = 3;
                    colorSpace2 = colorSpace;
                }
                boolean z = numBands == 2 || numBands == 4;
                int i8 = z ? i6 : 1;
                int dataTypeSize = DataBuffer.getDataTypeSize(dataType);
                int[] iArr = new int[numBands];
                while (i7 < numBands) {
                    iArr[i7] = dataTypeSize;
                    i7++;
                }
                return new ComponentColorModel(colorSpace2, iArr, z, false, i8, dataType);
            }
            if (sampleModel instanceof SinglePixelPackedSampleModel) {
                SinglePixelPackedSampleModel singlePixelPackedSampleModel = (SinglePixelPackedSampleModel) sampleModel;
                int[] bitMasks = singlePixelPackedSampleModel.getBitMasks();
                int length = bitMasks.length;
                if (length <= 2) {
                    int i9 = bitMasks[0];
                    if (length == 2) {
                        i4 = bitMasks[1];
                        i5 = i9;
                        i = i5;
                        i2 = i;
                    } else {
                        i5 = i9;
                        i = i5;
                        i2 = i;
                        i4 = 0;
                    }
                } else {
                    int i10 = bitMasks[0];
                    int i11 = bitMasks[1];
                    int i12 = bitMasks[2];
                    if (length == 4) {
                        i = i11;
                        i4 = bitMasks[3];
                        i2 = i12;
                    } else {
                        i = i11;
                        i2 = i12;
                        i4 = 0;
                    }
                    i5 = i10;
                }
                int[] sampleSize = singlePixelPackedSampleModel.getSampleSize();
                int i13 = 0;
                while (i7 < sampleSize.length) {
                    i13 += sampleSize[i7];
                    i7++;
                }
                return new DirectColorModel(colorSpace == null ? ColorSpace.getInstance(1000) : colorSpace, i13, i5, i, i2, i4, false, sampleModel.getDataType());
            }
            if (!(sampleModel instanceof MultiPixelPackedSampleModel)) {
                return null;
            }
            int pixelBitStride = ((MultiPixelPackedSampleModel) sampleModel).getPixelBitStride();
            int i14 = 1 << pixelBitStride;
            byte[] bArr = new byte[i14];
            while (i7 < i14) {
                bArr[i7] = (byte) ((i7 * 255) / (i14 - 1));
                i7++;
            }
            return new IndexColorModel(pixelBitStride, i14, bArr, bArr, bArr);
        }
        throw new IllegalArgumentException(I18N.getString("ImageUtil1"));
    }
}
