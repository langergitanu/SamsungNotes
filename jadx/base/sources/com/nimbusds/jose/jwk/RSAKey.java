package com.nimbusds.jose.jwk;

import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.IntegerOverflowException;
import com.nimbusds.jose.util.JSONArrayUtils;
import com.nimbusds.jose.util.JSONObjectUtils;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.URI;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAMultiPrimePrivateCrtKeySpec;
import java.security.spec.RSAOtherPrimeInfo;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class RSAKey extends JWK implements AsymmetricJWK {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: d */
    private final Base64URL f3643d;

    /* JADX INFO: renamed from: dp */
    private final Base64URL f3644dp;

    /* JADX INFO: renamed from: dq */
    private final Base64URL f3645dq;

    /* JADX INFO: renamed from: e */
    private final Base64URL f3646e;

    /* JADX INFO: renamed from: n */
    private final Base64URL f3647n;
    private final List<OtherPrimesInfo> oth;

    /* JADX INFO: renamed from: p */
    private final Base64URL f3648p;
    private final PrivateKey privateKey;

    /* JADX INFO: renamed from: q */
    private final Base64URL f3649q;

    /* JADX INFO: renamed from: qi */
    private final Base64URL f3650qi;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private Algorithm alg;

        /* JADX INFO: renamed from: d */
        private Base64URL f3651d;

        /* JADX INFO: renamed from: dp */
        private Base64URL f3652dp;

        /* JADX INFO: renamed from: dq */
        private Base64URL f3653dq;

        /* JADX INFO: renamed from: e */
        private final Base64URL f3654e;
        private Date exp;
        private Date iat;
        private String kid;

        /* JADX INFO: renamed from: ks */
        private KeyStore f3655ks;

        /* JADX INFO: renamed from: n */
        private final Base64URL f3656n;
        private Date nbf;
        private Set<KeyOperation> ops;
        private List<OtherPrimesInfo> oth;

        /* JADX INFO: renamed from: p */
        private Base64URL f3657p;
        private PrivateKey priv;

        /* JADX INFO: renamed from: q */
        private Base64URL f3658q;

        /* JADX INFO: renamed from: qi */
        private Base64URL f3659qi;
        private KeyUse use;
        private List<Base64> x5c;

        @Deprecated
        private Base64URL x5t;
        private Base64URL x5t256;
        private URI x5u;

        public Builder(Base64URL base64URL, Base64URL base64URL2) {
            if (base64URL == null) {
                throw new IllegalArgumentException("The modulus value must not be null");
            }
            this.f3656n = base64URL;
            if (base64URL2 == null) {
                throw new IllegalArgumentException("The public exponent value must not be null");
            }
            this.f3654e = base64URL2;
        }

        public Builder algorithm(Algorithm algorithm) {
            this.alg = algorithm;
            return this;
        }

        public RSAKey build() {
            try {
                return new RSAKey(this.f3656n, this.f3654e, this.f3651d, this.f3657p, this.f3658q, this.f3652dp, this.f3653dq, this.f3659qi, this.oth, this.priv, this.use, this.ops, this.alg, this.kid, this.x5u, this.x5t, this.x5t256, this.x5c, this.exp, this.nbf, this.iat, this.f3655ks);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        }

        public Builder expirationTime(Date date) {
            this.exp = date;
            return this;
        }

        public Builder firstCRTCoefficient(Base64URL base64URL) {
            this.f3659qi = base64URL;
            return this;
        }

        public Builder firstFactorCRTExponent(Base64URL base64URL) {
            this.f3652dp = base64URL;
            return this;
        }

        public Builder firstPrimeFactor(Base64URL base64URL) {
            this.f3657p = base64URL;
            return this;
        }

        public Builder issueTime(Date date) {
            this.iat = date;
            return this;
        }

        public Builder keyID(String str) {
            this.kid = str;
            return this;
        }

        public Builder keyIDFromThumbprint() {
            return keyIDFromThumbprint("SHA-256");
        }

        public Builder keyOperations(Set<KeyOperation> set) {
            this.ops = set;
            return this;
        }

        public Builder keyStore(KeyStore keyStore) {
            this.f3655ks = keyStore;
            return this;
        }

        public Builder keyUse(KeyUse keyUse) {
            this.use = keyUse;
            return this;
        }

        public Builder notBeforeTime(Date date) {
            this.nbf = date;
            return this;
        }

        public Builder otherPrimes(List<OtherPrimesInfo> list) {
            this.oth = list;
            return this;
        }

        public Builder privateExponent(Base64URL base64URL) {
            this.f3651d = base64URL;
            return this;
        }

        public Builder privateKey(RSAPrivateKey rSAPrivateKey) {
            if (rSAPrivateKey instanceof RSAPrivateCrtKey) {
                return privateKey((RSAPrivateCrtKey) rSAPrivateKey);
            }
            if (rSAPrivateKey instanceof RSAMultiPrimePrivateCrtKey) {
                return privateKey((RSAMultiPrimePrivateCrtKey) rSAPrivateKey);
            }
            this.f3651d = Base64URL.encode(rSAPrivateKey.getPrivateExponent());
            return this;
        }

        public Builder secondFactorCRTExponent(Base64URL base64URL) {
            this.f3653dq = base64URL;
            return this;
        }

        public Builder secondPrimeFactor(Base64URL base64URL) {
            this.f3658q = base64URL;
            return this;
        }

        public Builder x509CertChain(List<Base64> list) {
            this.x5c = list;
            return this;
        }

        public Builder x509CertSHA256Thumbprint(Base64URL base64URL) {
            this.x5t256 = base64URL;
            return this;
        }

        @Deprecated
        public Builder x509CertThumbprint(Base64URL base64URL) {
            this.x5t = base64URL;
            return this;
        }

        public Builder x509CertURL(URI uri) {
            this.x5u = uri;
            return this;
        }

        public Builder keyIDFromThumbprint(String str) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("e", this.f3654e.toString());
            linkedHashMap.put(JWKParameterNames.KEY_TYPE, KeyType.RSA.getValue());
            linkedHashMap.put("n", this.f3656n.toString());
            this.kid = ThumbprintUtils.compute(str, (LinkedHashMap<String, ?>) linkedHashMap).toString();
            return this;
        }

        public Builder(RSAPublicKey rSAPublicKey) {
            this.f3656n = Base64URL.encode(rSAPublicKey.getModulus());
            this.f3654e = Base64URL.encode(rSAPublicKey.getPublicExponent());
        }

        public Builder privateKey(PrivateKey privateKey) {
            if (privateKey instanceof RSAPrivateKey) {
                return privateKey((RSAPrivateKey) privateKey);
            }
            if (AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA.equalsIgnoreCase(privateKey.getAlgorithm())) {
                this.priv = privateKey;
                return this;
            }
            throw new IllegalArgumentException("The private key algorithm must be RSA");
        }

        public Builder(RSAKey rSAKey) {
            this.f3656n = rSAKey.f3647n;
            this.f3654e = rSAKey.f3646e;
            this.f3651d = rSAKey.f3643d;
            this.f3657p = rSAKey.f3648p;
            this.f3658q = rSAKey.f3649q;
            this.f3652dp = rSAKey.f3644dp;
            this.f3653dq = rSAKey.f3645dq;
            this.f3659qi = rSAKey.f3650qi;
            this.oth = rSAKey.oth;
            this.priv = rSAKey.privateKey;
            this.use = rSAKey.getKeyUse();
            this.ops = rSAKey.getKeyOperations();
            this.alg = rSAKey.getAlgorithm();
            this.kid = rSAKey.getKeyID();
            this.x5u = rSAKey.getX509CertURL();
            this.x5t = rSAKey.getX509CertThumbprint();
            this.x5t256 = rSAKey.getX509CertSHA256Thumbprint();
            this.x5c = rSAKey.getX509CertChain();
            this.exp = rSAKey.getExpirationTime();
            this.nbf = rSAKey.getNotBeforeTime();
            this.iat = rSAKey.getIssueTime();
            this.f3655ks = rSAKey.getKeyStore();
        }

        public Builder privateKey(RSAPrivateCrtKey rSAPrivateCrtKey) {
            this.f3651d = Base64URL.encode(rSAPrivateCrtKey.getPrivateExponent());
            this.f3657p = Base64URL.encode(rSAPrivateCrtKey.getPrimeP());
            this.f3658q = Base64URL.encode(rSAPrivateCrtKey.getPrimeQ());
            this.f3652dp = Base64URL.encode(rSAPrivateCrtKey.getPrimeExponentP());
            this.f3653dq = Base64URL.encode(rSAPrivateCrtKey.getPrimeExponentQ());
            this.f3659qi = Base64URL.encode(rSAPrivateCrtKey.getCrtCoefficient());
            return this;
        }

        public Builder privateKey(RSAMultiPrimePrivateCrtKey rSAMultiPrimePrivateCrtKey) {
            this.f3651d = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrivateExponent());
            this.f3657p = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeP());
            this.f3658q = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeQ());
            this.f3652dp = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeExponentP());
            this.f3653dq = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeExponentQ());
            this.f3659qi = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getCrtCoefficient());
            this.oth = OtherPrimesInfo.toList(rSAMultiPrimePrivateCrtKey.getOtherPrimeInfo());
            return this;
        }
    }

    @Deprecated
    public RSAKey(Base64URL base64URL, Base64URL base64URL2, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, KeyStore keyStore) {
        this(base64URL, base64URL2, null, null, null, null, null, null, null, null, keyUse, set, algorithm, str, uri, base64URL3, base64URL4, list, null, null, null, keyStore);
    }

    public static RSAKey load(KeyStore keyStore, String str, char[] cArr) {
        Certificate certificate = keyStore.getCertificate(str);
        if (!(certificate instanceof X509Certificate)) {
            return null;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        if (!(x509Certificate.getPublicKey() instanceof RSAPublicKey)) {
            throw new JOSEException("Couldn't load RSA JWK: The key algorithm is not RSA");
        }
        RSAKey rSAKeyBuild = new Builder(parse(x509Certificate)).keyID(str).keyStore(keyStore).build();
        try {
            Key key = keyStore.getKey(str, cArr);
            return key instanceof RSAPrivateKey ? new Builder(rSAKeyBuild).privateKey((RSAPrivateKey) key).build() : ((key instanceof PrivateKey) && AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA.equalsIgnoreCase(key.getAlgorithm())) ? new Builder(rSAKeyBuild).privateKey((PrivateKey) key).build() : rSAKeyBuild;
        } catch (NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new JOSEException("Couldn't retrieve private RSA key (bad pin?): " + e.getMessage(), e);
        }
    }

    public static RSAKey parse(String str) {
        return parse(JSONObjectUtils.parse(str));
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RSAKey) || !super.equals(obj)) {
            return false;
        }
        RSAKey rSAKey = (RSAKey) obj;
        return Objects.equals(this.f3647n, rSAKey.f3647n) && Objects.equals(this.f3646e, rSAKey.f3646e) && Objects.equals(this.f3643d, rSAKey.f3643d) && Objects.equals(this.f3648p, rSAKey.f3648p) && Objects.equals(this.f3649q, rSAKey.f3649q) && Objects.equals(this.f3644dp, rSAKey.f3644dp) && Objects.equals(this.f3645dq, rSAKey.f3645dq) && Objects.equals(this.f3650qi, rSAKey.f3650qi) && Objects.equals(this.oth, rSAKey.oth) && Objects.equals(this.privateKey, rSAKey.privateKey);
    }

    public Base64URL getFirstCRTCoefficient() {
        return this.f3650qi;
    }

    public Base64URL getFirstFactorCRTExponent() {
        return this.f3644dp;
    }

    public Base64URL getFirstPrimeFactor() {
        return this.f3648p;
    }

    public Base64URL getModulus() {
        return this.f3647n;
    }

    public List<OtherPrimesInfo> getOtherPrimes() {
        return this.oth;
    }

    public Base64URL getPrivateExponent() {
        return this.f3643d;
    }

    public Base64URL getPublicExponent() {
        return this.f3646e;
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public LinkedHashMap<String, ?> getRequiredParams() {
        LinkedHashMap<String, ?> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("e", this.f3646e.toString());
        linkedHashMap.put(JWKParameterNames.KEY_TYPE, getKeyType().getValue());
        linkedHashMap.put("n", this.f3647n.toString());
        return linkedHashMap;
    }

    public Base64URL getSecondFactorCRTExponent() {
        return this.f3645dq;
    }

    public Base64URL getSecondPrimeFactor() {
        return this.f3649q;
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.f3647n, this.f3646e, this.f3643d, this.f3648p, this.f3649q, this.f3644dp, this.f3645dq, this.f3650qi, this.oth, this.privateKey);
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public boolean isPrivate() {
        return (this.f3643d == null && this.f3648p == null && this.privateKey == null) ? false : true;
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public boolean matches(X509Certificate x509Certificate) {
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) getParsedX509CertChain().get(0).getPublicKey();
            if (this.f3646e.decodeToBigInteger().equals(rSAPublicKey.getPublicExponent())) {
                return this.f3647n.decodeToBigInteger().equals(rSAPublicKey.getModulus());
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public int size() {
        try {
            return ByteUtils.safeBitLength(this.f3647n.decode());
        } catch (IntegerOverflowException e) {
            throw new ArithmeticException(e.getMessage());
        }
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public Map<String, Object> toJSONObject() {
        Map<String, Object> jSONObject = super.toJSONObject();
        jSONObject.put("n", this.f3647n.toString());
        jSONObject.put("e", this.f3646e.toString());
        Base64URL base64URL = this.f3643d;
        if (base64URL != null) {
            jSONObject.put("d", base64URL.toString());
        }
        Base64URL base64URL2 = this.f3648p;
        if (base64URL2 != null) {
            jSONObject.put("p", base64URL2.toString());
        }
        Base64URL base64URL3 = this.f3649q;
        if (base64URL3 != null) {
            jSONObject.put(JWKParameterNames.RSA_SECOND_PRIME_FACTOR, base64URL3.toString());
        }
        Base64URL base64URL4 = this.f3644dp;
        if (base64URL4 != null) {
            jSONObject.put(JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, base64URL4.toString());
        }
        Base64URL base64URL5 = this.f3645dq;
        if (base64URL5 != null) {
            jSONObject.put(JWKParameterNames.RSA_SECOND_FACTOR_CRT_EXPONENT, base64URL5.toString());
        }
        Base64URL base64URL6 = this.f3650qi;
        if (base64URL6 != null) {
            jSONObject.put(JWKParameterNames.RSA_FIRST_CRT_COEFFICIENT, base64URL6.toString());
        }
        List<OtherPrimesInfo> list = this.oth;
        if (list != null && !list.isEmpty()) {
            List<Object> listNewJSONArray = JSONArrayUtils.newJSONArray();
            for (OtherPrimesInfo otherPrimesInfo : this.oth) {
                Map<String, Object> mapNewJSONObject = JSONObjectUtils.newJSONObject();
                mapNewJSONObject.put("r", otherPrimesInfo.f3661r.toString());
                mapNewJSONObject.put("d", otherPrimesInfo.f3660d.toString());
                mapNewJSONObject.put("t", otherPrimesInfo.f3662t.toString());
                listNewJSONArray.add(mapNewJSONObject);
            }
            jSONObject.put(JWKParameterNames.RSA_OTHER_PRIMES, listNewJSONArray);
        }
        return jSONObject;
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public KeyPair toKeyPair() {
        return new KeyPair(toRSAPublicKey(), toPrivateKey());
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public PrivateKey toPrivateKey() throws JOSEException {
        RSAPrivateKey rSAPrivateKey = toRSAPrivateKey();
        return rSAPrivateKey != null ? rSAPrivateKey : this.privateKey;
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public PublicKey toPublicKey() {
        return toRSAPublicKey();
    }

    public RSAPrivateKey toRSAPrivateKey() throws JOSEException {
        RSAPrivateKeySpec rSAPrivateCrtKeySpec;
        RSAPrivateKeySpec rSAPrivateKeySpec;
        if (this.f3643d == null) {
            return null;
        }
        BigInteger bigIntegerDecodeToBigInteger = this.f3647n.decodeToBigInteger();
        BigInteger bigIntegerDecodeToBigInteger2 = this.f3643d.decodeToBigInteger();
        if (this.f3648p == null) {
            rSAPrivateKeySpec = new RSAPrivateKeySpec(bigIntegerDecodeToBigInteger, bigIntegerDecodeToBigInteger2);
        } else {
            BigInteger bigIntegerDecodeToBigInteger3 = this.f3646e.decodeToBigInteger();
            BigInteger bigIntegerDecodeToBigInteger4 = this.f3648p.decodeToBigInteger();
            BigInteger bigIntegerDecodeToBigInteger5 = this.f3649q.decodeToBigInteger();
            BigInteger bigIntegerDecodeToBigInteger6 = this.f3644dp.decodeToBigInteger();
            BigInteger bigIntegerDecodeToBigInteger7 = this.f3645dq.decodeToBigInteger();
            BigInteger bigIntegerDecodeToBigInteger8 = this.f3650qi.decodeToBigInteger();
            List<OtherPrimesInfo> list = this.oth;
            if (list == null || list.isEmpty()) {
                rSAPrivateCrtKeySpec = new RSAPrivateCrtKeySpec(bigIntegerDecodeToBigInteger, bigIntegerDecodeToBigInteger3, bigIntegerDecodeToBigInteger2, bigIntegerDecodeToBigInteger4, bigIntegerDecodeToBigInteger5, bigIntegerDecodeToBigInteger6, bigIntegerDecodeToBigInteger7, bigIntegerDecodeToBigInteger8);
            } else {
                RSAOtherPrimeInfo[] rSAOtherPrimeInfoArr = new RSAOtherPrimeInfo[this.oth.size()];
                for (int i = 0; i < this.oth.size(); i++) {
                    OtherPrimesInfo otherPrimesInfo = this.oth.get(i);
                    rSAOtherPrimeInfoArr[i] = new RSAOtherPrimeInfo(otherPrimesInfo.getPrimeFactor().decodeToBigInteger(), otherPrimesInfo.getFactorCRTExponent().decodeToBigInteger(), otherPrimesInfo.getFactorCRTCoefficient().decodeToBigInteger());
                }
                rSAPrivateCrtKeySpec = new RSAMultiPrimePrivateCrtKeySpec(bigIntegerDecodeToBigInteger, bigIntegerDecodeToBigInteger3, bigIntegerDecodeToBigInteger2, bigIntegerDecodeToBigInteger4, bigIntegerDecodeToBigInteger5, bigIntegerDecodeToBigInteger6, bigIntegerDecodeToBigInteger7, bigIntegerDecodeToBigInteger8, rSAOtherPrimeInfoArr);
            }
            rSAPrivateKeySpec = rSAPrivateCrtKeySpec;
        }
        try {
            return (RSAPrivateKey) KeyFactory.getInstance(AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA).generatePrivate(rSAPrivateKeySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public RSAPublicKey toRSAPublicKey() throws JOSEException {
        try {
            return (RSAPublicKey) KeyFactory.getInstance(AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA).generatePublic(new RSAPublicKeySpec(this.f3647n.decodeToBigInteger(), this.f3646e.decodeToBigInteger()));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public RSAKey(Base64URL base64URL, Base64URL base64URL2, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, Date date, Date date2, Date date3, KeyStore keyStore) {
        this(base64URL, base64URL2, null, null, null, null, null, null, null, null, keyUse, set, algorithm, str, uri, base64URL3, base64URL4, list, date, date2, date3, keyStore);
    }

    public static RSAKey parse(Map<String, Object> map) throws ParseException {
        ArrayList arrayList;
        List<Object> jSONArray;
        if (!KeyType.RSA.equals(JWKMetadata.parseKeyType(map))) {
            throw new ParseException("The key type \"kty\" must be RSA", 0);
        }
        Base64URL base64URL = JSONObjectUtils.getBase64URL(map, "n");
        Base64URL base64URL2 = JSONObjectUtils.getBase64URL(map, "e");
        Base64URL base64URL3 = JSONObjectUtils.getBase64URL(map, "d");
        Base64URL base64URL4 = JSONObjectUtils.getBase64URL(map, "p");
        Base64URL base64URL5 = JSONObjectUtils.getBase64URL(map, JWKParameterNames.RSA_SECOND_PRIME_FACTOR);
        Base64URL base64URL6 = JSONObjectUtils.getBase64URL(map, JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT);
        Base64URL base64URL7 = JSONObjectUtils.getBase64URL(map, JWKParameterNames.RSA_SECOND_FACTOR_CRT_EXPONENT);
        Base64URL base64URL8 = JSONObjectUtils.getBase64URL(map, JWKParameterNames.RSA_FIRST_CRT_COEFFICIENT);
        if (!map.containsKey(JWKParameterNames.RSA_OTHER_PRIMES) || (jSONArray = JSONObjectUtils.getJSONArray(map, JWKParameterNames.RSA_OTHER_PRIMES)) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(jSONArray.size());
            for (Object obj : jSONArray) {
                if (obj instanceof Map) {
                    Map map2 = (Map) obj;
                    try {
                        arrayList.add(new OtherPrimesInfo(JSONObjectUtils.getBase64URL(map2, "r"), JSONObjectUtils.getBase64URL(map2, JWKParameterNames.RSA_SECOND_FACTOR_CRT_EXPONENT), JSONObjectUtils.getBase64URL(map2, "t")));
                    } catch (IllegalArgumentException e) {
                        throw new ParseException(e.getMessage(), 0);
                    }
                }
            }
        }
        try {
            return new RSAKey(base64URL, base64URL2, base64URL3, base64URL4, base64URL5, base64URL6, base64URL7, base64URL8, arrayList, null, JWKMetadata.parseKeyUse(map), JWKMetadata.parseKeyOperations(map), JWKMetadata.parseAlgorithm(map), JWKMetadata.parseKeyID(map), JWKMetadata.parseX509CertURL(map), JWKMetadata.parseX509CertThumbprint(map), JWKMetadata.parseX509CertSHA256Thumbprint(map), JWKMetadata.parseX509CertChain(map), JWKMetadata.parseExpirationTime(map), JWKMetadata.parseNotBeforeTime(map), JWKMetadata.parseIssueTime(map), null);
        } catch (IllegalArgumentException e2) {
            throw new ParseException(e2.getMessage(), 0);
        }
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public RSAKey toPublicJWK() {
        return new RSAKey(getModulus(), getPublicExponent(), getKeyUse(), getKeyOperations(), getAlgorithm(), getKeyID(), getX509CertURL(), getX509CertThumbprint(), getX509CertSHA256Thumbprint(), getX509CertChain(), getExpirationTime(), getNotBeforeTime(), getIssueTime(), getKeyStore());
    }

    @Deprecated
    public RSAKey(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL4, Base64URL base64URL5, List<Base64> list, KeyStore keyStore) {
        this(base64URL, base64URL2, base64URL3, null, null, null, null, null, null, null, keyUse, set, algorithm, str, uri, base64URL4, base64URL5, list, null, null, null, keyStore);
    }

    public RSAKey(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL4, Base64URL base64URL5, List<Base64> list, Date date, Date date2, Date date3, KeyStore keyStore) {
        this(base64URL, base64URL2, base64URL3, null, null, null, null, null, null, null, keyUse, set, algorithm, str, uri, base64URL4, base64URL5, list, date, date2, date3, keyStore);
        if (base64URL3 == null) {
            throw new IllegalArgumentException("The private exponent must not be null");
        }
    }

    @Deprecated
    public RSAKey(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, Base64URL base64URL6, Base64URL base64URL7, List<OtherPrimesInfo> list, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL8, Base64URL base64URL9, List<Base64> list2, KeyStore keyStore) {
        this(base64URL, base64URL2, null, base64URL3, base64URL4, base64URL5, base64URL6, base64URL7, list, null, keyUse, set, algorithm, str, uri, base64URL8, base64URL9, list2, null, null, null, keyStore);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    public static class OtherPrimesInfo implements Serializable {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: d */
        private final Base64URL f3660d;

        /* JADX INFO: renamed from: r */
        private final Base64URL f3661r;

        /* JADX INFO: renamed from: t */
        private final Base64URL f3662t;

        public OtherPrimesInfo(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3) {
            if (base64URL == null) {
                throw new IllegalArgumentException("The prime factor must not be null");
            }
            this.f3661r = base64URL;
            if (base64URL2 == null) {
                throw new IllegalArgumentException("The factor CRT exponent must not be null");
            }
            this.f3660d = base64URL2;
            if (base64URL3 == null) {
                throw new IllegalArgumentException("The factor CRT coefficient must not be null");
            }
            this.f3662t = base64URL3;
        }

        public static List<OtherPrimesInfo> toList(RSAOtherPrimeInfo[] rSAOtherPrimeInfoArr) {
            ArrayList arrayList = new ArrayList();
            if (rSAOtherPrimeInfoArr != null) {
                for (RSAOtherPrimeInfo rSAOtherPrimeInfo : rSAOtherPrimeInfoArr) {
                    arrayList.add(new OtherPrimesInfo(rSAOtherPrimeInfo));
                }
            }
            return arrayList;
        }

        public Base64URL getFactorCRTCoefficient() {
            return this.f3662t;
        }

        public Base64URL getFactorCRTExponent() {
            return this.f3660d;
        }

        public Base64URL getPrimeFactor() {
            return this.f3661r;
        }

        public OtherPrimesInfo(RSAOtherPrimeInfo rSAOtherPrimeInfo) {
            this.f3661r = Base64URL.encode(rSAOtherPrimeInfo.getPrime());
            this.f3660d = Base64URL.encode(rSAOtherPrimeInfo.getExponent());
            this.f3662t = Base64URL.encode(rSAOtherPrimeInfo.getCrtCoefficient());
        }
    }

    public RSAKey(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, Base64URL base64URL6, Base64URL base64URL7, List<OtherPrimesInfo> list, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL8, Base64URL base64URL9, List<Base64> list2, Date date, Date date2, Date date3, KeyStore keyStore) {
        this(base64URL, base64URL2, null, base64URL3, base64URL4, base64URL5, base64URL6, base64URL7, list, null, keyUse, set, algorithm, str, uri, base64URL8, base64URL9, list2, date, date2, date3, keyStore);
        if (base64URL3 == null) {
            throw new IllegalArgumentException("The first prime factor must not be null");
        }
        if (base64URL4 == null) {
            throw new IllegalArgumentException("The second prime factor must not be null");
        }
        if (base64URL5 == null) {
            throw new IllegalArgumentException("The first factor CRT exponent must not be null");
        }
        if (base64URL6 == null) {
            throw new IllegalArgumentException("The second factor CRT exponent must not be null");
        }
        if (base64URL7 == null) {
            throw new IllegalArgumentException("The first CRT coefficient must not be null");
        }
    }

    @Deprecated
    public RSAKey(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, Base64URL base64URL6, Base64URL base64URL7, Base64URL base64URL8, List<OtherPrimesInfo> list, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL9, Base64URL base64URL10, List<Base64> list2) {
        this(base64URL, base64URL2, base64URL3, base64URL4, base64URL5, base64URL6, base64URL7, base64URL8, list, null, keyUse, set, algorithm, str, uri, base64URL9, base64URL10, list2, null);
    }

    @Deprecated
    public RSAKey(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, Base64URL base64URL6, Base64URL base64URL7, Base64URL base64URL8, List<OtherPrimesInfo> list, PrivateKey privateKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL9, Base64URL base64URL10, List<Base64> list2, KeyStore keyStore) {
        this(base64URL, base64URL2, base64URL3, base64URL4, base64URL5, base64URL6, base64URL7, base64URL8, list, privateKey, keyUse, set, algorithm, str, uri, base64URL9, base64URL10, list2, null, null, null, keyStore);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RSAKey(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, Base64URL base64URL6, Base64URL base64URL7, Base64URL base64URL8, List<OtherPrimesInfo> list, PrivateKey privateKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL9, Base64URL base64URL10, List<Base64> list2, Date date, Date date2, Date date3, KeyStore keyStore) {
        Base64URL base64URL11;
        Base64URL base64URL12;
        super(KeyType.RSA, keyUse, set, algorithm, str, uri, base64URL9, base64URL10, list2, date, date2, date3, keyStore);
        if (base64URL != null) {
            this.f3647n = base64URL;
            if (base64URL2 != null) {
                this.f3646e = base64URL2;
                if (getParsedX509CertChain() != null && !matches(getParsedX509CertChain().get(0))) {
                    throw new IllegalArgumentException("The public subject key info of the first X.509 certificate in the chain must match the JWK type and public parameters");
                }
                this.f3643d = base64URL3;
                if (base64URL4 != null && base64URL5 != null) {
                    base64URL11 = base64URL7;
                    if (base64URL6 != null) {
                        base64URL12 = base64URL8;
                        if (base64URL11 != null && base64URL12 != null) {
                            this.f3648p = base64URL4;
                            this.f3649q = base64URL5;
                            this.f3644dp = base64URL6;
                            this.f3645dq = base64URL11;
                            this.f3650qi = base64URL12;
                            if (list != null) {
                                this.oth = Collections.unmodifiableList(list);
                            } else {
                                this.oth = Collections.EMPTY_LIST;
                            }
                        }
                        this.privateKey = privateKey;
                        return;
                    }
                    if (base64URL4 != null && base64URL5 == null && base64URL6 == null && base64URL11 == null && base64URL12 == null && list == null) {
                        this.f3648p = null;
                        this.f3649q = null;
                        this.f3644dp = null;
                        this.f3645dq = null;
                        this.f3650qi = null;
                        this.oth = Collections.EMPTY_LIST;
                    } else {
                        if (base64URL4 == null || base64URL5 != null || base64URL6 != null || base64URL11 != null || base64URL12 != null) {
                            if (base64URL4 != null) {
                                throw new IllegalArgumentException("Incomplete second private (CRT) representation: The first prime factor must not be null");
                            }
                            if (base64URL5 == null) {
                                throw new IllegalArgumentException("Incomplete second private (CRT) representation: The second prime factor must not be null");
                            }
                            if (base64URL6 == null) {
                                throw new IllegalArgumentException("Incomplete second private (CRT) representation: The first factor CRT exponent must not be null");
                            }
                            if (base64URL11 == null) {
                                throw new IllegalArgumentException("Incomplete second private (CRT) representation: The second factor CRT exponent must not be null");
                            }
                            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The first CRT coefficient must not be null");
                        }
                        this.f3648p = null;
                        this.f3649q = null;
                        this.f3644dp = null;
                        this.f3645dq = null;
                        this.f3650qi = null;
                        this.oth = Collections.EMPTY_LIST;
                    }
                    this.privateKey = privateKey;
                    return;
                }
                base64URL11 = base64URL7;
                base64URL12 = base64URL8;
                if (base64URL4 != null) {
                    if (base64URL4 == null) {
                    }
                    if (base64URL4 != null) {
                    }
                }
                this.privateKey = privateKey;
                return;
            }
            throw new IllegalArgumentException("The public exponent value must not be null");
        }
        throw new IllegalArgumentException("The modulus value must not be null");
    }

    public static RSAKey parse(X509Certificate x509Certificate) throws JOSEException {
        if (x509Certificate.getPublicKey() instanceof RSAPublicKey) {
            try {
                return new Builder((RSAPublicKey) x509Certificate.getPublicKey()).keyUse(KeyUse.from(x509Certificate)).keyID(x509Certificate.getSerialNumber().toString(10)).x509CertChain(Collections.singletonList(Base64.encode(x509Certificate.getEncoded()))).x509CertSHA256Thumbprint(Base64URL.encode(MessageDigest.getInstance("SHA-256").digest(x509Certificate.getEncoded()))).expirationTime(x509Certificate.getNotAfter()).notBeforeTime(x509Certificate.getNotBefore()).build();
            } catch (NoSuchAlgorithmException e) {
                throw new JOSEException("Couldn't encode x5t parameter: " + e.getMessage(), e);
            } catch (CertificateEncodingException e2) {
                throw new JOSEException("Couldn't encode x5c parameter: " + e2.getMessage(), e2);
            }
        }
        throw new JOSEException("The public key of the X.509 certificate is not RSA");
    }

    @Deprecated
    public RSAKey(RSAPublicKey rSAPublicKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(rSAPublicKey, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, null, null, null, keyStore);
    }

    public RSAKey(RSAPublicKey rSAPublicKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, Date date, Date date2, Date date3, KeyStore keyStore) {
        this(Base64URL.encode(rSAPublicKey.getModulus()), Base64URL.encode(rSAPublicKey.getPublicExponent()), keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, date, date2, date3, keyStore);
    }

    @Deprecated
    public RSAKey(RSAPublicKey rSAPublicKey, RSAPrivateKey rSAPrivateKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(rSAPublicKey, rSAPrivateKey, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, (Date) null, (Date) null, (Date) null, keyStore);
    }

    public RSAKey(RSAPublicKey rSAPublicKey, RSAPrivateKey rSAPrivateKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, Date date, Date date2, Date date3, KeyStore keyStore) {
        this(Base64URL.encode(rSAPublicKey.getModulus()), Base64URL.encode(rSAPublicKey.getPublicExponent()), Base64URL.encode(rSAPrivateKey.getPrivateExponent()), keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, date, date2, date3, keyStore);
    }

    @Deprecated
    public RSAKey(RSAPublicKey rSAPublicKey, RSAPrivateCrtKey rSAPrivateCrtKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(rSAPublicKey, rSAPrivateCrtKey, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, (Date) null, (Date) null, (Date) null, keyStore);
    }

    public RSAKey(RSAPublicKey rSAPublicKey, RSAPrivateCrtKey rSAPrivateCrtKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, Date date, Date date2, Date date3, KeyStore keyStore) {
        this(Base64URL.encode(rSAPublicKey.getModulus()), Base64URL.encode(rSAPublicKey.getPublicExponent()), Base64URL.encode(rSAPrivateCrtKey.getPrivateExponent()), Base64URL.encode(rSAPrivateCrtKey.getPrimeP()), Base64URL.encode(rSAPrivateCrtKey.getPrimeQ()), Base64URL.encode(rSAPrivateCrtKey.getPrimeExponentP()), Base64URL.encode(rSAPrivateCrtKey.getPrimeExponentQ()), Base64URL.encode(rSAPrivateCrtKey.getCrtCoefficient()), null, null, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, date, date2, date3, keyStore);
    }

    @Deprecated
    public RSAKey(RSAPublicKey rSAPublicKey, RSAMultiPrimePrivateCrtKey rSAMultiPrimePrivateCrtKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(rSAPublicKey, rSAMultiPrimePrivateCrtKey, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, (Date) null, (Date) null, (Date) null, keyStore);
    }

    public RSAKey(RSAPublicKey rSAPublicKey, RSAMultiPrimePrivateCrtKey rSAMultiPrimePrivateCrtKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, Date date, Date date2, Date date3, KeyStore keyStore) {
        this(Base64URL.encode(rSAPublicKey.getModulus()), Base64URL.encode(rSAPublicKey.getPublicExponent()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrivateExponent()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeP()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeQ()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeExponentP()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeExponentQ()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getCrtCoefficient()), OtherPrimesInfo.toList(rSAMultiPrimePrivateCrtKey.getOtherPrimeInfo()), null, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, date, date2, date3, keyStore);
    }

    @Deprecated
    public RSAKey(RSAPublicKey rSAPublicKey, PrivateKey privateKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(rSAPublicKey, privateKey, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, (Date) null, (Date) null, (Date) null, keyStore);
    }

    public RSAKey(RSAPublicKey rSAPublicKey, PrivateKey privateKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, Date date, Date date2, Date date3, KeyStore keyStore) {
        this(Base64URL.encode(rSAPublicKey.getModulus()), Base64URL.encode(rSAPublicKey.getPublicExponent()), null, null, null, null, null, null, null, privateKey, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, date, date2, date3, keyStore);
    }
}
