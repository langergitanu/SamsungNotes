package com.samsung.android.sdk.mobileservice.social.share.result;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class OriginalFile {
    private final Uri mContentUri;
    private final String mFilePath;
    private final String mHash;

    public OriginalFile(String str, String str2, Uri uri) {
        this.mHash = str;
        this.mFilePath = str2;
        this.mContentUri = uri;
    }

    public Uri getContentUri() {
        return this.mContentUri;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public String getHash() {
        return this.mHash;
    }
}
