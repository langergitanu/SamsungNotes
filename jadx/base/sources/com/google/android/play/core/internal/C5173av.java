package com.google.android.play.core.internal;

import android.os.Build;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.io.File;

/* JADX INFO: renamed from: com.google.android.play.core.internal.av */
/* JADX INFO: loaded from: classes5.dex */
public final class C5173av {
    /* JADX INFO: renamed from: a */
    public static InterfaceC5172au m3910a() {
        int i = Build.VERSION.SDK_INT;
        return i != 26 ? (i == 27 && Build.VERSION.PREVIEW_SDK_INT == 0) ? new C5190bl() : new C5192bn() : new C5189bk();
    }

    /* JADX INFO: renamed from: a */
    public static String m3911a(File file) {
        if (file.getName().endsWith(".apk")) {
            return file.getName().replaceFirst("(_\\d+)?\\.apk", "").replace("base-", "config.").replace(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, ".config.").replace(".config.master", "").replace("config.master", "");
        }
        throw new IllegalArgumentException("Non-apk found in splits directory.");
    }

    /* JADX INFO: renamed from: a */
    public static <T> void m3912a(T t, Object obj) {
        if (t == null) {
            throw new NullPointerException((String) obj);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3913a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
