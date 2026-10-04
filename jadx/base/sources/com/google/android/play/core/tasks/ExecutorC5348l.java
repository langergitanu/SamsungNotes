package com.google.android.play.core.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.play.core.tasks.l */
/* JADX INFO: loaded from: classes5.dex */
final class ExecutorC5348l implements Executor {

    /* JADX INFO: renamed from: a */
    private final Handler f3239a = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f3239a.post(runnable);
    }
}
