package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.splitcompat.C5271p;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.k */
/* JADX INFO: loaded from: classes5.dex */
public final class C5309k {

    /* JADX INFO: renamed from: a */
    private static InterfaceC5311m f3132a;

    private C5309k() {
    }

    /* JADX INFO: renamed from: a */
    public static synchronized InterfaceC5311m m4139a(Context context) {
        try {
            if (f3132a == null) {
                C5300b c5300b = new C5300b(null);
                c5300b.m4128a(new C5335y(C5271p.m4096a(context)));
                f3132a = c5300b.m4127a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3132a;
    }
}
