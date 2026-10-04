package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5199bu;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.aj */
/* JADX INFO: loaded from: classes5.dex */
final class C5283aj extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ int f3094a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5345i f3095b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5295av f3096c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5283aj(C5295av c5295av, C5345i c5345i, int i, C5345i c5345i2) {
        super(c5345i);
        this.f3096c = c5295av;
        this.f3094a = i;
        this.f3095b = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5199bu) this.f3096c.f3106a.m3898b()).mo3951a(this.f3096c.f3107d, this.f3094a, new BinderC5291ar(this.f3096c, this.f3095b));
        } catch (RemoteException e) {
            C5295av.f3104b.m3876a(e, "getSessionState(%d)", Integer.valueOf(this.f3094a));
            this.f3095b.m4200b((Exception) new RuntimeException(e));
        }
    }
}
