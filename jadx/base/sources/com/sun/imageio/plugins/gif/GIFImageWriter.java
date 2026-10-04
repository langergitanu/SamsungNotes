package com.sun.imageio.plugins.gif;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.sun.imageio.plugins.common.LZWCompressor;
import com.sun.imageio.plugins.common.PaletteBuilder;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.java.awt.Dimension;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.ComponentSampleModel;
import org.apache.poi.java.awt.image.DataBufferByte;
import org.apache.poi.java.awt.image.IndexColorModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RenderedImage;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.javax.imageio.IIOException;
import org.apache.poi.javax.imageio.IIOImage;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.ImageWriteParam;
import org.apache.poi.javax.imageio.ImageWriter;
import org.apache.poi.javax.imageio.metadata.IIOInvalidTreeException;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.metadata.IIOMetadataNode;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;
import org.apache.poi.sun.awt.image.ByteComponentRaster;
import org.w3c.dom.NodeList;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GIFImageWriter extends ImageWriter {
    private static final boolean DEBUG = false;
    static final String IMAGE_METADATA_NAME = "javax_imageio_gif_image_1.0";
    static final String STANDARD_METADATA_NAME = "javax_imageio_1.0";
    static final String STREAM_METADATA_NAME = "javax_imageio_gif_stream_1.0";
    private int imageIndex;
    private boolean isWritingSequence;
    private ImageOutputStream stream;
    private GIFWritableStreamMetadata theStreamMetadata;
    private boolean wroteSequenceHeader;

    public GIFImageWriter(GIFImageWriterSpi gIFImageWriterSpi) {
        super(gIFImageWriterSpi);
        this.stream = null;
        this.isWritingSequence = false;
        this.wroteSequenceHeader = false;
        this.theStreamMetadata = null;
        this.imageIndex = 0;
    }

    private static void computeRegions(Rectangle rectangle, Dimension dimension, ImageWriteParam imageWriteParam) {
        int sourceYSubsampling;
        int sourceXSubsampling;
        if (imageWriteParam != null) {
            int[] sourceBands = imageWriteParam.getSourceBands();
            if (sourceBands != null && (sourceBands.length != 1 || sourceBands[0] != 0)) {
                throw new IllegalArgumentException("Cannot sub-band image!");
            }
            Rectangle sourceRegion = imageWriteParam.getSourceRegion();
            if (sourceRegion != null) {
                rectangle.setBounds(sourceRegion.intersection(rectangle));
            }
            int subsamplingXOffset = imageWriteParam.getSubsamplingXOffset();
            int subsamplingYOffset = imageWriteParam.getSubsamplingYOffset();
            rectangle.f10094x += subsamplingXOffset;
            rectangle.f10095y += subsamplingYOffset;
            rectangle.width -= subsamplingXOffset;
            rectangle.height -= subsamplingYOffset;
            sourceXSubsampling = imageWriteParam.getSourceXSubsampling();
            sourceYSubsampling = imageWriteParam.getSourceYSubsampling();
        } else {
            sourceYSubsampling = 1;
            sourceXSubsampling = 1;
        }
        dimension.setSize(AbstractC4539a.m3211u(rectangle.width, sourceXSubsampling, 1, sourceXSubsampling), AbstractC4539a.m3211u(rectangle.height, sourceYSubsampling, 1, sourceYSubsampling));
        if (dimension.width <= 0 || dimension.height <= 0) {
            throw new IllegalArgumentException("Empty source region!");
        }
    }

    private void convertMetadata(String str, IIOMetadata iIOMetadata, IIOMetadata iIOMetadata2) {
        String nativeMetadataFormatName = iIOMetadata.getNativeMetadataFormatName();
        if (nativeMetadataFormatName == null || !nativeMetadataFormatName.equals(str)) {
            String[] extraMetadataFormatNames = iIOMetadata.getExtraMetadataFormatNames();
            if (extraMetadataFormatNames != null) {
                for (String str2 : extraMetadataFormatNames) {
                    if (str2.equals(str)) {
                        break;
                    }
                }
                str = null;
            } else {
                str = null;
            }
        }
        if (str == null && iIOMetadata.isStandardMetadataFormatSupported()) {
            str = "javax_imageio_1.0";
        }
        if (str != null) {
            try {
                iIOMetadata2.mergeTree(str, iIOMetadata.getAsTree(str));
            } catch (IIOInvalidTreeException unused) {
            }
        }
    }

    private static byte[] createColorTable(ColorModel colorModel, SampleModel sampleModel) {
        int i = 0;
        if (!(colorModel instanceof IndexColorModel)) {
            if (sampleModel.getNumBands() != 1) {
                return null;
            }
            int i2 = sampleModel.getSampleSize()[0];
            if (i2 > 8) {
                i2 = 8;
            }
            int i4 = (1 << i2) * 3;
            byte[] bArr = new byte[i4];
            while (i < i4) {
                bArr[i] = (byte) (i / 3);
                i++;
            }
            return bArr;
        }
        IndexColorModel indexColorModel = (IndexColorModel) colorModel;
        int mapSize = indexColorModel.getMapSize();
        int gifPaletteSize = getGifPaletteSize(mapSize);
        byte[] bArr2 = new byte[gifPaletteSize];
        byte[] bArr3 = new byte[gifPaletteSize];
        byte[] bArr4 = new byte[gifPaletteSize];
        indexColorModel.getReds(bArr2);
        indexColorModel.getGreens(bArr3);
        indexColorModel.getBlues(bArr4);
        while (mapSize < gifPaletteSize) {
            bArr2[mapSize] = bArr2[0];
            bArr3[mapSize] = bArr3[0];
            bArr4[mapSize] = bArr4[0];
            mapSize++;
        }
        byte[] bArr5 = new byte[gifPaletteSize * 3];
        int i5 = 0;
        while (i < gifPaletteSize) {
            bArr5[i5] = bArr2[i];
            int i6 = i5 + 2;
            bArr5[i5 + 1] = bArr3[i];
            i5 += 3;
            bArr5[i6] = bArr4[i];
            i++;
        }
        return bArr5;
    }

    private static int getGifPaletteSize(int i) {
        if (i <= 2) {
            return 2;
        }
        int i2 = i - 1;
        int i4 = i2 | (i2 >> 1);
        int i5 = i4 | (i4 >> 2);
        int i6 = i5 | (i5 >> 4);
        int i7 = i6 | (i6 >> 8);
        return (i7 | (i7 >> 16)) + 1;
    }

    private static int getNumBits(int i) throws IOException {
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 32) {
            return 5;
        }
        if (i == 64) {
            return 6;
        }
        if (i == 128) {
            return 7;
        }
        if (i == 256) {
            return 8;
        }
        throw new IOException(AbstractC0541b.m767i(i, "Bad palette length: ", "!"));
    }

    private boolean needToCreateIndex(RenderedImage renderedImage) {
        SampleModel sampleModel = renderedImage.getSampleModel();
        return sampleModel.getNumBands() != 1 || sampleModel.getSampleSize()[0] > 8 || renderedImage.getColorModel().getComponentSize()[0] > 8;
    }

    private void resetLocal() {
        this.isWritingSequence = false;
        this.wroteSequenceHeader = false;
        this.theStreamMetadata = null;
        this.imageIndex = 0;
    }

    private void writeApplicationExtension(GIFWritableImageMetadata gIFWritableImageMetadata) throws IIOException {
        List list = gIFWritableImageMetadata.applicationIDs;
        if (list != null) {
            Iterator it = list.iterator();
            Iterator it2 = gIFWritableImageMetadata.authenticationCodes.iterator();
            Iterator it3 = gIFWritableImageMetadata.applicationData.iterator();
            while (it.hasNext()) {
                try {
                    this.stream.write(33);
                    this.stream.write(255);
                    this.stream.write(11);
                    this.stream.write((byte[]) it.next(), 0, 8);
                    this.stream.write((byte[]) it2.next(), 0, 3);
                    writeBlocks((byte[]) it3.next());
                    this.stream.write(0);
                } catch (IOException e) {
                    throw new IIOException("I/O error writing Application Extension!", e);
                }
            }
        }
    }

    private void writeBlocks(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        int i = 0;
        while (i < bArr.length) {
            int iMin = Math.min(bArr.length - i, 255);
            this.stream.write(iMin);
            this.stream.write(bArr, i, iMin);
            i += iMin;
        }
    }

    private void writeCommentExtension(GIFWritableImageMetadata gIFWritableImageMetadata) throws IIOException {
        List list = gIFWritableImageMetadata.comments;
        if (list != null) {
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    this.stream.write(33);
                    this.stream.write(JPEG.COM);
                    writeBlocks((byte[]) it.next());
                    this.stream.write(0);
                }
            } catch (IOException e) {
                throw new IIOException("I/O error writing Comment Extension!", e);
            }
        }
    }

    private void writeGraphicControlExtension(int i, boolean z, boolean z2, int i2, int i4) throws IIOException {
        try {
            this.stream.write(33);
            this.stream.write(249);
            this.stream.write(4);
            int i5 = (i & 3) << 2;
            if (z) {
                i5 |= 2;
            }
            if (z2) {
                i5 |= 1;
            }
            this.stream.write(i5);
            this.stream.writeShort((short) i2);
            this.stream.write(i4);
            this.stream.write(0);
        } catch (IOException e) {
            throw new IIOException("I/O error writing Graphic Control Extension!", e);
        }
    }

    private void writeHeader(String str, int i, int i2, int i4, int i5, int i6, boolean z, int i7, byte[] bArr) throws IIOException {
        try {
            this.stream.writeBytes("GIF" + str);
            this.stream.writeShort((short) i);
            this.stream.writeShort((short) i2);
            int i8 = (bArr != null ? 128 : 0) | (((i4 - 1) & 7) << 4);
            if (z) {
                i8 |= 8;
            }
            this.stream.write(i8 | (i7 - 1));
            this.stream.write(i6);
            this.stream.write(i5);
            if (bArr != null) {
                this.stream.write(bArr);
            }
        } catch (IOException e) {
            throw new IIOException("I/O error writing header!", e);
        }
    }

    private void writeImage(RenderedImage renderedImage, GIFWritableImageMetadata gIFWritableImageMetadata, ImageWriteParam imageWriteParam, byte[] bArr, Rectangle rectangle, Dimension dimension) throws IIOException {
        NodeList elementsByTagName;
        boolean z;
        int length;
        int sampleSize;
        renderedImage.getColorModel();
        SampleModel sampleModel = renderedImage.getSampleModel();
        if (gIFWritableImageMetadata == null) {
            gIFWritableImageMetadata = (GIFWritableImageMetadata) getDefaultImageMetadata(new ImageTypeSpecifier(renderedImage), imageWriteParam);
            z = gIFWritableImageMetadata.transparentColorFlag;
        } else {
            try {
                elementsByTagName = ((IIOMetadataNode) gIFWritableImageMetadata.getAsTree(IMAGE_METADATA_NAME)).getElementsByTagName("GraphicControlExtension");
            } catch (IllegalArgumentException unused) {
                elementsByTagName = null;
            }
            z = elementsByTagName != null && elementsByTagName.getLength() > 0;
            if (imageWriteParam != null && imageWriteParam.canWriteProgressive()) {
                if (imageWriteParam.getProgressiveMode() == 0) {
                    gIFWritableImageMetadata.interlaceFlag = false;
                } else if (imageWriteParam.getProgressiveMode() == 1) {
                    gIFWritableImageMetadata.interlaceFlag = true;
                }
            }
        }
        if (Arrays.equals(bArr, gIFWritableImageMetadata.localColorTable)) {
            gIFWritableImageMetadata.localColorTable = null;
        }
        gIFWritableImageMetadata.imageWidth = dimension.width;
        gIFWritableImageMetadata.imageHeight = dimension.height;
        if (z) {
            writeGraphicControlExtension(gIFWritableImageMetadata);
        }
        writePlainTextExtension(gIFWritableImageMetadata);
        writeApplicationExtension(gIFWritableImageMetadata);
        writeCommentExtension(gIFWritableImageMetadata);
        byte[] bArr2 = gIFWritableImageMetadata.localColorTable;
        if (bArr2 != null) {
            length = bArr2.length;
        } else {
            if (bArr == null) {
                sampleSize = sampleModel.getSampleSize(0);
                writeImageDescriptor(gIFWritableImageMetadata, getNumBits(sampleSize));
                writeRasterData(renderedImage, rectangle, dimension, imageWriteParam, gIFWritableImageMetadata.interlaceFlag);
            }
            length = bArr.length;
        }
        sampleSize = length / 3;
        writeImageDescriptor(gIFWritableImageMetadata, getNumBits(sampleSize));
        writeRasterData(renderedImage, rectangle, dimension, imageWriteParam, gIFWritableImageMetadata.interlaceFlag);
    }

    private void writeImageDescriptor(int i, int i2, int i4, int i5, boolean z, boolean z2, int i6, byte[] bArr) throws IIOException {
        try {
            this.stream.write(44);
            this.stream.writeShort((short) i);
            this.stream.writeShort((short) i2);
            this.stream.writeShort((short) i4);
            this.stream.writeShort((short) i5);
            int i7 = bArr != null ? 128 : 0;
            if (z) {
                i7 |= 64;
            }
            if (z2) {
                i7 |= 8;
            }
            this.stream.write(i7 | (i6 - 1));
            if (bArr != null) {
                this.stream.write(bArr);
            }
        } catch (IOException e) {
            throw new IIOException("I/O error writing Image Descriptor!", e);
        }
    }

    private void writePlainTextExtension(GIFWritableImageMetadata gIFWritableImageMetadata) throws IIOException {
        if (gIFWritableImageMetadata.hasPlainTextExtension) {
            try {
                this.stream.write(33);
                this.stream.write(1);
                this.stream.write(12);
                this.stream.writeShort(gIFWritableImageMetadata.textGridLeft);
                this.stream.writeShort(gIFWritableImageMetadata.textGridTop);
                this.stream.writeShort(gIFWritableImageMetadata.textGridWidth);
                this.stream.writeShort(gIFWritableImageMetadata.textGridHeight);
                this.stream.write(gIFWritableImageMetadata.characterCellWidth);
                this.stream.write(gIFWritableImageMetadata.characterCellHeight);
                this.stream.write(gIFWritableImageMetadata.textForegroundColor);
                this.stream.write(gIFWritableImageMetadata.textBackgroundColor);
                writeBlocks(gIFWritableImageMetadata.text);
                this.stream.write(0);
            } catch (IOException e) {
                throw new IIOException("I/O error writing Plain Text Extension!", e);
            }
        }
    }

    private void writeRasterData(RenderedImage renderedImage, Rectangle rectangle, Dimension dimension, ImageWriteParam imageWriteParam, boolean z) {
        int sourceXSubsampling;
        int sourceYSubsampling;
        LZWCompressor lZWCompressor;
        GIFImageWriter gIFImageWriter;
        LZWCompressor lZWCompressor2;
        int i = rectangle.f10094x;
        int i2 = rectangle.f10095y;
        int i4 = rectangle.width;
        int i5 = dimension.width;
        int i6 = dimension.height;
        if (imageWriteParam == null) {
            sourceXSubsampling = 1;
            sourceYSubsampling = 1;
        } else {
            sourceXSubsampling = imageWriteParam.getSourceXSubsampling();
            sourceYSubsampling = imageWriteParam.getSourceYSubsampling();
        }
        SampleModel sampleModel = renderedImage.getSampleModel();
        int i7 = sampleModel.getSampleSize()[0];
        if (i7 == 1) {
            i7++;
        }
        this.stream.write(i7);
        LZWCompressor lZWCompressor3 = new LZWCompressor(this.stream, i7, false);
        boolean z2 = sourceXSubsampling == 1 && sourceYSubsampling == 1 && renderedImage.getNumXTiles() == 1 && renderedImage.getNumYTiles() == 1 && (sampleModel instanceof ComponentSampleModel) && (renderedImage.getTile(0, 0) instanceof ByteComponentRaster) && (renderedImage.getTile(0, 0).getDataBuffer() instanceof DataBufferByte);
        int iMax = Math.max(i6 / 20, 1);
        processImageStarted(this.imageIndex);
        if (z) {
            if (z2) {
                ByteComponentRaster byteComponentRaster = (ByteComponentRaster) renderedImage.getTile(0, 0);
                byte[] data = ((DataBufferByte) byteComponentRaster.getDataBuffer()).getData();
                ComponentSampleModel componentSampleModel = (ComponentSampleModel) byteComponentRaster.getSampleModel();
                int dataOffset = byteComponentRaster.getDataOffset(0) + componentSampleModel.getOffset(i, i2, 0);
                int scanlineStride = componentSampleModel.getScanlineStride();
                writeRowsOpt(data, dataOffset, scanlineStride, lZWCompressor3, 0, 8, i5, i6, 0, iMax);
                if (!abortRequested()) {
                    int i8 = i6 / 8;
                    writeRowsOpt(data, dataOffset, scanlineStride, lZWCompressor3, 4, 8, i5, i6, i8, iMax);
                    if (!abortRequested()) {
                        int iM7d = AbstractC0000a.m7d(i6, 4, 8, i8);
                        writeRowsOpt(data, dataOffset, scanlineStride, lZWCompressor3, 2, 4, i5, i6, iM7d, iMax);
                        if (!abortRequested()) {
                            lZWCompressor2 = lZWCompressor3;
                            gIFImageWriter = this;
                            gIFImageWriter.writeRowsOpt(data, dataOffset, scanlineStride, lZWCompressor2, 1, 2, i5, i6, AbstractC0000a.m7d(i6, 2, 4, iM7d), iMax);
                            lZWCompressor = lZWCompressor2;
                        }
                    }
                }
            } else {
                lZWCompressor = lZWCompressor3;
                int i9 = sourceYSubsampling * 8;
                int i10 = sourceXSubsampling;
                int i11 = sourceYSubsampling;
                writeRows(renderedImage, lZWCompressor, i, i10, i2, i9, i4, 0, 8, i5, i6, 0, iMax);
                if (!abortRequested()) {
                    int i12 = i6 / 8;
                    int i13 = i11 * 4;
                    writeRows(renderedImage, lZWCompressor, i, i10, i2 + i13, i9, i4, 4, 8, i5, i6, i12, iMax);
                    if (!abortRequested()) {
                        int iM7d2 = AbstractC0000a.m7d(i6, 4, 8, i12);
                        int i14 = i11 * 2;
                        writeRows(renderedImage, lZWCompressor, i, i10, i2 + i14, i13, i4, 2, 4, i5, i6, iM7d2, iMax);
                        if (!abortRequested()) {
                            gIFImageWriter = this;
                            gIFImageWriter.writeRows(renderedImage, lZWCompressor, i, i10, i2 + i11, i14, i4, 1, 2, i5, i6, AbstractC0000a.m7d(i6, 2, 4, iM7d2), iMax);
                        }
                    }
                }
            }
            return;
        }
        int i15 = sourceXSubsampling;
        lZWCompressor = lZWCompressor3;
        int i16 = sourceYSubsampling;
        if (z2) {
            Raster tile = renderedImage.getTile(0, 0);
            byte[] data2 = ((DataBufferByte) tile.getDataBuffer()).getData();
            ComponentSampleModel componentSampleModel2 = (ComponentSampleModel) tile.getSampleModel();
            lZWCompressor2 = lZWCompressor;
            gIFImageWriter = this;
            gIFImageWriter.writeRowsOpt(data2, componentSampleModel2.getOffset(i, i2, 0), componentSampleModel2.getScanlineStride(), lZWCompressor2, 0, 1, i5, i6, 0, iMax);
            lZWCompressor = lZWCompressor2;
        } else {
            gIFImageWriter = this;
            gIFImageWriter.writeRows(renderedImage, lZWCompressor, i, i15, i2, i16, i4, 0, 1, i5, i6, 0, iMax);
        }
        if (gIFImageWriter.abortRequested()) {
            return;
        }
        gIFImageWriter.processImageProgress(100.0f);
        lZWCompressor.flush();
        gIFImageWriter.stream.write(0);
        gIFImageWriter.processImageComplete();
    }

    private void writeRows(RenderedImage renderedImage, LZWCompressor lZWCompressor, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int i13 = i6;
        int[] iArr = new int[i13];
        byte[] bArr = new byte[i9];
        Raster tile = (renderedImage.getNumXTiles() == 1 && renderedImage.getNumYTiles() == 1) ? renderedImage.getTile(0, 0) : renderedImage.getData();
        int i14 = i4;
        int i15 = i7;
        int i16 = i11;
        while (i15 < i10) {
            if (i16 % i12 == 0) {
                if (abortRequested()) {
                    processWriteAborted();
                    return;
                }
                processImageProgress((i16 * 100.0f) / i10);
            }
            tile.getSamples(i, i14, i13, 1, 0, iArr);
            int i17 = 0;
            int i18 = 0;
            while (i17 < i9) {
                bArr[i17] = (byte) iArr[i18];
                i17++;
                i18 += i2;
            }
            lZWCompressor.compress(bArr, 0, i9);
            i16++;
            i14 += i5;
            i15 += i8;
            i13 = i6;
        }
    }

    private void writeRowsOpt(byte[] bArr, int i, int i2, LZWCompressor lZWCompressor, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = (i4 * i2) + i;
        int i11 = i2 * i5;
        while (i4 < i7) {
            if (i8 % i9 == 0) {
                if (abortRequested()) {
                    processWriteAborted();
                    return;
                }
                processImageProgress((i8 * 100.0f) / i7);
            }
            lZWCompressor.compress(bArr, i10, i6);
            i8++;
            i10 += i11;
            i4 += i5;
        }
    }

    private void writeTrailer() {
        this.stream.write(59);
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public boolean canWriteSequence() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter, org.apache.poi.javax.imageio.ImageTranscoder
    public IIOMetadata convertImageMetadata(IIOMetadata iIOMetadata, ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam) {
        if (iIOMetadata == null) {
            throw new IllegalArgumentException("inData == null!");
        }
        if (imageTypeSpecifier == null) {
            throw new IllegalArgumentException("imageType == null!");
        }
        GIFWritableImageMetadata gIFWritableImageMetadata = (GIFWritableImageMetadata) getDefaultImageMetadata(imageTypeSpecifier, imageWriteParam);
        boolean z = gIFWritableImageMetadata.interlaceFlag;
        convertMetadata(IMAGE_METADATA_NAME, iIOMetadata, gIFWritableImageMetadata);
        if (imageWriteParam != null && imageWriteParam.canWriteProgressive() && imageWriteParam.getProgressiveMode() != 3) {
            gIFWritableImageMetadata.interlaceFlag = z;
        }
        return gIFWritableImageMetadata;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter, org.apache.poi.javax.imageio.ImageTranscoder
    public IIOMetadata convertStreamMetadata(IIOMetadata iIOMetadata, ImageWriteParam imageWriteParam) {
        if (iIOMetadata == null) {
            throw new IllegalArgumentException("inData == null!");
        }
        IIOMetadata defaultStreamMetadata = getDefaultStreamMetadata(imageWriteParam);
        convertMetadata(STREAM_METADATA_NAME, iIOMetadata, defaultStreamMetadata);
        return defaultStreamMetadata;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void endWriteSequence() {
        if (this.stream == null) {
            throw new IllegalStateException("output == null!");
        }
        if (!this.isWritingSequence) {
            throw new IllegalStateException("prepareWriteSequence() was not invoked!");
        }
        writeTrailer();
        resetLocal();
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public IIOMetadata getDefaultImageMetadata(ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam) {
        int transparentPixel;
        GIFWritableImageMetadata gIFWritableImageMetadata = new GIFWritableImageMetadata();
        SampleModel sampleModel = imageTypeSpecifier.getSampleModel();
        Rectangle rectangle = new Rectangle(sampleModel.getWidth(), sampleModel.getHeight());
        Dimension dimension = new Dimension();
        computeRegions(rectangle, dimension, imageWriteParam);
        gIFWritableImageMetadata.imageWidth = dimension.width;
        gIFWritableImageMetadata.imageHeight = dimension.height;
        if (imageWriteParam != null && imageWriteParam.canWriteProgressive() && imageWriteParam.getProgressiveMode() == 0) {
            gIFWritableImageMetadata.interlaceFlag = false;
        } else {
            gIFWritableImageMetadata.interlaceFlag = true;
        }
        ColorModel colorModel = imageTypeSpecifier.getColorModel();
        gIFWritableImageMetadata.localColorTable = createColorTable(colorModel, sampleModel);
        if ((colorModel instanceof IndexColorModel) && (transparentPixel = ((IndexColorModel) colorModel).getTransparentPixel()) != -1) {
            gIFWritableImageMetadata.transparentColorFlag = true;
            gIFWritableImageMetadata.transparentColorIndex = transparentPixel;
        }
        return gIFWritableImageMetadata;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public IIOMetadata getDefaultStreamMetadata(ImageWriteParam imageWriteParam) {
        GIFWritableStreamMetadata gIFWritableStreamMetadata = new GIFWritableStreamMetadata();
        gIFWritableStreamMetadata.version = "89a";
        return gIFWritableStreamMetadata;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public ImageWriteParam getDefaultWriteParam() {
        return new GIFImageWriteParam(getLocale());
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void prepareWriteSequence(IIOMetadata iIOMetadata) {
        if (this.stream == null) {
            throw new IllegalStateException("Output is not set.");
        }
        resetLocal();
        if (iIOMetadata == null) {
            this.theStreamMetadata = (GIFWritableStreamMetadata) getDefaultStreamMetadata(null);
        } else {
            GIFWritableStreamMetadata gIFWritableStreamMetadata = new GIFWritableStreamMetadata();
            this.theStreamMetadata = gIFWritableStreamMetadata;
            convertMetadata(STREAM_METADATA_NAME, iIOMetadata, gIFWritableStreamMetadata);
        }
        this.isWritingSequence = true;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void reset() {
        super.reset();
        resetLocal();
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void setOutput(Object obj) {
        super.setOutput(obj);
        if (obj == null) {
            this.stream = null;
        } else {
            if (!(obj instanceof ImageOutputStream)) {
                throw new IllegalArgumentException("output is not an ImageOutputStream");
            }
            ImageOutputStream imageOutputStream = (ImageOutputStream) obj;
            this.stream = imageOutputStream;
            imageOutputStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void write(IIOMetadata iIOMetadata, IIOImage iIOImage, ImageWriteParam imageWriteParam) throws IOException {
        if (this.stream == null) {
            throw new IllegalStateException("output == null!");
        }
        if (iIOImage == null) {
            throw new IllegalArgumentException("iioimage == null!");
        }
        if (iIOImage.hasRaster()) {
            throw new UnsupportedOperationException("canWriteRasters() == false!");
        }
        resetLocal();
        write(true, true, iIOMetadata == null ? (GIFWritableStreamMetadata) getDefaultStreamMetadata(imageWriteParam) : (GIFWritableStreamMetadata) convertStreamMetadata(iIOMetadata, imageWriteParam), iIOImage, imageWriteParam);
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void writeToSequence(IIOImage iIOImage, ImageWriteParam imageWriteParam) throws IOException {
        if (this.stream == null) {
            throw new IllegalStateException("output == null!");
        }
        if (iIOImage == null) {
            throw new IllegalArgumentException("image == null!");
        }
        if (iIOImage.hasRaster()) {
            throw new UnsupportedOperationException("canWriteRasters() == false!");
        }
        if (!this.isWritingSequence) {
            throw new IllegalStateException("prepareWriteSequence() was not invoked!");
        }
        write(!this.wroteSequenceHeader, false, this.theStreamMetadata, iIOImage, imageWriteParam);
        if (!this.wroteSequenceHeader) {
            this.wroteSequenceHeader = true;
        }
        this.imageIndex++;
    }

    private void writeGraphicControlExtension(GIFWritableImageMetadata gIFWritableImageMetadata) throws IIOException {
        writeGraphicControlExtension(gIFWritableImageMetadata.disposalMethod, gIFWritableImageMetadata.userInputFlag, gIFWritableImageMetadata.transparentColorFlag, gIFWritableImageMetadata.delayTime, gIFWritableImageMetadata.transparentColorIndex);
    }

    private void writeHeader(IIOMetadata iIOMetadata, int i) throws IIOException {
        GIFWritableStreamMetadata gIFWritableStreamMetadata;
        if (iIOMetadata instanceof GIFWritableStreamMetadata) {
            gIFWritableStreamMetadata = (GIFWritableStreamMetadata) iIOMetadata;
        } else {
            GIFWritableStreamMetadata gIFWritableStreamMetadata2 = new GIFWritableStreamMetadata();
            gIFWritableStreamMetadata2.setFromTree(STREAM_METADATA_NAME, iIOMetadata.getAsTree(STREAM_METADATA_NAME));
            gIFWritableStreamMetadata = gIFWritableStreamMetadata2;
        }
        writeHeader(gIFWritableStreamMetadata.version, gIFWritableStreamMetadata.logicalScreenWidth, gIFWritableStreamMetadata.logicalScreenHeight, gIFWritableStreamMetadata.colorResolution, gIFWritableStreamMetadata.pixelAspectRatio, gIFWritableStreamMetadata.backgroundColorIndex, gIFWritableStreamMetadata.sortFlag, i, gIFWritableStreamMetadata.globalColorTable);
    }

    private void writeImageDescriptor(GIFWritableImageMetadata gIFWritableImageMetadata, int i) throws IIOException {
        writeImageDescriptor(gIFWritableImageMetadata.imageLeftPosition, gIFWritableImageMetadata.imageTopPosition, gIFWritableImageMetadata.imageWidth, gIFWritableImageMetadata.imageHeight, gIFWritableImageMetadata.interlaceFlag, gIFWritableImageMetadata.sortFlag, i, gIFWritableImageMetadata.localColorTable);
    }

    private void write(boolean z, boolean z2, IIOMetadata iIOMetadata, IIOImage iIOImage, ImageWriteParam imageWriteParam) throws IOException {
        GIFWritableImageMetadata gIFWritableImageMetadata;
        byte[] bArr;
        int sampleSize;
        byte[] bArr2;
        byte[] bArr3;
        int i;
        clearAbortRequest();
        RenderedImage renderedImage = iIOImage.getRenderedImage();
        if (needToCreateIndex(renderedImage)) {
            renderedImage = PaletteBuilder.createIndexedImage(renderedImage);
            iIOImage.setRenderedImage(renderedImage);
        }
        ColorModel colorModel = renderedImage.getColorModel();
        SampleModel sampleModel = renderedImage.getSampleModel();
        Rectangle rectangle = new Rectangle(renderedImage.getMinX(), renderedImage.getMinY(), renderedImage.getWidth(), renderedImage.getHeight());
        Dimension dimension = new Dimension();
        computeRegions(rectangle, dimension, imageWriteParam);
        if (iIOImage.getMetadata() != null) {
            gIFWritableImageMetadata = new GIFWritableImageMetadata();
            convertMetadata(IMAGE_METADATA_NAME, iIOImage.getMetadata(), gIFWritableImageMetadata);
            if (gIFWritableImageMetadata.localColorTable == null) {
                gIFWritableImageMetadata.localColorTable = createColorTable(colorModel, sampleModel);
                if (colorModel instanceof IndexColorModel) {
                    int transparentPixel = ((IndexColorModel) colorModel).getTransparentPixel();
                    boolean z3 = transparentPixel != -1;
                    gIFWritableImageMetadata.transparentColorFlag = z3;
                    if (z3) {
                        gIFWritableImageMetadata.transparentColorIndex = transparentPixel;
                    }
                }
            }
        } else {
            gIFWritableImageMetadata = null;
        }
        GIFWritableImageMetadata gIFWritableImageMetadata2 = gIFWritableImageMetadata;
        if (z) {
            if (iIOMetadata != null) {
                GIFWritableStreamMetadata gIFWritableStreamMetadata = (GIFWritableStreamMetadata) iIOMetadata;
                if (gIFWritableStreamMetadata.version == null) {
                    gIFWritableStreamMetadata.version = "89a";
                }
                if (gIFWritableStreamMetadata.logicalScreenWidth == -1) {
                    gIFWritableStreamMetadata.logicalScreenWidth = dimension.width;
                }
                if (gIFWritableStreamMetadata.logicalScreenHeight == -1) {
                    gIFWritableStreamMetadata.logicalScreenHeight = dimension.height;
                }
                if (gIFWritableStreamMetadata.colorResolution == -1) {
                    if (colorModel != null) {
                        i = colorModel.getComponentSize()[0];
                    } else {
                        i = sampleModel.getSampleSize()[0];
                    }
                    gIFWritableStreamMetadata.colorResolution = i;
                }
                if (gIFWritableStreamMetadata.globalColorTable == null) {
                    if (this.isWritingSequence && gIFWritableImageMetadata2 != null && (bArr3 = gIFWritableImageMetadata2.localColorTable) != null) {
                        gIFWritableStreamMetadata.globalColorTable = bArr3;
                    } else if (gIFWritableImageMetadata2 == null || gIFWritableImageMetadata2.localColorTable == null) {
                        gIFWritableStreamMetadata.globalColorTable = createColorTable(colorModel, sampleModel);
                    }
                }
                bArr = gIFWritableStreamMetadata.globalColorTable;
                if (bArr != null) {
                    sampleSize = getNumBits(bArr.length / 3);
                } else if (gIFWritableImageMetadata2 != null && (bArr2 = gIFWritableImageMetadata2.localColorTable) != null) {
                    sampleSize = getNumBits(bArr2.length / 3);
                } else {
                    sampleSize = sampleModel.getSampleSize(0);
                }
                writeHeader(gIFWritableStreamMetadata, sampleSize);
            } else {
                throw new IllegalArgumentException("Cannot write null header!");
            }
        } else if (this.isWritingSequence) {
            bArr = this.theStreamMetadata.globalColorTable;
        } else {
            throw new IllegalArgumentException("Must write header for single image!");
        }
        writeImage(iIOImage.getRenderedImage(), gIFWritableImageMetadata2, imageWriteParam, bArr, rectangle, dimension);
        if (z2) {
            writeTrailer();
        }
    }
}
