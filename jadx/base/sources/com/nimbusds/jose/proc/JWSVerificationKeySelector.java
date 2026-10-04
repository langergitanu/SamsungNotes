package com.nimbusds.jose.proc;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKMatcher;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.KeyConverter;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import java.security.Key;
import java.security.PublicKey;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class JWSVerificationKeySelector<C extends SecurityContext> extends AbstractJWKSelectorWithSource<C> implements JWSKeySelector<C> {
    private final Set<JWSAlgorithm> jwsAlgs;
    private final boolean singleJwsAlgConstructorWasCalled;

    public JWSVerificationKeySelector(JWSAlgorithm jWSAlgorithm, JWKSource<C> jWKSource) {
        super(jWKSource);
        if (jWSAlgorithm == null) {
            throw new IllegalArgumentException("The JWS algorithm must not be null");
        }
        this.jwsAlgs = Collections.singleton(jWSAlgorithm);
        this.singleJwsAlgConstructorWasCalled = true;
    }

    public JWKMatcher createJWKMatcher(JWSHeader jWSHeader) {
        if (isAllowed(jWSHeader.getAlgorithm())) {
            return JWKMatcher.forJWSHeader(jWSHeader);
        }
        return null;
    }

    @Deprecated
    public JWSAlgorithm getExpectedJWSAlgorithm() {
        if (this.singleJwsAlgConstructorWasCalled) {
            return this.jwsAlgs.iterator().next();
        }
        throw new UnsupportedOperationException("Since this class was constructed with multiple algorithms, the behavior of this method is undefined.");
    }

    @Override // com.nimbusds.jose.proc.AbstractJWKSelectorWithSource
    public /* bridge */ /* synthetic */ JWKSource getJWKSource() {
        return super.getJWKSource();
    }

    public boolean isAllowed(JWSAlgorithm jWSAlgorithm) {
        return this.jwsAlgs.contains(jWSAlgorithm);
    }

    @Override // com.nimbusds.jose.proc.JWSKeySelector
    public List<Key> selectJWSKeys(JWSHeader jWSHeader, C c) {
        if (!this.jwsAlgs.contains(jWSHeader.getAlgorithm())) {
            return Collections.EMPTY_LIST;
        }
        JWKMatcher jWKMatcherCreateJWKMatcher = createJWKMatcher(jWSHeader);
        if (jWKMatcherCreateJWKMatcher == null) {
            return Collections.EMPTY_LIST;
        }
        List<JWK> list = getJWKSource().get(new JWKSelector(jWKMatcherCreateJWKMatcher), c);
        LinkedList linkedList = new LinkedList();
        for (Key key : KeyConverter.toJavaKeys(list)) {
            if ((key instanceof PublicKey) || (key instanceof SecretKey)) {
                linkedList.add(key);
            }
        }
        return linkedList;
    }

    public JWSVerificationKeySelector(Set<JWSAlgorithm> set, JWKSource<C> jWKSource) {
        super(jWKSource);
        if (set != null && !set.isEmpty()) {
            this.jwsAlgs = Collections.unmodifiableSet(set);
            this.singleJwsAlgConstructorWasCalled = false;
            return;
        }
        throw new IllegalArgumentException("The JWS algorithms must not be null or empty");
    }
}
