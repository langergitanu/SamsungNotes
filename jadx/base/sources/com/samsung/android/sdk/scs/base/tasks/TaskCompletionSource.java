package com.samsung.android.sdk.scs.base.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class TaskCompletionSource<TResult> {
    private final TaskImpl<TResult> task;

    public TaskCompletionSource() {
        this(new TaskImpl());
    }

    @NonNull
    public Task<TResult> getTask() {
        return this.task;
    }

    public void setException(@NonNull Exception exc) {
        this.task.setException(exc);
    }

    public void setResult(TResult tresult) {
        this.task.setResult(tresult);
    }

    public boolean trySetException(@NonNull Exception exc) {
        return this.task.trySetException(exc);
    }

    public boolean trySetResult(TResult tresult) {
        return this.task.trySetResult(tresult);
    }

    public TaskCompletionSource(TaskImpl<TResult> taskImpl) {
        this.task = taskImpl;
    }
}
