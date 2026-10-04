package com.samsung.android.sdk.mobileservice.common.result;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class IntResult implements Result {
    private int mResult;
    private CommonResultStatus mStatus;

    public IntResult(CommonResultStatus commonResultStatus, int i) {
        this.mStatus = commonResultStatus;
        this.mResult = i;
    }

    public int getResult() {
        return this.mResult;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
