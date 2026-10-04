package com.google.android.play.core.tasks;

/* JADX INFO: renamed from: com.google.android.play.core.tasks.a */
/* JADX INFO: loaded from: classes5.dex */
final class RunnableC5337a implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Task f3220a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5338b f3221b;

    public RunnableC5337a(C5338b c5338b, Task task) {
        this.f3221b = c5338b;
        this.f3220a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f3221b.f3223b) {
            try {
                if (this.f3221b.f3224c != null) {
                    this.f3221b.f3224c.onComplete(this.f3220a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
