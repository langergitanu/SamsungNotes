package org.apache.http.impl.conn;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
class LoggingOutputStream extends OutputStream {
    private final OutputStream out;
    private final WireHC4 wire;

    public LoggingOutputStream(OutputStream outputStream, WireHC4 wireHC4) {
        this.out = outputStream;
        this.wire = wireHC4;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.out.close();
        } catch (IOException e) {
            this.wire.output("[close] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            this.out.flush();
        } catch (IOException e) {
            this.wire.output("[flush] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        try {
            this.wire.output(i);
        } catch (IOException e) {
            this.wire.output("[write] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        try {
            this.wire.output(bArr);
            this.out.write(bArr);
        } catch (IOException e) {
            this.wire.output("[write] I/O error: " + e.getMessage());
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.wire.output(bArr, i, i2);
            this.out.write(bArr, i, i2);
        } catch (IOException e) {
            this.wire.output("[write] I/O error: " + e.getMessage());
            throw e;
        }
    }
}
