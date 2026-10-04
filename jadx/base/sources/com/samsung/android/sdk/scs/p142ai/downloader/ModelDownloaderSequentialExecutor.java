package com.samsung.android.sdk.scs.p142ai.downloader;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.feature.FeatureStatusCache;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ModelDownloaderSequentialExecutor extends ThreadPoolExecutor implements AutoCloseable {
    private static final String TAG = "ModelDownloaderSequentialExecutor";
    private final Context mContext;

    public ModelDownloaderSequentialExecutor(@NonNull Context context) {
        super(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        allowCoreThreadTimeOut(true);
        this.mContext = context.getApplicationContext();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (runnable instanceof TaskRunnable) {
            String featureName = ((TaskRunnable) runnable).getFeatureName();
            if (FeatureStatusCache.getStatus(featureName) == -1000) {
                int iCheckFeature = Feature.checkFeature(this.mContext, featureName);
                Log.m6485d(TAG, "beforeExecute: check feature: " + featureName + " status: " + iCheckFeature);
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        boolean zIsTerminated;
        if (this == ForkJoinPool.commonPool() || (zIsTerminated = isTerminated())) {
            return;
        }
        shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void finalize() {
        super.finalize();
        Log.m6485d(TAG, "finalize");
    }
}
