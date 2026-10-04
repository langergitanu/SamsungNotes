package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C5195bq;
import com.google.android.play.core.internal.InterfaceC5219cn;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.p */
/* JADX INFO: loaded from: classes5.dex */
public final class C5134p implements InterfaceC5219cn<Executor> {
    /* JADX INFO: renamed from: b */
    public static Executor m3849b() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(ThreadFactoryC5129l.f2899a);
        C5195bq.m3949b(executorServiceNewSingleThreadExecutor);
        return executorServiceNewSingleThreadExecutor;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ Executor mo3591a() {
        return m3849b();
    }
}
