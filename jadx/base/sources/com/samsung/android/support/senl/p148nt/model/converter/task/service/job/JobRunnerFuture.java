package com.samsung.android.support.senl.p148nt.model.converter.task.service.job;

import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class JobRunnerFuture<T> extends FutureTask<T> {
    private JobRunner mRunner;

    public JobRunnerFuture(Runnable runnable, T t) {
        super(runnable, t);
        if (runnable instanceof JobRunner) {
            this.mRunner = (JobRunner) runnable;
        }
    }

    public boolean cancel(int i) {
        JobRunner jobRunner;
        if (isDone() || (jobRunner = this.mRunner) == null || !jobRunner.cancel(i)) {
            return false;
        }
        return cancel(true);
    }

    public boolean cancel() {
        return cancel(this.mRunner.mItem.getInfo().getCallerId());
    }
}
