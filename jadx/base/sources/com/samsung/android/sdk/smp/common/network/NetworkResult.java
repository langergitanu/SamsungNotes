package com.samsung.android.sdk.smp.common.network;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class NetworkResult {
    private final boolean mIsSuccess;
    private final int mResponseCode;
    private final String mResponseMsg;

    public NetworkResult(boolean z, int i) {
        this.mIsSuccess = z;
        this.mResponseCode = i;
        this.mResponseMsg = null;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public String getResponseMsg() {
        return this.mResponseMsg;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public NetworkResult(boolean z, int i, String str) {
        this.mIsSuccess = z;
        this.mResponseCode = i;
        this.mResponseMsg = str;
    }
}
