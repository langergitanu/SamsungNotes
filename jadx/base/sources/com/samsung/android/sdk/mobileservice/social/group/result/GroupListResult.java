package com.samsung.android.sdk.mobileservice.social.group.result;

import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;
import com.samsung.android.sdk.mobileservice.social.group.Group;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class GroupListResult implements Result {
    private List<Group> mGroups;
    private CommonResultStatus mStatus;

    public GroupListResult(CommonResultStatus commonResultStatus, List<Group> list) {
        this.mStatus = commonResultStatus;
        this.mGroups = list;
    }

    public List<Group> getResult() {
        return this.mGroups;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
