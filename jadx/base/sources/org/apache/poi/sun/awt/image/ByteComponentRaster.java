package org.apache.poi.sun.awt.image;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.image.ComponentSampleModel;
import org.apache.poi.java.awt.image.DataBuffer;
import org.apache.poi.java.awt.image.DataBufferByte;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RasterFormatException;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.java.awt.image.SinglePixelPackedSampleModel;
import org.apache.poi.java.awt.image.WritableRaster;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ByteComponentRaster extends SunWritableRaster {
    protected int bandOffset;
    protected byte[] data;
    protected int[] dataOffsets;
    private int maxX;
    private int maxY;
    protected int pixelStride;
    protected int scanlineStride;
    int type;

    static {
        NativeLibLoader.loadLibraries();
    }

    public ByteComponentRaster(SampleModel sampleModel, Point point) {
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
        return new ByteComponentRaster(this.sampleModel.createCompatibleSampleModel(i, i2), new Point(0, 0));
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
        return new ByteComponentRaster(iArr != null ? this.sampleModel.createSubsetSampleModel(iArr) : this.sampleModel, this.dataBuffer, new Rectangle(i6, i7, i4, i5), new Point(this.sampleModelTranslateX + (i6 - i), this.sampleModelTranslateY + (i7 - i2)), this);
    }

    public byte[] getByteData(int i, int i2, int i4, int i5, int i6, byte[] bArr) {
        int i7;
        int i8 = this.minX;
        if (i < i8 || i2 < (i7 = this.minY) || i + i4 > this.maxX || i2 + i5 > this.maxY) {
            throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
        }
        if (bArr == null) {
            bArr = new byte[this.scanlineStride * i5];
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

    @Override // org.apache.poi.java.awt.image.Raster
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

    public int getDataOffset(int i) {
        return this.dataOffsets[i];
    }

    public int[] getDataOffsets() {
        return (int[]) this.dataOffsets.clone();
    }

    public byte[] getDataStorage() {
        return this.data;
    }

    public int getPixelStride() {
        return this.pixelStride;
    }

    public int getScanlineStride() {
        return this.scanlineStride;
    }

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

    @Override // org.apache.poi.java.awt.image.WritableRaster
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

    public String toString() {
        return new String("ByteComponentRaster: width = " + this.width + " height = " + this.height + " #numDataElements " + this.numDataElements + " dataOff[0] = " + this.dataOffsets[0]);
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

    public ByteComponentRaster(SampleModel sampleModel, DataBuffer dataBuffer, Point point) {
        this(sampleModel, dataBuffer, new Rectangle(point.f10092x, point.f10093y, sampleModel.getWidth(), sampleModel.getHeight()), point, null);
    }

    @Override // org.apache.poi.java.awt.image.Raster
    public Object getDataElements(int i, int i2, int i4, int i5, Object obj) {
        int i6;
        byte[] bArr;
        int i7 = this.minX;
        if (i >= i7 && i2 >= (i6 = this.minY) && i + i4 <= this.maxX && i2 + i5 <= this.maxY) {
            if (obj == null) {
                bArr = new byte[i4 * i5 * this.numDataElements];
            } else {
                bArr = (byte[]) obj;
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
                        bArr[i10] = this.data[this.dataOffsets[i13] + i11];
                        i13++;
                        i10++;
                    }
                    i12++;
                    i11 += this.pixelStride;
                }
                i9++;
                i8 += this.scanlineStride;
            }
            return bArr;
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

    public ByteComponentRaster(SampleModel sampleModel, DataBuffer dataBuffer, Rectangle rectangle, Point point, ByteComponentRaster byteComponentRaster) {
        super(sampleModel, dataBuffer, rectangle, point, byteComponentRaster);
        this.maxX = this.minX + this.width;
        this.maxY = this.minY + this.height;
        if (dataBuffer instanceof DataBufferByte) {
            DataBufferByte dataBufferByte = (DataBufferByte) dataBuffer;
            this.data = SunWritableRaster.stealData(dataBufferByte, 0);
            if (dataBufferByte.getNumBanks() == 1) {
                int offset = dataBufferByte.getOffset();
                if (sampleModel instanceof ComponentSampleModel) {
                    ComponentSampleModel componentSampleModel = (ComponentSampleModel) sampleModel;
                    this.type = 1;
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
                    this.type = 7;
                    int scanlineStride = ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride();
                    this.scanlineStride = scanlineStride;
                    this.pixelStride = 1;
                    int[] iArr2 = {offset};
                    this.dataOffsets = iArr2;
                    iArr2[0] = ((rectangle.f10095y - point.f10093y) * scanlineStride) + (rectangle.f10094x - point.f10092x) + offset;
                } else {
                    throw new RasterFormatException("IntegerComponentRasters must have ComponentSampleModel or SinglePixelPackedSampleModel");
                }
                this.bandOffset = this.dataOffsets[0];
                verify();
                return;
            }
            throw new RasterFormatException("DataBuffer for ByteComponentRasters must only have 1 bank.");
        }
        throw new RasterFormatException("ByteComponentRasters must have byte DataBuffers");
    }

    public byte[] getByteData(int i, int i2, int i4, int i5, byte[] bArr) {
        int i6;
        int i7 = this.minX;
        if (i >= i7 && i2 >= (i6 = this.minY) && i + i4 <= this.maxX && i2 + i5 <= this.maxY) {
            if (bArr == null) {
                bArr = new byte[this.numDataElements * this.scanlineStride * i5];
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
                        bArr[i10] = this.data[this.dataOffsets[i13] + i11];
                        i13++;
                        i10++;
                    }
                    i12++;
                    i11 += this.pixelStride;
                }
                i9++;
                i8 += this.scanlineStride;
            }
            return bArr;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }

    public void putByteData(int i, int i2, int i4, int i5, byte[] bArr) {
        int i6;
        int i7 = this.minX;
        if (i >= i7 && i2 >= (i6 = this.minY) && i + i4 <= this.maxX && i2 + i5 <= this.maxY) {
            int i8 = i2 - i6;
            int i9 = this.scanlineStride;
            int i10 = i - i7;
            int i11 = this.pixelStride;
            int i12 = (i10 * i11) + (i8 * i9);
            if (this.numDataElements == 1) {
                int i13 = i12 + this.dataOffsets[0];
                if (i11 != 1) {
                    int i14 = 0;
                    int i15 = 0;
                    while (i14 < i5) {
                        int i16 = i13;
                        int i17 = 0;
                        while (i17 < i4) {
                            this.data[i16] = bArr[i15];
                            i17++;
                            i16 += this.pixelStride;
                            i15++;
                        }
                        i14++;
                        i13 += this.scanlineStride;
                    }
                } else if (i9 == i4) {
                    System.arraycopy(bArr, 0, this.data, i13, i4 * i5);
                } else {
                    int i18 = 0;
                    for (int i19 = 0; i19 < i5; i19++) {
                        System.arraycopy(bArr, i18, this.data, i13, i4);
                        i18 += i4;
                        i13 += this.scanlineStride;
                    }
                }
            } else {
                int i20 = 0;
                int i21 = 0;
                while (i20 < i5) {
                    int i22 = i12;
                    int i23 = 0;
                    while (i23 < i4) {
                        int i24 = 0;
                        while (i24 < this.numDataElements) {
                            this.data[this.dataOffsets[i24] + i22] = bArr[i21];
                            i24++;
                            i21++;
                        }
                        i23++;
                        i22 += this.pixelStride;
                    }
                    i20++;
                    i12 += this.scanlineStride;
                }
            }
            markDirty();
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }

    private void setDataElements(int i, int i2, int i4, int i5, Raster raster) {
        Raster raster2 = raster;
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        int minX = raster2.getMinX();
        int minY = raster2.getMinY();
        if (raster2 instanceof ByteComponentRaster) {
            ByteComponentRaster byteComponentRaster = (ByteComponentRaster) raster2;
            byte[] dataStorage = byteComponentRaster.getDataStorage();
            if (this.numDataElements == 1) {
                int dataOffset = byteComponentRaster.getDataOffset(0);
                int scanlineStride = byteComponentRaster.getScanlineStride();
                int i6 = (i - this.minX) + ((i2 - this.minY) * this.scanlineStride) + this.dataOffsets[0];
                if (this.pixelStride == byteComponentRaster.getPixelStride()) {
                    int i7 = this.pixelStride * i4;
                    for (int i8 = 0; i8 < i5; i8++) {
                        System.arraycopy(dataStorage, dataOffset, this.data, i6, i7);
                        dataOffset += scanlineStride;
                        i6 += this.scanlineStride;
                    }
                    markDirty();
                    return;
                }
            }
        }
        Object obj = null;
        int i9 = 0;
        while (i9 < i5) {
            Object dataElements = raster2.getDataElements(minX, minY + i9, i4, 1, obj);
            setDataElements(i, i2 + i9, i4, 1, dataElements);
            i9++;
            raster2 = raster;
            obj = dataElements;
        }
    }

    @Override // org.apache.poi.java.awt.image.WritableRaster
    public void setDataElements(int i, int i2, int i4, int i5, Object obj) {
        int i6;
        int i7 = this.minX;
        if (i >= i7 && i2 >= (i6 = this.minY) && i + i4 <= this.maxX && i2 + i5 <= this.maxY) {
            byte[] bArr = (byte[]) obj;
            int i8 = ((i - i7) * this.pixelStride) + ((i2 - i6) * this.scanlineStride);
            if (this.numDataElements == 1) {
                int i9 = i8 + this.dataOffsets[0];
                int i10 = 0;
                for (int i11 = 0; i11 < i5; i11++) {
                    System.arraycopy(bArr, i10, this.data, i9, i4);
                    i10 += i4;
                    i9 += this.scanlineStride;
                }
                markDirty();
                return;
            }
            int i12 = 0;
            int i13 = 0;
            while (i12 < i5) {
                int i14 = i8;
                int i15 = 0;
                while (i15 < i4) {
                    int i16 = 0;
                    while (i16 < this.numDataElements) {
                        this.data[this.dataOffsets[i16] + i14] = bArr[i13];
                        i16++;
                        i13++;
                    }
                    i15++;
                    i14 += this.pixelStride;
                }
                i12++;
                i8 += this.scanlineStride;
            }
            markDirty();
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Coordinate out of bounds!");
    }
}
