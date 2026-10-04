package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RSAKeyUtils {
    public static int keyBitLength(PrivateKey privateKey) {
        if (!(privateKey instanceof RSAPrivateKey)) {
            return -1;
        }
        try {
            return ((RSAPrivateKey) privateKey).getModulus().bitLength();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static PrivateKey toRSAPrivateKey(RSAKey rSAKey) throws JOSEException {
        if (rSAKey.isPrivate()) {
            return rSAKey.toPrivateKey();
        }
        throw new JOSEException("The RSA JWK doesn't contain a private part");
    }
}
