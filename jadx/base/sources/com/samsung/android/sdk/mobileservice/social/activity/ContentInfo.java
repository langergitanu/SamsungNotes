package com.samsung.android.sdk.mobileservice.social.activity;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContentInfo {
    private Uri mContentUri;
    private String mHash;
    private String mMime;
    private String mName;
    private long mSize;

    public ContentInfo(String str, String str2, long j, String str3, Uri uri) {
        this.mName = str;
        this.mHash = str2;
        this.mSize = j;
        this.mMime = str3;
        this.mContentUri = uri;
    }

    public Uri getContentUri() {
        return this.mContentUri;
    }

    public String getHash() {
        return this.mHash;
    }

    public String getMime() {
        return this.mMime;
    }

    public String getName() {
        return this.mName;
    }

    public long getSize() {
        return this.mSize;
    }
}
