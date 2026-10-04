package com.samsung.android.sdk.scs.p142ai.downloader;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ModelDownloaderDownloadRunnable extends TaskRunnable<Integer> {
    private static final String TAG = "ModelDownloaderDownloadRunnable";
    private String mFeature = null;
    private final ModelDownloaderExecutor mServiceExecutor;

    public ModelDownloaderDownloadRunnable(@NonNull ModelDownloaderExecutor modelDownloaderExecutor) {
        this.mServiceExecutor = modelDownloaderExecutor;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        Log.m6489i(TAG, "execute");
        try {
            this.mSource.getTask().getTaskId();
            this.mSource.setResult((TResult) Integer.valueOf(this.mServiceExecutor.getDownloadService().downloadModelPackages(this.mFeature)));
        } catch (RemoteException e) {
            Log.m6487e(TAG, "Exception : " + e);
            throw new RuntimeException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_DOWNLOAD";
    }

    public void setParameters(String str) {
        this.mFeature = str;
    }
}
