package com.samsung.android.sdk.mobileservice.social.group;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class InvitationLink {
    private long createdTime;
    private long expiredTime;
    private String url;

    public InvitationLink(String str, long j, long j2) {
        this.url = str;
        this.createdTime = j;
        this.expiredTime = j2;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public long getExpiredTime() {
        return this.expiredTime;
    }

    public String getUrl() {
        return this.url;
    }
}
