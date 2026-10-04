package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5230n;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.l */
/* JADX INFO: loaded from: classes5.dex */
final class C5002l extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C5345i f2440a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ String f2441b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5006p f2442c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5002l(C5006p c5006p, C5345i c5345i, C5345i c5345i2, String str) {
        super(c5345i);
        this.f2442c = c5006p;
        this.f2440a = c5345i2;
        this.f2441b = str;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5230n) this.f2442c.f2450a.m3898b()).mo4015b(this.f2442c.f2451d, C5006p.m3605d(), new BinderC5004n(this.f2442c, this.f2440a));
        } catch (RemoteException e) {
            C5006p.f2448b.m3876a(e, "completeUpdate(%s)", this.f2441b);
            this.f2440a.m4200b((Exception) new RuntimeException(e));
        }
    }
}
