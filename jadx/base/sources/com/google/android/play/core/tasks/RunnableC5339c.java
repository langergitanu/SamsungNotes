package com.google.android.play.core.tasks;

/* JADX INFO: renamed from: com.google.android.play.core.tasks.c */
/* JADX INFO: loaded from: classes5.dex */
final class RunnableC5339c implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Task f3225a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5340d f3226b;

    public RunnableC5339c(C5340d c5340d, Task task) {
        this.f3226b = c5340d;
        this.f3225a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f3226b.f3228b) {
            try {
                if (this.f3226b.f3229c != null) {
                    this.f3226b.f3229c.onFailure(this.f3225a.getException());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
