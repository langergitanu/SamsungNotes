package com.samsung.android.sdk.scs.base.tasks;

import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.base.utils.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Tasks {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TaskCountDown implements OnCompleteListener<Object> {
        private final CountDownLatch mLatch;

        public /* synthetic */ TaskCountDown(int i) {
            this();
        }

        public final void await() throws InterruptedException {
            this.mLatch.await();
        }

        @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<Object> task) {
            this.mLatch.countDown();
        }

        private TaskCountDown() {
            this.mLatch = new CountDownLatch(1);
        }

        public final boolean await(long j, TimeUnit timeUnit) {
            return this.mLatch.await(j, timeUnit);
        }
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task) {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return (TResult) completeTask(task);
        }
        TaskCountDown taskCountDown = new TaskCountDown(0);
        task.addOnCompleteListener(TaskExecutors.EXECUTOR, taskCountDown);
        taskCountDown.await();
        return (TResult) completeTask(task);
    }

    private static <TResult> TResult completeTask(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task, long j, @NonNull TimeUnit timeUnit) throws TimeoutException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return (TResult) completeTask(task);
        }
        TaskCountDown taskCountDown = new TaskCountDown(0);
        task.addOnCompleteListener(TaskExecutors.EXECUTOR, taskCountDown);
        if (taskCountDown.await(j, timeUnit)) {
            return (TResult) completeTask(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }
}
