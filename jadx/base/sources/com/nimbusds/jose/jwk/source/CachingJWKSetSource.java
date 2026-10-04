package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.util.cache.CachedObject;
import com.nimbusds.jose.util.events.EventListener;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class CachingJWKSetSource<C extends SecurityContext> extends AbstractCachingJWKSetSource<C> {
    private final long cacheRefreshTimeout;
    private final EventListener<CachingJWKSetSource<C>, C> eventListener;
    private final ReentrantLock lock;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AbstractCachingJWKSetSourceEvent<C extends SecurityContext> extends AbstractJWKSetSourceEvent<CachingJWKSetSource<C>, C> {
        private final int threadQueueLength;

        public AbstractCachingJWKSetSourceEvent(CachingJWKSetSource<C> cachingJWKSetSource, int i, C c) {
            super(cachingJWKSetSource, c);
            this.threadQueueLength = i;
        }

        public int getThreadQueueLength() {
            return this.threadQueueLength;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RefreshCompletedEvent<C extends SecurityContext> extends AbstractCachingJWKSetSourceEvent<C> {
        private final JWKSet jwkSet;

        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ SecurityContext getContext() {
            return super.getContext();
        }

        public JWKSet getJWKSet() {
            return this.jwkSet;
        }

        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ JWKSetSource getSource() {
            return super.getSource();
        }

        @Override // com.nimbusds.jose.jwk.source.CachingJWKSetSource.AbstractCachingJWKSetSourceEvent
        public /* bridge */ /* synthetic */ int getThreadQueueLength() {
            return super.getThreadQueueLength();
        }

        private RefreshCompletedEvent(CachingJWKSetSource<C> cachingJWKSetSource, JWKSet jWKSet, int i, C c) {
            super(cachingJWKSetSource, i, c);
            Objects.requireNonNull(jWKSet);
            this.jwkSet = jWKSet;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RefreshInitiatedEvent<C extends SecurityContext> extends AbstractCachingJWKSetSourceEvent<C> {
        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ SecurityContext getContext() {
            return super.getContext();
        }

        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ JWKSetSource getSource() {
            return super.getSource();
        }

        @Override // com.nimbusds.jose.jwk.source.CachingJWKSetSource.AbstractCachingJWKSetSourceEvent
        public /* bridge */ /* synthetic */ int getThreadQueueLength() {
            return super.getThreadQueueLength();
        }

        private RefreshInitiatedEvent(CachingJWKSetSource<C> cachingJWKSetSource, int i, C c) {
            super(cachingJWKSetSource, i, c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RefreshTimedOutEvent<C extends SecurityContext> extends AbstractCachingJWKSetSourceEvent<C> {
        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ SecurityContext getContext() {
            return super.getContext();
        }

        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ JWKSetSource getSource() {
            return super.getSource();
        }

        @Override // com.nimbusds.jose.jwk.source.CachingJWKSetSource.AbstractCachingJWKSetSourceEvent
        public /* bridge */ /* synthetic */ int getThreadQueueLength() {
            return super.getThreadQueueLength();
        }

        private RefreshTimedOutEvent(CachingJWKSetSource<C> cachingJWKSetSource, int i, C c) {
            super(cachingJWKSetSource, i, c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UnableToRefreshEvent<C extends SecurityContext> extends AbstractJWKSetSourceEvent<CachingJWKSetSource<C>, C> {
        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ SecurityContext getContext() {
            return super.getContext();
        }

        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ JWKSetSource getSource() {
            return super.getSource();
        }

        private UnableToRefreshEvent(CachingJWKSetSource<C> cachingJWKSetSource, C c) {
            super(cachingJWKSetSource, c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class WaitingForRefreshEvent<C extends SecurityContext> extends AbstractCachingJWKSetSourceEvent<C> {
        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ SecurityContext getContext() {
            return super.getContext();
        }

        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ JWKSetSource getSource() {
            return super.getSource();
        }

        @Override // com.nimbusds.jose.jwk.source.CachingJWKSetSource.AbstractCachingJWKSetSourceEvent
        public /* bridge */ /* synthetic */ int getThreadQueueLength() {
            return super.getThreadQueueLength();
        }

        private WaitingForRefreshEvent(CachingJWKSetSource<C> cachingJWKSetSource, int i, C c) {
            super(cachingJWKSetSource, i, c);
        }
    }

    public CachingJWKSetSource(JWKSetSource<C> jWKSetSource, long j, long j2, EventListener<CachingJWKSetSource<C>, C> eventListener) {
        super(jWKSetSource, j);
        this.lock = new ReentrantLock();
        this.cacheRefreshTimeout = j2;
        this.eventListener = eventListener;
    }

    public long getCacheRefreshTimeout() {
        return this.cacheRefreshTimeout;
    }

    @Override // com.nimbusds.jose.jwk.source.JWKSetSource
    public JWKSet getJWKSet(JWKSetCacheRefreshEvaluator jWKSetCacheRefreshEvaluator, long j, C c) {
        CachedObject<JWKSet> cachedJWKSet = getCachedJWKSet();
        if (cachedJWKSet == null) {
            return loadJWKSetBlocking(JWKSetCacheRefreshEvaluator.noRefresh(), j, c);
        }
        JWKSet jWKSet = cachedJWKSet.get();
        return jWKSetCacheRefreshEvaluator.requiresRefresh(jWKSet) ? loadJWKSetBlocking(jWKSetCacheRefreshEvaluator, j, c) : cachedJWKSet.isExpired(j) ? loadJWKSetBlocking(JWKSetCacheRefreshEvaluator.referenceComparison(jWKSet), j, c) : cachedJWKSet.get();
    }

    public ReentrantLock getLock() {
        return this.lock;
    }

    @Override // com.nimbusds.jose.jwk.source.AbstractCachingJWKSetSource
    public /* bridge */ /* synthetic */ long getTimeToLive() {
        return super.getTimeToLive();
    }

    public JWKSet loadJWKSetBlocking(JWKSetCacheRefreshEvaluator jWKSetCacheRefreshEvaluator, long j, C c) throws JWKSetUnavailableException {
        CachedObject<JWKSet> cachedJWKSet;
        try {
            if (this.lock.tryLock()) {
                try {
                    cachedJWKSet = getCachedJWKSet();
                    if (cachedJWKSet == null || jWKSetCacheRefreshEvaluator.requiresRefresh(cachedJWKSet.get())) {
                        EventListener<CachingJWKSetSource<C>, C> eventListener = this.eventListener;
                        if (eventListener != null) {
                            eventListener.notify(new RefreshInitiatedEvent(this.lock.getQueueLength(), c));
                        }
                        CachedObject<JWKSet> cachedObjectLoadJWKSetNotThreadSafe = loadJWKSetNotThreadSafe(jWKSetCacheRefreshEvaluator, j, c);
                        EventListener<CachingJWKSetSource<C>, C> eventListener2 = this.eventListener;
                        if (eventListener2 != null) {
                            eventListener2.notify(new RefreshCompletedEvent(cachedObjectLoadJWKSetNotThreadSafe.get(), this.lock.getQueueLength(), c));
                        }
                        cachedJWKSet = cachedObjectLoadJWKSetNotThreadSafe;
                    }
                    this.lock.unlock();
                } finally {
                }
            } else {
                EventListener<CachingJWKSetSource<C>, C> eventListener3 = this.eventListener;
                if (eventListener3 != null) {
                    eventListener3.notify(new WaitingForRefreshEvent(this.lock.getQueueLength(), c));
                }
                if (!this.lock.tryLock(getCacheRefreshTimeout(), TimeUnit.MILLISECONDS)) {
                    EventListener<CachingJWKSetSource<C>, C> eventListener4 = this.eventListener;
                    if (eventListener4 != null) {
                        eventListener4.notify(new RefreshTimedOutEvent(this.lock.getQueueLength(), c));
                    }
                    throw new JWKSetUnavailableException("Timeout while waiting for cache refresh (" + this.cacheRefreshTimeout + "ms exceeded)");
                }
                try {
                    cachedJWKSet = getCachedJWKSet();
                    if (cachedJWKSet == null || jWKSetCacheRefreshEvaluator.requiresRefresh(cachedJWKSet.get())) {
                        EventListener<CachingJWKSetSource<C>, C> eventListener5 = this.eventListener;
                        if (eventListener5 != null) {
                            eventListener5.notify(new RefreshInitiatedEvent(this.lock.getQueueLength(), c));
                        }
                        CachedObject<JWKSet> cachedObjectLoadJWKSetNotThreadSafe2 = loadJWKSetNotThreadSafe(jWKSetCacheRefreshEvaluator, j, c);
                        EventListener<CachingJWKSetSource<C>, C> eventListener6 = this.eventListener;
                        if (eventListener6 != null) {
                            eventListener6.notify(new RefreshCompletedEvent(cachedObjectLoadJWKSetNotThreadSafe2.get(), this.lock.getQueueLength(), c));
                        }
                        cachedJWKSet = cachedObjectLoadJWKSetNotThreadSafe2;
                    }
                    this.lock.unlock();
                } finally {
                }
            }
            if (cachedJWKSet != null && cachedJWKSet.isValid(j)) {
                return cachedJWKSet.get();
            }
            EventListener<CachingJWKSetSource<C>, C> eventListener7 = this.eventListener;
            if (eventListener7 != null) {
                eventListener7.notify(new UnableToRefreshEvent(c));
            }
            throw new JWKSetUnavailableException("Unable to refresh cache");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new JWKSetUnavailableException("Interrupted while waiting for cache refresh", e);
        }
    }

    public CachedObject<JWKSet> loadJWKSetNotThreadSafe(JWKSetCacheRefreshEvaluator jWKSetCacheRefreshEvaluator, long j, C c) {
        return cacheJWKSet(getSource().getJWKSet(jWKSetCacheRefreshEvaluator, j, c), j);
    }
}
