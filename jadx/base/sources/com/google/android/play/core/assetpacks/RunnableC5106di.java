package com.google.android.play.core.assetpacks;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.di */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class RunnableC5106di implements Runnable {

    /* JADX INFO: renamed from: a */
    private final C5045bb f2816a;

    private RunnableC5106di(C5045bb c5045bb) {
        this.f2816a = c5045bb;
    }

    /* JADX INFO: renamed from: a */
    public static Runnable m3798a(C5045bb c5045bb) {
        return new RunnableC5106di(c5045bb);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2816a.m3706c();
    }
}
