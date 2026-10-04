package com.google.android.play.core.tasks;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.play.core.tasks.b */
/* JADX INFO: loaded from: classes5.dex */
final class C5338b<ResultT> implements InterfaceC5343g<ResultT> {

    /* JADX INFO: renamed from: a */
    private final Executor f3222a;

    /* JADX INFO: renamed from: b */
    private final Object f3223b = new Object();

    /* JADX INFO: renamed from: c */
    @Nullable
    private final OnCompleteListener<ResultT> f3224c;

    public C5338b(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.f3222a = executor;
        this.f3224c = onCompleteListener;
    }

    @Override // com.google.android.play.core.tasks.InterfaceC5343g
    /* JADX INFO: renamed from: a */
    public final void mo4190a(Task<ResultT> task) {
        synchronized (this.f3223b) {
            try {
                if (this.f3224c == null) {
                    return;
                }
                this.f3222a.execute(new RunnableC5337a(this, task));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
