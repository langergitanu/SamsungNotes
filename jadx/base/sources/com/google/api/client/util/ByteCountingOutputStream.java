package com.google.api.client.util;

import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class ByteCountingOutputStream extends OutputStream {
    long count;

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.count += (long) i2;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.count++;
    }
}
