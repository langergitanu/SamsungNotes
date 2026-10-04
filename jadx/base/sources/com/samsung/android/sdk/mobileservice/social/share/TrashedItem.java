package com.samsung.android.sdk.mobileservice.social.share;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class TrashedItem extends SharedItem {
    private long mExpiryAt;

    public TrashedItem(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public long getExpiryAt() {
        return this.mExpiryAt;
    }

    public void setExpiryAt(long j) {
        this.mExpiryAt = j;
    }
}
