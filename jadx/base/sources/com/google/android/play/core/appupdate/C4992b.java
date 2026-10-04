package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.b */
/* JADX INFO: loaded from: classes5.dex */
public final class C4992b implements InterfaceC5219cn<C4991a> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<Context> f2423a;

    public C4992b(InterfaceC5219cn<Context> interfaceC5219cn) {
        this.f2423a = interfaceC5219cn;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C4991a mo3591a() {
        return new C4991a(((C4999i) this.f2423a).mo3591a());
    }
}
