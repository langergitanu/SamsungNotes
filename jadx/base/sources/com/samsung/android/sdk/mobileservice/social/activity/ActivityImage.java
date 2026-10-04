package com.samsung.android.sdk.mobileservice.social.activity;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class ActivityImage {
    private String mActivityId;
    private Uri mActivityImageContentUri;
    private String mGuid;
    private Uri mProfileImageContentUri;

    public ActivityImage(String str, String str2, Uri uri, Uri uri2) {
        this.mGuid = str;
        this.mActivityId = str2;
        this.mActivityImageContentUri = uri2;
        this.mProfileImageContentUri = uri;
    }

    public String getActivityId() {
        return this.mActivityId;
    }

    public Uri getActivityImageUri() {
        return this.mActivityImageContentUri;
    }

    public String getGuid() {
        return this.mGuid;
    }

    public Uri getProfileImageUri() {
        return this.mProfileImageContentUri;
    }
}
