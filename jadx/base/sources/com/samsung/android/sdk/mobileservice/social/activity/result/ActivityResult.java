package com.samsung.android.sdk.mobileservice.social.activity.result;

import com.samsung.android.sdk.mobileservice.common.result.BaseResult;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ActivityResult<T> implements BaseResult<T> {
    private T mResult;
    private CommonResultStatus mStatus;

    public ActivityResult(CommonResultStatus commonResultStatus, T t) {
        this.mStatus = commonResultStatus;
        this.mResult = t;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.BaseResult
    public T getResult() {
        return this.mResult;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
