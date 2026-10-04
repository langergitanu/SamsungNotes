package cz.msebera.android.httpclient.util;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class ByteArrayBuffer implements Serializable {
    private static final long serialVersionUID = 4359112959524048036L;
    private byte[] buffer;
    private int len;

    public ByteArrayBuffer(int i) {
        Args.notNegative(i, "Buffer capacity");
        this.buffer = new byte[i];
    }

    private void expand(int i) {
        byte[] bArr = new byte[Math.max(this.buffer.length << 1, i)];
        System.arraycopy(this.buffer, 0, bArr, 0, this.len);
        this.buffer = bArr;
    }

    public void append(byte[] bArr, int i, int i2) {
        int i4;
        if (bArr == null) {
            return;
        }
        if (i < 0 || i > bArr.length || i2 < 0 || (i4 = i + i2) < 0 || i4 > bArr.length) {
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "off: ", " len: ", " b.length: ");
            sbM1173s.append(bArr.length);
            throw new IndexOutOfBoundsException(sbM1173s.toString());
        }
        if (i2 == 0) {
            return;
        }
        int i5 = this.len + i2;
        if (i5 > this.buffer.length) {
            expand(i5);
        }
        System.arraycopy(bArr, i, this.buffer, this.len, i2);
        this.len = i5;
    }

    public byte[] buffer() {
        return this.buffer;
    }

    public int byteAt(int i) {
        return this.buffer[i];
    }

    public int capacity() {
        return this.buffer.length;
    }

    public void clear() {
        this.len = 0;
    }

    public void ensureCapacity(int i) {
        if (i <= 0) {
            return;
        }
        int length = this.buffer.length;
        int i2 = this.len;
        if (i > length - i2) {
            expand(i2 + i);
        }
    }

    public int indexOf(byte b, int i, int i2) {
        if (i < 0) {
            i = 0;
        }
        int i4 = this.len;
        if (i2 > i4) {
            i2 = i4;
        }
        if (i > i2) {
            return -1;
        }
        while (i < i2) {
            if (this.buffer[i] == b) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.len == 0;
    }

    public boolean isFull() {
        return this.len == this.buffer.length;
    }

    public int length() {
        return this.len;
    }

    public void setLength(int i) {
        if (i >= 0 && i <= this.buffer.length) {
            this.len = i;
        } else {
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "len: ", " < 0 or > buffer len: ");
            sbM778t.append(this.buffer.length);
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
    }

    public byte[] toByteArray() {
        int i = this.len;
        byte[] bArr = new byte[i];
        if (i > 0) {
            System.arraycopy(this.buffer, 0, bArr, 0, i);
        }
        return bArr;
    }

    public int indexOf(byte b) {
        return indexOf(b, 0, this.len);
    }

    public void append(int i) {
        int i2 = this.len + 1;
        if (i2 > this.buffer.length) {
            expand(i2);
        }
        this.buffer[this.len] = (byte) i;
        this.len = i2;
    }

    public void append(char[] cArr, int i, int i2) {
        int i4;
        if (cArr == null) {
            return;
        }
        if (i < 0 || i > cArr.length || i2 < 0 || (i4 = i + i2) < 0 || i4 > cArr.length) {
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "off: ", " len: ", " b.length: ");
            sbM1173s.append(cArr.length);
            throw new IndexOutOfBoundsException(sbM1173s.toString());
        }
        if (i2 == 0) {
            return;
        }
        int i5 = this.len;
        int i6 = i2 + i5;
        if (i6 > this.buffer.length) {
            expand(i6);
        }
        while (i5 < i6) {
            this.buffer[i5] = (byte) cArr[i];
            i++;
            i5++;
        }
        this.len = i6;
    }

    public void append(CharArrayBuffer charArrayBuffer, int i, int i2) {
        if (charArrayBuffer == null) {
            return;
        }
        append(charArrayBuffer.buffer(), i, i2);
    }
}
