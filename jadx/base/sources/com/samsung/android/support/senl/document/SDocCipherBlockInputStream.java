package com.samsung.android.support.senl.document;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SDocCipherBlockInputStream extends BufferedInputStream {
    private int mAvailable;
    private int mTotalSize;

    private SDocCipherBlockInputStream() {
        super(null);
        this.mTotalSize = 0;
        this.mAvailable = 0;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int i = this.mTotalSize;
        if (i >= this.mAvailable) {
            return -1;
        }
        this.mTotalSize = i + 1;
        return super.read();
    }

    public SDocCipherBlockInputStream(InputStream inputStream, int i) {
        super(inputStream);
        this.mTotalSize = 0;
        this.mAvailable = (16 - (i % 16)) + i;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i4 = this.mTotalSize;
        int i5 = i4 + i2;
        int i6 = this.mAvailable;
        if (i5 > i6 && (i2 = i6 - i4) <= 0) {
            return -1;
        }
        int i7 = super.read(bArr, i, i2);
        this.mTotalSize += i7;
        return i7;
    }
}
