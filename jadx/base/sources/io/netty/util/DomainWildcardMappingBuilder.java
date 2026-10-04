package io.netty.util;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.util.internal.ObjectUtil;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DomainWildcardMappingBuilder<V> {
    private final V defaultValue;
    private final Map<String, V> map;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ImmutableDomainWildcardMapping<V> implements Mapping<String, V> {
        private static final String REPR_HEADER = "ImmutableDomainWildcardMapping(default: ";
        private static final String REPR_MAP_CLOSING = ")";
        private static final String REPR_MAP_OPENING = ", map: ";
        private final V defaultValue;
        private final Map<String, V> map;

        public ImmutableDomainWildcardMapping(V v, Map<String, V> map) {
            this.defaultValue = v;
            this.map = new LinkedHashMap(map);
        }

        public static String normalize(String str) {
            return DomainNameMapping.normalizeHostname(str);
        }

        public String toString() {
            StringBuilder sbM1324q = AbstractC1974b.m1324q(REPR_HEADER);
            sbM1324q.append(this.defaultValue);
            sbM1324q.append(", map: {");
            for (Map.Entry<String, V> entry : this.map.entrySet()) {
                String key = entry.getKey();
                if (key.charAt(0) == '.') {
                    key = "*".concat(key);
                }
                sbM1324q.append(key);
                sbM1324q.append('=');
                sbM1324q.append(entry.getValue());
                sbM1324q.append(SQLKeyword.COMMA);
            }
            sbM1324q.setLength(sbM1324q.length() - 2);
            sbM1324q.append('}');
            sbM1324q.append(")");
            return sbM1324q.toString();
        }

        @Override // io.netty.util.Mapping
        public V map(String str) {
            V v;
            if (str != null) {
                String strNormalize = normalize(str);
                V v4 = this.map.get(strNormalize);
                if (v4 != null) {
                    return v4;
                }
                int iIndexOf = strNormalize.indexOf(46);
                if (iIndexOf != -1 && (v = this.map.get(strNormalize.substring(iIndexOf))) != null) {
                    return v;
                }
            }
            return this.defaultValue;
        }
    }

    public DomainWildcardMappingBuilder(V v) {
        this(4, v);
    }

    private String normalizeHostName(String str) {
        ObjectUtil.checkNotNull(str, "hostname");
        if (str.isEmpty() || str.charAt(0) == '.') {
            throw new IllegalArgumentException(AbstractC0541b.m773o("Hostname '", str, "' not valid"));
        }
        String strNormalize = ImmutableDomainWildcardMapping.normalize((String) ObjectUtil.checkNotNull(str, "hostname"));
        if (strNormalize.charAt(0) != '*') {
            return strNormalize;
        }
        if (strNormalize.length() < 3 || strNormalize.charAt(1) != '.') {
            throw new IllegalArgumentException(AbstractC0541b.m773o("Wildcard Hostname '", strNormalize, "'not valid"));
        }
        return strNormalize.substring(1);
    }

    public DomainWildcardMappingBuilder<V> add(String str, V v) {
        this.map.put(normalizeHostName(str), (V) ObjectUtil.checkNotNull(v, "output"));
        return this;
    }

    public Mapping<String, V> build() {
        return new ImmutableDomainWildcardMapping(this.defaultValue, this.map);
    }

    public DomainWildcardMappingBuilder(int i, V v) {
        this.defaultValue = (V) ObjectUtil.checkNotNull(v, "defaultValue");
        this.map = new LinkedHashMap(i);
    }
}
