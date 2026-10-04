package com.samsung.android.sdk.mobileservice.social.group.result;

import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;
import com.samsung.android.sdk.mobileservice.social.group.GroupMember;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class GroupMemberResult implements Result {
    private List<GroupMember> mGroupMembers;
    private CommonResultStatus mStatus;
    private int mTotalCountWithInvitation;

    public GroupMemberResult(CommonResultStatus commonResultStatus, List<GroupMember> list) {
        this.mStatus = commonResultStatus;
        this.mGroupMembers = list;
    }

    public List<GroupMember> getGroupMembers() {
        return this.mGroupMembers;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }

    public int getTotalCountWithInvitation() {
        return this.mTotalCountWithInvitation;
    }

    public void setTotalCountWithInvitation(int i) {
        this.mTotalCountWithInvitation = i;
    }
}
