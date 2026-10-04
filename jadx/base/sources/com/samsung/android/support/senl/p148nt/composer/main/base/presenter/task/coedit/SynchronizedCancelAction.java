package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.coedit;

import androidx.annotation.WorkerThread;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SynchronizedCancelAction implements Runnable {
    private Thread mCurThread;
    private final String mTag;

    public SynchronizedCancelAction(String str) {
        this.mTag = str;
    }

    @WorkerThread
    public void awaitCancel() {
        Logger.m11003i(this.mTag, "awaitCancel# start");
        this.mCurThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            try {
                Logger.m11003i(this.mTag, "awaitCancel# " + i);
                Thread.sleep(1000L);
                if (isCompleted()) {
                    break;
                }
            } catch (InterruptedException e) {
                Logger.m11003i(this.mTag, "awaitCancel# " + e.getMessage());
            }
        }
        this.mCurThread = null;
        Logger.m11003i(this.mTag, "awaitCancel# end");
    }

    public abstract void cancel();

    public abstract boolean isCompleted();

    @Override // java.lang.Runnable
    public final void run() {
        cancel();
        awaitCancel();
    }

    public void stopWaiting() {
        Thread thread = this.mCurThread;
        if (thread != null) {
            thread.interrupt();
        }
    }
}
