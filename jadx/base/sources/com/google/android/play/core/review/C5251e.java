package com.google.android.play.core.review;

import android.os.RemoteException;
import com.google.android.play.core.common.PlayCoreVersion;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5153ab;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.review.e */
/* JADX INFO: loaded from: classes5.dex */
final class C5251e extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C5345i f3016a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5254h f3017b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5251e(C5254h c5254h, C5345i c5345i, C5345i c5345i2) {
        super(c5345i);
        this.f3017b = c5254h;
        this.f3016a = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5153ab) this.f3017b.f3022a.m3898b()).mo3867a(this.f3017b.f3023c, PlayCoreVersion.m3855a(), new BinderC5253g(this.f3017b, this.f3016a));
        } catch (RemoteException e) {
            C5254h.f3021b.m3876a(e, "error requesting in-app review for %s", this.f3017b.f3023c);
            this.f3016a.m4200b((Exception) new RuntimeException(e));
        }
    }
}
