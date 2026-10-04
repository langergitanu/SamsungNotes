package com.samsung.android.support.senl.p148nt.model.converter.task.common;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CountInfo {
    private final int mFailedCount;
    private final int mInvalidInputCount;
    private final int mStorageFailedCount;
    private final int mSuccessCount;
    private final int mTotalCount;

    public CountInfo(int i, int i2, int i4, int i5, int i6) {
        this.mTotalCount = i;
        this.mInvalidInputCount = i2;
        this.mSuccessCount = i4;
        this.mFailedCount = i5;
        this.mStorageFailedCount = i6;
    }

    public int getFailedCount() {
        return this.mFailedCount;
    }

    public int getProgressCount() {
        return this.mInvalidInputCount + this.mFailedCount + this.mSuccessCount;
    }

    public int getStorageFailedCount() {
        return this.mStorageFailedCount;
    }

    public int getSuccessCount() {
        return this.mSuccessCount;
    }

    public int getTotalCount() {
        return this.mTotalCount;
    }

    @NonNull
    public String toString() {
        return "total/invalidInput/success/failed/storageFailed = " + this.mTotalCount + "/" + this.mInvalidInputCount + "/" + this.mSuccessCount + "/" + this.mFailedCount + "/" + this.mStorageFailedCount;
    }
}
