package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5235s;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.ai */
/* JADX INFO: loaded from: classes5.dex */
final class C5025ai extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ int f2539a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ String f2540b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ String f2541c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ int f2542d;

    /* JADX INFO: renamed from: e */
    final /* synthetic */ C5345i f2543e;

    /* JADX INFO: renamed from: f */
    final /* synthetic */ C5034ar f2544f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5025ai(C5034ar c5034ar, C5345i c5345i, int i, String str, String str2, int i2, C5345i c5345i2) {
        super(c5345i);
        this.f2544f = c5034ar;
        this.f2539a = i;
        this.f2540b = str;
        this.f2541c = str2;
        this.f2542d = i2;
        this.f2543e = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5235s) this.f2544f.f2563e.m3898b()).mo4025d(this.f2544f.f2561c, C5034ar.m3658c(this.f2539a, this.f2540b, this.f2541c, this.f2542d), C5034ar.m3662e(), new BinderC5028al(this.f2544f, this.f2543e));
        } catch (RemoteException e) {
            C5034ar.f2559a.m3877b("getChunkFileDescriptor(%s, %s, %d, session=%d)", this.f2540b, this.f2541c, Integer.valueOf(this.f2542d), Integer.valueOf(this.f2539a));
            this.f2543e.m4200b((Exception) new RuntimeException(e));
        }
    }
}
