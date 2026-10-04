package com.nimbusds.jose;

import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.JSONObjectUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class Header implements Serializable {
    private static final Map<String, Object> EMPTY_CUSTOM_PARAMS = Collections.unmodifiableMap(new HashMap());
    public static final int MAX_HEADER_STRING_LENGTH = 20000;
    private static final long serialVersionUID = 1;
    private final Algorithm alg;
    private final Set<String> crit;
    private final String cty;
    private final Map<String, Object> customParams;
    private final Base64URL parsedBase64URL;
    private final JOSEObjectType typ;

    public Header(Algorithm algorithm, JOSEObjectType jOSEObjectType, String str, Set<String> set, Map<String, Object> map, Base64URL base64URL) {
        this.alg = algorithm;
        this.typ = jOSEObjectType;
        this.cty = str;
        if (set != null) {
            this.crit = Collections.unmodifiableSet(new HashSet(set));
        } else {
            this.crit = null;
        }
        if (map != null) {
            this.customParams = Collections.unmodifiableMap(new HashMap(map));
        } else {
            this.customParams = EMPTY_CUSTOM_PARAMS;
        }
        this.parsedBase64URL = base64URL;
    }

    public static Header parse(Map<String, Object> map) {
        return parse(map, (Base64URL) null);
    }

    public static Algorithm parseAlgorithm(Map<String, Object> map) {
        String string = JSONObjectUtils.getString(map, "alg");
        if (string == null) {
            throw new ParseException("Missing \"alg\" in header JSON object", 0);
        }
        Algorithm algorithm = Algorithm.NONE;
        return string.equals(algorithm.getName()) ? algorithm : map.containsKey(HeaderParameterNames.ENCRYPTION_ALGORITHM) ? JWEAlgorithm.parse(string) : JWSAlgorithm.parse(string);
    }

    public Algorithm getAlgorithm() {
        return this.alg;
    }

    public String getContentType() {
        return this.cty;
    }

    public Set<String> getCriticalParams() {
        return this.crit;
    }

    public Object getCustomParam(String str) {
        return this.customParams.get(str);
    }

    public Map<String, Object> getCustomParams() {
        return this.customParams;
    }

    public Set<String> getIncludedParams() {
        HashSet hashSet = new HashSet(getCustomParams().keySet());
        if (getAlgorithm() != null) {
            hashSet.add("alg");
        }
        if (getType() != null) {
            hashSet.add("typ");
        }
        if (getContentType() != null) {
            hashSet.add(HeaderParameterNames.CONTENT_TYPE);
        }
        if (getCriticalParams() != null && !getCriticalParams().isEmpty()) {
            hashSet.add(HeaderParameterNames.CRITICAL);
        }
        return hashSet;
    }

    public Base64URL getParsedBase64URL() {
        return this.parsedBase64URL;
    }

    public JOSEObjectType getType() {
        return this.typ;
    }

    public Header join(UnprotectedHeader unprotectedHeader) throws ParseException {
        Map<String, Object> jSONObject = toJSONObject();
        try {
            HeaderValidation.ensureDisjoint(this, unprotectedHeader);
            if (unprotectedHeader != null) {
                jSONObject.putAll(unprotectedHeader.toJSONObject());
            }
            return parse(jSONObject, (Base64URL) null);
        } catch (IllegalHeaderException e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    public Base64URL toBase64URL() {
        Base64URL base64URL = this.parsedBase64URL;
        return base64URL == null ? Base64URL.encode(toString()) : base64URL;
    }

    public Map<String, Object> toJSONObject() {
        Map<String, Object> mapNewJSONObject = JSONObjectUtils.newJSONObject();
        mapNewJSONObject.putAll(this.customParams);
        Algorithm algorithm = this.alg;
        if (algorithm != null) {
            mapNewJSONObject.put("alg", algorithm.toString());
        }
        JOSEObjectType jOSEObjectType = this.typ;
        if (jOSEObjectType != null) {
            mapNewJSONObject.put("typ", jOSEObjectType.toString());
        }
        String str = this.cty;
        if (str != null) {
            mapNewJSONObject.put(HeaderParameterNames.CONTENT_TYPE, str);
        }
        Set<String> set = this.crit;
        if (set != null && !set.isEmpty()) {
            mapNewJSONObject.put(HeaderParameterNames.CRITICAL, new ArrayList(this.crit));
        }
        return mapNewJSONObject;
    }

    public String toString() {
        return JSONObjectUtils.toJSONString(toJSONObject());
    }

    public static Header parse(Map<String, Object> map, Base64URL base64URL) throws ParseException {
        String string = JSONObjectUtils.getString(map, "alg");
        if (map.containsKey(HeaderParameterNames.ENCRYPTION_ALGORITHM)) {
            return JWEHeader.parse(map, base64URL);
        }
        if (Algorithm.NONE.getName().equals(string)) {
            return PlainHeader.parse(map, base64URL);
        }
        if (map.containsKey("alg")) {
            return JWSHeader.parse(map, base64URL);
        }
        throw new ParseException("Missing \"alg\" in header JSON object", 0);
    }

    public Header(Header header) {
        this(header.getAlgorithm(), header.getType(), header.getContentType(), header.getCriticalParams(), header.getCustomParams(), header.getParsedBase64URL());
    }

    public static Header parse(String str) {
        return parse(str, (Base64URL) null);
    }

    public static Header parse(String str, Base64URL base64URL) {
        return parse(JSONObjectUtils.parse(str, 20000), base64URL);
    }

    public static Header parse(Base64URL base64URL) {
        return parse(base64URL.decodeToString(), base64URL);
    }
}
