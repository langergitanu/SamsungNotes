package com.google.android.play.core.splitinstall;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.g */
/* JADX INFO: loaded from: classes5.dex */
public final class C5305g {

    /* JADX INFO: renamed from: a */
    private final Map<String, Map<String, String>> f3124a = new HashMap();

    /* JADX INFO: renamed from: a */
    public final C5306h m4135a() {
        HashMap map = new HashMap();
        for (Map.Entry<String, Map<String, String>> entry : this.f3124a.entrySet()) {
            map.put(entry.getKey(), Collections.unmodifiableMap(new HashMap(entry.getValue())));
        }
        return new C5306h(Collections.unmodifiableMap(map));
    }

    /* JADX INFO: renamed from: a */
    public final void m4136a(String str, String str2, String str3) {
        if (!this.f3124a.containsKey(str2)) {
            this.f3124a.put(str2, new HashMap());
        }
        this.f3124a.get(str2).put(str, str3);
    }
}
