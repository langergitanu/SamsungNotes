package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.common.C5146a;
import com.google.android.play.core.internal.C5217cl;
import com.google.android.play.core.internal.InterfaceC5219cn;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.ax */
/* JADX INFO: loaded from: classes5.dex */
public final class C5040ax implements InterfaceC5219cn<C5039aw> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<Context> f2584a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<C5086cp> f2585b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5219cn<C5066bw> f2586c;

    /* JADX INFO: renamed from: d */
    private final InterfaceC5219cn<InterfaceC5141w> f2587d;

    /* JADX INFO: renamed from: e */
    private final InterfaceC5219cn<C5069bz> f2588e;

    /* JADX INFO: renamed from: f */
    private final InterfaceC5219cn<C5057bn> f2589f;

    /* JADX INFO: renamed from: g */
    private final InterfaceC5219cn<C5146a> f2590g;

    /* JADX INFO: renamed from: h */
    private final InterfaceC5219cn<Executor> f2591h;

    /* JADX INFO: renamed from: i */
    private final InterfaceC5219cn<Executor> f2592i;

    public C5040ax(InterfaceC5219cn<Context> interfaceC5219cn, InterfaceC5219cn<C5086cp> interfaceC5219cn2, InterfaceC5219cn<C5066bw> interfaceC5219cn3, InterfaceC5219cn<InterfaceC5141w> interfaceC5219cn4, InterfaceC5219cn<C5069bz> interfaceC5219cn5, InterfaceC5219cn<C5057bn> interfaceC5219cn6, InterfaceC5219cn<C5146a> interfaceC5219cn7, InterfaceC5219cn<Executor> interfaceC5219cn8, InterfaceC5219cn<Executor> interfaceC5219cn9) {
        this.f2584a = interfaceC5219cn;
        this.f2585b = interfaceC5219cn2;
        this.f2586c = interfaceC5219cn3;
        this.f2587d = interfaceC5219cn4;
        this.f2588e = interfaceC5219cn5;
        this.f2589f = interfaceC5219cn6;
        this.f2590g = interfaceC5219cn7;
        this.f2591h = interfaceC5219cn8;
        this.f2592i = interfaceC5219cn9;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5039aw mo3591a() {
        return new C5039aw(((C5137s) this.f2584a).mo3591a(), this.f2585b.mo3591a(), this.f2586c.mo3591a(), C5217cl.m3982b(this.f2587d), this.f2588e.mo3591a(), this.f2589f.mo3591a(), this.f2590g.mo3591a(), C5217cl.m3982b(this.f2591h), C5217cl.m3982b(this.f2592i));
    }
}
