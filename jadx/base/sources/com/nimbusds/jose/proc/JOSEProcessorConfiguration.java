package com.nimbusds.jose.proc;

import com.nimbusds.jose.proc.SecurityContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface JOSEProcessorConfiguration<C extends SecurityContext> {
    JWEDecrypterFactory getJWEDecrypterFactory();

    JWEKeySelector<C> getJWEKeySelector();

    JOSEObjectTypeVerifier<C> getJWETypeVerifier();

    JWSKeySelector<C> getJWSKeySelector();

    JOSEObjectTypeVerifier<C> getJWSTypeVerifier();

    JWSVerifierFactory getJWSVerifierFactory();

    void setJWEDecrypterFactory(JWEDecrypterFactory jWEDecrypterFactory);

    void setJWEKeySelector(JWEKeySelector<C> jWEKeySelector);

    void setJWETypeVerifier(JOSEObjectTypeVerifier<C> jOSEObjectTypeVerifier);

    void setJWSKeySelector(JWSKeySelector<C> jWSKeySelector);

    void setJWSTypeVerifier(JOSEObjectTypeVerifier<C> jOSEObjectTypeVerifier);

    void setJWSVerifierFactory(JWSVerifierFactory jWSVerifierFactory);
}
