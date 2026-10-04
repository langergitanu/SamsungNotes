package com.samsung.android.sdk.mobileservice.social.buddy.result;

import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;
import com.samsung.android.sdk.mobileservice.social.buddy.PublicBuddyInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PublicBuddyInfoResult implements Result {
    private PublicBuddyInfo mResult;
    private CommonResultStatus mStatus;

    public PublicBuddyInfoResult(CommonResultStatus commonResultStatus, PublicBuddyInfo publicBuddyInfo) {
        this.mStatus = commonResultStatus;
        this.mResult = publicBuddyInfo;
    }

    public PublicBuddyInfo getResult() {
        return this.mResult;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
