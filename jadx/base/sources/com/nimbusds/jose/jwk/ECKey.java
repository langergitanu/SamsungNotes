package com.nimbusds.jose.jwk;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.crypto.utils.ECChecks;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.BigIntegerUtils;
import com.nimbusds.jose.util.JSONObjectUtils;
import java.math.BigInteger;
import java.net.URI;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.jcip.annotations.Immutable;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class ECKey extends JWK implements AsymmetricJWK, CurveBasedJWK {
    public static final Set<Curve> SUPPORTED_CURVES = Collections.unmodifiableSet(new HashSet(Arrays.asList(Curve.P_256, Curve.SECP256K1, Curve.P_384, Curve.P_521)));
    private static final long serialVersionUID = 1;
    private final Curve crv;

    /* JADX INFO: renamed from: d */
    private final Base64URL f3627d;
    private final PrivateKey privateKey;

    /* JADX INFO: renamed from: x */
    private final Base64URL f3628x;

    /* JADX INFO: renamed from: y */
    private final Base64URL f3629y;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private Algorithm alg;
        private final Curve crv;

        /* JADX INFO: renamed from: d */
        private Base64URL f3630d;
        private Date exp;
        private Date iat;
        private String kid;

        /* JADX INFO: renamed from: ks */
        private KeyStore f3631ks;
        private Date nbf;
        private Set<KeyOperation> ops;
        private PrivateKey priv;
        private KeyUse use;

        /* JADX INFO: renamed from: x */
        private final Base64URL f3632x;
        private List<Base64> x5c;

        @Deprecated
        private Base64URL x5t;
        private Base64URL x5t256;
        private URI x5u;

        /* JADX INFO: renamed from: y */
        private final Base64URL f3633y;

        public Builder(Curve curve, Base64URL base64URL, Base64URL base64URL2) {
            if (curve == null) {
                throw new IllegalArgumentException("The curve must not be null");
            }
            this.crv = curve;
            if (base64URL == null) {
                throw new IllegalArgumentException("The 'x' coordinate must not be null");
            }
            this.f3632x = base64URL;
            if (base64URL2 == null) {
                throw new IllegalArgumentException("The 'y' coordinate must not be null");
            }
            this.f3633y = base64URL2;
        }

        public Builder algorithm(Algorithm algorithm) {
            this.alg = algorithm;
            return this;
        }

        public ECKey build() {
            try {
                return (this.f3630d == null && this.priv == null) ? new ECKey(this.crv, this.f3632x, this.f3633y, this.use, this.ops, this.alg, this.kid, this.x5u, this.x5t, this.x5t256, this.x5c, this.exp, this.nbf, this.iat, this.f3631ks) : this.priv != null ? new ECKey(this.crv, this.f3632x, this.f3633y, this.priv, this.use, this.ops, this.alg, this.kid, this.x5u, this.x5t, this.x5t256, this.x5c, this.exp, this.nbf, this.iat, this.f3631ks) : new ECKey(this.crv, this.f3632x, this.f3633y, this.f3630d, this.use, this.ops, this.alg, this.kid, this.x5u, this.x5t, this.x5t256, this.x5c, this.exp, this.nbf, this.iat, this.f3631ks);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        }

        /* JADX INFO: renamed from: d */
        public Builder m4636d(Base64URL base64URL) {
            this.f3630d = base64URL;
            return this;
        }

        public Builder expirationTime(Date date) {
            this.exp = date;
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
            this.f3631ks = keyStore;
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

        public Builder privateKey(ECPrivateKey eCPrivateKey) {
            if (eCPrivateKey != null) {
                this.f3630d = ECKey.encodeCoordinate(eCPrivateKey.getParams().getCurve().getField().getFieldSize(), eCPrivateKey.getS());
            }
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
            linkedHashMap.put("crv", this.crv.toString());
            linkedHashMap.put(JWKParameterNames.KEY_TYPE, KeyType.f3634EC.getValue());
            linkedHashMap.put("x", this.f3632x.toString());
            linkedHashMap.put("y", this.f3633y.toString());
            this.kid = ThumbprintUtils.compute(str, (LinkedHashMap<String, ?>) linkedHashMap).toString();
            return this;
        }

        public Builder privateKey(PrivateKey privateKey) {
            if (privateKey instanceof ECPrivateKey) {
                return privateKey((ECPrivateKey) privateKey);
            }
            if (!"EC".equalsIgnoreCase(privateKey.getAlgorithm())) {
                throw new IllegalArgumentException("The private key algorithm must be EC");
            }
            this.priv = privateKey;
            return this;
        }

        public Builder(Curve curve, ECPublicKey eCPublicKey) {
            this(curve, ECKey.encodeCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineX()), ECKey.encodeCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineY()));
        }

        public Builder(ECKey eCKey) {
            this.crv = eCKey.crv;
            this.f3632x = eCKey.f3628x;
            this.f3633y = eCKey.f3629y;
            this.f3630d = eCKey.f3627d;
            this.priv = eCKey.privateKey;
            this.use = eCKey.getKeyUse();
            this.ops = eCKey.getKeyOperations();
            this.alg = eCKey.getAlgorithm();
            this.kid = eCKey.getKeyID();
            this.x5u = eCKey.getX509CertURL();
            this.x5t = eCKey.getX509CertThumbprint();
            this.x5t256 = eCKey.getX509CertSHA256Thumbprint();
            this.x5c = eCKey.getX509CertChain();
            this.exp = eCKey.getExpirationTime();
            this.nbf = eCKey.getNotBeforeTime();
            this.iat = eCKey.getIssueTime();
            this.f3631ks = eCKey.getKeyStore();
        }
    }

    @Deprecated
    public ECKey(Curve curve, Base64URL base64URL, Base64URL base64URL2, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, KeyStore keyStore) {
        this(curve, base64URL, base64URL2, keyUse, set, algorithm, str, uri, base64URL3, base64URL4, list, (Date) null, (Date) null, (Date) null, keyStore);
    }

    public static Base64URL encodeCoordinate(int i, BigInteger bigInteger) {
        byte[] bytesUnsigned = BigIntegerUtils.toBytesUnsigned(bigInteger);
        int i2 = (i + 7) / 8;
        if (bytesUnsigned.length >= i2) {
            return Base64URL.encode(bytesUnsigned);
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(bytesUnsigned, 0, bArr, i2 - bytesUnsigned.length, bytesUnsigned.length);
        return Base64URL.encode(bArr);
    }

    private void ensureMatches(List<X509Certificate> list) {
        if (list != null && !matches(list.get(0))) {
            throw new IllegalArgumentException("The public subject key info of the first X.509 certificate in the chain must match the JWK type and public parameters");
        }
    }

    private static void ensurePublicCoordinatesOnCurve(Curve curve, Base64URL base64URL, Base64URL base64URL2) {
        if (!SUPPORTED_CURVES.contains(curve)) {
            throw new IllegalArgumentException("Unknown / unsupported curve: " + curve);
        }
        if (ECChecks.isPointOnCurve(base64URL.decodeToBigInteger(), base64URL2.decodeToBigInteger(), curve.toECParameterSpec())) {
            return;
        }
        throw new IllegalArgumentException("Invalid EC JWK: The 'x' and 'y' public coordinates are not on the " + curve + " curve");
    }

    public static ECKey load(KeyStore keyStore, String str, char[] cArr) throws JOSEException, KeyStoreException {
        Certificate certificate = keyStore.getCertificate(str);
        if (!(certificate instanceof X509Certificate)) {
            return null;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        if (!(x509Certificate.getPublicKey() instanceof ECPublicKey)) {
            throw new JOSEException("Couldn't load EC JWK: The key algorithm is not EC");
        }
        ECKey eCKeyBuild = new Builder(parse(x509Certificate)).keyID(str).keyStore(keyStore).build();
        try {
            Key key = keyStore.getKey(str, cArr);
            return key instanceof ECPrivateKey ? new Builder(eCKeyBuild).privateKey((ECPrivateKey) key).build() : ((key instanceof PrivateKey) && "EC".equalsIgnoreCase(key.getAlgorithm())) ? new Builder(eCKeyBuild).privateKey((PrivateKey) key).build() : eCKeyBuild;
        } catch (NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new JOSEException("Couldn't retrieve private EC key (bad pin?): " + e.getMessage(), e);
        }
    }

    public static ECKey parse(String str) {
        return parse(JSONObjectUtils.parse(str));
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ECKey) || !super.equals(obj)) {
            return false;
        }
        ECKey eCKey = (ECKey) obj;
        return Objects.equals(this.crv, eCKey.crv) && Objects.equals(this.f3628x, eCKey.f3628x) && Objects.equals(this.f3629y, eCKey.f3629y) && Objects.equals(this.f3627d, eCKey.f3627d) && Objects.equals(this.privateKey, eCKey.privateKey);
    }

    @Override // com.nimbusds.jose.jwk.CurveBasedJWK
    public Curve getCurve() {
        return this.crv;
    }

    public Base64URL getD() {
        return this.f3627d;
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public LinkedHashMap<String, ?> getRequiredParams() {
        LinkedHashMap<String, ?> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("crv", this.crv.toString());
        linkedHashMap.put(JWKParameterNames.KEY_TYPE, getKeyType().getValue());
        linkedHashMap.put("x", this.f3628x.toString());
        linkedHashMap.put("y", this.f3629y.toString());
        return linkedHashMap;
    }

    public Base64URL getX() {
        return this.f3628x;
    }

    public Base64URL getY() {
        return this.f3629y;
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.crv, this.f3628x, this.f3629y, this.f3627d, this.privateKey);
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public boolean isPrivate() {
        return (this.f3627d == null && this.privateKey == null) ? false : true;
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public boolean matches(X509Certificate x509Certificate) {
        try {
            ECPublicKey eCPublicKey = (ECPublicKey) getParsedX509CertChain().get(0).getPublicKey();
            if (getX().decodeToBigInteger().equals(eCPublicKey.getW().getAffineX())) {
                return getY().decodeToBigInteger().equals(eCPublicKey.getW().getAffineY());
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public int size() {
        ECParameterSpec eCParameterSpec = this.crv.toECParameterSpec();
        if (eCParameterSpec != null) {
            return eCParameterSpec.getCurve().getField().getFieldSize();
        }
        throw new UnsupportedOperationException("Couldn't determine field size for curve " + this.crv.getName());
    }

    public ECPrivateKey toECPrivateKey() {
        return toECPrivateKey(null);
    }

    public ECPublicKey toECPublicKey() {
        return toECPublicKey(null);
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public Map<String, Object> toJSONObject() {
        Map<String, Object> jSONObject = super.toJSONObject();
        jSONObject.put("crv", this.crv.toString());
        jSONObject.put("x", this.f3628x.toString());
        jSONObject.put("y", this.f3629y.toString());
        Base64URL base64URL = this.f3627d;
        if (base64URL != null) {
            jSONObject.put("d", base64URL.toString());
        }
        return jSONObject;
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public KeyPair toKeyPair() {
        return toKeyPair(null);
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public PrivateKey toPrivateKey() {
        ECPrivateKey eCPrivateKey = toECPrivateKey();
        return eCPrivateKey != null ? eCPrivateKey : this.privateKey;
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public PublicKey toPublicKey() {
        return toECPublicKey();
    }

    @Deprecated
    public ECKey(Curve curve, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL4, Base64URL base64URL5, List<Base64> list, KeyStore keyStore) {
        this(curve, base64URL, base64URL2, base64URL3, keyUse, set, algorithm, str, uri, base64URL4, base64URL5, list, (Date) null, (Date) null, (Date) null, keyStore);
    }

    public static ECKey parse(Map<String, Object> map) throws ParseException {
        if (!KeyType.f3634EC.equals(JWKMetadata.parseKeyType(map))) {
            throw new ParseException("The key type \"kty\" must be EC", 0);
        }
        try {
            Curve curve = Curve.parse(JSONObjectUtils.getString(map, "crv"));
            Base64URL base64URL = JSONObjectUtils.getBase64URL(map, "x");
            Base64URL base64URL2 = JSONObjectUtils.getBase64URL(map, "y");
            Base64URL base64URL3 = JSONObjectUtils.getBase64URL(map, "d");
            try {
                return base64URL3 == null ? new ECKey(curve, base64URL, base64URL2, JWKMetadata.parseKeyUse(map), JWKMetadata.parseKeyOperations(map), JWKMetadata.parseAlgorithm(map), JWKMetadata.parseKeyID(map), JWKMetadata.parseX509CertURL(map), JWKMetadata.parseX509CertThumbprint(map), JWKMetadata.parseX509CertSHA256Thumbprint(map), JWKMetadata.parseX509CertChain(map), JWKMetadata.parseExpirationTime(map), JWKMetadata.parseNotBeforeTime(map), JWKMetadata.parseIssueTime(map), (KeyStore) null) : new ECKey(curve, base64URL, base64URL2, base64URL3, JWKMetadata.parseKeyUse(map), JWKMetadata.parseKeyOperations(map), JWKMetadata.parseAlgorithm(map), JWKMetadata.parseKeyID(map), JWKMetadata.parseX509CertURL(map), JWKMetadata.parseX509CertThumbprint(map), JWKMetadata.parseX509CertSHA256Thumbprint(map), JWKMetadata.parseX509CertChain(map), JWKMetadata.parseExpirationTime(map), JWKMetadata.parseNotBeforeTime(map), JWKMetadata.parseIssueTime(map), (KeyStore) null);
            } catch (IllegalArgumentException e) {
                throw new ParseException(e.getMessage(), 0);
            }
        } catch (IllegalArgumentException e2) {
            throw new ParseException(e2.getMessage(), 0);
        }
    }

    public ECPrivateKey toECPrivateKey(Provider provider) throws JOSEException {
        if (this.f3627d == null) {
            return null;
        }
        ECParameterSpec eCParameterSpec = this.crv.toECParameterSpec();
        if (eCParameterSpec == null) {
            throw new JOSEException("Couldn't get EC parameter spec for curve " + this.crv);
        }
        try {
            return (ECPrivateKey) (provider == null ? KeyFactory.getInstance("EC") : KeyFactory.getInstance("EC", provider)).generatePrivate(new ECPrivateKeySpec(this.f3627d.decodeToBigInteger(), eCParameterSpec));
        } catch (NoSuchAlgorithmException e) {
            e = e;
            throw new JOSEException(e.getMessage(), e);
        } catch (InvalidKeySpecException e2) {
            e = e2;
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public ECPublicKey toECPublicKey(Provider provider) throws JOSEException {
        ECParameterSpec eCParameterSpec = this.crv.toECParameterSpec();
        if (eCParameterSpec == null) {
            throw new JOSEException("Couldn't get EC parameter spec for curve " + this.crv);
        }
        try {
            return (ECPublicKey) (provider == null ? KeyFactory.getInstance("EC") : KeyFactory.getInstance("EC", provider)).generatePublic(new ECPublicKeySpec(new ECPoint(this.f3628x.decodeToBigInteger(), this.f3629y.decodeToBigInteger()), eCParameterSpec));
        } catch (NoSuchAlgorithmException e) {
            e = e;
            throw new JOSEException(e.getMessage(), e);
        } catch (InvalidKeySpecException e2) {
            e = e2;
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public KeyPair toKeyPair(Provider provider) {
        return this.privateKey != null ? new KeyPair(toECPublicKey(provider), this.privateKey) : new KeyPair(toECPublicKey(provider), toECPrivateKey(provider));
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public ECKey toPublicJWK() {
        return new ECKey(getCurve(), getX(), getY(), getKeyUse(), getKeyOperations(), getAlgorithm(), getKeyID(), getX509CertURL(), getX509CertThumbprint(), getX509CertSHA256Thumbprint(), getX509CertChain(), getExpirationTime(), getNotBeforeTime(), getIssueTime(), getKeyStore());
    }

    @Deprecated
    public ECKey(Curve curve, Base64URL base64URL, Base64URL base64URL2, PrivateKey privateKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, KeyStore keyStore) {
        this(curve, base64URL, base64URL2, privateKey, keyUse, set, algorithm, str, uri, base64URL3, base64URL4, list, (Date) null, (Date) null, (Date) null, keyStore);
    }

    @Deprecated
    public ECKey(Curve curve, ECPublicKey eCPublicKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(curve, encodeCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineX()), encodeCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineY()), keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, (Date) null, (Date) null, (Date) null, keyStore);
    }

    @Deprecated
    public ECKey(Curve curve, ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(curve, encodeCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineX()), encodeCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineY()), encodeCoordinate(eCPrivateKey.getParams().getCurve().getField().getFieldSize(), eCPrivateKey.getS()), keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, (Date) null, (Date) null, (Date) null, keyStore);
    }

    @Deprecated
    public ECKey(Curve curve, ECPublicKey eCPublicKey, PrivateKey privateKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(curve, encodeCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineX()), encodeCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineY()), privateKey, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, (Date) null, (Date) null, (Date) null, keyStore);
    }

    public ECKey(Curve curve, Base64URL base64URL, Base64URL base64URL2, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, Date date, Date date2, Date date3, KeyStore keyStore) {
        super(KeyType.f3634EC, keyUse, set, algorithm, str, uri, base64URL3, base64URL4, list, date, date2, date3, keyStore);
        if (curve != null) {
            this.crv = curve;
            if (base64URL != null) {
                this.f3628x = base64URL;
                if (base64URL2 != null) {
                    this.f3629y = base64URL2;
                    ensurePublicCoordinatesOnCurve(curve, base64URL, base64URL2);
                    ensureMatches(getParsedX509CertChain());
                    this.f3627d = null;
                    this.privateKey = null;
                    return;
                }
                throw new IllegalArgumentException("The 'y' coordinate must not be null");
            }
            throw new IllegalArgumentException("The 'x' coordinate must not be null");
        }
        throw new IllegalArgumentException("The curve must not be null");
    }

    public ECKey(Curve curve, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL4, Base64URL base64URL5, List<Base64> list, Date date, Date date2, Date date3, KeyStore keyStore) {
        super(KeyType.f3634EC, keyUse, set, algorithm, str, uri, base64URL4, base64URL5, list, date, date2, date3, keyStore);
        if (curve != null) {
            this.crv = curve;
            if (base64URL != null) {
                this.f3628x = base64URL;
                if (base64URL2 != null) {
                    this.f3629y = base64URL2;
                    ensurePublicCoordinatesOnCurve(curve, base64URL, base64URL2);
                    ensureMatches(getParsedX509CertChain());
                    if (base64URL3 != null) {
                        this.f3627d = base64URL3;
                        this.privateKey = null;
                        return;
                    }
                    throw new IllegalArgumentException("The 'd' coordinate must not be null");
                }
                throw new IllegalArgumentException("The 'y' coordinate must not be null");
            }
            throw new IllegalArgumentException("The 'x' coordinate must not be null");
        }
        throw new IllegalArgumentException("The curve must not be null");
    }

    public static ECKey parse(X509Certificate x509Certificate) throws JOSEException {
        if (x509Certificate.getPublicKey() instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) x509Certificate.getPublicKey();
            try {
                String string = new JcaX509CertificateHolder(x509Certificate).getSubjectPublicKeyInfo().getAlgorithm().getParameters().toString();
                Curve curveForOID = Curve.forOID(string);
                if (curveForOID == null) {
                    throw new JOSEException("Couldn't determine EC JWK curve for OID " + string);
                }
                return new Builder(curveForOID, eCPublicKey).keyUse(KeyUse.from(x509Certificate)).keyID(x509Certificate.getSerialNumber().toString(10)).x509CertChain(Collections.singletonList(Base64.encode(x509Certificate.getEncoded()))).x509CertSHA256Thumbprint(Base64URL.encode(MessageDigest.getInstance("SHA-256").digest(x509Certificate.getEncoded()))).expirationTime(x509Certificate.getNotAfter()).notBeforeTime(x509Certificate.getNotBefore()).build();
            } catch (NoSuchAlgorithmException e) {
                throw new JOSEException("Couldn't encode x5t parameter: " + e.getMessage(), e);
            } catch (CertificateEncodingException e2) {
                throw new JOSEException("Couldn't encode x5c parameter: " + e2.getMessage(), e2);
            }
        }
        throw new JOSEException("The public key of the X.509 certificate is not EC");
    }

    public ECKey(Curve curve, Base64URL base64URL, Base64URL base64URL2, PrivateKey privateKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, Date date, Date date2, Date date3, KeyStore keyStore) {
        super(KeyType.f3634EC, keyUse, set, algorithm, str, uri, base64URL3, base64URL4, list, date, date2, date3, keyStore);
        if (curve != null) {
            this.crv = curve;
            if (base64URL != null) {
                this.f3628x = base64URL;
                if (base64URL2 != null) {
                    this.f3629y = base64URL2;
                    ensurePublicCoordinatesOnCurve(curve, base64URL, base64URL2);
                    ensureMatches(getParsedX509CertChain());
                    this.f3627d = null;
                    this.privateKey = privateKey;
                    return;
                }
                throw new IllegalArgumentException("The 'y' coordinate must not be null");
            }
            throw new IllegalArgumentException("The 'x' coordinate must not be null");
        }
        throw new IllegalArgumentException("The curve must not be null");
    }

    public ECKey(Curve curve, ECPublicKey eCPublicKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, Date date, Date date2, Date date3, KeyStore keyStore) {
        this(curve, encodeCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineX()), encodeCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineY()), keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, date, date2, date3, keyStore);
    }

    public ECKey(Curve curve, ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, Date date, Date date2, Date date3, KeyStore keyStore) {
        this(curve, encodeCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineX()), encodeCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineY()), encodeCoordinate(eCPrivateKey.getParams().getCurve().getField().getFieldSize(), eCPrivateKey.getS()), keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, date, date2, date3, keyStore);
    }

    public ECKey(Curve curve, ECPublicKey eCPublicKey, PrivateKey privateKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, Date date, Date date2, Date date3, KeyStore keyStore) {
        this(curve, encodeCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineX()), encodeCoordinate(eCPublicKey.getParams().getCurve().getField().getFieldSize(), eCPublicKey.getW().getAffineY()), privateKey, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, date, date2, date3, keyStore);
    }
}
