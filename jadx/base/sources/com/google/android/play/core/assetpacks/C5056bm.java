package com.google.android.play.core.assetpacks;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.bm */
/* JADX INFO: loaded from: classes5.dex */
final class C5056bm extends FilterInputStream {

    /* JADX INFO: renamed from: a */
    private final C5101dd f2629a;

    /* JADX INFO: renamed from: b */
    private byte[] f2630b;

    /* JADX INFO: renamed from: c */
    private long f2631c;

    /* JADX INFO: renamed from: d */
    private boolean f2632d;

    /* JADX INFO: renamed from: e */
    private boolean f2633e;

    public C5056bm(InputStream inputStream) {
        super(inputStream);
        this.f2629a = new C5101dd();
        this.f2630b = new byte[4096];
        this.f2632d = false;
        this.f2633e = false;
    }

    /* JADX INFO: renamed from: a */
    private final int m3723a(byte[] bArr, int i, int i2) {
        return Math.max(0, super.read(bArr, i, i2));
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3726b() {
        return this.f2632d;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m3727c() {
        return this.f2633e;
    }

    /* JADX INFO: renamed from: d */
    public final long m3728d() {
        return this.f2631c;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: a */
    public final C5121dx m3725a() {
        byte[] bArr;
        if (this.f2631c > 0) {
            do {
                bArr = this.f2630b;
            } while (read(bArr, 0, bArr.length) != -1);
        }
        if (this.f2632d || this.f2633e) {
            return new C5121dx(null, -1L, -1, false, false, null);
        }
        if (!m3724a(30)) {
            this.f2632d = true;
            return this.f2629a.m3793a();
        }
        C5121dx c5121dxM3793a = this.f2629a.m3793a();
        if (c5121dxM3793a.m3833g()) {
            this.f2633e = true;
            return c5121dxM3793a;
        }
        if (c5121dxM3793a.m3830d() == 4294967295L) {
            throw new C5065bv("Files bigger than 4GiB are not supported.");
        }
        int iM3794b = this.f2629a.m3794b() - 30;
        long j = iM3794b;
        int length = this.f2630b.length;
        if (j > length) {
            do {
                length += length;
            } while (length < j);
            this.f2630b = Arrays.copyOf(this.f2630b, length);
        }
        if (!m3724a(iM3794b)) {
            this.f2632d = true;
            return this.f2629a.m3793a();
        }
        C5121dx c5121dxM3793a2 = this.f2629a.m3793a();
        this.f2631c = c5121dxM3793a2.m3830d();
        return c5121dxM3793a2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        long j = this.f2631c;
        if (j <= 0 || this.f2632d) {
            return -1;
        }
        int iM3723a = m3723a(bArr, i, (int) Math.min(j, i2));
        this.f2631c -= (long) iM3723a;
        if (iM3723a != 0) {
            return iM3723a;
        }
        this.f2632d = true;
        return 0;
    }

    /* JADX INFO: renamed from: a */
    private final boolean m3724a(int i) {
        int iM3723a = m3723a(this.f2630b, 0, i);
        if (iM3723a != i) {
            int i2 = i - iM3723a;
            if (m3723a(this.f2630b, iM3723a, i2) != i2) {
                this.f2629a.m3792a(this.f2630b, 0, iM3723a);
                return false;
            }
        }
        this.f2629a.m3792a(this.f2630b, 0, i);
        return true;
    }
}
