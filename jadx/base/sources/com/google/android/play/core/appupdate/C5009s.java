package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.s */
/* JADX INFO: loaded from: classes5.dex */
public final class C5009s implements InterfaceC5219cn<C5008r> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<Context> f2457a;

    public C5009s(InterfaceC5219cn<Context> interfaceC5219cn) {
        this.f2457a = interfaceC5219cn;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5008r mo3591a() {
        return new C5008r(((C4999i) this.f2457a).mo3591a());
    }
}
