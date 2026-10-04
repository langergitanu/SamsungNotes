package com.samsung.android.app.notes.sync.network.networkutils;

import java.io.IOException;
import java.io.OutputStream;
import p086V.C0322h;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.networkutils.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6856g extends OutputStream {

    /* JADX INFO: renamed from: a */
    public Object f4285a;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        C0322h.m670a().f817c.close(this.f4285a);
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        C0322h.m670a().f817c.write(this.f4285a, bArr, bArr.length);
    }
}
