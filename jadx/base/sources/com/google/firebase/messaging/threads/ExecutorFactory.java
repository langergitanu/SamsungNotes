package com.google.firebase.messaging.threads;

import com.google.errorprone.annotations.CompileTimeConstant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ExecutorFactory {
    void executeOneOff(@CompileTimeConstant String str, @CompileTimeConstant String str2, ThreadPriority threadPriority, Runnable runnable);

    ScheduledExecutorService newScheduledThreadPool(int i, ThreadPriority threadPriority);

    ScheduledExecutorService newScheduledThreadPool(int i, ThreadFactory threadFactory, ThreadPriority threadPriority);

    ExecutorService newSingleThreadExecutor(ThreadPriority threadPriority);

    ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory, ThreadPriority threadPriority);

    ExecutorService newThreadPool(int i, ThreadPriority threadPriority);

    ExecutorService newThreadPool(int i, ThreadFactory threadFactory, ThreadPriority threadPriority);

    ExecutorService newThreadPool(ThreadPriority threadPriority);

    ExecutorService newThreadPool(ThreadFactory threadFactory, ThreadPriority threadPriority);

    Future<?> submitOneOff(@CompileTimeConstant String str, @CompileTimeConstant String str2, ThreadPriority threadPriority, Runnable runnable);
}
