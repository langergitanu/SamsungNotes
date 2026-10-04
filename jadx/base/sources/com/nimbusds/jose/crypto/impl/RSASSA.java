package com.nimbusds.jose.crypto.impl;

import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RSASSA {
    private RSASSA() {
    }

    public static Signature getSignerAndVerifier(JWSAlgorithm jWSAlgorithm, Provider provider) throws JOSEException {
        Signature signerAndVerifier;
        Signature signerAndVerifier2;
        Signature signerAndVerifier3;
        Signature signerAndVerifier4;
        Signature signerAndVerifier5;
        Signature signerAndVerifier6;
        Signature signerAndVerifier7;
        Signature signerAndVerifier8;
        Signature signerAndVerifier9;
        if (jWSAlgorithm.equals(JWSAlgorithm.RS256) && (signerAndVerifier9 = getSignerAndVerifier("SHA256withRSA", provider)) != null) {
            return signerAndVerifier9;
        }
        if (jWSAlgorithm.equals(JWSAlgorithm.RS384) && (signerAndVerifier8 = getSignerAndVerifier("SHA384withRSA", provider)) != null) {
            return signerAndVerifier8;
        }
        if (jWSAlgorithm.equals(JWSAlgorithm.RS512) && (signerAndVerifier7 = getSignerAndVerifier("SHA512withRSA", provider)) != null) {
            return signerAndVerifier7;
        }
        JWSAlgorithm jWSAlgorithm2 = JWSAlgorithm.PS256;
        if (jWSAlgorithm.equals(jWSAlgorithm2) && (signerAndVerifier6 = getSignerAndVerifier("RSASSA-PSS", provider, new PSSParameterSpec("SHA-256", IDevicePopManager.MGF_1, MGF1ParameterSpec.SHA256, 32, 1))) != null) {
            return signerAndVerifier6;
        }
        if (jWSAlgorithm.equals(jWSAlgorithm2) && (signerAndVerifier5 = getSignerAndVerifier("SHA256withRSAandMGF1", provider)) != null) {
            return signerAndVerifier5;
        }
        JWSAlgorithm jWSAlgorithm3 = JWSAlgorithm.PS384;
        if (jWSAlgorithm.equals(jWSAlgorithm3) && (signerAndVerifier4 = getSignerAndVerifier("RSASSA-PSS", provider, new PSSParameterSpec("SHA-384", IDevicePopManager.MGF_1, MGF1ParameterSpec.SHA384, 48, 1))) != null) {
            return signerAndVerifier4;
        }
        if (jWSAlgorithm.equals(jWSAlgorithm3) && (signerAndVerifier3 = getSignerAndVerifier("SHA384withRSAandMGF1", provider)) != null) {
            return signerAndVerifier3;
        }
        JWSAlgorithm jWSAlgorithm4 = JWSAlgorithm.PS512;
        if (jWSAlgorithm.equals(jWSAlgorithm4) && (signerAndVerifier2 = getSignerAndVerifier("RSASSA-PSS", provider, new PSSParameterSpec("SHA-512", IDevicePopManager.MGF_1, MGF1ParameterSpec.SHA512, 64, 1))) != null) {
            return signerAndVerifier2;
        }
        if (!jWSAlgorithm.equals(jWSAlgorithm4) || (signerAndVerifier = getSignerAndVerifier("SHA512withRSAandMGF1", provider)) == null) {
            throw new JOSEException(AlgorithmSupportMessage.unsupportedJWSAlgorithm(jWSAlgorithm, RSASSAProvider.SUPPORTED_ALGORITHMS));
        }
        return signerAndVerifier;
    }

    private static Signature getSignerAndVerifier(String str, Provider provider) {
        return getSignerAndVerifier(str, provider, null);
    }

    private static Signature getSignerAndVerifier(String str, Provider provider, PSSParameterSpec pSSParameterSpec) throws JOSEException {
        Signature signature;
        try {
            if (provider != null) {
                signature = Signature.getInstance(str, provider);
            } else {
                signature = Signature.getInstance(str);
            }
            if (pSSParameterSpec == null) {
                return signature;
            }
            try {
                signature.setParameter(pSSParameterSpec);
                return signature;
            } catch (InvalidAlgorithmParameterException e) {
                throw new JOSEException("Invalid RSASSA-PSS salt length parameter: " + e.getMessage(), e);
            }
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
