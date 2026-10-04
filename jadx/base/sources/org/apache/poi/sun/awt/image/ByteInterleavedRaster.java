package org.apache.poi.sun.awt.image;

import androidx.compose.runtime.AbstractC1974b;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.image.ComponentSampleModel;
import org.apache.poi.java.awt.image.DataBuffer;
import org.apache.poi.java.awt.image.DataBufferByte;
import org.apache.poi.java.awt.image.PixelInterleavedSampleModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RasterFormatException;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.java.awt.image.SinglePixelPackedSampleModel;
import org.apache.poi.java.awt.image.WritableRaster;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ByteInterleavedRaster extends ByteComponentRaster {
    int[] bitMasks;
    int[] bitOffsets;
    int dbOffset;
    int dbOffsetPacked;
    boolean inOrder;
    private int maxX;
    private int maxY;
    boolean packed;

    public ByteInterleavedRaster(SampleModel sampleModel, Point point) {
        this(sampleModel, sampleModel.createDataBuffer(), new Rectangle(point.f10092x, point.f10093y, sampleModel.getWidth(), sampleModel.getHeight()), point, null);
    }

    private boolean isInterleaved(ComponentSampleModel componentSampleModel) {
        int numBands = this.sampleModel.getNumBands();
        if (numBands == 1) {
            return true;
        }
        int[] bankIndices = componentSampleModel.getBankIndices();
        for (int i = 0; i < numBands; i++) {
            if (bankIndices[i] != 0) {
                return false;
            }
        }
        int[] bandOffsets = componentSampleModel.getBandOffsets();
        int i2 = bandOffsets[0];
        int i4 = i2;
        for (int i5 = 1; i5 < numBands; i5++) {
            int i6 = bandOffsets[i5];
            if (i6 < i4) {
                i4 = i6;
            }
            if (i6 > i2) {
                i2 = i6;
            }
        }
        return i2 - i4 < componentSampleModel.getPixelStride();
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster, org.apache.poi.java.awt.image.Raster
    public Raster createChild(int i, int i2, int i4, int i5, int i6, int i7, int[] iArr) {
        return createWritableChild(i, i2, i4, i5, i6, i7, iArr);
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster, org.apache.poi.java.awt.image.Raster
    public WritableRaster createCompatibleWritableRaster(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new RasterFormatException("negative ".concat(i <= 0 ? "width" : "height"));
        }
        return new ByteInterleavedRaster(this.sampleModel.createCompatibleSampleModel(i, i2), new Point(0, 0));
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster, org.apache.poi.java.awt.image.WritableRaster
    public WritableRaster createWritableChild(int i, int i2, int i4, int i5, int i6, int i7, int[] iArr) {
        int i8 = this.minX;
        if (i < i8) {
            throw new RasterFormatException("x lies outside the raster");
        }
        int i9 = this.minY;
        if (i2 < i9) {
            throw new RasterFormatException("y lies outside the raster");
        }
        int i10 = i + i4;
        if (i10 < i || i10 > i8 + this.width) {
            throw new RasterFormatException("(x + width) is outside of Raster");
        }
        int i11 = i2 + i5;
        if (i11 < i2 || i11 > i9 + this.height) {
            throw new RasterFormatException("(y + height) is outside of Raster");
        }
        return new ByteInterleavedRaster(iArr != null ? this.sampleModel.createSubsetSampleModel(iArr) : this.sampleModel, this.dataBuffer, new Rectangle(i6, i7, i4, i5), new Point(this.sampleModelTranslateX + (i6 - i), this.sampleModelTranslateY + (i7 - i2)), this);
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster
    public byte[] getByteData(int i, int i2, int i4, int i5, int i6, byte[] bArr) {
        int i7;
        int i8 = this.minX;
        if (i < i8 || i2 < (i7 = this.minY) || i + i4 > this.maxX || i2 + i5 > this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (bArr == null) {
            bArr = new byte[i4 * i5];
        }
        int i9 = i2 - i7;
        int i10 = this.scanlineStride;
        int i11 = i - i8;
        int i12 = this.pixelStride;
        int i13 = (i11 * i12) + (i9 * i10) + this.dataOffsets[i6];
        int i14 = 0;
        if (i12 != 1) {
            int i15 = 0;
            int i16 = 0;
            while (i15 < i5) {
                int i17 = i13;
                int i18 = 0;
                while (i18 < i4) {
                    bArr[i16] = this.data[i17];
                    i18++;
                    i17 += this.pixelStride;
                    i16++;
                }
                i15++;
                i13 += this.scanlineStride;
            }
        } else {
            if (i10 == i4) {
                System.arraycopy(this.data, i13, bArr, 0, i4 * i5);
                return bArr;
            }
            int i19 = 0;
            while (i14 < i5) {
                System.arraycopy(this.data, i13, bArr, i19, i4);
                i19 += i4;
                i14++;
                i13 += this.scanlineStride;
            }
        }
        return bArr;
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster, org.apache.poi.java.awt.image.Raster
    public Object getDataElements(int i, int i2, Object obj) {
        int i4;
        int i5 = this.minX;
        if (i < i5 || i2 < (i4 = this.minY) || i >= this.maxX || i2 >= this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        byte[] bArr = obj == null ? new byte[this.numDataElements] : (byte[]) obj;
        int i6 = ((i - i5) * this.pixelStride) + ((i2 - i4) * this.scanlineStride);
        for (int i7 = 0; i7 < this.numDataElements; i7++) {
            bArr[i7] = this.data[this.dataOffsets[i7] + i6];
        }
        return bArr;
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster
    public int getDataOffset(int i) {
        return this.dataOffsets[i];
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster
    public int[] getDataOffsets() {
        return (int[]) this.dataOffsets.clone();
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster
    public byte[] getDataStorage() {
        return this.data;
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster
    public int getPixelStride() {
        return this.pixelStride;
    }

    @Override // org.apache.poi.java.awt.image.Raster
    public int[] getPixels(int i, int i2, int i4, int i5, int[] iArr) {
        if (i < this.minX || i2 < this.minY || i + i4 > this.maxX || i2 + i5 > this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int[] iArr2 = iArr != null ? iArr : new int[i4 * i5 * this.numBands];
        int i6 = (i * this.pixelStride) + (i2 * this.scanlineStride);
        int i7 = 0;
        if (this.packed) {
            int i8 = i6 + this.dbOffsetPacked;
            int i9 = 0;
            for (int i10 = 0; i10 < i5; i10++) {
                for (int i11 = 0; i11 < i4; i11++) {
                    byte b = this.data[i8 + i11];
                    int i12 = 0;
                    while (i12 < this.numBands) {
                        iArr2[i9] = (this.bitMasks[i12] & b) >>> this.bitOffsets[i12];
                        i12++;
                        i9++;
                    }
                }
                i8 += this.scanlineStride;
            }
        } else {
            int i13 = i6 + this.dbOffset;
            int[] iArr3 = this.dataOffsets;
            int i14 = iArr3[0];
            int i15 = this.numBands;
            if (i15 == 1) {
                int i16 = 0;
                for (int i17 = 0; i17 < i5; i17++) {
                    int i18 = i13 + i14;
                    int i19 = 0;
                    while (i19 < i4) {
                        iArr2[i16] = this.data[i18] & 255;
                        i18 += this.pixelStride;
                        i19++;
                        i16++;
                    }
                    i13 += this.scanlineStride;
                }
            } else if (i15 == 2) {
                int i20 = iArr3[1] - i14;
                int i21 = 0;
                for (int i22 = 0; i22 < i5; i22++) {
                    int i23 = i13 + i14;
                    for (int i24 = 0; i24 < i4; i24++) {
                        int i25 = i21 + 1;
                        byte[] bArr = this.data;
                        iArr2[i21] = bArr[i23] & 255;
                        i21 += 2;
                        iArr2[i25] = bArr[i23 + i20] & 255;
                        i23 += this.pixelStride;
                    }
                    i13 += this.scanlineStride;
                }
            } else if (i15 == 3) {
                int i26 = iArr3[1] - i14;
                int i27 = iArr3[2] - i14;
                int i28 = 0;
                int i29 = 0;
                while (i28 < i5) {
                    int i30 = i13 + i14;
                    for (int i31 = i7; i31 < i4; i31++) {
                        byte[] bArr2 = this.data;
                        iArr2[i29] = bArr2[i30] & 255;
                        int i32 = i29 + 2;
                        iArr2[i29 + 1] = bArr2[i30 + i26] & 255;
                        i29 += 3;
                        iArr2[i32] = bArr2[i30 + i27] & 255;
                        i30 += this.pixelStride;
                    }
                    i13 += this.scanlineStride;
                    i28++;
                    i7 = 0;
                }
            } else if (i15 == 4) {
                int i33 = iArr3[1] - i14;
                int i34 = iArr3[2] - i14;
                int i35 = iArr3[3] - i14;
                int i36 = 0;
                for (int i37 = 0; i37 < i5; i37++) {
                    int i38 = i13 + i14;
                    int i39 = 0;
                    while (i39 < i4) {
                        byte[] bArr3 = this.data;
                        iArr2[i36] = bArr3[i38] & 255;
                        int i40 = i13;
                        iArr2[i36 + 1] = bArr3[i38 + i33] & 255;
                        int i41 = i36 + 3;
                        iArr2[i36 + 2] = bArr3[i38 + i34] & 255;
                        i36 += 4;
                        iArr2[i41] = bArr3[i38 + i35] & 255;
                        i38 += this.pixelStride;
                        i39++;
                        i13 = i40;
                    }
                    i13 += this.scanlineStride;
                }
            } else {
                int i42 = 0;
                for (int i43 = 0; i43 < i5; i43++) {
                    int i44 = i13;
                    for (int i45 = 0; i45 < i4; i45++) {
                        int i46 = 0;
                        while (i46 < this.numBands) {
                            iArr2[i42] = this.data[this.dataOffsets[i46] + i44] & 255;
                            i46++;
                            i42++;
                        }
                        i44 += this.pixelStride;
                    }
                    i13 += this.scanlineStride;
                }
            }
        }
        return iArr2;
    }

    @Override // org.apache.poi.java.awt.image.Raster
    public int getSample(int i, int i2, int i4) {
        if (i < this.minX || i2 < this.minY || i >= this.maxX || i2 >= this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (this.packed) {
            return (this.data[((i2 * this.scanlineStride) + i) + this.dbOffsetPacked] & this.bitMasks[i4]) >>> this.bitOffsets[i4];
        }
        return this.data[(i * this.pixelStride) + (i2 * this.scanlineStride) + this.dbOffset + this.dataOffsets[i4]] & 255;
    }

    @Override // org.apache.poi.java.awt.image.Raster
    public int[] getSamples(int i, int i2, int i4, int i5, int i6, int[] iArr) {
        if (i < this.minX || i2 < this.minY || i + i4 > this.maxX || i2 + i5 > this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (iArr == null) {
            iArr = new int[i4 * i5];
        }
        int i7 = (i * this.pixelStride) + (i2 * this.scanlineStride);
        if (this.packed) {
            int i8 = i7 + this.dbOffsetPacked;
            int i9 = this.bitMasks[i6];
            int i10 = this.bitOffsets[i6];
            int i11 = 0;
            for (int i12 = 0; i12 < i5; i12++) {
                int i13 = i8;
                int i14 = 0;
                while (i14 < i4) {
                    iArr[i11] = (this.data[i13] & i9) >>> i10;
                    i14++;
                    i11++;
                    i13++;
                }
                i8 += this.scanlineStride;
            }
        } else {
            int i15 = this.dbOffset + this.dataOffsets[i6] + i7;
            int i16 = 0;
            for (int i17 = 0; i17 < i5; i17++) {
                int i18 = i15;
                int i19 = 0;
                while (i19 < i4) {
                    iArr[i16] = this.data[i18] & 255;
                    i18 += this.pixelStride;
                    i19++;
                    i16++;
                }
                i15 += this.scanlineStride;
            }
        }
        return iArr;
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster
    public int getScanlineStride() {
        return this.scanlineStride;
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster
    public void putByteData(int i, int i2, int i4, int i5, int i6, byte[] bArr) {
        int i7;
        int i8 = this.minX;
        if (i < i8 || i2 < (i7 = this.minY) || i + i4 > this.maxX || i2 + i5 > this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int i9 = i2 - i7;
        int i10 = this.scanlineStride;
        int i11 = i - i8;
        int i12 = this.pixelStride;
        int i13 = (i11 * i12) + (i9 * i10) + this.dataOffsets[i6];
        int i14 = 0;
        if (i12 != 1) {
            int i15 = 0;
            int i16 = 0;
            while (i15 < i5) {
                int i17 = i13;
                int i18 = 0;
                while (i18 < i4) {
                    this.data[i17] = bArr[i16];
                    i18++;
                    i17 += this.pixelStride;
                    i16++;
                }
                i15++;
                i13 += this.scanlineStride;
            }
        } else if (i10 == i4) {
            System.arraycopy(bArr, 0, this.data, i13, i4 * i5);
        } else {
            int i19 = 0;
            while (i14 < i5) {
                System.arraycopy(bArr, i19, this.data, i13, i4);
                i19 += i4;
                i14++;
                i13 += this.scanlineStride;
            }
        }
        markDirty();
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster, org.apache.poi.java.awt.image.WritableRaster
    public void setDataElements(int i, int i2, Object obj) {
        int i4;
        int i5 = this.minX;
        if (i < i5 || i2 < (i4 = this.minY) || i >= this.maxX || i2 >= this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        byte[] bArr = (byte[]) obj;
        int i6 = ((i - i5) * this.pixelStride) + ((i2 - i4) * this.scanlineStride);
        for (int i7 = 0; i7 < this.numDataElements; i7++) {
            this.data[this.dataOffsets[i7] + i6] = bArr[i7];
        }
        markDirty();
    }

    @Override // org.apache.poi.java.awt.image.WritableRaster
    public void setPixels(int i, int i2, int i4, int i5, int[] iArr) {
        if (i < this.minX || i2 < this.minY || i + i4 > this.maxX || i2 + i5 > this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int i6 = (i * this.pixelStride) + (i2 * this.scanlineStride);
        int i7 = 0;
        if (this.packed) {
            int i8 = i6 + this.dbOffsetPacked;
            int i9 = 0;
            for (int i10 = 0; i10 < i5; i10++) {
                for (int i11 = 0; i11 < i4; i11++) {
                    int i12 = 0;
                    int i13 = 0;
                    while (i12 < this.numBands) {
                        i13 |= (iArr[i9] << this.bitOffsets[i12]) & this.bitMasks[i12];
                        i12++;
                        i9++;
                    }
                    this.data[i8 + i11] = (byte) i13;
                }
                i8 += this.scanlineStride;
            }
        } else {
            int i14 = i6 + this.dbOffset;
            int[] iArr2 = this.dataOffsets;
            int i15 = iArr2[0];
            int i16 = this.numBands;
            if (i16 == 1) {
                int i17 = 0;
                for (int i18 = 0; i18 < i5; i18++) {
                    int i19 = i14 + i15;
                    int i20 = 0;
                    while (i20 < i4) {
                        this.data[i19] = (byte) iArr[i17];
                        i19 += this.pixelStride;
                        i20++;
                        i17++;
                    }
                    i14 += this.scanlineStride;
                }
            } else if (i16 == 2) {
                int i21 = iArr2[1] - i15;
                int i22 = 0;
                for (int i23 = 0; i23 < i5; i23++) {
                    int i24 = i14 + i15;
                    for (int i25 = 0; i25 < i4; i25++) {
                        byte[] bArr = this.data;
                        int i26 = i22 + 1;
                        bArr[i24] = (byte) iArr[i22];
                        i22 += 2;
                        bArr[i24 + i21] = (byte) iArr[i26];
                        i24 += this.pixelStride;
                    }
                    i14 += this.scanlineStride;
                }
            } else if (i16 == 3) {
                int i27 = iArr2[1] - i15;
                int i28 = iArr2[2] - i15;
                int i29 = 0;
                for (int i30 = 0; i30 < i5; i30++) {
                    int i31 = i14 + i15;
                    for (int i32 = 0; i32 < i4; i32++) {
                        byte[] bArr2 = this.data;
                        bArr2[i31] = (byte) iArr[i29];
                        int i33 = i29 + 2;
                        bArr2[i31 + i27] = (byte) iArr[i29 + 1];
                        i29 += 3;
                        bArr2[i31 + i28] = (byte) iArr[i33];
                        i31 += this.pixelStride;
                    }
                    i14 += this.scanlineStride;
                }
            } else if (i16 == 4) {
                int i34 = iArr2[1] - i15;
                int i35 = iArr2[2] - i15;
                int i36 = iArr2[3] - i15;
                int i37 = 0;
                int i38 = 0;
                while (i37 < i5) {
                    int i39 = i14 + i15;
                    for (int i40 = i7; i40 < i4; i40++) {
                        byte[] bArr3 = this.data;
                        bArr3[i39] = (byte) iArr[i38];
                        bArr3[i39 + i34] = (byte) iArr[i38 + 1];
                        int i41 = i38 + 3;
                        bArr3[i39 + i35] = (byte) iArr[i38 + 2];
                        i38 += 4;
                        bArr3[i39 + i36] = (byte) iArr[i41];
                        i39 += this.pixelStride;
                    }
                    i14 += this.scanlineStride;
                    i37++;
                    i7 = 0;
                }
            } else {
                int i42 = 0;
                for (int i43 = 0; i43 < i5; i43++) {
                    int i44 = i14;
                    for (int i45 = 0; i45 < i4; i45++) {
                        int i46 = 0;
                        while (i46 < this.numBands) {
                            this.data[this.dataOffsets[i46] + i44] = (byte) iArr[i42];
                            i46++;
                            i42++;
                        }
                        i44 += this.pixelStride;
                    }
                    i14 += this.scanlineStride;
                }
            }
        }
        markDirty();
    }

    @Override // org.apache.poi.java.awt.image.WritableRaster
    public void setRect(int i, int i2, Raster raster) {
        if (!(raster instanceof ByteInterleavedRaster)) {
            super.setRect(i, i2, raster);
            return;
        }
        int width = raster.getWidth();
        int height = raster.getHeight();
        int minX = raster.getMinX();
        int minY = raster.getMinY();
        int i4 = i + minX;
        int i5 = i2 + minY;
        int i6 = this.minX;
        if (i4 < i6) {
            int i7 = i6 - i4;
            width -= i7;
            minX += i7;
            i4 = i6;
        }
        int i8 = this.minY;
        if (i5 < i8) {
            int i9 = i8 - i5;
            height -= i9;
            minY += i9;
            i5 = i8;
        }
        int i10 = i4 + width;
        int i11 = this.maxX;
        if (i10 > i11) {
            width = i11 - i4;
        }
        int i12 = i5 + height;
        int i13 = this.maxY;
        if (i12 > i13) {
            height = i13 - i5;
        }
        setDataElements(i4, i5, minX, minY, width, height, raster);
    }

    @Override // org.apache.poi.java.awt.image.WritableRaster
    public void setSample(int i, int i2, int i4, int i5) {
        if (i < this.minX || i2 < this.minY || i >= this.maxX || i2 >= this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (this.packed) {
            int i6 = (i2 * this.scanlineStride) + i + this.dbOffsetPacked;
            int i7 = this.bitMasks[i4];
            byte[] bArr = this.data;
            bArr[i6] = (byte) ((i7 & (i5 << this.bitOffsets[i4])) | ((byte) (bArr[i6] & (~i7))));
        } else {
            this.data[(i * this.pixelStride) + (i2 * this.scanlineStride) + this.dbOffset + this.dataOffsets[i4]] = (byte) i5;
        }
        markDirty();
    }

    @Override // org.apache.poi.java.awt.image.WritableRaster
    public void setSamples(int i, int i2, int i4, int i5, int i6, int[] iArr) {
        if (i < this.minX || i2 < this.minY || i + i4 > this.maxX || i2 + i5 > this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int i7 = (i * this.pixelStride) + (i2 * this.scanlineStride);
        if (this.packed) {
            int i8 = i7 + this.dbOffsetPacked;
            int i9 = this.bitMasks[i6];
            int i10 = 0;
            for (int i11 = 0; i11 < i5; i11++) {
                int i12 = i8;
                int i13 = 0;
                while (i13 < i4) {
                    byte[] bArr = this.data;
                    bArr[i12] = (byte) (((iArr[i10] << this.bitOffsets[i6]) & i9) | ((byte) (bArr[i12] & (~i9))));
                    i13++;
                    i12++;
                    i10++;
                }
                i8 += this.scanlineStride;
            }
        } else {
            int i14 = this.dbOffset + this.dataOffsets[i6] + i7;
            int i15 = 0;
            for (int i16 = 0; i16 < i5; i16++) {
                int i17 = i14;
                int i18 = 0;
                while (i18 < i4) {
                    this.data[i17] = (byte) iArr[i15];
                    i17 += this.pixelStride;
                    i18++;
                    i15++;
                }
                i14 += this.scanlineStride;
            }
        }
        markDirty();
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster
    public String toString() {
        return new String("ByteInterleavedRaster: width = " + this.width + " height = " + this.height + " #numDataElements " + this.numDataElements + " dataOff[0] = " + this.dataOffsets[0]);
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster, org.apache.poi.java.awt.image.Raster
    public WritableRaster createCompatibleWritableRaster() {
        return createCompatibleWritableRaster(this.width, this.height);
    }

    public ByteInterleavedRaster(SampleModel sampleModel, DataBuffer dataBuffer, Point point) {
        this(sampleModel, dataBuffer, new Rectangle(point.f10092x, point.f10093y, sampleModel.getWidth(), sampleModel.getHeight()), point, null);
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster, org.apache.poi.java.awt.image.Raster
    public Object getDataElements(int i, int i2, int i4, int i5, Object obj) {
        return getByteData(i, i2, i4, i5, (byte[]) obj);
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster, org.apache.poi.java.awt.image.WritableRaster
    public void setDataElements(int i, int i2, Raster raster) {
        int minX = raster.getMinX();
        int minY = raster.getMinY();
        int i4 = i + minX;
        int i5 = i2 + minY;
        int width = raster.getWidth();
        int height = raster.getHeight();
        if (i4 >= this.minX && i5 >= this.minY && i4 + width <= this.maxX && i5 + height <= this.maxY) {
            setDataElements(i4, i5, minX, minY, width, height, raster);
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }

    public ByteInterleavedRaster(SampleModel sampleModel, DataBuffer dataBuffer, Rectangle rectangle, Point point, ByteInterleavedRaster byteInterleavedRaster) {
        super(sampleModel, dataBuffer, rectangle, point, byteInterleavedRaster);
        this.packed = false;
        this.maxX = this.minX + this.width;
        this.maxY = this.minY + this.height;
        if (dataBuffer instanceof DataBufferByte) {
            DataBufferByte dataBufferByte = (DataBufferByte) dataBuffer;
            this.data = SunWritableRaster.stealData(dataBufferByte, 0);
            int i = rectangle.f10094x - point.f10092x;
            int i2 = rectangle.f10095y - point.f10093y;
            int i4 = 1;
            if (!(sampleModel instanceof PixelInterleavedSampleModel) && (!(sampleModel instanceof ComponentSampleModel) || !isInterleaved((ComponentSampleModel) sampleModel))) {
                if (sampleModel instanceof SinglePixelPackedSampleModel) {
                    SinglePixelPackedSampleModel singlePixelPackedSampleModel = (SinglePixelPackedSampleModel) sampleModel;
                    this.packed = true;
                    this.bitMasks = singlePixelPackedSampleModel.getBitMasks();
                    this.bitOffsets = singlePixelPackedSampleModel.getBitOffsets();
                    this.scanlineStride = singlePixelPackedSampleModel.getScanlineStride();
                    this.pixelStride = 1;
                    this.dataOffsets = new int[]{dataBufferByte.getOffset()};
                    int[] iArr = this.dataOffsets;
                    iArr[0] = AbstractC1974b.m1310c(i2, this.scanlineStride, this.pixelStride * i, iArr[0]);
                } else {
                    throw new RasterFormatException("ByteInterleavedRasters must have PixelInterleavedSampleModel, SinglePixelPackedSampleModel or interleaved ComponentSampleModel.  Sample model is " + sampleModel);
                }
            } else {
                ComponentSampleModel componentSampleModel = (ComponentSampleModel) sampleModel;
                this.scanlineStride = componentSampleModel.getScanlineStride();
                this.pixelStride = componentSampleModel.getPixelStride();
                this.dataOffsets = componentSampleModel.getBandOffsets();
                for (int i5 = 0; i5 < getNumDataElements(); i5++) {
                    int[] iArr2 = this.dataOffsets;
                    iArr2[i5] = AbstractC1974b.m1310c(i2, this.scanlineStride, this.pixelStride * i, iArr2[i5]);
                }
            }
            this.bandOffset = this.dataOffsets[0];
            int offset = dataBuffer.getOffset();
            int i6 = this.sampleModelTranslateY;
            int i7 = this.scanlineStride;
            int i8 = offset - (i6 * i7);
            int i9 = this.sampleModelTranslateX;
            int i10 = this.pixelStride;
            int i11 = i8 - (i9 * i10);
            this.dbOffsetPacked = i11;
            this.dbOffset = i11 - ((i2 * i7) + (i * i10));
            this.inOrder = false;
            if (this.numDataElements == i10) {
                this.inOrder = true;
                while (true) {
                    if (i4 >= this.numDataElements) {
                        break;
                    }
                    int[] iArr3 = this.dataOffsets;
                    if (iArr3[i4] - iArr3[0] != i4) {
                        this.inOrder = false;
                        break;
                    }
                    i4++;
                }
            }
            verify();
            return;
        }
        throw new RasterFormatException("ByteInterleavedRasters must have byte DataBuffers");
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster
    public byte[] getByteData(int i, int i2, int i4, int i5, byte[] bArr) {
        int i6;
        int i7 = this.minX;
        if (i >= i7 && i2 >= (i6 = this.minY) && i + i4 <= this.maxX && i2 + i5 <= this.maxY) {
            byte[] bArr2 = bArr == null ? new byte[this.numDataElements * i4 * i5] : bArr;
            int i8 = i2 - i6;
            int i9 = this.scanlineStride;
            int i10 = i - i7;
            int i11 = this.pixelStride;
            int i12 = (i10 * i11) + (i8 * i9);
            int i13 = 0;
            if (this.inOrder) {
                int i14 = i12 + this.dataOffsets[0];
                int i15 = i4 * i11;
                if (i9 == i15) {
                    System.arraycopy(this.data, i14, bArr2, 0, i15 * i5);
                    return bArr2;
                }
                int i16 = 0;
                while (i13 < i5) {
                    System.arraycopy(this.data, i14, bArr2, i16, i15);
                    i16 += i15;
                    i13++;
                    i14 += this.scanlineStride;
                }
            } else {
                int i17 = this.numDataElements;
                if (i17 == 1) {
                    int i18 = i12 + this.dataOffsets[0];
                    int i19 = 0;
                    int i20 = 0;
                    while (i19 < i5) {
                        int i21 = i18;
                        int i22 = 0;
                        while (i22 < i4) {
                            bArr2[i20] = this.data[i21];
                            i22++;
                            i21 += this.pixelStride;
                            i20++;
                        }
                        i19++;
                        i18 += this.scanlineStride;
                    }
                } else if (i17 == 2) {
                    int[] iArr = this.dataOffsets;
                    int i23 = iArr[0];
                    int i24 = i12 + i23;
                    int i25 = iArr[1] - i23;
                    int i26 = 0;
                    int i27 = 0;
                    while (i26 < i5) {
                        int i28 = i24;
                        int i29 = 0;
                        while (i29 < i4) {
                            int i30 = i27 + 1;
                            byte[] bArr3 = this.data;
                            bArr2[i27] = bArr3[i28];
                            i27 += 2;
                            bArr2[i30] = bArr3[i28 + i25];
                            i29++;
                            i28 += this.pixelStride;
                        }
                        i26++;
                        i24 += this.scanlineStride;
                    }
                } else if (i17 == 3) {
                    int[] iArr2 = this.dataOffsets;
                    int i31 = iArr2[0];
                    int i32 = i12 + i31;
                    int i33 = iArr2[1] - i31;
                    int i34 = iArr2[2] - i31;
                    int i35 = 0;
                    int i36 = 0;
                    while (i35 < i5) {
                        int i37 = i32;
                        int i38 = 0;
                        while (i38 < i4) {
                            byte[] bArr4 = this.data;
                            bArr2[i36] = bArr4[i37];
                            int i39 = i36 + 2;
                            bArr2[i36 + 1] = bArr4[i37 + i33];
                            i36 += 3;
                            bArr2[i39] = bArr4[i37 + i34];
                            i38++;
                            i37 += this.pixelStride;
                        }
                        i35++;
                        i32 += this.scanlineStride;
                    }
                } else if (i17 == 4) {
                    int[] iArr3 = this.dataOffsets;
                    int i40 = iArr3[0];
                    int i41 = i12 + i40;
                    int i42 = iArr3[1] - i40;
                    int i43 = iArr3[2] - i40;
                    int i44 = iArr3[3] - i40;
                    int i45 = 0;
                    int i46 = 0;
                    while (i45 < i5) {
                        int i47 = i41;
                        int i48 = 0;
                        while (i48 < i4) {
                            byte[] bArr5 = this.data;
                            bArr2[i46] = bArr5[i47];
                            bArr2[i46 + 1] = bArr5[i47 + i42];
                            int i49 = i46 + 3;
                            bArr2[i46 + 2] = bArr5[i47 + i43];
                            i46 += 4;
                            bArr2[i49] = bArr5[i47 + i44];
                            i48++;
                            i47 += this.pixelStride;
                        }
                        i45++;
                        i41 += this.scanlineStride;
                    }
                } else {
                    int i50 = 0;
                    int i51 = 0;
                    while (i50 < i5) {
                        int i52 = i12;
                        int i53 = 0;
                        while (i53 < i4) {
                            int i54 = 0;
                            while (i54 < this.numDataElements) {
                                bArr2[i51] = this.data[this.dataOffsets[i54] + i52];
                                i54++;
                                i51++;
                            }
                            i53++;
                            i52 += this.pixelStride;
                        }
                        i50++;
                        i12 += this.scanlineStride;
                    }
                }
            }
            return bArr2;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster
    public void putByteData(int i, int i2, int i4, int i5, byte[] bArr) {
        int i6;
        int i7 = this.minX;
        if (i >= i7 && i2 >= (i6 = this.minY) && i + i4 <= this.maxX && i2 + i5 <= this.maxY) {
            int i8 = i2 - i6;
            int i9 = this.scanlineStride;
            int i10 = i - i7;
            int i11 = this.pixelStride;
            int i12 = (i10 * i11) + (i8 * i9);
            int i13 = 0;
            if (this.inOrder) {
                int i14 = i12 + this.dataOffsets[0];
                int i15 = i4 * i11;
                if (i15 == i9) {
                    System.arraycopy(bArr, 0, this.data, i14, i15 * i5);
                } else {
                    int i16 = 0;
                    while (i13 < i5) {
                        System.arraycopy(bArr, i16, this.data, i14, i15);
                        i16 += i15;
                        i13++;
                        i14 += this.scanlineStride;
                    }
                }
            } else {
                int i17 = this.numDataElements;
                if (i17 == 1) {
                    int i18 = i12 + this.dataOffsets[0];
                    int i19 = 0;
                    int i20 = 0;
                    while (i19 < i5) {
                        int i21 = i18;
                        int i22 = 0;
                        while (i22 < i4) {
                            this.data[i21] = bArr[i20];
                            i22++;
                            i21 += this.pixelStride;
                            i20++;
                        }
                        i19++;
                        i18 += this.scanlineStride;
                    }
                } else if (i17 == 2) {
                    int[] iArr = this.dataOffsets;
                    int i23 = iArr[0];
                    int i24 = i12 + i23;
                    int i25 = iArr[1] - i23;
                    int i26 = 0;
                    int i27 = 0;
                    while (i26 < i5) {
                        int i28 = i24;
                        int i29 = 0;
                        while (i29 < i4) {
                            byte[] bArr2 = this.data;
                            int i30 = i27 + 1;
                            bArr2[i28] = bArr[i27];
                            i27 += 2;
                            bArr2[i28 + i25] = bArr[i30];
                            i29++;
                            i28 += this.pixelStride;
                        }
                        i26++;
                        i24 += this.scanlineStride;
                    }
                } else if (i17 == 3) {
                    int[] iArr2 = this.dataOffsets;
                    int i31 = iArr2[0];
                    int i32 = i12 + i31;
                    int i33 = iArr2[1] - i31;
                    int i34 = iArr2[2] - i31;
                    int i35 = 0;
                    int i36 = 0;
                    while (i35 < i5) {
                        int i37 = i32;
                        int i38 = 0;
                        while (i38 < i4) {
                            byte[] bArr3 = this.data;
                            bArr3[i37] = bArr[i36];
                            int i39 = i36 + 2;
                            bArr3[i37 + i33] = bArr[i36 + 1];
                            i36 += 3;
                            bArr3[i37 + i34] = bArr[i39];
                            i38++;
                            i37 += this.pixelStride;
                        }
                        i35++;
                        i32 += this.scanlineStride;
                    }
                } else if (i17 == 4) {
                    int[] iArr3 = this.dataOffsets;
                    int i40 = iArr3[0];
                    int i41 = i12 + i40;
                    int i42 = iArr3[1] - i40;
                    int i43 = iArr3[2] - i40;
                    int i44 = iArr3[3] - i40;
                    int i45 = 0;
                    int i46 = 0;
                    while (i45 < i5) {
                        int i47 = i41;
                        int i48 = 0;
                        while (i48 < i4) {
                            byte[] bArr4 = this.data;
                            bArr4[i47] = bArr[i46];
                            bArr4[i47 + i42] = bArr[i46 + 1];
                            int i49 = i46 + 3;
                            bArr4[i47 + i43] = bArr[i46 + 2];
                            i46 += 4;
                            bArr4[i47 + i44] = bArr[i49];
                            i48++;
                            i47 += this.pixelStride;
                        }
                        i45++;
                        i41 += this.scanlineStride;
                    }
                } else {
                    int i50 = 0;
                    int i51 = 0;
                    while (i50 < i5) {
                        int i52 = i12;
                        int i53 = 0;
                        while (i53 < i4) {
                            int i54 = 0;
                            while (i54 < this.numDataElements) {
                                this.data[this.dataOffsets[i54] + i52] = bArr[i51];
                                i54++;
                                i51++;
                            }
                            i53++;
                            i52 += this.pixelStride;
                        }
                        i50++;
                        i12 += this.scanlineStride;
                    }
                }
            }
            markDirty();
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }

    private void setDataElements(int i, int i2, int i4, int i5, int i6, int i7, Raster raster) {
        Raster raster2 = raster;
        if (i6 <= 0 || i7 <= 0) {
            return;
        }
        int minX = raster2.getMinX();
        int minY = raster2.getMinY();
        if (raster2 instanceof ByteInterleavedRaster) {
            ByteInterleavedRaster byteInterleavedRaster = (ByteInterleavedRaster) raster2;
            byte[] dataStorage = byteInterleavedRaster.getDataStorage();
            if (this.inOrder && byteInterleavedRaster.inOrder && this.pixelStride == byteInterleavedRaster.pixelStride) {
                int dataOffset = byteInterleavedRaster.getDataOffset(0);
                int scanlineStride = byteInterleavedRaster.getScanlineStride();
                int iM1304A = AbstractC1974b.m1304A(i4, minX, byteInterleavedRaster.getPixelStride(), AbstractC1974b.m1304A(i5, minY, scanlineStride, dataOffset));
                int i8 = ((i2 - this.minY) * this.scanlineStride) + this.dataOffsets[0];
                int i9 = i - this.minX;
                int i10 = this.pixelStride;
                int i11 = (i9 * i10) + i8;
                int i12 = i6 * i10;
                for (int i13 = 0; i13 < i7; i13++) {
                    System.arraycopy(dataStorage, iM1304A, this.data, i11, i12);
                    iM1304A += scanlineStride;
                    i11 += this.scanlineStride;
                }
                markDirty();
                return;
            }
        }
        Object obj = null;
        int i14 = 0;
        while (i14 < i7) {
            Object dataElements = raster2.getDataElements(minX, minY + i14, i6, 1, obj);
            setDataElements(i, i2 + i14, i6, 1, dataElements);
            i14++;
            raster2 = raster;
            obj = dataElements;
        }
    }

    @Override // org.apache.poi.sun.awt.image.ByteComponentRaster, org.apache.poi.java.awt.image.WritableRaster
    public void setDataElements(int i, int i2, int i4, int i5, Object obj) {
        putByteData(i, i2, i4, i5, (byte[]) obj);
    }
}
