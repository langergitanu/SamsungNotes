package com.samsung.android.support.senl.p148nt.composer.main.cover;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.cover.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10935b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7333a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CoverCreator f7334b;

    public /* synthetic */ RunnableC10935b(CoverCreator coverCreator, int i) {
        this.f7333a = i;
        this.f7334b = coverCreator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7333a) {
            case 0:
                this.f7334b.lambda$generateDefaultCoverForNotEnoughContents$14();
                break;
            default:
                this.f7334b.requestCoverGenerate();
                break;
        }
    }
}
