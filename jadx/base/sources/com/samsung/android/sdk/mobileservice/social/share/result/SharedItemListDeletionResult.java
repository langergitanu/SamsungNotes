package com.samsung.android.sdk.mobileservice.social.share.result;

import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SharedItemListDeletionResult implements Result {
    private List<SharedItemDeletionResult> mResultList;
    private CommonResultStatus mStatus;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SharedItemDeletionResult {
        private String itemId;
        private boolean result;
        private String spaceId;

        public SharedItemDeletionResult(String str, String str2, boolean z) {
            this.spaceId = str;
            this.itemId = str2;
            this.result = z;
        }

        public String getItemId() {
            return this.itemId;
        }

        public boolean getResult() {
            return this.result;
        }

        public String getSpaceId() {
            return this.spaceId;
        }
    }

    public SharedItemListDeletionResult(CommonResultStatus commonResultStatus, List<SharedItemDeletionResult> list) {
        this.mStatus = commonResultStatus;
        this.mResultList = list;
    }

    public List<SharedItemDeletionResult> getResultList() {
        return this.mResultList;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
