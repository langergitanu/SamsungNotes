package org.apache.http.impl.conn;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
class LoggingInputStream extends InputStream {

    /* JADX INFO: renamed from: in */
    private final InputStream f10024in;
    private final WireHC4 wire;

    public LoggingInputStream(InputStream inputStream, WireHC4 wireHC4) {
        this.f10024in = inputStream;
        this.wire = wireHC4;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.f10024in.available();
        } catch (IOException e) {
            this.wire.input("[available] I/O error : " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.f10024in.close();
        } catch (IOException e) {
            this.wire.input("[close] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        super.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            int i = this.f10024in.read();
            if (i == -1) {
                this.wire.input("end of stream");
                return i;
            }
            this.wire.input(i);
            return i;
        } catch (IOException e) {
            this.wire.input("[read] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        super.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return super.skip(j);
        } catch (IOException e) {
            this.wire.input("[skip] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            int i = this.f10024in.read(bArr);
            if (i == -1) {
                this.wire.input("end of stream");
                return i;
            }
            if (i > 0) {
                this.wire.input(bArr, 0, i);
            }
            return i;
        } catch (IOException e) {
            this.wire.input("[read] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int i4 = this.f10024in.read(bArr, i, i2);
            if (i4 == -1) {
                this.wire.input("end of stream");
                return i4;
            }
            if (i4 > 0) {
                this.wire.input(bArr, i, i4);
            }
            return i4;
        } catch (IOException e) {
            this.wire.input("[read] I/O error: " + e.getMessage());
            throw e;
        }
    }
}
