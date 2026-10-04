package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.ct */
/* JADX INFO: loaded from: classes5.dex */
public final class C5090ct implements InterfaceC5219cn<C5089cs> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<C5086cp> f2761a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<C5045bb> f2762b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5219cn<C5054bk> f2763c;

    public C5090ct(InterfaceC5219cn<C5086cp> interfaceC5219cn, InterfaceC5219cn<C5045bb> interfaceC5219cn2, InterfaceC5219cn<C5054bk> interfaceC5219cn3) {
        this.f2761a = interfaceC5219cn;
        this.f2762b = interfaceC5219cn2;
        this.f2763c = interfaceC5219cn3;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5089cs mo3591a() {
        return new C5089cs(this.f2761a.mo3591a(), this.f2762b.mo3591a(), this.f2763c.mo3591a());
    }
}
