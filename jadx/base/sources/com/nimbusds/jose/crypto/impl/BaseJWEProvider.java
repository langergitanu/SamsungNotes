package com.nimbusds.jose.crypto.impl;

import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEProvider;
import com.nimbusds.jose.jca.JWEJCAContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseJWEProvider implements JWEProvider {
    private static final Set<String> ACCEPTABLE_CEK_ALGS = Collections.unmodifiableSet(new HashSet(Arrays.asList(AES256KeyLoader.AES_ALGORITHM, "ChaCha20")));
    private final Set<JWEAlgorithm> algs;
    private final SecretKey cek;
    private final Set<EncryptionMethod> encs;
    private final JWEJCAContext jcaContext;

    public BaseJWEProvider(Set<JWEAlgorithm> set, Set<EncryptionMethod> set2) {
        this(set, set2, null);
    }

    public SecretKey getCEK(EncryptionMethod encryptionMethod) {
        return (isCEKProvided() || encryptionMethod == null) ? this.cek : ContentCryptoProvider.generateCEK(encryptionMethod, this.jcaContext.getSecureRandom());
    }

    public boolean isCEKProvided() {
        return this.cek != null;
    }

    @Override // com.nimbusds.jose.JWEProvider
    public Set<EncryptionMethod> supportedEncryptionMethods() {
        return this.encs;
    }

    @Override // com.nimbusds.jose.JWEProvider
    public Set<JWEAlgorithm> supportedJWEAlgorithms() {
        return this.algs;
    }

    public BaseJWEProvider(Set<JWEAlgorithm> set, Set<EncryptionMethod> set2, SecretKey secretKey) {
        this.jcaContext = new JWEJCAContext();
        if (set == null) {
            throw new IllegalArgumentException("The supported JWE algorithm set must not be null");
        }
        this.algs = Collections.unmodifiableSet(set);
        if (set2 == null) {
            throw new IllegalArgumentException("The supported encryption methods must not be null");
        }
        this.encs = set2;
        if (secretKey != null && set.size() > 1 && (secretKey.getAlgorithm() == null || !ACCEPTABLE_CEK_ALGS.contains(secretKey.getAlgorithm()))) {
            throw new IllegalArgumentException("The algorithm of the content encryption key (CEK) must be AES or ChaCha20");
        }
        this.cek = secretKey;
    }

    @Override // com.nimbusds.jose.jca.JCAAware
    public JWEJCAContext getJCAContext() {
        return this.jcaContext;
    }
}
