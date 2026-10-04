package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.AbstractRunnableC5158ag;
import com.google.android.play.core.internal.InterfaceC5235s;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.af */
/* JADX INFO: loaded from: classes5.dex */
final class C5022af extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ int f2525a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ String f2526b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ String f2527c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ int f2528d;

    /* JADX INFO: renamed from: e */
    final /* synthetic */ C5345i f2529e;

    /* JADX INFO: renamed from: f */
    final /* synthetic */ C5034ar f2530f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5022af(C5034ar c5034ar, C5345i c5345i, int i, String str, String str2, int i2, C5345i c5345i2) {
        super(c5345i);
        this.f2530f = c5034ar;
        this.f2525a = i;
        this.f2526b = str;
        this.f2527c = str2;
        this.f2528d = i2;
        this.f2529e = c5345i2;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        try {
            ((InterfaceC5235s) this.f2530f.f2563e.m3898b()).mo4017a(this.f2530f.f2561c, C5034ar.m3658c(this.f2525a, this.f2526b, this.f2527c, this.f2528d), C5034ar.m3662e(), new BinderC5027ak(this.f2530f, this.f2529e, (char[]) null));
        } catch (RemoteException e) {
            C5034ar.f2559a.m3876a(e, "notifyChunkTransferred", new Object[0]);
        }
    }
}
