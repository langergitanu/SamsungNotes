package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.C5217cl;
import com.google.android.play.core.internal.InterfaceC5219cn;
import com.google.android.play.core.splitinstall.testing.C5330k;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.io.File;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.c */
/* JADX INFO: loaded from: classes5.dex */
public final class C5301c implements InterfaceC5311m {

    /* JADX INFO: renamed from: a */
    private InterfaceC5219cn<Context> f3114a;

    /* JADX INFO: renamed from: b */
    private InterfaceC5219cn<C5295av> f3115b;

    /* JADX INFO: renamed from: c */
    private InterfaceC5219cn<C5319t> f3116c;

    /* JADX INFO: renamed from: d */
    private InterfaceC5219cn<C5315p> f3117d;

    /* JADX INFO: renamed from: e */
    private InterfaceC5219cn<C5297ax> f3118e;

    /* JADX INFO: renamed from: f */
    private InterfaceC5219cn<C5333w> f3119f;

    /* JADX INFO: renamed from: g */
    private InterfaceC5219cn<File> f3120g;

    /* JADX INFO: renamed from: h */
    private InterfaceC5219cn<FakeSplitInstallManager> f3121h;

    /* JADX INFO: renamed from: i */
    private InterfaceC5219cn<C5307i> f3122i;

    /* JADX INFO: renamed from: j */
    private InterfaceC5219cn<SplitInstallManager> f3123j;

    public /* synthetic */ C5301c(C5335y c5335y) {
        C5336z c5336z = new C5336z(c5335y);
        this.f3114a = c5336z;
        this.f3115b = C5217cl.m3981a(new C5296aw(c5336z));
        this.f3116c = C5217cl.m3981a(new C5275ab(c5335y));
        this.f3117d = C5217cl.m3981a(C5316q.m4151a(this.f3114a));
        InterfaceC5219cn<C5297ax> interfaceC5219cnM3981a = C5217cl.m3981a(new C5298ay(this.f3114a));
        this.f3118e = interfaceC5219cnM3981a;
        this.f3119f = C5217cl.m3981a(new C5334x(this.f3115b, this.f3116c, this.f3117d, interfaceC5219cnM3981a));
        InterfaceC5219cn<File> interfaceC5219cnM3981a2 = C5217cl.m3981a(new C5274aa(this.f3114a));
        this.f3120g = interfaceC5219cnM3981a2;
        InterfaceC5219cn<FakeSplitInstallManager> interfaceC5219cnM3981a3 = C5217cl.m3981a(new C5330k(this.f3114a, interfaceC5219cnM3981a2, this.f3117d));
        this.f3121h = interfaceC5219cnM3981a3;
        InterfaceC5219cn<C5307i> interfaceC5219cnM3981a4 = C5217cl.m3981a(new C5308j(this.f3119f, interfaceC5219cnM3981a3, this.f3120g));
        this.f3122i = interfaceC5219cnM3981a4;
        this.f3123j = C5217cl.m3981a(new C5276ac(c5335y, interfaceC5219cnM3981a4));
    }

    @Override // com.google.android.play.core.splitinstall.InterfaceC5311m
    /* JADX INFO: renamed from: a */
    public final SplitInstallManager mo4129a() {
        return this.f3123j.mo3591a();
    }

    @Override // com.google.android.play.core.splitinstall.InterfaceC5311m
    /* JADX INFO: renamed from: b */
    public final File mo4130b() {
        return this.f3120g.mo3591a();
    }
}
