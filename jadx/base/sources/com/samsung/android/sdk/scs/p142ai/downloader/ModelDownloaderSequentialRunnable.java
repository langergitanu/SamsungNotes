package com.samsung.android.sdk.scs.p142ai.downloader;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.base.connection.ServiceExecutor;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ModelDownloaderSequentialRunnable<TResult> extends TaskRunnable<TResult> {
    private static final int RUNNABLE_TIMEOUT_SECONDS = 60;
    private static final String TAG = "ModelDownloaderSequentialRunnable";
    private TResult mDefault;
    private final ArrayList<Pair<TaskRunnable<TResult>, ServiceExecutor>> mTasks = new ArrayList<>();

    public void addTask(@NonNull TaskRunnable<TResult> taskRunnable, @NonNull ServiceExecutor serviceExecutor) {
        Log.d(TAG, "addTask: " + taskRunnable.getTask().getTaskId());
        this.mTasks.add(new Pair<>(taskRunnable, serviceExecutor));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bc, code lost:
    
        if (r1 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00be, code lost:
    
        r9.mSource.setException(r1);
        android.util.Log.e(com.samsung.android.sdk.scs.p142ai.downloader.ModelDownloaderSequentialRunnable.TAG, "execute: set exception: " + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00d7, code lost:
    
        r9.mSource.setResult(r9.mDefault);
        android.util.Log.e(com.samsung.android.sdk.scs.p142ai.downloader.ModelDownloaderSequentialRunnable.TAG, "execute: set default: " + r9.mDefault);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00f3, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return;
     */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute() {
        boolean zAwait;
        String str = TAG;
        Log.d(str, "execute");
        if (!this.mTasks.isEmpty()) {
            Iterator<Pair<TaskRunnable<TResult>, ServiceExecutor>> it = this.mTasks.iterator();
            Exception exc = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pair<TaskRunnable<TResult>, ServiceExecutor> next = it.next();
                CountDownLatch countDownLatch = new CountDownLatch(1);
                TaskRunnable taskRunnable = (TaskRunnable) next.first;
                ServiceExecutor serviceExecutor = (ServiceExecutor) next.second;
                Task<TResult> task = taskRunnable.getTask();
                task.addOnCompleteListener(new C7728a(countDownLatch));
                Log.d(TAG, "execute: task=" + task.getTaskId());
                serviceExecutor.execute(taskRunnable);
                try {
                    zAwait = countDownLatch.await(60L, TimeUnit.SECONDS);
                } catch (InterruptedException unused) {
                    zAwait = false;
                }
                if (!zAwait) {
                    Log.e(TAG, "execute: timeout or interrupted: " + task.getTaskId());
                    break;
                }
                if (task.isSuccessful()) {
                    this.mSource.setResult(task.getResult());
                    Log.d(TAG, "execute: result: " + task.getTaskId());
                    return;
                }
                Exception exception = task.getException();
                if (exception != null) {
                    exc = exception;
                }
            }
        } else {
            this.mSource.setException(new Exception("Empty task"));
            Log.e(str, "execute: Empty task");
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_DOWNLOAD";
    }

    public void setDefaultResult(TResult tresult) {
        this.mDefault = tresult;
    }
}
