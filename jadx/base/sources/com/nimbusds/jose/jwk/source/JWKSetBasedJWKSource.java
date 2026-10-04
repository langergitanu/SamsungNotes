package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class JWKSetBasedJWKSource<C extends SecurityContext> implements JWKSource<C>, Closeable {
    private final JWKSetSource<C> source;

    public JWKSetBasedJWKSource(JWKSetSource<C> jWKSetSource) {
        Objects.requireNonNull(jWKSetSource);
        this.source = jWKSetSource;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    @Override // com.nimbusds.jose.jwk.source.JWKSource
    public List<JWK> get(JWKSelector jWKSelector, C c) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JWKSet jWKSet = this.source.getJWKSet(JWKSetCacheRefreshEvaluator.noRefresh(), jCurrentTimeMillis, c);
        List<JWK> listSelect = jWKSelector.select(jWKSet);
        return listSelect.isEmpty() ? jWKSelector.select(this.source.getJWKSet(JWKSetCacheRefreshEvaluator.referenceComparison(jWKSet), jCurrentTimeMillis, c)) : listSelect;
    }

    public JWKSetSource<C> getJWKSetSource() {
        return this.source;
    }
}
