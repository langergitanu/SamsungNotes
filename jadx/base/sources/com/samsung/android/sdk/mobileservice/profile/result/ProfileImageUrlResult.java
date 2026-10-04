package com.samsung.android.sdk.mobileservice.profile.result;

import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ProfileImageUrlResult implements Result {
    private String mProfileImageUrl;
    private CommonResultStatus mStatus;

    public ProfileImageUrlResult(CommonResultStatus commonResultStatus, String str) {
        this.mStatus = commonResultStatus;
        this.mProfileImageUrl = str;
    }

    public String getResult() {
        return this.mProfileImageUrl;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
