package com.sun.imageio.spi;

import java.io.File;
import java.util.Locale;
import org.apache.poi.javax.imageio.spi.ImageOutputStreamSpi;
import org.apache.poi.javax.imageio.stream.FileImageOutputStream;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FileImageOutputStreamSpi extends ImageOutputStreamSpi {
    private static final Class outputClass = File.class;
    private static final String vendorName = "Oracle Corporation";
    private static final String version = "1.0";

    public FileImageOutputStreamSpi() {
        super("Oracle Corporation", "1.0", outputClass);
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageOutputStreamSpi
    public ImageOutputStream createOutputStreamInstance(Object obj, boolean z, File file) {
        if (!(obj instanceof File)) {
            throw new IllegalArgumentException();
        }
        try {
            return new FileImageOutputStream((File) obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider
    public String getDescription(Locale locale) {
        return "Service provider that instantiates a FileImageOutputStream from a File";
    }
}
