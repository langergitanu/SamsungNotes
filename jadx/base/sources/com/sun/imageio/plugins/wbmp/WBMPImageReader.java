package com.sun.imageio.plugins.wbmp;

import com.sun.imageio.plugins.common.I18N;
import com.sun.imageio.plugins.common.ReaderUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.DataBufferByte;
import org.apache.poi.java.awt.image.MultiPixelPackedSampleModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.WritableRaster;
import org.apache.poi.javax.imageio.IIOException;
import org.apache.poi.javax.imageio.ImageReadParam;
import org.apache.poi.javax.imageio.ImageReader;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.spi.ImageReaderSpi;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class WBMPImageReader extends ImageReader {
    private boolean gotHeader;
    private int height;
    private ImageInputStream iis;
    private WBMPMetadata metadata;
    private int wbmpType;
    private int width;

    public WBMPImageReader(ImageReaderSpi imageReaderSpi) {
        super(imageReaderSpi);
        this.iis = null;
        this.gotHeader = false;
    }

    private void checkIndex(int i) {
        if (i != 0) {
            throw new IndexOutOfBoundsException(I18N.getString("WBMPImageReader0"));
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public boolean canReadRaster() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public ImageReadParam getDefaultReadParam() {
        return new ImageReadParam();
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getHeight(int i) throws IIOException {
        checkIndex(i);
        readHeader();
        return this.height;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public IIOMetadata getImageMetadata(int i) throws IIOException {
        checkIndex(i);
        if (this.metadata == null) {
            readHeader();
        }
        return this.metadata;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public Iterator getImageTypes(int i) throws IIOException {
        checkIndex(i);
        readHeader();
        BufferedImage bufferedImage = new BufferedImage(1, 1, 12);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new ImageTypeSpecifier(bufferedImage));
        return arrayList.iterator();
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getNumImages(boolean z) {
        if (this.iis == null) {
            throw new IllegalStateException(I18N.getString("GetNumImages0"));
        }
        if (this.seekForwardOnly && z) {
            throw new IllegalStateException(I18N.getString("GetNumImages1"));
        }
        return 1;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public IIOMetadata getStreamMetadata() {
        return null;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getWidth(int i) throws IIOException {
        checkIndex(i);
        readHeader();
        return this.width;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public boolean isRandomAccessEasy(int i) {
        checkIndex(i);
        return true;
    }

    public boolean isValidWbmpType(int i) {
        return i == 0;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public BufferedImage read(int i, ImageReadParam imageReadParam) throws IIOException {
        BufferedImage bufferedImage;
        if (this.iis == null) {
            throw new IllegalStateException(I18N.getString("WBMPImageReader1"));
        }
        checkIndex(i);
        clearAbortRequest();
        processImageStarted(i);
        ImageReadParam defaultReadParam = imageReadParam == null ? getDefaultReadParam() : imageReadParam;
        readHeader();
        Rectangle rectangle = new Rectangle(0, 0, 0, 0);
        Rectangle rectangle2 = new Rectangle(0, 0, 0, 0);
        ImageReader.computeRegions(defaultReadParam, this.width, this.height, defaultReadParam.getDestination(), rectangle, rectangle2);
        int sourceXSubsampling = defaultReadParam.getSourceXSubsampling();
        int sourceYSubsampling = defaultReadParam.getSourceYSubsampling();
        defaultReadParam.getSubsamplingXOffset();
        defaultReadParam.getSubsamplingYOffset();
        BufferedImage destination = defaultReadParam.getDestination();
        if (destination == null) {
            destination = new BufferedImage(rectangle2.f10094x + rectangle2.width, rectangle2.f10095y + rectangle2.height, 12);
        }
        boolean z = rectangle2.equals(new Rectangle(0, 0, this.width, this.height)) && rectangle2.equals(new Rectangle(0, 0, destination.getWidth(), destination.getHeight()));
        WritableRaster writableTile = destination.getWritableTile(0, 0);
        MultiPixelPackedSampleModel multiPixelPackedSampleModel = (MultiPixelPackedSampleModel) destination.getSampleModel();
        if (!z) {
            int i2 = (this.width + 7) / 8;
            byte[] bArr = new byte[i2];
            byte[] data = ((DataBufferByte) writableTile.getDataBuffer()).getData();
            int scanlineStride = multiPixelPackedSampleModel.getScanlineStride();
            this.iis.skipBytes(rectangle.f10095y * i2);
            int i4 = (sourceYSubsampling - 1) * i2;
            int i5 = rectangle2.width;
            int[] iArr = new int[i5];
            int[] iArr2 = new int[i5];
            int[] iArr3 = new int[i5];
            int[] iArr4 = new int[i5];
            int i6 = rectangle2.f10094x;
            int i7 = rectangle.f10094x;
            int i8 = 0;
            while (i6 < rectangle2.f10094x + rectangle2.width) {
                iArr3[i8] = i7 >> 3;
                iArr[i8] = 7 - (i7 & 7);
                iArr4[i8] = i6 >> 3;
                iArr2[i8] = 7 - (i6 & 7);
                i6++;
                i8++;
                i7 += sourceXSubsampling;
            }
            int i9 = rectangle2.f10095y * scanlineStride;
            int i10 = 0;
            while (i10 < rectangle2.height && !abortRequested()) {
                this.iis.read(bArr, 0, i2);
                for (int i11 = 0; i11 < rectangle2.width; i11++) {
                    int i12 = (bArr[iArr3[i11]] >> iArr[i11]) & 1;
                    int i13 = iArr4[i11] + i9;
                    data[i13] = (byte) (data[i13] | (i12 << iArr2[i11]));
                }
                int i14 = i9 + scanlineStride;
                this.iis.skipBytes(i4);
                BufferedImage bufferedImage2 = destination;
                int i15 = i4;
                int i16 = i10;
                processImageUpdate(bufferedImage2, 0, i16, rectangle2.width, 1, 1, 1, new int[]{0});
                processImageProgress((i16 * 100.0f) / rectangle2.height);
                i10 = i16 + 1;
                destination = bufferedImage2;
                i9 = i14;
                iArr2 = iArr2;
                iArr3 = iArr3;
                iArr4 = iArr4;
                iArr = iArr;
                i4 = i15;
            }
            bufferedImage = destination;
        } else {
            if (abortRequested()) {
                processReadAborted();
                return destination;
            }
            this.iis.read(((DataBufferByte) writableTile.getDataBuffer()).getData(), 0, multiPixelPackedSampleModel.getScanlineStride() * this.height);
            bufferedImage = destination;
            processImageUpdate(bufferedImage, 0, 0, this.width, this.height, 1, 1, new int[]{0});
            processImageProgress(100.0f);
        }
        if (abortRequested()) {
            processReadAborted();
            return bufferedImage;
        }
        processImageComplete();
        return bufferedImage;
    }

    public void readHeader() throws IIOException {
        if (this.gotHeader) {
            return;
        }
        if (this.iis == null) {
            throw new IllegalStateException("Input source not set!");
        }
        this.metadata = new WBMPMetadata();
        this.wbmpType = this.iis.readByte();
        if (this.iis.readByte() != 0 || !isValidWbmpType(this.wbmpType)) {
            throw new IIOException(I18N.getString("WBMPImageReader2"));
        }
        this.metadata.wbmpType = this.wbmpType;
        int multiByteInteger = ReaderUtil.readMultiByteInteger(this.iis);
        this.width = multiByteInteger;
        this.metadata.width = multiByteInteger;
        int multiByteInteger2 = ReaderUtil.readMultiByteInteger(this.iis);
        this.height = multiByteInteger2;
        this.metadata.height = multiByteInteger2;
        this.gotHeader = true;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public Raster readRaster(int i, ImageReadParam imageReadParam) {
        return read(i, imageReadParam).getData();
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public void reset() {
        super.reset();
        this.iis = null;
        this.gotHeader = false;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public void setInput(Object obj, boolean z, boolean z2) {
        super.setInput(obj, z, z2);
        this.iis = (ImageInputStream) obj;
        this.gotHeader = false;
    }
}
