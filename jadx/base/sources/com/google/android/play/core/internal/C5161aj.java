package com.google.android.play.core.internal;

/* JADX INFO: renamed from: com.google.android.play.core.internal.aj */
/* JADX INFO: loaded from: classes5.dex */
final class C5161aj extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C5167ap f2938a;

    public C5161aj(C5167ap c5167ap) {
        this.f2938a = c5167ap;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        if (this.f2938a.f2954l != null) {
            this.f2938a.f2945c.m3878c("Unbind from service.", new Object[0]);
            this.f2938a.f2944b.unbindService(this.f2938a.f2953k);
            this.f2938a.f2948f = false;
            this.f2938a.f2954l = null;
            this.f2938a.f2953k = null;
        }
    }
}
