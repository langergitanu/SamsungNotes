package com.sun.imageio.plugins.png;

import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.Locale;
import org.apache.poi.javax.imageio.ImageReader;
import org.apache.poi.javax.imageio.spi.ImageReaderSpi;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PNGImageReaderSpi extends ImageReaderSpi {
    private static final String readerClassName = "com.sun.imageio.plugins.png.PNGImageReader";
    private static final String vendorName = "Oracle Corporation";
    private static final String version = "1.0";
    private static final String[] names = {Constants.THUMBNAIL_PNG_EXTENSION, "PNG"};
    private static final String[] suffixes = {Constants.THUMBNAIL_PNG_EXTENSION};
    private static final String[] MIMETypes = {CoeditServiceConstants.MimeType.IMAGE_PNG, "image/x-png"};
    private static final String[] writerSpiNames = {"com.sun.imageio.plugins.png.PNGImageWriterSpi"};

    public PNGImageReaderSpi() {
        super("Oracle Corporation", "1.0", names, suffixes, MIMETypes, readerClassName, new Class[]{ImageInputStream.class}, writerSpiNames, false, null, null, null, null, true, PNGMetadata.nativeMetadataFormatName, "com.sun.imageio.plugins.png.PNGMetadataFormat", null, null);
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageReaderSpi
    public boolean canDecodeInput(Object obj) {
        if (!(obj instanceof ImageInputStream)) {
            return false;
        }
        ImageInputStream imageInputStream = (ImageInputStream) obj;
        byte[] bArr = new byte[8];
        imageInputStream.mark();
        imageInputStream.readFully(bArr);
        imageInputStream.reset();
        return bArr[0] == -119 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71 && bArr[4] == 13 && bArr[5] == 10 && bArr[6] == 26 && bArr[7] == 10;
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageReaderSpi
    public ImageReader createReaderInstance(Object obj) {
        return new PNGImageReader(this);
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider
    public String getDescription(Locale locale) {
        return "Standard PNG image reader";
    }
}
