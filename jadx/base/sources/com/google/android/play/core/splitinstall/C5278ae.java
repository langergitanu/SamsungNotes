package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5199bu;
import com.google.android.play.core.tasks.C5345i;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.ae */
/* JADX INFO: loaded from: classes5.dex */
final class C5278ae extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Collection f3078a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ Collection f3079b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5345i f3080c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ C5295av f3081d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5278ae(C5295av c5295av, C5345i c5345i, Collection collection, Collection collection2, C5345i c5345i2) {
        super(c5345i);
        this.f3081d = c5295av;
        this.f3078a = collection;
        this.f3079b = collection2;
        this.f3080c = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        ArrayList arrayListM4108a = C5295av.m4108a(this.f3078a);
        arrayListM4108a.addAll(C5295av.m4110b(this.f3079b));
        try {
            ((InterfaceC5199bu) this.f3081d.f3106a.m3898b()).mo3953a(this.f3081d.f3107d, arrayListM4108a, C5295av.m4109b(), new BinderC5293at(this.f3081d, this.f3080c));
        } catch (RemoteException e) {
            C5295av.f3104b.m3876a(e, "startInstall(%s,%s)", this.f3078a, this.f3079b);
            this.f3080c.m4200b((Exception) new RuntimeException(e));
        }
    }
}
