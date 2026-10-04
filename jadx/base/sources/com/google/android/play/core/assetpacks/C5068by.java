package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.by */
/* JADX INFO: loaded from: classes5.dex */
final class C5068by extends OutputStream {

    /* JADX INFO: renamed from: a */
    private final C5101dd f2701a = new C5101dd();

    /* JADX INFO: renamed from: b */
    private final File f2702b;

    /* JADX INFO: renamed from: c */
    private final C5115dr f2703c;

    /* JADX INFO: renamed from: d */
    private long f2704d;

    /* JADX INFO: renamed from: e */
    private long f2705e;

    /* JADX INFO: renamed from: f */
    private FileOutputStream f2706f;

    /* JADX INFO: renamed from: g */
    private C5121dx f2707g;

    public C5068by(File file, C5115dr c5115dr) {
        this.f2702b = file;
        this.f2703c = c5115dr;
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2;
        int i4;
        while (i2 > 0) {
            if (this.f2704d == 0 && this.f2705e == 0) {
                int iM3792a = this.f2701a.m3792a(bArr, i, i2);
                if (iM3792a == -1) {
                    return;
                }
                i += iM3792a;
                i2 -= iM3792a;
                C5121dx c5121dxM3793a = this.f2701a.m3793a();
                this.f2707g = c5121dxM3793a;
                if (c5121dxM3793a.m3833g()) {
                    this.f2704d = 0L;
                    this.f2703c.m3819b(this.f2707g.m3834h(), this.f2707g.m3834h().length);
                    this.f2705e = this.f2707g.m3834h().length;
                } else if (!this.f2707g.m3828b() || this.f2707g.m3827a()) {
                    byte[] bArrM3834h = this.f2707g.m3834h();
                    this.f2703c.m3819b(bArrM3834h, bArrM3834h.length);
                    this.f2704d = this.f2707g.m3830d();
                } else {
                    this.f2703c.m3814a(this.f2707g.m3834h());
                    File file = new File(this.f2702b, this.f2707g.m3829c());
                    file.getParentFile().mkdirs();
                    this.f2704d = this.f2707g.m3830d();
                    this.f2706f = new FileOutputStream(file);
                }
            }
            int i5 = i;
            int iMin = i2;
            if (this.f2707g.m3827a()) {
                i = i5;
                i2 = iMin;
            } else {
                if (this.f2707g.m3833g()) {
                    bArr2 = bArr;
                    this.f2703c.m3811a(this.f2705e, bArr2, i5, iMin);
                    i4 = iMin;
                    this.f2705e += (long) i4;
                } else {
                    bArr2 = bArr;
                    i4 = iMin;
                    if (this.f2707g.m3828b()) {
                        iMin = (int) Math.min(i4, this.f2704d);
                        this.f2706f.write(bArr2, i5, iMin);
                        long j = this.f2704d - ((long) iMin);
                        this.f2704d = j;
                        if (j == 0) {
                            this.f2706f.close();
                        }
                    } else {
                        iMin = (int) Math.min(i4, this.f2704d);
                        int length = this.f2707g.m3834h().length;
                        this.f2703c.m3811a((((long) length) + this.f2707g.m3830d()) - this.f2704d, bArr2, i5, iMin);
                        this.f2704d -= (long) iMin;
                    }
                }
                i = i5 + iMin;
                i2 = i4 - iMin;
                bArr = bArr2;
            }
        }
    }
}
