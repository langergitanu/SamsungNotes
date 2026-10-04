package com.samsung.android.sdk.mobileservice.common.result;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class StringResult implements Result {
    private String mResult;
    private CommonResultStatus mStatus;

    public StringResult(CommonResultStatus commonResultStatus, String str) {
        this.mStatus = commonResultStatus;
        this.mResult = str;
    }

    public String getResult() {
        return this.mResult;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
