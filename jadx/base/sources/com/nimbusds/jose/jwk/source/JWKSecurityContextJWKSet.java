package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.proc.JWKSecurityContext;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class JWKSecurityContextJWKSet implements JWKSource<JWKSecurityContext> {
    @Override // com.nimbusds.jose.jwk.source.JWKSource
    public List<JWK> get(JWKSelector jWKSelector, JWKSecurityContext jWKSecurityContext) {
        if (jWKSecurityContext != null) {
            return jWKSelector.select(new JWKSet(jWKSecurityContext.getKeys()));
        }
        throw new IllegalArgumentException("Security Context must not be null");
    }
}
