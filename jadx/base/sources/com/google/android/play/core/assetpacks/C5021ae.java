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

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.ae */
/* JADX INFO: loaded from: classes5.dex */
final class C5021ae extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ List f2520a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ Map f2521b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5345i f2522c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ InterfaceC5042az f2523d;

    /* JADX INFO: renamed from: e */
    final /* synthetic */ C5034ar f2524e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5021ae(C5034ar c5034ar, C5345i c5345i, List list, Map map, C5345i c5345i2, InterfaceC5042az interfaceC5042az) {
        super(c5345i);
        this.f2524e = c5034ar;
        this.f2520a = list;
        this.f2521b = map;
        this.f2522c = c5345i2;
        this.f2523d = interfaceC5042az;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        ArrayList arrayListM3646a = C5034ar.m3646a((Collection) this.f2520a);
        try {
            InterfaceC5235s interfaceC5235s = (InterfaceC5235s) this.f2524e.f2563e.m3898b();
            String str = this.f2524e.f2561c;
            Bundle bundleM3652b = C5034ar.m3652b(this.f2521b);
            C5034ar c5034ar = this.f2524e;
            interfaceC5235s.mo4024c(str, arrayListM3646a, bundleM3652b, new BinderC5032ap(c5034ar, this.f2522c, c5034ar.f2562d, this.f2523d));
        } catch (RemoteException e) {
            C5034ar.f2559a.m3876a(e, "getPackStates(%s)", this.f2520a);
            this.f2522c.m4200b((Exception) new RuntimeException(e));
        }
    }
}
