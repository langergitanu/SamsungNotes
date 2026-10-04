package com.samsung.android.sdk.mobileservice.social.datasync.result;

import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.social.datasync.SyncedData;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DataSyncResult {
    private final List<SyncedData> mResponse;
    private final CommonResultStatus mStatus;

    public DataSyncResult(CommonResultStatus commonResultStatus) {
        this.mStatus = commonResultStatus;
        this.mResponse = null;
    }

    public List<SyncedData> getResponse() {
        return this.mResponse;
    }

    public CommonResultStatus getStatus() {
        return this.mStatus;
    }

    public DataSyncResult(CommonResultStatus commonResultStatus, List<SyncedData> list) {
        this.mStatus = commonResultStatus;
        this.mResponse = list;
    }
}
