package org.apache.poi.javax.imageio.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class MemoryCache {
    private static final int BUFFER_LENGTH = 8192;
    private ArrayList cache = new ArrayList();
    private long cacheStart = 0;
    private long length = 0;

    private byte[] getCacheBlock(long j) throws IOException {
        long j2 = j - this.cacheStart;
        if (j2 <= 2147483647L) {
            return (byte[]) this.cache.get((int) j2);
        }
        throw new IOException("Cache addressing limit exceeded!");
    }

    private void pad(long j) throws IOException {
        long size = (j / 8192) - ((this.cacheStart + ((long) this.cache.size())) - 1);
        for (long j2 = 0; j2 < size; j2++) {
            try {
                this.cache.add(new byte[8192]);
            } catch (OutOfMemoryError unused) {
                throw new IOException("No memory left for cache!");
            }
        }
    }

    public void disposeBefore(long j) {
        long j2 = j / 8192;
        long j3 = this.cacheStart;
        if (j2 < j3) {
            throw new IndexOutOfBoundsException("pos already disposed");
        }
        long jMin = Math.min(j2 - j3, this.cache.size());
        for (long j5 = 0; j5 < jMin; j5++) {
            this.cache.remove(0);
        }
        this.cacheStart = j2;
    }

    public long getLength() {
        return this.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0018, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long loadFromStream(InputStream inputStream, long j) throws IOException {
        byte[] cacheBlock;
        long j2 = this.length;
        if (j >= j2) {
            int i = (int) (j2 % 8192);
            long j3 = j - j2;
            if (i != 0) {
                cacheBlock = getCacheBlock(j2 / 8192);
                while (j3 > 0) {
                    if (cacheBlock == null) {
                        try {
                            cacheBlock = new byte[8192];
                            i = 0;
                        } catch (OutOfMemoryError unused) {
                            throw new IOException("No memory left for cache!");
                        }
                    }
                    int i2 = inputStream.read(cacheBlock, i, (int) Math.min(j3, 8192 - i));
                    if (i2 == -1) {
                        return this.length;
                    }
                    if (i == 0) {
                        this.cache.add(cacheBlock);
                    }
                    long j5 = i2;
                    j3 -= j5;
                    this.length += j5;
                    i += i2;
                    if (i >= 8192) {
                    }
                }
            }
            cacheBlock = null;
        }
        return j;
    }

    public int read(long j) {
        byte[] cacheBlock;
        if (j < this.length && (cacheBlock = getCacheBlock(j / 8192)) != null) {
            return cacheBlock[(int) (j % 8192)] & 255;
        }
        return -1;
    }

    public void reset() {
        this.cache.clear();
        this.cacheStart = 0L;
        this.length = 0L;
    }

    public void write(byte[] bArr, int i, int i2, long j) throws IOException {
        int i4;
        if (bArr == null) {
            throw new NullPointerException("b == null!");
        }
        if (i < 0 || i2 < 0 || j < 0 || (i4 = i + i2) > bArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException();
        }
        long j2 = ((long) i2) + j;
        long j3 = j2 - 1;
        if (j3 >= this.length) {
            pad(j3);
            this.length = j2;
        }
        int i5 = (int) (j % 8192);
        while (i2 > 0) {
            byte[] cacheBlock = getCacheBlock(j / 8192);
            int iMin = Math.min(i2, 8192 - i5);
            System.arraycopy(bArr, i, cacheBlock, i5, iMin);
            j += (long) iMin;
            i += iMin;
            i2 -= iMin;
            i5 = 0;
        }
    }

    public void writeToStream(OutputStream outputStream, long j, long j2) throws IOException {
        if (j + j2 > this.length) {
            throw new IndexOutOfBoundsException("Argument out of cache");
        }
        if (j < 0 || j2 < 0) {
            throw new IndexOutOfBoundsException("Negative pos or len");
        }
        if (j2 == 0) {
            return;
        }
        long j3 = j / 8192;
        if (j3 < this.cacheStart) {
            throw new IndexOutOfBoundsException("pos already disposed");
        }
        int i = (int) (j % 8192);
        long j5 = j3 + 1;
        byte[] cacheBlock = getCacheBlock(j3);
        while (j2 > 0) {
            if (cacheBlock == null) {
                byte[] cacheBlock2 = getCacheBlock(j5);
                j5++;
                cacheBlock = cacheBlock2;
                i = 0;
            }
            int iMin = (int) Math.min(j2, 8192 - i);
            outputStream.write(cacheBlock, i, iMin);
            j2 -= (long) iMin;
            cacheBlock = null;
        }
    }

    public void read(byte[] bArr, int i, int i2, long j) {
        int i4;
        if (bArr != null) {
            if (i < 0 || i2 < 0 || j < 0 || (i4 = i + i2) > bArr.length || i4 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (((long) i2) + j <= this.length) {
                long j2 = j / 8192;
                int i5 = ((int) j) % 8192;
                while (i2 > 0) {
                    int iMin = Math.min(i2, 8192 - i5);
                    System.arraycopy(getCacheBlock(j2), i5, bArr, i, iMin);
                    i2 -= iMin;
                    i += iMin;
                    i5 = 0;
                    j2 = 1 + j2;
                }
                return;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("b == null!");
    }

    public void write(int i, long j) throws IOException {
        if (j >= 0) {
            if (j >= this.length) {
                pad(j);
                this.length = 1 + j;
            }
            getCacheBlock(j / 8192)[(int) (j % 8192)] = (byte) i;
            return;
        }
        throw new ArrayIndexOutOfBoundsException("pos < 0");
    }
}
