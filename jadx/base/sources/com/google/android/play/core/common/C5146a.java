package com.google.android.play.core.common;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.play.core.common.a */
/* JADX INFO: loaded from: classes5.dex */
public final class C5146a {

    /* JADX INFO: renamed from: a */
    private final Map<String, Object> f2921a = new HashMap();

    /* JADX INFO: renamed from: a */
    public final synchronized void m3857a(Bundle bundle) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && this.f2921a.get(str) == null) {
                this.f2921a.put(str, obj);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final synchronized boolean m3858a() {
        Object obj = this.f2921a.get("usingExtractorStream");
        if (!(obj instanceof Boolean)) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }
}
