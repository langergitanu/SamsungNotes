package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.l */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class ThreadFactoryC5129l implements ThreadFactory {

    /* JADX INFO: renamed from: a */
    static final ThreadFactory f2899a = new ThreadFactoryC5129l();

    private ThreadFactoryC5129l() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AssetPackBackgroundExecutor");
    }
}
