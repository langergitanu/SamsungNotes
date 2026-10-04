package com.samsung.android.sdk.scs.base.tasks;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
final class CompleteListenerRunnable implements Runnable {
    private CompleteListenerCompletion mCompletion;
    private Task mTask;

    public CompleteListenerRunnable(CompleteListenerCompletion completeListenerCompletion, Task task) {
        this.mCompletion = completeListenerCompletion;
        this.mTask = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.mCompletion) {
            try {
                if (this.mCompletion.getCompeteListener() != null) {
                    this.mCompletion.getCompeteListener().onComplete(this.mTask);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
