package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.m */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class ThreadFactoryC5130m implements ThreadFactory {

    /* JADX INFO: renamed from: a */
    static final ThreadFactory f2900a = new ThreadFactoryC5130m();

    private ThreadFactoryC5130m() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "UpdateListenerExecutor");
    }
}
