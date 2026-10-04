package com.nimbusds.jose.util;

import androidx.glance.AbstractC2821a;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BoundedInputStream extends InputStream {

    /* JADX INFO: renamed from: in */
    private final InputStream f3664in;
    private long mark;
    private final long max;
    private long pos;
    private boolean propagateClose;

    public BoundedInputStream(InputStream inputStream, long j) {
        this.pos = 0L;
        this.mark = -1L;
        this.propagateClose = true;
        this.max = j;
        this.f3664in = inputStream;
    }

    @Override // java.io.InputStream
    public int available() {
        long j = this.max;
        if (j < 0 || this.pos < j) {
            return this.f3664in.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.propagateClose) {
            this.f3664in.close();
        }
    }

    public long getLimitBytes() {
        return this.max;
    }

    public boolean isPropagateClose() {
        return this.propagateClose;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.f3664in.mark(i);
        this.mark = this.pos;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f3664in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        long j = this.max;
        if (j >= 0 && this.pos >= j) {
            throw new IOException(AbstractC2821a.m2224o(new StringBuilder("Exceeded configured input limit of "), " bytes", this.max));
        }
        int i = this.f3664in.read();
        this.pos++;
        return i;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f3664in.reset();
        this.pos = this.mark;
    }

    public void setPropagateClose(boolean z) {
        this.propagateClose = z;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long j2 = this.max;
        if (j2 >= 0) {
            j = Math.min(j, j2 - this.pos);
        }
        long jSkip = this.f3664in.skip(j);
        this.pos += jSkip;
        return jSkip;
    }

    public String toString() {
        return this.f3664in.toString();
    }

    public BoundedInputStream(InputStream inputStream) {
        this(inputStream, -1L);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.max;
        if (j >= 0 && this.pos >= j) {
            throw new IOException(AbstractC2821a.m2224o(new StringBuilder("Exceeded configured input limit of "), " bytes", this.max));
        }
        int i4 = this.f3664in.read(bArr, i, i2);
        if (i4 == -1) {
            return -1;
        }
        long j2 = this.pos + ((long) i4);
        this.pos = j2;
        long j3 = this.max;
        if (j3 < 0 || j2 < j3) {
            return i4;
        }
        throw new IOException(AbstractC2821a.m2224o(new StringBuilder("Exceeded configured input limit of "), " bytes", this.max));
    }
}
