package cz.msebera.android.httpclient.impl.bootstrap;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class ThreadFactoryImpl implements ThreadFactory {
    private final AtomicLong count;
    private final ThreadGroup group;
    private final String namePrefix;

    public ThreadFactoryImpl(String str, ThreadGroup threadGroup) {
        this.namePrefix = str;
        this.group = threadGroup;
        this.count = new AtomicLong();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(this.group, runnable, this.namePrefix + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + this.count.incrementAndGet());
    }

    public ThreadFactoryImpl(String str) {
        this(str, null);
    }
}
