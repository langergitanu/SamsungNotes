package com.samsung.android.sdk.scs.base.connection;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.feature.FeatureStatusCache;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class ProviderExecutor extends ThreadPoolExecutor implements AutoCloseable {
    private static final String TAG = "ScsApi@ProviderExecutor";
    private final Context context;
    private final AtomicInteger taskCount;

    public ProviderExecutor(Context context, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
        this.taskCount = new AtomicInteger(0);
        allowCoreThreadTimeOut(true);
        this.context = context;
        Log.m6485d(TAG, "ProviderExecutor constructor()");
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        this.taskCount.getAndDecrement();
        Log.m6485d(TAG, "afterExecute(). mTaskCount: " + this.taskCount);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        Log.objectInfo(TAG, "task", this, runnable);
        if (runnable instanceof TaskRunnable) {
            String featureName = ((TaskRunnable) runnable).getFeatureName();
            int status = FeatureStatusCache.getStatus(featureName);
            if (status == -1000 || status == 2000) {
                Log.m6485d(TAG, "beforeExecute(). First check for " + featureName + ". status: " + Feature.checkFeature(this.context, featureName));
            }
        } else {
            Log.m6487e(TAG, "Unexpected runnable!!!!");
        }
        this.taskCount.getAndIncrement();
        Log.m6485d(TAG, "beforeExecute(). mTaskCount: " + this.taskCount);
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
}
