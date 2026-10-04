package com.samsung.android.support.senl.p148nt.coedit.caller.updownloader;

import com.samsung.android.support.senl.p148nt.coedit.control.common.UpdatePriority;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DownloadRequest {
    public final String mItemId;
    public final DownloadResponse mRunnable;
    public final String mSpaceId;
    private final UpdatePriority mUpdatePriority;

    public DownloadRequest(String str, String str2, UpdatePriority updatePriority, DownloadResponse downloadResponse) {
        this.mSpaceId = str;
        this.mItemId = str2;
        this.mUpdatePriority = updatePriority;
        this.mRunnable = downloadResponse;
    }

    public UpdatePriority getUpdatePriority() {
        return this.mUpdatePriority;
    }

    public boolean isComposerPriority() {
        return this.mUpdatePriority == UpdatePriority.COMPOSE_PRIORITY;
    }

    public boolean isHighUpdatePriority() {
        UpdatePriority updatePriority = this.mUpdatePriority;
        return updatePriority == UpdatePriority.COMPOSE_PRIORITY || updatePriority == UpdatePriority.IMPORT_PRIORITY || updatePriority == UpdatePriority.STANDALONE_PRIORITY;
    }

    public boolean isLowUpdatePriority() {
        UpdatePriority updatePriority = this.mUpdatePriority;
        return updatePriority == UpdatePriority.BACKGROUND_PRIORITY || updatePriority == UpdatePriority.LIST_PRIORITY;
    }

    public void onFailed(String str) {
        DownloadResponse downloadResponse = this.mRunnable;
        if (downloadResponse == null) {
            return;
        }
        downloadResponse.onCompleted(this.mSpaceId, str, false);
    }

    public void onSuccess(String str) {
        DownloadResponse downloadResponse = this.mRunnable;
        if (downloadResponse == null) {
            return;
        }
        downloadResponse.onCompleted(this.mSpaceId, str, true);
    }
}
