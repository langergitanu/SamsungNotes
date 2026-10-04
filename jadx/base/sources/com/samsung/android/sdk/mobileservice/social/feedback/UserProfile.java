package com.samsung.android.sdk.mobileservice.social.feedback;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class UserProfile {
    private String mGuid;
    private Uri mImageContentUri;
    private String mName;

    public UserProfile(String str, String str2, Uri uri) {
        this.mGuid = str;
        this.mName = str2;
        this.mImageContentUri = uri;
    }

    public String getGuid() {
        return this.mGuid;
    }

    public Uri getImageContentUri() {
        return this.mImageContentUri;
    }

    public String getName() {
        return this.mName;
    }

    public UserProfile(String str, Uri uri) {
        this.mGuid = str;
        this.mImageContentUri = uri;
    }
}
