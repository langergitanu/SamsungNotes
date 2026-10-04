package org.apache.poi.java.awt.image;

import androidx.appcompat.widget.AbstractC0541b;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.sun.awt.image.ByteBandedRaster;
import org.apache.poi.sun.awt.image.ByteInterleavedRaster;
import org.apache.poi.sun.awt.image.BytePackedRaster;
import org.apache.poi.sun.awt.image.IntegerInterleavedRaster;
import org.apache.poi.sun.awt.image.ShortBandedRaster;
import org.apache.poi.sun.awt.image.ShortInterleavedRaster;
import org.apache.poi.sun.awt.image.SunWritableRaster;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Raster {
    protected DataBuffer dataBuffer;
    protected int height;
    protected int minX;
    protected int minY;
    protected int numBands;
    protected int numDataElements;
    protected Raster parent;
    protected SampleModel sampleModel;
    protected int sampleModelTranslateX;
    protected int sampleModelTranslateY;
    protected int width;

    static {
        ColorModel.loadLibraries();
    }

    public Raster(SampleModel sampleModel, Point point) {
        this(sampleModel, sampleModel.createDataBuffer(), new Rectangle(point.f10092x, point.f10093y, sampleModel.getWidth(), sampleModel.getHeight()), point, null);
    }

    public static WritableRaster createBandedRaster(int i, int i2, int i4, int i5, Point point) {
        if (i5 < 1) {
            throw new ArrayIndexOutOfBoundsException(AbstractC0541b.m767i(i5, "Number of bands (", ") must be greater than 0"));
        }
        int[] iArr = new int[i5];
        int[] iArr2 = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            iArr[i6] = i6;
            iArr2[i6] = 0;
        }
        return createBandedRaster(i, i2, i4, i2, iArr, iArr2, point);
    }

    public static WritableRaster createInterleavedRaster(int i, int i2, int i4, int i5, Point point) {
        int[] iArr = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            iArr[i6] = i6;
        }
        return createInterleavedRaster(i, i2, i4, i2 * i5, i5, iArr, point);
    }

    public static WritableRaster createPackedRaster(int i, int i2, int i4, int[] iArr, Point point) {
        DataBuffer dataBufferByte;
        if (i == 0) {
            dataBufferByte = new DataBufferByte(i2 * i4);
        } else if (i == 1) {
            dataBufferByte = new DataBufferUShort(i2 * i4);
        } else {
            if (i != 3) {
                throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unsupported data type "));
            }
            dataBufferByte = new DataBufferInt(i2 * i4);
        }
        return createPackedRaster(dataBufferByte, i2, i4, i2, iArr, point);
    }

    public static Raster createRaster(SampleModel sampleModel, DataBuffer dataBuffer, Point point) {
        if (sampleModel == null || dataBuffer == null) {
            throw new NullPointerException("SampleModel and DataBuffer cannot be null");
        }
        if (point == null) {
            point = new Point(0, 0);
        }
        int dataType = sampleModel.getDataType();
        if (sampleModel instanceof PixelInterleavedSampleModel) {
            if (dataType == 0) {
                return new ByteInterleavedRaster(sampleModel, dataBuffer, point);
            }
            if (dataType == 1) {
                return new ShortInterleavedRaster(sampleModel, dataBuffer, point);
            }
        } else if (sampleModel instanceof SinglePixelPackedSampleModel) {
            if (dataType == 0) {
                return new ByteInterleavedRaster(sampleModel, dataBuffer, point);
            }
            if (dataType == 1) {
                return new ShortInterleavedRaster(sampleModel, dataBuffer, point);
            }
            if (dataType == 3) {
                return new IntegerInterleavedRaster(sampleModel, dataBuffer, point);
            }
        } else if ((sampleModel instanceof MultiPixelPackedSampleModel) && dataType == 0 && sampleModel.getSampleSize(0) < 8) {
            return new BytePackedRaster(sampleModel, dataBuffer, point);
        }
        return new Raster(sampleModel, dataBuffer, point);
    }

    public static WritableRaster createWritableRaster(SampleModel sampleModel, Point point) {
        if (point == null) {
            point = new Point(0, 0);
        }
        return createWritableRaster(sampleModel, sampleModel.createDataBuffer(), point);
    }

    public Raster createChild(int i, int i2, int i4, int i5, int i6, int i7, int[] iArr) {
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
        return new Raster(iArr == null ? this.sampleModel : this.sampleModel.createSubsetSampleModel(iArr), getDataBuffer(), new Rectangle(i6, i7, i4, i5), new Point(this.sampleModelTranslateX + (i6 - i), this.sampleModelTranslateY + (i7 - i2)), this);
    }

    public WritableRaster createCompatibleWritableRaster() {
        return new SunWritableRaster(this.sampleModel, new Point(0, 0));
    }

    public Raster createTranslatedChild(int i, int i2) {
        return createChild(this.minX, this.minY, this.width, this.height, i, i2, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(this.minX, this.minY, this.width, this.height);
    }

    public DataBuffer getDataBuffer() {
        return this.dataBuffer;
    }

    public Object getDataElements(int i, int i2, Object obj) {
        return this.sampleModel.getDataElements(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, obj, this.dataBuffer);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getMinX() {
        return this.minX;
    }

    public final int getMinY() {
        return this.minY;
    }

    public final int getNumBands() {
        return this.numBands;
    }

    public final int getNumDataElements() {
        return this.sampleModel.getNumDataElements();
    }

    public Raster getParent() {
        return this.parent;
    }

    public int[] getPixel(int i, int i2, int[] iArr) {
        return this.sampleModel.getPixel(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, iArr, this.dataBuffer);
    }

    public int[] getPixels(int i, int i2, int i4, int i5, int[] iArr) {
        return this.sampleModel.getPixels(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, i5, iArr, this.dataBuffer);
    }

    public int getSample(int i, int i2, int i4) {
        return this.sampleModel.getSample(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, this.dataBuffer);
    }

    public double getSampleDouble(int i, int i2, int i4) {
        return this.sampleModel.getSampleDouble(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, this.dataBuffer);
    }

    public float getSampleFloat(int i, int i2, int i4) {
        return this.sampleModel.getSampleFloat(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, this.dataBuffer);
    }

    public SampleModel getSampleModel() {
        return this.sampleModel;
    }

    public final int getSampleModelTranslateX() {
        return this.sampleModelTranslateX;
    }

    public final int getSampleModelTranslateY() {
        return this.sampleModelTranslateY;
    }

    public int[] getSamples(int i, int i2, int i4, int i5, int i6, int[] iArr) {
        return this.sampleModel.getSamples(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, i5, i6, iArr, this.dataBuffer);
    }

    public final int getTransferType() {
        return this.sampleModel.getTransferType();
    }

    public final int getWidth() {
        return this.width;
    }

    public WritableRaster createCompatibleWritableRaster(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new RasterFormatException("negative ".concat(i <= 0 ? "width" : "height"));
        }
        return new SunWritableRaster(this.sampleModel.createCompatibleSampleModel(i, i2), new Point(0, 0));
    }

    public Object getDataElements(int i, int i2, int i4, int i5, Object obj) {
        return this.sampleModel.getDataElements(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, i5, obj, this.dataBuffer);
    }

    public float[] getPixel(int i, int i2, float[] fArr) {
        return this.sampleModel.getPixel(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, fArr, this.dataBuffer);
    }

    public float[] getPixels(int i, int i2, int i4, int i5, float[] fArr) {
        return this.sampleModel.getPixels(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, i5, fArr, this.dataBuffer);
    }

    public float[] getSamples(int i, int i2, int i4, int i5, int i6, float[] fArr) {
        return this.sampleModel.getSamples(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, i5, i6, fArr, this.dataBuffer);
    }

    public static WritableRaster createWritableRaster(SampleModel sampleModel, DataBuffer dataBuffer, Point point) {
        if (sampleModel != null && dataBuffer != null) {
            if (point == null) {
                point = new Point(0, 0);
            }
            int dataType = sampleModel.getDataType();
            if (sampleModel instanceof PixelInterleavedSampleModel) {
                if (dataType == 0) {
                    return new ByteInterleavedRaster(sampleModel, dataBuffer, point);
                }
                if (dataType == 1) {
                    return new ShortInterleavedRaster(sampleModel, dataBuffer, point);
                }
            } else if (sampleModel instanceof SinglePixelPackedSampleModel) {
                if (dataType == 0) {
                    return new ByteInterleavedRaster(sampleModel, dataBuffer, point);
                }
                if (dataType == 1) {
                    return new ShortInterleavedRaster(sampleModel, dataBuffer, point);
                }
                if (dataType == 3) {
                    return new IntegerInterleavedRaster(sampleModel, dataBuffer, point);
                }
            } else if ((sampleModel instanceof MultiPixelPackedSampleModel) && dataType == 0 && sampleModel.getSampleSize(0) < 8) {
                return new BytePackedRaster(sampleModel, dataBuffer, point);
            }
            return new SunWritableRaster(sampleModel, dataBuffer, point);
        }
        throw new NullPointerException("SampleModel and DataBuffer cannot be null");
    }

    public double[] getPixel(int i, int i2, double[] dArr) {
        return this.sampleModel.getPixel(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, dArr, this.dataBuffer);
    }

    public double[] getPixels(int i, int i2, int i4, int i5, double[] dArr) {
        return this.sampleModel.getPixels(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, i5, dArr, this.dataBuffer);
    }

    public double[] getSamples(int i, int i2, int i4, int i5, int i6, double[] dArr) {
        return this.sampleModel.getSamples(i - this.sampleModelTranslateX, i2 - this.sampleModelTranslateY, i4, i5, i6, dArr, this.dataBuffer);
    }

    public static WritableRaster createInterleavedRaster(int i, int i2, int i4, int i5, int i6, int[] iArr, Point point) {
        DataBuffer dataBufferByte;
        int i7 = (i6 * i2) + ((i4 - 1) * i5);
        if (i == 0) {
            dataBufferByte = new DataBufferByte(i7);
        } else if (i == 1) {
            dataBufferByte = new DataBufferUShort(i7);
        } else {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unsupported data type "));
        }
        return createInterleavedRaster(dataBufferByte, i2, i4, i5, i6, iArr, point);
    }

    public Raster(SampleModel sampleModel, DataBuffer dataBuffer, Point point) {
        this(sampleModel, dataBuffer, new Rectangle(point.f10092x, point.f10093y, sampleModel.getWidth(), sampleModel.getHeight()), point, null);
    }

    public WritableRaster createCompatibleWritableRaster(Rectangle rectangle) {
        if (rectangle != null) {
            return createCompatibleWritableRaster(rectangle.f10094x, rectangle.f10095y, rectangle.width, rectangle.height);
        }
        throw new NullPointerException("Rect cannot be null");
    }

    public WritableRaster createCompatibleWritableRaster(int i, int i2, int i4, int i5) {
        return createCompatibleWritableRaster(i4, i5).createWritableChild(0, 0, i4, i5, i, i2, null);
    }

    public Raster(SampleModel sampleModel, DataBuffer dataBuffer, Rectangle rectangle, Point point, Raster raster) {
        if (sampleModel != null && dataBuffer != null && rectangle != null && point != null) {
            this.sampleModel = sampleModel;
            this.dataBuffer = dataBuffer;
            int i = rectangle.f10094x;
            this.minX = i;
            int i2 = rectangle.f10095y;
            this.minY = i2;
            int i4 = rectangle.width;
            this.width = i4;
            int i5 = rectangle.height;
            this.height = i5;
            if (i4 <= 0 || i5 <= 0) {
                throw new RasterFormatException("negative or zero ".concat(this.width <= 0 ? "width" : "height"));
            }
            if (i4 + i < i) {
                throw new RasterFormatException("overflow condition for X coordinates of Raster");
            }
            if (i5 + i2 >= i2) {
                this.sampleModelTranslateX = point.f10092x;
                this.sampleModelTranslateY = point.f10093y;
                this.numBands = sampleModel.getNumBands();
                this.numDataElements = sampleModel.getNumDataElements();
                this.parent = raster;
                return;
            }
            throw new RasterFormatException("overflow condition for Y coordinates of Raster");
        }
        throw new NullPointerException("SampleModel, dataBuffer, aRegion and sampleModelTranslate cannot be null");
    }

    public static WritableRaster createPackedRaster(int i, int i2, int i4, int i5, int i6, Point point) {
        DataBuffer dataBufferByte;
        if (i5 <= 0) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i5, "Number of bands (", ") must be greater than 0"));
        }
        if (i6 <= 0) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i6, "Bits per band (", ") must be greater than 0"));
        }
        if (i5 != 1) {
            int[] iArr = new int[i5];
            int i7 = (1 << i6) - 1;
            int i8 = (i5 - 1) * i6;
            if (i8 + i6 > DataBuffer.getDataTypeSize(i)) {
                throw new IllegalArgumentException(AbstractC0541b.m767i(i6, "bitsPerBand(", ") * bands is  greater than data type size."));
            }
            if (i != 0 && i != 1 && i != 3) {
                throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unsupported data type "));
            }
            for (int i9 = 0; i9 < i5; i9++) {
                iArr[i9] = i7 << i8;
                i8 -= i6;
            }
            return createPackedRaster(i, i2, i4, iArr, point);
        }
        double d = i2;
        if (i == 0) {
            dataBufferByte = new DataBufferByte(((int) Math.ceil(d / ((double) (8 / i6)))) * i4);
        } else if (i == 1) {
            dataBufferByte = new DataBufferUShort(((int) Math.ceil(d / ((double) (16 / i6)))) * i4);
        } else if (i == 3) {
            dataBufferByte = new DataBufferInt(((int) Math.ceil(d / ((double) (32 / i6)))) * i4);
        } else {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unsupported data type "));
        }
        return createPackedRaster(dataBufferByte, i2, i4, i6, point);
    }

    public static WritableRaster createBandedRaster(int i, int i2, int i4, int i5, int[] iArr, int[] iArr2, Point point) {
        DataBuffer dataBufferByte;
        int length = iArr2.length;
        if (iArr != null) {
            int i6 = iArr[0];
            int i7 = iArr2[0];
            for (int i8 = 1; i8 < length; i8++) {
                int i9 = iArr[i8];
                if (i9 > i6) {
                    i6 = i9;
                }
                int i10 = iArr2[i8];
                if (i10 > i7) {
                    i7 = i10;
                }
            }
            int i11 = i6 + 1;
            int i12 = ((i4 - 1) * i5) + i7 + i2;
            if (i == 0) {
                dataBufferByte = new DataBufferByte(i12, i11);
            } else if (i == 1) {
                dataBufferByte = new DataBufferUShort(i12, i11);
            } else if (i == 3) {
                dataBufferByte = new DataBufferInt(i12, i11);
            } else {
                throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unsupported data type "));
            }
            return createBandedRaster(dataBufferByte, i2, i4, i5, iArr, iArr2, point);
        }
        throw new ArrayIndexOutOfBoundsException("Bank indices array is null");
    }

    public static WritableRaster createInterleavedRaster(DataBuffer dataBuffer, int i, int i2, int i4, int i5, int[] iArr, Point point) {
        if (dataBuffer != null) {
            if (point == null) {
                point = new Point(0, 0);
            }
            int dataType = dataBuffer.getDataType();
            PixelInterleavedSampleModel pixelInterleavedSampleModel = new PixelInterleavedSampleModel(dataType, i, i2, i5, i4, iArr);
            if (dataType == 0) {
                return new ByteInterleavedRaster(pixelInterleavedSampleModel, dataBuffer, point);
            }
            if (dataType == 1) {
                return new ShortInterleavedRaster(pixelInterleavedSampleModel, dataBuffer, point);
            }
            throw new IllegalArgumentException(AbstractC0000a.m11h(dataType, "Unsupported data type "));
        }
        throw new NullPointerException("DataBuffer cannot be null");
    }

    public static WritableRaster createBandedRaster(DataBuffer dataBuffer, int i, int i2, int i4, int[] iArr, int[] iArr2, Point point) {
        if (dataBuffer != null) {
            if (point == null) {
                point = new Point(0, 0);
            }
            int dataType = dataBuffer.getDataType();
            if (iArr2.length == iArr.length) {
                BandedSampleModel bandedSampleModel = new BandedSampleModel(dataType, i, i2, i4, iArr, iArr2);
                if (dataType == 0) {
                    return new ByteBandedRaster(bandedSampleModel, dataBuffer, point);
                }
                if (dataType == 1) {
                    return new ShortBandedRaster(bandedSampleModel, dataBuffer, point);
                }
                if (dataType == 3) {
                    return new SunWritableRaster(bandedSampleModel, dataBuffer, point);
                }
                throw new IllegalArgumentException(AbstractC0000a.m11h(dataType, "Unsupported data type "));
            }
            throw new IllegalArgumentException("bankIndices.length != bandOffsets.length");
        }
        throw new NullPointerException("DataBuffer cannot be null");
    }

    public static WritableRaster createPackedRaster(DataBuffer dataBuffer, int i, int i2, int i4, int[] iArr, Point point) {
        if (dataBuffer != null) {
            if (point == null) {
                point = new Point(0, 0);
            }
            int dataType = dataBuffer.getDataType();
            SinglePixelPackedSampleModel singlePixelPackedSampleModel = new SinglePixelPackedSampleModel(dataType, i, i2, i4, iArr);
            if (dataType == 0) {
                return new ByteInterleavedRaster(singlePixelPackedSampleModel, dataBuffer, point);
            }
            if (dataType == 1) {
                return new ShortInterleavedRaster(singlePixelPackedSampleModel, dataBuffer, point);
            }
            if (dataType == 3) {
                return new IntegerInterleavedRaster(singlePixelPackedSampleModel, dataBuffer, point);
            }
            throw new IllegalArgumentException(AbstractC0000a.m11h(dataType, "Unsupported data type "));
        }
        throw new NullPointerException("DataBuffer cannot be null");
    }

    public static WritableRaster createPackedRaster(DataBuffer dataBuffer, int i, int i2, int i4, Point point) {
        if (dataBuffer != null) {
            if (point == null) {
                point = new Point(0, 0);
            }
            int dataType = dataBuffer.getDataType();
            if (dataType != 0 && dataType != 1 && dataType != 3) {
                throw new IllegalArgumentException(AbstractC0000a.m11h(dataType, "Unsupported data type "));
            }
            if (dataBuffer.getNumBanks() == 1) {
                MultiPixelPackedSampleModel multiPixelPackedSampleModel = new MultiPixelPackedSampleModel(dataType, i, i2, i4);
                if (dataType == 0 && (i4 == 1 || i4 == 2 || i4 == 4)) {
                    return new BytePackedRaster(multiPixelPackedSampleModel, dataBuffer, point);
                }
                return new SunWritableRaster(multiPixelPackedSampleModel, dataBuffer, point);
            }
            throw new RasterFormatException("DataBuffer for packed Rasters must only have 1 bank.");
        }
        throw new NullPointerException("DataBuffer cannot be null");
    }
}
