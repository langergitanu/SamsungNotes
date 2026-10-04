package com.samsung.android.sdk.mobileservice.social.share;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class GallerySpace extends Space {
    private String mSyncSortValue;

    public GallerySpace(String str, String str2, String str3, Bundle bundle) {
        super(str, str2, str3);
        this.mSyncSortValue = bundle.getString(BundleKey.SYNC_SORT_VALUE);
    }

    public String getSyncSortValue() {
        return this.mSyncSortValue;
    }
}
