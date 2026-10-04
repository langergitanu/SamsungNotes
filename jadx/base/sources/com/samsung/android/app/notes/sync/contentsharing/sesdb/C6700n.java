package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import com.samsung.android.app.notes.sync.p135db.C6742k;
import java.util.HashMap;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sesdb.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6700n {

    /* JADX INFO: renamed from: b */
    public static C6700n f4020b;

    /* JADX INFO: renamed from: a */
    public HashMap f4021a;

    /* JADX INFO: renamed from: b */
    public static synchronized C6700n m4785b() {
        try {
            if (f4020b == null) {
                C6700n c6700n = new C6700n();
                c6700n.f4021a = new HashMap();
                f4020b = c6700n;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4020b;
    }

    /* JADX INFO: renamed from: a */
    public final C6742k m4786a(String str) {
        C6742k c6742k = new C6742k(str);
        if (c6742k.m4854k()) {
            this.f4021a.put(str, c6742k);
        }
        return c6742k;
    }
}
