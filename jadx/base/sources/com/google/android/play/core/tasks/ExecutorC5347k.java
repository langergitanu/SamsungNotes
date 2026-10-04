package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.play.core.tasks.k */
/* JADX INFO: loaded from: classes5.dex */
final class ExecutorC5347k implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
