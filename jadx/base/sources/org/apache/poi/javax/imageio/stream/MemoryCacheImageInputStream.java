package org.apache.poi.javax.imageio.stream;

import com.sun.imageio.stream.StreamFinalizer;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.sun.java2d.Disposer;
import org.apache.poi.sun.java2d.DisposerRecord;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MemoryCacheImageInputStream extends ImageInputStreamImpl {
    private MemoryCache cache;
    private final DisposerRecord disposerRecord;
    private final Object disposerReferent;
    private InputStream stream;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StreamDisposerRecord implements DisposerRecord {
        private MemoryCache cache;

        public StreamDisposerRecord(MemoryCache memoryCache) {
            this.cache = memoryCache;
        }

        @Override // org.apache.poi.sun.java2d.DisposerRecord
        public synchronized void dispose() {
            MemoryCache memoryCache = this.cache;
            if (memoryCache != null) {
                memoryCache.reset();
                this.cache = null;
            }
        }
    }

    public MemoryCacheImageInputStream(InputStream inputStream) {
        MemoryCache memoryCache = new MemoryCache();
        this.cache = memoryCache;
        if (inputStream == null) {
            throw new IllegalArgumentException("stream == null!");
        }
        this.stream = inputStream;
        StreamDisposerRecord streamDisposerRecord = new StreamDisposerRecord(memoryCache);
        this.disposerRecord = streamDisposerRecord;
        if (getClass() != MemoryCacheImageInputStream.class) {
            this.disposerReferent = new StreamFinalizer(this);
            return;
        }
        Object obj = new Object();
        this.disposerReferent = obj;
        Disposer.addRecord(obj, streamDisposerRecord);
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.disposerRecord.dispose();
        this.stream = null;
        this.cache = null;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream, org.apache.poi.javax.imageio.stream.ImageOutputStream
    public void flushBefore(long j) throws IOException {
        super.flushBefore(j);
        this.cache.disposeBefore(j);
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
    public int read() throws IOException {
        checkClosed();
        this.bitOffset = 0;
        long jLoadFromStream = this.cache.loadFromStream(this.stream, this.streamPos + 1);
        long j = this.streamPos;
        if (jLoadFromStream < j + 1) {
            return -1;
        }
        MemoryCache memoryCache = this.cache;
        this.streamPos = 1 + j;
        return memoryCache.read(j);
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
                long jLoadFromStream = this.cache.loadFromStream(this.stream, this.streamPos + ((long) i2));
                long j = this.streamPos;
                int i5 = (int) (jLoadFromStream - j);
                if (i5 <= 0) {
                    return -1;
                }
                this.cache.read(bArr, i, i5, j);
                this.streamPos += (long) i5;
                return i5;
            }
            throw new IndexOutOfBoundsException("off < 0 || len < 0 || off+len > b.length || off+len < 0!");
        }
        throw new NullPointerException("b == null!");
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl
    public void finalize() {
    }
}
