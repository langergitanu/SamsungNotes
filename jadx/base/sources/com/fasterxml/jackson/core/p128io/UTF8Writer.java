package com.fasterxml.jackson.core.p128io;

import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class UTF8Writer extends Writer {
    static final int SURR1_FIRST = 55296;
    static final int SURR1_LAST = 56319;
    static final int SURR2_FIRST = 56320;
    static final int SURR2_LAST = 57343;
    protected final IOContext _context;
    OutputStream _out;
    byte[] _outBuffer;
    final int _outBufferEnd;
    int _surrogate = 0;
    int _outPtr = 0;

    public UTF8Writer(IOContext iOContext, OutputStream outputStream) {
        this._context = iOContext;
        this._out = outputStream;
        this._outBuffer = iOContext.allocWriteEncodingBuffer();
        this._outBufferEnd = r2.length - 4;
    }

    private int convertSurrogate(int i) throws IOException {
        int i2 = this._surrogate;
        this._surrogate = 0;
        if (i >= 56320 && i <= SURR2_LAST) {
            return (i - 56320) + ((i2 - SURR1_FIRST) << 10) + 65536;
        }
        throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i) + "; illegal combination");
    }

    private void throwIllegal(int i) throws IOException {
        if (i > 1114111) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627");
        }
        if (i < SURR1_FIRST) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(i) + ") to output");
        }
        if (i <= SURR1_LAST) {
            throw new IOException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        }
        throw new IOException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")");
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OutputStream outputStream = this._out;
        if (outputStream != null) {
            int i = this._outPtr;
            if (i > 0) {
                outputStream.write(this._outBuffer, 0, i);
                this._outPtr = 0;
            }
            OutputStream outputStream2 = this._out;
            this._out = null;
            byte[] bArr = this._outBuffer;
            if (bArr != null) {
                this._outBuffer = null;
                this._context.releaseWriteEncodingBuffer(bArr);
            }
            outputStream2.close();
            int i2 = this._surrogate;
            this._surrogate = 0;
            if (i2 > 0) {
                throwIllegal(i2);
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        OutputStream outputStream = this._out;
        if (outputStream != null) {
            int i = this._outPtr;
            if (i > 0) {
                outputStream.write(this._outBuffer, 0, i);
                this._outPtr = 0;
            }
            this._out.flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOException {
        write(c);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0025, code lost:
    
        continue;
     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(char[] cArr, int i, int i2) throws IOException {
        if (i2 < 2) {
            if (i2 == 1) {
                write(cArr[i]);
                return;
            }
            return;
        }
        if (this._surrogate > 0) {
            i2--;
            write(convertSurrogate(cArr[i]));
            i++;
        }
        int i4 = this._outPtr;
        byte[] bArr = this._outBuffer;
        int i5 = this._outBufferEnd;
        int i6 = i2 + i;
        while (i < i6) {
            if (i4 >= i5) {
                this._out.write(bArr, 0, i4);
                i4 = 0;
            }
            int i7 = i + 1;
            char c = cArr[i];
            if (c < 128) {
                int i8 = i4 + 1;
                bArr[i4] = (byte) c;
                int i9 = i6 - i7;
                int i10 = i5 - i8;
                if (i9 > i10) {
                    i9 = i10;
                }
                int i11 = i9 + i7;
                while (true) {
                    i = i7;
                    i4 = i8;
                    if (i >= i11) {
                        break;
                    }
                    i7 = i + 1;
                    c = cArr[i];
                    if (c >= 128) {
                        break;
                    }
                    i8 = i4 + 1;
                    bArr[i4] = (byte) c;
                }
            }
            if (c < 2048) {
                int i12 = i4 + 1;
                bArr[i4] = (byte) ((c >> 6) | 192);
                i4 += 2;
                bArr[i12] = (byte) ((c & '?') | 128);
            } else if (c < SURR1_FIRST || c > SURR2_LAST) {
                bArr[i4] = (byte) ((c >> '\f') | JPEG.APP0);
                int i13 = i4 + 2;
                bArr[i4 + 1] = (byte) (((c >> 6) & 63) | 128);
                i4 += 3;
                bArr[i13] = (byte) ((c & '?') | 128);
            } else {
                if (c > SURR1_LAST) {
                    this._outPtr = i4;
                    throwIllegal(c);
                }
                this._surrogate = c;
                if (i7 >= i6) {
                    break;
                }
                i = i7 + 1;
                int iConvertSurrogate = convertSurrogate(cArr[i7]);
                if (iConvertSurrogate > 1114111) {
                    this._outPtr = i4;
                    throwIllegal(iConvertSurrogate);
                }
                bArr[i4] = (byte) ((iConvertSurrogate >> 18) | 240);
                bArr[i4 + 1] = (byte) (((iConvertSurrogate >> 12) & 63) | 128);
                int i14 = i4 + 3;
                bArr[i4 + 2] = (byte) (((iConvertSurrogate >> 6) & 63) | 128);
                i4 += 4;
                bArr[i14] = (byte) ((iConvertSurrogate & 63) | 128);
            }
            i = i7;
        }
        this._outPtr = i4;
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        int i2;
        if (this._surrogate > 0) {
            i = convertSurrogate(i);
        } else if (i >= SURR1_FIRST && i <= SURR2_LAST) {
            if (i > SURR1_LAST) {
                throwIllegal(i);
            }
            this._surrogate = i;
            return;
        }
        int i4 = this._outPtr;
        if (i4 >= this._outBufferEnd) {
            this._out.write(this._outBuffer, 0, i4);
            this._outPtr = 0;
        }
        if (i < 128) {
            byte[] bArr = this._outBuffer;
            int i5 = this._outPtr;
            this._outPtr = i5 + 1;
            bArr[i5] = (byte) i;
            return;
        }
        int i6 = this._outPtr;
        if (i < 2048) {
            byte[] bArr2 = this._outBuffer;
            int i7 = i6 + 1;
            bArr2[i6] = (byte) ((i >> 6) | 192);
            i2 = i6 + 2;
            bArr2[i7] = (byte) ((i & 63) | 128);
        } else if (i <= 65535) {
            byte[] bArr3 = this._outBuffer;
            bArr3[i6] = (byte) ((i >> 12) | JPEG.APP0);
            int i8 = i6 + 2;
            bArr3[i6 + 1] = (byte) (((i >> 6) & 63) | 128);
            i2 = i6 + 3;
            bArr3[i8] = (byte) ((i & 63) | 128);
        } else {
            if (i > 1114111) {
                throwIllegal(i);
            }
            byte[] bArr4 = this._outBuffer;
            bArr4[i6] = (byte) ((i >> 18) | 240);
            bArr4[i6 + 1] = (byte) (((i >> 12) & 63) | 128);
            int i9 = i6 + 3;
            bArr4[i6 + 2] = (byte) (((i >> 6) & 63) | 128);
            i2 = i6 + 4;
            bArr4[i9] = (byte) ((i & 63) | 128);
        }
        this._outPtr = i2;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0029, code lost:
    
        continue;
     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(String str, int i, int i2) throws IOException {
        if (i2 < 2) {
            if (i2 == 1) {
                write(str.charAt(i));
                return;
            }
            return;
        }
        if (this._surrogate > 0) {
            i2--;
            write(convertSurrogate(str.charAt(i)));
            i++;
        }
        int i4 = this._outPtr;
        byte[] bArr = this._outBuffer;
        int i5 = this._outBufferEnd;
        int i6 = i2 + i;
        while (i < i6) {
            if (i4 >= i5) {
                this._out.write(bArr, 0, i4);
                i4 = 0;
            }
            int i7 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                int i8 = i4 + 1;
                bArr[i4] = (byte) cCharAt;
                int i9 = i6 - i7;
                int i10 = i5 - i8;
                if (i9 > i10) {
                    i9 = i10;
                }
                int i11 = i9 + i7;
                while (true) {
                    i = i7;
                    i4 = i8;
                    if (i >= i11) {
                        break;
                    }
                    i7 = i + 1;
                    cCharAt = str.charAt(i);
                    if (cCharAt >= 128) {
                        break;
                    }
                    i8 = i4 + 1;
                    bArr[i4] = (byte) cCharAt;
                }
            }
            if (cCharAt < 2048) {
                int i12 = i4 + 1;
                bArr[i4] = (byte) ((cCharAt >> 6) | 192);
                i4 += 2;
                bArr[i12] = (byte) ((cCharAt & '?') | 128);
            } else if (cCharAt >= SURR1_FIRST && cCharAt <= SURR2_LAST) {
                if (cCharAt > SURR1_LAST) {
                    this._outPtr = i4;
                    throwIllegal(cCharAt);
                }
                this._surrogate = cCharAt;
                if (i7 >= i6) {
                    break;
                }
                i = i7 + 1;
                int iConvertSurrogate = convertSurrogate(str.charAt(i7));
                if (iConvertSurrogate > 1114111) {
                    this._outPtr = i4;
                    throwIllegal(iConvertSurrogate);
                }
                bArr[i4] = (byte) ((iConvertSurrogate >> 18) | 240);
                bArr[i4 + 1] = (byte) (((iConvertSurrogate >> 12) & 63) | 128);
                int i13 = i4 + 3;
                bArr[i4 + 2] = (byte) (((iConvertSurrogate >> 6) & 63) | 128);
                i4 += 4;
                bArr[i13] = (byte) ((iConvertSurrogate & 63) | 128);
            } else {
                bArr[i4] = (byte) ((cCharAt >> '\f') | JPEG.APP0);
                int i14 = i4 + 2;
                bArr[i4 + 1] = (byte) (((cCharAt >> 6) & 63) | 128);
                i4 += 3;
                bArr[i14] = (byte) ((cCharAt & '?') | 128);
            }
            i = i7;
        }
        this._outPtr = i4;
    }
}
