package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.a */
/* JADX INFO: loaded from: classes5.dex */
final class C5273a extends SplitInstallSessionState {

    /* JADX INFO: renamed from: a */
    private final int f3064a;

    /* JADX INFO: renamed from: b */
    private final int f3065b;

    /* JADX INFO: renamed from: c */
    private final int f3066c;

    /* JADX INFO: renamed from: d */
    private final long f3067d;

    /* JADX INFO: renamed from: e */
    private final long f3068e;

    /* JADX INFO: renamed from: f */
    private final List<String> f3069f;

    /* JADX INFO: renamed from: g */
    private final List<String> f3070g;

    /* JADX INFO: renamed from: h */
    private final PendingIntent f3071h;

    /* JADX INFO: renamed from: i */
    private final List<Intent> f3072i;

    public C5273a(int i, int i2, int i4, long j, long j2, @Nullable List<String> list, @Nullable List<String> list2, @Nullable PendingIntent pendingIntent, @Nullable List<Intent> list3) {
        this.f3064a = i;
        this.f3065b = i2;
        this.f3066c = i4;
        this.f3067d = j;
        this.f3068e = j2;
        this.f3069f = list;
        this.f3070g = list2;
        this.f3071h = pendingIntent;
        this.f3072i = list3;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    @Nullable
    /* JADX INFO: renamed from: a */
    public final List<String> mo4104a() {
        return this.f3069f;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    @Nullable
    /* JADX INFO: renamed from: b */
    public final List<String> mo4105b() {
        return this.f3070g;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final long bytesDownloaded() {
        return this.f3067d;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    @Nullable
    /* JADX INFO: renamed from: c */
    public final List<Intent> mo4106c() {
        return this.f3072i;
    }

    public final boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        PendingIntent pendingIntent;
        if (obj == this) {
            return true;
        }
        if (obj instanceof SplitInstallSessionState) {
            SplitInstallSessionState splitInstallSessionState = (SplitInstallSessionState) obj;
            if (this.f3064a == splitInstallSessionState.sessionId() && this.f3065b == splitInstallSessionState.status() && this.f3066c == splitInstallSessionState.errorCode() && this.f3067d == splitInstallSessionState.bytesDownloaded() && this.f3068e == splitInstallSessionState.totalBytesToDownload() && ((list = this.f3069f) != null ? list.equals(splitInstallSessionState.mo4104a()) : splitInstallSessionState.mo4104a() == null) && ((list2 = this.f3070g) != null ? list2.equals(splitInstallSessionState.mo4105b()) : splitInstallSessionState.mo4105b() == null) && ((pendingIntent = this.f3071h) != null ? pendingIntent.equals(splitInstallSessionState.resolutionIntent()) : splitInstallSessionState.resolutionIntent() == null)) {
                List<Intent> list3 = this.f3072i;
                List<Intent> listMo4106c = splitInstallSessionState.mo4106c();
                if (list3 != null ? list3.equals(listMo4106c) : listMo4106c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    @SplitInstallErrorCode
    public final int errorCode() {
        return this.f3066c;
    }

    public final int hashCode() {
        int i = this.f3064a;
        int i2 = this.f3065b;
        int i4 = this.f3066c;
        long j = this.f3067d;
        long j2 = this.f3068e;
        int i5 = (((((((((i ^ 1000003) * 1000003) ^ i2) * 1000003) ^ i4) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        List<String> list = this.f3069f;
        int iHashCode = (i5 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<String> list2 = this.f3070g;
        int iHashCode2 = (iHashCode ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        PendingIntent pendingIntent = this.f3071h;
        int iHashCode3 = (iHashCode2 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        List<Intent> list3 = this.f3072i;
        return iHashCode3 ^ (list3 != null ? list3.hashCode() : 0);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    @Nullable
    @Deprecated
    public final PendingIntent resolutionIntent() {
        return this.f3071h;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final int sessionId() {
        return this.f3064a;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    @SplitInstallSessionStatus
    public final int status() {
        return this.f3065b;
    }

    public final String toString() {
        int i = this.f3064a;
        int i2 = this.f3065b;
        int i4 = this.f3066c;
        long j = this.f3067d;
        long j2 = this.f3068e;
        String strValueOf = String.valueOf(this.f3069f);
        String strValueOf2 = String.valueOf(this.f3070g);
        String strValueOf3 = String.valueOf(this.f3071h);
        String strValueOf4 = String.valueOf(this.f3072i);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        StringBuilder sb = new StringBuilder(length + 251 + length2 + strValueOf3.length() + strValueOf4.length());
        AbstractC0622a.m1180z(sb, i, i2, "SplitInstallSessionState{sessionId=", ", status=");
        AbstractC1974b.m1330w(i4, ", errorCode=", ", bytesDownloaded=", sb);
        sb.append(j);
        AbstractC1038a.m1223x(sb, ", totalBytesToDownload=", j2, ", moduleNamesNullable=");
        AbstractC2821a.m2207B(sb, strValueOf, ", languagesNullable=", strValueOf2, ", resolutionIntent=");
        return AbstractC0541b.m776r(sb, strValueOf3, ", splitFileIntents=", strValueOf4, "}");
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final long totalBytesToDownload() {
        return this.f3068e;
    }
}
