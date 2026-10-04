package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9469n implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6891a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpellingCorrectionStreaming f6892b;

    public /* synthetic */ RunnableC9469n(SpellingCorrectionStreaming spellingCorrectionStreaming, int i) {
        this.f6891a = i;
        this.f6892b = spellingCorrectionStreaming;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6891a) {
            case 0:
                this.f6892b.lambda$initStreamingChar$3();
                break;
            default:
                this.f6892b.lambda$executeInternal$0();
                break;
        }
    }
}
