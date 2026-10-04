package org.apache.poi.java.awt.image;

/* JADX INFO: loaded from: classes10.dex */
public class PixelInterleavedSampleModel extends ComponentSampleModel {
    public PixelInterleavedSampleModel(int i, int i2, int i4, int i5, int i6, int[] iArr) {
        super(i, i2, i4, i5, i6, iArr);
        int iMax = this.bandOffsets[0];
        int i7 = 1;
        int iMin = iMax;
        while (true) {
            int[] iArr2 = this.bandOffsets;
            if (i7 >= iArr2.length) {
                break;
            }
            iMin = Math.min(iMin, iArr2[i7]);
            iMax = Math.max(iMax, this.bandOffsets[i7]);
            i7++;
        }
        int i8 = iMax - iMin;
        if (i8 > i6) {
            throw new IllegalArgumentException("Offsets between bands must be less than the scanline  stride");
        }
        if (i2 * i5 > i6) {
            throw new IllegalArgumentException("Pixel stride times width must be less than or equal to the scanline stride");
        }
        if (i5 < i8) {
            throw new IllegalArgumentException("Pixel stride must be greater than or equal to the offsets between bands");
        }
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public SampleModel createCompatibleSampleModel(int i, int i2) {
        int[] iArr;
        int[] iArr2 = this.bandOffsets;
        int i4 = iArr2[0];
        int length = iArr2.length;
        for (int i5 = 1; i5 < length; i5++) {
            int i6 = this.bandOffsets[i5];
            if (i6 < i4) {
                i4 = i6;
            }
        }
        if (i4 > 0) {
            iArr = new int[length];
            for (int i7 = 0; i7 < length; i7++) {
                iArr[i7] = this.bandOffsets[i7] - i4;
            }
        } else {
            iArr = this.bandOffsets;
        }
        int[] iArr3 = iArr;
        int i8 = this.dataType;
        int i9 = this.pixelStride;
        return new PixelInterleavedSampleModel(i8, i, i2, i9, i9 * i, iArr3);
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel, org.apache.poi.java.awt.image.SampleModel
    public SampleModel createSubsetSampleModel(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = this.bandOffsets[iArr[i]];
        }
        return new PixelInterleavedSampleModel(this.dataType, this.width, this.height, this.pixelStride, this.scanlineStride, iArr2);
    }

    @Override // org.apache.poi.java.awt.image.ComponentSampleModel
    public int hashCode() {
        return super.hashCode() ^ 1;
    }
}
