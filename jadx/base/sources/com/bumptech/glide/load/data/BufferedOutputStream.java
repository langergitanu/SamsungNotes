package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class BufferedOutputStream extends OutputStream {
    private ArrayPool arrayPool;
    private byte[] buffer;
    private int index;

    @NonNull
    private final OutputStream out;

    public BufferedOutputStream(@NonNull OutputStream outputStream, @NonNull ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    private void flushBuffer() throws IOException {
        int i = this.index;
        if (i > 0) {
            this.out.write(this.buffer, 0, i);
            this.index = 0;
        }
    }

    private void maybeFlushBuffer() throws IOException {
        if (this.index == this.buffer.length) {
            flushBuffer();
        }
    }

    private void release() {
        byte[] bArr = this.buffer;
        if (bArr != null) {
            this.arrayPool.put(bArr);
            this.buffer = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.out.close();
            release();
        } catch (Throwable th) {
            this.out.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flushBuffer();
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.buffer;
        int i2 = this.index;
        this.index = i2 + 1;
        bArr[i2] = (byte) i;
        maybeFlushBuffer();
    }

    @VisibleForTesting
    public BufferedOutputStream(@NonNull OutputStream outputStream, ArrayPool arrayPool, int i) {
        this.out = outputStream;
        this.arrayPool = arrayPool;
        this.buffer = (byte[]) arrayPool.get(i, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i4 = 0;
        do {
            int i5 = i2 - i4;
            int i6 = i + i4;
            int i7 = this.index;
            if (i7 == 0 && i5 >= this.buffer.length) {
                this.out.write(bArr, i6, i5);
                return;
            }
            int iMin = Math.min(i5, this.buffer.length - i7);
            System.arraycopy(bArr, i6, this.buffer, this.index, iMin);
            this.index += iMin;
            i4 += iMin;
            maybeFlushBuffer();
        } while (i4 < i2);
    }
}
