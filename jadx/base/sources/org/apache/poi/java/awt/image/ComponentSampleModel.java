package org.apache.poi.java.awt.image;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import java.util.Arrays;
import kotlin.UShort;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ComponentSampleModel extends SampleModel {
    protected int[] bandOffsets;
    protected int[] bankIndices;
    protected int numBands;
    protected int numBanks;
    protected int pixelStride;
    protected int scanlineStride;

    static {
        ColorModel.loadLibraries();
    }

    public ComponentSampleModel(int i, int i2, int i4, int i5, int i6, int[] iArr) {
        super(i, i2, i4, iArr.length);
        this.numBands = 1;
        this.numBanks = 1;
        this.dataType = i;
        this.pixelStride = i5;
        this.scanlineStride = i6;
        int[] iArr2 = (int[]) iArr.clone();
        this.bandOffsets = iArr2;
        int length = iArr2.length;
        this.numBands = length;
        if (i5 < 0) {
            throw new IllegalArgumentException("Pixel stride must be >= 0");
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("Scanline stride must be >= 0");
        }
        if (length < 1) {
            throw new IllegalArgumentException("Must have at least one band.");
        }
        if (i < 0 || i > 5) {
            throw new IllegalArgumentException("Unsupported dataType.");
        }
        this.bankIndices = new int[length];
        for (int i7 = 0; i7 < this.numBands; i7++) {
            this.bankIndices[i7] = 0;
        }
        verify();
    }

    private int getBufferSize() {
        int iMax = this.bandOffsets[0];
        int i = 1;
        while (true) {
            int[] iArr = this.bandOffsets;
            if (i >= iArr.length) {
                break;
            }
            iMax = Math.max(iMax, iArr[i]);
            i++;
        }
        if (iMax < 0 || iMax > 2147483646) {
            throw new IllegalArgumentException("Invalid band offset");
        }
        int i2 = this.pixelStride;
        if (i2 >= 0) {
            int i4 = this.width;
            if (i2 <= Integer.MAX_VALUE / i4) {
                int i5 = this.scanlineStride;
                if (i5 >= 0) {
                    int i6 = this.height;
                    if (i5 <= Integer.MAX_VALUE / i6) {
                        int i7 = iMax + 1;
                        int i8 = (i4 - 1) * i2;
                        if (i8 > Integer.MAX_VALUE - i7) {
                            throw new IllegalArgumentException("Invalid pixel stride");
                        }
                        int i9 = i7 + i8;
                        int i10 = (i6 - 1) * i5;
                        if (i10 <= Integer.MAX_VALUE - i9) {
                            return i9 + i10;
                        }
                        throw new IllegalArgumentException("Invalid scan stride");
                    }
                }
                throw new IllegalArgumentException("Invalid scanline stride");
            }
        }
        throw new IllegalArgumentException("Invalid pixel stride");
    }

    private void verify() {
        getBufferSize();
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public SampleModel createCompatibleSampleModel(int i, int i2) {
        int[] iArr;
        int[] iArrOrderBands;
        int[] iArrOrderBands2;
        int i4;
        int[] iArr2;
        int i5;
        int iMax = this.bandOffsets[0];
        int iMin = iMax;
        int i6 = 1;
        while (true) {
            iArr = this.bandOffsets;
            if (i6 >= iArr.length) {
                break;
            }
            iMin = Math.min(iMin, iArr[i6]);
            iMax = Math.max(iMax, this.bandOffsets[i6]);
            i6++;
        }
        int length = iArr.length;
        int iAbs = Math.abs(this.pixelStride);
        int iAbs2 = Math.abs(this.scanlineStride);
        int iAbs3 = Math.abs(iMax - iMin);
        if (iAbs > iAbs2) {
            if (iAbs > iAbs3) {
                if (iAbs2 > iAbs3) {
                    iArrOrderBands2 = new int[this.bandOffsets.length];
                    for (int i7 = 0; i7 < length; i7++) {
                        iArrOrderBands2[i7] = this.bandOffsets[i7] - iMin;
                    }
                    iAbs2 = iAbs3 + 1;
                    i4 = iAbs2 * i2;
                } else {
                    iArrOrderBands2 = orderBands(this.bandOffsets, iAbs2 * i2);
                    i4 = length * iAbs2 * i2;
                }
                iArr2 = iArrOrderBands2;
                iAbs = i4;
            } else {
                iAbs = iAbs2 * i2;
                iArrOrderBands = orderBands(this.bandOffsets, iAbs * i);
                iArr2 = iArrOrderBands;
            }
        } else if (iAbs > iAbs3) {
            iArrOrderBands2 = new int[this.bandOffsets.length];
            for (int i8 = 0; i8 < length; i8++) {
                iArrOrderBands2[i8] = this.bandOffsets[i8] - iMin;
            }
            i4 = iAbs3 + 1;
            iAbs2 = i4 * i;
            iArr2 = iArrOrderBands2;
            iAbs = i4;
        } else {
            if (iAbs2 > iAbs3) {
                iArrOrderBands = orderBands(this.bandOffsets, iAbs * i);
                iAbs2 = length * iAbs * i;
            } else {
                iAbs2 = iAbs * i;
                iArrOrderBands = orderBands(this.bandOffsets, iAbs2 * i2);
            }
            iArr2 = iArrOrderBands;
        }
        if (this.scanlineStride < 0) {
            i5 = iAbs2 * i2;
            iAbs2 *= -1;
        } else {
            i5 = 0;
        }
        int i9 = iAbs2;
        if (this.pixelStride < 0) {
            i5 += iAbs * i;
            iAbs *= -1;
        }
        int i10 = iAbs;
        for (int i11 = 0; i11 < length; i11++) {
            iArr2[i11] = iArr2[i11] + i5;
        }
        return new ComponentSampleModel(this.dataType, i, i2, i10, i9, this.bankIndices, iArr2);
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public DataBuffer createDataBuffer() {
        int bufferSize = getBufferSize();
        int i = this.dataType;
        if (i == 0) {
            return new DataBufferByte(bufferSize, this.numBanks);
        }
        if (i == 1) {
            return new DataBufferUShort(bufferSize, this.numBanks);
        }
        if (i == 2) {
            return new DataBufferShort(bufferSize, this.numBanks);
        }
        if (i == 3) {
            return new DataBufferInt(bufferSize, this.numBanks);
        }
        if (i == 4) {
            return new DataBufferFloat(bufferSize, this.numBanks);
        }
        if (i != 5) {
            return null;
        }
        return new DataBufferDouble(bufferSize, this.numBanks);
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
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
        return new ComponentSampleModel(this.dataType, this.width, this.height, this.pixelStride, this.scanlineStride, iArr2, iArr3);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ComponentSampleModel)) {
            ComponentSampleModel componentSampleModel = (ComponentSampleModel) obj;
            if (this.width == componentSampleModel.width && this.height == componentSampleModel.height && this.numBands == componentSampleModel.numBands && this.dataType == componentSampleModel.dataType && Arrays.equals(this.bandOffsets, componentSampleModel.bandOffsets) && Arrays.equals(this.bankIndices, componentSampleModel.bankIndices) && this.numBands == componentSampleModel.numBands && this.numBanks == componentSampleModel.numBanks && this.scanlineStride == componentSampleModel.scanlineStride && this.pixelStride == componentSampleModel.pixelStride) {
                return true;
            }
        }
        return false;
    }

    public final int[] getBandOffsets() {
        return (int[]) this.bandOffsets.clone();
    }

    public final int[] getBankIndices() {
        return (int[]) this.bankIndices.clone();
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public Object getDataElements(int i, int i2, Object obj, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int transferType = getTransferType();
        int numDataElements = getNumDataElements();
        int i4 = (i * this.pixelStride) + (i2 * this.scanlineStride);
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

    @Override // org.apache.poi.java.awt.image.SampleModel
    public final int getNumDataElements() {
        return getNumBands();
    }

    public int getOffset(int i, int i2) {
        return (i * this.pixelStride) + (i2 * this.scanlineStride) + this.bandOffsets[0];
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int[] getPixel(int i, int i2, int[] iArr, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (iArr == null) {
            iArr = new int[this.numBands];
        }
        int i4 = (i * this.pixelStride) + (i2 * this.scanlineStride);
        for (int i5 = 0; i5 < this.numBands; i5++) {
            iArr[i5] = dataBuffer.getElem(this.bankIndices[i5], this.bandOffsets[i5] + i4);
        }
        return iArr;
    }

    public final int getPixelStride() {
        return this.pixelStride;
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int[] getPixels(int i, int i2, int i4, int i5, int[] iArr, DataBuffer dataBuffer) {
        int i6;
        int i7;
        int i8 = i + i4;
        int i9 = i2 + i5;
        if (i < 0 || i >= (i6 = this.width) || i4 > i6 || i8 < 0 || i8 > i6 || i2 < 0 || i2 >= (i7 = this.height) || i2 > i7 || i9 < 0 || i9 > i7) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (iArr == null) {
            iArr = new int[i4 * i5 * this.numBands];
        }
        int i10 = (i * this.pixelStride) + (i2 * this.scanlineStride);
        int i11 = 0;
        for (int i12 = 0; i12 < i5; i12++) {
            int i13 = i10;
            for (int i14 = 0; i14 < i4; i14++) {
                int i15 = 0;
                while (i15 < this.numBands) {
                    iArr[i11] = dataBuffer.getElem(this.bankIndices[i15], this.bandOffsets[i15] + i13);
                    i15++;
                    i11++;
                }
                i13 += this.pixelStride;
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
        return dataBuffer.getElem(this.bankIndices[i4], (i * this.pixelStride) + (i2 * this.scanlineStride) + this.bandOffsets[i4]);
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public double getSampleDouble(int i, int i2, int i4, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        return dataBuffer.getElemDouble(this.bankIndices[i4], (i * this.pixelStride) + (i2 * this.scanlineStride) + this.bandOffsets[i4]);
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public float getSampleFloat(int i, int i2, int i4, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        return dataBuffer.getElemFloat(this.bankIndices[i4], (i * this.pixelStride) + (i2 * this.scanlineStride) + this.bandOffsets[i4]);
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public final int[] getSampleSize() {
        int[] iArr = new int[this.numBands];
        int sampleSize = getSampleSize(0);
        for (int i = 0; i < this.numBands; i++) {
            iArr[i] = sampleSize;
        }
        return iArr;
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public int[] getSamples(int i, int i2, int i4, int i5, int i6, int[] iArr, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i + i4 > this.width || i2 + i5 > this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (iArr == null) {
            iArr = new int[i4 * i5];
        }
        int i7 = (i * this.pixelStride) + (i2 * this.scanlineStride) + this.bandOffsets[i6];
        int i8 = 0;
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = i7;
            int i11 = 0;
            while (i11 < i4) {
                iArr[i8] = dataBuffer.getElem(this.bankIndices[i6], i10);
                i10 += this.pixelStride;
                i11++;
                i8++;
            }
            i7 += this.scanlineStride;
        }
        return iArr;
    }

    public final int getScanlineStride() {
        return this.scanlineStride;
    }

    public int hashCode() {
        int i = ((((((this.width << 8) ^ this.height) << 8) ^ this.numBands) << 8) ^ this.dataType) << 8;
        int i2 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.bandOffsets;
            if (i4 >= iArr.length) {
                break;
            }
            i = (i ^ iArr[i4]) << 8;
            i4++;
        }
        while (true) {
            int[] iArr2 = this.bankIndices;
            if (i2 >= iArr2.length) {
                return ((((((i ^ this.numBands) << 8) ^ this.numBanks) << 8) ^ this.scanlineStride) << 8) ^ this.pixelStride;
            }
            i = (i ^ iArr2[i2]) << 8;
            i2++;
        }
    }

    public int[] orderBands(int[] iArr, int i) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int length2 = iArr.length;
        int[] iArr3 = new int[length2];
        int i2 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            iArr2[i4] = i4;
        }
        while (i2 < length2) {
            int i5 = i2 + 1;
            int i6 = i2;
            for (int i7 = i5; i7 < length2; i7++) {
                if (iArr[iArr2[i6]] > iArr[iArr2[i7]]) {
                    i6 = i7;
                }
            }
            iArr3[iArr2[i6]] = i2 * i;
            iArr2[i6] = iArr2[i2];
            i2 = i5;
        }
        return iArr3;
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public void setDataElements(int i, int i2, Object obj, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int transferType = getTransferType();
        int numDataElements = getNumDataElements();
        int i4 = (i * this.pixelStride) + (i2 * this.scanlineStride);
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

    @Override // org.apache.poi.java.awt.image.SampleModel
    public void setPixel(int i, int i2, int[] iArr, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int i4 = (i * this.pixelStride) + (i2 * this.scanlineStride);
        for (int i5 = 0; i5 < this.numBands; i5++) {
            dataBuffer.setElem(this.bankIndices[i5], this.bandOffsets[i5] + i4, iArr[i5]);
        }
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
        int i10 = (i * this.pixelStride) + (i2 * this.scanlineStride);
        int i11 = 0;
        for (int i12 = 0; i12 < i5; i12++) {
            int i13 = i10;
            for (int i14 = 0; i14 < i4; i14++) {
                int i15 = 0;
                while (i15 < this.numBands) {
                    dataBuffer.setElem(this.bankIndices[i15], this.bandOffsets[i15] + i13, iArr[i11]);
                    i15++;
                    i11++;
                }
                i13 += this.pixelStride;
            }
            i10 += this.scanlineStride;
        }
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public void setSample(int i, int i2, int i4, int i5, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i >= this.width || i2 >= this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        dataBuffer.setElem(this.bankIndices[i4], (i * this.pixelStride) + (i2 * this.scanlineStride) + this.bandOffsets[i4], i5);
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public void setSamples(int i, int i2, int i4, int i5, int i6, int[] iArr, DataBuffer dataBuffer) {
        if (i < 0 || i2 < 0 || i + i4 > this.width || i2 + i5 > this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int i7 = (i * this.pixelStride) + (i2 * this.scanlineStride) + this.bandOffsets[i6];
        int i8 = 0;
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = i7;
            int i11 = 0;
            while (i11 < i4) {
                dataBuffer.setElem(this.bankIndices[i6], i10, iArr[i8]);
                i10 += this.pixelStride;
                i11++;
                i8++;
            }
            i7 += this.scanlineStride;
        }
    }

    public int getOffset(int i, int i2, int i4) {
        return (i * this.pixelStride) + (i2 * this.scanlineStride) + this.bandOffsets[i4];
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public void setSample(int i, int i2, int i4, float f, DataBuffer dataBuffer) {
        if (i >= 0 && i2 >= 0 && i < this.width && i2 < this.height) {
            dataBuffer.setElemFloat(this.bankIndices[i4], (i * this.pixelStride) + (i2 * this.scanlineStride) + this.bandOffsets[i4], f);
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public final int getSampleSize(int i) {
        return DataBuffer.getDataTypeSize(this.dataType);
    }

    @Override // org.apache.poi.java.awt.image.SampleModel
    public void setSample(int i, int i2, int i4, double d, DataBuffer dataBuffer) {
        if (i >= 0 && i2 >= 0 && i < this.width && i2 < this.height) {
            dataBuffer.setElemDouble(this.bankIndices[i4], (i * this.pixelStride) + (i2 * this.scanlineStride) + this.bandOffsets[i4], d);
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }

    public ComponentSampleModel(int i, int i2, int i4, int i5, int i6, int[] iArr, int[] iArr2) {
        super(i, i2, i4, iArr2.length);
        this.numBands = 1;
        this.numBanks = 1;
        this.dataType = i;
        this.pixelStride = i5;
        this.scanlineStride = i6;
        this.bandOffsets = (int[]) iArr2.clone();
        int[] iArr3 = (int[]) iArr.clone();
        this.bankIndices = iArr3;
        if (i5 < 0) {
            throw new IllegalArgumentException("Pixel stride must be >= 0");
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("Scanline stride must be >= 0");
        }
        if (i >= 0 && i <= 5) {
            int i7 = iArr3[0];
            if (i7 < 0) {
                throw new IllegalArgumentException(AbstractC0541b.m767i(i7, "Index of bank 0 is less than 0 (", ")"));
            }
            int i8 = 1;
            while (true) {
                int[] iArr4 = this.bankIndices;
                if (i8 < iArr4.length) {
                    int i9 = iArr4[i8];
                    if (i9 > i7) {
                        i7 = i9;
                    } else if (i9 < 0) {
                        throw new IllegalArgumentException(AbstractC0622a.m1164j(i8, i7, "Index of bank ", " is less than 0 (", ")"));
                    }
                    i8++;
                } else {
                    this.numBanks = i7 + 1;
                    int[] iArr5 = this.bandOffsets;
                    this.numBands = iArr5.length;
                    if (iArr5.length == iArr4.length) {
                        verify();
                        return;
                    }
                    throw new IllegalArgumentException("Length of bandOffsets must equal length of bankIndices.");
                }
            }
        } else {
            throw new IllegalArgumentException("Unsupported dataType.");
        }
    }
}
