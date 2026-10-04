package com.samsung.android.sdk.scs.p142ai.downloader;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ModelDownloaderCheckAndDownloadRunnable extends TaskRunnable<Integer> {
    private static final String TAG = "ModelDownloaderCheckAndDownloadRunnable";
    private boolean mCheckOnly;
    private String mFeature;
    private boolean mLaunchStore;
    private final ModelDownloaderCoreExecutor mServiceExecutor;

    public ModelDownloaderCheckAndDownloadRunnable(@NonNull ModelDownloaderCoreExecutor modelDownloaderCoreExecutor) {
        this.mServiceExecutor = modelDownloaderCoreExecutor;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        String str = TAG;
        Log.m6489i(str, "execute");
        try {
            int iCheckAndDownload = this.mServiceExecutor.getDownloadService().checkAndDownload(this.mFeature, this.mCheckOnly, this.mLaunchStore);
            Log.m6485d(str, "execute: result=" + iCheckAndDownload);
            if (iCheckAndDownload == 0) {
                throw new RemoteException("Non-existent interface");
            }
            if (iCheckAndDownload > 9000) {
                iCheckAndDownload -= 10000;
            }
            this.mSource.setResult((TResult) Integer.valueOf(iCheckAndDownload));
        } catch (RemoteException e) {
            Log.m6487e(TAG, "execute: " + e);
            this.mSource.setException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_DOWNLOAD";
    }

    public void setParameter(@NonNull String str, boolean z, boolean z2) {
        this.mFeature = str;
        this.mCheckOnly = z;
        this.mLaunchStore = z2;
    }
}
