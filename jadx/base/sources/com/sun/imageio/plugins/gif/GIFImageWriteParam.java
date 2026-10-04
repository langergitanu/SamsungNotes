package com.sun.imageio.plugins.gif;

import java.util.Locale;
import org.apache.poi.javax.imageio.ImageWriteParam;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class GIFImageWriteParam extends ImageWriteParam {
    public GIFImageWriteParam(Locale locale) {
        super(locale);
        this.canWriteCompressed = true;
        this.canWriteProgressive = true;
        String[] strArr = {"LZW", "lzw"};
        this.compressionTypes = strArr;
        this.compressionType = strArr[0];
    }

    @Override // org.apache.poi.javax.imageio.ImageWriteParam
    public void setCompressionMode(int i) {
        if (i == 0) {
            throw new UnsupportedOperationException("MODE_DISABLED is not supported.");
        }
        super.setCompressionMode(i);
    }
}
