package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9842a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7005a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ OptionMenuAddPresenter f7006b;

    public /* synthetic */ RunnableC9842a(OptionMenuAddPresenter optionMenuAddPresenter, int i) {
        this.f7005a = i;
        this.f7006b = optionMenuAddPresenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7005a) {
            case 0:
                this.f7006b.lambda$addCameraImage$1();
                break;
            case 1:
                this.f7006b.lambda$addPdf$4();
                break;
            case 2:
                this.f7006b.lambda$addPdf$5();
                break;
            default:
                this.f7006b.lambda$addImage$0();
                break;
        }
    }
}
