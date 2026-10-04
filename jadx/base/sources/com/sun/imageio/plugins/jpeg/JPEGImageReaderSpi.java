package com.sun.imageio.plugins.jpeg;

import java.util.Locale;
import org.apache.poi.javax.imageio.ImageReader;
import org.apache.poi.javax.imageio.spi.ImageReaderSpi;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class JPEGImageReaderSpi extends ImageReaderSpi {
    private static String[] writerSpiNames = {"com.sun.imageio.plugins.jpeg.JPEGImageWriterSpi"};

    public JPEGImageReaderSpi() {
        super(JPEG.vendor, JPEG.version, JPEG.names, JPEG.suffixes, JPEG.MIMETypes, "com.sun.imageio.plugins.jpeg.JPEGImageReader", new Class[]{ImageInputStream.class}, writerSpiNames, true, JPEG.nativeStreamMetadataFormatName, JPEG.nativeStreamMetadataFormatClassName, null, null, true, JPEG.nativeImageMetadataFormatName, JPEG.nativeImageMetadataFormatClassName, null, null);
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageReaderSpi
    public boolean canDecodeInput(Object obj) {
        if (!(obj instanceof ImageInputStream)) {
            return false;
        }
        ImageInputStream imageInputStream = (ImageInputStream) obj;
        imageInputStream.mark();
        int i = imageInputStream.read();
        int i2 = imageInputStream.read();
        imageInputStream.reset();
        return i == 255 && i2 == 216;
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageReaderSpi
    public ImageReader createReaderInstance(Object obj) {
        return new JPEGImageReader(this);
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider
    public String getDescription(Locale locale) {
        return "Standard JPEG Image Reader";
    }
}
