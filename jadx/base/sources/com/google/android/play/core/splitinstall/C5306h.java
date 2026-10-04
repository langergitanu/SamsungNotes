package com.google.android.play.core.splitinstall;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.h */
/* JADX INFO: loaded from: classes5.dex */
public final class C5306h {

    /* JADX INFO: renamed from: a */
    private final Map<String, Map<String, String>> f3125a;

    /* JADX INFO: renamed from: a */
    public final Map<String, Set<String>> m4137a(Collection<String> collection) {
        Set setUnmodifiableSet;
        HashMap map = new HashMap();
        for (String str : this.f3125a.keySet()) {
            if (this.f3125a.containsKey(str)) {
                HashSet hashSet = new HashSet();
                for (Map.Entry<String, String> entry : this.f3125a.get(str).entrySet()) {
                    if (collection.contains(entry.getKey())) {
                        hashSet.add(entry.getValue());
                    }
                }
                setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
            } else {
                setUnmodifiableSet = Collections.EMPTY_SET;
            }
            map.put(str, setUnmodifiableSet);
        }
        return map;
    }
}
