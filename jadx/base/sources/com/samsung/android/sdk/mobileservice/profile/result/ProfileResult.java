package com.samsung.android.sdk.mobileservice.profile.result;

import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;
import com.samsung.android.sdk.mobileservice.profile.Profile;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ProfileResult implements Result {
    private Profile mResult;
    private CommonResultStatus mStatus;

    public ProfileResult(CommonResultStatus commonResultStatus, Profile profile) {
        this.mStatus = commonResultStatus;
        this.mResult = profile;
    }

    public Profile getResult() {
        return this.mResult;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
