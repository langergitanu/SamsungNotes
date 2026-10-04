package com.google.android.gms.gcm;

import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractC4539a;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
final class zze implements ThreadFactory {
    private final AtomicInteger zzy = new AtomicInteger(1);

    public zze(GcmTaskService gcmTaskService) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(@NonNull Runnable runnable) {
        Thread thread = new Thread(runnable, AbstractC4539a.m3197g(20, this.zzy.getAndIncrement(), "gcm-task#"));
        thread.setPriority(4);
        return thread;
    }
}
