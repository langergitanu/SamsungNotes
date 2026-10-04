package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import java.io.ByteArrayInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class TestableByteArrayInputStream extends ByteArrayInputStream {
    private boolean closed;

    public TestableByteArrayInputStream(byte[] bArr) {
        super(bArr);
    }

    @Override // java.io.ByteArrayInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    public final byte[] getBuffer() {
        return ((ByteArrayInputStream) this).buf;
    }

    public final boolean isClosed() {
        return this.closed;
    }

    public TestableByteArrayInputStream(byte[] bArr, int i, int i2) {
        super(bArr);
    }
}
