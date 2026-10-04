package org.apache.http.impl.p224io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.ConnectionClosedException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.p225io.BufferInfo;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class ContentLengthInputStreamHC4 extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private final long contentLength;

    /* JADX INFO: renamed from: in */
    private SessionInputBuffer f10028in;
    private long pos = 0;
    private boolean closed = false;

    public ContentLengthInputStreamHC4(SessionInputBuffer sessionInputBuffer, long j) {
        this.f10028in = null;
        this.f10028in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.contentLength = Args.notNegative(j, "Content length");
    }

    @Override // java.io.InputStream
    public int available() {
        SessionInputBuffer sessionInputBuffer = this.f10028in;
        if (sessionInputBuffer instanceof BufferInfo) {
            return Math.min(((BufferInfo) sessionInputBuffer).length(), (int) (this.contentLength - this.pos));
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        try {
            if (this.pos < this.contentLength) {
                do {
                } while (read(new byte[2048]) >= 0);
            }
        } finally {
            this.closed = true;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        }
        if (this.pos >= this.contentLength) {
            return -1;
        }
        int i = this.f10028in.read();
        if (i != -1) {
            this.pos++;
            return i;
        }
        if (this.pos >= this.contentLength) {
            return i;
        }
        throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: " + this.contentLength + "; received: " + this.pos);
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        int i;
        if (j <= 0) {
            return 0L;
        }
        byte[] bArr = new byte[2048];
        long jMin = Math.min(j, this.contentLength - this.pos);
        long j2 = 0;
        while (jMin > 0 && (i = read(bArr, 0, (int) Math.min(2048L, jMin))) != -1) {
            long j3 = i;
            j2 += j3;
            jMin -= j3;
        }
        return j2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.closed) {
            long j = this.pos;
            long j2 = this.contentLength;
            if (j >= j2) {
                return -1;
            }
            if (((long) i2) + j > j2) {
                i2 = (int) (j2 - j);
            }
            int i4 = this.f10028in.read(bArr, i, i2);
            if (i4 != -1 || this.pos >= this.contentLength) {
                if (i4 > 0) {
                    this.pos += (long) i4;
                }
                return i4;
            }
            throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: " + this.contentLength + "; received: " + this.pos);
        }
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }
}
