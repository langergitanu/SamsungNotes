package com.nimbusds.jose.jwk;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface AsymmetricJWK {
    boolean matches(X509Certificate x509Certificate);

    KeyPair toKeyPair();

    PrivateKey toPrivateKey();

    PublicKey toPublicKey();
}
