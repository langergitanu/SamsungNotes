package com.google.android.play.core.splitinstall.testing;

import android.content.Context;
import com.google.android.play.core.internal.InterfaceC5219cn;
import com.google.android.play.core.splitinstall.C5315p;
import com.google.android.play.core.splitinstall.C5336z;
import java.io.File;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.testing.k */
/* JADX INFO: loaded from: classes5.dex */
public final class C5330k implements InterfaceC5219cn<FakeSplitInstallManager> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<Context> f3200a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<File> f3201b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5219cn<C5315p> f3202c;

    public C5330k(InterfaceC5219cn<Context> interfaceC5219cn, InterfaceC5219cn<File> interfaceC5219cn2, InterfaceC5219cn<C5315p> interfaceC5219cn3) {
        this.f3200a = interfaceC5219cn;
        this.f3201b = interfaceC5219cn2;
        this.f3202c = interfaceC5219cn3;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ FakeSplitInstallManager mo3591a() {
        return new FakeSplitInstallManager(((C5336z) this.f3200a).mo3591a(), this.f3201b.mo3591a(), this.f3202c.mo3591a());
    }
}
