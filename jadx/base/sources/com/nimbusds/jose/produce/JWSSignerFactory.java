package com.nimbusds.jose.produce;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSProvider;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.jwk.JWK;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface JWSSignerFactory extends JWSProvider {
    JWSSigner createJWSSigner(JWK jwk);

    JWSSigner createJWSSigner(JWK jwk, JWSAlgorithm jWSAlgorithm);
}
