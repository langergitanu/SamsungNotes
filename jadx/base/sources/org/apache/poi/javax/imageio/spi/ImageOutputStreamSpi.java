package org.apache.poi.javax.imageio.spi;

import java.io.File;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class ImageOutputStreamSpi extends IIOServiceProvider {
    protected Class<?> outputClass;

    public ImageOutputStreamSpi() {
    }

    public boolean canUseCacheFile() {
        return false;
    }

    public ImageOutputStream createOutputStreamInstance(Object obj) {
        return createOutputStreamInstance(obj, true, null);
    }

    public abstract ImageOutputStream createOutputStreamInstance(Object obj, boolean z, File file);

    public Class<?> getOutputClass() {
        return this.outputClass;
    }

    public boolean needsCacheFile() {
        return false;
    }

    public ImageOutputStreamSpi(String str, String str2, Class<?> cls) {
        super(str, str2);
        this.outputClass = cls;
    }
}
