package com.google.android.play.core.assetpacks;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.bd */
/* JADX INFO: loaded from: classes5.dex */
final class C5047bd extends InputStream {

    /* JADX INFO: renamed from: a */
    private final InputStream f2606a;

    /* JADX INFO: renamed from: b */
    private long f2607b;

    public C5047bd(InputStream inputStream, long j) {
        this.f2606a = inputStream;
        this.f2607b = j;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        this.f2606a.close();
        this.f2607b = 0L;
    }

    @Override // java.io.InputStream
    public final int read() {
        long j = this.f2607b;
        if (j <= 0) {
            return -1;
        }
        this.f2607b = j - 1;
        return this.f2606a.read();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f2607b;
        if (j <= 0) {
            return -1;
        }
        int i4 = this.f2606a.read(bArr, i, (int) Math.min(i2, j));
        if (i4 != -1) {
            this.f2607b -= (long) i4;
        }
        return i4;
    }
}
