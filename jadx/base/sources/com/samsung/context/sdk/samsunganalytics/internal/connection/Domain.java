package com.samsung.context.sdk.samsunganalytics.internal.connection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum Domain {
    REGISTRATION("https://regi.di.atlas.samsung.com"),
    POLICY("https://dc.di.atlas.samsung.com"),
    DLS("");

    String domain;

    Domain(String str) {
        this.domain = str;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }
}
