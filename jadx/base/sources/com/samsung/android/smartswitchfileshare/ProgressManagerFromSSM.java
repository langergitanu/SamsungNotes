package com.samsung.android.smartswitchfileshare;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ProgressManagerFromSSM extends ProgressManager {
    public ProgressManagerFromSSM(@Nullable FileShareCallback fileShareCallback, Intent intent, boolean z) {
        super(fileShareCallback, "ProgressManagerFromSSM", z);
        this.totalCount = getTotalFileCount(intent);
        this.totalSize = getTotalFileSize(intent);
    }

    private int getTotalFileCount(@NonNull Intent intent) {
        return intent.getIntExtra(Constants.TAG_URI_FILE_COUNT, -1);
    }

    private long getTotalFileSize(@NonNull Intent intent) {
        return intent.getLongExtra(Constants.TAG_URI_FILE_SIZE, -1L);
    }

    public ProgressManagerFromSSM(boolean z) {
        super(null, "ProgressManagerFromSSM", z);
        this.totalCount = -1;
        this.totalSize = -1L;
    }
}
