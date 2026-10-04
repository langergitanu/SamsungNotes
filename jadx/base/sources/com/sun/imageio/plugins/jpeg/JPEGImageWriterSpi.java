package com.sun.imageio.plugins.jpeg;

import java.util.Locale;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.ImageWriter;
import org.apache.poi.javax.imageio.spi.ImageWriterSpi;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class JPEGImageWriterSpi extends ImageWriterSpi {
    private static String[] readerSpiNames = {"com.sun.imageio.plugins.jpeg.JPEGImageReaderSpi"};

    public JPEGImageWriterSpi() {
        super(JPEG.vendor, JPEG.version, JPEG.names, JPEG.suffixes, JPEG.MIMETypes, "com.sun.imageio.plugins.jpeg.JPEGImageWriter", new Class[]{ImageOutputStream.class}, readerSpiNames, true, JPEG.nativeStreamMetadataFormatName, JPEG.nativeStreamMetadataFormatClassName, null, null, true, JPEG.nativeImageMetadataFormatName, JPEG.nativeImageMetadataFormatClassName, null, null);
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageWriterSpi
    public boolean canEncodeImage(ImageTypeSpecifier imageTypeSpecifier) {
        int[] sampleSize = imageTypeSpecifier.getSampleModel().getSampleSize();
        int i = sampleSize[0];
        for (int i2 = 1; i2 < sampleSize.length; i2++) {
            int i4 = sampleSize[i2];
            if (i4 > i) {
                i = i4;
            }
        }
        return i >= 1 && i <= 8;
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageWriterSpi
    public ImageWriter createWriterInstance(Object obj) {
        return new JPEGImageWriter(this);
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider
    public String getDescription(Locale locale) {
        return "Standard JPEG Image Writer";
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageWriterSpi
    public boolean isFormatLossless() {
        return false;
    }
}
