package org.apache.poi.p226sl.image;

import org.apache.poi.java.awt.Dimension;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ImageHeaderPICT {
    public static final double DEFAULT_RESOLUTION = 72.0d;
    public static final int PICT_HEADER_OFFSET = 512;
    private static final byte[] V2_HEADER = {0, 17, 2, -1, 12, 0, -1, -2, 0, 0};
    private final Rectangle bounds;
    private final double hRes;
    private final double vRes;

    public ImageHeaderPICT(byte[] bArr, int i) {
        int unsignedShort = readUnsignedShort(bArr, i + 2);
        int unsignedShort2 = readUnsignedShort(bArr, i + 4);
        int unsignedShort3 = readUnsignedShort(bArr, i + 6);
        int unsignedShort4 = readUnsignedShort(bArr, i + 8);
        int i2 = i + 10;
        byte[] bArr2 = V2_HEADER;
        int length = bArr2.length;
        boolean z = false;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                z = true;
                break;
            }
            int i5 = i2 + 1;
            if (bArr2[i4] != bArr[i2]) {
                i2 = i5;
                break;
            } else {
                i4++;
                i2 = i5;
            }
        }
        if (z) {
            this.hRes = readFixedPoint(bArr, i2);
            this.vRes = readFixedPoint(bArr, i2 + 4);
        } else {
            this.hRes = 72.0d;
            this.vRes = 72.0d;
        }
        this.bounds = new Rectangle(unsignedShort2, unsignedShort, unsignedShort4 - unsignedShort2, unsignedShort3 - unsignedShort);
    }

    private static double readFixedPoint(byte[] bArr, int i) {
        return ((double) ((bArr[i + 3] & 255) | ((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8)))) / 65536.0d;
    }

    private static int readUnsignedShort(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    public Dimension getSize() {
        return new Dimension((int) Math.round((((double) this.bounds.width) * 72.0d) / this.hRes), (int) Math.round((((double) this.bounds.height) * 72.0d) / this.vRes));
    }
}
