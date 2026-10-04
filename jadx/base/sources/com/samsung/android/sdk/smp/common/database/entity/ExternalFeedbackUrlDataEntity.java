package com.samsung.android.sdk.smp.common.database.entity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ExternalFeedbackUrlDataEntity {
    private final int mFailCount;
    private final String mPath;
    private final long mTimestamp;

    public ExternalFeedbackUrlDataEntity(String str, int i, long j) {
        this.mPath = str;
        this.mFailCount = i;
        this.mTimestamp = j;
    }

    public int getFailCount() {
        return this.mFailCount;
    }

    public String getPath() {
        return this.mPath;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }
}
