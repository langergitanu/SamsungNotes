package com.sun.imageio.plugins.bmp;

import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.Locale;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.java.awt.image.SinglePixelPackedSampleModel;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.ImageWriter;
import org.apache.poi.javax.imageio.spi.ImageWriterSpi;
import org.apache.poi.javax.imageio.spi.ServiceRegistry;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BMPImageWriterSpi extends ImageWriterSpi {
    private boolean registered;
    private static String[] readerSpiNames = {"com.sun.imageio.plugins.bmp.BMPImageReaderSpi"};
    private static String[] formatNames = {"bmp", "BMP"};
    private static String[] entensions = {"bmp"};
    private static String[] mimeType = {"image/bmp"};

    public BMPImageWriterSpi() {
        super(JPEG.vendor, "1.0", formatNames, entensions, mimeType, "com.sun.imageio.plugins.bmp.BMPImageWriter", new Class[]{ImageOutputStream.class}, readerSpiNames, false, null, null, null, null, true, BMPMetadata.nativeMetadataFormatName, "com.sun.imageio.plugins.bmp.BMPMetadataFormat", null, null);
        this.registered = false;
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageWriterSpi
    public boolean canEncodeImage(ImageTypeSpecifier imageTypeSpecifier) {
        int dataType = imageTypeSpecifier.getSampleModel().getDataType();
        if (dataType < 0 || dataType > 3) {
            return false;
        }
        SampleModel sampleModel = imageTypeSpecifier.getSampleModel();
        int numBands = sampleModel.getNumBands();
        if (numBands != 1 && numBands != 3) {
            return false;
        }
        if (numBands != 1 || dataType == 0) {
            return dataType <= 0 || (sampleModel instanceof SinglePixelPackedSampleModel);
        }
        return false;
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageWriterSpi
    public ImageWriter createWriterInstance(Object obj) {
        return new BMPImageWriter(this);
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider
    public String getDescription(Locale locale) {
        return "Standard BMP Image Writer";
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider, org.apache.poi.javax.imageio.spi.RegisterableService
    public void onRegistration(ServiceRegistry serviceRegistry, Class<?> cls) {
        if (this.registered) {
            return;
        }
        this.registered = true;
    }
}
