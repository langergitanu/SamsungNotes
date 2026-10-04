package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C5217cl;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.bu */
/* JADX INFO: loaded from: classes5.dex */
public final class C5064bu implements InterfaceC5219cn<C5063bt> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<C5045bb> f2678a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<InterfaceC5141w> f2679b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5219cn<C5039aw> f2680c;

    /* JADX INFO: renamed from: d */
    private final InterfaceC5219cn<C5069bz> f2681d;

    public C5064bu(InterfaceC5219cn<C5045bb> interfaceC5219cn, InterfaceC5219cn<InterfaceC5141w> interfaceC5219cn2, InterfaceC5219cn<C5039aw> interfaceC5219cn3, InterfaceC5219cn<C5069bz> interfaceC5219cn4) {
        this.f2678a = interfaceC5219cn;
        this.f2679b = interfaceC5219cn2;
        this.f2680c = interfaceC5219cn3;
        this.f2681d = interfaceC5219cn4;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5063bt mo3591a() {
        return new C5063bt(this.f2678a.mo3591a(), C5217cl.m3982b(this.f2679b), C5217cl.m3982b(this.f2680c), this.f2681d.mo3591a());
    }
}
