package org.apache.poi.javax.imageio.stream;

import com.sun.imageio.stream.StreamCloser;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FileCacheImageOutputStream extends ImageOutputStreamImpl {
    private RandomAccessFile cache;
    private File cacheFile;
    private final StreamCloser.CloseAction closeAction;
    private long maxStreamPos = 0;
    private OutputStream stream;

    public FileCacheImageOutputStream(OutputStream outputStream, File file) {
        if (outputStream == null) {
            throw new IllegalArgumentException("stream == null!");
        }
        if (file != null && !file.isDirectory()) {
            throw new IllegalArgumentException("Not a directory!");
        }
        this.stream = outputStream;
        if (file == null) {
            this.cacheFile = Files.createTempFile("imageio", DiskFileUpload.postfix, new FileAttribute[0]).toFile();
        } else {
            this.cacheFile = Files.createTempFile(file.toPath(), "imageio", DiskFileUpload.postfix, new FileAttribute[0]).toFile();
        }
        this.cache = new RandomAccessFile(this.cacheFile, InternalZipConstants.WRITE_MODE);
        StreamCloser.CloseAction closeActionCreateCloseAction = StreamCloser.createCloseAction(this);
        this.closeAction = closeActionCreateCloseAction;
        StreamCloser.addToQueue(closeActionCreateCloseAction);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        long length = this.cache.length();
        this.maxStreamPos = length;
        seek(length);
        flushBefore(this.maxStreamPos);
        super.close();
        this.cache.close();
        this.cache = null;
        this.cacheFile.delete();
        this.cacheFile = null;
        this.stream.flush();
        this.stream = null;
        StreamCloser.removeFromQueue(this.closeAction);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream, org.apache.poi.javax.imageio.stream.ImageOutputStream
    public void flushBefore(long j) throws IOException {
        long j2 = this.flushedPos;
        super.flushBefore(j);
        long j3 = this.flushedPos - j2;
        if (j3 > 0) {
            byte[] bArr = new byte[512];
            this.cache.seek(j2);
            while (j3 > 0) {
                int iMin = (int) Math.min(j3, 512);
                this.cache.readFully(bArr, 0, iMin);
                this.stream.write(bArr, 0, iMin);
                j3 -= (long) iMin;
            }
            this.stream.flush();
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public boolean isCached() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public boolean isCachedFile() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public boolean isCachedMemory() {
        return false;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public long length() {
        try {
            checkClosed();
            return this.cache.length();
        } catch (IOException unused) {
            return -1L;
        }
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public int read() throws IOException {
        checkClosed();
        this.bitOffset = 0;
        int i = this.cache.read();
        if (i != -1) {
            this.streamPos++;
        }
        return i;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public void seek(long j) throws IOException {
        checkClosed();
        if (j < this.flushedPos) {
            throw new IndexOutOfBoundsException();
        }
        this.cache.seek(j);
        long filePointer = this.cache.getFilePointer();
        this.streamPos = filePointer;
        this.maxStreamPos = Math.max(this.maxStreamPos, filePointer);
        this.bitOffset = 0;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStreamImpl, org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void write(int i) throws IOException {
        flushBits();
        this.cache.write(i);
        long j = this.streamPos + 1;
        this.streamPos = j;
        this.maxStreamPos = Math.max(this.maxStreamPos, j);
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
                int i5 = this.cache.read(bArr, i, i2);
                if (i5 != -1) {
                    this.streamPos += (long) i5;
                }
                return i5;
            }
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off+len > b.length || off+len < 0!");
        }
        throw new NullPointerException("b == null!");
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageOutputStreamImpl, org.apache.poi.javax.imageio.stream.ImageOutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) throws IOException {
        flushBits();
        this.cache.write(bArr, i, i2);
        long j = this.streamPos + ((long) i2);
        this.streamPos = j;
        this.maxStreamPos = Math.max(this.maxStreamPos, j);
    }
}
