package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.common.C5146a;
import com.google.android.play.core.common.C5148c;
import com.google.android.play.core.internal.C5216ck;
import com.google.android.play.core.internal.C5217cl;
import com.google.android.play.core.internal.InterfaceC5219cn;
import com.google.android.play.core.splitinstall.C5315p;
import com.google.android.play.core.splitinstall.C5316q;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.br */
/* JADX INFO: loaded from: classes5.dex */
public final class C5061br implements InterfaceC5016a {

    /* JADX INFO: renamed from: a */
    private final C5132n f2637a;

    /* JADX INFO: renamed from: b */
    private InterfaceC5219cn<Context> f2638b;

    /* JADX INFO: renamed from: c */
    private InterfaceC5219cn<C5109dl> f2639c;

    /* JADX INFO: renamed from: d */
    private InterfaceC5219cn<C5045bb> f2640d;

    /* JADX INFO: renamed from: e */
    private InterfaceC5219cn<C5069bz> f2641e;

    /* JADX INFO: renamed from: f */
    private InterfaceC5219cn<C5034ar> f2642f;

    /* JADX INFO: renamed from: g */
    private InterfaceC5219cn<String> f2643g;

    /* JADX INFO: renamed from: h */
    private InterfaceC5219cn<InterfaceC5141w> f2644h;

    /* JADX INFO: renamed from: i */
    private InterfaceC5219cn<Executor> f2645i;

    /* JADX INFO: renamed from: j */
    private InterfaceC5219cn<C5086cp> f2646j;

    /* JADX INFO: renamed from: k */
    private InterfaceC5219cn<C5039aw> f2647k;

    /* JADX INFO: renamed from: l */
    private InterfaceC5219cn<C5063bt> f2648l;

    /* JADX INFO: renamed from: m */
    private InterfaceC5219cn<C5119dv> f2649m;

    /* JADX INFO: renamed from: n */
    private InterfaceC5219cn<C5103df> f2650n;

    /* JADX INFO: renamed from: o */
    private InterfaceC5219cn<C5107dj> f2651o;

    /* JADX INFO: renamed from: p */
    private InterfaceC5219cn<C5146a> f2652p;

    /* JADX INFO: renamed from: q */
    private InterfaceC5219cn<C5112do> f2653q;

    /* JADX INFO: renamed from: r */
    private InterfaceC5219cn<C5054bk> f2654r;

    /* JADX INFO: renamed from: s */
    private InterfaceC5219cn<C5089cs> f2655s;

    /* JADX INFO: renamed from: t */
    private InterfaceC5219cn<C5066bw> f2656t;

    /* JADX INFO: renamed from: u */
    private InterfaceC5219cn<C5057bn> f2657u;

    /* JADX INFO: renamed from: v */
    private InterfaceC5219cn<Executor> f2658v;

    /* JADX INFO: renamed from: w */
    private InterfaceC5219cn<C5096cz> f2659w;

    /* JADX INFO: renamed from: x */
    private InterfaceC5219cn<C5315p> f2660x;

    /* JADX INFO: renamed from: y */
    private InterfaceC5219cn<C5127j> f2661y;

    /* JADX INFO: renamed from: z */
    private InterfaceC5219cn<AssetPackManager> f2662z;

    public /* synthetic */ C5061br(C5132n c5132n) {
        this.f2637a = c5132n;
        C5137s c5137s = new C5137s(c5132n);
        this.f2638b = c5137s;
        InterfaceC5219cn<C5109dl> interfaceC5219cnM3981a = C5217cl.m3981a(new C5110dm(c5137s));
        this.f2639c = interfaceC5219cnM3981a;
        this.f2640d = C5217cl.m3981a(new C5046bc(this.f2638b, interfaceC5219cnM3981a));
        InterfaceC5219cn<C5069bz> interfaceC5219cnM3981a2 = C5217cl.m3981a(C5071ca.f2710a);
        this.f2641e = interfaceC5219cnM3981a2;
        this.f2642f = C5217cl.m3981a(new C5035as(this.f2638b, interfaceC5219cnM3981a2));
        this.f2643g = C5217cl.m3981a(new C5138t(this.f2638b));
        this.f2644h = new C5216ck();
        InterfaceC5219cn<Executor> interfaceC5219cnM3981a3 = C5217cl.m3981a(C5133o.f2904a);
        this.f2645i = interfaceC5219cnM3981a3;
        this.f2646j = C5217cl.m3981a(new C5087cq(this.f2640d, this.f2644h, this.f2641e, interfaceC5219cnM3981a3));
        C5216ck c5216ck = new C5216ck();
        this.f2647k = c5216ck;
        this.f2648l = C5217cl.m3981a(new C5064bu(this.f2640d, this.f2644h, c5216ck, this.f2641e));
        this.f2649m = C5217cl.m3981a(new C5120dw(this.f2640d));
        this.f2650n = C5217cl.m3981a(new C5104dg(this.f2640d));
        this.f2651o = C5217cl.m3981a(new C5108dk(this.f2640d, this.f2644h, this.f2646j, this.f2645i, this.f2641e));
        InterfaceC5219cn<C5146a> interfaceC5219cnM3981a4 = C5217cl.m3981a(C5148c.m3860b());
        this.f2652p = interfaceC5219cnM3981a4;
        this.f2653q = C5217cl.m3981a(new C5113dp(this.f2640d, this.f2644h, interfaceC5219cnM3981a4));
        InterfaceC5219cn<C5054bk> interfaceC5219cnM3981a5 = C5217cl.m3981a(new C5055bl(this.f2644h));
        this.f2654r = interfaceC5219cnM3981a5;
        InterfaceC5219cn<C5089cs> interfaceC5219cnM3981a6 = C5217cl.m3981a(new C5090ct(this.f2646j, this.f2640d, interfaceC5219cnM3981a5));
        this.f2655s = interfaceC5219cnM3981a6;
        this.f2656t = C5217cl.m3981a(new C5067bx(this.f2646j, this.f2644h, this.f2648l, this.f2649m, this.f2650n, this.f2651o, this.f2653q, interfaceC5219cnM3981a6));
        this.f2657u = C5217cl.m3981a(C5058bo.f2635a);
        InterfaceC5219cn<Executor> interfaceC5219cnM3981a7 = C5217cl.m3981a(C5139u.f2912a);
        this.f2658v = interfaceC5219cnM3981a7;
        C5216ck.m3980a(this.f2647k, C5217cl.m3981a(new C5040ax(this.f2638b, this.f2646j, this.f2656t, this.f2644h, this.f2641e, this.f2657u, this.f2652p, this.f2645i, interfaceC5219cnM3981a7)));
        InterfaceC5219cn<C5096cz> interfaceC5219cnM3981a8 = C5217cl.m3981a(new C5098da(this.f2643g, this.f2647k, this.f2641e, this.f2638b, this.f2639c, this.f2645i));
        this.f2659w = interfaceC5219cnM3981a8;
        C5216ck.m3980a(this.f2644h, C5217cl.m3981a(new C5136r(this.f2638b, this.f2642f, interfaceC5219cnM3981a8)));
        InterfaceC5219cn<C5315p> interfaceC5219cnM3981a9 = C5217cl.m3981a(C5316q.m4151a(this.f2638b));
        this.f2660x = interfaceC5219cnM3981a9;
        InterfaceC5219cn<C5127j> interfaceC5219cnM3981a10 = C5217cl.m3981a(new C5128k(this.f2640d, this.f2644h, this.f2647k, interfaceC5219cnM3981a9, this.f2646j, this.f2641e, this.f2657u, this.f2645i));
        this.f2661y = interfaceC5219cnM3981a10;
        this.f2662z = C5217cl.m3981a(new C5135q(interfaceC5219cnM3981a10, this.f2638b));
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5016a
    /* JADX INFO: renamed from: a */
    public final AssetPackManager mo3630a() {
        return this.f2662z.mo3591a();
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5016a
    /* JADX INFO: renamed from: a */
    public final void mo3631a(AssetPackExtractionService assetPackExtractionService) {
        assetPackExtractionService.f2499a = C5137s.m3850a(this.f2637a);
        assetPackExtractionService.f2500b = this.f2661y.mo3591a();
        assetPackExtractionService.f2501c = this.f2640d.mo3591a();
    }
}
