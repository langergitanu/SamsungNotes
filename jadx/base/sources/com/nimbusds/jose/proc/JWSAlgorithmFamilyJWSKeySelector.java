package com.nimbusds.jose.proc;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKMatcher;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.KeyType;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import java.net.URL;
import java.security.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class JWSAlgorithmFamilyJWSKeySelector<C extends SecurityContext> extends AbstractJWKSelectorWithSource<C> implements JWSKeySelector<C> {
    private final Map<JWSAlgorithm, JWSKeySelector<C>> selectors;

    public JWSAlgorithmFamilyJWSKeySelector(JWSAlgorithm.Family family, JWKSource<C> jWKSource) {
        super(jWKSource);
        this.selectors = new HashMap();
        if (family == null) {
            throw new IllegalArgumentException("JWS algorithm family must not be null");
        }
        Iterator<T> it = family.iterator();
        while (it.hasNext()) {
            JWSAlgorithm jWSAlgorithm = (JWSAlgorithm) it.next();
            this.selectors.put(jWSAlgorithm, new JWSVerificationKeySelector(jWSAlgorithm, jWKSource));
        }
    }

    public static <C extends SecurityContext> JWSAlgorithmFamilyJWSKeySelector<C> fromJWKSetURL(URL url) {
        return fromJWKSource(new RemoteJWKSet(url));
    }

    public static <C extends SecurityContext> JWSAlgorithmFamilyJWSKeySelector<C> fromJWKSource(JWKSource<C> jWKSource) throws KeySourceException {
        for (JWK jwk : jWKSource.get(new JWKSelector(new JWKMatcher.Builder().publicOnly(true).keyUses(KeyUse.SIGNATURE, null).keyTypes(KeyType.RSA, KeyType.f3634EC).build()), null)) {
            if (KeyType.RSA.equals(jwk.getKeyType())) {
                return new JWSAlgorithmFamilyJWSKeySelector<>(JWSAlgorithm.Family.RSA, jWKSource);
            }
            if (KeyType.f3634EC.equals(jwk.getKeyType())) {
                return new JWSAlgorithmFamilyJWSKeySelector<>(JWSAlgorithm.Family.f3624EC, jWKSource);
            }
        }
        throw new KeySourceException("Couldn't retrieve JWKs");
    }

    @Override // com.nimbusds.jose.proc.AbstractJWKSelectorWithSource
    public /* bridge */ /* synthetic */ JWKSource getJWKSource() {
        return super.getJWKSource();
    }

    @Override // com.nimbusds.jose.proc.JWSKeySelector
    public List<? extends Key> selectJWSKeys(JWSHeader jWSHeader, C c) {
        JWSKeySelector<C> jWSKeySelector = this.selectors.get(jWSHeader.getAlgorithm());
        return jWSKeySelector == null ? Collections.EMPTY_LIST : jWSKeySelector.selectJWSKeys(jWSHeader, c);
    }
}
