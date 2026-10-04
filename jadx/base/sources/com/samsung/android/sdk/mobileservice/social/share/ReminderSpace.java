package com.samsung.android.sdk.mobileservice.social.share;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ReminderSpace extends Space {
    private Integer mSyncColor;
    private Integer mSyncIcon;

    public ReminderSpace(String str, String str2, String str3, Bundle bundle) {
        super(str, str2, str3);
        this.mSyncColor = bundle.containsKey(BundleKey.SYNC_COLOR) ? Integer.valueOf(bundle.getInt(BundleKey.SYNC_COLOR)) : null;
        this.mSyncIcon = bundle.containsKey(BundleKey.SYNC_ICON) ? Integer.valueOf(bundle.getInt(BundleKey.SYNC_ICON)) : null;
    }

    public Integer getSyncColor() {
        return this.mSyncColor;
    }

    public Integer getSyncIcon() {
        return this.mSyncIcon;
    }
}
