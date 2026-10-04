package com.nimbusds.jose.jwk;

import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.Requirement;
import com.nimbusds.jose.util.JSONStringUtils;
import java.io.Serializable;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class KeyType implements Serializable {
    public static final KeyType OCT;
    public static final KeyType OKP;
    private static final long serialVersionUID = 1;
    private final Requirement requirement;
    private final String value;

    /* JADX INFO: renamed from: EC */
    public static final KeyType f3634EC = new KeyType("EC", Requirement.RECOMMENDED);
    public static final KeyType RSA = new KeyType(AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA, Requirement.REQUIRED);

    static {
        Requirement requirement = Requirement.OPTIONAL;
        OCT = new KeyType("oct", requirement);
        OKP = new KeyType("OKP", requirement);
    }

    public KeyType(String str, Requirement requirement) {
        if (str == null) {
            throw new IllegalArgumentException("The key type value must not be null");
        }
        this.value = str;
        this.requirement = requirement;
    }

    public static KeyType forAlgorithm(Algorithm algorithm) {
        if (algorithm == null) {
            return null;
        }
        if (JWSAlgorithm.Family.RSA.contains(algorithm)) {
            return RSA;
        }
        if (JWSAlgorithm.Family.f3624EC.contains(algorithm)) {
            return f3634EC;
        }
        if (JWSAlgorithm.Family.HMAC_SHA.contains(algorithm)) {
            return OCT;
        }
        if (JWEAlgorithm.Family.RSA.contains(algorithm)) {
            return RSA;
        }
        if (JWEAlgorithm.Family.ECDH_ES.contains(algorithm)) {
            return f3634EC;
        }
        if (JWEAlgorithm.DIR.equals(algorithm)) {
            return OCT;
        }
        if (JWEAlgorithm.Family.AES_GCM_KW.contains(algorithm)) {
            return OCT;
        }
        if (JWEAlgorithm.Family.AES_KW.contains(algorithm)) {
            return OCT;
        }
        if (JWEAlgorithm.Family.PBES2.contains(algorithm)) {
            return OCT;
        }
        if (JWSAlgorithm.Family.f3625ED.contains(algorithm)) {
            return OKP;
        }
        return null;
    }

    public static KeyType parse(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The key type to parse must not be null");
        }
        KeyType keyType = f3634EC;
        if (str.equals(keyType.getValue())) {
            return keyType;
        }
        KeyType keyType2 = RSA;
        if (str.equals(keyType2.getValue())) {
            return keyType2;
        }
        KeyType keyType3 = OCT;
        if (str.equals(keyType3.getValue())) {
            return keyType3;
        }
        KeyType keyType4 = OKP;
        return str.equals(keyType4.getValue()) ? keyType4 : new KeyType(str, null);
    }

    public boolean equals(Object obj) {
        return (obj instanceof KeyType) && toString().equals(obj.toString());
    }

    public Requirement getRequirement() {
        return this.requirement;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toJSONString() {
        return JSONStringUtils.toJSONString(this.value);
    }

    public String toString() {
        return this.value;
    }
}
