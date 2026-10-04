package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5230n;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.k */
/* JADX INFO: loaded from: classes5.dex */
final class C5001k extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ String f2437a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5345i f2438b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5006p f2439c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5001k(C5006p c5006p, C5345i c5345i, String str, C5345i c5345i2) {
        super(c5345i);
        this.f2439c = c5006p;
        this.f2437a = str;
        this.f2438b = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5230n) this.f2439c.f2450a.m3898b()).mo4014a(this.f2439c.f2451d, C5006p.m3599a(this.f2439c, this.f2437a), new BinderC5005o(this.f2439c, this.f2438b, this.f2437a));
        } catch (RemoteException e) {
            C5006p.f2448b.m3876a(e, "requestUpdateInfo(%s)", this.f2437a);
            this.f2438b.m4200b((Exception) new RuntimeException(e));
        }
    }
}
