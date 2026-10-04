package com.fasterxml.jackson.core;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Base64Variant implements Serializable {
    public static final int BASE64_VALUE_INVALID = -1;
    public static final int BASE64_VALUE_PADDING = -2;
    static final char PADDING_CHAR_NONE = 0;
    private static final long serialVersionUID = 1;
    private final transient int[] _asciiToBase64;
    private final transient byte[] _base64ToAsciiB;
    private final transient char[] _base64ToAsciiC;
    protected final transient int _maxLineLength;
    protected final String _name;
    protected final transient char _paddingChar;
    protected final transient boolean _usesPadding;

    public Base64Variant(String str, String str2, boolean z, char c, int i) {
        int[] iArr = new int[128];
        this._asciiToBase64 = iArr;
        char[] cArr = new char[64];
        this._base64ToAsciiC = cArr;
        this._base64ToAsciiB = new byte[64];
        this._name = str;
        this._usesPadding = z;
        this._paddingChar = c;
        this._maxLineLength = i;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(length, "Base64Alphabet length must be exactly 64 (was ", ")"));
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = this._base64ToAsciiC[i2];
            this._base64ToAsciiB[i2] = (byte) c2;
            this._asciiToBase64[c2] = i2;
        }
        if (z) {
            this._asciiToBase64[c] = -2;
        }
    }

    public int decodeBase64Byte(byte b) {
        if (b <= 127) {
            return this._asciiToBase64[b];
        }
        return -1;
    }

    public int decodeBase64Char(char c) {
        if (c <= 127) {
            return this._asciiToBase64[c];
        }
        return -1;
    }

    public String encode(byte[] bArr) {
        return encode(bArr, false);
    }

    public byte encodeBase64BitsAsByte(int i) {
        return this._base64ToAsciiB[i];
    }

    public char encodeBase64BitsAsChar(int i) {
        return this._base64ToAsciiC[i];
    }

    public int encodeBase64Chunk(int i, char[] cArr, int i2) {
        char[] cArr2 = this._base64ToAsciiC;
        cArr[i2] = cArr2[(i >> 18) & 63];
        cArr[i2 + 1] = cArr2[(i >> 12) & 63];
        int i4 = i2 + 3;
        cArr[i2 + 2] = cArr2[(i >> 6) & 63];
        int i5 = i2 + 4;
        cArr[i4] = cArr2[i & 63];
        return i5;
    }

    public int encodeBase64Partial(int i, int i2, char[] cArr, int i4) {
        char[] cArr2 = this._base64ToAsciiC;
        cArr[i4] = cArr2[(i >> 18) & 63];
        int i5 = i4 + 2;
        cArr[i4 + 1] = cArr2[(i >> 12) & 63];
        if (this._usesPadding) {
            int i6 = i4 + 3;
            cArr[i5] = i2 == 2 ? cArr2[(i >> 6) & 63] : this._paddingChar;
            int i7 = i4 + 4;
            cArr[i6] = this._paddingChar;
            return i7;
        }
        if (i2 != 2) {
            return i5;
        }
        int i8 = i4 + 3;
        cArr[i5] = cArr2[(i >> 6) & 63];
        return i8;
    }

    public int getMaxLineLength() {
        return this._maxLineLength;
    }

    public String getName() {
        return this._name;
    }

    public byte getPaddingByte() {
        return (byte) this._paddingChar;
    }

    public char getPaddingChar() {
        return this._paddingChar;
    }

    public Object readResolve() {
        return Base64Variants.valueOf(this._name);
    }

    public String toString() {
        return this._name;
    }

    public boolean usesPadding() {
        return this._usesPadding;
    }

    public boolean usesPaddingChar(char c) {
        return c == this._paddingChar;
    }

    public int decodeBase64Char(int i) {
        if (i <= 127) {
            return this._asciiToBase64[i];
        }
        return -1;
    }

    public String encode(byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z) {
            sb.append('\"');
        }
        int maxLineLength = getMaxLineLength() >> 2;
        int i = length - 3;
        int i2 = 0;
        while (i2 <= i) {
            int i4 = i2 + 2;
            int i5 = ((bArr[i2 + 1] & 255) | (bArr[i2] << 8)) << 8;
            i2 += 3;
            encodeBase64Chunk(sb, i5 | (bArr[i4] & 255));
            maxLineLength--;
            if (maxLineLength <= 0) {
                sb.append('\\');
                sb.append('n');
                maxLineLength = getMaxLineLength() >> 2;
            }
        }
        int i6 = length - i2;
        if (i6 > 0) {
            int i7 = i2 + 1;
            int i8 = bArr[i2] << 16;
            if (i6 == 2) {
                i8 |= (bArr[i7] & 255) << 8;
            }
            encodeBase64Partial(sb, i8, i6);
        }
        if (z) {
            sb.append('\"');
        }
        return sb.toString();
    }

    public boolean usesPaddingChar(int i) {
        return i == this._paddingChar;
    }

    public void encodeBase64Chunk(StringBuilder sb, int i) {
        sb.append(this._base64ToAsciiC[(i >> 18) & 63]);
        sb.append(this._base64ToAsciiC[(i >> 12) & 63]);
        sb.append(this._base64ToAsciiC[(i >> 6) & 63]);
        sb.append(this._base64ToAsciiC[i & 63]);
    }

    public void encodeBase64Partial(StringBuilder sb, int i, int i2) {
        sb.append(this._base64ToAsciiC[(i >> 18) & 63]);
        sb.append(this._base64ToAsciiC[(i >> 12) & 63]);
        if (this._usesPadding) {
            sb.append(i2 == 2 ? this._base64ToAsciiC[(i >> 6) & 63] : this._paddingChar);
            sb.append(this._paddingChar);
        } else if (i2 == 2) {
            sb.append(this._base64ToAsciiC[(i >> 6) & 63]);
        }
    }

    public int encodeBase64Chunk(int i, byte[] bArr, int i2) {
        byte[] bArr2 = this._base64ToAsciiB;
        bArr[i2] = bArr2[(i >> 18) & 63];
        bArr[i2 + 1] = bArr2[(i >> 12) & 63];
        int i4 = i2 + 3;
        bArr[i2 + 2] = bArr2[(i >> 6) & 63];
        int i5 = i2 + 4;
        bArr[i4] = bArr2[i & 63];
        return i5;
    }

    public int encodeBase64Partial(int i, int i2, byte[] bArr, int i4) {
        byte[] bArr2 = this._base64ToAsciiB;
        bArr[i4] = bArr2[(i >> 18) & 63];
        int i5 = i4 + 2;
        bArr[i4 + 1] = bArr2[(i >> 12) & 63];
        if (!this._usesPadding) {
            if (i2 != 2) {
                return i5;
            }
            int i6 = i4 + 3;
            bArr[i5] = bArr2[(i >> 6) & 63];
            return i6;
        }
        byte b = (byte) this._paddingChar;
        int i7 = i4 + 3;
        bArr[i5] = i2 == 2 ? bArr2[(i >> 6) & 63] : b;
        int i8 = i4 + 4;
        bArr[i7] = b;
        return i8;
    }

    public Base64Variant(Base64Variant base64Variant, String str, int i) {
        this(base64Variant, str, base64Variant._usesPadding, base64Variant._paddingChar, i);
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z, char c, int i) {
        int[] iArr = new int[128];
        this._asciiToBase64 = iArr;
        char[] cArr = new char[64];
        this._base64ToAsciiC = cArr;
        byte[] bArr = new byte[64];
        this._base64ToAsciiB = bArr;
        this._name = str;
        byte[] bArr2 = base64Variant._base64ToAsciiB;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = base64Variant._base64ToAsciiC;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = base64Variant._asciiToBase64;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this._usesPadding = z;
        this._paddingChar = c;
        this._maxLineLength = i;
    }
}
