package com.samsung.android.sdk.mobileservice.social.buddy.request;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class BuddyKey {
    private String mKeyword;

    public BuddyKey(String str) {
        this.mKeyword = str;
    }

    public String getKeyword() {
        return TextUtils.isEmpty(this.mKeyword) ? "" : this.mKeyword;
    }

    public abstract int getType();
}
