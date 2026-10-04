package com.nimbusds.jose;

import com.microsoft.identity.common.java.constants.FidoConstants;
import com.nimbusds.jose.util.JSONObjectUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class JOSEObjectJSON implements Serializable {
    public static final String MIME_TYPE_JOSE_JSON = "application/jose+json; charset=UTF-8";
    private static final long serialVersionUID = 1;
    private Payload payload;

    public JOSEObjectJSON(Payload payload) {
        this.payload = payload;
    }

    public static JOSEObjectJSON parse(Map<String, Object> map) throws ParseException {
        if (map.containsKey(FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY) || map.containsKey("signatures")) {
            return JWSObjectJSON.parse(map);
        }
        if (map.containsKey("ciphertext")) {
            throw new ParseException("JWE JSON not supported", 0);
        }
        throw new ParseException("Invalid JOSE object", 0);
    }

    public Payload getPayload() {
        return this.payload;
    }

    public abstract String serializeFlattened();

    public abstract String serializeGeneral();

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public abstract Map<String, Object> toFlattenedJSONObject();

    public abstract Map<String, Object> toGeneralJSONObject();

    public static JOSEObjectJSON parse(String str) {
        Objects.requireNonNull(str);
        return parse(JSONObjectUtils.parse(str));
    }
}
