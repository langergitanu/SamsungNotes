package com.samsung.android.app.notes.sync.network.networkutils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import p191j0.C12930p;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.networkutils.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6858i extends InputStream {

    /* JADX INFO: renamed from: a */
    public ByteArrayInputStream f4292a;

    /* JADX INFO: renamed from: b */
    public ByteArrayInputStream f4293b;

    /* JADX INFO: renamed from: c */
    public final int f4294c;

    /* JADX INFO: renamed from: d */
    public byte[] f4295d;

    /* JADX INFO: renamed from: e */
    public final byte[] f4296e;

    /* JADX INFO: renamed from: f */
    public int f4297f = 0;

    public C6858i(byte[] bArr) throws IOException {
        this.f4295d = bArr;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f4295d);
        this.f4292a = byteArrayInputStream;
        int iAvailable = byteArrayInputStream.available();
        this.f4294c = iAvailable;
        this.f4296e = C12930p.f9098Y;
        this.f4294c = iAvailable + 4;
    }

    @Override // java.io.InputStream
    public final int available() {
        ByteArrayInputStream byteArrayInputStream = this.f4293b;
        if (byteArrayInputStream == null) {
            return 0;
        }
        return byteArrayInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f4295d != null) {
            this.f4295d = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f4292a;
        if (byteArrayInputStream != null) {
            byteArrayInputStream.close();
            this.f4292a = null;
        }
        ByteArrayInputStream byteArrayInputStream2 = this.f4293b;
        if (byteArrayInputStream2 != null) {
            byteArrayInputStream2.close();
            this.f4293b = null;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = this.f4293b;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr);
        }
        int i = this.f4297f;
        if (i != 0) {
            this.f4297f = i + bArr.length;
            return this.f4292a.read(bArr);
        }
        byte[] bArr2 = this.f4296e;
        int length = bArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = bArr2[i2];
        }
        this.f4297f = bArr2.length + bArr.length;
        return this.f4292a.read(bArr, bArr2.length, bArr.length - bArr2.length) + bArr2.length;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        int i;
        ByteArrayInputStream byteArrayInputStream = this.f4293b;
        if (byteArrayInputStream == null) {
            int i2 = this.f4297f;
            byte[] bArr = this.f4296e;
            if (i2 < bArr.length) {
                i = bArr[i2];
            } else {
                i = this.f4292a.read();
            }
            this.f4297f++;
            return i;
        }
        return byteArrayInputStream.read();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = this.f4293b;
        if (byteArrayInputStream == null) {
            int i4 = this.f4297f;
            if (i4 == 0) {
                byte[] bArr2 = this.f4296e;
                int length = bArr2.length + i;
                for (int i5 = i; i5 < length; i5++) {
                    bArr[i5] = bArr2[i5 - i];
                }
                this.f4297f = bArr2.length + i2;
                return this.f4292a.read(bArr, bArr2.length, i2 - bArr2.length) + bArr2.length;
            }
            this.f4297f = i4 + i2;
            return this.f4292a.read(bArr, i, i2);
        }
        return byteArrayInputStream.read(bArr, i, i2);
    }
}
