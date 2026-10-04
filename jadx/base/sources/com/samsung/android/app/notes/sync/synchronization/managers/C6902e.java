package com.samsung.android.app.notes.sync.synchronization.managers;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.synchronization.managers.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6902e {

    /* JADX INFO: renamed from: b */
    public static C6902e f4470b;

    /* JADX INFO: renamed from: a */
    public boolean f4471a;

    /* JADX INFO: renamed from: a */
    public static synchronized C6902e m5116a() {
        try {
            if (f4470b == null) {
                C6902e c6902e = new C6902e();
                c6902e.f4471a = false;
                f4470b = c6902e;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4470b;
    }
}
