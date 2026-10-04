package com.samsung.android.sdk.mobileservice.social.group.result;

import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;
import com.samsung.android.sdk.mobileservice.social.group.InvitationLink;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class InvitationLinkResult implements Result {
    private InvitationLink mInvitationLink;
    private CommonResultStatus mStatus;

    public InvitationLinkResult(CommonResultStatus commonResultStatus, InvitationLink invitationLink) {
        this.mStatus = commonResultStatus;
        this.mInvitationLink = invitationLink;
    }

    public InvitationLink getResult() {
        return this.mInvitationLink;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
