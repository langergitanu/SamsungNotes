package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.util.Arrays;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.dx */
/* JADX INFO: loaded from: classes5.dex */
final class C5121dx {

    /* JADX INFO: renamed from: a */
    private final String f2868a;

    /* JADX INFO: renamed from: b */
    private final long f2869b;

    /* JADX INFO: renamed from: c */
    private final int f2870c;

    /* JADX INFO: renamed from: d */
    private final boolean f2871d;

    /* JADX INFO: renamed from: e */
    private final boolean f2872e;

    /* JADX INFO: renamed from: f */
    private final byte[] f2873f;

    public C5121dx() {
    }

    /* JADX INFO: renamed from: a */
    public static C5121dx m3826a(@Nullable String str, long j, int i, boolean z, byte[] bArr, boolean z2) {
        return new C5121dx(str, j, i, z, z2, bArr);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3828b() {
        return m3831e() == 0;
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public String m3829c() {
        return this.f2868a;
    }

    /* JADX INFO: renamed from: d */
    public long m3830d() {
        return this.f2869b;
    }

    /* JADX INFO: renamed from: e */
    public int m3831e() {
        return this.f2870c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C5121dx) {
            C5121dx c5121dx = (C5121dx) obj;
            String str = this.f2868a;
            if (str != null ? str.equals(c5121dx.m3829c()) : c5121dx.m3829c() == null) {
                if (this.f2869b == c5121dx.m3830d() && this.f2870c == c5121dx.m3831e() && this.f2871d == c5121dx.m3832f() && this.f2872e == c5121dx.m3833g() && Arrays.equals(this.f2873f, c5121dx.f2873f)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    public boolean m3832f() {
        return this.f2871d;
    }

    /* JADX INFO: renamed from: g */
    public boolean m3833g() {
        return this.f2872e;
    }

    @Nullable
    /* JADX INFO: renamed from: h */
    public byte[] m3834h() {
        return this.f2873f;
    }

    public int hashCode() {
        String str = this.f2868a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.f2869b;
        return ((((((((((iHashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.f2870c) * 1000003) ^ (true != this.f2871d ? 1237 : 1231)) * 1000003) ^ (true != this.f2872e ? 1237 : 1231)) * 1000003) ^ Arrays.hashCode(this.f2873f);
    }

    public String toString() {
        String str = this.f2868a;
        long j = this.f2869b;
        int i = this.f2870c;
        boolean z = this.f2871d;
        boolean z2 = this.f2872e;
        String string = Arrays.toString(this.f2873f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 126 + String.valueOf(string).length());
        AbstractC1974b.m1332y(sb, "ZipEntry{name=", str, ", size=");
        sb.append(j);
        sb.append(", compressionMethod=");
        sb.append(i);
        sb.append(", isPartial=");
        sb.append(z);
        sb.append(", isEndOfArchive=");
        sb.append(z2);
        return AbstractC2322a.m1626p(sb, ", headerBytes=", string, "}");
    }

    public C5121dx(@Nullable String str, long j, int i, boolean z, boolean z2, @Nullable byte[] bArr) {
        this();
        this.f2868a = str;
        this.f2869b = j;
        this.f2870c = i;
        this.f2871d = z;
        this.f2872e = z2;
        this.f2873f = bArr;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3827a() {
        if (m3829c() == null) {
            return false;
        }
        return m3829c().endsWith("/");
    }
}
