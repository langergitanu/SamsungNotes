package com.nimbusds.jose.crypto.impl;

import com.microsoft.identity.common.java.crypto.key.KeyUtil;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import java.security.Provider;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class PRFParams {
    private final int dkLen;
    private final String jcaMacAlg;
    private final Provider macProvider;

    public PRFParams(String str, Provider provider, int i) {
        this.jcaMacAlg = str;
        this.macProvider = provider;
        this.dkLen = i;
    }

    public static PRFParams resolve(JWEAlgorithm jWEAlgorithm, Provider provider) throws JOSEException {
        String str;
        int i;
        if (JWEAlgorithm.PBES2_HS256_A128KW.equals(jWEAlgorithm)) {
            str = KeyUtil.HMAC_ALGORITHM;
            i = 16;
        } else if (JWEAlgorithm.PBES2_HS384_A192KW.equals(jWEAlgorithm)) {
            str = "HmacSHA384";
            i = 24;
        } else {
            if (!JWEAlgorithm.PBES2_HS512_A256KW.equals(jWEAlgorithm)) {
                throw new JOSEException(AlgorithmSupportMessage.unsupportedJWEAlgorithm(jWEAlgorithm, PasswordBasedCryptoProvider.SUPPORTED_ALGORITHMS));
            }
            str = "HmacSHA512";
            i = 32;
        }
        return new PRFParams(str, provider, i);
    }

    public int getDerivedKeyByteLength() {
        return this.dkLen;
    }

    public String getMACAlgorithm() {
        return this.jcaMacAlg;
    }

    public Provider getMacProvider() {
        return this.macProvider;
    }
}
