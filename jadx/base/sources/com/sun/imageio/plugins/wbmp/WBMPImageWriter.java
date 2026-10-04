package com.sun.imageio.plugins.wbmp;

import com.google.android.gms.common.data.AbstractC4539a;
import com.sun.imageio.plugins.common.I18N;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.image.DataBufferByte;
import org.apache.poi.java.awt.image.IndexColorModel;
import org.apache.poi.java.awt.image.MultiPixelPackedSampleModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RenderedImage;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.java.awt.image.WritableRaster;
import org.apache.poi.javax.imageio.IIOImage;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.ImageWriteParam;
import org.apache.poi.javax.imageio.ImageWriter;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.spi.ImageWriterSpi;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class WBMPImageWriter extends ImageWriter {
    private ImageOutputStream stream;

    public WBMPImageWriter(ImageWriterSpi imageWriterSpi) {
        super(imageWriterSpi);
        this.stream = null;
    }

    private void checkSampleModel(SampleModel sampleModel) {
        int dataType = sampleModel.getDataType();
        if (dataType < 0 || dataType > 3 || sampleModel.getNumBands() != 1 || sampleModel.getSampleSize(0) != 1) {
            throw new IllegalArgumentException(I18N.getString("WBMPImageWriter2"));
        }
    }

    private static int getNumBits(int i) {
        int i2 = 32;
        for (int i4 = Integer.MIN_VALUE; i4 != 0 && (i & i4) == 0; i4 >>>= 1) {
            i2--;
        }
        return i2;
    }

    private static byte[] intToMultiByte(int i) {
        int numBits = (getNumBits(i) + 6) / 7;
        byte[] bArr = new byte[numBits];
        int i2 = numBits - 1;
        for (int i4 = 0; i4 <= i2; i4++) {
            byte b = (byte) ((i >>> ((i2 - i4) * 7)) & 127);
            bArr[i4] = b;
            if (i4 != i2) {
                bArr[i4] = (byte) (b | (-128));
            }
        }
        return bArr;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public boolean canWriteRasters() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter, org.apache.poi.javax.imageio.ImageTranscoder
    public IIOMetadata convertImageMetadata(IIOMetadata iIOMetadata, ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam) {
        return null;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter, org.apache.poi.javax.imageio.ImageTranscoder
    public IIOMetadata convertStreamMetadata(IIOMetadata iIOMetadata, ImageWriteParam imageWriteParam) {
        return null;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public IIOMetadata getDefaultImageMetadata(ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam) {
        WBMPMetadata wBMPMetadata = new WBMPMetadata();
        wBMPMetadata.wbmpType = 0;
        return wBMPMetadata;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public IIOMetadata getDefaultStreamMetadata(ImageWriteParam imageWriteParam) {
        return null;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void reset() {
        super.reset();
        this.stream = null;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void setOutput(Object obj) {
        super.setOutput(obj);
        if (obj == null) {
            this.stream = null;
        } else {
            if (!(obj instanceof ImageOutputStream)) {
                throw new IllegalArgumentException(I18N.getString("WBMPImageWriter"));
            }
            this.stream = (ImageOutputStream) obj;
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void write(IIOMetadata iIOMetadata, IIOImage iIOImage, ImageWriteParam imageWriteParam) {
        RenderedImage renderedImage;
        SampleModel sampleModel;
        Raster data;
        int i;
        boolean z;
        int i2;
        Raster rasterCreateChild;
        boolean z2;
        if (this.stream == null) {
            throw new IllegalStateException(I18N.getString("WBMPImageWriter3"));
        }
        if (iIOImage == null) {
            throw new IllegalArgumentException(I18N.getString("WBMPImageWriter4"));
        }
        clearAbortRequest();
        processImageStarted(0);
        ImageWriteParam defaultWriteParam = imageWriteParam == null ? getDefaultWriteParam() : imageWriteParam;
        boolean zHasRaster = iIOImage.hasRaster();
        Rectangle sourceRegion = defaultWriteParam.getSourceRegion();
        if (zHasRaster) {
            data = iIOImage.getRaster();
            sampleModel = data.getSampleModel();
            renderedImage = null;
        } else {
            renderedImage = iIOImage.getRenderedImage();
            sampleModel = renderedImage.getSampleModel();
            data = renderedImage.getData();
        }
        Raster raster = data;
        checkSampleModel(sampleModel);
        Rectangle bounds = sourceRegion == null ? raster.getBounds() : sourceRegion.intersection(raster.getBounds());
        if (bounds.isEmpty()) {
            throw new RuntimeException(I18N.getString("WBMPImageWriter1"));
        }
        int sourceXSubsampling = defaultWriteParam.getSourceXSubsampling();
        int sourceYSubsampling = defaultWriteParam.getSourceYSubsampling();
        int subsamplingXOffset = defaultWriteParam.getSubsamplingXOffset();
        int subsamplingYOffset = defaultWriteParam.getSubsamplingYOffset();
        bounds.translate(subsamplingXOffset, subsamplingYOffset);
        int i4 = bounds.width - subsamplingXOffset;
        bounds.width = i4;
        int i5 = bounds.height - subsamplingYOffset;
        bounds.height = i5;
        int i6 = bounds.f10094x / sourceXSubsampling;
        int i7 = bounds.f10095y / sourceYSubsampling;
        int iM3211u = AbstractC4539a.m3211u(i4, sourceXSubsampling, 1, sourceXSubsampling);
        int iM3211u2 = AbstractC4539a.m3211u(i5, sourceYSubsampling, 1, sourceYSubsampling);
        Rectangle rectangle = new Rectangle(i6, i7, iM3211u, iM3211u2);
        SampleModel sampleModelCreateCompatibleSampleModel = sampleModel.createCompatibleSampleModel(iM3211u, iM3211u2);
        if (sampleModelCreateCompatibleSampleModel.getDataType() == 0 && (sampleModelCreateCompatibleSampleModel instanceof MultiPixelPackedSampleModel) && ((MultiPixelPackedSampleModel) sampleModelCreateCompatibleSampleModel).getDataBitOffset() == 0) {
            i = iM3211u;
        } else {
            i = iM3211u;
            sampleModelCreateCompatibleSampleModel = new MultiPixelPackedSampleModel(0, i, iM3211u2, 1, (iM3211u + 7) >> 3, 0);
        }
        if (rectangle.equals(bounds)) {
            z = zHasRaster;
            i2 = i;
            rasterCreateChild = raster;
        } else if (sourceXSubsampling == 1 && sourceYSubsampling == 1) {
            i2 = i;
            z = zHasRaster;
            rasterCreateChild = raster.createChild(raster.getMinX(), raster.getMinY(), i2, iM3211u2, i6, i7, null);
        } else {
            i2 = i;
            WritableRaster writableRasterCreateWritableRaster = Raster.createWritableRaster(sampleModelCreateCompatibleSampleModel, new Point(i6, i7));
            byte[] data2 = ((DataBufferByte) writableRasterCreateWritableRaster.getDataBuffer()).getData();
            int i8 = 0;
            int i9 = bounds.f10095y;
            int i10 = i7;
            while (i10 < i7 + iM3211u2) {
                int i11 = bounds.f10094x;
                boolean z3 = zHasRaster;
                int i12 = 0;
                while (i12 < i2) {
                    int i13 = i12;
                    int i14 = i8 + (i13 >> 3);
                    data2[i14] = (byte) (data2[i14] | (raster.getSample(i11, i9, 0) << (7 - (i13 & 7))));
                    i12 = i13 + 1;
                    i11 += sourceXSubsampling;
                }
                i8 += (i2 + 7) >> 3;
                i10++;
                i9 += sourceYSubsampling;
                zHasRaster = z3;
            }
            z = zHasRaster;
            rasterCreateChild = writableRasterCreateWritableRaster;
        }
        boolean zEquals = sampleModelCreateCompatibleSampleModel.equals(rasterCreateChild.getSampleModel());
        Raster raster2 = rasterCreateChild;
        if (!zEquals) {
            WritableRaster writableRasterCreateWritableRaster2 = Raster.createWritableRaster(sampleModelCreateCompatibleSampleModel, new Point(rasterCreateChild.getMinX(), rasterCreateChild.getMinY()));
            writableRasterCreateWritableRaster2.setRect(rasterCreateChild);
            raster2 = writableRasterCreateWritableRaster2;
        }
        if (z || !(renderedImage.getColorModel() instanceof IndexColorModel)) {
            z2 = false;
        } else {
            IndexColorModel indexColorModel = (IndexColorModel) renderedImage.getColorModel();
            z2 = indexColorModel.getRed(0) > indexColorModel.getRed(1);
        }
        int scanlineStride = ((MultiPixelPackedSampleModel) sampleModelCreateCompatibleSampleModel).getScanlineStride();
        int i15 = (i2 + 7) / 8;
        byte[] data3 = ((DataBufferByte) raster2.getDataBuffer()).getData();
        this.stream.write(0);
        this.stream.write(0);
        this.stream.write(intToMultiByte(i2));
        this.stream.write(intToMultiByte(iM3211u2));
        if (!z2 && scanlineStride == i15) {
            this.stream.write(data3, 0, iM3211u2 * i15);
            processImageProgress(100.0f);
        } else if (z2) {
            byte[] bArr = new byte[i15];
            int i16 = 0;
            for (int i17 = 0; i17 < iM3211u2 && !abortRequested(); i17++) {
                for (int i18 = 0; i18 < i15; i18++) {
                    bArr[i18] = (byte) (~data3[i18 + i16]);
                }
                this.stream.write(bArr, 0, i15);
                i16 += scanlineStride;
                processImageProgress((i17 * 100.0f) / iM3211u2);
            }
        } else {
            int i19 = 0;
            for (int i20 = 0; i20 < iM3211u2 && !abortRequested(); i20++) {
                this.stream.write(data3, i19, i15);
                i19 += scanlineStride;
                processImageProgress((i20 * 100.0f) / iM3211u2);
            }
        }
        if (abortRequested()) {
            processWriteAborted();
            return;
        }
        processImageComplete();
        ImageOutputStream imageOutputStream = this.stream;
        imageOutputStream.flushBefore(imageOutputStream.getStreamPosition());
    }
}
