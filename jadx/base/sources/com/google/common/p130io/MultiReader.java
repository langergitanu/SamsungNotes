package com.google.common.p130io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
class MultiReader extends Reader {

    @CheckForNull
    private Reader current;

    /* JADX INFO: renamed from: it */
    private final Iterator<? extends CharSource> f3408it;

    public MultiReader(Iterator<? extends CharSource> it) {
        this.f3408it = it;
        advance();
    }

    private void advance() {
        close();
        if (this.f3408it.hasNext()) {
            this.current = this.f3408it.next().openStream();
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Reader reader = this.current;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.current = null;
            }
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        Preconditions.checkNotNull(cArr);
        Reader reader = this.current;
        if (reader == null) {
            return -1;
        }
        int i4 = reader.read(cArr, i, i2);
        if (i4 != -1) {
            return i4;
        }
        advance();
        return read(cArr, i, i2);
    }

    @Override // java.io.Reader
    public boolean ready() {
        Reader reader = this.current;
        return reader != null && reader.ready();
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        Preconditions.checkArgument(j >= 0, "n is negative");
        if (j > 0) {
            while (true) {
                Reader reader = this.current;
                if (reader == null) {
                    break;
                }
                long jSkip = reader.skip(j);
                if (jSkip > 0) {
                    return jSkip;
                }
                advance();
            }
        }
        return 0L;
    }
}
