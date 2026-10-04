package com.samsung.android.sdk.mobileservice.auth.result;

import com.samsung.android.sdk.mobileservice.auth.AuthInfo;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class AuthInfoResult implements Result {
    private AuthInfo mResult;
    private CommonResultStatus mStatus;

    public AuthInfoResult(CommonResultStatus commonResultStatus, AuthInfo authInfo) {
        this.mStatus = commonResultStatus;
        this.mResult = authInfo;
    }

    public AuthInfo getResult() {
        return this.mResult;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
