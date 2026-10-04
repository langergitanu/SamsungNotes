package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C5217cl;
import com.google.android.play.core.internal.InterfaceC5219cn;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.cq */
/* JADX INFO: loaded from: classes5.dex */
public final class C5087cq implements InterfaceC5219cn<C5086cp> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<C5045bb> f2751a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<InterfaceC5141w> f2752b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5219cn<C5069bz> f2753c;

    /* JADX INFO: renamed from: d */
    private final InterfaceC5219cn<Executor> f2754d;

    public C5087cq(InterfaceC5219cn<C5045bb> interfaceC5219cn, InterfaceC5219cn<InterfaceC5141w> interfaceC5219cn2, InterfaceC5219cn<C5069bz> interfaceC5219cn3, InterfaceC5219cn<Executor> interfaceC5219cn4) {
        this.f2751a = interfaceC5219cn;
        this.f2752b = interfaceC5219cn2;
        this.f2753c = interfaceC5219cn3;
        this.f2754d = interfaceC5219cn4;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5086cp mo3591a() {
        C5045bb c5045bbMo3591a = this.f2751a.mo3591a();
        return new C5086cp(c5045bbMo3591a, C5217cl.m3982b(this.f2752b), this.f2753c.mo3591a(), C5217cl.m3982b(this.f2754d));
    }
}
