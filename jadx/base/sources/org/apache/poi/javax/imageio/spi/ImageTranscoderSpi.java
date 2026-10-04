package org.apache.poi.javax.imageio.spi;

import org.apache.poi.javax.imageio.ImageTranscoder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class ImageTranscoderSpi extends IIOServiceProvider {
    public ImageTranscoderSpi() {
    }

    public abstract ImageTranscoder createTranscoderInstance();

    public abstract String getReaderServiceProviderName();

    public abstract String getWriterServiceProviderName();

    public ImageTranscoderSpi(String str, String str2) {
        super(str, str2);
    }
}
