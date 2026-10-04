package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.dc */
/* JADX INFO: loaded from: classes5.dex */
public final class C5100dc extends InputStream {

    /* JADX INFO: renamed from: a */
    private final Enumeration<File> f2797a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private InputStream f2798b;

    public C5100dc(Enumeration<File> enumeration) throws IOException {
        this.f2797a = enumeration;
        m3790a();
    }

    /* JADX INFO: renamed from: a */
    public final void m3790a() throws IOException {
        InputStream inputStream = this.f2798b;
        if (inputStream != null) {
            inputStream.close();
        }
        this.f2798b = this.f2797a.hasMoreElements() ? new FileInputStream(this.f2797a.nextElement()) : null;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        InputStream inputStream = this.f2798b;
        if (inputStream != null) {
            inputStream.close();
            this.f2798b = null;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f2798b;
            if (inputStream == null) {
                return -1;
            }
            int i = inputStream.read();
            if (i != -1) {
                return i;
            }
            m3790a();
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f2798b == null) {
            return -1;
        }
        bArr.getClass();
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        do {
            int i4 = this.f2798b.read(bArr, i, i2);
            if (i4 > 0) {
                return i4;
            }
            m3790a();
        } while (this.f2798b != null);
        return -1;
    }
}
