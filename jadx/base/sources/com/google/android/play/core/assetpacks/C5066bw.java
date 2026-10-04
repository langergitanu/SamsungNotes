package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.InterfaceC5215cj;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.bw */
/* JADX INFO: loaded from: classes5.dex */
final class C5066bw {

    /* JADX INFO: renamed from: a */
    private static final C5157af f2683a = new C5157af("ExtractorLooper");

    /* JADX INFO: renamed from: b */
    private final C5086cp f2684b;

    /* JADX INFO: renamed from: c */
    private final C5063bt f2685c;

    /* JADX INFO: renamed from: d */
    private final C5119dv f2686d;

    /* JADX INFO: renamed from: e */
    private final C5103df f2687e;

    /* JADX INFO: renamed from: f */
    private final C5107dj f2688f;

    /* JADX INFO: renamed from: g */
    private final C5112do f2689g;

    /* JADX INFO: renamed from: h */
    private final InterfaceC5215cj<InterfaceC5141w> f2690h;

    /* JADX INFO: renamed from: i */
    private final C5089cs f2691i;

    /* JADX INFO: renamed from: j */
    private final AtomicBoolean f2692j = new AtomicBoolean(false);

    public C5066bw(C5086cp c5086cp, InterfaceC5215cj<InterfaceC5141w> interfaceC5215cj, C5063bt c5063bt, C5119dv c5119dv, C5103df c5103df, C5107dj c5107dj, C5112do c5112do, C5089cs c5089cs) {
        this.f2684b = c5086cp;
        this.f2690h = interfaceC5215cj;
        this.f2685c = c5063bt;
        this.f2686d = c5119dv;
        this.f2687e = c5103df;
        this.f2688f = c5107dj;
        this.f2689g = c5112do;
        this.f2691i = c5089cs;
    }

    /* JADX INFO: renamed from: a */
    public final void m3739a() {
        C5088cr c5088crM3769a;
        C5157af c5157af = f2683a;
        c5157af.m3875a("Run extractor loop", new Object[0]);
        if (!this.f2692j.compareAndSet(false, true)) {
            c5157af.m3879d("runLoop already looping; return", new Object[0]);
            return;
        }
        while (true) {
            try {
                c5088crM3769a = this.f2691i.m3769a();
            } catch (C5065bv e) {
                f2683a.m3877b("Error while getting next extraction task: %s", e.getMessage());
                if (e.f2682a >= 0) {
                    this.f2690h.m3979a().mo3668a(e.f2682a);
                    m3738a(e.f2682a, e);
                }
                c5088crM3769a = null;
            }
            if (c5088crM3769a == null) {
                this.f2692j.set(false);
                return;
            }
            try {
                if (c5088crM3769a instanceof C5062bs) {
                    this.f2685c.m3737a((C5062bs) c5088crM3769a);
                } else if (c5088crM3769a instanceof C5118du) {
                    this.f2686d.m3825a((C5118du) c5088crM3769a);
                } else if (c5088crM3769a instanceof C5102de) {
                    this.f2687e.m3797a((C5102de) c5088crM3769a);
                } else if (c5088crM3769a instanceof C5105dh) {
                    this.f2688f.m3799a((C5105dh) c5088crM3769a);
                } else if (c5088crM3769a instanceof C5111dn) {
                    this.f2689g.m3801a((C5111dn) c5088crM3769a);
                } else {
                    f2683a.m3877b("Unknown task type: %s", c5088crM3769a.getClass().getName());
                }
            } catch (Exception e2) {
                f2683a.m3877b("Error during extraction task: %s", e2.getMessage());
                this.f2690h.m3979a().mo3668a(c5088crM3769a.f2755j);
                m3738a(c5088crM3769a.f2755j, e2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m3738a(int i, Exception exc) {
        try {
            this.f2684b.m3766d(i);
            this.f2684b.m3753a(i);
        } catch (C5065bv unused) {
            f2683a.m3877b("Error during error handling: %s", exc.getMessage());
        }
    }
}
