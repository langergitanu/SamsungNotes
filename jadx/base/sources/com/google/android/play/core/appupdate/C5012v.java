package com.google.android.play.core.appupdate;

import com.google.android.play.core.install.model.AppUpdateType;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.v */
/* JADX INFO: loaded from: classes5.dex */
final class C5012v extends AppUpdateOptions {

    /* JADX INFO: renamed from: a */
    private final int f2488a;

    /* JADX INFO: renamed from: b */
    private final boolean f2489b;

    public /* synthetic */ C5012v(int i, boolean z) {
        this.f2488a = i;
        this.f2489b = z;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions
    public final boolean allowAssetPackDeletion() {
        return this.f2489b;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions
    @AppUpdateType
    public final int appUpdateType() {
        return this.f2488a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateOptions) {
            AppUpdateOptions appUpdateOptions = (AppUpdateOptions) obj;
            if (this.f2488a == appUpdateOptions.appUpdateType() && this.f2489b == appUpdateOptions.allowAssetPackDeletion()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f2488a ^ 1000003) * 1000003) ^ (true != this.f2489b ? 1237 : 1231);
    }

    public final String toString() {
        int i = this.f2488a;
        boolean z = this.f2489b;
        StringBuilder sb = new StringBuilder(73);
        sb.append("AppUpdateOptions{appUpdateType=");
        sb.append(i);
        sb.append(", allowAssetPackDeletion=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
