package com.samsung.android.sdk.scs.base.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.scs.base.utils.Preconditions;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class TaskImpl<TResult> extends Task<TResult> {
    protected volatile boolean mCanceled;
    protected boolean mComplete;
    protected Exception mException;
    protected final TaskListenersManager<TResult> mListenersManager;
    protected final Object mLock;
    protected TResult mResult;
    protected String mTaskId;

    public TaskImpl() {
        this(new TaskListenersManager());
    }

    private void checkComplete() {
        Preconditions.checkState(this.mComplete, "Task is not yet complete");
    }

    private void checkNotComplete() {
        Preconditions.checkState(!this.mComplete, "Task is already complete");
    }

    private void process() {
        synchronized (this.mLock) {
            try {
                if (this.mComplete) {
                    this.mListenersManager.processCompletion(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.Task
    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<? super TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    public boolean cancel() {
        synchronized (this.mLock) {
            try {
                if (this.mComplete) {
                    return false;
                }
                this.mComplete = true;
                this.mCanceled = true;
                this.mListenersManager.processCompletion(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void checkCanceled() {
        if (this.mCanceled) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.Task
    @Nullable
    public Exception getException() {
        Exception exc;
        synchronized (this.mLock) {
            exc = this.mException;
        }
        return exc;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.Task
    public TResult getResult() {
        TResult tresult;
        synchronized (this.mLock) {
            try {
                checkComplete();
                checkCanceled();
                if (this.mException != null) {
                    throw new RuntimeException(this.mException);
                }
                tresult = this.mResult;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tresult;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.Task
    public String getTaskId() {
        return this.mTaskId;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.Task
    public boolean isCanceled() {
        return this.mCanceled;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.Task
    public boolean isComplete() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mComplete;
        }
        return z;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.Task
    public boolean isSuccessful() {
        boolean z;
        synchronized (this.mLock) {
            try {
                z = this.mComplete && !this.mCanceled && this.mException == null;
            } finally {
            }
        }
        return z;
    }

    public void setException(@NonNull Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.mLock) {
            checkNotComplete();
            this.mComplete = true;
            this.mException = exc;
        }
        this.mListenersManager.processCompletion(this);
    }

    public void setResult(TResult tresult) {
        synchronized (this.mLock) {
            checkNotComplete();
            this.mComplete = true;
            this.mResult = tresult;
        }
        this.mListenersManager.processCompletion(this);
    }

    public boolean trySetException(@NonNull Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.mLock) {
            try {
                if (this.mComplete) {
                    return false;
                }
                this.mComplete = true;
                this.mException = exc;
                this.mListenersManager.processCompletion(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean trySetResult(TResult tresult) {
        synchronized (this.mLock) {
            try {
                if (this.mComplete) {
                    return false;
                }
                this.mComplete = true;
                this.mResult = tresult;
                this.mListenersManager.processCompletion(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public TaskImpl(TaskListenersManager<TResult> taskListenersManager) {
        this.mLock = new Object();
        this.mListenersManager = taskListenersManager;
        this.mTaskId = UUID.randomUUID().toString();
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.Task
    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<? super TResult> onCompleteListener) {
        this.mListenersManager.add(new CompleteListenerCompletion(executor, onCompleteListener));
        process();
        return this;
    }
}
