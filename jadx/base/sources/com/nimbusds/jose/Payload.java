package com.nimbusds.jose;

import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.JSONObjectUtils;
import com.nimbusds.jose.util.StandardCharset;
import com.nimbusds.jwt.SignedJWT;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Map;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class Payload implements Serializable {
    private static final long serialVersionUID = 1;
    private final Base64URL base64URL;
    private final byte[] bytes;
    private final Map<String, Object> jsonObject;
    private final JWSObject jwsObject;
    private final Origin origin;
    private final SignedJWT signedJWT;
    private final String string;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Origin {
        JSON,
        STRING,
        BYTE_ARRAY,
        BASE64URL,
        JWS_OBJECT,
        SIGNED_JWT
    }

    public Payload(Map<String, Object> map) {
        if (map == null) {
            throw new IllegalArgumentException("The JSON object must not be null");
        }
        Map<String, Object> mapNewJSONObject = JSONObjectUtils.newJSONObject();
        this.jsonObject = mapNewJSONObject;
        mapNewJSONObject.putAll(map);
        this.string = null;
        this.bytes = null;
        this.base64URL = null;
        this.jwsObject = null;
        this.signedJWT = null;
        this.origin = Origin.JSON;
    }

    private static String byteArrayToString(byte[] bArr) {
        if (bArr != null) {
            return new String(bArr, StandardCharset.UTF_8);
        }
        return null;
    }

    private static byte[] stringToByteArray(String str) {
        if (str != null) {
            return str.getBytes(StandardCharset.UTF_8);
        }
        return null;
    }

    public Origin getOrigin() {
        return this.origin;
    }

    public Base64URL toBase64URL() {
        Base64URL base64URL = this.base64URL;
        return base64URL != null ? base64URL : Base64URL.encode(toBytes());
    }

    public byte[] toBytes() {
        byte[] bArr = this.bytes;
        if (bArr != null) {
            return bArr;
        }
        Base64URL base64URL = this.base64URL;
        return base64URL != null ? base64URL.decode() : stringToByteArray(toString());
    }

    public Map<String, Object> toJSONObject() {
        Map<String, Object> map = this.jsonObject;
        if (map != null) {
            return map;
        }
        String string = toString();
        if (string == null) {
            return null;
        }
        try {
            return JSONObjectUtils.parse(string);
        } catch (ParseException unused) {
            return null;
        }
    }

    public JWSObject toJWSObject() {
        JWSObject jWSObject = this.jwsObject;
        if (jWSObject != null) {
            return jWSObject;
        }
        try {
            return JWSObject.parse(toString());
        } catch (ParseException unused) {
            return null;
        }
    }

    public SignedJWT toSignedJWT() {
        SignedJWT signedJWT = this.signedJWT;
        if (signedJWT != null) {
            return signedJWT;
        }
        try {
            return SignedJWT.parse(toString());
        } catch (ParseException unused) {
            return null;
        }
    }

    public String toString() {
        String str = this.string;
        if (str != null) {
            return str;
        }
        JWSObject jWSObject = this.jwsObject;
        if (jWSObject != null) {
            return jWSObject.getParsedString() != null ? this.jwsObject.getParsedString() : this.jwsObject.serialize();
        }
        Map<String, Object> map = this.jsonObject;
        if (map != null) {
            return JSONObjectUtils.toJSONString(map);
        }
        byte[] bArr = this.bytes;
        if (bArr != null) {
            return byteArrayToString(bArr);
        }
        Base64URL base64URL = this.base64URL;
        if (base64URL != null) {
            return base64URL.decodeToString();
        }
        return null;
    }

    public <T> T toType(PayloadTransformer<T> payloadTransformer) {
        return payloadTransformer.transform(this);
    }

    public Payload(String str) {
        if (str != null) {
            this.jsonObject = null;
            this.string = str;
            this.bytes = null;
            this.base64URL = null;
            this.jwsObject = null;
            this.signedJWT = null;
            this.origin = Origin.STRING;
            return;
        }
        throw new IllegalArgumentException("The string must not be null");
    }

    public Payload(byte[] bArr) {
        if (bArr != null) {
            this.jsonObject = null;
            this.string = null;
            this.bytes = bArr;
            this.base64URL = null;
            this.jwsObject = null;
            this.signedJWT = null;
            this.origin = Origin.BYTE_ARRAY;
            return;
        }
        throw new IllegalArgumentException("The byte array must not be null");
    }

    public Payload(Base64URL base64URL) {
        if (base64URL != null) {
            this.jsonObject = null;
            this.string = null;
            this.bytes = null;
            this.base64URL = base64URL;
            this.jwsObject = null;
            this.signedJWT = null;
            this.origin = Origin.BASE64URL;
            return;
        }
        throw new IllegalArgumentException("The Base64URL-encoded object must not be null");
    }

    public Payload(JWSObject jWSObject) {
        if (jWSObject != null) {
            if (jWSObject.getState() != JWSObject.State.UNSIGNED) {
                this.jsonObject = null;
                this.string = null;
                this.bytes = null;
                this.base64URL = null;
                this.jwsObject = jWSObject;
                this.signedJWT = null;
                this.origin = Origin.JWS_OBJECT;
                return;
            }
            throw new IllegalArgumentException("The JWS object must be signed");
        }
        throw new IllegalArgumentException("The JWS object must not be null");
    }

    public Payload(SignedJWT signedJWT) {
        if (signedJWT != null) {
            if (signedJWT.getState() != JWSObject.State.UNSIGNED) {
                this.jsonObject = null;
                this.string = null;
                this.bytes = null;
                this.base64URL = null;
                this.signedJWT = signedJWT;
                this.jwsObject = signedJWT;
                this.origin = Origin.SIGNED_JWT;
                return;
            }
            throw new IllegalArgumentException("The JWT must be signed");
        }
        throw new IllegalArgumentException("The signed JWT must not be null");
    }
}
