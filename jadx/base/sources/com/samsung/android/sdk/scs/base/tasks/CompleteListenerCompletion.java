package com.samsung.android.sdk.scs.base.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
final class CompleteListenerCompletion<TResult> implements TaskListenerCompletion<TResult> {
    private final Executor mExecutor;
    private OnCompleteListener<TResult> mListener;
    private final Object mLock = new Object();

    public CompleteListenerCompletion(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.mExecutor = executor;
        this.mListener = onCompleteListener;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskListenerCompletion
    public final void cancel() {
        synchronized (this.mLock) {
            this.mListener = null;
        }
    }

    public final OnCompleteListener<TResult> getCompeteListener() {
        return this.mListener;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskListenerCompletion
    public final void onComplete(@NonNull Task<TResult> task) {
        synchronized (this.mLock) {
            try {
                if (this.mListener == null) {
                    return;
                }
                this.mExecutor.execute(new CompleteListenerRunnable(this, task));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
