package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5235s;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.aj */
/* JADX INFO: loaded from: classes5.dex */
final class C5026aj extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C5345i f2545a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5034ar f2546b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5026aj(C5034ar c5034ar, C5345i c5345i, C5345i c5345i2) {
        super(c5345i);
        this.f2546b = c5034ar;
        this.f2545a = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5235s) this.f2546b.f2564f.m3898b()).mo4021b(this.f2546b.f2561c, C5034ar.m3662e(), new BinderC5030an(this.f2546b, this.f2545a));
        } catch (RemoteException e) {
            C5034ar.f2559a.m3876a(e, "keepAlive", new Object[0]);
        }
    }
}
