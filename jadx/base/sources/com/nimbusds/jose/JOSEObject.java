package com.nimbusds.jose;

import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.JSONObjectUtils;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.Serializable;
import java.text.ParseException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class JOSEObject implements Serializable {
    public static final String MIME_TYPE_COMPACT = "application/jose; charset=UTF-8";

    @Deprecated
    public static final String MIME_TYPE_JS = "application/jose+json; charset=UTF-8";
    private static final long serialVersionUID = 1;
    private Base64URL[] parsedParts;
    private Payload payload;

    public JOSEObject() {
        this.payload = null;
        this.parsedParts = null;
    }

    public static JOSEObject parse(String str) throws ParseException {
        try {
            Algorithm algorithm = Header.parseAlgorithm(JSONObjectUtils.parse(split(str)[0].decodeToString()));
            if (algorithm.equals(Algorithm.NONE)) {
                return PlainObject.parse(str);
            }
            if (algorithm instanceof JWSAlgorithm) {
                return JWSObject.parse(str);
            }
            if (algorithm instanceof JWEAlgorithm) {
                return JWEObject.parse(str);
            }
            throw new AssertionError("Unexpected algorithm type: " + algorithm);
        } catch (ParseException e) {
            throw new ParseException("Invalid unsecured/JWS/JWE header: " + e.getMessage(), 0);
        }
    }

    public static Base64URL[] split(String str) throws ParseException {
        String strTrim = str.trim();
        int iIndexOf = strTrim.indexOf(Extension.DOT);
        if (iIndexOf == -1) {
            throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Missing part delimiters", 0);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = strTrim.indexOf(Extension.DOT, i);
        if (iIndexOf2 == -1) {
            throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Missing second delimiter", 0);
        }
        int i2 = iIndexOf2 + 1;
        int iIndexOf3 = strTrim.indexOf(Extension.DOT, i2);
        if (iIndexOf3 == -1) {
            return new Base64URL[]{new Base64URL(strTrim.substring(0, iIndexOf)), new Base64URL(strTrim.substring(i, iIndexOf2)), new Base64URL(strTrim.substring(i2))};
        }
        int i4 = iIndexOf3 + 1;
        int iIndexOf4 = strTrim.indexOf(Extension.DOT, i4);
        if (iIndexOf4 == -1) {
            throw new ParseException("Invalid serialized JWE object: Missing fourth delimiter", 0);
        }
        if (iIndexOf4 == -1 || strTrim.indexOf(Extension.DOT, iIndexOf4 + 1) == -1) {
            return new Base64URL[]{new Base64URL(strTrim.substring(0, iIndexOf)), new Base64URL(strTrim.substring(i, iIndexOf2)), new Base64URL(strTrim.substring(i2, iIndexOf3)), new Base64URL(strTrim.substring(i4, iIndexOf4)), new Base64URL(strTrim.substring(iIndexOf4 + 1))};
        }
        throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Too many part delimiters", 0);
    }

    public abstract Header getHeader();

    public Base64URL[] getParsedParts() {
        return this.parsedParts;
    }

    public String getParsedString() {
        if (this.parsedParts == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Base64URL base64URL : this.parsedParts) {
            if (sb.length() > 0) {
                sb.append('.');
            }
            if (base64URL != null) {
                sb.append(base64URL);
            }
        }
        return sb.toString();
    }

    public Payload getPayload() {
        return this.payload;
    }

    public abstract String serialize();

    public void setParsedParts(Base64URL... base64URLArr) {
        this.parsedParts = base64URLArr;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public JOSEObject(Payload payload) {
        this.payload = payload;
    }
}
