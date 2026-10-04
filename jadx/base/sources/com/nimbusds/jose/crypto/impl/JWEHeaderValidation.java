package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class JWEHeaderValidation {
    private JWEHeaderValidation() {
    }

    public static JWEAlgorithm getAlgorithmAndEnsureNotNull(JWEHeader jWEHeader) throws JOSEException {
        JWEAlgorithm algorithm = jWEHeader.getAlgorithm();
        if (algorithm != null) {
            return algorithm;
        }
        throw new JOSEException("The algorithm \"alg\" header parameter must not be null");
    }
}
