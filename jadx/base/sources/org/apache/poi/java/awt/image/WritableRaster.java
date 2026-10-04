package org.apache.poi.java.awt.image;

import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;

/* JADX INFO: loaded from: classes10.dex */
public class WritableRaster extends Raster {
    public WritableRaster(SampleModel sampleModel, Point point) {
        this(sampleModel, sampleModel.createDataBuffer(), new Rectangle(point.f10092x, point.f10093y, sampleModel.getWidth(), sampleModel.getHeight()), point, null);
    }

    public WritableRaster createWritableChild(int i, int i2, int i4, int i5, int i6, int i7, int[] iArr) {
        int i8 = this.minX;
        if (i < i8) {
            throw new RasterFormatException("parentX lies outside raster");
        }
        int i9 = this.minY;
        if (i2 < i9) {
            throw new RasterFormatException("parentY lies outside raster");
        }
        int i10 = i + i4;
        if (i10 < i || i10 > this.width + i8) {
            throw new RasterFormatException("(parentX + width) is outside raster");
        }
        int i11 = i2 + i5;
        if (i11 < i2 || i11 > this.height + i9) {
            throw new RasterFormatException("(parentY + height) is outside raster");
        }
        return new WritableRaster(iArr != null ? this.sampleModel.createSubsetSampleModel(iArr) : this.sampleModel, getDataBuffer(), new Rectangle(i6, i7, i4, i5), new Point(this.sampleModelTranslateX + (i6 - i), this.sampleModelTranslateY + (i7 - i2)), this);
    }

    public WritableRaster createWritableTranslatedChild(int i, int i2) {
        return createWritableChild(this.minX, this.minY, this.width, this.height, i, i2, null);
    }

    public WritableRaster getWritableParent() {
        return (WritableRaster) this.parent;
    }

    public void setDataElements(int i, int i2, int i4, int i5, Object obj) {
        this.sampleModel.setDataElements(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, i5, obj, this.dataBuffer);
    }

    public void setPixel(int i, int i2, double[] dArr) {
        this.sampleModel.setPixel(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, dArr, this.dataBuffer);
    }

    public void setPixels(int i, int i2, int i4, int i5, double[] dArr) {
        this.sampleModel.setPixels(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, i5, dArr, this.dataBuffer);
    }

    public void setRect(int i, int i2, Raster raster) {
        int i4;
        WritableRaster writableRaster = this;
        int width = raster.getWidth();
        int height = raster.getHeight();
        int minX = raster.getMinX();
        int minY = raster.getMinY();
        int i5 = i + minX;
        int i6 = i2 + minY;
        int i7 = writableRaster.minX;
        if (i5 < i7) {
            int i8 = i7 - i5;
            width -= i8;
            minX += i8;
            i5 = i7;
        }
        int i9 = minX;
        int i10 = writableRaster.minY;
        if (i6 < i10) {
            int i11 = i10 - i6;
            height -= i11;
            minY += i11;
            i4 = i10;
        } else {
            i4 = i6;
        }
        int i12 = minY;
        int i13 = i5 + width;
        int i14 = writableRaster.width;
        if (i13 > i7 + i14) {
            width = (i7 + i14) - i5;
        }
        int i15 = width;
        int i16 = i4 + height;
        int i17 = writableRaster.height;
        if (i16 > i10 + i17) {
            height = (i10 + i17) - i4;
        }
        int i18 = height;
        if (i15 <= 0 || i18 <= 0) {
            return;
        }
        int dataType = raster.getSampleModel().getDataType();
        if (dataType == 0 || dataType == 1 || dataType == 2 || dataType == 3) {
            int i19 = i5;
            int i20 = 0;
            int[] iArr = null;
            while (i20 < i18) {
                int[] pixels = raster.getPixels(i9, i12 + i20, i15, 1, iArr);
                setPixels(i19, i4 + i20, i15, 1, pixels);
                i20++;
                iArr = pixels;
            }
            return;
        }
        if (dataType == 4) {
            int i21 = i5;
            int i22 = 0;
            float[] fArr = null;
            while (i22 < i18) {
                float[] pixels2 = raster.getPixels(i9, i12 + i22, i15, 1, fArr);
                setPixels(i21, i4 + i22, i15, 1, pixels2);
                i22++;
                fArr = pixels2;
            }
            return;
        }
        if (dataType != 5) {
            return;
        }
        int i23 = 0;
        double[] dArr = null;
        while (i23 < i18) {
            double[] pixels3 = raster.getPixels(i9, i12 + i23, i15, 1, dArr);
            int i24 = i5;
            writableRaster.setPixels(i24, i4 + i23, i15, 1, pixels3);
            i23++;
            writableRaster = this;
            dArr = pixels3;
            i5 = i24;
        }
    }

    public void setSample(int i, int i2, int i4, double d) {
        this.sampleModel.setSample(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, d, this.dataBuffer);
    }

    public void setSamples(int i, int i2, int i4, int i5, int i6, double[] dArr) {
        this.sampleModel.setSamples(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, i5, i6, dArr, this.dataBuffer);
    }

    public WritableRaster(SampleModel sampleModel, DataBuffer dataBuffer, Point point) {
        this(sampleModel, dataBuffer, new Rectangle(point.f10092x, point.f10093y, sampleModel.getWidth(), sampleModel.getHeight()), point, null);
    }

    public void setDataElements(int i, int i2, Object obj) {
        this.sampleModel.setDataElements(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, obj, this.dataBuffer);
    }

    public void setPixel(int i, int i2, float[] fArr) {
        this.sampleModel.setPixel(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, fArr, this.dataBuffer);
    }

    public void setPixels(int i, int i2, int i4, int i5, float[] fArr) {
        this.sampleModel.setPixels(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, i5, fArr, this.dataBuffer);
    }

    public void setRect(Raster raster) {
        setRect(0, 0, raster);
    }

    public void setSample(int i, int i2, int i4, float f) {
        this.sampleModel.setSample(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, f, this.dataBuffer);
    }

    public void setSamples(int i, int i2, int i4, int i5, int i6, float[] fArr) {
        this.sampleModel.setSamples(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, i5, i6, fArr, this.dataBuffer);
    }

    public WritableRaster(SampleModel sampleModel, DataBuffer dataBuffer, Rectangle rectangle, Point point, WritableRaster writableRaster) {
        super(sampleModel, dataBuffer, rectangle, point, writableRaster);
    }

    public void setDataElements(int i, int i2, Raster raster) {
        int i4;
        int minX = raster.getMinX() + i;
        int minY = raster.getMinY() + i2;
        int width = raster.getWidth();
        int height = raster.getHeight();
        int i5 = this.minX;
        if (minX < i5 || minY < (i4 = this.minY) || minX + width > i5 + this.width || minY + height > i4 + this.height) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int i6 = width;
        int minX2 = raster.getMinX();
        int minY2 = raster.getMinY();
        Object obj = null;
        int i7 = 0;
        while (i7 < height) {
            Raster raster2 = raster;
            Object dataElements = raster2.getDataElements(minX2, minY2 + i7, i6, 1, obj);
            int i8 = minX2;
            int i9 = i6;
            setDataElements(minX, minY + i7, i9, 1, dataElements);
            i7++;
            i6 = i9;
            minX2 = i8;
            obj = dataElements;
            raster = raster2;
        }
    }

    public void setPixel(int i, int i2, int[] iArr) {
        this.sampleModel.setPixel(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, iArr, this.dataBuffer);
    }

    public void setPixels(int i, int i2, int i4, int i5, int[] iArr) {
        this.sampleModel.setPixels(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, i5, iArr, this.dataBuffer);
    }

    public void setSample(int i, int i2, int i4, int i5) {
        this.sampleModel.setSample(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, i5, this.dataBuffer);
    }

    public void setSamples(int i, int i2, int i4, int i5, int i6, int[] iArr) {
        this.sampleModel.setSamples(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, i5, i6, iArr, this.dataBuffer);
    }
}
