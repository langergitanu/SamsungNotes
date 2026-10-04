package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5235s;
import com.google.android.play.core.tasks.C5345i;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.ad */
/* JADX INFO: loaded from: classes5.dex */
final class C5020ad extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Map f2517a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5345i f2518b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5034ar f2519c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5020ad(C5034ar c5034ar, C5345i c5345i, Map map, C5345i c5345i2) {
        super(c5345i);
        this.f2519c = c5034ar;
        this.f2517a = map;
        this.f2518b = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5235s) this.f2519c.f2563e.m3898b()).mo4018a(this.f2519c.f2561c, C5034ar.m3652b(this.f2517a), new BinderC5029am(this.f2519c, this.f2518b));
        } catch (RemoteException e) {
            C5034ar.f2559a.m3876a(e, "syncPacks", new Object[0]);
            this.f2518b.m4200b((Exception) new RuntimeException(e));
        }
    }
}
