package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5199bu;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.al */
/* JADX INFO: loaded from: classes5.dex */
final class C5285al extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ int f3099a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5345i f3100b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5295av f3101c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5285al(C5295av c5295av, C5345i c5345i, int i, C5345i c5345i2) {
        super(c5345i);
        this.f3101c = c5295av;
        this.f3099a = i;
        this.f3100b = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5199bu) this.f3101c.f3106a.m3898b()).mo3950a(this.f3101c.f3107d, this.f3099a, C5295av.m4109b(), new BinderC5286am(this.f3101c, this.f3100b));
        } catch (RemoteException e) {
            C5295av.f3104b.m3876a(e, "cancelInstall(%d)", Integer.valueOf(this.f3099a));
            this.f3100b.m4200b((Exception) new RuntimeException(e));
        }
    }
}
