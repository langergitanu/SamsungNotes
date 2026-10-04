package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5235s;
import com.google.android.play.core.tasks.C5345i;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.ac */
/* JADX INFO: loaded from: classes5.dex */
final class C5019ac extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ List f2514a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5345i f2515b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5034ar f2516c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5019ac(C5034ar c5034ar, C5345i c5345i, List list, C5345i c5345i2) {
        super(c5345i);
        this.f2516c = c5034ar;
        this.f2514a = list;
        this.f2515b = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5235s) this.f2516c.f2563e.m3898b()).mo4022b(this.f2516c.f2561c, C5034ar.m3646a((Collection) this.f2514a), C5034ar.m3662e(), new BinderC5027ak(this.f2516c, this.f2515b, (byte[]) null));
        } catch (RemoteException e) {
            C5034ar.f2559a.m3876a(e, "cancelDownloads(%s)", this.f2514a);
        }
    }
}
