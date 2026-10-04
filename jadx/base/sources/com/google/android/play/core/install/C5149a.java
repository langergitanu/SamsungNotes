package com.google.android.play.core.install;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;

/* JADX INFO: renamed from: com.google.android.play.core.install.a */
/* JADX INFO: loaded from: classes5.dex */
final class C5149a extends InstallState {

    /* JADX INFO: renamed from: a */
    private final int f2924a;

    /* JADX INFO: renamed from: b */
    private final long f2925b;

    /* JADX INFO: renamed from: c */
    private final long f2926c;

    /* JADX INFO: renamed from: d */
    private final int f2927d;

    /* JADX INFO: renamed from: e */
    private final String f2928e;

    public C5149a(int i, long j, long j2, int i2, String str) {
        this.f2924a = i;
        this.f2925b = j;
        this.f2926c = j2;
        this.f2927d = i2;
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.f2928e = str;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long bytesDownloaded() {
        return this.f2925b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallState) {
            InstallState installState = (InstallState) obj;
            if (this.f2924a == installState.installStatus() && this.f2925b == installState.bytesDownloaded() && this.f2926c == installState.totalBytesToDownload() && this.f2927d == installState.installErrorCode() && this.f2928e.equals(installState.packageName())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f2924a;
        long j = this.f2925b;
        long j2 = this.f2926c;
        return ((((((((i ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f2927d) * 1000003) ^ this.f2928e.hashCode();
    }

    @Override // com.google.android.play.core.install.InstallState
    @InstallErrorCode
    public final int installErrorCode() {
        return this.f2927d;
    }

    @Override // com.google.android.play.core.install.InstallState
    @InstallStatus
    public final int installStatus() {
        return this.f2924a;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final String packageName() {
        return this.f2928e;
    }

    public final String toString() {
        int i = this.f2924a;
        long j = this.f2925b;
        long j2 = this.f2926c;
        int i2 = this.f2927d;
        String str = this.f2928e;
        StringBuilder sb = new StringBuilder(str.length() + 164);
        AbstractC1974b.m1330w(i, "InstallState{installStatus=", ", bytesDownloaded=", sb);
        sb.append(j);
        AbstractC1038a.m1223x(sb, ", totalBytesToDownload=", j2, ", installErrorCode=");
        sb.append(i2);
        sb.append(", packageName=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long totalBytesToDownload() {
        return this.f2926c;
    }
}
