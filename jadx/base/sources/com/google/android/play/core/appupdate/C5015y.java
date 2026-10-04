package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.C5217cl;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.y */
/* JADX INFO: loaded from: classes5.dex */
public final class C5015y {

    /* JADX INFO: renamed from: a */
    private InterfaceC5219cn<Context> f2492a;

    /* JADX INFO: renamed from: b */
    private InterfaceC5219cn<C5008r> f2493b;

    /* JADX INFO: renamed from: c */
    private InterfaceC5219cn<C5006p> f2494c;

    /* JADX INFO: renamed from: d */
    private InterfaceC5219cn<C4991a> f2495d;

    /* JADX INFO: renamed from: e */
    private InterfaceC5219cn<C4995e> f2496e;

    /* JADX INFO: renamed from: f */
    private InterfaceC5219cn<AppUpdateManager> f2497f;

    public /* synthetic */ C5015y(C4997g c4997g) {
        C4999i c4999i = new C4999i(c4997g);
        this.f2492a = c4999i;
        InterfaceC5219cn<C5008r> interfaceC5219cnM3981a = C5217cl.m3981a(new C5009s(c4999i));
        this.f2493b = interfaceC5219cnM3981a;
        this.f2494c = C5217cl.m3981a(new C5007q(this.f2492a, interfaceC5219cnM3981a));
        InterfaceC5219cn<C4991a> interfaceC5219cnM3981a2 = C5217cl.m3981a(new C4992b(this.f2492a));
        this.f2495d = interfaceC5219cnM3981a2;
        InterfaceC5219cn<C4995e> interfaceC5219cnM3981a3 = C5217cl.m3981a(new C4996f(this.f2494c, interfaceC5219cnM3981a2, this.f2492a));
        this.f2496e = interfaceC5219cnM3981a3;
        this.f2497f = C5217cl.m3981a(new C4998h(interfaceC5219cnM3981a3));
    }

    /* JADX INFO: renamed from: a */
    public final AppUpdateManager m3616a() {
        return this.f2497f.mo3591a();
    }
}
