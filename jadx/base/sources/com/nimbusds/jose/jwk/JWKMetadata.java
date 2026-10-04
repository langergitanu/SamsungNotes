package com.nimbusds.jose.jwk;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.JSONObjectUtils;
import com.nimbusds.jose.util.X509CertChainUtils;
import com.nimbusds.jwt.util.DateUtils;
import java.net.URI;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
final class JWKMetadata {
    public static Algorithm parseAlgorithm(Map<String, Object> map) {
        return Algorithm.parse(JSONObjectUtils.getString(map, "alg"));
    }

    public static Date parseExpirationTime(Map<String, Object> map) {
        if (map.get("exp") == null) {
            return null;
        }
        return DateUtils.fromSecondsSinceEpoch(JSONObjectUtils.getLong(map, "exp"));
    }

    public static Date parseIssueTime(Map<String, Object> map) {
        if (map.get("iat") == null) {
            return null;
        }
        return DateUtils.fromSecondsSinceEpoch(JSONObjectUtils.getLong(map, "iat"));
    }

    public static String parseKeyID(Map<String, Object> map) {
        return JSONObjectUtils.getString(map, "kid");
    }

    public static Set<KeyOperation> parseKeyOperations(Map<String, Object> map) {
        return KeyOperation.parse(JSONObjectUtils.getStringList(map, JWKParameterNames.KEY_OPS));
    }

    public static KeyType parseKeyType(Map<String, Object> map) throws ParseException {
        try {
            return KeyType.parse(JSONObjectUtils.getString(map, JWKParameterNames.KEY_TYPE));
        } catch (IllegalArgumentException e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    public static KeyUse parseKeyUse(Map<String, Object> map) {
        return KeyUse.parse(JSONObjectUtils.getString(map, "use"));
    }

    public static Date parseNotBeforeTime(Map<String, Object> map) {
        if (map.get("nbf") == null) {
            return null;
        }
        return DateUtils.fromSecondsSinceEpoch(JSONObjectUtils.getLong(map, "nbf"));
    }

    public static List<Base64> parseX509CertChain(Map<String, Object> map) throws ParseException {
        List<Base64> base64List = X509CertChainUtils.toBase64List(JSONObjectUtils.getJSONArray(map, "x5c"));
        if (base64List == null || !base64List.isEmpty()) {
            return base64List;
        }
        return null;
    }

    public static Base64URL parseX509CertSHA256Thumbprint(Map<String, Object> map) {
        return JSONObjectUtils.getBase64URL(map, "x5t#S256");
    }

    public static Base64URL parseX509CertThumbprint(Map<String, Object> map) {
        return JSONObjectUtils.getBase64URL(map, "x5t");
    }

    public static URI parseX509CertURL(Map<String, Object> map) {
        return JSONObjectUtils.getURI(map, "x5u");
    }
}
