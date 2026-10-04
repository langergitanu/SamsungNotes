package com.nimbusds.jose;

import com.nimbusds.jose.util.JSONObjectUtils;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class UnprotectedHeader {
    private final Map<String, Object> params;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private final Map<String, Object> params = JSONObjectUtils.newJSONObject();

        public UnprotectedHeader build() {
            return new UnprotectedHeader(this.params);
        }

        public Builder keyID(String str) {
            this.params.put("kid", str);
            return this;
        }

        public Builder param(String str, Object obj) {
            this.params.put(str, obj);
            return this;
        }
    }

    public static UnprotectedHeader parse(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Builder builder = new Builder();
        for (String str : map.keySet()) {
            builder = builder.param(str, map.get(str));
        }
        return builder.build();
    }

    public Set<String> getIncludedParams() {
        return this.params.keySet();
    }

    public String getKeyID() {
        return (String) this.params.get("kid");
    }

    public Object getParam(String str) {
        return this.params.get(str);
    }

    public Map<String, Object> toJSONObject() {
        Map<String, Object> mapNewJSONObject = JSONObjectUtils.newJSONObject();
        mapNewJSONObject.putAll(this.params);
        return mapNewJSONObject;
    }

    private UnprotectedHeader(Map<String, Object> map) {
        Objects.requireNonNull(map);
        this.params = map;
    }
}
