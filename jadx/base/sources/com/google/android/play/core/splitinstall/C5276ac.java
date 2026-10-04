package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.C5195bq;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.ac */
/* JADX INFO: loaded from: classes5.dex */
public final class C5276ac implements InterfaceC5219cn<SplitInstallManager> {

    /* JADX INFO: renamed from: a */
    private final C5335y f3075a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<C5307i> f3076b;

    public C5276ac(C5335y c5335y, InterfaceC5219cn<C5307i> interfaceC5219cn) {
        this.f3075a = c5335y;
        this.f3076b = interfaceC5219cn;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ SplitInstallManager mo3591a() {
        C5307i c5307iMo3591a = this.f3076b.mo3591a();
        C5195bq.m3949b(c5307iMo3591a);
        return c5307iMo3591a;
    }
}
