package com.sun.imageio.plugins.png;

import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.Locale;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.IndexColorModel;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.ImageWriter;
import org.apache.poi.javax.imageio.spi.ImageWriterSpi;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PNGImageWriterSpi extends ImageWriterSpi {
    private static final String vendorName = "Oracle Corporation";
    private static final String version = "1.0";
    private static final String writerClassName = "com.sun.imageio.plugins.png.PNGImageWriter";
    private static final String[] names = {Constants.THUMBNAIL_PNG_EXTENSION, "PNG"};
    private static final String[] suffixes = {Constants.THUMBNAIL_PNG_EXTENSION};
    private static final String[] MIMETypes = {CoeditServiceConstants.MimeType.IMAGE_PNG, "image/x-png"};
    private static final String[] readerSpiNames = {"com.sun.imageio.plugins.png.PNGImageReaderSpi"};

    public PNGImageWriterSpi() {
        super("Oracle Corporation", "1.0", names, suffixes, MIMETypes, writerClassName, new Class[]{ImageOutputStream.class}, readerSpiNames, false, null, null, null, null, true, PNGMetadata.nativeMetadataFormatName, "com.sun.imageio.plugins.png.PNGMetadataFormat", null, null);
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageWriterSpi
    public boolean canEncodeImage(ImageTypeSpecifier imageTypeSpecifier) {
        int numBands;
        SampleModel sampleModel = imageTypeSpecifier.getSampleModel();
        ColorModel colorModel = imageTypeSpecifier.getColorModel();
        int[] sampleSize = sampleModel.getSampleSize();
        int i = sampleSize[0];
        for (int i2 = 1; i2 < sampleSize.length; i2++) {
            int i4 = sampleSize[i2];
            if (i4 > i) {
                i = i4;
            }
        }
        if (i < 1 || i > 16 || (numBands = sampleModel.getNumBands()) < 1 || numBands > 4) {
            return false;
        }
        boolean zHasAlpha = colorModel.hasAlpha();
        if (colorModel instanceof IndexColorModel) {
            return true;
        }
        if ((numBands == 1 || numBands == 3) && zHasAlpha) {
            return false;
        }
        return !(numBands == 2 || numBands == 4) || zHasAlpha;
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageWriterSpi
    public ImageWriter createWriterInstance(Object obj) {
        return new PNGImageWriter(this);
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider
    public String getDescription(Locale locale) {
        return "Standard PNG image writer";
    }
}
