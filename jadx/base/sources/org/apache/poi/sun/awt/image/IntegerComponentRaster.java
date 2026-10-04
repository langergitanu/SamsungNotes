package org.apache.poi.sun.awt.image;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
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
public class IntegerComponentRaster extends SunWritableRaster {
    static final int TYPE_BYTE_BANDED_SAMPLES = 4;
    static final int TYPE_BYTE_BINARY_SAMPLES = 11;
    static final int TYPE_BYTE_PACKED_SAMPLES = 7;
    static final int TYPE_BYTE_SAMPLES = 1;
    static final int TYPE_CUSTOM = 0;
    static final int TYPE_INT_8BIT_SAMPLES = 10;
    static final int TYPE_INT_BANDED_SAMPLES = 6;
    static final int TYPE_INT_PACKED_SAMPLES = 9;
    static final int TYPE_INT_SAMPLES = 3;
    static final int TYPE_USHORT_BANDED_SAMPLES = 5;
    static final int TYPE_USHORT_PACKED_SAMPLES = 8;
    static final int TYPE_USHORT_SAMPLES = 2;
    protected int bandOffset;
    protected int[] data;
    protected int[] dataOffsets;
    private int maxX;
    private int maxY;
    protected int numDataElems;
    protected int pixelStride;
    protected int scanlineStride;
    int type;

    static {
        NativeLibLoader.loadLibraries();
    }

    public IntegerComponentRaster(SampleModel sampleModel, Point point) {
        this(sampleModel, sampleModel.createDataBuffer(), new Rectangle(point.f10092x, point.f10093y, sampleModel.getWidth(), sampleModel.getHeight()), point, null);
    }

    @Override // org.apache.poi.java.awt.image.Raster
    public Raster createChild(int i, int i2, int i4, int i5, int i6, int i7, int[] iArr) {
        return createWritableChild(i, i2, i4, i5, i6, i7, iArr);
    }

    @Override // org.apache.poi.java.awt.image.Raster
    public WritableRaster createCompatibleWritableRaster(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new RasterFormatException("negative ".concat(i <= 0 ? "width" : "height"));
        }
        return new IntegerComponentRaster(this.sampleModel.createCompatibleSampleModel(i, i2), new Point(0, 0));
    }

    @Override // org.apache.poi.java.awt.image.WritableRaster
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
        return new IntegerComponentRaster(iArr != null ? this.sampleModel.createSubsetSampleModel(iArr) : this.sampleModel, this.dataBuffer, new Rectangle(i6, i7, i4, i5), new Point(this.sampleModelTranslateX + (i6 - i), this.sampleModelTranslateY + (i7 - i2)), this);
    }

    @Override // org.apache.poi.java.awt.image.Raster
    public Object getDataElements(int i, int i2, Object obj) {
        int i4;
        int i5 = this.minX;
        if (i < i5 || i2 < (i4 = this.minY) || i >= this.maxX || i2 >= this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int[] iArr = obj == null ? new int[this.numDataElements] : (int[]) obj;
        int i6 = ((i - i5) * this.pixelStride) + ((i2 - i4) * this.scanlineStride);
        for (int i7 = 0; i7 < this.numDataElements; i7++) {
            iArr[i7] = this.data[this.dataOffsets[i7] + i6];
        }
        return iArr;
    }

    public int getDataOffset(int i) {
        return this.dataOffsets[i];
    }

    public int[] getDataOffsets() {
        return (int[]) this.dataOffsets.clone();
    }

    public int[] getDataStorage() {
        return this.data;
    }

    public int getPixelStride() {
        return this.pixelStride;
    }

    public int getScanlineStride() {
        return this.scanlineStride;
    }

    @Override // org.apache.poi.java.awt.image.WritableRaster
    public void setDataElements(int i, int i2, Object obj) {
        int i4;
        int i5 = this.minX;
        if (i < i5 || i2 < (i4 = this.minY) || i >= this.maxX || i2 >= this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        int[] iArr = (int[]) obj;
        int i6 = ((i - i5) * this.pixelStride) + ((i2 - i4) * this.scanlineStride);
        for (int i7 = 0; i7 < this.numDataElements; i7++) {
            this.data[this.dataOffsets[i7] + i6] = iArr[i7];
        }
        markDirty();
    }

    public String toString() {
        return new String("IntegerComponentRaster: width = " + this.width + " height = " + this.height + " #Bands = " + this.numBands + " #DataElements " + this.numDataElements + " xOff = " + this.sampleModelTranslateX + " yOff = " + this.sampleModelTranslateY + " dataOffset[0] " + this.dataOffsets[0]);
    }

    public final void verify() {
        int i;
        int i2 = this.width;
        if (i2 <= 0 || (i = this.height) <= 0 || i > Integer.MAX_VALUE / i2) {
            throw new RasterFormatException("Invalid raster dimension");
        }
        if (this.dataOffsets[0] < 0) {
            throw new RasterFormatException(AbstractC2821a.m2223n(new StringBuilder("Data offset ("), ") must be >= 0", this.dataOffsets[0]));
        }
        if (((long) this.minX) - ((long) this.sampleModelTranslateX) >= 0) {
            int i4 = this.minY;
            int i5 = this.sampleModelTranslateY;
            if (((long) i4) - ((long) i5) >= 0) {
                int i6 = this.scanlineStride;
                if (i6 < 0 || i6 > Integer.MAX_VALUE / i) {
                    throw new RasterFormatException("Incorrect scanline stride: " + this.scanlineStride);
                }
                if ((i > 1 || i4 - i5 > 0) && i6 > this.data.length) {
                    throw new RasterFormatException("Incorrect scanline stride: " + this.scanlineStride);
                }
                int i7 = (i - 1) * i6;
                int i8 = this.pixelStride;
                if (i8 < 0 || i8 > Integer.MAX_VALUE / i2 || i8 > this.data.length) {
                    throw new RasterFormatException("Incorrect pixel stride: " + this.pixelStride);
                }
                int i9 = (i2 - 1) * i8;
                if (i9 > Integer.MAX_VALUE - i7) {
                    throw new RasterFormatException("Incorrect raster attributes");
                }
                int i10 = i9 + i7;
                int i11 = 0;
                for (int i12 = 0; i12 < this.numDataElements; i12++) {
                    int i13 = this.dataOffsets[i12];
                    if (i13 > Integer.MAX_VALUE - i10) {
                        throw new RasterFormatException("Incorrect band offset: " + this.dataOffsets[i12]);
                    }
                    int i14 = i13 + i10;
                    if (i14 > i11) {
                        i11 = i14;
                    }
                }
                if (this.data.length <= i11) {
                    throw new RasterFormatException(AbstractC0541b.m767i(i11, "Data array too small (should be > ", " )"));
                }
                return;
            }
        }
        StringBuilder sb = new StringBuilder("Incorrect origin/translate: (");
        sb.append(this.minX);
        sb.append(SQLKeyword.COMMA);
        sb.append(this.minY);
        sb.append(") / (");
        sb.append(this.sampleModelTranslateX);
        sb.append(SQLKeyword.COMMA);
        throw new RasterFormatException(AbstractC2821a.m2223n(sb, ")", this.sampleModelTranslateY));
    }

    @Override // org.apache.poi.java.awt.image.Raster
    public WritableRaster createCompatibleWritableRaster() {
        return createCompatibleWritableRaster(this.width, this.height);
    }

    public IntegerComponentRaster(SampleModel sampleModel, DataBuffer dataBuffer, Point point) {
        this(sampleModel, dataBuffer, new Rectangle(point.f10092x, point.f10093y, sampleModel.getWidth(), sampleModel.getHeight()), point, null);
    }

    @Override // org.apache.poi.java.awt.image.Raster
    public Object getDataElements(int i, int i2, int i4, int i5, Object obj) {
        int i6;
        int[] iArr;
        int i7 = this.minX;
        if (i >= i7 && i2 >= (i6 = this.minY) && i + i4 <= this.maxX && i2 + i5 <= this.maxY) {
            if (obj instanceof int[]) {
                iArr = (int[]) obj;
            } else {
                iArr = new int[this.numDataElements * i4 * i5];
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
                        iArr[i10] = this.data[this.dataOffsets[i13] + i11];
                        i13++;
                        i10++;
                    }
                    i12++;
                    i11 += this.pixelStride;
                }
                i9++;
                i8 += this.scanlineStride;
            }
            return iArr;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }

    @Override // org.apache.poi.java.awt.image.WritableRaster
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

    public IntegerComponentRaster(SampleModel sampleModel, DataBuffer dataBuffer, Rectangle rectangle, Point point, IntegerComponentRaster integerComponentRaster) {
        super(sampleModel, dataBuffer, rectangle, point, integerComponentRaster);
        this.maxX = this.minX + this.width;
        this.maxY = this.minY + this.height;
        if (dataBuffer instanceof DataBufferInt) {
            DataBufferInt dataBufferInt = (DataBufferInt) dataBuffer;
            if (dataBufferInt.getNumBanks() == 1) {
                this.data = SunWritableRaster.stealData(dataBufferInt, 0);
                if (sampleModel instanceof SinglePixelPackedSampleModel) {
                    SinglePixelPackedSampleModel singlePixelPackedSampleModel = (SinglePixelPackedSampleModel) sampleModel;
                    int[] bitOffsets = singlePixelPackedSampleModel.getBitOffsets();
                    boolean z = false;
                    for (int i = 1; i < bitOffsets.length; i++) {
                        if (bitOffsets[i] % 8 != 0) {
                            z = true;
                        }
                    }
                    this.type = z ? 9 : 10;
                    this.scanlineStride = singlePixelPackedSampleModel.getScanlineStride();
                    this.pixelStride = 1;
                    this.dataOffsets = new int[]{dataBufferInt.getOffset()};
                    int[] iArr = this.dataOffsets;
                    int i2 = iArr[0];
                    this.bandOffset = i2;
                    iArr[0] = AbstractC1974b.m1310c(rectangle.f10095y - point.f10093y, this.scanlineStride, rectangle.f10094x - point.f10092x, i2);
                    this.numDataElems = singlePixelPackedSampleModel.getNumDataElements();
                    verify();
                    return;
                }
                throw new RasterFormatException("IntegerComponentRasters must have SinglePixelPackedSampleModel");
            }
            throw new RasterFormatException("DataBuffer for IntegerComponentRasters must only have 1 bank.");
        }
        throw new RasterFormatException("IntegerComponentRasters must haveinteger DataBuffers");
    }

    private void setDataElements(int i, int i2, int i4, int i5, Raster raster) {
        Raster raster2 = raster;
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        int minX = raster2.getMinX();
        int minY = raster2.getMinY();
        if ((raster2 instanceof IntegerComponentRaster) && this.pixelStride == 1 && this.numDataElements == 1) {
            IntegerComponentRaster integerComponentRaster = (IntegerComponentRaster) raster2;
            if (integerComponentRaster.getNumDataElements() == 1) {
                int[] dataStorage = integerComponentRaster.getDataStorage();
                int scanlineStride = integerComponentRaster.getScanlineStride();
                int dataOffset = integerComponentRaster.getDataOffset(0);
                int i6 = (i - this.minX) + ((i2 - this.minY) * this.scanlineStride) + this.dataOffsets[0];
                int pixelStride = integerComponentRaster.getPixelStride();
                int i7 = this.pixelStride;
                if (pixelStride == i7) {
                    int i8 = i4 * i7;
                    for (int i9 = 0; i9 < i5; i9++) {
                        System.arraycopy(dataStorage, dataOffset, this.data, i6, i8);
                        dataOffset += scanlineStride;
                        i6 += this.scanlineStride;
                    }
                    markDirty();
                    return;
                }
            } else {
                throw new ArrayIndexOutOfBoundsException("Number of bands does not match");
            }
        }
        Object obj = null;
        int i10 = 0;
        while (i10 < i5) {
            Object dataElements = raster2.getDataElements(minX, minY + i10, i4, 1, obj);
            setDataElements(i, i2 + i10, i4, 1, dataElements);
            i10++;
            raster2 = raster;
            obj = dataElements;
        }
    }

    @Override // org.apache.poi.java.awt.image.WritableRaster
    public void setDataElements(int i, int i2, int i4, int i5, Object obj) {
        int i6;
        int i7 = this.minX;
        if (i >= i7 && i2 >= (i6 = this.minY) && i + i4 <= this.maxX && i2 + i5 <= this.maxY) {
            int[] iArr = (int[]) obj;
            int i8 = ((i - i7) * this.pixelStride) + ((i2 - i6) * this.scanlineStride);
            int i9 = 0;
            int i10 = 0;
            while (i9 < i5) {
                int i11 = i8;
                int i12 = 0;
                while (i12 < i4) {
                    int i13 = 0;
                    while (i13 < this.numDataElements) {
                        this.data[this.dataOffsets[i13] + i11] = iArr[i10];
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
