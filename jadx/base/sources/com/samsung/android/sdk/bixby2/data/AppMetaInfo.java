package com.samsung.android.sdk.bixby2.data;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class AppMetaInfo {
    int appVersionCode;
    String capsuleId;

    public AppMetaInfo(String str, int i) {
        this.capsuleId = str;
        this.appVersionCode = i;
    }

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public String getCapsuleId() {
        return this.capsuleId;
    }

    public void setAppVersionCode(int i) {
        this.appVersionCode = i;
    }

    public void setCapsuleId(String str) {
        this.capsuleId = str;
    }
}
