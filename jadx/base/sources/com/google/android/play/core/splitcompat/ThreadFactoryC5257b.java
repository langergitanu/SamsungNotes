package com.google.android.play.core.splitcompat;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: com.google.android.play.core.splitcompat.b */
/* JADX INFO: loaded from: classes5.dex */
final class ThreadFactoryC5257b implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "SplitCompatBackgroundThread");
    }
}
