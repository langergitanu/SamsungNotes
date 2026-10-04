package com.nimbusds.jose.mint;

import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.produce.JWSSignerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface JWSMinterConfiguration<C extends SecurityContext> {
    JWKSource<C> getJWKSource();

    JWSSignerFactory getJWSSignerFactory();

    void setJWKSource(JWKSource<C> jWKSource);

    void setJWSSignerFactory(JWSSignerFactory jWSSignerFactory);
}
