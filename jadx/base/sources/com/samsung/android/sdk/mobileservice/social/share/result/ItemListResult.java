package com.samsung.android.sdk.mobileservice.social.share.result;

import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ItemListResult implements Result {
    private List<SharedItemListFailureResult> mFailureList;
    private CommonResultStatus mStatus;
    private List<SharedItemListSuccessResult> mSuccessList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SharedItemListFailureResult {
        private Long errorCode;
        private String itemId;
        private String spaceId;

        public SharedItemListFailureResult(String str, String str2, Long l) {
            this.spaceId = str;
            this.itemId = str2;
            this.errorCode = l;
        }

        public Long getErrorCode() {
            return this.errorCode;
        }

        public String getItemId() {
            return this.itemId;
        }

        public String getSpaceId() {
            return this.spaceId;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SharedItemListSuccessResult {
        private String itemId;
        private String spaceId;

        public SharedItemListSuccessResult(String str, String str2) {
            this.spaceId = str;
            this.itemId = str2;
        }

        public String getItemId() {
            return this.itemId;
        }

        public String getSpaceId() {
            return this.spaceId;
        }
    }

    public ItemListResult(CommonResultStatus commonResultStatus, List<SharedItemListSuccessResult> list, List<SharedItemListFailureResult> list2) {
        this.mStatus = commonResultStatus;
        this.mSuccessList = list;
        this.mFailureList = list2;
    }

    public List<SharedItemListFailureResult> getFailureList() {
        return this.mFailureList;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }

    public List<SharedItemListSuccessResult> getSuccessList() {
        return this.mSuccessList;
    }
}
