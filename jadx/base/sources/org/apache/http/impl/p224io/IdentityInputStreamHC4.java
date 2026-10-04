package org.apache.http.impl.p224io;

import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.p225io.BufferInfo;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class IdentityInputStreamHC4 extends InputStream {
    private boolean closed = false;

    /* JADX INFO: renamed from: in */
    private final SessionInputBuffer f10029in;

    public IdentityInputStreamHC4(SessionInputBuffer sessionInputBuffer) {
        this.f10029in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
    }

    @Override // java.io.InputStream
    public int available() {
        SessionInputBuffer sessionInputBuffer = this.f10029in;
        if (sessionInputBuffer instanceof BufferInfo) {
            return ((BufferInfo) sessionInputBuffer).length();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.closed) {
            return -1;
        }
        return this.f10029in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this.closed) {
            return -1;
        }
        return this.f10029in.read(bArr, i, i2);
    }
}
