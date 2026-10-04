package com.sun.imageio.plugins.gif;

import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.Locale;
import org.apache.poi.javax.imageio.ImageReader;
import org.apache.poi.javax.imageio.spi.ImageReaderSpi;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GIFImageReaderSpi extends ImageReaderSpi {
    private static final String readerClassName = "com.sun.imageio.plugins.gif.GIFImageReader";
    private static final String vendorName = "Oracle Corporation";
    private static final String version = "1.0";
    private static final String[] names = {Constants.THUMBNAIL_GIF_EXTENSION, "GIF"};
    private static final String[] suffixes = {Constants.THUMBNAIL_GIF_EXTENSION};
    private static final String[] MIMETypes = {Constants.MIME_GIF};
    private static final String[] writerSpiNames = {"com.sun.imageio.plugins.gif.GIFImageWriterSpi"};

    public GIFImageReaderSpi() {
        super("Oracle Corporation", "1.0", names, suffixes, MIMETypes, readerClassName, new Class[]{ImageInputStream.class}, writerSpiNames, true, "javax_imageio_gif_stream_1.0", "com.sun.imageio.plugins.gif.GIFStreamMetadataFormat", null, null, true, "javax_imageio_gif_image_1.0", "com.sun.imageio.plugins.gif.GIFImageMetadataFormat", null, null);
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageReaderSpi
    public boolean canDecodeInput(Object obj) {
        byte b;
        if (!(obj instanceof ImageInputStream)) {
            return false;
        }
        ImageInputStream imageInputStream = (ImageInputStream) obj;
        byte[] bArr = new byte[6];
        imageInputStream.mark();
        imageInputStream.readFully(bArr);
        imageInputStream.reset();
        return bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56 && ((b = bArr[4]) == 55 || b == 57) && bArr[5] == 97;
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageReaderSpi
    public ImageReader createReaderInstance(Object obj) {
        return new GIFImageReader(this);
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider
    public String getDescription(Locale locale) {
        return "Standard GIF image reader";
    }
}
