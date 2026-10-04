package com.google.android.play.core.tasks;

/* JADX INFO: renamed from: com.google.android.play.core.tasks.e */
/* JADX INFO: loaded from: classes5.dex */
final class RunnableC5341e implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Task f3230a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5342f f3231b;

    public RunnableC5341e(C5342f c5342f, Task task) {
        this.f3231b = c5342f;
        this.f3230a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f3231b.f3233b) {
            try {
                if (this.f3231b.f3234c != null) {
                    this.f3231b.f3234c.onSuccess(this.f3230a.getResult());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
