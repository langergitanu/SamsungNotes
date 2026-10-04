package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5235s;
import com.google.android.play.core.tasks.C5345i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.ab */
/* JADX INFO: loaded from: classes5.dex */
final class C5018ab extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ List f2509a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ Map f2510b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5345i f2511c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ List f2512d;

    /* JADX INFO: renamed from: e */
    final /* synthetic */ C5034ar f2513e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5018ab(C5034ar c5034ar, C5345i c5345i, List list, Map map, C5345i c5345i2, List list2) {
        super(c5345i);
        this.f2513e = c5034ar;
        this.f2509a = list;
        this.f2510b = map;
        this.f2511c = c5345i2;
        this.f2512d = list2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        ArrayList arrayListM3646a = C5034ar.m3646a((Collection) this.f2509a);
        try {
            InterfaceC5235s interfaceC5235s = (InterfaceC5235s) this.f2513e.f2563e.m3898b();
            String str = this.f2513e.f2561c;
            Bundle bundleM3652b = C5034ar.m3652b(this.f2510b);
            C5034ar c5034ar = this.f2513e;
            interfaceC5235s.mo4019a(str, arrayListM3646a, bundleM3652b, new BinderC5033aq(c5034ar, this.f2511c, c5034ar.f2562d, this.f2512d));
        } catch (RemoteException e) {
            C5034ar.f2559a.m3876a(e, "startDownload(%s)", this.f2509a);
            this.f2511c.m4200b((Exception) new RuntimeException(e));
        }
    }
}
