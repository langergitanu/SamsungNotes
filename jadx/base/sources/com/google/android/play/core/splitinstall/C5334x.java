package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.x */
/* JADX INFO: loaded from: classes5.dex */
public final class C5334x implements InterfaceC5219cn<C5333w> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<C5295av> f3211a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<C5319t> f3212b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5219cn<C5315p> f3213c;

    /* JADX INFO: renamed from: d */
    private final InterfaceC5219cn<C5297ax> f3214d;

    public C5334x(InterfaceC5219cn<C5295av> interfaceC5219cn, InterfaceC5219cn<C5319t> interfaceC5219cn2, InterfaceC5219cn<C5315p> interfaceC5219cn3, InterfaceC5219cn<C5297ax> interfaceC5219cn4) {
        this.f3211a = interfaceC5219cn;
        this.f3212b = interfaceC5219cn2;
        this.f3213c = interfaceC5219cn3;
        this.f3214d = interfaceC5219cn4;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5333w mo3591a() {
        return new C5333w(this.f3211a.mo3591a(), this.f3212b.mo3591a(), this.f3213c.mo3591a(), this.f3214d.mo3591a());
    }
}
