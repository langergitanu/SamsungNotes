package org.apache.poi.java.awt.image;

import androidx.glance.AbstractC2821a;
import kotlin.UShort;

/* JADX INFO: loaded from: classes10.dex */
public final class BandedSampleModel extends ComponentSampleModel {
    public BandedSampleModel(int i, int i2, int i4, int i5) {
        super(i, i2, i4, 1, i2, createIndicesArray(i5), createOffsetArray(i5));
    }

    private static int[] createIndicesArray(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = i2;
        }
        return iArr;
    }

    private static int[] createOffsetArray(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = 0;
        }
        return iArr;
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public SampleModel createCompatibleSampleModel(int i, int i2) {
        return new BandedSampleModel(this.dataType, i, i2, i, this.bankIndices, this.numBanks == 1 ? orderBands(this.bandOffsets, i * i2) : new int[this.bandOffsets.length]);
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public DataBuffer createDataBuffer() {
        int i = this.scanlineStride * this.height;
        int i2 = this.dataType;
        if (i2 == 0) {
            return new DataBufferByte(i, this.numBanks);
        }
        if (i2 == 1) {
            return new DataBufferUShort(i, this.numBanks);
        }
        if (i2 == 2) {
            return new DataBufferShort(i, this.numBanks);
        }
        if (i2 == 3) {
            return new DataBufferInt(i, this.numBanks);
        }
        if (i2 == 4) {
            return new DataBufferFloat(i, this.numBanks);
        }
        if (i2 == 5) {
            return new DataBufferDouble(i, this.numBanks);
        }
        throw new IllegalArgumentException("dataType is not one of the supported types.");
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public SampleModel createSubsetSampleModel(int[] iArr) {
        if (iArr.length > this.bankIndices.length) {
            throw new RasterFormatException(AbstractC2821a.m2223n(new StringBuilder("There are only "), " bands", this.bankIndices.length));
        }
        int[] iArr2 = new int[iArr.length];
        int[] iArr3 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = this.bankIndices[iArr[i]];
            iArr3[i] = this.bandOffsets[iArr[i]];
        }
        return new BandedSampleModel(this.dataType, this.width, this.height, this.scanlineStride, iArr2, iArr3);
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public Object getDataElements(int i, int i2, Object obj, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int transferType = getTransferType();
        int numDataElements = getNumDataElements();
        int i4 = (i2 * this.scanlineStride) + i;
        int i5 = 0;
        if (transferType == 0) {
            byte[] bArr = obj == null ? new byte[numDataElements] : (byte[]) obj;
            while (i5 < numDataElements) {
                bArr[i5] = (byte) dataBuffer.getElem(this.bankIndices[i5], this.bandOffsets[i5] + i4);
                i5++;
            }
            return bArr;
        }
        if (transferType == 1 || transferType == 2) {
            short[] sArr = obj == null ? new short[numDataElements] : (short[]) obj;
            while (i5 < numDataElements) {
                sArr[i5] = (short) dataBuffer.getElem(this.bankIndices[i5], this.bandOffsets[i5] + i4);
                i5++;
            }
            return sArr;
        }
        if (transferType == 3) {
            int[] iArr = obj == null ? new int[numDataElements] : (int[]) obj;
            while (i5 < numDataElements) {
                iArr[i5] = dataBuffer.getElem(this.bankIndices[i5], this.bandOffsets[i5] + i4);
                i5++;
            }
            return iArr;
        }
        if (transferType == 4) {
            float[] fArr = obj == null ? new float[numDataElements] : (float[]) obj;
            while (i5 < numDataElements) {
                fArr[i5] = dataBuffer.getElemFloat(this.bankIndices[i5], this.bandOffsets[i5] + i4);
                i5++;
            }
            return fArr;
        }
        if (transferType != 5) {
            return obj;
        }
        double[] dArr = obj == null ? new double[numDataElements] : (double[]) obj;
        while (i5 < numDataElements) {
            dArr[i5] = dataBuffer.getElemDouble(this.bankIndices[i5], this.bandOffsets[i5] + i4);
            i5++;
        }
        return dArr;
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public int[] getPixel(int i, int i2, int[] iArr, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (iArr == null) {
            iArr = new int[((ComponentSampleModel) this).numBands];
        }
        int i4 = (i2 * this.scanlineStride) + i;
        for (int i5 = 0; i5 < ((ComponentSampleModel) this).numBands; i5++) {
            iArr[i5] = dataBuffer.getElem(this.bankIndices[i5], this.bandOffsets[i5] + i4);
        }
        return iArr;
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public int[] getPixels(int i, int i2, int i4, int i5, int[] iArr, DataBuffer dataBuffer) {
        int i6;
        int i7;
        int i8 = i + i4;
        int i9 = i2 + i5;
        if (i < 0 || i >= (i6 = this.width) || i4 > i6 || i8 < 0 || i8 > i6 || i2 < 0 || i2 >= (i7 = this.height) || i5 > i7 || i9 < 0 || i9 > i7) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (iArr == null) {
            iArr = new int[i4 * i5 * ((ComponentSampleModel) this).numBands];
        }
        for (int i10 = 0; i10 < ((ComponentSampleModel) this).numBands; i10++) {
            int i11 = (this.scanlineStride * i2) + i + this.bandOffsets[i10];
            int i12 = this.bankIndices[i10];
            int i13 = i10;
            for (int i14 = 0; i14 < i5; i14++) {
                int i15 = 0;
                int i16 = i11;
                while (i15 < i4) {
                    iArr[i13] = dataBuffer.getElem(i12, i16);
                    i13 += ((ComponentSampleModel) this).numBands;
                    i15++;
                    i16++;
                }
                i11 += this.scanlineStride;
            }
        }
        return iArr;
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public int getSample(int i, int i2, int i4, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        return dataBuffer.getElem(this.bankIndices[i4], (i2 * this.scanlineStride) + i + this.bandOffsets[i4]);
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public double getSampleDouble(int i, int i2, int i4, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        return dataBuffer.getElemDouble(this.bankIndices[i4], (i2 * this.scanlineStride) + i + this.bandOffsets[i4]);
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public float getSampleFloat(int i, int i2, int i4, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        return dataBuffer.getElemFloat(this.bankIndices[i4], (i2 * this.scanlineStride) + i + this.bandOffsets[i4]);
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public int[] getSamples(int i, int i2, int i4, int i5, int i6, int[] iArr, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i + i4 > this.width || i2 + i5 > this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (iArr == null) {
            iArr = new int[i4 * i5];
        }
        int i7 = (i2 * this.scanlineStride) + i + this.bandOffsets[i6];
        int i8 = this.bankIndices[i6];
        int i9 = 0;
        for (int i10 = 0; i10 < i5; i10++) {
            int i11 = i7;
            int i12 = 0;
            while (i12 < i4) {
                iArr[i9] = dataBuffer.getElem(i8, i11);
                i12++;
                i9++;
                i11++;
            }
            i7 += this.scanlineStride;
        }
        return iArr;
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel
    public int hashCode() {
        return super.hashCode() ^ 2;
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public void setDataElements(int i, int i2, Object obj, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int transferType = getTransferType();
        int numDataElements = getNumDataElements();
        int i4 = (i2 * this.scanlineStride) + i;
        int i5 = 0;
        if (transferType == 0) {
            byte[] bArr = (byte[]) obj;
            while (i5 < numDataElements) {
                dataBuffer.setElem(this.bankIndices[i5], this.bandOffsets[i5] + i4, bArr[i5] & 255);
                i5++;
            }
            return;
        }
        if (transferType == 1 || transferType == 2) {
            short[] sArr = (short[]) obj;
            while (i5 < numDataElements) {
                dataBuffer.setElem(this.bankIndices[i5], this.bandOffsets[i5] + i4, sArr[i5] & UShort.MAX_VALUE);
                i5++;
            }
            return;
        }
        if (transferType == 3) {
            int[] iArr = (int[]) obj;
            while (i5 < numDataElements) {
                dataBuffer.setElem(this.bankIndices[i5], this.bandOffsets[i5] + i4, iArr[i5]);
                i5++;
            }
            return;
        }
        if (transferType == 4) {
            float[] fArr = (float[]) obj;
            while (i5 < numDataElements) {
                dataBuffer.setElemFloat(this.bankIndices[i5], this.bandOffsets[i5] + i4, fArr[i5]);
                i5++;
            }
            return;
        }
        if (transferType != 5) {
            return;
        }
        double[] dArr = (double[]) obj;
        while (i5 < numDataElements) {
            dataBuffer.setElemDouble(this.bankIndices[i5], this.bandOffsets[i5] + i4, dArr[i5]);
            i5++;
        }
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public void setPixel(int i, int i2, int[] iArr, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int i4 = (i2 * this.scanlineStride) + i;
        for (int i5 = 0; i5 < ((ComponentSampleModel) this).numBands; i5++) {
            dataBuffer.setElem(this.bankIndices[i5], this.bandOffsets[i5] + i4, iArr[i5]);
        }
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public void setPixels(int i, int i2, int i4, int i5, int[] iArr, DataBuffer dataBuffer) {
        int i6;
        int i7;
        int i8 = i + i4;
        int i9 = i2 + i5;
        if (i < 0 || i >= (i6 = this.width) || i4 > i6 || i8 < 0 || i8 > i6 || i2 < 0 || i2 >= (i7 = this.height) || i5 > i7 || i9 < 0 || i9 > i7) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        for (int i10 = 0; i10 < ((ComponentSampleModel) this).numBands; i10++) {
            int i11 = (this.scanlineStride * i2) + i + this.bandOffsets[i10];
            int i12 = this.bankIndices[i10];
            int i13 = i10;
            for (int i14 = 0; i14 < i5; i14++) {
                int i15 = 0;
                int i16 = i11;
                while (i15 < i4) {
                    dataBuffer.setElem(i12, i16, iArr[i13]);
                    i13 += ((ComponentSampleModel) this).numBands;
                    i15++;
                    i16++;
                }
                i11 += this.scanlineStride;
            }
        }
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public void setSample(int i, int i2, int i4, double d, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        dataBuffer.setElemDouble(this.bankIndices[i4], (i2 * this.scanlineStride) + i + this.bandOffsets[i4], d);
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public void setSamples(int i, int i2, int i4, int i5, int i6, int[] iArr, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i + i4 > this.width || i2 + i5 > this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int i7 = (i2 * this.scanlineStride) + i + this.bandOffsets[i6];
        int i8 = this.bankIndices[i6];
        int i9 = 0;
        for (int i10 = 0; i10 < i5; i10++) {
            int i11 = i7;
            int i12 = 0;
            while (i12 < i4) {
                dataBuffer.setElem(i8, i11, iArr[i9]);
                i12++;
                i11++;
                i9++;
            }
            i7 += this.scanlineStride;
        }
    }

    public BandedSampleModel(int i, int i2, int i4, int i5, int[] iArr, int[] iArr2) {
        super(i, i2, i4, 1, i5, iArr, iArr2);
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public void setSample(int i, int i2, int i4, float f, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        dataBuffer.setElemFloat(this.bankIndices[i4], (i2 * this.scanlineStride) + i + this.bandOffsets[i4], f);
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public void setSample(int i, int i2, int i4, int i5, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        dataBuffer.setElem(this.bankIndices[i4], (i2 * this.scanlineStride) + i + this.bandOffsets[i4], i5);
    }
}
