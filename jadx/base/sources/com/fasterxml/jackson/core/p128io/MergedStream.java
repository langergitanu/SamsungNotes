package com.fasterxml.jackson.core.p128io;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class MergedStream extends InputStream {
    byte[] _buffer;
    protected final IOContext _context;
    final int _end;
    final InputStream _in;
    int _ptr;

    public MergedStream(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2) {
        this._context = iOContext;
        this._in = inputStream;
        this._buffer = bArr;
        this._ptr = i;
        this._end = i2;
    }

    private void freeMergedBuffer() {
        byte[] bArr = this._buffer;
        if (bArr != null) {
            this._buffer = null;
            IOContext iOContext = this._context;
            if (iOContext != null) {
                iOContext.releaseReadIOBuffer(bArr);
            }
        }
    }

    @Override // java.io.InputStream
    public int available() {
        return this._buffer != null ? this._end - this._ptr : this._in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        freeMergedBuffer();
        this._in.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        if (this._buffer == null) {
            this._in.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this._buffer == null && this._in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = this._buffer;
        if (bArr == null) {
            return this._in.read();
        }
        int i = this._ptr;
        int i2 = i + 1;
        this._ptr = i2;
        int i4 = bArr[i] & 255;
        if (i2 >= this._end) {
            freeMergedBuffer();
        }
        return i4;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        if (this._buffer == null) {
            this._in.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        long j2;
        if (this._buffer != null) {
            int i = this._end;
            int i2 = this._ptr;
            j2 = i - i2;
            if (j2 > j) {
                this._ptr = i2 + ((int) j);
                return j;
            }
            freeMergedBuffer();
            j -= j2;
        } else {
            j2 = 0;
        }
        return j > 0 ? this._in.skip(j) + j2 : j2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this._buffer;
        if (bArr2 != null) {
            int i4 = this._end;
            int i5 = this._ptr;
            int i6 = i4 - i5;
            if (i2 > i6) {
                i2 = i6;
            }
            System.arraycopy(bArr2, i5, bArr, i, i2);
            int i7 = this._ptr + i2;
            this._ptr = i7;
            if (i7 >= this._end) {
                freeMergedBuffer();
            }
            return i2;
        }
        return this._in.read(bArr, i, i2);
    }
}
