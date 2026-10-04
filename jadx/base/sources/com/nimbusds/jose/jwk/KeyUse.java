package com.nimbusds.jose.jwk;

import com.nimbusds.jose.HeaderParameterNames;
import java.io.Serializable;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class KeyUse implements Serializable {
    private static final long serialVersionUID = 1;
    private final String identifier;
    public static final KeyUse SIGNATURE = new KeyUse("sig");
    public static final KeyUse ENCRYPTION = new KeyUse(HeaderParameterNames.ENCRYPTION_ALGORITHM);

    public KeyUse(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The key use identifier must not be null");
        }
        this.identifier = str;
    }

    public static KeyUse from(X509Certificate x509Certificate) {
        if (x509Certificate.getKeyUsage() == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        if (x509Certificate.getKeyUsage()[0] || x509Certificate.getKeyUsage()[1]) {
            hashSet.add(SIGNATURE);
        }
        if (x509Certificate.getKeyUsage()[0] && x509Certificate.getKeyUsage()[2]) {
            hashSet.add(ENCRYPTION);
        }
        if (x509Certificate.getKeyUsage()[0] && x509Certificate.getKeyUsage()[4]) {
            hashSet.add(ENCRYPTION);
        }
        if (x509Certificate.getKeyUsage()[2] || x509Certificate.getKeyUsage()[3] || x509Certificate.getKeyUsage()[4]) {
            hashSet.add(ENCRYPTION);
        }
        if (x509Certificate.getKeyUsage()[5] || x509Certificate.getKeyUsage()[6]) {
            hashSet.add(SIGNATURE);
        }
        if (hashSet.size() == 1) {
            return (KeyUse) hashSet.iterator().next();
        }
        return null;
    }

    public static KeyUse parse(String str) throws ParseException {
        if (str == null) {
            return null;
        }
        KeyUse keyUse = SIGNATURE;
        if (str.equals(keyUse.identifier())) {
            return keyUse;
        }
        KeyUse keyUse2 = ENCRYPTION;
        if (str.equals(keyUse2.identifier())) {
            return keyUse2;
        }
        if (str.trim().isEmpty()) {
            throw new ParseException("JWK use value must not be empty or blank", 0);
        }
        return new KeyUse(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KeyUse) {
            return Objects.equals(this.identifier, ((KeyUse) obj).identifier);
        }
        return false;
    }

    public String getValue() {
        return identifier();
    }

    public int hashCode() {
        return Objects.hash(this.identifier);
    }

    public String identifier() {
        return this.identifier;
    }

    public String toString() {
        return identifier();
    }
}
