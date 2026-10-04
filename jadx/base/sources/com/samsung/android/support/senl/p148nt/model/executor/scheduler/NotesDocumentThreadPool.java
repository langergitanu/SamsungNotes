package com.samsung.android.support.senl.p148nt.model.executor.scheduler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentFutureTask;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NotesDocumentThreadPool extends ThreadPoolExecutor implements AutoCloseable {
    private static final String TAG = ModelLogger.createTag("DocumentThreadPool");
    private DocumentTask.Type mLastTaskType;
    private SchedulerDataSource.OnWorkingStateListener mOnWorkingStateListener;
    private SchedulerDataSource.WorkingState mState;
    private final AtomicLong mTaskCount;
    private final ConcurrentHashMap<Runnable, Long> mTimeMap;
    private final AtomicLong mTotalTime;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.executor.scheduler.NotesDocumentThreadPool$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C114581 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$model$executor$task$DocumentTask$Type */
        static final /* synthetic */ int[] f7748x6534c2f4;

        static {
            int[] iArr = new int[DocumentTask.Type.values().length];
            f7748x6534c2f4 = iArr;
            try {
                iArr[DocumentTask.Type.LOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7748x6534c2f4[DocumentTask.Type.SAVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7748x6534c2f4[DocumentTask.Type.CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7748x6534c2f4[DocumentTask.Type.SAVE_CACHE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7748x6534c2f4[DocumentTask.Type.LOAD_CACHE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7748x6534c2f4[DocumentTask.Type.RELOAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7748x6534c2f4[DocumentTask.Type.DISCARD_CACHE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7748x6534c2f4[DocumentTask.Type.SNAP_SAVE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public NotesDocumentThreadPool(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue, new DocumentThreadFactory());
        this.mTaskCount = new AtomicLong();
        this.mTotalTime = new AtomicLong();
        this.mTimeMap = new ConcurrentHashMap<>();
        this.mLastTaskType = DocumentTask.Type.NONE;
    }

    @NonNull
    private DocumentSubscriptionId getOwner(Runnable runnable) {
        if (runnable instanceof DocumentFutureTask) {
            DocumentFutureTask documentFutureTask = (DocumentFutureTask) runnable;
            if (documentFutureTask.getRunnable() instanceof DocumentTask) {
                return ((DocumentTask) documentFutureTask.getRunnable()).getUser();
            }
        }
        return DocumentSubscriptionId.REFERENCE_SKIP_ID;
    }

    @NonNull
    private String getUuid(Runnable runnable) {
        if (!(runnable instanceof DocumentFutureTask)) {
            return "";
        }
        DocumentFutureTask documentFutureTask = (DocumentFutureTask) runnable;
        return documentFutureTask.getRunnable() instanceof DocumentTask ? ((DocumentTask) documentFutureTask.getRunnable()).getUuid() : "";
    }

    private void notifyOnWorkingStateListener(String str, SchedulerDataSource.WorkingState workingState, DocumentSubscriptionId documentSubscriptionId) {
        DataLogger.m12307i(TAG, "notifyOnWorkingStateListener");
        SchedulerDataSource.OnWorkingStateListener onWorkingStateListener = this.mOnWorkingStateListener;
        if (onWorkingStateListener != null) {
            onWorkingStateListener.onState(this, str, workingState, documentSubscriptionId);
        }
    }

    private void setCurrentState(@NonNull String str, @NonNull SchedulerDataSource.WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        DataLogger.m12307i(TAG, "setCurrentState, uuid : " + str + ", state : " + workingState + ", owner : " + documentSubscriptionId);
        this.mState = workingState;
        notifyOnWorkingStateListener(str, workingState, documentSubscriptionId);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    @SuppressLint({"DefaultLocale"})
    public void afterExecute(Runnable runnable, Throwable th) throws Throwable {
        Runnable runnable2;
        Throwable th2;
        long jCurrentTimeMillis;
        try {
            Long lRemove = this.mTimeMap.remove(runnable);
            if (lRemove == null) {
                DataLogger.m12309w(TAG, "afterExecute, startTime is null");
                lRemove = 0L;
            }
            jCurrentTimeMillis = System.currentTimeMillis() - lRemove.longValue();
            this.mTotalTime.addAndGet(jCurrentTimeMillis);
            this.mTaskCount.decrementAndGet();
            setCurrentState(getUuid(runnable), SchedulerDataSource.WorkingState.IDLE, getOwner(runnable));
            runnable2 = runnable;
            th2 = th;
        } catch (Throwable th3) {
            th = th3;
            runnable2 = runnable;
            th2 = th;
        }
        try {
            DataLogger.m12308p(TAG, String.format("@--- afterExecute -> throwable : %s, owner : %s, executed runnable{%s} ended, time : %d, state[%s], pending queue{size - %d, queue - %s}", th2, getOwner(runnable), runnable2, Long.valueOf(jCurrentTimeMillis), getCurrentState(), Integer.valueOf(getQueue().size()), getQueue()));
            super.afterExecute(runnable2, th2);
        } catch (Throwable th4) {
            th = th4;
            super.afterExecute(runnable2, th2);
            throw th;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    @SuppressLint({"DefaultLocale"})
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        setCurrentState(getUuid(runnable), convertToWorkingState(runnable), getOwner(runnable));
        this.mTimeMap.put(runnable, Long.valueOf(System.currentTimeMillis()));
        this.mTaskCount.incrementAndGet();
        DataLogger.m12308p(TAG, String.format("@--- beforeExecute -> thread : %s, owner : %s, executed runnable{%s} started, state[%s], pending queue{size - %d, queue - %s}", thread, getOwner(runnable), runnable, getCurrentState(), Integer.valueOf(getQueue().size()), getQueue()));
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

    @NonNull
    public SchedulerDataSource.WorkingState convertToWorkingState(@NonNull Runnable runnable) {
        SchedulerDataSource.WorkingState workingState = SchedulerDataSource.WorkingState.UNDEFINED;
        if (runnable instanceof DocumentFutureTask) {
            Runnable runnable2 = ((DocumentFutureTask) runnable).getRunnable();
            if (runnable2 instanceof DocumentTask) {
                switch (C114581.f7748x6534c2f4[((DocumentTask) runnable2).getType().ordinal()]) {
                    case 1:
                        return SchedulerDataSource.WorkingState.LOADING;
                    case 2:
                        return SchedulerDataSource.WorkingState.SAVING;
                    case 3:
                        return SchedulerDataSource.WorkingState.CLOSING;
                    case 4:
                        return SchedulerDataSource.WorkingState.SAVING_CACHE;
                    case 5:
                        return SchedulerDataSource.WorkingState.LOADING_CACHE;
                    case 6:
                        return SchedulerDataSource.WorkingState.RELOADING;
                    case 7:
                        return SchedulerDataSource.WorkingState.DISCARD_CACHE;
                    case 8:
                        return SchedulerDataSource.WorkingState.SNAP_SAVE;
                }
            }
        }
        return workingState;
    }

    @NonNull
    public SchedulerDataSource.WorkingState getCurrentState() {
        return this.mState;
    }

    public DocumentTask.Type getLastTaskType() {
        return this.mLastTaskType;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new DocumentFutureTask(callable);
    }

    public void setOnWorkingStateListener(@Nullable SchedulerDataSource.OnWorkingStateListener onWorkingStateListener) {
        this.mOnWorkingStateListener = onWorkingStateListener;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        if (runnable instanceof DocumentTask) {
            this.mLastTaskType = ((DocumentTask) runnable).getType();
        }
        return super.submit(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    @SuppressLint({"DefaultLocale"})
    public void terminated() {
        try {
            DataLogger.m12308p(TAG, String.format("@--- terminated -> Thread is terminated. state[%s], pending queue{size - %d, queue - %s}", getCurrentState(), Integer.valueOf(getQueue().size()), getQueue()));
        } finally {
            super.terminated();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    @NonNull
    public String toString() {
        return "DocumentThreadPool{State : " + getCurrentState() + ", ActiveCount : " + getActiveCount() + ", TaskCount : " + getTaskCount() + ", CompletedCount : " + getCompletedTaskCount() + ", Queue : " + getQueue() + '}';
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new DocumentFutureTask(runnable, t);
    }
}
