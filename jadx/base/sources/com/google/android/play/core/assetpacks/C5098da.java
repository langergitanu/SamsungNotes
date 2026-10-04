package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.C5217cl;
import com.google.android.play.core.internal.InterfaceC5219cn;
import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.da */
/* JADX INFO: loaded from: classes5.dex */
public final class C5098da implements InterfaceC5219cn<C5096cz> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<String> f2790a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5219cn<C5039aw> f2791b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5219cn<C5069bz> f2792c;

    /* JADX INFO: renamed from: d */
    private final InterfaceC5219cn<Context> f2793d;

    /* JADX INFO: renamed from: e */
    private final InterfaceC5219cn<C5109dl> f2794e;

    /* JADX INFO: renamed from: f */
    private final InterfaceC5219cn<Executor> f2795f;

    public C5098da(InterfaceC5219cn<String> interfaceC5219cn, InterfaceC5219cn<C5039aw> interfaceC5219cn2, InterfaceC5219cn<C5069bz> interfaceC5219cn3, InterfaceC5219cn<Context> interfaceC5219cn4, InterfaceC5219cn<C5109dl> interfaceC5219cn5, InterfaceC5219cn<Executor> interfaceC5219cn6) {
        this.f2790a = interfaceC5219cn;
        this.f2791b = interfaceC5219cn2;
        this.f2792c = interfaceC5219cn3;
        this.f2793d = interfaceC5219cn4;
        this.f2794e = interfaceC5219cn5;
        this.f2795f = interfaceC5219cn6;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ C5096cz mo3591a() {
        String strMo3591a = this.f2790a.mo3591a();
        C5039aw c5039awMo3591a = this.f2791b.mo3591a();
        C5069bz c5069bzMo3591a = this.f2792c.mo3591a();
        Context contextMo3591a = ((C5137s) this.f2793d).mo3591a();
        C5109dl c5109dlMo3591a = this.f2794e.mo3591a();
        return new C5096cz(strMo3591a != null ? new File(contextMo3591a.getExternalFilesDir(null), strMo3591a) : contextMo3591a.getExternalFilesDir(null), c5039awMo3591a, c5069bzMo3591a, contextMo3591a, c5109dlMo3591a, C5217cl.m3982b(this.f2795f));
    }
}
