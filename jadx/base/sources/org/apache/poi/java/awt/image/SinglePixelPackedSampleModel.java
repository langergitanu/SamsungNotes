package org.apache.poi.java.awt.image;

import androidx.glance.AbstractC2821a;
import java.util.Arrays;
import kotlin.UShort;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SinglePixelPackedSampleModel extends SampleModel {
    private int[] bitMasks;
    private int[] bitOffsets;
    private int[] bitSizes;
    private int maxBitSize;
    private int scanlineStride;

    static {
        ColorModel.loadLibraries();
    }

    public SinglePixelPackedSampleModel(int i, int i2, int i4, int[] iArr) {
        this(i, i2, i4, i2, iArr);
        if (i != 0 && i != 1 && i != 3) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unsupported data type "));
        }
    }

    private long getBufferSize() {
        return ((this.height - 1) * this.scanlineStride) + this.width;
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public SampleModel createCompatibleSampleModel(int i, int i2) {
        return new SinglePixelPackedSampleModel(this.dataType, i, i2, this.bitMasks);
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public DataBuffer createDataBuffer() {
        int bufferSize = (int) getBufferSize();
        int i = this.dataType;
        if (i == 0) {
            return new DataBufferByte(bufferSize);
        }
        if (i == 1) {
            return new DataBufferUShort(bufferSize);
        }
        if (i != 3) {
            return null;
        }
        return new DataBufferInt(bufferSize);
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public SampleModel createSubsetSampleModel(int[] iArr) {
        if (iArr.length > this.numBands) {
            throw new RasterFormatException(AbstractC2821a.m2223n(new StringBuilder("There are only "), " bands", this.numBands));
        }
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = this.bitMasks[iArr[i]];
        }
        return new SinglePixelPackedSampleModel(this.dataType, this.width, this.height, this.scanlineStride, iArr2);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof SinglePixelPackedSampleModel)) {
            SinglePixelPackedSampleModel singlePixelPackedSampleModel = (SinglePixelPackedSampleModel) obj;
            if (this.width == singlePixelPackedSampleModel.width && this.height == singlePixelPackedSampleModel.height && this.numBands == singlePixelPackedSampleModel.numBands && this.dataType == singlePixelPackedSampleModel.dataType && Arrays.equals(this.bitMasks, singlePixelPackedSampleModel.bitMasks) && Arrays.equals(this.bitOffsets, singlePixelPackedSampleModel.bitOffsets) && Arrays.equals(this.bitSizes, singlePixelPackedSampleModel.bitSizes) && this.maxBitSize == singlePixelPackedSampleModel.maxBitSize && this.scanlineStride == singlePixelPackedSampleModel.scanlineStride) {
                return true;
            }
        }
        return false;
    }

    public int[] getBitMasks() {
        return (int[]) this.bitMasks.clone();
    }

    public int[] getBitOffsets() {
        return (int[]) this.bitOffsets.clone();
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public Object getDataElements(int i, int i2, Object obj, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int transferType = getTransferType();
        if (transferType == 0) {
            byte[] bArr = obj == null ? new byte[1] : (byte[]) obj;
            bArr[0] = (byte) dataBuffer.getElem((i2 * this.scanlineStride) + i);
            return bArr;
        }
        if (transferType == 1) {
            short[] sArr = obj == null ? new short[1] : (short[]) obj;
            sArr[0] = (short) dataBuffer.getElem((i2 * this.scanlineStride) + i);
            return sArr;
        }
        if (transferType != 3) {
            return obj;
        }
        int[] iArr = obj == null ? new int[1] : (int[]) obj;
        iArr[0] = dataBuffer.getElem((i2 * this.scanlineStride) + i);
        return iArr;
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int getNumDataElements() {
        return 1;
    }

    public int getOffset(int i, int i2) {
        return (i2 * this.scanlineStride) + i;
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int[] getPixel(int i, int i2, int[] iArr, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (iArr == null) {
            iArr = new int[this.numBands];
        }
        int elem = dataBuffer.getElem((i2 * this.scanlineStride) + i);
        for (int i4 = 0; i4 < this.numBands; i4++) {
            iArr[i4] = (this.bitMasks[i4] & elem) >>> this.bitOffsets[i4];
        }
        return iArr;
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int[] getPixels(int i, int i2, int i4, int i5, int[] iArr, DataBuffer dataBuffer) {
        int i6;
        int i7;
        int i8 = i + i4;
        int i9 = i2 + i5;
        if (i < 0 || i >= (i6 = this.width) || i4 > i6 || i8 < 0 || i8 > i6 || i2 < 0 || i2 >= (i7 = this.height) || i5 > i7 || i9 < 0 || i9 > i7) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (iArr == null) {
            iArr = new int[i4 * i5 * this.numBands];
        }
        int i10 = (i2 * this.scanlineStride) + i;
        int i11 = 0;
        for (int i12 = 0; i12 < i5; i12++) {
            for (int i13 = 0; i13 < i4; i13++) {
                int elem = dataBuffer.getElem(i10 + i13);
                int i14 = 0;
                while (i14 < this.numBands) {
                    iArr[i11] = (this.bitMasks[i14] & elem) >>> this.bitOffsets[i14];
                    i14++;
                    i11++;
                }
            }
            i10 += this.scanlineStride;
        }
        return iArr;
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int getSample(int i, int i2, int i4, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        return (dataBuffer.getElem((i2 * this.scanlineStride) + i) & this.bitMasks[i4]) >>> this.bitOffsets[i4];
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int[] getSampleSize() {
        return (int[]) this.bitSizes.clone();
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int[] getSamples(int i, int i2, int i4, int i5, int i6, int[] iArr, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i + i4 > this.width || i2 + i5 > this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (iArr == null) {
            iArr = new int[i4 * i5];
        }
        int i7 = (i2 * this.scanlineStride) + i;
        int i8 = 0;
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = 0;
            while (i10 < i4) {
                iArr[i8] = (dataBuffer.getElem(i7 + i10) & this.bitMasks[i6]) >>> this.bitOffsets[i6];
                i10++;
                i8++;
            }
            i7 += this.scanlineStride;
        }
        return iArr;
    }

    public int getScanlineStride() {
        return this.scanlineStride;
    }

    public int hashCode() {
        int i = ((((((this.width << 8) ^ this.height) << 8) ^ this.numBands) << 8) ^ this.dataType) << 8;
        int i2 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.bitMasks;
            if (i4 >= iArr.length) {
                break;
            }
            i = (i ^ iArr[i4]) << 8;
            i4++;
        }
        int i5 = 0;
        while (true) {
            int[] iArr2 = this.bitOffsets;
            if (i5 >= iArr2.length) {
                break;
            }
            i = (i ^ iArr2[i5]) << 8;
            i5++;
        }
        while (true) {
            int[] iArr3 = this.bitSizes;
            if (i2 >= iArr3.length) {
                return ((i ^ this.maxBitSize) << 8) ^ this.scanlineStride;
            }
            i = (i ^ iArr3[i2]) << 8;
            i2++;
        }
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public void setDataElements(int i, int i2, Object obj, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int transferType = getTransferType();
        if (transferType == 0) {
            dataBuffer.setElem((i2 * this.scanlineStride) + i, ((byte[]) obj)[0] & 255);
        } else if (transferType == 1) {
            dataBuffer.setElem((i2 * this.scanlineStride) + i, ((short[]) obj)[0] & UShort.MAX_VALUE);
        } else {
            if (transferType != 3) {
                return;
            }
            dataBuffer.setElem((i2 * this.scanlineStride) + i, ((int[]) obj)[0]);
        }
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public void setPixel(int i, int i2, int[] iArr, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int i4 = (i2 * this.scanlineStride) + i;
        int elem = dataBuffer.getElem(i4);
        for (int i5 = 0; i5 < this.numBands; i5++) {
            int i6 = this.bitMasks[i5];
            elem = (elem & (~i6)) | (i6 & (iArr[i5] << this.bitOffsets[i5]));
        }
        dataBuffer.setElem(i4, elem);
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public void setPixels(int i, int i2, int i4, int i5, int[] iArr, DataBuffer dataBuffer) {
        int i6;
        int i7;
        int i8 = i + i4;
        int i9 = i2 + i5;
        if (i < 0 || i >= (i6 = this.width) || i4 > i6 || i8 < 0 || i8 > i6 || i2 < 0 || i2 >= (i7 = this.height) || i5 > i7 || i9 < 0 || i9 > i7) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int i10 = (i2 * this.scanlineStride) + i;
        int i11 = 0;
        for (int i12 = 0; i12 < i5; i12++) {
            for (int i13 = 0; i13 < i4; i13++) {
                int i14 = i10 + i13;
                int elem = dataBuffer.getElem(i14);
                int i15 = 0;
                while (i15 < this.numBands) {
                    int i16 = this.bitMasks[i15];
                    elem = (elem & (~i16)) | ((iArr[i11] << this.bitOffsets[i15]) & i16);
                    i15++;
                    i11++;
                }
                dataBuffer.setElem(i14, elem);
            }
            i10 += this.scanlineStride;
        }
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public void setSample(int i, int i2, int i4, int i5, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int elem = dataBuffer.getElem((this.scanlineStride * i2) + i);
        int i6 = this.bitMasks[i4];
        dataBuffer.setElem((i2 * this.scanlineStride) + i, ((i5 << this.bitOffsets[i4]) & i6) | (elem & (~i6)));
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public void setSamples(int i, int i2, int i4, int i5, int i6, int[] iArr, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i + i4 > this.width || i2 + i5 > this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int i7 = (i2 * this.scanlineStride) + i;
        int i8 = 0;
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = 0;
            while (i10 < i4) {
                int i11 = i7 + i10;
                int elem = dataBuffer.getElem(i11);
                int i12 = this.bitMasks[i6];
                dataBuffer.setElem(i11, ((iArr[i8] << this.bitOffsets[i6]) & i12) | (elem & (~i12)));
                i10++;
                i8++;
            }
            i7 += this.scanlineStride;
        }
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int getSampleSize(int i) {
        return this.bitSizes[i];
    }

    public SinglePixelPackedSampleModel(int i, int i2, int i4, int i5, int[] iArr) {
        int i6;
        super(i, i2, i4, iArr.length);
        if (i != 0 && i != 1 && i != 3) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unsupported data type "));
        }
        this.dataType = i;
        this.bitMasks = (int[]) iArr.clone();
        this.scanlineStride = i5;
        int i7 = this.numBands;
        this.bitOffsets = new int[i7];
        this.bitSizes = new int[i7];
        int dataTypeSize = (int) ((1 << DataBuffer.getDataTypeSize(i)) - 1);
        this.maxBitSize = 0;
        for (int i8 = 0; i8 < this.numBands; i8++) {
            int[] iArr2 = this.bitMasks;
            int i9 = iArr2[i8] & dataTypeSize;
            iArr2[i8] = i9;
            int i10 = 0;
            if (i9 != 0) {
                while ((i9 & 1) == 0) {
                    i9 >>>= 1;
                    i10++;
                }
                i6 = 0;
                while ((i9 & 1) == 1) {
                    i9 >>>= 1;
                    i6++;
                }
                if (i9 != 0) {
                    throw new IllegalArgumentException(AbstractC2821a.m2223n(new StringBuilder("Mask "), " must be contiguous", iArr[i8]));
                }
            } else {
                i6 = 0;
            }
            this.bitOffsets[i8] = i10;
            this.bitSizes[i8] = i6;
            if (i6 > this.maxBitSize) {
                this.maxBitSize = i6;
            }
        }
    }
}
