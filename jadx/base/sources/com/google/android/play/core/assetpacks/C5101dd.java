package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import java.util.Arrays;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.dd */
/* JADX INFO: loaded from: classes5.dex */
final class C5101dd {

    /* JADX INFO: renamed from: a */
    private byte[] f2799a = new byte[4096];

    /* JADX INFO: renamed from: b */
    private int f2800b;

    /* JADX INFO: renamed from: c */
    private long f2801c;

    /* JADX INFO: renamed from: d */
    private long f2802d;

    /* JADX INFO: renamed from: e */
    private int f2803e;

    /* JADX INFO: renamed from: f */
    private int f2804f;

    /* JADX INFO: renamed from: g */
    private int f2805g;

    /* JADX INFO: renamed from: h */
    private boolean f2806h;

    /* JADX INFO: renamed from: i */
    @Nullable
    private String f2807i;

    public C5101dd() {
        m3795c();
    }

    /* JADX INFO: renamed from: a */
    private final int m3791a(int i, byte[] bArr, int i2, int i4) {
        int i5 = this.f2800b;
        if (i5 >= i) {
            return 0;
        }
        int iMin = Math.min(i4, i - i5);
        System.arraycopy(bArr, i2, this.f2799a, this.f2800b, iMin);
        int i6 = this.f2800b + iMin;
        this.f2800b = i6;
        if (i6 < i) {
            return -1;
        }
        return iMin;
    }

    /* JADX INFO: renamed from: b */
    public final int m3794b() {
        return this.f2804f;
    }

    /* JADX INFO: renamed from: c */
    public final void m3795c() {
        this.f2800b = 0;
        this.f2803e = -1;
        this.f2801c = -1L;
        this.f2806h = false;
        this.f2804f = 30;
        this.f2802d = -1L;
        this.f2805g = -1;
        this.f2807i = null;
    }

    /* JADX INFO: renamed from: a */
    public final int m3792a(byte[] bArr, int i, int i2) {
        int iM3791a = m3791a(30, bArr, i, i2);
        if (iM3791a == -1) {
            return -1;
        }
        if (this.f2801c == -1) {
            long jM3786b = C5099db.m3786b(this.f2799a, 0);
            this.f2801c = jM3786b;
            if (jM3786b == InternalZipConstants.LOCSIG) {
                this.f2806h = false;
                this.f2802d = C5099db.m3786b(this.f2799a, 18);
                this.f2805g = C5099db.m3788c(this.f2799a, 8);
                this.f2803e = C5099db.m3788c(this.f2799a, 26);
                int iM3788c = this.f2803e + 30 + C5099db.m3788c(this.f2799a, 28);
                this.f2804f = iM3788c;
                int length = this.f2799a.length;
                if (length < iM3788c) {
                    do {
                        length += length;
                    } while (length < iM3788c);
                    this.f2799a = Arrays.copyOf(this.f2799a, length);
                }
            } else {
                this.f2806h = true;
            }
        }
        int iM3791a2 = m3791a(this.f2804f, bArr, i + iM3791a, i2 - iM3791a);
        if (iM3791a2 == -1) {
            return -1;
        }
        int i4 = iM3791a + iM3791a2;
        if (!this.f2806h && this.f2807i == null) {
            this.f2807i = new String(this.f2799a, 30, this.f2803e);
        }
        return i4;
    }

    /* JADX INFO: renamed from: a */
    public final C5121dx m3793a() {
        int i = this.f2800b;
        int i2 = this.f2804f;
        if (i < i2) {
            return C5121dx.m3826a(this.f2807i, this.f2802d, this.f2805g, true, Arrays.copyOf(this.f2799a, i), this.f2806h);
        }
        C5121dx c5121dxM3826a = C5121dx.m3826a(this.f2807i, this.f2802d, this.f2805g, false, Arrays.copyOf(this.f2799a, i2), this.f2806h);
        m3795c();
        return c5121dxM3826a;
    }
}
