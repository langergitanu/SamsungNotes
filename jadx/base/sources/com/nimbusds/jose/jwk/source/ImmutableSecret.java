package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.proc.SecurityContext;
import javax.crypto.SecretKey;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public class ImmutableSecret<C extends SecurityContext> extends ImmutableJWKSet<C> {
    public ImmutableSecret(byte[] bArr) {
        super(new JWKSet(new OctetSequenceKey.Builder(bArr).build()));
    }

    public byte[] getSecret() {
        return ((OctetSequenceKey) getJWKSet().getKeys().get(0)).toByteArray();
    }

    public SecretKey getSecretKey() {
        return ((OctetSequenceKey) getJWKSet().getKeys().get(0)).toSecretKey();
    }

    public ImmutableSecret(SecretKey secretKey) {
        super(new JWKSet(new OctetSequenceKey.Builder(secretKey).build()));
    }
}
