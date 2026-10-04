package org.apache.poi.sun.awt.image;

import androidx.compose.runtime.AbstractC1974b;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.image.ComponentSampleModel;
import org.apache.poi.java.awt.image.DataBuffer;
import org.apache.poi.java.awt.image.DataBufferUShort;
import org.apache.poi.java.awt.image.PixelInterleavedSampleModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RasterFormatException;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.java.awt.image.SinglePixelPackedSampleModel;
import org.apache.poi.java.awt.image.WritableRaster;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ShortInterleavedRaster extends ShortComponentRaster {
    private int maxX;
    private int maxY;

    public ShortInterleavedRaster(SampleModel sampleModel, Point point) {
        this(sampleModel, sampleModel.createDataBuffer(), new Rectangle(point.f10092x, point.f10093y, sampleModel.getWidth(), sampleModel.getHeight()), point, null);
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster, org.apache.poi.java.awt.image.Raster
    public Raster createChild(int i, int i2, int i4, int i5, int i6, int i7, int[] iArr) {
        return createWritableChild(i, i2, i4, i5, i6, i7, iArr);
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster, org.apache.poi.java.awt.image.Raster
    public WritableRaster createCompatibleWritableRaster(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new RasterFormatException("negative ".concat(i <= 0 ? "width" : "height"));
        }
        return new ShortInterleavedRaster(this.sampleModel.createCompatibleSampleModel(i, i2), new Point(0, 0));
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster, org.apache.poi.java.awt.image.WritableRaster
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
        return new ShortInterleavedRaster(iArr != null ? this.sampleModel.createSubsetSampleModel(iArr) : this.sampleModel, this.dataBuffer, new Rectangle(i6, i7, i4, i5), new Point(this.sampleModelTranslateX + (i6 - i), this.sampleModelTranslateY + (i7 - i2)), this);
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster, org.apache.poi.java.awt.image.Raster
    public Object getDataElements(int i, int i2, Object obj) {
        int i4;
        int i5 = this.minX;
        if (i < i5 || i2 < (i4 = this.minY) || i >= this.maxX || i2 >= this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        short[] sArr = obj == null ? new short[this.numDataElements] : (short[]) obj;
        int i6 = ((i - i5) * this.pixelStride) + ((i2 - i4) * this.scanlineStride);
        for (int i7 = 0; i7 < this.numDataElements; i7++) {
            sArr[i7] = this.data[this.dataOffsets[i7] + i6];
        }
        return sArr;
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster
    public int getDataOffset(int i) {
        return this.dataOffsets[i];
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster
    public int[] getDataOffsets() {
        return (int[]) this.dataOffsets.clone();
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster
    public short[] getDataStorage() {
        return this.data;
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster
    public int getPixelStride() {
        return this.pixelStride;
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster
    public int getScanlineStride() {
        return this.scanlineStride;
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster
    public short[] getShortData(int i, int i2, int i4, int i5, int i6, short[] sArr) {
        int i7;
        int i8 = this.minX;
        if (i < i8 || i2 < (i7 = this.minY) || i + i4 > this.maxX || i2 + i5 > this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (sArr == null) {
            sArr = new short[this.numDataElements * i4 * i5];
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
                    sArr[i16] = this.data[i17];
                    i18++;
                    i17 += this.pixelStride;
                    i16++;
                }
                i15++;
                i13 += this.scanlineStride;
            }
        } else {
            if (i10 == i4) {
                System.arraycopy(this.data, i13, sArr, 0, i4 * i5);
                return sArr;
            }
            int i19 = 0;
            while (i14 < i5) {
                System.arraycopy(this.data, i13, sArr, i19, i4);
                i19 += i4;
                i14++;
                i13 += this.scanlineStride;
            }
        }
        return sArr;
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster
    public void putShortData(int i, int i2, int i4, int i5, int i6, short[] sArr) {
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
                    this.data[i17] = sArr[i16];
                    i18++;
                    i17 += this.pixelStride;
                    i16++;
                }
                i15++;
                i13 += this.scanlineStride;
            }
        } else if (i10 == i4) {
            System.arraycopy(sArr, 0, this.data, i13, i4 * i5);
        } else {
            int i19 = 0;
            while (i14 < i5) {
                System.arraycopy(sArr, i19, this.data, i13, i4);
                i19 += i4;
                i14++;
                i13 += this.scanlineStride;
            }
        }
        markDirty();
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster, org.apache.poi.java.awt.image.WritableRaster
    public void setDataElements(int i, int i2, Object obj) {
        int i4;
        int i5 = this.minX;
        if (i < i5 || i2 < (i4 = this.minY) || i >= this.maxX || i2 >= this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        short[] sArr = (short[]) obj;
        int i6 = ((i - i5) * this.pixelStride) + ((i2 - i4) * this.scanlineStride);
        for (int i7 = 0; i7 < this.numDataElements; i7++) {
            this.data[this.dataOffsets[i7] + i6] = sArr[i7];
        }
        markDirty();
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster
    public String toString() {
        return new String("ShortInterleavedRaster: width = " + this.width + " height = " + this.height + " #numDataElements " + this.numDataElements);
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster, org.apache.poi.java.awt.image.Raster
    public WritableRaster createCompatibleWritableRaster() {
        return createCompatibleWritableRaster(this.width, this.height);
    }

    public ShortInterleavedRaster(SampleModel sampleModel, DataBuffer dataBuffer, Point point) {
        this(sampleModel, dataBuffer, new Rectangle(point.f10092x, point.f10093y, sampleModel.getWidth(), sampleModel.getHeight()), point, null);
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster, org.apache.poi.java.awt.image.Raster
    public Object getDataElements(int i, int i2, int i4, int i5, Object obj) {
        int i6;
        short[] sArr;
        int i7 = this.minX;
        if (i >= i7 && i2 >= (i6 = this.minY) && i + i4 <= this.maxX && i2 + i5 <= this.maxY) {
            if (obj == null) {
                sArr = new short[i4 * i5 * this.numDataElements];
            } else {
                sArr = (short[]) obj;
            }
            int i8 = ((i - i7) * this.pixelStride) + ((i2 - i6) * this.scanlineStride);
            int i9 = 0;
            int i10 = 0;
            while (i9 < i5) {
                int i11 = i8;
                int i12 = 0;
                while (i12 < i4) {
                    int i13 = 0;
                    while (i13 < this.numDataElements) {
                        sArr[i10] = this.data[this.dataOffsets[i13] + i11];
                        i13++;
                        i10++;
                    }
                    i12++;
                    i11 += this.pixelStride;
                }
                i9++;
                i8 += this.scanlineStride;
            }
            return sArr;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster, org.apache.poi.java.awt.image.WritableRaster
    public void setDataElements(int i, int i2, Raster raster) {
        int minX = raster.getMinX() + i;
        int minY = raster.getMinY() + i2;
        int width = raster.getWidth();
        int height = raster.getHeight();
        if (minX >= this.minX && minY >= this.minY && minX + width <= this.maxX && minY + height <= this.maxY) {
            setDataElements(minX, minY, width, height, raster);
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }

    public ShortInterleavedRaster(SampleModel sampleModel, DataBuffer dataBuffer, Rectangle rectangle, Point point, ShortInterleavedRaster shortInterleavedRaster) {
        super(sampleModel, dataBuffer, rectangle, point, shortInterleavedRaster);
        this.maxX = this.minX + this.width;
        this.maxY = this.minY + this.height;
        if (dataBuffer instanceof DataBufferUShort) {
            DataBufferUShort dataBufferUShort = (DataBufferUShort) dataBuffer;
            this.data = SunWritableRaster.stealData(dataBufferUShort, 0);
            if (!(sampleModel instanceof PixelInterleavedSampleModel) && (!(sampleModel instanceof ComponentSampleModel) || sampleModel.getNumBands() != 1)) {
                if (sampleModel instanceof SinglePixelPackedSampleModel) {
                    this.scanlineStride = ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride();
                    this.pixelStride = 1;
                    this.dataOffsets = new int[]{dataBufferUShort.getOffset()};
                    int i = rectangle.f10094x - point.f10092x;
                    int i2 = rectangle.f10095y - point.f10093y;
                    int[] iArr = this.dataOffsets;
                    iArr[0] = AbstractC1974b.m1310c(i2, this.scanlineStride, i, iArr[0]);
                } else {
                    throw new RasterFormatException("ShortInterleavedRasters must have PixelInterleavedSampleModel, SinglePixelPackedSampleModel or 1 band ComponentSampleModel.  Sample model is " + sampleModel);
                }
            } else {
                ComponentSampleModel componentSampleModel = (ComponentSampleModel) sampleModel;
                this.scanlineStride = componentSampleModel.getScanlineStride();
                this.pixelStride = componentSampleModel.getPixelStride();
                this.dataOffsets = componentSampleModel.getBandOffsets();
                int i4 = rectangle.f10094x - point.f10092x;
                int i5 = rectangle.f10095y - point.f10093y;
                for (int i6 = 0; i6 < getNumDataElements(); i6++) {
                    int[] iArr2 = this.dataOffsets;
                    iArr2[i6] = AbstractC1974b.m1310c(i5, this.scanlineStride, this.pixelStride * i4, iArr2[i6]);
                }
            }
            this.bandOffset = this.dataOffsets[0];
            verify();
            return;
        }
        throw new RasterFormatException("ShortInterleavedRasters must have ushort DataBuffers");
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster
    public short[] getShortData(int i, int i2, int i4, int i5, short[] sArr) {
        int i6;
        int i7 = this.minX;
        if (i >= i7 && i2 >= (i6 = this.minY) && i + i4 <= this.maxX && i2 + i5 <= this.maxY) {
            if (sArr == null) {
                sArr = new short[this.numDataElements * i4 * i5];
            }
            int i8 = ((i - i7) * this.pixelStride) + ((i2 - i6) * this.scanlineStride);
            int i9 = 0;
            int i10 = 0;
            while (i9 < i5) {
                int i11 = i8;
                int i12 = 0;
                while (i12 < i4) {
                    int i13 = 0;
                    while (i13 < this.numDataElements) {
                        sArr[i10] = this.data[this.dataOffsets[i13] + i11];
                        i13++;
                        i10++;
                    }
                    i12++;
                    i11 += this.pixelStride;
                }
                i9++;
                i8 += this.scanlineStride;
            }
            return sArr;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster
    public void putShortData(int i, int i2, int i4, int i5, short[] sArr) {
        int i6;
        int i7 = this.minX;
        if (i >= i7 && i2 >= (i6 = this.minY) && i + i4 <= this.maxX && i2 + i5 <= this.maxY) {
            int i8 = ((i - i7) * this.pixelStride) + ((i2 - i6) * this.scanlineStride);
            int i9 = 0;
            int i10 = 0;
            while (i9 < i5) {
                int i11 = i8;
                int i12 = 0;
                while (i12 < i4) {
                    int i13 = 0;
                    while (i13 < this.numDataElements) {
                        this.data[this.dataOffsets[i13] + i11] = sArr[i10];
                        i13++;
                        i10++;
                    }
                    i12++;
                    i11 += this.pixelStride;
                }
                i9++;
                i8 += this.scanlineStride;
            }
            markDirty();
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }

    private void setDataElements(int i, int i2, int i4, int i5, Raster raster) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        int minX = raster.getMinX();
        int minY = raster.getMinY();
        Object obj = null;
        int i6 = 0;
        while (i6 < i5) {
            Object dataElements = raster.getDataElements(minX, minY + i6, i4, 1, obj);
            setDataElements(i, i2 + i6, i4, 1, dataElements);
            i6++;
            obj = dataElements;
        }
    }

    @Override // org.apache.poi.sun.awt.image.ShortComponentRaster, org.apache.poi.java.awt.image.WritableRaster
    public void setDataElements(int i, int i2, int i4, int i5, Object obj) {
        int i6;
        int i7 = this.minX;
        if (i >= i7 && i2 >= (i6 = this.minY) && i + i4 <= this.maxX && i2 + i5 <= this.maxY) {
            short[] sArr = (short[]) obj;
            int i8 = ((i - i7) * this.pixelStride) + ((i2 - i6) * this.scanlineStride);
            int i9 = 0;
            int i10 = 0;
            while (i9 < i5) {
                int i11 = i8;
                int i12 = 0;
                while (i12 < i4) {
                    int i13 = 0;
                    while (i13 < this.numDataElements) {
                        this.data[this.dataOffsets[i13] + i11] = sArr[i10];
                        i13++;
                        i10++;
                    }
                    i12++;
                    i11 += this.pixelStride;
                }
                i9++;
                i8 += this.scanlineStride;
            }
            markDirty();
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }
}
