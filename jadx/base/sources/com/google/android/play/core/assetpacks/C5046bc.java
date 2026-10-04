package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.bc */
/* JADX INFO: loaded from: classes5.dex */
public final class C5046bc implements InterfaceC5219cn<C5045bb> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<Context> f2604a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<C5109dl> f2605b;

    public C5046bc(InterfaceC5219cn<Context> interfaceC5219cn, InterfaceC5219cn<C5109dl> interfaceC5219cn2) {
        this.f2604a = interfaceC5219cn;
        this.f2605b = interfaceC5219cn2;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5045bb mo3591a() {
        return new C5045bb(((C5137s) this.f2604a).mo3591a(), this.f2605b.mo3591a());
    }
}
