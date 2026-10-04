package com.google.android.play.core.assetpacks;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.play.core.internal.InterfaceC5215cj;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.dj */
/* JADX INFO: loaded from: classes5.dex */
final class C5107dj {

    /* JADX INFO: renamed from: a */
    private final C5045bb f2817a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5215cj<InterfaceC5141w> f2818b;

    /* JADX INFO: renamed from: c */
    private final C5086cp f2819c;

    /* JADX INFO: renamed from: d */
    private final InterfaceC5215cj<Executor> f2820d;

    /* JADX INFO: renamed from: e */
    private final C5069bz f2821e;

    public C5107dj(C5045bb c5045bb, InterfaceC5215cj<InterfaceC5141w> interfaceC5215cj, C5086cp c5086cp, InterfaceC5215cj<Executor> interfaceC5215cj2, C5069bz c5069bz) {
        this.f2817a = c5045bb;
        this.f2818b = interfaceC5215cj;
        this.f2819c = c5086cp;
        this.f2820d = interfaceC5215cj2;
        this.f2821e = c5069bz;
    }

    /* JADX INFO: renamed from: a */
    public final void m3799a(C5105dh c5105dh) {
        File fileM3703c = this.f2817a.m3703c(c5105dh.f2756k, c5105dh.f2814a, c5105dh.f2815b);
        File fileM3712e = this.f2817a.m3712e(c5105dh.f2756k, c5105dh.f2814a, c5105dh.f2815b);
        if (!fileM3703c.exists() || !fileM3712e.exists()) {
            throw new C5065bv(AbstractC0541b.m773o("Cannot find pack files to move for pack ", c5105dh.f2756k, Extension.DOT), c5105dh.f2755j);
        }
        File fileM3693a = this.f2817a.m3693a(c5105dh.f2756k, c5105dh.f2814a, c5105dh.f2815b);
        fileM3693a.mkdirs();
        if (!fileM3703c.renameTo(fileM3693a)) {
            throw new C5065bv("Cannot move merged pack files to final location.", c5105dh.f2755j);
        }
        new File(this.f2817a.m3693a(c5105dh.f2756k, c5105dh.f2814a, c5105dh.f2815b), "merge.tmp").delete();
        File fileM3700b = this.f2817a.m3700b(c5105dh.f2756k, c5105dh.f2814a, c5105dh.f2815b);
        fileM3700b.mkdirs();
        if (!fileM3712e.renameTo(fileM3700b)) {
            throw new C5065bv("Cannot move metadata files to final location.", c5105dh.f2755j);
        }
        Executor executorM3979a = this.f2820d.m3979a();
        C5045bb c5045bb = this.f2817a;
        c5045bb.getClass();
        executorM3979a.execute(RunnableC5106di.m3798a(c5045bb));
        this.f2819c.m3754a(c5105dh.f2756k, c5105dh.f2814a, c5105dh.f2815b);
        this.f2821e.m3741a(c5105dh.f2756k);
        this.f2818b.m3979a().mo3669a(c5105dh.f2755j, c5105dh.f2756k);
    }
}
