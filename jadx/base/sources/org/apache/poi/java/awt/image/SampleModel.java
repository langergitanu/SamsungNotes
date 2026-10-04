package org.apache.poi.java.awt.image;

import androidx.collection.AbstractC0622a;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class SampleModel {
    protected int dataType;
    protected int height;
    protected int numBands;
    protected int width;

    static {
        ColorModel.loadLibraries();
    }

    public SampleModel(int i, int i2, int i4, int i5) {
        long j = ((long) i2) * ((long) i4);
        if (i2 <= 0 || i4 <= 0) {
            throw new IllegalArgumentException(AbstractC0622a.m1164j(i2, i4, "Width (", ") and height (", ") must be > 0"));
        }
        if (j >= 2147483647L) {
            throw new IllegalArgumentException(AbstractC0622a.m1164j(i2, i4, "Dimensions (width=", " height=", ") are too large"));
        }
        if (i < 0 || (i > 5 && i != 32)) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unsupported dataType: "));
        }
        if (i5 <= 0) {
            throw new IllegalArgumentException("Number of bands must be > 0");
        }
        this.dataType = i;
        this.width = i2;
        this.height = i4;
        this.numBands = i5;
    }

    public abstract SampleModel createCompatibleSampleModel(int i, int i2);

    public abstract DataBuffer createDataBuffer();

    public abstract SampleModel createSubsetSampleModel(int[] iArr);

    public Object getDataElements(int i, int i2, int i4, int i5, Object obj, DataBuffer dataBuffer) {
        int i6;
        int i7;
        int i8 = i2;
        int transferType = getTransferType();
        int numDataElements = getNumDataElements();
        int i9 = i + i4;
        int i10 = i8 + i5;
        if (i < 0 || i >= (i6 = this.width) || i4 > i6 || i9 < 0 || i9 > i6 || i8 < 0 || i8 >= (i7 = this.height) || i5 > i7 || i10 < 0 || i10 > i7) {
            throw new ArrayIndexOutOfBoundsException("Invalid coordinates.");
        }
        Object dataElements = null;
        if (transferType == 0) {
            byte[] bArr = obj == null ? new byte[i4 * numDataElements * i5] : (byte[]) obj;
            int i11 = 0;
            while (i8 < i10) {
                for (int i12 = i; i12 < i9; i12++) {
                    dataElements = getDataElements(i12, i8, dataElements, dataBuffer);
                    byte[] bArr2 = (byte[]) dataElements;
                    int i13 = 0;
                    while (i13 < numDataElements) {
                        bArr[i11] = bArr2[i13];
                        i13++;
                        i11++;
                    }
                }
                i8++;
            }
            return bArr;
        }
        if (transferType == 1 || transferType == 2) {
            short[] sArr = obj == null ? new short[i4 * numDataElements * i5] : (short[]) obj;
            int i14 = 0;
            while (i8 < i10) {
                for (int i15 = i; i15 < i9; i15++) {
                    dataElements = getDataElements(i15, i8, dataElements, dataBuffer);
                    short[] sArr2 = (short[]) dataElements;
                    int i16 = 0;
                    while (i16 < numDataElements) {
                        sArr[i14] = sArr2[i16];
                        i16++;
                        i14++;
                    }
                }
                i8++;
            }
            return sArr;
        }
        if (transferType == 3) {
            int[] iArr = obj == null ? new int[i4 * numDataElements * i5] : (int[]) obj;
            int i17 = 0;
            while (i8 < i10) {
                for (int i18 = i; i18 < i9; i18++) {
                    dataElements = getDataElements(i18, i8, dataElements, dataBuffer);
                    int[] iArr2 = (int[]) dataElements;
                    int i19 = 0;
                    while (i19 < numDataElements) {
                        iArr[i17] = iArr2[i19];
                        i19++;
                        i17++;
                    }
                }
                i8++;
            }
            return iArr;
        }
        if (transferType == 4) {
            float[] fArr = obj == null ? new float[i4 * numDataElements * i5] : (float[]) obj;
            int i20 = 0;
            while (i8 < i10) {
                for (int i21 = i; i21 < i9; i21++) {
                    dataElements = getDataElements(i21, i8, dataElements, dataBuffer);
                    float[] fArr2 = (float[]) dataElements;
                    int i22 = 0;
                    while (i22 < numDataElements) {
                        fArr[i20] = fArr2[i22];
                        i22++;
                        i20++;
                    }
                }
                i8++;
            }
            return fArr;
        }
        if (transferType != 5) {
            return obj;
        }
        double[] dArr = obj == null ? new double[i4 * numDataElements * i5] : (double[]) obj;
        int i23 = 0;
        while (i8 < i10) {
            for (int i24 = i; i24 < i9; i24++) {
                dataElements = getDataElements(i24, i8, dataElements, dataBuffer);
                double[] dArr2 = (double[]) dataElements;
                int i25 = 0;
                while (i25 < numDataElements) {
                    dArr[i23] = dArr2[i25];
                    i25++;
                    i23++;
                }
            }
            i8++;
        }
        return dArr;
    }

    public abstract Object getDataElements(int i, int i2, Object obj, DataBuffer dataBuffer);

    public final int getDataType() {
        return this.dataType;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getNumBands() {
        return this.numBands;
    }

    public abstract int getNumDataElements();

    public int[] getPixel(int i, int i2, int[] iArr, DataBuffer dataBuffer) {
        if (iArr == null) {
            iArr = new int[this.numBands];
        }
        for (int i4 = 0; i4 < this.numBands; i4++) {
            iArr[i4] = getSample(i, i2, i4, dataBuffer);
        }
        return iArr;
    }

    public int[] getPixels(int i, int i2, int i4, int i5, int[] iArr, DataBuffer dataBuffer) {
        int i6;
        int i7;
        int i8 = i + i4;
        int i9 = i2 + i5;
        if (i < 0 || i >= (i6 = this.width) || i4 > i6 || i8 < 0 || i8 > i6 || i2 < 0 || i2 >= (i7 = this.height) || i5 > i7 || i9 < 0 || i9 > i7) {
            throw new ArrayIndexOutOfBoundsException("Invalid coordinates.");
        }
        if (iArr == null) {
            iArr = new int[this.numBands * i4 * i5];
        }
        int i10 = 0;
        while (i2 < i9) {
            for (int i11 = i; i11 < i8; i11++) {
                int i12 = 0;
                while (i12 < this.numBands) {
                    iArr[i10] = getSample(i11, i2, i12, dataBuffer);
                    i12++;
                    i10++;
                }
            }
            i2++;
        }
        return iArr;
    }

    public abstract int getSample(int i, int i2, int i4, DataBuffer dataBuffer);

    public double getSampleDouble(int i, int i2, int i4, DataBuffer dataBuffer) {
        return getSample(i, i2, i4, dataBuffer);
    }

    public float getSampleFloat(int i, int i2, int i4, DataBuffer dataBuffer) {
        return getSample(i, i2, i4, dataBuffer);
    }

    public abstract int getSampleSize(int i);

    public abstract int[] getSampleSize();

    public int[] getSamples(int i, int i2, int i4, int i5, int i6, int[] iArr, DataBuffer dataBuffer) {
        int i7 = i + i4;
        int i8 = i2 + i5;
        if (i < 0 || i7 < i || i7 > this.width || i2 < 0 || i8 < i2 || i8 > this.height) {
            throw new ArrayIndexOutOfBoundsException("Invalid coordinates.");
        }
        if (iArr == null) {
            iArr = new int[i4 * i5];
        }
        int i9 = 0;
        while (i2 < i8) {
            int i10 = i;
            while (i10 < i7) {
                iArr[i9] = getSample(i10, i2, i6, dataBuffer);
                i10++;
                i9++;
            }
            i2++;
        }
        return iArr;
    }

    public int getTransferType() {
        return this.dataType;
    }

    public final int getWidth() {
        return this.width;
    }

    public void setDataElements(int i, int i2, int i4, int i5, Object obj, DataBuffer dataBuffer) {
        int i6;
        int i7;
        int transferType = getTransferType();
        int numDataElements = getNumDataElements();
        int i8 = i + i4;
        int i9 = i2 + i5;
        if (i < 0 || i >= (i6 = this.width) || i4 > i6 || i8 < 0 || i8 > i6 || i2 < 0 || i2 >= (i7 = this.height) || i5 > i7 || i9 < 0 || i9 > i7) {
            throw new ArrayIndexOutOfBoundsException("Invalid coordinates.");
        }
        if (transferType == 0) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[numDataElements];
            int i10 = 0;
            while (i2 < i9) {
                for (int i11 = i; i11 < i8; i11++) {
                    int i12 = 0;
                    while (i12 < numDataElements) {
                        bArr2[i12] = bArr[i10];
                        i12++;
                        i10++;
                    }
                    setDataElements(i11, i2, bArr2, dataBuffer);
                }
                i2++;
            }
            return;
        }
        if (transferType == 1 || transferType == 2) {
            short[] sArr = (short[]) obj;
            short[] sArr2 = new short[numDataElements];
            int i13 = 0;
            while (i2 < i9) {
                for (int i14 = i; i14 < i8; i14++) {
                    int i15 = 0;
                    while (i15 < numDataElements) {
                        sArr2[i15] = sArr[i13];
                        i15++;
                        i13++;
                    }
                    setDataElements(i14, i2, sArr2, dataBuffer);
                }
                i2++;
            }
            return;
        }
        if (transferType == 3) {
            int[] iArr = (int[]) obj;
            int[] iArr2 = new int[numDataElements];
            int i16 = 0;
            while (i2 < i9) {
                for (int i17 = i; i17 < i8; i17++) {
                    int i18 = 0;
                    while (i18 < numDataElements) {
                        iArr2[i18] = iArr[i16];
                        i18++;
                        i16++;
                    }
                    setDataElements(i17, i2, iArr2, dataBuffer);
                }
                i2++;
            }
            return;
        }
        if (transferType == 4) {
            float[] fArr = (float[]) obj;
            float[] fArr2 = new float[numDataElements];
            int i19 = 0;
            while (i2 < i9) {
                for (int i20 = i; i20 < i8; i20++) {
                    int i21 = 0;
                    while (i21 < numDataElements) {
                        fArr2[i21] = fArr[i19];
                        i21++;
                        i19++;
                    }
                    setDataElements(i20, i2, fArr2, dataBuffer);
                }
                i2++;
            }
            return;
        }
        if (transferType != 5) {
            return;
        }
        double[] dArr = (double[]) obj;
        double[] dArr2 = new double[numDataElements];
        int i22 = 0;
        while (i2 < i9) {
            for (int i23 = i; i23 < i8; i23++) {
                int i24 = 0;
                while (i24 < numDataElements) {
                    dArr2[i24] = dArr[i22];
                    i24++;
                    i22++;
                }
                setDataElements(i23, i2, dArr2, dataBuffer);
            }
            i2++;
        }
    }

    public abstract void setDataElements(int i, int i2, Object obj, DataBuffer dataBuffer);

    public void setPixel(int i, int i2, int[] iArr, DataBuffer dataBuffer) {
        for (int i4 = 0; i4 < this.numBands; i4++) {
            setSample(i, i2, i4, iArr[i4], dataBuffer);
        }
    }

    public void setPixels(int i, int i2, int i4, int i5, int[] iArr, DataBuffer dataBuffer) {
        int i6;
        int i7;
        int i8 = i + i4;
        int i9 = i2 + i5;
        if (i < 0 || i >= (i6 = this.width) || i4 > i6 || i8 < 0 || i8 > i6 || i2 < 0 || i2 >= (i7 = this.height) || i5 > i7 || i9 < 0 || i9 > i7) {
            throw new ArrayIndexOutOfBoundsException("Invalid coordinates.");
        }
        int i10 = 0;
        for (int i11 = i2; i11 < i9; i11++) {
            for (int i12 = i; i12 < i8; i12++) {
                int i13 = 0;
                while (i13 < this.numBands) {
                    setSample(i12, i11, i13, iArr[i10], dataBuffer);
                    i13++;
                    i10++;
                }
            }
        }
    }

    public void setSample(int i, int i2, int i4, float f, DataBuffer dataBuffer) {
        setSample(i, i2, i4, (int) f, dataBuffer);
    }

    public abstract void setSample(int i, int i2, int i4, int i5, DataBuffer dataBuffer);

    public void setSamples(int i, int i2, int i4, int i5, int i6, int[] iArr, DataBuffer dataBuffer) {
        int i7;
        int i8;
        int i9 = i + i4;
        int i10 = i2 + i5;
        if (i < 0 || i >= (i7 = this.width) || i4 > i7 || i9 < 0 || i9 > i7 || i2 < 0 || i2 >= (i8 = this.height) || i5 > i8 || i10 < 0 || i10 > i8) {
            throw new ArrayIndexOutOfBoundsException("Invalid coordinates.");
        }
        int i11 = 0;
        for (int i12 = i2; i12 < i10; i12++) {
            int i13 = i;
            while (i13 < i9) {
                setSample(i13, i12, i6, iArr[i11], dataBuffer);
                i13++;
                i11++;
            }
        }
    }

    public void setSample(int i, int i2, int i4, double d, DataBuffer dataBuffer) {
        setSample(i, i2, i4, (int) d, dataBuffer);
    }

    public void setPixel(int i, int i2, float[] fArr, DataBuffer dataBuffer) {
        for (int i4 = 0; i4 < this.numBands; i4++) {
            setSample(i, i2, i4, fArr[i4], dataBuffer);
        }
    }

    public float[] getPixel(int i, int i2, float[] fArr, DataBuffer dataBuffer) {
        if (fArr == null) {
            fArr = new float[this.numBands];
        }
        for (int i4 = 0; i4 < this.numBands; i4++) {
            fArr[i4] = getSampleFloat(i, i2, i4, dataBuffer);
        }
        return fArr;
    }

    public void setSamples(int i, int i2, int i4, int i5, int i6, float[] fArr, DataBuffer dataBuffer) {
        int i7;
        int i8;
        int i9 = i + i4;
        int i10 = i2 + i5;
        if (i < 0 || i >= (i7 = this.width) || i4 > i7 || i9 < 0 || i9 > i7 || i2 < 0 || i2 >= (i8 = this.height) || i5 > i8 || i10 < 0 || i10 > i8) {
            throw new ArrayIndexOutOfBoundsException("Invalid coordinates.");
        }
        int i11 = 0;
        for (int i12 = i2; i12 < i10; i12++) {
            int i13 = i;
            while (i13 < i9) {
                setSample(i13, i12, i6, fArr[i11], dataBuffer);
                i13++;
                i11++;
            }
        }
    }

    public float[] getSamples(int i, int i2, int i4, int i5, int i6, float[] fArr, DataBuffer dataBuffer) {
        int i7 = i + i4;
        int i8 = i2 + i5;
        if (i < 0 || i7 < i || i7 > this.width || i2 < 0 || i8 < i2 || i8 > this.height) {
            throw new ArrayIndexOutOfBoundsException("Invalid coordinates");
        }
        if (fArr == null) {
            fArr = new float[i4 * i5];
        }
        int i9 = 0;
        while (i2 < i8) {
            int i10 = i;
            while (i10 < i7) {
                fArr[i9] = getSampleFloat(i10, i2, i6, dataBuffer);
                i10++;
                i9++;
            }
            i2++;
        }
        return fArr;
    }

    public void setPixel(int i, int i2, double[] dArr, DataBuffer dataBuffer) {
        for (int i4 = 0; i4 < this.numBands; i4++) {
            setSample(i, i2, i4, dArr[i4], dataBuffer);
        }
    }

    public void setPixels(int i, int i2, int i4, int i5, float[] fArr, DataBuffer dataBuffer) {
        int i6;
        int i7;
        int i8 = i + i4;
        int i9 = i2 + i5;
        if (i < 0 || i >= (i6 = this.width) || i4 > i6 || i8 < 0 || i8 > i6 || i2 < 0 || i2 >= (i7 = this.height) || i5 > i7 || i9 < 0 || i9 > i7) {
            throw new ArrayIndexOutOfBoundsException("Invalid coordinates.");
        }
        int i10 = 0;
        for (int i11 = i2; i11 < i9; i11++) {
            for (int i12 = i; i12 < i8; i12++) {
                int i13 = 0;
                while (i13 < this.numBands) {
                    setSample(i12, i11, i13, fArr[i10], dataBuffer);
                    i13++;
                    i10++;
                }
            }
        }
    }

    public float[] getPixels(int i, int i2, int i4, int i5, float[] fArr, DataBuffer dataBuffer) {
        int i6;
        int i7;
        int i8 = i + i4;
        int i9 = i2 + i5;
        if (i < 0 || i >= (i6 = this.width) || i4 > i6 || i8 < 0 || i8 > i6 || i2 < 0 || i2 >= (i7 = this.height) || i5 > i7 || i9 < 0 || i9 > i7) {
            throw new ArrayIndexOutOfBoundsException("Invalid coordinates.");
        }
        if (fArr == null) {
            fArr = new float[this.numBands * i4 * i5];
        }
        int i10 = 0;
        while (i2 < i9) {
            for (int i11 = i; i11 < i8; i11++) {
                int i12 = 0;
                while (i12 < this.numBands) {
                    fArr[i10] = getSampleFloat(i11, i2, i12, dataBuffer);
                    i12++;
                    i10++;
                }
            }
            i2++;
        }
        return fArr;
    }

    public double[] getPixel(int i, int i2, double[] dArr, DataBuffer dataBuffer) {
        if (dArr == null) {
            dArr = new double[this.numBands];
        }
        for (int i4 = 0; i4 < this.numBands; i4++) {
            dArr[i4] = getSampleDouble(i, i2, i4, dataBuffer);
        }
        return dArr;
    }

    public void setSamples(int i, int i2, int i4, int i5, int i6, double[] dArr, DataBuffer dataBuffer) {
        int i7;
        int i8;
        int i9 = i + i4;
        int i10 = i2 + i5;
        if (i < 0 || i >= (i7 = this.width) || i4 > i7 || i9 < 0 || i9 > i7 || i2 < 0 || i2 >= (i8 = this.height) || i5 > i8 || i10 < 0 || i10 > i8) {
            throw new ArrayIndexOutOfBoundsException("Invalid coordinates.");
        }
        int i11 = 0;
        for (int i12 = i2; i12 < i10; i12++) {
            int i13 = i;
            while (i13 < i9) {
                setSample(i13, i12, i6, dArr[i11], dataBuffer);
                i13++;
                i11++;
            }
        }
    }

    public double[] getSamples(int i, int i2, int i4, int i5, int i6, double[] dArr, DataBuffer dataBuffer) {
        int i7 = i + i4;
        int i8 = i2 + i5;
        if (i < 0 || i7 < i || i7 > this.width || i2 < 0 || i8 < i2 || i8 > this.height) {
            throw new ArrayIndexOutOfBoundsException("Invalid coordinates");
        }
        if (dArr == null) {
            dArr = new double[i4 * i5];
        }
        int i9 = 0;
        while (i2 < i8) {
            int i10 = i;
            while (i10 < i7) {
                dArr[i9] = getSampleDouble(i10, i2, i6, dataBuffer);
                i10++;
                i9++;
            }
            i2++;
        }
        return dArr;
    }

    public void setPixels(int i, int i2, int i4, int i5, double[] dArr, DataBuffer dataBuffer) {
        int i6;
        int i7;
        int i8 = i + i4;
        int i9 = i2 + i5;
        if (i < 0 || i >= (i6 = this.width) || i4 > i6 || i8 < 0 || i8 > i6 || i2 < 0 || i2 >= (i7 = this.height) || i5 > i7 || i9 < 0 || i9 > i7) {
            throw new ArrayIndexOutOfBoundsException("Invalid coordinates.");
        }
        int i10 = 0;
        for (int i11 = i2; i11 < i9; i11++) {
            for (int i12 = i; i12 < i8; i12++) {
                int i13 = 0;
                while (i13 < this.numBands) {
                    setSample(i12, i11, i13, dArr[i10], dataBuffer);
                    i13++;
                    i10++;
                }
            }
        }
    }

    public double[] getPixels(int i, int i2, int i4, int i5, double[] dArr, DataBuffer dataBuffer) {
        int i6;
        int i7;
        int i8 = i + i4;
        int i9 = i2 + i5;
        if (i < 0 || i >= (i6 = this.width) || i4 > i6 || i8 < 0 || i8 > i6 || i2 < 0 || i2 >= (i7 = this.height) || i5 > i7 || i9 < 0 || i9 > i7) {
            throw new ArrayIndexOutOfBoundsException("Invalid coordinates.");
        }
        if (dArr == null) {
            dArr = new double[this.numBands * i4 * i5];
        }
        int i10 = 0;
        while (i2 < i9) {
            for (int i11 = i; i11 < i8; i11++) {
                int i12 = 0;
                while (i12 < this.numBands) {
                    dArr[i10] = getSampleDouble(i11, i2, i12, dataBuffer);
                    i12++;
                    i10++;
                }
            }
            i2++;
        }
        return dArr;
    }
}
