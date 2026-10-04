package com.nimbusds.jwt.proc;

import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.PlainJWT;
import com.nimbusds.jwt.SignedJWT;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface JWTProcessor<C extends SecurityContext> {
    JWTClaimsSet process(EncryptedJWT encryptedJWT, C c);

    JWTClaimsSet process(JWT jwt, C c);

    JWTClaimsSet process(PlainJWT plainJWT, C c);

    JWTClaimsSet process(SignedJWT signedJWT, C c);

    JWTClaimsSet process(String str, C c);
}
