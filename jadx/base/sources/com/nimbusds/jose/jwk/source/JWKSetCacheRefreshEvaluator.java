package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class JWKSetCacheRefreshEvaluator {
    private static final ForceRefreshJWKSetCacheEvaluator FORCE_REFRESH = new ForceRefreshJWKSetCacheEvaluator();
    private static final NoRefreshJWKSetCacheEvaluator NO_REFRESH = new NoRefreshJWKSetCacheEvaluator();

    public static JWKSetCacheRefreshEvaluator forceRefresh() {
        return FORCE_REFRESH;
    }

    public static JWKSetCacheRefreshEvaluator noRefresh() {
        return NO_REFRESH;
    }

    public static JWKSetCacheRefreshEvaluator referenceComparison(JWKSet jWKSet) {
        return new ReferenceComparisonRefreshJWKSetEvaluator(jWKSet);
    }

    public abstract boolean requiresRefresh(JWKSet jWKSet);
}
