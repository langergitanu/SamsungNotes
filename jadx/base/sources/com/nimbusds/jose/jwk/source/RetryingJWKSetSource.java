package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.util.events.EventListener;
import java.util.Objects;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class RetryingJWKSetSource<C extends SecurityContext> extends JWKSetSourceWrapper<C> {
    private final EventListener<RetryingJWKSetSource<C>, C> eventListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RetrialEvent<C extends SecurityContext> extends AbstractJWKSetSourceEvent<RetryingJWKSetSource<C>, C> {
        private final Exception exception;

        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ SecurityContext getContext() {
            return super.getContext();
        }

        public Exception getException() {
            return this.exception;
        }

        @Override // com.nimbusds.jose.jwk.source.AbstractJWKSetSourceEvent, com.nimbusds.jose.util.events.Event
        public /* bridge */ /* synthetic */ JWKSetSource getSource() {
            return super.getSource();
        }

        private RetrialEvent(RetryingJWKSetSource<C> retryingJWKSetSource, Exception exc, C c) {
            super(retryingJWKSetSource, c);
            Objects.requireNonNull(exc);
            this.exception = exc;
        }
    }

    public RetryingJWKSetSource(JWKSetSource<C> jWKSetSource, EventListener<RetryingJWKSetSource<C>, C> eventListener) {
        super(jWKSetSource);
        this.eventListener = eventListener;
    }

    @Override // com.nimbusds.jose.jwk.source.JWKSetSource
    public JWKSet getJWKSet(JWKSetCacheRefreshEvaluator jWKSetCacheRefreshEvaluator, long j, C c) {
        try {
            return getSource().getJWKSet(jWKSetCacheRefreshEvaluator, j, c);
        } catch (JWKSetUnavailableException e) {
            EventListener<RetryingJWKSetSource<C>, C> eventListener = this.eventListener;
            if (eventListener != null) {
                eventListener.notify(new RetrialEvent(e, c));
            }
            return getSource().getJWKSet(jWKSetCacheRefreshEvaluator, j, c);
        }
    }
}
