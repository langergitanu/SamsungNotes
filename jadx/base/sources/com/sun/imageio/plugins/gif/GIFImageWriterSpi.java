package com.sun.imageio.plugins.gif;

import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.sun.imageio.plugins.common.PaletteBuilder;
import java.util.Locale;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.ImageWriter;
import org.apache.poi.javax.imageio.spi.ImageWriterSpi;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GIFImageWriterSpi extends ImageWriterSpi {
    private static final String vendorName = "Oracle Corporation";
    private static final String version = "1.0";
    private static final String writerClassName = "com.sun.imageio.plugins.gif.GIFImageWriter";
    private static final String[] names = {Constants.THUMBNAIL_GIF_EXTENSION, "GIF"};
    private static final String[] suffixes = {Constants.THUMBNAIL_GIF_EXTENSION};
    private static final String[] MIMETypes = {Constants.MIME_GIF};
    private static final String[] readerSpiNames = {"com.sun.imageio.plugins.gif.GIFImageReaderSpi"};

    public GIFImageWriterSpi() {
        super("Oracle Corporation", "1.0", names, suffixes, MIMETypes, writerClassName, new Class[]{ImageOutputStream.class}, readerSpiNames, true, "javax_imageio_gif_stream_1.0", "com.sun.imageio.plugins.gif.GIFStreamMetadataFormat", null, null, true, "javax_imageio_gif_image_1.0", "com.sun.imageio.plugins.gif.GIFImageMetadataFormat", null, null);
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageWriterSpi
    public boolean canEncodeImage(ImageTypeSpecifier imageTypeSpecifier) {
        if (imageTypeSpecifier == null) {
            throw new IllegalArgumentException("type == null!");
        }
        SampleModel sampleModel = imageTypeSpecifier.getSampleModel();
        ColorModel colorModel = imageTypeSpecifier.getColorModel();
        if (sampleModel.getNumBands() != 1 || sampleModel.getSampleSize(0) > 8 || sampleModel.getWidth() > 65535 || sampleModel.getHeight() > 65535 || (colorModel != null && colorModel.getComponentSize()[0] > 8)) {
            return PaletteBuilder.canCreatePalette(imageTypeSpecifier);
        }
        return true;
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageWriterSpi
    public ImageWriter createWriterInstance(Object obj) {
        return new GIFImageWriter(this);
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider
    public String getDescription(Locale locale) {
        return "Standard GIF image writer";
    }
}
