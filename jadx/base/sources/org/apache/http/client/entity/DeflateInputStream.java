package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DeflateInputStream extends InputStream {
    private InputStream sourceStream;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DeflateStream extends InflaterInputStream {
        private boolean closed;

        public DeflateStream(InputStream inputStream, Inflater inflater) {
            super(inputStream, inflater);
            this.closed = false;
        }

        @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ((InflaterInputStream) this).inf.end();
            super.close();
        }
    }

    public DeflateInputStream(InputStream inputStream) throws IOException {
        int iInflate;
        byte[] bArr = new byte[6];
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 6);
        int i = pushbackInputStream.read(bArr);
        if (i == -1) {
            throw new IOException("Unable to read the response");
        }
        byte[] bArr2 = new byte[1];
        Inflater inflater = new Inflater();
        while (true) {
            try {
                iInflate = inflater.inflate(bArr2);
                if (iInflate != 0) {
                    break;
                }
                if (inflater.finished()) {
                    throw new IOException("Unable to read the response");
                }
                if (inflater.needsDictionary()) {
                    break;
                } else if (inflater.needsInput()) {
                    inflater.setInput(bArr);
                }
            } catch (DataFormatException unused) {
                pushbackInputStream.unread(bArr, 0, i);
                this.sourceStream = new DeflateStream(pushbackInputStream, new Inflater(true));
                return;
            } finally {
                inflater.end();
            }
        }
        if (iInflate == -1) {
            throw new IOException("Unable to read the response");
        }
        pushbackInputStream.unread(bArr, 0, i);
        this.sourceStream = new DeflateStream(pushbackInputStream, new Inflater());
    }

    @Override // java.io.InputStream
    public int available() {
        return this.sourceStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.sourceStream.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.sourceStream.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.sourceStream.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        return this.sourceStream.read();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.sourceStream.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.sourceStream.skip(j);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.sourceStream.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return this.sourceStream.read(bArr, i, i2);
    }
}
