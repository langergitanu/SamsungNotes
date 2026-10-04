package com.samsung.android.sdk.mobileservice.common.result;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CommonResultStatus {
    private String mAgentCode;
    private int mCode;
    private String mDisplayMessage;
    private String mMessage;

    public CommonResultStatus(int i) {
        this.mCode = i;
    }

    public String getAgentCode() {
        return this.mAgentCode;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getDisplayMessage() {
        return this.mDisplayMessage;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public CommonResultStatus(int i, String str, String str2) {
        this.mCode = i;
        this.mMessage = str;
        this.mAgentCode = str2;
    }

    public CommonResultStatus(int i, String str, String str2, String str3) {
        this.mCode = i;
        this.mMessage = str;
        this.mAgentCode = str2;
        this.mDisplayMessage = str3;
    }
}
