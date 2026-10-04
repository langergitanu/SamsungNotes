package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5199bu;
import com.google.android.play.core.tasks.C5345i;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.ag */
/* JADX INFO: loaded from: classes5.dex */
final class C5280ag extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ List f3085a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5345i f3086b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5295av f3087c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5280ag(C5295av c5295av, C5345i c5345i, List list, C5345i c5345i2) {
        super(c5345i);
        this.f3087c = c5295av;
        this.f3085a = list;
        this.f3086b = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5199bu) this.f3087c.f3106a.m3898b()).mo3955c(this.f3087c.f3107d, C5295av.m4108a((Collection) this.f3085a), C5295av.m4109b(), new BinderC5287an(this.f3087c, this.f3086b));
        } catch (RemoteException e) {
            C5295av.f3104b.m3876a(e, "deferredInstall(%s)", this.f3085a);
            this.f3086b.m4200b((Exception) new RuntimeException(e));
        }
    }
}
