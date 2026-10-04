package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.q */
/* JADX INFO: loaded from: classes5.dex */
public final class C5316q implements InterfaceC5219cn<C5315p> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<Context> f3141a;

    public C5316q(InterfaceC5219cn<Context> interfaceC5219cn) {
        this.f3141a = interfaceC5219cn;
    }

    /* JADX INFO: renamed from: a */
    public static C5316q m4151a(InterfaceC5219cn<Context> interfaceC5219cn) {
        return new C5316q(interfaceC5219cn);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5315p mo3591a() {
        return new C5315p(this.f3141a.mo3591a());
    }
}
