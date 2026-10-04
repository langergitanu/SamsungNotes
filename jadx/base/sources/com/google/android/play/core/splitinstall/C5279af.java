package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5199bu;
import com.google.android.play.core.tasks.C5345i;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.af */
/* JADX INFO: loaded from: classes5.dex */
final class C5279af extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ List f3082a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5345i f3083b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5295av f3084c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5279af(C5295av c5295av, C5345i c5345i, List list, C5345i c5345i2) {
        super(c5345i);
        this.f3084c = c5295av;
        this.f3082a = list;
        this.f3083b = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5199bu) this.f3084c.f3106a.m3898b()).mo3954b(this.f3084c.f3107d, C5295av.m4108a((Collection) this.f3082a), C5295av.m4109b(), new BinderC5290aq(this.f3084c, this.f3083b));
        } catch (RemoteException e) {
            C5295av.f3104b.m3876a(e, "deferredUninstall(%s)", this.f3082a);
            this.f3083b.m4200b((Exception) new RuntimeException(e));
        }
    }
}
