package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.y */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9739y implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6983a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiMenuResultViewSTT f6984b;

    public /* synthetic */ RunnableC9739y(AiMenuResultViewSTT aiMenuResultViewSTT, int i) {
        this.f6983a = i;
        this.f6984b = aiMenuResultViewSTT;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6983a) {
            case 0:
                this.f6984b.lambda$onVoiceInfoChanged$27();
                break;
            case 1:
                this.f6984b.lambda$onModeChanged$28();
                break;
            case 2:
                this.f6984b.lambda$onModeChanged$29();
                break;
            case 3:
                this.f6984b.lambda$onConverting$26();
                break;
            case 4:
                this.f6984b.lambda$onResume$30();
                break;
            case 5:
                this.f6984b.lambda$onResume$31();
                break;
            case 6:
                this.f6984b.lambda$initLanguage$7();
                break;
            case 7:
                this.f6984b.lambda$onOrientationChanged$36();
                break;
            case 8:
                this.f6984b.lambda$initPopUpWindow$18();
                break;
            default:
                this.f6984b.lambda$initPopUpWindow$19();
                break;
        }
    }
}
