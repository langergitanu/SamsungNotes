package cz.msebera.android.httpclient.impl.p171io;

import cz.msebera.android.httpclient.p172io.BufferInfo;
import cz.msebera.android.httpclient.p172io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class IdentityInputStream extends InputStream {
    private boolean closed = false;

    /* JADX INFO: renamed from: in */
    private final SessionInputBuffer f8507in;

    public IdentityInputStream(SessionInputBuffer sessionInputBuffer) {
        this.f8507in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
    }

    @Override // java.io.InputStream
    public int available() {
        SessionInputBuffer sessionInputBuffer = this.f8507in;
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
        return this.f8507in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this.closed) {
            return -1;
        }
        return this.f8507in.read(bArr, i, i2);
    }
}
