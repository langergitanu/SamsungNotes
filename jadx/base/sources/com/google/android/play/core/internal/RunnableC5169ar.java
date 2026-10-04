package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.splitinstall.InterfaceC5302d;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.internal.ar */
/* JADX INFO: loaded from: classes5.dex */
final class RunnableC5169ar implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ List f2955a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ InterfaceC5302d f2956b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5170as f2957c;

    public RunnableC5169ar(C5170as c5170as, List list, InterfaceC5302d interfaceC5302d) {
        this.f2957c = c5170as;
        this.f2955a = list;
        this.f2956b = interfaceC5302d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f2957c.f2960c.m3907a(this.f2955a)) {
                C5170as.m3902a(this.f2957c, this.f2956b);
            } else {
                C5170as.m3903a(this.f2957c, this.f2955a, this.f2956b);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Error checking verified files.", e);
            this.f2956b.mo4132a(-11);
        }
    }
}
