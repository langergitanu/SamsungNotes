package com.samsung.android.sdk.mobileservice.social.social;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ShareLimit {
    private final int maxCountOfDelete;
    private final int maxCountOfDeleteFromTrashBin;
    private final int maxCountOfDownload;
    private final int maxCountOfMoveToTrashBin;
    private final int maxCountOfRestoreFromTrashBin;
    private final int maxCountOfUpload;

    public ShareLimit(int i, int i2, int i4, int i5, int i6, int i7) {
        this.maxCountOfUpload = i;
        this.maxCountOfDownload = i2;
        this.maxCountOfDelete = i4;
        this.maxCountOfMoveToTrashBin = i5;
        this.maxCountOfRestoreFromTrashBin = i6;
        this.maxCountOfDeleteFromTrashBin = i7;
    }

    public int getMaxCountOfDelete() {
        return this.maxCountOfDelete;
    }

    public int getMaxCountOfDeleteFromTrashBin() {
        return this.maxCountOfDeleteFromTrashBin;
    }

    public int getMaxCountOfDownload() {
        return this.maxCountOfDownload;
    }

    public int getMaxCountOfMoveToTrashBin() {
        return this.maxCountOfMoveToTrashBin;
    }

    public int getMaxCountOfRestoreFromTrashBin() {
        return this.maxCountOfRestoreFromTrashBin;
    }

    public int getMaxCountOfUpload() {
        return this.maxCountOfUpload;
    }
}
