package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.ay */
/* JADX INFO: loaded from: classes5.dex */
public final class C5298ay implements InterfaceC5219cn<C5297ax> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<Context> f3110a;

    public C5298ay(InterfaceC5219cn<Context> interfaceC5219cn) {
        this.f3110a = interfaceC5219cn;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5297ax mo3591a() {
        return new C5297ax(((C5336z) this.f3110a).mo3591a());
    }
}
