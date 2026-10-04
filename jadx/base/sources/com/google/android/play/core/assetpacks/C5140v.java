package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C5195bq;
import com.google.android.play.core.internal.InterfaceC5219cn;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.v */
/* JADX INFO: loaded from: classes5.dex */
public final class C5140v implements InterfaceC5219cn<Executor> {
    /* JADX INFO: renamed from: b */
    public static Executor m3853b() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(ThreadFactoryC5130m.f2900a);
        C5195bq.m3949b(executorServiceNewSingleThreadExecutor);
        return executorServiceNewSingleThreadExecutor;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ Executor mo3591a() {
        return m3853b();
    }
}
