package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.jwk.Curve;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class MultiCryptoProvider extends BaseJWEProvider {
    public static final Map<Integer, Set<JWEAlgorithm>> COMPATIBLE_ALGORITHMS;
    public static final Set<JWEAlgorithm> SUPPORTED_ALGORITHMS;
    public static final Set<Curve> SUPPORTED_ELLIPTIC_CURVES;
    public static final Set<EncryptionMethod> SUPPORTED_ENCRYPTION_METHODS = ContentCryptoProvider.SUPPORTED_ENCRYPTION_METHODS;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(null);
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
        linkedHashSet.add(JWEAlgorithm.DIR);
        linkedHashSet.add(JWEAlgorithm.ECDH_ES_A128KW);
        linkedHashSet.add(JWEAlgorithm.ECDH_ES_A192KW);
        linkedHashSet.add(JWEAlgorithm.ECDH_ES_A256KW);
        linkedHashSet.add(JWEAlgorithm.RSA1_5);
        linkedHashSet.add(JWEAlgorithm.RSA_OAEP);
        linkedHashSet.add(JWEAlgorithm.RSA_OAEP_256);
        linkedHashSet.add(JWEAlgorithm.RSA_OAEP_384);
        linkedHashSet.add(JWEAlgorithm.RSA_OAEP_512);
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
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        linkedHashSet2.add(Curve.P_256);
        linkedHashSet2.add(Curve.P_384);
        linkedHashSet2.add(Curve.P_521);
        linkedHashSet2.add(Curve.X25519);
        SUPPORTED_ELLIPTIC_CURVES = Collections.unmodifiableSet(linkedHashSet2);
    }

    public MultiCryptoProvider(SecretKey secretKey) {
        super(SUPPORTED_ALGORITHMS, ContentCryptoProvider.SUPPORTED_ENCRYPTION_METHODS, secretKey);
    }

    public Set<Curve> supportedEllipticCurves() {
        return SUPPORTED_ELLIPTIC_CURVES;
    }
}
