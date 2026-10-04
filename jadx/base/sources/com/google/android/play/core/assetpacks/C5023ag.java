package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5235s;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.ag */
/* JADX INFO: loaded from: classes5.dex */
final class C5023ag extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ int f2531a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ String f2532b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5345i f2533c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ int f2534d;

    /* JADX INFO: renamed from: e */
    final /* synthetic */ C5034ar f2535e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5023ag(C5034ar c5034ar, C5345i c5345i, int i, String str, C5345i c5345i2, int i2) {
        super(c5345i);
        this.f2535e = c5034ar;
        this.f2531a = i;
        this.f2532b = str;
        this.f2533c = c5345i2;
        this.f2534d = i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5235s) this.f2535e.f2563e.m3898b()).mo4020b(this.f2535e.f2561c, C5034ar.m3657c(this.f2531a, this.f2532b), C5034ar.m3662e(), new BinderC5031ao(this.f2535e, this.f2533c, this.f2531a, this.f2532b, this.f2534d));
        } catch (RemoteException e) {
            C5034ar.f2559a.m3876a(e, "notifyModuleCompleted", new Object[0]);
        }
    }
}
