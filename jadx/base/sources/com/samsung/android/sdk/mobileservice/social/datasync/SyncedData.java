package com.samsung.android.sdk.mobileservice.social.datasync;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SyncedData {
    private final String TIMESTAMP = "timestamp";
    private final IData mData;
    private final long mTimestamp;

    public SyncedData(String str, Bundle bundle) {
        if (TextUtils.equals(str, ProfileCard.SYNC_SERVICE_NAME)) {
            this.mData = new ProfileCard(bundle);
        } else if (TextUtils.equals(str, GallerySetting.SYNC_SERVICE_NAME)) {
            this.mData = new GallerySetting(bundle);
        } else if (TextUtils.equals(str, GallerySpace.SYNC_SERVICE_NAME)) {
            this.mData = new GallerySpace(bundle);
        } else if (TextUtils.equals(str, ReminderSpace.SYNC_SERVICE_NAME)) {
            this.mData = new ReminderSpace(bundle);
        } else {
            this.mData = null;
        }
        this.mTimestamp = bundle.getLong("timestamp");
    }

    public IData getData() {
        return this.mData;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }
}
