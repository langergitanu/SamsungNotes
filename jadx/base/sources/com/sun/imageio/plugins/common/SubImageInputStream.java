package com.sun.imageio.plugins.common;

import org.apache.poi.javax.imageio.stream.ImageInputStream;
import org.apache.poi.javax.imageio.stream.ImageInputStreamImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class SubImageInputStream extends ImageInputStreamImpl {
    int length;
    int startingLength;
    long startingPos;
    ImageInputStream stream;

    public SubImageInputStream(ImageInputStream imageInputStream, int i) {
        this.stream = imageInputStream;
        this.startingPos = imageInputStream.getStreamPosition();
        this.length = i;
        this.startingLength = i;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl
    public void finalize() {
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public long length() {
        return this.startingLength;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public int read() {
        int i = this.length;
        if (i == 0) {
            return -1;
        }
        this.length = i - 1;
        return this.stream.read();
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public void seek(long j) {
        this.stream.seek(j - this.startingPos);
        this.streamPos = j;
    }

    @Override // org.apache.poi.javax.imageio.stream.ImageInputStreamImpl, org.apache.poi.javax.imageio.stream.ImageInputStream
    public int read(byte[] bArr, int i, int i2) {
        int i4 = this.length;
        if (i4 == 0) {
            return -1;
        }
        int i5 = this.stream.read(bArr, i, Math.min(i2, i4));
        this.length -= i5;
        return i5;
    }
}
