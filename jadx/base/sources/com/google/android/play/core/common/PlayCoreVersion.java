package com.google.android.play.core.common;

import android.os.Bundle;
import com.google.android.play.core.internal.C5157af;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.text.lookup.StringLookupFactory;

/* JADX INFO: loaded from: classes5.dex */
public class PlayCoreVersion {

    /* JADX INFO: renamed from: a */
    private static final Set<String> f2917a = new HashSet(Arrays.asList("review"));

    /* JADX INFO: renamed from: b */
    private static final Set<String> f2918b = new HashSet(Arrays.asList("native", "unity"));

    /* JADX INFO: renamed from: c */
    private static final Map<String, Map<String, Integer>> f2919c = new HashMap();

    /* JADX INFO: renamed from: d */
    private static final C5157af f2920d = new C5157af("PlayCoreVersion");

    private PlayCoreVersion() {
    }

    /* JADX INFO: renamed from: a */
    public static Bundle m3855a() {
        Bundle bundle = new Bundle();
        Map<String, Integer> mapM3856a = m3856a("review");
        bundle.putInt("playcore_version_code", mapM3856a.get(StringLookupFactory.KEY_JAVA).intValue());
        if (mapM3856a.containsKey("native")) {
            bundle.putInt("playcore_native_version", mapM3856a.get("native").intValue());
        }
        if (mapM3856a.containsKey("unity")) {
            bundle.putInt("playcore_unity_version", mapM3856a.get("unity").intValue());
        }
        return bundle;
    }

    public static synchronized void addVersion(String str, String str2, int i) {
        if (!f2917a.contains(str)) {
            f2920d.m3879d("Illegal module name: %s", str);
        } else if (f2918b.contains(str2)) {
            m3856a(str).put(str2, Integer.valueOf(i));
        } else {
            f2920d.m3879d("Illegal platform name: %s", str2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static synchronized Map<String, Integer> m3856a(String str) {
        Map<String, Map<String, Integer>> map;
        try {
            map = f2919c;
            if (!map.containsKey(str)) {
                HashMap map2 = new HashMap();
                map2.put(StringLookupFactory.KEY_JAVA, 10800);
                map.put(str, map2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return map.get(str);
    }
}
