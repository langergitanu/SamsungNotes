package cz.msebera.android.httpclient.util;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.Serializable;
import java.nio.CharBuffer;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class CharArrayBuffer implements CharSequence, Serializable {
    private static final long serialVersionUID = -6208952725094867135L;
    private char[] buffer;
    private int len;

    public CharArrayBuffer(int i) {
        Args.notNegative(i, "Buffer capacity");
        this.buffer = new char[i];
    }

    private void expand(int i) {
        char[] cArr = new char[Math.max(this.buffer.length << 1, i)];
        System.arraycopy(this.buffer, 0, cArr, 0, this.len);
        this.buffer = cArr;
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
        int i5 = this.len + i2;
        if (i5 > this.buffer.length) {
            expand(i5);
        }
        System.arraycopy(cArr, i, this.buffer, this.len, i2);
        this.len = i5;
    }

    public char[] buffer() {
        return this.buffer;
    }

    public int capacity() {
        return this.buffer.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.buffer[i];
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

    public int indexOf(int i, int i2, int i4) {
        if (i2 < 0) {
            i2 = 0;
        }
        int i5 = this.len;
        if (i4 > i5) {
            i4 = i5;
        }
        if (i2 > i4) {
            return -1;
        }
        while (i2 < i4) {
            if (this.buffer[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.len == 0;
    }

    public boolean isFull() {
        return this.len == this.buffer.length;
    }

    @Override // java.lang.CharSequence
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

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(AbstractC0000a.m11h(i, "Negative beginIndex: "));
        }
        if (i2 <= this.len) {
            if (i <= i2) {
                return CharBuffer.wrap(this.buffer, i, i2);
            }
            throw new IndexOutOfBoundsException(AbstractC1038a.m1214o(i, i2, "beginIndex: ", " > endIndex: "));
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i2, "endIndex: ", " > length: ");
        sbM778t.append(this.len);
        throw new IndexOutOfBoundsException(sbM778t.toString());
    }

    public String substring(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(AbstractC0000a.m11h(i, "Negative beginIndex: "));
        }
        if (i2 <= this.len) {
            if (i <= i2) {
                return new String(this.buffer, i, i2 - i);
            }
            throw new IndexOutOfBoundsException(AbstractC1038a.m1214o(i, i2, "beginIndex: ", " > endIndex: "));
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i2, "endIndex: ", " > length: ");
        sbM778t.append(this.len);
        throw new IndexOutOfBoundsException(sbM778t.toString());
    }

    public String substringTrimmed(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(AbstractC0000a.m11h(i, "Negative beginIndex: "));
        }
        if (i2 > this.len) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i2, "endIndex: ", " > length: ");
            sbM778t.append(this.len);
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
        if (i > i2) {
            throw new IndexOutOfBoundsException(AbstractC1038a.m1214o(i, i2, "beginIndex: ", " > endIndex: "));
        }
        while (i < i2 && HTTP.isWhitespace(this.buffer[i])) {
            i++;
        }
        while (i2 > i && HTTP.isWhitespace(this.buffer[i2 - 1])) {
            i2--;
        }
        return new String(this.buffer, i, i2 - i);
    }

    public char[] toCharArray() {
        int i = this.len;
        char[] cArr = new char[i];
        if (i > 0) {
            System.arraycopy(this.buffer, 0, cArr, 0, i);
        }
        return cArr;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.buffer, 0, this.len);
    }

    public int indexOf(int i) {
        return indexOf(i, 0, this.len);
    }

    public void append(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i = this.len + length;
        if (i > this.buffer.length) {
            expand(i);
        }
        str.getChars(0, length, this.buffer, this.len);
        this.len = i;
    }

    public void append(CharArrayBuffer charArrayBuffer, int i, int i2) {
        if (charArrayBuffer == null) {
            return;
        }
        append(charArrayBuffer.buffer, i, i2);
    }

    public void append(CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer == null) {
            return;
        }
        append(charArrayBuffer.buffer, 0, charArrayBuffer.len);
    }

    public void append(char c) {
        int i = this.len + 1;
        if (i > this.buffer.length) {
            expand(i);
        }
        this.buffer[this.len] = c;
        this.len = i;
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
        int i5 = this.len;
        int i6 = i2 + i5;
        if (i6 > this.buffer.length) {
            expand(i6);
        }
        while (i5 < i6) {
            this.buffer[i5] = (char) (bArr[i] & 255);
            i++;
            i5++;
        }
        this.len = i6;
    }

    public void append(ByteArrayBuffer byteArrayBuffer, int i, int i2) {
        if (byteArrayBuffer == null) {
            return;
        }
        append(byteArrayBuffer.buffer(), i, i2);
    }

    public void append(Object obj) {
        append(String.valueOf(obj));
    }
}
