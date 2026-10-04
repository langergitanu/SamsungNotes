package com.google.common.p130io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
final class MultiInputStream extends InputStream {

    /* JADX INFO: renamed from: in */
    @CheckForNull
    private InputStream f3406in;

    /* JADX INFO: renamed from: it */
    private Iterator<? extends ByteSource> f3407it;

    public MultiInputStream(Iterator<? extends ByteSource> it) {
        this.f3407it = (Iterator) Preconditions.checkNotNull(it);
        advance();
    }

    private void advance() {
        close();
        if (this.f3407it.hasNext()) {
            this.f3406in = this.f3407it.next().openStream();
        }
    }

    @Override // java.io.InputStream
    public int available() {
        InputStream inputStream = this.f3406in;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream inputStream = this.f3406in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f3406in = null;
            }
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f3406in;
            if (inputStream == null) {
                return -1;
            }
            int i = inputStream.read();
            if (i != -1) {
                return i;
            }
            advance();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InputStream inputStream = this.f3406in;
        if (inputStream == null || j <= 0) {
            return 0L;
        }
        long jSkip = inputStream.skip(j);
        if (jSkip != 0) {
            return jSkip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.f3406in.skip(j - 1) + 1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        Preconditions.checkNotNull(bArr);
        while (true) {
            InputStream inputStream = this.f3406in;
            if (inputStream == null) {
                return -1;
            }
            int i4 = inputStream.read(bArr, i, i2);
            if (i4 != -1) {
                return i4;
            }
            advance();
        }
    }
}
