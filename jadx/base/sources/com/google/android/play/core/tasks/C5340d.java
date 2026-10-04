package com.google.android.play.core.tasks;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.play.core.tasks.d */
/* JADX INFO: loaded from: classes5.dex */
final class C5340d<ResultT> implements InterfaceC5343g<ResultT> {

    /* JADX INFO: renamed from: a */
    private final Executor f3227a;

    /* JADX INFO: renamed from: b */
    private final Object f3228b = new Object();

    /* JADX INFO: renamed from: c */
    @Nullable
    private final OnFailureListener f3229c;

    public C5340d(Executor executor, OnFailureListener onFailureListener) {
        this.f3227a = executor;
        this.f3229c = onFailureListener;
    }

    @Override // com.google.android.play.core.tasks.InterfaceC5343g
    /* JADX INFO: renamed from: a */
    public final void mo4190a(Task<ResultT> task) {
        if (task.isSuccessful()) {
            return;
        }
        synchronized (this.f3228b) {
            try {
                if (this.f3229c == null) {
                    return;
                }
                this.f3227a.execute(new RunnableC5339c(this, task));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
