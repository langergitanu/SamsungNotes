package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.util.ResourceRetriever;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class URLBasedJWKSetSource<C extends SecurityContext> implements JWKSetSource<C> {
    private final ResourceRetriever resourceRetriever;
    private final URL url;

    public URLBasedJWKSetSource(URL url, ResourceRetriever resourceRetriever) {
        Objects.requireNonNull(url, "The URL must not be null");
        this.url = url;
        Objects.requireNonNull(resourceRetriever, "The resource retriever must not be null");
        this.resourceRetriever = resourceRetriever;
    }

    @Override // com.nimbusds.jose.jwk.source.JWKSetSource
    public JWKSet getJWKSet(JWKSetCacheRefreshEvaluator jWKSetCacheRefreshEvaluator, long j, C c) throws JWKSetRetrievalException, JWKSetParseException {
        try {
            try {
                return JWKSet.parse(this.resourceRetriever.retrieveResource(this.url).getContent());
            } catch (Exception e) {
                throw new JWKSetParseException("Unable to parse JWK set", e);
            }
        } catch (IOException e2) {
            throw new JWKSetRetrievalException("Couldn't retrieve JWK set from URL: " + e2.getMessage(), e2);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
