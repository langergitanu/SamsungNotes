package com.sun.imageio.spi;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Locale;
import org.apache.poi.javax.imageio.spi.ImageInputStreamSpi;
import org.apache.poi.javax.imageio.stream.FileImageInputStream;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class RAFImageInputStreamSpi extends ImageInputStreamSpi {
    private static final Class inputClass = RandomAccessFile.class;
    private static final String vendorName = "Oracle Corporation";
    private static final String version = "1.0";

    public RAFImageInputStreamSpi() {
        super("Oracle Corporation", "1.0", inputClass);
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageInputStreamSpi
    public ImageInputStream createInputStreamInstance(Object obj, boolean z, File file) {
        if (!(obj instanceof RandomAccessFile)) {
            throw new IllegalArgumentException("input not a RandomAccessFile!");
        }
        try {
            return new FileImageInputStream((RandomAccessFile) obj);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider
    public String getDescription(Locale locale) {
        return "Service provider that instantiates a FileImageInputStream from a RandomAccessFile";
    }
}
