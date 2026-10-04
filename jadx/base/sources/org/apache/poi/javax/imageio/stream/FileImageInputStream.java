package org.apache.poi.javax.imageio.stream;

import com.sun.imageio.stream.CloseableDisposerRecord;
import com.sun.imageio.stream.StreamFinalizer;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.poi.sun.java2d.Disposer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FileImageInputStream extends ImageInputStreamImpl {
    private final CloseableDisposerRecord disposerRecord;
    private final Object disposerReferent;
    private RandomAccessFile raf;

    public FileImageInputStream(File file) {
        this(file == null ? null : new RandomAccessFile(file, "r"));
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.disposerRecord.dispose();
        this.raf = null;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public long length() {
        try {
            checkClosed();
            return this.raf.length();
        } catch (IOException unused) {
            return -1L;
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public int read() throws IOException {
        checkClosed();
        this.bitOffset = 0;
        int i = this.raf.read();
        if (i != -1) {
            this.streamPos++;
        }
        return i;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public void seek(long j) throws IOException {
        checkClosed();
        if (j < this.flushedPos) {
            throw new IndexOutOfBoundsException("pos < flushedPos!");
        }
        this.bitOffset = 0;
        this.raf.seek(j);
        this.streamPos = this.raf.getFilePointer();
    }

    public FileImageInputStream(RandomAccessFile randomAccessFile) {
        if (randomAccessFile == null) {
            throw new IllegalArgumentException("raf == null!");
        }
        this.raf = randomAccessFile;
        CloseableDisposerRecord closeableDisposerRecord = new CloseableDisposerRecord(randomAccessFile);
        this.disposerRecord = closeableDisposerRecord;
        if (getClass() != FileImageInputStream.class) {
            this.disposerReferent = new StreamFinalizer(this);
            return;
        }
        Object obj = new Object();
        this.disposerReferent = obj;
        Disposer.addRecord(obj, closeableDisposerRecord);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        checkClosed();
        this.bitOffset = 0;
        int i4 = this.raf.read(bArr, i, i2);
        if (i4 != -1) {
            this.streamPos += (long) i4;
        }
        return i4;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl
    public void finalize() {
    }
}
