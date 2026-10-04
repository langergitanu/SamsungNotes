package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.aw */
/* JADX INFO: loaded from: classes5.dex */
public final class C5296aw implements InterfaceC5219cn<C5295av> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<Context> f3108a;

    public C5296aw(InterfaceC5219cn<Context> interfaceC5219cn) {
        this.f3108a = interfaceC5219cn;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5295av mo3591a() {
        return new C5295av(((C5336z) this.f3108a).mo3591a());
    }
}
