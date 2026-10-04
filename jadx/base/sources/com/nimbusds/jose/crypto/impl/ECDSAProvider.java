package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ECDSAProvider extends BaseJWSProvider {
    public static final Set<JWSAlgorithm> SUPPORTED_ALGORITHMS;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(JWSAlgorithm.ES256);
        linkedHashSet.add(JWSAlgorithm.ES256K);
        linkedHashSet.add(JWSAlgorithm.ES384);
        linkedHashSet.add(JWSAlgorithm.ES512);
        SUPPORTED_ALGORITHMS = Collections.unmodifiableSet(linkedHashSet);
    }

    public ECDSAProvider(JWSAlgorithm jWSAlgorithm) throws JOSEException {
        super(Collections.singleton(jWSAlgorithm));
        if (SUPPORTED_ALGORITHMS.contains(jWSAlgorithm)) {
            return;
        }
        throw new JOSEException("Unsupported EC DSA algorithm: " + jWSAlgorithm);
    }

    public JWSAlgorithm supportedECDSAAlgorithm() {
        return supportedJWSAlgorithms().iterator().next();
    }
}
