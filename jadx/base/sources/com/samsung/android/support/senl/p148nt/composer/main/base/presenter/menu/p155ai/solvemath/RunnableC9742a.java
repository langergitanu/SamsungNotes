package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.solvemath.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9742a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6988a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SolveMathPresenter f6989b;

    public /* synthetic */ RunnableC9742a(SolveMathPresenter solveMathPresenter, int i) {
        this.f6988a = i;
        this.f6989b = solveMathPresenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6988a) {
            case 0:
                this.f6989b.lambda$onShowRecognitionResult$0();
                break;
            default:
                this.f6989b.lambda$onHideRecognitionResult$1();
                break;
        }
    }
}
