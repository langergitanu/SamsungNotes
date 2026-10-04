package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import java.util.Iterator;

/* JADX INFO: renamed from: com.google.android.play.core.internal.am */
/* JADX INFO: loaded from: classes5.dex */
final class C5164am extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ IBinder f2939a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ ServiceConnectionC5166ao f2940b;

    public C5164am(ServiceConnectionC5166ao serviceConnectionC5166ao, IBinder iBinder) {
        this.f2940b = serviceConnectionC5166ao;
        this.f2939a = iBinder;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        C5167ap c5167ap = this.f2940b.f2942a;
        c5167ap.f2954l = (IInterface) c5167ap.f2950h.mo3594a(this.f2939a);
        C5167ap.m3891f(this.f2940b.f2942a);
        this.f2940b.f2942a.f2948f = false;
        Iterator it = this.f2940b.f2942a.f2947e.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f2940b.f2942a.f2947e.clear();
    }
}
