package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9415b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6851a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TranslationLanguageSelector f6852b;

    public /* synthetic */ RunnableC9415b(TranslationLanguageSelector translationLanguageSelector, int i) {
        this.f6851a = i;
        this.f6852b = translationLanguageSelector;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6851a) {
            case 0:
                this.f6852b.lambda$updateLanguage$5();
                break;
            case 1:
                this.f6852b.lambda$animateTranslationAutoDetecting$8();
                break;
            case 2:
                this.f6852b.lambda$showTranslationProgress$6();
                break;
            default:
                this.f6852b.lambda$hideTranslationProgress$7();
                break;
        }
    }
}
