package com.samsung.android.sdk.mobileservice.social.share.result;

import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SharedItemListResult implements Result {
    private List<ShareApi.SharedItemRequest> mFailureList;
    private CommonResultStatus mStatus;
    private List<SharedItem> mSuccessList;

    public SharedItemListResult(CommonResultStatus commonResultStatus, List<SharedItem> list, List<ShareApi.SharedItemRequest> list2) {
        this.mStatus = commonResultStatus;
        this.mSuccessList = list;
        this.mFailureList = list2;
    }

    public List<ShareApi.SharedItemRequest> getFailureList() {
        return this.mFailureList;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }

    public List<SharedItem> getSuccessList() {
        return this.mSuccessList;
    }
}
