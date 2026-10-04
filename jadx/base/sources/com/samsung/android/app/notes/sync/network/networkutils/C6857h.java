package com.samsung.android.app.notes.sync.network.networkutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import p042J1.AbstractC0155m;
import p086V.C0322h;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.networkutils.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6857h extends InputStream {

    /* JADX INFO: renamed from: a */
    public final FileInputStream f4286a;

    /* JADX INFO: renamed from: b */
    public final Object f4287b;

    /* JADX INFO: renamed from: c */
    public final int f4288c;

    /* JADX INFO: renamed from: d */
    public final boolean f4289d;

    /* JADX INFO: renamed from: e */
    public int f4290e = 0;

    /* JADX INFO: renamed from: f */
    public final byte[] f4291f;

    public C6857h(String str, boolean z) {
        this.f4288c = 0;
        this.f4289d = z;
        if (z) {
            Object objCreateSDocCipherInputStream = C0322h.m670a().f825k.createSDocCipherInputStream(str);
            this.f4287b = objCreateSDocCipherInputStream;
            this.f4288c = C0322h.m670a().f825k.getReservedSize(objCreateSDocCipherInputStream);
        } else {
            FileInputStream fileInputStream = new FileInputStream(str);
            this.f4286a = fileInputStream;
            this.f4288c = fileInputStream.available();
        }
        byte[] bArr = new byte[8];
        this.f4291f = bArr;
        if (z) {
            System.arraycopy(AbstractC0155m.f474a, 0, bArr, 0, 8);
        } else {
            System.arraycopy(AbstractC0155m.f475b, 0, bArr, 0, 8);
        }
        this.f4288c += 8;
    }

    @Override // java.io.InputStream
    public final int available() {
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f4289d) {
            C0322h.m670a().f825k.close(this.f4287b);
        } else {
            this.f4286a.close();
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        int i = this.f4290e;
        FileInputStream fileInputStream = this.f4286a;
        Object obj = this.f4287b;
        boolean z = this.f4289d;
        if (i != 0) {
            this.f4290e = i + bArr.length;
            return z ? C0322h.m670a().f825k.read(obj, bArr, bArr.length) : fileInputStream.read(bArr);
        }
        byte[] bArr2 = this.f4291f;
        int length = bArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = bArr2[i2];
        }
        this.f4290e = bArr2.length + bArr.length;
        if (!z) {
            return fileInputStream.read(bArr, bArr2.length, bArr.length - bArr2.length) + bArr2.length;
        }
        int length2 = bArr.length - bArr2.length;
        byte[] bArr3 = new byte[length2];
        int i4 = C0322h.m670a().f825k.read(obj, bArr3, length2);
        if (length2 >= 4) {
            for (int i5 = 0; i5 < 4; i5++) {
                if (AbstractC0155m.f476c[i5] == bArr3[i5]) {
                }
            }
            System.arraycopy(bArr3, 0, bArr, bArr2.length, i4);
            return i4 + bArr2.length;
        }
        throw new RuntimeException("ZipHeaderError");
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        int i;
        int i2 = this.f4290e;
        byte[] bArr = this.f4291f;
        if (i2 < bArr.length) {
            i = bArr[i2];
        } else if (this.f4289d) {
            byte[] bArr2 = new byte[1];
            C0322h.m670a().f825k.read(this.f4287b, bArr2, 1);
            i = bArr2[0];
            int i4 = this.f4290e;
            if (i4 >= bArr.length && i4 < bArr.length + 4) {
                if (AbstractC0155m.f476c[i4 - bArr.length] != ((byte) i)) {
                    throw new IOException("zip header is not found");
                }
            }
        } else {
            i = this.f4286a.read();
        }
        this.f4290e++;
        return i;
    }
}
