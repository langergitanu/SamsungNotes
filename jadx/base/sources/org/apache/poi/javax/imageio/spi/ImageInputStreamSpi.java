package org.apache.poi.javax.imageio.spi;

import java.io.File;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class ImageInputStreamSpi extends IIOServiceProvider {
    protected Class<?> inputClass;

    public ImageInputStreamSpi() {
    }

    public boolean canUseCacheFile() {
        return false;
    }

    public ImageInputStream createInputStreamInstance(Object obj) {
        return createInputStreamInstance(obj, true, null);
    }

    public abstract ImageInputStream createInputStreamInstance(Object obj, boolean z, File file);

    public Class<?> getInputClass() {
        return this.inputClass;
    }

    public boolean needsCacheFile() {
        return false;
    }

    public ImageInputStreamSpi(String str, String str2, Class<?> cls) {
        super(str, str2);
        this.inputClass = cls;
    }
}
