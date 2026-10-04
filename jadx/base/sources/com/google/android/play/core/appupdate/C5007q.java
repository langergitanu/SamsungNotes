package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.q */
/* JADX INFO: loaded from: classes5.dex */
public final class C5007q implements InterfaceC5219cn<C5006p> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<Context> f2454a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<C5008r> f2455b;

    public C5007q(InterfaceC5219cn<Context> interfaceC5219cn, InterfaceC5219cn<C5008r> interfaceC5219cn2) {
        this.f2454a = interfaceC5219cn;
        this.f2455b = interfaceC5219cn2;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5006p mo3591a() {
        return new C5006p(((C4999i) this.f2454a).mo3591a(), this.f2455b.mo3591a());
    }
}
