package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C5217cl;
import com.google.android.play.core.internal.InterfaceC5219cn;
import com.google.android.play.core.splitinstall.C5315p;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.k */
/* JADX INFO: loaded from: classes5.dex */
public final class C5128k implements InterfaceC5219cn<C5127j> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<C5045bb> f2891a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<InterfaceC5141w> f2892b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5219cn<C5039aw> f2893c;

    /* JADX INFO: renamed from: d */
    private final InterfaceC5219cn<C5315p> f2894d;

    /* JADX INFO: renamed from: e */
    private final InterfaceC5219cn<C5086cp> f2895e;

    /* JADX INFO: renamed from: f */
    private final InterfaceC5219cn<C5069bz> f2896f;

    /* JADX INFO: renamed from: g */
    private final InterfaceC5219cn<C5057bn> f2897g;

    /* JADX INFO: renamed from: h */
    private final InterfaceC5219cn<Executor> f2898h;

    public C5128k(InterfaceC5219cn<C5045bb> interfaceC5219cn, InterfaceC5219cn<InterfaceC5141w> interfaceC5219cn2, InterfaceC5219cn<C5039aw> interfaceC5219cn3, InterfaceC5219cn<C5315p> interfaceC5219cn4, InterfaceC5219cn<C5086cp> interfaceC5219cn5, InterfaceC5219cn<C5069bz> interfaceC5219cn6, InterfaceC5219cn<C5057bn> interfaceC5219cn7, InterfaceC5219cn<Executor> interfaceC5219cn8) {
        this.f2891a = interfaceC5219cn;
        this.f2892b = interfaceC5219cn2;
        this.f2893c = interfaceC5219cn3;
        this.f2894d = interfaceC5219cn4;
        this.f2895e = interfaceC5219cn5;
        this.f2896f = interfaceC5219cn6;
        this.f2897g = interfaceC5219cn7;
        this.f2898h = interfaceC5219cn8;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5127j mo3591a() {
        return new C5127j(this.f2891a.mo3591a(), C5217cl.m3982b(this.f2892b), this.f2893c.mo3591a(), this.f2894d.mo3591a(), this.f2895e.mo3591a(), this.f2896f.mo3591a(), this.f2897g.mo3591a(), C5217cl.m3982b(this.f2898h));
    }
}
