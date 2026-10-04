package com.samsung.android.sdk.mobileservice.social.feedback;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ContentId {
    public static final int TYPE_ACTIVITY = 1;
    private int mContentIdType;

    public ContentId(int i) {
        this.mContentIdType = i;
    }

    public int getContentIdType() {
        return this.mContentIdType;
    }

    public abstract Bundle toBundle();
}
