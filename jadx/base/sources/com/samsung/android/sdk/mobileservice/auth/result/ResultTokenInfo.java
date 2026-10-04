package com.samsung.android.sdk.mobileservice.auth.result;

import com.samsung.android.sdk.mobileservice.auth.TokenInfo;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ResultTokenInfo implements Result {
    private TokenInfo mResult;
    private CommonResultStatus mStatus;

    public ResultTokenInfo(CommonResultStatus commonResultStatus, TokenInfo tokenInfo) {
        this.mStatus = commonResultStatus;
        this.mResult = tokenInfo;
    }

    public TokenInfo getResult() {
        return this.mResult;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
