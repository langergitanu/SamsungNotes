package org.apache.poi.p226sl.image;

import org.apache.poi.java.awt.Dimension;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ImageHeaderEMF {
    private static final String EMF_SIGNATURE = " EMF";
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) ImageHeaderEMF.class);
    private final Rectangle deviceBounds;

    public ImageHeaderEMF(byte[] bArr, int i) {
        if (((int) LittleEndian.getUInt(bArr, i)) != 1) {
            LOG.log(5, "Invalid EMF picture - invalid type");
            this.deviceBounds = new Rectangle(0, 0, 200, 200);
            return;
        }
        int i2 = LittleEndian.getInt(bArr, i + 8);
        int i4 = LittleEndian.getInt(bArr, i + 12);
        this.deviceBounds = new Rectangle(i2, i4, LittleEndian.getInt(bArr, i + 16) - i2, LittleEndian.getInt(bArr, i + 20) - i4);
        if (EMF_SIGNATURE.equals(new String(bArr, i + 40, 4, LocaleUtil.CHARSET_1252))) {
            return;
        }
        LOG.log(5, "Invalid EMF picture - invalid signature");
    }

    public Rectangle getBounds() {
        return this.deviceBounds;
    }

    public Dimension getSize() {
        return this.deviceBounds.getSize();
    }
}
