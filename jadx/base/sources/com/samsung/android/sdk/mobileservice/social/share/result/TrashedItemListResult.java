package com.samsung.android.sdk.mobileservice.social.share.result;

import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.TrashedItem;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class TrashedItemListResult implements Result {
    private final List<ShareApi.SharedItemRequest> mFailureList;
    private final CommonResultStatus mStatus;
    private final List<TrashedItem> mSuccessList;

    public TrashedItemListResult(CommonResultStatus commonResultStatus, List<TrashedItem> list, List<ShareApi.SharedItemRequest> list2) {
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

    public List<TrashedItem> getSuccessList() {
        return this.mSuccessList;
    }
}
