package org.apache.poi.p226sl.image;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.java.awt.Dimension;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ImageHeaderWMF {
    public static final int APMHEADER_KEY = -1698247209;
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) ImageHeaderWMF.class);
    private final int bottom;
    private int checksum;
    private final int handle;
    private final int inch;
    private final int left;
    private final int reserved;
    private final int right;
    private final int top;

    public ImageHeaderWMF(Rectangle rectangle) {
        this.handle = 0;
        int i = rectangle.f10094x;
        this.left = i;
        int i2 = rectangle.f10095y;
        this.top = i2;
        this.right = i + rectangle.width;
        this.bottom = i2 + rectangle.height;
        this.inch = 72;
        this.reserved = 0;
    }

    public Rectangle getBounds() {
        int i = this.left;
        int i2 = this.top;
        return new Rectangle(i, i2, this.right - i, this.bottom - i2);
    }

    public int getChecksum() {
        return (((((-43247) ^ this.left) ^ this.top) ^ this.right) ^ this.bottom) ^ this.inch;
    }

    public int getLength() {
        return 22;
    }

    public Dimension getSize() {
        double d = 72.0d / ((double) this.inch);
        return new Dimension((int) Math.round(((double) (this.right - this.left)) * d), (int) Math.round(((double) (this.bottom - this.top)) * d));
    }

    public void write(OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[22];
        LittleEndian.putInt(bArr, 0, APMHEADER_KEY);
        LittleEndian.putUShort(bArr, 4, 0);
        LittleEndian.putUShort(bArr, 6, this.left);
        LittleEndian.putUShort(bArr, 8, this.top);
        LittleEndian.putUShort(bArr, 10, this.right);
        LittleEndian.putUShort(bArr, 12, this.bottom);
        LittleEndian.putUShort(bArr, 14, this.inch);
        LittleEndian.putInt(bArr, 16, 0);
        int checksum = getChecksum();
        this.checksum = checksum;
        LittleEndian.putUShort(bArr, 20, checksum);
        outputStream.write(bArr);
    }

    public ImageHeaderWMF(byte[] bArr, int i) {
        int i2 = i + 4;
        if (LittleEndian.getInt(bArr, i) != -1698247209) {
            LOG.log(5, "WMF file doesn't contain a placeable header - ignore parsing");
            this.handle = 0;
            this.left = 0;
            this.top = 0;
            this.right = 200;
            this.bottom = 200;
            this.inch = 72;
            this.reserved = 0;
            return;
        }
        this.handle = LittleEndian.getUShort(bArr, i2);
        this.left = LittleEndian.getShort(bArr, i + 6);
        this.top = LittleEndian.getShort(bArr, i + 8);
        this.right = LittleEndian.getShort(bArr, i + 10);
        this.bottom = LittleEndian.getShort(bArr, i + 12);
        this.inch = LittleEndian.getUShort(bArr, i + 14);
        this.reserved = LittleEndian.getInt(bArr, i + 16);
        short s = LittleEndian.getShort(bArr, i + 20);
        this.checksum = s;
        if (s != getChecksum()) {
            LOG.log(5, "WMF checksum does not match the header data");
        }
    }
}
