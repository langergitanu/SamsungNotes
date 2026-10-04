package org.apache.poi.sun.awt.image;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.image.ComponentSampleModel;
import org.apache.poi.java.awt.image.DataBuffer;
import org.apache.poi.java.awt.image.DataBufferUShort;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RasterFormatException;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.java.awt.image.SinglePixelPackedSampleModel;
import org.apache.poi.java.awt.image.WritableRaster;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ShortComponentRaster extends SunWritableRaster {
    protected int bandOffset;
    protected short[] data;
    protected int[] dataOffsets;
    private int maxX;
    private int maxY;
    protected int pixelStride;
    protected int scanlineStride;
    int type;

    static {
        NativeLibLoader.loadLibraries();
    }

    public ShortComponentRaster(SampleModel sampleModel, Point point) {
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
        return new ShortComponentRaster(this.sampleModel.createCompatibleSampleModel(i, i2), new Point(0, 0));
    }

    @Override // org.apache.poi.java.awt.image.WritableRaster
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
        return new ShortComponentRaster(iArr != null ? this.sampleModel.createSubsetSampleModel(iArr) : this.sampleModel, this.dataBuffer, new Rectangle(i6, i7, i4, i5), new Point(this.sampleModelTranslateX + (i6 - i), this.sampleModelTranslateY + (i7 - i2)), this);
    }

    @Override // org.apache.poi.java.awt.image.Raster
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

    public int getDataOffset(int i) {
        return this.dataOffsets[i];
    }

    public int[] getDataOffsets() {
        return (int[]) this.dataOffsets.clone();
    }

    public short[] getDataStorage() {
        return this.data;
    }

    public int getPixelStride() {
        return this.pixelStride;
    }

    public int getScanlineStride() {
        return this.scanlineStride;
    }

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

    @Override // org.apache.poi.java.awt.image.WritableRaster
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

    public String toString() {
        return new String("ShortComponentRaster: width = " + this.width + " height = " + this.height + " #numDataElements " + this.numDataElements);
    }

    public final void verify() {
        int i;
        int i2 = this.width;
        if (i2 <= 0 || (i = this.height) <= 0 || i > Integer.MAX_VALUE / i2) {
            throw new RasterFormatException("Invalid raster dimension");
        }
        int i4 = 0;
        while (true) {
            int[] iArr = this.dataOffsets;
            if (i4 >= iArr.length) {
                if (((long) this.minX) - ((long) this.sampleModelTranslateX) >= 0) {
                    int i5 = this.minY;
                    int i6 = this.sampleModelTranslateY;
                    if (((long) i5) - ((long) i6) >= 0) {
                        int i7 = this.scanlineStride;
                        if (i7 >= 0) {
                            int i8 = this.height;
                            if (i7 <= Integer.MAX_VALUE / i8) {
                                if ((i8 > 1 || i5 - i6 > 0) && i7 > this.data.length) {
                                    throw new RasterFormatException("Incorrect scanline stride: " + this.scanlineStride);
                                }
                                int i9 = (i8 - 1) * i7;
                                int i10 = this.pixelStride;
                                if (i10 >= 0) {
                                    int i11 = this.width;
                                    if (i10 <= Integer.MAX_VALUE / i11 && i10 <= this.data.length) {
                                        int i12 = (i11 - 1) * i10;
                                        if (i12 > Integer.MAX_VALUE - i9) {
                                            throw new RasterFormatException("Incorrect raster attributes");
                                        }
                                        int i13 = i12 + i9;
                                        int i14 = 0;
                                        for (int i15 = 0; i15 < this.numDataElements; i15++) {
                                            int i16 = this.dataOffsets[i15];
                                            if (i16 > Integer.MAX_VALUE - i13) {
                                                throw new RasterFormatException("Incorrect band offset: " + this.dataOffsets[i15]);
                                            }
                                            int i17 = i16 + i13;
                                            if (i17 > i14) {
                                                i14 = i17;
                                            }
                                        }
                                        if (this.data.length <= i14) {
                                            throw new RasterFormatException(AbstractC0541b.m767i(i14, "Data array too small (should be > ", " )"));
                                        }
                                        return;
                                    }
                                }
                                throw new RasterFormatException("Incorrect pixel stride: " + this.pixelStride);
                            }
                        }
                        throw new RasterFormatException("Incorrect scanline stride: " + this.scanlineStride);
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
            if (iArr[i4] < 0) {
                throw new RasterFormatException(AbstractC2821a.m2223n(AbstractC0541b.m778t(i4, "Data offsets for band ", "("), ") must be >= 0", this.dataOffsets[i4]));
            }
            i4++;
        }
    }

    @Override // org.apache.poi.java.awt.image.Raster
    public WritableRaster createCompatibleWritableRaster() {
        return createCompatibleWritableRaster(this.width, this.height);
    }

    public ShortComponentRaster(SampleModel sampleModel, DataBuffer dataBuffer, Point point) {
        this(sampleModel, dataBuffer, new Rectangle(point.f10092x, point.f10093y, sampleModel.getWidth(), sampleModel.getHeight()), point, null);
    }

    @Override // org.apache.poi.java.awt.image.Raster
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

    public ShortComponentRaster(SampleModel sampleModel, DataBuffer dataBuffer, Rectangle rectangle, Point point, ShortComponentRaster shortComponentRaster) {
        super(sampleModel, dataBuffer, rectangle, point, shortComponentRaster);
        this.maxX = this.minX + this.width;
        this.maxY = this.minY + this.height;
        if (dataBuffer instanceof DataBufferUShort) {
            DataBufferUShort dataBufferUShort = (DataBufferUShort) dataBuffer;
            this.data = SunWritableRaster.stealData(dataBufferUShort, 0);
            if (dataBufferUShort.getNumBanks() == 1) {
                int offset = dataBufferUShort.getOffset();
                if (sampleModel instanceof ComponentSampleModel) {
                    ComponentSampleModel componentSampleModel = (ComponentSampleModel) sampleModel;
                    this.type = 2;
                    this.scanlineStride = componentSampleModel.getScanlineStride();
                    this.pixelStride = componentSampleModel.getPixelStride();
                    this.dataOffsets = componentSampleModel.getBandOffsets();
                    int i = rectangle.f10094x - point.f10092x;
                    int i2 = rectangle.f10095y - point.f10093y;
                    for (int i4 = 0; i4 < getNumDataElements(); i4++) {
                        int[] iArr = this.dataOffsets;
                        iArr[i4] = AbstractC1974b.m1310c(i2, this.scanlineStride, (this.pixelStride * i) + offset, iArr[i4]);
                    }
                } else if (sampleModel instanceof SinglePixelPackedSampleModel) {
                    this.type = 8;
                    int scanlineStride = ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride();
                    this.scanlineStride = scanlineStride;
                    this.pixelStride = 1;
                    int[] iArr2 = {offset};
                    this.dataOffsets = iArr2;
                    iArr2[0] = ((rectangle.f10095y - point.f10093y) * scanlineStride) + (rectangle.f10094x - point.f10092x) + offset;
                } else {
                    throw new RasterFormatException("ShortComponentRasters must haveComponentSampleModel or SinglePixelPackedSampleModel");
                }
                this.bandOffset = this.dataOffsets[0];
                verify();
                return;
            }
            throw new RasterFormatException("DataBuffer for ShortComponentRasters must only have 1 bank.");
        }
        throw new RasterFormatException("ShortComponentRasters must have short DataBuffers");
    }

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

    @Override // org.apache.poi.java.awt.image.WritableRaster
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
