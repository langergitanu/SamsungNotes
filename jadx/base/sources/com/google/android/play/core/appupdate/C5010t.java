package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.t */
/* JADX INFO: loaded from: classes5.dex */
final class C5010t extends AppUpdateInfo {

    /* JADX INFO: renamed from: a */
    private final String f2458a;

    /* JADX INFO: renamed from: b */
    private final int f2459b;

    /* JADX INFO: renamed from: c */
    private final int f2460c;

    /* JADX INFO: renamed from: d */
    private final int f2461d;

    /* JADX INFO: renamed from: e */
    private final Integer f2462e;

    /* JADX INFO: renamed from: f */
    private final int f2463f;

    /* JADX INFO: renamed from: g */
    private final long f2464g;

    /* JADX INFO: renamed from: h */
    private final long f2465h;

    /* JADX INFO: renamed from: i */
    private final long f2466i;

    /* JADX INFO: renamed from: j */
    private final long f2467j;

    /* JADX INFO: renamed from: k */
    private final PendingIntent f2468k;

    /* JADX INFO: renamed from: l */
    private final PendingIntent f2469l;

    /* JADX INFO: renamed from: m */
    private final PendingIntent f2470m;

    /* JADX INFO: renamed from: n */
    private final PendingIntent f2471n;

    public C5010t(String str, int i, int i2, int i4, @Nullable Integer num, int i5, long j, long j2, long j3, long j5, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable PendingIntent pendingIntent3, @Nullable PendingIntent pendingIntent4) {
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.f2458a = str;
        this.f2459b = i;
        this.f2460c = i2;
        this.f2461d = i4;
        this.f2462e = num;
        this.f2463f = i5;
        this.f2464g = j;
        this.f2465h = j2;
        this.f2466i = j3;
        this.f2467j = j5;
        this.f2468k = pendingIntent;
        this.f2469l = pendingIntent2;
        this.f2470m = pendingIntent3;
        this.f2471n = pendingIntent4;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    /* JADX INFO: renamed from: a */
    public final long mo3583a() {
        return this.f2466i;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final int availableVersionCode() {
        return this.f2459b;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    /* JADX INFO: renamed from: b */
    public final long mo3585b() {
        return this.f2467j;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final long bytesDownloaded() {
        return this.f2464g;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    @Nullable
    /* JADX INFO: renamed from: c */
    public final PendingIntent mo3586c() {
        return this.f2468k;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    @Nullable
    public final Integer clientVersionStalenessDays() {
        return this.f2462e;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    @Nullable
    /* JADX INFO: renamed from: d */
    public final PendingIntent mo3587d() {
        return this.f2469l;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    @Nullable
    /* JADX INFO: renamed from: e */
    public final PendingIntent mo3588e() {
        return this.f2470m;
    }

    public final boolean equals(Object obj) {
        Integer num;
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        PendingIntent pendingIntent3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateInfo) {
            AppUpdateInfo appUpdateInfo = (AppUpdateInfo) obj;
            if (this.f2458a.equals(appUpdateInfo.packageName()) && this.f2459b == appUpdateInfo.availableVersionCode() && this.f2460c == appUpdateInfo.updateAvailability() && this.f2461d == appUpdateInfo.installStatus() && ((num = this.f2462e) != null ? num.equals(appUpdateInfo.clientVersionStalenessDays()) : appUpdateInfo.clientVersionStalenessDays() == null) && this.f2463f == appUpdateInfo.updatePriority() && this.f2464g == appUpdateInfo.bytesDownloaded() && this.f2465h == appUpdateInfo.totalBytesToDownload() && this.f2466i == appUpdateInfo.mo3583a() && this.f2467j == appUpdateInfo.mo3585b() && ((pendingIntent = this.f2468k) != null ? pendingIntent.equals(appUpdateInfo.mo3586c()) : appUpdateInfo.mo3586c() == null) && ((pendingIntent2 = this.f2469l) != null ? pendingIntent2.equals(appUpdateInfo.mo3587d()) : appUpdateInfo.mo3587d() == null) && ((pendingIntent3 = this.f2470m) != null ? pendingIntent3.equals(appUpdateInfo.mo3588e()) : appUpdateInfo.mo3588e() == null)) {
                PendingIntent pendingIntent4 = this.f2471n;
                PendingIntent pendingIntentMo3589f = appUpdateInfo.mo3589f();
                if (pendingIntent4 != null ? pendingIntent4.equals(pendingIntentMo3589f) : pendingIntentMo3589f == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    @Nullable
    /* JADX INFO: renamed from: f */
    public final PendingIntent mo3589f() {
        return this.f2471n;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f2458a.hashCode() ^ 1000003) * 1000003) ^ this.f2459b) * 1000003) ^ this.f2460c) * 1000003) ^ this.f2461d) * 1000003;
        Integer num = this.f2462e;
        int iHashCode2 = num == null ? 0 : num.hashCode();
        int i = this.f2463f;
        long j = this.f2464g;
        long j2 = this.f2465h;
        long j3 = this.f2466i;
        long j5 = this.f2467j;
        int i2 = (((((((((((iHashCode ^ iHashCode2) * 1000003) ^ i) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003;
        PendingIntent pendingIntent = this.f2468k;
        int iHashCode3 = (i2 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        PendingIntent pendingIntent2 = this.f2469l;
        int iHashCode4 = (iHashCode3 ^ (pendingIntent2 == null ? 0 : pendingIntent2.hashCode())) * 1000003;
        PendingIntent pendingIntent3 = this.f2470m;
        int iHashCode5 = (iHashCode4 ^ (pendingIntent3 == null ? 0 : pendingIntent3.hashCode())) * 1000003;
        PendingIntent pendingIntent4 = this.f2471n;
        return iHashCode5 ^ (pendingIntent4 != null ? pendingIntent4.hashCode() : 0);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    @InstallStatus
    public final int installStatus() {
        return this.f2461d;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    @NonNull
    public final String packageName() {
        return this.f2458a;
    }

    public final String toString() {
        String str = this.f2458a;
        int i = this.f2459b;
        int i2 = this.f2460c;
        int i4 = this.f2461d;
        String strValueOf = String.valueOf(this.f2462e);
        int i5 = this.f2463f;
        long j = this.f2464g;
        long j2 = this.f2465h;
        long j3 = this.f2466i;
        long j5 = this.f2467j;
        String strValueOf2 = String.valueOf(this.f2468k);
        String strValueOf3 = String.valueOf(this.f2469l);
        String strValueOf4 = String.valueOf(this.f2470m);
        String strValueOf5 = String.valueOf(this.f2471n);
        int length = str.length();
        int length2 = strValueOf.length();
        int length3 = strValueOf2.length();
        int length4 = strValueOf3.length();
        StringBuilder sb = new StringBuilder(length + 463 + length2 + length3 + length4 + strValueOf4.length() + strValueOf5.length());
        sb.append("AppUpdateInfo{packageName=");
        sb.append(str);
        sb.append(", availableVersionCode=");
        sb.append(i);
        AbstractC0622a.m1180z(sb, i2, i4, ", updateAvailability=", ", installStatus=");
        sb.append(", clientVersionStalenessDays=");
        sb.append(strValueOf);
        sb.append(", updatePriority=");
        sb.append(i5);
        AbstractC1038a.m1223x(sb, ", bytesDownloaded=", j, ", totalBytesToDownload=");
        sb.append(j2);
        AbstractC1038a.m1223x(sb, ", additionalSpaceRequired=", j3, ", assetPackStorageSize=");
        sb.append(j5);
        sb.append(", immediateUpdateIntent=");
        sb.append(strValueOf2);
        AbstractC2821a.m2207B(sb, ", flexibleUpdateIntent=", strValueOf3, ", immediateDestructiveUpdateIntent=", strValueOf4);
        return AbstractC2322a.m1626p(sb, ", flexibleDestructiveUpdateIntent=", strValueOf5, "}");
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final long totalBytesToDownload() {
        return this.f2465h;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    @UpdateAvailability
    public final int updateAvailability() {
        return this.f2460c;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final int updatePriority() {
        return this.f2463f;
    }
}
