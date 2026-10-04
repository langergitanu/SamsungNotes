package com.samsung.android.sdk.scs.base.tasks;

import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.scs.base.ResultException;
import com.samsung.android.sdk.scs.base.feature.FeatureStatusCache;
import com.samsung.android.sdk.scs.base.utils.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class TaskRunnable<TResult> implements Runnable {
    private static final String TAG = "ScsApi@TaskRunnable<>";
    private static final String TASK_DELIMITER = "#";
    private static final String THREAD_NAME_PREFIX = "scs";
    protected final TaskCompletionSource<TResult> mSource;

    public TaskRunnable() {
        this(new TaskCompletionSource());
    }

    private String createThreadName(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String strConcat = str.split("#")[0];
        if (!strConcat.startsWith(THREAD_NAME_PREFIX)) {
            strConcat = "scs-".concat(strConcat);
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(strConcat, "#");
        sbM781w.append(getClass().getSimpleName());
        sbM781w.append(Log.TAG_SEPARATOR);
        sbM781w.append(Integer.toHexString(hashCode()));
        return sbM781w.toString();
    }

    public abstract void execute();

    public abstract String getFeatureName();

    public TaskCompletionSource<TResult> getSource() {
        return this.mSource;
    }

    public Task<TResult> getTask() {
        return this.mSource.getTask();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            boolean zInterrupted = Thread.interrupted();
            Thread.currentThread().setName(createThreadName(Thread.currentThread().getName()));
            Log.m6489i(TAG, "run() - " + Thread.currentThread() + ", interrupt : " + zInterrupted);
            int status = FeatureStatusCache.getStatus(getFeatureName());
            if (status == 0 && !zInterrupted) {
                execute();
                return;
            }
            ResultException resultException = new ResultException(status, getFeatureName() + " is not available. statusCode: " + status + ", isInterrupted: " + zInterrupted);
            Log.m6489i(TAG, resultException.getMessage());
            this.mSource.setException(resultException);
        } catch (Exception e) {
            Log.m6488e(TAG, "Uncaught Exception!!!", e);
            this.mSource.trySetException(e);
        }
    }

    public TaskRunnable(TaskCompletionSource<TResult> taskCompletionSource) {
        this.mSource = taskCompletionSource;
    }
}
