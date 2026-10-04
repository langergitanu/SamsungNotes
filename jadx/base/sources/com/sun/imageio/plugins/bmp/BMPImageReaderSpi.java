package com.sun.imageio.plugins.bmp;

import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.Locale;
import org.apache.poi.javax.imageio.ImageReader;
import org.apache.poi.javax.imageio.spi.ImageReaderSpi;
import org.apache.poi.javax.imageio.spi.ServiceRegistry;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BMPImageReaderSpi extends ImageReaderSpi {
    private boolean registered;
    private static String[] writerSpiNames = {"com.sun.imageio.plugins.bmp.BMPImageWriterSpi"};
    private static String[] formatNames = {"bmp", "BMP"};
    private static String[] entensions = {"bmp"};
    private static String[] mimeType = {"image/bmp"};

    public BMPImageReaderSpi() {
        super(JPEG.vendor, "1.0", formatNames, entensions, mimeType, "com.sun.imageio.plugins.bmp.BMPImageReader", new Class[]{ImageInputStream.class}, writerSpiNames, false, null, null, null, null, true, BMPMetadata.nativeMetadataFormatName, "com.sun.imageio.plugins.bmp.BMPMetadataFormat", null, null);
        this.registered = false;
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageReaderSpi
    public boolean canDecodeInput(Object obj) {
        if (!(obj instanceof ImageInputStream)) {
            return false;
        }
        ImageInputStream imageInputStream = (ImageInputStream) obj;
        byte[] bArr = new byte[2];
        imageInputStream.mark();
        imageInputStream.readFully(bArr);
        imageInputStream.reset();
        return bArr[0] == 66 && bArr[1] == 77;
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageReaderSpi
    public ImageReader createReaderInstance(Object obj) {
        return new BMPImageReader(this);
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider
    public String getDescription(Locale locale) {
        return "Standard BMP Image Reader";
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider, org.apache.poi.javax.imageio.spi.RegisterableService
    public void onRegistration(ServiceRegistry serviceRegistry, Class<?> cls) {
        if (this.registered) {
            return;
        }
        this.registered = true;
    }
}
