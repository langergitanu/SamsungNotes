package com.fasterxml.jackson.core.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class InternCache extends LinkedHashMap<String, String> {
    private static final int MAX_ENTRIES = 100;
    public static final InternCache instance = new InternCache();

    private InternCache() {
        super(100, 0.8f, true);
    }

    public synchronized String intern(String str) {
        String strIntern;
        strIntern = get(str);
        if (strIntern == null) {
            strIntern = str.intern();
            put(strIntern, strIntern);
        }
        return strIntern;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, String> entry) {
        return size() > 100;
    }
}
