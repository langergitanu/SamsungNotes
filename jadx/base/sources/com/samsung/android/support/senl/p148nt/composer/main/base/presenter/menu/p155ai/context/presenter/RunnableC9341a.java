package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9341a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6805a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiContextMenuPresenter f6806b;

    public /* synthetic */ RunnableC9341a(AiContextMenuPresenter aiContextMenuPresenter, int i) {
        this.f6805a = i;
        this.f6806b = aiContextMenuPresenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6805a) {
            case 0:
                this.f6806b.lambda$executeSummarize$8();
                break;
            case 1:
                this.f6806b.lambda$executeMeeting$7();
                break;
            case 2:
                this.f6806b.lambda$executeTranslate$10();
                break;
            case 3:
                this.f6806b.lambda$executeNormal$6();
                break;
            case 4:
                this.f6806b.lambda$executeSpellingCorrection$9();
                break;
            case 5:
                this.f6806b.lambda$switchContents$11();
                break;
            case 6:
                this.f6806b.lambda$show$1();
                break;
            case 7:
                this.f6806b.selectMaximumContent();
                break;
            case 8:
                this.f6806b.lambda$postDirectAction$3();
                break;
            default:
                this.f6806b.lambda$postDirectAction$4();
                break;
        }
    }
}
