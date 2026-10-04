package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class ReferenceComparisonRefreshJWKSetEvaluator extends JWKSetCacheRefreshEvaluator {
    private final JWKSet jwkSet;

    public ReferenceComparisonRefreshJWKSetEvaluator(JWKSet jWKSet) {
        this.jwkSet = jWKSet;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Objects.equals(this.jwkSet, ((ReferenceComparisonRefreshJWKSetEvaluator) obj).jwkSet);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.jwkSet);
    }

    @Override // com.nimbusds.jose.jwk.source.JWKSetCacheRefreshEvaluator
    public boolean requiresRefresh(JWKSet jWKSet) {
        return jWKSet == this.jwkSet;
    }
}
