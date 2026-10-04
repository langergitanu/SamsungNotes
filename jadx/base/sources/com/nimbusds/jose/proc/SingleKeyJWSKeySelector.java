package com.nimbusds.jose.proc;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.proc.SecurityContext;
import java.security.Key;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SingleKeyJWSKeySelector<C extends SecurityContext> implements JWSKeySelector<C> {
    private final JWSAlgorithm expectedJWSAlg;
    private final List<Key> singletonKeyList;

    public SingleKeyJWSKeySelector(JWSAlgorithm jWSAlgorithm, Key key) {
        if (jWSAlgorithm == null) {
            throw new IllegalArgumentException("The expected JWS algorithm cannot be null");
        }
        if (key == null) {
            throw new IllegalArgumentException("The key cannot be null");
        }
        this.singletonKeyList = Collections.singletonList(key);
        this.expectedJWSAlg = jWSAlgorithm;
    }

    @Override // com.nimbusds.jose.proc.JWSKeySelector
    public List<? extends Key> selectJWSKeys(JWSHeader jWSHeader, C c) {
        return !this.expectedJWSAlg.equals(jWSHeader.getAlgorithm()) ? Collections.EMPTY_LIST : this.singletonKeyList;
    }
}
