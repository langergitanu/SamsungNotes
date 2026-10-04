package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.f */
/* JADX INFO: loaded from: classes5.dex */
public final class C4996f implements InterfaceC5219cn<C4995e> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<C5006p> f2430a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<C4991a> f2431b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5219cn<Context> f2432c;

    public C4996f(InterfaceC5219cn<C5006p> interfaceC5219cn, InterfaceC5219cn<C4991a> interfaceC5219cn2, InterfaceC5219cn<Context> interfaceC5219cn3) {
        this.f2430a = interfaceC5219cn;
        this.f2431b = interfaceC5219cn2;
        this.f2432c = interfaceC5219cn3;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C4995e mo3591a() {
        return new C4995e(this.f2430a.mo3591a(), this.f2431b.mo3591a(), ((C4999i) this.f2432c).mo3591a());
    }
}
