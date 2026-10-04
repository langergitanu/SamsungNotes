package com.samsung.android.sdk.mobileservice.social.share.result;

import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class OriginalFileListResult implements Result {
    private final List<OriginalFile> mResultList;
    private final CommonResultStatus mStatus;

    public OriginalFileListResult(CommonResultStatus commonResultStatus, List<OriginalFile> list) {
        this.mStatus = commonResultStatus;
        this.mResultList = list;
    }

    public List<OriginalFile> getResultList() {
        return this.mResultList;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
