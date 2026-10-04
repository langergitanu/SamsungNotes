package org.apache.poi.java.awt.image;

import kotlin.UShort;
import p001A.AbstractC0000a;

/* JADX INFO: loaded from: classes10.dex */
public class MultiPixelPackedSampleModel extends SampleModel {
    int bitMask;
    int dataBitOffset;
    int dataElementSize;
    int pixelBitStride;
    int pixelsPerDataElement;
    int scanlineStride;

    public MultiPixelPackedSampleModel(int i, int i2, int i4, int i5) {
        this(i, i2, i4, i5, ((DataBuffer.getDataTypeSize(i) + (i2 * i5)) - 1) / DataBuffer.getDataTypeSize(i), 0);
        if (i != 0 && i != 1 && i != 3) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unsupported data type "));
        }
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public SampleModel createCompatibleSampleModel(int i, int i2) {
        return new MultiPixelPackedSampleModel(this.dataType, i, i2, this.pixelBitStride);
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public DataBuffer createDataBuffer() {
        int i = this.scanlineStride * this.height;
        int i2 = this.dataType;
        if (i2 == 0) {
            return new DataBufferByte(((this.dataBitOffset + 7) / 8) + i);
        }
        if (i2 == 1) {
            return new DataBufferUShort(((this.dataBitOffset + 15) / 16) + i);
        }
        if (i2 != 3) {
            return null;
        }
        return new DataBufferInt(((this.dataBitOffset + 31) / 32) + i);
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public SampleModel createSubsetSampleModel(int[] iArr) {
        if (iArr == null || iArr.length == 1) {
            return createCompatibleSampleModel(this.width, this.height);
        }
        throw new RasterFormatException("MultiPixelPackedSampleModel has only one band.");
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof MultiPixelPackedSampleModel)) {
            MultiPixelPackedSampleModel multiPixelPackedSampleModel = (MultiPixelPackedSampleModel) obj;
            if (this.width == multiPixelPackedSampleModel.width && this.height == multiPixelPackedSampleModel.height && this.numBands == multiPixelPackedSampleModel.numBands && this.dataType == multiPixelPackedSampleModel.dataType && this.pixelBitStride == multiPixelPackedSampleModel.pixelBitStride && this.bitMask == multiPixelPackedSampleModel.bitMask && this.pixelsPerDataElement == multiPixelPackedSampleModel.pixelsPerDataElement && this.dataElementSize == multiPixelPackedSampleModel.dataElementSize && this.dataBitOffset == multiPixelPackedSampleModel.dataBitOffset && this.scanlineStride == multiPixelPackedSampleModel.scanlineStride) {
                return true;
            }
        }
        return false;
    }

    public int getBitOffset(int i) {
        return ((i * this.pixelBitStride) + this.dataBitOffset) % this.dataElementSize;
    }

    public int getDataBitOffset() {
        return this.dataBitOffset;
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public Object getDataElements(int i, int i2, Object obj, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int transferType = getTransferType();
        int i4 = this.dataBitOffset;
        int i5 = this.pixelBitStride;
        int i6 = (i * i5) + i4;
        int i7 = this.dataElementSize;
        int i8 = (i7 - ((i7 - 1) & i6)) - i5;
        if (transferType == 0) {
            byte[] bArr = obj == null ? new byte[1] : (byte[]) obj;
            bArr[0] = (byte) ((dataBuffer.getElem((i6 / i7) + (i2 * this.scanlineStride)) >> i8) & this.bitMask);
            return bArr;
        }
        if (transferType == 1) {
            short[] sArr = obj == null ? new short[1] : (short[]) obj;
            sArr[0] = (short) ((dataBuffer.getElem((i6 / i7) + (i2 * this.scanlineStride)) >> i8) & this.bitMask);
            return sArr;
        }
        if (transferType != 3) {
            return obj;
        }
        int[] iArr = obj == null ? new int[1] : (int[]) obj;
        iArr[0] = (dataBuffer.getElem((i6 / i7) + (i2 * this.scanlineStride)) >> i8) & this.bitMask;
        return iArr;
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int getNumDataElements() {
        return 1;
    }

    public int getOffset(int i, int i2) {
        return (((i * this.pixelBitStride) + this.dataBitOffset) / this.dataElementSize) + (i2 * this.scanlineStride);
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int[] getPixel(int i, int i2, int[] iArr, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (iArr == null) {
            iArr = new int[this.numBands];
        }
        int i4 = (i * this.pixelBitStride) + this.dataBitOffset;
        int elem = dataBuffer.getElem((i4 / this.dataElementSize) + (i2 * this.scanlineStride));
        int i5 = this.dataElementSize;
        iArr[0] = (elem >> ((i5 - (i4 & (i5 - 1))) - this.pixelBitStride)) & this.bitMask;
        return iArr;
    }

    public int getPixelBitStride() {
        return this.pixelBitStride;
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int getSample(int i, int i2, int i4, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height || i4 != 0) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int i5 = (i * this.pixelBitStride) + this.dataBitOffset;
        int elem = dataBuffer.getElem((i5 / this.dataElementSize) + (i2 * this.scanlineStride));
        int i6 = this.dataElementSize;
        return (elem >> ((i6 - (i5 & (i6 - 1))) - this.pixelBitStride)) & this.bitMask;
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int getSampleSize(int i) {
        return this.pixelBitStride;
    }

    public int getScanlineStride() {
        return this.scanlineStride;
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int getTransferType() {
        int i = this.pixelBitStride;
        if (i > 16) {
            return 3;
        }
        return i > 8 ? 1 : 0;
    }

    public int hashCode() {
        return (((((((((((((((((this.width << 8) ^ this.height) << 8) ^ this.numBands) << 8) ^ this.dataType) << 8) ^ this.pixelBitStride) << 8) ^ this.bitMask) << 8) ^ this.pixelsPerDataElement) << 8) ^ this.dataElementSize) << 8) ^ this.dataBitOffset) << 8) ^ this.scanlineStride;
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public void setDataElements(int i, int i2, Object obj, DataBuffer dataBuffer) {
        int i4;
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int transferType = getTransferType();
        int i5 = this.dataBitOffset;
        int i6 = this.pixelBitStride;
        int i7 = (i * i6) + i5;
        int i8 = i2 * this.scanlineStride;
        int i9 = this.dataElementSize;
        int i10 = (i7 / i9) + i8;
        int i11 = (i9 - (i7 & (i9 - 1))) - i6;
        int elem = dataBuffer.getElem(i10);
        int i12 = this.bitMask;
        int i13 = elem & (~(i12 << i11));
        if (transferType == 0) {
            i4 = ((byte[]) obj)[0] & 255;
        } else if (transferType == 1) {
            i4 = ((short[]) obj)[0] & UShort.MAX_VALUE;
        } else if (transferType != 3) {
            return;
        } else {
            i4 = ((int[]) obj)[0];
        }
        dataBuffer.setElem(i10, i13 | ((i12 & i4) << i11));
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public void setPixel(int i, int i2, int[] iArr, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int i4 = this.dataBitOffset;
        int i5 = this.pixelBitStride;
        int i6 = (i * i5) + i4;
        int i7 = i2 * this.scanlineStride;
        int i8 = this.dataElementSize;
        int i9 = (i6 / i8) + i7;
        int i10 = (i8 - (i6 & (i8 - 1))) - i5;
        int elem = dataBuffer.getElem(i9);
        int i11 = this.bitMask;
        dataBuffer.setElem(i9, (elem & (~(i11 << i10))) | ((i11 & iArr[0]) << i10));
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public void setSample(int i, int i2, int i4, int i5, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height || i4 != 0) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int i6 = this.dataBitOffset;
        int i7 = this.pixelBitStride;
        int i8 = (i * i7) + i6;
        int i9 = i2 * this.scanlineStride;
        int i10 = this.dataElementSize;
        int i11 = (i8 / i10) + i9;
        int i12 = (i10 - (i8 & (i10 - 1))) - i7;
        int elem = dataBuffer.getElem(i11);
        int i13 = this.bitMask;
        dataBuffer.setElem(i11, (elem & (~(i13 << i12))) | ((i13 & i5) << i12));
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int[] getSampleSize() {
        return new int[]{this.pixelBitStride};
    }

    public MultiPixelPackedSampleModel(int i, int i2, int i4, int i5, int i6, int i7) {
        super(i, i2, i4, 1);
        if (i != 0 && i != 1 && i != 3) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unsupported data type "));
        }
        this.dataType = i;
        this.pixelBitStride = i5;
        this.scanlineStride = i6;
        this.dataBitOffset = i7;
        int dataTypeSize = DataBuffer.getDataTypeSize(i);
        this.dataElementSize = dataTypeSize;
        int i8 = dataTypeSize / i5;
        this.pixelsPerDataElement = i8;
        if (i8 * i5 != dataTypeSize) {
            throw new RasterFormatException("MultiPixelPackedSampleModel does not allow pixels to span data element boundaries");
        }
        this.bitMask = (1 << i5) - 1;
    }
}
