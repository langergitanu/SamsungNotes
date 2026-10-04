package com.samsung.android.sdk.mobileservice.social.share.result;

import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;
import com.samsung.android.sdk.mobileservice.social.share.SharedItemWithUriList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SharedItemListWithContentListResult implements Result {
    private List<SharedItemWithUriList> mItemList;
    private CommonResultStatus mStatus;

    public SharedItemListWithContentListResult(CommonResultStatus commonResultStatus, List<SharedItemWithUriList> list) {
        this.mStatus = commonResultStatus;
        this.mItemList = list;
    }

    public List<SharedItemWithUriList> getItemsList() {
        return this.mItemList;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
