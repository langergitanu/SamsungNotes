package org.apache.commons.text.lookup;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class InterpolatorStringLookup extends AbstractStringLookup {
    static final AbstractStringLookup INSTANCE = new InterpolatorStringLookup();
    private static final char PREFIX_SEPARATOR = ':';
    private final StringLookup defaultStringLookup;
    private final Map<String, StringLookup> stringLookupMap;

    public InterpolatorStringLookup() {
        this((Map) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$0(Map.Entry entry) {
        return StringLookupFactory.toKey((String) entry.getKey());
    }

    public Map<String, StringLookup> getStringLookupMap() {
        return this.stringLookupMap;
    }

    @Override // org.apache.commons.text.lookup.StringLookup
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(58);
        if (iIndexOf >= 0) {
            String key = StringLookupFactory.toKey(str.substring(0, iIndexOf));
            int i = iIndexOf + 1;
            String strSubstring = str.substring(i);
            StringLookup stringLookup = this.stringLookupMap.get(key);
            String strLookup = stringLookup != null ? stringLookup.lookup(strSubstring) : null;
            if (strLookup != null) {
                return strLookup;
            }
            str = str.substring(i);
        }
        StringLookup stringLookup2 = this.defaultStringLookup;
        if (stringLookup2 != null) {
            return stringLookup2.lookup(str);
        }
        return null;
    }

    public String toString() {
        return super.toString() + " [stringLookupMap=" + this.stringLookupMap + ", defaultStringLookup=" + this.defaultStringLookup + "]";
    }

    public InterpolatorStringLookup(Map<String, StringLookup> map, StringLookup stringLookup, boolean z) {
        this.defaultStringLookup = stringLookup;
        Map<String, StringLookup> map2 = (Map) map.entrySet().stream().collect(Collectors.toMap(new C13960e(0), new C13960e(2)));
        this.stringLookupMap = map2;
        if (z) {
            StringLookupFactory.INSTANCE.addDefaultStringLookups(map2);
        }
    }

    public <V> InterpolatorStringLookup(Map<String, V> map) {
        this(StringLookupFactory.INSTANCE.mapStringLookup(map));
    }

    public InterpolatorStringLookup(StringLookup stringLookup) {
        this(Collections.EMPTY_MAP, stringLookup, true);
    }
}
