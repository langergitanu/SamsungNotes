package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9719o implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6966a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiMenuResultViewRecognizedHw f6967b;

    public /* synthetic */ RunnableC9719o(AiMenuResultViewRecognizedHw aiMenuResultViewRecognizedHw, int i) {
        this.f6966a = i;
        this.f6967b = aiMenuResultViewRecognizedHw;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6966a) {
            case 0:
                this.f6967b.lambda$executeTranslate$13();
                break;
            case 1:
                this.f6967b.lambda$executeSummarize$11();
                break;
            case 2:
                this.f6967b.lambda$setNormalModeState$8();
                break;
            default:
                this.f6967b.lambda$onCompleted$14();
                break;
        }
    }
}
