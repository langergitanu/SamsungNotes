package com.google.android.play.core.tasks;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.play.core.tasks.f */
/* JADX INFO: loaded from: classes5.dex */
final class C5342f<ResultT> implements InterfaceC5343g<ResultT> {

    /* JADX INFO: renamed from: a */
    private final Executor f3232a;

    /* JADX INFO: renamed from: b */
    private final Object f3233b = new Object();

    /* JADX INFO: renamed from: c */
    @Nullable
    private final OnSuccessListener<? super ResultT> f3234c;

    public C5342f(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.f3232a = executor;
        this.f3234c = onSuccessListener;
    }

    @Override // com.google.android.play.core.tasks.InterfaceC5343g
    /* JADX INFO: renamed from: a */
    public final void mo4190a(Task<ResultT> task) {
        if (task.isSuccessful()) {
            synchronized (this.f3233b) {
                try {
                    if (this.f3234c == null) {
                        return;
                    }
                    this.f3232a.execute(new RunnableC5341e(this, task));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
