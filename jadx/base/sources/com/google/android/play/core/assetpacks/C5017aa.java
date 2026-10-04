package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5235s;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.aa */
/* JADX INFO: loaded from: classes5.dex */
final class C5017aa extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ String f2506a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5345i f2507b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5034ar f2508c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5017aa(C5034ar c5034ar, C5345i c5345i, String str, C5345i c5345i2) {
        super(c5345i);
        this.f2508c = c5034ar;
        this.f2506a = str;
        this.f2507b = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5235s) this.f2508c.f2563e.m3898b()).mo4026e(this.f2508c.f2561c, C5034ar.m3657c(0, this.f2506a), C5034ar.m3662e(), new BinderC5027ak(this.f2508c, this.f2507b, (short[]) null));
        } catch (RemoteException e) {
            C5034ar.f2559a.m3876a(e, "removePack(%s)", this.f2506a);
        }
    }
}
