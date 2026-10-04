package com.samsung.android.sdk.scs.p142ai.downloader;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ModelDownloader {
    public static final int CHECK_RESULT_AVAILABLE = 0;
    public static final int CHECK_RESULT_NEED_DOWNLOAD = 1;
    public static final int CHECK_RESULT_NETWORK_UNAVAILABLE = -3;
    public static final int CHECK_RESULT_NOT_SUPPORTED = -1;
    public static final int CHECK_RESULT_SERVER_ERROR = -5;
    public static final int CHECK_RESULT_STORE_NOT_FOUND = -4;
    public static final int CHECK_RESULT_TIMEOUT = -6;
    public static final int CHECK_RESULT_UNKNOWN_FEATURE = -2;
    public static final String MODEL_FEATURE_LITERT = "litert";
    public static final String MODEL_FEATURE_UNKNOWN = "unknown";
    public static final String MODEL_FEATURE_VISIONLVM = "visionlvm";
    private static final String TAG = "ScsApi@ModelDownloader";
    private final ModelDownloaderCoreExecutor mCoreServicedExecutor;
    private final ModelDownloaderSequentialExecutor mExecutor;
    private final ModelDownloaderExecutor mServiceExecutor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckResult {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ModelFeature {
    }

    public ModelDownloader(@NonNull Context context) {
        Log.m6485d(TAG, "ModelDownloader");
        this.mServiceExecutor = new ModelDownloaderExecutor(context);
        this.mCoreServicedExecutor = new ModelDownloaderCoreExecutor(context);
        this.mExecutor = new ModelDownloaderSequentialExecutor(context);
    }

    public Task<Boolean> cancel(@NonNull String str) {
        Log.m6485d(TAG, "cancel(" + str + ")");
        ModelDownloaderCancelRunnable modelDownloaderCancelRunnable = new ModelDownloaderCancelRunnable(this.mCoreServicedExecutor);
        modelDownloaderCancelRunnable.setParameters(str);
        this.mCoreServicedExecutor.execute(modelDownloaderCancelRunnable);
        return modelDownloaderCancelRunnable.getTask();
    }

    public Task<Integer> check(String str) {
        Log.m6485d(TAG, "check(" + str + ")");
        ModelDownloaderCheckAndDownloadRunnable modelDownloaderCheckAndDownloadRunnable = new ModelDownloaderCheckAndDownloadRunnable(this.mCoreServicedExecutor);
        modelDownloaderCheckAndDownloadRunnable.setParameter(str, true, false);
        Log.m6485d(TAG, "core task: " + modelDownloaderCheckAndDownloadRunnable.getTask().getTaskId());
        ModelDownloaderCheckRunnable modelDownloaderCheckRunnable = new ModelDownloaderCheckRunnable(this.mServiceExecutor);
        modelDownloaderCheckRunnable.setParameters(str);
        Log.m6485d(TAG, "cloud task: " + modelDownloaderCheckRunnable.getTask().getTaskId());
        ModelDownloaderSequentialRunnable modelDownloaderSequentialRunnable = new ModelDownloaderSequentialRunnable();
        modelDownloaderSequentialRunnable.setDefaultResult(-6);
        modelDownloaderSequentialRunnable.addTask(modelDownloaderCheckAndDownloadRunnable, this.mCoreServicedExecutor);
        modelDownloaderSequentialRunnable.addTask(modelDownloaderCheckRunnable, this.mServiceExecutor);
        this.mExecutor.execute(modelDownloaderSequentialRunnable);
        return modelDownloaderSequentialRunnable.getTask();
    }

    public Task<Integer> checkPackage(@NonNull String str) {
        Log.m6485d(TAG, "checkPackage(" + str + ")");
        ModelDownloaderCheckAndDownloadPackageRunnable modelDownloaderCheckAndDownloadPackageRunnable = new ModelDownloaderCheckAndDownloadPackageRunnable(this.mServiceExecutor);
        modelDownloaderCheckAndDownloadPackageRunnable.setParameter(str, true, false);
        Log.m6485d(TAG, "cloud task: " + modelDownloaderCheckAndDownloadPackageRunnable.getTask().getTaskId());
        this.mServiceExecutor.execute(modelDownloaderCheckAndDownloadPackageRunnable);
        return modelDownloaderCheckAndDownloadPackageRunnable.getTask();
    }

    public Task<Integer> checkStore(String str) {
        Log.m6485d(TAG, "check(" + str + ")");
        ModelDownloaderCheckAndDownloadRunnable modelDownloaderCheckAndDownloadRunnable = new ModelDownloaderCheckAndDownloadRunnable(this.mCoreServicedExecutor);
        modelDownloaderCheckAndDownloadRunnable.setParameter(str, false, false);
        Log.m6485d(TAG, "core task: " + modelDownloaderCheckAndDownloadRunnable.getTask().getTaskId());
        ModelDownloaderCheckStoreRunnable modelDownloaderCheckStoreRunnable = new ModelDownloaderCheckStoreRunnable(this.mServiceExecutor);
        modelDownloaderCheckStoreRunnable.setParameters(str);
        Log.m6485d(TAG, "cloud task: " + modelDownloaderCheckStoreRunnable.getTask().getTaskId());
        ModelDownloaderSequentialRunnable modelDownloaderSequentialRunnable = new ModelDownloaderSequentialRunnable();
        modelDownloaderSequentialRunnable.setDefaultResult(-6);
        modelDownloaderSequentialRunnable.addTask(modelDownloaderCheckAndDownloadRunnable, this.mCoreServicedExecutor);
        modelDownloaderSequentialRunnable.addTask(modelDownloaderCheckStoreRunnable, this.mServiceExecutor);
        this.mExecutor.execute(modelDownloaderSequentialRunnable);
        return modelDownloaderSequentialRunnable.getTask();
    }

    public Task<Integer> checkStorePackage(@NonNull String str) {
        Log.m6485d(TAG, "checkStorePackage(" + str + ")");
        ModelDownloaderCheckAndDownloadPackageRunnable modelDownloaderCheckAndDownloadPackageRunnable = new ModelDownloaderCheckAndDownloadPackageRunnable(this.mServiceExecutor);
        modelDownloaderCheckAndDownloadPackageRunnable.setParameter(str, false, false);
        Log.m6485d(TAG, "cloud task: " + modelDownloaderCheckAndDownloadPackageRunnable.getTask().getTaskId());
        this.mServiceExecutor.execute(modelDownloaderCheckAndDownloadPackageRunnable);
        return modelDownloaderCheckAndDownloadPackageRunnable.getTask();
    }

    public Task<Integer> download(@NonNull String str) {
        Log.m6485d(TAG, "download(" + str + ")");
        ModelDownloaderCheckAndDownloadRunnable modelDownloaderCheckAndDownloadRunnable = new ModelDownloaderCheckAndDownloadRunnable(this.mCoreServicedExecutor);
        modelDownloaderCheckAndDownloadRunnable.setParameter(str, false, true);
        Log.m6485d(TAG, "core task: " + modelDownloaderCheckAndDownloadRunnable.getTask().getTaskId());
        ModelDownloaderDownloadRunnable modelDownloaderDownloadRunnable = new ModelDownloaderDownloadRunnable(this.mServiceExecutor);
        modelDownloaderDownloadRunnable.setParameters(str);
        ModelDownloaderSequentialRunnable modelDownloaderSequentialRunnable = new ModelDownloaderSequentialRunnable();
        modelDownloaderSequentialRunnable.setDefaultResult(-6);
        modelDownloaderSequentialRunnable.addTask(modelDownloaderCheckAndDownloadRunnable, this.mCoreServicedExecutor);
        modelDownloaderSequentialRunnable.addTask(modelDownloaderDownloadRunnable, this.mServiceExecutor);
        this.mExecutor.execute(modelDownloaderSequentialRunnable);
        return modelDownloaderSequentialRunnable.getTask();
    }

    public Task<Boolean> downloadCore(@NonNull String str) {
        Log.m6485d(TAG, "download(" + str + ")");
        ModelDownloaderCoreDownloadRunnable modelDownloaderCoreDownloadRunnable = new ModelDownloaderCoreDownloadRunnable(this.mCoreServicedExecutor);
        modelDownloaderCoreDownloadRunnable.setParameters(str);
        this.mCoreServicedExecutor.execute(modelDownloaderCoreDownloadRunnable);
        return modelDownloaderCoreDownloadRunnable.getTask();
    }

    public Task<Integer> downloadPackage(@NonNull String str) {
        Log.m6485d(TAG, "downloadPackage(" + str + ")");
        ModelDownloaderCheckAndDownloadPackageRunnable modelDownloaderCheckAndDownloadPackageRunnable = new ModelDownloaderCheckAndDownloadPackageRunnable(this.mServiceExecutor);
        modelDownloaderCheckAndDownloadPackageRunnable.setParameter(str, false, true);
        Log.m6485d(TAG, "cloud task: " + modelDownloaderCheckAndDownloadPackageRunnable.getTask().getTaskId());
        this.mServiceExecutor.execute(modelDownloaderCheckAndDownloadPackageRunnable);
        return modelDownloaderCheckAndDownloadPackageRunnable.getTask();
    }

    public void release() {
        Log.m6485d(TAG, "release()");
        this.mCoreServicedExecutor.deInit();
        this.mServiceExecutor.deInit();
    }
}
