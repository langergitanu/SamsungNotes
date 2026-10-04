package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import androidx.compose.foundation.layout.AbstractC1038a;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.dq */
/* JADX INFO: loaded from: classes5.dex */
final class C5114dq {

    /* JADX INFO: renamed from: a */
    private final int f2846a;

    /* JADX INFO: renamed from: b */
    private final String f2847b;

    /* JADX INFO: renamed from: c */
    private final long f2848c;

    /* JADX INFO: renamed from: d */
    private final long f2849d;

    /* JADX INFO: renamed from: e */
    private final int f2850e;

    public C5114dq() {
    }

    /* JADX INFO: renamed from: a */
    public int m3802a() {
        return this.f2846a;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public String m3803b() {
        return this.f2847b;
    }

    /* JADX INFO: renamed from: c */
    public long m3804c() {
        return this.f2848c;
    }

    /* JADX INFO: renamed from: d */
    public long m3805d() {
        return this.f2849d;
    }

    /* JADX INFO: renamed from: e */
    public int m3806e() {
        return this.f2850e;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C5114dq) {
            C5114dq c5114dq = (C5114dq) obj;
            if (this.f2846a == c5114dq.m3802a() && ((str = this.f2847b) != null ? str.equals(c5114dq.m3803b()) : c5114dq.m3803b() == null) && this.f2848c == c5114dq.m3804c() && this.f2849d == c5114dq.m3805d() && this.f2850e == c5114dq.m3806e()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (this.f2846a ^ 1000003) * 1000003;
        String str = this.f2847b;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.f2848c;
        long j2 = this.f2849d;
        return ((((((i ^ iHashCode) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f2850e;
    }

    public String toString() {
        int i = this.f2846a;
        String str = this.f2847b;
        long j = this.f2848c;
        long j2 = this.f2849d;
        int i2 = this.f2850e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 157);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i);
        sb.append(", filePath=");
        sb.append(str);
        AbstractC1038a.m1223x(sb, ", fileOffset=", j, ", remainingBytes=");
        sb.append(j2);
        sb.append(", previousChunk=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }

    public C5114dq(int i, @Nullable String str, long j, long j2, int i2) {
        this();
        this.f2846a = i;
        this.f2847b = str;
        this.f2848c = j;
        this.f2849d = j2;
        this.f2850e = i2;
    }
}
