package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5199bu;
import com.google.android.play.core.tasks.C5345i;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.ai */
/* JADX INFO: loaded from: classes5.dex */
final class C5282ai extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ List f3091a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5345i f3092b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5295av f3093c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5282ai(C5295av c5295av, C5345i c5345i, List list, C5345i c5345i2) {
        super(c5345i);
        this.f3093c = c5295av;
        this.f3091a = list;
        this.f3092b = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5199bu) this.f3093c.f3106a.m3898b()).mo3957e(this.f3093c.f3107d, C5295av.m4110b((Collection) this.f3091a), C5295av.m4109b(), new BinderC5289ap(this.f3093c, this.f3092b));
        } catch (RemoteException e) {
            C5295av.f3104b.m3876a(e, "deferredLanguageUninstall(%s)", this.f3091a);
            this.f3092b.m4200b((Exception) new RuntimeException(e));
        }
    }
}
