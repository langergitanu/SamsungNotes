package org.apache.poi.javax.imageio.plugins.bmp;

import com.sun.imageio.plugins.bmp.BMPCompressionTypes;
import java.util.Locale;
import org.apache.poi.javax.imageio.ImageWriteParam;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BMPImageWriteParam extends ImageWriteParam {
    private boolean topDown;

    public BMPImageWriteParam(Locale locale) {
        super(locale);
        this.topDown = false;
        String[] compressionTypes = BMPCompressionTypes.getCompressionTypes();
        this.compressionTypes = compressionTypes;
        this.canWriteCompressed = true;
        this.compressionMode = 3;
        this.compressionType = compressionTypes[0];
    }

    public boolean isTopDown() {
        return this.topDown;
    }

    public void setTopDown(boolean z) {
        this.topDown = z;
    }

    public BMPImageWriteParam() {
        this(null);
    }
}
