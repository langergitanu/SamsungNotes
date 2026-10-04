package org.apache.poi.java.awt.image;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import org.apache.poi.java.awt.color.ColorSpace;

/* JADX INFO: loaded from: classes10.dex */
public abstract class PackedColorModel extends ColorModel {
    int[] maskArray;
    int[] maskOffsets;
    float[] scaleFactors;

    public PackedColorModel(ColorSpace colorSpace, int i, int i2, int i4, int i5, int i6, boolean z, int i7, int i8) {
        super(i, createBitsArray(i2, i4, i5, i6), colorSpace, i6 != 0, z, i7, i8);
        if (colorSpace.getType() != 5) {
            throw new IllegalArgumentException("ColorSpace must be TYPE_RGB.");
        }
        int i9 = this.numComponents;
        this.maskArray = new int[i9];
        this.maskOffsets = new int[i9];
        this.scaleFactors = new float[i9];
        DecomposeMask(i2, 0, "red");
        DecomposeMask(i4, 1, "green");
        DecomposeMask(i5, 2, "blue");
        if (i6 != 0) {
            DecomposeMask(i6, 3, "alpha");
            if (this.nBits[3] == 1) {
                this.transparency = 2;
            }
        }
    }

    private void DecomposeMask(int i, int i2, String str) {
        int i4 = this.nBits[i2];
        this.maskArray[i2] = i;
        int i5 = 0;
        if (i != 0) {
            while ((i & 1) == 0) {
                i >>>= 1;
                i5++;
            }
        }
        if (i5 + i4 > this.pixel_bits) {
            StringBuilder sbM781w = AbstractC0541b.m781w(str, " mask ");
            sbM781w.append(Integer.toHexString(this.maskArray[i2]));
            sbM781w.append(" overflows pixel (expecting ");
            throw new IllegalArgumentException(AbstractC2821a.m2223n(sbM781w, " bits", this.pixel_bits));
        }
        this.maskOffsets[i2] = i5;
        float[] fArr = this.scaleFactors;
        if (i4 == 0) {
            fArr[i2] = 256.0f;
        } else {
            fArr[i2] = 255.0f / ((1 << i4) - 1);
        }
    }

    private static final int countBits(int i) {
        int i2 = 0;
        if (i != 0) {
            while ((i & 1) == 0) {
                i >>>= 1;
            }
            while ((i & 1) == 1) {
                i >>>= 1;
                i2++;
            }
        }
        if (i != 0) {
            return -1;
        }
        return i2;
    }

    private static final int[] createBitsArray(int i, int i2, int i4, int i5) {
        int[] iArr = new int[(i5 == 0 ? 0 : 1) + 3];
        iArr[0] = countBits(i);
        iArr[1] = countBits(i2);
        int iCountBits = countBits(i4);
        iArr[2] = iCountBits;
        if (iArr[0] < 0) {
            throw new IllegalArgumentException(AbstractC1974b.m1316i(i, new StringBuilder("Noncontiguous red mask (")));
        }
        if (iArr[1] < 0) {
            throw new IllegalArgumentException(AbstractC1974b.m1316i(i2, new StringBuilder("Noncontiguous green mask (")));
        }
        if (iCountBits < 0) {
            throw new IllegalArgumentException(AbstractC1974b.m1316i(i4, new StringBuilder("Noncontiguous blue mask (")));
        }
        if (i5 != 0) {
            int iCountBits2 = countBits(i5);
            iArr[3] = iCountBits2;
            if (iCountBits2 < 0) {
                throw new IllegalArgumentException(AbstractC1974b.m1316i(i5, new StringBuilder("Noncontiguous alpha mask (")));
            }
        }
        return iArr;
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public SampleModel createCompatibleSampleModel(int i, int i2) {
        return new SinglePixelPackedSampleModel(this.transferType, i, i2, this.maskArray);
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public boolean equals(Object obj) {
        PackedColorModel packedColorModel;
        int numComponents;
        if (!(obj instanceof PackedColorModel) || !super.equals(obj) || (numComponents = (packedColorModel = (PackedColorModel) obj).getNumComponents()) != this.numComponents) {
            return false;
        }
        for (int i = 0; i < numComponents; i++) {
            if (this.maskArray[i] != packedColorModel.getMask(i)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public WritableRaster getAlphaRaster(WritableRaster writableRaster) {
        if (!hasAlpha()) {
            return null;
        }
        int minX = writableRaster.getMinX();
        int minY = writableRaster.getMinY();
        return writableRaster.createWritableChild(minX, minY, writableRaster.getWidth(), writableRaster.getHeight(), minX, minY, new int[]{writableRaster.getNumBands() - 1});
    }

    public final int getMask(int i) {
        return this.maskArray[i];
    }

    public final int[] getMasks() {
        return (int[]) this.maskArray.clone();
    }

    @Override // org.apache.poi.java.awt.image.ColorModel
    public boolean isCompatibleSampleModel(SampleModel sampleModel) {
        if (!(sampleModel instanceof SinglePixelPackedSampleModel) || this.numComponents != sampleModel.getNumBands() || sampleModel.getTransferType() != this.transferType) {
            return false;
        }
        int[] bitMasks = ((SinglePixelPackedSampleModel) sampleModel).getBitMasks();
        if (bitMasks.length != this.maskArray.length) {
            return false;
        }
        int dataTypeSize = (int) ((1 << DataBuffer.getDataTypeSize(this.transferType)) - 1);
        for (int i = 0; i < bitMasks.length; i++) {
            if ((bitMasks[i] & dataTypeSize) != (this.maskArray[i] & dataTypeSize)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PackedColorModel(ColorSpace colorSpace, int i, int[] iArr, int i2, boolean z, int i4, int i5) {
        int i6;
        super(i, createBitsArray(iArr, i2), colorSpace, i2 != 0, z, i4, i5);
        int i7 = 0;
        if (i < 1 || i > 32) {
            throw new IllegalArgumentException("Number of bits must be between 1 and 32.");
        }
        int i8 = this.numComponents;
        this.maskArray = new int[i8];
        this.maskOffsets = new int[i8];
        this.scaleFactors = new float[i8];
        while (true) {
            i6 = this.numColorComponents;
            if (i7 >= i6) {
                break;
            }
            DecomposeMask(iArr[i7], i7, colorSpace.getName(i7));
            i7++;
        }
        if (i2 != 0) {
            DecomposeMask(i2, i6, "alpha");
            if (this.nBits[this.numComponents - 1] == 1) {
                this.transparency = 2;
            }
        }
    }

    private static final int[] createBitsArray(int[] iArr, int i) {
        int length = iArr.length;
        int[] iArr2 = new int[(i == 0 ? 0 : 1) + length];
        for (int i2 = 0; i2 < length; i2++) {
            int iCountBits = countBits(iArr[i2]);
            iArr2[i2] = iCountBits;
            if (iCountBits < 0) {
                throw new IllegalArgumentException("Noncontiguous color mask (" + Integer.toHexString(iArr[i2]) + "at index " + i2);
            }
        }
        if (i != 0) {
            int iCountBits2 = countBits(i);
            iArr2[length] = iCountBits2;
            if (iCountBits2 < 0) {
                throw new IllegalArgumentException(AbstractC1974b.m1316i(i, new StringBuilder("Noncontiguous alpha mask (")));
            }
        }
        return iArr2;
    }
}
