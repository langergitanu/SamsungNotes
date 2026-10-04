package com.google.android.play.core.assetpacks;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.bz */
/* JADX INFO: loaded from: classes5.dex */
final class C5069bz {

    /* JADX INFO: renamed from: a */
    private final Map<String, Double> f2708a = new HashMap();

    /* JADX INFO: renamed from: a */
    public final synchronized double m3740a(String str, C5088cr c5088cr) {
        double d;
        d = (((double) ((C5062bs) c5088cr).f2667e) + 1.0d) / ((double) ((C5062bs) c5088cr).f2668f);
        this.f2708a.put(str, Double.valueOf(d));
        return d;
    }

    /* JADX INFO: renamed from: b */
    public final synchronized double m3742b(String str) {
        Double d = this.f2708a.get(str);
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m3741a(String str) {
        this.f2708a.put(str, Double.valueOf(0.0d));
    }
}
