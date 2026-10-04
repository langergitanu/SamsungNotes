package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C5217cl;
import com.google.android.play.core.internal.InterfaceC5219cn;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.dk */
/* JADX INFO: loaded from: classes5.dex */
public final class C5108dk implements InterfaceC5219cn<C5107dj> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<C5045bb> f2822a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<InterfaceC5141w> f2823b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5219cn<C5086cp> f2824c;

    /* JADX INFO: renamed from: d */
    private final InterfaceC5219cn<Executor> f2825d;

    /* JADX INFO: renamed from: e */
    private final InterfaceC5219cn<C5069bz> f2826e;

    public C5108dk(InterfaceC5219cn<C5045bb> interfaceC5219cn, InterfaceC5219cn<InterfaceC5141w> interfaceC5219cn2, InterfaceC5219cn<C5086cp> interfaceC5219cn3, InterfaceC5219cn<Executor> interfaceC5219cn4, InterfaceC5219cn<C5069bz> interfaceC5219cn5) {
        this.f2822a = interfaceC5219cn;
        this.f2823b = interfaceC5219cn2;
        this.f2824c = interfaceC5219cn3;
        this.f2825d = interfaceC5219cn4;
        this.f2826e = interfaceC5219cn5;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5107dj mo3591a() {
        C5045bb c5045bbMo3591a = this.f2822a.mo3591a();
        return new C5107dj(c5045bbMo3591a, C5217cl.m3982b(this.f2823b), this.f2824c.mo3591a(), C5217cl.m3982b(this.f2825d), this.f2826e.mo3591a());
    }
}
