package org.apache.poi.sun.awt.image;

import androidx.compose.runtime.AbstractC1974b;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.image.DataBuffer;
import org.apache.poi.java.awt.image.DataBufferInt;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RasterFormatException;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.java.awt.image.SinglePixelPackedSampleModel;
import org.apache.poi.java.awt.image.WritableRaster;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IntegerInterleavedRaster extends IntegerComponentRaster {
    private int maxX;
    private int maxY;

    public IntegerInterleavedRaster(SampleModel sampleModel, Point point) {
        this(sampleModel, sampleModel.createDataBuffer(), new Rectangle(point.f10092x, point.f10093y, sampleModel.getWidth(), sampleModel.getHeight()), point, null);
    }

    @Override // org.apache.poi.sun.awt.image.IntegerComponentRaster, org.apache.poi.java.awt.image.Raster
    public Raster createChild(int i, int i2, int i4, int i5, int i6, int i7, int[] iArr) {
        return createWritableChild(i, i2, i4, i5, i6, i7, iArr);
    }

    @Override // org.apache.poi.sun.awt.image.IntegerComponentRaster, org.apache.poi.java.awt.image.Raster
    public WritableRaster createCompatibleWritableRaster(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new RasterFormatException("negative ".concat(i <= 0 ? "width" : "height"));
        }
        return new IntegerInterleavedRaster(this.sampleModel.createCompatibleSampleModel(i, i2), new Point(0, 0));
    }

    @Override // org.apache.poi.sun.awt.image.IntegerComponentRaster, org.apache.poi.java.awt.image.WritableRaster
    public WritableRaster createWritableChild(int i, int i2, int i4, int i5, int i6, int i7, int[] iArr) {
        int i8 = this.minX;
        if (i < i8) {
            throw new RasterFormatException("x lies outside raster");
        }
        int i9 = this.minY;
        if (i2 < i9) {
            throw new RasterFormatException("y lies outside raster");
        }
        int i10 = i + i4;
        if (i10 < i || i10 > i8 + this.width) {
            throw new RasterFormatException("(x + width) is outside raster");
        }
        int i11 = i2 + i5;
        if (i11 < i2 || i11 > i9 + this.height) {
            throw new RasterFormatException("(y + height) is outside raster");
        }
        return new IntegerInterleavedRaster(iArr != null ? this.sampleModel.createSubsetSampleModel(iArr) : this.sampleModel, this.dataBuffer, new Rectangle(i6, i7, i4, i5), new Point(this.sampleModelTranslateX + (i6 - i), this.sampleModelTranslateY + (i7 - i2)), this);
    }

    @Override // org.apache.poi.sun.awt.image.IntegerComponentRaster, org.apache.poi.java.awt.image.Raster
    public Object getDataElements(int i, int i2, Object obj) {
        int i4;
        int i5 = this.minX;
        if (i < i5 || i2 < (i4 = this.minY) || i >= this.maxX || i2 >= this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int[] iArr = obj == null ? new int[1] : (int[]) obj;
        iArr[0] = this.data[(i - i5) + ((i2 - i4) * this.scanlineStride) + this.dataOffsets[0]];
        return iArr;
    }

    @Override // org.apache.poi.sun.awt.image.IntegerComponentRaster
    public int getDataOffset(int i) {
        return this.dataOffsets[i];
    }

    @Override // org.apache.poi.sun.awt.image.IntegerComponentRaster
    public int[] getDataOffsets() {
        return (int[]) this.dataOffsets.clone();
    }

    @Override // org.apache.poi.sun.awt.image.IntegerComponentRaster
    public int[] getDataStorage() {
        return this.data;
    }

    @Override // org.apache.poi.sun.awt.image.IntegerComponentRaster
    public int getPixelStride() {
        return this.pixelStride;
    }

    @Override // org.apache.poi.sun.awt.image.IntegerComponentRaster
    public int getScanlineStride() {
        return this.scanlineStride;
    }

    @Override // org.apache.poi.sun.awt.image.IntegerComponentRaster, org.apache.poi.java.awt.image.WritableRaster
    public void setDataElements(int i, int i2, Object obj) {
        int i4;
        int i5 = this.minX;
        if (i < i5 || i2 < (i4 = this.minY) || i >= this.maxX || i2 >= this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        this.data[(i - i5) + ((i2 - i4) * this.scanlineStride) + this.dataOffsets[0]] = ((int[]) obj)[0];
        markDirty();
    }

    @Override // org.apache.poi.sun.awt.image.IntegerComponentRaster
    public String toString() {
        return new String("IntegerInterleavedRaster: width = " + this.width + " height = " + this.height + " #Bands = " + this.numBands + " xOff = " + this.sampleModelTranslateX + " yOff = " + this.sampleModelTranslateY + " dataOffset[0] " + this.dataOffsets[0]);
    }

    @Override // org.apache.poi.sun.awt.image.IntegerComponentRaster, org.apache.poi.java.awt.image.Raster
    public WritableRaster createCompatibleWritableRaster() {
        return createCompatibleWritableRaster(this.width, this.height);
    }

    public IntegerInterleavedRaster(SampleModel sampleModel, DataBuffer dataBuffer, Point point) {
        this(sampleModel, dataBuffer, new Rectangle(point.f10092x, point.f10093y, sampleModel.getWidth(), sampleModel.getHeight()), point, null);
    }

    @Override // org.apache.poi.sun.awt.image.IntegerComponentRaster, org.apache.poi.java.awt.image.Raster
    public Object getDataElements(int i, int i2, int i4, int i5, Object obj) {
        int i6;
        int[] iArr;
        int i7 = this.minX;
        if (i >= i7 && i2 >= (i6 = this.minY) && i + i4 <= this.maxX && i2 + i5 <= this.maxY) {
            if (obj instanceof int[]) {
                iArr = (int[]) obj;
            } else {
                iArr = new int[i4 * i5];
            }
            int i8 = i - i7;
            int i9 = i8 + ((i2 - i6) * this.scanlineStride) + this.dataOffsets[0];
            int i10 = 0;
            for (int i11 = 0; i11 < i5; i11++) {
                System.arraycopy(this.data, i9, iArr, i10, i4);
                i10 += i4;
                i9 += this.scanlineStride;
            }
            return iArr;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }

    @Override // org.apache.poi.sun.awt.image.IntegerComponentRaster, org.apache.poi.java.awt.image.WritableRaster
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

    public IntegerInterleavedRaster(SampleModel sampleModel, DataBuffer dataBuffer, Rectangle rectangle, Point point, IntegerInterleavedRaster integerInterleavedRaster) {
        super(sampleModel, dataBuffer, rectangle, point, integerInterleavedRaster);
        this.maxX = this.minX + this.width;
        this.maxY = this.minY + this.height;
        if (dataBuffer instanceof DataBufferInt) {
            DataBufferInt dataBufferInt = (DataBufferInt) dataBuffer;
            this.data = SunWritableRaster.stealData(dataBufferInt, 0);
            if (sampleModel instanceof SinglePixelPackedSampleModel) {
                SinglePixelPackedSampleModel singlePixelPackedSampleModel = (SinglePixelPackedSampleModel) sampleModel;
                this.scanlineStride = singlePixelPackedSampleModel.getScanlineStride();
                this.pixelStride = 1;
                this.dataOffsets = new int[]{dataBufferInt.getOffset()};
                int[] iArr = this.dataOffsets;
                int i = iArr[0];
                this.bandOffset = i;
                iArr[0] = AbstractC1974b.m1310c(rectangle.f10095y - point.f10093y, this.scanlineStride, rectangle.f10094x - point.f10092x, i);
                this.numDataElems = singlePixelPackedSampleModel.getNumDataElements();
                verify();
                return;
            }
            throw new RasterFormatException("IntegerInterleavedRasters must have SinglePixelPackedSampleModel");
        }
        throw new RasterFormatException("IntegerInterleavedRasters must haveinteger DataBuffers");
    }

    private void setDataElements(int i, int i2, int i4, int i5, Raster raster) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        int minX = raster.getMinX();
        int minY = raster.getMinY();
        if (!(raster instanceof IntegerInterleavedRaster)) {
            Object obj = null;
            int i6 = 0;
            while (i6 < i5) {
                Object dataElements = raster.getDataElements(minX, minY + i6, i4, 1, obj);
                setDataElements(i, i2 + i6, i4, 1, dataElements);
                i6++;
                minX = minX;
                obj = dataElements;
            }
            return;
        }
        IntegerInterleavedRaster integerInterleavedRaster = (IntegerInterleavedRaster) raster;
        int[] dataStorage = integerInterleavedRaster.getDataStorage();
        int scanlineStride = integerInterleavedRaster.getScanlineStride();
        int dataOffset = integerInterleavedRaster.getDataOffset(0);
        int i7 = (i - this.minX) + ((i2 - this.minY) * this.scanlineStride) + this.dataOffsets[0];
        for (int i8 = 0; i8 < i5; i8++) {
            System.arraycopy(dataStorage, dataOffset, this.data, i7, i4);
            dataOffset += scanlineStride;
            i7 += this.scanlineStride;
        }
        markDirty();
    }

    @Override // org.apache.poi.sun.awt.image.IntegerComponentRaster, org.apache.poi.java.awt.image.WritableRaster
    public void setDataElements(int i, int i2, int i4, int i5, Object obj) {
        int i6;
        int i7 = this.minX;
        if (i >= i7 && i2 >= (i6 = this.minY) && i + i4 <= this.maxX && i2 + i5 <= this.maxY) {
            int[] iArr = (int[]) obj;
            int i8 = i - i7;
            int i9 = i8 + ((i2 - i6) * this.scanlineStride) + this.dataOffsets[0];
            int i10 = 0;
            for (int i11 = 0; i11 < i5; i11++) {
                System.arraycopy(iArr, i10, this.data, i9, i4);
                i10 += i4;
                i9 += this.scanlineStride;
            }
            markDirty();
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }
}
