package com.samsung.android.sdk.mobileservice.social.share;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ShareSnapshot {
    private long mCurrentFileBytes;
    private long mCurrentFileBytesTransferred;
    private int mCurrentFileIndex;
    private long mTotalBytes;
    private long mTotalBytesTransferred;
    private int mTotalFileCount;
    private int mTotalFileCountTransferred;

    public ShareSnapshot(long j, long j2, int i, int i2, long j3, long j5, int i4) {
        this.mTotalBytes = j;
        this.mTotalBytesTransferred = j2;
        this.mTotalFileCount = i;
        this.mTotalFileCountTransferred = i2;
        this.mCurrentFileBytes = j3;
        this.mCurrentFileBytesTransferred = j5;
        this.mCurrentFileIndex = i4;
    }

    public long getCurrentFileBytes() {
        return this.mCurrentFileBytes;
    }

    public long getCurrentFileBytesTransferred() {
        return this.mCurrentFileBytesTransferred;
    }

    public int getCurrentFileIndex() {
        return this.mCurrentFileIndex;
    }

    public long getTotalBytes() {
        return this.mTotalBytes;
    }

    public long getTotalBytesTransferred() {
        return this.mTotalBytesTransferred;
    }

    public int getTotalFileCount() {
        return this.mTotalFileCount;
    }

    public int getTotalFileCountTransferred() {
        return this.mTotalFileCountTransferred;
    }
}
