package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.as */
/* JADX INFO: loaded from: classes5.dex */
public final class C5035as implements InterfaceC5219cn<C5034ar> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<Context> f2566a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<C5069bz> f2567b;

    public C5035as(InterfaceC5219cn<Context> interfaceC5219cn, InterfaceC5219cn<C5069bz> interfaceC5219cn2) {
        this.f2566a = interfaceC5219cn;
        this.f2567b = interfaceC5219cn2;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5034ar mo3591a() {
        return new C5034ar(((C5137s) this.f2566a).mo3591a(), this.f2567b.mo3591a());
    }
}
