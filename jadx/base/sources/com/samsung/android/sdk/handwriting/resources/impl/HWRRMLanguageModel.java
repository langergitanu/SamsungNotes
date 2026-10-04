package com.samsung.android.sdk.handwriting.resources.impl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HWRRMLanguageModel {
    private final String mLatest;
    private final String mName;
    private final String mPreloaded;
    private final HWRVersion mVersion;

    public HWRRMLanguageModel(String str, HWRVersion hWRVersion) {
        this.mName = str;
        this.mVersion = hWRVersion;
        this.mPreloaded = "false";
        this.mLatest = "false";
    }

    public String getName() {
        return this.mName;
    }

    public HWRVersion getVersion() {
        return this.mVersion;
    }

    public boolean isLatest() {
        return "true".equals(this.mLatest);
    }

    public boolean isPreloaded() {
        return "true".equals(this.mPreloaded);
    }

    public HWRRMLanguageModel(String str, HWRVersion hWRVersion, String str2) {
        this.mName = str;
        this.mVersion = hWRVersion;
        this.mPreloaded = str2;
        this.mLatest = "false";
    }

    public HWRRMLanguageModel(String str, HWRVersion hWRVersion, String str2, String str3) {
        this.mName = str;
        this.mVersion = hWRVersion;
        this.mPreloaded = str2;
        this.mLatest = str3;
    }
}
