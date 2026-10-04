package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class TestableByteArrayOutputStream extends ByteArrayOutputStream {
    private boolean closed;

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    public final byte[] getBuffer() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public final boolean isClosed() {
        return this.closed;
    }
}
