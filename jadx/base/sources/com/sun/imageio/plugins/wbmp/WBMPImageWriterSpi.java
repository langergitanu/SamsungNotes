package com.sun.imageio.plugins.wbmp;

import com.samsung.android.support.senl.document.memoconverter.core.ImageUtil;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.Locale;
import org.apache.poi.java.awt.image.MultiPixelPackedSampleModel;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.ImageWriter;
import org.apache.poi.javax.imageio.spi.ImageWriterSpi;
import org.apache.poi.javax.imageio.spi.ServiceRegistry;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class WBMPImageWriterSpi extends ImageWriterSpi {
    private boolean registered;
    private static String[] readerSpiNames = {"com.sun.imageio.plugins.wbmp.WBMPImageReaderSpi"};
    private static String[] formatNames = {"wbmp", "WBMP"};
    private static String[] entensions = {"wbmp"};
    private static String[] mimeType = {ImageUtil.MIME_TYPE_WBMP};

    public WBMPImageWriterSpi() {
        super(JPEG.vendor, "1.0", formatNames, entensions, mimeType, "com.sun.imageio.plugins.wbmp.WBMPImageWriter", new Class[]{ImageOutputStream.class}, readerSpiNames, true, null, null, null, null, true, null, null, null, null);
        this.registered = false;
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageWriterSpi
    public boolean canEncodeImage(ImageTypeSpecifier imageTypeSpecifier) {
        SampleModel sampleModel = imageTypeSpecifier.getSampleModel();
        return (sampleModel instanceof MultiPixelPackedSampleModel) && sampleModel.getSampleSize(0) == 1;
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageWriterSpi
    public ImageWriter createWriterInstance(Object obj) {
        return new WBMPImageWriter(this);
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider
    public String getDescription(Locale locale) {
        return "Standard WBMP Image Writer";
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider, org.apache.poi.javax.imageio.spi.RegisterableService
    public void onRegistration(ServiceRegistry serviceRegistry, Class<?> cls) {
        if (this.registered) {
            return;
        }
        this.registered = true;
    }
}
