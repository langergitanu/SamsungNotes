package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.util.cache.CachedObject;
import com.nimbusds.jose.util.events.EventListener;
import java.util.Objects;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class OutageTolerantJWKSetSource<C extends SecurityContext> extends AbstractCachingJWKSetSource<C> {
    private final EventListener<OutageTolerantJWKSetSource<C>, C> eventListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class OutageEvent<C extends SecurityContext> extends AbstractJWKSetSourceEvent<OutageTolerantJWKSetSource<C>, C> {
        private final Exception exception;
        private final long remainingTime;

        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ SecurityContext getContext() {
            return super.getContext();
        }

        public Exception getException() {
            return this.exception;
        }

        public long getRemainingTime() {
            return this.remainingTime;
        }

        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ JWKSetSource getSource() {
            return super.getSource();
        }

        private OutageEvent(OutageTolerantJWKSetSource<C> outageTolerantJWKSetSource, Exception exc, long j, C c) {
            super(outageTolerantJWKSetSource, c);
            Objects.requireNonNull(exc);
            this.exception = exc;
            this.remainingTime = j;
        }
    }

    public OutageTolerantJWKSetSource(JWKSetSource<C> jWKSetSource, long j, EventListener<OutageTolerantJWKSetSource<C>, C> eventListener) {
        super(jWKSetSource, j);
        this.eventListener = eventListener;
    }

    @Override // com.nimbusds.jose.jwk.source.JWKSetSource
    public JWKSet getJWKSet(JWKSetCacheRefreshEvaluator jWKSetCacheRefreshEvaluator, long j, C c) throws JWKSetUnavailableException {
        try {
            JWKSet jWKSet = getSource().getJWKSet(jWKSetCacheRefreshEvaluator, j, c);
            cacheJWKSet(jWKSet, j);
            return jWKSet;
        } catch (JWKSetUnavailableException e) {
            CachedObject<JWKSet> cachedJWKSet = getCachedJWKSet();
            if (cachedJWKSet == null || !cachedJWKSet.isValid(j)) {
                throw e;
            }
            long expirationTime = cachedJWKSet.getExpirationTime() - j;
            EventListener<OutageTolerantJWKSetSource<C>, C> eventListener = this.eventListener;
            if (eventListener != null) {
                eventListener.notify(new OutageEvent(e, expirationTime, c));
            }
            JWKSet jWKSet2 = new JWKSet(cachedJWKSet.get().getKeys());
            if (jWKSetCacheRefreshEvaluator.requiresRefresh(jWKSet2)) {
                throw e;
            }
            return jWKSet2;
        }
    }

    @Override // com.nimbusds.jose.jwk.source.AbstractCachingJWKSetSource
    public /* bridge */ /* synthetic */ long getTimeToLive() {
        return super.getTimeToLive();
    }
}
