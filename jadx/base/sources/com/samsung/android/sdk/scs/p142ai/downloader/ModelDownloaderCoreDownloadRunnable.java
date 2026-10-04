package com.samsung.android.sdk.scs.p142ai.downloader;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.visual.p167ai.sdkcommon.IDownloadCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ModelDownloaderCoreDownloadRunnable extends TaskRunnable<Boolean> {
    private static final String TAG = "ModelDownloaderCoreDownloadRunnable";
    private final ModelDownloaderCoreExecutor mServiceExecutor;
    private String mName = null;
    private final IDownloadCallback.Stub mCallback = new IDownloadCallback.Stub() { // from class: com.samsung.android.sdk.scs.ai.downloader.ModelDownloaderCoreDownloadRunnable.1
        @Override // com.samsung.android.visual.p167ai.sdkcommon.IDownloadCallback
        public void onError(String str, String str2) {
            ModelDownloaderCoreDownloadRunnable.this.mServiceExecutor.removeCallback(str);
            Log.m6485d(ModelDownloaderCoreDownloadRunnable.TAG, "removeCallback: " + str + " : " + str2);
            ((TaskRunnable) ModelDownloaderCoreDownloadRunnable.this).mSource.setException(new Exception(str2));
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IDownloadCallback
        public void onSuccess(String str) {
            ModelDownloaderCoreDownloadRunnable.this.mServiceExecutor.removeCallback(str);
            Log.m6485d(ModelDownloaderCoreDownloadRunnable.TAG, "removeCallback: " + str);
            ((TaskRunnable) ModelDownloaderCoreDownloadRunnable.this).mSource.setResult(Boolean.TRUE);
        }
    };

    public ModelDownloaderCoreDownloadRunnable(@NonNull ModelDownloaderCoreExecutor modelDownloaderCoreExecutor) {
        this.mServiceExecutor = modelDownloaderCoreExecutor;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        String str = TAG;
        Log.m6489i(str, "execute");
        try {
            String taskId = this.mSource.getTask().getTaskId();
            this.mServiceExecutor.getDownloadService().download(this.mName, taskId, this.mCallback);
            this.mServiceExecutor.addCallback(taskId, this.mCallback);
            Log.m6485d(str, "addCallback: " + taskId);
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
        this.mName = str;
    }
}
