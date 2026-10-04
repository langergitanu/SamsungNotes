package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.os.Handler;
import com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.InputValues;
import com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.ResultValues;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SingleThreadTask<I extends Task.InputValues, R extends Task.ResultValues> extends Task<I, R> {
    private static final String TAG = Logger.createTag("SingleThreadTask");
    private CountDownLatch mCountDownLatch;
    protected ExecutorService mExecutorService;
    protected boolean mThreadWaitingTermination = false;

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        String str = TAG;
        Logger.m10999d(str, "clear# " + this.mExecutorService);
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            executorService.shutdownNow();
            if (this.mThreadWaitingTermination) {
                try {
                    if (!this.mExecutorService.awaitTermination(1L, TimeUnit.SECONDS)) {
                        Logger.m10999d(str, "clear# timeout");
                    }
                } catch (InterruptedException e) {
                    Logger.m10999d(TAG, "clear#InterruptedException: " + e.getMessage());
                }
            }
            this.mExecutorService = null;
        }
    }

    public boolean isShutdown() {
        ExecutorService executorService = this.mExecutorService;
        return executorService == null || executorService.isShutdown();
    }

    public void notifyCallback(boolean z, R r) {
        if (getTaskCallback() != null) {
            if (z) {
                getTaskCallback().onSuccess(r);
            } else {
                getTaskCallback().onError(r);
            }
        }
    }

    public void waitToMainThread(Handler handler, final Runnable runnable) {
        this.mCountDownLatch = new CountDownLatch(1);
        handler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.SingleThreadTask.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
                SingleThreadTask.this.mCountDownLatch.countDown();
            }
        });
        try {
            this.mCountDownLatch.await(1L, TimeUnit.MINUTES);
        } catch (InterruptedException unused) {
            Logger.m11000e(TAG, "waitToMainThread# interrupted");
        }
    }
}
