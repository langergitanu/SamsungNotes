package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.C5217cl;
import com.google.android.play.core.internal.InterfaceC5219cn;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.io.File;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.j */
/* JADX INFO: loaded from: classes5.dex */
public final class C5308j implements InterfaceC5219cn<C5307i> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<C5333w> f3129a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<FakeSplitInstallManager> f3130b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5219cn<File> f3131c;

    public C5308j(InterfaceC5219cn<C5333w> interfaceC5219cn, InterfaceC5219cn<FakeSplitInstallManager> interfaceC5219cn2, InterfaceC5219cn<File> interfaceC5219cn3) {
        this.f3129a = interfaceC5219cn;
        this.f3130b = interfaceC5219cn2;
        this.f3131c = interfaceC5219cn3;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5307i mo3591a() {
        return new C5307i(C5217cl.m3982b(this.f3129a), C5217cl.m3982b(this.f3130b), C5217cl.m3982b(this.f3131c));
    }
}
