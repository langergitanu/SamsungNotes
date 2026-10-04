package com.samsung.android.sdk.scs.base.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TaskStreamingImpl<TResult> extends TaskImpl<TResult> implements Cloneable {
    private static final String TAG = "ScsApi@TaskStreamingImpl";

    public TaskStreamingImpl() {
        super(new TaskStreamingListenersManager());
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskImpl, com.samsung.android.sdk.scs.base.tasks.Task
    @NonNull
    public /* bridge */ /* synthetic */ Task addOnCompleteListener(@NonNull OnCompleteListener onCompleteListener) {
        return super.addOnCompleteListener(onCompleteListener);
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskImpl
    public /* bridge */ /* synthetic */ boolean cancel() {
        return super.cancel();
    }

    @NonNull
    public Object clone() {
        return super.clone();
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskImpl, com.samsung.android.sdk.scs.base.tasks.Task
    @Nullable
    public /* bridge */ /* synthetic */ Exception getException() {
        return super.getException();
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskImpl, com.samsung.android.sdk.scs.base.tasks.Task
    public TResult getResult() {
        TResult tresult;
        synchronized (this.mLock) {
            try {
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

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskImpl, com.samsung.android.sdk.scs.base.tasks.Task
    public /* bridge */ /* synthetic */ String getTaskId() {
        return super.getTaskId();
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskImpl, com.samsung.android.sdk.scs.base.tasks.Task
    public /* bridge */ /* synthetic */ boolean isCanceled() {
        return super.isCanceled();
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskImpl, com.samsung.android.sdk.scs.base.tasks.Task
    public /* bridge */ /* synthetic */ boolean isComplete() {
        return super.isComplete();
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskImpl, com.samsung.android.sdk.scs.base.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.mLock) {
            try {
                z = !this.mCanceled && this.mException == null;
            } finally {
            }
        }
        return z;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskImpl
    public /* bridge */ /* synthetic */ void setException(@NonNull Exception exc) {
        super.setException(exc);
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskImpl
    public void setResult(TResult tresult) {
        synchronized (this.mLock) {
            this.mResult = tresult;
        }
        try {
            this.mListenersManager.processCompletion((Task) clone());
        } catch (Exception e) {
            Log.m6489i(TAG, "setResult, e : " + e.getMessage());
            this.mListenersManager.processCompletion(this);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskImpl
    public /* bridge */ /* synthetic */ boolean trySetException(@NonNull Exception exc) {
        return super.trySetException(exc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskImpl
    public /* bridge */ /* synthetic */ boolean trySetResult(Object obj) {
        return super.trySetResult(obj);
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskImpl, com.samsung.android.sdk.scs.base.tasks.Task
    @NonNull
    public /* bridge */ /* synthetic */ Task addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener onCompleteListener) {
        return super.addOnCompleteListener(executor, onCompleteListener);
    }
}
