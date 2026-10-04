package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.splitcompat.C5271p;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.w */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C5013w {

    /* JADX INFO: renamed from: a */
    private static C5015y f2490a;

    /* JADX INFO: renamed from: a */
    public static synchronized C5015y m3613a(Context context) {
        try {
            if (f2490a == null) {
                C5014x c5014x = new C5014x(null);
                c5014x.m3615a(new C4997g(C5271p.m4096a(context)));
                f2490a = c5014x.m3614a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2490a;
    }
}
