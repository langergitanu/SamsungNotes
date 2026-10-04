package com.nimbusds.jose.jwk;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.JSONObjectUtils;
import java.net.URI;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
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

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public class OctetKeyPair extends JWK implements AsymmetricJWK, CurveBasedJWK {
    public static final Set<Curve> SUPPORTED_CURVES = Collections.unmodifiableSet(new HashSet(Arrays.asList(Curve.Ed25519, Curve.Ed448, Curve.X25519, Curve.X448)));
    private static final long serialVersionUID = 1;
    private final Curve crv;

    /* JADX INFO: renamed from: d */
    private final Base64URL f3635d;
    private final byte[] decodedD;
    private final byte[] decodedX;

    /* JADX INFO: renamed from: x */
    private final Base64URL f3636x;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private Algorithm alg;
        private final Curve crv;

        /* JADX INFO: renamed from: d */
        private Base64URL f3637d;
        private Date exp;
        private Date iat;
        private String kid;

        /* JADX INFO: renamed from: ks */
        private KeyStore f3638ks;
        private Date nbf;
        private Set<KeyOperation> ops;
        private KeyUse use;

        /* JADX INFO: renamed from: x */
        private final Base64URL f3639x;
        private List<Base64> x5c;

        @Deprecated
        private Base64URL x5t;
        private Base64URL x5t256;
        private URI x5u;

        public Builder(Curve curve, Base64URL base64URL) {
            if (curve == null) {
                throw new IllegalArgumentException("The curve must not be null");
            }
            this.crv = curve;
            if (base64URL == null) {
                throw new IllegalArgumentException("The 'x' coordinate must not be null");
            }
            this.f3639x = base64URL;
        }

        public Builder algorithm(Algorithm algorithm) {
            this.alg = algorithm;
            return this;
        }

        public OctetKeyPair build() {
            try {
                return this.f3637d == null ? new OctetKeyPair(this.crv, this.f3639x, this.use, this.ops, this.alg, this.kid, this.x5u, this.x5t, this.x5t256, this.x5c, this.exp, this.nbf, this.iat, this.f3638ks) : new OctetKeyPair(this.crv, this.f3639x, this.f3637d, this.use, this.ops, this.alg, this.kid, this.x5u, this.x5t, this.x5t256, this.x5c, this.exp, this.nbf, this.iat, this.f3638ks);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        }

        /* JADX INFO: renamed from: d */
        public Builder m4637d(Base64URL base64URL) {
            this.f3637d = base64URL;
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
            this.f3638ks = keyStore;
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
            linkedHashMap.put(JWKParameterNames.KEY_TYPE, KeyType.OKP.getValue());
            linkedHashMap.put("x", this.f3639x.toString());
            this.kid = ThumbprintUtils.compute(str, (LinkedHashMap<String, ?>) linkedHashMap).toString();
            return this;
        }

        public Builder(OctetKeyPair octetKeyPair) {
            this.crv = octetKeyPair.crv;
            this.f3639x = octetKeyPair.f3636x;
            this.f3637d = octetKeyPair.f3635d;
            this.use = octetKeyPair.getKeyUse();
            this.ops = octetKeyPair.getKeyOperations();
            this.alg = octetKeyPair.getAlgorithm();
            this.kid = octetKeyPair.getKeyID();
            this.x5u = octetKeyPair.getX509CertURL();
            this.x5t = octetKeyPair.getX509CertThumbprint();
            this.x5t256 = octetKeyPair.getX509CertSHA256Thumbprint();
            this.x5c = octetKeyPair.getX509CertChain();
            this.exp = octetKeyPair.getExpirationTime();
            this.nbf = octetKeyPair.getNotBeforeTime();
            this.iat = octetKeyPair.getIssueTime();
            this.f3638ks = octetKeyPair.getKeyStore();
        }
    }

    @Deprecated
    public OctetKeyPair(Curve curve, Base64URL base64URL, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL2, Base64URL base64URL3, List<Base64> list, KeyStore keyStore) {
        this(curve, base64URL, keyUse, set, algorithm, str, uri, base64URL2, base64URL3, list, null, null, null, keyStore);
    }

    public static OctetKeyPair parse(String str) {
        return parse(JSONObjectUtils.parse(str));
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OctetKeyPair) || !super.equals(obj)) {
            return false;
        }
        OctetKeyPair octetKeyPair = (OctetKeyPair) obj;
        return Objects.equals(this.crv, octetKeyPair.crv) && Objects.equals(this.f3636x, octetKeyPair.f3636x) && Arrays.equals(this.decodedX, octetKeyPair.decodedX) && Objects.equals(this.f3635d, octetKeyPair.f3635d) && Arrays.equals(this.decodedD, octetKeyPair.decodedD);
    }

    @Override // com.nimbusds.jose.jwk.CurveBasedJWK
    public Curve getCurve() {
        return this.crv;
    }

    public Base64URL getD() {
        return this.f3635d;
    }

    public byte[] getDecodedD() {
        byte[] bArr = this.decodedD;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public byte[] getDecodedX() {
        return (byte[]) this.decodedX.clone();
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public LinkedHashMap<String, ?> getRequiredParams() {
        LinkedHashMap<String, ?> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("crv", this.crv.toString());
        linkedHashMap.put(JWKParameterNames.KEY_TYPE, getKeyType().getValue());
        linkedHashMap.put("x", this.f3636x.toString());
        return linkedHashMap;
    }

    public Base64URL getX() {
        return this.f3636x;
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public int hashCode() {
        return Arrays.hashCode(this.decodedD) + ((Arrays.hashCode(this.decodedX) + (Objects.hash(Integer.valueOf(super.hashCode()), this.crv, this.f3636x, this.f3635d) * 31)) * 31);
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public boolean isPrivate() {
        return this.f3635d != null;
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public boolean matches(X509Certificate x509Certificate) {
        return false;
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public int size() {
        return ByteUtils.bitLength(this.f3636x.decode());
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public Map<String, Object> toJSONObject() {
        Map<String, Object> jSONObject = super.toJSONObject();
        jSONObject.put("crv", this.crv.toString());
        jSONObject.put("x", this.f3636x.toString());
        Base64URL base64URL = this.f3635d;
        if (base64URL != null) {
            jSONObject.put("d", base64URL.toString());
        }
        return jSONObject;
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public KeyPair toKeyPair() throws JOSEException {
        throw new JOSEException("Export to java.security.KeyPair not supported");
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public PrivateKey toPrivateKey() throws JOSEException {
        throw new JOSEException("Export to java.security.PrivateKey not supported");
    }

    @Override // com.nimbusds.jose.jwk.AsymmetricJWK
    public PublicKey toPublicKey() throws JOSEException {
        throw new JOSEException("Export to java.security.PublicKey not supported");
    }

    @Deprecated
    public OctetKeyPair(Curve curve, Base64URL base64URL, Base64URL base64URL2, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, KeyStore keyStore) {
        this(curve, base64URL, base64URL2, keyUse, set, algorithm, str, uri, base64URL3, base64URL4, list, null, null, null, keyStore);
    }

    public static OctetKeyPair parse(Map<String, Object> map) throws ParseException {
        KeyType keyType = KeyType.OKP;
        if (!keyType.equals(JWKMetadata.parseKeyType(map))) {
            throw new ParseException("The key type kty must be " + keyType.getValue(), 0);
        }
        try {
            Curve curve = Curve.parse(JSONObjectUtils.getString(map, "crv"));
            Base64URL base64URL = JSONObjectUtils.getBase64URL(map, "x");
            Base64URL base64URL2 = JSONObjectUtils.getBase64URL(map, "d");
            try {
                return base64URL2 == null ? new OctetKeyPair(curve, base64URL, JWKMetadata.parseKeyUse(map), JWKMetadata.parseKeyOperations(map), JWKMetadata.parseAlgorithm(map), JWKMetadata.parseKeyID(map), JWKMetadata.parseX509CertURL(map), JWKMetadata.parseX509CertThumbprint(map), JWKMetadata.parseX509CertSHA256Thumbprint(map), JWKMetadata.parseX509CertChain(map), JWKMetadata.parseExpirationTime(map), JWKMetadata.parseNotBeforeTime(map), JWKMetadata.parseIssueTime(map), null) : new OctetKeyPair(curve, base64URL, base64URL2, JWKMetadata.parseKeyUse(map), JWKMetadata.parseKeyOperations(map), JWKMetadata.parseAlgorithm(map), JWKMetadata.parseKeyID(map), JWKMetadata.parseX509CertURL(map), JWKMetadata.parseX509CertThumbprint(map), JWKMetadata.parseX509CertSHA256Thumbprint(map), JWKMetadata.parseX509CertChain(map), JWKMetadata.parseExpirationTime(map), JWKMetadata.parseNotBeforeTime(map), JWKMetadata.parseIssueTime(map), null);
            } catch (IllegalArgumentException e) {
                throw new ParseException(e.getMessage(), 0);
            }
        } catch (IllegalArgumentException e2) {
            throw new ParseException(e2.getMessage(), 0);
        }
    }

    @Override // com.nimbusds.jose.jwk.JWK
    public OctetKeyPair toPublicJWK() {
        return new OctetKeyPair(getCurve(), getX(), getKeyUse(), getKeyOperations(), getAlgorithm(), getKeyID(), getX509CertURL(), getX509CertThumbprint(), getX509CertSHA256Thumbprint(), getX509CertChain(), getExpirationTime(), getNotBeforeTime(), getIssueTime(), getKeyStore());
    }

    public OctetKeyPair(Curve curve, Base64URL base64URL, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL2, Base64URL base64URL3, List<Base64> list, Date date, Date date2, Date date3, KeyStore keyStore) {
        super(KeyType.OKP, keyUse, set, algorithm, str, uri, base64URL2, base64URL3, list, date, date2, date3, keyStore);
        if (curve != null) {
            if (SUPPORTED_CURVES.contains(curve)) {
                this.crv = curve;
                if (base64URL != null) {
                    this.f3636x = base64URL;
                    this.decodedX = base64URL.decode();
                    this.f3635d = null;
                    this.decodedD = null;
                    return;
                }
                throw new IllegalArgumentException("The 'x' parameter must not be null");
            }
            throw new IllegalArgumentException("Unknown / unsupported curve: " + curve);
        }
        throw new IllegalArgumentException("The curve must not be null");
    }

    public OctetKeyPair(Curve curve, Base64URL base64URL, Base64URL base64URL2, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, Date date, Date date2, Date date3, KeyStore keyStore) {
        super(KeyType.OKP, keyUse, set, algorithm, str, uri, base64URL3, base64URL4, list, date, date2, date3, keyStore);
        if (curve != null) {
            if (SUPPORTED_CURVES.contains(curve)) {
                this.crv = curve;
                if (base64URL != null) {
                    this.f3636x = base64URL;
                    this.decodedX = base64URL.decode();
                    if (base64URL2 != null) {
                        this.f3635d = base64URL2;
                        this.decodedD = base64URL2.decode();
                        return;
                    }
                    throw new IllegalArgumentException("The 'd' parameter must not be null");
                }
                throw new IllegalArgumentException("The 'x' parameter must not be null");
            }
            throw new IllegalArgumentException("Unknown / unsupported curve: " + curve);
        }
        throw new IllegalArgumentException("The curve must not be null");
    }
}
