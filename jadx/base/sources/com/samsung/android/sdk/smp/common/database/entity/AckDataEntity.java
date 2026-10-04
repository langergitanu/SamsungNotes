package com.samsung.android.sdk.smp.common.database.entity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class AckDataEntity {
    private final String mErrorCode;
    private final String mErrorMsg;
    private final long mFailCount;
    private final String mPushtype;
    private final String mRequestId;
    private final long mTimestamp;

    public AckDataEntity(String str, long j, long j2, String str2, String str3, String str4) {
        this.mRequestId = str;
        this.mTimestamp = j;
        this.mFailCount = j2;
        this.mPushtype = str2;
        this.mErrorCode = str3;
        this.mErrorMsg = str4;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public long getFailCount() {
        return this.mFailCount;
    }

    public String getPushtype() {
        return this.mPushtype;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }
}
