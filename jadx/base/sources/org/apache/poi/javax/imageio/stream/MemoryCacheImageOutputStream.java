package org.apache.poi.javax.imageio.stream;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MemoryCacheImageOutputStream extends ImageOutputStreamImpl {
    private MemoryCache cache = new MemoryCache();
    private OutputStream stream;

    public MemoryCacheImageOutputStream(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("stream == null!");
        }
        this.stream = outputStream;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        long length = this.cache.getLength();
        seek(length);
        flushBefore(length);
        super.close();
        this.cache.reset();
        this.cache = null;
        this.stream = null;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream, org.apache.poi.javax.imageio.stream.ImageOutputStream
    public void flushBefore(long j) throws IOException {
        long j2 = this.flushedPos;
        super.flushBefore(j);
        this.cache.writeToStream(this.stream, j2, this.flushedPos - j2);
        this.cache.disposeBefore(this.flushedPos);
        this.stream.flush();
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public boolean isCached() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public boolean isCachedFile() {
        return false;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public boolean isCachedMemory() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public long length() {
        try {
            checkClosed();
            return this.cache.getLength();
        } catch (IOException unused) {
            return -1L;
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public int read() throws IOException {
        checkClosed();
        this.bitOffset = 0;
        int i = this.cache.read(this.streamPos);
        if (i != -1) {
            this.streamPos++;
        }
        return i;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStreamImpl, org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void write(int i) throws IOException {
        flushBits();
        this.cache.write(i, this.streamPos);
        this.streamPos++;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStreamImpl, org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) throws IOException {
        flushBits();
        this.cache.write(bArr, i, i2, this.streamPos);
        this.streamPos += (long) i2;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i4;
        checkClosed();
        if (bArr != null) {
            if (i >= 0 && i2 >= 0 && (i4 = i + i2) <= bArr.length && i4 >= 0) {
                this.bitOffset = 0;
                if (i2 == 0) {
                    return 0;
                }
                long length = this.cache.getLength() - this.streamPos;
                if (length <= 0) {
                    return -1;
                }
                int iMin = (int) Math.min(length, i2);
                this.cache.read(bArr, i, iMin, this.streamPos);
                this.streamPos += (long) iMin;
                return iMin;
            }
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off+len > b.length || off+len < 0!");
        }
        throw new NullPointerException("b == null!");
    }
}
