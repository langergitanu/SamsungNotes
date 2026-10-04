package com.samsung.android.sdk.mobileservice.social.group.result;

import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;
import com.samsung.android.sdk.mobileservice.social.group.GroupAuthority;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class GroupAuthorityListResult implements Result {
    private List<GroupAuthority> mAuthorityList;
    private CommonResultStatus mStatus;

    public GroupAuthorityListResult(CommonResultStatus commonResultStatus, List<GroupAuthority> list) {
        this.mStatus = commonResultStatus;
        this.mAuthorityList = list;
    }

    public List<GroupAuthority> getResult() {
        return this.mAuthorityList;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
