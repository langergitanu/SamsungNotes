package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class StrictLineReader implements Closeable {

    /* JADX INFO: renamed from: CR */
    private static final byte f1971CR = 13;

    /* JADX INFO: renamed from: LF */
    private static final byte f1972LF = 10;
    private byte[] buf;
    private final Charset charset;
    private int end;

    /* JADX INFO: renamed from: in */
    private final InputStream f1973in;
    private int pos;

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void fillBuf() throws IOException {
        InputStream inputStream = this.f1973in;
        byte[] bArr = this.buf;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.pos = 0;
        this.end = i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f1973in) {
            try {
                if (this.buf != null) {
                    this.buf = null;
                    this.f1973in.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean hasUnterminatedLine() {
        return this.end == -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String readLine() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.f1973in) {
            try {
                if (this.buf == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.pos >= this.end) {
                    fillBuf();
                }
                for (int i4 = this.pos; i4 != this.end; i4++) {
                    byte[] bArr2 = this.buf;
                    if (bArr2[i4] == 10) {
                        int i5 = this.pos;
                        if (i4 != i5) {
                            i2 = i4 - 1;
                            if (bArr2[i2] != 13) {
                                i2 = i4;
                            }
                        }
                        String str = new String(bArr2, i5, i2 - i5, this.charset.name());
                        this.pos = i4 + 1;
                        return str;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.end - this.pos) + 80) { // from class: com.bumptech.glide.disklrucache.StrictLineReader.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i6 = ((ByteArrayOutputStream) this).count;
                        if (i6 > 0 && ((ByteArrayOutputStream) this).buf[i6 - 1] == 13) {
                            i6--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i6, StrictLineReader.this.charset.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.buf;
                    int i6 = this.pos;
                    byteArrayOutputStream.write(bArr3, i6, this.end - i6);
                    this.end = -1;
                    fillBuf();
                    i = this.pos;
                    while (i != this.end) {
                        bArr = this.buf;
                        if (bArr[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                int i7 = this.pos;
                if (i != i7) {
                    byteArrayOutputStream.write(bArr, i7, i - i7);
                }
                this.pos = i + 1;
                return byteArrayOutputStream.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public StrictLineReader(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(Util.US_ASCII)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f1973in = inputStream;
        this.charset = charset;
        this.buf = new byte[i];
    }
}
