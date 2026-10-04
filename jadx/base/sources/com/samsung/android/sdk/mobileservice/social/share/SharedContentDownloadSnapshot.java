package com.samsung.android.sdk.mobileservice.social.share;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SharedContentDownloadSnapshot {
    private long mCurrentFileBytes;
    private long mCurrentFileBytesReceived;
    private int mCurrentFileIndex;
    private long mTotalBytes;
    private long mTotalBytesReceived;
    private int mTotalFileCount;
    private int mTotalFileCountReceived;

    public SharedContentDownloadSnapshot(long j, long j2, int i, int i2, long j3, long j5, int i4) {
        this.mTotalBytes = j;
        this.mTotalBytesReceived = j2;
        this.mTotalFileCount = i;
        this.mTotalFileCountReceived = i2;
        this.mCurrentFileBytes = j3;
        this.mCurrentFileBytesReceived = j5;
        this.mCurrentFileIndex = i4;
    }

    public long getCurrentFileBytes() {
        return this.mCurrentFileBytes;
    }

    public long getCurrentFileBytesReceived() {
        return this.mCurrentFileBytesReceived;
    }

    public int getCurrentFileIndex() {
        return this.mCurrentFileIndex;
    }

    public long getTotalBytes() {
        return this.mTotalBytes;
    }

    public long getTotalBytesReceived() {
        return this.mTotalBytesReceived;
    }

    public int getTotalFileCount() {
        return this.mTotalFileCount;
    }

    public int getTotalFileCountReceived() {
        return this.mTotalFileCountReceived;
    }
}
