package com.microsoft.identity.common.java.cache;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class HttpCache {
    private static IHttpCacheCallback sHttpCache;
    private static final ReentrantReadWriteLock sLock = new ReentrantReadWriteLock();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IHttpCacheCallback {
        void flush();
    }

    public static void flush() {
        ReentrantReadWriteLock reentrantReadWriteLock = sLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            IHttpCacheCallback iHttpCacheCallback = sHttpCache;
            if (iHttpCacheCallback != null) {
                iHttpCacheCallback.flush();
            }
            reentrantReadWriteLock.readLock().unlock();
        } catch (Throwable th) {
            sLock.readLock().unlock();
            throw th;
        }
    }

    public static void setHttpCache(@Nullable IHttpCacheCallback iHttpCacheCallback) {
        ReentrantReadWriteLock reentrantReadWriteLock = sLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            sHttpCache = iHttpCacheCallback;
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            sLock.writeLock().unlock();
            throw th;
        }
    }
}
