package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.AppUpdateOptions;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.u */
/* JADX INFO: loaded from: classes5.dex */
final class C5011u extends AppUpdateOptions.Builder {

    /* JADX INFO: renamed from: a */
    private Integer f2486a;

    /* JADX INFO: renamed from: b */
    private Boolean f2487b;

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions.Builder
    public final AppUpdateOptions build() {
        String strConcat = this.f2486a == null ? "".concat(" appUpdateType") : "";
        if (this.f2487b == null) {
            strConcat = String.valueOf(strConcat).concat(" allowAssetPackDeletion");
        }
        if (strConcat.isEmpty()) {
            return new C5012v(this.f2486a.intValue(), this.f2487b.booleanValue());
        }
        throw new IllegalStateException(strConcat.length() != 0 ? "Missing required properties:".concat(strConcat) : new String("Missing required properties:"));
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions.Builder
    public final AppUpdateOptions.Builder setAllowAssetPackDeletion(boolean z) {
        this.f2487b = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions.Builder
    public final AppUpdateOptions.Builder setAppUpdateType(int i) {
        this.f2486a = Integer.valueOf(i);
        return this;
    }
}
