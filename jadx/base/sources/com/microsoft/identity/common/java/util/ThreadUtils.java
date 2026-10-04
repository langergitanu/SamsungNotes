package com.microsoft.identity.common.java.util;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.microsoft.identity.common.java.logging.Logger;
import java.lang.Thread;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ThreadUtils {
    private static ThreadFactory getNamedThreadFactory(@NonNull String str, SecurityManager securityManager) {
        if (str != null) {
            return new ThreadFactory(str, securityManager) { // from class: com.microsoft.identity.common.java.util.ThreadUtils.1
                private final ThreadGroup group;
                private final String poolPrefix;
                private final AtomicLong threadNumber = new AtomicLong(1);
                final /* synthetic */ String val$poolName;
                final /* synthetic */ SecurityManager val$securityManager;

                {
                    this.val$poolName = str;
                    this.val$securityManager = securityManager;
                    this.poolPrefix = AbstractC0541b.m756B(str, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
                    this.group = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
                }

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(this.group, runnable, this.poolPrefix + this.threadNumber.getAndIncrement(), 0L);
                    thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.microsoft.identity.common.java.util.ThreadUtils.1.1
                        @Override // java.lang.Thread.UncaughtExceptionHandler
                        public void uncaughtException(@NonNull Thread thread2, @NonNull Throwable th) {
                            if (thread2 == null) {
                                throw new NullPointerException("t is marked non-null but is null");
                            }
                            if (th == null) {
                                throw new NullPointerException("e is marked non-null but is null");
                            }
                            if (th instanceof ThreadDeath) {
                                Logger.info(AbstractC0622a.m1170p(ThreadFactoryC64431.this.val$poolName, "]", new StringBuilder("ThreadPool[")), null, "Thread Death Exception in thread pool " + ThreadFactoryC64431.this.val$poolName);
                                return;
                            }
                            Logger.error(AbstractC0622a.m1170p(ThreadFactoryC64431.this.val$poolName, "]", new StringBuilder("ThreadPool[")), null, "Uncaught Exception in thread pool " + ThreadFactoryC64431.this.val$poolName, th);
                        }
                    });
                    return thread;
                }
            };
        }
        throw new NullPointerException("poolName is marked non-null but is null");
    }

    public static ExecutorService getNamedThreadPoolExecutor(int i, int i2, int i4, long j, @NonNull TimeUnit timeUnit, @NonNull String str) {
        if (timeUnit == null) {
            throw new NullPointerException("keepAliveUnit is marked non-null but is null");
        }
        if (str != null) {
            return i4 > 0 ? new ThreadPoolExecutor(i, i2, j, timeUnit, new ArrayBlockingQueue(i4), getNamedThreadFactory(str, System.getSecurityManager())) : i4 == 0 ? new ThreadPoolExecutor(i, i2, j, timeUnit, new SynchronousQueue(), getNamedThreadFactory(str, System.getSecurityManager())) : new ThreadPoolExecutor(i, i2, j, timeUnit, new LinkedBlockingQueue(), getNamedThreadFactory(str, System.getSecurityManager()));
        }
        throw new NullPointerException("poolName is marked non-null but is null");
    }

    public static void sleepSafely(int i, @NonNull String str, @NonNull String str2) {
        if (str == null) {
            throw new NullPointerException("tag is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("message is marked non-null but is null");
        }
        if (i > 0) {
            try {
                Thread.sleep(i);
            } catch (InterruptedException unused) {
                Logger.info(str, str2);
                Thread.currentThread().interrupt();
            }
        }
    }
}
