package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.C5195bq;
import com.google.android.play.core.internal.C5217cl;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.r */
/* JADX INFO: loaded from: classes5.dex */
public final class C5136r implements InterfaceC5219cn<InterfaceC5141w> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<Context> f2907a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<C5034ar> f2908b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5219cn<C5096cz> f2909c;

    public C5136r(InterfaceC5219cn<Context> interfaceC5219cn, InterfaceC5219cn<C5034ar> interfaceC5219cn2, InterfaceC5219cn<C5096cz> interfaceC5219cn3) {
        this.f2907a = interfaceC5219cn;
        this.f2908b = interfaceC5219cn2;
        this.f2909c = interfaceC5219cn3;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ InterfaceC5141w mo3591a() {
        InterfaceC5141w interfaceC5141w = (InterfaceC5141w) (C5132n.m3846a(((C5137s) this.f2907a).mo3591a()) == null ? C5217cl.m3982b(this.f2908b).m3979a() : C5217cl.m3982b(this.f2909c).m3979a());
        C5195bq.m3949b(interfaceC5141w);
        return interfaceC5141w;
    }
}
