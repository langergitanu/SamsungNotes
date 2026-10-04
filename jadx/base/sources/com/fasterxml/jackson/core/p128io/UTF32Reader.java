package com.fasterxml.jackson.core.p128io;

import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.text.RandomStringGenerator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class UTF32Reader extends BaseReader {
    protected final boolean _bigEndian;
    protected int _byteCount;
    protected int _charCount;
    protected final boolean _managedBuffers;
    protected char _surrogate;

    public UTF32Reader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2, boolean z) {
        super(iOContext, inputStream, bArr, i, i2);
        this._surrogate = (char) 0;
        this._charCount = 0;
        this._byteCount = 0;
        this._bigEndian = z;
        this._managedBuffers = inputStream != null;
    }

    private boolean loadMore(int i) throws IOException {
        int i2;
        this._byteCount = (this._length - i) + this._byteCount;
        if (i > 0) {
            if (this._ptr > 0) {
                for (int i4 = 0; i4 < i; i4++) {
                    byte[] bArr = this._buffer;
                    bArr[i4] = bArr[this._ptr + i4];
                }
                this._ptr = 0;
            }
            this._length = i;
        } else {
            this._ptr = 0;
            InputStream inputStream = this._in;
            int i5 = inputStream == null ? -1 : inputStream.read(this._buffer);
            if (i5 < 1) {
                this._length = 0;
                if (i5 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    return false;
                }
                reportStrangeStream();
            }
            this._length = i5;
        }
        while (true) {
            int i6 = this._length;
            if (i6 >= 4) {
                return true;
            }
            InputStream inputStream2 = this._in;
            if (inputStream2 == null) {
                i2 = -1;
            } else {
                byte[] bArr2 = this._buffer;
                i2 = inputStream2.read(bArr2, i6, bArr2.length - i6);
            }
            if (i2 < 1) {
                if (i2 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    reportUnexpectedEOF(this._length, 4);
                }
                reportStrangeStream();
            }
            this._length += i2;
        }
    }

    private void reportInvalid(int i, int i2, String str) throws CharConversionException {
        int i4 = (this._byteCount + this._ptr) - 1;
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i) + str + " at char #" + (this._charCount + i2) + ", byte #" + i4 + ")");
    }

    private void reportUnexpectedEOF(int i, int i2) throws CharConversionException {
        int i4 = this._byteCount + i;
        throw new CharConversionException(AbstractC2322a.m1625o(AbstractC0622a.m1173s(i, i2, "Unexpected EOF in the middle of a 4-byte UTF-32 char: got ", ", needed ", ", at char #"), this._charCount, i4, ", byte #", ")"));
    }

    @Override // com.fasterxml.jackson.core.p128io.BaseReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    @Override // com.fasterxml.jackson.core.p128io.BaseReader, java.io.Reader
    public /* bridge */ /* synthetic */ int read() {
        return super.read();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ca A[LOOP:0: B:21:0x0031->B:40:0x00ca, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bb A[SYNTHETIC] */
    @Override // java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(char[] cArr, int i, int i2) throws CharConversionException {
        int i4;
        int i5;
        int i6;
        int i7;
        if (this._buffer == null) {
            return -1;
        }
        if (i2 < 1) {
            return i2;
        }
        if (i < 0 || i + i2 > cArr.length) {
            reportBounds(cArr, i, i2);
        }
        int i8 = i2 + i;
        char c = this._surrogate;
        if (c != 0) {
            i4 = i + 1;
            cArr[i] = c;
            this._surrogate = (char) 0;
        } else {
            int i9 = this._length - this._ptr;
            if (i9 < 4 && !loadMore(i9)) {
                return -1;
            }
            i4 = i;
        }
        while (i4 < i8) {
            int i10 = this._ptr;
            if (this._bigEndian) {
                byte[] bArr = this._buffer;
                i5 = (bArr[i10] << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
                i6 = bArr[i10 + 3] & 255;
            } else {
                byte[] bArr2 = this._buffer;
                i5 = (bArr2[i10] & 255) | ((bArr2[i10 + 1] & 255) << 8) | ((bArr2[i10 + 2] & 255) << 16);
                i6 = bArr2[i10 + 3] << 24;
            }
            int i11 = i6 | i5;
            this._ptr = i10 + 4;
            if (i11 <= 65535) {
                i7 = i4 + 1;
                cArr[i4] = (char) i11;
                if (this._ptr < this._length) {
                    i4 = i7;
                    break;
                }
                i4 = i7;
            } else {
                if (i11 > 1114111) {
                    reportInvalid(i11, i4 - i, "(above " + Integer.toHexString(RandomStringGenerator.Builder.DEFAULT_MAXIMUM_CODE_POINT) + ") ");
                }
                int i12 = i11 - 65536;
                i7 = i4 + 1;
                cArr[i4] = (char) ((i12 >> 10) + 55296);
                i11 = 56320 | (i12 & 1023);
                if (i7 >= i8) {
                    this._surrogate = (char) i11;
                    i4 = i7;
                    break;
                }
                i4 = i7;
                i7 = i4 + 1;
                cArr[i4] = (char) i11;
                if (this._ptr < this._length) {
                }
            }
        }
        int i13 = i4 - i;
        this._charCount += i13;
        return i13;
    }
}
