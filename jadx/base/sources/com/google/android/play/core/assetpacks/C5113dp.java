package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.C5146a;
import com.google.android.play.core.internal.C5217cl;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.dp */
/* JADX INFO: loaded from: classes5.dex */
public final class C5113dp implements InterfaceC5219cn<C5112do> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<C5045bb> f2843a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<InterfaceC5141w> f2844b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5219cn<C5146a> f2845c;

    public C5113dp(InterfaceC5219cn<C5045bb> interfaceC5219cn, InterfaceC5219cn<InterfaceC5141w> interfaceC5219cn2, InterfaceC5219cn<C5146a> interfaceC5219cn3) {
        this.f2843a = interfaceC5219cn;
        this.f2844b = interfaceC5219cn2;
        this.f2845c = interfaceC5219cn3;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5112do mo3591a() {
        return new C5112do(this.f2843a.mo3591a(), C5217cl.m3982b(this.f2844b), this.f2845c.mo3591a());
    }
}
