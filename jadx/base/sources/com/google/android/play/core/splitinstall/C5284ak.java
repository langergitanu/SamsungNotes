package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5199bu;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.ak */
/* JADX INFO: loaded from: classes5.dex */
final class C5284ak extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C5345i f3097a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5295av f3098b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5284ak(C5295av c5295av, C5345i c5345i, C5345i c5345i2) {
        super(c5345i);
        this.f3098b = c5295av;
        this.f3097a = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5199bu) this.f3098b.f3106a.m3898b()).mo3952a(this.f3098b.f3107d, new BinderC5292as(this.f3098b, this.f3097a));
        } catch (RemoteException e) {
            C5295av.f3104b.m3876a(e, "getSessionStates", new Object[0]);
            this.f3097a.m4200b((Exception) new RuntimeException(e));
        }
    }
}
