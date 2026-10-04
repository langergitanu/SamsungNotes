package com.samsung.android.sdk.mobileservice.social.share;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class WebLink {
    private long createdTime;
    private String creator;
    private long expiredTime;
    private String url;

    public WebLink(String str, String str2, long j, long j2) {
        this.url = str;
        this.creator = str2;
        this.createdTime = j;
        this.expiredTime = j2;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public String getCreator() {
        return this.creator;
    }

    public long getExpiredTime() {
        return this.expiredTime;
    }

    public String getUrl() {
        return this.url;
    }
}
