package com.sun.imageio.plugins.wbmp;

import com.samsung.android.support.senl.document.memoconverter.core.ImageUtil;
import com.sun.imageio.plugins.common.ReaderUtil;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.Locale;
import org.apache.poi.javax.imageio.ImageReader;
import org.apache.poi.javax.imageio.spi.ImageReaderSpi;
import org.apache.poi.javax.imageio.spi.ServiceRegistry;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class WBMPImageReaderSpi extends ImageReaderSpi {
    private static final int MAX_WBMP_HEIGHT = 768;
    private static final int MAX_WBMP_WIDTH = 1024;
    private boolean registered;
    private static String[] writerSpiNames = {"com.sun.imageio.plugins.wbmp.WBMPImageWriterSpi"};
    private static String[] formatNames = {"wbmp", "WBMP"};
    private static String[] entensions = {"wbmp"};
    private static String[] mimeType = {ImageUtil.MIME_TYPE_WBMP};

    public WBMPImageReaderSpi() {
        super(JPEG.vendor, "1.0", formatNames, entensions, mimeType, "com.sun.imageio.plugins.wbmp.WBMPImageReader", new Class[]{ImageInputStream.class}, writerSpiNames, true, null, null, null, null, true, "javax_imageio_wbmp_1.0", "com.sun.imageio.plugins.wbmp.WBMPMetadataFormat", null, null);
        this.registered = false;
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageReaderSpi
    public boolean canDecodeInput(Object obj) {
        if (!(obj instanceof ImageInputStream)) {
            return false;
        }
        ImageInputStream imageInputStream = (ImageInputStream) obj;
        imageInputStream.mark();
        try {
            byte b = imageInputStream.readByte();
            byte b5 = imageInputStream.readByte();
            if (b == 0 && b5 == 0) {
                int multiByteInteger = ReaderUtil.readMultiByteInteger(imageInputStream);
                int multiByteInteger2 = ReaderUtil.readMultiByteInteger(imageInputStream);
                if (multiByteInteger > 0 && multiByteInteger2 > 0) {
                    long length = imageInputStream.length();
                    if (length != -1) {
                        return length - imageInputStream.getStreamPosition() == ((long) ((multiByteInteger / 8) + (multiByteInteger % 8 == 0 ? 0 : 1))) * ((long) multiByteInteger2);
                    }
                    if (multiByteInteger < 1024 && multiByteInteger2 < 768) {
                        z = true;
                    }
                    return z;
                }
                return false;
            }
            return false;
        } finally {
            imageInputStream.reset();
        }
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageReaderSpi
    public ImageReader createReaderInstance(Object obj) {
        return new WBMPImageReader(this);
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider
    public String getDescription(Locale locale) {
        return "Standard WBMP Image Reader";
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider, org.apache.poi.javax.imageio.spi.RegisterableService
    public void onRegistration(ServiceRegistry serviceRegistry, Class<?> cls) {
        if (this.registered) {
            return;
        }
        this.registered = true;
    }
}
