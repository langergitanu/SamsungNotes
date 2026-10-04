package com.nimbusds.jose.jwk;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.JSONObjectUtils;
import com.nimbusds.jose.util.StandardCharset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class ThumbprintUtils {
    public static Base64URL compute(JWK jwk) {
        return compute("SHA-256", jwk);
    }

    public static Base64URL compute(String str, JWK jwk) {
        return compute(str, jwk.getRequiredParams());
    }

    public static Base64URL compute(String str, LinkedHashMap<String, ?> linkedHashMap) throws JOSEException {
        String jSONString = JSONObjectUtils.toJSONString(linkedHashMap);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(jSONString.getBytes(StandardCharset.UTF_8));
            return Base64URL.encode(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new JOSEException("Couldn't compute JWK thumbprint: Unsupported hash algorithm: " + e.getMessage(), e);
        }
    }
}
