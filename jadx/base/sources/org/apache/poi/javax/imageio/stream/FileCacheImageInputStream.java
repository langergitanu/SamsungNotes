package org.apache.poi.javax.imageio.stream;

import com.sun.imageio.stream.StreamCloser;
import com.sun.imageio.stream.StreamFinalizer;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.sun.java2d.Disposer;
import org.apache.poi.sun.java2d.DisposerRecord;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FileCacheImageInputStream extends ImageInputStreamImpl {
    private static final int BUFFER_LENGTH = 1024;
    private RandomAccessFile cache;
    private File cacheFile;
    private final StreamCloser.CloseAction closeAction;
    private final DisposerRecord disposerRecord;
    private final Object disposerReferent;
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private long length = 0;
    private boolean foundEOF = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StreamDisposerRecord implements DisposerRecord {
        private RandomAccessFile cache;
        private File cacheFile;

        public StreamDisposerRecord(File file, RandomAccessFile randomAccessFile) {
            this.cacheFile = file;
            this.cache = randomAccessFile;
        }

        @Override // org.apache.poi.sun.java2d.DisposerRecord
        public synchronized void dispose() {
            try {
                RandomAccessFile randomAccessFile = this.cache;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        this.cache = null;
                        throw th;
                    }
                    this.cache = null;
                }
                File file = this.cacheFile;
                if (file != null) {
                    file.delete();
                    this.cacheFile = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public FileCacheImageInputStream(InputStream inputStream, File file) {
        if (inputStream == null) {
            throw new IllegalArgumentException("stream == null!");
        }
        if (file != null && !file.isDirectory()) {
            throw new IllegalArgumentException("Not a directory!");
        }
        this.stream = inputStream;
        if (file == null) {
            this.cacheFile = Files.createTempFile("imageio", DiskFileUpload.postfix, new FileAttribute[0]).toFile();
        } else {
            this.cacheFile = Files.createTempFile(file.toPath(), "imageio", DiskFileUpload.postfix, new FileAttribute[0]).toFile();
        }
        this.cache = new RandomAccessFile(this.cacheFile, InternalZipConstants.WRITE_MODE);
        StreamCloser.CloseAction closeActionCreateCloseAction = StreamCloser.createCloseAction(this);
        this.closeAction = closeActionCreateCloseAction;
        StreamCloser.addToQueue(closeActionCreateCloseAction);
        StreamDisposerRecord streamDisposerRecord = new StreamDisposerRecord(this.cacheFile, this.cache);
        this.disposerRecord = streamDisposerRecord;
        if (getClass() != FileCacheImageInputStream.class) {
            this.disposerReferent = new StreamFinalizer(this);
            return;
        }
        Object obj = new Object();
        this.disposerReferent = obj;
        Disposer.addRecord(obj, streamDisposerRecord);
    }

    private long readUntil(long j) throws IOException {
        long j2 = this.length;
        if (j >= j2) {
            if (this.foundEOF) {
                return j2;
            }
            long j3 = j - j2;
            this.cache.seek(j2);
            while (j3 > 0) {
                int i = this.stream.read(this.buf, 0, (int) Math.min(j3, 1024L));
                if (i == -1) {
                    this.foundEOF = true;
                    return this.length;
                }
                this.cache.write(this.buf, 0, i);
                long j5 = i;
                j3 -= j5;
                this.length += j5;
            }
        }
        return j;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.disposerRecord.dispose();
        this.stream = null;
        this.cache = null;
        this.cacheFile = null;
        StreamCloser.removeFromQueue(this.closeAction);
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
    public int read() throws IOException {
        checkClosed();
        this.bitOffset = 0;
        long j = this.streamPos + 1;
        if (readUntil(j) < j) {
            return -1;
        }
        RandomAccessFile randomAccessFile = this.cache;
        long j2 = this.streamPos;
        this.streamPos = 1 + j2;
        randomAccessFile.seek(j2);
        return this.cache.read();
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
                long j = i2;
                int iMin = (int) Math.min(j, readUntil(this.streamPos + j) - this.streamPos);
                if (iMin <= 0) {
                    return -1;
                }
                this.cache.seek(this.streamPos);
                this.cache.readFully(bArr, i, iMin);
                this.streamPos += (long) iMin;
                return iMin;
            }
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off+len > b.length || off+len < 0!");
        }
        throw new NullPointerException("b == null!");
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl
    public void finalize() {
    }
}
