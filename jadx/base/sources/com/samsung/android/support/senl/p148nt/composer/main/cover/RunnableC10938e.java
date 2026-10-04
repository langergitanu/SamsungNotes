package com.samsung.android.support.senl.p148nt.composer.main.cover;

import com.samsung.android.support.senl.p148nt.composer.main.cover.CoverCreator;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.cover.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10938e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7338a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CoverCreator.C109209 f7339b;

    public /* synthetic */ RunnableC10938e(CoverCreator.C109209 c109209, int i) {
        this.f7338a = i;
        this.f7339b = c109209;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7338a) {
            case 0:
                this.f7339b.lambda$onStart$0();
                break;
            default:
                this.f7339b.lambda$onCompleted$1();
                break;
        }
    }
}
