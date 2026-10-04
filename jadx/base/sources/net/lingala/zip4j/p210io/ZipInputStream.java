package net.lingala.zip4j.p210io;

import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.exception.ZipException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ZipInputStream extends InputStream {

    /* JADX INFO: renamed from: is */
    private BaseInputStream f9604is;

    public ZipInputStream(BaseInputStream baseInputStream) {
        this.f9604is = baseInputStream;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f9604is.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close(false);
    }

    @Override // java.io.InputStream
    public int read() {
        int i = this.f9604is.read();
        if (i != -1) {
            this.f9604is.getUnzipEngine().updateCRC(i);
        }
        return i;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f9604is.skip(j);
    }

    public void close(boolean z) throws IOException {
        try {
            this.f9604is.close();
            if (z || this.f9604is.getUnzipEngine() == null) {
                return;
            }
            this.f9604is.getUnzipEngine().checkCRC();
        } catch (ZipException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i4 = this.f9604is.read(bArr, i, i2);
        if (i4 > 0 && this.f9604is.getUnzipEngine() != null) {
            this.f9604is.getUnzipEngine().updateCRC(bArr, i, i4);
        }
        return i4;
    }
}
