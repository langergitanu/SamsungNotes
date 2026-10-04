package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.util.ByteUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AESCryptoProvider extends BaseJWEProvider {
    public static final Map<Integer, Set<JWEAlgorithm>> COMPATIBLE_ALGORITHMS;
    public static final Set<JWEAlgorithm> SUPPORTED_ALGORITHMS;
    public static final Set<EncryptionMethod> SUPPORTED_ENCRYPTION_METHODS = ContentCryptoProvider.SUPPORTED_ENCRYPTION_METHODS;
    private final SecretKey kek;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        JWEAlgorithm jWEAlgorithm = JWEAlgorithm.A128KW;
        linkedHashSet.add(jWEAlgorithm);
        JWEAlgorithm jWEAlgorithm2 = JWEAlgorithm.A192KW;
        linkedHashSet.add(jWEAlgorithm2);
        JWEAlgorithm jWEAlgorithm3 = JWEAlgorithm.A256KW;
        linkedHashSet.add(jWEAlgorithm3);
        JWEAlgorithm jWEAlgorithm4 = JWEAlgorithm.A128GCMKW;
        linkedHashSet.add(jWEAlgorithm4);
        JWEAlgorithm jWEAlgorithm5 = JWEAlgorithm.A192GCMKW;
        linkedHashSet.add(jWEAlgorithm5);
        JWEAlgorithm jWEAlgorithm6 = JWEAlgorithm.A256GCMKW;
        linkedHashSet.add(jWEAlgorithm6);
        SUPPORTED_ALGORITHMS = Collections.unmodifiableSet(linkedHashSet);
        HashMap map = new HashMap();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(jWEAlgorithm4);
        hashSet.add(jWEAlgorithm);
        hashSet2.add(jWEAlgorithm5);
        hashSet2.add(jWEAlgorithm2);
        hashSet3.add(jWEAlgorithm6);
        hashSet3.add(jWEAlgorithm3);
        map.put(128, Collections.unmodifiableSet(hashSet));
        map.put(192, Collections.unmodifiableSet(hashSet2));
        map.put(256, Collections.unmodifiableSet(hashSet3));
        COMPATIBLE_ALGORITHMS = Collections.unmodifiableMap(map);
    }

    public AESCryptoProvider(SecretKey secretKey, SecretKey secretKey2) {
        super(getCompatibleJWEAlgorithms(ByteUtils.bitLength(secretKey.getEncoded())), ContentCryptoProvider.SUPPORTED_ENCRYPTION_METHODS, secretKey2);
        this.kek = secretKey;
    }

    private static Set<JWEAlgorithm> getCompatibleJWEAlgorithms(int i) throws KeyLengthException {
        Set<JWEAlgorithm> set = COMPATIBLE_ALGORITHMS.get(Integer.valueOf(i));
        if (set != null) {
            return set;
        }
        throw new KeyLengthException("The Key Encryption Key length must be 128 bits (16 bytes), 192 bits (24 bytes) or 256 bits (32 bytes)");
    }

    public SecretKey getKey() {
        return this.kek;
    }
}
