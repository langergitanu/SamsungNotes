package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.ax */
/* JADX INFO: loaded from: classes5.dex */
final class C5297ax {

    /* JADX INFO: renamed from: a */
    private final Context f3109a;

    public C5297ax(@NonNull Context context) {
        this.f3109a = context;
    }

    /* JADX INFO: renamed from: b */
    private final SharedPreferences m4121b() {
        return this.f3109a.getSharedPreferences("playcore_split_install_internal", 0);
    }

    /* JADX INFO: renamed from: a */
    public final synchronized Set<String> m4122a() {
        Set<String> stringSet;
        try {
            stringSet = m4121b().getStringSet("deferred_uninstall_module_list", new HashSet());
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
        } catch (Exception unused) {
            return new HashSet();
        }
        return stringSet;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m4123a(Collection<String> collection) {
        Set<String> setM4122a = m4122a();
        Iterator<String> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= setM4122a.add(it.next());
        }
        if (zAdd) {
            try {
                m4121b().edit().putStringSet("deferred_uninstall_module_list", setM4122a).apply();
            } catch (Exception unused) {
            }
        }
    }
}
