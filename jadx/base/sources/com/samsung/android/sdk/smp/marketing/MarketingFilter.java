package com.samsung.android.sdk.smp.marketing;

import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MarketingFilter {
    private int mInstallCount;
    private JSONArray mInstallPkg;
    private int mNotInstallCount;
    private JSONArray mNotInstallPkg;

    public int getInstallCount() {
        return this.mInstallCount;
    }

    public JSONArray getInstallPkg() {
        return this.mInstallPkg;
    }

    public int getNotInstallCount() {
        return this.mNotInstallCount;
    }

    public JSONArray getNotInstallPkg() {
        return this.mNotInstallPkg;
    }

    public void setInstallCount(int i) {
        this.mInstallCount = i;
    }

    public void setInstallPkg(JSONArray jSONArray) {
        this.mInstallPkg = jSONArray;
    }

    public void setNotInstallCount(int i) {
        this.mNotInstallCount = i;
    }

    public void setNotInstallPkg(JSONArray jSONArray) {
        this.mNotInstallPkg = jSONArray;
    }
}
