package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.util.events.EventListener;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class RateLimitedJWKSetSource<C extends SecurityContext> extends JWKSetSourceWrapper<C> {
    private int counter;
    private final EventListener<RateLimitedJWKSetSource<C>, C> eventListener;
    private final long minTimeInterval;
    private long nextOpeningTime;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RateLimitedEvent<C extends SecurityContext> extends AbstractJWKSetSourceEvent<RateLimitedJWKSetSource<C>, C> {
        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ SecurityContext getContext() {
            return super.getContext();
        }

        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ JWKSetSource getSource() {
            return super.getSource();
        }

        private RateLimitedEvent(RateLimitedJWKSetSource<C> rateLimitedJWKSetSource, C c) {
            super(rateLimitedJWKSetSource, c);
        }
    }

    public RateLimitedJWKSetSource(JWKSetSource<C> jWKSetSource, long j, EventListener<RateLimitedJWKSetSource<C>, C> eventListener) {
        super(jWKSetSource);
        this.nextOpeningTime = -1L;
        this.counter = 0;
        this.minTimeInterval = j;
        this.eventListener = eventListener;
    }

    @Override // com.nimbusds.jose.jwk.source.JWKSetSource
    public JWKSet getJWKSet(JWKSetCacheRefreshEvaluator jWKSetCacheRefreshEvaluator, long j, C c) throws RateLimitReachedException {
        boolean z;
        synchronized (this) {
            try {
                if (this.nextOpeningTime <= j) {
                    this.nextOpeningTime = this.minTimeInterval + j;
                    this.counter = 1;
                } else {
                    int i = this.counter;
                    z = i <= 0;
                    if (!z) {
                        this.counter = i - 1;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z) {
            return getSource().getJWKSet(jWKSetCacheRefreshEvaluator, j, c);
        }
        EventListener<RateLimitedJWKSetSource<C>, C> eventListener = this.eventListener;
        if (eventListener != null) {
            eventListener.notify(new RateLimitedEvent(c));
        }
        throw new RateLimitReachedException();
    }

    public long getMinTimeInterval() {
        return this.minTimeInterval;
    }
}
