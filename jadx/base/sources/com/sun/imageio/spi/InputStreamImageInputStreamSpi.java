package com.sun.imageio.spi;

import java.io.File;
import java.io.InputStream;
import java.util.Locale;
import org.apache.poi.javax.imageio.spi.ImageInputStreamSpi;
import org.apache.poi.javax.imageio.stream.FileCacheImageInputStream;
import org.apache.poi.javax.imageio.stream.ImageInputStream;
import org.apache.poi.javax.imageio.stream.MemoryCacheImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class InputStreamImageInputStreamSpi extends ImageInputStreamSpi {
    private static final Class inputClass = InputStream.class;
    private static final String vendorName = "Oracle Corporation";
    private static final String version = "1.0";

    public InputStreamImageInputStreamSpi() {
        super("Oracle Corporation", "1.0", inputClass);
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageInputStreamSpi
    public boolean canUseCacheFile() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageInputStreamSpi
    public ImageInputStream createInputStreamInstance(Object obj, boolean z, File file) {
        if (!(obj instanceof InputStream)) {
            throw new IllegalArgumentException();
        }
        InputStream inputStream = (InputStream) obj;
        return z ? new FileCacheImageInputStream(inputStream, file) : new MemoryCacheImageInputStream(inputStream);
    }

    @Override // org.apache.poi.javax.imageio.spi.IIOServiceProvider
    public String getDescription(Locale locale) {
        return "Service provider that instantiates a FileCacheImageInputStream or MemoryCacheImageInputStream from an InputStream";
    }

    @Override // org.apache.poi.javax.imageio.spi.ImageInputStreamSpi
    public boolean needsCacheFile() {
        return false;
    }
}
