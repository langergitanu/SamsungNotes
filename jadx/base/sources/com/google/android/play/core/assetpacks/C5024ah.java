package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5235s;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.ah */
/* JADX INFO: loaded from: classes5.dex */
final class C5024ah extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ int f2536a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5345i f2537b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5034ar f2538c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5024ah(C5034ar c5034ar, C5345i c5345i, int i, C5345i c5345i2) {
        super(c5345i);
        this.f2538c = c5034ar;
        this.f2536a = i;
        this.f2537b = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5235s) this.f2538c.f2563e.m3898b()).mo4023c(this.f2538c.f2561c, C5034ar.m3656c(this.f2536a), C5034ar.m3662e(), new BinderC5027ak(this.f2538c, this.f2537b, (int[]) null));
        } catch (RemoteException e) {
            C5034ar.f2559a.m3876a(e, "notifySessionFailed", new Object[0]);
        }
    }
}
