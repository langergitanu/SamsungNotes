package com.sun.imageio.plugins.jpeg;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import org.apache.poi.javax.imageio.IIOException;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class JPEGBuffer {
    ImageInputStream iis;
    private boolean debug = false;
    final int BUFFER_SIZE = 4096;
    byte[] buf = new byte[4096];
    int bufAvail = 0;
    int bufPtr = 0;

    public JPEGBuffer(ImageInputStream imageInputStream) {
        this.iis = imageInputStream;
    }

    public long getStreamPosition() {
        return this.iis.getStreamPosition() - ((long) this.bufAvail);
    }

    public void loadBuf(int i) {
        if (this.debug) {
            System.out.print("loadbuf called with ");
            System.out.print("count " + i + SQLKeyword.COMMA);
            System.out.println("bufAvail " + this.bufAvail + SQLKeyword.COMMA);
        }
        if (i != 0) {
            if (this.bufAvail >= i) {
                return;
            }
        } else if (this.bufAvail == 4096) {
            return;
        }
        int i2 = this.bufAvail;
        if (i2 > 0 && i2 < 4096) {
            byte[] bArr = this.buf;
            System.arraycopy(bArr, this.bufPtr, bArr, 0, i2);
        }
        ImageInputStream imageInputStream = this.iis;
        byte[] bArr2 = this.buf;
        int i4 = this.bufAvail;
        int i5 = imageInputStream.read(bArr2, i4, bArr2.length - i4);
        if (this.debug) {
            System.out.println("iis.read returned " + i5);
        }
        if (i5 != -1) {
            this.bufAvail += i5;
        }
        this.bufPtr = 0;
        if (this.bufAvail < Math.min(4096, i)) {
            throw new IIOException("Image Format Error");
        }
    }

    public void print(int i) {
        System.out.print("buffer has ");
        System.out.print(this.bufAvail);
        System.out.println(" bytes available");
        int i2 = this.bufAvail;
        if (i2 < i) {
            i = i2;
        }
        int i4 = this.bufPtr;
        while (i > 0) {
            int i5 = i4 + 1;
            int i6 = this.buf[i4] & 255;
            System.out.print(" " + Integer.toHexString(i6));
            i += -1;
            i4 = i5;
        }
        System.out.println();
    }

    public void pushBack() {
        ImageInputStream imageInputStream = this.iis;
        imageInputStream.seek(imageInputStream.getStreamPosition() - ((long) this.bufAvail));
        this.bufAvail = 0;
        this.bufPtr = 0;
    }

    public void readData(byte[] bArr) throws IIOException {
        int length = bArr.length;
        int i = this.bufAvail;
        int i2 = 0;
        if (i >= length) {
            System.arraycopy(this.buf, this.bufPtr, bArr, 0, length);
            this.bufAvail -= length;
            this.bufPtr += length;
            return;
        }
        if (i > 0) {
            System.arraycopy(this.buf, this.bufPtr, bArr, 0, i);
            int i4 = this.bufAvail;
            length -= i4;
            this.bufAvail = 0;
            this.bufPtr = 0;
            i2 = i4;
        }
        if (this.iis.read(bArr, i2, length) != length) {
            throw new IIOException("Image format Error");
        }
    }

    public boolean scanForFF(JPEGImageReader jPEGImageReader) {
        boolean z = false;
        while (true) {
            boolean z2 = z;
            while (!z) {
                while (true) {
                    int i = this.bufAvail;
                    if (i <= 0) {
                        break;
                    }
                    byte[] bArr = this.buf;
                    int i2 = this.bufPtr;
                    this.bufPtr = i2 + 1;
                    if ((bArr[i2] & 255) == 255) {
                        this.bufAvail = i - 1;
                        z = true;
                        break;
                    }
                    this.bufAvail = i - 1;
                }
                loadBuf(0);
                if (z) {
                    while (true) {
                        int i4 = this.bufAvail;
                        if (i4 <= 0) {
                            break;
                        }
                        byte[] bArr2 = this.buf;
                        int i5 = this.bufPtr;
                        if ((bArr2[i5] & 255) != 255) {
                            break;
                        }
                        this.bufPtr = i5 + 1;
                        this.bufAvail = i4 - 1;
                    }
                }
                if (this.bufAvail == 0) {
                    break;
                }
            }
            return z2;
            this.buf[0] = -39;
            this.bufAvail = 1;
            this.bufPtr = 0;
            z = true;
        }
    }

    public void skipData(int i) {
        int i2 = this.bufAvail;
        if (i2 >= i) {
            this.bufAvail = i2 - i;
            this.bufPtr += i;
            return;
        }
        if (i2 > 0) {
            i -= i2;
            this.bufAvail = 0;
            this.bufPtr = 0;
        }
        if (this.iis.skipBytes(i) != i) {
            throw new IIOException("Image format Error");
        }
    }
}
